package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IClxxry_zpDao;
import com.aisino2.publicsystem.domain.Clxxry_zp;

public class Clxxry_zpDaoImpl extends BaseDao implements IClxxry_zpDao {
	/** @param 车辆信息人员_照片(t_clxxry_zp) 增加 */
	public Clxxry_zp insertClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		clxxry_zp.setClxxryzpid(getNextID("Clxxryzpid"));
		insert("insertClxxry_zp", clxxry_zp);
		return clxxry_zp;
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 删除 */
	public int deleteClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return delete("deleteClxxry_zp", clxxry_zp);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 修改 */
	public int updateClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return update("updateClxxry_zp", clxxry_zp);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 查询单条 */
	public Clxxry_zp getClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return (Clxxry_zp)queryForObject("getClxxry_zp", clxxry_zp);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Cljbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getClxxry_zpList", map, pageNo,pageSize);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 多条查询(无照片) */
	public List getListClxxry_zpNoZp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return queryForList("getClxxry_zpNoZpListNoPage", clxxry_zp);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 多条查询(有照片) */
	public List getListClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return queryForList("getClxxry_zpListNoPage", clxxry_zp);
	}
}
