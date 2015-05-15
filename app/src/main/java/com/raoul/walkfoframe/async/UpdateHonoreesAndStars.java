package com.raoul.walkfoframe.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.raoul.walkfoframe.model.HonoreesandStar;
import com.raoul.walkfoframe.model.WOFStars;
import com.raoul.walkfoframe.model.Wofhonorees;
import com.raoul.walkfoframe.utils.ConnectionDetector;
import com.raoul.walkfoframe.tablemanager.HonoressAndStarTableManager;
import com.raoul.walkfoframe.tablemanager.StarsManager;
import com.raoul.walkfoframe.tablemanager.WofHonreesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpdateHonoreesAndStars extends AsyncTask<Void, Void, Void> {
	
	private Context context;
	private int notificationId;
	private ProgressDialog dialog;
	
	public UpdateHonoreesAndStars(Context context) {
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
	protected Void doInBackground(Void... params) {
		HonoressAndStarTableManager honoressAndStarManager = new HonoressAndStarTableManager();
		StarsManager starManager = new StarsManager();
		honoressAndStarManager.deletehonoreesandstarData(context);
		
		WofHonreesManager honoreesManager = new WofHonreesManager();
		List<Wofhonorees> mlist = honoreesManager.getAllWofHonoreest(context);
		
		List<HonoreesandStar> hl = new ArrayList<HonoreesandStar>();
		List<String> ids = new ArrayList<String>();
		for (int i = 0; i < mlist.size(); i++) {
			ids.add(String.valueOf(mlist.get(i).getHonoreeID()));
		}
		
		List<WOFStars> allStars = starManager.getStarsByHonoress(context, ids);
		for (int i = 0; i < mlist.size(); i++) {
			List<WOFStars> list = new ArrayList<WOFStars>();
			for (WOFStars star : allStars) {
				if (String.valueOf(mlist.get(i).getHonoreeID()).equals(star.getHonoreeID())) {
					list.add(star);
				}
			}
			
			String honoreeID = String.valueOf(mlist.get(i)
					.getHonoreeID());
			String bioThumbnail = mlist.get(i).getBioThumbnail();
			String biography = mlist.get(i).getBiography();
			String birthCity = mlist.get(i).getBirthCity();
			String birthCountry = mlist.get(i).getBirthCountry();
			String birthDate = mlist.get(i).getBirthDate();
			String createdTimeStamp = mlist.get(i)
					.getCreatedTimeStamp();
			String deathCity = mlist.get(i).getDeathCity();
			String deathState = mlist.get(i).getDeathState();
			String education = mlist.get(i).getEducation();
			String ethnicity = mlist.get(i).getEthnicity();
			String inductiondate = mlist.get(i).getInductionDate();
			String fullname = mlist.get(i).getFullName();
			String nameFullFirst = mlist.get(i).getNameFullFirst();
			String nameFullFirstLetter = mlist.get(i)
					.getNameFullFirstLetter();
			String nameFullLast = mlist.get(i).getNameFullLast();
			Integer starID = null;
			String streetNo = null, streetName = null, longitude = null, latitude = null, honoreeFullName = null, ceremonyDate = null, category = null;
			if (list != null && list.size() > 0) {
				starID = list.get(0).getStarID();
				;
				streetNo = list.get(0).getStreetNo();
				streetName = list.get(0).getStreetName();
				longitude = list.get(0).getLongitude();
				latitude = list.get(0).getLatitude();
				honoreeFullName = list.get(0).getHonoreeFullName();
				ceremonyDate = list.get(0).getCeremonyDate();
				category = list.get(0).getCategory();
			}
			HonoreesandStar h = new HonoreesandStar(honoreeID,
					bioThumbnail, biography, birthCity, "",
					birthCountry, birthDate, createdTimeStamp,
					deathCity, deathState, education, ethnicity,
					inductiondate, fullname, nameFullFirst,
					nameFullFirstLetter, nameFullLast, starID,
					streetNo, streetName, longitude, latitude,
					honoreeFullName, ceremonyDate, category, "");

			hl.add(h);
		}
		
		honoressAndStarManager.inserStarsAndHonoreeData(context, hl);

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		//use this line of code when primary keys are added to the database, in the moment its impossible to identify changed rows
		/*NotificationManager mNotificationManager =
			    (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancel(this.notificationId);*/
		if (this.dialog != null) {
			this.dialog.dismiss();
			this.dialog = null;
		}
		
		if (ConnectionDetector.isConnectingToInternet(context)) {
			new UpdateQuestions(context).execute();
		}
		
		this.context = null;
	}
}