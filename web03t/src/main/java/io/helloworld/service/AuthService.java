package io.helloworld.service;

import io.helloworld.dao.AuthDao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired 
	AuthDao authDao;

	  public HashMap validate(String loginEmail, String loginPwd) {
		    HashMap<String,String> params = new HashMap<>();
		    params.put("userId", loginEmail);
		    params.put("password", loginPwd);
		    
		    HashMap resultMap = authDao.existUser(params);
		    int guideBool = authDao.areYouGuide(params);
		    int touristBool = authDao.areYouTourist(params);
		    
		    resultMap.put("guideBool", guideBool);
		    resultMap.put("touristBool", touristBool);
		    
		    return resultMap;
		  }
	

}
