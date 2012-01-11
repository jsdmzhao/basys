package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IParamDao;
import com.aisino2.sysadmin.dao.IRole_paramDao;
import com.aisino2.sysadmin.domain.Param;
import com.aisino2.sysadmin.domain.Role_param;
import com.aisino2.sysadmin.service.IParamService;

public class ParamServiceImpl extends BaseService implements IParamService {

	private IParamDao paramDao;
	private IRole_paramDao role_paramDao;

	/** @param 参数设置(t_param) 增加 */
	public Param insertParam(Param param){
		// TODO: implement
		//return (Param)paramDao.insertParam(param);
		Role_param role_param = null;
		//增加参数
		paramDao.insertParam(param);
		//增加角色参数
		if(param.getLRoleParamList()!=null)
		{
			for(int i = 0;i<param.getLRoleParamList().size();i++)
			{
				role_param = new Role_param();
				role_param = (Role_param)param.getLRoleParamList().get(i);
				role_param.setParamcode(param.getParamcode());
				role_paramDao.insertRole_param(role_param);
				role_param = null;
			}
		}
		return param;
	}

	/** @param 参数设置(t_param) 删除 */
	public boolean deleteParam(Param param){
		// TODO: implement
		//return paramDao.deleteParam(param)>0;
		boolean isSuccess = false;
		Role_param role_param = new Role_param();
		//删除所有角色参数
		role_param.setParamcode(param.getParamcode());
		role_paramDao.deleteRole_param(role_param);
		//删除参数
		paramDao.deleteParam(param);
		isSuccess = true;
		return isSuccess;
	}

	/** @param 参数设置(t_param) 修改 */
	public boolean updateParam(Param param){
		// TODO: implement
		//return paramDao.updateParam(param)>0;
		boolean isSuccess = false;
		Role_param role_param = new Role_param();
		//修改参数
		paramDao.updateParam(param);
		//删除所有角色参数
		role_param.setParamcode(param.getParamcode());
		role_paramDao.deleteRole_param(role_param);
		//增加角色参数
		if(param.getLRoleParamList()!=null)
		{
			for(int i = 0;i<param.getLRoleParamList().size();i++)
			{
				role_param = null;
				role_param = new Role_param();
				role_param = (Role_param)param.getLRoleParamList().get(i);
				role_param.setParamcode(param.getParamcode());
				role_paramDao.insertRole_param(role_param);
			}
		}
		isSuccess = true;
		return isSuccess;
	}

	/** @param 参数设置(t_param) 查询单条 */
	public Param getParam(Param param){
		// TODO: implement
		return (Param)paramDao.getParam(param);
	}

	/** @param 参数设置(t_param) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return paramDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 参数设置(t_param) 多条查询 */
	public List getListParam(Param param){
		// TODO: implement
		return paramDao.getListParam(param);
	}

	public IParamDao getParamDao() {
		return paramDao;
	}

	public void setParamDao(IParamDao paramDao) {
		this.paramDao = paramDao;
	}

	public void setRole_paramDao(IRole_paramDao role_paramDao) {
		this.role_paramDao = role_paramDao;
	}
}
