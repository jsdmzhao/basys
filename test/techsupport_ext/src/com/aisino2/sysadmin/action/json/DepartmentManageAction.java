package com.aisino2.sysadmin.action.json;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.action.PageAction;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.service.IDepartmentService;

@Component
@Scope("prototype")
public class DepartmentManageAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8963651412037411136L;
	private IDepartmentService department_service;
	private Department department;
	private List<Department> department_list;
	
	public String query() throws Exception{
		try{
			List page_list = department_service.getListForPage(department, this.pageNo, this.pageSize, this.dir, this.sort);
			this.total = (Integer) page_list.get(0);
			department_list = (List<Department>) page_list.get(1);
		}catch(Exception e){
			this.returnNo=1;
			this.returnMessage="获取列表发送错误";
		}
		
		return SUCCESS;
	}
	
	public String add() throws Exception{
		return SUCCESS;
	}
	
	public String remove() throws Exception{
		return SUCCESS;
	}
	
	public String modify() throws Exception{
		return SUCCESS;
	}

	@Resource(name="departmentServiceImpl")
	public void setDepartment_service(IDepartmentService department_service) {
		this.department_service = department_service;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Department> getDepartment_list() {
		return department_list;
	}

	public void setDepartment_list(List<Department> department_list) {
		this.department_list = department_list;
	}
	
	
	
}
