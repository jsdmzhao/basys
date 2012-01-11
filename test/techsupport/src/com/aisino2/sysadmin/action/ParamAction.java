package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Param;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_param;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IParamService;
import com.aisino2.sysadmin.service.IRoleService;
import com.aisino2.sysadmin.service.IRole_paramService;

public class ParamAction extends PageAction{
	private IParamService paramService;
	private IRoleService roleService;
	private IRole_paramService roleParamService;
	private List lParam = new ArrayList();
	private Param param;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setRoleParamService(IRole_paramService roleParamService) {
		this.roleParamService = roleParamService;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Param getParam() {
		return param;
	}
	
	public List getLParam() {
		return lParam;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setParamService(IParamService paramService) {
		this.paramService = paramService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("paramcode");
		lPro.add("paramcode");
		lPro.add("paramname");
		lPro.add("paramvalue");


		List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Param getParam=new Param();
    	
        this.setData(getParam,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	

	public void setTabledataRole_Param(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("roleid");
		lPro.add("checkbox");
		lPro.add("departname");
		lPro.add("rolename");
		lPro.add("roletype");
    	
    	Role getRole=new Role();
    	
        this.setData(getRole,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	public String querylist() throws Exception{
		try{
		Param setParam=new Param();
		param=(Param)this.setClass(setParam, null);
        Map map = new HashMap();
        if(param!=null){
        	map.put("", "");
        	map.put("", "");
        }
        Page page = paramService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lParam=page.getData();
        setTabledata(lParam); 
		 this.result="success";
		}catch(Exception e){
			this.result = "查询失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	/**
	 * 根据部门ID 查角色
	 * @return
	 */
	public String queryRoleList() throws Exception{
		try {
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User sessionUser = (User)session.getAttribute(Constants.userKey);
			
			Role setRole=new Role();
			setRole=(Role)this.setClass(setRole, null);
			
			setRole.setDepartcode(StringUtil.trimEven0(sessionUser.getDepartment().getDepartcode()));
			
			List lRole = roleService.getListRole(setRole);

			Role_param role_param = new Role_param();
			role_param=(Role_param)this.setClass(role_param, null);
			List roleParamList = roleParamService.getListRole_param(role_param);
			if(roleParamList==null)
				roleParamList = new ArrayList();
			
			if(lRole!=null&&lRole.size()>0){
				for(int index=0,max=lRole.size();index<max;index++){
					int bzw = 0;
					Role temp = (Role)lRole.get(index);
					
					for(java.util.Iterator iter=roleParamList.iterator();iter.hasNext();){
						Role_param newRoleParam = (Role_param)iter.next();
						if(temp.getRoleid().equals(newRoleParam.getRoleid())){
							bzw = 1;
							break;
						}
					}
					
					if(bzw==1)
						temp.setCheckbox("<input type='checkbox' name='"+temp.getRoleid()+"' style='width:16' onClick='validateChecked(this);' checked='true' />");
					else
						temp.setCheckbox("<input type='checkbox' name='"+temp.getRoleid()+"' style='width:16' onClick='validateChecked(this);' />");
				}
			}
			
			
			setTabledataRole_Param(lRole);
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result="查询失败";
		}
        return "success";
    }
	
	
	public String query() throws Exception{
		try {
			Param setParam=new Param();
			param=(Param)this.setClass(setParam, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        param=paramService.getParam(param);
        lParam = new ArrayList();
        //lParam.clear();
        lParam.add(param);
		this.result="success";
        return "success";
    }
	
//	参数树节点点击链接Action
	public String queryParam(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String paramcode = request.getParameter("paramcode");
		if(paramcode==null||"".equals(paramcode)){
			paramcode = "0";
		}
		request.setAttribute("paramcode", paramcode);
		return SUCCESS;
	}
	
	/**
	 * 新增角色时，设置角色参数
	 * @return
	 */
	public String insertRoleParam(){
		try {
			Param setParam = new Param();
			param=(Param)this.setClass(setParam, null);//得到roleid
//			User setUser=new User();
//			setUser=(User)this.setClass(setUser, null);//得到userid集合
//			
			String paramcode = param.getParamcode();
			String roleidSet = param.getRoleidSet();
			if(roleidSet!=null && !roleidSet.equals("")){
				String[] roleidArry = roleidSet.split("_,,");
				List role_paramList = new ArrayList();
				for(int index=0,max=roleidArry.length;index<max;index++){
					Role_param temp = new Role_param();
					temp.setParamcode(paramcode);
					temp.setRoleid(Integer.parseInt(roleidArry[index]));
					role_paramList.add(temp);
				}
				param.setLRoleParamList(role_paramList);
			}
			paramService.insertParam(param);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="保存失败";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	/**
	 * 修改角色时，设置角色参数
	 * @return
	 */
	public String updateRoleParam(){
		try {
			Param setParam = new Param();
			param=(Param)this.setClass(setParam, null);//得到roleid
			
			String paramcode = param.getParamcode();
			String roleidSet = param.getRoleidSet();
			if(roleidSet!=null && !roleidSet.equals("")){
				String[] roleidArry = roleidSet.split("_,,");
				List role_paramList = new ArrayList();
				for(int index=0,max=roleidArry.length;index<max;index++){
					Role_param temp = new Role_param();
					temp.setParamcode(paramcode);
					temp.setRoleid(Integer.parseInt(roleidArry[index]));
					role_paramList.add(temp);
				}
				param.setLRoleParamList(role_paramList);
			}
			paramService.updateParam(param);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="修改失败";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	/**
	 * 删除角色时，删除角色参数
	 * @return
	 */
	public String deleteRoleParam() throws Exception{
		try {
			Param setParam=new Param();
			param=(Param)this.setClass(setParam, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        paramService.deleteParam(param);
        this.result="success";
        return "success";
    }
	
	/**
	 * 参数列表查询,不分页
	 * @return
	 * @throws Exception
	 */
	public String queryParamListNoPage() throws Exception{
		try {
			Param setParam = new Param();
			param=(Param)this.setClass(setParam, null);
			lParam = paramService.getListParam(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		this.result="success";
        return "success";
    }
}