package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.ISystemDao;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.service.ISystemService;

@Component
public class SystemServiceImpl implements ISystemService {
	private ISystemDao system_dao;

	
	@Resource(name="systemDaoImpl")
	public void setSystem_dao(ISystemDao system_dao) {
		this.system_dao = system_dao;
	}


	public void insertSystem(System system) {
		this.system_dao.insertSystem(system);
	}


	public void deleteSystem(System system) {
		this.system_dao.deleteSystem(system);
	}


	public void updateSystem(System system) {
		this.system_dao.updateSystem(system);
	}


	public System getSystem(System system) {
		
		return this.getSystem(system);
	}


	public List getListForPage(System system, int pageNo, int pageSize,
			String sort, String desc) {
		
		return this.system_dao.getListForPage(system, pageNo, pageSize, sort, desc);
	}


	public List<System> getListSystem(System system) {
		return this.system_dao.getListSystem(system);
	}


	public List<System> getChildSystem(System system) {
		return this.system_dao.getChildSystem(system);
	}


	public List<System> getTheUserChildSystem(System system) {
		return this.system_dao.getTheUserChildSystem(system);
	}


	public System getParentSystem(System system) {
		return this.system_dao.getParentSystem(system);
	}


	public boolean isExit(Map condition) {
		// TODO Auto-generated method stub
		return false;
	}


	public List<System> getSystemByUserID(System system) {
		return this.system_dao.getSystemByUserID(system);
	}


	public boolean updateSystemEditEdOrder(System system) {
		// TODO Auto-generated method stub
		return false;
	}


	public Integer getNextNodeorder(System system) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
