package io.helloworld.control;

import io.helloworld.domain.Search;
import io.helloworld.service.ItemService;

import java.util.Enumeration;
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
      @RequestParam(defaultValue="6") int pageSize,
      Search search,
      HttpServletRequest request) throws Exception {
    HashMap itemMap = new HashMap();
    
    

    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;

    int maxPageNo = itemService.getMaxPageNo(pageSize, search);
    
    if (pageNo <= 0) pageNo = 1;
    if (maxPageNo!=0 && pageNo > maxPageNo) pageNo = maxPageNo;

    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("currPageNo", pageNo);
    resultMap.put("maxPageNo", maxPageNo);
    resultMap.put("items", 
         itemService.getList(pageNo, pageSize,search));
     resultMap.put("tags",itemService.getTag());

     Cookie[] cookies = request.getCookies();
     
     //cookies[i].getValue() =  값을 출력,
     //cookies[i].getName() = 키(값의 키값)을 출력. 
     if(cookies != null){
       int length = cookies.length > 4 ? 3: (cookies.length-1);
       //쿠키의 크기가 4보다크면 반복문을 3번 반복하고 아니면 크기에서 1뺀값으로 한다.
       //쿠키의 마지막 값이 itemNo가 아니기 때문이다.

       for(int count = 0; count < length; count++) {
         int i = cookies.length - 2 - count;
           //i의 값은 가장 최근에 들어간 사이트부터 출력을 해야 하기 때문에 이 공식을 사용하였다.
         itemMap = itemService.getRecently(Integer.parseInt(cookies[i].getValue()));
         resultMap.put("item"+count, itemMap);
       }
     }
    return resultMap;
  }
	@RequestMapping("/view")
	public Object view(
			String itemNo, 
			HttpSession session, 
			HttpServletResponse response, 
			HttpServletRequest request) throws Exception {
		
			   for (Enumeration e = request.getLocales(); e.hasMoreElements();){
				   System.out.println("========@@@@@@@@=========");
			       System.out.println(e.nextElement());
			       System.out.println("========@@@@@@@@=========");
			   }
		
			HashMap itemMap = itemService.get(Integer.parseInt(itemNo));
			List interMaps = itemService.getInter(Integer.parseInt(itemNo));
			List scheduleMaps = itemService.getSchedule(Integer.parseInt(itemNo));
			HashMap guideMap = itemService.getGuideInfo(Integer.parseInt(itemNo));
			int tourDayCount = itemService.getTourDayCount(Integer.parseInt(itemNo));
			List photoMaps = itemService.getDetailPhoto(Integer.parseInt(itemNo));
			List disableDates = itemService.getDisableDate(Integer.parseInt(itemNo));
			
			/*Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(int i = 0; i < cookies.length; i++) {
					System.out.println("@@@@___@@@@");
					System.out.println(cookies[i].getValue());
					System.out.println(cookies[i].getName()); // 끝 쿠키 JSESSIONID
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
			resultMap.put("inters", interMaps);
			resultMap.put("itemSchedules", scheduleMaps);
			resultMap.put("guideInfo", guideMap);
			resultMap.put("tourDayCount", tourDayCount);
			resultMap.put("photoList", photoMaps);
			resultMap.put("disableDates", disableDates);
			/*resultMap.put("photos", datamap.getPhotoList());
			resultMap.put("travels", datamap.getTravelScheduleList());*/
			return resultMap; 
	}
	
	
	@RequestMapping("/viewComment")
	public Object viewComment(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="6") int pageSize,
			String itemNo, 
			HttpSession session, 
			HttpServletResponse response, 
			HttpServletRequest request) throws Exception {
		
			if (pageSize <= 0) pageSize = PAGE_DEFAULT_SIZE;
		    
		    int maxPageNo = itemService.getCommentMaxPageNo(pageSize, Integer.parseInt(itemNo));
		    
		    if (pageNo <= 0) pageNo = 1;
		    if (maxPageNo != 0 && pageNo > maxPageNo) pageNo = maxPageNo;
		
		
			List commentMaps = itemService.getComment(Integer.parseInt(itemNo), pageNo, pageSize);
			
			//int non = (int)session.getAttribute("view2Page");
			HashMap<String,Object> resultMap = new HashMap<>();
			resultMap.put("status", "success");
			resultMap.put("currPageNo", pageNo);
		    resultMap.put("maxPageNo", maxPageNo);
			resultMap.put("commentList", commentMaps);
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
	
	
	@RequestMapping("/addComment")
	public Object addComment(int connectNo, String selectScore, String inputComment, String currentDate) throws Exception {
		itemService.addComment(connectNo, Integer.parseInt(selectScore), inputComment,currentDate);
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		return resultMap; 
	}
	

}
