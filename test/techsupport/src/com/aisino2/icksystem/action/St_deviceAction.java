package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.St_device;
import com.aisino2.icksystem.service.ISt_deviceService;
import com.aisino2.sysadmin.domain.Dict_item;

public class St_deviceAction extends PageAction{
	private ISt_deviceService st_deviceService;
	private List lSt_device=new ArrayList();
	//private St_device st_device=new St_device();
	private St_device st_device;
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

	public St_device getSt_device() {
		return st_device;
	}
	
	public List getLSt_device() {
		return lSt_device;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setSt_deviceService(ISt_deviceService st_deviceService) {
		this.st_deviceService = st_deviceService;
	}
	
	
	
	
	
	
	
	
	
	/**信息状态改变（从数字转换为汉字，友好显示列表信息）*/
	private String setDict_itemList(String dict_code,String fact_value){
		String displayName;
		Dict_item dict_item = new Dict_item();
		
			displayName = "";
			dict_item.setDict_code(dict_code);
			dict_item.setFact_value(fact_value);
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			return displayName;
		
	
	}	
	
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("dev_serial");
		lPro.add("dev_name");
		lPro.add("mac");
		lPro.add("dev_ip");
		lPro.add("port");
		lPro.add("csbm");	
		lPro.add("qymc");
		lPro.add("run_state");
		
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	St_device getSt_device=new St_device();
    	
        this.setData(getSt_device,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataMoRenFuWu(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("dev_serial");
		lPro.add("dev_name");
		lPro.add("dev_serial");
    	St_device getSt_device=new St_device();
    	
        this.setData(getSt_device,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		
		try {
        St_device setSt_device=new St_device();
        st_device=(St_device)this.setClass(setSt_device, null);
        Map map = new HashMap();
        if(st_device!=null){
        	map.put("dev_name", st_device.getDev_name());
        	map.put("mac", st_device.getMac());
        	map.put("qyid", st_device.getQyid());
        	map.put("qymc", st_device.getQymc());
        	map.put("csbm", st_device.getCsbm());
        	map.put("dev_ip", st_device.getDev_ip());
        	map.put("hylbdm", st_device.getHylbdm());
        }

        Page page = st_deviceService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lSt_device=page.getData(); 
        setTabledata(lSt_device); 
		 this.result="success";
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        
        return "success";
    }
	
	public String query() throws Exception{
		try {
			St_device setSt_device=new St_device();
			st_device=(St_device)this.setClass(setSt_device, null);
            st_device=st_deviceService.getSt_device(st_device);
        if(st_device!=null&&st_device.getDev_up()!=null) {
        	st_device.setDev_upName(setDict_itemList("dm_wxsbgxzt",st_device.getDev_up().toString()));
        }
       
        lSt_device.add(st_device);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="查询失败";
			e.printStackTrace();
		}
		st_device=null;
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			St_device setSt_device=new St_device();
			st_device=(St_device)this.setClass(setSt_device, null);
			String hylb = setDict_itemList("dm_hylb",st_device.getHylbdm());
			st_device.setHylb(hylb);
			
			
			st_device=st_deviceService.insertSt_device(st_device);
			   this.result="success";
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			    this.result="添加失败";
			
				e.printStackTrace();
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			St_device setSt_device=new St_device();
			st_device=(St_device)this.setClass(setSt_device, null);
			String hylb = setDict_itemList("dm_hylb",st_device.getHylbdm());
			st_device.setHylb(hylb);
			 st_deviceService.updateSt_device(st_device);
		        this.result="success";
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			  this.result="修改失败";
			 
				e.printStackTrace();
		}
     
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			St_device setSt_device=new St_device();
			st_device=(St_device)this.setClass(setSt_device, null);
			  st_deviceService.deleteSt_device(st_device);
		        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			   this.result="success";
			e.printStackTrace();
		}
      
        return "success";
    }
	//取得默认服务列表
	public String queryMoRenlist() throws Exception{
		try {
        St_device setSt_device=new St_device();
        st_device=(St_device)this.setClass(setSt_device, null);
        Map map = new HashMap();
        if(st_device!=null){
        	map.put("query_simplepinfuwu", st_device.getQuery_simplepinfuwu());
        	map.put("hylbdm", st_device.getHylbdm());
        }
        Page page = st_deviceService.getListMoRenForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lSt_device=page.getData(); 
        setTabledataMoRenFuWu(lSt_device); 
		 this.result="success";
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        
        return "success";
    }
	//取得默认服务列表
	public String setParentFrist() throws Exception{
		try {
 
        Map map = new HashMap();
        Page page = st_deviceService.getListMoRenForPage(map, 1, 10,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        List list = page.getData();
        if(list!=null&&list.size()>0){
        	st_device =(St_device) list.get(0);
        	lSt_device.add(st_device);
        }
		 this.result="success";
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        
        return "success";
    }
	
	
}