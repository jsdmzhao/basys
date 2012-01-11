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
import com.aisino2.publicsystem.domain.Lhjc;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.service.IKyqkService;
import com.aisino2.publicsystem.service.ILhjcService;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class LhjcAction extends PageAction{
	private IKyqkService kyqkService;
	private IQyjbxxService qyjbxxService;
	private ILhjcService lhjcService;
	private List lLhjc=new ArrayList();
	private Lhjc lhjc=new Lhjc();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setKyqkService(IKyqkService kyqkService) {
		this.kyqkService = kyqkService;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Lhjc getLhjc() {
		return lhjc;
	}
	
	public List getLLhjc() {
		return lLhjc;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setLhjcService(ILhjcService lhjcService) {
		this.lhjcService = lhjcService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("lhjcid");
		lPro.add("qymc");
		lPro.add("glbmlhjcdjxh");
		lPro.add("lcjgjb");
		lPro.add("lcjglx");
		lPro.add("lcjgmc");
		lPro.add("lcsj");
		lPro.add("lcryxm");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Lhjc getLhjc=new Lhjc();
    	
        this.setData(getLhjc,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
        Lhjc setLhjc=new Lhjc();
        setLhjc=(Lhjc)this.setClass(setLhjc, null);
        Map map = new HashMap();
        map.put("glbmlhjcdjxh", setLhjc.getGlbmlhjcdjxh());
        map.put("lcjgjbdm", setLhjc.getLcjgjbdm());
        map.put("lcjglxdm", setLhjc.getLcjglxdm());
        map.put("lcjgmc", setLhjc.getLcjgmc());
        map.put("lcsj", setLhjc.getLcsj());
        map.put("lcsjzhi", setLhjc.getLcsjzhi());
        map.put("lcryxm", setLhjc.getLcryxm());
        map.put("qymc", setLhjc.getQymc());
        map.put("qybm", setLhjc.getQybm());
        map.put("qyid", setLhjc.getQyid());
        map.put("hylbdm", setLhjc.getHylbdm());
        map.put("lcjg", setLhjc.getLcjg());
       
        if(setLhjc.getGxdwbm()!=null&&!"".equals(setLhjc.getGxdwbm())){
        	 map.put("gxdwbm", StringUtil.trimEven0(setLhjc.getGxdwbm())); //7.27取简项代码
        }else{
        	 map.put("gxdwbm", StringUtil.trimEven0(user.getDepartment().getDepartcode())); //7.27取简项代码
        }
        Page page = lhjcService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lLhjc=page.getData();
        setTabledata(lLhjc); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Lhjc setLhjc=new Lhjc();
			lhjc=(Lhjc)this.setClass(setLhjc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        lhjc=lhjcService.getLhjc(lhjc);
        lLhjc.clear();
        lLhjc.add(lhjc);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Lhjc setLhjc=new Lhjc();
			setLhjc=(Lhjc)this.setClass(setLhjc, null);
			//setLhjc.setLcsj(new Date());
			setLhjc.setQyid(findQyid(setLhjc));
			setLhjc.setGlbmlhjcdjxh(initinsert(setLhjc.getQybm()));
			setLhjc.setScbz(0);
			setLhjc=lhjcService.insertLhjc(setLhjc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Lhjc setLhjc=new Lhjc();
			lhjc=(Lhjc)this.setClass(setLhjc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        lhjcService.updateLhjc(lhjc);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Lhjc setLhjc=new Lhjc();
			setLhjc=(Lhjc)this.setClass(setLhjc, null);
			lhjcService.deleteLhjc(setLhjc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        this.result="success";
        return "success";
    }
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String initinsert(String qybm) throws Exception{
		
	    Map map = new HashMap();
		map.put("p_bmfl", "RCJCXH");
		map.put("p_xzqh",qybm);
		//map.put("p_xzqh", user.getUseraccount());
		//Globalpar globalpar = new Globalpar();
		//globalpar  = this.getCacheGlobalpar("sssf");
		//String sssf = globalpar.getGlobalparvalue();
		map.put("p_sssf", "hn");
		map.put("p_scgz", 2);
		
		String djxh= kyqkService.getScbm(map);

        return djxh;
		
	}
	private int findQyid(Lhjc setLhjc){
	    int qyid=0;
	    Qyjbxx qyjbxx =new Qyjbxx();
	    qyjbxx.setQybm(setLhjc.getQybm());
	    
	    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
		if(qyjbxx!=null){
			qyid=qyjbxx.getQyid();
		}
		return qyid;
	}
	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}
}