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
		    params.put("loginEmail", loginEmail);
		    params.put("loginPwd", loginPwd);
		    
		    HashMap resultMap = new HashMap();
		    long guideBool = 0L;
		    long touristBool = 0L;
		    
		    HashMap existUser = authDao.existUser(params);
		    resultMap.put("existUser", existUser);

		    guideBool = authDao.areYouGuide(params);
		    resultMap.put("guideBool", guideBool);

		    touristBool = authDao.areYouTourist(params);
		    resultMap.put("touristBool", touristBool);
		    
		    return resultMap;
		  }
	

}
