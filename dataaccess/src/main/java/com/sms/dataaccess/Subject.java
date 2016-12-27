package com.sms.dataaccess;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="subject")
@Table(name="SUBJECT")
public class Subject {
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	@Column(name="TITLE", nullable=false)
	private String titile;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CLASS_ID")
	private StudentClass clazz;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public StudentClass getClazz() {
		return clazz;
	}
	public void setClazz(StudentClass clazz) {
		this.clazz = clazz;
	}
	public Subject(String titile, StudentClass clazz) {
		this.titile = titile;
		this.clazz = clazz;
		clazz.addSubject(this);
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", titile=" + titile + ", clazz=" + clazz + "]";
	}
	
	
}
