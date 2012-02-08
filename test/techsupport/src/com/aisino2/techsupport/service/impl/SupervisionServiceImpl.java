package com.aisino2.techsupport.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.dao.ISupervisionDao;
import com.aisino2.techsupport.domain.Supervision;
import com.aisino2.techsupport.service.ISupervisionService;

@Component("SupervisionServiceImpl")
public class SupervisionServiceImpl implements ISupervisionService {

	private ISupervisionDao supervision_dao;
	
	@Resource(name="SupervisionDaoImpl")
	public void setSupervision_dao(ISupervisionDao supervision_dao) {
		this.supervision_dao = supervision_dao;
	}

	public void insert_supervision(Supervision supervision) {
		this.supervision_dao.insert(supervision);
	}

	public Page query_supervision_for_page(Map map, int pageno, int pagesize,
			String dir, String sort) {
		return this.supervision_dao.query_for_page(map, pageno, pagesize, dir, sort);
	}

	public Supervision get_supervision(Supervision supervision) {
		if(supervision.getId()==null)
			throw new RuntimeException("督办ID不能为空");
		return this.supervision_dao.get(supervision);
	}

}
