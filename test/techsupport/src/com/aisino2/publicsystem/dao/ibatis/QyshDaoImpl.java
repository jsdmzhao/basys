package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyshDao;
import com.aisino2.publicsystem.domain.Qysh;

public class QyshDaoImpl extends BaseDao implements IQyshDao {
	/** @param 企业审核(t_qysh) 增加 */
	public Qysh insertQysh(Qysh qysh){
		// TODO: implement
		qysh.setQyshid(getNextID("Ggqyshid"));
		insert("insertQysh", qysh);
		return qysh;
	}

	/** @param 企业审核(t_qysh) 删除 */
	public int deleteQysh(Qysh qysh){
		// TODO: implement
		return delete("deleteQysh", qysh);
	}

	/** @param 企业审核(t_qysh) 修改 */
	public int updateQysh(Qysh qysh){
		// TODO: implement
		return update("updateQysh", qysh);
	}

	/** @param 企业审核(t_qysh) 查询单条 */
	public Qysh getQysh(Qysh qysh){
		// TODO: implement
		return (Qysh)queryForObject("getQysh", qysh);
	}

	/** @param 企业审核(t_qysh) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyshid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyshList", map, pageNo,pageSize);
	}

	/** @param 企业审核(t_qysh) 多条查询 */
	public List getListQysh(Qysh qysh){
		// TODO: implement
		return queryForList("getQyshListNoPage", qysh);
	}
	
	/** 获得上级审核id，即最后一次审核的qyshid */
	public Qysh getSjshid(Qysh qysh){
		// TODO: implement
		return (Qysh)queryForObject("getSjshid", qysh);
	}
}
