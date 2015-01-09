package io.helloworld.domain;

import java.io.Serializable;


public class Item implements Serializable{
  
  private static final long serialVersionUID = 1L;

  protected int             itemNo;
  protected String          country;
  protected String          language;
  protected String          title;
  protected String          place;
  protected int             price;
  
  protected String          interest1;
  protected String          interest2;
  protected String          interest3;
  
  protected int             travelNo;
  protected int             travelDay;
  protected String          travelTime;
  protected String          travelContent;
  
  protected String          photoUrl;  
  
  
  @Override
  public String toString() {
    return "Item [itemNo=" + itemNo + ", country=" + country + ", language="
        + language + ", title=" + title + ", place=" + place + ", price="
        + price + ", interest1=" + interest1 + ", interest2=" + interest2
        + ", interest3=" + interest3 + ", travelNo=" + travelNo
        + ", travelDay=" + travelDay + ", travelTime=" + travelTime
        + ", travelContent=" + travelContent + ", photoUrl=" + photoUrl + "]";
  }
  public int getItemNo() {
    return itemNo;
  }
  public void setItemNo(int itemNo) {
    this.itemNo = itemNo;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getPlace() {
    return place;
  }
  public void setPlace(String place) {
    this.place = place;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public String getInterest1() {
    return interest1;
  }
  public void setInterest1(String interest1) {
    this.interest1 = interest1;
  }
  public String getInterest2() {
    return interest2;
  }
  public void setInterest2(String interest2) {
    this.interest2 = interest2;
  }
  public String getInterest3() {
    return interest3;
  }
  public void setInterest3(String interest3) {
    this.interest3 = interest3;
  }
  public int getTravelNo() {
    return travelNo;
  }
  public void setTravelNo(int travelNo) {
    this.travelNo = travelNo;
  }
  public int getTravelDay() {
    return travelDay;
  }
  public void setTravelDay(int travelDay) {
    this.travelDay = travelDay;
  }
  public String getTravelTime() {
    return travelTime;
  }
  public void setTravelTime(String travelTime) {
    this.travelTime = travelTime;
  }
  public String getTravelContent() {
    return travelContent;
  }
  public void setTravelContent(String travelContent) {
    this.travelContent = travelContent;
  }
  
  public String getPhotoUrl() {
    return photoUrl;
  }
  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }
 
 

  
  
}
