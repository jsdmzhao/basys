package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IClxxwgryxxDao;
import com.aisino2.publicsystem.domain.Clxxwgryxx;

public class ClxxwgryxxDaoImpl extends BaseDao implements IClxxwgryxxDao {
	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 增加 */
	public Clxxwgryxx insertClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		clxxwgryxx.setWgrxxid(getNextID("Wgrxxid"));
		insert("insertClxxwgryxx", clxxwgryxx);
		return clxxwgryxx;
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 删除 */
	public int deleteClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return delete("deleteClxxwgryxx", clxxwgryxx);
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 修改 */
	public int updateClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return update("updateClxxwgryxx", clxxwgryxx);
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 查询单条 */
	public Clxxwgryxx getClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return (Clxxwgryxx)queryForObject("getClxxwgryxx", clxxwgryxx);
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Cljbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getClxxwgryxxList", map, pageNo,pageSize);
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 多条查询 */
	public List getListClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return queryForList("getClxxwgryxxListNoPage", clxxwgryxx);
	}
}
