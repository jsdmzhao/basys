package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IRole_paramDao;
import com.aisino2.sysadmin.domain.Role_param;
import com.aisino2.sysadmin.service.IRole_paramService;

public class Role_paramServiceImpl extends BaseService implements IRole_paramService {

	private IRole_paramDao role_paramDao;

	/** @param 角色参数(t_role_param) 增加 */
	public Role_param insertRole_param(Role_param role_param){
		// TODO: implement
		return (Role_param)role_paramDao.insertRole_param(role_param);
	}

	/** @param 角色参数(t_role_param) 删除 */
	public boolean deleteRole_param(Role_param role_param){
		// TODO: implement
		return role_paramDao.deleteRole_param(role_param)>0;
	}

	/** @param 角色参数(t_role_param) 修改 */
	public boolean updateRole_param(Role_param role_param){
		// TODO: implement
		return role_paramDao.updateRole_param(role_param)>0;
	}

	/** @param 角色参数(t_role_param) 查询单条 */
	public Role_param getRole_param(Role_param role_param){
		// TODO: implement
		return (Role_param)role_paramDao.getRole_param(role_param);
	}

	/** @param 角色参数(t_role_param) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return role_paramDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 角色参数(t_role_param) 多条查询 */
	public List getListRole_param(Role_param role_param){
		// TODO: implement
		return role_paramDao.getListRole_param(role_param);
	}

	public IRole_paramDao getRole_paramDao() {
		return role_paramDao;
	}

	public void setRole_paramDao(IRole_paramDao role_paramDao) {
		this.role_paramDao = role_paramDao;
	}
}
