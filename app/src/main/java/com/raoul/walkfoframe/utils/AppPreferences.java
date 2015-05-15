package com.raoul.walkfoframe.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.raoul.walkfoframe.R;

import java.util.Date;

public class AppPreferences {
  public static final String HWOFPREFERENCES = "preferences";
  public static final String APPLUNCH = "Launch";
  public static final String HONOREES = "HONOREES";
  public static final String MEDIA = "MEDIA";
  public static final String QUESTION = "QUESTION";
  public static final String COUPONS = "COUPONS";
  public static final String CONTROLS = "CONTROLS";
  public static final String QUIZE = "QUIZE";
  public static final String STARS = "STARS";
  public static final String USER = "USER";
  public static final String HINTDIALOG = "HINTDIALOG";
  public static final String LATITUDE="lat";
  public static final String LONGITUDE="lng";
  public static final String QUIZES_TIMESTAMP = "QUIZE_TIMESTAMP";
  public static final String MEDIA_TIMESTAMP = "MEDIA_TIMESTAMP";
  public static final String HONOREES_TIMESTAMP = "HONOREES_TIMESTAMP";
  public static final String STARS_TIMESTAMP = "STARS_TIMESTAMP";
  public static final String QUESTIONS_TIMESTAMP = "QUESTIONS_TIMESTAMP";
  public static final String MEDIA_HONOREES_ID = "MEDIA_HONOREES_ID";
  public static final String MEDIA_URL = "MEDIA_URL";
  public static final String MEDIA_DESC = "MEDIA_DESC";
  public static final String BOUGHT_ITEMS = "BOUGHT_ITEMS";
  public static final String MY_STAR_NAME = "MY_STAR_NAME";
  public static final String MY_STAR_ICON = "MY_STAR_ICON";
  public static final String LAST_NOTIFICATION_TIME = "LAST_NOTIFICATION_TIME";
  public static final String PREMIUM = "PREMIUM";
  public static final String IS_AD_FIRST_TIME = "IS_AD_FIRST_TIME";
  public static final String AD_LAST_TIME_SHOWN = "AD_LAST_TIME_SHOWN";
  public static final String SHOP_UNLOCK_TRIVIA = "SHOP_UNLOCK_TRIVIA";
  public static final String SHOP_UNLOCK_VIDEOS_AND_PHOTOS = "SHOP_UNLOCK_VIDEOS_AND_PHOTOS";
  public static final String SHOP_UNLOCK_COUPONS = "SHOP_UNLOCK_COUPONS";
  public static final String SHOP_UNLOCK_CREATE_A_STAR = "SHOP_UNLOCK_CREATE_A_STAR";
  public static final String CLICK_COUNT = "CLICK_COUNT";
  public static final String TRIVIA_CLICK_COUNT = "TRIVIA_CLICK_COUNT";
  public static final String CREATE_STAR_CLICK_COUNT = "CREATE_STAR_CLICK_COUNT";
  public static final String MEDIA_FILE_IS_PREMIUM = "MEDIA_FILE_IS_PREMIUM";
  public static final String PREVIOUS_SCREEN = "PREVIOUS_SCREEN";
  public static final int NUMBER_OF_CLICKS_FOR_AD = 10;
  public static final String IS_TRAILER = "IS_TRAILER";
  
  public static void saveAppLaunch(Context context, boolean isFirstLaunch) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(APPLUNCH, isFirstLaunch);
    editor.commit();
  }

  public static boolean isAppFirstLaunch(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(APPLUNCH, false);
  }

  public static void honoreesIsSaved(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(HONOREES, success);
    editor.commit();
  }

  public static void MEDIAIsSaved(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(MEDIA, success);
    editor.commit();
  }

  public void question(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(QUESTION, success);
    editor.commit();
  }

  public static void coupons(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(QUESTION, success);
    editor.commit();
  }

  public static void quizeIsSave(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(QUIZE, success);
    editor.commit();
  }

  public static void ControlIsSaved(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(CONTROLS, success);
    editor.commit();
  }

  public static void starIsSaved(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(STARS, success);
    editor.commit();
  }

  public static void userIsSaved(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(USER, success);
    editor.commit();
  }

  public static void setHintDialogSetting(Context context, boolean success) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putBoolean(HINTDIALOG, success);
    editor.commit();
  }
  public static void setLatitude(Context context, String lat) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putString(LATITUDE, lat);
    editor.commit();
  }

  public static void setLongitude(Context context, String lng) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putString(LONGITUDE, lng);
    editor.commit();
  }
  
  public static String getLatutude(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getString(LATITUDE, "0.0");
  }
  
  public static String getLongitude(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getString(LONGITUDE, "0.0");
  }
  
  public static boolean getHonoreesIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(HONOREES, false);
  }

  public static boolean isHintDiologshow(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(HINTDIALOG, false);
  }

  public static boolean getcouponsIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(COUPONS, false);
  }

  public static boolean getStarIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(STARS, false);
  }

  public static boolean getQuestionIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(QUESTION, false);
  }

  public static boolean getQuizeIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(QUIZE, false);
  }

  public static boolean getContollsIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(CONTROLS, false);
  }

  public static boolean getUserIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(USER, false);
  }

  public static boolean getMediaIsSaved(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getBoolean(MEDIA, false);
  }
  
  public static Date getQuizesTimestamp(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    long milis = pereference.getLong(QUIZES_TIMESTAMP, 0);
    return new Date(milis);
  }
  
  public static void saveQuizTimestamp(Context context, Date timestamp) {
	  if (timestamp == null) return;
	  
	  long milis = timestamp.getTime();
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putLong(QUIZES_TIMESTAMP, milis);
	  editor.commit();
  }
  
  public static void saveMediaTimestamp(Context context, Date timestamp) {
	  if (timestamp == null) return;
	  
	  long milis = timestamp.getTime();
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putLong(MEDIA_TIMESTAMP, milis);
	  editor.commit();
  }
  
  public static Date getMediaTimestamp(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    long milis = pereference.getLong(MEDIA_TIMESTAMP, 0);
    return new Date(milis);
  }
  
  public static void saveHonoreesTimestamp(Context context, Date timestamp) {
	  if (timestamp == null) return;
	  
	  long milis = timestamp.getTime();
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putLong(HONOREES_TIMESTAMP, milis);
	  editor.commit();
  }
  
  public static Date getHonoreesTimestamp(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    long milis = pereference.getLong(HONOREES_TIMESTAMP, 0);
    return new Date(milis);
  }
	  
  public static void saveStarsTimestamp(Context context, Date timestamp) {
	  if (timestamp == null) return;
	  
	  long milis = timestamp.getTime();
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putLong(STARS_TIMESTAMP, milis);
	  editor.commit();
  }
  
  public static Date getStarsTimestamp(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    long milis = pereference.getLong(STARS_TIMESTAMP, 0);
    return new Date(milis);
  }
  
  public static void saveQuestionsTimestamp(Context context, Date timestamp) {
	  if (timestamp == null) return;
	  
	  long milis = timestamp.getTime();
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putLong(QUESTIONS_TIMESTAMP, milis);
	  editor.commit();
  }
  
  public static Date getQuestionsTimestamp(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    long milis = pereference.getLong(QUESTIONS_TIMESTAMP, 0);
    return new Date(milis);
  }
  
  public static void saveHonoreesIdForMedia(Context context, Integer starId) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putInt(MEDIA_HONOREES_ID, starId);
	  editor.commit();
  }
  
  public static int getHonoreesIdForMedia(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    int starId = pereference.getInt(MEDIA_HONOREES_ID, 0);
    return starId;
  }
  
  public static void saveMediaUrl(Context context, String url) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putString(MEDIA_URL, url);
	  editor.commit();
  }
  
  public static String getMediaUrl(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    String url = pereference.getString(MEDIA_URL, "");
    return url;
  }
  
  public static void saveMediaDesc(Context context, String url) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putString(MEDIA_DESC, url);
	  editor.commit();
  }
  
  public static String getMediaDesc(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    String url = pereference.getString(MEDIA_DESC, "");
    return url;
  }
  
  public static void saveBoughtItems(Context context, String items) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putString(BOUGHT_ITEMS, items);
	  editor.commit();
  }
  
  public static String getBoughtItems(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    String url = pereference.getString(BOUGHT_ITEMS, "");
    return url;
  }
  
  public static void saveMyStarName(Context context, String name) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putString(MY_STAR_NAME, name);
	  editor.commit();
  }
  
  public static String getMyStarName(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    String name = pereference.getString(MY_STAR_NAME, "");
    return name;
  }
  
  public static void saveMyStarIcon(Context context, int icon) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putInt(MY_STAR_ICON, icon);
	  editor.commit();
  }
  
  public static int getMyStarIcon(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    int icon = pereference.getInt(MY_STAR_ICON, R.drawable.camera_gold_img);
    return icon;
  }

  public static void saveLastNotificationId(Context context, int notification) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putInt(LAST_NOTIFICATION_TIME, notification);
	  editor.commit();
  }
  
  public static int getLastNotificationId(Context context) {
	  SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return pereference.getInt(LAST_NOTIFICATION_TIME, -1);
  }
  
  public static void savePremium(Context context, boolean value) {
	  SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preferences.edit();
	  editor.putBoolean(PREMIUM, value);
	  editor.commit();
  }
  
  public static boolean getIsPremium(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(PREMIUM, false);
  }
  
  public static long getAdLastTimeShown(Context context, long value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getLong(AD_LAST_TIME_SHOWN, value);
  }
  
  public static void saveAdLastTimeShown(Context context, long value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preference.edit();
	  editor.putLong(AD_LAST_TIME_SHOWN, value);
	  editor.commit();
  }
  
  public static boolean getIsAdFirstTime(Context context, boolean value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(IS_AD_FIRST_TIME, value);
  }
  
  public static void saveIsAdFirstTime(Context context, boolean value) {
	SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	Editor editor = preference.edit();
	editor.putBoolean(IS_AD_FIRST_TIME, value);
	editor.commit();
  }
  
  public static boolean getShopUnlockTrivia(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(SHOP_UNLOCK_TRIVIA, false);
  }
  
  public static void saveShopUnlockTrivia(Context context, boolean value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preference.edit();
	  editor.putBoolean(SHOP_UNLOCK_TRIVIA, value);
	  editor.commit();
  }
  
  public static boolean getShopUnlockVideosAndPhotos(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(SHOP_UNLOCK_VIDEOS_AND_PHOTOS, false);
  }
  
  public static void saveShopUnlockVideosAndPhotos(Context context, boolean value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preference.edit();
	  editor.putBoolean(SHOP_UNLOCK_VIDEOS_AND_PHOTOS, value);
	  editor.commit();
  }
  
  public static boolean getShopUnlockCoupons(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(SHOP_UNLOCK_COUPONS, false);
  }
  
  public static void saveShopUnlockCoupons(Context context, boolean value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preference.edit();
	  editor.putBoolean(SHOP_UNLOCK_COUPONS, value);
	  editor.commit();
  }

  public static boolean getShopUnlockCreateAStar(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(SHOP_UNLOCK_CREATE_A_STAR, false);
  }
  
  public static void saveShopUnlockCreateAStar(Context context, boolean value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preference.edit();
	  editor.putBoolean(SHOP_UNLOCK_CREATE_A_STAR, value);
	  editor.commit();
  }

  public static int getClickCount(Context context) {
    SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    int clickCount = preference.getInt(CLICK_COUNT, 1);
    return clickCount;
  }
  
  public static void incrementClickCount(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  int clickCount = preference.getInt(CLICK_COUNT, 1);
	  clickCount++;
	  Editor editor = preference.edit();
	  editor.putInt(CLICK_COUNT, clickCount % NUMBER_OF_CLICKS_FOR_AD);
	  editor.commit();
  }
  public static int getTriviaClickCount(Context context) {
	    SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	    int triviaClickCount = preference.getInt(TRIVIA_CLICK_COUNT, 0);
	    return triviaClickCount;
	  }
		  
  public static void incrementTriviaClickCount(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  int triviaClickCount = preference.getInt(TRIVIA_CLICK_COUNT, 0);
	  if( triviaClickCount < 2 ) {
		  triviaClickCount++;
		  Editor editor = preference.edit();
		  editor.putInt(TRIVIA_CLICK_COUNT, triviaClickCount);
		  editor.commit();
	  }
  }
  public static int getCreateStarClickCount(Context context) {
	    SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	    int createStarClickCount = preference.getInt(CREATE_STAR_CLICK_COUNT, 0);
	    return createStarClickCount;
	  }
		  
  public static void incrementCreateStarClickCount(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  int createStarClickCount = preference.getInt(CREATE_STAR_CLICK_COUNT, 0);
	  if( createStarClickCount < 1 ) {
		  createStarClickCount++;
		  Editor editor = preference.edit();
		  editor.putInt(CREATE_STAR_CLICK_COUNT, createStarClickCount);
		  editor.commit();
	  }
  }
  
  public static void setMediaIsPremium(Context context, boolean value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preference.edit();
	  editor.putBoolean(MEDIA_FILE_IS_PREMIUM, value);
	  editor.commit();
  }

  public static boolean getMediaIsPremium(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(MEDIA_FILE_IS_PREMIUM, false);
  }
  
  public static void saveIsTrailer(Context context, boolean value) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  Editor editor = preference.edit();
	  editor.putBoolean(IS_TRAILER, value);
	  editor.commit();
  }

  public static boolean getIsTrailer(Context context) {
	  SharedPreferences preference = context.getSharedPreferences(HWOFPREFERENCES, 0);
	  return preference.getBoolean(IS_TRAILER, false);
  }
  
  public static void setPreviousScreen(Context context, String previousScreen) {
    SharedPreferences preferences = context.getSharedPreferences(HWOFPREFERENCES, 0);
    Editor editor = preferences.edit();
    editor.putString(PREVIOUS_SCREEN, previousScreen);
    editor.commit();
  }
  
  public static String getPreviousScreen(Context context) {
    SharedPreferences pereference = context.getSharedPreferences(HWOFPREFERENCES, 0);
    return pereference.getString(PREVIOUS_SCREEN, "");
  }
  
}

