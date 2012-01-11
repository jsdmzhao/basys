package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Bwryxx;
import com.aisino2.publicsystem.service.IBwryxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class BwryxxAction extends PageAction{
	private IBwryxxService bwryxxService;
	private List lBwryxx=new ArrayList();
	private Bwryxx bwryxx=new Bwryxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private User user;
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Bwryxx getBwryxx() {
		return bwryxx;
	}
	
	public List getLBwryxx() {
		return lBwryxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBwryxxService(IBwryxxService bwryxxService) {
		this.bwryxxService = bwryxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bwryid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("hjdxzqh");
		lPro.add("hjdxz");
		lPro.add("sgrq");

		lPro.add("hjdxzqhdm");
		lPro.add("lrr");
		lPro.add("lrsj");
		lPro.add("bz");

    	
    	Bwryxx getBwryxx=new Bwryxx();
    	
        this.setData(getBwryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}	
	
	public void setTableCxdata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bwryid");
		lPro.add("hylb");
		lPro.add("qymc");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("hjdxzqh");
		lPro.add("hjdxz");
		lPro.add("zt");
    	Bwryxx getBwryxx=new Bwryxx();
    	
        this.setData(getBwryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataBack(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bwryid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("hjdxzqh");
		lPro.add("hjdxz");
		lPro.add("sgrq");

		lPro.add("hjdxzqhdm");
		lPro.add("lrr");
		lPro.add("lrsj");
		lPro.add("bz");
		lPro.add("hylb");
		lPro.add("qymc");
		lPro.add("zt");
		lPro.add("lzrq");
		lPro.add("lzyy");
    	
    	Bwryxx getBwryxx=new Bwryxx();
    	
        this.setData(getBwryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		Bwryxx setBwryxx=new Bwryxx();
		bwryxx=(Bwryxx)this.setClass(setBwryxx, null);
        Map map = new HashMap();
        map.put("qyid", bwryxx.getQyid());
        map.put("zt", "1");// 在职
        Page page = bwryxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBwryxx=page.getData();
        setTabledata(lBwryxx); 
		 this.result="success";
        return "success";
    }
	
	public String queryCxlist() throws Exception{
		try{
			Bwryxx setBwryxx=new Bwryxx();
			bwryxx=(Bwryxx)this.setClass(setBwryxx, null);
			Map map = new HashMap();
	        map.put("hylbdm", bwryxx.getHylbdm());
	        map.put("qymc", bwryxx.getQymc());
	        map.put("xm", bwryxx.getXm());
	        map.put("gmsfhm", bwryxx.getGmsfhm());
	        map.put("hjdxzqh", bwryxx.getHjdxzqh());
	        map.put("hjdxz", bwryxx.getHjdxz());
	        map.put("zt", bwryxx.getZt());
	        //map.put("qyid", bwryxx.getQyid());
	     // 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			user = (User) session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment()
					.getDepartcode());
			map.put("gxdwbm", depertCode0);
	        Page page = bwryxxService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lBwryxx=page.getData();
	        translateDictZT();
	        setTableCxdata(lBwryxx); 
			this.result="success";
		}catch(Exception e){
			e.printStackTrace();
		}
        return "success";
    }

	/**保卫人员列表修改时，查询列表方法，用于企业修改*/
	public String querylistByQy() throws Exception{
		Bwryxx setBwryxx=new Bwryxx();
		bwryxx=(Bwryxx)this.setClass(setBwryxx, null);
		bwryxx.setZt("1");
		//传递qyid参数
        lBwryxx = bwryxxService.getListBwryxx(bwryxx);
        setTabledataBack(lBwryxx); 
		 this.result="success";
        return "success";
    }
	
	/**保卫人员列表添加时，返回action添加样式的方法，用于企业新增*/
	public String querylistBack() throws Exception{
		Bwryxx setBwryxx=new Bwryxx();
		Object[] bwryObj = {setBwryxx};
		bwryxx=(Bwryxx)this.setClass(setBwryxx, bwryObj);
		lBwryxx = bwryxx.getLBwryxxList();
		if(lBwryxx==null)
			lBwryxx = new ArrayList();
		//是否删除操作  1:删除  0:修改  2:查询
		if(!(new Integer(1)).equals(bwryxx.getSfsccz())){
			bwryxx.setBwryid(new Integer(0));
			lBwryxx.add(bwryxx);
		}
        setTabledataBack(lBwryxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bwryxx setBwryxx=new Bwryxx();
			bwryxx=(Bwryxx)this.setClass(setBwryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bwryxx=bwryxxService.getBwryxx(bwryxx);
        translateBwryDictZT();
        lBwryxx.add(bwryxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bwryxx setBwryxx=new Bwryxx();
			bwryxx=(Bwryxx)this.setClass(setBwryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bwryxx=bwryxxService.insertBwryxx(bwryxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bwryxx setBwryxx=new Bwryxx();
			bwryxx=(Bwryxx)this.setClass(setBwryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bwryxxService.updateBwryxx(bwryxx);
        this.result="success";
        return "success";
    }
	

	public String delete() throws Exception{
		try {
			Bwryxx setBwryxx=new Bwryxx();
			bwryxx=(Bwryxx)this.setClass(setBwryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bwryxxService.deleteBwryxx(bwryxx);
        this.result="success";
        return "success";
    }
	/**
	 * 翻译字典项

	 */
	public void translateDictZT() {
		if (lBwryxx != null && lBwryxx.size() > 0) {
			for (int index = 0, max = lBwryxx.size(); index < max; index++) {
				Bwryxx tempQy = (Bwryxx) lBwryxx.get(index);
				Dict_item dict_item = CacheManager.getCacheDictitemOne(
						"dm_ryzt", tempQy.getZt());
				if (dict_item != null) {
					tempQy.setZt(dict_item.getDisplay_name());
					lBwryxx.set(index, tempQy);
				}
			}
		}
	}
	/**
	 * 一个实例的，翻译字典项

	 */
	public void translateBwryDictZT() {
		if(bwryxx!=null){
			Dict_item dict_item = CacheManager.getCacheDictitemOne(
					"dm_ryzt", bwryxx.getZt());
			if (dict_item != null) {
				bwryxx.setZt(dict_item.getDisplay_name());
			}
		}
	}
}