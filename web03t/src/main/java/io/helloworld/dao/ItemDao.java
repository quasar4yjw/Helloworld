package io.helloworld.dao;

import java.util.List;
import java.util.Map;

import io.helloworld.domain.DetailPhoto;
import io.helloworld.domain.Item;
import io.helloworld.domain.ItemSchedule;

public interface ItemDao {
  
  void insertItem(Map dataMap);
  void insertTag1(Map dataMap);
  void insertTag2(Map dataMap);
  void insertTag3(Map dataMap);
  void insertSchedule(Map dataMap);
  List<?> selectList(Map<String,Object> params);
  int totalSize();
  Item selectOne(int no);
  List<?> selectPhoto(int productNo);
  /*List<?> selectTags(int No);*/
  /* void insertDetailPhoto(DetailPhoto detailPhoto);
*/  
}
