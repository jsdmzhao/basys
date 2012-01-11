package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IRole_funcDao;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.service.IRole_funcService;

public class Role_funcServiceImpl extends BaseService implements IRole_funcService {

	private IRole_funcDao role_funcDao;

	/** @param 角色功能(t_role_func) 增加 */
	public Role_func insertRole_func(Role_func role_func){
		// TODO: implement
		return (Role_func)role_funcDao.insertRole_func(role_func);
	}

	/** @param 角色功能(t_role_func) 删除 */
	public boolean deleteRole_func(Role_func role_func){
		// TODO: implement
		return role_funcDao.deleteRole_func(role_func)>0;
	}

	/** @param 角色功能(t_role_func) 修改 */
	public boolean updateRole_func(Role_func role_func){
		// TODO: implement
		return role_funcDao.updateRole_func(role_func)>0;
	}

	/** @param 角色功能(t_role_func) 查询单条 */
	public Role_func getRole_func(Role_func role_func){
		// TODO: implement
		return (Role_func)role_funcDao.getRole_func(role_func);
	}
	 
		/** @param 角色功能(t_role_func) 分页查询 */
		public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
			// TODO: implement
			return role_funcDao.getListForPage(map,pageNo,pageSize,sort,desc);
		}	
	 
	 /** @param 角色功能(t_role_func) 分页查询 */
		public Page getRoleFunctionList(Map map, int pageNo, int pageSize){
			// TODO: implement
			return role_funcDao.getRoleFunctionList(map,pageNo,pageSize);
		}

	/** @param 角色功能(t_role_func) 多条查询 */
	public List getListRole_func(Role_func role_func){
		// TODO: implement
		return role_funcDao.getListRole_func(role_func);
	}

	public IRole_funcDao getRole_funcDao() {
		return role_funcDao;
	}

	public void setRole_funcDao(IRole_funcDao role_funcDao) {
		this.role_funcDao = role_funcDao;
	}

	public List getParam(Role_func role_func) {
		// TODO Auto-generated method stub
		List rfList = role_funcDao.getParam(role_func);
		return rfList.size()>0 ? rfList:null;
	}
	
	/** @param  查询菜单下在Role_func中不存在的功能 */
	public List getFunctionListNotInRole(Role_func role_func) {
		// TODO Auto-generated method stub
		return role_funcDao.getFunctionListNotInRole(role_func);
	}
}
