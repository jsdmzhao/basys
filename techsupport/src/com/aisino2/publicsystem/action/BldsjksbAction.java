package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Bldsjksb;
import com.aisino2.publicsystem.service.IBldsjksbService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class BldsjksbAction extends PageAction{
	private IBldsjksbService bldsjksbService;
	private List lBldsjksb=new ArrayList();
	private Bldsjksb bldsjksb=new Bldsjksb();
	private String tabledata="";
	private int totalrows=0;
	private String result="success";
	private String requestType="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Bldsjksb getBldsjksb() {
		return bldsjksb;
	}
	
	public List getLBldsjksb() {
		return lBldsjksb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBldsjksbService(IBldsjksbService bldsjksbService) {
		this.bldsjksbService = bldsjksbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bldsjksbid");
		lPro.add("sbmc");
		lPro.add("sccsmc");
		lPro.add("ggxh");
		lPro.add("sbjcjgmc");
		lPro.add("anwz");
		lPro.add("wlcslxmc");
		lPro.add("azsxtsl");
		lPro.add("sflx");
		lPro.add("ipdz");
		

		/*
		List lCol=new ArrayList();
    	List lDel=new ArrayList();
    	lDel.add("bldsjksb_setDelete");
    	lDel.add("删除");
    	lCol.add(lDel);
    	
    	if(!"detail".equals(requestType)){
    		List lMod=new ArrayList();
    		lMod.add("bldsjksb_setModify");
    		lMod.add("修 改");
        	lCol.add(lMod);
    	}*/
    	Bldsjksb getBldsjksb=new Bldsjksb();
        this.setData(getBldsjksb,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void mapProperty(Map map, Bldsjksb bldsjksb) {

		map.put("hylbdm", bldsjksb.getHylb());
		map.put("qymc", bldsjksb.getQymc());
		map.put("sbmc", bldsjksb.getSbmc());
		map.put("sccsmc", bldsjksb.getSccsmc());
		map.put("ggxh", bldsjksb.getGgxh());
		map.put("azsl", bldsjksb.getAzsl());
		map.put("sflx", bldsjksb.getSflx());
		map.put("ipdz", bldsjksb.getIpdz());
		map.put("zt",bldsjksb.getZt());

	}
	
	public void setTabledataBack(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bldsjksbid");
		lPro.add("sbmc");
		lPro.add("sccsmc");
		lPro.add("ggxh");
		lPro.add("sbjcjgmc");
		lPro.add("wlcslxmc");
		lPro.add("azsxtsl");
		lPro.add("sflx");
		lPro.add("ipdz");
		lPro.add("lrr");
		lPro.add("lrsj");
		lPro.add("bz");
		lPro.add("wlcslxbm");
		lPro.add("azsl");
		
    	Bldsjksb getBldsjksb=new Bldsjksb();
    	
        this.setData(getBldsjksb,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setstopTabledataBack(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bldsjksbid");
		lPro.add("sbmc");
		lPro.add("sccsmc");
		lPro.add("ggxh");
		lPro.add("sbjcjgmc");
		lPro.add("wlcslxmc");
		lPro.add("azsxtsl");
		lPro.add("sflx");
		lPro.add("ipdz");
		lPro.add("lrr");
		lPro.add("lrsj");
		lPro.add("bz");
		lPro.add("jibr");
		lPro.add("tysj");
		lPro.add("zt");
		lPro.add("tyyy");
		lPro.add("hylb");
		lPro.add("qymc");
		
    	Bldsjksb getBldsjksb=new Bldsjksb();
    	
        this.setData(getBldsjksb,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querystoplistByQy() throws Exception{
		try {
			Bldsjksb setBldsjksb=new Bldsjksb();
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, null);
			setBldsjksb.setZt("1");
			//传递qyid参数
	        lBldsjksb = bldsjksbService.getListBldsjksb(setBldsjksb);
	        setstopTabledataBack(lBldsjksb); 
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String querylist() throws Exception{
		try {
			requestType = "";
			Bldsjksb setBldsjksb=new Bldsjksb();
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, null);
			requestType = setBldsjksb.getBldsjkRequetType();
			Map map = new HashMap();
			map.put("qyid", setBldsjksb.getQyid());
			map.put("zt", "1");
			Page page = bldsjksbService.getListForPage(map, pagesize, pagerow,null,null);
			lBldsjksb=page.getData();
			setTabledata(lBldsjksb);
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	/**依据企业查询视频监控设备列表方法*/
	public String querylistByQy() throws Exception{
		try {
			Bldsjksb setBldsjksb=new Bldsjksb();
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, null);
			setBldsjksb.setZt("1");
			//传递qyid参数
	        lBldsjksb = bldsjksbService.getListBldsjksb(setBldsjksb);
	        setTabledataBack(lBldsjksb); 
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	/**视频监控设备回调查询方法*/
	public String querylistBack() throws Exception{
		try {
			Bldsjksb setBldsjksb=new Bldsjksb();
			Object[] bldsjksbObj = {setBldsjksb};
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, bldsjksbObj);
			lBldsjksb = setBldsjksb.getLBldsjksbList();
			if(lBldsjksb==null)
				lBldsjksb = new ArrayList();
			//是否删除操作  sc:删除  xg:修改  cx:查询
			if(!"sc".equals(setBldsjksb.getBldsjkRequetType())){
				setBldsjksb.setBldsjksbid(new Integer(0));
				lBldsjksb.add(setBldsjksb);
			}
	        setTabledataBack(lBldsjksb); 
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Bldsjksb setBldsjksb=new Bldsjksb();
			Object[] objA={setBldsjksb};
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, objA);
			oldList = setBldsjksb.getLBldsjksbList();
			int rowId = setBldsjksb.getBldsjksbid();
			lBldsjksb = new ArrayList();
			lBldsjksb.add(oldList.get(rowId));
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Bldsjksb setBldsjksb=new Bldsjksb();
			Object[] objA={setBldsjksb};
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, objA);
			oldList = setBldsjksb.getLBldsjksbList();
			oldList.add(setBldsjksb);
			setTabledata(setObjectIdForHtmlList(oldList)); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			List oldList = new ArrayList();
			Bldsjksb setBldsjksb=new Bldsjksb();
			Bldsjksb newBldsjksb=new Bldsjksb();
			Object[] objA={setBldsjksb};
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, objA);
			newBldsjksb=(Bldsjksb)this.setClass(newBldsjksb, null);
			oldList = setBldsjksb.getLBldsjksbList();
			int modify = setBldsjksb.getBldsjksbid();
			oldList.set(modify, newBldsjksb);
			setTabledata(setObjectIdForHtmlList(oldList)); 
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
		}
//        bldsjksbService.updateBldsjksb(bldsjksb);
        return "success";
    }
	
	
	public String querylistinsertBack() throws Exception{
		try {
			Bldsjksb setBldsjksb=new Bldsjksb();
			Object[] bldsjksbObj = {setBldsjksb};
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, bldsjksbObj);
			lBldsjksb = setBldsjksb.getLBldsjksbList();
			if(lBldsjksb==null)
				lBldsjksb = new ArrayList();
			//是否删除操作  sc:删除  xg:修改  cx:查询
			if(!"sc".equals(setBldsjksb.getBldsjkRequetType())){
				setBldsjksb.setBldsjksbid(new Integer(0));
				lBldsjksb.add(setBldsjksb);
			}
			setstopTabledataBack(lBldsjksb); 
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	public String delete() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Bldsjksb setBldsjksb=new Bldsjksb();
			Object[] objA={setBldsjksb};
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, objA);
			oldList = setBldsjksb.getLBldsjksbList();
			int remove = setBldsjksb.getBldsjksbid();
			oldList.remove(remove);
			setTabledata(setObjectIdForHtmlList(oldList)); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 this.result="";
		}
//        bldsjksbService.deleteBldsjksb(bldsjksb);
        return "success";
    }
	
	public List setObjectIdForHtmlList(List allResult){
		List result = new ArrayList();
		if(allResult!=null&&allResult.size()>0){
			for(int index=0,max=allResult.size();index<max;index++){
				Bldsjksb temp = (Bldsjksb)allResult.get(index);
				temp.setBldsjksbid(1);
				result.add(temp);
			}
		}
		return result;
	}
	//下面是娱乐场所公安端闭路电视查询
	public void setTabledataGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		
		lPro.add("sbmc");
		lPro.add("sccsmc");
		lPro.add("ggxh");
		lPro.add("azsxtsl");
		
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("qyzflmc");
		
		lPro.add("sbjcjgmc");
		lPro.add("anwz");
		lPro.add("wlcslxmc");
		lPro.add("sflx");
		lPro.add("ipdz");
    	
		List lCol=new ArrayList();
    	List lDel=new ArrayList();
    	lDel.add("");
    	lDel.add("详情");
    	lCol.add(lDel);
    	
    	Bldsjksb setBldsjksb=new Bldsjksb();
    	
        this.setData(setBldsjksb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String queryBldsListGnd() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Bldsjksb setBldsjksb=new Bldsjksb();
			setBldsjksb=(Bldsjksb)this.setClass(setBldsjksb, null);
			Map map = new HashMap();
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode())); //session
			map.put("sfyx", "1");
			map.put("qyid", setBldsjksb.getQyid());
			map.put("qybm", setBldsjksb.getQybm());
			map.put("hylbdm", null);
			map.put("allhylbdm", setBldsjksb.getHylbdm());
			map.put("ggxh", setBldsjksb.getGgxh());
			map.put("sbmc", setBldsjksb.getSbmc());
			
			map.put("superbWhere", setBldsjksb.getSuperbWhere()); //高级查询条件
			map.put("superbOrderBy", setBldsjksb.getSuperbOrderBy());
			
			map.put("zt", "1");
			
			Page page = bldsjksbService.getBldsjksbGadListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledataGad(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String queryspjkxxlist() throws Exception {
		try {
			Bldsjksb setBldsjksb = new Bldsjksb();
			setBldsjksb = (Bldsjksb) this.setClass(setBldsjksb, null);
			Map map = new HashMap();
			mapProperty(map, setBldsjksb);

			Page page = bldsjksbService.getSpjksbGadListForPage(map, pagesize,
					pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setSpjkxxTabledata(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
		}
		return "success";
	}
	
	
	public void setSpjkxxTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("hylb");
		lPro.add("qymc");
		lPro.add("sbmc");
		lPro.add("sccsmc");
		lPro.add("ggxh");
		lPro.add("azsl");
		lPro.add("sflx");
		lPro.add("ipdz");
		lPro.add("sbjcjgmc");
		lPro.add("wlcslxmc");
		lPro.add("lrr");
		lPro.add("lrsj");
		lPro.add("bz");
		lPro.add("qyzflbm");

    	Bldsjksb getBldsjksb=new Bldsjksb();
        this.setData(getBldsjksb,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
}