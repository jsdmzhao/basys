package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.sysadmin.dao.IDepartmentDao;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.service.IDepartmentService;

public class DepartmentServiceImpl extends BaseService implements IDepartmentService {

	private IDepartmentDao departmentDao;

	/** @param 机构(t_department) 增加 */
	public Department insertDepartment(Department department){
		// TODO: implement
		   Department parentDepart = getParentDepart(department); 
		   if (parentDepart != null) {
			      if ("Y".equals(parentDepart.getIsleaf())) {
			        parentDepart.setIsleaf("N");
			        departmentDao.updateCacheDepartment(parentDepart);
			      }
			      department.setDepartfullcode(parentDepart.getDepartfullcode() + department.getDepartcode() + ".");
			      department.setDepartlevel(parentDepart.getDepartlevel()+1);
			    } else {
			    	department.setDepartfullcode(department.getDepartcode()+ ".");
			    	department.setDepartlevel(1);
			    	department.setParentdepartid(0);
			    }
		   if(department.getDepartcode()!=null)
		   {
			   department.setDepartbrevitycode(StringUtil.trimEven0(department.getDepartcode()));
		   }
		   if(department.getDepartname()!=null)
		   {
			   if(!"".equals(department.getDepartname()))
			   {
				   department.setDepartallpin(PinYinUtil.getHanyuPingYin(department.getDepartname()));
				   department.setDepartsimplepin(PinYinUtil.getHanyuPingYinInitial(department.getDepartname()));
			   }
		   }
		return (Department)departmentDao.insertCacheDepartment(department);
	}

	/** @param 机构(t_department) 删除 内存*/
	public boolean deleteDepartment(Department department){
		// TODO: implement
		 department = departmentDao.getDepartment(department);
		 int parentdepartid = department.getParentdepartid();
		 Department parentDepartment = new Department();
		 parentDepartment.setParentdepartid(parentdepartid);
		int i = departmentDao.deleteCacheDepartment(department);
		boolean flag = departmentDao.checkChild(parentDepartment);
		if(!flag){
			parentDepartment.setParentdepartid(null);
			parentDepartment.setDepartid(parentdepartid);
			parentDepartment.setIsleaf("Y");
			departmentDao.updateCacheDepartment(parentDepartment);
		}
		 return i>0;
	}

	/** @param 机构(t_department) 修改 内存 */
	public boolean updateDepartment(Department department){
		// TODO: implement
		Department parentDepart = departmentDao.getParentDepart(department);
		Department old = departmentDao.getDepartment(department);
		if (parentDepart != null) {
			department.setDepartfullcode(parentDepart.getDepartfullcode() + department.getDepartcode()
					+ ".");
		} else {
			department.setDepartfullcode(department.getDepartcode()+ ".");
		}
		List childDepartList = departmentDao.getAllChildDepart(old);
		if (childDepartList != null) {
			for (int i = 0; i < childDepartList.size(); i++) {
				Department childDepart = (Department) childDepartList.get(i);
				childDepart.setDepartfullcode(childDepart.getDepartfullcode().replaceFirst(
						old.getDepartcode(), department.getDepartcode()));
				departmentDao.updateCacheDepartment(childDepart);
			}
		}
		if(department.getDepartcode()!=null)
		   {
			   department.setDepartbrevitycode(StringUtil.trimEven0(department.getDepartcode()));
		   }
		if(department.getDepartname()!=null)
		   {
			   if(!"".equals(department.getDepartname()))
			   {
				   department.setDepartallpin(PinYinUtil.getHanyuPingYin(department.getDepartname()));
				   department.setDepartsimplepin(PinYinUtil.getHanyuPingYinInitial(department.getDepartname()));
			   }
		   }
		return departmentDao.updateCacheDepartment(department) > 0;
	}

	/** @param 机构(t_department) 查询单条 */
	public Department getDepartment(Department department){
		// TODO: implement
		return (Department)departmentDao.getDepartment(department);
	}

	/** @param 机构(t_department) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return departmentDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 机构(t_department) 分页查询  平板字典下拉框*/
	public Page getDicListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return departmentDao.getDicListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 机构(t_department) 多条查询 */
	public List getListDepartment(Department department){
		// TODO: implement
		return departmentDao.getListDepartment(department);
	}
	
	/** @param 机构(t_department) 多条查询 平板字典下拉框 放到内存*/
	public List getListDepartmentForCache(Department department){
		// TODO: implement
		return departmentDao.getListDepartmentForCache(department);
	}
	
	/** @param 机构(t_department) 多条查询 平板字典下拉框 放到内存 onlyGa-只查询公安机关*/
	public List getListDepartment(Department department,String onlyGa)
	{
		return departmentDao.getListDepartment(department, onlyGa);
	}

	public IDepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public List getChildDepart(Department depart) {
		// TODO Auto-generated method stub
		return departmentDao.getChildDepart(depart);
	}

	public Department getParentDepart(Department depart) {
		// TODO Auto-generated method stub
		return departmentDao.getParentDepart(depart);
	}

	public List getDepartInfo(Department depart) {
		// TODO Auto-generated method stub
		List departInfoList = departmentDao.getDepartInfo(depart);
		return  departInfoList.size()>0?departInfoList:null;
	}

	public List getAllChildDepart(Department depart) {
		// TODO Auto-generated method stub
		return departmentDao.getAllChildDepart(depart);
	}
	public List getAllChildDepartByFullCode(Department depart) {
		// TODO Auto-generated method stub
		return departmentDao.getAllChildDepartByFullCode(depart);
	}

	public List getChildDepartCs(Department depart) {
		// TODO Auto-generated method stub
		return departmentDao.getChildDepartCs(depart);
	}
//部门调整
	public boolean deptAdjust(Department depart) {
		// TODO Auto-generated method stub
		return false;
	}
//上下移动，置顶，置底
	public boolean updateDeptEditEdOrder(Department departOrigin) {
		// TODO Auto-generated method stub
	Department depart=new Department();
	depart.setDepartid(departOrigin.getDepartid());
	depart = departmentDao.getDepartment(depart);
	
    Department parentDepart=departmentDao.getParentDepart(depart);
	List childList=	departmentDao.getChildDepart(parentDepart);
	Department jiaohuanDapart = new Department();

	int departid=depart.getDepartid();
	String way ="";
	way = departOrigin.getWay();
	Integer  nodeorder=0;
	Integer  nodeorderTwo=0;
	int n=0;
	int j=0;
	if(childList.size()==0){
		return true;
	}
	
	for(int i=0;i<childList.size();i++){
		depart = (Department)childList.get(i);
	
		if(departid==depart.getDepartid()){
			nodeorder = depart.getNodeorder();
			n=i;
			if(way.equals("上移")){
				if(i>0)
				{
					jiaohuanDapart = (Department)childList.get(i-1);
					depart.setNodeorder(jiaohuanDapart.getNodeorder());
					jiaohuanDapart.setNodeorder(nodeorder);
					departmentDao.updateDepartment(depart);
					departmentDao.updateDepartment(jiaohuanDapart);
					break;
				}
				else
					break;
			}
			if(way.equals("下移")){
				if(i<childList.size()-1)
				{
					jiaohuanDapart = (Department)childList.get(i+1);
					depart.setNodeorder(jiaohuanDapart.getNodeorder());
					jiaohuanDapart.setNodeorder(nodeorder);
					departmentDao.updateDepartment(depart);
					departmentDao.updateDepartment(jiaohuanDapart);
					break;
				}
				else
					break;
			}
			if(way.equals("置顶")){
				if(i>0)
				{
					jiaohuanDapart = (Department)childList.get(0);
					depart.setNodeorder(jiaohuanDapart.getNodeorder());
					departmentDao.updateDepartment(depart);
					for(j=n;j>0;j--){
						jiaohuanDapart = (Department)childList.get(j-1);
						nodeorderTwo = jiaohuanDapart.getNodeorder();
						jiaohuanDapart.setNodeorder(nodeorder);
						departmentDao.updateDepartment(jiaohuanDapart);
						nodeorder = nodeorderTwo;
					}
					break;
				}
				else
					break;
			}
			if(way.equals("置底")){
				if(i<childList.size()-1)
				{
					jiaohuanDapart = (Department)childList.get(childList.size()-1);
					depart.setNodeorder(jiaohuanDapart.getNodeorder());
					departmentDao.updateDepartment(depart);
					for(j=n;j<childList.size()-1;j++){
						jiaohuanDapart = (Department)childList.get(j+1);
						nodeorderTwo = jiaohuanDapart.getNodeorder();
						jiaohuanDapart.setNodeorder(nodeorder);
						departmentDao.updateDepartment(jiaohuanDapart);
						nodeorder = nodeorderTwo;
					}
					break;
				}
				else
					break;
			}
			
		}
	}
		return true;
	}
	
	/** 获得下一个排序号 */
	public Integer getNextNodeorder(Department department)
	{
		Integer nextNodeorder = 0;
		Department newDepartment = new Department();
		newDepartment = departmentDao.getNextNodeorder(department);
		if(newDepartment != null)
		{
			nextNodeorder = newDepartment.getNodeorder();
		}
		return nextNodeorder;
	}
	
	/** @param 机构(t_department) 多条查询 */
	public List getListAllDepartment(Department department){
		// TODO: implement
		return departmentDao.getListAllDepartment(department);
	}
}
