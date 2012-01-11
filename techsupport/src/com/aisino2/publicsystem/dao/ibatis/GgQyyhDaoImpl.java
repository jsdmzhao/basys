package com.aisino2.publicsystem.dao.ibatis;

import java.util.HashMap;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.publicsystem.dao.IGgQyyhDao;
import com.aisino2.publicsystem.domain.GgQyyh;



public class GgQyyhDaoImpl extends BaseDao implements IGgQyyhDao{

	
	//-------------------------------------------------//
	
	/** 同步增加典当企业员工用户 */
	public int insertQyYgyh(GgQyyh qyyh){
		Map map = new HashMap();
		map.put("ryid", qyyh.getRyid());
		this.getSqlMapClientTemplate().insert("insertGgQyYgyh", map);
		qyyh.setErrCode((Integer)map.get("errCode"));
		qyyh.setErrMsg(String.valueOf(map.get("errMsg")));
		return qyyh.getErrCode();
	}
	
	/** 同步修改典当企业员工用户 */
	public int updateQyYgyh(GgQyyh qyyh){
		Map map = new HashMap();
		map.put("ryid", qyyh.getRyid());
		this.getSqlMapClientTemplate().insert("updateGgQyYgyh", map);
		qyyh.setErrCode((Integer)map.get("errCode"));
		return qyyh.getErrCode();
	}
	
	/** 同步删除典当企业员工用户 */
	public int delQyYgyh(GgQyyh qyyh){
		Map map = new HashMap();
		map.put("ryid", qyyh.getRyid());
		this.getSqlMapClientTemplate().insert("delGgQyYgyh", map);
		qyyh.setErrCode((Integer)map.get("errCode"));
		return qyyh.getErrCode();
	}

	/** 同步注销典当企业员工用户 */
	public int zhuxQyYgyh(GgQyyh qyyh){
		Map map = new HashMap();
		map.put("ryid", qyyh.getRyid());
		map.put("isval", qyyh.getIsval());
		this.getSqlMapClientTemplate().insert("zhuxGgQyYgyh", map);
		qyyh.setErrCode((Integer)map.get("errCode"));
		return qyyh.getErrCode();
	}
	


}
