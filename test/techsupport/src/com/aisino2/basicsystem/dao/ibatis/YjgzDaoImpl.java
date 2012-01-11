package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IYjgzDao;
import com.aisino2.basicsystem.domain.Yjgz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class YjgzDaoImpl extends BaseDao implements IYjgzDao {
	/** @param 预警规则(t_yjgz) 增加 */
	public Yjgz insertYjgz(Yjgz yjgz){
		// TODO: implement
		yjgz.setYjgzid(getNextID("Yjgzid"));
		return (Yjgz)insert("insertYjgz", yjgz);
	}

	/** @param 预警规则(t_yjgz) 删除 */
	public int deleteYjgz(Yjgz yjgz){
		// TODO: implement
		return delete("deleteYjgz", yjgz);
	}

	/** @param 预警规则(t_yjgz) 修改 */
	public int updateYjgz(Yjgz yjgz){
		// TODO: implement
		return update("updateYjgz", yjgz);
	}

	/** @param 预警规则(t_yjgz) 查询单条 */
	public Yjgz getYjgz(Yjgz yjgz){
		// TODO: implement
		return (Yjgz)queryForObject("getYjgz", yjgz);
	}

	/** @param 预警规则(t_yjgz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Yjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getYjgzList", map, pageNo,pageSize);
	}

	/** @param 预警规则(t_yjgz) 多条查询 */
	public List getListYjgz(Yjgz yjgz){
		// TODO: implement
		return queryForList("getYjgzListNoPage", yjgz);
	}
}
