package io.helloworld.service;

import io.helloworld.dao.ConnectDao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConnectService {
  
  @Autowired 
  ConnectDao connectDao;
  
  @Transactional(
      rollbackFor=Exception.class,
      propagation=Propagation.REQUIRED)
  
  /*public void status(Connect connect) {*/
  
  public List<?> getList(int pageNo, int pageSize) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    /*paramMap.put("interest", itemDao.selectTages());*/
    
    return connectDao.selectConnect(paramMap);
  }
  
  public int getMaxPageNo(int pageSize) {
    int totalSize = connectDao.totalSize();
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
    return maxPageNo;
  }
  
  

}
