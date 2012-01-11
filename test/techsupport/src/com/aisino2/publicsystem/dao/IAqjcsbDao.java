package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Aqjcsb;
public interface IAqjcsbDao {
	/** @param 安全检查设备(t_aqjcsb) 增加 */
	Aqjcsb insertAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 删除 */
	int deleteAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 修改 */
	int updateAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 查询单条 */
	Aqjcsb getAqjcsb(Aqjcsb aqjcsb);

	/** @param 安全检查设备(t_aqjcsb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 安全检查设备(t_aqjcsb) 多条查询 */
	List getListAqjcsb(Aqjcsb aqjcsb);
	
	/** @param 安全检查设备(t_aqjcsb) 分页查询  安全检查设备信息查询*/
	Page getAqjcsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 公共 技防设备 公安端 分页查询 */
	Page getjfsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 技防设备查询数量 */
	Integer getJfsbCount(Aqjcsb aqjcsb);
}
