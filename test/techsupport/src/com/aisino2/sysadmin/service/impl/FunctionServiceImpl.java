package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IFunctionDao;
import com.aisino2.sysadmin.dao.IRole_funcDao;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.service.IFunctionService;

public class FunctionServiceImpl extends BaseService implements IFunctionService {

	private IFunctionDao functionDao;
	  private IRole_funcDao role_funcDao;

	/** @param 功能(t_function) 增加 */
	public Function insertFunction(Function function){
		// TODO: implement
		return (Function)functionDao.insertFunction(function);
	}

	/** @param 功能(t_function) 删除 */
	public boolean deleteFunction(Function function){
		// TODO: implement
		role_funcDao.deleteRoleFunctionByFunction(function);
	    return functionDao.deleteFunction(function)>0;
	}

	/** @param 功能(t_function) 修改 */
	public boolean updateFunction(Function function){
		// TODO: implement
		return functionDao.updateFunction(function)>0;
	}

	/** @param 功能(t_function) 查询单条 */
	public Function getFunction(Function function){
		// TODO: implement
		return (Function)functionDao.getFunction(function);
	}

	/** @param 功能(t_function) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return functionDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 功能(t_function) 多条查询 */
	public List getListFunction(Function function){
		// TODO: implement
		return functionDao.getListFunction(function);
	}

	public IFunctionDao getFunctionDao() {
		return functionDao;
	}

	public void setFunctionDao(IFunctionDao functionDao) {
		this.functionDao = functionDao;
	}


	public List getOwnFunction(Function function) {
		// TODO Auto-generated method stub
		List funcList =  functionDao.getOwnFunction(function);
		 return funcList.size()>0 ?  funcList : null;
	}

	public boolean checkFunction(Function function) {
		// TODO Auto-generated method stub
		return functionDao.checkFunction(function);
	}

	public boolean findFuncDefine(Function function) {
		// TODO Auto-generated method stub
		return functionDao.findFuncDefine(function);
	}

	public List getParam(Function function) {
		// TODO Auto-generated method stub
		Role_func  role_func = new Role_func();
		role_func.setRoleid(function.getRoleid());
		role_func.setFuncdefine(function.getFuncdefine());
		return role_funcDao.getParam(role_func);
	}

	public IRole_funcDao getRole_funcDao() {
		return role_funcDao;
	}

	public void setRole_funcDao(IRole_funcDao role_funcDao) {
		this.role_funcDao = role_funcDao;
	}


}
