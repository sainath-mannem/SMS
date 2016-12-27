package com.sms.service;

import java.util.List;

import com.sms.dataaccess.StudentClass;
import com.sms.exception.DataAccessException;

public interface ClassService {
	Integer add(StudentClass studentClass) throws DataAccessException;
	void update(StudentClass studentClass) throws DataAccessException;
	StudentClass get(int id) throws DataAccessException;
	List<StudentClass> list() throws DataAccessException;
}
