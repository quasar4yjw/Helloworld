package io.helloworld.control;

import io.helloworld.service.AuthService;
import io.helloworld.service.MessageService;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("messageControl") 
@RequestMapping("/i18n") 
public class MessageControl {
	@Autowired MessageService messageService;
	
	
	  @RequestMapping(value="/selectJoinForm", method=RequestMethod.POST)
	  public Object loginUser(HttpSession session, HttpServletRequest request) throws Exception {
	    HashMap<String,Object> resultMap = new HashMap<>();
	    
	      resultMap.put("message", messageService.getSelectJoinForm(request));
	      resultMap.put("status", "success");
	      resultMap.put("selectJoinForm", session.getAttribute("loginUser"));
	    
	    return resultMap;
	  }
	 
}
