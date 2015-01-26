package io.helloworld.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Connect implements Serializable{

  private static final long serialVersionUID = 1L;

  protected int       itemNo;
  protected int       connectNo;
  protected Date      connectStartDate;
  protected Date      connectEndDate;
  protected String    connectStatus;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  protected String    connectDate;
  
  protected String    buttonType;
  protected String    guideEmail;
  protected String    touristEmail;
  

  
	  @Override
	public String toString() {
		return "Connect [itemNo=" + itemNo + ", connectNo=" + connectNo
				+ ", connectStartDate=" + connectStartDate + ", connectEndDate="
				+ connectEndDate + ", connectStatus=" + connectStatus
				+ ", connectDate=" + connectDate + ", buttonType=" + buttonType
				+ ", guideEmail=" + guideEmail + ", touristEmail=" + touristEmail
				+ "]";
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
  public String getConnectDate() {
    return connectDate;
  }
  public void setConnectDate(String connectDate) {
    this.connectDate = connectDate;
  }
  public String getButtonType() {
    return buttonType;
  }
  public void setButtonType(String buttonType) {
    this.buttonType = buttonType;
  }



	public String getGuideEmail() {
		return guideEmail;
	}
	public void setGuideEmail(String guideEmail) {
		this.guideEmail = guideEmail;
	}
	public String getTouristEmail() {
		return touristEmail;
	}
	public void setTouristEmail(String touristEmail) {
		this.touristEmail = touristEmail;
	}
	  
  
 
  
}
