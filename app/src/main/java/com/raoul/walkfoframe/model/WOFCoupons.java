package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.google.android.gms.maps.model.LatLng;
import com.raoul.walkfoframe.maputtiliy.clustering.ClusterItem;

@DynamoDBTable(tableName = "WOFCoupons")
public class WOFCoupons implements ClusterItem {

  @DynamoDBAttribute(attributeName = "specialAddress")
  public String getSpecialAddress() {
    return specialAddress;
  }

  public void setSpecialAddress(String specialAddress) {
    this.specialAddress = specialAddress;
  }
  
  @DynamoDBAttribute(attributeName = "CouponLogo")
  public String getCouponLogo() {
    return couponLogo;
  }

  public void setCouponLogo(String CouponLogo) {
    this.couponLogo = CouponLogo;
  }
  
  @DynamoDBAttribute(attributeName = "CouponCatID")
  public int getCouponCatID() {
    return couponCategoryId;
  }

  public void setCouponCatID(int CouponCatID) {
    this.couponCategoryId = CouponCatID;
  }

  @DynamoDBHashKey(attributeName = "couponID")
  public int getCouponID() {
    return couponID;
  }

  public void setCouponID(int couponID) {
    this.couponID = couponID;
  }

  @DynamoDBAttribute(attributeName = "specialDescription")
  public String getSpecialDescription() {
    return specialDescription;
  }

  public void setSpecialDescription(String specialDescription) {
    this.specialDescription = specialDescription;
  }

  @DynamoDBAttribute(attributeName = "specialMessage")
  public String getSpecialMessage() {
    return specialMessage;
  }

  public void setSpecialMessage(String specialMessage) {
    this.specialMessage = specialMessage;
  }

  @DynamoDBAttribute(attributeName = "specialIsEnabled")
  public int getSpecialIsEnabled() {
    return specialIsEnabled;
  }

  public void setSpecialIsEnabled(int specialIsEnabled) {
    this.specialIsEnabled = specialIsEnabled;
  }

  @DynamoDBAttribute(attributeName = "specialProvider")
  public String getSpecialProvider() {
    return specialProvider;
  }

  public void setSpecialProvider(String specialProvider) {
    this.specialProvider = specialProvider;
  }

  @DynamoDBAttribute(attributeName = "specialRedemption")
  public String getSpecialRedemption() {
    return specialRedemption;
  }

  public void setSpecialRedemption(String specialRedemption) {
    this.specialRedemption = specialRedemption;
  }

  @DynamoDBAttribute(attributeName = "specialRevealCode")
  public String getSpecialRevealCode() {
    return specialRevealCode;
  }

  public void setSpecialRevealCode(String specialRevealCode) {
    this.specialRevealCode = specialRevealCode;
  }

  @DynamoDBAttribute(attributeName = "specialTitle")
  public String getSpecialTitle() {
    return specialTitle;
  }

  public void setSpecialTitle(String specialTitle) {
    this.specialTitle = specialTitle;
  }

  @DynamoDBAttribute(attributeName = "specialVenueID")
  public String getSpecialVenueID() {
    return specialVenueID;
  }

  public void setSpecialVenueID(String specialVenueID) {
    this.specialVenueID = specialVenueID;
  }

  @DynamoDBAttribute(attributeName = "specialType")
  public String getSpecialType() {
    return specialType;
  }

  public void setSpecialType(String specialType) {
    this.specialType = specialType;
  }

  @DynamoDBAttribute(attributeName = "venueLongitude")
  public double getVenueLongitude() {
    return venueLongitude;
  }

  public void setVenueLongitude(double venueLongitude) {
    this.venueLongitude = venueLongitude;
  }

  @DynamoDBAttribute(attributeName = "venueLatitude")
  public double getVenueLatitude() {
    return venueLatitude;
  }

  public void setVenueLatitude(double venueLatitude) {
    this.venueLatitude = venueLatitude;
  }

  @DynamoDBAttribute(attributeName = "venueName")
  public String getVenueName() {
    return venueName;
  }

  public void setVenueName(String venueName) {
    this.venueName = venueName;
  }

  private int couponID;

  @Override
  public String toString() {
    return "WOFCoupons [couponID=" + couponID + ", specialDescription=" + specialDescription
        + ", specialMessage=" + specialMessage + ", specialIsEnabled=" + specialIsEnabled
        + ", specialProvider=" + specialProvider + ", specialRedemption=" + specialRedemption
        + ", specialRevealCode=" + specialRevealCode + ", specialTitle=" + specialTitle
        + ", specialVenueID=" + specialVenueID + ", specialType=" + specialType
        + ", venueLongitude=" + venueLongitude + ", venueLatitude=" + venueLatitude
        + ", venueName=" + venueName + ", specialAddress=" + specialAddress + "]";
  }

  private String specialDescription;
  private String specialMessage;
  private int specialIsEnabled;
  private String specialProvider;
  private String specialRedemption;
  private String specialRevealCode;
  private String specialTitle;
  private String specialVenueID;
  private String specialType;
  private double venueLongitude;
  private double venueLatitude;
  private String venueName;
  private String specialAddress;
  private int couponCategoryId;
  private String couponLogo;
  
  public WOFCoupons() {}

  public WOFCoupons(int CouponCatID, int couponID, Double venueLongitude, Double venueLatitude,
      String specialDescription, String specialMessage, String specialProvider,
      String specialRedemption, String specialTitle, String specialVenueID, String specialType,
      String venueName, String specialAddress, String couponLogo) {
	  this.couponCategoryId = CouponCatID;
    this.couponID = couponID;
    this.venueLongitude = venueLongitude;
    this.venueLatitude = venueLatitude;
    this.specialDescription = specialDescription;
    this.specialMessage = specialMessage;
    this.specialProvider = specialProvider;
    this.specialRedemption = specialRedemption;
    this.specialTitle = specialTitle;
    this.specialVenueID = specialVenueID;
    this.specialType = specialType;
    this.venueName = venueName;
    this.specialAddress = specialAddress;
    this.couponLogo = couponLogo;
  }

  @Override
  public LatLng getPosition() {
    // TODO Auto-generated method stub
    return new LatLng(getVenueLatitude(), getVenueLongitude());
  }
}
