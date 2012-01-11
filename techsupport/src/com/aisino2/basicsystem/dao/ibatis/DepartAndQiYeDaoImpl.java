package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDepartAndQiYeDao;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.sysadmin.domain.Department;

public class DepartAndQiYeDaoImpl extends BaseDao implements IDepartAndQiYeDao {
	
	public List ChildDepartmentForTree(Department department) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("getChildDepartmentQiyeForTree", department);
	}

	public List QyTreeList(Map map) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("getQiyeTreeListNoPage", map);
	}
	
	public List QyJlTreeList(Map map) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("getQiyeJlTreeListNoPage", map);
	}

}
