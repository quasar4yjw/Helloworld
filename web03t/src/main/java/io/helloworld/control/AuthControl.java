package io.helloworld.control;

import io.helloworld.service.AuthService;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("authControl") 
@RequestMapping("/auth") 
public class AuthControl {
	@Autowired AuthService authService;
	
	
	  @RequestMapping(value="/loginUser", method=RequestMethod.GET)
	  public Object loginUser(HttpSession session) throws Exception {
	    HashMap<String,Object> resultMap = new HashMap<>();
	    
	    if (session.getAttribute("loginUser") != null) {
	      resultMap.put("status", "success");
	      resultMap.put("loginUser", session.getAttribute("loginUser"));
	    } else {
	      resultMap.put("status", "fail");
	    }
	    
	    return resultMap;
	  }
	

	 @RequestMapping(value="/login", method=RequestMethod.POST)
	  public Object login(
	      String loginEmail, 
	      String loginPwd, 
	      String requestUrl, /* 세션에 저장된 값을 달라고 하려면?*/
	      HttpServletResponse response,
	      HttpSession session) throws Exception {

	    HashMap validateMap = authService.validate(loginEmail, loginPwd);
	    
	    HashMap<String,Object> resultMap = new HashMap<>();
	    
	    if (validateMap != null) {
	      resultMap.put("status", "success");
	      session.setAttribute("loginUser", validateMap);
	    } else {
	      session.invalidate();
	      resultMap.put("status", "fail");
	    }
	    
	    return resultMap;
	  }
}
