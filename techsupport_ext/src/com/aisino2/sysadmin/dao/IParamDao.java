package com.aisino2.sysadmin.dao;
import java.util.List;

import com.aisino2.sysadmin.domain.Param;
public interface IParamDao {
	/** @param 参数设置(t_param) 增加 */
	void insertParam(Param param);

	/** @param 参数设置(t_param) 删除 */
	void deleteParam(Param param);

	/** @param 参数设置(t_param) 修改 */
	void updateParam(Param param);

	/** @param 参数设置(t_param) 查询单条 */
	Param getParam(Param param);

	/** @param 参数设置(t_param) 分页查询 */
	List getListForPage(Param param, int pageNo,int pageSize,String sort,String desc);

	/** @param 参数设置(t_param) 多条查询 */
	List<Param> getListParam(Param param);
}
