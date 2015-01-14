package io.helloworld.service;

import io.helloworld.dao.ItemDao;
import io.helloworld.domain.Item;

import java.util.HashMap;
import java.util.List;
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
  
  public List<?> getList(int pageNo, int pageSize) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    /*paramMap.put("interest", itemDao.selectTages());*/
    
    return itemDao.selectList(paramMap);
  }
  
  public int getMaxPageNo(int pageSize) {
    int totalSize = itemDao.totalSize();
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
    return maxPageNo;
  }
  
  public Item get(int productNo) {
	    Item item = itemDao.selectOne(productNo);
	    item.setPhotoList( itemDao.selectPhoto(productNo));
	    return item;
	  }
  
/*  @Transactional(
      rollbackFor=Exception.class,
      propagation=Propagation.REQUIRED)
   public void addPlanSchedule(Item item, ItemSchedule itemSchedule, DetailPhoto detailPhoto){
     itemDao.insertSchedule(item);
           itemDao.insertDetailPhoto(detailPhoto);
   }*/
  
  
}
