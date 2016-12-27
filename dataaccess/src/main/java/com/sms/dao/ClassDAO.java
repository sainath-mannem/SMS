package com.sms.dao;

import java.util.List;

import com.sms.dataaccess.StudentClass;

public interface ClassDAO {
	Integer add(StudentClass studentClass);
	void update(StudentClass studentClass);
	List<StudentClass> list();
	StudentClass get(int classID);
}
