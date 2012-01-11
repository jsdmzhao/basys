package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IYjxxbDao;
import com.aisino2.basicsystem.domain.Yjxxb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class YjxxbDaoImpl extends BaseDao implements IYjxxbDao {
	/** @param 预警信息表(t_yjxxb) 增加 */
	public Yjxxb insertYjxxb(Yjxxb yjxxb){
		// TODO: implement
		yjxxb.setYjgzid(getNextID("Yjgzid"));
		return (Yjxxb)insert("insertYjxxb", yjxxb);
	}

	/** @param 预警信息表(t_yjxxb) 删除 */
	public int deleteYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return delete("deleteYjxxb", yjxxb);
	}

	/** @param 预警信息表(t_yjxxb) 修改 */
	public int updateYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return update("updateYjxxb", yjxxb);
	}

	/** @param 预警信息表(t_yjxxb) 查询单条 */
	public Yjxxb getYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return (Yjxxb)queryForObject("getYjxxb", yjxxb);
	}

	/** @param 预警信息表(t_yjxxb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Yjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getYjxxbList", map, pageNo,pageSize);
	}

	/** @param 预警信息表(t_yjxxb) 多条查询 */
	public List getListYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return queryForList("getYjxxbListNoPage", yjxxb);
	}

	public 	List<Yjxxb> getListYjxxbBDBJ(Yjxxb yjxxb) {
		return queryForList("getYjxxbListBDBJNoPage", yjxxb);
	}

	public Yjxxb insertYjxxbBDBJ(Yjxxb yjxxb) {
		yjxxb.setYjxxid(getNextID("Yjxxid"));
		yjxxb.setYwbzj(String.valueOf(getNextID("Gnlklsid")));
		yjxxb.setBdbzj(String.valueOf(getNextID("Gzdxkzid")));
		insert("insertYjxxb", yjxxb);
		return yjxxb;
	}
}
