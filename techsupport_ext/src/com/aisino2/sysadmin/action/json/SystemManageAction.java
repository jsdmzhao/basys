package com.aisino2.sysadmin.action.json;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.action.PageAction;
import com.aisino2.sysadmin.domain.Department;
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
	private static Logger log  = Logger.getLogger(SystemManageAction.class);
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
		try{
			if(system== null)
				throw new RuntimeException("系统实体为空");
			system = systemService.getSystem(system);
			returnNo=0;
		}catch (Exception e) {
			returnNo=1;
			returnMessage="系统查询详情失败";
			log.error(e);
			if(log.isDebugEnabled()){
				log.debug(e,e.fillInStackTrace());
				returnMessageDebug=e.getMessage();
			}
		}
		return SUCCESS;
	}
	/**
	 * 列表查询
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String querylist() throws Exception{
		try{
			if(system== null)
				throw new RuntimeException("系统实体为空");
			List systemQueryList = systemService.getListForPage(system,start,limit,dir,sort);
			this.total = (Integer) systemQueryList.get(0);
			systemList = (List<System>)systemQueryList.get(1);
			returnNo=0;
		}catch (Exception e) {
			returnNo=1;
			returnMessage="系统查询列表失败";
			log.error(e);
			if(log.isDebugEnabled()){
				log.debug(e,e.fillInStackTrace());
				returnMessageDebug=e.getMessage();
			}
		}
		return SUCCESS;
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		try{
			if(system== null)
				throw new RuntimeException("系统实体为空");
			systemService.insertSystem(system);
			returnNo=0;
			returnMessage="系统添加成功";
		}catch (Exception e) {
			returnNo=1;
			returnMessage="系统添加失败";
			log.error(e);
			if(log.isDebugEnabled()){
				log.debug(e,e.fillInStackTrace());
				returnMessageDebug=e.getMessage();
			}
		}
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String remove() throws Exception{
		try{
			if(systemList==null || systemList.isEmpty())
				throw new RuntimeException("未选择需要删除的机构");
			this.returnMessageDebug="";
			List<System> removedList = new ArrayList<System>();
			for(System d : systemList){
				try{
					this.systemService.deleteSystem(d);
					removedList.add(d);
				}
				catch (Exception e) {
					log.error(e);
					this.returnMessageDebug+=e.getMessage()+"\n"; 
				}
			}
			
			if(systemList.size() != removedList.size() )
				throw new RuntimeException("未全部删除，部分无法删除");
			this.returnNo=0;
			this.returnMessage="已删除选择的记录";
		}catch (Exception e) {
			this.returnNo=1;
			this.returnMessage="删除发生了错误";
			log.error(e);
			if(log.isDebugEnabled()){
				log.debug(e,e.fillInStackTrace());
				this.returnMessageDebug=e.getMessage()+"\n";
			}
		}
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception{
		try{
			if(system== null)
				throw new RuntimeException("系统实体为空");
			systemService.updateSystem(system);
			returnNo=0;
			returnMessage="系统修改成功";
		}catch (Exception e) {
			returnNo=1;
			returnMessage="系统修改失败";
			log.error(e);
			if(log.isDebugEnabled()){
				log.debug(e,e.fillInStackTrace());
				returnMessageDebug=e.getMessage();
			}
		}
		
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
