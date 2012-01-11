package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.ILoginlogDao;
import com.aisino2.sysadmin.domain.Dltj;
import com.aisino2.sysadmin.domain.Loginlog;

public class LoginlogDaoImpl extends BaseDao implements ILoginlogDao {
	/** @param 登录日志表(t_loginlog) 增加 */
	public Loginlog insertLoginlog(Loginlog loginlog){
		// TODO: implement
		loginlog.setLoginlogid(getNextID("Loginlogid"));
		insert("insertLoginlog", loginlog);
		return loginlog;
	}

	/** @param 登录日志表(t_loginlog) 删除 */
	public int deleteLoginlog(Loginlog loginlog){
		// TODO: implement
		return delete("deleteLoginlog", loginlog);
	}

	/** @param 登录日志表(t_loginlog) 修改 */
	public int updateLoginlog(Loginlog loginlog){
		// TODO: implement
		return update("updateLoginlog", loginlog);
	}

	/** @param 登录日志表(t_loginlog) 查询单条 */
	public Loginlog getLoginlog(Loginlog loginlog){
		// TODO: implement
		return (Loginlog)queryForObject("getLoginlog", loginlog);
	}

	/** @param 登录日志表(t_loginlog) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if("0".equals(sort))
				sCol = " a.useraccount "+ desc;
			else if("1".equals(sort))
				sCol = " a.username "+ desc;
			else if("2".equals(sort))
				sCol = " a.loginip "+ desc;
			else if("3".equals(sort))
				sCol = " a.loginmac "+ desc;
			else if("4".equals(sort))
				sCol = " a.logintiime "+ desc;
			else 
				sCol=" a.logintiime desc ";
		}else{
			sCol=" a.logintiime desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getLoginlogList", map, pageNo,pageSize);
	}

	/** @param 登录日志表(t_loginlog) 多条查询 */
	public List getListLoginlog(Loginlog loginlog){
		// TODO: implement
		return queryForList("getLoginlogListNoPage", loginlog);
	}
	
	////得到日志的人员个数
	public String getLoginlogNum(Map map){
		return (String) queryForObject("getLoginlogNum", map);
	}
	
	
	public Page getDltjListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		
		String sCol="pcs.departcode ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " pcs.departcode ";
			else if(sort.equals("1"))
				sCol = " dlzs ";
		}else{
			sCol="pcs.departcode ";
		}
		if (desc != null)
			sCol += desc;
	    else
			sCol += " desc";
	    map.put("pageSort", sCol);
	    
		return queryForPage("getDltjList", map, pageNo,pageSize);
		
	}
	
	public Dltj getDltjTotalNum(Map map){
		return  (Dltj)queryForObject("getDltjTotalNum", map);
	}
}
