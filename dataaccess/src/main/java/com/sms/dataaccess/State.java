package com.sms.dataaccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="state")
@Table(name="STATE")
public class State {
	@Id
	@Column(name="CODE")
	private String code;
	@Column(name="NAME", nullable=false )
	private String stateName;
	
	public State(String code, String stateName) {
		this.code = code;
		this.stateName = stateName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public State(String code) {
		this.code = code;
	}
	
	
}
