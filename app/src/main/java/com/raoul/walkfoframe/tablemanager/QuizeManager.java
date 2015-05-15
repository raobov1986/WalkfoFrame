package com.raoul.walkfoframe.tablemanager;

import android.content.Context;
import android.database.Cursor;

import com.raoul.walkfoframe.dao.QuizzesDao;
import com.raoul.walkfoframe.dao.QuizzesDao.Properties;
import com.raoul.walkfoframe.model.Quizzes;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class QuizeManager extends BaseManager {
  /** The Constant TAG. */
  public static final String TAG = QuizeManager.class.getSimpleName();

  public void deleteQuizsData(Context context) {
    DaoSession session = getDBSessoin(context);
    QuizzesDao dao = session.getQuizzesDao();
    try {

      dao.deleteAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }

  public void inserQuizeData(Context context, List<Quizzes> l) {
	  if (l == null) return;
    DaoSession session = getDBSessoin(context);
    QuizzesDao dao = session.getQuizzesDao();
    try {
    	dao.insertInTx(l);
      //dao.insert(quizzes);
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }
  
  public void updateQuizData(Context context, List<Quizzes> l) {
	  if (l == null) return;
	  DaoSession session = getDBSessoin(context);
	  QuizzesDao dao = session.getQuizzesDao();
	  try {
		  dao.insertOrReplaceInTx(l);
	  } catch (Exception e) {
		  e.printStackTrace();
	  } finally {
		  dao.getDatabase().close();
	  }
  }

  public List<String> getCategory(Context context) {
    DaoSession session = getDBSessoin(context);
    QuizzesDao dao = session.getQuizzesDao();
    final String SQL_DISTINCT_ENAME =
        "SELECT DISTINCT " + Properties.QuizCategory.columnName + " FROM " + dao.TABLENAME;
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


  public List<Quizzes> getquizebyCategory(Context context, String categoryname) {
    DaoSession session = getDBSessoin(context);
    QuizzesDao dao = session.getQuizzesDao();
    List<Quizzes> list = null;
    try {
      list = dao.queryBuilder().where(Properties.QuizCategory.eq(categoryname)).list();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
    return list;

  }

  public List<Quizzes> getAllquizData(Context context) {
    List<Quizzes> list = null;
    DaoSession session = getDBSessoin(context);
    QuizzesDao dao = session.getQuizzesDao();
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
