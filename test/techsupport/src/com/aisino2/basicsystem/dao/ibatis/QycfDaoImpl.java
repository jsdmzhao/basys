package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQycfDao;
import com.aisino2.basicsystem.domain.Qycf;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class QycfDaoImpl extends BaseDao implements IQycfDao {
	/**
	 * @param 企业处罚(t_qycf)
	 *            增加
	 */
	public Qycf insertQycf(Qycf qycf) {
		// TODO: implement
		qycf.setQycfid(getNextID("Qycfid"));
		return (Qycf) insert("insertQycf", qycf);
	}

	/**
	 * @param 企业处罚(t_qycf)
	 *            删除
	 */
	public int deleteQycf(Qycf qycf) {
		// TODO: implement
		return delete("deleteQycf", qycf);
	}

	/**
	 * @param 企业处罚(t_qycf)
	 *            修改
	 */
	public int updateQycf(Qycf qycf) {
		// TODO: implement
		return update("updateQycf", qycf);
	}

	/**
	 * @param 企业处罚(t_qycf)
	 *            查询单条
	 */
	public Qycf getQycf(Qycf qycf) {
		// TODO: implement
		return (Qycf) queryForObject("getQycf", qycf);
	}

	/**
	 * @param 企业处罚(t_qycf)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		// TODO: implement
		String sCol = "a.Qycfid ";

		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.qymc ";
			else if (sort.equals("1"))
				sCol = "a.cfjg ";
			else if (sort.equals("2"))
				sCol = "a.cfrq ";
			else if (sort.equals("3"))
				sCol = "a.djsj ";
			else if (sort.equals("4"))
				sCol = "a.ssdwmc ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		return queryForPage("getQycfList", map, pageNo, pageSize);
	}

	/**
	 * @param 企业处罚(t_qycf)
	 *            多条查询
	 */
	public List getListQycf(Qycf qycf) {
		// TODO: implement
		return queryForList("getQycfListNoPage", qycf);
	}

	public List getListExportQycf(Map map, String sort, String desc) {
		String sCol = "a.Qycfid ";

		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.qymc ";
			else if (sort.equals("1"))
				sCol = "a.cfjg ";
			else if (sort.equals("2"))
				sCol = "a.cfrq ";
			else if (sort.equals("3"))
				sCol = "a.djsj ";
			else if (sort.equals("4"))
				sCol = "a.ssdwmc ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		return queryForList("getQycfListExcel", map);
	}
}
