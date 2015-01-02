package io.helloworld.service;

import io.helloworld.dao.GuideDao;
import io.helloworld.domain.Guide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	}
}
