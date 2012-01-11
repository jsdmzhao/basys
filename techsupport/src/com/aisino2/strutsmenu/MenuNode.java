package com.aisino2.strutsmenu;

import net.sf.navigator.menu.MenuComponent;

public class MenuNode extends MenuComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
