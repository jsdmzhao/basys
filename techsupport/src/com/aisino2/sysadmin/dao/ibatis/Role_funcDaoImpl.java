package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IRole_funcDao;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;

public class Role_funcDaoImpl extends BaseDao implements IRole_funcDao {
	/** @param 角色功能(t_role_func) 增加 */
	public Role_func insertRole_func(Role_func role_func){
		// TODO: implement

		return (Role_func)insert("insertRole_func", role_func);
	}

	/** @param 角色功能(t_role_func) 删除 */
	public int deleteRole_func(Role_func role_func){
		// TODO: implement
		return delete("deleteRole_func", role_func);
	}

	/** @param 角色功能(t_role_func) 修改 */
	public int updateRole_func(Role_func role_func){
		// TODO: implement
		return update("updateRole_func", role_func);
	}

	/** @param 角色功能(t_role_func) 查询单条 */
	public Role_func getRole_func(Role_func role_func){
		// TODO: implement
		return (Role_func)queryForObject("getRole_func", role_func);
	}

	/** @param 角色功能(t_role_func) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Roleid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getRole_funcList", map, pageNo,pageSize);
	}
	

	/** @param 角色功能(t_role_func) 多条查询 */
	public List getListRole_func(Role_func role_func){
		// TODO: implement
		return queryForList("getRole_funcListNoPage", role_func);
	}
	
	/** @param 角色功能(t_role_func) 多条查询 */
	public Page getRoleFunctionList(Map map, int pageNo,int pageSize){
		// TODO: implement
		return queryForPage("getRoleFunctionList", map, pageNo,pageSize);
	}

	public List getParam(Role_func role_func) {
		// TODO Auto-generated method stub
		return queryForList("getRoleFuncParam", role_func);
	}

	public int deleteRoleFunctionByFunction(Function function) {
		// TODO Auto-generated method stub
		return this.delete("deleteRoleFunctionByFunction", function);
	}

	public int deleteRoleFunctionByRole(Role role) {
		// TODO Auto-generated method stub
		return this.delete("deleteRoleFunctionByRole", role);
	}



	public int updateRoleFunctionParam(Role_func role_func) {
		// TODO Auto-generated method stub
		return update("updateRoleFunctionParam", role_func);
	}

	public List getFunctionListNotInRole(Role_func role_func) {
		// TODO Auto-generated method stub
		return queryForList("getFunctionListNotInRole", role_func);
	}

	public Page getRoleFunctionForPage(Map condition, int pageNo) {
		// TODO Auto-generated method stub
		return queryForPage("getRoleFunctionList", condition, pageNo);
	}
}
