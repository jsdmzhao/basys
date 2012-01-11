package com.aisino2.icksystem.dao;

import java.util.Map;

import com.aisino2.core.dao.Page;

public interface IYcskqyDao {

	/**
	 * 异常刷卡企业
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @param sort
	 * @param desc
	 * @return
	 */
	Page getYcskqy(Map map, int pageNo,int pageSize,String sort,String desc);
	/**
	 * 刷卡信息
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @param sort
	 * @param desc
	 * @return
	 */
	Page getSkxx(Map map, int pageNo,int pageSize,String sort,String desc);
}
