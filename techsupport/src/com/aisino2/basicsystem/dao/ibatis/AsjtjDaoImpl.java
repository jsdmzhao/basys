package com.aisino2.basicsystem.dao.ibatis;

import java.util.Map;

import com.aisino2.basicsystem.dao.IAsjtjDao;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class AsjtjDaoImpl extends BaseDao implements IAsjtjDao {

	public Page getAsjtjList(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		String sCol = "dsjgdm,fxjdm,gxdwdm,qybm ";
		
		map.put("pageSort", sCol);
		return queryForPage("getAsjtjList", map, pageNo,pageSize);
	}

}
