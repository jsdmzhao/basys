package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IPmtDao;
import com.aisino2.publicsystem.domain.Pmt;

public class PmtDaoImpl extends BaseDao implements IPmtDao {
	/** @param 平面图(t_pmt) 增加 */
	public Pmt insertPmt(Pmt pmt){
		// TODO: implement
		//pmt.setQyid(getNextID("Qyid"));
		pmt.setPmtid(getNextID("Pmtid"));
		insert("insertPmt", pmt);
		return pmt;
	}

	/** @param 平面图(t_pmt) 删除 */
	public int deletePmt(Pmt pmt){
		// TODO: implement
		return delete("deletePmt", pmt);
	}

	/** @param 平面图(t_pmt) 修改 */
	public int updatePmt(Pmt pmt){
		// TODO: implement
		return update("updatePmt", pmt);
	}

	/** @param 平面图(t_pmt) 查询单条 */
	public Pmt getPmt(Pmt pmt){
		// TODO: implement
		return (Pmt)queryForObject("getPmt", pmt);
	}
	
	/** @param 平面图(t_pmt) 查询单条 不查询BLOB*/
	public Pmt getPmtNoBlob(Pmt pmt){
		// TODO: implement
		return (Pmt)queryForObject("getPmtNoBlob", pmt);
	}

	/** @param 平面图(t_pmt) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getPmtList", map, pageNo,pageSize);
	}

	/** @param 平面图(t_pmt) 多条查询 */
	public List getListPmt(Pmt pmt){
		// TODO: implement
		return queryForList("getPmtListNoPage", pmt);
	}
}
