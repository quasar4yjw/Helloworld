package io.helloworld.control;

import io.helloworld.service.ConnectService;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("connectControl")
@RequestMapping("/connect")

public class ConnectControl {
  static Logger log = Logger.getLogger(ConnectControl.class);
  static final int PAGE_DEFAULT_SIZE = 6;
  @Autowired ConnectService connectService;
  @Autowired ServletContext servletcontext;
  
  
  @RequestMapping("/status")
  public Object progress(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="6") int pageSize,
      @RequestParam(defaultValue="all") String selected) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int maxPageNo = connectService.getMaxPageNo(pageSize, selected);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("currPageNo", pageNo);
    resultMap.put("maxPageNo", maxPageNo);
    resultMap.put("connects", 
          connectService.getList(pageNo, pageSize, selected));
    
      
    return resultMap;
  }

  
}


