package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IParamDao;
import com.aisino2.sysadmin.domain.Param;

public class ParamDaoImpl extends BaseDao implements IParamDao {
	/** @param 参数设置(t_param) 增加 */
	public Param insertParam(Param param){
		// TODO: implement
		insert("insertParam", param);
		return param;
	}

	/** @param 参数设置(t_param) 删除 */
	public int deleteParam(Param param){
		// TODO: implement
		return delete("deleteParam", param);
	}

	/** @param 参数设置(t_param) 修改 */
	public int updateParam(Param param){
		// TODO: implement
		return update("updateParam", param);
	}

	/** @param 参数设置(t_param) 查询单条 */
	public Param getParam(Param param){
		// TODO: implement
		return (Param)queryForObject("getParam", param);
	}

	/** @param 参数设置(t_param) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.paramcode "+ desc;
			else if(sort.equals("1"))
				sCol = " a.paramname "+ desc;
			else if(sort.equals("2"))
				sCol = " a.paramvalue "+ desc;
			else
				sCol = "a.Paramcode desc";
		}else{
			sCol="a.Paramcode desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getParamList", map, pageNo,pageSize);
	}

	/** @param 参数设置(t_param) 多条查询 */
	public List getListParam(Param param){
		// TODO: implement
		return queryForList("getParamListNoPage", param);
	}
}
