package com.raoul.walkfoframe.model;


import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Questions")
public class Questions {

  public Questions() {}

  public Questions(Integer starID, Integer answer, Integer quizID, Integer complexity,
      Integer questionType, String option1, String option2, String question, String questionName,
      String option3, String option4, String postQuestion) {
    this.starID = starID;
    this.answer = answer;
    this.quizID = quizID;
    this.complexity = complexity;
    this.questionType = questionType;
    this.option1 = option1;
    this.option2 = option2;
    this.question = question;
    this.questionName = questionName;
    this.option3 = option3;
    this.option4 = option4;
    this.postQuestion = postQuestion;
  }

  private int questionID;

  @DynamoDBHashKey(attributeName = "questionID")
  public int getQuestionID() {
    return questionID;
  }

  public void setQuestionID(int questionID) {
    this.questionID = questionID;
  }

  @DynamoDBRangeKey(attributeName = "starID")
  public int getStarID() {
    return starID;
  }

  public void setStarID(int starID) {
    this.starID = starID;
  }

  @DynamoDBAttribute(attributeName = "answer")
  public int getAnswer() {
    return answer;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }

  @DynamoDBAttribute(attributeName = "complexity")
  public int getComplexity() {
    return complexity;
  }

  public void setComplexity(int complexity) {
    this.complexity = complexity;
  }

  @DynamoDBAttribute(attributeName = "option1")
  public String getOption1() {
    return option1;
  }

  public void setOption1(String option1) {
    this.option1 = option1;
  }

  @DynamoDBAttribute(attributeName = "option2")
  public String getOption2() {
    return option2;
  }

  public void setOption2(String option2) {
    this.option2 = option2;
  }

  @DynamoDBAttribute(attributeName = "question")
  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  @DynamoDBAttribute(attributeName = "questionType")
  public int getQuestionType() {
    return questionType;
  }

  public void setQuestionType(int questionType) {
    this.questionType = questionType;
  }

  @DynamoDBAttribute(attributeName = "quizID")
  public int getQuizID() {
    return quizID;
  }

  public void setQuizID(int quizID) {
    this.quizID = quizID;
  }

  @DynamoDBAttribute(attributeName = "questionName")
  public String getQuestionName() {
    return questionName;
  }

  public void setQuestionName(String questionName) {
    this.questionName = questionName;
  }

  @DynamoDBAttribute(attributeName = "option3")
  public String getOption3() {
    return option3;
  }

  public void setOption3(String option3) {
    this.option3 = option3;
  }

  @DynamoDBAttribute(attributeName = "option4")
  public String getOption4() {
    return option4;
  }

  public void setOption4(String option4) {
    this.option4 = option4;
  }

  @DynamoDBAttribute(attributeName = "postQuestion")
  public String getPostQuestion() {
    return postQuestion;
  }

  public void setPostQuestion(String postQuestion) {
    this.postQuestion = postQuestion;
  }

  private int starID;

  @Override
  public String toString() {
    return "Questions [questionID=" + questionID + ", starID=" + starID + ", answer=" + answer
        + ", complexity=" + complexity + ", option1=" + option1 + ", option2=" + option2
        + ", question=" + question + ", questionType=" + questionType + ", quizID=" + quizID
        + ", questionName=" + questionName + ", option3=" + option3 + ", option4=" + option4
        + ", postQuestion=" + postQuestion + "]";
  }

  private int answer;
  private int complexity;
  private String option1;
  private String option2;
  private String question;
  private int questionType;
  private int quizID;
  private String questionName;
  private String option3;
  private String option4;
  private String postQuestion;

}
