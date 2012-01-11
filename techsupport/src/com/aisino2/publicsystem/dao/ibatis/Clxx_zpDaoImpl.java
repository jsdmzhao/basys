package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IClxx_zpDao;
import com.aisino2.publicsystem.domain.Clxx_zp;

public class Clxx_zpDaoImpl extends BaseDao implements IClxx_zpDao {
	/** @param 车辆信息_照片(t_clxx_zp) 增加 */
	public Clxx_zp insertClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		clxx_zp.setClxxzpid(getNextID("Clxxzpid"));
		insert("insertClxx_zp", clxx_zp);
		return clxx_zp;
	}

	/** @param 车辆信息_照片(t_clxx_zp) 删除 */
	public int deleteClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return delete("deleteClxx_zp", clxx_zp);
	}

	/** @param 车辆信息_照片(t_clxx_zp) 修改 */
	public int updateClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return update("updateClxx_zp", clxx_zp);
	}

	/** @param 车辆信息_照片(t_clxx_zp) 查询单条 */
	public Clxx_zp getClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return (Clxx_zp)queryForObject("getClxx_zp", clxx_zp);
	}

	/** @param 车辆信息_照片(t_clxx_zp) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Cljbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getClxx_zpList", map, pageNo,pageSize);
	}

	/** @param 车辆信息_照片(t_clxx_zp) 多条查询(无照片) */
	public List getListClxx_zpNoTp(Clxx_zp clxx_zp){
		// TODO: implement
		return queryForList("getClxx_zpNoTpListNoPage", clxx_zp);
	}
	
	/** @param 车辆信息_照片(t_clxx_zp) 多条查询(有照片) */
	public List getListClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return queryForList("getClxx_zpListNoPage", clxx_zp);
	}
}
