package io.helloworld.dao;

import io.helloworld.domain.Search;

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
  int totalSize(Search search);
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
List selectComments(HashMap<String, Object> paramMap);
Object selectTourDayCount(int itemNo);
List selectDetailPhotos(int itemNo);
void insertComment(HashMap<String, Object> paramMap);  
int commentTotalSize(int itemNo);
List disableDatepicker(int itemNo);  
}
