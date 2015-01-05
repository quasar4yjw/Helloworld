package io.helloworld.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class DetailPhoto implements Serializable{

  private static final long serialVersionUID = 1L;
  
  protected int             detailPhotoNo;
  protected String          photoUrl;
  protected MultipartFile   photofile;
  public int getDetailPhotoNo() {
    return detailPhotoNo;
  }
  public void setDetailPhotoNo(int detailPhotoNo) {
    this.detailPhotoNo = detailPhotoNo;
  }
  public String getPhotoUrl() {
    return photoUrl;
  }
  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }
  public MultipartFile getPhotofile() {
    return photofile;
  }
  public void setPhotofile(MultipartFile photofile) {
    this.photofile = photofile;
  }
  @Override
  public String toString() {
    return "DetailPhoto [detailPhotoNo=" + detailPhotoNo + ", photoUrl="
        + photoUrl + "]";
  }

  
  
}
