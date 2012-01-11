package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQybaxxDao;
import com.aisino2.publicsystem.domain.Qybaxx;

public class QybaxxDaoImpl extends BaseDao implements IQybaxxDao {
	/** @param 企业备案信息(t_qybaxx) 增加 */
	public Qybaxx insertQybaxx(Qybaxx qybaxx){
		// TODO: implement
		qybaxx.setQybaxxid(getNextID("Qybaxxid"));
		return (Qybaxx)insert("insertQybaxx", qybaxx);
	}

	/** @param 企业备案信息(t_qybaxx) 删除 */
	public int deleteQybaxx(Qybaxx qybaxx){
		// TODO: implement
		return delete("deleteQybaxx", qybaxx);
	}

	/** @param 企业备案信息(t_qybaxx) 修改 */
	public int updateQybaxx(Qybaxx qybaxx){
		// TODO: implement
		return update("updateQybaxx", qybaxx);
	}

	/** @param 企业备案信息(t_qybaxx) 查询单条 */
	public Qybaxx getQybaxx(Qybaxx qybaxx){
		// TODO: implement
		return (Qybaxx)queryForObject("getQybaxx", qybaxx);
	}

	/** @param 企业备案信息(t_qybaxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQybaxxList", map, pageNo,pageSize);
	}

	/** @param 企业备案信息(t_qybaxx) 多条查询 */
	public List getListQybaxx(Qybaxx qybaxx){
		// TODO: implement
		return queryForList("getQybaxxListNoPage", qybaxx);
	}

	/** @param 企业基本信息(t_ylcsjbxx) 分页查询  企业备案查询*/
	public Page getListForPageCsba(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		}else{
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.qybm "+ desc;
				else if(sort.equals("1"))
					sCol = " a.qymc "+ desc;
				else if(sort.equals("2"))
					sCol = " b.zrs "+ desc;
				else if(sort.equals("3"))
					sCol = " a.qyzflmc "+ desc;
				else if(sort.equals("4"))
					sCol = " a.frdb "+ desc;
				else if(sort.equals("5"))
					sCol = " a.yyztdm "+ desc;
				else
					sCol = " a.csbm  ";
			}else{
				sCol="a.qybm ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getQyjbxxList", map, pageNo,pageSize);
	}
}
