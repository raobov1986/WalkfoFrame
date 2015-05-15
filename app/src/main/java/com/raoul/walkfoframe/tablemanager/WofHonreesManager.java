package com.raoul.walkfoframe.tablemanager;

import android.content.Context;
import android.util.Log;

import com.raoul.walkfoframe.dao.WofhonoreesDao;
import com.raoul.walkfoframe.model.Wofhonorees;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class WofHonreesManager extends BaseManager {

  /** The Constant TAG. */
  public static final String TAG = WofHonreesManager.class.getSimpleName();

  /**
   * Insertstudent data.
   * 
   * @param student the student
   * @param context the context
   */
  public void insertstudentData(Context context, List<Wofhonorees> l) {
	  if (l == null) return;
    DaoSession session = getDBSessoin(context);
    WofhonoreesDao Dao = session.getWofhonoreesDao();

    
    
    try {
    	Dao.insertInTx(l);
      //Dao.insert(wofhonorees);
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      Dao.getDatabase().close();
    }
  }
  
  public void updateHonorees(Context context, List<Wofhonorees> l) {
	  if (l == null) return;
	  DaoSession session = getDBSessoin(context);
	  WofhonoreesDao Dao = session.getWofhonoreesDao();

	  try {
		  List<Integer> ids = new ArrayList<Integer>();
		  
		  for (Wofhonorees honoree : l) {
			  ids.add(honoree.getHonoreeID());
		  }
		  
		  Dao.queryBuilder().where(WofhonoreesDao.Properties.HonoreeID.in(ids)).buildDelete().executeDeleteWithoutDetachingEntities();
		  
		  Dao.insertOrReplaceInTx(l);
	  } catch (Exception e) {
		  e.printStackTrace();
	  } finally {
		  Dao.getDatabase().close();
	  }
  }

  /**
   * Delet student data.
   * 
   * @param context the context
   */
  public void deletStudentData(Context context) {

    DaoSession session = getDBSessoin(context);
    WofhonoreesDao dao = session.getWofhonoreesDao();
    try {
      dao.deleteAll();

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
  public List<Wofhonorees> getAllWofHonoreest(Context context) {
    List<Wofhonorees> list = null;
    DaoSession session = getDBSessoin(context);
    WofhonoreesDao dao = session.getWofhonoreesDao();
    try {
      list = dao.loadAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
    Log.v(TAG, "getAllWofHonoreest >>>>>>>>>>" + list.size());
    return list;

  }

}
