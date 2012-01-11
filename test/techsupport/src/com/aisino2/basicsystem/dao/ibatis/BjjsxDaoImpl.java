package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBjjsxDao;
import com.aisino2.basicsystem.domain.Bjjsx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BjjsxDaoImpl extends BaseDao implements IBjjsxDao {
	/**
	 * @param 报警机刷新(t_bjjsx)
	 *            增加
	 */
	public Bjjsx insertBjjsx(Bjjsx bjjsx) {
		// TODO: implement
		bjjsx.setBjjxh(getNextID("Bjjxh"));
		return (Bjjsx) insert("insertBjjsx", bjjsx);
	}

	/**
	 * @param 报警机刷新(t_bjjsx)
	 *            删除
	 */
	public int deleteBjjsx(Bjjsx bjjsx) {
		// TODO: implement
		return delete("deleteBjjsx", bjjsx);
	}

	/**
	 * @param 报警机刷新(t_bjjsx)
	 *            修改
	 */
	public int updateBjjsx(Bjjsx bjjsx) {
		// TODO: implement
		return update("updateBjjsx", bjjsx);
	}

	/**
	 * @param 报警机刷新(t_bjjsx)
	 *            查询单条
	 */
	public Bjjsx getBjjsx(Bjjsx bjjsx) {
		// TODO: implement
		return (Bjjsx) queryForObject("getBjjsx", bjjsx);
	}

	/**
	 * @param 报警机刷新(t_bjjsx)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
		// TODO: implement
		String sCol = "a.jyxxid ";
		if (sort != null) {
			int sortCol = Integer.valueOf(sort).intValue();

			switch (sortCol) {
			case 0:
				sCol = "a.GAJGBM ";
				break;
			case 1:
				sCol = "a.GAJGMC ";
				break;
			case 2:
				sCol = "a.BJJIPDZ ";
				break;
			case 3:
				sCol = "a.BJJSXJ ";
				break;
			case 4:
				sCol = "a.YSCSXSJDJG ";
				break;
			default:
				break;
			}
		} else {
			sCol = "a.BJJXH ";
		}
		
		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";
		
		map.put("pageSort", sCol);
		return queryForPage("getBjjsxList", map, pageNo, pageSize);
	}

	/**
	 * @param 报警机刷新(t_bjjsx)
	 *            多条查询
	 */
	public List getListBjjsx(Bjjsx bjjsx) {
		// TODO: implement
		return queryForList("getBjjsxListNoPage", bjjsx);
	}
}
