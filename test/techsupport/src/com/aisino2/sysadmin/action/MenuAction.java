package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.common.TreeMenu;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IMenuService;
import com.aisino2.sysadmin.service.ISystemService;

public class MenuAction extends PageAction {
	private IMenuService menuService;
	private ISystemService systemService;
	private List lMenu;
	private List ldata;
	private Menu menu;
	private Menu nowMenu;
	private String tabledata;
	private int totalrows;
	private String result = "";

	private String moveParentid;
	private String moveSelectId;
	private String moveWay;

	private String strResult;

	private int userid;// 登录用户ID
	private String parentmenucode;// 菜单父节点代码
	private String treeMenuString;// 存放菜单树
	private List lTreeMenuList;
	private String fullcodelike;//用于查询单一行业下所有菜单

	private String usertype;// 用户类别

	public void setFullcodelike(String fullcodelike) {
		this.fullcodelike = fullcodelike;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public List getLdata() {
		return ldata;
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

	public Menu getMenu() {
		return menu;
	}

	public List getLMenu() {
		return lMenu;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public Menu getNowMenu() {
		return nowMenu;
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

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setParentmenucode(String parentmenucode) {
		this.parentmenucode = parentmenucode;
	}

	public void setTreeMenuString(String treeMenuString) {
		this.treeMenuString = treeMenuString;
	}

	public void setLTreeMenuList(List treeMenuList) {
		lTreeMenuList = treeMenuList;
	}

	public List getLTreeMenuList() {
		return lTreeMenuList;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("menucode");
		lPro.add("menucode");
		lPro.add("menuname");
		lPro.add("parentmenuname");

		List lDetail = new ArrayList();
		lDetail.add("setMenuDetail");
		lDetail.add("详细");

		List lModify = new ArrayList();
		lModify.add("setModifyQuery");
		lModify.add("修改");

		List lDel = new ArrayList();
		lDel.add("setDelete");
		lDel.add("删除");

		List lCol = new ArrayList();
		lCol.add(lDetail);
		lCol.add(lModify);
		lCol.add(lDel);

		Menu getMenu = new Menu();

		this.setData(getMenu, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 菜单管理入口 系统编号、当前菜单编号
	 * 
	 * @return
	 */
	public String queryMenu() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String systemcode = request.getParameter("systemcode");
		String menucode = request.getParameter("menucode");
		if (systemcode == null || "".equals(systemcode)) {
			systemcode = "";
		}
		if (menucode == null || "".equals(menucode)) {
			menucode = "0";
		}
		request.setAttribute("menucode", menucode);
		request.setAttribute("systemcode", systemcode);
		return SUCCESS;
	}

	/**
	 * 显示 当前菜单
	 * 
	 * @return
	 */
	public String showMenu() throws Exception {
		try {
			Menu setMenu = new Menu();
			nowMenu = (Menu) this.setClass(setMenu, null);
			nowMenu = menuService.getMenu(nowMenu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 根据条件 请求列表
	 * 
	 * @return
	 */
	public String querylist() throws Exception {
		try {
			Menu setMenu = new Menu();
			setMenu = (Menu) this.setClass(setMenu, null);
			Map map = new HashMap();
			map.put("parentmenucode", setMenu.getMenucode());
			map.put("systemcode", setMenu.getSystemcode());
			Page page = menuService.getListForPage(map, pagesize, pagerow,
					null, null);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setTabledata(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 请求单条
	 * 
	 * @return
	 */
	public String query() throws Exception {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);
			menu = menuService.getMenu(menu);
			lMenu = new ArrayList();
			lMenu.add(menu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);
			menu = menuService.insertMenu(menu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);
			menuService.updateMenu(menu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);
			menuService.deleteMenu(menu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 移动排序
	 * 
	 * @return
	 */
	public String moveSort() {
		try {
			Menu moveMenu = new Menu();
			moveMenu.setParentmenucode(moveParentid);
			moveMenu.setMenucode(moveSelectId);
			moveMenu.setWay(moveWay);
			menuService.updateMenuEditEdOrder(moveMenu);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 获取 兄弟节点最大排序号
	 * 
	 * @return
	 */
	public String nextNodeorder() {
		try {
			strResult = "";
			Menu setMenu = new Menu();
			setMenu = (Menu) this.setClass(setMenu, null);
			strResult = String.valueOf(menuService.getNextNodeorder(setMenu));
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 验证菜单编号
	 * 
	 * @return
	 */
	public String validateMenu() {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);
			String menucode = menu.getMenucode();
			Map map = new HashMap();
			map.put("tableName", "t_menu");
			if (menucode != "") {
				map.put("menucode", menucode);
			}
			boolean result = systemService.isExit(map);
			strResult = "";
			if (result) {
				strResult = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 根据登录用户获得index页面菜单，获得parentmenucode指定的菜单
	 */
	public String mainMenu() {
		try {
			if (menu == null)
				menu = new Menu();
			menu.setUserid(userid);
			menu.setParentmenucode(parentmenucode);

			if (lMenu == null)
				lMenu = new ArrayList();
			lMenu.clear();

			lMenu = menuService.getOwnMenu(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 根据登录用户获得index页面菜单,获得所有菜单
	 */
	public String allMenu() {
		try {
			menu = new Menu();
			// 首先获得顶级菜单(平板结构)
			menu.setUserid(userid);
			menu.setParentmenucode("");

			Globalpar globalpar = new Globalpar();
			if (usertype.equals("9999")) {
				globalpar.setGlobalparcode("glryzxsglcd");
				List list = CacheManager.getCacheGlobalpar(globalpar);
				String glryzxsglcd = "";
				if (list != null && list.size() > 0) {
					glryzxsglcd = (((Globalpar) list.get(0))
							.getGlobalparvalue()).toString();
				}
				if (glryzxsglcd.equals("1")) {
					menu.setMenuTypeCode("1");// 只显示管理菜单
				}
			} else {

				globalpar.setGlobalparcode("ptryzxsywcd");
				List lista = CacheManager.getCacheGlobalpar(globalpar);
				String ptryzxsglcd = "";
				if (lista != null && lista.size() > 0) {
					ptryzxsglcd = (((Globalpar) lista.get(0))
							.getGlobalparvalue()).toString();
				}

				if (ptryzxsglcd.equals("1")) {
					menu.setMenuTypeCode("0");// 只显示业务菜单
				}

			}
			//加入全局参数“多行业展开菜单”，若为1，菜单必然展开；否则进行行业个数判定
			
			globalpar.setGlobalparcode("dhyzkcd");
			List listb = CacheManager.getCacheGlobalpar(globalpar);
			String dhyzkcd = "0";
			if (listb != null && listb.size() > 0) {
				dhyzkcd = (((Globalpar) listb.get(0))
						.getGlobalparvalue()).toString();
			}

			// 若用户只属于一个行业，则不显示顶级菜单
			String[] userTypeArr = new String[usertype.split(",").length];
			userTypeArr = usertype.split(",");
			int hylbCounter = 1;// 行业类别计数器
			if (userTypeArr != null) {
				if (userTypeArr.length >= 2) {
					String tempUsertype = userTypeArr[0].substring(0,
							userTypeArr[0].length() - 1);
					for (int i = 1; i < userTypeArr.length; i++) {
						if (!tempUsertype.equals(userTypeArr[i].substring(0,
								userTypeArr[i].length() - 1))) {
							tempUsertype = userTypeArr[i].substring(0,
									userTypeArr[i].length() - 1);
							hylbCounter++;
						}

					}
				}
			}
			if (hylbCounter <= 1||dhyzkcd.equals("1"))
				menu.setSingleHylb("1");

			if (lMenu == null)
				lMenu = new ArrayList();
			
			//只查询出fullcodelike行业的菜单
			if(fullcodelike != null){
				menu.setFullcodelike(fullcodelike+"%");
				menu.setSingleHylb("1");
			}
			lMenu = menuService.getOwnMenu(menu);

			// 得到UL及LI拼成的树形串
			TreeMenu treeMenu = new TreeMenu();
			treeMenuString = "";

			if (lTreeMenuList == null)
				lTreeMenuList = new ArrayList();
			lTreeMenuList.clear();
			if (lMenu != null) {
				treeMenu.setReturnXml(lMenu);
				treeMenuString = treeMenu.getReturnXml().toString();
				// lTreeMenuList.add(treeMenuString);
				Menu resultMenu = new Menu();
				resultMenu.setMenucode(treeMenuString);
				lTreeMenuList.clear();
				lTreeMenuList.add(resultMenu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 根据登录用户获得行业菜单
	 */
	public String queryHangYeMenu() {
		try {
			menu = new Menu();
			//登录用户ID，用于获得菜单
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);

			menu.setUserid(userid);
			menu.setParentmenucode("0");
			
			
			String hycdpcggmk = "'xtgl_g','gad-glpt'";
			Globalpar globalpar = this.getCacheGlobalpar("hycdpcggmk");
			
			if(globalpar!=null){
				//menu.setMenucodein(globalpar.getGlobalparvalue());
				hycdpcggmk = globalpar.getGlobalparvalue();
			}

			lMenu = menuService.getOwnMenu(menu);
			if(lMenu!=null){
				int length,hylength;
				length = hylength = lMenu.size();
				for(int index=0;index<length;index++){
					menu = (Menu)lMenu.get(index);
					if(hycdpcggmk.indexOf(("'"+menu.getMenucode()+"'"))>-1){
						hylength--;
					}
				}
				menu.setSingleHylb(String.valueOf(hylength));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "0";
		}
		return "success";
	}

	public String getTreeMenuString() {
		return treeMenuString;
	}

	/**
	 * 菜单下拉列表查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querySelMenu() throws Exception {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);
			// setDict_item.setDict_code(dict_code);
			// }
			ldata = new ArrayList();

			ldata = menuService.getListMenu(menu);

			if (ldata == null)
				ldata = new ArrayList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 根据登录用户获得index页面菜单,获得所有菜单
	 */
	public String queryUserMenu() {
		try {
			Menu setMenu = new Menu();
			//登录用户ID，用于获得菜单
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			setMenu.setUserid(user.getUserid());

			List menuList = new ArrayList();
			menuList = menuService.getOwnMenu(setMenu);
			this.result = "0";
			for (java.util.Iterator iter = menuList.iterator(); iter.hasNext();) {
				Menu oneMenu = (Menu) iter.next();
				// "场所信息提交"和"从业人员提交"菜单存在的情况
				if("csxxtjbzh_cjd".equals(oneMenu.getMenucode())
						|| "cyrytj-cjd-bzh".equals(oneMenu.getMenucode())){
					this.result = "1";
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "0";
		}
		return "success";
	}
	
	public void removeSessionMenu() throws Exception{
		this.getRequest().getSession().removeAttribute("roleMenuMap");
	}
	
	public String sheZhiChildNode() throws Exception{
		try{
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);

			String systemCode = menu.getSystemcode();
			
			Map roleMenuMap = (Map) this.getRequest().getSession().getAttribute(
			"roleMenuMap");
			if (roleMenuMap != null && systemCode != null) {
				String strWay = menu.getWay();
				Integer check;
				int intCheck = menu.getIschecked().intValue();
				if(intCheck==0 || intCheck==-1){
					check = new Integer(1);
				}else{
					check = new Integer(0);
				}
				lMenu = (List)roleMenuMap.get(systemCode);
				int length = lMenu.size();
				if(strWay!=null && strWay.equals("0")){
					for(int index=0;index<length;index++){
						setMenu = (Menu)lMenu.get(index);
						if(setMenu.getSystemcode().equals(systemCode)){
							setMenu.setIschecked(check);
						}
					}
				}else{
					boolean otherMenu = false;
					int index = 0;
					for(;index<length;index++){
						setMenu = (Menu)lMenu.get(index);
						if(setMenu.getMenufullcode().indexOf(strWay)==0){
							setMenu.setIschecked(check);
							otherMenu = true;
						}else if(otherMenu){
							break;
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		lMenu = null;
		this.result = "success";
		return "success";
	}

	public String queryChildRoleMenu() throws Exception {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);

			Map roleMenuMap = (Map) this.getRequest().getSession().getAttribute(
					"roleMenuMap");
			
			String strWay = menu.getWay();
			String systemCode = menu.getSystemcode();
			if (roleMenuMap != null && strWay != null && !strWay.equals("")
					&& systemCode != null) {
				lMenu = (List)roleMenuMap.get(systemCode);

				//父节点选中状态,选中(1):子节点默认选中
				int parentCheck = menu.getIschecked().intValue();
				// 组装菜单table初始化参数
				StringBuffer bufferStr = new StringBuffer("<table><tbody>");
				String way,setMenuCode;
				String waySpace = null, waySpaceOld = "&nbsp;", waySpace1 = "&emsp;&emsp;", waySpace2 = "&emsp;&emsp;&emsp;", waySpace3 = "&emsp;&emsp;&emsp;&emsp;", waySpace4 = "&emsp;&emsp;&emsp;&emsp;&emsp;", waySpace5 = "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;";
				String isChecked = null, isLeaf = null, leaf = null;
				int checked = 0;
				int length = lMenu.size();
				// 判断点击的级别,若为0(系统),则取出行业菜单,若为其他(行业),则取出行业下所有菜单
				int index = 0,checkIndex = 0;

				// 取出行业菜单,并组装成菜单table,取出后从list删除
				String menuCode = menu.getMenucode();
				if (strWay.equals("1")) {
					menuCode = "0";
				}
				// 依据systemcode和menucode判断并组装下一级菜单
				while (index < length) {
					setMenu = (Menu) lMenu.get(index);
					if (setMenu.getParentmenucode().equals(menuCode)) {

						way = setMenu.getWay();
						leaf = setMenu.getIsleaf();
						if (leaf.equals("Y")) {
							isLeaf = "&emsp;";
						} else {
							isLeaf = "＋";
						}

						// 判断节点的层级
						if (way.equals("3")) {
							waySpace = waySpace3;
						} else if (way.equals("2")) {
							waySpace = waySpace2;
						} else if (way.equals("1")) {
							waySpace = waySpace1;
						} else if (way.equals("4")) {
							waySpace = waySpace4;
						} else if (way.equals("5")) {
							waySpace = waySpace5;
						} else {
							waySpace = waySpaceOld;
						}
						if(parentCheck==-1){
							checked = setMenu.getIschecked().intValue();
							if(checked==1){
								setMenuCode = setMenu.getMenufullcode();
								checkIndex = index+1;
								for(;checkIndex<length;checkIndex++){
									menu = (Menu)lMenu.get(checkIndex);
									if(menu.getMenufullcode().indexOf(setMenuCode)==0){
										if(menu.getIschecked().intValue()==0){
											checked = -1;
											break;
										}
									}else{
										break;
									}
								}
								setMenu.setIschecked(new Integer(checked));
							}
						}

						this.zuZhuangStrBack(setMenu, bufferStr, isChecked,
								way, waySpace, isLeaf);
						lMenu.remove(index);
						length = lMenu.size();
					} else {
						index++;
					}
				}
				bufferStr.append("</tbody></table>");
				this.tabledata = bufferStr.toString();
				menu = null;
				lMenu = null;
				bufferStr = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result = "success";
		return "success";
	}

	public String querylistRoleMenu() throws Exception {
		try {
			Menu setMenu = new Menu();
			menu = (Menu) this.setClass(setMenu, null);
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			User user = (User) session.getAttribute(Constants.userKey);
			menu.setUserid(user.getUserid());
			menu.setDepartid(user.getDepartment().getParentdepartid());

			List menuList = menuService.getRoleCheckedMenuList(menu);

			// 角色可操作的系统
			List systemList = menu.getLChildMenu();
			Map roleMenuMap = new HashMap();
			if (systemList != null && menuList != null) {
				List mapList;
				int length = systemList.size();
				int menuLen = menuList.size();
				int menuIndex = 0;
				int checked;

				// 组装菜单table初始化参数
				StringBuffer bufferStr = new StringBuffer("<table><tbody>");
				String way;
				String waySpace = null, waySpaceOld = "&nbsp;", waySpace1 = "&emsp;&emsp;", waySpace2 = "&emsp;&emsp;&emsp;", waySpace3 = "&emsp;&emsp;&emsp;&emsp;", waySpace4 = "&emsp;&emsp;&emsp;&emsp;&emsp;", waySpace5 = "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;";
				String isChecked = null, isLeaf = null,systemCode;
				int allChecked = 0,systemIndex = 0;
				for (int index = 0; index < length; index++) {
					mapList = new ArrayList();
					checked = 0;allChecked = 0;systemIndex = 0;
					System system = (System) systemList.get(index);
					systemCode = system.getSystemcode();
					for (; menuIndex < menuLen; menuIndex++) {
						setMenu = (Menu) menuList.get(menuIndex);
						if (systemCode.equals(
								setMenu.getSystemcode())) {
							if (setMenu.getIschecked().intValue() == 1){
								checked = 1;
								allChecked++;
							}
							mapList.add(setMenu);
							systemIndex++;
						} else {
							break;
						}
					}
					if(allChecked!=0 && allChecked<systemIndex)
						checked = -1;

					setMenu = new Menu();
					setMenu.setSystemcode(systemCode);
					setMenu.setMenuname(system.getSystemname());
					setMenu.setMenucode(systemCode);
					setMenu.setParentmenucode("");
					setMenu.setMenufullcode("0");
					setMenu.setIschecked(new Integer(checked));
					setMenu.setIsleaf("N");

					// 判断节点是否为叶子节点，决定是否可以展开
					isLeaf = "＋";

					way = "0";
					// 判断节点的层级
					if (way.equals("3")) {
						waySpace = waySpace3;
					} else if (way.equals("2")) {
						waySpace = waySpace2;
					} else if (way.equals("1")) {
						waySpace = waySpace1;
					} else if (way.equals("4")) {
						waySpace = waySpace4;
					} else if (way.equals("5")) {
						waySpace = waySpace5;
					} else {
						waySpace = waySpaceOld;
					}
					this.zuZhuangStrBack(setMenu, bufferStr, isChecked, way,
							waySpace, isLeaf);
					
					roleMenuMap.put(systemCode, mapList);
				}
				bufferStr.append("</tbody></table>");
				this.tabledata = bufferStr.toString();

				// 角色可操作的菜单
				session.setAttribute("roleMenuMap", roleMenuMap);
				menu = null;
				lMenu = null;
				bufferStr = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result = "success";
		return "success";
	}

	private void zuZhuangStrBack(Menu setMenu, StringBuffer bufferStr,
			String isChecked, String way, String waySpace, String leaf) {

		bufferStr.append("<tr ck='");
		bufferStr.append(setMenu.getIschecked());
		bufferStr.append("' way='");
		bufferStr.append(way);
		bufferStr.append("' id='");
		bufferStr.append(setMenu.getMenucode());
		bufferStr.append("' pd='");
		bufferStr.append(setMenu.getParentmenucode());
		bufferStr.append("' fd='");
		bufferStr.append(setMenu.getMenufullcode());
		bufferStr.append("' sd='");
		bufferStr.append(setMenu.getSystemcode());
		bufferStr.append("' lf='");
		bufferStr.append(setMenu.getIsleaf());
		bufferStr.append("'><td>");
		bufferStr.append(waySpace);
		bufferStr.append(" <span onclick='spCk(this)'>");
		bufferStr.append(leaf);
		bufferStr.append("</span><img onclick='imCk(this)' /><span>");
		bufferStr.append(setMenu.getMenuname());
		bufferStr.append("</span></td></tr>");
	}
}