package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IDictDao;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.service.IDictService;
import com.aisino2.sysadmin.service.IDict_itemService;

public class DictServiceImpl extends BaseService implements IDictService {

	private IDictDao dictDao;
	private IDict_itemService dict_itemService;

	/** @param 字典(t_dict) 增加*/
	public Dict insertDict(Dict dict){
		// TODO: implement
		return (Dict)dictDao.insertCacheDict(dict);
	}
	
	/** @param 字典(t_dict) 删除*/
	public boolean deleteDict(Dict dict){
		// TODO: implement
		//return dictDao.deleteDict(dict)>0;
		boolean isSuccess = false;
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(dict.getDict_code());
		dict_itemService.deleteDict_item(dict_item);
		dictDao.deleteCacheDict(dict);
		isSuccess = true;
		return isSuccess;
	}

	/** @param 字典(t_dict) 修改 内存*/
	public boolean updateDict(Dict dict){
		// TODO: implement
		return dictDao.updateCacheDict(dict)>0;
	}

	/** @param 字典(t_dict) 查询单条 */
	public Dict getDict(Dict dict){
		// TODO: implement
		return (Dict)dictDao.getDict(dict);
	}

	/** @param 字典(t_dict) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
	
		Page page =  dictDao.getListForPage(map,pageNo,pageSize,sort,desc);
		List lst = page.getData();
		Dict dictionary = null;
	    String dictType = null;
		for(int i=0;i<lst.size();i++){
		    dictionary = (Dict)lst.get(i);
		    if(dictionary != null){
			    dictType = dictionary.getDict_type();
			    if(dictType != null && dictType.trim().length() >0){
				    if(dictType.equals("01"))dictionary.setDict_type("简单");				    
				    if(dictType.equals("02"))dictionary.setDict_type("树状");				   
				    if(dictType.equals("11"))dictionary.setDict_type("联动");
			    }
		    }			
		}
		
		return page;
	}

	/** @param 字典(t_dict) 多条查询 */
	public List getListDict(Dict dict){
		// TODO: implement
		return dictDao.getListDict(dict);
	}

	public IDictDao getDictDao() {
		return dictDao;
	}

	public void setDictDao(IDictDao dictDao) {
		this.dictDao = dictDao;
	}

	public List getChildrenDictionary(Dict dict) {
		// TODO Auto-generated method stub
		return dictDao.getDictionaryAll(dict);
	}

	public List getDictionaryAll(Dict dict) {
		// TODO Auto-generated method stub
		return dictDao.getChildrenDictionary(dict);
	}
	public IDict_itemService getDict_itemService() {
		return dict_itemService;
	}
	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
}
