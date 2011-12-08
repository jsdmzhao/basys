package com.aisino2.sysadmin.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.domain.User;

public class UIContainer {
	private List<System> Modules;
	private List<Menu> trees;
	private User user;
	private TreeNodeTool tree_node_tool;

	public void initContainer(List<System> m, List<Menu> tr, User user,
			TreeNodeTool tree_node_tool) {
		Modules = m;
		trees = tr;
		this.user = user;
		this.tree_node_tool = tree_node_tool;
	}

	public String CreateAccordion(String html_element_container_id,
			String html_content_render_container_id) throws IOException {
		// accordtion菜单EXTJS代码
		String AccordionItems = "";

		for (int i = 0; i < Modules.size(); i++) {
			System module = Modules.get(i);
			List<Menu> this_system_menu_list = new ArrayList<Menu>();
			for (Menu m : trees) {
				if (m.getSystem().getSystemcode().equals(module.getSystemcode())) {
					this_system_menu_list.add(m);
				}
			}
			if (this_system_menu_list.size() > 0) {
				List<TreeNode> tree_node_list = tree_node_tool.parse_to_tree_node_from_menu(
																this_system_menu_list, true,
																null, user);
				
				AccordionItems += ","
						+ tree_node_tool
								.make_ext_tree(tree_node_list);
			}
		}

		if (AccordionItems.trim().length() > 0)
			AccordionItems = AccordionItems.substring(1);
		
		return AccordionItems;
	}
}
