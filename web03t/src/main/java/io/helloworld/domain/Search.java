package io.helloworld.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class Search implements Serializable{

  private static final long serialVersionUID = 1L;

  
  protected String          country;
  protected Date            startDate;
  protected Date            endDate;
  protected int             minPrice;
  protected int             maxPrice;
  protected String[]        interests;
  
  @Override
  public String toString() {
    return "Search [country=" + country + ", startDate=" + startDate
        + ", endDate=" + endDate + ", minPrice=" + minPrice + ", maxPrice="
        + maxPrice + ", inter=" + Arrays.toString(interests) + "]";
  }
  public String[] getInterests() {
    return interests;
  }
  public void setInterests(String[] interests) {
    this.interests = interests;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getMinPrice() {
    return minPrice;
  }
  public void setMinPrice(int minPrice) {
    this.minPrice = minPrice;
  }
  public int getMaxPrice() {
    return maxPrice;
  }
  public void setMaxPrice(int maxPrice) {
    this.maxPrice = maxPrice;
  }
  
  

}
