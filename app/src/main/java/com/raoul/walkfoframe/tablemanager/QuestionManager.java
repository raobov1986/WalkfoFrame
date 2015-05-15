package com.raoul.walkfoframe.tablemanager;

import android.content.Context;

import com.raoul.walkfoframe.dao.QuestionsDao;
import com.raoul.walkfoframe.dao.QuestionsDao.Properties;
import com.raoul.walkfoframe.model.Questions;
import com.raoul.walkfoframe.database.BaseManager;
import com.raoul.walkfoframe.database.DaoSession;

import java.util.List;

public class QuestionManager extends BaseManager {
  /** The Constant TAG. */
  public static final String TAG = QuestionManager.class.getSimpleName();

  public void deleteQuestionsData(Context context) {
    DaoSession session = getDBSessoin(context);
    QuestionsDao dao = session.getQuestionsDao();
    try {

      dao.deleteAll();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }

  public void inserQuestionData(Context context, List<Questions> l) {

	  if (l == null) return;
    DaoSession session = getDBSessoin(context);
    QuestionsDao dao = session.getQuestionsDao();
    try {
    	dao.insertInTx(l);
      //dao.insert(question);
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
  }
  
  public void updateQuestions(Context context, List<Questions> l) {
	  if (l == null) return;
	  DaoSession session = getDBSessoin(context);
	  QuestionsDao dao = session.getQuestionsDao();
	  try {
		  dao.insertOrReplaceInTx(l);
	  } catch (Exception e) {
		  e.printStackTrace();
	  } finally {
		  dao.getDatabase().close();
	  }
  }

  public List<Questions> getAllQuestionData(Context context) {
    List<Questions> list = null;
    DaoSession session = getDBSessoin(context);
    QuestionsDao dao = session.getQuestionsDao();
    try {
      list = dao.loadAll();
    } catch (Exception e) {
      dao.getDatabase().close();
    } finally {
      dao.getDatabase().close();
    }
    return list;

  }

  public List<Questions> getQustionByQuizeId(String quizedId, Context context) {
    DaoSession session = getDBSessoin(context);
    QuestionsDao dao = session.getQuestionsDao();
    List<Questions> list = null;
    try {
      list = dao.queryBuilder().where(Properties.QuizID.eq(quizedId)).list();
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      dao.getDatabase().close();
    }
    return list;

  }
}
