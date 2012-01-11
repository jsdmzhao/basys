package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbdqxxkzDao;
import com.aisino2.basicsystem.domain.Sjbdqxxkz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class SjbdqxxkzDaoImpl extends BaseDao implements ISjbdqxxkzDao {
	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 增加 */
	public Sjbdqxxkz insertSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		sjbdqxxkz.setSjbdqxxkzid(getNextID("Sjbdqxxkzid"));
		return (Sjbdqxxkz)insert("insertSjbdqxxkz", sjbdqxxkz);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 删除 */
	public int deleteSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return delete("deleteSjbdqxxkz", sjbdqxxkz);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 修改 */
	public int updateSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return update("updateSjbdqxxkz", sjbdqxxkz);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 查询单条 */
	public Sjbdqxxkz getSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return (Sjbdqxxkz)queryForObject("getSjbdqxxkz", sjbdqxxkz);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getSjbdqxxkzList", map, pageNo,pageSize);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 多条查询 */
	public List getListSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return queryForList("getSjbdqxxkzListNoPage", sjbdqxxkz);
	}
}
