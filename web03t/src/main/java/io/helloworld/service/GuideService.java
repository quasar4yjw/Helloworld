package io.helloworld.service;

import io.helloworld.dao.GuideDao;
import io.helloworld.domain.Guide;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class GuideService {

	@Autowired
	GuideDao guideDao;

	@Transactional(
			rollbackFor=Exception.class, 
			propagation=Propagation.REQUIRED)
	public void signUp(Guide guide) {
		guideDao.insert(guide);
		guideDao.insertSpecial(guide);
		String msg = null;
		try {
			msg = URLDecoder.decode(guide.getGuideLanguageList(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map dataMap = new Gson().fromJson(msg, new TypeToken<Map<String, String>>() {}.getType());

		for(int i = 0; i < dataMap.size(); i++) {
			guide.setGuideLanguage((String)dataMap.get(i+""));
			guideDao.insertLanguage(guide);
		}
	}
	
	
  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRED)
   public void update(Guide guide) {
    guideDao.update(guide);
    guideDao.updateSpecial(guide);
    
    
    String msg = null;
    try {
      msg = URLDecoder.decode(guide.getGuideLanguageList(), "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Map dataMap = new Gson().fromJson(msg, new TypeToken<Map<String, String>>() {}.getType());

    guideDao.updateLanguageToDelete(guide);
    for(int i = 0; i < dataMap.size(); i++) {
      guide.setGuideLanguage((String)dataMap.get(i+""));
      guideDao.updateLanguageToInsert(guide);
    }
    
  }

  


    public HashMap get(String email) {
      HashMap guide = guideDao.select(email);
      return guide;
  }
    
  
  public List getLang(String email) {
    List guideLang = guideDao.selectLang(email);
    return guideLang;
  }

  
  
  
  
  
  
  
  
  
	
	
	
}
