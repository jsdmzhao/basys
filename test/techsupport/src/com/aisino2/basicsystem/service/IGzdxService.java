package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gzdx;
import com.aisino2.core.dao.Page;

public interface IGzdxService {
	/** @param 关注对象(t_gzdx) 增加 */
	Gzdx insertGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 删除 */
	boolean deleteGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 修改 */
	boolean updateGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 查询单条 */
	Gzdx getGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 关注对象(t_gzdx) 多条查询 */
	List getListGzdx(Gzdx gzdx);
	
	/** 验证添加时候的身份证号码在关注对象跟在逃表中是否存在*/
	String validateZjhm(Gzdx gzdx);

	List getListExportGzdx(Map map, String sort, String dir);
}
