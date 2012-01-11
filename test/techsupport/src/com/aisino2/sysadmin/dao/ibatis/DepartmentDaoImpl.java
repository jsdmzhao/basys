package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IDepartmentDao;
import com.aisino2.sysadmin.domain.Department;

public class DepartmentDaoImpl extends BaseDao implements IDepartmentDao {
	/** @param 机构(t_department) 增加 */
	public Department insertDepartment(Department department){
		// TODO: implement
		return insertCacheDepartment(department);
	}
	
	/** @param 机构(t_department) 增加 */
	public Department insertCacheDepartment(Department department){
		// TODO: implement
		department.setDepartid(getNextID("Departid"));
		insert("insertDepartment", department);
		return department;
	}

	/** @param 机构(t_department) 删除 */
	public int deleteDepartment(Department department){
		// TODO: implement
		return deleteCacheDepartment(department);
	}
	
	/** @param 机构(t_department) 删除 */
	public int deleteCacheDepartment(Department department){
		// TODO: implement
		return delete("deleteDepartment", department);
	}

	/** @param 机构(t_department) 修改 */
	public int updateDepartment(Department department){
		// TODO: implement
		return updateCacheDepartment(department);
	}
	
	/** @param 机构(t_department) 修改 */
	public int updateCacheDepartment(Department department){
		// TODO: implement
		return update("updateDepartment", department);
	}

	/** @param 机构(t_department) 查询单条 */
	public Department getDepartment(Department department){
		// TODO: implement
		return (Department)queryForObject("getDepartment", department);
	}

	/** @param 机构(t_department) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.departcode "+ desc;
			else if(sort.equals("1"))
				sCol = " a.departname "+ desc;
			else if(sort.equals("2"))
				sCol = " a.parentdepartid "+ desc;
			else
				sCol = " a.nodeorder ";
		}else{
			sCol=" a.nodeorder ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDepartmentList", map, pageNo,pageSize);
	}
	
	/** @param 机构(t_department) 分页查询  平板字典下拉框*/
	public Page getDicListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.departname "+ desc;
			else if(sort.equals("1"))
				sCol = " a.departcode "+ desc;
			else
				sCol = " a.departcode ";
		}else{
			sCol=" a.departcode ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDepartmentList", map, pageNo,pageSize);
	}

	/** @param 机构(t_department) 多条查询 */
	public List getListDepartment(Department department){
		// TODO: implement
		return queryForList("getDepartmentListNoPage", department);
	}
	
	/** @param 机构(t_department) 多条查询 平板字典下拉框 放到内存*/
	public List getListDepartmentForCache(Department department){
		// TODO: implement
		return queryForList("getDepartmentListForCache", department);
	}
	
	/** @param 机构(t_department) 多条查询 平板字典下拉框 放到内存 onlyGa-只查询公安机关*/
	public List getListDepartment(Department department,String onlyGa)
	{
		return queryForList("getDepartmentListForCache", department);
	}

	public List getChildDepart(Department depart) {
		// TODO Auto-generated method stub
		  return queryForList("getChildDepartment", depart);
	}

	public Department getParentDepart(Department depart) {
		// TODO Auto-generated method stub
		  Object obj = queryForObject("getParentDepartment", depart);
		    return (obj == null) ? null : (Department) obj;
	}

	public List getDepartInfo(Department depart) {
		// TODO Auto-generated method stub
		return queryForList("getDepartInfo", depart);
	}

	public List getAllChildDepart(Department depart) {
		// TODO Auto-generated method stub
		return queryForList("getAllChildDepartment", depart);
	}
	public List getAllChildDepartByFullCode(Department depart) {
		// TODO Auto-generated method stub
		return queryForList("getAllChildDepartmentByFullCode", depart);
	}

	public List getChildDepartCs(Department depart) {
		// TODO Auto-generated method stub
		  return queryForList("getChildDepartmentCs", depart);
	}

	public boolean checkChild(Department depart) {
		// TODO Auto-generated method stub
		Object obj = queryForObject("checkChild", depart);
		return new Integer(obj.toString()).intValue()>0;
	}
	/** 获得下一个排序号 */
	public Department getNextNodeorder(Department department)
	{
		return (Department)queryForObject("getNextNodeorder", department);
	}

	/** @param 机构(t_department) 多条查询 */
	public List getListAllDepartment(Department department){
		// TODO: implement
		return queryForList("getAllDepartmentListNoPage", department);
	}

}
