package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IRcjcDao;
import com.aisino2.basicsystem.domain.TyRcjc;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class RcjcDaoImpl extends BaseDao implements IRcjcDao {
	/** @param 日常检查(t_tyrcjc) 增加 */
	public TyRcjc insertRcjc(TyRcjc rcjc){
		// TODO: implement
		rcjc.setRcjcid(getNextID("TyRcjcid"));
		insert("insertTyrcjc", rcjc);
		return rcjc;
	}

	/** @param 日常检查(t_tyrcjc) 删除 */
	public int deleteRcjc(TyRcjc rcjc){
		// TODO: implement
		return delete("deleteTyrcjc", rcjc);
	}

	/** @param 日常检查(t_tyrcjc) 修改 */
	public int updateRcjc(TyRcjc rcjc){
		// TODO: implement
		return update("updateTyrcjc", rcjc);
	}

	/** @param 日常检查(t_tyrcjc) 查询单条 */
	public TyRcjc getRcjc(TyRcjc rcjc){
		// TODO: implement
		return (TyRcjc)queryForObject("getTyrcjc", rcjc);
	}

	/** @param 日常检查(t_tyrcjc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.jcrq "+ desc;
			else if(sort.equals("1"))
				sCol = " a.qymc "+ desc;
			else if(sort.equals("2"))
				sCol = " a.jcrxm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.lsdw "+ desc;
			else
				sCol = " a.jcrq desc ";
		}else{
			sCol="a.jcrq desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getTyrcjcList", map, pageNo,pageSize);
	}

	/** @param 日常检查(t_tyrcjc) 多条查询 */
	public List getListRcjc(TyRcjc rcjc){
		// TODO: implement
		return queryForList("getTyrcjcListNoPage", rcjc);
	}
}
