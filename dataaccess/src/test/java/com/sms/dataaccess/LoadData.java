package com.sms.dataaccess;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sms.dataaccess.Address.AddressType;
import com.sms.dataaccess.Medium;
import com.sms.dataaccess.State;
import com.sms.dataaccess.StudentClass;

public class LoadData {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		loadMedium();
		loadStates();
		loadClassesAndSubjects();
		loadStudentAndAddress();
	}

	private static void loadStudentAndAddress() {
		Student stu1 = new Student("1", "Sainath", new StudentClass(1));
		Student stu2 = new Student("2", "Mannem", new StudentClass(2));
		stu1.setAddressList(Arrays.asList(new Address("#9","Basavananager main road" ,"Hoodi", 560048, new State("KA"), AddressType.PRESENT ),
				new Address("2/72","South Street" ,"VPM", 517541, new State("AP"), AddressType.PERMINENT )));
		persist(Arrays.asList(stu1, stu2));
	}

	private static void loadClassesAndSubjects() {
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
		persist(Arrays.asList(clazz, clazz1, clazz2, clazz3, clazz4, clazz5, clazz6));
	}

	private static void loadStates() {
		State state = new State("AP", "Andhra Pradesh");
		State state1 = new State("KA", "Karnataka");
		save(Arrays.asList(state, state1));
	}

	private static void loadMedium() {
		Medium medium = new Medium("TEL", "Telugu");
		Medium medium2 = new Medium("ENG", "English");
		Medium medium3 = new Medium("HIN", "Hindhi");
		save(Arrays.asList(medium, medium2, medium3));
	}
	private static void save(List<?> objlist) {
		Session session = getSession();
		session.beginTransaction().begin();
		for (Object object : objlist) {
			session.save(object);
		}
		session.getTransaction().commit();
		session.close();

	}
	private static void persist(List<?> objlist) {
		Session session = getSession();
		session.beginTransaction().begin();
		for (Object object : objlist) {
			session.persist(object);
		}
		session.getTransaction().commit();
		session.close();

	}

	private static Session getSession() {
		return factory.openSession();
	}

}