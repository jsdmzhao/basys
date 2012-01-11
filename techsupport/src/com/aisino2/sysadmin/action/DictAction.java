package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.service.IDictService;

public class DictAction extends PageAction{
	private IDictService dictService;
	private List lDict = new ArrayList();
	private Dict dict;
	private String tabledata;
	private int totalrows;
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

	public Dict getDict() {
		return dict;
	}
	
	public List getLDict() {
		return lDict;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setDictService(IDictService dictService) {
		this.dictService = dictService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("dict_code");
		lPro.add("dict_code");
		lPro.add("dict_name");
		lPro.add("super_dict_code");
		lPro.add("dict_versionid");
		lPro.add("dict_type");

    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete_dict");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Dict getDict=new Dict();
    	
        this.setData(getDict,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}	
	public void setTabledataLd(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("dict_id");
		lPro.add("dict_name");
		lPro.add("dict_code");
    	
    	Dict getDict=new Dict();
    	
        this.setData(getDict,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	private void setDict_type(List list){
		for(Iterator iter=list.iterator();iter.hasNext();){
			Dict dict = (Dict)iter.next();
			if(dict.getDict_type()!=null){
				if(dict.getDict_type().equals("01")){
					dict.setDict_type("简单");
				}
				else if(dict.getDict_type().equals("02")){
					dict.setDict_type("树状");
				}
				else if(dict.getDict_type().equals("11")){
					dict.setDict_type("联动");
				}
			}
		}
	}
	
	public String querylist() throws Exception{
        Dict setDict=new Dict();
        try{
        	dict = (Dict)this.setClass(setDict, null);
        }catch(Exception e){
        	e.printStackTrace();
        }
        Map map = new HashMap();
        if(dict!=null){
    		if(dict.getDict_name()!=null&&!dict.getDict_name().equals(""))
    			map.put("dict_name", dict.getDict_name());
    		if(dict.getSuper_dict_code()!=null&&!dict.getSuper_dict_code().equals(""))
    			map.put("super_dict_code", dict.getSuper_dict_code());
    		if(dict.getDict_code()!=null&&!dict.getDict_code().equals(""))
    			map.put("dict_code", dict.getDict_code());
    		if(dict.getDict_type()!=null&&!dict.getDict_type().equals(""))
    			map.put("dict_type", dict.getDict_type());
    		if(dict.getDict_versionid()!=null&&!dict.getDict_versionid().equals(""))
    			map.put("dict_versionid", dict.getDict_versionid());
        }
        Page page = dictService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lDict=page.getData();
        setDict_type(lDict);
        setTabledata(lDict); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Dict setDict=new Dict();
			dict=(Dict)this.setClass(setDict, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dict=dictService.getDict(dict);
        lDict = new ArrayList();
        lDict.add(dict);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Dict setDict=new Dict();
			dict=(Dict)this.setClass(setDict, null);
			Dict exitDict = dictService.getDict(dict);
			if(exitDict!=null){
				this.result = "该字典代码已经存在";
				return "success";
			}
	        dict=dictService.insertDict(dict);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Dict setDict=new Dict();
			dict=(Dict)this.setClass(setDict, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dictService.updateDict(dict);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Dict setDict=new Dict();
			dict=(Dict)this.setClass(setDict, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dictService.deleteDict(dict);
        this.result="success";
        return "success";
    }
	
	/**
	 * 字典下拉列表查询,分页
	 * @return
	 * @throws Exception
	 */
	public String queryForDictLd() throws Exception{
		try {
			Dict setDict = new Dict();
			dict=(Dict)this.setClass(setDict, null);
			Map map = new HashMap();
	        //筛选条件
	        if(dict.getQuery_simplepin() != null)
	        	map.put("query_simplepin", dict.getQuery_simplepin());
	        
	        Page page = dictService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lDict=page.getData();
	        setTabledataLd(lDict); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		this.result="success";
        return "success";
    }
	
	/**
	 * 字典列表查询,不分页
	 * @return
	 * @throws Exception
	 */
	public String queryDictListNoPage() throws Exception{
		try {
			Dict setDict = new Dict();
			dict=(Dict)this.setClass(setDict, null);
			lDict = dictService.getListDict(dict);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		this.result="success";
        return "success";
    }

}