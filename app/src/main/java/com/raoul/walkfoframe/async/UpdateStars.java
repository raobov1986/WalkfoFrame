package com.raoul.walkfoframe.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.raoul.walkfoframe.model.WOFStars;
import com.raoul.walkfoframe.web.DynamoDBManager;
import com.raoul.walkfoframe.utils.AppPreferences;
import com.raoul.walkfoframe.utils.ConnectionDetector;
import com.raoul.walkfoframe.tablemanager.StarsManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class UpdateStars  extends AsyncTask<Void, Void, List<WOFStars>> {
	
	private Context context;
	private int notificationId;
	private ProgressDialog dialog;
	
	public UpdateStars(Context context) {
		this.context = context;
		this.notificationId = Math.abs((new Random()).nextInt());
	}
	
	protected void onPreExecute() {
		super.onPreExecute();
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		/*NotificationCompat.Builder mBuilder =
	        new NotificationCompat.Builder(this.context)
	        .setSmallIcon(R.drawable.ic_launcher)
	        .setContentTitle("Updating")
	        .setContentText("Updating stars")
	        .setOngoing(true);
		NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(this.notificationId, mBuilder.build());*/
		dialog = new ProgressDialog(context);
		dialog.setCancelable(false);
		dialog.setMessage("Updating stars");
		dialog.show();
	}

	@Override
	protected List<WOFStars> doInBackground(Void... params) {
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//List<WOFStars> l = DynamoDBManager.GetWofStars(AppPreferences.getStarsTimestamp(context));
		List<WOFStars> l = DynamoDBManager.GetWofStars(new Date(0));
		StarsManager manager = new StarsManager();
		
		Log.e("Count", "Stars before: " + manager.getStarsnData(context).size() );
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//manager.updateStars(context, l);
		manager.deleteStarDataData(context);
		manager.inserStarsData(context, l);
		if (l != null) {
			Log.e("Updated stars", l.size() + "");
		}
		return l;
	}

	@Override
	protected void onPostExecute(List<WOFStars> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result != null && result.size() > 0) {
			AppPreferences.starIsSaved(this.context, true);
			AppPreferences.saveStarsTimestamp(context, new Date());
		}
		
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		/*NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancel(this.notificationId);*/
		if (this.dialog != null) {
			this.dialog.dismiss();
			this.dialog = null;
		}
		
		if (ConnectionDetector.isConnectingToInternet(context)) {
			new UpdateHonoreesAndStars(context).execute();
		}
		
		this.context = null;

	}
}