package io.helloworld.dao;

import java.util.List;

public interface MessageDao {

	List getSelectJoinForm(String nextElement);

	List getJoinGuide(String string);

	List getMainI18N(String string);

}
