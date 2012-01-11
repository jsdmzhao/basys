package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkryDao;
import com.aisino2.basicsystem.domain.Bkry;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BkryDaoImpl extends BaseDao implements IBkryDao {
	/**
	 * @param 布控人员(t_bkry)
	 *            增加
	 */
	public Bkry insertBkry(Bkry bkry) {
		// TODO: implement
		bkry.setBkryid(getNextID("Bkryid"));
		return (Bkry) insert("insertBkry", bkry);
	}

	/**
	 * @param 布控人员(t_bkry)
	 *            删除
	 */
	public int deleteBkry(Bkry bkry) {
		// TODO: implement
		return delete("deleteBkry", bkry);
	}

	/**
	 * @param 布控人员(t_bkry)
	 *            修改
	 */
	public int updateBkry(Bkry bkry) {
		// TODO: implement
		return update("updateBkry", bkry);
	}

	/**
	 * @param 布控人员(t_bkry)
	 *            查询单条
	 */
	public Bkry getBkry(Bkry bkry) {
		// TODO: implement
		return (Bkry) queryForObject("getBkry", bkry);
	}

	/**
	 * @param 布控人员(t_bkry)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		// TODO: implement
		String sCol = "a.Bkryid ";
		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.xm ";
			else if (sort.equals("1"))
				sCol = "a.gmsfhm ";
			else if (sort.equals("2"))
				sCol = "a.csrq ";
			else if (sort.equals("3"))
				sCol = "a.xb ";
			else if (sort.equals("4"))
				sCol = "a.minzu ";
			else if (sort.equals("5"))
				sCol = "a.jg ";
			else if (sort.equals("6"))
				sCol = "a.bkfw ";
			else if (sort.equals("7"))
				sCol = "a.bkczsj ";
			else if (sort.equals("8"))
				sCol = "a.bkdqsj ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";
		map.put("pageSort", sCol);
		return queryForPage("getBkryList", map, pageNo, pageSize);
	}

	/**
	 * @param 布控人员(t_bkry)
	 *            多条查询
	 */
	public List getListBkry(Bkry bkry) {
		// TODO: implement
		return queryForList("getBkryListNoPage", bkry);
	}

	public int validateZjhm(Bkry bkry) {
		// TODO Auto-generated method stub
		return ((Integer) queryForObject("validateGmsfhm", bkry)).intValue();
	}
	/**境外布控人员，涉及到点表头排序的问题，故要重写*/
	public Page getJwListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
//		 TODO: implement
		String sCol = "a.Bkryid ";
		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.zwm ";
			else if (sort.equals("1"))
				sCol = "a.ywm ";
			else if (sort.equals("2"))
				sCol = "a.ywx ";
			else if (sort.equals("3"))
				sCol = "a.zjhm ";
			else if (sort.equals("4"))
				sCol = "a.csrq ";
			else if (sort.equals("5"))
				sCol = "a.xb ";
			else if (sort.equals("6"))
				sCol = "a.gj ";
			else if (sort.equals("7"))
				sCol = "a.bkfw ";
			else if (sort.equals("8"))
				sCol = "a.bkczsj ";
			else if (sort.equals("9"))
				sCol = "a.bkdqsj ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";
		map.put("pageSort", sCol);
		return queryForPage("getBkryList", map, pageNo, pageSize);
	}

}
