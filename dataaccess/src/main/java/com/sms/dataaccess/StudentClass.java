package com.sms.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="studentClass")
@Table(name="STUDENT_CLASS")
public class StudentClass {
	@Id
	@GeneratedValue
	@Column(name="CLASS_ID")
	private int classId;
	@Column(name="CLASS_NAME")
	private String className;
	@OneToMany(mappedBy="clazz", cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Subject> subjectList = new ArrayList<Subject>();
	@OneToMany(mappedBy="studentClass")
	private List<Student> studentList;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public StudentClass(String className) {
		this.className = className;
	}
	public StudentClass(int classId) {
		this.classId = classId;
	}
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	@Override
	public String toString() {
		return "StudentClass [classId=" + classId + ", className=" + className + ", subjectList=" + subjectList + "]";
	}
	
}
