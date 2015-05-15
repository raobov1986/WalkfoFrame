package com.raoul.walkfoframe.tablemanager;

import android.content.Context;
import android.database.Cursor;

import com.raoul.walkfoframe.dao.WOFStarsDao;
import com.raoul.walkfoframe.dao.WOFStarsDao.Properties;
import com.raoul.walkfoframe.model.WOFStars;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class StarsManager extends BaseManager {
  /** The Constant TAG. */
  public static final String TAG = StarsManager.class.getSimpleName();

  public void deleteStarDataData(Context context) {
    DaoSession session = getDBSessoin(context);
    WOFStarsDao dao = session.getWOFStarsDao();
    try {

      dao.deleteAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }

  public void inserStarsData(Context context, List<WOFStars> l) {
	  if (l == null) return;
    DaoSession session = getDBSessoin(context);
    WOFStarsDao dao = session.getWOFStarsDao();
    try {
     dao.insertInTx(l);
      //dao.insert(stars);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dao.getDatabase().close();
    }
  }
  
  public void updateStars(Context context, List<WOFStars> l) {
	  if (l == null) return;
	  DaoSession session = getDBSessoin(context);
	  WOFStarsDao dao = session.getWOFStarsDao();
	  try {
		  dao.insertOrReplaceInTx(l);
	  } catch (Exception e) {
		  e.printStackTrace();
	  } finally {
		  dao.getDatabase().close();
	  }
  }

  public synchronized List<WOFStars> getStarByHonoressID(String iD, Context context) {
    List<WOFStars> star = null;
    DaoSession session = getDBSessoin(context);
    WOFStarsDao dao = session.getWOFStarsDao();
    try {
      star = dao.queryBuilder().where(Properties.HonoreeID.eq(iD)).list();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }

    return star;
  }
  
  public synchronized List<WOFStars> getStarsByHonoress(Context context, List<String> ids) {
	    List<WOFStars> star = null;
	    DaoSession session = getDBSessoin(context);
	    WOFStarsDao dao = session.getWOFStarsDao();
	    try {
	    	star = dao.loadAll();
	      //star = dao.queryBuilder().where(Properties.HonoreeID.in(ids)).list();
	    } catch (Exception e) {
	    	e.printStackTrace();
	      // TODO: handle exception
	    } finally {
	      dao.getDatabase().close();
	    }

	    return star;
	  }

  public List<String> getCategory(Context context) {
    DaoSession session = getDBSessoin(context);
    WOFStarsDao dao = session.getWOFStarsDao();
    final String SQL_DISTINCT_ENAME =
        "SELECT DISTINCT " + Properties.Category.columnName + " FROM " + dao.TABLENAME;
    ArrayList<String> result = new ArrayList<String>();
    Cursor c = session.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
    if (c.moveToFirst()) {
      do {
        result.add(c.getString(0));
      } while (c.moveToNext());
    }
    c.close();
    return result;
  }

  public List<WOFStars> getAllHonoreeIdByCategory(String Category, Context context) {
    List<WOFStars> star = null;
    DaoSession session = getDBSessoin(context);
    WOFStarsDao dao = session.getWOFStarsDao();
    try {
      star = dao.queryBuilder().where(Properties.Category.eq(Category)).list();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }

    return star;


  }

  public List<WOFStars> getStarsnData(Context context) {
    List<WOFStars> list = null;
    DaoSession session = getDBSessoin(context);
    WOFStarsDao dao = session.getWOFStarsDao();
    
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
