package com.sms.dataaccess;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

@Entity(name="student")
@Table(name="STUDENT")
/*@SecondaryTable(name="Student_ADDRESS",
pkJoinColumns=@PrimaryKeyJoinColumn(name="Student_ID"))*/
public class Student {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="STUDENT_ID")
	private String number;
	@Column(name="STUDENT_NAME")
	private String name;
	@ElementCollection(fetch=FetchType.LAZY)
	@GenericGenerator(name="seq", strategy="increment")
	@JoinTable(name="STUDENT_ADDRESS")
	@CollectionId(columns=@Column(name="ADDRESS_ID"), generator="seq", type =@Type(type="long") )
	/*@AttributeOverrides({
        @AttributeOverride(name="addressLine1", column=@Column(table="Student_ADDRESS")),
        @AttributeOverride(name="addressLine2", column=@Column(table="Student_ADDRESS")),
        @AttributeOverride(name="city", column=@Column(name="CITY", table="Student_ADDRESS")),
        @AttributeOverride(name="state", column=@Column(name="STATE", table="Student_ADDRESS")),
        @AttributeOverride(name="pincode", column=@Column(name="ZIP_CODE", table="Student_ADDRESS"))
    })*/
	private List<Address> addressList;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.EXCEPTION)
	@JoinColumn(name="CLASS_ID")
	private StudentClass studentClass;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String studentNumber, String name, StudentClass studentClass2) {
		this.number = studentNumber;
		this.name = name;
		this.studentClass = studentClass2;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	
}
