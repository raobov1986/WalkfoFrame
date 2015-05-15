package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "WOFControl")
public class WOFControl {
	
	
	private Integer controlID;
	private int challenges;
	private int forceDownload;
	
	private int honorees;
	private String hunts;
	private int media;
	private int questions;
	private int quizzes;
	private int stars;
	 public WOFControl() {
	    }

	    public WOFControl(Integer controlID, Integer challenges, Integer forceDownload, Integer honorees, Integer media, Integer questions, Integer quizzes, Integer stars, String hunts) {
	        this.controlID = controlID;
	        this.challenges = challenges;
	        this.forceDownload = forceDownload;
	        this.honorees = honorees;
	        this.media = media;
	        this.questions = questions;
	        this.quizzes = quizzes;
	        this.stars = stars;
	        this.hunts = hunts;
	    }
	@DynamoDBHashKey(attributeName = "controlID")
	public int getControlID() {
		return controlID;
	}

	public void setControlID(int controlID) {
		this.controlID = controlID;
	}

	@DynamoDBAttribute(attributeName = "challenges")
	public int getChallenges() {
		return challenges;
	}

	public void setChallenges(int challenges) {
		this.challenges = challenges;
	}

	@DynamoDBAttribute(attributeName = "forceDownload")
	public int getForceDownload() {
		return forceDownload;
	}

	public void setForceDownload(int forceDownload) {
		this.forceDownload = forceDownload;
	}

	/*@DynamoDBAttribute(attributeName = "HwofControlint")
	public String getHwofControlint() {
		return HwofControlint;
	}

	public void setHwofControlint(String hwofControlint) {
		HwofControlint = hwofControlint;
	}*/

	@DynamoDBAttribute(attributeName = "honorees")
	public int getHonorees() {
		return honorees;
	}

	public void setHonorees(int honorees) {
		this.honorees = honorees;
	}

	@DynamoDBAttribute(attributeName = "hunts")
	public String getHunts() {
		return hunts;
	}

	public void setHunts(String hunts) {
		this.hunts = hunts;
	}

	@DynamoDBAttribute(attributeName = "media")
	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	@DynamoDBAttribute(attributeName = "questions")
	public int getQuestions() {
		return questions;
	}

	public void setQuestions(int questions) {
		this.questions = questions;
	}

	@DynamoDBAttribute(attributeName = "quizzes")
	public int getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(int quizzes) {
		this.quizzes = quizzes;
	}

	@DynamoDBAttribute(attributeName = "stars")
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

}
