package com.raoul.walkfoframe.tablemanager;

import android.content.Context;

import com.raoul.walkfoframe.dao.WOF_USERDao;
import com.raoul.walkfoframe.model.WOF_USER;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.List;

public class UserManager extends BaseManager {
	/** The Constant TAG. */
	public static final String TAG = UserManager.class.getSimpleName();

	public void deleteUserData(Context context) {
		DaoSession session = getDBSessoin(context);
		WOF_USERDao dao = session.getWOF_USERDao();
		try {

			dao.deleteAll();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dao.getDatabase().close();
		}
	}

	public void inserUserData(WOF_USER user, Context context) {

		DaoSession session = getDBSessoin(context);
		WOF_USERDao dao = session.getWOF_USERDao();
		try {
			//deleteUserData(context);
			dao.insert(user);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dao.getDatabase().close();
		}
	}

	public List<WOF_USER> getUserData(Context context) {
		List<WOF_USER> list = null;
		DaoSession session = getDBSessoin(context);
		WOF_USERDao dao = session.getWOF_USERDao();

		try {
			
			list = dao.loadAll();
		} catch (Exception e) {
			dao.getDatabase().close();
		} finally {
			dao.getDatabase().close();
		}
		return list;

	}

}
