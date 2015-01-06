package io.helloworld.domain;

import java.io.Serializable;
import java.sql.Time;

public class ItemSchedule implements Serializable{

  private static final long serialVersionUID = 1L;
  
  protected int             itemNo;
  protected int             travelNo;
  protected String          travelDay;
  protected Time            travelTime;
  protected String          travelContent;
  public int getItemNo() {
    return itemNo;
  }
  public void setItemNo(int itemNo) {
    this.itemNo = itemNo;
  }
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
  public String getTravelContent() {
    return travelContent;
  }
  public void setTravelContent(String travelContent) {
    this.travelContent = travelContent;
  }
  @Override
  public String toString() {
    return "ItemSchedule [itemNo=" + itemNo + ", travelNo=" + travelNo
        + ", travelDay=" + travelDay + ", travelTime=" + travelTime
        + ", travelContent=" + travelContent + "]";
  }
  
  
  
}
