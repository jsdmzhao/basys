package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIckrzjlDao;
import com.aisino2.icksystem.domain.Ickrzjl;

public class IckrzjlDaoImpl extends BaseDao implements IIckrzjlDao {
	/** @param IC卡日志记录(t_ickrzjl) 增加 */
	public Ickrzjl insertIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		ickrzjl.setRzbh(getNextID("Rzbh"));
		return (Ickrzjl)insert("insertIckrzjl", ickrzjl);
	}

	/** @param IC卡日志记录(t_ickrzjl) 删除 */
	public int deleteIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return delete("deleteIckrzjl", ickrzjl);
	}

	/** @param IC卡日志记录(t_ickrzjl) 修改 */
	public int updateIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return update("updateIckrzjl", ickrzjl);
	}

	/** @param IC卡日志记录(t_ickrzjl) 查询单条 */
	public Ickrzjl getIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return (Ickrzjl)queryForObject("getIckrzjl", ickrzjl);
	}

	/** @param IC卡日志记录(t_ickrzjl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.glbh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.pch "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.czlb "+ desc;
			else if(sort.equals("5"))
				sCol = " a.czr "+ desc;
			else if(sort.equals("6"))
				sCol = " a.czsj "+ desc;
			else
				sCol = " a.rzbh ";
		}else{
			sCol="a.rzbh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckrzjlList", map, pageNo,pageSize);
	}

	/** @param IC卡日志记录(t_ickrzjl) 多条查询 */
	public List getListIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return queryForList("getIckrzjlListNoPage", ickrzjl);
	}
}
