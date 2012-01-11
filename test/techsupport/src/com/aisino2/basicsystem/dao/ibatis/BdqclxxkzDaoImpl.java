package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdqclxxkzDao;
import com.aisino2.basicsystem.domain.Bdqclxxkz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BdqclxxkzDaoImpl extends BaseDao implements IBdqclxxkzDao {
	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 增加 */
	public Bdqclxxkz insertBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		bdqclxxkz.setBdqclxxkzid(getNextID("Bdqclxxkzid"));
		return (Bdqclxxkz)insert("insertBdqclxxkz", bdqclxxkz);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 删除 */
	public int deleteBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return delete("deleteBdqclxxkz", bdqclxxkz);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 修改 */
	public int updateBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return update("updateBdqclxxkz", bdqclxxkz);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 查询单条 */
	public Bdqclxxkz getBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return (Bdqclxxkz)queryForObject("getBdqclxxkz", bdqclxxkz);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBdqclxxkzList", map, pageNo,pageSize);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 多条查询 */
	public List getListBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return queryForList("getBdqclxxkzListNoPage", bdqclxxkz);
	}
}
