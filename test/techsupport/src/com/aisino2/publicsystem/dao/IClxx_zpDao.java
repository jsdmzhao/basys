package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Clxx_zp;
public interface IClxx_zpDao {
	/** @param 车辆信息_照片(t_clxx_zp) 增加 */
	Clxx_zp insertClxx_zp(Clxx_zp clxx_zp);

	/** @param 车辆信息_照片(t_clxx_zp) 删除 */
	int deleteClxx_zp(Clxx_zp clxx_zp);

	/** @param 车辆信息_照片(t_clxx_zp) 修改 */
	int updateClxx_zp(Clxx_zp clxx_zp);

	/** @param 车辆信息_照片(t_clxx_zp) 查询单条 */
	Clxx_zp getClxx_zp(Clxx_zp clxx_zp);

	/** @param 车辆信息_照片(t_clxx_zp) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 车辆信息_照片(t_clxx_zp) 多条查询 */
	List getListClxx_zp(Clxx_zp clxx_zp);

	/** @param 车辆信息_照片(t_clxx_zp) 多条查询(无照片) */
	List getListClxx_zpNoTp(Clxx_zp clxx_zp);
}
