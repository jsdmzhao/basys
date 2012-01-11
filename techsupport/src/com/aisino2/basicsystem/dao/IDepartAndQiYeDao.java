package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.sysadmin.domain.Department;
public interface IDepartAndQiYeDao {
	/** @param 企业或场所多条查询*/
	List QyTreeList(Map map);
	
	/** @param 企业或场所多条查询*/
	List QyJlTreeList(Map map);
	
	/** @param 企业或场所  获得指定级别的机构下所有子机构，并且该子机构拥有企业或场所*/
	List ChildDepartmentForTree(Department department);
}
