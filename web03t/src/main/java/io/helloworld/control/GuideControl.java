package io.helloworld.control;

import io.helloworld.domain.Guide;
import io.helloworld.service.GuideService;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller("guideControl")
@RequestMapping("/guide")
public class GuideControl {
	static Logger log = Logger.getLogger(GuideControl.class);
	
	  @Autowired GuideService guideService;
	  @Autowired ServletContext servletContext;
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	  public Object add(Guide guide, MultipartFile photofile) throws Exception {  
		if (photofile != null
		        && !photofile.isEmpty()) {

		      String fileuploadRealPath = 
		        servletContext.getRealPath("/fileupload");
		      String filename = System.currentTimeMillis() + "_";
		      //String filename = new String(photofile.getOriginalFilename().getBytes("8859_1"),"utf-8");
		      File file = new File(fileuploadRealPath + "/" + filename);
		    
		      photofile.transferTo(file);
		      guide.setPhoto(filename);
		}
		guideService.signUp(guide);
		
	    HashMap<String,Object> resultMap = new HashMap<>();
	    try{
		    resultMap.put("status", "success");
		    return resultMap;
	    } catch(Exception ex){
	    	return resultMap;
	    }
	  }
	
	
	@RequestMapping("/update")
  public Object update(Guide guide, MultipartFile photofile) throws Exception {

	  if (photofile != null
        && !photofile.isEmpty()) {
/*
	    if(photofile.delete()){
        System.out.println(photofile.getName() + " is deleted!");
      }else{
        System.out.println("Delete operation is failed.");
      }*/
	      
	    
      String fileuploadRealPath = 
        servletContext.getRealPath("/fileupload");
      String filename = System.currentTimeMillis() + "_";
      //String filename = new String(photofile.getOriginalFilename().getBytes("8859_1"),"utf-8");
      File file = new File(fileuploadRealPath + "/" + filename);
    
      photofile.transferTo(file);
      guide.setPhoto(filename);
}
	  
	  
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    guideService.update(guide);
    return resultMap;
  }
  
  @RequestMapping("/view")
  public Object view(String email) throws Exception {
    HashMap guide = guideService.get(email);
    List guideLang = guideService.getLang(email);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("guide", guide);
    resultMap.put("guideLang", guideLang);
    return resultMap;
  }
	
	
	
	
	
}
