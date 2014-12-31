package io.helloworld.control;


import io.helloworld.domain.Tourist;
import io.helloworld.service.TouristService;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller("touristControl")
@RequestMapping("/tourist")
public class TouristControl {
	static Logger log = Logger.getLogger(TouristControl.class);
	
	  @Autowired TouristService touristService;
	  @Autowired ServletContext servletContext;
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	  public Object add(Tourist tourist) throws Exception {  
	    
		touristService.signUp(tourist);
	    HashMap<String,Object> resultMap = new HashMap<>();
	    resultMap.put("status", "success");
	    return resultMap;
	  }
	
	
}
