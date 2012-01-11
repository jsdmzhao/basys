package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Sjbdqxx;
import com.aisino2.core.dao.Page;

public interface ISjbdqxxService {
	/** @param 手机被盗抢信息(t_sjbdqxx) 增加 */
	Sjbdqxx insertSjbdqxx(Sjbdqxx sjbdqxx);

	/** @param 手机被盗抢信息(t_sjbdqxx) 删除 */
	boolean deleteSjbdqxx(Sjbdqxx sjbdqxx);

	/** @param 手机被盗抢信息(t_sjbdqxx) 修改 */
	boolean updateSjbdqxx(Sjbdqxx sjbdqxx);

	/** @param 手机被盗抢信息(t_sjbdqxx) 查询单条 */
	Sjbdqxx getSjbdqxx(Sjbdqxx sjbdqxx);

	/** @param 手机被盗抢信息(t_sjbdqxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 手机被盗抢信息(t_sjbdqxx) 多条查询 */
	List getListSjbdqxx(Sjbdqxx sjbdqxx);
	
	/** 判断手机被盗抢信息 是否已存在 */
	String isSjbdqxxExist(Sjbdqxx sjbdqxx);
}
