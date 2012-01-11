package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyyyrztjDao;
import com.aisino2.publicsystem.domain.Qyyyrztj;

public class QyyyrztjDaoImpl extends BaseDao implements IQyyyrztjDao {
	/** @param 企业营业日志统计(t_qyyyrztj) 增加 */
	public Qyyyrztj insertQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		qyyyrztj.setQyid(getNextID("Qyid"));
		return (Qyyyrztj)insert("insertQyyyrztj", qyyyrztj);
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 删除 */
	public int deleteQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		return delete("deleteQyyyrztj", qyyyrztj);
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 修改 */
	public int updateQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		return update("updateQyyyrztj", qyyyrztj);
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 查询单条 */
	public Qyyyrztj getQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		return (Qyyyrztj)queryForObject("getQyyyrztj", qyyyrztj);
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 统计查询 */
	public Page getListForPagetj(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="dsjgdm,fxjdm,gxdwdm";
		map.put("pageSort", sCol);
		return queryForPage("getQyyyrztjListtj", map, pageNo,pageSize);
	}
	
	/** @param 企业营业日志统计(t_qyyyrztj) 统计查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="tjrq desc";
		map.put("pageSort", sCol);
		return queryForPage("getQyyyrztjList", map, pageNo,pageSize);
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 多条查询 */
	public List getListQyyyrztj(Map map){
		// TODO: implement
		return queryForList("getQyyyrztjListNoPage", map);
	}
	
	/** @param 企业营业日志统计(t_qyyyrztj) 统计查询 */
	public Page getrzmxList(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = "a.tjrq "+ desc;
			else if(sort.equals("1"))
				sCol = "a.qymc "+ desc;
			else if(sort.equals("2"))
				sCol = "a.qybm "+ desc;
			else if(sort.equals("3"))
				sCol = "b.zrs "+ desc;
			else if(sort.equals("4"))
				sCol = "b.lxdh "+ desc;
			else if(sort.equals("5"))
				sCol = "b.qyzflbm "+ desc;
			else if(sort.equals("6"))
				sCol = "b.yyztdm "+ desc;
			else if(sort.equals("7"))
				sCol = "b.zabdm "+ desc;
			else
				sCol = "tjrq desc,qybm";
		}else{
				sCol = "tjrq desc,qybm";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyyyrzmxList", map, pageNo,pageSize);
	}
}
