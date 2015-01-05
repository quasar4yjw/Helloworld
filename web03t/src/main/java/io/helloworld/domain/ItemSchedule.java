package io.helloworld.domain;

import java.io.Serializable;
import java.sql.Time;

public class ItemSchedule implements Serializable{

  private static final long serialVersionUID = 1L;
  
  protected int             travelNo;
  protected String          travelDay;
  protected Time            travelTime;
  protected String          Content;
  
  public int getTravelNo() {
    return travelNo;
  }
  public void setTravelNo(int travelNo) {
    this.travelNo = travelNo;
  }
  public String getTravelDay() {
    return travelDay;
  }
  public void setTravelDay(String travelDay) {
    this.travelDay = travelDay;
  }
  public Time getTravelTime() {
    return travelTime;
  }
  public void setTravelTime(Time travelTime) {
    this.travelTime = travelTime;
  }
  public String getContent() {
    return Content;
  }
  public void setContent(String content) {
    Content = content;
  }
  
  @Override
  public String toString() {
    return "ItemSchedule [travelNo=" + travelNo + ", travelDay=" + travelDay
        + ", travelTime=" + travelTime + ", Content=" + Content + "]";
  }
  
  

}
