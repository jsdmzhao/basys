package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQycftjDao;
import com.aisino2.basicsystem.domain.Qycftj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class QycftjDaoImpl extends BaseDao implements IQycftjDao {
	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            增加
	 */
	public Qycftj insertQycftj(Qycftj qycftj) {
		// TODO: implement
		qycftj.setQycftjid(getNextID("Qycftjid"));
		return (Qycftj) insert("insertQycftj", qycftj);
	}

	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            删除
	 */
	public int deleteQycftj(Qycftj qycftj) {
		// TODO: implement
		return delete("deleteQycftj", qycftj);
	}

	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            修改
	 */
	public int updateQycftj(Qycftj qycftj) {
		// TODO: implement
		return update("updateQycftj", qycftj);
	}

	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            查询单条
	 */
	public Qycftj getQycftj(Qycftj qycftj) {
		// TODO: implement
		return (Qycftj) queryForObject("getQycftj", qycftj);
	}

	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		String sCol = " ";
		boolean csbz = false;
		if (map.get("csbz") != null) {
			csbz = ((String) map.get("csbz")).equalsIgnoreCase("1");
		}
		if (csbz) {
			if (sort == null || sort.equals(""))
				sort = "6";
		} else {
			if (sort == null || sort.equals(""))
				sort = "0";
		}
		if (sort != null) {
			if (sort.equals("0"))
				sCol = " z.jgcs " + desc;
			else if (sort.equals("1"))
				sCol = " z.fmcs " + desc;
			else if (sort.equals("2"))
				sCol = " z.tdcs " + desc;
			else if (sort.equals("3"))
				sCol = " z.zjcs " + desc;
			else if (sort.equals("4"))
				sCol = " z.qtfmcs " + desc;
			else if (sort.equals("5"))
				sCol = " z.xiaoji " + desc;
			else if (sort.equals("6"))
				sCol = " z.csbm " + desc;
		}
		map.put("pageSort", sCol);
		return queryForPage("getQycftjList", map, pageNo, pageSize);
	}

	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            多条查询
	 */
	public List getListQycftj(Qycftj qycftj) {
		// TODO: implement
		return queryForList("getQycftjListNoPage", qycftj);
	}

	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            分页查询 all
	 */
	public Page getListForPageAlldw(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		String sCol = " ";
		boolean csbz = false;
		if (map.get("csbz") != null) {
			csbz = ((String) map.get("csbz")).equalsIgnoreCase("1");
		}
		if (csbz) {
			if (sort == null || sort.equals(""))
				sort = "6";
		} else {
			if (sort == null || sort.equals(""))
				sort = "0";
		}

		if (sort != null) {
			if (sort.equals("0"))
				sCol = " PCS.DEPARTCODE ";
			else if (sort.equals("1"))
				sCol = " xiaoji ";
			else if (sort.equals("2"))
				sCol = " jgcs ";
			else if (sort.equals("3"))
				sCol = " fmcs ";
			else if (sort.equals("4"))
				sCol = " tdcs ";
			else if (sort.equals("5"))
				sCol = " zjcs ";
			else if (sort.equals("6"))
				sCol = " qtfmcs ";
		} else {
			sCol = "PCS.DEPARTCODE  ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		return queryForPage("getQycftjListyzy", map, pageNo, pageSize);
	}

	public Qycftj getQycftjTotalNum(Map map) {

		return (Qycftj) queryForObject("getQycftjTotalNum", map);
	}

	/**
	 * @param 企业处罚统计表(t_qycftj)
	 *            分页查询--标准化
	 */
	public Page getListForPageBzh(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		String sCol = "dsjgdm,fxjdm,gxdwdm ";
/*		boolean csbz = false;
		if (desc == null|| desc.equals(""))
			desc= " desc";
		
		if (map.get("csbz") != null) {
			csbz = ((String) map.get("csbz")).equalsIgnoreCase("1");
		}
		if (csbz) {
			if (sort == null || sort.equals(""))
				sort = "0";
			if (sort.equals("0"))
				sCol = " csbm " + desc;
			else if (sort.equals("1"))
				sCol = " csbm " + desc;
			else if (sort.equals("2"))
				sCol = " jczsT " + desc;
			else if (sort.equals("3"))
				sCol = " cfzsT " + desc;
			else if (sort.equals("4"))
				sCol = " jlzsT " + desc;
			else if (sort.equals("5"))
				sCol = " jczs " + desc;
			else if (sort.equals("6"))
				sCol = " cfzs " + desc;
			else if (sort.equals("7"))
				sCol = " jgcs " + desc;
			else if (sort.equals("8"))
				sCol = " fmcs " + desc;
			else if (sort.equals("9"))
				sCol = " tdcs " + desc;
			else if (sort.equals("10"))
				sCol = " zjcs " + desc;
			else if (sort.equals("11"))
				sCol = " qtfmcs " + desc;
			else if (sort.equals("12"))
				sCol = " jlzs " + desc;
			else if (sort.equals("13"))
				sCol = " tbbycs " + desc;
			else if (sort.equals("14"))
				sCol = " wzjlcs " + desc;
			else if (sort.equals("15"))
				sCol = " qtjlcs " + desc;
		} else {
			if (sort == null || sort.equals(""))
				sort = "1";
			if (sort.equals("1"))
				sCol = " jczsT " + desc;
			else if (sort.equals("2"))
				sCol = " cfzsT " + desc;
			else if (sort.equals("3"))
				sCol = " jlzsT " + desc;
			else if (sort.equals("4"))
				sCol = " jczs " + desc;
			else if (sort.equals("5"))
				sCol = " cfzs " + desc;
			else if (sort.equals("6"))
				sCol = " jgcs " + desc;
			else if (sort.equals("7"))
				sCol = " fmcs " + desc;
			else if (sort.equals("8"))
				sCol = " tdcs " + desc;
			else if (sort.equals("9"))
				sCol = " zjcs " + desc;
			else if (sort.equals("10"))
				sCol = " qtfmcs " + desc;
			else if (sort.equals("11"))
				sCol = " jlzs " + desc;
			else if (sort.equals("12"))
				sCol = " tbbycs " + desc;
			else if (sort.equals("13"))
				sCol = " wzjlcs " + desc;
			else if (sort.equals("14"))
				sCol = " qtjlcs " + desc;
		}*/
		map.put("pageSort", sCol);
		return queryForPage("getQycftjListBzh", map, pageNo, pageSize);
	}
}
