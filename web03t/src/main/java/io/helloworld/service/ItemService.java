package io.helloworld.service;

import io.helloworld.dao.ItemDao;
import io.helloworld.dao.TagDao;

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

	public List<?> getList(int pageNo, int pageSize) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		/*paramMap.put("interest", itemDao.selectTages());*/

		return itemDao.selectList(paramMap);
	}
	public List<?> getTag() {

    return tagDao.selectInter();
  }

	public int getMaxPageNo(int pageSize) {
		int totalSize = itemDao.totalSize();
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
		//item.setPhotoList( itemDao.selectPhoto(itemNo));
		//item.setTravelScheduleList( itemDao.selectTravelSchedule(itemNo));
		return datamaps;
	}

	/*  @Transactional(
      rollbackFor=Exception.class,
      propagation=Propagation.REQUIRED)
   public void addPlanSchedule(Item item, ItemSchedule itemSchedule, DetailPhoto detailPhoto){
     itemDao.insertSchedule(item);
           itemDao.insertDetailPhoto(detailPhoto);
   }*/


}
