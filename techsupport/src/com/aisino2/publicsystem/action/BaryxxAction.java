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
import com.aisino2.publicsystem.domain.Baryxx;
import com.aisino2.publicsystem.service.IBaryxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class BaryxxAction extends PageAction{
	private IBaryxxService baryxxService;
	private List lBaryxx=new ArrayList();
	private Baryxx baryxx=new Baryxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private String requestType="";
	private User user;
	private String exitResult;
	
	
	public String getExitResult() {
		return exitResult;
	}

	public void setExitResult(String exitResult) {
		this.exitResult = exitResult;
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

	public Baryxx getBaryxx() {
		return baryxx;
	}
	
	public List getLBaryxx() {
		return lBaryxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBaryxxService(IBaryxxService baryxxService) {
		this.baryxxService = baryxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("baryid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("hjdxzqh");
		lPro.add("sgrq");
		lPro.add("balx");
		lPro.add("fzjg");
		lPro.add("xb");
		lPro.add("xbdm");
		lPro.add("csrq");
		lPro.add("hjdxzqhdm");
		lPro.add("hjdxz");
	    lPro.add("balxbm");
	    lPro.add("bz");
	    lPro.add("zt");
	    lPro.add("lrr");
	    lPro.add("lrsj");
	    lPro.add("lzyy");
		lPro.add("hylb");
		lPro.add("qymc");
		lPro.add("lzrq");
		
    	/*List lModify=new ArrayList();
    	lModify.add("bary_setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("bary_setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);*/
    	
    	Baryxx getBaryxx=new Baryxx();
    	
        this.setData(getBaryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTableCxdata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("baryid");
		lPro.add("hylb");
		lPro.add("qymc");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("hjdxzqh");
		lPro.add("hjdxz");
		lPro.add("zt");
    	Baryxx getBaryxx=new Baryxx();
    	
        this.setData(getBaryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try{
			requestType="";
	        Baryxx setBaryxx=new Baryxx();
	        setBaryxx=(Baryxx)this.setClass(setBaryxx, null);
	        requestType = setBaryxx.getBaryRequetType();
	        setBaryxx.setZt("1");// 在职
	        lBaryxx= baryxxService.getListBaryxx(setBaryxx);
	        setTabledata(lBaryxx); 
			this.result="success";
		}catch(Exception e){
			e.printStackTrace();
		}
        return "success";
    }
	
	public String queryCxlist() throws Exception{
		try{
			requestType="";
	        Baryxx setBaryxx=new Baryxx();
	        setBaryxx=(Baryxx)this.setClass(setBaryxx, null);
	        requestType = setBaryxx.getBaryRequetType();
	        Map map = new HashMap();
	        map.put("hylbdm", setBaryxx.getHylbdm());
	        map.put("qymc", setBaryxx.getQymc());
	        map.put("xm", setBaryxx.getXm());
	        map.put("gmsfhm", setBaryxx.getGmsfhm());
	        map.put("hjdxzqh", setBaryxx.getHjdxzqh());
	        map.put("hjdxz", setBaryxx.getHjdxz());
	        map.put("zt", setBaryxx.getZt());
	     // 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			user = (User) session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment()
					.getDepartcode());
			map.put("gxdwbm", depertCode0);
	        Page page = baryxxService.getListForPage(map, pagesize, pagerow,sort, dir);
	        totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
	        lBaryxx=page.getData();
	        translateDictZT();
	        setTableCxdata(lBaryxx); 
			this.result="success";
		}catch(Exception e){
			e.printStackTrace();
		}
        return "success";
    }
	
	public String query() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Baryxx setBaryxx=new Baryxx();
			Object[] objA={setBaryxx};
			setBaryxx=(Baryxx)this.setClass(setBaryxx, objA);
			oldList = setBaryxx.getLBaryxxList();
			int rowId = setBaryxx.getBaryid();
			lBaryxx = new ArrayList();
			lBaryxx.add(oldList.get(rowId));
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return "success";
    }
	
	public String queryBary() throws Exception{
		try {
			Baryxx setBaryxx=new Baryxx();
			baryxx=(Baryxx)this.setClass(setBaryxx, null);
			baryxx=baryxxService.getBaryxx(baryxx);
			translateBwryDictZT();
			lBaryxx.add(baryxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	public String insert() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Baryxx setBaryxx=new Baryxx();
			Object[] objA={setBaryxx};
			setBaryxx=(Baryxx)this.setClass(setBaryxx, objA);
			oldList = setBaryxx.getLBaryxxList();
			oldList.add(setBaryxx);
			setTabledata(setObjectIdForHtmlList(oldList)); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	/**
	 * 设定页面列表
	 * @param allResult
	 * @return
	 */
	public List setObjectIdForHtmlList(List allResult){
		List result = new ArrayList();
		if(allResult!=null&&allResult.size()>0){
			for(int index=0,max=allResult.size();index<max;index++){
				Baryxx temp = (Baryxx)allResult.get(index);
				if(temp.getBaryid()==null){
					temp.setBaryid(1);
					temp.setOldbaryid(1);
				}
				result.add(temp);
			}
		}
		return result;
	}
	
	public String modify() throws Exception{
		try {
			List oldList = new ArrayList();
			Baryxx setBaryxx=new Baryxx();
			Baryxx newBaryxx=new Baryxx();
			Object[] objA={setBaryxx};
			setBaryxx=(Baryxx)this.setClass(setBaryxx, objA);
			newBaryxx=(Baryxx)this.setClass(newBaryxx, null);
			oldList = setBaryxx.getLBaryxxList();
			int modify = setBaryxx.getBaryid();
			newBaryxx.setBaryid(newBaryxx.getOldbaryid());
			oldList.set(modify, newBaryxx);
			setTabledata(setObjectIdForHtmlList(oldList));
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	
	
	public String delete() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Baryxx setBaryxx=new Baryxx();
			Object[] objA={setBaryxx};
			setBaryxx=(Baryxx)this.setClass(setBaryxx, objA);
			oldList = setBaryxx.getLBaryxxList();
			int remove = setBaryxx.getBaryid();
			oldList.remove(remove);
			setTabledata(setObjectIdForHtmlList(oldList)); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "success";
    }
	
	/**
	 * 翻译字典项

	 */
	public void translateDictZT() {
		if (lBaryxx != null && lBaryxx.size() > 0) {
			for (int index = 0, max = lBaryxx.size(); index < max; index++) {
				Baryxx tempQy = (Baryxx) lBaryxx.get(index);
				Dict_item dict_item = CacheManager.getCacheDictitemOne(
						"dm_ryzt", tempQy.getZt());
				if (dict_item != null) {
					tempQy.setZt(dict_item.getDisplay_name());
					lBaryxx.set(index, tempQy);
				}
			}
		}
	}
	/**
	 * 一个实例的，翻译字典项

	 */
	public void translateBwryDictZT() {
		if(baryxx!=null){
			Dict_item dict_item = CacheManager.getCacheDictitemOne(
					"dm_ryzt", baryxx.getZt());
			if (dict_item != null) {
				baryxx.setZt(dict_item.getDisplay_name());
			}
		}
	}
}