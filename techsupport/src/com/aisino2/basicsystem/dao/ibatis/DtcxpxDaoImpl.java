package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDtcxpxDao;
import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class DtcxpxDaoImpl extends BaseDao implements IDtcxpxDao {
	/** @param 动态查询排序(t_dtcxpx) 增加 */
	public Dtcxpx insertDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		dtcxpx.setDtcxpxid(getNextID("Dtcxpxid"));
		return (Dtcxpx)insert("insertDtcxpx", dtcxpx);
	}

	/** @param 动态查询排序(t_dtcxpx) 删除 */
	public int deleteDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return delete("deleteDtcxpx", dtcxpx);
	}

	/** @param 动态查询排序(t_dtcxpx) 修改 */
	public int updateDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return update("updateDtcxpx", dtcxpx);
	}

	/** @param 动态查询排序(t_dtcxpx) 查询单条 */
	public Dtcxpx getDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return (Dtcxpx)queryForObject("getDtcxpx", dtcxpx);
	}

	/** @param 动态查询排序(t_dtcxpx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Dtcxpxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDtcxpxList", map, pageNo,pageSize);
	}

	/** @param 动态查询排序(t_dtcxpx) 多条查询 */
	public List getListDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return queryForList("getDtcxpxListNoPage", dtcxpx);
	}
}
