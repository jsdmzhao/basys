package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IOperatelogDao;
import com.aisino2.sysadmin.domain.Operatelog;


public class OperatelogDaoImpl extends BaseDao implements IOperatelogDao  {
	/** @param 登录日志表(t_Operatelog) 增加 */
	public Operatelog insertOperatelog(Operatelog Operatelog){
		// TODO: implement
		Operatelog.setOperatelogid(getNextID("Operatelogid"));
		insert("insertOperatelog", Operatelog);
		return Operatelog;
	}

	/** @param 登录日志表(t_Operatelog) 删除 */
	public int deleteOperatelog(Operatelog Operatelog){
		// TODO: implement
		return delete("deleteOperatelog", Operatelog);
	}

	/** @param 登录日志表(t_Operatelog) 修改 */
	public int updateOperatelog(Operatelog Operatelog){
		// TODO: implement
		return update("updateOperatelog", Operatelog);
	}

	/** @param 登录日志表(t_Operatelog) 查询单条 */
	public Operatelog getOperatelog(Operatelog Operatelog){
		// TODO: implement
		return (Operatelog)queryForObject("getOperatelog", Operatelog);
	}

	/** @param 登录日志表(t_Operatelog) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if("0".equals(sort))
				sCol = " a.operatemodule "+ desc;
			else if("1".equals(sort))
				sCol = " a.useraccount "+ desc;
			else if("2".equals(sort))
				sCol = " a.operatedate "+ desc;
			else if("3".equals(sort))
				sCol = " a.operatetype "+ desc;
			
		}else{
			sCol=" a.operatelogid desc";
		}
		
		map.put("pageSort", sCol);
		return queryForPage("getOperatelogList", map, pageNo,pageSize);
	}

	/** @param 登录日志表(t_Operatelog) 多条查询 */
	public List getListOperatelog(Operatelog Operatelog){
		// TODO: implement
		return queryForList("getOperatelogListNoPage", Operatelog);
	}
}
