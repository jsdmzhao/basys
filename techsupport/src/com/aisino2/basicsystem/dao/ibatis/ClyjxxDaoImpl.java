package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IClyjxxDao;
import com.aisino2.basicsystem.domain.Clyjxx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class ClyjxxDaoImpl extends BaseDao implements IClyjxxDao {
	/** @param 车辆预警信息(t_clyjxx) 增加 */
	public Clyjxx insertClyjxx(Clyjxx clyjxx){
		// TODO: implement
		clyjxx.setClyjxxid(getNextID("Clyjxxid"));
		insert("insertClyjxx", clyjxx);
		return clyjxx;
	}

	/** @param 车辆预警信息(t_clyjxx) 删除 */
	public int deleteClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return delete("deleteClyjxx", clyjxx);
	}

	/** @param 车辆预警信息(t_clyjxx) 修改 */
	public int updateClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return update("updateClyjxx", clyjxx);
	}

	/** @param 车辆预警信息(t_clyjxx) 查询单条 */
	public Clyjxx getClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return (Clyjxx)queryForObject("getClyjxx", clyjxx);
	}

	/** @param 车辆预警信息(t_clyjxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Clyjxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getClyjxxList", map, pageNo,pageSize);
	}

	/** @param 车辆预警信息(t_clyjxx) 多条查询 */
	public List getListClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return queryForList("getClyjxxListNoPage", clyjxx);
	}

	public Integer checkOtherYjxxExist(Map map) {
		return (Integer)queryForObject("checkOtherYjxxExist", map);
	}
	public List checkClxxExist(Map map) {
		return queryForList("checkClxxExist", map);
	}
	
}
