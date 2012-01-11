package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Rcjc;
import com.aisino2.publicsystem.service.IKyqkService;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IRcjcService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class RcjcAction extends PageAction{
	private IQyjbxxService qyjbxxService;
	private IKyqkService kyqkService;
	private IRcjcService rcjcService;
	private List lRcjc=new ArrayList();
	private Rcjc rcjc;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
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

	public Rcjc getRcjc() {
		return rcjc;
	}
	
	public List getLRcjc() {
		return lRcjc;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setRcjcService(IRcjcService rcjcService) {
		this.rcjcService = rcjcService;
	}
	
	public void setKyqkService(IKyqkService kyqkService) {
		this.kyqkService = kyqkService;
	}
	
	public void setTabledata(List lData) throws Exception{
		
		List lPro=new ArrayList();
		lPro.add("rcjcid");
		lPro.add("jcrq");
		lPro.add("qymc");
		lPro.add("jcrxm");
		lPro.add("lsdw");
		
   	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lXzcz = new ArrayList();

    	List lZx=new ArrayList();
    	lZx.add("setModifyQuery");
    	lZx.add("处理");
    	lZx.add("cljg");
    	lZx.add("");
    	lXzcz.add(lZx);
    	
    	lZx=new ArrayList();
    	lZx.add("setModifyQuery");
    	lZx.add("处理");
    	lZx.add("cljg");
    	lZx.add(null);
    	lXzcz.add(lZx);
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Rcjc getRcjc=new Rcjc();
    	
    	this.setDataCustomer(getRcjc, lData, lPro, lCol, lXzcz);
        //this.setData(getRcjc,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			//System.out.println("querylist方法"+"--------------");
			Rcjc setRcjc=new Rcjc();
			rcjc=(Rcjc)this.setClass(setRcjc, null);
			Map map = new HashMap();
			if(rcjc!=null){
				map.put("qybm", rcjc.getQybm());
				map.put("qymc", rcjc.getQymc());
				map.put("hylbdm", rcjc.getHylbdm());
				map.put("jcrqf", rcjc.getJcrqf());
				map.put("jcrqt", rcjc.getJcrqt());
				map.put("jcfs", rcjc.getJcfs());
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("gxdwbm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
     
			Page page = rcjcService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lRcjc=page.getData();
			setTabledata(lRcjc); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        return "success";
    }
	
	public String query() throws Exception{
		try {
			//System.out.println("query方法"+"--------------");
			
			Rcjc setRcjc=new Rcjc();
			setRcjc=(Rcjc)this.setClass(setRcjc, null);
			setRcjc=rcjcService.getRcjc(setRcjc);
			
			String displayName="";
			Dict_item dict_item = new Dict_item();
			dict_item.setDict_code("dm_jcfs");
			dict_item.setFact_value(setRcjc.getJcfs());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0) displayName = ((Dict_item)list.get(0)).getDisplay_name();			
			setRcjc.setJcfsDisName(displayName);
	        lRcjc.clear();
	        lRcjc.add(setRcjc);
	        //System.out.println(rcjc.getHylb()+"=============");
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			//System.out.println("insert方法"+"--------------");
			Rcjc setRcjc=new Rcjc();
			setRcjc=(Rcjc)this.setClass(setRcjc, null);
			String a=setRcjc.getQymc();
			System.out.println(a);
			String b=creatJcdm(setRcjc.getQybm());
			setRcjc.setRcjcbh(b);
			setRcjc.setScbz(0);
			setRcjc.setQyid(findQyid(setRcjc.getQybm()));
			//javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			setRcjc=rcjcService.insertRcjc(setRcjc);
			//String sssf = (String)session.getAttribute("sssf"); //从session中得到所属省份(全局参数)
			//rcjc.setSssf(sssf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		
		//System.out.println("modify方法"+"--------------");
		try {
			Rcjc setRcjc=new Rcjc();
			rcjc=(Rcjc)this.setClass(setRcjc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rcjcService.updateRcjc(rcjc);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		
		//System.out.println("delete方法"+"--------------");
		try {
			Rcjc setRcjc=new Rcjc();
			rcjc=(Rcjc)this.setClass(setRcjc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rcjcService.deleteRcjc(rcjc);
        this.result="success";
        return "success";
    }
	
	/**
	 * 人员检查查询

	 * @return
	 * @throws Exception
	 */
	public String querylistCx() throws Exception{
		
		//System.out.println("querylistCx方法"+"--------------");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String nwwbz = (String)session.getAttribute("nwwbz");
			Rcjc setRcjc=new Rcjc();
			rcjc=(Rcjc)this.setClass(setRcjc, null);
			Map map = new HashMap();
			if(rcjc!=null){
				
				map.put("qymc", rcjc.getQymc());
				map.put("qybm", rcjc.getQybm());
				map.put("jcrqf", rcjc.getJcrqf());
				map.put("jcrqt", rcjc.getJcrqt());
				map.put("hylbdm", rcjc.getHylbdm());
				map.put("jcjgdm", rcjc.getJcjgdm());
				map.put("cljg", rcjc.getCljg());
				map.put("jcfs", rcjc.getJcfs());
				map.put("queryOrAdd", "query");
				
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("gxdwbm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
			
	        Page page = rcjcService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lRcjc=page.getData();
	        setTabledataCx(lRcjc); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "success";
    }
    
	public String creatJcdm(String qybm){
		
		/*
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
	    User user= (User)session.getAttribute(Constants.userKey);
	    */
	    Map map = new HashMap();
		map.put("p_bmfl", "LHJCXH");
		map.put("p_xzqh", qybm);
		//map.put("p_xzqh", user.getUseraccount());
		/*
		Globalpar globalpar = new Globalpar();
		globalpar  = this.getCacheGlobalpar("sssf");
		String sssf = globalpar.getGlobalparvalue();
		*/
		map.put("p_sssf", "hn");
		map.put("p_scgz", 2);
		String djxh = kyqkService.getScbm(map);
		
        return djxh;
		
	}


	private int findQyid(String qybm){
		
	    int qyid=1;
	    Qyjbxx qyjbxx =new Qyjbxx();
	    qyjbxx.setQybm(qybm);
	    //System.out.println(qybm+"----------");
	    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
		if(qyjbxx!=null){
			
			qyid=qyjbxx.getQyid();
		}
		return qyid;
	}
	public void setTabledataCx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("rcjcid");
		lPro.add("jcrq");
		lPro.add("lsdw");
		lPro.add("jcrxm");
		lPro.add("jcrybh"); //检查人警号
		lPro.add("jcrzw"); //检查人职务
		lPro.add("qymc");
		
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String nwwbz = (String)session.getAttribute("nwwbz");
		List lXzcz = new ArrayList();
		List lModify=new ArrayList();
    	lModify.add("setModifyRcjc"); 
    	lModify.add("修改");
    	lModify.add("nwwbz");
    	lModify.add(nwwbz);
    	lXzcz.add(lModify);
    	
    	
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	lDel.add("nwwbz");
    	lDel.add(nwwbz);
    	lXzcz.add(lDel);

    	List lZx=new ArrayList();
    	lZx.add("setModifyQuery");
    	lZx.add("处理");
    	lZx.add("cljg");
    	lZx.add("");
    	lXzcz.add(lZx);
    	
    	lZx=new ArrayList();
    	lZx.add("setModifyQuery");
    	lZx.add("处理");
    	lZx.add("cljg");
    	lZx.add(null);
    	lXzcz.add(lZx);
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Rcjc getRcjc=new Rcjc();
    	
    	this.setDataCustomer(getRcjc, lData, lPro, null, lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	
//监督检查统计

	
	public void setTabledataTj(List lData,Rcjc getRcj,String flag) throws Exception{
		List lPro=new ArrayList();
		
		
		
		if("1".equals(getRcj.getCsbz())){
			lPro.add("qybm");
			lPro.add("qybm");
			lPro.add("qymc");
		} else if("1".equals(getRcj.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(getRcj.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(getRcj.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		}
		
		lPro.add("rcjccs");
	
		
		
    
    	List lCol=new ArrayList();
    
    	
    
    	
    	Rcjc getRcjc=new Rcjc();
        this.setData(getRcjc,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylistTj() throws Exception{
		try {
			Rcjc setrcjc=new Rcjc();
			setrcjc = (Rcjc)this.setClass(setrcjc, null);
			Map map = new HashMap();
			map.put("dsjgbz", setrcjc.getDsjgbz());
			map.put("fxjbz", setrcjc.getFxjbz());
			map.put("gxdwbz", setrcjc.getGxdwbz());
			map.put("csbz", setrcjc.getCsbz());
			map.put("dsjgdm", setrcjc.getDsjgdm());
			map.put("fxjdm", setrcjc.getFxjdm());
			map.put("gxdwdm", setrcjc.getGxdwdm());
			map.put("qybm", setrcjc.getCsbm());
			map.put("qsrq", setrcjc.getQssj());
			map.put("jzrq", setrcjc.getJzsj());
			map.put("hylbdm", setrcjc.getHylbdm());
			
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

		    if("".equals(setrcjc.getHylbdm())||"".equals(setrcjc.getHylbdm())){ //yangbo 2010-11-1 miao确认
		    	map.put("yyzt", "yes");//只显示装机开业
		    }
		    map.put("qyyyzt", "yes");//只显示营业状态为“营业”
			
	        Page page = rcjcService.getTjListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataTj(page.getData(),setrcjc,"all"); 
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
			
			Rcjc setrcjc=new Rcjc();
			setrcjc = (Rcjc)this.setClass(setrcjc, null);
			Map map = new HashMap();
			map.put("dsjgbz", setrcjc.getDsjgbz());
			map.put("fxjbz", setrcjc.getFxjbz());
			map.put("gxdwbz", setrcjc.getGxdwbz());
			map.put("csbz", setrcjc.getCsbz());
			map.put("dsjgdm", setrcjc.getDsjgdm());
			map.put("fxjdm", setrcjc.getFxjdm());
			map.put("gxdwdm", setrcjc.getGxdwdm());
			map.put("qybm", setrcjc.getCsbm());
			map.put("qsrq", setrcjc.getQssj());
			map.put("jzrq", setrcjc.getJzsj());
			map.put("hylbdm", setrcjc.getHylbdm());
			
			
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

		    if("".equals(setrcjc.getHylbdm())||"".equals(setrcjc.getHylbdm())){ //yangbo 2010-11-1 miao确认
		    	map.put("yyzt", "yes");//只显示装机开业
		    }
		    map.put("qyyyzt", "yes");//只显示营业状态为“营业”

			
			Page page = rcjcService.getTjListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("rcjctjList", page.getData());
			
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
			Rcjc setrcjc=new Rcjc();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("rcjctjList"));
			lResult.add(setrcjc);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
//监督检查统计详细

	
	public void setTabledataTjxx(List lData,Rcjc getRcj,String flag) throws Exception{
		List lPro=new ArrayList();
		
		
		lPro.add("rcjcid");
		lPro.add("jcrq");
		lPro.add("qymc");
		lPro.add("cljg");
		lPro.add("jcrxm");
    
    
    	List lModify=new ArrayList();
    	lModify.add("setRcjcQuery");
    	lModify.add("详细");
   
    	List lCol=new ArrayList();
    	
    	  lCol.add(lModify);
    	
   
    
    	
    	Rcjc getRcjc=new Rcjc();
        this.setData(getRcjc,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylistTjxx() throws Exception{
		try {
			Rcjc setrcjc=new Rcjc();
			setrcjc = (Rcjc)this.setClass(setrcjc, null);
			Map map = new HashMap();
			map.put("dsjgbz", setrcjc.getDsjgbz());
			map.put("fxjbz", setrcjc.getFxjbz());
			map.put("gxdwbz", setrcjc.getGxdwbz());
			map.put("csbz", setrcjc.getCsbz());
			
			
			
			
			String csjb = setrcjc.getCsjb();
			
			  if (csjb.equals("fxj")){
					map.put("fxjdm", setrcjc.getFxjdm());
			  }
			  else if (csjb.equals("gxdw")){
				  map.put("gxdwdm", setrcjc.getGxdwdm());
			  }else if (csjb.equals("qy")){
				    map.put("dsjgdm", setrcjc.getDsjgdm());
					map.put("fxjdm", setrcjc.getFxjdm());
					map.put("gxdwdm", setrcjc.getGxdwdm());
					map.put("qybm", setrcjc.getCsbm());
				  
			  }else{
					map.put("dsjgdm", setrcjc.getDsjgdm());
				 
				  }
			
			
			
			map.put("qsrq", setrcjc.getQssj());
			map.put("jzrq", setrcjc.getJzsj());
			map.put("hylbdm", setrcjc.getHylbdm());
			
			
	
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

		    if("".equals(setrcjc.getHylbdm())||"".equals(setrcjc.getHylbdm())){ //yangbo 2010-11-1 miao确认
		    	map.put("yyzt", "yes");//只显示装机开业
		    }
		    map.put("qyyyzt", "yes");//只显示营业状态为“营业”

			  
			
	        Page page = rcjcService.getTjxxListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataTjxx(page.getData(),setrcjc,"all"); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	
	
	public String querylistRcjcycyj()throws Exception{
		try {
			Rcjc setrcjc=new Rcjc();
			setrcjc = (Rcjc)this.setClass(setrcjc, null);
			Map map = new HashMap();
			map.put("hylbdm", setrcjc.getHylbdm());
			if(!"50".equals(StringUtil.trimEven0(setrcjc.getJcjgdm()))){
				map.put("jcjgdm_jx", StringUtil.trimEven0(setrcjc.getJcjgdm()));
			}
			map.put("jcjgdm", setrcjc.getJcjgdm());
			map.put("rcjcjgsj", QjblUtil.queryQjblVal("rcjcjgsj"));
			map.put("jcrqf", setrcjc.getJcrqf());
			map.put("jcrqt", setrcjc.getJcrqt());
			Page page = rcjcService.getRcjcycyjListForPage(map,pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
		    totalrows=page.getTotalRows();
		    setTabledataRcjcycyj(page.getData());
			this.result="success";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	public void setTabledataRcjcycyj(List lData)throws Exception{
		List lPro=new ArrayList();
		lPro.add("rcjcid");
		lPro.add("jcjgmc");
		lPro.add("mjjczbh");
		lPro.add("jcrq");
		lPro.add("jcrybh");
		lPro.add("jcrxm");
		lPro.add("jcrzw");
		Rcjc getRcjc=new Rcjc();
		this.setData(getRcjc,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
}