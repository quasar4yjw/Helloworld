package io.helloworld.dao;

import io.helloworld.domain.DetailPhoto;
import io.helloworld.domain.Item;
import io.helloworld.domain.ItemSchedule;

public interface ItemDao {
  
  void insertItem(Item item);
  void insertTag1(Item item);
  void insertTag2(Item item);
  void insertTag3(Item item);
  void insertSchedule(Item item);
  /* void insertDetailPhoto(DetailPhoto detailPhoto);
*/  
}
