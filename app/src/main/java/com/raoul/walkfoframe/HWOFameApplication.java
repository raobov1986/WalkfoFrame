package com.raoul.walkfoframe;

import android.app.Application;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.raoul.walkfoframe.model.WOFCoupons;
import com.raoul.walkfoframe.model.Wofhonorees;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HWOFameApplication extends Application {
	public static final int GOOGLE_ANALYTICS_DISPATCH_TIME = 1;
  public static AmazonDynamoDB clientManager = null;
  public static String PREF_NAME = "com.wof.prefname";
  public List<Wofhonorees> Honorieeslist;
  public List<WOFCoupons> couponslist;
  public static int quizId;
  public static int getQuizId() {
	  return quizId;
  }
  
  private static final String PROPERTY_ID = "UA-58753628-1";
  
  public enum TrackerName {
      APP_TRACKER, // Tracker used only in this app.
  }
  
  HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();
  
  public HWOFameApplication() {
      super();
      
      
  }
  
  synchronized Tracker getTracker(TrackerName trackerId) {
      if (!mTrackers.containsKey(trackerId)) {

          GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
          analytics.setLocalDispatchPeriod(GOOGLE_ANALYTICS_DISPATCH_TIME);
          analytics.getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
          Tracker t = analytics.newTracker(PROPERTY_ID);
          t.enableAdvertisingIdCollection(true);
          mTrackers.put(trackerId, t);
      }
      
      return mTrackers.get(trackerId);
  }
  
  public static void logMessageToGoogleAnalytics(HWOFameApplication application, String category, String action, String label, long value) {
	  Tracker t = application.getTracker(TrackerName.APP_TRACKER);
			// Build and send an Event.
			t.send(new HitBuilders.EventBuilder()
			    .setCategory(category)
			    .setAction(action)
			    .setLabel(label)
			    .setValue(value)
			    .build());
  }

public static void setQuizId(int quizId) {
  HWOFameApplication.quizId = quizId;
}

  @Override
  public void onCreate() {
    // TODO Auto-generated method stub
    super.onCreate();
    BasicAWSCredentials c = new BasicAWSCredentials("AKIAJRYXOB72QJQU3MQQ", "FOQ6TDEhxTqvZb6hb+5db1OQFd4nikDRh2tuGqy1");
    /*CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
    	    this.getApplicationContext(), // get the context for the current activity
    	    "007454190510",
    	    "us-east-1:cfe2b057-c6a0-4f11-a962-2fb9b957f32c",
    	    "arn:aws:iam::007454190510:role/UNAUTHENTICATED_ROLE",
    	    "arn:aws:iam::007454190510:role/AUTHENTICATED_ROLE",
    	    Regions.US_EAST_1
    	);*/
    
    //new Amazon
    
    //clientManager = new AmazonDynamoDBClient(credentialsProvider);
    clientManager = new AmazonDynamoDBClient(c);
    clientManager.setRegion(Region.getRegion(Regions.US_WEST_2));
    UncaughtExceptionHandler myHandler = new ExceptionReporter(
	    getTracker(TrackerName.APP_TRACKER),                                        // Currently used Tracker.
	    Thread.getDefaultUncaughtExceptionHandler(),      // Current default uncaught exception handler.
	    this);                                         // Context of the application.

	// Make myHandler the new default uncaught exception handler.
	Thread.setDefaultUncaughtExceptionHandler(myHandler);
  }

  public AmazonDynamoDB getAmazonDaynmoDbClint() {
    if (clientManager == null) {
    	BasicAWSCredentials c = new BasicAWSCredentials("AKIAJRYXOB72QJQU3MQQ", "FOQ6TDEhxTqvZb6hb+5db1OQFd4nikDRh2tuGqy1");
    	/*CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
        	    this.getApplicationContext(), // get the context for the current activity
        	    "0074-5419-0510",
        	    "us-east-1:cfe2b057-c6a0-4f11-a962-2fb9b957f32c",
        	    "arn:aws:iam::0074-5419-0510:role/UNAUTHENTICATED_ROLE",
        	    "arn:aws:iam::0074-5419-0510:role/AUTHENTICATED_ROLE",
        	    Regions.US_EAST_1
        	);
        
        clientManager = new AmazonDynamoDBClient(credentialsProvider);*/
    	 clientManager = new AmazonDynamoDBClient(c);
    	 clientManager.setRegion(Region.getRegion(Regions.US_WEST_2));
    }
    
    return clientManager;
  }

  public void setHonorresList(List<Wofhonorees> list) {
    Honorieeslist = new ArrayList<Wofhonorees>();
    Honorieeslist.addAll(list);
  }

  public List<Wofhonorees> getHonoreesList() {
    return Honorieeslist;

  }

  public void setCouponsList(List<WOFCoupons> list) {
    couponslist = new ArrayList<WOFCoupons>();
    couponslist.addAll(couponslist);
  }

  public List<WOFCoupons> getCopounsList() {
    return couponslist;

  }


}
