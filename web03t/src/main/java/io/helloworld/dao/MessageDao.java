package io.helloworld.dao;

import java.util.HashMap;

public interface MessageDao {

	HashMap existUser(HashMap<String, String> params);

	long areYouGuide(HashMap<String, String> params);

	long areYouTourist(HashMap<String, String> params);

}
