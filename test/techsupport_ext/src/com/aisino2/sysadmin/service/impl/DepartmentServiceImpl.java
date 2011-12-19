package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aisino2.sysadmin.dao.IDepartmentDao;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.service.IDepartmentService;

@Component
public class DepartmentServiceImpl implements IDepartmentService {

	private IDepartmentDao department_dao;
	
	@Transactional
	public void insertDepartment(Department department) {
//		设置序列
		if(department.getNodeorder()==null)
			department.setNodeorder(getNextNodeorder(department));
		
		this.department_dao.insertDepartment(department);
	}

	@Transactional
	public void deleteDepartment(Department department) {
		this.department_dao.deleteDepartment(department);
	}

	@Transactional
	public void updateDepartment(Department department) {
		this.department_dao.updateDepartment(department);
	}

	public Department getDepartment(Department department) {
		return this.department_dao.getDepartment(department);
	}

	public List getListForPage(Department department, int start, int limit,
			String sort, String desc) {
		return this.department_dao.getListForPage(department, start, limit, sort, desc);
	}

	public List getDicListForPage(Department department, int pageNo,
			int pageSize, String sort, String desc) {
		return null;
	}

	public List<Department> getListDepartment(Department department) {
		return this.department_dao.getListDepartment(department);
	}

	public List<Department> getListDepartmentForCache(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> getListDepartment(Department department,
			String onlyGa) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> getChildDepart(Department depart,Integer departlevel) {
		return this.department_dao.getChildDepart(depart,departlevel);
	}
	
	public boolean checkChildDepart(Department department, Integer departlevel){
		department.setDepartlevel(departlevel);
		return this.department_dao.checkChild(department);
	}

	public Department getParentDepart(Department depart) {
		return this.department_dao.getParentDepart(depart);
	}

	public List<Department> getDepartInfo(Department depart) {
		return null;
	}

	public List<Department> getAllChildDepart(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> getAllChildDepartByFullCode(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> getChildDepartCs(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deptAdjust(Department depart) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateDeptEditEdOrder(Department depart) {
		// TODO Auto-generated method stub
		return false;
	}

	public Integer getNextNodeorder(Department department) {
		
		return this.department_dao.getNextNodeorder(department);
	}

	public List<Department> getListAllDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Resource(name="departmentDaoImpl")
	public void setDepartment_dao(IDepartmentDao department_dao) {
		this.department_dao = department_dao;
	}

}