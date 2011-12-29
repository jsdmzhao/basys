package com.aisino2.sysadmin.action.json;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.action.PageAction;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.service.ISystemService;
import com.aisino2.sysadmin.tree.TreeNodeTool;

@Component
@Scope("prototype")
public class SystemManageAction extends PageAction {
	private System system;
	private List<System> systemList;
	private ISystemService systemService;
	private TreeNodeTool treeNodeTool;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6479289252324243277L;
	
	/**
	 * 详情查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception{
		return SUCCESS;
	}
	/**
	 * 列表查询
	 * @return
	 * @throws Exception
	 */
	public String querylist() throws Exception{
		return SUCCESS;
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String remove() throws Exception{
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception{
		return SUCCESS;
	}
	/**
	 * 上移
	 * @return
	 * @throws Exception
	 */
//	public String up() throws Exception{
//		return SUCCESS;
//	}
//	
//	public String down() throws Exception{
//		return SUCCESS;
//	}
	/**
	 * 置顶
	 */
	public String top() throws Exception{
		return SUCCESS;
	}
	/**
	 * 置底
	 * @return
	 * @throws Exception
	 */
	public String bottom() throws Exception{
		return SUCCESS;
	}
	
	/**
	 * 查询系统信息的树形节点 
	 */
	public String querySystemNodes() throws Exception {
		if (system == null)
			system = new System();
		if(system.getSystemcode()!=null && system.getSystemcode().equals("0"))
			system.setSystemcode(null);
		List<System> childSystemList = this.systemService.getChildSystem(system);
		try{
			system = this.systemService.getSystem(system);
		}catch (Exception e) {
			system = null;
		}
		StringBuffer buff = new StringBuffer();
		String systemTreenodeList = "["+treeNodeTool.make_ext_tree_node(treeNodeTool
				.parseToTreenodeFromSystem(childSystemList,
						system, false),buff).toString()+"]";
		this.response.setContentType("text/html; charset=utf-8");
		PrintWriter out = this.response.getWriter();
		out.print(systemTreenodeList);
		out.close();
		return null;
	}
	
	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public List<System> getSystemList() {
		return systemList;
	}

	public void setSystemList(List<System> systemList) {
		this.systemList = systemList;
	}
	@Resource(name="systemServiceImpl")
	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}
	@Resource(name="treeNodeTool")
	public void setTreeNodeTool(TreeNodeTool treeNodeTool) {
		this.treeNodeTool = treeNodeTool;
	}
	
}
