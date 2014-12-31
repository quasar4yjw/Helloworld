package io.helloworld.service;

import io.helloworld.dao.TouristDao;
import io.helloworld.domain.Tourist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TouristService {

	@Autowired
	TouristDao touristDao;

	@Transactional(
			rollbackFor=Exception.class, 
			propagation=Propagation.REQUIRED)
	public void signUp(Tourist tourist) {
		touristDao.insert(tourist);
		touristDao.insertSpecial(tourist);
	}
}
