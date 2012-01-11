package com.aisino2.sysadmin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.Operatelog;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IOperatelogService;

public class OperatelogAction extends PageAction{
	private IOperatelogService operatelogService;
	private List lOperatelog;
	private Operatelog operatelog;
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

	public Operatelog getOperatelog() {
		return operatelog;
	}
	
	public List getLOperatelog() {
		return lOperatelog;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setOperatelogService(IOperatelogService operatelogService) {
		this.operatelogService = operatelogService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("operatelogid");
		lPro.add("operatemodule");
		lPro.add("useraccount");
		lPro.add("operatedate");
		lPro.add("operatetype");
    	
    	Operatelog getOperatelog=new Operatelog();
    	
        this.setData(getOperatelog,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
		Operatelog setOperatelog=new Operatelog();
		operatelog=(Operatelog)this.setClass(setOperatelog, null); 
		Map map = new HashMap();
		
		if(operatelog!=null){
			map.put("operatesystem", operatelog.getOperatesystem());
			map.put("operatemodule", operatelog.getOperatemodule());
			map.put("useraccount", operatelog.getUseraccount());
			map.put("operatedatef", operatelog.getOperatedatef());
			map.put("operatedatet", operatelog.getOperatedatet());
		}
        Page page = operatelogService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lOperatelog=page.getData();
//        for(Iterator iter=lOperatelog.iterator();iter.hasNext();){
//        	Operatelog oneOperatelog = (Operatelog)iter.next();
//        	String operatelogSql = oneOperatelog.getOperatesql();
//        	if(operatelogSql==null)operatelogSql="";
//        	else if(operatelogSql.length()>40)operatelogSql = operatelogSql.substring(0,40)+"......";
//        	oneOperatelog.setOperatesql(operatelogSql);
//        }
        setTabledata(lOperatelog); 
		 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Operatelog setOperatelog=new Operatelog();
			operatelog=(Operatelog)this.setClass(setOperatelog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        operatelog=operatelogService.getOperatelog(operatelog);
        lOperatelog.clear();
        lOperatelog.add(operatelog);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Operatelog setOperatelog=new Operatelog();
			operatelog=(Operatelog)this.setClass(setOperatelog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        operatelog=operatelogService.insertOperatelog(operatelog);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Operatelog setOperatelog=new Operatelog();
			operatelog=(Operatelog)this.setClass(setOperatelog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        operatelogService.updateOperatelog(operatelog);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Operatelog setOperatelog=new Operatelog();
			operatelog=(Operatelog)this.setClass(setOperatelog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        operatelogService.deleteOperatelog(operatelog);
        this.result="success";
        return "success";
    }
	
	public String queryForExport() {
		
		this.result = "success";
		return "success";
	}

	public void getExcelCreate() throws Exception{
		try {	
			Operatelog setOperatelog=new Operatelog();
			operatelog=(Operatelog)this.setClass(setOperatelog, null); 
			Map map = new HashMap();
			
			if(operatelog!=null){
				map.put("operatesystem", operatelog.getOperatesystem());
				map.put("operatemodule", operatelog.getOperatemodule());
				map.put("useraccount", operatelog.getUseraccount());
				map.put("operatedatef", operatelog.getOperatedatef());
				map.put("operatedatet", operatelog.getOperatedatet());
			}
			int maxRow = 0;
			Globalpar glo_temp = this.getCacheGlobalpar("exportmaxrows");
			if(glo_temp!=null && glo_temp.getGlobalparvalue()!=null){
				maxRow = Integer.parseInt(glo_temp.getGlobalparvalue());
			}
	        Page page = operatelogService.getListForPage(map, 1, maxRow,sort,dir);
	        lOperatelog=page.getData();
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(Constants.userKey);
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			// Excel输出
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(lOperatelog);
			lResult.add(setOperatelog);
			this.setExcelCreate("operatelog", lResult);
			this.result = "ok";
		} catch (IOException e) {
			e.printStackTrace();
			this.result = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			this.result = e.getMessage();
		}
    }
	
}