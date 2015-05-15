package com.raoul.walkfoframe.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.raoul.walkfoframe.model.Wofhonorees;
import com.raoul.walkfoframe.web.DynamoDBManager;
import com.raoul.walkfoframe.utils.AppPreferences;
import com.raoul.walkfoframe.utils.ConnectionDetector;
import com.raoul.walkfoframe.tablemanager.WofHonreesManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class UpdateHonorees  extends AsyncTask<Void, Void, List<Wofhonorees>> {
	
	private Context context;
	private int notificationId;
	private ProgressDialog dialog;
	
	public UpdateHonorees(Context context) {
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
	        .setContentText("Updating honorees")
	        .setOngoing(true);
		NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(this.notificationId, mBuilder.build());*/
		dialog = new ProgressDialog(context);
		dialog.setCancelable(false);
		dialog.setMessage("Updating honorees");
		dialog.show();
	}

	@Override
	protected List<Wofhonorees> doInBackground(Void... params) {
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//List<Wofhonorees> l = DynamoDBManager.getWOFhonorees(AppPreferences.getHonoreesTimestamp(context));
		List<Wofhonorees> l = DynamoDBManager.getWOFhonorees(new Date(0));
		WofHonreesManager manager = new WofHonreesManager();
		
		Log.e("Honorees before", manager.getAllWofHonoreest(context).size()+"");
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//manager.updateHonorees(context, l);
		manager.deletStudentData(context);
		manager.insertstudentData(context, l);
		
		if (l != null) {
			Log.e("Updated honorees", l.size() + "");
		}
		return l;
	}

	@Override
	protected void onPostExecute(List<Wofhonorees> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result != null && result.size() > 0) {
			AppPreferences.honoreesIsSaved(context, true);
			AppPreferences.saveHonoreesTimestamp(context, new Date());
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
		
		if (ConnectionDetector.isConnectingToInternet(context)) {
			new UpdateStars(this.context).execute();
		}
		
		this.context = null;

	}
}