package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IZtxxDao;
import com.aisino2.basicsystem.domain.Ztxx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class ZtxxDaoImpl extends BaseDao implements IZtxxDao {
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {

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
				sCol = "decode(yxbjs,0,0,zts/yxbjs)";
				break;
			case 9:
				sCol = "decode(yxbjs,0,0,cjs/yxbjs)";
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
		return queryForPage("getZtxxList", map, pageNo, pageSize);
	}

	public Ztxx getZtxxTotalNum(Map map) {
		return (Ztxx) queryForObject("getZtxxTotalNum", map);
	}
	
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
}
