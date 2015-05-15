package com.raoul.walkfoframe.model;

import java.util.List;

public class QuiestionEvent {

  List<Quizzes>questList;

  public List<Quizzes> getQuestList() {
    return questList;
  }

  public void setQuestList(List<Quizzes> questList) {
    this.questList = questList;
  }
  int quizID;

  public int getQuizID() {
    return quizID;
  }

  public void setQuizID(int quizID) {
    this.quizID = quizID;
  }
}
