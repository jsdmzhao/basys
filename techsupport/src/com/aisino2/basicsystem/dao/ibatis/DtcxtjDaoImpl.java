package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDtcxtjDao;
import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class DtcxtjDaoImpl extends BaseDao implements IDtcxtjDao {
	/** @param 动态查询条件(t_dtcxtj) 增加 */
	public Dtcxtj insertDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		dtcxtj.setDtcxtjid(getNextID("Dtcxtjid"));
		return (Dtcxtj)insert("insertDtcxtj", dtcxtj);
	}

	/** @param 动态查询条件(t_dtcxtj) 删除 */
	public int deleteDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return delete("deleteDtcxtj", dtcxtj);
	}

	/** @param 动态查询条件(t_dtcxtj) 修改 */
	public int updateDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return update("updateDtcxtj", dtcxtj);
	}

	/** @param 动态查询条件(t_dtcxtj) 查询单条 */
	public Dtcxtj getDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return (Dtcxtj)queryForObject("getDtcxtj", dtcxtj);
	}

	/** @param 动态查询条件(t_dtcxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Dtcxtjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDtcxtjList", map, pageNo,pageSize);
	}

	/** @param 动态查询条件(t_dtcxtj) 多条查询 */
	public List getListDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return queryForList("getDtcxtjListNoPage", dtcxtj);
	}
}
