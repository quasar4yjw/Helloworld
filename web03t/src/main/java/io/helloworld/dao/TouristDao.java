package io.helloworld.dao;

import io.helloworld.domain.Tourist;


public interface TouristDao {
	void insert(Tourist tourist);
	void insertSpecial(Tourist tourist);
}
