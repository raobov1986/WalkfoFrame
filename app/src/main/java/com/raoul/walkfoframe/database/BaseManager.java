package com.raoul.walkfoframe.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.raoul.walkfoframe.database.DaoMaster.DevOpenHelper;

// TODO: Auto-generated Javadoc

/**
 * The Class BaseManager.
 *
 * @author Bhoopendra .kaurav  class for managing database
 */
public class BaseManager {
	// private static final String LOG_TAG = "BaseManager"
	/**
	 * Gets the DB sessoin.
	 *
	 * @param context the context
	 * @return the DB sessoin
	 */
	public DaoSession getDBSessoin(Context context) {
		// long startTime = System.currentTimeMillis();
		if (context != null) {
			DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,
					"hwof-db", null);
			SQLiteDatabase db = helper.getWritableDatabase();
			DaoMaster daoMaster = new DaoMaster(db);
			DaoSession daoSession = daoMaster.newSession();
			if (daoSession != null) {
				return daoSession;
			} else {
				return null;
			}
		}
		return null;
	}

}
