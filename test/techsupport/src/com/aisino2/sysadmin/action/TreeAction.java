package com.aisino2.sysadmin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.Param;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_menu;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IDictService;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IMenuService;
import com.aisino2.sysadmin.service.IParamService;
import com.aisino2.sysadmin.service.IRoleService;
import com.aisino2.sysadmin.service.IRole_menuService;
import com.aisino2.sysadmin.service.ISystemService;
import com.opensymphony.xwork2.ActionContext;

public class TreeAction extends PageAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDepartmentService departmentService;
	private ISystemService systemService;
	private IMenuService menuService;
	private IParamService paramService;
	private IDictService dictService;
	private IDict_itemService dict_itemService;
	private IRoleService roleService;
	private IRole_menuService role_menuService;

	private String id;
	private String result = "";

	//部门树变量


	private String treeFalg;
	private Department department;
	private String parentdeptid;
	private String deptMessage;
	private String departidFrom;
	private String departidTo;
	private String departmentFullCode;
	//系统树变量


	private String systemTreeFalg;
	private String parentSystemCode;
	private System system;

	// 菜单树变量


	private Menu menu;
	private String systemcode;
	private String menucode;
	// 角色菜单树变量


	boolean open; //是否展开
	boolean selectAll;// 是否全选，不按照系统查询

	private List lRoleSystem;// 角色下的菜单所在的系统
	private List lRoleSystemMenu;// 指定角色及系统下的菜单

	private String roleid;
	// 字典变量
	List dictList = new ArrayList();
	Dict dict;
	private String dict_code;
	private String dict_name;

	// 字典项树变量
	Dict_item dict_item;
	private String item_id;
	private String fact_value;
	List dictItemList = new ArrayList();
	
	//参数树(列表)变量
	Param param;
	List paramList = new ArrayList();
	//角色用户树(列表)变量
	Role role;
	List roleList = new ArrayList();
	
	
    ////出租房 详细地址 变量
	private String itemId;         ///字典项id
	private String allFact_value;  ////详细地址全部
	
	public String getFact_value() {
		return fact_value;
	}
	public void setFact_value(String fact_value) {
		this.fact_value = fact_value;
	}

	public void setDictItemList(List dictItemList) {
		this.dictItemList = dictItemList;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public void setDict_item(Dict_item dict_item) {
		this.dict_item = dict_item;
	}

	public String getDict_code() {
		return dict_code;
	}

	public void setDict_code(String dict_code) {
		this.dict_code = dict_code;
	}

	public String getDict_name() {
		return dict_name;
	}

	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}

	public List getDictList() {
		return dictList;
	}

	public void setDictList(List dictList) {
		this.dictList = dictList;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getMenucode() {
		return menucode;
	}

	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}

	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isSelectAll() {
		return selectAll;
	}

	public void setSelectAll(boolean selectAll) {
		this.selectAll = selectAll;
	}

	public String getParentdeptid() {
		return parentdeptid;
	}

	public void setParentdeptid(String parentdeptid) {
		this.parentdeptid = parentdeptid;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getTreeFalg() {
		return treeFalg;
	}

	public void setTreeFalg(String treeFalg) {
		this.treeFalg = treeFalg;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}

	public List getLRoleSystem() {
		return lRoleSystem;
	}

	public void setLRoleSystem(List roleSystem) {
		lRoleSystem = roleSystem;
	}

	public List getLRoleSystemMenu() {
		return lRoleSystemMenu;
	}

	public void setLRoleSystemMenu(List roleSystemMenu) {
		lRoleSystemMenu = roleSystemMenu;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public List getParamList() {
		return paramList;
	}

	public void setParamList(List paramList) {
		this.paramList = paramList;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List getRoleList() {
		return roleList;
	}

	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}
	/**
	 * 部门树的生成
	 * 
	 * @throws Exception
	 */
	public void deptAllTree() throws Exception {
		Department UserDepartment = new Department();
		String top_deptid_ba = this.getCacheGlobalpar("top_deptid_ba").getGlobalparvalue();
		UserDepartment.setDepartid(Integer.valueOf(top_deptid_ba));
		UserDepartment = departmentService.getDepartment(UserDepartment);
		List lst = new ArrayList();
		Department departmentOne = new Department();	
		if (id == null
				|| id.trim().equals(
						String.valueOf(UserDepartment.getParentdepartid()))) {
			
			id = String.valueOf(UserDepartment.getParentdepartid());
			departmentOne = UserDepartment;
			lst.clear();
			lst.add(departmentOne);
		} else {
			departmentOne.setDepartid(Integer.parseInt(id));
			// departmentOne.setDepartid(UserDepartment.getDepartid());
			lst = departmentService.getChildDepart(departmentOne);
		}
		String xml = "";
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version='1.0' encoding='utf-8'?> \n");
		xmlBuffer.append("<tree id=\"" + id + "\"> \n");

		for (int i = 0; i < lst.size(); i++) {
			departmentOne = (Department) lst.get(i);
			xmlBuffer.append("<item text=\""
					+ departmentOne.getDepartname()
					+ "\" id=\""
					+ departmentOne.getDepartid()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ");
			if ("Y".equals(departmentOne.getIsleaf())) {
				xmlBuffer.append("child=\"0\">");
			} else {
				xmlBuffer.append("child=\"1\">");
			}
			xmlBuffer.append("<userdata name=\""+ departmentOne.getDepartid()+ "\">"
					+ departmentOne.getDepartcode()
					+ ","
					+ com.aisino2.common.StringUtil.trimEven0(departmentOne.getDepartcode())
					+","
					+departmentOne.getDepartlevel() 
					+","
					+departmentOne.getParentdepartid() 
					+","
					+departmentOne.getDepartfullcode()
					+","
					+departmentOne.getIsleaf()
					+ "</userdata>");
			xmlBuffer.append("</item>");
		}
		xmlBuffer.append("</tree>");
		xml = xmlBuffer.toString();
		// java.lang.System.out.println(xml);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		out.close();
	}
	/**
	 * 部门树的生成
	 * 
	 * @throws Exception
	 */
	public void deptTree() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		Department UserDepartment = new Department();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		if(user.getDepartment().getDepartcode().indexOf("ZKD")!=-1){//制卡端用户登录
			UserDepartment.setDepartcode(user.getDepartment().getDepartcode().substring(3));
		}else{
			UserDepartment.setDepartid(user.getDepartid());
		}
		//UserDepartment.setDepartid(user.getDepartid());
		UserDepartment = departmentService.getDepartment(UserDepartment);
		List lst = new ArrayList();
		Department departmentOne = new Department();
		// id = "0";
		if (id == null
				|| id.trim().equals(
						String.valueOf(UserDepartment.getParentdepartid()))) {
			
			id = String.valueOf(UserDepartment.getParentdepartid());
			departmentOne = UserDepartment;
			lst.clear();
			lst.add(departmentOne);
		} else {
			departmentOne.setDepartid(Integer.parseInt(id));
			// departmentOne.setDepartid(UserDepartment.getDepartid());
			lst = departmentService.getChildDepart(departmentOne);
		}
		String xml = "";
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version='1.0' encoding='utf-8'?> \n");
		xmlBuffer.append("<tree id=\"" + id + "\"> \n");

		for (int i = 0; i < lst.size(); i++) {
			departmentOne = (Department) lst.get(i);
			xmlBuffer.append("<item text=\""
					+ departmentOne.getDepartname()
					+ "\" id=\""
					+ departmentOne.getDepartid()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ");
			if ("Y".equals(departmentOne.getIsleaf())) {
				xmlBuffer.append("child=\"0\">");
			} else {
				xmlBuffer.append("child=\"1\">");
			}
			xmlBuffer.append("<userdata name=\""+ departmentOne.getDepartid()+ "\">"
					+ departmentOne.getDepartcode()
					+ ","
					+ com.aisino2.common.StringUtil.trimEven0(departmentOne.getDepartcode())
					+","
					+departmentOne.getDepartlevel() 
					+","
					+departmentOne.getParentdepartid() 
					+","
					+departmentOne.getDepartfullcode()
					+","
					+departmentOne.getIsleaf()
					+ "</userdata>");
			xmlBuffer.append("</item>");
		}
		xmlBuffer.append("</tree>");
		xml = xmlBuffer.toString();
		// java.lang.System.out.println(xml);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		out.close();
	}
	public void deptTreejdjb() throws Exception {//监督举报开发的树 功能为根据传来的fullcode显示相应树形结构
		String fullCode="";
		String[] arrFullCode=new String[5];
		if(departmentFullCode!=null&&!"".equals(departmentFullCode)){
			 arrFullCode=departmentFullCode.split("\\.");
			for(int i=0;i<arrFullCode.length;i++){
				if(!"".equals(arrFullCode[i])){
					fullCode=fullCode+"'"+arrFullCode[i]+"',";
				}
			}
			fullCode=fullCode.substring(0, fullCode.length()-1);//截取掉最后一个,
		}
		List lst = new ArrayList();
		Department departmentOne = new Department();
		departmentOne.setDepartfullcode(fullCode);
		if(id!=null){//子节点
			departmentOne.setDepartid(Integer.parseInt(id));
			lst = departmentService.getChildDepart(departmentOne);
		}else{//初始化
			id="0";
			departmentOne.setDepartcode(arrFullCode[1]);
			departmentOne = departmentService.getDepartment(departmentOne);
			lst.clear();
			lst.add(departmentOne);
		}
		
		String xml = "";
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version='1.0' encoding='utf-8'?> \n");
		xmlBuffer.append("<tree id=\"" + id + "\"> \n");
		
		for (int i = 0; i < lst.size(); i++) {
			departmentOne = (Department) lst.get(i);
			xmlBuffer.append("<item text=\""
					+ departmentOne.getDepartname()
					+ "\" id=\""
					+ departmentOne.getDepartid()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ");
			if ("Y".equals(departmentOne.getIsleaf())) {
				xmlBuffer.append("child=\"0\">");
			} else {
				xmlBuffer.append("child=\"1\">");
			}
			xmlBuffer.append("<userdata name=\""+ departmentOne.getDepartid()+ "\">"
					+ departmentOne.getDepartcode()
					+ ","
					+ com.aisino2.common.StringUtil.trimEven0(departmentOne.getDepartcode())
					+","
					+departmentOne.getDepartlevel() 
					+","
					+departmentOne.getParentdepartid() 
					+","
					+departmentOne.getDepartfullcode()
					+","
					+departmentOne.getIsleaf()
					+ "</userdata>");
			xmlBuffer.append("</item>");
		}
		xmlBuffer.append("</tree>");
		xml = xmlBuffer.toString();
		// java.lang.System.out.println(xml);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		out.close();
	}

	/**
	 * 部门树的初始化

	 * 
	 * @throws Exception
	 */
	public String deptTreeForm() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		Department departmentTwo = new Department();
		// departmentTwo.setDepartid(user.getDepartid());
		// departmentTwo.setDepartid(100);
		departmentTwo.setDepartid(user.getDepartid());
		departmentTwo = departmentService.getDepartment(departmentTwo);

		parentdeptid = String.valueOf(departmentTwo.getParentdepartid());

		if (this.treeFalg == null || this.treeFalg.equals("")) {
			this.treeFalg = "department";
		}
		this.setDepartment(departmentTwo);
		return "deptTree";
	}

	/**
	 * 用户角色部门树的初始化

	 * 
	 * @throws Exception
	 */
	public String deptTreeUser_roleForm() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx .get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		Department departmentTwo = new Department();
		// departmentTwo.setDepartid(user.getDepartid());
		// departmentTwo.setDepartid(100);
		departmentTwo.setDepartid(user.getDepartid());
		departmentTwo = departmentService.getDepartment(departmentTwo);

		parentdeptid = String.valueOf(departmentTwo.getParentdepartid());

		if (this.treeFalg == null || this.treeFalg.equals("")) {
			this.treeFalg = "user_role";
		}
		this.setDepartment(departmentTwo);
		return "deptTreeUser_role";
	}

	/**
	 * 角色部门树的初始化

	 * 
	 * @throws Exception
	 */
	public String deptTreeRoleForm() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		Department departmentTwo = new Department();
		// departmentTwo.setDepartid(user.getDepartid());
		// departmentTwo.setDepartid(100);
		departmentTwo.setDepartid(user.getDepartid());
		departmentTwo = departmentService.getDepartment(departmentTwo);

		parentdeptid = String.valueOf(departmentTwo.getParentdepartid());

		if (this.treeFalg == null || this.treeFalg.equals("")) {
			this.treeFalg = "role";
		}
		this.setDepartment(departmentTwo);
		return "deptTreeRole";
	}

	/**
	 * 系统树的生成
	 * 
	 * @throws Exception
	 */

	public void systemTree() throws Exception {
		if (id == null || id.equals("")) {
			id = "0";
		}
		system = new System();
		system.setSystemcode(id);
		List lst = systemService.getChildSystem(system);
		String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
		xml += "<tree id=\"" + id + "\"> \n";
		for (int i = 0; i < lst.size(); i++) {
			system = (System) lst.get(i);
			xml += "<item text=\""
					+ system.getSystemname()
					+ "\" id=\""
					+ system.getSystemcode()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
			if ("Y".equals(system.getIsleaf())) {
				xml += "child=\"0\"/> \n";
			} else {
				xml += "child=\"1\"/> \n";
			}
		}
		xml += "</tree>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);

		out.close();
	}

	/**
	 * 系统树用于菜单,只有一级系统

	 * 
	 * @throws Exception
	 */

	public void systemMenuTree(String falg) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute(Constants.userKey);
		Department department = userSession.getDepartment();
		if (id == null || id.equals("")) {
			id = "0";
		}
		system = new System();
		system.setSystemcode(id);
		List lst = null;
		if("fxmenu".equals(falg)&&department.getParentdepartid()!=0){ //10.3.29需求 非省级用户只看到用户所拥有的菜单
			system.setUserid(userSession.getUserid());
			lst = systemService.getTheUserChildSystem(system);
		} else {
			lst = systemService.getChildSystem(system);
		}
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0' encoding='utf-8'?> \n");
		xml.append("<tree id=\"" + id + "\"> \n");
		for (int i = 0; i < lst.size(); i++) {
			system = (System) lst.get(i);
			xml.append("<item text=\"");
			xml.append(system.getSystemname());
			xml.append("\" id=\"");
			xml.append("sysfalg");
			xml.append(system.getSystemcode());
			xml.append("\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ");
			if (falg.equals("roleMenu")) {
				Role_menu role_menu = new Role_menu();
				role_menu.setRoleid(Integer.parseInt(roleid));
				role_menu.setSystemcode(systemcode);
				List roleMenuList = role_menuService
						.getRoleMenusByRoleidAndSystemcode(role_menu);
				if (roleMenuList != null && roleMenuList.size() > 0) {
					xml.append("checked='true' ");
				}
			}
			xml.append("child=\"1\"/> \n");
		}
		xml.append("</tree>");

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml.toString());
		//
		out.close();
	}

	/**
	 * 系统树的初始化

	 * 
	 * @throws Exception
	 */

	public String systemTreeForm() throws Exception {
		if (this.systemTreeFalg == null || this.systemTreeFalg.equals("")) {
			this.systemTreeFalg = "system";
		}
		return "systemTree";
	}

	public void menuTree() throws Exception {

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		if (id.equals("0")) {
			systemMenuTree("menu");
		} else {
			// 点开系统
			if (id.indexOf("sysfalg") != -1) {
				this.systemcode = id.substring(7);
				// 便于测试设了个默认值100，正式用时，值为0；


				menucode = "0";
				/*request.getSession().removeAttribute("systemcode");
				request.getSession()
						.setAttribute("systemcode", this.systemcode);*/
			} else {
				// 点开菜单
				menucode = id;
				//modified by mds at 20100415.解决如下问题：例如先点击开企业端和公安端，然后点击公安端下面菜单，菜单能够正常打开，再点击企业端菜单，菜单无法打开
				Menu tempMenu = new Menu();
				tempMenu.setMenucode(menucode);
				tempMenu = menuService.getMenu(tempMenu);
				systemcode = tempMenu.getSystemcode();
			}
			menu = new Menu();
			menu.setMenucode(menucode);
			
			//modified by mds at 20100415
			/*if (this.systemcode == null || this.systemcode.equals("")) {
				if (request.getSession().getAttribute("systemcode") != null) {
					this.systemcode = (String) request.getSession()
							.getAttribute("systemcode");
				}
			}*/

			menu.setSystemcode(systemcode);
			List lst = menuService.getChildMenu(menu);
			StringBuffer xml = new StringBuffer();
			xml.append("<?xml version='1.0' encoding='utf-8'?> \n");
			xml.append("<tree id=\"" + id + "\"> \n");

			for (int i = 0; i < lst.size(); i++) {
				menu = (Menu) lst.get(i);
				xml.append("<item text=\"");
				xml.append(menu.getMenuname());
				xml.append("\" id=\"");
				xml.append(menu.getMenucode());
				xml.append("\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\"   ");
				if (open) {
					xml.append("open='true' ");
				}
				if ("Y".equals(menu.getIsleaf())) {
					// xml += "open='' ";
					xml.append("child=\"0\"/> \n");
				} else {
					// xml += "open='true' ";
					xml.append("child=\"1\"/> \n");
				}
			}
			xml.append("</tree>");

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(xml.toString());

			out.close();
		}
	}

	/**
	 * 用于带复选框的菜单树
	 * 
	 * @throws Exception
	 */
	public void menuTreeCheckbox() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute(Constants.userKey);
		Department department = userSession.getDepartment();
		if (id.equals("0")) {
			systemMenuTree("fxmenu");
		} else {
			// 点开系统
			if (id.indexOf("sysfalg") != -1) {
				this.systemcode = id.substring(7);
				// 便于测试设了个默认值100，正式用时，值为0；
				menucode = "0";
				/*request.getSession().removeAttribute("systemcode");
				request.getSession()
						.setAttribute("systemcode", this.systemcode);*/
			} else {
				// 点开菜单
				menucode = id.substring(8);// 去掉菜单id前的"menuflag"
//				modified by mds at 20100415.解决如下问题：例如先点击开企业端和公安端，然后点击公安端下面菜单，菜单能够正常打开，再点击企业端菜单，菜单无法打开
				Menu tempMenu = new Menu();
				tempMenu.setMenucode(menucode);
				tempMenu = menuService.getMenu(tempMenu);
				systemcode = tempMenu.getSystemcode();
			}
			menu = new Menu();
			menu.setMenucode(menucode);
			/*if (this.systemcode == null || this.systemcode.equals("")) {
				if (request.getSession().getAttribute("systemcode") != null) {
					this.systemcode = (String) request.getSession()
							.getAttribute("systemcode");
				}
			}*/
			
			List lst = null;
			menu.setSystemcode(systemcode);
			if(userSession!=null&&department.getParentdepartid()!=0){ //
				menu.setUserid(userSession.getUserid()); //10.3.29需求 非省级用户只看到用户所拥有的菜单
				lst = menuService.getTheUserChildMenu(menu);
			} else {
				lst = menuService.getChildMenu(menu);
			}
			String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
			xml += "<tree id=\"" + id + "\"> \n";

			for (int i = 0; i < lst.size(); i++) {
				menu = (Menu) lst.get(i);
				xml += "<item text=\""
						+ menu.getMenuname()
						+ "\" id=\""
						+ "menuflag"
						+ menu.getMenucode()
						+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\"   ";
				/*
				 * if (open) { xml += "open='true' "; }
				 */
				if ("Y".equals(menu.getIsleaf())) {
					xml += "open='' ";
					xml += "child=\"0\"/> \n";
				} else {
					xml += "open='true' ";
					xml += "child=\"1\"/> \n";
				}
			}
			xml += "</tree>";

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(xml);
			// 
			out.close();
		}
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 */
	public String menuTreeForm() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		request.getSession().removeAttribute("systemcode");
		return "menuTree";
	}

	/*
	 * 角色菜单树

	 * 
	 * 
	 */
	public void roleMenuTree() throws Exception {

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		if (id.equals("0")) {

			systemMenuTree("roleMenu");
		} else {
			// 点开系统
			if (id.indexOf("sysfalg") != -1) {
				this.systemcode = id.substring(7);
				// 便于测试设了个默认值100，正式用时，值为0；


				// menucode="100";
				menucode = "0";
				request.getSession().removeAttribute("systemcode");
				request.getSession()
						.setAttribute("systemcode", this.systemcode);
			} else {
				// 点开菜单
				menucode = id;
			}
			menu = new Menu();
			menu.setMenucode(menucode);
			if (this.systemcode == null || this.systemcode.equals("")) {
				if (request.getSession().getAttribute("systemcode") != null) {
					this.systemcode = (String) request.getSession()
							.getAttribute("systemcode");
				}
			}
			menu.setSystemcode(systemcode);

			// if(request.getParameter("systemNameExit")!=null){
			// if(request.getSession().getAttribute("systemNameExit")!=null){
			// request.getSession().removeAttribute("systemNameExit");
			// }
			// request.getSession().setAttribute("systemNameExit",
			// Escape.unescape(request.getParameter("systemNameExit")));
			// }
			Role_menu role_menu = new Role_menu();
			role_menu.setRoleid(Integer.parseInt(roleid));
			role_menu.setSystemcode(systemcode);

			List checkedList = role_menuService
					.getRoleMenusByRoleidAndSystemcode(role_menu);
			String checked = getStringFromMenuRoleList(checkedList);
			List lst = menuService.getChildMenu(menu);
			String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
			xml += "<tree id=\"" + id + "\"> \n";

			for (int i = 0; i < lst.size(); i++) {
				menu = (Menu) lst.get(i);
				xml += "<item text=\""
						+ menu.getMenuname()
						+ "\" id=\""
						+ menu.getMenucode()
						+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\"   ";
				if (open) {
					xml += "open='true' ";
				}
				if (checked.indexOf(menu.getMenucode()) >= 0) {
					xml += "checked='true' ";
				}
				if ("Y".equals(menu.getIsleaf())) {
					xml += "child=\"0\"/> \n";
				} else {
					xml += "child=\"1\"/> \n";
				}
			}
			xml += "</tree>";

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(xml);
			// 
			out.close();
		}
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 */
	public String roleMenuTreeForm() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		request.getSession().removeAttribute("systemcode");
		return "roleMenuTree";
	}

	// 拼已选的菜单code字符串


	private String getStringFromMenuRoleList(List menuRoleList) {
		String checked = "";
		if (menuRoleList != null) {
			for (int i = 0; i < menuRoleList.size(); i++) {
				Role_menu roleMenu = (Role_menu) menuRoleList.get(i);
				checked += "".equals(checked) ? roleMenu.getMenucode() : ","
						+ String.valueOf(roleMenu.getMenucode());
			}
		}
		return checked;
	}

	// 用于字典项功能中的字典列表

	public String dictAll() throws Exception {

		// dict.setDict_code(dict_code);
		// dict.setDict_name(dict_name);
		dictList = dictService.getListDict(dict);
		return "dictAll";
	}
	
	// 用于角色用户功能中的角色列表
	public String roleAll() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		User user = new User();
		Department department = new Department();
		String tempDepartcode = "";
		user = (User)session.getAttribute(Constants.userKey);
		department = user.getDepartment();
		tempDepartcode = department.getDepartcode();
		Role setRole = new Role();
		setRole.setDepartcode(StringUtil.trimEven0(tempDepartcode));
		//role.setDepartcode("111");
		roleList = roleService.getListRole(setRole);
		
		
		//取得登陆者拥有的（非所在部门及下属部门）的角色
		List loginOutDeptList = roleService.getloginUserRoleOutDeptList(user);
		
		if(loginOutDeptList!=null&&loginOutDeptList.size()>0){
			for(int i=0;i<loginOutDeptList.size();i++){
				roleList.add((Role)loginOutDeptList.get(i));
			}
		}
		
		
		return "roleAll";
	}

	/**
	 * 字典项树
	 * 
	 * @throws Exception
	 */
	public void dictItemTree() throws Exception {
		this.item_id = id;
		if (item_id == null || item_id.equals(""))
			item_id = "0";
		dict_item = new Dict_item();
		dict_item.setDict_code(dict_code);
		dict_item.setItem_id(Integer.parseInt(item_id));
		dictItemList = dict_itemService
				.getChildDict_itemListByItemIDAndDictCode(dict_item);
		Dict_item dictItem = new Dict_item();
		String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
		xml += "<tree id=\"" + item_id + "\"> \n";
		for (int i = 0; i < dictItemList.size(); i++) {
			dictItem = (Dict_item) dictItemList.get(i);
			xml += "<item text=\""
					+ dictItem.getDisplay_name().trim()
					+ "\" id=\""
					+ dictItem.getItem_id()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
			if ("Y".equals(dictItem.getLeaf_flag())) {
				xml += "child=\"0\"> \n";
			} else {
				xml += "child=\"1\"> \n";
			}
			xml += "<userdata name=\"" + dictItem.getItem_id() + "\">"
					+ dictItem.getFact_value() + "</userdata>\n";
			xml += "</item>\n";
		}
		xml += "</tree>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		// 
		out.close();
		;
	}
	
	
	/**
	 * 字典项树(可以选择根节点)
	 * 
	 * @throws Exception
	 */
	public void dictItemTree_fact() throws Exception {
		this.item_id = id;
		
		dict_item = new Dict_item();
		if (item_id == null || item_id.equals("")){
			item_id = "0";
			dict_item.setFact_value(fact_value); 	
		}
		dict_item.setDict_code(dict_code);
		dict_item.setItem_id(Integer.parseInt(item_id));
		dictItemList = dict_itemService
				.getChildDict_itemListByItemIDAndDictCode(dict_item);
		Dict_item dictItem = new Dict_item();
		String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
		xml += "<tree id=\"" + item_id + "\"> \n";
		for (int i = 0; i < dictItemList.size(); i++) {
			dictItem = (Dict_item) dictItemList.get(i);
			xml += "<item text=\""
					+ dictItem.getDisplay_name().trim()
					+ "\" id=\""
					+ dictItem.getItem_id()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
			if ("Y".equals(dictItem.getLeaf_flag())) {
				xml += "child=\"0\"> \n";
			} else {
				xml += "child=\"1\"> \n";
			}
			xml += "<userdata name=\"" + dictItem.getItem_id() + "\">"
					+ dictItem.getFact_value() + "</userdata>\n";
			xml += "</item>\n";
		}
		xml += "</tree>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		// 
		out.close();
		;
	}
	
	
	/**
	 * 字典项树(出租房详细地址)
	 * 
	 * @throws Exception
	 */
	
	
	
	public void dictItemTreexxdz() throws Exception {
		
		
		this.item_id = id;
		if (item_id == null || item_id.equals("")){
			item_id = "0";
			//allFact_value = "";
		}
			
		dict_item = new Dict_item();
		dict_item.setDict_code(dict_code);
		dict_item.setItem_id(Integer.parseInt(item_id));
		dictItemList = dict_itemService
				.getChildDict_itemListByItemIDAndDictCode(dict_item);
		Dict_item dictItem = new Dict_item();
		String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
		xml += "<tree id=\"" + item_id + "\"> \n";
		for (int i = 0; i < dictItemList.size(); i++) {
			dictItem = (Dict_item) dictItemList.get(i);
			xml += "<item text=\""
					+ dictItem.getDisplay_name().trim()
					+ "\" id=\""
					+ dictItem.getItem_id()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
			if ("Y".equals(dictItem.getLeaf_flag())) {
				xml += "child=\"0\"> \n";
			} else {
				xml += "child=\"1\"> \n";
				
				
			}
			xml += "<userdata name=\"" + dictItem.getItem_id() + "\">"
					+ dictItem.getFact_value() + "</userdata>\n";
			
			
			
			xml += "</item>\n";
		}
		xml += "</tree>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		// 
		out.close();
		;
	}
	/**
	 * 得到得到 详细地址
	 * @return
	 * @throws Exception
	 */
	public String getDictItemallvalue() throws Exception{
		       
		allFact_value = itemId;
		
		return "success";
		
	}
	
	

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 */
	public String dictItemTreeForm() throws Exception {
		return "dictItemTree";
	}

	
	// 获得参数列表
	public String paramAll() throws Exception {
		paramList = paramService.getListParam(param);
		return "paramAll";
	}

	/*
	 * 部门调整
	 */
	public void deptAdjust() throws Exception {

		// this.deptMessage = deptLdapService.deptAdjust();
	}

	/*
	 * 部门顺序修改
	 */
	public void deptEditEdOrder() throws Exception {

		// this.deptMessage = deptLdapService.updateEdOrder(lvForm.getMap());

	}

	/**
	 * 查询指定角色拥有哪个系统下的菜单
	 * 
	 * @return
	 */
	public String getRolesystemList() {
		try {
			Role_menu setRole_menu = new Role_menu();
			setRole_menu = (Role_menu) this.setClass(setRole_menu, null);
			if (lRoleSystem == null)
				lRoleSystem = new ArrayList();
			lRoleSystem.clear();
			lRoleSystem = role_menuService
					.getRolesystemListNoPage(setRole_menu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}
	
	/**
	 * 查询指定角色指定系统下的菜单
	 * 
	 * @return
	 */
	public String getRolesystemenuList() {
		try {
			Role_menu setRole_menu = new Role_menu();
			setRole_menu = (Role_menu) this.setClass(setRole_menu, null);
			if (lRoleSystemMenu == null)
				lRoleSystemMenu = new ArrayList();
			lRoleSystemMenu.clear();
			lRoleSystemMenu = role_menuService
					.getRolesystemenuListNoPage(setRole_menu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystemTreeFalg() {
		return systemTreeFalg;
	}

	public void setSystemTreeFalg(String systemTreeFalg) {
		this.systemTreeFalg = systemTreeFalg;
	}

	public String getParentSystemCode() {
		return parentSystemCode;
	}

	public void setParentSystemCode(String parentSystemCode) {
		this.parentSystemCode = parentSystemCode;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public void setDictService(IDictService dictService) {
		this.dictService = dictService;
	}

	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

	public String getDeptMessage() {
		return deptMessage;
	}

	public void setDeptMessage(String deptMessage) {
		this.deptMessage = deptMessage;
	}

	public String getDepartidFrom() {
		return departidFrom;
	}

	public void setDepartidFrom(String departidFrom) {
		this.departidFrom = departidFrom;
	}

	public String getDepartidTo() {
		return departidTo;
	}

	public void setDepartidTo(String departidTo) {
		this.departidTo = departidTo;
	}

	public void setRole_menuService(IRole_menuService role_menuService) {
		this.role_menuService = role_menuService;
	}

	public void setParamService(IParamService paramService) {
		this.paramService = paramService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAllFact_value() {
		return allFact_value;
	}

	public void setAllFact_value(String allFact_value) {
		this.allFact_value = allFact_value;
	}
	public String getDepartmentFullCode() {
		return departmentFullCode;
	}
	public void setDepartmentFullCode(String departmentFullCode) {
		this.departmentFullCode = departmentFullCode;
	}
	
	/**
	 * 部门树的生成(加入部门级别限制)
	 * 
	 * @throws Exception
	 */
	public void deptAllTreeWithDepartlevel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int departlevel = -999;
		String level = request.getParameter("level");
		if(level!=null && !level.trim().equals("") && level.trim().length()>0 && com.aisino2.core.util.StringUtil.isNumeric(level.trim())){
			try{
				departlevel = Integer.valueOf(level.trim());
			}catch(Exception numFromatException){
				departlevel = -999;
			}
		}else{
			departlevel = -999;
		}
		
		
		Department UserDepartment = new Department();
		String top_deptid_ba = this.getCacheGlobalpar("top_deptid_ba").getGlobalparvalue();
		UserDepartment.setDepartid(Integer.valueOf(top_deptid_ba));
		UserDepartment = departmentService.getDepartment(UserDepartment);
		List lst = new ArrayList();
		Department departmentOne = new Department();	
		if (id == null
				|| id.trim().equals(
						String.valueOf(UserDepartment.getParentdepartid()))) {
			
			id = String.valueOf(UserDepartment.getParentdepartid());
			departmentOne = UserDepartment;
			lst.clear();
			lst.add(departmentOne);
		} else {
			departmentOne.setDepartid(Integer.parseInt(id));
			// departmentOne.setDepartid(UserDepartment.getDepartid());
			if(departlevel>0){
				departmentOne.setDepartlevel(departlevel);
			}
			lst = departmentService.getChildDepart(departmentOne);
		}
		String xml = "";
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version='1.0' encoding='utf-8'?> \n");
		xmlBuffer.append("<tree id=\"" + id + "\"> \n");

		for (int i = 0; i < lst.size(); i++) {
			departmentOne = (Department) lst.get(i);
			xmlBuffer.append("<item text=\""
					+ departmentOne.getDepartname()
					+ "\" id=\""
					+ departmentOne.getDepartid()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ");
			
			if(departlevel>0){
				Integer levelFromBean = departmentOne.getDepartlevel();
				if ("Y".equals(departmentOne.getIsleaf())) {
					xmlBuffer.append("child=\"0\">");
				} else {
					if(levelFromBean!=null && levelFromBean>0 && levelFromBean.intValue()==departlevel){//数据库中非叶子节点级别与前台显示要求级别相等的，在前台改为叶子节点显示
						xmlBuffer.append("child=\"0\">");
					}else{
						xmlBuffer.append("child=\"1\">");
					}
				}
			}else{
				if ("Y".equals(departmentOne.getIsleaf())) {
					xmlBuffer.append("child=\"0\">");
				} else {
					xmlBuffer.append("child=\"1\">");
				}
			}
			xmlBuffer.append("<userdata name=\""+ departmentOne.getDepartid()+ "\">"
					+ departmentOne.getDepartcode()
					+ ","
					+ com.aisino2.common.StringUtil.trimEven0(departmentOne.getDepartcode())
					+","
					+departmentOne.getDepartlevel() 
					+","
					+departmentOne.getParentdepartid() 
					+","
					+departmentOne.getDepartfullcode()
					+","
					+departmentOne.getIsleaf()
					+ "</userdata>");
			xmlBuffer.append("</item>");
		}
		xmlBuffer.append("</tree>");
		xml = xmlBuffer.toString();
		// java.lang.System.out.println(xml);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		out.close();
	}
}
