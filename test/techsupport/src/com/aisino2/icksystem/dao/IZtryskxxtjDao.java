package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Ztryskxxtj;
public interface IZtryskxxtjDao {
	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 增加 */
	Ztryskxxtj insertZtryskxxtj(Ztryskxxtj ztryskxxtj);

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 删除 */
	int deleteZtryskxxtj(Ztryskxxtj ztryskxxtj);

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 修改 */
	int updateZtryskxxtj(Ztryskxxtj ztryskxxtj);

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 查询单条 */
	Ztryskxxtj getZtryskxxtj(Ztryskxxtj ztryskxxtj);

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 多条查询 */
	List getListZtryskxxtj(Ztryskxxtj ztryskxxtj);
}
