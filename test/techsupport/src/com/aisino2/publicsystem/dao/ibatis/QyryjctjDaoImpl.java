package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyryjctjDao;
import com.aisino2.publicsystem.domain.Qyryjctj;

public class QyryjctjDaoImpl extends BaseDao implements IQyryjctjDao {
	/** @param 企业人员奖惩统计表(t_qyryjctj) 增加 */
	public Qyryjctj insertQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		qyryjctj.setQyryjctjid(getNextID("Qyryjctjid"));
		return (Qyryjctj)insert("insertQyryjctj", qyryjctj);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 删除 */
	public int deleteQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return delete("deleteQyryjctj", qyryjctj);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 修改 */
	public int updateQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return update("updateQyryjctj", qyryjctj);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 查询单条 */
	public Qyryjctj getQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return (Qyryjctj)queryForObject("getQyryjctj", qyryjctj);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "dsjgdm,fxjdm,gxdwdm ";
//		if (sort != null) {
//		   if (sort.equals("3"))
//				sCol = "jg ";
//			else if (sort.equals("4"))
//				sCol = "fk ";
//			else if (sort.equals("5"))
//				sCol = "jl ";
//			else if (sort.equals("6"))
//				sCol = "jlbfk ";
//			else if (sort.equals("7"))
//				sCol = "zjxszr ";
//			else if (sort.equals("8"))
//				sCol = "xqcjhqzcj ";
//			else if (sort.equals("9"))
//				sCol = "qtfklx ";
//		}
//		if (desc != null)
//			sCol += desc;
//		else
//			sCol += " desc";
		map.put("pageSort", sCol);
		return queryForPage("getQyryjctjList", map, pageNo,pageSize);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 多条查询 */
	public List getListQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return queryForList("getQyryjctjListNoPage", qyryjctj);
	}
}
