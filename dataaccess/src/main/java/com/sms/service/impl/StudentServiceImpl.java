package com.sms.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.StudentDAO;
import com.sms.dataaccess.Address;
import com.sms.dataaccess.State;
import com.sms.dataaccess.Student;
import com.sms.dataaccess.StudentClass;
import com.sms.dataaccess.Subject;
import com.sms.dataaccess.Address.AddressType;
import com.sms.exception.DataAccessException;
import com.sms.service.ClassService;
import com.sms.service.GenericService;
import com.sms.service.StudentService;

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDAO dao;
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Long add(Student student) throws DataAccessException {
		return dao.add(student);
	}

	public void update(Student student) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public Student get(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> list() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		loadStudentAndAddress();
	}
	private static void loadStudentAndAddress() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\Sainath\\My Project\\SMS\\dataaccess\\src\\main\\resources\\Spring-Config.xml");
		

		StudentClass clazz = new StudentClass("LKG");
		StudentClass clazz1 = new StudentClass("UKG");
		StudentClass clazz2 = new StudentClass("I Class");
		StudentClass clazz3 = new StudentClass("II Class");
		StudentClass clazz4 = new StudentClass("III Class");
		StudentClass clazz5 = new StudentClass("IV Class");
		StudentClass clazz6 = new StudentClass("V Class");
		new Subject("Alphabets", clazz);
		new Subject("Numbers", clazz);
		new Subject("Rymes", clazz);
		new Subject("Alphabets II", clazz1);
		new Subject("Numbers II", clazz1);
		new Subject("Rymes II", clazz1);
		//persist(Arrays.asList(clazz, clazz1, clazz2, clazz3, clazz4, clazz5, clazz6));
	
		ClassService c = (ClassService) ac.getBean("classService");
		
		StudentService s = (StudentService) ac.getBean("studentService");
		Student stu1 = new Student("1", "Sainath", new StudentClass(1));
		Student stu2 = new Student("2", "Mannem", new StudentClass(2));
		State state = new State("AP", "Andhra Pradesh");
		State state1 = new State("KA", "Karnataka");
		stu1.setAddressList(Arrays.asList(new Address("#9","Basavananager main road" ,"Hoodi", 560048, new State("KA"), AddressType.PRESENT ),
				new Address("2/72","South Street" ,"VPM", 517541, new State("AP"), AddressType.PERMINENT )));
		GenericService g = (GenericService) ac.getBean("genericService");
		try {
			for (StudentClass claz : Arrays.asList(clazz, clazz1, clazz2, clazz3, clazz4, clazz5, clazz6)) {
				System.out.println(c.add(claz));
			}
			g.loadStates();
			System.out.println(s.add(stu1));
			System.out.println(s.add(stu2));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
