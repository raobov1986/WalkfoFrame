package com.raoul.walkfoframe.tablemanager;

import android.content.Context;

import com.raoul.walkfoframe.dao.WOFMediaDao;
import com.raoul.walkfoframe.dao.WOFMediaDao.Properties;
import com.raoul.walkfoframe.model.WOFMedia;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.List;

public class MediaManager extends BaseManager {
	/** The Constant TAG. */
	public static final String TAG = MediaManager.class.getSimpleName();

	public void deleteMediaData(Context context) {
		DaoSession session = getDBSessoin(context);
		WOFMediaDao dao = session.getWOFMediaDao();
		try {

			dao.deleteAll();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dao.getDatabase().close();
		}
	}

	public void inserMediasData(Context context, List<WOFMedia> l) {
		if (l == null) return;
		
		DaoSession session = getDBSessoin(context);
		WOFMediaDao dao = session.getWOFMediaDao();
		try {
			dao.insertInTx(l);
			//dao.insert(media);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dao.getDatabase().close();
		}
	}
	
	public void updateMedia(Context context, List<WOFMedia> l) {
		if (l == null) return;
		
		DaoSession session = getDBSessoin(context);
		WOFMediaDao dao = session.getWOFMediaDao();
		try { 
			dao.insertOrReplaceInTx(l);
			//dao.insert(media);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dao.getDatabase().close();
		}
	}

	public List<WOFMedia> getAllMediaData(Context context) {
		List<WOFMedia> list = null;
		DaoSession session = getDBSessoin(context);
		WOFMediaDao dao = session.getWOFMediaDao();

		try {
			
			list = dao.loadAll();
		} catch (Exception e) {
			dao.getDatabase().close();
		} finally {
			dao.getDatabase().close();
		}
		return list;

	}
	
	public List<WOFMedia> getMediaForStar(Context context, int starId) {
		List<WOFMedia> list = null;
		DaoSession session = getDBSessoin(context);
		WOFMediaDao dao = session.getWOFMediaDao();

		try {
			list = dao.queryBuilder().where(Properties.StarID.eq(starId)).list();
		} catch (Exception e) {
			dao.getDatabase().close();
		} finally {
			dao.getDatabase().close();
		}
		return list;

	}

}
