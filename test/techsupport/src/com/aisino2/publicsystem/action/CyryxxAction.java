package com.aisino2.publicsystem.action;

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

import com.aisino2.cache.CacheManager;
import com.aisino2.common.ImageUtil;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.publicsystem.domain.Garkktbsj;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.ICyryxxService;
import com.aisino2.publicsystem.service.IGarkktbsjService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyryxxhcService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class CyryxxAction extends QyryxxAction {
	
	private ICyryxxService cyryxxtjService;
	private IQyryxxService qyryxxService;
	private IIckslService ickslService;
	private IQyryxxhcService qyryxxhcService;
	private IGarkktbsjService garkktbsjService;
	private Qyryxx qyryxx=new Qyryxx();
	private String result="success";
	private String tabledata="";
	private int totalrows=0;
	private int myPageSize;
	private List lQyryxx=new ArrayList();
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setCyryxxtjService(ICyryxxService cyryxxService) {
		this.cyryxxtjService = cyryxxService;
	}
	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}
	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}
	public void setQyryxxhcService(IQyryxxhcService qyryxxhcService) {
		this.qyryxxhcService = qyryxxhcService;
	}
	public void setGarkktbsjService(IGarkktbsjService garkktbsjService) {
		this.garkktbsjService = garkktbsjService;
	}
	public String getTabledata() {
		return tabledata;
	}
	public int getMyPageSize() {
		return myPageSize;
	}
	public List getLQyryxx() {
		return lQyryxx;
	}
	public String getResult() {
		return result;
	}
	public Qyryxx getQyryxx() {
		return qyryxx;
	}
	
	public void setTabledataCjd(List lData) throws Exception {
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("whcd");

    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
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
	public void setTabledataQyd(List lData) throws Exception {
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("zt");

    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	List lDel=new ArrayList();
    	lDel.add("setTijian");
    	lDel.add("体检信息");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyryxx getQyryxx=new Qyryxx();
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataQydZxgl(List lData) throws Exception {
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("zt");

    	List lModify=new ArrayList();
    	lModify.add("setZhuXiao");
    	lModify.add("注销");
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	Qyryxx getQyryxx=new Qyryxx();
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataQydLs(List lData) throws Exception {
		List lPro=new ArrayList();
		lPro.add("rylsid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("zt");
    	
		Qyryxx_lsxx getQyryxx_lsxx=new Qyryxx_lsxx();
        this.setData(getQyryxx_lsxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataCxGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxzqh");
		lPro.add("cylb");
		lPro.add("qymc");
		lPro.add("zt");

    	List lCygj=new ArrayList();
    	lCygj.add("setCyryCygj");
    	lCygj.add("从业轨迹");
    	List lGzrz=new ArrayList();
    	lGzrz.add("setCyryGzrz");
    	lGzrz.add("工作日志");
    	
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	lCol.add(lGzrz);
    	Qyryxx getCyryxx=new Qyryxx();
        this.setData(getCyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataZxCxGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxzqh");
		lPro.add("cylb");
		lPro.add("qymc");
		lPro.add("zt");
		lPro.add("yxrys");

		List lXzcz = new ArrayList();

    	List lZx=new ArrayList();
    	lZx.add("setCyryZx");
    	lZx.add("注销");
    	lZx.add("zxbz");
    	lZx.add("0");
    	lXzcz.add(lZx);
    	lZx=new ArrayList();
    	lZx.add("setCyryZx");
    	lZx.add("注销恢复");
    	lZx.add("zxbz");
    	lZx.add("1");
    	lXzcz.add(lZx);
    	Qyryxx getCyryxx=new Qyryxx();
    	this.setDataCustomer(getCyryxx, lData, lPro, null, lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataScCxGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("hjdxzqh");
		lPro.add("cylb");
		lPro.add("qymc");
		lPro.add("zt");

    	Qyryxx getCyryxx=new Qyryxx();
    	this.setData(getCyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataDhcCxGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("hcid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("cylb");
		lPro.add("qymc");
		lPro.add("hcwt");
		lPro.add("bdsj");
		lPro.add("pageSort");
		lPro.add("yjbz");
		
		List lXzcz = new ArrayList();
    	List lHc=new ArrayList();
    	lHc.add("setCyryHc");
    	lHc.add("核查");
    	lHc.add("hczt");
    	lHc.add("0");
    	lXzcz.add(lHc);
    	lHc=new ArrayList();
    	lHc.add("setCyryHc");
    	lHc.add("");
    	lHc.add("hczt");
    	lHc.add("1");
    	lXzcz.add(lHc);
    	List lYj = new ArrayList();
    	lYj.add("setCyryYj");
    	lYj.add("预警");
    	lYj.add("yjbz");
    	lYj.add("0");
    	lXzcz.add(lYj);
    	lYj = new ArrayList();
    	lYj.add("setCyryYj");
    	lYj.add("");
    	lYj.add("yjbz");
    	lYj.add("1");
    	lXzcz.add(lYj);
    	
    	Qyryxxhc getQyryxxhc=new Qyryxxhc();
    	this.setDataCustomer(getQyryxxhc, lData, lPro, null, lXzcz);
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
	
	/**
	 * 采集点
	 */
	public String querylistCjd() throws Exception {
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
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("hylbdm", null);
			map.put("allhylbdm", setQyryxx.getHylbdm());
			map.put("qymc", setQyryxx.getQymc());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
			map.put("lrsjf", setQyryxx.getLrsjf());
			map.put("lrsjt", setQyryxx.getLrsjt());
			map.put("lrdwbm", lrdwbm);
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = cyryxxtjService.getListForPage(map, pagesize, pagerow,sort,dir);
	        CyryztFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List lQyryxx = page.getData();
	        
	        String jdzkd = "" ;//从缓存中得到制卡点(全局参数)
			Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("jdzkd");
			List list = CacheManager.getCacheGlobalpar(globalpar);
			if(list!=null&&list.size()>0){
				jdzkd = ((Globalpar)list.get(0)).getGlobalparvalue();
			}
	        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
	        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
	        	String slid = String.valueOf(oneCyryxx.getIckslid());
	        	String sjscbz = oneCyryxx.getSjscbz();
	        	String zkztbs = oneCyryxx.getZkztbs();
	        	String cyryzt = oneCyryxx.getZt();
	        	if(slid==null)slid="";
	        	if(sjscbz==null)sjscbz="";
	        	if(zkztbs==null)zkztbs="";
	        	if(cyryzt==null)cyryzt="";
	        	String xm=oneCyryxx.getXm()+"<input type='hidden' id='qyid' value='"+oneCyryxx.getQyid()+"'>";
	        	oneCyryxx.setXm(xm);
	        	oneCyryxx.setCyrybh("<input type='hidden' name='cs"+oneCyryxx.getRyid()+"' value='"+oneCyryxx.getQyid()+"' />" +
	        			"<input type='hidden' name='sl"+oneCyryxx.getRyid()+"' value='"+slid+"' />" +
	        					"<input type='hidden' name='zkzt"+oneCyryxx.getRyid()+"' value='"+zkztbs+"' />" +
								"<input type='hidden' name='ryzt"+oneCyryxx.getRyid()+"' value='"+cyryzt+"' />" +
								"<input type='hidden' name='wbzk"+oneCyryxx.getRyid()+"' value='"+sjscbz+"' />"+
								"<input type='hidden' name='zkd"+oneCyryxx.getRyid()+"' value='"+jdzkd+"' />"+oneCyryxx.getCyrybh());
	        	setCyryxxDict_itemList(oneCyryxx);
	        }
	        
	        setTabledataCjd(lQyryxx);
		} catch (Exception e) {
			setResult("查询失败");
			e.printStackTrace();
		}
        return "success";	
	}
	
	/**
	 * 公安端查询
	 */
	public String querylistCxGad() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("allhylbdm", setQyryxx.getHylbdm());
			map.put("hylbdm", null);
			map.put("qymc", setQyryxx.getQymc());
			map.put("kh", setQyryxx.getKh());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
			map.put("lrsjf", setQyryxx.getLrsjf());
			map.put("lrsjt", setQyryxx.getLrsjt());
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			map.put("zzzhm", setQyryxx.getZzzhm());
			map.put("zt", setQyryxx.getZt());
			map.put("mzdm", setQyryxx.getMzdm());
			map.put("cyryztdm", setQyryxx.getCyryztdm());
			map.put("yjbz", setQyryxx.getYjbz());
			map.put("scbz", "0");
	        Page page = cyryxxtjService.getListGadForPage(map, pagesize, pagerow,sort,dir);
	        myPageSize = pagesize;
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryxx=page.getData();
	        setTabledataCxGad(lQyryxx);
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
        return "success";	
	}
	
	/**
	 * 公安端注销查询
	 */
	public String querylistZxCxGad() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		
		try {
			String deptCode=user.getDepartment().getDepartcode();
			if(deptCode.indexOf("CJD")==0){
				deptCode=deptCode.replace("CJD", "");
			}	
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("allhylbdm", setQyryxx.getHylbdm());
			map.put("hylbdm", null);
			map.put("qymc", setQyryxx.getQymc());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
			map.put("gxdwbm", setQyryxx.getGxdwbm());
			map.put("gxdwmc", setQyryxx.getGxdwmc());
			map.put("scbz", "0");
			map.put("deptCode", StringUtil.trimEven0(deptCode));
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = cyryxxtjService.getListGadForPage(map, pagesize, pagerow,sort,dir);
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataZxCxGad(page.getData());
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
        return "success";	
	}
	
	/**
	 * 公安端删除查询
	 */
	public String querylistScCxGad() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("allhylbdm", setQyryxx.getHylbdm());
			map.put("hylbdm", null);
			map.put("qymc", setQyryxx.getQymc());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
			map.put("scbz", "1");
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
	        Page page = cyryxxtjService.getListGadForPage(map, pagesize, pagerow,sort,dir);
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataScCxGad(page.getData());
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
        return "success";	
	}
	
	/**
	 * 公安端待核查人员查询
	 */
	public String querylistDhcCxGad() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Qyryxxhc setQyryxxhc=new Qyryxxhc();
			setQyryxxhc=(Qyryxxhc)this.setClass(setQyryxxhc, null);
			
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("mzdm", setQyryxx.getMzdm());
			map.put("allhylbdm", setQyryxx.getHylbdm());
			map.put("qymc", setQyryxx.getQymc());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
			map.put("hczt", setQyryxxhc.getHczt());
			map.put("hcwt", setQyryxxhc.getHcwt());
			map.put("gxdwdm", StringUtil.trimEven0(setQyryxx.getGxdwbm()));
			map.put("gxdwmc", setQyryxx.getGxdwmc());
			map.put("yjbz", setQyryxx.getYjbz());
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			Page page = qyryxxhcService.getListForPage(map, pagesize, pagerow,sort,dir);
			List lCyryxx = page.getData();
			for(Iterator iter=lCyryxx.iterator();iter.hasNext();){
				Qyryxxhc oneQyryxxhc=(Qyryxxhc)iter.next();
				oneQyryxxhc.setZjhm("<input type='hidden' name='ry"+oneQyryxxhc.getHcid()+"' value='"+oneQyryxxhc.getRyid()+"' />"+
						"<input type='hidden' name='db"+oneQyryxxhc.getHcid()+"' value='"+oneQyryxxhc.getGarkktbsjid()+"' />"+oneQyryxxhc.getZjhm());
	        	setCyryxxhcDict_itemList(oneQyryxxhc);
	        }
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataDhcCxGad(page.getData());
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
        return "success";	
	}
	
	/**
	 * 采集点 未提交人员查询
	 */
	public String querylistWtjryCjd() throws Exception {
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
			map.put("hylbdm", null);
			map.put("allhylbdm", setQyryxx.getHylbdm());
			map.put("qymc", setQyryxx.getQymc());
			map.put("cyzj", setQyryxx.getCyzj());
			map.put("cyzjdm", setQyryxx.getCyzjdm());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
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
	        	if(!"0".equals(qyryxx.getBz())){ //bz放的是企业状态 当为0时，为企业未提交状态
	        		qyryxx.setCyrybh(qyryxx.getCyrybh()+"<input type='hidden' name='lb"+qyryxx.getRyid()+"' value='"+qyryxx.getCyrylbdm()+"' />");
	        	}
	        }
	        setTabledataTj(page.getData());
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}
	public String querylistQyd() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("hylbdm", setQyryxx.getHylbdm());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
	        Page page = cyryxxtjService.getListQydForPage(map, pagesize, pagerow,sort,dir);
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List lQyryxx = page.getData();
	        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
	        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
	        	oneCyryxx.setXb(oneCyryxx.getXb()+"<input type='hidden' id='qyid' value='"+oneCyryxx.getQyid()+"'/>");
	        }
	        setTabledataQyd(lQyryxx);
		} catch (Exception e) {
			setResult("查询失败");
			e.printStackTrace();
		}
        return "success";	
	}
	public String querylistQydZxgl() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("hylbdm", setQyryxx.getHylbdm());
			map.put("zxbz", "0");
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
	        Page page = cyryxxtjService.getListQydForPage(map, pagesize, pagerow,sort,dir);
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List lQyryxx = page.getData();
	        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
	        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
	        	oneCyryxx.setXb(oneCyryxx.getXb()+"<input type='hidden' id='qyid' value='"+oneCyryxx.getQyid()+"'/>");
	        }
	        setTabledataQydZxgl(lQyryxx);
		} catch (Exception e) {
			setResult("查询失败");
			e.printStackTrace();
		}
        return "success";	
	}
	public String querylistQydLs() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("hylbdm", setQyryxx.getHylbdm());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
			map.put("cyrylbdm", "0");
	        Page page = cyryxxtjService.getCyryxx_lsxxListQydGnForPage(map, pagesize, pagerow,sort,dir);
	        dictFanYi_ls(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataQydLs(page.getData());
		} catch (Exception e) {
			setResult("查询失败");
			e.printStackTrace();
		}
        return "success";	
	}
	
	public String excelCreateTemp() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String lrdwbm = user.getDepartment().getDepartcode();
		if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
			lrdwbm = user.getSsdwbm();
		}
		
		String maxRows = QjblUtil.queryQjblVal("exportmaxrows");
		Qyryxx setQyryxx=new Qyryxx();
		setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
		
		Map map = new HashMap();
		map=addMap(setQyryxx);
		map.put("hylbdm", null);
		map.put("allhylbdm", setQyryxx.getHylbdm());
		map.put("qymc", setQyryxx.getQymc());
		map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
		map.put("lrsjf", setQyryxx.getLrsjf());
		map.put("lrsjt", setQyryxx.getLrsjt());
		map.put("lrdwbm", lrdwbm);
        Page page = cyryxxtjService.getListForPage(map, 1, Integer.parseInt(maxRows),sort,dir);
        dictFanYi(page.getData());
        session.setAttribute("cyryxxExlList", page.getData());
        this.result = "success";
		return "success";
	}
	
	public void excelCreate() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		Qyryxx setQyryxx=new Qyryxx();
		
		String bbmc = request.getParameter("bbmc");
		String tabletitle = request.getParameter("tabletitle");
		List lResult = new ArrayList(); //开头excel
		
		List lColumn = this.getExcelColumn(tabletitle);
		lResult.add(bbmc);
		lResult.add(lColumn);
		lResult.add(response);
		lResult.add((List) session.getAttribute("cyryxxExlList"));
		lResult.add(setQyryxx);
		this.setExcelCreate("fileName", lResult); // //ztxx 默认文件名字的开头excel
	}
	
	/**
	 * 公安端查询 倒出EXCEL
	 */
	public String excelCreateCxGadTemp() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String maxRows = QjblUtil.queryQjblVal("exportmaxrows");
		
		Qyryxx setQyryxx=new Qyryxx();
		setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
		
		Map map = new HashMap();
		map=addMap(setQyryxx);
		map.put("allhylbdm", setQyryxx.getHylbdm());
		map.remove("hylbdm");
		map.put("qymc", setQyryxx.getQymc());
		map.put("kh", setQyryxx.getKh());
		map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
		map.put("lrsjf", setQyryxx.getLrsjf());
		map.put("lrsjt", setQyryxx.getLrsjt());
		map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
		map.put("zzzhm", setQyryxx.getZzzhm());
		map.put("zt", setQyryxx.getZt());
		map.put("mzdm", setQyryxx.getMzdm());
		map.put("cyryztdm", setQyryxx.getCyryztdm());
		map.put("scbz", "0");
		Page page = cyryxxtjService.getListGadForPage(map, 1, Integer.parseInt(maxRows),sort,dir);
		dictFanYi(page.getData());
		session.setAttribute("gadCyryxxExlList", page.getData());
		
		this.result = "success";
		return "success";
	}
	
	public void excelCreateCxGad() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		Qyryxx setQyryxx=new Qyryxx();
		
		String bbmc = request.getParameter("bbmc");
		String tabletitle = request.getParameter("tabletitle");
		List lResult = new ArrayList(); //开头excel
		
		List lColumn = this.getExcelColumn(tabletitle);
		lResult.add(bbmc);
		lResult.add(lColumn);
		lResult.add(response);
		lResult.add((List) session.getAttribute("gadCyryxxExlList"));
		lResult.add(setQyryxx);
		this.setExcelCreate("fileName", lResult); // //ztxx 默认文件名字的开头excel
	}
	
	private void dealExcelData(List data,List lResult) {
		List lPro = new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("zt");
		
		Qyryxx getQyryxx=new Qyryxx();
		List lcache = new ArrayList();
		data=this.getResultCache(getQyryxx.getClass().getName(), lPro, data, lcache);
        lResult.add(data);
        lResult.add(getQyryxx);
        try {
			this.setExcelCreate("cyryxx",lResult);
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	
	public String queryHc() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			Garkktbsj setGarkktbsj = new Garkktbsj();
			Qyryxxhc setQyryxxhc = new Qyryxxhc();
			setQyryxx = (Qyryxx)this.setClass(setQyryxx, null);
			setGarkktbsj = (Garkktbsj)this.setClass(setGarkktbsj, null);
			setQyryxxhc = (Qyryxxhc)this.setClass(setQyryxxhc, null);
	        
			setQyryxx=qyryxxService.getQyryxx(setQyryxx);
			setGarkktbsj = garkktbsjService.getGarkktbsj(setGarkktbsj);
			setQyryxxhc = qyryxxhcService.getQyryxxhc(setQyryxxhc);
			setQyryxx=setCyryxxDict_itemList(setQyryxx);
			setGarkktbsjDict_item(setGarkktbsj);
			
			lQyryxx.add(setQyryxx);
			lQyryxx.add(setGarkktbsj);
			lQyryxx.add(setQyryxxhc);
	        
	        //设置采集点编码(需要改动，从session用户信息中得到)
	        setQyryxxhc.setHcdwdm(user.getDepartment().getDepartcode());
	        setQyryxxhc.setHcdw(user.getDepartment().getDepartname());
	        setQyryxxhc.setHcr(user.getUseraccount());
	        setQyryxxhc.setHcsj(new Date());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	public String insert() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String lrdwbm = user.getDepartment().getDepartcode();
		String lrdwmc = user.getDepartment().getDepartname();
		if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
			lrdwbm = user.getSsdwbm();
			lrdwmc = user.getSsdwmc();
		}
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			if(!valPersonCard(setQyryxx)){
				result = "此公民身份号码已经存在";
				return "success";
			}
			
			setQyryxx=fzQyryxx_zp(setQyryxx);
			setQyryxx.setCyrylbdm("0");
			setQyryxx.setCyrylbmc("国内从业人员");
			setQyryxx.setLrr(user.getUseraccount());
			setQyryxx.setLrdwbm(lrdwbm);
			setQyryxx.setLrdwmc(lrdwmc);
			qyryxx = cyryxxtjService.insertQyryxx(setQyryxx);
			int ryid = qyryxx.getRyid();
			qyryxx = new Qyryxx();
			qyryxx.setRyid(ryid);
			
			String ryhcdxkg = QjblUtil.queryQjblVal("ryhcdxkg");//人员核查单向开关 为1时，若人员没有提交，则不能转到受理界面
			if(!"1".equals(ryhcdxkg))
			{	
				Icksl icksl = new Icksl();
				icksl.setRyid(setQyryxx.getRyid());
				if(!ickslService.getIckslExist(icksl)){ //不存在受理记录 跳转
					Qyry_zp qyry_zp = new Qyry_zp();
					qyry_zp.setRyid(setQyryxx.getRyid());
					if(qyry_zpService.isZpExist(qyry_zp)){
						result = "toicksl";
					}
				}
			}
		} catch (Exception e) {
			result = "添加失败";
			e.printStackTrace();
		}
		return "success";
	}
	public String modify() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			if(!valPersonCard(setQyryxx)){
				result = "此公民身份号码已经存在";
				return "success";
			}
			
			setQyryxx=fzQyryxx_zp(setQyryxx);
			setQyryxx.setCyrylbdm("0");
			setQyryxx.setCyrylbmc("国内从业人员");
			setQyryxx.setCzr(user.getUseraccount());
			cyryxxtjService.updateQyryxx(setQyryxx);
			
			qyryxx = setQyryxx;
			Qyryxx qyryxxNew = new Qyryxx();
			qyryxxNew.setRyid(setQyryxx.getRyid());
			qyryxxNew = qyryxxService.getQyryxx(qyryxxNew);
			String ryhcdxkg = QjblUtil.queryQjblVal("ryhcdxkg");//人员核查单向开关 为1时，若人员没有提交，则不能转到受理界面

			Icksl icksl = new Icksl();
			icksl.setRyid(setQyryxx.getRyid());
			if(!ickslService.getIckslExist(icksl)){ //不存在受理记录 跳转
				Qyry_zp qyry_zp = new Qyry_zp();
				qyry_zp.setRyid(setQyryxx.getRyid());
				if(qyry_zpService.isZpExist(qyry_zp)){
					if(!"1".equals(ryhcdxkg)||("1".equals(ryhcdxkg)&&!"0".equals(qyryxxNew.getZt())))
						result = "toicksl";
				}
			}
		} catch (Exception e) {
			result = "修改失败";
			e.printStackTrace();
		}
		return "success";	
	}
	public String insertWgcyry() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String lrdwbm = user.getDepartment().getDepartcode();
		String lrdwmc = user.getDepartment().getDepartname();
		if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
			lrdwbm = user.getSsdwbm();
			lrdwmc = user.getSsdwmc();
		}
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			setWgcyryxx = (Wgcyryxx)this.setClass(setWgcyryxx, null);
			if(!valPersonCard(setQyryxx)){
				result = "此证件号码已经存在";
				return "success";
			}
			
			setQyryxx=fzQyryxx_zp(setQyryxx);
			setQyryxx.setCyrylbdm("1");
			setQyryxx.setCyrylbmc("境外从业人员");
			setQyryxx.setLrr(user.getUseraccount());
			setQyryxx.setLrdwbm(lrdwbm);
			setQyryxx.setLrdwmc(lrdwmc);
			setQyryxx.setWgcyryxx(setWgcyryxx);
			qyryxx = cyryxxtjService.insertQyryxx(setQyryxx);
			int ryid = qyryxx.getRyid();
			qyryxx = new Qyryxx();
			qyryxx.setRyid(ryid);
			
			String ryhcdxkg = QjblUtil.queryQjblVal("ryhcdxkg");//人员核查单向开关 为1时，若人员没有提交，则不能转到受理界面
			if(!"1".equals(ryhcdxkg))
			{
				Icksl icksl = new Icksl();
				icksl.setRyid(setQyryxx.getRyid());
				if(!ickslService.getIckslExist(icksl)){ //不存在受理记录 跳转
					Qyry_zp qyry_zp = new Qyry_zp();
					qyry_zp.setRyid(setQyryxx.getRyid());
					if(qyry_zpService.isZpExist(qyry_zp)){
						result = "toicksl";
					}
				}
			}
		} catch (Exception e) {
			result = "添加失败";
			e.printStackTrace();
		}
		return "success";	
	}
	public String modifyWgcyry() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			setWgcyryxx = (Wgcyryxx)this.setClass(setWgcyryxx, null);
			if(!valPersonCard(setQyryxx)){
				result = "此证件号码已经存在";
				return "success";
			}
			
			setQyryxx=fzQyryxx_zp(setQyryxx);
			setQyryxx.setCyrylbdm("1");
			setQyryxx.setCyrylbmc("境外从业人员");
			setQyryxx.setCzr(user.getUseraccount());
			setQyryxx.setWgcyryxx(setWgcyryxx);
			cyryxxtjService.updateQyryxx(setQyryxx);
			
			qyryxx = setQyryxx;
			Qyryxx qyryxxNew = new Qyryxx();
			qyryxxNew.setRyid(setQyryxx.getRyid());
			qyryxxNew = qyryxxService.getQyryxx(qyryxxNew);
			String ryhcdxkg = QjblUtil.queryQjblVal("ryhcdxkg");//人员核查单向开关 为1时，若人员没有提交，则不能转到受理界面
			Icksl icksl = new Icksl();
			icksl.setRyid(setQyryxx.getRyid());
			if(!ickslService.getIckslExist(icksl)){ //不存在受理记录 跳转
				Qyry_zp qyry_zp = new Qyry_zp();
				qyry_zp.setRyid(setQyryxx.getRyid());
				if(qyry_zpService.isZpExist(qyry_zp)){
					if(!"1".equals(ryhcdxkg)||("1".equals(ryhcdxkg)&&!"0".equals(qyryxxNew.getZt())))
						result = "toicksl";
				}
			}
		} catch (Exception e) {
			result = "修改失败";
			e.printStackTrace();
		}
		return "success";	
	}
	
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			setQyryxx.setCzr(user.getUseraccount());
			cyryxxtjService.deleteQyryxx(setQyryxx);
		} catch (Exception e) {
			result = "修改失败";
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 人员注销
	 * @return
	 */
	public String ryzhuxiao(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			setQyryxx.setZxr(user.getUseraccount());
			setQyryxx.setZxsj(new Date());
			cyryxxtjService.updateQyryxxZx(setQyryxx);
		} catch (Exception e) {
			result = "修改失败";
			e.printStackTrace();
		}
		return "success";	
	}
	/**
	 * 恢复人员注销
	 * @return
	 */
	public String ryzhuxiaoHuifu(){
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			cyryxxtjService.updateQyryxxZxhf(setQyryxx);
		} catch (Exception e) {
			result = "修改失败";
			e.printStackTrace();
		}
		return "success";
	}
	public String ryxxhc(){
		try {
			Qyryxxhc setQyryxxhc = new Qyryxxhc();
			setQyryxxhc = (Qyryxxhc)this.setClass(setQyryxxhc, null);
			qyryxxhcService.updateQyryxxhc(setQyryxxhc);
		} catch (Exception e) {
			result = "核查失败";
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
						isTiJiao = cyryxxtjService.updateQyryxxTj(lCyryxx);
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
			
			//setQyryxx.setHylbdm("J");//刘峰开发公共场所时注释 20100902
			setQyryxx.setAllhylbdm(setQyryxx.getHylbdm());
			setQyryxx.setHylbdm(null);
			cyryxxtjService.updateQyryxxQbtj(setQyryxx);
		} catch (Exception e) {
		    this.result="提交失败";
			e.printStackTrace();
		}
	    return "success";
	}
	//根据公安人口库ID查询人员照片
	public void queryTphc() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest requeset = ServletActionContext.getRequest();
		OutputStream out = response.getOutputStream();
		try{
			String rkkid = requeset.getParameter("rkkid");
			
			Garkktbsj setGarkktbsj = new Garkktbsj();
			setGarkktbsj.setGarkktbsjid(Integer.parseInt(rkkid));
			setGarkktbsj = garkktbsjService.getGarkktbsj(setGarkktbsj);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			byte [] by ;
			if(setGarkktbsj!=null){
				by = setGarkktbsj.getZp();
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
			if(out!=null) out.close();
		}
	}
	public boolean valPersonCard(Qyryxx setQyryxx){
		List temp = qyryxxService.getIsQyryxxExist(setQyryxx); //gjdm zjhm + ryid
		if(temp==null||temp.size()==0){ 
			return true;
		}
		return false;
	}
	/**人口库人员信息状态改变（从数字转换为汉字，友好显示详细信息）*/
	private void setGarkktbsjDict_item(Garkktbsj data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getXb()!=null){
			displayName = "";
			dict_item.setDict_code("dm_xb");
			dict_item.setFact_value(data.getXb());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setXb(displayName);
		}
		if(data.getMz()!=null){
			displayName = "";
			dict_item.setDict_code("dm_mz");
			dict_item.setFact_value(data.getMz());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setMz(displayName);
		}
		if(data.getHyzk()!=null){
			displayName = "";
			dict_item.setDict_code("dm_hyzk");
			dict_item.setFact_value(data.getHyzk());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setHyzk(displayName);
		}
		if(data.getHjsx()!=null){
			displayName = "";
			dict_item.setDict_code("dm_xzqh");
			dict_item.setFact_value(data.getHjsx());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setHjsx(displayName);
		}
		
	}
	/**人员信息状态改变（从数字转换为汉字，友好显示列表信息）*/
	private void setCyryxxhcDict_itemList(Qyryxxhc data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getHczt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_hczt(cyry)");
			dict_item.setFact_value(data.getHczt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setPageSort(displayName);
		}
	}
	/**
	 * 翻译字典项 从业人员状态  因为后续用到ZT字段 临时放到 whcd里面
	 */
	public void CyryztFanYi(List queryList){
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
				temp.setWhcd((String)jlztMap.get(temp.getZt()));
			}
		}
	}
	
	/**
	 * 公安端 台账 待核查人员总数
	 */
	public String queryDhcryCount() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Qyryxxhc setQyryxxhc=new Qyryxxhc();
			setQyryxxhc=(Qyryxxhc)this.setClass(setQyryxxhc, null);
			
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("hczt", "0"); 	
			map.put("hylbdm", setQyryxx.getHylbdm());
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			int count = qyryxxhcService.getDhcryCount(map);
			lQyryxx.add(count);
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
        return "success";	
	}
	/**
	 * 采集点
	 */
	public String querylistJc() throws Exception {
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
			Map map = new HashMap();
			map=addMap(setQyryxx);
			map.put("hylbdm", setQyryxx.getHylbdm());
			map.put("qymc", setQyryxx.getQymc());
			map.put("cylbdm", StringUtil.trim0(setQyryxx.getCylbdm()));
			map.put("lrsjf", setQyryxx.getLrsjf());
			map.put("lrsjt", setQyryxx.getLrsjt());
			map.put("lrdwbm", lrdwbm);
	        Page page = cyryxxtjService.getListForPage(map, pagesize, pagerow,sort,dir);
	        CyryztFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List lQyryxx = page.getData();
	        
	        String jdzkd = "" ;//从缓存中得到制卡点(全局参数)
			Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("jdzkd");
			List list = CacheManager.getCacheGlobalpar(globalpar);
			if(list!=null&&list.size()>0){
				jdzkd = ((Globalpar)list.get(0)).getGlobalparvalue();
			}
	        for(Iterator iter=lQyryxx.iterator();iter.hasNext();){
	        	Qyryxx oneCyryxx=(Qyryxx)iter.next();
	        	String slid = String.valueOf(oneCyryxx.getIckslid());
	        	String sjscbz = oneCyryxx.getSjscbz();
	        	String zkztbs = oneCyryxx.getZkztbs();
	        	String cyryzt = oneCyryxx.getZt();
	        	if(slid==null)slid="";
	        	if(sjscbz==null)sjscbz="";
	        	if(zkztbs==null)zkztbs="";
	        	if(cyryzt==null)cyryzt="";
	        	String xm=oneCyryxx.getXm()+"<input type='hidden' id='qyid' value='"+oneCyryxx.getQyid()+"'>";
	        	oneCyryxx.setXm(xm);
	        	oneCyryxx.setCyrybh("<input type='hidden' name='cs"+oneCyryxx.getRyid()+"' value='"+oneCyryxx.getQyid()+"' />" +
	        			"<input type='hidden' name='sl"+oneCyryxx.getRyid()+"' value='"+slid+"' />" +
	        					"<input type='hidden' name='zkzt"+oneCyryxx.getRyid()+"' value='"+zkztbs+"' />" +
								"<input type='hidden' name='ryzt"+oneCyryxx.getRyid()+"' value='"+cyryzt+"' />" +
								"<input type='hidden' name='wbzk"+oneCyryxx.getRyid()+"' value='"+sjscbz+"' />"+
								"<input type='hidden' name='zkd"+oneCyryxx.getRyid()+"' value='"+jdzkd+"' />"+oneCyryxx.getCyrybh());
	        	setCyryxxDict_itemList(oneCyryxx);
	        }
	        
	        setTabledataJc(lQyryxx);
		} catch (Exception e) {
			setResult("查询失败");
			e.printStackTrace();
		}
        return "success";	
	}

	public void setTabledataJc(List lData) throws Exception {
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("whcd");

    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	List lTjxx=new ArrayList();
    	lTjxx.add("setTijian");
    	lTjxx.add("体检信息");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	lCol.add(lTjxx);
    	
    	Qyryxx getQyryxx=new Qyryxx();
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 采集点台账--已采集从业人员
	 */
	public String queryYcjCyryxxlist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map.put("hylbdm", "J");
			map.put("lrsj", setQyryxx.getLrsj());
			map.put("lrdwbm",  StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = cyryxxtjService.getYcjCyryListForPage(map, pagesize, pagerow,sort,dir);
	        List temp = page.getData();
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        dictFanYi(temp);
	        setYcjCyryxxTabledata(page.getData());
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}
	public void setYcjCyryxxTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("zt");
    	
		Qyryxx getCyryxx=new Qyryxx();
		this.setData(getCyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 根据江苏老版本14位从业人员编号查询
	 */
	public String queryCyryxxlistby14w() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String departCode = user.getDepartment().getDepartcode();
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			if (departCode.indexOf("CJD")!=-1)
			{
			map.put("lrdwbm",  StringUtil.trimEven0(departCode));
			} else {
			map.put("gxdwbm",  StringUtil.trimEven0(departCode));	
			}
			map.put("hylbdm", setQyryxx.getHylbdm());
			map.put("oldCyrybh", setQyryxx.getOldCyrybh());
	        Page page = cyryxxtjService.getQyryxxByOldcyrybh(map, pagesize, pagerow,sort,dir);
	        myPageSize = pagesize;
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryxx=page.getData();
	        setCyryxxby14wTabledata(lQyryxx);
		} catch (Exception e) {
			result = "查询失败";
			e.printStackTrace();
		}
        return "success";
	}
	public void setCyryxxby14wTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("oldCyrybh");
		lPro.add("cyrybh");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("cylb");
		lPro.add("qymc");
		lPro.add("zt");

		List lCygj=new ArrayList();
    	lCygj.add("setCyryCygj");
    	lCygj.add("从业轨迹");
    	List lGzrz=new ArrayList();
    	lGzrz.add("setCyryGzrz");
    	lGzrz.add("工作日志");
    	
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	lCol.add(lGzrz);
    	Qyryxx getCyryxx=new Qyryxx();
        this.setData(getCyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	
	
}
