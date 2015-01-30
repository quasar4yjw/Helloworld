package io.helloworld.service;

import io.helloworld.dao.MessageDao;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired 
	MessageDao messageDao;

	public Object getSelectJoinForm(HttpServletRequest request) {
		Object obj = null;
		for (Enumeration e = request.getLocales(); e.hasMoreElements();) {
		       if((obj = messageDao.getSelectJoinForm(e.nextElement().toString())) != null){
		    	   return obj;
		       }
		   }
		return obj;
	}
	
	public Object getJoinGuide(HttpServletRequest request) {
		Object obj = null;
		for (Enumeration e = request.getLocales(); e.hasMoreElements();) {
		       if( (obj = messageDao.getJoinGuide(e.nextElement().toString()) ) != null){
		    	   return obj;
		       }
		   }
		return obj;
	}

	public Object getMainI18N(HttpServletRequest request) {
		Object obj = null;
		for (Enumeration e = request.getLocales(); e.hasMoreElements();) {
		       if( (obj = messageDao.getMainI18N(e.nextElement().toString()) ) != null){
		    	   return obj;
		       }
		   }
		return obj;
	}
	

}
