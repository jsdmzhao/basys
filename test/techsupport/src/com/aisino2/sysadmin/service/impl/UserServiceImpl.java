package com.aisino2.sysadmin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IRoleDao;
import com.aisino2.sysadmin.dao.IUserDao;
import com.aisino2.sysadmin.dao.IUser_roleDao;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IUserService;

public class UserServiceImpl extends BaseService implements IUserService {

	private IUserDao userDao;
	  private IUser_roleDao user_roleDao;
	  private IRoleDao roleDao;
	/** @param 用户(t_user) 增加 */
	public User insertUser(User userOrigin){
		// TODO: implement
		//return (User)userDao.insertUser(user);
		User user = new User();
		//全局参数中存放的各用户类型的默认角色
		Map defaultRoleMap = new HashMap();
		defaultRoleMap = userOrigin.getDefaultRoleMap();
		String[] usertypeArr ;
		User_role user_role = null;
		int roleid = 0;
		user = userDao.insertUser(userOrigin);
		//为用户赋默认角色
		if(user != null)
		{
			if(user.getUsertype() != null)
			{
				if(!"".equals(user.getUsertype()))
				{
					usertypeArr = new String[user.getUsertype().split(",").length];
					usertypeArr = user.getUsertype().split(",");
					for(int i = 0;i<usertypeArr.length;i++)
					{
						if(defaultRoleMap.get("mrjs"+usertypeArr[i])!=null)
							if(!"".equals(defaultRoleMap.get("mrjs"+usertypeArr[i])))
							{
								user_role = new User_role();
								user_role.setUserid(user.getUserid());
								user_role.setRoleid(Integer.parseInt((String)defaultRoleMap.get("mrjs"+usertypeArr[i])));
								user_roleDao.insertUser_role(user_role);
								user_role = null;
							}
					}
				}
			}
		}
		return user;
	}

	/** @param 用户(t_user) 删除 */
	public boolean deleteUser(User user){
		// TODO: implement
		
	    boolean revalue = false;
	    // RoleUser userRole=new RoleUser();
	       //userRole.setUserID(user.getId());
	     int i = user_roleDao.deleteRoleUserByUser(user);
	       if(i>= 0){
	         revalue = userDao.deleteUser(user) >= 0;
	       }
	     return revalue;
		
	}

	/** @param 用户(t_user) 修改 */
	public boolean updateUser(User user){
		// TODO: implement
		return userDao.updateUser(user)>0;
	}

	/** @param 用户(t_user) 查询单条 */
	public User getUser(User user){
		// TODO: implement
		return (User)userDao.getUser(user);
	}
	
	/** @param 用户(t_user) 查询单条 */
	public User getPasswordByUseraccount(User user){
		// TODO: implement
		return (User)userDao.getPasswordByUseraccount(user);
	}

	/** @param 用户(t_user) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return userDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 用户(t_user) 多条查询 */
	public List getListUser(User user){
		// TODO: implement
		return userDao.getListUser(user);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public User checkUser(User user) {
		// TODO Auto-generated method stub
		 return userDao.checkUser(user);
	}
	
	public User checkCAUser(User user) {
		// TODO Auto-generated method stub
		 return userDao.checkCAUser(user);
	}

	public boolean deleteRolesFromUser(User user) {
		// TODO Auto-generated method stub
		 boolean revalue = true;
		    List list = user.getUserRoles();
		    User_role userRole=null;
		    for (int i = 0; i < list.size(); i++) {
		      userRole = (User_role) list.get(i);
		      revalue = user_roleDao.deleteUser_role(userRole) > 0;
		      
		    }
		    return revalue;
	}
	
	
	/**
	    * 用户的上移、下移、置顶、置底
	    * @param userOrigin
	    * user.way取值：上移,下移,置顶,置底
	    * @return
	    */
	public  boolean updateUserEditEdOrder(User userOrigin)
	{
		boolean isSuccess = false;
		User user = new User();
		User userParent = new User();
		User swapUser = new User();
		int swapUserorder = -1;
		int swapUserorderTwo = -1;
		Integer userid = userOrigin.getUserid();
		//获得user的所有兄弟节点,包括自身
		user.setUserid(userid);
		user = userDao.getUser(user);
		userParent.setDepartid(user.getDepartid());
		List siblingList = userDao.getListUser(userParent);
		
		//若无兄弟节点，则无需进行移动操作
		if(siblingList == null)
			return true;
		else if(siblingList.size()==0)
			return true;

		if(userOrigin !=null)
		{
			swapUserorder = user.getUserorder();
			if(user != null)
			{
				if(userOrigin.getWay()!=null)
				{
					for(int i = 0;i<siblingList.size();i++)
					{
						user = (User)siblingList.get(i);
						if(userid.equals(user.getUserid()))
						{
							if(userOrigin.getWay().equals("上移"))
							{
								if(i>0)//第一个子节点无需上移
								{
									//交换需上移节点与其上一个节点的排序号
									swapUser = (User)siblingList.get(i-1);
									user.setUserorder(swapUser.getUserorder());
									swapUser.setUserorder(swapUserorder);
									userDao.updateUser(swapUser);
									userDao.updateUser(user);
									
								}
								else
									break;
							}
							else if(userOrigin.getWay().equals("下移"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需下移
								{
									//交换需下移节点与其下一个节点的排序号
									swapUser = (User)siblingList.get(i+1);
									user.setUserorder(swapUser.getUserorder());
									swapUser.setUserorder(swapUserorder);
									userDao.updateUser(swapUser);
									userDao.updateUser(user);
									
								}
								else
									break;
							}
							else if(userOrigin.getWay().equals("置顶"))
							{
								if(i>0)//第一个子节点无需置顶
								{
									swapUser = (User)siblingList.get(0);
									user.setUserorder(swapUser.getUserorder());
									userDao.updateUser(user);
									for(int j = i;j>0;j--)
									{
										swapUser = (User)siblingList.get(j-1);
										swapUserorderTwo = swapUser.getUserorder();
										swapUser.setUserorder(swapUserorder);
										userDao.updateUser(swapUser);
										swapUserorder = swapUserorderTwo;
									}
									
								}
								else
									break;
							}
							else if(userOrigin.getWay().equals("置底"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需置底
								{
									swapUser = (User)siblingList.get(siblingList.size()-1);
									user.setUserorder(swapUser.getUserorder());
									userDao.updateUser(user);
									for(int j = i;j<siblingList.size()-1;j++)
									{
										swapUser = (User)siblingList.get(j+1);
										swapUserorderTwo = swapUser.getUserorder();
										swapUser.setUserorder(swapUserorder);
										userDao.updateUser(swapUser);
										swapUserorder = swapUserorderTwo;
									}
								}
								else
									break;
							}
						}
					}
				}
			}
		}
		
		return true;
	}

	public List getOptionUserRoles(User user) {
		// TODO Auto-generated method stub
		return roleDao.getOptionRolesForUser(user);
	}

	public List getUserRoles(User user) {
		// TODO Auto-generated method stub
		  return roleDao.getRolesByUser(user);
	}

	public boolean insertRolesToUser(User user) {
		// TODO Auto-generated method stub
		  boolean revalue = true;
		    List list = user.getUserRoles();
		    User_role userRole=null;
		    for (int i = 0; i < list.size(); i++) {
		      userRole = (User_role) list.get(i);
		      revalue = user_roleDao.insertUser_role(userRole) != null;
		   
		    }
		    return revalue;
	}

	public boolean updatePwd(User user) {
		// TODO Auto-generated method stub
		//user.setPassword(EncryptUtil.getMD5Code(user.getPassword()));
		return userDao.updatePwd(user)>0;
	}
	
	/**
	   * 修改用户角色
	   * @param user_role
	   * @return
	   */
	public  boolean updateUser_role(User user)
	{
		boolean isSuccess = false;
		User_role user_role = null;
		User_role deleteUser_role = new User_role();
		List user_roleList = new ArrayList();
		if(user != null)
		{
			if(user.getUserid() != null)
			{
				//删除该用户所有角色
				deleteUser_role.setUserid(user.getUserid());
				user_roleDao.deleteUser_role(deleteUser_role);
				//添加角色
				if(user.getLUserRoleList()!= null)
				{
					for(int i = 0;i<user.getLUserRoleList().size();i++)
					{
						user_role = new User_role();
						user_role = (User_role)user.getLUserRoleList().get(i);
						user_role.setUserid(user.getUserid());
						user_roleDao.insertUser_role(user_role);
						user_role = null;
					}
				}
				isSuccess = true;
			}
			
		}
		
		return isSuccess;
	}
	
	/**
	   * 获得下一个排序号
	   * @param user.departid
	   * @return 
	*/
	public Integer getNextNodeorder(User user)
	{
		Integer nextNodeorder = 0;
		User newUser = new User();
		newUser = userDao.getNextNodeorder(user);
		if(newUser != null)
		{
			nextNodeorder = newUser.getUserorder();
		}
		return nextNodeorder;
	}
	
	/**
	 * 通过从业人员编号(即员工用户账号)获得所属企业编码及所属企业名称
	 * 默认一个员工用户只能属于一个行业
	 * @param user（usertype）
	 * @return user
	 */
	public User getQybmByCyrybh(User user)
	{
		String usertype = user.getUsertype();
		String qybmzdm = "";//企业编码字段名
		String qybmzmc = "";//企业名称字段名
		String rybm= "";//人员表名
		String qybm = "";//企业表名
		String rybzj = "";//人员表与企业表关联字段
		String qybzj = "";//企业表与人员表关联字段
		String cyrybh = "";//从业人员编号
		//获取全局变量ddyversion，解决新老版本问题
		String ddyversion="";
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode("ddyversion");
		List globalparList = new ArrayList();
		globalparList = CacheManager.getCacheGlobalpar(globalpar);
		if(globalparList!=null&&globalparList.size()>0){
			Globalpar glo = ((Globalpar) globalparList.get(0));
			 ddyversion = glo.getGlobalparvalue();
		}
		if ("old".equals(ddyversion)){
			if(user.getUsertype().indexOf("32")>-1)//典当员工
			{
				qybmzdm = "ddqybm";
				qybmzmc = "ddqymc";
				rybm= "t_ddcyryxx";
				qybm = "t_ddqyxx";
				rybzj = "ddqyid";
				qybzj = "ddqyid";
				cyrybh = "cyrybh";
			}
		}
		
		/*else if(user.getUsertype().indexOf("42")>-1)//机修员工
		{
			qybmzdm = "jxqybm";
			qybmzmc = "jxqymc";
			rybm= "t_jxcyryxx";
			qybm = "t_jxqyxx";
			rybzj = "jxqyid";
			qybzj = "jxqyid";
			cyrybh = "cyrybh";
		}*/
		if((user.getUsertype().indexOf("32")>-1&&!"old".equals(ddyversion))
				||user.getUsertype().indexOf("42")>-1
				||user.getUsertype().indexOf("62")>-1
				||user.getUsertype().indexOf("72")>-1
				||user.getUsertype().indexOf("82")>-1
				||user.getUsertype().indexOf("92")>-1
				||user.getUsertype().indexOf("102")>-1
				||user.getUsertype().indexOf("152")>-1
				||user.getUsertype().indexOf("162")>-1)
			//二手车、二手机、废旧金属、出租车、汽车租赁员工。增加使用公用从业人员的行业时，可在此语句中增加判断
		{//新增典当、机修业使用公用从业人员
			qybmzdm = "qybm";
			qybmzmc = "qymc";
			rybm= "t_qyryxx";
			qybm = "t_qyjbxx";
			rybzj = "qyid";
			qybzj = "qyid";
			cyrybh = "cyrybh";
		}
		//组装查询语句
		StringBuffer sqlStmt = new StringBuffer();
		sqlStmt.append(" select b.");
		sqlStmt.append(qybmzdm);
		sqlStmt.append(" as ssdwbm,b." );
		sqlStmt.append(qybmzmc);
		sqlStmt.append(" as ssdwmc " );
		sqlStmt.append(" from ");
		sqlStmt.append(rybm);
		sqlStmt.append(" a , ");
		sqlStmt.append(qybm);
		sqlStmt.append("  b where a.");
		sqlStmt.append(rybzj);
		sqlStmt.append(" =b.");
		sqlStmt.append(qybzj);
		sqlStmt.append(" and a.");
		sqlStmt.append(cyrybh);
		sqlStmt.append(" = '");
		sqlStmt.append(user.getUseraccount());
		sqlStmt.append("' ");
		
		user = userDao.getQybmByCyrybh(sqlStmt.toString());

		return user;
	}
	 /** @param 企业用户(t_user) 分页查询 */
	public Page getListForPageGa(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		sheZhiCxtj(map, "ga");
		return userDao.getListForPageQyOrGa(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业用户(t_user) 分页查询 */
	public Page getListForPageQy(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		sheZhiCxtj(map, "qy");
		return userDao.getListForPageQyOrGa(map,pageNo,pageSize,sort,desc);
	}
  	private void sheZhiCxtj(Map map, String leiXing){
		String usertype = (String)map.get("usertype");
		//公安用户为!=,企业用户为=
		String ljf = "=";
		String lianJie = "or";
		boolean usertypeNull = (usertype==null || usertype.equals(""));
		if(leiXing.equals("ga")){
			ljf = "!=";
			lianJie = "and";
			usertype = "instr((usertype||','),'" + usertype + "')>0";
		}else if(leiXing.equals("qy")){
			ljf = "=";
			lianJie = "or";
			usertype = "usertype='" + usertype +"'";
		}
		if(usertypeNull){
			StringBuffer userTypeTj = new StringBuffer();
			//娱乐企业
			userTypeTj.append("(usertype");
			userTypeTj.append(ljf);
			userTypeTj.append("'13' ");
			//典当企业和企业员工
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'33' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'32' ");

			//机修企业和企业员工
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'43' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'42' ");

			//印章制作企业和使用企业
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'52' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'53' ");

			//旧机动车企业和企业员工
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'63' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'62' ");
			
			//旧移动电话交易企业和企业员工
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'73' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'72' ");
			
			//废旧金属收购企业和企业员工
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'83' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'82' ");

			//出租汽车企业和企业员工
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'93' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'92' ");

			//汽车租赁企业和企业员工
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'103' ");
			szLjfAndLianJie(userTypeTj,lianJie,ljf,"'102' ");
			
			userTypeTj.append(")");
			map.put("usertype",userTypeTj.toString());
		}else{
			map.put("usertype", usertype);
		}
	}
	
	//设置逻辑符和连接符
	private void szLjfAndLianJie(StringBuffer userTypeTj,String lianJie,String ljf,String yhlb){
		userTypeTj.append(lianJie);
		userTypeTj.append(" usertype");
		userTypeTj.append(ljf);
		userTypeTj.append(yhlb);
	}
	public String getQymcByQybm(String qybm){
		String qymc="";
		return qymc=userDao.getQymcByQybm(qybm);
	}
	

	public IUser_roleDao getUser_roleDao() {
		return user_roleDao;
	}

	public void setUser_roleDao(IUser_roleDao user_roleDao) {
		this.user_roleDao = user_roleDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	
}
