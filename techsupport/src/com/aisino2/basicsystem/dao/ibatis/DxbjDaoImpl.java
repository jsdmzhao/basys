package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDxbjDao;
import com.aisino2.basicsystem.domain.Dxbj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class DxbjDaoImpl extends BaseDao implements IDxbjDao {
	/** @param 短信报警(t_dxbj) 增加 */
	public Dxbj insertDxbj(Dxbj dxbj){
		// TODO: implement
		dxbj.setBjgzid(getNextID("Bjgzid"));
		return (Dxbj)insert("insertDxbj", dxbj);
	}

	/** @param 短信报警(t_dxbj) 删除 */
	public int deleteDxbj(Dxbj dxbj){
		// TODO: implement
		return delete("deleteDxbj", dxbj);
	}

	/** @param 短信报警(t_dxbj) 修改 */
	public int updateDxbj(Dxbj dxbj){
		// TODO: implement
		return update("updateDxbj", dxbj);
	}

	/** @param 短信报警(t_dxbj) 查询单条 */
	public Dxbj getDxbj(Dxbj dxbj){
		// TODO: implement
		return (Dxbj)queryForObject("getDxbj", dxbj);
	}

	/** @param 短信报警(t_dxbj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDxbjList", map, pageNo,pageSize);
	}

	/** @param 短信报警(t_dxbj) 多条查询 */
	public List getListDxbj(Dxbj dxbj){
		// TODO: implement
		return queryForList("getDxbjListNoPage", dxbj);
	}
}
