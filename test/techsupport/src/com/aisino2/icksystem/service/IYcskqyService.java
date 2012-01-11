package com.aisino2.icksystem.service;

import java.util.Map;

import com.aisino2.core.dao.Page;

public interface IYcskqyService {

	/**
	 * 异常刷卡场所
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
