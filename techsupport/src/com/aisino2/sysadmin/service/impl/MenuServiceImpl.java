package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IMenuDao;
import com.aisino2.sysadmin.dao.ISystemDao;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.service.IMenuService;

public class MenuServiceImpl extends BaseService implements IMenuService {

	private IMenuDao menuDao;
	private ISystemDao systemDao;

	/** @param 菜单(t_menu) 增加 */
	public Menu insertMenu(Menu menu){
		// TODO: implement
		 Menu parentMenu = menuDao.getParentMenu(menu);
		    if (parentMenu != null) {
		      if ("Y".equals(parentMenu.getIsleaf())) {
		        parentMenu.setIsleaf("N");
		        menuDao.updateMenu(parentMenu);
		      }
		      menu.setMenufullcode(parentMenu.getMenufullcode()+ menu.getMenucode() + ".");
		      menu.setMenulevel(parentMenu.getMenulevel() + 1);
		    } else {
		      menu.setMenufullcode(menu.getMenucode() + ".");
		      menu.setMenulevel(1);
		    }

		    return (Menu)menuDao.insertMenu(menu);
	}

	/** @param 菜单(t_menu) 删除 */
	public boolean deleteMenu(Menu menu){
		// TODO: implement
		menu = getMenu(menu);
		  String  parentmenucode = menu.getParentmenucode();
			int i= menuDao.deleteMenu(menu);
			Menu parentmenu = new Menu();
			parentmenu.setParentmenucode(parentmenucode);
			boolean flag = menuDao.checkChild(parentmenu);
			if(!flag){
				parentmenu = menuDao.getParentMenu(parentmenu);
				parentmenu.setIsleaf("Y");
				menuDao.updateMenu(parentmenu);
			}
			//i==-1删除成功，-1是ibatis删除成功返回的值
	     return i==-1?true:false;
	}
	/**
	    * 菜单的上移、下移、置顶、置底
	    * @param menu
	    * menu.way取值：上移,下移,置顶,置底
	    * @return
	*/
	public boolean updateMenuEditEdOrder(Menu menuOrigin)
	{
		boolean isSuccess = false;
		Menu menu = new Menu();
		Menu parentMenu = new Menu();
		Menu swapMenu = new Menu();
		int swapNodeorder = -1;
		int swapNodeorderTwo = -1;
		String menuCode = "";
		//获得menu的父节点
		menu.setMenucode(menuOrigin.getMenucode());
		menu = menuDao.getMenu(menu);
		parentMenu.setParentmenucode(menu.getParentmenucode());
		parentMenu = menuDao.getParentMenu(parentMenu);
		//获得menu的所有兄弟节点,包括自身
		if(parentMenu == null)//若该菜单为顶级菜单，则其父菜单的menucode为0
		{
			parentMenu = new Menu();
			parentMenu.setMenucode("0");
			parentMenu.setSystemcode(menu.getSystemcode());
		}
		List siblingList = menuDao.getChildMenu(parentMenu);
		
		//若无兄弟节点，则无需进行移动操作
		if(siblingList == null)
			return true;
		else if(siblingList.size()==0)
			return true;

		if(menuOrigin !=null)
		{
			menuCode = menu.getMenucode();
			swapNodeorder = menu.getNodeorder();
			if(menuCode != null)
			{
				if(menuOrigin.getWay()!=null)
				{
					for(int i = 0;i<siblingList.size();i++)
					{
						menu = (Menu)siblingList.get(i);
						if(menuCode.equals(menu.getMenucode()))
						{
							if(menuOrigin.getWay().equals("上移"))
							{
								if(i>0)//第一个子节点无需上移
								{
									//交换需上移节点与其上一个节点的排序号
									swapMenu = (Menu)siblingList.get(i-1);
									menu.setNodeorder(swapMenu.getNodeorder());
									swapMenu.setNodeorder(swapNodeorder);
									menuDao.updateMenu(swapMenu);
									menuDao.updateMenu(menu);
									
								}
								else
									break;
							}
							else if(menuOrigin.getWay().equals("下移"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需下移
								{
									//交换需下移节点与其下一个节点的排序号
									swapMenu = (Menu)siblingList.get(i+1);
									menu.setNodeorder(swapMenu.getNodeorder());
									swapMenu.setNodeorder(swapNodeorder);
									menuDao.updateMenu(swapMenu);
									menuDao.updateMenu(menu);
									
								}
								else
									break;
							}
							else if(menuOrigin.getWay().equals("置顶"))
							{
								if(i>0)//第一个子节点无需置顶
								{
									swapMenu = (Menu)siblingList.get(0);
									menu.setNodeorder(swapMenu.getNodeorder());
									menuDao.updateMenu(menu);
									for(int j = i;j>0;j--)
									{
										swapMenu = (Menu)siblingList.get(j-1);
										swapNodeorderTwo = swapMenu.getNodeorder();
										swapMenu.setNodeorder(swapNodeorder);
										menuDao.updateMenu(swapMenu);
										swapNodeorder = swapNodeorderTwo;
									}
									
								}
								else
									break;
							}
							else if(menuOrigin.getWay().equals("置底"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需置底
								{
									swapMenu = (Menu)siblingList.get(siblingList.size()-1);
									menu.setNodeorder(swapMenu.getNodeorder());
									menuDao.updateMenu(menu);
									for(int j = i;j<siblingList.size()-1;j++)
									{
										swapMenu = (Menu)siblingList.get(j+1);
										swapNodeorderTwo = swapMenu.getNodeorder();
										swapMenu.setNodeorder(swapNodeorder);
										menuDao.updateMenu(swapMenu);
										swapNodeorder = swapNodeorderTwo;
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

	/** @param 菜单(t_menu) 修改 */
	public boolean updateMenu(Menu menu){
		// TODO: implement
		return menuDao.updateMenu(menu)>0;
	}

	/** @param 菜单(t_menu) 查询单条 */
	public Menu getMenu(Menu menu){
		// TODO: implement
		return (Menu)menuDao.getMenu(menu);
	}

	public ISystemDao getSystemDao() {
		return systemDao;
	}

	public void setSystemDao(ISystemDao systemDao) {
		this.systemDao = systemDao;
	}

	/** @param 菜单(t_menu) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return menuDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 菜单(t_menu) 多条查询 */
	public List getListMenu(Menu menu){
		// TODO: implement
		return menuDao.getListMenu(menu);
	}

	public IMenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List getChildMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.getChildMenu(menu);
	}
	
	//根据 用户id和syscode 获取菜单 3.29需求只看到用户所拥有的菜单
	public List getTheUserChildMenu(Menu menu) {
		return menuDao.getTheUserChildMenu(menu);
	}

	public boolean checkMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.checkMenu(menu);
	}

	public List getOwnMenu(Menu menu) {
		// TODO Auto-generated method stub
		List menuList = menuDao.getOwnMenu(menu);
		return menuList.size()>0 ? menuList :null;
	}

	public List getAllMenu() {
		// TODO Auto-generated method stub
		return menuDao.getAllMenu();
	}

	public Menu getParentMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.getParentMenu(menu);
	}
	/**
	   * 获得下一个排序号
	   * @param menu.parentmenucode
	   * @return 
	*/
	public Integer getNextNodeorder(Menu menu)
	{
		Integer nextNodeorder = 0;
		Menu newMenu = new Menu();
		newMenu = menuDao.getNextNodeorder(menu);
		if(newMenu != null)
		{
			nextNodeorder = newMenu.getNodeorder();
		}
		return nextNodeorder;
	}

	  /** @根据角色取得所有菜单 */
	public List getRoleCheckedMenuList(Menu menu){
		List resultList = null;
		System system = new System();
		system.setSystemcode("0");
		Integer usrId = menu.getUserid();
		Integer departId = menu.getDepartid();
		system.setUserid(usrId);
		List systemList;
		boolean isZuiGaoJi = false;
		if((isZuiGaoJi=!(departId.intValue()==0))){
			systemList = systemDao.getTheUserChildSystem(system);
		}else{
			systemList = systemDao.getChildSystem(system);
		}
		if(systemList!=null){
			StringBuffer bufferStr = new StringBuffer();
			int length = systemList.size();
			int lengthJ1 = length - 1;
			String sysCode = null;
			Integer roleId = menu.getRoleid();
			if(isZuiGaoJi){
				for(int index=0;index<length;index++){
					system = (System)systemList.get(index);
					sysCode = system.getSystemcode();
					//bufferStr.append("select '"+sysCode+"' systemcode,'"+system.getSystemname()+"' menuname,'"+sysCode+"' menucode,'' parentmenucode,'0' menufullcode,'0' way,0 ischecked,'N' isleaf from dual union all ");
					bufferStr.append("select t.systemcode, t.menuname,t.menucode,t.parentmenucode,t.menufullcode,level way,decode((select 1 from t_role_menu b where b.menucode=t.menucode and b.roleid="+roleId+"),1,1,0) ischecked,t.isleaf isleaf ");
					bufferStr.append("from t_menu t where t.systemcode='"+sysCode+"' and  exists(select 1 from t_user b, t_user_role c, t_role_menu d where b.userid = c.userid and c.roleid = d.roleid and t.menucode = d.menucode ");
					bufferStr.append("and b.userid = "+usrId+") start with t.parentmenucode = '0' connect by prior t.menucode = t.parentmenucode");
					if(index!=lengthJ1)
						bufferStr.append(" union all ");
				}
			}else{
				for(int index=0;index<length;index++){
					system = (System)systemList.get(index);
					sysCode = system.getSystemcode();
					//bufferStr.append("select '"+sysCode+"' systemcode,'"+system.getSystemname()+"' menuname,'"+sysCode+"' menucode,'' parentmenucode,'0' menufullcode,0 way,0 ischecked,'N' isleaf from dual union all ");
					bufferStr.append("select t.systemcode, t.menuname,t.menucode,t.parentmenucode,t.menufullcode,level way,decode((select 1 from t_role_menu b where b.menucode=t.menucode and b.roleid="+roleId+"),1,1,0) ischecked,t.isleaf isleaf ");
					bufferStr.append("from t_menu t where t.systemcode='"+sysCode+"' start with t.parentmenucode = '0' connect by prior t.menucode = t.parentmenucode");
					if(index!=lengthJ1)
						bufferStr.append(" union all ");
				}
			}
			menu.setPageSort(bufferStr.toString());
			resultList = menuDao.getRoleCheckedMenuList(menu);
			menu.setLChildMenu(systemList);
		}
		  return resultList;
	}
}
