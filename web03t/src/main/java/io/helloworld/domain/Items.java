package io.helloworld.domain;

import java.io.Serializable;


public class Items implements Serializable{
  
  private static final long serialVersionUID = 1L;

  protected int             itemNo;
  protected String          country;
  protected String          language;
  protected String          place;
  protected int             price;
  
  protected String          interest1;
  protected String          interest2;
  protected String          interest3;
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
  
  @Override
  public String toString() {
    return "Items [itemNo=" + itemNo + ", country=" + country + ", language="
        + language + ", place=" + place + ", price=" + price + ", interest1="
        + interest1 + ", interest2=" + interest2 + ", interest3=" + interest3
        + "]";
  }
  

}
