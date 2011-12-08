package com.aisino2.sysadmin.tree;

import java.util.List;
import java.util.Map;

public class TreeNode {
	//id
	private String id;
	//显示文本
	private String text;
	//点击事件的字符串
	private String click_listener;
	//父节点
	private TreeNode parent_node;
	//子节点
	private List<TreeNode> child_nodes;
	//右键事件的字符串
	private String right_click_listener;
	//是不是已关闭
	private boolean disabled;
	//自定义属性
	private Map<String, Object> attributes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getClick_listener() {
		return click_listener;
	}
	public void setClick_listener(String click_listener) {
		this.click_listener = click_listener;
	}
	public TreeNode getParent_node() {
		return parent_node;
	}
	public void setParent_node(TreeNode parent_node) {
		this.parent_node = parent_node;
	}
	public List<TreeNode> getChild_nodes() {
		return child_nodes;
	}
	public void setChild_nodes(List<TreeNode> child_nodes) {
		this.child_nodes = child_nodes;
	}
	public String getRight_click_listener() {
		return right_click_listener;
	}
	public void setRight_click_listener(String right_click_listener) {
		this.right_click_listener = right_click_listener;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	
}
