package com.aisino2.sysadmin.authorization.impl;

import java.util.List;

import com.aisino2.sysadmin.authorization.IMenuAuthorization;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.service.IMenuService;

public class MenuAuthorizationImpl implements IMenuAuthorization {
		private IMenuService menuService;
	public IMenuService getMenuService() {
			return menuService;
		}

		public void setMenuService(IMenuService menuService) {
			this.menuService = menuService;
		}

	public boolean checkMenu(int userID, String menuCode) {
		// TODO Auto-generated method stub
			Menu menu = new Menu();
			menu.setUserid(userID);
			menu.setMenucode(menuCode);
			return menuService.checkMenu(menu);
			
 		
	}

	public List getOwnMenu(int userID, String systemID) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.setUserid(userID);
		menu.setSystemcode(systemID);
		return menuService.getOwnMenu(menu);
	}



}
