package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.basicsystem.domain.Gjcxfa;
import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.basicsystem.service.IGjcxfaService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class GjcxfaAction extends PageAction{
	private IGjcxfaService gjcxfaService;
	private List lGjcxfa=new ArrayList();
	private List ldata = new ArrayList();
	private Gjcxfa gjcxfa=new Gjcxfa();
	private String[] gjcx = {"",""};
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	
	public String[] getGjcx() {
		return gjcx;
	}

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

	public Gjcxfa getGjcxfa() {
		return gjcxfa;
	}
	
	public List getLGjcxfa() {
		return lGjcxfa;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGjcxfaService(IGjcxfaService gjcxfaService) {
		this.gjcxfaService = gjcxfaService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gjcxfaid");
		lPro.add("gjcxfamc");
		//lPro.add("ssyhzh");
		lPro.add("ssgnmc");
		//lPro.add("gjcxlx");

    	
//    	List lModify=new ArrayList();
//    	lModify.add("setModifyQuery");
//    	lModify.add("修改");
//    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete_fa");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
//    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Gjcxfa getGjcxfa=new Gjcxfa();
    	
        this.setData(getGjcxfa,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Gjcxfa setGjcxfa=new Gjcxfa();
			gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, null);
	        Map map = new HashMap();
	        if(gjcxfa!=null){
	        	map.put("ssgnmc", gjcxfa.getSsgnmc());
	        	
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
	        	map.put("ssyhzh", user.getUseraccount());
	        }
	        Page page = gjcxfaService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lGjcxfa=page.getData();
	        setTabledata(lGjcxfa); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
	    return "success";
	    
    }
	
	public String listNoPage() throws Exception{
		try {
		Gjcxfa setGjcxfa=new Gjcxfa();
		gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, null);

		javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		gjcxfa.setSsyhzh(user.getUseraccount());
		
        ldata = gjcxfaService.getListGjcxfa(gjcxfa);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Gjcxfa setGjcxfa=new Gjcxfa();
			gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gjcxfa=gjcxfaService.getGjcxfa(gjcxfa);
        lGjcxfa.clear();
        lGjcxfa.add(gjcxfa);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Gjcxfa setGjcxfa=new Gjcxfa();

			Dtcxtj setDtcxtj=new Dtcxtj();
			Dtcxpx setDtcxpx=new Dtcxpx();
			Object []objDtcxtj = {setDtcxtj,setDtcxpx};
			gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, objDtcxtj);
			
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			gjcxfa.setSsyhzh(user.getUseraccount());
			
			Integer gjcxfaid = gjcxfa.getGjcxfaid();
			if(gjcxfaid==null || gjcxfaid.equals(-1)){
		        gjcxfa=gjcxfaService.insertGjcxfa(gjcxfa);
			}else{
				gjcxfaService.updateGjcxfa(gjcxfa);
			}
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="修改失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String insertSql() throws Exception{
		try {
			Gjcxfa setGjcxfa=new Gjcxfa();
			gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, null);
			
			Zdycxtj zdycxtj = new Zdycxtj();
			zdycxtj=(Zdycxtj)this.setClass(zdycxtj, null);
			
			gjcxfa.setZdycxtj(zdycxtj);
			
			javax.servlet.http.HttpSession session = this.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			gjcxfa.setSsyhzh(user.getUseraccount());
			
			Integer gjcxfaid = gjcxfa.getGjcxfaid();
			if(gjcxfaid==null || gjcxfaid.equals(-1)){
		        gjcxfa=gjcxfaService.insertGjcxfa(gjcxfa);
			}else{
				gjcxfaService.updateGjcxfa(gjcxfa);
			}
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="修改失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Gjcxfa setGjcxfa=new Gjcxfa();
			gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, null);
	        if(gjcxfaService.updateGjcxfamc(gjcxfa)){
	            this.result="success";
	        }else{
	            this.result="修改失败";
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
            this.result="修改失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Gjcxfa setGjcxfa=new Gjcxfa();
			gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, null);
	        if(gjcxfaService.deleteGjcxfa(gjcxfa)){
	            this.result="success";
	        }else{
	            this.result="删除失败";
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
            this.result="删除失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String executeQuery() throws Exception{
		Gjcxfa setGjcxfa=new Gjcxfa();

		Dtcxtj setDtcxtj=new Dtcxtj();
		Dtcxpx setDtcxpx=new Dtcxpx();
		Object []objDtcxtj = {setDtcxtj,setDtcxpx};
		gjcxfa=(Gjcxfa)this.setClass(setGjcxfa, objDtcxtj);
		
		Zdycxtj setZdycxtj = new Zdycxtj();
		setZdycxtj=(Zdycxtj)this.setClass(setZdycxtj, null);
		gjcxfa.setZdycxtj(setZdycxtj);
		
		gjcx = gjcxfaService.getQueryConditions(gjcxfa);
		this.result="success";
        return "success";
	}
}