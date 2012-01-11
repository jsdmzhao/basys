package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Wgcyryxx;
public interface IWgcyryxxDao {
	/** @param 外国从业人员信息(t_wgcyryxx) 增加 */
	Wgcyryxx insertWgcyryxx(Wgcyryxx wgcyryxx);

	/** @param 外国从业人员信息(t_wgcyryxx) 删除 */
	int deleteWgcyryxx(Wgcyryxx wgcyryxx);

	/** @param 外国从业人员信息(t_wgcyryxx) 修改 */
	int updateWgcyryxx(Wgcyryxx wgcyryxx);

	/** @param 外国从业人员信息(t_wgcyryxx) 查询单条 */
	Wgcyryxx getWgcyryxx(Wgcyryxx wgcyryxx);

	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 外国从业人员信息(t_wgcyryxx) 多条查询 */
	List getListWgcyryxx(Wgcyryxx wgcyryxx);
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 人员查询、注销查询*/
	Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	Page getListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 企业人员查询*/
	Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param  外国从业人员信息(t_wgcyryxx) 分页查询  由场所ID或场所编码获得该场所下从业人员*/
	Page getCyryxxListByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
