package io.helloworld.dao;

import io.helloworld.domain.DetailPhoto;
import io.helloworld.domain.Item;
import io.helloworld.domain.ItemSchedule;

public interface ItemDao {
  
  void insertItem(Item item);
  void insertSchedule(ItemSchedule itemSchedule);
  void insertDetailPhoto(DetailPhoto detailPhoto);
}
