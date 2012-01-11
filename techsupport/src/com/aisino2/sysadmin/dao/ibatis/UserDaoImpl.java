package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IUserDao;
import com.aisino2.sysadmin.domain.User;

public class UserDaoImpl extends BaseDao implements IUserDao {
	/** @param 用户(t_user) 增加 */
	public User insertUser(User user){
		// TODO: implement
		user.setUserid(getNextID("Userid"));
		insert("insertUser", user);
		return user;
	}

	/** @param 用户(t_user) 删除 */
	public int deleteUser(User user){
		// TODO: implement
		return delete("deleteUser", user);
	}

	/** @param 用户(t_user) 修改 */
	public int updateUser(User user){
		// TODO: implement
		return update("updateUser", user);
	}
	
	/** @param 用户(t_user) 修改 */
	public int updateUkeyUser(User user){
		// TODO: implement
		return update("updateUkeyUser", user);
	}

	/** @param 用户(t_user) 查询单条 */
	public User getUser(User user){
		// TODO: implement
		  Object obj = queryForObject("getUser", user);
		    return (obj == null) ? null : (User) obj;
	}
	
	/** @param 用户(t_user) 查询单条 */
	public User getPasswordByUseraccount(User user){
		// TODO: implement
		  Object obj = queryForObject("getPasswordByUseraccount", user);
		    return (obj == null) ? null : (User) obj;
	}

	/** @param 用户(t_user) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.username "+ desc;
			else if(sort.equals("1"))
				sCol = " a.useraccount "+ desc;
			else if(sort.equals("2"))
				sCol = " a.usertype "+ desc;
			else
				sCol = " a.userorder ";
		}else{
			sCol=" a.userorder ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getUserList", map, pageNo,pageSize);
	}

	/** @param 用户(t_user) 多条查询 */
	public List getListUser(User user){
		// TODO: implement
		return queryForList("getUserListNoPage", user);
	}

	public User checkUser(User user) {
		// TODO Auto-generated method stub
		   Object obj = queryForObject("checkUser", user);
		    return (obj == null) ? null : (User) obj;
	}

	public User checkCAUser(User user) {
		// TODO Auto-generated method stub
		   Object obj = queryForObject("checkCAUser", user);
		    return (obj == null) ? null : (User) obj;
	}
	
	public int updatePwd(User user) {
		// TODO Auto-generated method stub
		return update("updateUser",user);
	}
	
	/** 获得下一个排序号 */
	public  User getNextNodeorder(User user)
	{
		return (User) queryForObject("getNextUserorder", user);
	}
	
	/**
	 * 通过从业人员编号(即员工用户账号)获得所属企业编码及所属企业名称
	 * 默认一个员工用户只能属于一个行业
	 * @param user（usertype）
	 * @return user
	 */
	public User getQybmByCyrybh(String sqlStmt)
	{
		User user = new User();
		user.setSsdwbm(sqlStmt);
		return (User)queryForObject("getQybmByCyrybh", user);
	}
	/**
	   * 通过企业编码取的企业名称
	   * @param qybm
	   * @return qymc
		*/
	public String getQymcByQybm(String qybm)
	{
		User user = new User();
		user.setSsdwbm(qybm);
		user=(User)queryForObject("getQymcByQybm", user);
		String qymc=user.getSsdwmc();
		return qymc;
	}
	 /** @param 企业用户(t_user) 分页查询 */
	public Page getListForPageQyOrGa(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.username "+ desc;
			else if(sort.equals("1"))
				sCol = " a.useraccount "+ desc;
			else if(sort.equals("2"))
				sCol = " a.usertype "+ desc;
			else
				sCol = " a.userorder ";
		}else{
			sCol=" a.userorder ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getUserQyOrGaList", map, pageNo,pageSize);
	}

}
