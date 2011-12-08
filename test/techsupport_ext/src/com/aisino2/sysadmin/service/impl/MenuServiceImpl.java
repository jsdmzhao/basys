package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IMenuDao;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IMenuService;

@Component
public class MenuServiceImpl implements IMenuService {
	private IMenuDao menu_dao;

	@Resource(name="menuDaoImpl")
	public void setMenu_dao(IMenuDao menu_dao) {
		this.menu_dao = menu_dao;
	}

	public void insertMenu(Menu menu) {
		this.menu_dao.insertMenu(menu);
	}

	public void deleteMenu(Menu menu) {
		this.menu_dao.deleteMenu(menu);
	}

	public void updateMenu(Menu menu) {
		this.menu_dao.updateMenu(menu);
	}

	public Menu getMenu(Menu menu) {
		return this.menu_dao.getMenu(menu);
	}

	public List getListForPage(Menu menu, int pageNo, int pageSize,
			String sort, String desc) {
		
		return this.menu_dao.getListForPage(menu, pageNo, pageSize, sort, desc);
	}

	public List<Menu> getListMenu(Menu menu) {
		return this.menu_dao.getListMenu(menu);
	}

	public List<Menu> getChildMenu(Menu menu) {
		return this.menu_dao.getChildMenu(menu);
	}

	public List<Menu> getTheUserChildMenu(Menu menu, User user) {
		return this.menu_dao.getTheUserChildMenu(menu, user);
	}

	public boolean checkMenu(Menu menu) {
		return this.menu_dao.checkChild(menu);
	}

	public List<Menu> getOwnMenu(Menu menu) {
		return this.menu_dao.getOwnMenu(menu);
	}

	public Menu getParentMenu(Menu menu) {
		return this.menu_dao.getParentMenu(menu);
	}

	public List<Menu> getAllMenu() {
		return this.menu_dao.getAllMenu();
	}

	public boolean updateMenuEditEdOrder(Menu menu) {
		return false;
	}

	public Integer getNextNodeorder(Menu menu) {
		return 0;
	}

	public List<Menu> getRoleCheckedMenuList(Menu menu) {
		return this.menu_dao.getRoleCheckedMenuList(menu);
	}

}
