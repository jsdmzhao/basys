package com.aisino2.cache;

import java.util.ArrayList;
import java.util.List;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;

public class CacheResult {
	public List getCacheList(String sCache,String sColumn,String sDictCode,String sCacheType ){
		List lCacheList=new ArrayList();
		lCacheList.add(sCache);
		lCacheList.add(sColumn);
		lCacheList.add(sDictCode);
		lCacheList.add(sCacheType);
		return lCacheList;
	}
	//全部字典明细
	public List getCacheAllDictItem(String sColumn,String sDictCode,String sCacheType ){
		return getCacheList("dict_item",sColumn,sDictCode,sCacheType);
	}
	//全部字典
	public List getCacheAllDict(String sColumn,String sDictCode,String sCacheType ){
		return getCacheList("dict",sColumn,sDictCode,sCacheType);
	}
	//全部部门
	public List getCacheAllDepartment(String sColumn,String sDictCode,String sCacheType ){
		return getCacheList("department",sColumn,sDictCode,sCacheType);
	}
	//全部全局参数
	public List getCacheAllGlobalpar(String sColumn,String sDictCode,String sCacheType ){
		return getCacheList("globalpar",sColumn,sDictCode,sCacheType);
	}
	//单条字典明细
	public Dict_item getCacheDictItem(String sDictCode,String sFactValue,String item_allpin,
		String item_simplepin,Integer super_item_id){
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(sDictCode);
		dict_item.setFact_value(sFactValue);
		dict_item.setItem_allpin(item_allpin);
		dict_item.setItem_simplepin(item_simplepin);
		dict_item.setSuper_item_id(super_item_id);
		List dictitemList = new ArrayList();
		dictitemList=CacheManager.getCacheDictitem(dict_item);
		if (dictitemList.size()==1)
			return (Dict_item)dictitemList.get(0);
		else 
			return null;
	}
	//字典明细多条
	public List getCacheListDictItem(String sDictCode,Integer super_item_id){
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(sDictCode);
		dict_item.setSuper_item_id(super_item_id);
		List dictitemList = new ArrayList();
		dictitemList=CacheManager.getCacheDictitem(dict_item);
		return dictitemList;
	}
	//单条字典
	public Dict getCacheDict(String sDictCode,String dict_allpin,String dict_simplepin,String dict_type,String super_dict_code){
		Dict dict = new Dict();
		dict.setDict_code(sDictCode);
		dict.setDict_allpin(dict_allpin);
		dict.setDict_simplepin(dict_simplepin);
		dict.setDict_type(dict_type);
		dict.setSuper_dict_code(super_dict_code);
		List dictList = new ArrayList();
		dictList=CacheManager.getCacheDict(dict);
		if (dictList.size()==1)
			return (Dict)dictList.get(0);
		else 
			return null;
	}
	//字典多条
	public List getCacheListDict(String super_dict_code){
		Dict dict = new Dict();
		dict.setSuper_dict_code(super_dict_code);
		List dictList = new ArrayList();
		dictList=CacheManager.getCacheDict(dict);
		return dictList;
	}
	//单条部门
	public Department getCacheDepartment(String departcode,String departallpin,String departsimplepin,String departbrevitycode,Integer parentdepartid){
		Department department = new Department();
		department.setDepartcode(departcode);
		department.setDepartallpin(departallpin);
		department.setDepartsimplepin(departsimplepin);
		department.setDepartbrevitycode(departbrevitycode);
		department.setParentdepartid(parentdepartid);
		List departmentList = new ArrayList();
		departmentList=CacheManager.getCacheDepartment(department);
		if (departmentList.size()==1)
			return (Department)departmentList.get(0);
		else 
			return null;
	}
	//部门
	public List getCacheListDepartment(Integer parentdepartid){
		Department department = new Department();
		department.setParentdepartid(parentdepartid);
		List departmentList = new ArrayList();
		departmentList=CacheManager.getCacheDepartment(department);
		return departmentList;
	}
	//单条全局参数
	public Globalpar getCacheGlobalpar(String globalparcode){
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode(globalparcode);
		List globalparList = new ArrayList();
		globalparList=CacheManager.getCacheGlobalpar(globalpar);
		if (globalparList.size()==1)
			return (Globalpar)globalparList.get(0);
		else 
			return null;
	}
}
