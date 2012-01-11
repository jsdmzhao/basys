package com.aisino2.publicsystem.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Encoder;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.ImageUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyry_zpService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyryxx_lsxxService;
import com.aisino2.publicsystem.service.IQyryxxhcService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.opensymphony.xwork2.ActionContext;

public class QyryxxAction extends PageAction{
	private IDict_itemService dict_itemService;
	private IQyryxxService qyryxxService;
	private IQyjbxxService qyjbxxService;
	protected IQyry_zpService qyry_zpService;
	private IQyryxx_lsxxService qyryxx_lsxxService;
	private IQyryxxhcService qyryxxhcService;
	
	private List lQyryxx=new ArrayList();
	private Qyryxx qyryxx=new Qyryxx();
	private List lQyryxx_lsxx=new ArrayList();
	private String tabledata="";
	private String result="success";
	private int myPageSize;
	private int totalrows=0;
	private String baseStringPic = "";

	public int getTotalrows() {
		return totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Qyryxx getQyryxx() {
		return qyryxx;
	}
	
	public List getLQyryxx() {
		return lQyryxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}
	public void setTabledata_gad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxz");
		lPro.add("zhiwu");
		lPro.add("qymc");
		lPro.add("zzzhm");
		lPro.add("cyryzt");

    	List lCol=new ArrayList();
    	
    	Qyryxx getQyryxx=new Qyryxx();
    	
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lTj=new ArrayList();
    	lTj.add("detailTjxx");
    	lTj.add("体检信息");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	lCol.add(lTj);
    	
    	Qyryxx getQyryxx=new Qyryxx();
    	
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataGadGl(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxzqh");
		lPro.add("gwmc");
		lPro.add("qymc");
		lPro.add("zt");
		lPro.add("cyryzt");
		
    	List lModify=new ArrayList();
    	lModify.add("setModify");
    	lModify.add("修改");
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyryxx getQyryxx=new Qyryxx();
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxzqh");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");

    	List lCygj=new ArrayList();
    	lCygj.add("setCyryCygj");
    	lCygj.add("从业轨迹");
    	
    	List lGzrz=new ArrayList();
    	lGzrz.add("setCyryGzrz");
    	lGzrz.add("工作日志");
//    	
    	
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	lCol.add(lGzrz);
    	//lCol.add(lXq);
    	//lCol.add(lDy);
    	
    	Qyryxx getCyryxx=new Qyryxx();
    	
        this.setData(getCyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataGadcygj(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("rzrq");
		lPro.add("csmc");
		//lPro.add("lzsj");
		lPro.add("cjdmc");
    
    	Qyryxx getCyryxx=new Qyryxx();
    	
        this.setData(getCyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataGadzx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		//lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxzqh");
		lPro.add("gwmc");
		lPro.add("qymc");
		lPro.add("zxbzmc");
		lPro.add("cyryzt");
    	
		List lXzcz = new ArrayList();

    	List lZx=new ArrayList();
    	//lZx.add("setCyryZx");
    	lZx.add("setCyryZx");
    	lZx.add("注销");
    	lZx.add("zxbz");
    	lZx.add("0");
    	lXzcz.add(lZx);
    	
    	lZx=new ArrayList();
    	//lZxhf.add("setCyryZxhf");
    	lZx.add("setCyryZx");
    	lZx.add("注销恢复");
    	lZx.add("zxbz");
    	lZx.add("1");
    	lXzcz.add(lZx);
    	
    	Qyryxx getQyryxx=new Qyryxx();
    	this.setDataCustomer(getQyryxx, lData, lPro, null, lXzcz);
        //this.setData(getCyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataTj(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("zt");
    	
		Qyryxx getCyryxx=new Qyryxx();
		this.setData(getCyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
			if(map.get("qyid")!=null&&!"".equals(map.get("qyid").toString())){
		        Page page = qyryxxService.getListForPage(map, pagesize, pagerow,sort,dir);
		        dictFanYi(page.getData());
		        totalpage=page.getTotalPages();
		        totalrows=page.getTotalRows();
		        lQyryxx=page.getData();  
		        for(int i=0;i<lQyryxx.size();i++){
		        	Qyryxx ryxx=(Qyryxx)lQyryxx.get(i);
		        	String xm=ryxx.getXm()+"<input type='hidden' id='qyid' value='"+ryxx.getQyid()+"'>";
		        	ryxx.setXm(xm);
		        }
			}
	        setTabledata(lQyryxx); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        
        return "success";
    }
	
	/**
	 * 企业端 未提交人员查询
	 */
	public String querylistWtjry() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String lrdwbm = "";
		lrdwbm = user.getDepartment().getDepartcode();
		if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
			lrdwbm = user.getSsdwbm();
		}
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("cyzj", setQyryxx.getCyzj());
			map.put("cyzjdm", setQyryxx.getCyzjdm());
			map.put("lrsjf", setQyryxx.getLrsjf());
			map.put("lrsjt", setQyryxx.getLrsjt());
			map.put("ywx", setQyryxx.getYwx());
			map.put("ywm", setQyryxx.getYwm());
			map.put("lrdwbm", lrdwbm);
	        Page page = qyryxxService.getWtjListForPage(map, pagesize, pagerow,sort,dir);
	        List temp = page.getData();
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        dictFanYi(temp);
	        int length = temp.size();
	        Qyryxx qyryxx ;
	        for(int index=0;index<length;index++){
	        	qyryxx = (Qyryxx)temp.get(index);
	        	qyryxx.setCyrybh(qyryxx.getCyrybh()+"<input type='hidden' name='lb"+qyryxx.getRyid()+"' value='"+qyryxx.getCyrylbdm()+"' />");
	        }
	        setTabledataTj(page.getData());
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 部分提交
	 */
	public String modifyRyTj() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			String ryidSet = setQyryxx.getRyidSet();

			List lCyryxx = new ArrayList();
			if(ryidSet!=null && !ryidSet.equals("")){
				String [] ryidArry = ryidSet.split(",");
				int arryLength = ryidArry.length;
				boolean isTiJiao = true,isHaveSuc = false,isHaveFail = false;
				for(int index=0;index<arryLength;index++){
					Qyryxx oneCyryxx = new Qyryxx();
					oneCyryxx.setRyid(new Integer(ryidArry[index]));
					oneCyryxx.setCzr(user.getUseraccount());
					lCyryxx.add(oneCyryxx);
					
					if(((index+1)%2==0) || (index+1==arryLength)){
						isTiJiao = qyryxxService.updateQyryxxTj(lCyryxx);
						lCyryxx = new ArrayList();
						if(isTiJiao)
							isHaveSuc = true;
						else
							isHaveFail = true;
					}
				}
				if(isHaveSuc && !isHaveFail)
				    this.result="success";
				else if(isHaveSuc && isHaveFail)
					this.result="部分提交成功";
				else
					this.result="提交失败";
			}
		} catch (Exception e) {
			this.result="提交失败";
			e.printStackTrace();
		}
		
	    return "success";
	}	
	/**
	 * 全部提交
	 */
	public String modifyRyTjQb() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String lrdwbm = user.getDepartment().getDepartcode();
		if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
			lrdwbm = user.getSsdwbm();
		}
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			setQyryxx.setLrdwbm(lrdwbm);
			setQyryxx.setCzr(user.getUseraccount()); 
			qyryxxService.updateQyryxxQbtj(setQyryxx);
		} catch (Exception e) {
		    this.result="提交失败";
			e.printStackTrace();
		}
	    return "success";
	}
	
	/**
	 * 公安端 人员管理查询 2010-2-22 yb
	 * @return
	 * @throws Exception
	 */
	public String querylistGadGl() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			String gxdwbmTemp = setQyryxx.getGxdwbm();
			String gxdwbm = user.getDepartment().getDepartcode();
			gxdwbm = (gxdwbmTemp!=null&&!"".equals(gxdwbmTemp))?gxdwbmTemp:gxdwbm;
			
			Map map = new HashMap(); 
			map.put("hylbdm", setQyryxx.getHylbdm());
			map.put("cyrybh", setQyryxx.getCyrybh());
			if(gxdwbm.indexOf("CJD")==0){
				map.put("lrdwbm", StringUtil.trimEven0(gxdwbm));
			}else{
				map.put("gxdwbm", StringUtil.trimEven0(gxdwbm));
			}
			map.put("qybm", setQyryxx.getQybm());
			map.put("xm", setQyryxx.getXm());
			map.put("zjhm", setQyryxx.getZjhm());
			map.put("xbdm", setQyryxx.getXbdm());
			map.put("gwbh", setQyryxx.getGwbh());
			map.put("scbz", "0");
			
	        Page page = qyryxxService.getListGadForPage(map, pagesize, pagerow,sort,dir);
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataGadGl(page.getData()); 
		} catch (Exception e) {
			 this.result="查询失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public void setTabledataGadsc(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		//lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxzqh");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zxr");
		lPro.add("zxsj");
		lPro.add("cyryzt");
    	
//    	List lXq=new ArrayList();
//    	lXq.add("setCyryXq");
//    	lXq.add("璇︽儏");
    	
//    	List lCol=new ArrayList();
//    	lCol.add(lXq);
    	
    	Qyryxx getQyryxx=new Qyryxx();
    	
        this.setData(getQyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	//从业人员注销查询
	public String querylistGadzx() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			qyryxx=(Qyryxx)this.setClass(setQyryxx, null);
	        Map map = new HashMap();
	        map=addMap(qyryxx);
	        map.put("loselizhi", "yes");
	        map.put("scbz", "0");
	        Page page = qyryxxService.getListGadForPage(map, pagesize, pagerow,sort,dir);
	        myPageSize = pagesize;
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	       // lQyryxx=page.getData();  
	        for(Iterator iter=page.getData().iterator();iter.hasNext();){
	        	Qyryxx oneQyryxx=(Qyryxx)iter.next();
	        	lQyryxx.add(setCyryxxDict_itemList(oneQyryxx));
	        }
	        setTabledataGadzx(lQyryxx);  
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        return "success";
    }
	public void setTabledataCsls(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("rylsid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("rzrq");
		lPro.add("cyryzt");
    	
    	Qyryxx_lsxx getQyryxx_lsxx=new Qyryxx_lsxx();
    	
        this.setData(getQyryxx_lsxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataCs(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("rzrq");
		lPro.add("zt");
		lPro.add("cyryzt");
		lPro.add("cyryztdm");
    	
		List lModify=new ArrayList();
    	lModify.add("updateCyryxx");
    	lModify.add("修改");
    	
    	List lTjxx=new ArrayList();
    	lTjxx.add("detailTjxx");
    	lTjxx.add("体检信息");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lTjxx);
    	
    	Qyryxx getCyryxx=new Qyryxx();
    	
        this.setData(getCyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}	
	public String querylistCs() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			qyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			
			Map map = new HashMap();
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			map=addMap(qyryxx);
			if(map.get("qyid")!=null&&!"".equals(map.get("qyid").toString())){
				Page page = qyryxxService.getListQydForPage(map, pagesize, pagerow,sort,dir);
		        totalpage=page.getTotalPages();
		        totalrows=page.getTotalRows();
		        dictFanYi(page.getData());
		        lQyryxx=page.getData();
		        
		        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
		        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
		        	oneCyryxx.setXb(oneCyryxx.getXb()+"<input type='hidden' name='ry"+oneCyryxx.getRyid()+"' value='"+oneCyryxx.getQyid()+"'/>");
		        }
			}
	        
	        setTabledataCs(lQyryxx); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "success";
    }	
	public String querylistCsls() throws Exception{
		try {
			Qyryxx setCyryxx=new Qyryxx();
			qyryxx=(Qyryxx)this.setClass(setCyryxx, null);
			
			Map map = new HashMap();
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			map=addMap(qyryxx);
	        Page page = qyryxx_lsxxService.getCyryxx_lsxxListQydGnForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        dictFanYi_ls(page.getData());
	        List lCyry_lsxx = null;
	        lCyry_lsxx=page.getData();
	        setTabledataCsls(lCyry_lsxx); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "success";
    }	
	public String querylistGad() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			qyryxx=(Qyryxx)this.setClass(setQyryxx, null);
	        Map map = new HashMap();
	        map=addMap(qyryxx);
	        Page page = qyryxxService.getListGadForPage(map, pagesize, pagerow,sort,dir);
	        myPageSize = pagesize;
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        dictFanYi(page.getData());
	        lQyryxx=page.getData();  
//	        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
//	        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
//	        	setCyryxxDict_itemList(oneCyryxx);
//	        }
	       
	        setTabledataGad(lQyryxx); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	public String querylistGadsc() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
	        Map map = new HashMap();
	        map=addMap(setQyryxx);
	        map.put("scbz", "1");
	        Page page = qyryxxService.getScListGadForPage(map, pagesize, pagerow,sort,dir);
	        myPageSize = pagesize;
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryxx=page.getData();  
	        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
	        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
	        	setCyryxxDict_itemList(oneCyryxx);
	        }
	        setTabledataGadsc(lQyryxx); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	/**
	 * 从业人员变更查询列表---公安端
	 * */
	public void setTabledataGadBG(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("rzrq");
		lPro.add("cyryzt");
    	
    	List lXq=new ArrayList();
    	lXq.add("setCyryXq");
    	lXq.add("变更轨迹");
    	
    	List lCol=new ArrayList();
    	lCol.add(lXq);
    	
    	Qyryxx getQyryxx=new Qyryxx();
    	
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 从业人员变更查询---公安端
	 * */
	public String querylistGadBG() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
	        Map map = new HashMap();
	        map=addMap(setQyryxx);
	        Page page = qyryxxService.getBgListGadForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryxx=page.getData();  
//	        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
//	        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
//	        	setCyryxxDict_itemList(oneCyryxx);
//	        }
	        setTabledataGadBG(lQyryxx); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	/**
	 * 从业人员历史查询列表---公安端
	 * */
	public void setTabledataGadLS(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("rylsid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("bcsj");
		lPro.add("cyryzt");
    	
    	List lXq=new ArrayList();
    	lXq.add("cyrylsxx_setXqInfo");
    	lXq.add("详情");
    	
    	List lCol=new ArrayList();
    	lCol.add(lXq);
    	
    	Qyryxx_lsxx getQyryxx_lsxx=new Qyryxx_lsxx();
    	
        this.setData(getQyryxx_lsxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 从业人员历史查询---公安端
	 * */
	public String querylistGadLS() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
	        Map map = new HashMap();
	        map.put("ryid", setQyryxx.getRyid());
			map.put("bcsjf", setQyryxx.getBcsj());
			map.put("bcsjt", setQyryxx.getBcsjt());
			//根据登陆用户 设置查询条件  只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
			map.put("deptCode", depertCode0);;
	        Page page = qyryxx_lsxxService.getCyryxx_lsxxListGadGnForPage(map, pagesize, pagerow, sort, dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryxx=page.getData();  
	        setTabledataGadLS(lQyryxx); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	/**
	 * 变更历史信息
	 * @return
	 */
	public String queryLs(){
		try {
			Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
			setQyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setQyryxx_lsxx, null);
			setQyryxx_lsxx=qyryxx_lsxxService.getQyryxx_lsxx(setQyryxx_lsxx);
	        lQyryxx_lsxx.clear();
			setQyry_lsxxDict_item(setQyryxx_lsxx);
	        lQyryxx_lsxx.add(setQyryxx_lsxx);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
		}
        return "success";
	}
	
	/**
	 * 变更历史对比信息
	 * @return
	 */
	public String queryLsBalance(){
		try {
			Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
			setQyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setQyryxx_lsxx, null);
			String isLast = qyryxx_lsxxService.isLatestBgQyryxx_lsxx(setQyryxx_lsxx); //判断是否是最新记录
			
			if("0".equals(isLast)){ //不是最新记录
				setQyryxx_lsxx = qyryxx_lsxxService.getNextBgQyryxx_lsxx(setQyryxx_lsxx);
				lQyryxx_lsxx.clear();
				setQyry_lsxxDict_item(setQyryxx_lsxx);
		        lQyryxx_lsxx.add(setQyryxx_lsxx);
			}
			if("1".equals(isLast)){ //是最新记录 则取娱乐场所信息
				Qyryxx setQyryxx=new Qyryxx();
				setQyryxx.setRyid(setQyryxx_lsxx.getRyid());
				setQyryxx.setScbz(setQyryxx_lsxx.getScbz());
				setQyryxx=qyryxxService.getQyryxx(setQyryxx);
				setCyryxxDict_itemList(setQyryxx);
				lQyryxx_lsxx.clear();
		        lQyryxx_lsxx.add(setQyryxx);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	
	/**人员信息状态改变（从数字转换为汉字，友好显示列表信息）*/
	public Qyryxx setCyryxxDict_itemList(Qyryxx data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getZt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
			dict_item.setFact_value(data.getZt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZt(displayName);
		}

		if(data.getZxbz()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxbz");
			dict_item.setFact_value(data.getZxbz());
			List list = CacheManager.getCacheDictitem(dict_item);
			Map jlztMap = new HashMap();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
				jlztMap.get(data.getCyryzt());
				data.setZxbzmc((String)jlztMap.get(data.getZxbz()));
		}
		if(data.getHyzk()!=null){
			displayName = "";
			dict_item.setDict_code("dm_hyzk");
			dict_item.setFact_value(data.getHyzk());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0){
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
				data.setHyzk(displayName);
			}
		}
		if(data.getZxyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxyy(cyry)");
			dict_item.setFact_value(data.getZxyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			Map jlztMap = new HashMap();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			data.setZxyy((String)jlztMap.get(data.getZxyy()));
		}

		return data;
	}	
	public String modifyZxhf() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			setQyryxx=qyryxxService.getQyryxx(setQyryxx);
	        
	        javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			setQyryxx.setCzr(user.getUseraccount());
			
	        qyryxxService.updateQyryxxZxhf(setQyryxx);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "success";
	}
	public String modifyZx() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			setQyryxx.setZxr(user.getUseraccount());
			
	        qyryxxService.updateQyryxxZx(setQyryxx);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "success";
	}
	public String query() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			qyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			qyryxx=qyryxxService.getQyryxx(qyryxx);
			if(qyryxx!=null){
				qyryxx=setCyryxxDict_itemList(qyryxx);
				
				qyryxx.setZxbz(qyryxx.getZxbzmc());
			}
			
		        lQyryxx.clear();
		        lQyryxx.add(qyryxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			setQyryxx=findQyid(setQyryxx);
			List isCyryExist = qyryxxService.getIsQyryxxExist(setQyryxx);
			if(isCyryExist!=null && isCyryExist.size()>0){
				this.result="公民身份号码已存在";
				lQyryxx.add(this.result);
				return "success";
			}
			setQyryxx=fzQyryxx_zp(setQyryxx);
			setQyryxx.setCyrylbdm("0");
			setQyryxx.setCyrylbmc("国内从业人员");
			setQyryxx.setCyryztdm("10");
			setQyryxx.setCyryzt(findqycyryzt("10"));
			setQyryxx=qyryxxService.insertQyryxx(setQyryxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			setQyryxx=fzQyryxx_zp(setQyryxx);
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			String useraccount=user.getUseraccount();
			setQyryxx.setCzr(useraccount);
			qyryxxService.updateQyryxx(setQyryxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	/**
	 * 公安端 人员添加 2010-2-22 yb
	 * @return
	 * @throws Exception
	 */
	public String insertGad() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			
			Qyjbxx qyjbxx =new Qyjbxx();
			qyjbxx.setQybm(setQyryxx.getQybm());
			qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
			setQyryxx.setQyid(qyjbxx.getQyid());
			setQyryxx.setHylb(qyjbxx.getHylb());
			setQyryxx.setHylbdm(qyjbxx.getHylbdm());
			setQyryxx.setLrdwbm(qyjbxx.getQybm());
			setQyryxx.setLrdwmc(qyjbxx.getQymc());
			
			setQyryxx=findQyid(setQyryxx);
			List isCyryExist = qyryxxService.getIsQyryxxExist(setQyryxx);
			if(isCyryExist!=null&&isCyryExist.size()>0){
				this.result="公民身份号码已存在";
				return "success";
			}
			setQyryxx=fzQyryxx_zp(setQyryxx);
			setQyryxx.setCyrylbdm("0");
			setQyryxx.setCyrylbmc("国内从业人员");
			setQyryxx.setCyryztdm("10");
			setQyryxx.setCyryzt(findqycyryzt("10"));
			setQyryxx=qyryxxService.insertQyryxx(setQyryxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			String useraccount=user.getUseraccount();
			setQyryxx.setCzr(useraccount);
			 qyryxxService.deleteQyryxx(setQyryxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.result="success";
        return "success";
    }
	/**
	 * 人员预警
	 * @return
	 * @throws Exception
	 */
	public String yj() throws Exception{
		try {
			Qyryxxhc setQyryxxhc=new Qyryxxhc();
			setQyryxxhc=(Qyryxxhc)this.setClass(setQyryxxhc, null);
			setQyryxxhc = qyryxxhcService.getQyryxxhc(setQyryxxhc);
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			String useraccount=user.getUseraccount();
			
			Qyryxx setQyryxx = new Qyryxx();
			setQyryxx.setRyid(setQyryxxhc.getRyid());
			setQyryxx.setCzr(useraccount);
			setQyryxx.setYjbz("1");
			setQyryxx.setYjsj(new Date());
			 qyryxxService.updateQyryxxOnly(setQyryxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.result="success";
        return "success";
    }
	public Qyryxx findQyid(Qyryxx setQyryxx){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
	    int qyid=0;
	    String usercount="";
	    Qyjbxx qyjbxx =new Qyjbxx();
	    if(user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm()))
	    {
	    	usercount=user.getSsdwbm();
	    	  qyjbxx.setQybm(usercount);
	  	    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
	    }else{
	    	qyjbxx=null;
	    }
	  
		if(qyjbxx!=null){
			setQyryxx.setQyid(qyjbxx.getQyid());
			setQyryxx.setHylb(qyjbxx.getHylb());
			setQyryxx.setHylbdm(qyjbxx.getHylbdm());
			setQyryxx.setLrdwbm(qyjbxx.getQybm());
			setQyryxx.setLrdwmc(qyjbxx.getQymc());
		}else{
			//String name=user.getUsername();
			//setQyryxx.setCzr(name);
			setQyryxx.setLrdwbm(user.getDepartment().getDepartcode());
			setQyryxx.setLrdwmc(user.getDepartment().getDepartname());
		}
		setQyryxx.setLrr(user.getUseraccount());
		return setQyryxx;
	}
	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}
	//场所人员历史信息
	public String queryCsls() throws Exception{
		try {
			Qyryxx_lsxx setCyryxx_lsxx=new Qyryxx_lsxx();
			setCyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setCyryxx_lsxx, null);
	        
			setCyryxx_lsxx=qyryxx_lsxxService.getQyryxx_lsxx(setCyryxx_lsxx);
	        lQyryxx = new ArrayList();
	        lQyryxx.clear();

	        setQyry_lsxxDict_item(setCyryxx_lsxx);
	        lQyryxx.add(setCyryxx_lsxx);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxx=null;
		this.result="success";
        return "success";
    }
	/**人员历史信息状态改变（从数字转换为汉字，友好显示详细信息）*/
	private void setQyry_lsxxDict_item(Qyryxx_lsxx data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getZt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
			dict_item.setFact_value(data.getZt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZt(displayName);
		}
		if(data.getHyzk()!=null){
			displayName = "";
			dict_item.setDict_code("dm_hyzk");
			dict_item.setFact_value(data.getHyzk());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0){
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			}
			data.setHyzk(displayName);
		}
		if(data.getZxbz()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxbz");
			dict_item.setFact_value(data.getZxbz());
			List list = CacheManager.getCacheDictitem(dict_item);
			Map jlztMap = new HashMap();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
				jlztMap.get(data.getCyryzt());
				data.setZxbz((String)jlztMap.get(data.getZxbz()));
		}
		if(data.getZxyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxyy(cyry)");
			dict_item.setFact_value(data.getZxyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZxyy(displayName);
		}
		
	}	
	//根据人员ID查询人员照片
	public void queryTp() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest requeset = ServletActionContext.getRequest();
		OutputStream out = response.getOutputStream();
		try{
        		String ryId = requeset.getParameter("ryId");
        		
        		Qyry_zp zp = new Qyry_zp();
        		zp.setRyid(new Integer(ryId));
        		zp=qyry_zpService.getQyry_zp(zp);
    			response.setCharacterEncoding("UTF-8");
    			response.setContentType("image/jpeg");
    			byte [] by ;
        		if(zp!=null){
        			by = zp.getTpnr();
        			if(by==null || by.length==0){
        				sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
        				by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
        			}
        		}else{
        			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
    				by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
        		}
        		out.write(by);
        	}catch(Exception e){
        		e.printStackTrace();
        	}finally{
        		if(out!=null)
        			out.close();
        	}
	}
	//根据人员ID查询人员照片
	public String queryBaseTpnr() throws Exception{
		HttpServletRequest requeset = ServletActionContext.getRequest();
		try{
    		String ryId = requeset.getParameter("ryId");
    		Qyry_zp zp = new Qyry_zp();
    		zp.setRyid(new Integer(ryId));
    		zp=qyry_zpService.getQyry_zp(zp);
    		String basePic = "";
			byte[] by = null;
    		if(zp!=null){
    			by = zp.getTpnr();
    			if(by==null || by.length==0){
    				basePic = ImageUtil.picConTemp;
    			} else {
    				BASE64Encoder encoder = new BASE64Encoder();
    				basePic = encoder.encode(by);
    			}
    		}else{
    			basePic = ImageUtil.picConTemp;
    		}
    		baseStringPic = basePic;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "success";
	}
	public Qyryxx fzQyryxx_zp(Qyryxx setQyryxx){
		Qyry_zp zp=new Qyry_zp();
		sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
		
		try {
			if(setQyryxx.getFileload()!=null&&!"".equals(setQyryxx.getFileload())){
				byte[] by;
				by = base64Decoder.decodeBuffer(setQyryxx.getFileload());
				zp.setTpnr(by);
				setQyryxx.setQyry_zp(zp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setQyryxx;
	}
	public void excelCreate() throws Exception{
		List lResult=this.getExcelResponse();
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		
		Qyryxx setQyryxx=new Qyryxx();
		setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
		
		Map map = new HashMap();
		map=addMap(setQyryxx);
        Page page = qyryxxService.getListForPage(map, 1, Integer.parseInt(maxRows),sort,dir);
        dictFanYi(page.getData());
		dealExcelData(page.getData(),lResult);
		this.result="ok";
	}
	/**
	 * 企业人员筛选框
	 * @return
	 * @throws Exception
	 */
	public String querylistDict() throws Exception{
		try {
			Qyryxx setCyryxx=new Qyryxx();
			setCyryxx=(Qyryxx)this.setClass(setCyryxx, null);
			Map map = new HashMap();
			map=addMap(setCyryxx);
			map.put("scbz","0");
			map.put("query_simplepin", setCyryxx.getQuery_simplepin());//筛选框条件
			Page page = qyryxxService.getQyryxxListQydDictForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledataDict(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	
	/**
	 * 企业人员筛选框
	 * @return
	 * @throws Exception
	 */
	public String querylistRyDict() throws Exception{
		try {
			Qyryxx setCyryxx=new Qyryxx();
			setCyryxx=(Qyryxx)this.setClass(setCyryxx, null);
			Map map = new HashMap();
			map=addMap(setCyryxx);
			map.put("qybm", setCyryxx.getQybm());
			map.put("xm", setCyryxx.getXm());//筛选框条件
			Page page = qyryxxService.getQyryxxListQydDictForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledataRyDict(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 公安端 场所查询
	 * @return
	 * @throws Exception
	 */
	public void setTabledataDict(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("gwmc");

    	 
    	
    	Qyryxx getCyryxx=new Qyryxx();
    	
        this.setData(getCyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 公安端 场所查询
	 * @return
	 * @throws Exception
	 */
	public void setTabledataRyDict(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("cyrybh");

    	 
    	
    	Qyryxx getCyryxx=new Qyryxx();
    	
        this.setData(getCyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 公安端 场所查询
	 * @return
	 * @throws Exception
	 */
	public String querylistGadCscx() throws Exception{
		try {
			Qyryxx setCyryxx=new Qyryxx();
			setCyryxx=(Qyryxx)this.setClass(setCyryxx, null);
	        Map map = new HashMap();
	        map.put("qyid", setCyryxx.getQyid());
	        map.put("qybm", setCyryxx.getQybm());
	        map.put("scbz","0");
	        map.put("zxbz","0");
	        Page page = qyryxxService.getQyryxxListByCsidForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataGadCscx(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		    return "success";
		}
		this.result="success";
	    return "success";
	}
	/**
	 * 公安端 场所查询
	 * @return
	 * @throws Exception
	 */
	public void setTabledataGadCscx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("cylb");

    	List lCygj=new ArrayList();
    	lCygj.add("set_CscxCygj");
    	lCygj.add("从业轨迹");
    	
    	List lGzrz=new ArrayList();
    	lGzrz.add("set_CscxGzrz");
    	lGzrz.add("工作日志");
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	lCol.add(lGzrz);
    	
    	Qyryxx getCyryxx=new Qyryxx();
    	
        this.setData(getCyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	private void dealExcelData(List data,List lResult) {
		
		List lPro = new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");
 
		Qyryxx setQyryxx=new Qyryxx();
		List lcache = new ArrayList();
//		List lcache2 = this.getDictItemCacheList("cyryzt","dm_jlzt","0");
//		
//		lcache.add(lcache2);
		
		data=this.getResultCache(setQyryxx.getClass().getName(), lPro, data, lcache);
		
        lResult.add(data);
        lResult.add(setQyryxx);
        try {
			this.setExcelCreate("cyryxx",lResult);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public Map addMap(Qyryxx setQyryxx){
		Map map=new HashMap();
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		String usercount="";
		Qyjbxx qyjbxx =new Qyjbxx();
		if(user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm()))
	    {
	    	usercount=user.getSsdwbm();
		    qyjbxx.setQybm(usercount);
		    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
	    }
	    
        if(setQyryxx!=null){
        	map.put("xm", setQyryxx.getXm());
        	map.put("zjhm", setQyryxx.getZjhm());
        	map.put("cyryztdm", setQyryxx.getCyryztdm());
        	map.put("xbdm", setQyryxx.getXbdm());
        	map.put("cyrybh", setQyryxx.getCyrybh());
        	map.put("cyrylbdm", setQyryxx.getCyrylbdm());
        	map.put("cyryzt", setQyryxx.getCyryzt());
        	map.put("gwbh", setQyryxx.getGwbh());
        	map.put("qybm", setQyryxx.getQybm());
        	map.put("zt", setQyryxx.getZt());
        	map.put("cyrybh", setQyryxx.getCyrybh());
        	map.put("hylbdm", setQyryxx.getHylbdm());
        	map.put("hjdxzqhdm", setQyryxx.getHjdxzqhdm());
        	map.put("csrq", setQyryxx.getCsrq());
        	map.put("zxbz", setQyryxx.getZxbz()); 
        	map.put("isTongyin", setQyryxx.getSfty());
        	map.put("isZhaopianExist", setQyryxx.getSfyzp());
        	map.put("nianlingF", setQyryxx.getNianlingF());
        	map.put("nianlingT", setQyryxx.getNianlingT());
        	if(setQyryxx.getXm()!=null&&!"".equals(setQyryxx.getXm())){
        		map.put("xmpy", PinYinUtil.getHanyuPingYin(setQyryxx.getXm()));
        	}
        	if(setQyryxx.getGxdwbm()!=null&&!"".equals(setQyryxx.getGxdwbm())){
        		map.put("gxdwbm", StringUtil.trimEven0(setQyryxx.getGxdwbm()));
        	}else{
        		map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
        	}
        	if(qyjbxx!=null){
        		map.put("qyid", qyjbxx.getQyid());
        	}
        	//System.out.println("管辖单位"+map.get("gxdwbm")+"部门编号"+map.get("deptCode"));
        }
		return map;
	}
	 /**
	 * 翻译字典项
	 */
	public void dictFanYi(List queryList){
		String displayName;
		if(queryList!=null&&queryList.size()>0){
			Map jlztMap = new HashMap();
			Dict_item dict_item = new Dict_item();
			dict_item.setDict_code("dm_jlzt");
			dict_item.setItem_allpin("");
			dict_item.setItem_simplepin("");
			dict_item.setFact_value("");
			dict_item.setDisplay_name("");
			dict_item.setAppend_value("");
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			for(int index=0,max=queryList.size();index<max;index++){
				Qyryxx temp = (Qyryxx)queryList.get(index);
				jlztMap.get(temp.getZt());
				temp.setZt((String)jlztMap.get(temp.getZt()));
			}
		}
	}
	public void dictFanYi_ls(List queryList){
		String displayName;
		if(queryList!=null&&queryList.size()>0){
			Map jlztMap = new HashMap();
			Dict_item dict_item = new Dict_item();
			dict_item.setDict_code("dm_jlzt");
			dict_item.setItem_allpin("");
			dict_item.setItem_simplepin("");
			dict_item.setFact_value("");
			dict_item.setDisplay_name("");
			dict_item.setAppend_value("");
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			for(int index=0,max=queryList.size();index<max;index++){
				Qyryxx_lsxx temp = (Qyryxx_lsxx)queryList.get(index);
				jlztMap.get(temp.getZt());
				temp.setZt((String)jlztMap.get(temp.getZt()));
			}
		}
	}
	public String findqycyryzt(String dm){//根据代码找从业人员状态


		Map jlztMap = new HashMap();
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code("dm_cyryzt(yly)");
		dict_item.setItem_allpin("");
		dict_item.setItem_simplepin("");
		dict_item.setFact_value("");
		dict_item.setDisplay_name("");
		dict_item.setAppend_value("");
		List list = CacheManager.getCacheDictitem(dict_item);
		if(list!=null&&list.size()>0){
			for(int index=0,max=list.size();index<max;index++){
				Dict_item temp = (Dict_item)list.get(index);
				jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
			}
		}
		return (String)jlztMap.get(dm);
	}
	public void setQyry_zpService(IQyry_zpService qyry_zpService) {
		this.qyry_zpService = qyry_zpService;
	}

	public int getMyPageSize() {
		return myPageSize;
	}

	public void setMyPageSize(int myPageSize) {
		this.myPageSize = myPageSize;
	}

	public void setQyryxx_lsxxService(IQyryxx_lsxxService qyryxx_lsxxService) {
		this.qyryxx_lsxxService = qyryxx_lsxxService;
	}
	
	/**
	 * 制卡端 从业人员 请求类表
	 * @return
	 * @throws Exception
	 */
	public String queryCyryZkdList() throws Exception{
		try {
			Map dictTemp = new HashMap();
			dictTemp.put("", ""); dictTemp.put(null, "");
			Map dict = new HashMap();
			dict.put("dict_code","dm_jlzt");
			Page dictpage = dict_itemService.getListForPage(dict, 1, 30,null,null);
			List dictList = dictpage.getData();
			if(dictList!=null&&dictList.size()>0){
				for(int index=0,max=dictList.size();index<max;index++){
					Dict_item temp = (Dict_item)dictList.get(index);
					dictTemp.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			
			Qyryxx setCyryxx=new Qyryxx();
			setCyryxx=(Qyryxx)this.setClass(setCyryxx, null);
	        Map map = new HashMap();
	        map.put("xm", setCyryxx.getXm());
	        map.put("zjhm", setCyryxx.getZjhm());
	        map.put("xbdm", setCyryxx.getXbdm());
	        map.put("qybm", setCyryxx.getQybm());
	        map.put("qymc", setCyryxx.getQymc());
	        map.put("hylbdm",setCyryxx.getHylbdm());
	        map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = qyryxxService.getListZkdForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        
	        if(setCyryxx.getZkdQyxxCyry()!=null&&"1".equals(setCyryxx.getZkdQyxxCyry())){ //场所信息 查询人员信息
	        	page = qyryxxService.getListZkdByCsidForPage(map, pagesize, pagerow,sort,dir);
	        	List tempList = page.getData();
	        	List resList = new ArrayList();
	        	if(tempList!=null&&tempList.size()>0){
	    			for(int index=0,max=tempList.size();index<max;index++){
	    				Qyryxx temp = (Qyryxx)tempList.get(index);
	    				temp.setCyryzt((String)dictTemp.get(temp.getZt()));
	    				resList.add(temp);
	    			}
	    		}
	        	setCsxxCyryZkdTabledata(resList);
	        } else {
	        	page = qyryxxService.getListZkdForPage(map, pagesize, pagerow,sort,dir);
	        	List tempList = page.getData();
	        	List resList = new ArrayList();
	        	if(tempList!=null&&tempList.size()>0){
	        		for(int index=0,max=tempList.size();index<max;index++){
	        			Qyryxx temp = (Qyryxx)tempList.get(index);
	        			temp.setXmpy(temp.getRyid()+"----"+temp.getQyid()); //需要场所信息 拼在主键ID上
	        			temp.setCyryzt((String)dictTemp.get(temp.getZt()));
	        			resList.add(temp);
	        		}
	        	}
	        	setCyryZkdTabledata(resList);
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
	 *  制卡端 从业人员 列表
	 * @return
	 * @throws Exception
	 */
	public void setCyryZkdTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("xmpy");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("gj");
		lPro.add("xb");
		lPro.add("cylb");
		lPro.add("qymc");
		lPro.add("cyryzt");
		
		List lXzcz=new ArrayList();
		List lCk = new ArrayList();
    	lCk.add("gn");
    	lCk.add("查看");
    	lCk.add("cyrylbdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("gw");
    	lCk.add("查看");
    	lCk.add("cyrylbdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("gn");
    	lCk.add("IC卡");
    	lCk.add("cyrylbdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("gw");
    	lCk.add("IC卡");
    	lCk.add("cyrylbdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	
    	Qyryxx getCyryxx=new Qyryxx();
    	
    	this.setDataCustomer(getCyryxx,lData,lPro,null,lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}

	/**
	 * 制卡端 企业信息 查询 从业人员 列表
	 * @return
	 * @throws Exception
	 */
	public void setCsxxCyryZkdTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("gj");
		lPro.add("xb");
		lPro.add("cylb");
		lPro.add("cyryzt");

		List lXzcz=new ArrayList();
		List lCk = new ArrayList();
    	lCk.add("gn");
    	lCk.add("查看");
    	lCk.add("cyrylbdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("gw");
    	lCk.add("查看");
    	lCk.add("cyrylbdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("gn");
    	lCk.add("IC卡");
    	lCk.add("cyrylbdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("gw");
    	lCk.add("IC卡");
    	lCk.add("cyrylbdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	
    	Qyryxx getCyryxx=new Qyryxx();
    	
    	this.setDataCustomer(getCyryxx,lData,lPro,null,lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}	
	public String querylistforgad() throws Exception{
		try{
			Qyryxx setQyryxx=new Qyryxx();
	        Map map = new HashMap();
	        setQyryxx = (Qyryxx)this.setClass(setQyryxx, null);
	        HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			if(user==null){
				result="";
				return "success";
			}
			
			map.put("qyid", setQyryxx.getQyid());
	    	
	        Page page = qyryxxService.getListForPage(map, pagesize, pagerow,sort,"DESC");
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryxx=page.getData();
	        translateDictZT();
	        setTabledata_gad(lQyryxx); 
			 this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="";
		}
        return "success";
    }
	/**
	 * 翻译字典项
	 */
	public void translateDictZT(){
		if(lQyryxx!=null&&lQyryxx.size()>0){
			for(int index=0,max=lQyryxx.size();index<max;index++){
				Qyryxx tempQyryxx = (Qyryxx)lQyryxx.get(index);
				Dict_item dict_item = this.getCacheDictItem("dm_ryzt(jxy)", tempQyryxx
						.getCyryzt(), null, null, null);
				if (dict_item != null){
					tempQyryxx.setCyryzt(dict_item.getDisplay_name());
					lQyryxx.set(index, tempQyryxx);
				}
			}
		}
	}
	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}

	public List getLQyryxx_lsxx() {
		return lQyryxx_lsxx;
	}

	public String getBaseStringPic() {
		return baseStringPic;
	}

	public void setQyryxxhcService(IQyryxxhcService qyryxxhcService) {
		this.qyryxxhcService = qyryxxhcService;
	}
}