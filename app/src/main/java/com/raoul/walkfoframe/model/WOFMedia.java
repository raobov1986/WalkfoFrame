package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.io.Serializable;

@DynamoDBTable(tableName = "WOFMedia")
public class WOFMedia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WOFMedia() {
	}

	public WOFMedia(Integer starID, Integer honoreeID, Integer contentLength,
			Integer mediaType, String playPreview, String mediaName,
			String mediaNotes, String mediaURL, String previewTimeOut,
			String previewTimeIn, String thumbnailURL, int accessLevel, int mediaID) {
		this.starID = starID;
		this.honoreeID = honoreeID;
		this.contentLength = contentLength;
		this.mediaType = mediaType;
		this.playPreview = playPreview;
		this.mediaName = mediaName;
		this.mediaNotes = mediaNotes;
		this.mediaURL = mediaURL;
		this.previewTimeOut = previewTimeOut;
		this.previewTimeIn = previewTimeIn;
		this.thumbnailURL = thumbnailURL;
		this.accessLevel = accessLevel;
		this.mediaID = mediaID;
	}

	private int mediaID;

	@DynamoDBHashKey(attributeName = "mediaID")
	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	@DynamoDBAttribute(attributeName = "accessLevel")
	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	@DynamoDBAttribute(attributeName = "contentLength")
	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	@DynamoDBAttribute(attributeName = "playPreview")
	public String getPlayPreview() {
		return playPreview;
	}

	public void setPlayPreview(String playPreview) {
		this.playPreview = playPreview;
	}

	@DynamoDBAttribute(attributeName = "mediaName")
	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	@DynamoDBAttribute(attributeName = "mediaNotes")
	public String getMediaNotes() {
		return mediaNotes;
	}

	public void setMediaNotes(String mediaNotes) {
		this.mediaNotes = mediaNotes;
	}

	@DynamoDBAttribute(attributeName = "mediaType")
	public int getMediaType() {
		return mediaType;
	}

	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}

	@DynamoDBAttribute(attributeName = "mediaURL")
	public String getMediaURL() {
		return mediaURL;
	}

	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}

	@DynamoDBAttribute(attributeName = "previewTimeIn")
	public String getPreviewTimeIn() {
		return previewTimeIn;
	}

	public void setPreviewTimeIn(String previewTimeIn) {
		this.previewTimeIn = previewTimeIn;
	}

	@DynamoDBAttribute(attributeName = "previewTimeOut")
	public String getPreviewTimeOut() {
		return previewTimeOut;
	}

	public void setPreviewTimeOut(String previewTimeOut) {
		this.previewTimeOut = previewTimeOut;
	}

	@DynamoDBAttribute(attributeName = "starID")
	public int getStarID() {
		return starID;
	}

	public void setStarID(int starID) {
		this.starID = starID;
	}

	@DynamoDBAttribute(attributeName = "thumbnailURL")
	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	@DynamoDBAttribute(attributeName = "honoreeID")
	public int getHonoreeID() {
		return honoreeID;
	}

	public void setHonoreeID(int honoreeID) {
		this.honoreeID = honoreeID;
	}

	private int accessLevel;
	private int contentLength;
	private String playPreview;
	private String mediaName;
	private String mediaNotes;
	private int mediaType;
	private String mediaURL;
	private String previewTimeIn;
	private String previewTimeOut;
	private int starID;
	private String thumbnailURL;
	private int honoreeID;
}
