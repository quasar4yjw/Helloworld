package io.helloworld.service;

import io.helloworld.dao.ItemDao;
import io.helloworld.dao.TagDao;
import io.helloworld.domain.Search;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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
public class ItemService {

	@Autowired
	ItemDao itemDao;
	@Autowired
  TagDao tagDao;


	@Transactional(
			rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void addPlan(String data/*, ItemSchedule itemSchedule, DetailPhoto detailPhoto*/){
		String msg = null;
		try {
			msg = URLDecoder.decode(data, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map dataMap = new Gson().fromJson(msg, new TypeToken<Map<String, String>>() {}.getType());
		System.out.println(dataMap);
		System.out.println(dataMap.size()); //일정하나:11 일정둘:14
		
		itemDao.insertItem(dataMap);
		itemDao.insertTag1(dataMap);
		itemDao.insertTag2(dataMap);
		itemDao.insertTag3(dataMap);
		int j = (dataMap.size() - 8) / 3;
		for(int i = 1; i <= j; i++) {
			System.out.println(i + "@_@_@_@");
			dataMap.put("travelDay", dataMap.get("travelDay" + i));
			dataMap.put("travelTime", dataMap.get("travelTime" + i));
			dataMap.put("travelContent", dataMap.get("travelContent" + i));
			itemDao.insertSchedule(dataMap);
		}
		/*   itemDao.insertDetailPhoto(detailPhoto);*/
	}

	public List<?> getList(int pageNo, int pageSize, Search search) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    paramMap.put("country",search.getCountry());
    paramMap.put("startDate",search.getStartDate());
    paramMap.put("endDate",search.getEndDate());
    paramMap.put("minPrice",search.getMinPrice());
    paramMap.put("maxPrice",search.getMaxPrice());
    
    if (search.getInterests() != null && search.getInterests().length > 0) {
      String interests = "";
      for (String interest : search.getInterests()) {
        if (interests.length() > 0)
          interests += ",";
        interests += "'" + interest + "'";
      }
      paramMap.put("interests",interests);
      System.out.println(paramMap.get("interests"));
    }
    
    //paramMap.put("interests",search.getInterests());
    /*paramMap.put("interest", itemDao.selectTages());*/

    return itemDao.selectList(paramMap);
  }
	public List<?> getTag() {

    return tagDao.selectInter();
  }

	public int getMaxPageNo(int pageSize, Search search) {
    int totalSize = itemDao.totalSize(search);
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;

    return maxPageNo;
  }

	public HashMap get(int itemNo) {
		HashMap datamap = itemDao.selectOne(itemNo);
		//item.setPhotoList( itemDao.selectPhoto(itemNo));
		//item.setTravelScheduleList( itemDao.selectTravelSchedule(itemNo));
		return datamap;
	}
	public List getInter(int itemNo) {
		List datamaps = itemDao.selectInters(itemNo);
		return datamaps;
	}
	public List getSchedule(int itemNo) {
		List datamaps = itemDao.selectSchedules(itemNo);
		return datamaps;
	}
	public HashMap getGuideInfo(int itemNo) {
		HashMap datamap = itemDao.selectGuideOfItem(itemNo);
		return datamap;
	}
	public List getComment(int itemNo, int pageNo, int pageSize) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		paramMap.put("itemNo", itemNo);
		List datamaps = itemDao.selectComments(paramMap);
		return datamaps;
	}

	public int getTourDayCount(int itemNo) {
		int count = 1;
		if ((Integer)itemDao.selectTourDayCount(itemNo) != null) 
		count = (Integer)itemDao.selectTourDayCount(itemNo);
		return count;
	}

  public HashMap getRecently(int itemNo) {
    HashMap datamap = itemDao.selectRecently(itemNo);
    return datamap;
  }

	public List getDetailPhoto(int itemNo) {
		List datamaps = itemDao.selectDetailPhotos(itemNo);
		return datamaps;
	}
	

	/*  @Transactional(
      rollbackFor=Exception.class,
      propagation=Propagation.REQUIRED)
   public void addPlanSchedule(Item item, ItemSchedule itemSchedule, DetailPhoto detailPhoto){
     itemDao.insertSchedule(item);
           itemDao.insertDetailPhoto(detailPhoto);
   }*/

	
	@Transactional(
			rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void addComment(int connectNo, int selectScore, String inputComment, String currentDate){
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("connectNo", connectNo);
		paramMap.put("selectScore", selectScore);
		paramMap.put("inputComment", inputComment);
		paramMap.put("currentDate", currentDate);
		itemDao.insertComment(paramMap);
		/*   itemDao.insertDetailPhoto(detailPhoto);*/
	}
	
	
	public int getCommentMaxPageNo(int pageSize, int itemNo) {
		int totalSize = itemDao.commentTotalSize(itemNo);
		int maxPageNo = totalSize / pageSize;
		if ((totalSize % pageSize) > 0) maxPageNo++;

		return maxPageNo;
	}

	public List getDisableDate(int itemNo) {
		return itemDao.disableDatepicker(itemNo);
		
	}

}
