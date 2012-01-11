package com.aisino2.sysadmin.action;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.codehaus.xfire.client.Client;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import sun.misc.BASE64Decoder;

import com.aisino2.common.IpMac;
import com.aisino2.common.QjblUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.authorization.IIdentityAuthorization;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.Loginlog;
import com.aisino2.sysadmin.domain.OnlineUser;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IFunctionService;
import com.aisino2.sysadmin.service.ILoginlogService;
import com.aisino2.sysadmin.service.IUserService;
import com.ibatis.common.resources.Resources;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends PageAction{

	private static final long serialVersionUID = 1L;

	private IDepartmentService departmentService;
	private ILoginlogService loginlogService;
	private IFunctionService functionService;
	private IIdentityAuthorization identityAuthorization;
	private IUserService userService;
	
	private String useraccount;
	private String passWord;
	private String usertype;
	private String result="success";
	private User user;
	private String reflashtime;

	private String baojingflag;
  
	private String csbm;//场所编码 客户端民警登陆取得客户端得场所编码和场所名称
	private String csmc;//场所名称 客户端民警登陆取得客户端得场所编码和场所名称
  
	private String kjtuichu;//控件退出标志
	private static String nwwbz=null;
	private static String nwwbz_zkd=null;
	private static String nwwbz_cjd=null;
	private static String rcjc=null;


	public String getKjtuichu() {
	return kjtuichu;
}
public void setKjtuichu(String kjtuichu) {
	this.kjtuichu = kjtuichu;
}
	public String getBaojingflag() {
	return baojingflag;
}
public void setBaojingflag(String baojingflag) {
	this.baojingflag = baojingflag;
}
	public String getReflashtime() {
		return reflashtime;
	}
	public void setReflashtime(String reflashtime) {
		this.reflashtime = reflashtime;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setLoginlogService(ILoginlogService loginlogService) {
		this.loginlogService = loginlogService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 用于普通的用户名密码登陆
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 */

	public String  login() {
	   
		try {
			User setUser = new User();
			setUser = (User)this.setClass(setUser, null);

			//企业端登陆方式
			String way = setUser.getWay();
			baojingflag = setUser.getBaojingflag();
			setUser = (User) identityAuthorization.getUser(setUser.getUseraccount(), setUser.getPassword());
			if (setUser == null) {
				this.result="登录失败：输入的用户名或密码错误！";
			} 
			else if("0".equals(setUser.getIsvalid()))
			{
				this.result="登录失败：用户无效！";
			}else{
				//对登录用户进行验证判断是否有权限登录页面
				if(!loginJudge(setUser)){
					//未通过验证
					return "success";
				}else{
					//通过验证
					loadInformation(way,baojingflag,setUser,false);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="登录异常";
		}
		return "success";
	}
	/**
	 * 用于CA登陆
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 */

	public String  loginCA() {
		try {
			User setUser = new User();
			setUser = (User)this.setClass(setUser, null);
			//setUkey.setZt("02");
			String way = setUser.getWay();
			baojingflag = setUser.getBaojingflag();
			setUser = (User) userService.checkCAUser(setUser);
		    if(setUser==null){
		    	this.result = "0";
		    }else{
			    Date a=setUser.getZsyxrq();
			    Date b=new Date();
			    if(b.after(a)){
			    	this.result="登录失败：usbkey过期！";
			    }else{
			    	if("0".equals(setUser.getIsvalid()))
					{
			    		this.result="登录失败：用户无效！";
					}else{
						//对登录用户进行验证判断是否有权限登录页面
						if(loginJudge(setUser)){
							//通过验证
							//user信息加载 ,ture标识ca登录
							loadInformation(way,baojingflag,setUser,true);
							//CA信息加载
							loadCaInformation(setUser);
							this.result="success";
						}
					}
			    }
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="登录异常";
		}
        return "success";   
	}

	private User loadInformation(String way,String bjflag,User getuser ,boolean ca) throws Exception{
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		//Globalpar globalpar = null;
		//List globalparList = new ArrayList();//全局参数目前放在缓存中，无需放在session中了
		//内外网标志加载
		session.setAttribute("nwwbz", nwwbz);
		session.setAttribute("rcjc", rcjc);
		
		//将部门信息放入用户信息
		Department userDepartment = new Department();
		userDepartment.setDepartid(getuser.getDepartid());
		userDepartment = departmentService.getDepartment(userDepartment);
		getuser.setDepartment(userDepartment);
		
		
		//将功能信息放入session
		Function function = new Function();
		List functionList = new ArrayList();
		function.setUserid(getuser.getUserid());
		functionList = functionService.getOwnFunction(function);
		session.setAttribute(Constants.functionList, functionList);
		
		
		//写入登录日志 20100903不再采用ActiveX控件方式取的IP和Mac地址；不再获得Mac地址
		IpMac ipMac = new IpMac();
		String loginip = "";
		loginip = ipMac.getIpAddr(request);
		//loginip = getIpAddr(request);
		
		
		//存入登录日志
		Loginlog loginlog = new Loginlog();
		loginlog = loadLoginlog(loginip,getuser);
		//登录日志放入登录用户
		getuser.setLoginlog(loginlog);
		
		
		//加载在线用户信息
		loadOnlineUser(loginip,session,getuser);
		
		
		//将用户所属单位编码放入user.ssdwbm，企业用户及员工用户放置企业编码，其他用户为空
		User userssdw= queryQybm(getuser);
		if(userssdw==null){
			if(!ca){
				throw new Exception();
			}
		}else{
			getuser.setSsdwbm(userssdw.getSsdwbm());
			getuser.setSsdwmc(userssdw.getSsdwmc());
		}
		
		getuser.setWay(way);//移动方式

		//登录用户放入session
		session.setAttribute(Constants.userKey, getuser);
		session.setAttribute("loginAccount", getuser.getUseraccount());
		
		usertype=getuser.getUsertype();

		//报警修改start
		if(bjflag!=null&&bjflag.equals("baojingyes")){
			this.result="baojingsuccess";
			session.setAttribute("gxdwbm", userDepartment.getDepartcode());
		}else{
			this.result="success";
		}
		
		
		return getuser;
	}
	/**
	 * 判断当前用户是否可以登录，如果有新的登录判断请在这里添加
	 * @param getuser
	 * @return boolean returnback
	 * @throws IOException 
	 */
	
	//
	private boolean loginJudge(User getuser) throws IOException{
		//将DisplayerStrings.properties配置文件中的内外网标识(nwwbz)和内外网制卡端标识（nwwbz_zkd）读入
		boolean returnback=true;
		try {
			//判断这些标志 是否被加载，没有加载则读取配置文件
			if(nwwbz==null&&nwwbz_zkd==null&&nwwbz_cjd==null){
				Properties prop = Resources.getResourceAsProperties("DisplayerStrings.properties");
				nwwbz = prop.getProperty("nwwbz");//neiwaiwang biaozhi 0-neiwang ,1-waiwang
				nwwbz_zkd = prop.getProperty("nwwbz_zkd");//neiwaiwang-zhikaduan biaozhi 0-neiwang ,1-waiwang
				nwwbz_cjd = prop.getProperty("nwwbz_cjd");//neiwaiwang-采集端 biaozhi 0-neiwang ,1-waiwang
				rcjc = prop.getProperty("rcjc");//neiwaiwang-采集端 biaozhi 0-gad has add ,1-gad no add
			}
			String userTypes = getuser.getUsertype();
			String arrUserType[] = userTypes.split(",");
			String userType = "";
			for(int i=0;i<arrUserType.length;i++){
				userType = arrUserType[i];
				if(("12".equals(userType) || "142".equals(userType)) && !nwwbz.equals(nwwbz_cjd)){
					//内外网采集端标识与内外网标识不一致 娱乐业采集点用户 公共场所采集点用户无法登陆	
					if("0".equals(nwwbz)){//内网
						this.result="登录失败：此用户不是内网用户！";
						returnback=false;
					}else if("1".equals(nwwbz)){// 外网
						this.result="登录失败：此用户不是外网用户！";
						returnback=false;
					}
				}
				else if(("13".equals(userType) || "143".equals(userType)) && "0".equals(nwwbz)){
					// 内网 娱乐业企业端用户  公共场所企业端用户 无法登陆
					this.result="登录失败：此用户不是内网用户！";
					returnback=false;
				}
				else if(("11".equals(userType) || "141".equals(userType)) && !nwwbz.equals(nwwbz_zkd)){
					// 娱乐业制卡端用户 公共场所制卡端用户 无法登陆
					if("0".equals(nwwbz)){//内网
						this.result="登录失败：此用户不是内网用户！";
						returnback=false;
					}else if("1".equals(nwwbz)){// 外网
						this.result="登录失败：此用户不是外网用户！";
						returnback=false;
					}
				}else if("123".equals(userType)){
					//重点单位咨询网用户不允许登录
					this.result = "资讯网用户不能登录！";
					returnback=false;
				}
				
			}
			
			
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			HttpSession session = request.getSession();
			if(!kefuValidater(getuser,session)){
				//未通过客服验证
				this.result = "未通过客服验证！";
				returnback=false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="登录验证时出现错误";
		}
		return returnback;
	}
	/**
	 * 存储在线用户信息
	 * @param String loginip,HttpSession session,User getuser
	 * @return void
	 */
	//
	private void loadOnlineUser(String loginip,HttpSession session,User getuser){
		//在线用户
		ServletContext application=session.getServletContext();
		OnlineUser onlineuser=new OnlineUser();
		String sessionID=session.getId();
		onlineuser.setSessionID(sessionID);
		onlineuser.setUserid(getuser.getUseraccount());
		onlineuser.setUsername(getuser.getUsername());
		onlineuser.setDepartmentname(getuser.getDepartment().getDepartname());
		onlineuser.setLoginip(loginip);
		java.util.Date currentTime=new java.util.Date();
		    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String dateString = formatter.format(currentTime);
		onlineuser.setLogintime(dateString);

		List onlineUsersList=(ArrayList)application.getAttribute("ONLINEUSERSLIST");
		if(onlineUsersList==null){
			onlineUsersList=new ArrayList<OnlineUser>();
		}
		onlineUsersList.add(onlineuser);
		application.setAttribute("ONLINEUSERSLIST", onlineUsersList);
	}
	/**
	 * 存储日志信息
	 * @param String loginip,User getuser
	 * @return Loginlog
	 */
	//
	private Loginlog loadLoginlog(String loginip,User getuser){
		Loginlog loginlog = new Loginlog();
		loginlog.setLoginuserid(getuser.getUserid());
		loginlog.setUseraccount(getuser.getUseraccount());
		loginlog.setUsername(getuser.getUsername());
		loginlog.setLoginunitcode(getuser.getDepartment().getDepartcode());
		loginlog.setLoginunitname(getuser.getDepartment().getDepartname());
		loginlog.setLoginip(loginip);
		//loginlog.setLoginmac(loginmac);
		loginlog.setLogintiime(new Date());
		
		loginlog = loginlogService.insertLoginlog(loginlog);
		return loginlog;
	}
	/**
	 * ca信息加载
	 * @return
	 */
	private void loadCaInformation(User getuser){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		
		session.setAttribute("ca-tag", "true");
		session.setAttribute("ukeyid", getuser.getUkeyid());
		session.setAttribute("zssqrq", getuser.getZssqrq());
		session.setAttribute("zsyxrq", getuser.getZsyxrq());
		session.setAttribute("xm_syr", getuser.getXm_syr());
		session.setAttribute("cyrybh", getuser.getCyrybh());
		
		//计算日期大小，如果距离证书到期天数小于30天，将剩余天数放入到session中
		long day=(getuser.getZsyxrq().getTime()-(new Date()).getTime())/1000/60/60/24;
		if(day<31){
			String zsyxqsyts=String.valueOf(day);
			session.setAttribute("zsyxqsyts",zsyxqsyts);
		}
	}
	/**
	 * 退出登录，目前只适用用户点击退出按钮情况
	 * @return
	 */
	public String loginout() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		
		//写登录日志，记录退出时间
		User currentUser = new User();
		Loginlog loginlog = new Loginlog();
		currentUser = (User)session.getAttribute(Constants.userKey);
		if(currentUser != null)
		{
			loginlog = currentUser.getLoginlog();
			loginlog.setQuittime(new Date());
			loginlogService.updateLoginlog(loginlog);
		}
		
		session.removeAttribute(Constants.userKey);
		session.invalidate();
		return "success";
	}
	
	/**
	 * 获得登录机器MAC地址 该方法作废2009-05-11
	 * @param ip 登录机器IP
	 * @return
	 */
	public String queryMACAddress(String ip){
        String str = "";
        String macAddress = "";
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }

	/**
	 * 获得登录机器IP地址 
	 * @param ip 登录机器IP
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public void setIdentityAuthorization(
			IIdentityAuthorization identityAuthorization) {
		this.identityAuthorization = identityAuthorization;
	}
	public User getUser() {
		return user;
	}
	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}
	
	
	private String manflag;  ///主页面显示标志

	private String manflag2;  ///主页面显示标志



	
	public String getManflag() {
		return manflag;
	}
	public void setManflag(String manflag) {
		this.manflag = manflag;
	}
	/**
	 * 登陆首页判断(旅馆业首页)
	 * @return
	 */
	public String loginMain() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		int bjxxb = 0;
		int Dryxqk = 0;
		int yzyDryxqk =0;
		List funcList = (List)session.getAttribute(Constants.functionList);
		
		if(funcList!=null){
			for(int i=0;i<funcList.size();i++){
				Function func = (Function)funcList.get(i);
				if("mainbjxxb".equals(func.getFunccode())){
					bjxxb = 1;
				}
				if("mainDryxqk".equals(func.getFunccode())){
					Dryxqk = 1;
				}
				if("yzyDryxqk".equals(func.getFunccode())){
					yzyDryxqk = 1;
				}	
			}
		}
		if(bjxxb==1&&Dryxqk==1){
			manflag = "all";
		}else if(bjxxb==1&&Dryxqk!=1){
			manflag = "one";
		}else if(bjxxb!=1&&Dryxqk==1){
			manflag = "two";
		}
		
		if(bjxxb==1&&yzyDryxqk==1){
			manflag2 = "all";
		}else if(bjxxb==1&&yzyDryxqk!=1){
			manflag2 = "one";
		}else if(bjxxb!=1&&yzyDryxqk==1){
			manflag2 = "two";
		}
		
		Globalpar globalpar = new Globalpar();
		reflashtime = this.getCacheGlobalpar("reflashtime").getGlobalparvalue();
		
		return "success";
	}
	
	/**
	 * 登陆首页判断(公安厅旅馆业首页)
	 * @return
	 */
	public String loginMainGat() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		int jqhzqk = 0;
		int jqxtyxqktj = 0;
		
		List funcList = (List)session.getAttribute(Constants.functionList);
		
		if(funcList!=null){
			for(int i=0;i<funcList.size();i++){
				Function func = (Function)funcList.get(i);
				if("mainJqhzqk".equals(func.getFunccode())){
					jqhzqk = 1;
				}	
				if("mainJqxtyxqktj".equals(func.getFunccode())){
					jqxtyxqktj = 1;
				}
				
			}
		}
		if(jqhzqk==1&&jqxtyxqktj==1){
			manflag = "all";
		}else if(jqhzqk==1&&jqxtyxqktj!=1){
			manflag = "one";
		}else if(jqhzqk!=1&&jqxtyxqktj==1){
			manflag = "two";
		}
		
	
		
		Globalpar globalpar = new Globalpar();
		reflashtime = this.getCacheGlobalpar("reflashtime").getGlobalparvalue();
		
		return "success";
	}
	
	public String getManflag2() {
		return manflag2;
	}
	public void setManflag2(String manflag2) {
		this.manflag2 = manflag2;
	}
	/**
	 * 不比对密码  直接登录
	 * @return
	 */
	public String  loginNoPassword() {
		   ActionContext ctx = ActionContext.getContext();
		   HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			HttpSession session = request.getSession();
			Globalpar globalpar = null;
			//List globalparList = new ArrayList();//全局参数目前放在缓存中，无需放在session中了
			List functionList = new ArrayList();
			try {
				User setUser = new User();
				user = (User)this.setClass(setUser, null);
				
				baojingflag = user.getBaojingflag();
				//user = (User) identityAuthorization.getUser(useraccount, passWord);
				user = (User) identityAuthorization.getUserAcc(user.getUseraccount());
				if (user == null) {
					this.result="登录失败：输入的用户名或密码错误！";
				} 
				else if("0".equals(user.getIsvalid()))
				{
					this.result="登录失败：用户无效！";
				}
				else {
					//将部门信息放入登录用户


					Department userDepartment = new Department();
					userDepartment.setDepartid(user.getDepartid());
					userDepartment = departmentService.getDepartment(userDepartment);
					user.setDepartment(userDepartment);
					//将功能列表放入
					Function function = new Function();
					function.setUserid(user.getUserid());
					functionList = functionService.getOwnFunction(function);
					session.setAttribute(Constants.functionList, functionList);
					//写入登录日志
					IpMac ipMac = new IpMac();
					String loginip = "";
					loginip = ipMac.getIpAddr(request);
						
					Loginlog loginlog = new Loginlog();
					loginlog.setLoginuserid(user.getUserid());
					loginlog.setUseraccount(user.getUseraccount());
					loginlog.setUsername(user.getUsername());
					loginlog.setLoginunitcode(userDepartment.getDepartcode());
					loginlog.setLoginunitname(userDepartment.getDepartname());
					loginlog.setLoginip(loginip);
					loginlog.setLogintiime(new Date());
					
					loginlog = loginlogService.insertLoginlog(loginlog);
					
					//登录日志放入登录用户
					user.setLoginlog(loginlog);
					
					//在线用户
					ServletContext application=session.getServletContext();
					OnlineUser onlineuser=new OnlineUser();
					String sessionID=session.getId();
					onlineuser.setSessionID(sessionID);
					onlineuser.setUserid(user.getUseraccount());
					onlineuser.setUsername(user.getUsername());
					onlineuser.setDepartmentname(user.getDepartment().getDepartname());
					onlineuser.setLoginip(loginip);
					java.util.Date currentTime=new java.util.Date();
	 	   		    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	   		    String dateString = formatter.format(currentTime);
					onlineuser.setLogintime(dateString);
					//System.out.println("sessionID: "+sessionID+" userid: "+onlineuser.getUserid()+" username: "+onlineuser.getUsername()+" ip: "+onlineuser.getLoginip()+" departname: "+onlineuser.getDepartmentname()+" logintime: "+onlineuser.getLogintime());
					
					List onlineUsersList=(ArrayList)application.getAttribute("ONLINEUSERSLIST");
					if(onlineUsersList==null){
						onlineUsersList=new ArrayList<OnlineUser>();
					}
					onlineUsersList.add(onlineuser);
					application.setAttribute("ONLINEUSERSLIST", onlineUsersList);
					
					//登录用户放入session
					session.setAttribute(Constants.userKey, user);
					session.setAttribute("loginAccount", user.getUseraccount());
					
					//this.result="success";
					//报警修改start
					if(baojingflag!=null&&baojingflag.equals("baojingyes")){
						this.result="baojingsuccess";
						session.setAttribute("gxdwbm", userDepartment.getDepartcode());
					
						
						
					}else{
						this.result="success";
					}
					//报警修改end
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.result="登录失败";
			}
			return "success";
		}
	
	/**
	 * 客服 验证
	 * @param logUser
	 * @return
	 */
	public boolean kefuValidater(User logUser, HttpSession session){
		boolean res = true;
		String userType = logUser.getUsertype();
		String qykfkg = QjblUtil.queryQjblVal("qykf-kg");
		Map mapUse = queryKfsqUserType("qysqUserType"); //需要验证的UserType
		Map mapTg = queryKfsqUserType("qysqTiaoGuoUserType"); //需要跳过的UserType
		if("1".equals(qykfkg)&&!isContentsUserType(mapTg, userType)&&isContentsUserType(mapUse, userType)){ //企业端用户
			try {
				String content = wsdlResult(queryQybm(logUser).getSsdwbm());
				Document doc = DocumentHelper.parseText(content);
				Element root = doc.getRootElement();
				String isright = root.element("ISVERIFY").getText();
				String endDate = root.element("ENDDATE").getText();
				if("1".equals(isright)){
					long difday = difDay(endDate);
					if(difday<31){
						session.setAttribute("shouquanEndDate", "授权截止日期:"+endDate);
					}
				}else{
					result = "授权无效";
					res = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				result = "请联系管理员";
				res = false;
			}
		}
		return res;
	}
	/**
	 * 客服webserver验证 返回XML描述
	 * @param qybm
	 * @return
	 * @throws Exception
	 */
	public String wsdlResult(String qybm) throws Exception {
		String qykfwsdl = QjblUtil.queryQjblVal("qykf-wsdl");
		Client client = new Client(new java.net.URL(qykfwsdl));
		return client.invoke("licenseVerifyByID",new String[]{qybm})[0].toString();
	}
	/**
	 * 日期相差的天数

	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public long difDay(String endDate) throws Exception {
		SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		String dateNowStr=dateFormat.format(nowDate);
	    
		Date dateEnd = formatter.parse(endDate);
		Date dateNow = formatter.parse(dateNowStr);
		long day1 = dateEnd.getTime()/(24*60*60*1000);
		long day2 = dateNow.getTime()/(24*60*60*1000);
		return (day1-day2);
	}
	//获取全局参数用户类别 转成map 
	public Map queryKfsqUserType(String keys){
		Map map = new HashMap();
		String qysqUserType = QjblUtil.queryQjblVal(keys);
		if(qysqUserType!=null&&!"".equals(qysqUserType)){
			String[] userType= qysqUserType.split(",");
			if(userType!=null&&userType.length>0){
				for(int index=0,max=userType.length;index<max;index++){
					map.put(userType[index].trim(), "1");
				}
			}
		}
		return map;
	}
	//判断实际的用户类别是否在存在MAP中
	public boolean isContentsUserType(Map map,String userType){
		boolean result = false;
		if(userType!=null&&!"".equals(userType)){
			String[] userTypes= userType.split(",");
			if(userTypes!=null&&userTypes.length>0){
				for(int index=0,max=userTypes.length;index<max;index++){
					if("1".equals(map.get(userTypes[index].trim()))){
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}
	//获取企业编码、企业名称
	public User queryQybm(User loginuser){
		String userType = loginuser.getUsertype();
		String[] utype = userType.split(",");
		for(int i=0;i<utype.length;i++){
			if("112".equals(utype[i])){
				//剧毒化学品
				String account=loginuser.getUseraccount();
				loginuser.setSsdwbm(account.substring(0,13));
				break;
			}else if("122".equals(utype[i])){
				//重点单位
				String account=loginuser.getUseraccount();
				loginuser.setSsdwbm(account.substring(1,12));
				break;
			}else if("32".equals(utype[i])
					||"42".equals(utype[i])
					||"62".equals(utype[i])
					||"72".equals(utype[i])
					||"82".equals(utype[i])
					||"92".equals(utype[i])
					||"102".equals(utype[i])
					||"152".equals(utype[i])
					||"162".equals(utype[i])){
				loginuser = userService.getQybmByCyrybh(loginuser);
				break;
			}else if ("13".equals(utype[i])
					||"33".equals(utype[i])
					||"43".equals(utype[i])
					||"52".equals(utype[i])
					||"53".equals(utype[i])
					||"63".equals(utype[i])
					||"73".equals(utype[i])
					||"83".equals(utype[i])
					||"93".equals(utype[i])
					||"103".equals(utype[i])
					||"113".equals(utype[i])
					||"143".equals(utype[i])
					||"153".equals(utype[i])
					||"163".equals(utype[i])) {
				loginuser.setSsdwbm(loginuser.getUseraccount());
				loginuser.setSsdwmc(loginuser.getUsername());
				break;
			}
		}
		return loginuser;
	}
	
	//为场所编码和场所名称创建session用于客户端民警登陆取得客户端得场所编码和场所名称
	public String creatSessionForCsbmCsmc() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		//Kjtuichu如果
		
/*		if(this.getKjtuichu()!=null){
			if(this.getKjtuichu().equals("noindex")){
				if(csmc!=null&&!csmc.equals("")){
					csmc = csmc.replace('_', '+');
					csmc =  csmc.replace('$', '=');
					csmc= getFromBASE64(csmc);
				}
			}
		}*/
		//通过数据库取回企业名称
		try{
			csmc=userService.getQymcByQybm(csbm);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		if(session.getAttribute("csbmcsmc")!=null){
			session.removeAttribute("csbmcsmc");
		}
	     session.setAttribute("csbmcsmc", csbm+",|"+csmc);
	     result = "success";
	     return "success";
	     
	}
	//将 BASE64 编码的字符串 s 进行解码 
	public static String getFromBASE64(String s) { 
		if (s == null) return null; 
		BASE64Decoder decoder = new BASE64Decoder(); 
		try { 
			byte[] b = decoder.decodeBuffer(s); 
			return new String(b); 
		} catch (Exception e) { 
			return null; 
		} 
	}
	public String getCsbm() {
		return csbm;
	}
	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}
	public String getCsmc() {
		return csmc;
	}
	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}
	
	  /**
	    * 取IP
	    * @param request HttpServletRequest
	    * @return ip String
	    */
	   public static String getIP(HttpServletRequest request) {
	     String ip="";
	     if(request.getHeader("X-Forwarded-For")!=null)
	       ip=request.getHeader("X-Forwarded-For");
	     else ip=request.getRemoteAddr();
	     return ip;
	   }

	
}
