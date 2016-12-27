package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sms.dao.StudentDAO;
import com.sms.dataaccess.Student;
import com.sms.exception.DataAccessException;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Long add(Student student) throws DataAccessException {
		return (Long) sessionFactory.getCurrentSession().save(student);
	}

	public void update(Student student) throws DataAccessException {
		sessionFactory.getCurrentSession().update(student);
	}

	public Student get(int id) throws DataAccessException {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Student> list() throws DataAccessException {
		Query query = sessionFactory.getCurrentSession().createQuery("from student");
		return ((List<Student>) query.list());
	}

	@Override
	public String toString() {
		return "StudentServiceImpl [sessionFactory=" + sessionFactory + "]";
	}
}
