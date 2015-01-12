package io.helloworld.domain;

import java.io.Serializable;
import java.util.Date;

public class Connect implements Serializable{

  private static final long serialVersionUID = 1L;

  protected int       itemNo;
  protected int       connectNo;
  protected Date      connectStartDate;
  protected Date      connectEndDate;
  protected String    connectStatus;
  protected Date      connectDate;
  
  @Override
  public String toString() {
    return "Connect [itemNo=" + itemNo + ", connectNo=" + connectNo
        + ", connectStartDate=" + connectStartDate + ", connectEndDate="
        + connectEndDate + ", connectStatus=" + connectStatus
        + ", connectDate=" + connectDate + "]";
  }

  public int getItemNo() {
    return itemNo;
  }

  public void setItemNo(int itemNo) {
    this.itemNo = itemNo;
  }

  public int getConnectNo() {
    return connectNo;
  }

  public void setConnectNo(int connectNo) {
    this.connectNo = connectNo;
  }

  public Date getConnectStartDate() {
    return connectStartDate;
  }

  public void setConnectStartDate(Date connectStartDate) {
    this.connectStartDate = connectStartDate;
  }

  public Date getConnectEndDate() {
    return connectEndDate;
  }

  public void setConnectEndDate(Date connectEndDate) {
    this.connectEndDate = connectEndDate;
  }

  public String getConnectStatus() {
    return connectStatus;
  }

  public void setConnectStatus(String connectStatus) {
    this.connectStatus = connectStatus;
  }

  public Date getConnectDate() {
    return connectDate;
  }

  public void setConnectDate(Date connectDate) {
    this.connectDate = connectDate;
  }
  
  
  
  
  
}
