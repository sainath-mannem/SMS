package com.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.ClassDAO;
import com.sms.dataaccess.StudentClass;
import com.sms.exception.DataAccessException;
import com.sms.service.ClassService;

@Service("classService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClassServiceImpl implements ClassService{
	@Autowired
	private ClassDAO dao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Integer add(StudentClass studentClass) throws DataAccessException {
		return dao.add(studentClass);
	}

	public void update(StudentClass studentClass) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public StudentClass get(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentClass> list() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
