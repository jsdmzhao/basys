package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.EncryptUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.authorization.IIdentityAuthorization;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IRoleService;
import com.aisino2.sysadmin.service.ISystemService;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.sysadmin.service.IUser_roleService;

public class UserAction extends PageAction{
	private IUserService userService;
	private ISystemService systemService;
	private IIdentityAuthorization identityAuthorization;
	private IRoleService roleService;
	private IUser_roleService userRoleService;
	private IDict_itemService dict_itemService;
	private List lUser;
	private User user;
	private String tabledata;
	private int totalrows;
	private String result="success";
	
	private String moveParentid;
	private String moveSelectId;
	private String moveWay;
	private String jzlbdm;
	private String strResult = "";
	private String strResult1 = "";
	private String passwordResult;
	
	private List deptRoleList; //部门角色
	private List userRoleList; //用户角色
	
	private List loginUserRoleOutDeptList;//登陆账号的（除本身部门及以下部门)的角色

	
	public List getLoginUserRoleOutDeptList() {
		return loginUserRoleOutDeptList;
	}
	public void setLoginUserRoleOutDeptList(List loginUserRoleOutDeptList) {
		this.loginUserRoleOutDeptList = loginUserRoleOutDeptList;
	}
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
	public String getTabledata() {
		return tabledata;
	}
	public User getUser() {
		return user;
	}
	public List getLUser() {
		return lUser;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public void setIdentityAuthorization(
			IIdentityAuthorization identityAuthorization) {
		this.identityAuthorization = identityAuthorization;
	}
	public void setMoveParentid(String moveParentid) {
		this.moveParentid = moveParentid;
	}
	public void setMoveSelectId(String moveSelectId) {
		this.moveSelectId = moveSelectId;
	}
	public void setMoveWay(String moveWay) {
		this.moveWay = moveWay;
	}
	public String getStrResult() {
		return strResult;
	}
	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public void setUserRoleService(IUser_roleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	public List getDeptRoleList() {
		return deptRoleList;
	}
	public void setDeptRoleList(List deptRoleList) {
		this.deptRoleList = deptRoleList;
	}
	public List getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List userRoleList) {
		this.userRoleList = userRoleList;
	}
	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
	public String getStrResult1() {
		return strResult1;
	}
	public void setJzlbdm(String jzlbdm) {
		this.jzlbdm = jzlbdm;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("userid");
		lPro.add("username");
		lPro.add("useraccount");
		lPro.add("usertypename");

		List lDetail=new ArrayList();
		lDetail.add("setUserDetail");
		lDetail.add("详细");
    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lRole=new ArrayList();
    	lRole.add("setUserRole");
    	lRole.add("角色维护");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lPwd=new ArrayList();
    	lPwd.add("resetPwd");
    	lPwd.add("重置密码");
    	
    	List lCol=new ArrayList();
    	lCol.add(lDetail);
    	lCol.add(lModify);
    	lCol.add(lRole);
    	lCol.add(lDel);
    	lCol.add(lPwd);
    	
    	User getUser=new User();
    	
        this.setData(getUser,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	

	public void setTabledataRole_User(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("userid");
		lPro.add("checkbox");
		lPro.add("departname");
		lPro.add("username");
		lPro.add("useraccount");
		lPro.add("usertypename");
    	
    	User getUser=new User();
    	
        this.setData(getUser,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	/**
	 * 用户管理入口 参数：机构代码

	 * @return
	 */
	public String queryUser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String departid = request.getParameter("departid");
		if(departid==null||"".equals(departid)){
			departid = "0";
		}
		request.setAttribute("departid", departid);
		return "userMan";
	}
	/**
	 * 用户角色管理入口 参数：机构代码

	 * @return
	 */
	public String queryUserRole(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String departid = request.getParameter("departid");
		if(departid==null||"".equals(departid)){
			departid = "0";
		}
		request.setAttribute("roledepartid", departid);
		return "userRole";
	}
	/**
	 * 角色用户管理入口 参数：机构代码

	 * @return
	 */
	public String queryRoleUser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String roleid = request.getParameter("roleid");
		if(roleid==null||"".equals(roleid)){
			roleid = "0";
		}
		request.setAttribute("roleid", roleid);
		return "roleUser";
	}
	/**
	 * 根据条件请求列表
	 * @return
	 */
	public String querylist() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		User userTemp = (User) session.getAttribute(Constants.userKey);
		try {
			User setUser=new User();
			user=(User)this.setClass(setUser, null);
			Map map = new HashMap();
			map.put("departid", user.getDepartid());
			map.put("useraccount", user.getUseraccount());
			map.put("username", user.getUsername());
			map.put("jzlbdm", user.getJzlbdm());
			Page page = userService.getListForPage(map, pagesize, pagerow,null,null);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lUser=page.getData();
			List listtemp = new ArrayList();
			if(lUser!=null&&lUser.size()>0){
				for(int index=0,max=lUser.size();index<max;index++){
					User temp = (User)lUser.get(index);
					if(temp!=null&&temp.getUsertype()!=null){
						String[] usretype = temp.getUsertype().split(",");
						String userTypeName = "";
						for(int index1=0,max1=usretype.length;index1<max1;index1++){
							Dict_item dict_item = new Dict_item();
							dict_item.setDict_code("dm_yhlb");
							dict_item.setFact_value(usretype[index1]);
							List list= CacheManager.getCacheDictitem(dict_item);
							if(list!=null&&list.size()>0){
								userTypeName += ((Dict_item)list.get(0)).getDisplay_name() + " ";
							}
						}
						temp.setUsertypename(userTypeName);
					}
					if(!userTemp.getUseraccount().equals(temp.getUseraccount())){
						listtemp.add(temp);
					}
				}
			}
			setTabledata(listtemp);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 查找单条
	 * @return
	 */
	public String query() throws Exception{
		try {
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			setUser=userService.getUser(setUser);
			
			if(setUser!=null){
				Dict_item dict_item = new Dict_item();
				dict_item.setDict_code("dm_bez");
				dict_item.setFact_value(setUser.getIsvalid()); //是否有效
				List list= CacheManager.getCacheDictitem(dict_item);
				if(list!=null&&list.size()>0){
					setUser.setIsvalidValue(((Dict_item)list.get(0)).getDisplay_name());
				}
				
				dict_item = new Dict_item();
				dict_item.setDict_code("dm_yhlb");
				String[] usretype = setUser.getUsertype().split(",");
				String userTypeName = "";
				for(int index=0,max=usretype.length;index<max;index++){
					dict_item.setFact_value(usretype[index]); //用户类别
					list= CacheManager.getCacheDictitem(dict_item);
					if(list!=null&&list.size()>0){
						userTypeName += ((Dict_item)list.get(0)).getDisplay_name() + "<br>";
					}
				}
				setUser.setUsertypename(userTypeName);
			}
			lUser = new ArrayList();
			lUser.add(setUser);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 获取用户类别
	 * @return
	 */
	public String findUserType(){
		Map jzyhlb = queryDictMapForDictcode("jzyhlb"+jzlbdm);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		User sessionUser = (User)session.getAttribute(Constants.userKey);
		String sessionUserType = sessionUser.getUsertype();
		if(!sessionUserType.equals("13")){
			sessionUserType = "";
		}

		List lusertype = queryListMapForCodeAValue("dm_yhlb",sessionUserType);
		if(lusertype!=null&&lusertype.size()>0){
			for(int index=0,max=lusertype.size();index<max;index++){
				Dict_item dictItemTemp = (Dict_item)lusertype.get(index);
				String factValue = dictItemTemp.getFact_value();
				if(valJzlb(jzyhlb,factValue)||(jzlbdm==null||"".equals(jzlbdm))){ //选择警种则过滤 不选不过滤
					if(!"9999".equals(factValue)){
						String ut = "<input type='checkbox' id='yhlb_"+factValue+"'/>"
						+dictItemTemp.getDisplay_name()+"<br>";
						strResult += ut;
					}
				}
			}
		}
		this.result="success";
        return "success";
	}
	/**
	 * 获取用户类别 双排
	 * @return
	 */
	public String findUserType1(){
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code("dm_yhlb");
		List lusertype = dict_itemService.getListDict_item(dict_item);
		if(lusertype!=null&&lusertype.size()>0){
			int len = lusertype.size()/2;
			for(int index=0,max=lusertype.size();index<max;index++){
				Dict_item dictItemTemp = (Dict_item)lusertype.get(index);
				if(!dictItemTemp.getFact_value().equals("9999")){
						String ut = "<input type='checkbox' id='yhlb_"+dictItemTemp.getFact_value()+"'/>"
							+dictItemTemp.getDisplay_name()+"<br>";
						
						if(index<len){
							strResult += ut;
						} else {
							strResult1 += ut;
						}
				}
			}
		}
		this.result="success";
        return "success";
	}
	public String insert() throws Exception{
		try {
			/*ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();*/
			
			Map map = new HashMap();
			Globalpar globalpar = new Globalpar();
			List globalparList = new ArrayList();
			globalpar.setGlobalparcode("mrjs");//内存中取全局参数中的所有默认角色

			globalparList = CacheManager.getCacheGlobalpar(globalpar);
			//将默认角色放入map
			if(globalparList!=null)
			{
				for(int i = 0;i<globalparList.size();i++)
				{
					globalpar = (Globalpar)globalparList.get(i);
					map.put(globalpar.getGlobalparcode(), globalpar.getGlobalparvalue());
				}
			}
			
			/*map.put("mrjs11", session.getAttribute("mrjs11"));
			map.put("mrjs12", session.getAttribute("mrjs12"));
			map.put("mrjs13", session.getAttribute("mrjs13"));
			map.put("mrjs14", session.getAttribute("mrjs14"));
			map.put("mrjs21", session.getAttribute("mrjs21"));
			map.put("mrjs22", session.getAttribute("mrjs22"));
			map.put("mrjs23", session.getAttribute("mrjs23"));
			map.put("mrjs24", session.getAttribute("mrjs24"));*/
			
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			String userType = setUser.getUsertype();
			setUser.setUsertype(userType.substring(0, userType.length()-1));
			setUser.setDefaultRoleMap(map);
			userService.insertUser(setUser);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			User setUser=new User();
			user=(User)this.setClass(setUser, null);
			String userType = user.getUsertype();
			user.setUsertype(userType.substring(0, userType.length()-1));
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	/** 重置用户密码 */
	public String redoUserPwd() throws Exception{
		try {
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			setUser.setPassword(EncryptUtil.getMD5Code("1"));
			userService.updateUser(setUser);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User userLog = (User)session.getAttribute(Constants.userKey);
		try {
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			int userid = setUser.getUserid();
			int temp = userLog.getUserid();
			if(temp!=userid){
				userService.deleteUser(setUser);
			} else {
				this.result="请用管理员帐户进行删除";
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	/**
	 * 根据用户ID 查角色

	 * @return
	 */
	public String queryUsreRoleList() throws Exception{
		try {
			userRoleList = new ArrayList();
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			User_role user_role = new User_role();
			user_role.setUserid(setUser.getUserid());
			userRoleList = userRoleService.getUser_roleListByUserid(user_role);
			
			if(userRoleList!=null&&userRoleList.size()>0){
				//便于页面显示
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				User loginuser = (User)session.getAttribute(Constants.userKey);
				int deptid = loginuser.getDepartid();
				List deptRolelistone = roleService.getDeptRoleList(loginuser);//取得部门及下属部门所有的角色。

				
				if(deptRolelistone==null||deptRolelistone.size()==0){
					//没有角色
				  for(int i=0;i<userRoleList.size();i++){
					  ((User_role)userRoleList.get(i)).setDepartid(deptid);
				   }
				}else{
					HashMap map = new HashMap();
					for(int j=0;j<deptRolelistone.size();j++){
				    	map.put(((Role)deptRolelistone.get(j)).getRoleid(), "n");
				    }
					for(int i=0;i<userRoleList.size();i++){
						     if(map.get(((User_role)userRoleList.get(i)).getRoleid())==null){
						    	((User_role)userRoleList.get(i)).setDepartid(deptid);
						     }
					   }
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	
	
	/**
	 * 根据点击的部门ID，登陆账号的部门id 查登陆账号具有的非所在部门和下属部门的角色

	 * @return
	 */
	public String queryLoginUserRoleListOutDept() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User loginuser = (User)session.getAttribute(Constants.userKey);
		int deptid = loginuser.getDepartid();
		try {
			loginUserRoleOutDeptList = new ArrayList();
			Department setDepartment=new Department();
			setDepartment=(Department)this.setClass(setDepartment, null);
			
			if(setDepartment.getDepartid()==deptid){	
				loginUserRoleOutDeptList = roleService.getloginUserRoleOutDeptList(loginuser);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	

	
	/**
	 * 根据部门ID 查角色

	 * @return
	 */
	public String queryDeptRoleList() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		User userSession = (User) session.getAttribute(Constants.userKey);
		try {
			deptRoleList = new ArrayList();
			Department setDepartment=new Department();
			setDepartment=(Department)this.setClass(setDepartment, null);
			Role role = new Role();
			role.setDepartid(setDepartment.getDepartid());
			String jzlbdm = userSession.getJzlbdm();
			if(jzlbdm!=null&&!"".equals(jzlbdm)){
				role.setJzlbdm(jzlbdm);
			}
			deptRoleList = roleService.getListRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	

	/**
	 * 根据角色ID 查用户

	 * @return
	 */
	public String queryUserListByRole() throws Exception{
		try {
			userRoleList = new ArrayList();
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			User_role user_role = new User_role();
			user_role.setUserid(setUser.getUserid());
			userRoleList = userRoleService.getListUser_role(user_role);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 根据部门ID 查用户

	 * @return
	 */
	public String queryUserList() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		User sessionUser = (User)session.getAttribute(Constants.userKey);
		try {
			User setUser = new User();
			setUser=(User)this.setClass(setUser, null);
			setUser.setDepartcode(StringUtil.trimEven0(sessionUser.getDepartment().getDepartcode()));
			List lUser = userService.getListUser(setUser);
			List luserTemp = new ArrayList();

			User_role user_role = new User_role();
			user_role=(User_role)this.setClass(user_role, null);
			List userRoleList = userRoleService.getListUser_role(user_role);
			if(userRoleList==null){
				userRoleList = new ArrayList();
			}
			
			Map utMap = new HashMap();
			utMap.put("", null);
			Dict_item dict_item = new Dict_item();
			dict_item.setDict_code("dm_yhlb");
			List lusertype = dict_itemService.getListDict_item(dict_item);
			for(int indexut=0,maxut=lusertype.size();indexut<maxut;indexut++){
				Dict_item dictItemTemp = (Dict_item)lusertype.get(indexut);
				utMap.put(dictItemTemp.getFact_value(), dictItemTemp.getDisplay_name());
			}
			
			Map userRoleMap = new HashMap();
			if(userRoleList!=null&&userRoleList.size()>0){
				for(java.util.Iterator iter=userRoleList.iterator();iter.hasNext();){
					User_role newUserRole = (User_role)iter.next();
					userRoleMap.put(newUserRole.getUserid(), "1");
				}
			}
			if(lUser!=null&&lUser.size()>0){
				for(int index=0,max=lUser.size();index<max;index++){
					User temp = (User)lUser.get(index);
					if(temp!=null&&temp.getUsertype()!=null){
						temp.setUsertypename((String)utMap.get(temp.getUsertype()));
					}
					if(userRoleMap.get(temp.getUserid())!=null){
						temp.setCheckbox("<input type='checkbox' name='"+temp.getUserid()+"' style='width:16' onClick='validateChecked(this);' checked='true' />");
					} else {
						temp.setCheckbox("<input type='checkbox' name='"+temp.getUserid()+"' style='width:16' onClick='validateChecked(this);' />");
					}
					temp.setDepartname(temp.getDepartment().getDepartname());
					if(!sessionUser.getUseraccount().equals(temp.getUseraccount())){
						luserTemp.add(temp);
					}
				}
			}
			setTabledataRole_User(luserTemp);
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result="查询失败";
		}
        return "success";
    }
	
	/**
	 * 修改用户角色
	 * @return
	 */
	public String updateUserRole(){
		try {
			Role setrole = new Role();
			setrole=(Role)this.setClass(setrole, null);
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			
			Integer userid = setUser.getUserid();
			String roleidString = setrole.getRoleidString();
			String[] roleids = roleidString.split("\\|");
			List roleList = new ArrayList();
			if(!"".equals(roleidString)&&roleids!=null&&roleids.length>0){
				for(int index=0,max=roleids.length;index<max;index++){
					User_role temp = new User_role();
					temp.setUserid(userid);
					temp.setRoleid(Integer.parseInt(roleids[index]));
					roleList.add(temp);
				}
			}
			setUser.setLUserRoleList(roleList);
			userService.updateUser_role(setUser);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
    
	
	/**
	 * 修改角色用户
	 * @return
	 */
	public String insertRoleUser(){
		try {
			Role setrole = new Role();
			setrole=(Role)this.setClass(setrole, null);//得到roleid
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);//得到userid集合
			
			Integer roleid = setrole.getRoleid();
			String useridSet = setUser.getUseridSet();
			if(useridSet!=null && !useridSet.equals("")){
				String[] useridArry = useridSet.split("_,,");
				List roleList = new ArrayList();
				for(int index=0,max=useridArry.length;index<max;index++){
					User_role temp = new User_role();
					temp.setRoleid(roleid);
					temp.setUserid(Integer.parseInt(useridArry[index]));
					roleList.add(temp);
				}
				setrole.setLUserRoleList(roleList);
			}
			roleService.updateUser_role(setrole);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="保存失败";
			return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 移动排序
	 * @return
	 */
	public String moveSort(){
		try {
			User moveUser = new User();
			moveUser.setDepartid(Integer.parseInt(moveParentid));
			moveUser.setUserid(Integer.parseInt(moveSelectId));
			moveUser.setWay(moveWay);
			userService.updateUserEditEdOrder(moveUser);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	/**
	 * 获取 兄弟节点最大排序号
	 * @return
	 */
	public String nextNodeorder(){
		try {
			strResult = "";
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			strResult = String.valueOf(userService.getNextNodeorder(setUser));
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	/**
	 * 验证用户帐号
	 * @return
	 */
	public String validateUser(){
		try {
			User setUser=new User();
			user=(User)this.setClass(setUser, null);
			String useraccount = user.getUseraccount();
			Map map = new HashMap();
			map.put("tableName", "t_user");
			if(useraccount!=""){
				map.put("useraccount", useraccount);
			}
			boolean result = systemService.isExit(map);
			strResult = "";
			if(result){	
				strResult = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	/**
	 * 修改登录用户密码
	 * @return
	 */
	public String updatePassword()
	{
		try {
			User setUser = new User();
			user = (User)this.setClass(setUser, null);
			String passwordNew = user.getPasswordNew();
			user = (User) identityAuthorization.getUser(user.getUseraccount(), user.getPassword());
			if (user == null) {
				this.result="原口令错误";
			} else {
				user.setPassword(passwordNew);
				userService.updatePwd(user);
				this.result="success";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="修改失败";
		}
		return "success";
	}
	
	/**
	 * 查找单条
	 * @return
	 */
	public String queryPasswordByUseraccount() throws Exception{
		try {
			User setUser=new User();
			setUser=(User)this.setClass(setUser, null);
			setUser=userService.getPasswordByUseraccount(setUser);

			if(setUser != null)
				passwordResult = setUser.getPassword();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	private String idnum;  /////身份证号码 18
	
	private String idnum15; ////身份证号码 15
	
	private String userAccP; ///用户的用户名||密码
	
	public String getUserAccP() {
		return userAccP;
	}

	public void setUserAccP(String userAccP) {
		this.userAccP = userAccP;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	/**
	 * 根据身份证号码 得到用户名 和密码   格式为：用户名||密码
	 * @return
	 */
	public String queryUserlogin(){
		
		User numuser = new User();
		try {
			numuser.setIdnum(idnum);
			numuser.setIdnum15(idnum15);
			
			List userList = userService.getListUser(numuser);
			if(userList!=null){
				if(userList.size()>0){
					numuser = new User();
					numuser = (User)userList.get(0);
					userAccP = numuser.getUseraccount() + "||" + numuser.getPassword();
				}
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
		return "success";
		
	}
	public Map queryDictMapForDictcode(String dictCode){ //根据字典代码
		Map jzyhlb = new HashMap();
		List list = queryListMapForDictcode(dictCode);
		if(list!=null&&list.size()>0){
			for(int index=0,max=list.size();index<max;index++){
				Dict_item temp = (Dict_item)list.get(index);
				jzyhlb.put(temp.getFact_value(), temp.getDisplay_name());
			}
		}
		return jzyhlb;
	}
	public List queryListMapForDictcode(String dictCode){ //从全局参数取警种用户类别
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(dictCode);
		dict_item.setItem_allpin("");
		dict_item.setItem_simplepin("");
		dict_item.setFact_value("");
		dict_item.setDisplay_name("");
		dict_item.setAppend_value("");
		List list = CacheManager.getCacheDictitem(dict_item);
		return list;
	}	
	
	public List queryListMapForCodeAValue(String dictCode,String dictValue){ //从全局参数取警种用户类别
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(dictCode);
		dict_item.setItem_allpin("");
		dict_item.setItem_simplepin("");
		dict_item.setFact_value(dictValue);
		dict_item.setDisplay_name("");
		dict_item.setAppend_value("");
		List list = CacheManager.getCacheDictitem(dict_item);
		return list;
	}
	public boolean valJzlb(Map jzyhlb,String factValue){ //过滤警种使用的用户类别
		if(jzyhlb!=null&&factValue!=null){
			//map里：060和121 意义：061、062、063、064、121
			if(factValue.length()==2){
				factValue = "0"+factValue;
			}
			if(jzyhlb.get(factValue)!=null){
				return true;
			}
			factValue = factValue.substring(0, 2)+"0";
			if(jzyhlb.get(factValue)!=null){
				return true;
			}
		}
		return false;
	}
	  private void sheZhiCxtj(Map map){
			map.put("departid", user.getDepartid());
			map.put("useraccount", user.getUseraccount());
			map.put("username", user.getUsername());
			map.put("jzlbdm", user.getJzlbdm());
			map.put("usertype", user.getUsertype());
		}

		/**
		 * 根据条件请求列表
		 * @return
		 */
		public String querylistGa() throws Exception{
			HttpSession session = ServletActionContext.getRequest().getSession();
			User userTemp = (User) session.getAttribute(Constants.userKey);
			try {
				User setUser=new User();
				user=(User)this.setClass(setUser, null);
				
				Map map = new HashMap();
				sheZhiCxtj(map);

				Page page = userService.getListForPageGa(map, pagesize, pagerow,null,null);
				totalpage=page.getTotalPages();
				totalrows=page.getTotalRows();
				lUser=page.getData();
				List listtemp = new ArrayList();
				if(lUser!=null&&lUser.size()>0){
					for(int index=0,max=lUser.size();index<max;index++){
						User temp = (User)lUser.get(index);
						if(temp!=null&&temp.getUsertype()!=null){
							String[] usretype = temp.getUsertype().split(",");
							String userTypeName = "";
							for(int index1=0,max1=usretype.length;index1<max1;index1++){
								Dict_item dict_item = new Dict_item();
								dict_item.setDict_code("dm_yhlb");
								dict_item.setFact_value(usretype[index1]);
								List list= CacheManager.getCacheDictitem(dict_item);
								if(list!=null&&list.size()>0){
									userTypeName += ((Dict_item)list.get(0)).getDisplay_name() + " ";
								}
							}
							temp.setUsertypename(userTypeName);
						}
						if(!userTemp.getUseraccount().equals(temp.getUseraccount())){
							listtemp.add(temp);
						}
					}
				}
				setTabledata(listtemp);
			} catch (Exception e) {
				e.printStackTrace();
				this.result="";
				return "success";
			}
			this.result="success";
	        return "success";
	    }
		
		public void setTabledataQy(List lData) throws Exception{
			List lPro=new ArrayList();
			lPro.add("userid");
			lPro.add("username");
			lPro.add("useraccount");
			lPro.add("usertypename");

			List lDetail=new ArrayList();
			lDetail.add("setUserDetail");
			lDetail.add("详细");
	    	
	    	List lDel=new ArrayList();
	    	lDel.add("setDelete");
	    	lDel.add("删除");
	    	
	    	List lPwd=new ArrayList();
	    	lPwd.add("resetPwd");
	    	lPwd.add("重置密码");
	    	
	    	List lCol=new ArrayList();
	    	lCol.add(lDetail);
	    	lCol.add(lDel);
	    	lCol.add(lPwd);
	    	
	    	User getUser=new User();
	    	
	        this.setData(getUser,lData,lPro,lCol);
	        this.tabledata=this.getData();
	        totalrows=this.getTotalrows();
		}
		
		/**
		 * 企业用户查询
		 * @return
		 */
		public String querylistQy() throws Exception{
			HttpSession session = ServletActionContext.getRequest().getSession();
			User userTemp = (User) session.getAttribute(Constants.userKey);
			try {
				User setUser=new User();
				user=(User)this.setClass(setUser, null);
				
				Map map = new HashMap();
				sheZhiCxtj(map);
				
				Page page = userService.getListForPageQy(map, pagesize, pagerow,null,null);
				totalpage=page.getTotalPages();
				totalrows=page.getTotalRows();
				lUser=page.getData();
				List listtemp = new ArrayList();
				if(lUser!=null&&lUser.size()>0){
					for(int index=0,max=lUser.size();index<max;index++){
						User temp = (User)lUser.get(index);
						if(temp!=null&&temp.getUsertype()!=null){
							String[] usretype = temp.getUsertype().split(",");
							String userTypeName = "";
							for(int index1=0,max1=usretype.length;index1<max1;index1++){
								Dict_item dict_item = new Dict_item();
								dict_item.setDict_code("dm_yhlb");
								dict_item.setFact_value(usretype[index1]);
								List list= CacheManager.getCacheDictitem(dict_item);
								if(list!=null&&list.size()>0){
									userTypeName += ((Dict_item)list.get(0)).getDisplay_name() + " ";
								}
							}
							temp.setUsertypename(userTypeName);
						}
						if(!userTemp.getUseraccount().equals(temp.getUseraccount())){
							listtemp.add(temp);
						}
					}
				}
				setTabledataQy(listtemp);
			} catch (Exception e) {
				e.printStackTrace();
				this.result="";
				return "success";
			}
			this.result="success";
	        return "success";
	    }
	public String getPasswordResult() {
		return passwordResult;
	}

	public void setPasswordResult(String passwordResult) {
		this.passwordResult = passwordResult;
	}

	public String getIdnum15() {
		return idnum15;
	}

	public void setIdnum15(String idnum15) {
		this.idnum15 = idnum15;
	}
	
}