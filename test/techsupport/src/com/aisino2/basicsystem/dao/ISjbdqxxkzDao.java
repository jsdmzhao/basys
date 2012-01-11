package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Sjbdqxxkz;
import com.aisino2.core.dao.Page;
public interface ISjbdqxxkzDao {
	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 增加 */
	Sjbdqxxkz insertSjbdqxxkz(Sjbdqxxkz sjbdqxxkz);

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 删除 */
	int deleteSjbdqxxkz(Sjbdqxxkz sjbdqxxkz);

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 修改 */
	int updateSjbdqxxkz(Sjbdqxxkz sjbdqxxkz);

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 查询单条 */
	Sjbdqxxkz getSjbdqxxkz(Sjbdqxxkz sjbdqxxkz);

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 多条查询 */
	List getListSjbdqxxkz(Sjbdqxxkz sjbdqxxkz);
}
