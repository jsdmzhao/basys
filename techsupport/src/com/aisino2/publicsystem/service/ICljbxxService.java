package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Cljbxx;

public interface ICljbxxService {
	/** @param 车辆基本信息(t_cljbxx) 增加 */
	Cljbxx insertCljbxx(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 删除 */
	boolean deleteCljbxx(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 修改 */
	boolean updateCljbxx(Cljbxx cljbxx);	
	
	/** @param 车辆基本信息(t_cljbxx) 修改  有报警*/
	Cljbxx updateCljbxxBj(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 查询单条 */
	Cljbxx getCljbxx(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 查询单条(包括人员照片、外国车主等信息) */
	Cljbxx getCljbxxCommon(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 车辆基本信息(t_cljbxx) 多条查询 */
	List getListCljbxx(Cljbxx cljbxx);
}

