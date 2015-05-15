package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "WOF_USER")
public class WOF_USER {
	public WOF_USER() {
	}

	public WOF_USER(String Email, String EmailVerifyDate,
			String RegistrationDate, String LastPassword,
			String PrimaryRegistartionName, String Password, String UserName,
			String PrimaryRegistartion, String PasswordChangeDate) {
		this.Email = Email;
		this.EmailVerifyDate = EmailVerifyDate;
		this.RegistrationDate = RegistrationDate;
		this.LastPassword = LastPassword;
		this.PrimaryRegistartionName = PrimaryRegistartionName;
		this.Password = Password;
		this.UserName = UserName;
		this.PrimaryRegistartion = PrimaryRegistartion;
		this.PasswordChangeDate = PasswordChangeDate;
	}

	private String UserID;

	@DynamoDBHashKey(attributeName = "UserID")
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	@DynamoDBAttribute(attributeName = "Email")
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@DynamoDBAttribute(attributeName = "EmailVerifyDate")
	public String getEmailVerifyDate() {
		return EmailVerifyDate;
	}

	public void setEmailVerifyDate(String emailVerifyDate) {
		EmailVerifyDate = emailVerifyDate;
	}

	@DynamoDBAttribute(attributeName = "RegistrationDate")
	public String getRegistrationDate() {
		return RegistrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		RegistrationDate = registrationDate;
	}

	@DynamoDBAttribute(attributeName = "LastPassword")
	public String getLastPassword() {
		return LastPassword;
	}

	public void setLastPassword(String lastPassword) {
		LastPassword = lastPassword;
	}

	@DynamoDBAttribute(attributeName = "PrimaryRegistartionName")
	public String getPrimaryRegistartionName() {
		return PrimaryRegistartionName;
	}

	public void setPrimaryRegistartionName(String primaryRegistartionName) {
		PrimaryRegistartionName = primaryRegistartionName;
	}

	@DynamoDBAttribute(attributeName = "Password")
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@DynamoDBAttribute(attributeName = "UserName")
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	@DynamoDBAttribute(attributeName = "PrimaryRegistartion")
	public String getPrimaryRegistartion() {
		return PrimaryRegistartion;
	}

	public void setPrimaryRegistartion(String primaryRegistartion) {
		PrimaryRegistartion = primaryRegistartion;
	}

	@DynamoDBAttribute(attributeName = "PasswordChangeDate")
	public String getPasswordChangeDate() {
		return PasswordChangeDate;
	}

	public void setPasswordChangeDate(String passwordChangeDate) {
		PasswordChangeDate = passwordChangeDate;
	}

	private String Email;
	private String EmailVerifyDate;
	private String RegistrationDate;
	private String LastPassword;
	private String PrimaryRegistartionName;
	private String Password;
	private String UserName;
	private String PrimaryRegistartion;
	private String PasswordChangeDate;
}
