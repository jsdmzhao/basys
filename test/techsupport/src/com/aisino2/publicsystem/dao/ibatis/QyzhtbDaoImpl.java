package com.aisino2.publicsystem.dao.ibatis;

import java.util.HashMap;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.publicsystem.dao.IQyzhtbDao;
import com.aisino2.publicsystem.domain.Qyzhtb;

public class QyzhtbDaoImpl extends BaseDao implements IQyzhtbDao {
	/** 同步增加企业用户 */
	public int insertQyzhtb(Qyzhtb qyzhtb) {
		// TODO: implement		
		Map map = new HashMap();
		map.put("qybm", qyzhtb.getQybm());
		this.getSqlMapClientTemplate().insert("insertQyzhtb", map);
		qyzhtb.setCwbz((Integer)map.get("cwbz"));
		return qyzhtb.getCwbz();
	}

	/** 同步注销企业用户 */
	public int deleteQyzhtb(Qyzhtb qyzhtb) {
		// TODO: implement		
		Map map = new HashMap();
		map.put("qybm", qyzhtb.getQybm());
		this.getSqlMapClientTemplate().insert("deleteQyzhtb", map);
		qyzhtb.setCwbz((Integer)map.get("cwbz"));
		qyzhtb.setCwxx((String)map.get("cwxx"));
		return qyzhtb.getCwbz();
	}
	
	/** @param 同步修改企业用户 */
	public int updateQyzhtb(Qyzhtb qyzhtb) {
		// TODO: implement		
		Map map = new HashMap();
		map.put("qybm", qyzhtb.getQybm());
		this.getSqlMapClientTemplate().insert("updateQyzhtb", map);
		qyzhtb.setCwbz((Integer)map.get("cwbz"));
		qyzhtb.setCwxx((String)map.get("cwxx"));
		return qyzhtb.getCwbz();
	}
}

