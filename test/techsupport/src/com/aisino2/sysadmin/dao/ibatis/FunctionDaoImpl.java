package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IFunctionDao;
import com.aisino2.sysadmin.domain.Function;

public class FunctionDaoImpl extends BaseDao implements IFunctionDao {
	/** @param 功能(t_function) 增加 */
	public Function insertFunction(Function function){
		// TODO: implement
		return (Function)insert("insertFunction", function);
	}

	/** @param 功能(t_function) 删除 */
	public int deleteFunction(Function function){
		// TODO: implement
		return delete("deleteFunction", function);
	}

	/** @param 功能(t_function) 修改 */
	public int updateFunction(Function function){
		// TODO: implement
		return update("updateFunction", function);
	}

	/** @param 功能(t_function) 查询单条 */
	public Function getFunction(Function function){
		// TODO: implement
		return (Function)queryForObject("getFunction", function);
	}

	/** @param 功能(t_function) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if("0".equals(sort)){
				sCol = " a.funccode "+desc;
			} else if("1".equals(sort)){
				sCol = " a.funcname "+desc;
			} else if("2".equals(sort)){
				sCol = " a.functype "+desc;
			} else {
				sCol=" a.funccode desc";
			}
		}else{
			sCol=" a.funccode desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getFunctionList", map, pageNo,pageSize);
	}

	/** @param 功能(t_function) 多条查询 */
	public List getListFunction(Function function){
		// TODO: implement
		return queryForList("getFunctionListNoPage", function);
	}

	public boolean checkFunction(Function function) {
		// TODO Auto-generated method stub
		return ((Integer)queryForObject("checkFunction",function)).intValue()>0;
	}

	public boolean findFuncDefine(Function function) {
		// TODO Auto-generated method stub
		return queryForList("findFuncDefine", function).size()>0;
	}

	public List getOwnFunction(Function function) {
		// TODO Auto-generated method stub
		return queryForList("getOwnFunction", function);	
	}

	

}
