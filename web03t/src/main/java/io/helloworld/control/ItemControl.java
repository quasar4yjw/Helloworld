package io.helloworld.control;

import java.util.HashMap;

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


@Controller("ItemControl")
@RequestMapping("/item")

public class ItemControl {
  static Logger log = Logger.getLogger(ItemControl.class);
  
  @Autowired ItemService itemService;
  @Autowired ServletContext servletContext;
  
 @RequestMapping(value="/addPlan", method=RequestMethod.POST)
 public Object add(Item item/*, ItemSchedule itemSchedule, DetailPhoto detailPhoto*/) throws Exception {
   
   itemService.addPlan(item/*, itemSchedule, detailPhoto*/);
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
