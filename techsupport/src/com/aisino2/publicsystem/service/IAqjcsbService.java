package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Aqjcsb;

public interface IAqjcsbService {
	/** @param 安全检查设备(t_aqjcsb) 增加 */
	Aqjcsb insertAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 删除 */
	boolean deleteAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 修改 */
	boolean updateAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 查询单条 */
	Aqjcsb getAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 安全检查设备(t_aqjcsb) 多条查询 */
	List getListAqjcsb(Aqjcsb aqjcsb);
	
	/** @param 安全检查设备(t_aqjcsb) 分页查询  安全检查设备信息查询*/
	Page getAqjcsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 公共 技防设备 公安端 分页查询
	 * map 参数如下：
	 * deptCode	当前公安用户 去掉偶数个0的机构编码 必须
	 * hylbdm	行业类别代码	必须
	 * qybm		企业编码
	 * qymc		企业名称
	 * sbmc		设备名称
	 * ggxh		规格型号
	 * aqjcsbzlbm	技防设备种类编码
	 * zt		状态  */
	Page getjfsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
