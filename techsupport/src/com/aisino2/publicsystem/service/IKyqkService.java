package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Kyqk;

public interface IKyqkService {
	/** @param 可疑情况(t_kyqk) 增加 */
	Kyqk insertKyqk(Kyqk kyqk);

	/** @param 可疑情况(t_kyqk) 删除 */
	boolean deleteKyqk(Kyqk kyqk);

	/** @param 可疑情况(t_kyqk) 修改 */
	boolean updateKyqk(Kyqk kyqk);

	/** @param 可疑情况(t_kyqk) 查询单条 */
	Kyqk getKyqk(Kyqk kyqk);

	/** @param 可疑情况(t_kyqk) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 可疑情况(t_kyqk) 公安端分页查询 */
	Page getListForPageGAD(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 可疑情况(t_kyqk) 多条查询 */
	List getListKyqk(Kyqk kyqk);
	/**
	 * 得到通报编码
	 * @param map
	 * @return
	 */
	String getScbm(Map map);
	
	/** @param 可疑情况(t_kyqk) 总数查询 */
	int getKyqkCount(Map map);
}
