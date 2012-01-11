package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IAsjglDao;
import com.aisino2.basicsystem.domain.Asjgl;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class AsjglDaoImpl extends BaseDao implements IAsjglDao {
	/**
	 * @param 案事件管理(t_asjgl)
	 *            增加
	 */
	public Asjgl insertAsjgl(Asjgl asjgl) {
		// TODO: implement
		asjgl.setAsjglid(getNextID("Asjglid"));
		return (Asjgl) insert("insertAsjgl", asjgl);
	}

	/**
	 * @param 案事件管理(t_asjgl)
	 *            删除
	 */
	public int deleteAsjgl(Asjgl asjgl) {
		// TODO: implement
		return delete("deleteAsjgl", asjgl);
	}

	/**
	 * @param 案事件管理(t_asjgl)
	 *            修改
	 */
	public int updateAsjgl(Asjgl asjgl) {
		// TODO: implement
		return update("updateAsjgl", asjgl);
	}

	/**
	 * @param 案事件管理(t_asjgl)
	 *            查询单条
	 */
	public Asjgl getAsjgl(Asjgl asjgl) {
		// TODO: implement
		return (Asjgl) queryForObject("getAsjgl", asjgl);
	}

	/**
	 * @param 案事件管理(t_asjgl)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		// TODO: implement

		String sCol = "a.Asjglid ";
		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.qymc ";
			else if (sort.equals("1"))
				sCol = "a.ajxz ";
			else if (sort.equals("2"))
				sCol = "a.ajlb ";
			else if (sort.equals("3"))
				sCol = "a.fasj ";
			else if (sort.equals("4"))
				sCol = "a.ssdwmc ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";
		map.put("pageSort", sCol);
		return queryForPage("getAsjglList", map, pageNo, pageSize);
	}

	/**
	 * @param 案事件管理(t_asjgl)
	 *            多条查询
	 */
	public List getListAsjgl(Asjgl asjgl) {
		// TODO: implement
		return queryForList("getAsjglListNoPage", asjgl);
	}
	
	//导出Excel
	public List getListExportAsjgl(Map map, String sort, String desc) {
		String sCol="a.fasj desc";
        		
		map.put("pageSort", sCol);
		return queryForList("getAsjglListExcel", map);
	}
}
