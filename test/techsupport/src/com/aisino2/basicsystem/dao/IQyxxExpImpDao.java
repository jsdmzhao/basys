package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.QyxxExpImp;
import com.aisino2.core.dao.Page;

public interface IQyxxExpImpDao {

	/** 企业信息 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 旅馆业信息 修改 */
	int updateLgyxx(QyxxExpImp qyxxExpImp);
	/** 旅馆业信息XML 查询 */
	List getListLgyXmlMes(QyxxExpImp qyxxExpImp);
	/** 旅馆业 xml数据查询 分页 */
	Page getListLgyXmlMesPage(Map map, int pageNo,int pageSize);
	
	/** 公共模块 修改 */
	int updatePubxx(QyxxExpImp qyxxExpImp);
	/** 公共模块XML 查询 */
	List getListPubXmlMes(QyxxExpImp qyxxExpImp);
	/** 公共模块XML 查询 分页 */
	Page getListPubXmlMesPage(Map map, int pageNo,int pageSize);
	
	/** 典当业 修改 */
	int updateDdyxx(QyxxExpImp qyxxExpImp);
	/** 典当业 查询 */
	List getListDdyXmlMes(QyxxExpImp qyxxExpImp);
	/** 典当业XML 查询 分页 */
	Page getListDdyXmlMesPage(Map map, int pageNo,int pageSize);
	
	/** 机修业 修改 */
	int updateJxyxx(QyxxExpImp qyxxExpImp);
	/** 机修业 查询 */
	List getListJxyXmlMes(QyxxExpImp qyxxExpImp);
	/** 机修业XML 查询 分页 */
	Page getListJxyXmlMesPage(Map map, int pageNo,int pageSize);
	
	/** 印章业 修改 */
	int updateYzyxx(QyxxExpImp qyxxExpImp);
	/** 印章业 查询 */
	List getListYzyXmlMes(QyxxExpImp qyxxExpImp);
	/** 印章业XML 查询 分页 */
	Page getListYzyXmlMesPage(Map map, int pageNo,int pageSize);
	
	/** 出租房屋业 修改 */
	int updateCzfwyxx(QyxxExpImp qyxxExpImp);
	/** 出租房屋业 查询 */
	List getListCzfwyXmlMes(QyxxExpImp qyxxExpImp);
	/** 出租房屋业XML 查询 分页 */
	Page getListCzfwyXmlMesPage(Map map, int pageNo,int pageSize);
	
	/** 企业授权表 添加 */
	void insertSjbdqxx(QyxxExpImp qyxxExpImp);
	/** 企业授权表 删除 */
	int deleteSjbdqxx(QyxxExpImp qyxxExpImp);
}
