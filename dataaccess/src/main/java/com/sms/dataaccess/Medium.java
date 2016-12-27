package com.sms.dataaccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="medium")
@Table(name="MEDIUM")
public class Medium {
	
	
	public Medium() {
	}
	public Medium(String code, String name) {
		this.code = code;
		this.name = name;
	}
	@Id()
	@Column(name="CODE")
	private String code;
	@Column(name="NAME")
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
