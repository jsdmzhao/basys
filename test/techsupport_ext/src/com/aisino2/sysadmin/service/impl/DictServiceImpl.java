package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IDictDao;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.service.IDictService;

@Component
public class DictServiceImpl implements IDictService {
	private IDictDao dict_dao;
	
	public void insertDict(Dict dict) {
		dict_dao.insertDict(dict);
	}

	public void deleteDict(Dict dict) {
		dict_dao.deleteDict(dict);
	}

	public void updateDict(Dict dict) {
		dict_dao.updateDict(dict);
	}

	public Dict getDict(Dict dict) {
		return dict_dao.getDict(dict);
	}

	public List getListForPage(Dict map, int pageNo, int pageSize, String sort,
			String desc) {
		return dict_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List<Dict> getListDict(Dict dict) {
		return dict_dao.getListDict(dict);
	}

	public List<Dict> getDictionaryAll(Dict dict) {
		return dict_dao.getDictionaryAll(dict);
	}

	public List<Dict> getChildrenDictionary(Dict dict) {
		return dict_dao.getChildrenDictionary(dict);
	}

	@Resource(name="dictDaoImpl")
	public void setDict_dao(IDictDao dict_dao) {
		this.dict_dao = dict_dao;
	}

}
