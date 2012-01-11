package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.core.dao.Page;
public interface IBjxxbDao {
	/** @param 报警信息表(t_bjxxb) 增加 */
	Bjxxb insertBjxxb(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 删除 */
	int deleteBjxxb(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 修改 */
	int updateBjxxb(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 查询单条 */
	Bjxxb getBjxxb(Bjxxb bjxxb);
	
	/** @param 报警信息表(t_bjxxb) 查询快照表名称 */
	Map getKzbmc(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 报警信息表(t_bjxxb) 多条查询 */
	List getListBjxxb(Bjxxb bjxxb);
	
	/** @param 报警信息表(t_bjxxb) 分页查询 主页面 */
	Page getMainListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	List getListExportBjxxb(Map map, String sort, String dir);
	
	/** @param 报警信息表(t_bjxxb) 分页查询 报警客户端得页面 */
	Page getClientListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 报警信息表(t_bjxxb)条数 */
	int getBjxxbCount(Map map);
	
	/** ByTy 按照比对规则SQL执行查询，由于身份证重号现象，所以返回报警信息列表 */
	List getBjxxByBdtjSql(Bjxxb bjxxb);
}
