package io.helloworld.dao;

import java.util.HashMap;

public interface AuthDao {

	HashMap existUser(HashMap<String, String> params);

	int areYouGuide(HashMap<String, String> params);

	int areYouTourist(HashMap<String, String> params);

}
