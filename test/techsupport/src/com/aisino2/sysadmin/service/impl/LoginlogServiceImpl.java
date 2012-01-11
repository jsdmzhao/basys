package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.ILoginlogDao;
import com.aisino2.sysadmin.domain.Dltj;
import com.aisino2.sysadmin.domain.Loginlog;
import com.aisino2.sysadmin.service.ILoginlogService;

public class LoginlogServiceImpl extends BaseService implements ILoginlogService {

	private ILoginlogDao loginlogDao;

	/** @param 登录日志表(t_loginlog) 增加 */
	public Loginlog insertLoginlog(Loginlog loginlog){
		// TODO: implement
		if(loginlog != null)
			if("read MAC error!".equals(loginlog.getLoginmac()))
				loginlog.setLoginmac("");
		return (Loginlog)loginlogDao.insertLoginlog(loginlog);
	}

	/** @param 登录日志表(t_loginlog) 删除 */
	public boolean deleteLoginlog(Loginlog loginlog){
		// TODO: implement
		return loginlogDao.deleteLoginlog(loginlog)>0;
	}

	/** @param 登录日志表(t_loginlog) 修改 */
	public boolean updateLoginlog(Loginlog loginlog){
		// TODO: implement
		return loginlogDao.updateLoginlog(loginlog)>0;
	}

	/** @param 登录日志表(t_loginlog) 查询单条 */
	public Loginlog getLoginlog(Loginlog loginlog){
		// TODO: implement
		return (Loginlog)loginlogDao.getLoginlog(loginlog);
	}

	/** @param 登录日志表(t_loginlog) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return loginlogDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 登录日志表(t_loginlog) 多条查询 */
	public List getListLoginlog(Loginlog loginlog){
		// TODO: implement
		return loginlogDao.getListLoginlog(loginlog);
	}

	public ILoginlogDao getLoginlogDao() {
		return loginlogDao;
	}

	public void setLoginlogDao(ILoginlogDao loginlogDao) {
		this.loginlogDao = loginlogDao;
	}
	
    ////得到日志的人员个数
	public String getLoginlogNum(Map map){
		
		return loginlogDao.getLoginlogNum(map);
	}
	
	/** @param 登录日志表统计 分页查询 */
	public Page getDltjListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return loginlogDao.getDltjListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	public Dltj getDltjTotalNum(Map map){
		
		return loginlogDao.getDltjTotalNum(map);
		
	}
}
