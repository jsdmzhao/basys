package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.service.IMenuService;

public class MenuTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IMenuService menuService;

	/** @param 菜单(t_menu) */

	public void test() {
		Menu menu = new Menu();

	/** @ 菜单代码(menucode) */
	menu.setMenucode("test");

	/** @ 系统代码(systemcode) */
	menu.setSystemcode("test");

	/** @ 菜单名称(menuname) */
	menu.setMenuname("test");

	/** @ 功能入口(funcentry) */
	menu.setFuncentry("test");

	/** @ 菜单层次(menulevel) */
	menu.setMenulevel(0);

	/** @ 上级菜单代码(parentmenucode) */
	menu.setParentmenucode("test");

	/** @ 菜单全路径代码(menufullcode) */
	menu.setMenufullcode("test");

	/** @ 节点顺序(nodeorder) */
	menu.setNodeorder(0);

	/** @ 是否叶结点(isleaf) */
	menu.setIsleaf("te");

		/*
		//插入对象
		menuService.insertMenu(menu);

		//读取对象比较
		BaseObject bo = menuService.getMenu(menu);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Menu menuNew = (Menu)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(menuNew.getMenucode(), menu.getMenucode());
		assertEquals(menuNew.getSystemcode(), menu.getSystemcode());
		assertEquals(menuNew.getMenuname(), menu.getMenuname());
		assertEquals(menuNew.getFuncentry(), menu.getFuncentry());
		assertEquals(menuNew.getMenulevel(), menu.getMenulevel());
		assertEquals(menuNew.getParentmenucode(), menu.getParentmenucode());
		assertEquals(menuNew.getMenufullcode(), menu.getMenufullcode());
		assertEquals(menuNew.getNodeorder(), menu.getNodeorder());
		assertEquals(menuNew.getIsleaf(), menu.getIsleaf());

		//删除对象
		// @ 菜单代码(menucode) 
		menu.setMenucode(1)
		// @ 系统代码(systemcode) 
		menu.setSystemcode(1)

		menuService.deleteMenu(menu);

		//修改对象
		// @ 菜单代码(menucode) 
		menu.setMenucode(1)
		// @ 系统代码(systemcode) 
		menu.setSystemcode(1)

		menuService.updateMenu(menu);

		//查询单条
		// @ 菜单代码(menucode) 
		menu.setMenucode(1)
		// @ 系统代码(systemcode) 
		menu.setSystemcode(1)

		menuService.getMenu(menu);

		//查询多条
		// @ 菜单代码(menucode) 
		menu.setMenucode(1)
		// @ 系统代码(systemcode) 
		menu.setSystemcode(1)

		menuService.getListMenu(menu);

		//翻页查询
		// @ 菜单代码(menucode) 
		menu.setMenucode(1)
		// @ 系统代码(systemcode) 
		menu.setSystemcode(1)

		menuService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		Menu menuSort = new Menu();
		menuSort.setMenucode("xtgl_g");
		//menuSort.setWay("置顶");
		//menuSort.setWay("上移");
		//menuSort.setWay("下移");
		menuSort.setWay("置底");
		menuSort.setParentmenucode("0");
		menuSort.setSystemcode("glpt");
		menuService.updateMenuEditEdOrder(menuSort);
		//menuService.insertMenu(menu);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
}
