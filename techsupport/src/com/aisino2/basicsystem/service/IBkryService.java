package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bkry;
import com.aisino2.core.dao.Page;

public interface IBkryService {
	/** @param 布控人员(t_bkry) 增加 */
	Bkry insertBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 删除 */
	boolean deleteBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 修改 */
	boolean updateBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 查询单条 */
	Bkry getBkry(Bkry bkry);

	/** @param 布控人员(t_bkry) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 境外布控人员(t_bkry) 分页查询 */
	Page getJwListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 布控人员(t_bkry) 多条查询 */
	List getListBkry(Bkry bkry);
	
	/** 验证添加时候的身份证号码在布控表中是否存在*/
	boolean validateZjhm(Bkry bkry);
}
