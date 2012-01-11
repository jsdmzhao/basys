package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Yjxxb;
import com.aisino2.core.dao.Page;

public interface IYjxxbService {
	/**
	 * @param 预警信息表
	 *            (t_yjxxb) 增加
	 */
	Yjxxb insertYjxxb(Yjxxb yjxxb);

	/**
	 * @param 预警信息表
	 *            (t_yjxxb) 删除
	 */
	boolean deleteYjxxb(Yjxxb yjxxb);

	/**
	 * @param 预警信息表
	 *            (t_yjxxb) 修改
	 */
	boolean updateYjxxb(Yjxxb yjxxb);

	/**
	 * @param 预警信息表
	 *            (t_yjxxb) 查询单条
	 */
	Yjxxb getYjxxb(Yjxxb yjxxb);

	/**
	 * @param 预警信息表
	 *            (t_yjxxb) 分页查询
	 */
	Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc);

	/**
	 * @param 预警信息表
	 *            (t_yjxxb) 多条查询
	 */
	List getListYjxxb(Yjxxb yjxxb);

	/** 预警信息表(t_yjxxb) 关注对象比对报警增加 */
	List<Yjxxb> getListYjxxbBDBJ(Yjxxb yjxxb);
	
	/**
	 * @param 预警信息表
	 *            (t_yjxxb) 比对报警增加
	 */
	Yjxxb insertYjxxbBDBJ(Yjxxb yjxxb);
}
