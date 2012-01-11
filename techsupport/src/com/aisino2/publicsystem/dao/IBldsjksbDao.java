package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Bldsjksb;
public interface IBldsjksbDao {
	/** @param 闭路电视监控设备(t_bldsjksb) 增加 */
	Bldsjksb insertBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 删除 */
	int deleteBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 修改 */
	int updateBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 查询单条 */
	Bldsjksb getBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 闭路电视监控设备(t_bldsjksb) 多条查询 */
	List getListBldsjksb(Bldsjksb bldsjksb);
	
	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 公安端闭路电视监控设备查询*/
	Page getBldsjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 公共 视频监控设备 公安端 分页查询 */
	Page getSpjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 闭路电视监控设备查询数量 */
	Integer getSpjksbCount(Bldsjksb bldsjksb);
}
