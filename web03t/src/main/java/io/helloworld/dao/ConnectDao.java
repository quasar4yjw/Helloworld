package io.helloworld.dao;

import io.helloworld.domain.Connect;

import java.util.List;
import java.util.Map;

public interface ConnectDao {
  List<?> selectConnect(Map<String,Object> params);
  int totalSize(Map<String,Object> params);
  void update(Connect connect);

}
