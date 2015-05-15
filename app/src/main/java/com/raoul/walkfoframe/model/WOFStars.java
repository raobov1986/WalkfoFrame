package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.google.android.gms.maps.model.LatLng;
import com.raoul.walkfoframe.maputtiliy.clustering.ClusterItem;

@DynamoDBTable(tableName = "WOFStars")
public class WOFStars implements ClusterItem {

  @DynamoDBHashKey(attributeName = "starID")
  public int getStarID() {
    return starID;
  }

  public void setStarID(int starID) {
    this.starID = starID;
  }

  @DynamoDBAttribute(attributeName = "category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @DynamoDBAttribute(attributeName = "ceremonyDate")
  public String getCeremonyDate() {
    return ceremonyDate;
  }

  public void setCeremonyDate(String ceremonyDate) {
    this.ceremonyDate = ceremonyDate;
  }

  @DynamoDBAttribute(attributeName = "honoreeFullName")
  public String getHonoreeFullName() {
    return honoreeFullName;
  }

  public void setHonoreeFullName(String honoreeFullName) {
    this.honoreeFullName = honoreeFullName;
  }

  @DynamoDBAttribute(attributeName = "honoreeID")
  public String getHonoreeID() {
    return honoreeID;
  }

  public void setHonoreeID(String honoreeID) {
    this.honoreeID = honoreeID;
  }

  @DynamoDBAttribute(attributeName = "latitude")
  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  @DynamoDBAttribute(attributeName = "longitude")
  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  @DynamoDBAttribute(attributeName = "streetName")
  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  @DynamoDBAttribute(attributeName = "streetNo")
  public String getStreetNo() {
    return streetNo;
  }

  public void setStreetNo(String streetNo) {
    this.streetNo = streetNo;
  }

  private String category;
  private String ceremonyDate;
  private String honoreeFullName;
  private String honoreeID;
  private String latitude = "0.0";
  private String longitude = "0.0";
  private String streetName;
  private String streetNo;
  private int starID;

  public WOFStars() {}

  public WOFStars(Integer starID, String streetNo, String streetName, String longitude,
      String latitude, String honoreeID, String honoreeFullName, String ceremonyDate,
      String category) {
    this.starID = starID;
    this.streetNo = streetNo;
    this.streetName = streetName;
    this.longitude = longitude;
    this.latitude = latitude;
    this.honoreeID = honoreeID;
    this.honoreeFullName = honoreeFullName;
    this.ceremonyDate = ceremonyDate;
    this.category = category;
  }
  @Override
  public LatLng getPosition() {
    // TODO Auto-generated method stub

    try {
      return new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
    } catch (Exception e) {
      e.printStackTrace();
      return new LatLng(51.50360, -0.14980);
    }

  }
}
