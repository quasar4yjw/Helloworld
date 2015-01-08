package io.helloworld.control;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import io.helloworld.domain.DetailPhoto;
import io.helloworld.domain.Item;
import io.helloworld.domain.ItemSchedule;
import io.helloworld.service.ItemService;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@Controller("ItemControl")
@RequestMapping("/item")

public class ItemControl {
  static Logger log = Logger.getLogger(ItemControl.class);
  
  @Autowired ItemService itemService;
  @Autowired ServletContext servletContext;
  
 @RequestMapping(value="/addPlan", method=RequestMethod.POST)
 public Object add(Item item, String data/*, ItemSchedule itemSchedule, DetailPhoto detailPhoto*/) throws Exception {
   
   String msg = URLDecoder.decode(data, "utf-8");
   Map<?, ?> dataMap = new Gson().fromJson(msg, new TypeToken<Map<String, String>>() {}.getType());
   System.out.println(dataMap);
   System.out.println(dataMap.size()); //일정하나:11 일정둘:14
   itemService.addPlan(dataMap/*, itemSchedule, detailPhoto*/);
   HashMap<String,Object> resultMap = new HashMap<>();
   resultMap.put("status", "success");
   return resultMap;
   
   }
 
/* @RequestMapping(value="/addPlanSchedule", method=RequestMethod.POST)
 public Object addSchedule(Item item, ItemSchedule itemSchedule, DetailPhoto detailPhoto) throws Exception {
   
   itemService.addPlanSchedule(item, itemSchedule, detailPhoto);
   HashMap<String,Object> resultMap = new HashMap<>();
   resultMap.put("status", "success");
   return resultMap;
   
   }*/
  
}
