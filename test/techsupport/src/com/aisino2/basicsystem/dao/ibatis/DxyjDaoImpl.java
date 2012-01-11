package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDxyjDao;
import com.aisino2.basicsystem.domain.Dxyj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class DxyjDaoImpl extends BaseDao implements IDxyjDao {
	/** @param 短信预警(t_dxyj) 增加 */
	public Dxyj insertDxyj(Dxyj dxyj){
		// TODO: implement
		dxyj.setYjgzid(getNextID("Yjgzid"));
		return (Dxyj)insert("insertDxyj", dxyj);
	}

	/** @param 短信预警(t_dxyj) 删除 */
	public int deleteDxyj(Dxyj dxyj){
		// TODO: implement
		return delete("deleteDxyj", dxyj);
	}

	/** @param 短信预警(t_dxyj) 修改 */
	public int updateDxyj(Dxyj dxyj){
		// TODO: implement
		return update("updateDxyj", dxyj);
	}

	/** @param 短信预警(t_dxyj) 查询单条 */
	public Dxyj getDxyj(Dxyj dxyj){
		// TODO: implement
		return (Dxyj)queryForObject("getDxyj", dxyj);
	}

	/** @param 短信预警(t_dxyj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Yjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDxyjList", map, pageNo,pageSize);
	}

	/** @param 短信预警(t_dxyj) 多条查询 */
	public List getListDxyj(Dxyj dxyj){
		// TODO: implement
		return queryForList("getDxyjListNoPage", dxyj);
	}
}
