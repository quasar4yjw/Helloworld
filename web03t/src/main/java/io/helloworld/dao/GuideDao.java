package io.helloworld.dao;

import io.helloworld.domain.Guide;


public interface GuideDao {
	void insert(Guide guide);
	void insertSpecial(Guide guide);
}
