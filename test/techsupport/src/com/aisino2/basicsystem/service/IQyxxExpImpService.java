package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.QyxxExpImp;
import com.aisino2.core.dao.Page;

public interface IQyxxExpImpService {

	/** 企业信息 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 企业信息 全部 导出 */
	boolean updateExpAllQxx(QyxxExpImp qyxxExpImp) throws Exception;
	
	/** 企业信息 部分 导出 */
	boolean updateExpBufenQyxx(String[] qyidArr,String hylbdm) throws Exception;
	
	List getListLgyXmlMes(QyxxExpImp qyxxExpImp);
	
	String uploadXmlMessage(List listNode) throws Exception;
}
