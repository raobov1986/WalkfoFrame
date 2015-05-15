package com.raoul.walkfoframe.tablemanager;

import android.content.Context;

import com.raoul.walkfoframe.dao.WOFCouponsDao;
import com.raoul.walkfoframe.model.WOFCoupons;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.List;

public class CouponsManager extends BaseManager {
  /** The Constant TAG. */
  public static final String TAG = CouponsManager.class.getSimpleName();

  public void deleteCouponsData(Context context) {
    DaoSession session = getDBSessoin(context);
    WOFCouponsDao dao = session.getWOFCouponsDao();
    try {
      dao.deleteAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }

  public void inserCouponsData(Context context, List<WOFCoupons> l) {
	  if (l == null) return;
    DaoSession session = getDBSessoin(context);
    WOFCouponsDao dao = session.getWOFCouponsDao();
    try {
      //dao.insert(coupons);
    	dao.insertInTx(l);
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }

  public List<WOFCoupons> getAllCoupons(Context context) {
    List<WOFCoupons> list = null;
    DaoSession session = getDBSessoin(context);
    WOFCouponsDao dao = session.getWOFCouponsDao();

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
