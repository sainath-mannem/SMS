package com.sms.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.GenericDAO;
import com.sms.dataaccess.State;
import com.sms.service.GenericService;

@Service("genericService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GenericServiceImpl implements GenericService {

	@Autowired
	private GenericDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void loadStates() {
		State state = new State("AP", "Andhra Pradesh");
		State state1 = new State("KA", "Karnataka");
		dao.loadStates(Arrays.asList(state, state1));
	}

	public List<State> list() {
		return null;
	}

	public State get(String code) {
		return null;
	}

}
