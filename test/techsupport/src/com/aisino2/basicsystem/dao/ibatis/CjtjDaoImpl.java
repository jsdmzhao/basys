package com.aisino2.basicsystem.dao.ibatis;

import java.util.Map;

import com.aisino2.basicsystem.dao.ICjtjDao;
import com.aisino2.basicsystem.domain.Cjtj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class CjtjDaoImpl extends BaseDao implements ICjtjDao {
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {

		String sCol = "PCS.DEPARTCODE, PCS.NODEORDER ";
		if (sort != null) {
			int sortCol = Integer.valueOf(sort).intValue();

			switch (sortCol) {
			case 0:
				sCol = "departname ";
				break;
			case 1:
				sCol = "jjzs ";
				break;
			case 2:
				sCol = "yxbjs ";
				break;
			case 3:
				sCol = "hfs ";
				break;
			case 4:
				sCol = "decode(yxbjs,0,0,hfs/yxbjs)";
				break;
			default:
				break;
			}
		} else {
			sCol = "PCS.DEPARTCODE, PCS.NODEORDER ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		return queryForPage("getCjtjList", map, pageNo, pageSize);
	}

	public Cjtj getCjtjTotalNum(Map map) {
		return (Cjtj) queryForObject("getCjtjTotalNum", map);
	}
}
