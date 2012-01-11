package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IYjbdtjDao;
import com.aisino2.basicsystem.domain.Yjbdtj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class YjbdtjDaoImpl extends BaseDao implements IYjbdtjDao {
	/** @param 预警比对条件(t_yjbdtj) 增加 */
	public Yjbdtj insertYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		yjbdtj.setYjgzid(getNextID("Yjgzid"));
		return (Yjbdtj)insert("insertYjbdtj", yjbdtj);
	}

	/** @param 预警比对条件(t_yjbdtj) 删除 */
	public int deleteYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return delete("deleteYjbdtj", yjbdtj);
	}

	/** @param 预警比对条件(t_yjbdtj) 修改 */
	public int updateYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return update("updateYjbdtj", yjbdtj);
	}

	/** @param 预警比对条件(t_yjbdtj) 查询单条 */
	public Yjbdtj getYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return (Yjbdtj)queryForObject("getYjbdtj", yjbdtj);
	}

	/** @param 预警比对条件(t_yjbdtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Yjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getYjbdtjList", map, pageNo,pageSize);
	}

	/** @param 预警比对条件(t_yjbdtj) 多条查询 */
	public List getListYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return queryForList("getYjbdtjListNoPage", yjbdtj);
	}
}
