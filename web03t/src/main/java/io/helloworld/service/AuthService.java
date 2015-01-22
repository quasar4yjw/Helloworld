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
		    long guideBool = 0L;
		    long touristBool = 0L;
		    HashMap resultMap = authDao.existUser(params);
		    
		    if ((Long)authDao.areYouGuide(params) != null){
		    guideBool = (Long)authDao.areYouGuide(params);
		    }
		    if ((Long)authDao.areYouTourist(params) != null) {
		    touristBool = (Long)authDao.areYouTourist(params);
		    }
		    
		    /*resultMap.put("guideBool", "333");
		    resultMap.put("touristBool", "222");*/
		    
		    return resultMap;
		  }
	

}
