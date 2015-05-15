package com.raoul.walkfoframe.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.raoul.walkfoframe.model.Quizzes;
import com.raoul.walkfoframe.web.DynamoDBManager;
import com.raoul.walkfoframe.utils.AppPreferences;
import com.raoul.walkfoframe.tablemanager.QuizeManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class UpdateQuizes extends AsyncTask<Void, Void, List<Quizzes>> {
	
	private Context context;
	private int notificationId;
	private ProgressDialog dialog;
	
	public UpdateQuizes(Context context) {
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
	        .setContentText("Updating quizes")
	        .setOngoing(true);
		NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(this.notificationId, mBuilder.build());*/
		dialog = new ProgressDialog(context);
		dialog.setCancelable(false);
		dialog.setMessage("Updating quiz");
		dialog.show();
	}

	@Override
	protected List<Quizzes> doInBackground(Void... params) {
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//List<Quizzes> l = DynamoDBManager.GetWofQuize(AppPreferences.getQuizesTimestamp(context));
		List<Quizzes> l = DynamoDBManager.GetWofQuize(new Date(0));
		QuizeManager manager = new QuizeManager();
		Log.e("Count", "Quizes before: " + manager.getAllquizData(context).size() );
		
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//manager.updateQuizData(context, l);
		
		manager.deleteQuizsData(context);
		manager.inserQuizeData(context, l);
		if (l != null) {
			Log.e("Updated quizes", l.size() + "");
		}
		return l;
	}

	@Override
	protected void onPostExecute(List<Quizzes> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result != null && result.size() > 0) {
			AppPreferences.quizeIsSave(context, true);
			AppPreferences.saveQuizTimestamp(context, new Date());
		}
		
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		/*NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancel(this.notificationId);*/
		if (this.dialog != null) {
			this.dialog.dismiss();
			this.dialog = null;
		}
		
		this.context = null;

	}
}