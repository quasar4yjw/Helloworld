package io.helloworld.domain;

import java.io.Serializable;
import java.util.Date;

public class Tourist implements Serializable{
	private static final long serialVersionUID = 1L;
	  protected String             email;
	  protected String         	   userName;
	  protected String             tel;
	  protected String             password;
	  protected Date               birthDate;
	  protected int                gender;
	  
	  
	@Override
	public String toString() {
		return "Tourist [email=" + email + ", userName=" + userName + ", tel="
				+ tel + ", password=" + password + ", birthDate=" + birthDate
				+ ", gender=" + gender + "]";
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	  
	  
} 
