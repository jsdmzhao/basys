package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.service.IRole_funcService;

public class Role_FuncAction extends PageAction{
	private IRole_funcService role_funcService;
	private List lRole_func = new ArrayList();
	private List lfunction = new ArrayList();
	private Role_func role_func;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	public List getLfunction() {
		return lfunction;
	}

	public void setLfunction(List function) {
		lfunction = function;
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

	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setRole_funcService(IRole_funcService role_funcService) {
		this.role_funcService = role_funcService;
	}

	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("roleid");
		lPro.add("funccode");
		lPro.add("funcname");
		lPro.add("functype");
		lPro.add("funcdefine");

    	List lCol=new ArrayList();
    	
		Role_func getRole_func=new Role_func();
    	
        this.setData(getRole_func,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Role_func setRole=new Role_func();
			role_func=(Role_func)this.setClass(setRole, null);
			Map map = new HashMap();
	        if(role_func!=null){
	        	map.put("roleid", role_func.getRoleid());
	        }
	        Page page = role_funcService.getRoleFunctionList(map, pagesize, pagerow);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lRole_func=page.getData();
	        for(java.util.Iterator iter=lRole_func.iterator();iter.hasNext();){
				Role_func objRole_func = (Role_func)iter.next();
				objRole_func.setFuncdefine("<input type='checkbox' name='"+objRole_func.getSystemcode()+"' />");
			}
	        setTabledata(lRole_func); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	public String listRoleFunc() throws Exception{
		 try {
	        	Role_func setRole_func=new Role_func();
				role_func=(Role_func)this.setClass(setRole_func, null);
				lfunction = role_funcService.getFunctionListNotInRole(role_func);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        this.result="success";
	        return "success";
	}
	
	/*依据roleid查询role_func*/
	public String listByRole() throws Exception{
		   
        try {
        	Role_func setRole_func=new Role_func();
        	Object []funcObj = {setRole_func};
			role_func=(Role_func)this.setClass(setRole_func, funcObj);
			lRole_func = role_func.getLFuncList();
			for(java.util.Iterator iter=lRole_func.iterator();iter.hasNext();){
				Role_func objRole_func = (Role_func)iter.next();
				objRole_func.setRoleid(role_func.getRoleid());
				objRole_func.setFuncdefine("<input type='checkbox' name='"+role_func.getSystemcode()+"' />");
			}
			setTabledata(lRole_func); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        this.result="success";
        return "success";
    }	

}