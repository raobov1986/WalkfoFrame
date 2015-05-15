package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "WOFPushNotification")
public class WOFPushNotification {
	public WOFPushNotification() {
	}

	public WOFPushNotification(Integer id, Integer date, String message, String title) {
		this.id = id;
		this.date = date;
		this.message = message;
		this.title = title;
	}

	@DynamoDBHashKey(attributeName = "ID")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName = "Date")
	public int getDate() {
		return this.date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@DynamoDBAttribute(attributeName = "Message")
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@DynamoDBAttribute(attributeName = "Title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private int id;
	private int date;
	private String title;
	private String message;
}
