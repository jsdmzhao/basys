package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Khxx;
public interface IKhxxDao {
	/** @param 客户信息表(t_khxx) 增加 */
	Khxx insertKhxx(Khxx khxx);

	/** @param 客户信息表(t_khxx) 删除 */
	int deleteKhxx(Khxx khxx);

	/** @param 客户信息表(t_khxx) 修改 */
	int updateKhxx(Khxx khxx);

	/** @param 客户信息表(t_khxx) 查询单条 */
	Khxx getKhxx(Khxx khxx);
	
	/** @param 客户信息表(t_khxx) 查询单条 获得证件号码及国籍代码相同的客户信息中最新一条信息*/
	Khxx getLatestKhxx(Khxx khxx);

	/** @param 客户信息表(t_khxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 客户信息表(t_khxx) 多条查询 */
	List getListKhxx(Khxx khxx);
	
	/** @param 客户信息表(t_khxx) 多条查询 判断客户是否存在*/
	public List isKhxxExist(Khxx khxx);
	
}
