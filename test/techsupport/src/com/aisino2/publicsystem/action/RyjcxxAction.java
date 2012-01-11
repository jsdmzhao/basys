package com.aisino2.publicsystem.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.ImageUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Ryjcxx;
import com.aisino2.publicsystem.service.IKyqkService;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyry_zpService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IRyjcxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;


public class RyjcxxAction extends PageAction{
	private IRyjcxxService ryjcxxService;
	private IQyryxxService qyryxxService;
	private IQyjbxxService qyjbxxService;
	private IQyry_zpService qyry_zpService;
	private IKyqkService kyqkService;
	public void setKyqkService(IKyqkService kyqkService) {
		this.kyqkService = kyqkService;
	}

	public void setQyry_zpService(IQyry_zpService qyry_zpService) {
		this.qyry_zpService = qyry_zpService;
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}
	private List lRyjcxx=new ArrayList();
	private List lCyryxx;
	private Ryjcxx ryjcxx=new Ryjcxx();
	private Qyryxx qyryxx=new Qyryxx();
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

	public Ryjcxx getRyjcxx() {
		return ryjcxx;
	}
	
	public List getLRyjcxx() {
		return lRyjcxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setRyjcxxService(IRyjcxxService ryjcxxService) {
		this.ryjcxxService = ryjcxxService;
	}
	
	public Map addMap(Qyryxx setQyryxx){
		Map map=new HashMap();
        if(setQyryxx!=null){
        	
        	map.put("xm", setQyryxx.getXm());
        	map.put("zjhm", setQyryxx.getZjhm());
        	map.put("qymc", setQyryxx.getQymc());
        	map.put("qybm", setQyryxx.getQybm());
        	map.put("cyrybh", setQyryxx.getCyrybh());
        	map.put("hylbdm", setQyryxx.getHylbdm());
        	
        	HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			map.put("gxdwbm",StringUtil.trimEven0(user.getDepartment().getDepartcode()));
        	
        }
		return map;
	}
	
	private Qyryxx findQyid(Qyryxx setQyryxx){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
	    Qyjbxx qyjbxx =new Qyjbxx();
	    qyjbxx.setQyid(setQyryxx.getQyid());
	    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
		if(qyjbxx!=null){
			setQyryxx.setHylb(qyjbxx.getHylb());
			setQyryxx.setHylbdm(qyjbxx.getHylbdm());
		}
		return setQyryxx;
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
				jlztMap.get(temp.getCyryzt());
				temp.setCyryzt((String)jlztMap.get(temp.getCyryzt()));
			}
		}
	}
	private List lQyryxx=new ArrayList();
	public List getLCyryxx() {
		return lCyryxx;
	}

	public void setLCyryxx(List cyryxx) {
		lCyryxx = cyryxx;
	}
	//人员基本信息列表显示
	public void rysetTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("hylb");
		lPro.add("qymc");
		lPro.add("gxdwmc");

    	
		List ldetail=new ArrayList();
    	ldetail.add("setQueryXq");
    	ldetail.add("详情");
    	
    	List lAdd=new ArrayList();
    	lAdd.add("setDengji");
    	lAdd.add("登记");
    	
    	List lcfxx=new ArrayList();
    	lcfxx.add("setChufaxx");
    	lcfxx.add("奖惩信息");
    	
    	List lCol=new ArrayList();
    	lCol.add(ldetail);
    	lCol.add(lAdd);
    	lCol.add(lcfxx);
    	Qyryxx getQyryxx=new Qyryxx();
    	
        this.setData(getQyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	//人员基本信息列表显示
	public void ryCfsetTabledata(List lData) throws Exception{
		List lPro = new ArrayList();
		lPro.add("rycfid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("gxdwmc");
		lPro.add("jcmxlb");
		lPro.add("pzjg");
		lPro.add("pzrxm");
		lPro.add("zxrxm");
		lPro.add("ryjcrq");

		List lModify = new ArrayList();
		lModify.add("setUpdate_rycf");
		lModify.add("修改");

		List lDel = new ArrayList();
		lDel.add("setDelete_rycf");
		lDel.add("删除");
		
		List lDetail = new ArrayList();
		lDetail.add("setQuery_rycf");
		lDetail.add("详情");

		
		
		List lCol = new ArrayList();
		lCol.add(lDetail);
		lCol.add(lModify);
		lCol.add(lDel);

		Ryjcxx getRyjcxx = new Ryjcxx();
		
		this.setData(getRyjcxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	//人员基本信息列表查询
	public String ryquerylist() throws Exception{
		try {
			Qyryxx setQyryxx=new Qyryxx();
			setQyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			Map map = new HashMap();
			map=addMap(setQyryxx);
	        Page page = ryjcxxService.getRyListForPage(map, pagesize, pagerow,sort,dir);
	        
	        dictFanYi(page.getData());
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryxx=page.getData(); 
	        // 为企业名称那个地方的链结加的
			for (java.util.Iterator iter = lQyryxx.iterator(); iter.hasNext();) {
				Qyryxx oneIcksl = (Qyryxx) iter.next();
				oneIcksl.setQymc(oneIcksl.getQymc() + "<input type='hidden' name='qy"
						+ oneIcksl.getRyid() + "' value='" + oneIcksl.getQyid()
						+ "'/>");
			}
	        rysetTabledata(lQyryxx); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        
        return "success";
    }
	
	//人员处罚信息查询
	public String ryCfquerylist() throws Exception{
		try {
			Ryjcxx setRyjcxx=new Ryjcxx();
			setRyjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);

			Map map = new HashMap();
			map.put("ryid", setRyjcxx.getRyid());
			map.put("cflbbm",setRyjcxx.getCflbbm());
			map.put("jcmxlbdm",setRyjcxx.getJcmxlbdm());
			map.put("ryjcrqf", setRyjcxx.getRyjcrqf());
			map.put("ryjcrqt", setRyjcxx.getRyjcrqt());
			map.put("qymc", setRyjcxx.getQymc());
			map.put("qybm", setRyjcxx.getQybm());
			map.put("xm", setRyjcxx.getXm());
			map.put("hylbdm", setRyjcxx.getHylbdm());
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			map.put("gxdwbm",StringUtil.trimEven0(user.getDepartment().getDepartcode()));

	        Page page = ryjcxxService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lCyryxx=page.getData();
	        
	        for (java.util.Iterator iter = lCyryxx.iterator(); iter.hasNext();) {
				Ryjcxx oneIcksl = (Ryjcxx) iter.next();
				oneIcksl.setQymc(oneIcksl.getQymc() + "<input type='hidden' name='qy"
						+ oneIcksl.getRycfid() + "' value='" + oneIcksl.getQyid()
						+ "'/>");
				oneIcksl.setXm(oneIcksl.getXm()+ "<input type='hidden' name='ry"
						+ oneIcksl.getRycfid() + "' value='" + oneIcksl.getRyid()
						+ "'/>");
			}
	        
	        ryCfsetTabledata(lCyryxx); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        
        return "success";
    }

	//查询人员基本信息
	public String query() throws Exception{
	
        try {
    
        	Qyryxx setQyryxx=new Qyryxx();
			qyryxx=(Qyryxx)this.setClass(setQyryxx, null);
	        String qyryZt = qyryxx.getZt();
	        
	        qyryxx=qyryxxService.getQyryxx(qyryxx);
	        
	        lCyryxx = new ArrayList();
	        lCyryxx.clear();
	        qyryxx.setShenhe_qyryzt(qyryxx.getCyryzt()); //审核需要 状态值 0、1==
	        //根据zt值，判断是否需要友好显示（详细页面与修改页面区别）
	        if(qyryZt==null || !qyryZt.equals("m"))
	        	setQyryxxDict_item(qyryxx);
	        lCyryxx.add(qyryxx);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxx=null;
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			
			Ryjcxx setRyjcxx=new Ryjcxx();
			ryjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);
			Qyjbxx qyjbxx =new Qyjbxx();
		    qyjbxx.setQyid(ryjcxx.getQyid());
		    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
		    String b="0";
			if(qyjbxx!=null){
				b=creatCfdjxh(qyjbxx.getQybm());
			}
			
			ryjcxx.setCfdjxh(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ryjcxx=ryjcxxService.insertRyjcxx(ryjcxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Ryjcxx setRyjcxx=new Ryjcxx();
			ryjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ryjcxxService.updateRyjcxx(ryjcxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Ryjcxx setRyjcxx=new Ryjcxx();
			ryjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ryjcxxService.deleteRyjcxx(ryjcxx);
        this.result="success";
        return "success";
    }

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}
//查询单条奖惩记录
	public String queryForby() throws Exception{
		
        try {
    
        	Ryjcxx setRyjcxx=new Ryjcxx();
    		ryjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);
    		ryjcxx=ryjcxxService.getRyjcxx(ryjcxx);
	        
	        
    		lRyjcxx.clear();
    		lRyjcxx.add(ryjcxx);
    		this.result="success";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxx=null;
		this.result="success";
        return "success";
    }
//查询人员的对应处罚奖惩记录	
	public String querylistForRy() throws Exception{
		Ryjcxx setRyjcxx=new Ryjcxx();
		ryjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);

		Map map = new HashMap();
		map.put("ryid", ryjcxx.getRyid());
		map.put("cflbbm",ryjcxx.getCflbbm());
		map.put("jcmxlbdm",ryjcxx.getJcmxlbdm());
		map.put("ryjcrqf", ryjcxx.getRyjcrqf());
		map.put("ryjcrqt", ryjcxx.getRyjcrqt());

        Page page = ryjcxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lCyryxx=page.getData();
        
        setTabledataForRy(lCyryxx); 
		 this.result="success";
        return "success";
    }
	//人员奖惩查询
	public String querylistForCx() throws Exception{
		Ryjcxx setRyjcxx=new Ryjcxx();
		ryjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);
		
		Map map = new HashMap();
		map.put("cflbbm",ryjcxx.getCflbbm());
		map.put("jcmxlbdm",ryjcxx.getJcmxlbdm());
		map.put("ryjcrqf", ryjcxx.getRyjcrqf());
		map.put("ryjcrqt", ryjcxx.getRyjcrqt());
		map.put("cyrybh", ryjcxx.getCyrybh());
		map.put("xm", ryjcxx.getXm());
		map.put("zjhm", ryjcxx.getZjhm());
		map.put("hylbdm", ryjcxx.getHylbdm());
		map.put("qybm", ryjcxx.getQybm());
		map.put("cylbdm", ryjcxx.getCylbdm());
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		map.put("gxdwbm",StringUtil.trimEven0(user.getDepartment().getDepartcode()));
		Page page = ryjcxxService.getListForPage(map, pagesize, pagerow,sort,dir);
		totalpage=page.getTotalPages();
		totalrows=page.getTotalRows();
		lCyryxx=page.getData();
		
		setTabledataForCx(lCyryxx); 
		this.result="success";
		return "success";
	}
	
	public void setTabledataForRy(List lData) throws Exception {
		
		List lPro = new ArrayList();
		lPro.add("rycfid");
		lPro.add("cflb");
		lPro.add("pzjg");
		lPro.add("pzrxm");
		lPro.add("zxrxm");
		lPro.add("ryjcrq");

		List lModify = new ArrayList();
		lModify.add("setUpdate_rycf");
		lModify.add("修改");

		List lDel = new ArrayList();
		lDel.add("setDelete_rycf");
		lDel.add("删除");
		
		
		List lCol = new ArrayList();
		lCol.add(lModify);
		lCol.add(lDel);

		Ryjcxx getRyjcxx = new Ryjcxx();
		
		this.setData(getRyjcxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	public void setTabledataForCx(List lData) throws Exception {
		
		List lPro = new ArrayList();
		lPro.add("rycfid");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("cylb");
		lPro.add("qymc");
		lPro.add("cflb");
		lPro.add("jcmxlb");
		lPro.add("ryjcrq");
		
		List lModify = new ArrayList();
		lModify.add("setQuery");
		lModify.add("详情");
		
		
		List lCol = new ArrayList();
		lCol.add(lModify);
		
		Ryjcxx getRyjcxx = new Ryjcxx();
		
		this.setData(getRyjcxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}


	/**人员信息状态改变（从数字转换为汉字，友好显示详细信息）*/
	private void setQyryxxDict_item(Qyryxx data){
		String displayName = "";
		Dict_item dict_item = new Dict_item();
		if(data.getCyryzt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
			dict_item.setFact_value(data.getCyryzt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setCyryzt(displayName);
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
		if(data.getZxyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxyy(cyry)");
			dict_item.setFact_value(data.getZxyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZxyy(displayName);
		}
		if(data.getZxbz()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxbz");
			dict_item.setFact_value(data.getZxbz());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZxbz(displayName);
		}
		
	}	
	
	public String creatCfdjxh(String qybm){
		
		/*
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
	    User user= (User)session.getAttribute(Constants.userKey);
	    */
	    Map map = new HashMap();
		map.put("p_bmfl", "RYJCXH");
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
		System.out.println(djxh);
        return djxh;
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
	/**
	 * 人员奖惩查询
	 * */
	public String querylistForRyjc() throws Exception{
		Ryjcxx setRyjcxx = new Ryjcxx();
		setRyjcxx=(Ryjcxx)this.setClass(setRyjcxx, null);

		Map map = new HashMap();
		map.put("ryid", setRyjcxx.getRyid());
		map.put("hylbdm", setRyjcxx.getHylbdm());
		map.put("qybm", setRyjcxx.getQybm());
		map.put("qymc", setRyjcxx.getQymc());
		map.put("xm", setRyjcxx.getXm());
		map.put("cflbbm",setRyjcxx.getCflbbm());
		map.put("jcmxlbdm", setRyjcxx.getJcmxlbdm());
		map.put("ryjcrqf", setRyjcxx.getRyjcrqf());
		map.put("ryjcrqt", setRyjcxx.getRyjcrqt());
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		map.put("gxdwbm",StringUtil.trimEven0(user.getDepartment().getDepartcode()));

        Page page = ryjcxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lCyryxx=page.getData();
        
        setTabledataForRyjc(lCyryxx); 
		 this.result="success";
        return "success";
    }
	/**
	 * 人员奖惩查询列表
	 * */
    public void setTabledataForRyjc(List lData) throws Exception {
		
		List lPro = new ArrayList();
		lPro.add("rycfid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("xm");
		lPro.add("cflb");
		lPro.add("jcmxlb");
		lPro.add("pzjg");
		lPro.add("pzrxm");
		lPro.add("zxrxm");
		lPro.add("ryjcrq");


		Ryjcxx getRyjcxx = new Ryjcxx();
		
		this.setData(getRyjcxx, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
}