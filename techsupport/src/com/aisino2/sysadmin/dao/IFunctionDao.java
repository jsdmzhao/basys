package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Function;
public interface IFunctionDao {
	/** @param 功能(t_function) 增加 */
	Function insertFunction(Function function);

	/** @param 功能(t_function) 删除 */
	int deleteFunction(Function function);

	/** @param 功能(t_function) 修改 */
	int updateFunction(Function function);

	/** @param 功能(t_function) 查询单条 */
	Function getFunction(Function function);

	/** @param 功能(t_function) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 功能(t_function) 多条查询 */
	List getListFunction(Function function);
	
	/**
	   * 根据用户userid和funcDefine查看此用户是否有这个功能权限。
	   * 
	   * @param condition
	   * @return
	   */
	    boolean  checkFunction(Function function);
	    
	    /***
	     * 更加funcDefine查看这个功能是否存在
	     * @param condition
	     * @return
	     */
	    boolean  findFuncDefine(Function function);
	  
	    /**
	     * 根据userid取得自己的功能，systemID可选
	     * @param condition
	     * @return
	     */
		List getOwnFunction(Function function);
		

}
