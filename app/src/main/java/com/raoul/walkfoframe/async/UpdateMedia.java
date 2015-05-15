package com.raoul.walkfoframe.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.raoul.walkfoframe.model.WOFMedia;
import com.raoul.walkfoframe.web.DynamoDBManager;
import com.raoul.walkfoframe.utils.AppPreferences;
import com.raoul.walkfoframe.utils.ConnectionDetector;
import com.raoul.walkfoframe.tablemanager.MediaManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class UpdateMedia extends AsyncTask<Void, Void, List<WOFMedia>> {
	private Context context;
	private int notificationId;
	private ProgressDialog dialog;
	
	public UpdateMedia(Context context) {
		this.context = context;
		this.notificationId = Math.abs((new Random()).nextInt());
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		/*NotificationCompat.Builder mBuilder =
		        new NotificationCompat.Builder(this.context)
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentTitle("Updating")
		        .setContentText("Updating media")
		        .setOngoing(true);
			NotificationManager mNotificationManager =
				    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
			mNotificationManager.notify(this.notificationId, mBuilder.build());*/
		dialog = new ProgressDialog(context);
		dialog.setCancelable(false);
		dialog.setMessage("Updating media");
		dialog.show();
	}

	@Override
	protected List<WOFMedia> doInBackground(Void... params) {
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//List<WOFMedia> l = DynamoDBManager.GetWofMedia(AppPreferences.getMediaTimestamp(context));
		List<WOFMedia> l = DynamoDBManager.GetWofMedia(new Date(0));
		MediaManager manager = new MediaManager();
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//manager.updateMedia(context, l);
		manager.deleteMediaData(context);
		manager.inserMediasData(context, l);
		if (l != null) {
			Log.e("Updated media", l.size() + "");
		}
		
		return l;
	}

	@Override
	protected void onPostExecute(List<WOFMedia> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result != null && result.size() > 0) {
			AppPreferences.MEDIAIsSaved(this.context, true);
			AppPreferences.saveMediaTimestamp(context, new Date());
		}
		
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		/*
		NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancel(this.notificationId);
		*/
		
		if (this.dialog != null) {
			this.dialog.dismiss();
			this.dialog = null;
		}
		
		if (ConnectionDetector.isConnectingToInternet(this.context)) {
			new UpdateQuizes(this.context).execute();
		}
		
		this.context = null;

	}
}