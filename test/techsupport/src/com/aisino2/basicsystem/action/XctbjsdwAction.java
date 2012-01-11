package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Xctbjsdw;
import com.aisino2.basicsystem.service.IXctbjsdwService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class XctbjsdwAction extends PageAction{
	private IXctbjsdwService xctbjsdwService;
	private List lXctbjsdw = new ArrayList();
	private Xctbjsdw xctbjsdw = new Xctbjsdw();
	private String tabledata;
	private int totalrows;
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

	public Xctbjsdw getXctbjsdw() {
		return xctbjsdw;
	}
	
	public List getLXctbjsdw() {
		return lXctbjsdw;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setXctbjsdwService(IXctbjsdwService xctbjsdwService) {
		this.xctbjsdwService = xctbjsdwService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		
		lPro.add("jsdwid");
		lPro.add("bt");
		lPro.add("sqsj");
		lPro.add("jsdwmc");

    	/*List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");*/
		List lXq=new ArrayList();
    	lXq.add("xctbhfDetail_xqck");
    	lXq.add("详情");
    	
    	List lCol=new ArrayList();
    	//lCol.add(lModify);
    	//lCol.add(lDel);
    	lCol.add(lXq);
    	
    	Xctbjsdw getXctbjsdw=new Xctbjsdw();
        this.setData(getXctbjsdw,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Xctbjsdw setXctbjsdw=new Xctbjsdw();
        xctbjsdw=(Xctbjsdw)this.setClass(setXctbjsdw, null);
        Map map = new HashMap();
        map.put("tbid", xctbjsdw.getTbid());
        Page page = xctbjsdwService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lXctbjsdw=page.getData();
        setTabledata(lXctbjsdw); 
		 this.result="success";
        return "success";
    }
	
	
	/**
	 * 回复查看的列表
	 * @return
	 * @throws Exception
	 */
	public String querylistHf() throws Exception{
        Xctbjsdw setXctbjsdw=new Xctbjsdw();
        xctbjsdw=(Xctbjsdw)this.setClass(setXctbjsdw, null);
        Map map = new HashMap();
        map.put("tbid", xctbjsdw.getTbid());
        Page page = xctbjsdwService.getListForPageHf(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lXctbjsdw=page.getData();
        setTabledata(lXctbjsdw); 
		 this.result="success";
        return "success";
    }
	
	
	public String query() throws Exception{
		try {
			Xctbjsdw setXctbjsdw=new Xctbjsdw();
			xctbjsdw=(Xctbjsdw)this.setClass(setXctbjsdw, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctbjsdw=xctbjsdwService.getXctbjsdw(xctbjsdw);
        lXctbjsdw.clear();
        lXctbjsdw.add(xctbjsdw);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Xctbjsdw setXctbjsdw=new Xctbjsdw();
			xctbjsdw=(Xctbjsdw)this.setClass(setXctbjsdw, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctbjsdw=xctbjsdwService.insertXctbjsdw(xctbjsdw);
        this.result="success";
        return "success";
    }
	/**
	 * 增加查看时间的方法
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception{
		try {
			Xctbjsdw setXctbjsdw=new Xctbjsdw();
			xctbjsdw=(Xctbjsdw)this.setClass(setXctbjsdw, null);
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			
			/*String userType = user.getUsertype();
			String useraccount = user.getUseraccount();
			if("B02".equals(useraccount.substring(0,3))){
				
				xctbjsdw.setJsdwbm(user.getUseraccount().substring(0,15)); 
			}else{
				xctbjsdw.setJsdwbm(user.getUseraccount().substring(0,14));
			}*/
			//xctbjsdw.setJsdwbm(user.getUseraccount().substring(0,14));
			xctbjsdw.setJsdwbm(user.getSsdwbm());
		    xctbjsdw = xctbjsdwService.getXctbjsdw(xctbjsdw);
		    if(xctbjsdw.getSqsj()==null){
		    	xctbjsdw.setSqsj(new Date());
		    	xctbjsdwService.updateXctbjsdw(xctbjsdw);
		    }	
			//xctbjsdwService.updateXctbjsdw(xctbjsdw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Xctbjsdw setXctbjsdw=new Xctbjsdw();
			xctbjsdw=(Xctbjsdw)this.setClass(setXctbjsdw, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctbjsdwService.deleteXctbjsdw(xctbjsdw);
        this.result="success";
        return "success";
    }
}