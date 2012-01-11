package com.aisino2.basicsystem.dao.ibatis;

import java.util.Map;

import com.aisino2.basicsystem.dao.IJqhzlgyDao;
import com.aisino2.basicsystem.domain.Jqhzlgy;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class JqhzlgyDaoImpl extends BaseDao implements IJqhzlgyDao {
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {

		String sCol = "PCS.DEPARTCODE ";
		if (sort != null) {
			int sortCol = Integer.valueOf(sort).intValue();
			switch (sortCol) {
			case 0:
				sCol = "departname ";
				break;
			case 1:
				sCol = "bjzs ";
				break;
			case 2:
				sCol = "zhs ";
				break;
			case 3:
				sCol = "bdzhs ";
				break;
			case 4:
				sCol = "bszhs ";
				break;
			case 5:
				sCol = "kszhs ";
				break;
			default:
				break;
			}
		} else {
			sCol = "PCS.DEPARTCODE ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		return queryForPage("getJqhzlgyList", map, pageNo, pageSize);
	}

	public Jqhzlgy getJqhzlgyTotalNum(Map map) {
		return (Jqhzlgy) queryForObject("getJqhzlgyTotalNum", map);
	}
	/**
	public List getListZtxx(Map map,String sort,String desc){
		// TODO: implement
		String sCol = "PCS.DEPARTCODE, PCS.NODEORDER ";
		if (sort != null) {
			int sortCol = Integer.valueOf(sort).intValue();

			switch (sortCol) {
			case 0:
				sCol = "departname ";
				break;
			case 1:
				sCol = "bjzs ";
				break;
			case 2:
				sCol = "yxbjs ";
				break;
			case 3:
				sCol = "zts ";
				break;
			case 4:
				sCol = "lws ";
				break;
			case 5:
				sCol = "zhqgztrs ";
				break;
			case 6:
				sCol = "zhbdbkrs ";
				break;
			case 7:
				sCol = "bdbkydzhs ";
				break;
			case 8:
				sCol = "ztl ";
				break;
			case 9:
				sCol = "cjl ";
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
		return queryForList("getZtxxListNoPage", map);
	}
	**/
}
