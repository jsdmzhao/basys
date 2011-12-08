package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IDict_itemDao;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.service.IDict_itemService;

@Component
public class Dict_itemServiceImpl implements IDict_itemService {
	private IDict_itemDao dict_item_dao;
	
	public void insertDict_item(Dict_item dict_item) {
		dict_item_dao.insertDict_item(dict_item);
	}

	public void deleteDict_item(Dict_item dict_item) {
		dict_item_dao.deleteDict_item(dict_item);
	}

	public void updateDict_item(Dict_item dict_item) {
		dict_item_dao.updateDict_item(dict_item);
	}

	public Dict_item getDict_item(Dict_item dict_item) {
		return dict_item_dao.getDict_item(dict_item);
	}

	public List getListForPage(Dict_item map, int pageNo, int pageSize,
			String sort, String desc) {
		return dict_item_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List getDropdownListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		return dict_item_dao.getDropdownListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List<Dict_item> getListDict_item(Dict_item dict_item) {
		return dict_item_dao.getListDict_item(dict_item);
	}

	public List<Dict_item> getOfflineDict_item(Dict dict) {
		return dict_item_dao.getOfflineDict_item(dict);
	}

	public List<Dict_item> getChildDict_itemListByItemIDAndDictCode(
			Dict_item dict_item) {
		return dict_item_dao.getChildDict_itemListByItemIDAndDictCode(dict_item);
	}

	public Dict_item deleteDictionaryItemTreeItem(Dict_item dict_item) {
		return null;
	}

	public Dict_item getDictionaryItemByDictCodeAndFactValue(Dict_item dict_item) {
		return dict_item_dao.getDictionaryItemByDictCodeAndFactValue(dict_item);
	}

	public Dict_item getParentDictionaryItemBySuperItemID(Dict_item dict_item) {
		return dict_item_dao.getParentDictionaryItemBySuperItemID(dict_item);
	}

	public List<Dict_item> getParentDictionaryItemListByDictCode(
			Dict_item dict_item) {
		return dict_item_dao.getParentDictionaryItemListByDictCode(dict_item);
	}

	public List getChildDictionaryItemListByItemID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getDIList(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDictItemNameByDcFv(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDictItemCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getDictionaryItemListByDictID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dict_item getDictionaryItemByDcAndFvAndSuperII(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateDict_itemEditEdOrder(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return false;
	}

	public Integer getNextNodeorder(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Resource(name="dict_itemDaoImpl")
	public void setDict_item_dao(IDict_itemDao dict_item_dao) {
		this.dict_item_dao = dict_item_dao;
	}



}
