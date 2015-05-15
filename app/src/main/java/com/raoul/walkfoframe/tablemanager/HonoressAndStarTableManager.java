package com.raoul.walkfoframe.tablemanager;

import android.content.Context;

import com.raoul.walkfoframe.dao.HonoreesandStarDao;
import com.raoul.walkfoframe.dao.HonoreesandStarDao.Properties;
import com.raoul.walkfoframe.model.HonoreesandStar;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class HonoressAndStarTableManager extends BaseManager {
  /** The Constant TAG. */
  public static final String TAG = HonoressAndStarTableManager.class.getSimpleName();

  public void deletehonoreesandstarData(Context context) {
    DaoSession session = getDBSessoin(context);
    HonoreesandStarDao dao = session.getHonoreesandstarDao();
    try {
      dao.deleteAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }

  public void inserStarsAndHonoreeData(Context context, List<HonoreesandStar> l) {
	  if (l == null) return;
	  
    DaoSession session = getDBSessoin(context);
    HonoreesandStarDao dao = session.getHonoreesandstarDao();
    try {
    	dao.insertInTx(l);
      //dao.insert(stars);
    } catch (Exception e) {
    } finally {
      dao.getDatabase().close();
    }
  }

  public void addfavorite(String id, Context context, String value, HonoreesandStar honoreesandStar) {
    DaoSession session = getDBSessoin(context);
    HonoreesandStarDao dao = session.getHonoreesandstarDao();
    String updateQuery =
        "update " + dao.TABLENAME + " set " + Properties.Isfavorite.columnName + "=?" + " where "
            + Properties.HonoreeID.columnName + "=?";
   dao.getDatabase().execSQL(updateQuery, new Object[] {value, id});
    dao.refresh(honoreesandStar);
  //  dao.update(honoreesandStar);
   session.clear();



  }

  public synchronized List<HonoreesandStar> getStarAndHonoreesData(Context context) {
    List<HonoreesandStar> star = null;
    DaoSession session = getDBSessoin(context);
    HonoreesandStarDao dao = session.getHonoreesandstarDao();;
    try {
      star = dao.loadAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }

    return star;
  }
  
  public synchronized List<HonoreesandStar> getStarAndHonoreesFavorites(Context context) {
	    List<HonoreesandStar> star = new ArrayList<HonoreesandStar>();
	    DaoSession session = getDBSessoin(context);
	    HonoreesandStarDao dao = session.getHonoreesandstarDao();;
	    try {
	    	star = dao.queryBuilder().where(Properties.Isfavorite.eq("true")).list();
	      //star = dao.loadAll();
	    } catch (Exception e) {
	      // TODO: handle exception
	    } finally {
	      dao.getDatabase().close();
	    }

	    return star;
	  }

}
