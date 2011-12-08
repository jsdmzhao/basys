package com.aisino2.sysadmin.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TreeMappingAction extends PageAction {
	private String treeFalg;

	
	/**
	 * 机构树
	 * @return
	 * @throws Exception
	 */
	public String deptTreeForm() throws Exception {
//		treeFalg = this.request.getParameter("treeFalg");
		if(treeFalg == null || treeFalg.equals(""))
			throw new RuntimeException("treeFalg 输入有误");
		return treeFalg;
	}
	/** 系统树 */
	public String systemTreeForm() throws Exception{
		return SUCCESS;
	}
	
	public String getTreeFalg() {
		return treeFalg;
	}
	public void setTreeFalg(String treeFalg) {
		this.treeFalg = treeFalg;
	}
	
}
