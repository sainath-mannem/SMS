package com.sms.service;

import java.util.List;

import com.sms.dataaccess.Student;
import com.sms.exception.DataAccessException;

public interface StudentService {
	
	Long add(Student student) throws DataAccessException;
	void update(Student student) throws DataAccessException;
	Student get(int id) throws DataAccessException;
	List<Student> list() throws DataAccessException;

}
