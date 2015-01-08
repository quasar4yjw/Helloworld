package io.helloworld.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Guide implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String             email;
	protected String             userName;
	protected String             tel;
	protected String             password;
	protected Date               birthDate;
	protected int                guideCount;
	protected String             guideLanguageList;
	protected String             guideLanguage;
	protected String             introduce;
	protected String   	      	 photo;
	protected MultipartFile      photofile;
	
	
	@Override
	public String toString() {
		return "Guide [email=" + email + ", userName=" + userName + ", tel="
				+ tel + ", password=" + password + ", birthDate=" + birthDate
				+ ", guideCount=" + guideCount + ", guideLanguageList="
				+ guideLanguageList + ", guideLanguage=" + guideLanguage
				+ ", introduce=" + introduce + ", photo=" + photo
				+ ", photofile=" + photofile + "]";
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public int getGuideCount() {
		return guideCount;
	}


	public void setGuideCount(int guideCount) {
		this.guideCount = guideCount;
	}


	public String getGuideLanguageList() {
		return guideLanguageList;
	}


	public void setGuideLanguageList(String guideLanguageList) {
		this.guideLanguageList = guideLanguageList;
	}


	public String getGuideLanguage() {
		return guideLanguage;
	}


	public void setGuideLanguage(String guideLanguage) {
		this.guideLanguage = guideLanguage;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public MultipartFile getPhotofile() {
		return photofile;
	}


	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}
	
	
	


} 
