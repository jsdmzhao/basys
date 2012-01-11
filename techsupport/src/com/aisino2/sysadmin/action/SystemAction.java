package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.service.ISystemService;

public class SystemAction extends PageAction{
	private ISystemService systemService;
	private List lSystem;
	private List ldata;
	private System system;
	private System nowSystem;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	private String moveParentid;
	private String moveSelectId;
	private String moveWay;
	
	private String strResult;
	
	public List getLdata() {
		return ldata;
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

	public System getSystem() {
		return system;
	}
	
	public List getLSystem() {
		return lSystem;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}
	
	public System getNowSystem() {
		return nowSystem;
	}

	public void setMoveParentid(String moveParentid) {
		this.moveParentid = moveParentid;
	}

	public void setMoveSelectId(String moveSelectId) {
		this.moveSelectId = moveSelectId;
	}

	public void setMoveWay(String moveWay) {
		this.moveWay = moveWay;
	}

	public String getStrResult() {
		return strResult;
	}

	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("systemcode");
		lPro.add("systemcode");
		lPro.add("systemname");
		lPro.add("parentsystemname");
    	
		List lDetail=new ArrayList();
		lDetail.add("setSysDetail");
		lDetail.add("详细");
    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lDetail);
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	System getSystem=new System();
    	
        this.setData(getSystem,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 系统管理入口 参数：当前系统代码
	 * @return
	 */
	public String querySystem(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String systemcode = request.getParameter("systemcode");
		if(systemcode==null||"".equals(systemcode)){
			systemcode = "0";
		}
		request.setAttribute("systemcode", systemcode);
		return SUCCESS;
	}
	/**
	 * 显示当前系统信息
	 * @return
	 */
	public String showSystem() throws Exception{
		try {
			System setSystem=new System();
			nowSystem=(System)this.setClass(setSystem, null);
			nowSystem=systemService.getSystem(nowSystem);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 根据条件 请求列表
	 * @return
	 */
	public String querylist() throws Exception{
		try {
			System setSystem=new System();
			system=(System)this.setClass(setSystem, null);
			Map map = new HashMap();
			if(system!=null){
				map.put("parentsystemcode", system.getSystemcode());
			}
			Page page = systemService.getListForPage(map, pagesize, pagerow,null,null);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledata(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		 this.result="success";
        return "success";
    }
	/**
	 * 查找单条
	 * @return
	 */
	public String query() throws Exception{
		try {
			System setSystem=new System();
			system=(System)this.setClass(setSystem, null);
			system=systemService.getSystem(system);
			lSystem = new ArrayList();
			lSystem.add(system);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			System setSystem=new System();
			system=(System)this.setClass(setSystem, null);
			system=systemService.insertSystem(system);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			System setSystem=new System();
			system=(System)this.setClass(setSystem, null);
			systemService.updateSystem(system);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			System setSystem=new System();
			system=(System)this.setClass(setSystem, null);
			systemService.deleteSystem(system);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 移动排序
	 * @return
	 */
	public String moveSort(){
		try {
			System moveSys = new System();
			moveSys.setParentsystemcode(moveParentid);
			moveSys.setSystemcode(moveSelectId);
			moveSys.setWay(moveWay);
			systemService.updateSystemEditEdOrder(moveSys);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	/**
	 * 获取 兄弟节点最大排序号
	 * @return
	 */
	public String nextNodeorder(){
		try {
			strResult = "";
			System setSystem=new System();
			setSystem=(System)this.setClass(setSystem, null);
			strResult = String.valueOf(systemService.getNextNodeorder(setSystem));
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	/**
	 * 验证系统代码
	 * @return
	 */
	public String validateSystem(){
		try {
			System setSystem=new System();
			system=(System)this.setClass(setSystem, null);
			String systemcode = system.getSystemcode();
			Map map = new HashMap();
			map.put("tableName", "t_system");
			if(systemcode!=""){
				map.put("systemcode", systemcode);
			}
			boolean result = systemService.isExit(map);
			strResult = "";
			if(result){	
				strResult = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	
	
	/**
	 * 系统下拉列表查询
	 * @return
	 * @throws Exception
	 */	
public String querySelSystem() throws Exception{
	try {
		System setSystem=new System();
		system=(System)this.setClass(setSystem, null);
		//setDict_item.setDict_code(dict_code);
		//}
		ldata = new ArrayList();
		
		ldata=systemService.getListSystem(system);
		
		if(ldata==null)
			ldata = new ArrayList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.result="success";
	return "success";
}

}