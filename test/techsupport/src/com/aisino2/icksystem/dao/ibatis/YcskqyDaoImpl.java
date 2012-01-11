package com.aisino2.icksystem.dao.ibatis;

import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IYcskqyDao;

public class YcskqyDaoImpl extends BaseDao implements IYcskqyDao {

	public Page getSkxx(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		
		return queryForPage("getSkxxList", map, pageNo,pageSize);
	}

	public Page getYcskqy(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		String sCol = " gxdwdm,qybm ";
		if (sort != null) {
		   if (sort.equals("1"))
				sCol = " qybm ";
			
		}
		if (desc != null)
			sCol += desc;
		else
			sCol += " asc";

		map.put("pageSort", sCol);
		return queryForPage("getYcskcsList", map, pageNo,pageSize);
	}

}
