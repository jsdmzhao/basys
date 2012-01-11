package com.aisino2.basicsystem.service;

import java.util.List;

import com.aisino2.basicsystem.domain.YlcsjbxxForTree;
import com.aisino2.sysadmin.domain.Department;

public interface IDepartAndQiYeService {
	List QyJlTreeList(YlcsjbxxForTree ylcsjbxxForTree);
	/** @param 企业或场所多条查询*/
	List QyTreeList(YlcsjbxxForTree ylcsjbxxForTree,String hylbdm);
	
	/** @param 企业或场所  获得指定级别的机构下所有子机构，并且该子机构拥有企业或场所*/
	List ChildDepartmentForTree(Department department, String hylbdm);
}
