package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyjcxx;
import com.aisino2.publicsystem.service.IKyqkService;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyjcxxService;

public class QyjcxxAction extends PageAction{
	private IQyjcxxService qyjcxxService;
	private IQyjbxxService qyjbxxService;
	private IKyqkService kyqkService;
	private List lQyjcxx=new ArrayList();
	private Qyjcxx qyjcxx=new Qyjcxx();
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

	public Qyjcxx getQyjcxx() {
		return qyjcxx;
	}
	
	public List getLQyjcxx() {
		return lQyjcxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyjcxxService(IQyjcxxService qyjcxxService) {
		this.qyjcxxService = qyjcxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qycfid");
		lPro.add("qymc");
		lPro.add("cfdjxh");
		lPro.add("cflb");
		lPro.add("jcmxlb");
		lPro.add("pzjg");
		lPro.add("qyjcrq");
		lPro.add("bjcr");
		
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyjcxx getQyjcxx=new Qyjcxx();
    	
        this.setData(getQyjcxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyjcxx setQyjcxx=new Qyjcxx();
        setQyjcxx=(Qyjcxx)this.setClass(setQyjcxx, null);
        Map map = new HashMap();
        map.put("hylbdm", setQyjcxx.getHylbdm());
        map.put("qyjcrq", setQyjcxx.getQyjcrq());
        map.put("qyjcrqzhi", setQyjcxx.getQyjcrqzhi());
        map.put("qymc", setQyjcxx.getQymc());
        map.put("qyid", setQyjcxx.getQyid());
        map.put("cflbbm", setQyjcxx.getCflbbm());
        map.put("jcmxlbdm", setQyjcxx.getJcmxlbdm());
        map.put("pzjgdm", setQyjcxx.getPzjgdm());
        map.put("cfdjxh", setQyjcxx.getCfdjxh());
        map.put("xzcfpzwh", setQyjcxx.getXzcfpzwh());
        map.put("zxbz", "0");
        Page page = qyjcxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyjcxx=page.getData();
        setTabledata(lQyjcxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyjcxx setQyjcxx=new Qyjcxx();
			qyjcxx=(Qyjcxx)this.setClass(setQyjcxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyjcxx=qyjcxxService.getQyjcxx(qyjcxx);
        lQyjcxx.clear();
        lQyjcxx.add(qyjcxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyjcxx setQyjcxx=new Qyjcxx();
			setQyjcxx=(Qyjcxx)this.setClass(setQyjcxx, null);
			setQyjcxx=findQyjcxx(setQyjcxx);
			setQyjcxx.setScbz(0);
			setQyjcxx=qyjcxxService.insertQyjcxx(setQyjcxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyjcxx setQyjcxx=new Qyjcxx();
			setQyjcxx=(Qyjcxx)this.setClass(setQyjcxx, null);
			Qyjbxx qyjbxx =new Qyjbxx();
		    qyjbxx.setQybm(setQyjcxx.getQybm());
		    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
		    setQyjcxx.setQyid(qyjbxx.getQyid());
		    qyjcxxService.updateQyjcxx(setQyjcxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyjcxx setQyjcxx=new Qyjcxx();
			setQyjcxx=(Qyjcxx)this.setClass(setQyjcxx, null);
			qyjcxxService.deleteQyjcxx(setQyjcxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        this.result="success";
        return "success";
    }
	public Qyjcxx findQyjcxx(Qyjcxx setQyjcxx){//生成企业编码以及获取企业id
		Qyjbxx qyjbxx =new Qyjbxx();
	    qyjbxx.setQybm(setQyjcxx.getQybm());
	    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
	    setQyjcxx.setQyid(qyjbxx.getQyid());
	    
	    Map map = new HashMap();
		map.put("p_bmfl", "QYJCXH");
		map.put("p_xzqh", setQyjcxx.getQybm());
		//map.put("p_xzqh", user.getUseraccount());
		//Globalpar globalpar = new Globalpar();
		//globalpar  = this.getCacheGlobalpar("sssf");
		//String sssf = globalpar.getGlobalparvalue();
		map.put("p_sssf", "hn");
		map.put("p_scgz", 2);
		String djxh = kyqkService.getScbm(map);
		setQyjcxx.setCfdjxh(djxh);
	    return setQyjcxx;
	}
	public void setKyqkService(IKyqkService kyqkService) {
		this.kyqkService = kyqkService;
	}
	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}
}