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
//		设置机构等级
		if(department.getDepartlevel()==null){
			department.setDepartlevel(getNextDepartlevel(department));
		}
//		更新上级机构字典信息
		if(department.getParent()!=null){
			Department parent = this.department_dao.getDepartment(department.getParent());
			parent.setIsleaf("N");
			this.department_dao.updateDepartment(parent);
		}
		this.department_dao.insertDepartment(department);
	}

	@Transactional
	public void deleteDepartment(Department department) {
		this.department_dao.deleteDepartment(department);
		if(department.getParent()!=null)
			if(!this.department_dao.checkChild(department.getParent())){
				department.getParent().setIsleaf("Y");
				this.department_dao.updateDepartment(department.getParent());
			}
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

	public boolean check_departcode(Department department) {
		if(department.getDepartcode()==null || department.getDepartcode().equals(""))
			throw new RuntimeException("机构代码为空");
		return this.department_dao.check_departcode(department);
	}
	
	public Integer getNextDepartlevel(Department department){
		if(department==null)
			throw new RuntimeException("机构为空");
		Department d = null;
		if(department.getParent()!=null){
			d = this.department_dao.getDepartment(department.getParent());
			return d.getDepartlevel()+1;
		}
		else
			return 1;
	}

}
