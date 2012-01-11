package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Kyqk;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.service.IKyqkService;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class KyqkAction extends PageAction{
	private IKyqkService kyqkService;
	private IQyjbxxService qyjbxxService;
	private List lKyqk=new ArrayList();
	private Kyqk kyqk=new Kyqk();
	private String tabledata="";
	private int totalrows=0;
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

	public Kyqk getKyqk() {
		return kyqk;
	}
	
	public List getLKyqk() {
		return lKyqk;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setKyqkService(IKyqkService kyqkService) {
		this.kyqkService = kyqkService;
	}
	private String djxh;
	public String getDjxh() {
		return djxh;
	}

	public void setDjxh(String djxh) {
		this.djxh = djxh;
	}
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("kyqkid");
		lPro.add("kyqkdjxh");
		lPro.add("kyqklx");
		lPro.add("tbrxm");
		lPro.add("tbsj");
		
//    	List lModify=new ArrayList();
//    	lModify.add("setModifyQuery");
//    	lModify.add("修改");
//    	
//    	List lDel=new ArrayList();
//    	lDel.add("setDelete");
//    	lDel.add("删除");
    	
    	
    
		List lCol=new ArrayList();
		List lModify=new ArrayList();
    	lModify.add("Kyqk");//链接ID开头
    	lModify.add("修改");//链接显示文字
    	lModify.add("jjsj");//需要比对的属性
    	lModify.add("");//需要比对的属性的值
    	lCol.add(lModify);
    	
    	lModify=new ArrayList();
    	lModify.add("Kyqk");//链接ID开头
    	lModify.add("删除");//链接显示文字
    	lModify.add("jjsj");//需要比对的属性
    	lModify.add("");//需要比对的属性的值
    	lCol.add(lModify);
		Kyqk getKyqk=new Kyqk();
		
		this.setDataCustomer(getKyqk,lData,lPro,null,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void GAsetTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("kyqkid");
		lPro.add("qymc");
		lPro.add("kyqkdjxh");
		lPro.add("kyqklx");
		lPro.add("tbrxm");
		lPro.add("tbsj");
		
		List lModify=new ArrayList();
    	lModify.add("Kyqk");//链接ID开头
    	lModify.add("处理");//链接显示文字
    	lModify.add("jjsj");//需要比对的属性
    	lModify.add("");//需要比对的属性的值
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
		
		Kyqk getKyqk=new Kyqk();
		
		this.setDataCustomer(getKyqk,lData,lPro,null,lCol);
		this.tabledata=this.getData();
		totalrows=this.getTotalrows();
	}
	
	public String Gaquerylist() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		Kyqk setKyqk=new Kyqk();
		setKyqk=(Kyqk)this.setClass(setKyqk, null);
		Map map = new HashMap();
		map.put("tbrxm", setKyqk.getTbrxm());
		map.put("tbsj", setKyqk.getTbsj());
		map.put("tbsjzhi", setKyqk.getTbsjzhi());
		map.put("kyqklxbm", setKyqk.getKyqklxbm());
		if(setKyqk.getGxdwbh()!=null&&!"".equals(setKyqk.getGxdwbh())){
			map.put("gxdwbh",StringUtil.trimEven0(setKyqk.getGxdwbh()));
		}else{
			map.put("gxdwbh",StringUtil.trimEven0(user.getDepartment().getDepartcode()));
		}
		
		map.put("qymc", setKyqk.getQymc());
		map.put("qyid", setKyqk.getQyid());
		map.put("qybm", setKyqk.getQybm());
		map.put("hylbdm", setKyqk.getHylbdm());
		String hydm = setKyqk.getHydm();// 行业类别代码 进入可疑情况页面直接检索时传递此参数
		if(hydm != null && !"".equals(hydm)){
			map.put("hylbdm", hydm);
		}
		map.put("jjrxm", setKyqk.getJjrxm());// 接警人姓名存在时，查询可疑情况未处理的所有记录
		
		Page page = kyqkService.getListForPageGAD(map, pagesize, pagerow,sort,dir);
		totalpage=page.getTotalPages();
		totalrows=page.getTotalRows();
		lKyqk=page.getData();
		GAsetTabledata(lKyqk); 
		this.result="success";
		return "success";
	}
	public String querylist() throws Exception{
        Kyqk setKyqk=new Kyqk();
        setKyqk=(Kyqk)this.setClass(setKyqk, null);
        Map map = new HashMap();
        map.put("tbrxm", setKyqk.getTbrxm());
		map.put("tbsj", setKyqk.getTbsj());
		map.put("tbsjzhi", setKyqk.getTbsjzhi());
		map.put("kyqklxbm", setKyqk.getKyqklxbm());
		map.put("qyid", findQyid());
        Page page = kyqkService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lKyqk=page.getData();
        setTabledata(lKyqk); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Kyqk setKyqk=new Kyqk();
			setKyqk=(Kyqk)this.setClass(setKyqk, null);
			setKyqk=kyqkService.getKyqk(setKyqk);
	        lKyqk.clear();
	        lKyqk.add(setKyqk);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Kyqk setKyqk=new Kyqk();
			setKyqk=(Kyqk)this.setClass(setKyqk, null);
			//setKyqk.setQyid(1);
			setKyqk.setQyid(findQyid());
			setKyqk.setTbsj(new Date());
			setKyqk.setScbz(0);
			setKyqk.setKyqkdjxh(initinsert());
			setKyqk=kyqkService.insertKyqk(setKyqk);
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Kyqk setKyqk=new Kyqk();
			setKyqk=(Kyqk)this.setClass(setKyqk, null);
			
			Kyqk newsetKyqk=new Kyqk();
			newsetKyqk.setKyqkid(setKyqk.getKyqkid());
			newsetKyqk=kyqkService.getKyqk(newsetKyqk);
			if(newsetKyqk.getJjsj()==null){
				kyqkService.updateKyqk(setKyqk);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Kyqk setKyqk=new Kyqk();
			setKyqk=(Kyqk)this.setClass(setKyqk, null);
			Kyqk newsetKyqk=new Kyqk();
			newsetKyqk.setKyqkid(setKyqk.getKyqkid());
			newsetKyqk=kyqkService.getKyqk(newsetKyqk);
			if(newsetKyqk.getJjsj()==null){
				kyqkService.deleteKyqk(setKyqk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	public String initinsert() throws Exception{
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
	    user= (User)session.getAttribute(Constants.userKey);
	    Map map = new HashMap();
		map.put("p_bmfl", "KYQKXH");
		//map.put("p_xzqh", user.getDepartment().getDepartcode().substring(0,6));
		map.put("p_xzqh", user.getUseraccount());
		String sssf = QjblUtil.queryQjblVal("sssf");
		if(sssf==null||"".equals(sssf)){
			sssf = "hn";
		}
		map.put("p_sssf", sssf);
		map.put("p_scgz", 2);
		djxh = kyqkService.getScbm(map);
		
		return djxh;
		
	}
	private int findQyid(){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
	    user= (User)session.getAttribute(Constants.userKey);
	    int qyid=0;
	    String usercount="";
	    if(user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm()))
	    {
	    	usercount=user.getSsdwbm();
	    }
	    Qyjbxx qyjbxx =new Qyjbxx();
	    qyjbxx.setQybm(usercount);
	    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
		if(qyjbxx!=null){
			qyid=qyjbxx.getQyid();
		}
		return qyid;
	}
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}
	
	public String kyqkCount() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		
		Map map = new HashMap();
		map.put("hylbdm", "J");
		map.put("gxdwbh",StringUtil.trimEven0(user.getDepartment().getDepartcode()));
		
		
		int count = kyqkService.getKyqkCount(map);
		lKyqk.add(count);
		this.result="success";
		return "success";
	}
}