package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQyxxExpImpDao;
import com.aisino2.basicsystem.domain.QyxxExpImp;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class QyxxExpImpDaoImpl extends BaseDao implements IQyxxExpImpDao {

	/** 企业信息 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		Page page = null;
		String pageQuery = "";
		String hylb = (String)map.get("hylbdm");
		if("A".equals(hylb)){ //旅馆业
			pageQuery = "getLgyQyxxList";
		}
		if("Z".equals(hylb)){ //出租房
			pageQuery = "getCzfwyQyxxList";
		}
		if("J".equals(hylb)||"E01".equals(hylb)||"E02".equals(hylb)||"E04".equals(hylb)||
				"F01".equals(hylb)||"F02".equals(hylb)||"C".equals(hylb)||"X".equals(hylb)||
				"E03".equals(hylb)||"B".equals(hylb)){
				//公用模块-J娱乐业、E01二手车、E02二手机、F01汽车出租、F02汽车租赁、E04废旧金属、C机修业、X剧毒、E03典当、B印章
			pageQuery = "getPublicQyxxList";
		}
		map.put("hylbdm", hylb);
		if(!"".equals(pageQuery)){
			page = queryForPage(pageQuery, map, pageNo,pageSize);
		}
		return page;
	}
	
	
	/** 旅馆业信息 修改 */
	public int updateLgyxx(QyxxExpImp qyxxExpImp){
		return update("updateLgyxx", qyxxExpImp);
	}
	/** 旅馆业信息XML 查询 */
	public List getListLgyXmlMes(QyxxExpImp qyxxExpImp){
		return queryForList("getLgyXmlMes", qyxxExpImp);
	}
	/** 旅馆业 xml数据查询 分页 */
	public Page getListLgyXmlMesPage(Map map, int pageNo,int pageSize){
		return queryForPage("getLgyXmlMesPage", map, pageNo,pageSize);
	}
	
	/** 公共模块 修改 */
	public int updatePubxx(QyxxExpImp qyxxExpImp){
		return update("updatePublicQyxx", qyxxExpImp);
	}
	/** 公共模块XML 查询 */
	public List getListPubXmlMes(QyxxExpImp qyxxExpImp){
		return queryForList("getPublicQyxxXmlMes", qyxxExpImp);
	}
	/** 公共模块XML 查询 分页 */
	public Page getListPubXmlMesPage(Map map, int pageNo,int pageSize){
		return queryForPage("getPublicQyxxXmlMesPage", map, pageNo,pageSize);
	}
	
	/** 典当业 修改 */
	public int updateDdyxx(QyxxExpImp qyxxExpImp){
		return update("updateDdyQyxx", qyxxExpImp);
	}
	/** 典当业 查询 */
	public List getListDdyXmlMes(QyxxExpImp qyxxExpImp){
		return queryForList("getDdyQyxxXmlMes", qyxxExpImp);
	}
	/** 典当业XML 查询 分页 */
	public Page getListDdyXmlMesPage(Map map, int pageNo,int pageSize){
		return queryForPage("getDdyQyxxXmlMesPage", map, pageNo,pageSize);
	}
	
	
	/** 机修业 修改 */
	public int updateJxyxx(QyxxExpImp qyxxExpImp){
		return update("updateJxyQyxx", qyxxExpImp);
	}
	/** 机修业 查询 */
	public List getListJxyXmlMes(QyxxExpImp qyxxExpImp){
		return queryForList("getJxyQyxxXmlMes", qyxxExpImp);
	}
	/** 机修业XML 查询 分页 */
	public Page getListJxyXmlMesPage(Map map, int pageNo,int pageSize){
		return queryForPage("getJxyQyxxXmlMesPage", map, pageNo,pageSize);
	}
	
	
	/** 印章业 修改 */
	public int updateYzyxx(QyxxExpImp qyxxExpImp){
		return update("updateYzyQyxx", qyxxExpImp);
	}
	/** 印章业 查询 */
	public List getListYzyXmlMes(QyxxExpImp qyxxExpImp){
		return queryForList("getYzyQyxxXmlMes", qyxxExpImp);
	}
	/** 印章业XML 查询 分页 */
	public Page getListYzyXmlMesPage(Map map, int pageNo,int pageSize){
		return queryForPage("getYzyQyxxXmlMesPage", map, pageNo,pageSize);
	}
	
	
	/** 出租房屋业 修改 */
	public int updateCzfwyxx(QyxxExpImp qyxxExpImp){
		return update("updateCzfwyQyxx", qyxxExpImp);
	}
	/** 出租房屋业 查询 */
	public List getListCzfwyXmlMes(QyxxExpImp qyxxExpImp){
		return queryForList("getCzfwyQyxxXmlMes", qyxxExpImp);
	}
	/** 出租房屋业XML 查询 分页 */
	public Page getListCzfwyXmlMesPage(Map map, int pageNo,int pageSize){
		return queryForPage("getCzfwyQyxxXmlMesPage", map, pageNo,pageSize);
	}
	
	
	/** 企业授权表 添加 */
	public void insertSjbdqxx(QyxxExpImp qyxxExpImp){
		insert("insertLicense", qyxxExpImp);
	}
	/** 企业授权表 删除 */
	public int deleteSjbdqxx(QyxxExpImp qyxxExpImp){
		return delete("deleteLicense", qyxxExpImp);
	}
	
}
