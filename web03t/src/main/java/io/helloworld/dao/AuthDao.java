package io.helloworld.dao;

import java.util.HashMap;

public interface AuthDao {

	HashMap existUser(HashMap<String, String> params);

	Object areYouGuide(HashMap<String, String> params);

	Object areYouTourist(HashMap<String, String> params);

}
