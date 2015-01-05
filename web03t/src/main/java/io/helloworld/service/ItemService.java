package io.helloworld.service;

import io.helloworld.dao.ItemDao;
import io.helloworld.domain.DetailPhoto;
import io.helloworld.domain.Item;
import io.helloworld.domain.ItemSchedule;

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
  public void addPlan(Item item, ItemSchedule itemSchedule, DetailPhoto detailPhoto){
    itemDao.insertItem(item);
/*    itemDao.insertSchedule(itemSchedule);
    itemDao.insertDetailPhoto(detailPhoto);*/
  }
  
  
}
