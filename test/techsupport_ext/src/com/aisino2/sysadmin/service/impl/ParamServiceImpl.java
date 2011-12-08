package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IParamDao;
import com.aisino2.sysadmin.domain.Param;
import com.aisino2.sysadmin.service.IParamService;
@Component
public class ParamServiceImpl implements IParamService {
	private IParamDao param_dao;

	@Resource(name="paramDaoImpl")
	public void setParam_dao(IParamDao param_dao) {
		this.param_dao = param_dao;
	}

	public void insertParam(Param param) {
		param_dao.insertParam(param);
	}

	public void deleteParam(Param param) {
		param_dao.deleteParam(param);
	}

	public void updateParam(Param param) {
		param_dao.updateParam(param);
	}

	public Param getParam(Param param) {
		return param_dao.getParam(param);
	}

	public List getListForPage(Param map, int pageNo, int pageSize, String sort,
			String desc) {
		return param_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List<Param> getListParam(Param param) {
		return param_dao.getListParam(param);
	}
	
	
	

}
