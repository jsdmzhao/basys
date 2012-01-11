package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdqclxxlsbDao;
import com.aisino2.basicsystem.domain.Bdqclxxlsb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BdqclxxlsbDaoImpl extends BaseDao implements IBdqclxxlsbDao {
	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 增加 */
	public Bdqclxxlsb insertBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		bdqclxxlsb.setBdqclxxid(getNextID("Bdqclxxid"));
		return (Bdqclxxlsb)insert("insertBdqclxxlsb", bdqclxxlsb);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 删除 */
	public int deleteBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return delete("deleteBdqclxxlsb", bdqclxxlsb);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 修改 */
	public int updateBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return update("updateBdqclxxlsb", bdqclxxlsb);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 查询单条 */
	public Bdqclxxlsb getBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return (Bdqclxxlsb)queryForObject("getBdqclxxlsb", bdqclxxlsb);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bdqclxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBdqclxxlsbList", map, pageNo,pageSize);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 多条查询 */
	public List getListBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return queryForList("getBdqclxxlsbListNoPage", bdqclxxlsb);
	}
}
