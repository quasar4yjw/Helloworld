package io.helloworld.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ItemDao {
  
  void insertItem(Map dataMap);
  void insertTag1(Map dataMap);
  void insertTag2(Map dataMap);
  void insertTag3(Map dataMap);
  void insertSchedule(Map dataMap);
  List<?> selectList(Map<String,Object> params);
  int totalSize();
  HashMap selectOne(int itemNo);
  List selectInters(int itemNo);
  List selectSchedules(int itemNo);
  List<?> selectPhoto(int itemNo);
  List<?> selectTravelSchedule(int itemNo);
  /*List<?> selectTags(int No);*/
  /* void insertDetailPhoto(DetailPhoto detailPhoto);
*/
  HashMap selectRecently(int itemNo);
HashMap selectGuideOfItem(int itemNo);
List selectComments(int itemNo);
int selectTourDayCount(int itemNo);
List selectDetailPhotos(int itemNo);  
}
