package io.helloworld.service;

import io.helloworld.dao.ConnectDao;
import io.helloworld.domain.Connect;

import java.util.HashMap;
import java.util.List;
import java63.web03.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConnectService {

	@Autowired 
	ConnectDao connectDao;

	@Transactional(
			rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)

	/*public void status(Connect connect) {*/

	public List<?> getList(int pageNo, int pageSize, String selected, String userType) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		paramMap.put("selected", selected);
		paramMap.put("userType", userType);

		/*    if(selected == "req"){
      resultMap.put("connects", 
          connectService.getList(pageNo, pageSize));
    } else if(selected == "succ") {
      resultMap.put("connects", 
          connectService.getList(pageNo, pageSize));
    } else if(selected == "cancel") {
      resultMap.put("connects", 
          connectService.getList(pageNo, pageSize));
    } else {

    }*/


		/*paramMap.put("interest", itemDao.selectTages());*/

		return connectDao.selectConnect(paramMap);
	}

	public int getMaxPageNo(int pageSize, String selected) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("selected", selected);

		int totalSize = connectDao.totalSize(paramMap);
		int maxPageNo = totalSize / pageSize;
		if ((totalSize % pageSize) > 0) maxPageNo++;

		return maxPageNo;
	}


	@Transactional(
			rollbackFor=Exception.class, 
			propagation=Propagation.REQUIRED)
	public void update(Connect connect) {
		connectDao.update(connect);
	}

	@Transactional(
			rollbackFor=Exception.class, 
			propagation=Propagation.REQUIRED)
	public void insert(Connect connect) {
		connectDao.insert(connect);
	}

	public Object getMinConnectNo(int reqNo, String touristEmail) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("reqNo", reqNo);
		paramMap.put("touristEmail", touristEmail);
		return connectDao.getMinConnectNo(paramMap);
	}

}
