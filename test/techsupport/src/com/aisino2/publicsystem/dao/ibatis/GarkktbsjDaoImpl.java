package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IGarkktbsjDao;
import com.aisino2.publicsystem.domain.Garkktbsj;

public class GarkktbsjDaoImpl extends BaseDao implements IGarkktbsjDao {
	/** @param 公安人口库同步数据(t_garkktbsj) 增加 */
	public Garkktbsj insertGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		garkktbsj.setGarkktbsjid(getNextID("Gggarkktbsjid"));
		insert("insertGarkktbsj", garkktbsj);
		return garkktbsj;
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 删除 */
	public int deleteGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return delete("deleteGarkktbsj", garkktbsj);
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 修改 */
	public int updateGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return update("updateGarkktbsj", garkktbsj);
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 查询单条 */
	public Garkktbsj getGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return (Garkktbsj)queryForObject("getGarkktbsj", garkktbsj);
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Garkktbsjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGarkktbsjList", map, pageNo,pageSize);
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 多条查询 */
	public List getListGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return queryForList("getGarkktbsjListNoPage", garkktbsj);
	}
}
