package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Xctb_fj;
import com.aisino2.core.dao.Page;

public interface IXctb_fjService {
	/** @param 协查通报_附件(t_xctb_fj) 增加 */
	Xctb_fj insertXctb_fj(Xctb_fj xctb_fj);

	/** @param 协查通报_附件(t_xctb_fj) 删除 */
	boolean deleteXctb_fj(Xctb_fj xctb_fj);

	/** @param 协查通报_附件(t_xctb_fj) 修改 */
	boolean updateXctb_fj(Xctb_fj xctb_fj);

	/** @param 协查通报_附件(t_xctb_fj) 查询单条 */
	Xctb_fj getXctb_fj(Xctb_fj xctb_fj);

	/** @param 协查通报_附件(t_xctb_fj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 协查通报_附件(t_xctb_fj) 多条查询 */
	List getListXctb_fj(Xctb_fj xctb_fj);
}
