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
	private Integer supervision_persion_id;
	private Date supervision_date;
	
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
	public Integer getSupervision_persion_id() {
		return supervision_persion_id;
	}
	public void setSupervision_persion_id(Integer supervision_persion_id) {
		this.supervision_persion_id = supervision_persion_id;
	}
	public Date getSupervision_date() {
		return supervision_date;
	}
	public void setSupervision_date(Date supervision_date) {
		this.supervision_date = supervision_date;
	}
	
	
}
