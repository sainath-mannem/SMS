package com.sms.dao;

import java.util.List;

import com.sms.dataaccess.State;

public interface GenericDAO {

	void loadStates(List<State> states);
	List<State> list();
	State get(String code);


}
