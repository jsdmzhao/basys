package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IRoleDao;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.User;

public class RoleDaoImpl extends BaseDao implements IRoleDao {
	/** @param 角色(t_role) 增加 */
	public Role insertRole(Role role){
		// TODO: implement
		role.setRoleid(getNextID("Roleid"));
		return (Role)insert("insertRole", role);
	}

	/** @param 角色(t_role) 删除 */
	public int deleteRole(Role role){
		// TODO: implement
		return delete("deleteRole", role);
	}

	/** @param 角色(t_role) 修改 */
	public int updateRole(Role role){
		// TODO: implement
		return update("updateRole", role);
	}

	/** @param 角色(t_role) 查询单条 */
	public Role getRole(Role role){
		// TODO: implement
		return (Role)queryForObject("getRole", role);
	}

	/** @param 角色(t_role) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.rolename "+ desc;
			else if(sort.equals("1"))
				sCol = " a.roletype "+ desc;
			else if(sort.equals("2"))
				sCol = " a.roledescription "+ desc;
			else
				sCol = " a.rolename ";
		}else{
			sCol=" a.rolename ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getRoleList", map, pageNo,pageSize);
	}

	/** @param 角色(t_role) 多条查询 */
	public List getListRole(Role role){
		// TODO: implement
		return queryForList("getRoleListNoPage", role);
	}

	public List getOptionRolesForUser(User user) {
		// TODO Auto-generated method stub
		 return queryForList("getOptionRolesForUser",user);
	}

	public List getRolesByUser(User user) {
		// TODO Auto-generated method stub
		 return queryForList("getRolesByUser",user);
	}

	public List getloginUserRoleOutDeptList(User user) {
		// TODO Auto-generated method stub
		return queryForList("getloginUserRoleOutDeptList", user);
	}

	public List getDeptRoleList(User user) {
		// TODO Auto-generated method stub
		return queryForList("getDeptRoleList", user);
	}
}
