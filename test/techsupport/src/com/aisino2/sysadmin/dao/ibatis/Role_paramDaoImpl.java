package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IRole_paramDao;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_param;

public class Role_paramDaoImpl extends BaseDao implements IRole_paramDao {
	/** @param 角色参数(t_role_param) 增加 */
	public Role_param insertRole_param(Role_param role_param){
		// TODO: implement
		//role_param.setRoleid(getNextID("Roleid"));
		insert("insertRole_param", role_param);
		return role_param;
	}

	/** @param 角色参数(t_role_param) 删除 */
	public int deleteRole_param(Role_param role_param){
		// TODO: implement
		return delete("deleteRole_param", role_param);
	}

	/** @param 角色参数(t_role_param) 修改 */
	public int updateRole_param(Role_param role_param){
		// TODO: implement
		return update("updateRole_param", role_param);
	}

	/** @param 角色参数(t_role_param) 查询单条 */
	public Role_param getRole_param(Role_param role_param){
		// TODO: implement
		return (Role_param)queryForObject("getRole_param", role_param);
	}

	/** @param 角色参数(t_role_param) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Roleid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getRole_paramList", map, pageNo,pageSize);
	}

	/** @param 角色参数(t_role_param) 多条查询 */
	public List getListRole_param(Role_param role_param){
		// TODO: implement
		return queryForList("getRole_paramListNoPage", role_param);
	}

	public int deleteRoleParamByRole(Role role) {
		// TODO Auto-generated method stub
		return this.delete("deleteRoleParamByRole", role);
	}
}
