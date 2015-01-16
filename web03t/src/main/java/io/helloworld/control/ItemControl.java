package io.helloworld.control;

import io.helloworld.service.ItemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller("ItemControl")
@RequestMapping("/item")

public class ItemControl {
	static Logger log = Logger.getLogger(ItemControl.class);
	static final int PAGE_DEFAULT_SIZE = 6;
	@Autowired ItemService itemService;
	@Autowired ServletContext servletContext;

	@RequestMapping(value="/addPlan", method=RequestMethod.POST)
	public Object add(/*Item item,*/ String data/*, ItemSchedule itemSchedule, DetailPhoto detailPhoto*/) throws Exception {

		/*String msg = URLDecoder.decode(data, "utf-8");
		Map<?, ?> dataMap = new Gson().fromJson(msg, new TypeToken<Map<String, String>>() {}.getType());
		System.out.println(dataMap);
		System.out.println(dataMap.size()); //일정하나:11 일정둘:14 */		
		
		itemService.addPlan(data/*, itemSchedule, detailPhoto*/);
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		return resultMap;

	}
	@RequestMapping("/list")
	public Object list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="6") int pageSize) throws Exception {

		if (pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;

		int maxPageNo = itemService.getMaxPageNo(pageSize);

		if (pageNo <= 0) pageNo = 1;
		if (pageNo > maxPageNo) pageNo = maxPageNo;

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("currPageNo", pageNo);
		resultMap.put("maxPageNo", maxPageNo);
	   resultMap.put("items", 
	       itemService.getList(pageNo, pageSize));
	   resultMap.put("tags",itemService.getTag());

		return resultMap;
	}
	@RequestMapping("/view")
	public Object view(String itemNo, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		HashMap itemMap = itemService.get(Integer.parseInt(itemNo));
		List interMap = itemService.getInter(Integer.parseInt(itemNo));
		
		
		
		/*Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++) {
				System.out.println("@@@@___@@@@");
				System.out.println(cookies[i].getValue());
			}
		}*/
		
		
		Cookie cookie = new Cookie("item" + itemNo, itemNo);
		cookie.setMaxAge(60 * 60 * 24);
		//cookie.setMaxAge(0); // 무효화시킴
		response.addCookie(cookie);
	      
		
		//int non = (int)session.getAttribute("view2Page");
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("item", itemMap);
		resultMap.put("inters", interMap);
		/*resultMap.put("photos", datamap.getPhotoList());
		resultMap.put("travels", datamap.getTravelScheduleList());*/
		return resultMap; 
	}

	/* @RequestMapping(value="/addPlanSchedule", method=RequestMethod.POST)
 public Object addSchedule(Item item, ItemSchedule itemSchedule, DetailPhoto detailPhoto) throws Exception {

   itemService.addPlanSchedule(item, itemSchedule, detailPhoto);
   HashMap<String,Object> resultMap = new HashMap<>();
   resultMap.put("status", "success");
   return resultMap;

   }*/

}
