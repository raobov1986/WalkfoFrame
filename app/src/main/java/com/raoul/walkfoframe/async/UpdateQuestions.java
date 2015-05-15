package com.raoul.walkfoframe.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.raoul.walkfoframe.model.Questions;
import com.raoul.walkfoframe.web.DynamoDBManager;
import com.raoul.walkfoframe.utils.AppPreferences;
import com.raoul.walkfoframe.utils.ConnectionDetector;
import com.raoul.walkfoframe.tablemanager.QuestionManager;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class UpdateQuestions extends AsyncTask<Void, Void, List<Questions>> {
	
	private Context context;
	private int notificationId;
	private ProgressDialog dialog;
	
	public UpdateQuestions(Context context) {
		this.context = context;
		this.notificationId = Math.abs((new Random()).nextInt());
	}
	
	protected void onPreExecute() {
		super.onPreExecute();
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		/*
		NotificationCompat.Builder mBuilder =
	        new NotificationCompat.Builder(this.context)
	        .setSmallIcon(R.drawable.ic_launcher)
	        .setContentTitle("Updating")
	        .setContentText("Updating questions")
	        .setOngoing(true);
		NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(this.notificationId, mBuilder.build());*/
		dialog = new ProgressDialog(context);
		dialog.setCancelable(false);
		dialog.setMessage("Updating questions");
		dialog.show();
	}

	@Override
	protected List<Questions> doInBackground(Void... params) {
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//List<Questions> l = DynamoDBManager.GetWofQuestion(AppPreferences.getQuestionsTimestamp(context));
		List<Questions> l = DynamoDBManager.GetWofQuestion(new Date(0));
		QuestionManager manager = new QuestionManager();
		
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		//manager.updateQuestions(this.context, l);
		manager.deleteQuestionsData(context);
		manager.inserQuestionData(context, l);
		
		if (l != null) {
			Log.e("Updated questions", l.size() + "");
		}
		return l;
	}

	@Override
	protected void onPostExecute(List<Questions> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result != null && result.size() > 0) {
			AppPreferences.quizeIsSave(this.context, true);
			AppPreferences.saveQuestionsTimestamp(context, new Date());
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
			new UpdateMedia(context).execute();
		}
		
		this.context = null;

	}
}