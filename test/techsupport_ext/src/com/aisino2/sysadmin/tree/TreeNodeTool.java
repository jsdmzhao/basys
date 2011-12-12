package com.aisino2.sysadmin.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IMenuService;

/**
 *
 *
 */
@Component
public class TreeNodeTool {
	private IMenuService menu_service;
	private IDepartmentService deparemnt_service;

	/**
	 * 生成EXT 树
	 * 
	 * @param node_list
	 *            节点列表已经具有树形结构。
	 * @return
	 */
	public StringBuffer make_ext_tree(List<TreeNode> node_list) {
		StringBuffer tree_buf = new StringBuffer();
		if (node_list == null || node_list.size() == 0)
			throw new RuntimeException("节点列表为空");

		tree_buf.append("{id:'tree_" + node_list.get(0).getId() + "',\n");
		// 设置鼠标指针
		tree_buf.append("\t		useArrows: true,\n");
		// 设置自动滚轮
		tree_buf.append("\t		autoScroll: true,\n");
		// 设置动画效果
		tree_buf.append("\t		animate: true,\n");
		// 不打开拖拽
		tree_buf.append("\t		enableDD: false,\n");
		// 设置容器滚轮
		tree_buf.append("\t		containerScroll: true,\n");
		// 设置类型
		tree_buf.append("\t		xtype:'treepanel', \n");
		// 设置这个树形面板不用边框
		tree_buf.append("\t		border: false, \n");
		// 设置标题
		tree_buf.append("\t		title:'"
				+ node_list.get(0).getAttributes().get("system_name") + "'");
		// 设置根节点
		// 当为一个节点的时候，就把该节点作为根节点设置到里面
		if (node_list.size() == 1) {
			tree_buf.append("\t		,root:");
			make_ext_tree_node(node_list, tree_buf);
			tree_buf.append("\n");
		}
		// 当为多个节点的时候，初始化一个没有没名字的根节点，然后把多个节点作为子节点设置到里面
		else {
			tree_buf.append("\t		,rootVisible: false");
			tree_buf.append("\t		,root:{id:'"
					+ node_list.get(0).getId().split("__")[0] + "',\n");
			tree_buf.append("\t			text:'',\n");
			tree_buf.append("\t			cn:[");
			make_ext_tree_node(node_list, tree_buf);
			tree_buf.append("]\n");

			tree_buf.append("\t		}");
		}
		tree_buf.append("}\n");

		return tree_buf;
	}

	public StringBuffer make_ext_tree_node(List<TreeNode> node_list,
			StringBuffer buff) {
		for (int i = 0; i < node_list.size(); i++) {
			TreeNode node = node_list.get(i);
			if (i > 0)
				buff.append(",");
			buff.append("function(){\n"); // 开始
			buff.append("\t\t	var node = new Ext.tree.TreeNode({id:'"
					+ node.getId() + "',text:'" + node.getText() + "'});\n");
			// 设置属性
			if (node.getAttributes() != null && !node.getAttributes().isEmpty()) {
				buff.append("\t\t	node.attributes={");
				String tempstr = "";
				for (String key : node.getAttributes().keySet()) {
					tempstr += "," + key + ":'" + node.getAttributes().get(key)
							+ "'";
				}
				tempstr = tempstr.substring(1);
				buff.append(tempstr);
				buff.append("};\n");
			}
			// 设置事件
			if (node.getClick_listener() != null
					&& node.getClick_listener().trim().length() > 0) {
				buff.append("\t\t 	node.on('click'," + node.getClick_listener()
						+ ");\n");
			}
			if (node.getRight_click_listener() != null
					&& node.getRight_click_listener().trim().length() > 0) {
				buff.append("\t\t	node.on('rightclick',"
						+ node.getRight_click_listener() + ");\n");
			}
			// 设置子节点
			if (node.getChild_nodes() != null
					&& node.getChild_nodes().size() > 0) {
				buff.append("\t\t	node.appendChild([");
				make_ext_tree_node(node.getChild_nodes(), buff);
				buff.append("]);\n");
			}

			buff.append("\t\t	return node;");
			buff.append("}()");// 返回回调
		}
		return buff;
	}

	/**
	 * 解析单位
	 * 
	 * @param department_list
	 *            单位列表
	 * @param is_recursive
	 *            是否递归
	 * @return
	 */
	public List<TreeNode> parse_to_tree_node_from_department(
			List<Department> department_list, Department parent,
			boolean is_recursive, Integer departlevel) {
		if (department_list == null || department_list.isEmpty())
			throw new RuntimeException("需要生成树节点类型的机构列表为空");
		List<TreeNode> tree_node_list = new ArrayList();

		for (Department d : department_list) {
			TreeNode node = parse_to_tree_node_from_department(d, parent, true,
					departlevel);
			tree_node_list.add(node);
		}
		return tree_node_list;
	}

	public TreeNode parse_to_tree_node_from_department(Department department,
			Department parent, boolean is_recursive, Integer departlevel) {

		TreeNode node = new TreeNode();
		node.setId(department.getDepartid().toString());
		node.setText(department.getDepartname());

		node.setDisabled(false);
		Map<String, Object> attrs = new HashMap<String, Object>();
		attrs.put("departid", department.getDepartid());
		attrs.put("departname", department.getDepartname());
		attrs.put("departcode", department.getDepartcode());
		attrs.put("parentdepartid", department.getParentdepartid());
		attrs.put("departlevel", department.getDepartlevel());
		node.setAttributes(attrs);

		if (parent != null)
			node.setParent_node(parse_to_tree_node_from_department(parent,
					null, false, departlevel));

		if (is_recursive) {
			List<Department> child_departments = deparemnt_service
					.getChildDepart(department, departlevel);
			if (child_departments != null && !child_departments.isEmpty()) {
				node.setChild_nodes(parse_to_tree_node_from_department(
						child_departments, department, is_recursive,
						departlevel));
			}
		}

		return node;
	}

	/**
	 * 解析菜单
	 * 
	 * @param menu_list
	 *            菜单列表
	 * @param is_recursive
	 *            是否递归
	 * @param parent_menu
	 * @return
	 */
	public List<TreeNode> parse_to_tree_node_from_menu(List<Menu> menu_list,
			boolean is_recursive, Menu parent_menu, User user) {
		if (menu_list == null)
			throw new RuntimeException("菜单列表为空");
		List<TreeNode> tree_node_list = new ArrayList();
		String click_listener = "function(node,e){\n"
				+ "					if(node.attributes.funcentry && node.attributes.funcentry != '#'){\n"
				+ "						cp.load({url:node.attributes.funcentry,scripts:true});\n"
				+ "					}\n" +

				"				}\n";
		for (Menu m : menu_list) {

			TreeNode node = new TreeNode();
			node.setId(m.getSystem().getSystemcode() + "__" + m.getMenucode());
			node.setText(m.getMenuname());
			node.setDisabled(false);
			node.setClick_listener(click_listener);
			// 父节点
			if (parent_menu != null) {
				TreeNode parent_node = new TreeNode();
				parent_node.setId(m.getSystem().getSystemcode() + "__"
						+ parent_menu.getMenucode());
				parent_node.setText(parent_menu.getMenuname());
				parent_node.setClick_listener(click_listener);
				parent_node.setDisabled(false);

				node.setParent_node(parent_node);
			}

			// 设置属性
			Map<String, Object> attributes_map = new HashMap<String, Object>();
			attributes_map.put("menucode", m.getMenucode());
			attributes_map.put("menuname", m.getMenuname());
			attributes_map.put("funcentry", m.getFuncentry());
			attributes_map.put("system_name", m.getSystem().getSystemname());
			attributes_map.put("systemcode", m.getSystem().getSystemcode());

			node.setAttributes(attributes_map);
			// 子节点
			List<Menu> temp_children_menu = menu_service.getTheUserChildMenu(m,
					user);
			m.setChild_menu_list(temp_children_menu);
			if (is_recursive && m.getChild_menu_list() != null
					&& m.getChild_menu_list().size() > 0) {
				node.setChild_nodes(parse_to_tree_node_from_menu(
						m.getChild_menu_list(), is_recursive, m, user));
			}

			tree_node_list.add(node);
		}
		return tree_node_list;
	}

	@Resource(name = "menuServiceImpl")
	public void setMenu_service(IMenuService menu_service) {
		this.menu_service = menu_service;
	}

	@Resource(name = "departmentServiceImpl")
	public void setDeparemnt_service(IDepartmentService deparemnt_service) {
		this.deparemnt_service = deparemnt_service;
	}

}
