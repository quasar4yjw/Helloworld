package io.helloworld.dao;

import java.util.List;
import java.util.Map;

public interface ConnectDao {
  List<?> selectConnect(Map<String,Object> params);
  int totalSize();

}
