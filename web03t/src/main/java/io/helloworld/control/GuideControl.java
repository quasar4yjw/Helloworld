package io.helloworld.control;

import io.helloworld.domain.Guide;
import io.helloworld.service.GuideService;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("guideControl")
@RequestMapping("/guide")
public class GuideControl {
	static Logger log = Logger.getLogger(GuideControl.class);
	
	  @Autowired GuideService guideService;
	  @Autowired ServletContext servletContext;
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	  public Object add(Guide guide) throws Exception {  
	    
		guideService.signUp(guide);
	    HashMap<String,Object> resultMap = new HashMap<>();
	    resultMap.put("status", "success");
	    return resultMap;
	  }
}
