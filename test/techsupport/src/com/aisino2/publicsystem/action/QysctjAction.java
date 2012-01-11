package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.DateToString;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qysctj;
import com.aisino2.publicsystem.service.IQysctjService;
import com.aisino2.sysadmin.domain.Globalpar;

public class QysctjAction extends PageAction{
	private IQysctjService qysctjService;
	private List lQysctj=new ArrayList();
	private Qysctj qysctj=new Qysctj();
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

	public Qysctj getQysctj() {
		return qysctj;
	}
	
	public List getLQysctj() {
		return lQysctj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQysctjService(IQysctjService qysctjService) {
		this.qysctjService = qysctjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qysctjid");
		lPro.add("hylbdm");
		lPro.add("hylb");
		lPro.add("tjrq");
		lPro.add("dsjgdm");
		lPro.add("dsjgmc");
		lPro.add("fxjdm");
		lPro.add("fxjmc");
		lPro.add("gxdwmc");
		lPro.add("gxdwdm");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("lxdh");
		lPro.add("sfdb");
		lPro.add("zrs");
		lPro.add("gzrs");
		lPro.add("sskrs");
		lPro.add("zdskb");
		lPro.add("ycskrs");
		lPro.add("dcskrs");
		lPro.add("bcsskrs");
		lPro.add("ztskrs");
		lPro.add("zskb");
		lPro.add("ycskb");
		lPro.add("dcskb");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qysctj getQysctj=new Qysctj();
    	
        this.setData(getQysctj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qysctj setQysctj=new Qysctj();
        Map map = new HashMap();
        Page page = qysctjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQysctj=page.getData();
        setTabledata(lQysctj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qysctj setQysctj=new Qysctj();
			qysctj=(Qysctj)this.setClass(setQysctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qysctj=qysctjService.getQysctj(qysctj);
        lQysctj.clear();
        lQysctj.add(qysctj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qysctj setQysctj=new Qysctj();
			qysctj=(Qysctj)this.setClass(setQysctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qysctj=qysctjService.insertQysctj(qysctj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qysctj setQysctj=new Qysctj();
			qysctj=(Qysctj)this.setClass(setQysctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qysctjService.updateQysctj(qysctj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qysctj setQysctj=new Qysctj();
			qysctj=(Qysctj)this.setClass(setQysctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qysctjService.deleteQysctj(qysctj);
        this.result="success";
        return "success";
    }
	
	
	//刷卡统计
	
	public void setTabledatasktj(List lData,Qysctj getQysctj,String flag) throws Exception{
		List lPro=new ArrayList();
		
		
		
		if("1".equals(getQysctj.getCsbz())){
			lPro.add("qybm");
			lPro.add("qybm");
			lPro.add("qymc");
		} else if("1".equals(getQysctj.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(getQysctj.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(getQysctj.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		}
		
		lPro.add("zrs");
		lPro.add("gzrs");
		lPro.add("sskrs");
		lPro.add("ztskrs");
		lPro.add("zskbstring");
		lPro.add("ycskrs");
		lPro.add("ycskbstring");
		lPro.add("dcskrs");
		lPro.add("dcskbstring");
		
		
		List lModify=new ArrayList();
    	lModify.add("setXxQuery");
    	lModify.add("详细");
    
    	List lCol=new ArrayList();
    	if(flag.equals("all")){
    	  lCol.add(lModify);
    	}else{
    		lPro.add("tjrqString");
    	}
   
    	
    
    	
    	Qysctj setqysctj=new Qysctj();
        this.setData(setqysctj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylistsktj() throws Exception{
		try {
			Qysctj setqysctj=new Qysctj();
			setqysctj = (Qysctj)this.setClass(setqysctj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setqysctj.getDsjgbz());
			map.put("fxjbz", setqysctj.getFxjbz());
			map.put("gxdwbz", setqysctj.getGxdwbz());
			map.put("csbz", setqysctj.getCsbz());
			map.put("dsjgdm", setqysctj.getDsjgdm());
			map.put("fxjdm", setqysctj.getFxjdm());
			map.put("gxdwdm", setqysctj.getGxdwdm());
			map.put("qybm", setqysctj.getCsbm());
			map.put("qsrq", setqysctj.getQssj());
			map.put("jzrq", setqysctj.getJzsj());
			map.put("hylbdm", setqysctj.getHylbdm());
			
			
			map.put("zskbdxdy", setqysctj.getZskbdxdy());
			map.put("zskbbfb", setqysctj.getZskbbfb());
			map.put("shenheFlagCx", "yes");//统计已审核的
			map.put("sftjyg",  "1");//是否统计异构系统，1统计，0不统计；统计已审核时启用
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业
			
	        Page page = qysctjService.getSktjListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatasktj(page.getData(),setqysctj,"all"); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Qysctj setqysctj=new Qysctj();
			setqysctj = (Qysctj)this.setClass(setqysctj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setqysctj.getDsjgbz());
			map.put("fxjbz", setqysctj.getFxjbz());
			map.put("gxdwbz", setqysctj.getGxdwbz());
			map.put("csbz", setqysctj.getCsbz());
			map.put("dsjgdm", setqysctj.getDsjgdm());
			map.put("fxjdm", setqysctj.getFxjdm());
			map.put("gxdwdm", setqysctj.getGxdwdm());
			map.put("qybm", setqysctj.getCsbm());
			map.put("qsrq", setqysctj.getQssj());
			map.put("jzrq", setqysctj.getJzsj());
			map.put("hylbdm", setqysctj.getHylbdm());
			
			
			map.put("zskbdxdy", setqysctj.getZskbdxdy());
			map.put("zskbbfb", setqysctj.getZskbbfb());
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			
			Page page = qysctjService.getSktjListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("qysctjList", page.getData());
			
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	
	public void querylistExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Qysctj setqysctj=new Qysctj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("qysctjList"));
			lResult.add(setqysctj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	//刷卡统计详细
	public String querylistsktjxx() throws Exception{
		try {
			Qysctj setqysctj=new Qysctj();
			setqysctj = (Qysctj)this.setClass(setqysctj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setqysctj.getDsjgbz());
			map.put("fxjbz", setqysctj.getFxjbz());
			map.put("gxdwbz", setqysctj.getGxdwbz());
			map.put("csbz", setqysctj.getCsbz());
			map.put("dsjgdm", setqysctj.getDsjgdm());
			map.put("fxjdm", setqysctj.getFxjdm());
			map.put("gxdwdm", setqysctj.getGxdwdm());
			map.put("qybm", setqysctj.getCsbm());
			map.put("qsrq", setqysctj.getQssj());
			map.put("jzrq", setqysctj.getJzsj());
			map.put("hylbdm", setqysctj.getHylbdm());
			
		
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业
			map.put("sftjyg",1);//统计异构卡
			  
			
	        Page page = qysctjService.getSktjxxListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatasktj(page.getData(),setqysctj,"part"); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	
	
	
	
	public String querylistExcelTempxx(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Qysctj setqysctj=new Qysctj();
			setqysctj = (Qysctj)this.setClass(setqysctj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setqysctj.getDsjgbz());
			map.put("fxjbz", setqysctj.getFxjbz());
			map.put("gxdwbz", setqysctj.getGxdwbz());
			map.put("csbz", setqysctj.getCsbz());
			map.put("dsjgdm", setqysctj.getDsjgdm());
			map.put("fxjdm", setqysctj.getFxjdm());
			map.put("gxdwdm", setqysctj.getGxdwdm());
			map.put("qybm", setqysctj.getCsbm());
			map.put("qsrq", setqysctj.getQssj());
			map.put("jzrq", setqysctj.getJzsj());
			map.put("hylbdm", setqysctj.getHylbdm());
			
			
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			
			Page page = qysctjService.getSktjxxListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("qysctjxxList", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	public void querylistExcelxx() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Qysctj setqysctj=new Qysctj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("qysctjxxList"));
			lResult.add(setqysctj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	
//查询场所走台人数
	
	public void setTabledatasktjzt(List lData,Qysctj getQysctj) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("sksj");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		lPro.add("cyrylbdm");
		lPro.add("ryid");
    	List lCol=new ArrayList();
    	Qysctj setqysctj=new Qysctj();
        this.setData(setqysctj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	

	
	public String querylistZt(){
		try {
			Qysctj setqysctj=new Qysctj();
			setqysctj = (Qysctj)this.setClass(setqysctj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setqysctj.getDsjgbz());
			map.put("fxjbz", setqysctj.getFxjbz());
			map.put("gxdwbz", setqysctj.getGxdwbz());
			map.put("csbz", setqysctj.getCsbz());
//			map.put("dsjgdm", setqysctj.getDsjgdm());
//			map.put("fxjdm", setqysctj.getFxjdm());
//			map.put("gxdwdm", setqysctj.getGxdwdm());
//			map.put("qybm", setqysctj.getCsbm());
			
		   if(setqysctj.getCsbz().equals("1")){
				   map.put("qybm", setqysctj.getZtjbdm());
			}else{
				
			   if("1".equals(setqysctj.getFxjbz())){
					String ss =StringUtil.trimEven0(setqysctj.getZtjbdm());
					if(ss.length()>4){
						 map.put("gxdwdm", ss);
						 map.put("truefalg", "1");
						 
					}else{
						 map.put("gxdwdm", setqysctj.getZtjbdm());
						 map.put("truefalg", "0");
					}
				}else if("1".equals(setqysctj.getGxdwbz())){
					String ss =StringUtil.trimEven0(setqysctj.getZtjbdm());
					if(ss.length()>6){
						 map.put("gxdwdm", ss);
						 map.put("truefalg", "1");
						 
					}else{
						 map.put("gxdwdm", setqysctj.getZtjbdm());
						 map.put("truefalg", "0");
					}
				}else{
					map.put("gxdwdm", StringUtil.trimEven0(setqysctj.getZtjbdm()));
					 map.put("truefalg", "1");
					
				}
				
			}
			
		   if(setqysctj.getZttjrqString()!=null&&!setqysctj.getZttjrqString().equals("")){
			   //setqysctj.setZttjrq(DateToString.toDate(setqysctj.getZttjrqString()));
			   map.put("zttjrq", DateToString.toDate(setqysctj.getZttjrqString()));  
		   }else{
				map.put("qsrq", setqysctj.getQssj());
				map.put("jzrq", setqysctj.getJzsj());
		   }
			map.put("hylbdm", setqysctj.getHylbdm());
			
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

	        Page page = qysctjService.getZtxxListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatasktjzt(page.getData(),setqysctj); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
		
	}
	
//查询一次刷卡人员
	public void setTabledataycsk(List lData,Qysctj getQysctj) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("zjhm");
		lPro.add("ssqymc");
		lPro.add("qymc");
		lPro.add("sksj");
		//lPro.add("skcs");
		
    	List lCol=new ArrayList();
    	Qysctj setqysctj=new Qysctj();
        this.setData(setqysctj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
//查询一次刷卡人员
	public String querylistYcsk(){
		try {
			Qysctj setqysctj=new Qysctj();
			setqysctj = (Qysctj)this.setClass(setqysctj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setqysctj.getDsjgbz());
			map.put("fxjbz", setqysctj.getFxjbz());
			map.put("gxdwbz", setqysctj.getGxdwbz());
			map.put("csbz", setqysctj.getCsbz());
			if(setqysctj.getCsbz().equals("1")){
				map.put("qybm", setqysctj.getZtjbdm());
			}else if("1".equals(setqysctj.getGxdwbz())){
				map.put("gxdwdm", setqysctj.getZtjbdm().substring(0, 8));
			}else if("1".equals(setqysctj.getFxjbz())){
				map.put("gxdwdm", setqysctj.getZtjbdm().substring(0, 6));
			}else if("1".equals(setqysctj.getDsjgbz())){
				map.put("gxdwdm", setqysctj.getZtjbdm().substring(0, 4));
			}
			map.put("qsrq", setqysctj.getQssj());
			map.put("jzrq", setqysctj.getJzsj());
			map.put("hylbdm", setqysctj.getHylbdm());
			map.put("skcs", 1);
	        Page page = qysctjService.getYcskxxListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataycsk(page.getData(),setqysctj); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
		
	}
//查询多次刷卡人员
	public void setTabledatadcsk(List lData,Qysctj getQysctj) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("zjhm");
		lPro.add("ssqymc");
		lPro.add("qymc");
		lPro.add("sksj");
		lPro.add("skcs");
		
    	List lCol=new ArrayList();
    	Qysctj setqysctj=new Qysctj();
        this.setData(setqysctj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
//查询多次刷卡人员
	public String querylistDcsk(){
		try {
			Qysctj setqysctj=new Qysctj();
			setqysctj = (Qysctj)this.setClass(setqysctj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setqysctj.getDsjgbz());
			map.put("fxjbz", setqysctj.getFxjbz());
			map.put("gxdwbz", setqysctj.getGxdwbz());
			map.put("csbz", setqysctj.getCsbz());
			if(setqysctj.getCsbz().equals("1")){
				map.put("qybm", setqysctj.getZtjbdm());
			}else if("1".equals(setqysctj.getGxdwbz())){
				map.put("gxdwdm", setqysctj.getZtjbdm().substring(0, 8));
			}else if("1".equals(setqysctj.getFxjbz())){
				map.put("gxdwdm", setqysctj.getZtjbdm().substring(0, 6));
			}else if("1".equals(setqysctj.getDsjgbz())){
				map.put("gxdwdm", setqysctj.getZtjbdm().substring(0, 4));
			}
			map.put("qsrq", setqysctj.getQssj());
			map.put("jzrq", setqysctj.getJzsj());
			map.put("hylbdm", setqysctj.getHylbdm());
			map.put("skcs", 2);
	        Page page = qysctjService.getYcskxxListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatadcsk(page.getData(),setqysctj); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
		
	}
	
	
}