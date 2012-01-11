package com.aisino2.publicsystem.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qybaxx;
import com.aisino2.publicsystem.domain.Qybcbaxx;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Tjclxx;
import com.aisino2.publicsystem.service.IQybaxxService;
import com.aisino2.publicsystem.service.IQybcbaxxService;
import com.aisino2.publicsystem.service.ITjclxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDict_itemService;

public class QybaxxAction extends PageAction{
	private IQybaxxService qybaxxService;
	private IDict_itemService dict_itemService;
	private IQybcbaxxService qybcbaxxService;
	private ITjclxxService tjclxxService;
	private List lQybaxx=new ArrayList();
	private Qybaxx qybaxx=new Qybaxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Qybaxx getQybaxx() {
		return qybaxx;
	}
	
	public List getLQybaxx() {
		return lQybaxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQybaxxService(IQybaxxService qybaxxService) {
		this.qybaxxService = qybaxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qybaxxid");
		lPro.add("qybabm");
		lPro.add("barq");
		lPro.add("babmmc");
    	
		List lXzcz=new ArrayList();
    	List lCk = new ArrayList();
    	lCk.add("csba");
    	lCk.add("修改");
    	lCk.add("sftjwz");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("csba");
    	lCk.add("修改");
    	lCk.add("sftjwz");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	
    	lCk = new ArrayList();
    	lCk.add("csba");
    	lCk.add("删除");
    	lCk.add("sftjwz");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("csba");
    	lCk.add("删除");
    	lCk.add("sftjwz");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	
    	lCk = new ArrayList();
    	lCk.add("csba");
    	lCk.add("补备");
    	lCk.add("sftjwz");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	
    	Qybaxx getQybaxx=new Qybaxx();
    	
    	  this.setDataCustomer(getQybaxx,lData,lPro,null,lXzcz);
          this.tabledata=this.getData();
          totalrows=this.getTotalrows();
	}
	/**
	 * 提交材料
	 * @param lData
	 * @throws Exception
	 */
	public void setItemListTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("fact_value");
		lPro.add("display_name");
		lPro.add("append_value"); //是否提交
		lPro.add("like_factValue"); //提交人
		lPro.add("query_simplepin"); //提交日期
		
    	List lCol = new ArrayList();
    	Dict_item getDict_itemx = new Dict_item();
    	
        this.setData(getDict_itemx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 提交材料 请求列表
	 * @return
	 * @throws Exception
	 */
	public String querylistTjcl() throws Exception{
		try {
			Map map = new HashMap();
			map.put("dict_code", "dm_tjcllx");
			Page page = dict_itemService.getListForPage(map, 1, 50,null,null);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			List itemList = page.getData();
			List itemResult = new ArrayList();
			if(itemList!=null&&itemList.size()>0){
				String factValue = "";
				for(int index=0,max=itemList.size();index<max;index++){
					Dict_item dictItemTemp = (Dict_item)itemList.get(index);
					factValue = dictItemTemp.getFact_value();
					if(factValue.lastIndexOf("0")!=(factValue.length()-1)){
						String iftj = "<input type='checkbox' name='"+
							dictItemTemp.getDisplay_name()+"' id='sftj_"+
							dictItemTemp.getFact_value()+"'/>已提交";
						String tjr = "<input class='inputstyle' type='text' id='tjr_"+dictItemTemp.getFact_value()+"' />";
						String tjrq = "<input class='inputstyle' type='text' id='tjrq_"+dictItemTemp.getFact_value()+"' />";
						dictItemTemp.setAppend_value(iftj); //是否提交
						dictItemTemp.setLike_factValue(tjr);
						dictItemTemp.setQuery_simplepin(tjrq); //提交日期
						dictItemTemp.setDisplay_name("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+dictItemTemp.getDisplay_name());
					} else {
						dictItemTemp.setDisplay_name("<b>"+dictItemTemp.getDisplay_name()+"</b>");
					}
					itemResult.add(dictItemTemp);
				}
			}
			setItemListTabledata(itemResult);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 备案
	 * @param lData
	 * @throws Exception
	 */
	public void setBeianTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("zrs");
		lPro.add("qyzflmc");
		lPro.add("frdb");
		lPro.add("yyztmc");
    	
    	List lModify=new ArrayList();
    	lModify.add("ylcsba_setBeian");
    	lModify.add("备案");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	
    	Qyjbxx getQyjbxx=new Qyjbxx();
    	
        this.setData(getQyjbxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 企业备案 请求列表
	 * @return
	 * @throws Exception
	 */
	public String queryCsbeianList() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Qyjbxx setQyjbxx=new Qyjbxx();
			setQyjbxx=(Qyjbxx)this.setClass(setQyjbxx, null);
			Map map = new HashMap();
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode())); //session
			map.put("sfyx", "1"); //是否有效
			map.put("qymc", setQyjbxx.getQymc());
			map.put("qybm", setQyjbxx.getQybm());
			map.put("qyzflbm", setQyjbxx.getQyzflbm());
			map.put("zjbh", setQyjbxx.getZjbh());
			map.put("gxdwbm", StringUtil.trimEven0(setQyjbxx.getGxdwbm())); //7.27取简项代码
			map.put("zabdm", setQyjbxx.getZabdm());
			map.put("zrs", setQyjbxx.getZrs());
			map.put("relation", setQyjbxx.getRelation());
			map.put("yyztdm", setQyjbxx.getYyztdm());
			map.put("hylbdm", setQyjbxx.getHylbdm());
			map.put("qyzflbm", setQyjbxx.getQyzflbm());
			System.out.println("============"+setQyjbxx.getQyzflbm());
			map.put("superbWhere", setQyjbxx.getSuperbWhere()); //高级查询条件
			map.put("superbOrderBy", setQyjbxx.getSuperbOrderBy());
			
			Page page = qybaxxService.getListForPageCsba(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			List lQyjbxx = page.getData();
			setBeianTabledata(lQyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	public String querylist() throws Exception{
		try {
			Qybaxx setQybaxx=new Qybaxx();
			setQybaxx=(Qybaxx)this.setClass(setQybaxx, null);
			Map map = new HashMap();
			map.put("qyid", setQybaxx.getQyid());
			map.put("qybm", setQybaxx.getQybm());
			map.put("barqf", setQybaxx.getBarq());
			map.put("barqt", setQybaxx.getBarqzhi());
			Page page = qybaxxService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lQybaxx=page.getData();
			setTabledata(lQybaxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			System.out.println("==================================================================");
			Qybaxx setQybaxx=new Qybaxx();
			setQybaxx=(Qybaxx)this.setClass(setQybaxx, null);
			setQybaxx=qybaxxService.getQybaxx(setQybaxx);
			if(setQybaxx==null){
				setQybaxx = new Qybaxx(); //防止页面空指针
			}
			//备案信息开始
			Qybcbaxx setQybcbaxx = new Qybcbaxx();
			setQybcbaxx.setQyid(setQybaxx.getQyid());
			setQybcbaxx.setQybaxxid(setQybaxx.getQybaxxid());
			setQybcbaxx = qybcbaxxService.getQybcbaxx(setQybcbaxx);
			if(setQybcbaxx==null){
				setQybcbaxx = new Qybcbaxx(); //防止页面空指针
			}
			//提交材料信息开始
			Map tjclMp = new HashMap();
			tjclMp.put("qyid", setQybaxx.getQyid());
			tjclMp.put("qybaxxid", setQybaxx.getQybaxxid());
	        Page page = tjclxxService.getListForPage(tjclMp, 1, 50,null,null);
	        List tjclList = page.getData();
	        
			lQybaxx = new ArrayList();
			lQybaxx.add(setQybaxx); //备案信息
			lQybaxx.add(setQybcbaxx); //补备信息
			lQybaxx.add(tjclList);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }

	public String insert() throws Exception{
		try {
			Qybaxx setQybaxx = new Qybaxx();
			setQybaxx = (Qybaxx)this.setClass(setQybaxx, null);
			Tjclxx setTjclxx = new Tjclxx();
			setTjclxx = (Tjclxx)this.setClass(setTjclxx, null);
			setQybaxx.setScbz(0);
			//提交材料
			List tjclList = new ArrayList();
			String tjcllxdm = setTjclxx.getTjcllxdm();
			String tjcllx = setTjclxx.getTjcllx();
			String pageSort = setTjclxx.getPageSort(); //提交日期
			String tjrxm = setTjclxx.getTjrxm();
			String[] tjcllxdmArr = tjcllxdm.split("\\|");
			String[] tjcllxArr = tjcllx.split("\\|");
			String[] pageSortArr = pageSort.split("\\|");
			String[] tjrxmArr = tjrxm.split("\\|");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			if(!"".equals(pageSort)&&pageSortArr!=null&&pageSortArr.length>0){
				for(int index=0,max=tjcllxdmArr.length;index<max;index++){
					Tjclxx tjcltemp = new Tjclxx();
					tjcltemp.setTjcllxdm(tjcllxdmArr[index]);
					tjcltemp.setTjcllx(tjcllxArr[index]);
					tjcltemp.setTijiaorq(formatter.parse(pageSortArr[index]));
					tjcltemp.setTjrxm(tjrxmArr[index]);
					tjclList.add(tjcltemp);
				}
			}
			setQybaxx.setLTjclxx(tjclList);
			qybaxxService.insertQybaxx(setQybaxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }

	public String insertTable() throws Exception{
		try {
			Qybaxx setQybaxx = new Qybaxx();
			setQybaxx = (Qybaxx)this.setClass(setQybaxx, null);
			Tjclxx setTjclxx = new Tjclxx();
			setTjclxx = (Tjclxx)this.setClass(setTjclxx, null);
			setQybaxx.setScbz(0);
			//提交材料
			List tjclList = new ArrayList();
			String tjcllxdm = setTjclxx.getTjcllxdm();
			String tjcllx = setTjclxx.getTjcllx();
			String pageSort = setTjclxx.getPageSort(); //提交日期
			String tjrxm = setTjclxx.getTjrxm();
			String[] tjcllxdmArr = tjcllxdm.split("\\|");
			String[] tjcllxArr = tjcllx.split("\\|");
			String[] pageSortArr = pageSort.split("\\|");
			String[] tjrxmArr = tjrxm.split("\\|");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			if(!"".equals(pageSort)&&pageSortArr!=null&&pageSortArr.length>0){
				for(int index=0,max=tjcllxdmArr.length;index<max;index++){
					Tjclxx tjcltemp = new Tjclxx();
					tjcltemp.setTjcllxdm(tjcllxdmArr[index]);
					tjcltemp.setTjcllx(tjcllxArr[index]);
					tjcltemp.setTijiaorq(formatter.parse(pageSortArr[index]));
					tjcltemp.setTjrxm(tjrxmArr[index]);
					tjclList.add(tjcltemp);
				}
			}
			setQybaxx.setLTjclxx(tjclList);
			qybaxxService.insertQybaxx(setQybaxx);
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
			Qybaxx setQybaxx=new Qybaxx();
			qybaxx=(Qybaxx)this.setClass(setQybaxx, null);//提交材料
			Tjclxx setTjclxx = new Tjclxx();
			setTjclxx = (Tjclxx)this.setClass(setTjclxx, null);
			
			List tjclList = new ArrayList();
			String tjcllxdm = setTjclxx.getTjcllxdm();
			String tjcllx = setTjclxx.getTjcllx();
			String pageSort = setTjclxx.getPageSort(); //提交日期
			String tjrxm = setTjclxx.getTjrxm();
			String[] tjcllxdmArr = tjcllxdm.split("\\|");
			String[] tjcllxArr = tjcllx.split("\\|");
			String[] pageSortArr = pageSort.split("\\|");
			String[] tjrxmArr = tjrxm.split("\\|");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			if(!"".equals(pageSort)&&pageSortArr!=null&&pageSortArr.length>0){
				for(int index=0,max=tjcllxdmArr.length;index<max;index++){
					Tjclxx tjcltemp = new Tjclxx();
					tjcltemp.setTjcllxdm(tjcllxdmArr[index]);
					tjcltemp.setTjcllx(tjcllxArr[index]);
					tjcltemp.setTijiaorq(formatter.parse(pageSortArr[index]));
					tjcltemp.setTjrxm(tjrxmArr[index]);
					tjclList.add(tjcltemp);
				}
			}
			qybaxx.setLTjclxx(tjclList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qybaxxService.updateQybaxx(qybaxx);
        this.result="success";
        return "success";
    }
	/**
	 * 补备 备案信息
	 * @return
	 * @throws Exception
	 */
	public String beianBubei() throws Exception{
		try {
			Qybcbaxx setQybcbaxx = new Qybcbaxx();
			setQybcbaxx = (Qybcbaxx)this.setClass(setQybcbaxx, null);
			Qybaxx setQybaxx = new Qybaxx();
			setQybaxx = (Qybaxx)this.setClass(setQybaxx, null);
			Tjclxx setTjclxx = new Tjclxx();
			setTjclxx = (Tjclxx)this.setClass(setTjclxx, null);
			//提交材料
			List tjclList = new ArrayList();
			String tjcllxdm = setTjclxx.getTjcllxdm();
			String tjcllx = setTjclxx.getTjcllx();
			String pageSort = setTjclxx.getPageSort(); //提交日期
			String tjrxm = setTjclxx.getTjrxm();
			String[] tjcllxdmArr = tjcllxdm.split("\\|");
			String[] tjcllxArr = tjcllx.split("\\|");
			String[] pageSortArr = pageSort.split("\\|");
			String[] tjrxmArr = tjrxm.split("\\|");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			if(!"".equals(pageSort)&&pageSortArr!=null&&pageSortArr.length>0){
				for(int index=0,max=tjcllxdmArr.length;index<max;index++){
					Tjclxx tjcltemp = new Tjclxx();
					tjcltemp.setTjcllxdm(tjcllxdmArr[index]);
					tjcltemp.setTjcllx(tjcllxArr[index]);
					tjcltemp.setTijiaorq(formatter.parse(pageSortArr[index]));
					tjcltemp.setTjrxm(tjrxmArr[index]);
					tjclList.add(tjcltemp);
				}
			}
			setQybcbaxx.setQybaxx(setQybaxx); //备案信息
			setQybcbaxx.setLTjclxx(tjclList);
			Date temp = setQybcbaxx.getBbwcrq();
			if(setQybcbaxx.getBbwcrq()!=null){
				setQybcbaxx.setIsBbwcrqNull("0");
			} else {
				setQybcbaxx.setIsBbwcrqNull("1");
			}
			qybcbaxxService.updateQybcbaxx(setQybcbaxx);
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
			Qybaxx setQybaxx=new Qybaxx();
			qybaxx=(Qybaxx)this.setClass(setQybaxx, null);
			 qybaxxService.deleteQybaxx(qybaxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.result="success";
        return "success";
    }
	public void setQybcbaxxService(IQybcbaxxService qybcbaxxService) {
		this.qybcbaxxService = qybcbaxxService;
	}
	public void setTjclxxService(ITjclxxService tjclxxService) {
		this.tjclxxService = tjclxxService;
	}
}