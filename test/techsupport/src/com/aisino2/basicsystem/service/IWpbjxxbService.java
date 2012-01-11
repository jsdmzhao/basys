package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.core.dao.Page;

public interface IWpbjxxbService {
	/** @param 物品报警信息表(t_wpbjxxb) 增加 */
	Wpbjxxb insertWpbjxxb(Wpbjxxb wpbjxxb);

	/** @param 物品报警信息表(t_wpbjxxb) 删除 */
	boolean deleteWpbjxxb(Wpbjxxb wpbjxxb);

	/** @param 物品报警信息表(t_wpbjxxb) 修改 */
	boolean updateWpbjxxb(Wpbjxxb wpbjxxb);
	
	/**
	 *  报警方法 车辆、手机
	 * @param Wpbjxxb 物品报警信息表，内含业务表相关字段（ddqyid、ddwpclid、ddwpsjid、wpmc、wpjp、wpqp、hphm、fdjhcl、sbdh、cjh、sjch）
	 * @param sfyx-物品类别,增加新的行业时，可增加如下注释说明：
	 * @param sfyx 1-典当车辆
	 * @param sfyx 2-典当手机
	 * @param sfyx 3-机修业车辆
	 * @param sfyx 4-公用车辆
	 * @param sfyx 
	 * @param sfyx 6-二手手机
	 * @param sfyx 
	 * @return int 1-比中，2-未比中
	 */
    int BaoJingCl(Wpbjxxb wpbjxxbIn,String wplb) throws Exception;

	/** @param 物品报警信息表(t_wpbjxxb) 查询单条 */
	Wpbjxxb getWpbjxxb(Wpbjxxb wpbjxxb);
	
	

	/** @param 物品报警信息表(t_wpbjxxb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 物品报警信息表(t_wpbjxxb) 多条查询 */
	List getListWpbjxxb(Wpbjxxb wpbjxxb);
	
	/** 物品报警
	 * 
	 *  报警方法 车辆、手机
	 * @param Wpbjxxb 物品报警信息表
	 * @param wplb-物品类别：1-典当业车辆，2-典当业手机，3-机修业车辆
	 * @return int 1-比中，2-未比中
	 */
    void BaoJingWp(Wpbjxxb wpbjxxbIn,Integer recordNum) throws Exception;
 
}
