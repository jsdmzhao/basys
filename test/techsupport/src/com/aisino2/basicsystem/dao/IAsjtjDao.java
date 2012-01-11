package com.aisino2.basicsystem.dao;

import java.util.Map;

import com.aisino2.core.dao.Page;

public interface IAsjtjDao {

	/**
	 * 按事件统计
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @param sort
	 * @param desc
	 * @return
	 */
	public Page getAsjtjList(Map map, int pageNo, int pageSize, String sort,
			String desc);
}
