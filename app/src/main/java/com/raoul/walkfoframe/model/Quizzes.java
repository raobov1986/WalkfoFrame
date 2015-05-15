package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Quizzes")
public class Quizzes {
  private int quizID;
  private String quizCategory;
  private String quizName;
  public Quizzes() {}
  public Quizzes(Integer quizID, String quizCategory, String quizName) {
    this.quizID = quizID;
    this.quizCategory = quizCategory;
    this.quizName = quizName;
  }
  @DynamoDBHashKey(attributeName = "quizID")
  public int getQuizID() {
    return quizID;
  }
  public void setQuizID(int quizID) {
    this.quizID = quizID;
  }
  @DynamoDBHashKey(attributeName = "quizCategory")
  public String getQuizCategory() {
    return quizCategory;
  }
  public void setQuizCategory(String quizCategory) {
    this.quizCategory = quizCategory;
  }
  @DynamoDBAttribute(attributeName = "quizName")
  public String getQuizName() {
    return quizName;
  }
  public void setQuizName(String quizName) {
    this.quizName = quizName;
  }
}
