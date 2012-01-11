package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gatztb_fj;
import com.aisino2.core.dao.Page;

public interface IGatztb_fjService {
	/** @param 公安通知通报_附件(t_gatztb_fj) 增加 */
	Gatztb_fj insertGatztb_fj(Gatztb_fj gatztb_fj);

	/** @param 公安通知通报_附件(t_gatztb_fj) 删除 */
	boolean deleteGatztb_fj(Gatztb_fj gatztb_fj);

	/** @param 公安通知通报_附件(t_gatztb_fj) 修改 */
	boolean updateGatztb_fj(Gatztb_fj gatztb_fj);

	/** @param 公安通知通报_附件(t_gatztb_fj) 查询单条 */
	Gatztb_fj getGatztb_fj(Gatztb_fj gatztb_fj);

	/** @param 公安通知通报_附件(t_gatztb_fj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 公安通知通报_附件(t_gatztb_fj) 多条查询 */
	List getListGatztb_fj(Gatztb_fj gatztb_fj);
}
