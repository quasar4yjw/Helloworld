package io.helloworld.service;

import io.helloworld.dao.ItemDao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
  
  @Autowired
  ItemDao itemDao;
  
  
  @Transactional(
     rollbackFor=Exception.class,
     propagation=Propagation.REQUIRED)
  public void addPlan(Map dataMap/*, ItemSchedule itemSchedule, DetailPhoto detailPhoto*/){
    itemDao.insertItem(dataMap);
    itemDao.insertTag1(dataMap);
    itemDao.insertTag2(dataMap);
    itemDao.insertTag3(dataMap);
    int j = (dataMap.size() - 8) / 3;
     for(int i = 1; i <= j; i++) {
       System.out.println(i + "@_@_@_@");
       dataMap.put("travelDay", dataMap.get("travelDay" + i));
       dataMap.put("travelTime", dataMap.get("travelTime" + i));
       dataMap.put("travelContent", dataMap.get("travelContent" + i));
       itemDao.insertSchedule(dataMap);
     }
       /*   itemDao.insertDetailPhoto(detailPhoto);*/
  }
  
/*  @Transactional(
      rollbackFor=Exception.class,
      propagation=Propagation.REQUIRED)
   public void addPlanSchedule(Item item, ItemSchedule itemSchedule, DetailPhoto detailPhoto){
     itemDao.insertSchedule(item);
           itemDao.insertDetailPhoto(detailPhoto);
   }*/
  
  
}
