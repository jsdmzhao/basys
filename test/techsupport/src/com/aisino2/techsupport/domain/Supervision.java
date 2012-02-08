package com.aisino2.techsupport.domain;

import java.util.Date;

import com.aisino2.sysadmin.domain.User;

/**
 * 督办
 *
 *
 */
public class Supervision {
	private Integer id;
	private String supervision_suggestion;
	private User supervision_person;
	private Integer supervision_person_id;
	private String supervision_person_name;
	private Date supervision_date;
	private Integer st_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSupervision_suggestion() {
		return supervision_suggestion;
	}
	public void setSupervision_suggestion(String supervision_suggestion) {
		this.supervision_suggestion = supervision_suggestion;
	}
	public User getSupervision_person() {
		return supervision_person;
	}
	public void setSupervision_person(User supervision_person) {
		this.supervision_person = supervision_person;
	}
	public Integer getSupervision_person_id() {
		return supervision_person_id;
	}
	public void setSupervision_person_id(Integer supervision_person_id) {
		this.supervision_person_id = supervision_person_id;
	}
	public String getSupervision_person_name() {
		return supervision_person_name;
	}
	public void setSupervision_person_name(String supervision_person_name) {
		this.supervision_person_name = supervision_person_name;
	}
	public Date getSupervision_date() {
		return supervision_date;
	}
	public void setSupervision_date(Date supervision_date) {
		this.supervision_date = supervision_date;
	}
	public Integer getSt_id() {
		return st_id;
	}
	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}
	
	
}
