package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.ICljbxxDao;
import com.aisino2.publicsystem.domain.Cljbxx;

public class CljbxxDaoImpl extends BaseDao implements ICljbxxDao {
	/** @param 车辆基本信息(t_cljbxx) 增加 */
	public Cljbxx insertCljbxx(Cljbxx cljbxx){
		// TODO: implement
		cljbxx.setCljbxxid(getNextID("Cljbxxid"));
		insert("insertCljbxx", cljbxx);
		return cljbxx;
	}

	/** @param 车辆基本信息(t_cljbxx) 删除 */
	public int deleteCljbxx(Cljbxx cljbxx){
		// TODO: implement
		return delete("deleteCljbxx", cljbxx);
	}

	/** @param 车辆基本信息(t_cljbxx) 修改 */
	public int updateCljbxx(Cljbxx cljbxx){
		// TODO: implement
		return update("updateCljbxx", cljbxx);
	}

	/** @param 车辆基本信息(t_cljbxx) 查询单条 */
	public Cljbxx getCljbxx(Cljbxx cljbxx){
		// TODO: implement
		return (Cljbxx)queryForObject("getCljbxx", cljbxx);
	}

	/** @param 车辆基本信息(t_cljbxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Cljbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCljbxxList", map, pageNo,pageSize);
	}
	

	/** @param 车辆基本信息(t_cljbxx) 分页查询 */
	public Page getSelListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.cph "+ desc;
			else if(sort.equals("1"))
				sCol = " a.cllx "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cszs "+ desc;
			else if(sort.equals("3"))
				sCol = " a.clpp "+ desc;
			else if(sort.equals("4"))
				sCol = " a.clxh "+ desc;
			else if(sort.equals("5"))
				sCol = " a.clcs "+ desc;
			else if(sort.equals("6"))
				sCol = " a.xslc "+ desc;
			else
				sCol = " t.Cljbxxid desc ";
		}else{
			sCol="a.Cljbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getSelCljbxxList", map, pageNo,pageSize);
	}

	/** @param 车辆基本信息(t_cljbxx) 多条查询 */
	public List getListCljbxx(Cljbxx cljbxx){
		// TODO: implement
		return queryForList("getCljbxxListNoPage", cljbxx);
	}
	/** @param 检测车辆是否可用 */
	public Integer jianChaClsfky(Cljbxx cljbxx){
		return (Integer)queryForObject("jianChaClsfky",cljbxx);
	}
}
