package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.sysadmin.domain.Dltj;
import com.aisino2.sysadmin.domain.Loginlog;
import com.opensymphony.module.sitemesh.Page;

public interface ILoginlogService {
	/** @param 登录日志表(t_loginlog) 增加 */
	Loginlog insertLoginlog(Loginlog loginlog);

	/** @param 登录日志表(t_loginlog) 删除 */
	boolean deleteLoginlog(Loginlog loginlog);

	/** @param 登录日志表(t_loginlog) 修改 */
	boolean updateLoginlog(Loginlog loginlog);

	/** @param 登录日志表(t_loginlog) 查询单条 */
	Loginlog getLoginlog(Loginlog loginlog);

	/** @param 登录日志表(t_loginlog) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 登录日志表(t_loginlog) 多条查询 */
	List getListLoginlog(Loginlog loginlog);
	
	////得到日志的人员个数
	String getLoginlogNum(Map map);
	
	/** @param 登录日志表统计 分页查询 */
	Page getDltjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	Dltj getDltjTotalNum(Map map);
}
