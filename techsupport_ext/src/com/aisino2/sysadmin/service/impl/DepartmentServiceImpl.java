package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IDepartmentDao;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.service.IDepartmentService;

@Component
public class DepartmentServiceImpl implements IDepartmentService {

	private IDepartmentDao department_dao;
	
	public void insertDepartment(Department department) {
		this.department_dao.insertDepartment(department);
	}

	public void deleteDepartment(Department department) {
		this.department_dao.deleteDepartment(department);
	}

	public void updateDepartment(Department department) {
		this.department_dao.updateDepartment(department);
	}

	public Department getDepartment(Department department) {
		return this.department_dao.getDepartment(department);
	}

	public List getListForPage(Department department, int pageNo, int pageSize,
			String sort, String desc) {
		return this.department_dao.getListForPage(department, pageNo, pageSize, sort, desc);
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

	public List<Department> getChildDepart(Department depart) {
		return this.department_dao.getChildDepart(depart);
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
		// TODO Auto-generated method stub
		return null;
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
