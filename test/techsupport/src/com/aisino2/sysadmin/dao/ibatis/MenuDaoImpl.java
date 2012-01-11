package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IMenuDao;
import com.aisino2.sysadmin.domain.Menu;

public class MenuDaoImpl extends BaseDao implements IMenuDao {
	/** @param 菜单(t_menu) 增加 */
	public Menu insertMenu(Menu menu){
		// TODO: implement
		return (Menu)insert("insertMenu", menu);
	}

	/** @param 菜单(t_menu) 删除 */
	public int deleteMenu(Menu menu){
		// TODO: implement
		return delete("deleteMenu", menu);
	}

	/** @param 菜单(t_menu) 修改 */
	public int updateMenu(Menu menu){
		// TODO: implement
		return update("updateMenu", menu);
	}

	/** @param 菜单(t_menu) 查询单条 */
	public Menu getMenu(Menu menu){
		// TODO: implement
	    Object obj = queryForObject("getMenu", menu);
	    return (obj == null) ? null : (Menu) obj;
	}

	/** @param 菜单(t_menu) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.menucode "+ desc;
			else if(sort.equals("1"))
				sCol = " a.menuname "+ desc;
			else if(sort.equals("2"))
				sCol = " a.parentmenucode "+ desc;
			else
				sCol = " a.nodeorder ";
		}else{
			sCol=" a.nodeorder ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getMenuList", map, pageNo,pageSize);
	}

	/** @param 菜单(t_menu) 多条查询 */
	public List getListMenu(Menu menu){
		// TODO: implement
		return queryForList("getMenuListNoPage", menu);
	}

	public List getChildMenu(Menu menu) {
		// TODO Auto-generated method stub
		 return queryForList("getChildMenu", menu);
	}

	//根据 用户id和syscode 获取菜单 3.29需求只看到用户所拥有的菜单
	public List getTheUserChildMenu(Menu menu) {
		return queryForList("getTheUserChildMenu", menu);
	}
	
	public boolean checkMenu(Menu menu) {
		// TODO Auto-generated method stub
		return ((Integer)queryForObject("checkMenu",menu)).intValue()>0;
	}

	public List getOwnMenu(Menu menu) {
		// TODO Auto-generated method stub
		return  queryForList("getOwnMenu", menu);
	}

	public boolean checkChild(Menu menu) {
		// TODO Auto-generated method stub
		Object obj = queryForObject("checkChildMenu", menu);
		return new Integer(obj.toString()).intValue()>0;
	}

	public List getAllChildren(Menu menu) {
		// TODO Auto-generated method stub
		return queryForList("getAllChildren",menu);
	}

	public List getAllMenu() {
		// TODO Auto-generated method stub
		return queryForList("getAllMenu",null);
	}

	public List getMenuBySystem(Menu menu) {

		return queryForList("getMenuBySystem",menu);
	}

	public Menu getParentMenu(Menu menu) {
		// TODO Auto-generated method stub
		  Object obj = queryForObject("getParentMenu", menu);
		    return (obj == null) ? null : (Menu) obj;
	}
	
	/** 获得下一个排序号 */
	public  Menu getNextNodeorder(Menu menu)
	{
		return (Menu) queryForObject("getNextMenuNodeorder", menu);
	}
	/** @根据角色取得所有菜单 */
	public List getRoleCheckedMenuList(Menu menu){
		return queryForList("getRoleCheckedMenuList",menu);
	}
}
