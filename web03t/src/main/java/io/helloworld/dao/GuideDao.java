package io.helloworld.dao;

import io.helloworld.domain.Guide;

import java.util.HashMap;
import java.util.List;


public interface GuideDao {
	void insert(Guide guide);
	void insertSpecial(Guide guide);
	void insertLanguage(Guide guide);
  void update(Guide guide);
  void updateSpecial(Guide guide);
  void updateLanguageToDelete(Guide guide);
  void updateLanguageToInsert(Guide guide);
  HashMap select(String email);
  List selectLang(String email);

}
