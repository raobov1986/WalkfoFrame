package com.raoul.walkfoframe.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.raoul.walkfoframe.HomeActivity;
import com.raoul.walkfoframe.R;
import com.raoul.walkfoframe.model.WOFPushNotification;
import com.raoul.walkfoframe.web.DynamoDBManager;
import com.raoul.walkfoframe.utils.AppPreferences;
import com.raoul.walkfoframe.utils.ConnectionDetector;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

public class PushNotificationService extends Service {

	Context context;
	Handler handler;
	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
		  this.context = this;
		  
		  new GetPushNotifications().execute();
		  handler = new Handler();
		  handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				startService(new Intent(PushNotificationService.this, PushNotificationService.class));
			}
		}, 15*60*1000);
		  
		  return Service.START_STICKY;
	  }

	  @Override
	  public IBinder onBind(Intent arg0) {
		  return null;
	  }
	  
	  @Override
	  public void onDestroy() {
		  if (this.handler != null) {
			  this.handler.removeCallbacksAndMessages(null);
			  this.handler = null;
		  }
		  
		  this.context = null;
		  super.onDestroy();
	  }
	  
	  private void createNotification(final Context context, final WOFPushNotification notification) {
		  Runnable runnable = new Runnable() {
			  @Override
			  public void run() {
				  PushNotificationService.notify(context, notification);
				  AppPreferences.saveLastNotificationId(PushNotificationService.this.getApplicationContext(), notification.getId());
			  }
		  };
			
		  Handler handler = new Handler();
		  handler.postDelayed(runnable, 0);
	  }
	  
	  public static void notify(Context context, WOFPushNotification notification) {
			final NotificationManager mNotificationManager =
			  	    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		  	
			Intent resultIntent = new Intent(context, HomeActivity.class);
			final PendingIntent contentIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			 
			NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle(notification.getTitle())
				.setContentText(notification.getMessage())
				.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
				.setTicker(notification.getMessage())
				.setWhen((new Date()).getTime())
				.setAutoCancel(true)
				.setContentIntent(contentIntent);
			
			 mNotificationManager.notify(notification.getId(), notificationBuilder.build());
		}
	  
	  private class GetPushNotifications extends AsyncTask<Void, Void, List<WOFPushNotification>> {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
			}

			@Override
			protected List<WOFPushNotification> doInBackground(Void... params) {
				List<WOFPushNotification> notifications = null;
				try {
					if (ConnectionDetector.isConnectingToInternet(context)) {
						notifications = DynamoDBManager.getWofPushNotifications(AppPreferences.getLastNotificationId(context.getApplicationContext()));
					}
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				
				return notifications;
			}

			@Override
			protected void onPostExecute(List<WOFPushNotification> notifications) {
				// TODO Auto-generated method stub
				super.onPostExecute(notifications);
				if (notifications != null && notifications.size() > 0) {
					WOFPushNotification notification = null;
					for (WOFPushNotification notif : notifications) {
						if (notification == null) {
							notification = notif;
						} else if (notif.getId() > notification.getId()) {
							notification = notif;
						}
					}
					
					createNotification(context, notification);
				}
			}
		}
}