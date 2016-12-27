package com.sms.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sms.dao.GenericDAO;
import com.sms.dataaccess.State;

@Repository("genericDao")
public class GenericDAOImpl implements GenericDAO {
	
	@Autowired
	private SessionFactory factory;
	public void loadStates(List<State> states) {
		for (State state : states) {
			factory.getCurrentSession().save(state);
		}
	}

	public List<State> list() {
		return null;
	}

	public State get(String code) {
		return null;
	}

}
