package io.helloworld.service;

import io.helloworld.dao.ItemDao;
import io.helloworld.domain.Item;

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
  public void addPlan(Item item/*, ItemSchedule itemSchedule, DetailPhoto detailPhoto*/){
    if(item.getTitle() != null){
    itemDao.insertItem(item);
    itemDao.insertTag1(item);
    itemDao.insertTag2(item);
    itemDao.insertTag3(item);
   }
   if(item.getTravelContent() != null){
    itemDao.insertSchedule(item);
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
