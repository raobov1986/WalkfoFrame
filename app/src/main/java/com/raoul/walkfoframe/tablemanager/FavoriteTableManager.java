package com.raoul.walkfoframe.tablemanager;

import android.content.Context;
import android.database.Cursor;

import com.raoul.walkfoframe.dao.FavoriteDao;
import com.raoul.walkfoframe.dao.FavoriteDao.Properties;
import com.raoul.walkfoframe.model.Favorite;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class FavoriteTableManager extends BaseManager {


  /** The Constant TAG. */
  public static final String TAG = FavoriteTableManager.class.getSimpleName();

  /**
   * Insertstudent data.
   * 
   * @param student the student
   * @param context the context
   */
  public void insertfavoriteData(Favorite wofhonorees, Context context) {
    DaoSession session = getDBSessoin(context);
    FavoriteDao Dao = session.getFavoriteDao();

    try {

      Dao.insertOrReplace(wofhonorees);
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      Dao.getDatabase().close();
    }
  }

  /**
   * Delet student data.
   * 
   * @param context the context
   */
  public void deletfavoriteData(Context context) {

    DaoSession session = getDBSessoin(context);
    FavoriteDao dao = session.getFavoriteDao();

    try {
      dao.deleteAll();

    } catch (Exception e) {
      // TODO: handle exception
    } finally {

      dao.getDatabase().close();
    }
  }

  public void deletfavoriteDatabyHonoreeiD(Context context, String id) {

    DaoSession session = getDBSessoin(context);
    FavoriteDao dao = session.getFavoriteDao();

    try {
      // dao.delet;

    } catch (Exception e) {
      // TODO: handle exception
    } finally {

      dao.getDatabase().close();
    }
  }

  /**
   * Gets the all student.
   * 
   * @param context the context
   * @return the all student
   */
  public List<Favorite> getAllfavoritedata(Context context) {
    List<Favorite> list = null;
    DaoSession session = getDBSessoin(context);
    FavoriteDao dao = session.getFavoriteDao();
    try {
      list = dao.loadAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }

    return list;

  }

  public List<String> deletfavoriteDatabyHonoreeiD(Context context, int id) {
    DaoSession session = getDBSessoin(context);
    FavoriteDao dao = session.getFavoriteDao();

    ArrayList<String> result = new ArrayList<String>();
    Cursor c =
        session.getDatabase().rawQuery(
            "delete from" + dao.TABLENAME + "where" + Properties.HonoreeID + "=" + id, null);
   /* if (c.moveToFirst()) {
      do {
        result.add(c.getString(0));
      } while (c.moveToNext());
    }*/
    c.close();
    return result;
  }

}
