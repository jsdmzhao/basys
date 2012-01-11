package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQgztjxDao;
import com.aisino2.basicsystem.domain.Qgztjx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class QgztjxDaoImpl extends BaseDao implements IQgztjxDao {
	/**
	 * @param 全国在逃简项(t_qgztjx)
	 *            增加
	 */
	public Qgztjx insertQgztjx(Qgztjx qgztjx) {
		// TODO: implement
		qgztjx.setQgztjxid(getNextID("Qgztjxid"));
		return (Qgztjx) insert("insertQgztjx", qgztjx);
	}
	/**
	 * @param 全国在逃简项(t_qgztjx)
	 *            转换
	 */
	public int insertQgztjxIn() {
		// TODO: implement
		return update("InsertQgztjxIn", null);
	}
	
	/**
	 * @param 全国在逃简项临时表(t_qgztjx_lsb)
	 *            增加
	 */
	public Qgztjx insertQgztjxlsb(Qgztjx qgztjx) {
		// TODO: implement
		return (Qgztjx) insert("insertQgztjxlsb", qgztjx);
	}
	
	/**
	 * @param 全国在逃简项临时表(t_qgztjx_lsb)
	 *            删除
	 */
	public int deleteQgztjxlsb(Qgztjx qgztjx) {
		// TODO: implement
		return delete("deleteQgztjxlsb", qgztjx);
	}
	
	/**
	 * @param 全国在逃简项(t_qgztjx)
	 *            删除
	 */
	public int deleteQgztjx(Qgztjx qgztjx) {
		// TODO: implement
		return delete("deleteQgztjx", qgztjx);
	}

	/**
	 * @param 全国在逃简项(t_qgztjx)
	 *            修改
	 */
	public int updateQgztjx(Qgztjx qgztjx) {
		// TODO: implement
		return update("updateQgztjx", qgztjx);
	}

	/**
	 * @param 全国在逃简项(t_qgztjx)
	 *            查询单条
	 */
	public Qgztjx getQgztjx(Qgztjx qgztjx) {
		// TODO: implement
		return (Qgztjx) queryForObject("getQgztjx", qgztjx);
	}

	/**
	 * @param 全国在逃简项(t_qgztjx)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		// TODO: implement
		String sCol = "";
		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.xm ";
			else if (sort.equals("1"))
				sCol = "a.gmsfhm " + desc;
			else if (sort.equals("2"))
				sCol = "a.csrq " + desc;
			else if (sort.equals("3"))
				sCol = "a.xb " + desc;
			else if (sort.equals("4"))
				sCol = "a.hjd " + desc;
			else if (sort.equals("5"))
				sCol = "a.hjxxdz " + desc;
			else if (sort.equals("6"))
				sCol = "a.djrq " + desc;
			else if (sort.equals("7"))
				sCol = "a.tbbh " + desc;
			else
				sCol = "a.djrq desc";
		} else {
			sCol = "a.djrq desc";
		}

		map.put("pageSort", sCol);
		return queryForPage("getQgztjxList", map, pageNo, pageSize);
	}

	/**
	 * @param 全国在逃简项(t_qgztjx)
	 *            多条查询
	 */
	public List getListQgztjx(Qgztjx qgztjx) {
		// TODO: implement
		return queryForList("getQgztjxListNoPage", qgztjx);
	}
	public List getListExportQgztjx(Map map, String sort, String desc) {
		String sCol = "";
		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.xm " + desc;
			else if (sort.equals("1"))
				sCol = "a.gmsfhm " + desc;
			else if (sort.equals("2"))
				sCol = "a.csrq " + desc;
			else if (sort.equals("3"))
				sCol = "a.xb " + desc;
			else if (sort.equals("4"))
				sCol = "a.hjd " + desc;
			else if (sort.equals("5"))
				sCol = "a.hjxxdz " + desc;
			else if (sort.equals("6"))
				sCol = "a.djrq " + desc;
			else if (sort.equals("7"))
				sCol = "a.tbbh " + desc;
			else
				sCol = "a.djrq desc";
		}else {
			sCol = "a.djrq desc";
		}
		map.put("pageSort", sCol);
		return queryForList("getQgztjxListExcel",map);
	}
}
