package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Aqjcsb;
import com.aisino2.publicsystem.service.IAqjcsbService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class AqjcsbAction extends PageAction{
	private IAqjcsbService aqjcsbService;
	private List lAqjcsb=new ArrayList();
	private Aqjcsb aqjcsb=new Aqjcsb();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private String requestType="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Aqjcsb getAqjcsb() {
		return aqjcsb;
	}
	
	public List getLAqjcsb() {
		return lAqjcsb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setAqjcsbService(IAqjcsbService aqjcsbService) {
		this.aqjcsbService = aqjcsbService;
	}
	/**
	 * 安全检查设备列表
	 * @param lData
	 * @throws Exception
	 */
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("anjcsbid");
		lPro.add("sbmc");
		lPro.add("ggxh");
		lPro.add("aqjcsbzlmc");
		lPro.add("azsl");
		lPro.add("aqjcsbzlbm");
    	
		/*List lCol=new ArrayList();
    	List lDel=new ArrayList();
    	lDel.add("aqjcsb_setDelete");
    	lDel.add("删除");
    	lCol.add(lDel);*/
    	
    	
    	Aqjcsb getAqjcsb=new Aqjcsb();
    	
        this.setData(getAqjcsb,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	public String aqjStop() throws Exception{
		try {
			List oldList = new ArrayList();
			Aqjcsb setAqjcsb=new Aqjcsb();
			Aqjcsb newAqjcsb=new Aqjcsb();
			Object[] objA={setAqjcsb};
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, objA);
			newAqjcsb=(Aqjcsb)this.setClass(newAqjcsb, null);
			oldList=setAqjcsb.getLAqjcsbList();
			int modify = setAqjcsb.getAnjcsbid();
			newAqjcsb.setAnjcsbid(newAqjcsb.getOldanjcsbid());
			oldList.set(modify, newAqjcsb);
			String strListType = newAqjcsb.getListtype();//取得列表类型
			setJFSBTabledata(setObjectIdForHtmlList(oldList));
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }  
	/**
	 * 技防设备列表
	 * @param lData
	 * @throws Exception
	 */
	public void setJFSBTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("anjcsbid");
		lPro.add("sbmc");
		lPro.add("ggxh");
		lPro.add("aqjcsbzlmc");
		lPro.add("aqjcsbzlbm");
		lPro.add("azsl");
		lPro.add("bz");
		lPro.add("lrr");
	    lPro.add("lrsj");

	    lPro.add("jibr");
		lPro.add("zt");
		lPro.add("tysj");
	    lPro.add("tyyy");
	    lPro.add("hylb");
	    lPro.add("qymc");
   
    	Aqjcsb getAqjcsb=new Aqjcsb();
    	
        this.setData(getAqjcsb,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			requestType = "";
			Aqjcsb setAqjcsb=new Aqjcsb();
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, null);
			requestType = setAqjcsb.getAqjcsbRequetType();
			Map map = new HashMap();
			map.put("qyid", setAqjcsb.getQyid());
			map.put("zt", "1");
			Page page = aqjcsbService.getListForPage(map, pagesize, pagerow,null,null);
			lAqjcsb=page.getData();
			String strListType = setAqjcsb.getListtype();//取得列表类型
			if(strListType!= null && "jfsb".equals(strListType)){
				setJFSBTabledata(lAqjcsb);
			}else{
				setTabledata(lAqjcsb);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	
	public String Aqquerylist() throws Exception{
		try {
			requestType = "";
			Aqjcsb setAqjcsb=new Aqjcsb();
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, null);
			requestType = setAqjcsb.getAqjcsbRequetType();
			Map map = new HashMap();
			map.put("qyid", setAqjcsb.getQyid());
			map.put("hylbdm", setAqjcsb.getHylbdm());
			map.put("qymc", setAqjcsb.getQymc());
			map.put("sbmc", setAqjcsb.getSbmc());
			map.put("ggxh", setAqjcsb.getGgxh());
			map.put("aqjcsbzlmc", setAqjcsb.getAqjcsbzlmc());
			map.put("aqjcsbzlbm", setAqjcsb.getAqjcsbzlbm());
			map.put("qybm", setAqjcsb.getQybm());
			map.put("zt", setAqjcsb.getZt());
			Page page = aqjcsbService.getjfsbGadListForPage(map, pagesize, pagerow,null,null);
			lAqjcsb=page.getData();
			setAQJFSBTabledata(lAqjcsb);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	/**
	 * 技防设备列表
	 * @param lData
	 * @throws Exception
	 */
	public void setAQJFSBTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("anjcsbid");
		lPro.add("hylb");
		lPro.add("qymc");
		lPro.add("sbmc");
		lPro.add("ggxh");
		lPro.add("aqjcsbzlmc");
    	lPro.add("azsl");
		lPro.add("lrr");
	    lPro.add("lrsj");
	    lPro.add("qyid");
        lPro.add("bz");
        lPro.add("hylbdm");
	    
	    
    	Aqjcsb getAqjcsb=new Aqjcsb();
    	
        this.setData(getAqjcsb,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String query() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Aqjcsb setAqjcsb=new Aqjcsb();
			Object[] objA={setAqjcsb};
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, objA);
			oldList = setAqjcsb.getLAqjcsbList();
			lAqjcsb = new ArrayList();
			lAqjcsb.add(oldList.get(setAqjcsb.getAnjcsbid()));
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Aqjcsb setAqjcsb=new Aqjcsb();
			Aqjcsb newAqjcsb=new Aqjcsb();
			Object[] objA={setAqjcsb};
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, objA);
			newAqjcsb=(Aqjcsb)this.setClass(newAqjcsb, null);
			oldList = setAqjcsb.getLAqjcsbList();
			oldList.add(setAqjcsb);
			String strListType = newAqjcsb.getListtype();//取得列表类型
			if(strListType != null && "jfsb".equals(strListType)){
				setJFSBTabledata(setObjectIdForHtmlList(oldList));
			}else{
				setTabledata(setObjectIdForHtmlList(oldList)); 
			}
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			List oldList = new ArrayList();
			Aqjcsb setAqjcsb=new Aqjcsb();
			Aqjcsb newAqjcsb=new Aqjcsb();
			Object[] objA={setAqjcsb};
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, objA);
			newAqjcsb=(Aqjcsb)this.setClass(newAqjcsb, null);
			oldList=setAqjcsb.getLAqjcsbList();
			int modify = setAqjcsb.getAnjcsbid();
		 	newAqjcsb.setAnjcsbid(newAqjcsb.getOldanjcsbid());
			oldList.set(modify, newAqjcsb);
			String strListType = newAqjcsb.getListtype();//取得列表类型
			if(strListType != null && "jfsb".equals(strListType)){
				setJFSBTabledata(setObjectIdForHtmlList(oldList));
			}else{
				setTabledata(setObjectIdForHtmlList(oldList)); 
			}
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	public String delete() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Aqjcsb setAqjcsb=new Aqjcsb();
			Aqjcsb newAqjcsb=new Aqjcsb();
			Object[] objA={setAqjcsb};
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, objA);
			newAqjcsb=(Aqjcsb)this.setClass(newAqjcsb, null);
			oldList = setAqjcsb.getLAqjcsbList();
			int delId = setAqjcsb.getAnjcsbid();
			oldList.remove(delId);
			String strListType = newAqjcsb.getListtype();//取得列表类型
			if(strListType != null && "jfsb".equals(strListType)){
				setJFSBTabledata(setObjectIdForHtmlList(oldList));
			}else{
				setTabledata(setObjectIdForHtmlList(oldList)); 
			}
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return "success";
    }
	
	public List setObjectIdForHtmlList(List allResult){
		List result = new ArrayList();
		if(allResult!=null&&allResult.size()>0){
			for(int index=0,max=allResult.size();index<max;index++){
				Aqjcsb temp = (Aqjcsb)allResult.get(index);
				if(temp.getAnjcsbid()==null) {
				  temp.setAnjcsbid(1);
				}
				result.add(temp);
			}
		}
		return result;
	}
	//下面是娱乐场所公安端 安全检查设备查询
	public void setTabledataGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		
		lPro.add("sbmc");
		lPro.add("ggxh");
		lPro.add("aqjcsbzlmc");
		
		lPro.add("azsl");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("aqjcsbzlbm");
		
		List lCol=new ArrayList();
    	List lDel=new ArrayList();
    	lDel.add("");
    	lDel.add("详情");
    	lCol.add(lDel);
    	
    	Aqjcsb setAqjcsb=new Aqjcsb();
    	
        this.setData(setAqjcsb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String queryAqjcListGnd() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Aqjcsb setAqjcsb=new Aqjcsb();
			setAqjcsb=(Aqjcsb)this.setClass(setAqjcsb, null);
			Map map = new HashMap();
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode())); //session
			map.put("sfyx", "1");
			map.put("qyid", setAqjcsb.getQyid());
			map.put("qybm", setAqjcsb.getQybm());
			map.put("ggxh", setAqjcsb.getGgxh());
			map.put("sbmc", setAqjcsb.getSbmc());
			map.put("aqjcsbzlmc", setAqjcsb.getAqjcsbzlmc());
			map.put("aqjcsbzlbm", setAqjcsb.getAqjcsbzlbm());
			map.put("hylbdm", null);
			map.put("allhylbdm", setAqjcsb.getHylbdm());
			
			map.put("superbWhere", setAqjcsb.getSuperbWhere()); //高级查询条件
			map.put("superbOrderBy", setAqjcsb.getSuperbOrderBy());
			
			Page page = aqjcsbService.getAqjcsbGadListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledataGad(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
}