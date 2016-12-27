package com.sms.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sms.dao.ClassDAO;
import com.sms.dataaccess.StudentClass;
@Repository("classDao")
public class ClassDAOImpl implements ClassDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer add(StudentClass studentClass) {
		return (Integer) sessionFactory.getCurrentSession().save(studentClass);
	}

	public void update(StudentClass studentClass) {
		// TODO Auto-generated method stub
		
	}

	public List<StudentClass> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentClass get(int classID) {
		// TODO Auto-generated method stub
		return null;
	}

}
