package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.domain.Role_menu;
import com.aisino2.sysadmin.service.IRoleService;

public class RoleAction extends PageAction{
	private IRoleService roleService;
	private List lRole = new ArrayList();
	private Role role;
	private Role_func role_func;
	private String tabledata;
	private int totalrows;
	private List lRoleSystem;// 角色下的菜单所在的系统
	private List lRoleSystemMenu;// 指定角色及系统下的菜单
	private String result="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Role getRole() {
		return role;
	}
	
	public List getLRole() {
		return lRole;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public List getLRoleSystem() {
		return lRoleSystem;
	}

	public void setLRoleSystem(List roleSystem) {
		lRoleSystem = roleSystem;
	}

	public List getLRoleSystemMenu() {
		return lRoleSystemMenu;
	}

	public void setLRoleSystemMenu(List roleSystemMenu) {
		lRoleSystemMenu = roleSystemMenu;
	}

	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("roleid");
		lPro.add("rolename");
		lPro.add("roletype");
		lPro.add("roledescription");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lPurview=new ArrayList();
    	lPurview.add("setPurview");
    	lPurview.add("角色权限");    
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lPurview);
    	lCol.add(lDel);
    	
    	Role getRole=new Role();
    	
        this.setData(getRole,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Role setRole=new Role();
			setRole=(Role)this.setClass(setRole, null);
			Map map = new HashMap();
			if(setRole!=null){
				Integer departId = setRole.getDepartid();
				if(departId!=null && !departId.equals(new Integer(100))){
					map.put("departid", departId);
				}
				map.put("rolename", setRole.getRolename());
				map.put("jzlbdm", setRole.getJzlbdm());
			}
			Page page = roleService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledata(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String queryRole(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String departid = request.getParameter("departid");
		if(departid==null||"".equals(departid)){
			departid = "0";
		}
		request.setAttribute("departid", departid);
		return SUCCESS;
	}
	
	/*移动role,更改role的排列顺序(上移、下移、置顶、置底)*/
	public String moveRole () throws Exception{
		try {
			Role setRole=new Role();
			role=(Role)this.setClass(setRole, null);
			
			if(role!=null && role.getRoleid()!=null){
				String moveWay = role.getWay();
			
				role = roleService.getRole(role);
				
				role.setWay(moveWay);
		        roleService.updateRoleEditEdOrder(role);
			}
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="移动失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Role setRole=new Role();
			role=(Role)this.setClass(setRole, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        role=roleService.getRole(role);
        lRole.clear();
        lRole.add(role);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		
		try {
			Role setRole=new Role();
			role=(Role)this.setClass(setRole, null);
			if(role.getDepartid()==null||role.getDepartid().equals("")){
		        this.result="机构编码不能为空";
		        return "success";
			}
			role.setRoleNameType("1");
			lRole = roleService.getListRole(role);
			if(lRole!=null && lRole.size()>0){
		        this.result="该角色已经存在";
		        return "success";
			}
	        role=roleService.insertRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  this.result="添加失败";
		}
		
        this.result="success";
        return "success";
    }
	
	/*添加role_menu 和 role_func信息*/
	public String insFuncMenu() throws Exception{
		
		try {
			HttpSession session = this.getRequest().getSession();
			Map roleMenuMap = (Map)session.getAttribute("roleMenuMap");
			Role_menu setRole_menu = new Role_menu();
			Role_func setRole_func = new Role_func();
			//得到role的信息(roleid/选中的menu)
			Role setRole=new Role();
			Object []objRole_menu = {setRole_func,setRole_menu};
			role = (Role)this.setClass(setRole, objRole_menu);
			
			//得到选中的function的信息
			Object []objRole_func = {setRole_func,null};
			role_func=(Role_func)this.setClass(setRole_func, objRole_menu);
			
			role.setLRoleFunc(role_func.getLFuncList());
			role.setRoleMenuMap(roleMenuMap);
			
			roleService.updateRolemenuAndRolefunc(role);
			
			role_func = null;
			role = null;
			session.removeAttribute("roleMenuMap");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  this.result="修改失败";
		}
		
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Role setRole=new Role();
			role=(Role)this.setClass(setRole, null);
			
			setRole.setRoleNameType("1");
			setRole.setDepartid(role.getDepartid());
			setRole.setRolename(role.getRolename());
			lRole = roleService.getListRole(setRole);
			if(lRole!=null && lRole.size()>0){
				for(int index=0,length=lRole.size();index<length;index++){
					Role oneRole = (Role)lRole.get(index);
					if(!oneRole.getRoleid().equals(role.getRoleid())){
						this.result="该角色已经存在";
						return "success";
					}
				}
			}
	        roleService.updateRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 this.result="修改失败";
		}
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Role setRole=new Role();
			role=(Role)this.setClass(setRole, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        roleService.deleteRole(role);
        this.result="success";
        return "success";
    }
	
	/**
	 * 角色列表查询,不分页
	 * @return
	 * @throws Exception
	 */
	public String queryRoleListNoPage() throws Exception{
		try {
			Role setRole = new Role();
			role=(Role)this.setClass(setRole, null);
			lRole = roleService.getListRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		this.result="success";
        return "success";
    }
}