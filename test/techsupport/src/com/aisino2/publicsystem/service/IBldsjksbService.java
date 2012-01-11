package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Bldsjksb;

public interface IBldsjksbService {
	/** @param 闭路电视监控设备(t_bldsjksb) 增加 */
	Bldsjksb insertBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 删除 */
	boolean deleteBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 修改 */
	boolean updateBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 查询单条 */
	Bldsjksb getBldsjksb(Bldsjksb bldsjksb);

	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 闭路电视监控设备(t_bldsjksb) 多条查询 */
	List getListBldsjksb(Bldsjksb bldsjksb);
	
	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 公安端闭路电视监控设备查询 */
	Page getBldsjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 公共 视频监控设备 公安端 分页查询
	 * map 参数如下：
	 * deptCode	当前公安用户 去掉偶数个0的机构编码 必须
	 * hylbdm	行业类别代码	必须
	 * qybm		企业编码
	 * qymc		企业名称
	 * sbmc		设备名称
	 * sccsmc	设备生产商
	 * ggxh		规格型号
	 * ipdz		IP地址
	 * zt		状态  */
	Page getSpjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
