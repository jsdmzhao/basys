package com.aisino2.basicsystem.dao;

import java.util.Map;

import com.aisino2.basicsystem.domain.Cjtj;
import com.aisino2.core.dao.Page;

public interface ICjtjDao {
	Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc);

	Cjtj getCjtjTotalNum(Map map);
}
