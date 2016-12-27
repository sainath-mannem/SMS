package com.sms.service;

import java.util.List;

import com.sms.dataaccess.State;

public interface GenericService {
	void loadStates();
	List<State> list();
	State get(String code);
}
