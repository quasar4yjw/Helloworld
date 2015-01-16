package io.helloworld.dao;

import io.helloworld.domain.Tourist;

import java.util.HashMap;


public interface TouristDao {
	void insert(Tourist tourist);
	void insertSpecial(Tourist tourist);
	void update(Tourist tourist);
	void updateSpecial(Tourist tourist);
	HashMap select(String email);
}
