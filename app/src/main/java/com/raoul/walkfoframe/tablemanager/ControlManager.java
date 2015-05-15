package com.raoul.walkfoframe.tablemanager;

import android.content.Context;

import com.raoul.walkfoframe.dao.WOFControlDao;
import com.raoul.walkfoframe.model.WOFControl;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.List;

public class ControlManager extends BaseManager {
  /** The Constant TAG. */
  public static final String TAG = ControlManager.class.getSimpleName();

  /**
   * Insertstudent data.
   * 
   * @param student the student
   * @param context the context
   */
  public void insertControlData(WOFControl controls, Context context) {
    DaoSession session = getDBSessoin(context);
    WOFControlDao Dao = session.getWOFControlDao();

    try {

      Dao.insert(controls);
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
  public void deleteControlData(Context context) {

    DaoSession session = getDBSessoin(context);
    WOFControlDao dao = session.getWOFControlDao();
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
   * @return the all WOFControl
   */
  public List<WOFControl> getAllWofcontroll(Context context) {
    List<WOFControl> list = null;
    DaoSession session = getDBSessoin(context);
    WOFControlDao dao = session.getWOFControlDao();
    try {
      list = dao.loadAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }

    return list;

  }

}
