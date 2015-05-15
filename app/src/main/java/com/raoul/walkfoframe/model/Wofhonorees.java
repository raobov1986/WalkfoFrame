package com.raoul.walkfoframe.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "WOFHonorees")
public class Wofhonorees {

  public Wofhonorees() {}

  public Wofhonorees(Wofhonorees honorees) {
    this.honorees = honorees;
  }


  public Wofhonorees(int honoreeID, String bioThumbnail, String biography, String birthCity,
      String birthCountry, String birthDate, String createdTimeStamp, String deathCity,
      String deathState, String education, String ethnicity, String inductionDate, String fullName,
      String nameFullFirst, String nameFullFirstLetter, String nameFullLast) {
    this.honoreeID = honoreeID;
    this.bioThumbnail = bioThumbnail;
    this.biography = biography;
    this.birthCity = birthCity;
    this.birthCountry = birthCountry;
    this.birthDate = birthDate;
    this.createdTimeStamp = createdTimeStamp;
    this.deathCity = deathCity;
    this.deathState = deathState;
    this.education = education;
    this.ethnicity = ethnicity;
    this.inductionDate = inductionDate;
    this.fullName = fullName;
    this.nameFullFirst = nameFullFirst;
    this.nameFullFirstLetter = nameFullFirstLetter;
    this.nameFullLast = nameFullLast;
  }

  @DynamoDBHashKey(attributeName = "honoreeID")
  public int getHonoreeID() {
    return honoreeID;
  }

  public void setHonoreeID(int honoreeID) {
    this.honoreeID = honoreeID;
  }

  @DynamoDBAttribute(attributeName = "bioThumbnail")
  public String getBioThumbnail() {
    return bioThumbnail;
  }

  public void setBioThumbnail(String bioThumbnail) {
    this.bioThumbnail = bioThumbnail;
  }

  @DynamoDBAttribute(attributeName = "biography")
  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  @DynamoDBAttribute(attributeName = "birthCity")
  public String getBirthCity() {
    return birthCity;
  }

  public void setBirthCity(String birthCity) {
    this.birthCity = birthCity;
  }

  @DynamoDBAttribute(attributeName = "birthCountry")
  public String getBirthCountry() {
    return birthCountry;
  }

  public void setBirthCountry(String birthCountry) {
    this.birthCountry = birthCountry;
  }

  @DynamoDBAttribute(attributeName = "birthDate")
  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @DynamoDBAttribute(attributeName = "createdTimeStamp")
  public String getCreatedTimeStamp() {
    return createdTimeStamp;
  }

  public void setCreatedTimeStamp(String createdTimeStamp) {
    this.createdTimeStamp = createdTimeStamp;
  }

  @DynamoDBAttribute(attributeName = "cutoutImage")
  public String getCutoutImage() {
    return cutoutImage;
  }

  public void setCutoutImage(String cutoutImage) {
    this.cutoutImage = cutoutImage;
  }

  @DynamoDBAttribute(attributeName = "deathCity")
  public String getDeathCity() {
    return deathCity;
  }

  public void setDeathCity(String deathCity) {
    this.deathCity = deathCity;
  }

  @DynamoDBAttribute(attributeName = "deathDate")
  public String getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(String deathDate) {
    this.deathDate = deathDate;
  }

  @DynamoDBAttribute(attributeName = "deathState")
  public String getDeathState() {
    return deathState;
  }

  public void setDeathState(String deathState) {
    this.deathState = deathState;
  }

  @DynamoDBAttribute(attributeName = "education")
  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  @DynamoDBAttribute(attributeName = "ethnicity")
  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }

  @DynamoDBAttribute(attributeName = "fullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @DynamoDBAttribute(attributeName = "inductionDate")
  public String getInductionDate() {
    return inductionDate;
  }

  public void setInductionDate(String inductionDate) {
    this.inductionDate = inductionDate;
  }

  @DynamoDBAttribute(attributeName = "nameFullFirst")
  public String getNameFullFirst() {
    return nameFullFirst;
  }

  public void setNameFullFirst(String nameFullFirst) {
    this.nameFullFirst = nameFullFirst;
  }

  @DynamoDBAttribute(attributeName = "nameFullFirstLetter")
  public String getNameFullFirstLetter() {
    return nameFullFirstLetter;
  }

  public void setNameFullFirstLetter(String nameFullFirstLetter) {
    this.nameFullFirstLetter = nameFullFirstLetter;
  }

  @DynamoDBAttribute(attributeName = "nameFullLast")
  public String getNameFullLast() {
    return nameFullLast;
  }

  public void setNameFullLast(String nameFullLast) {
    this.nameFullLast = nameFullLast;
  }

  private int honoreeID;;
  private String bioThumbnail;
  private String biography;
  private String birthCity;
  private String birthCountry;
  private String birthDate;
  private String createdTimeStamp;
  private String cutoutImage;
  private String deathCity;
  private String deathDate;
  private String deathState;
  private String education;
  private String ethnicity;
  private String fullName;
  private String inductionDate;
  private String nameFullFirst;
  private String nameFullFirstLetter;
  private String nameFullLast;
  private Wofhonorees honorees;

  public WOFStars getWhostar() {
    return whostar;
  }

  public void setWhostar(WOFStars whostar) {
    this.whostar = whostar;
  }

  private WOFStars whostar;

  public Wofhonorees getHonorees() {
    return honorees;
  }

  public void setHonorees(Wofhonorees honorees) {
    this.honorees = honorees;
  }

}
