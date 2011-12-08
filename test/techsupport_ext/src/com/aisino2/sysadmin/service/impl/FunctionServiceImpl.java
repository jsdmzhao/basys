package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IFunctionDao;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.service.IFunctionService;
@Component
public class FunctionServiceImpl implements IFunctionService {
	private IFunctionDao func_dao;
	public void insertFunction(Function function) {
		func_dao.insertFunction(function);
	}

	public void deleteFunction(Function function) {
		func_dao.deleteFunction(function);
	}

	public void updateFunction(Function function) {
		func_dao.updateFunction(function);
	}

	public Function getFunction(Function function) {
		return func_dao.getFunction(function);
	}

	public List getListForPage(Function map, int pageNo, int pageSize,
			String sort, String desc) {
		return func_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List<Function> getListFunction(Function function) {
		return func_dao.getListFunction(function);
	}

	public boolean checkFunction(Function function) {
		return func_dao.checkFunction(function);
	}

	public boolean findFuncDefine(Function function) {
		return func_dao.findFuncDefine(function);
	}

	public List<Function> getOwnFunction(Function function) {
		return func_dao.getOwnFunction(function);
	}

	public List getParam(Function function) {
		return null;
	}

	@Resource(name="functionDaoImpl")
	public void setFunc_dao(IFunctionDao func_dao) {
		this.func_dao = func_dao;
	}

}
