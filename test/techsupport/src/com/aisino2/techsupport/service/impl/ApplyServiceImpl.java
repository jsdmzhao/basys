package com.aisino2.techsupport.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IRoleService;
import com.aisino2.sysadmin.service.IUser_roleService;
import com.aisino2.techsupport.common.CommonUtil;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.ApplyService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.workflow.WorkflowUtil;
@Component("ApplyServiceImpl")
public class ApplyServiceImpl extends BaseService implements ApplyService {
	private SupportTicketService stService;
	private IDict_itemService dictitemService;
	private IUser_roleService userRoleService;
	private IRoleService roleService;
	private CommonUtil util;
	
	/**
	 * 流程控制服务
	 */
	private WorkflowUtil workflow;
	
	public void insertApplyAndGo(SupportTicket st) {
		SupportTicket supportTicket = null;
		//设置支持单流程状态 为 待公司审批
//		st.setStStatus(Constants.ST_STATUS_GOING);
		st.setStStatus(Constants.ST_STATUS_WAIT_COMPANY_APPRAVAL);
		//更新最后操作时间
		st.setLastUpdateDate(new Date());
		try{
			
			supportTicket=this.stService.insertSupportTicket(st);
			
			// 指派下一个环节操作用户 --
			// 开始流程 
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("worksheetno", supportTicket.getId());
			
			Map<String, Object> candidateUsers = new HashMap<String, Object>();
//			//指派追踪批复用户
//			if(supportTicket.getSupportLeader()!=null)
//				candidateUsers.put("trackingUsers", "");
//			公司审核
			Role cerole=new Role();
			cerole.setRolename(Constants.ST_ROLE_NAME_CE);
			try{
				cerole=(Role) roleService.getListRole(cerole).get(0);
			}catch (IndexOutOfBoundsException e) {
				
				RuntimeException a= new RuntimeException("角色["+Constants.ST_ROLE_NAME_CE+"] 未创建..");
				log.error(a,a.fillInStackTrace());
				throw a;
			}
			User_role ceUser_role=new User_role();
			ceUser_role.setRoleid(cerole.getRoleid());
			List<User_role> ceUserRoleList = userRoleService.getListUser_role(ceUser_role);
			String ceApprovalUsersID="";
			if(ceUserRoleList!=null && ceUserRoleList.size() > 0){
				StringBuffer ceApprovalUsersIDBuffer = new StringBuffer();
				for(User_role userRole1 : ceUserRoleList){
					ceApprovalUsersIDBuffer.append(userRole1.getUserid());
					ceApprovalUsersIDBuffer.append(",");
				}
				ceApprovalUsersID=ceApprovalUsersIDBuffer.substring(0, ceApprovalUsersIDBuffer.length()-1);
			}
			candidateUsers.put("ceApprovalUsers", ceApprovalUsersID);
			
//			指派负责单位
			if(supportTicket.getSupportDeptList()!=null && supportTicket.getSupportDeptList().size()>0)
				candidateUsers.putAll(workflow.setDeptAssigneeVariable(supportTicket.getSupportDeptList()));
//			指派反馈确认用户
			//具有反馈人角色的，并且关联了区总角色的
//			字典映射的各区总角色
			Dict_item dictitem = new Dict_item();
			dictitem.setDict_code(Constants.ST_RGM_RG_MAP_DICT_CODE);
			dictitem.setFact_value(st.getRegion());
			dictitem = dictitemService.getDictionaryItemByDictCodeAndFactValue(dictitem);
			
			if(dictitem==null)
				throw new RuntimeException("该区域没有指定区总");
			String feedbackUsersStr=""	;
			Role rgmRole=new Role();
			Role feedback_role = new Role();
			rgmRole.setRolename(dictitem.getDisplay_name());
			List<Role> rgmRoleList=roleService.getListRole(rgmRole);
			feedback_role.setRolename(Constants.ST_ROLE_NAME_FEEDBACKER);
			try{
				feedback_role = (Role) roleService.getListRole(feedback_role).get(0);
			}catch (Exception e) {
				throw new RuntimeException("角色["+Constants.ST_ROLE_NAME_FEEDBACKER+"]不存在");
			}
			
			if(rgmRoleList!=null && rgmRoleList.size()>0){
				rgmRole=rgmRoleList.get(0);
				
				User_role userrole=new User_role();
				userrole.setRoleid(rgmRole.getRoleid());
				List<User_role> lstUserRole = userRoleService.getListUser_role(userrole);
				for(User_role userRole : lstUserRole){
					//验证改用户是否具有反馈人角色，只有具有反馈人角色的用户才可以执行反馈。
					userrole=new User_role();
					userrole.setRoleid(feedback_role.getRoleid());
					userrole.setUserid(userRole.getUserid());
					userrole = userRoleService.getUser_role(userrole);
					if(userrole != null)
						feedbackUsersStr+=","+userRole.getUserid();
				}
					
			}
			if(feedbackUsersStr.length()==0)
				throw new RuntimeException("所关联的地区区总，不具有反馈人角色");
			feedbackUsersStr=feedbackUsersStr.substring(1);
			candidateUsers.put("feedbackUsers", feedbackUsersStr);
//			指派归档用户
//			指派 技术质量管理员
			Role role=new Role();
			role.setRolename(Constants.ST_ROLE_NAME_QC);
			try{
				role=(Role) roleService.getListRole(role).get(0);
			}catch (IndexOutOfBoundsException e) {
				throw new RuntimeException("角色["+Constants.ST_ROLE_NAME_QC+"] 未创建..");
			}
			
			User_role userRole = new User_role();
			userRole.setRoleid(role.getRoleid());//技术质量员角色
			List<User_role> userRoleList = userRoleService.getListUser_role(userRole);
			String archiverUserID="";
			if(userRoleList!=null && userRoleList.size() > 0){
				StringBuffer archiverUserIDBuffer = new StringBuffer();
				for(User_role userRole1 : userRoleList){
					archiverUserIDBuffer.append(userRole1.getUserid());
					archiverUserIDBuffer.append(",");
				}
				archiverUserID=archiverUserIDBuffer.substring(0, archiverUserIDBuffer.length()-1);
			}
			
			candidateUsers.put("archiveUsers", archiverUserID);
			
//			添加总工审核相关的变量
			params.put("ceApprovalCode", "");
//			审核标志通过
			params.put("approvalCodePassed", Constants.ST_APPR_TYPE_APPR_PASSED);
			//流程启动
			workflow.workflowStart(workflow.setVariable(null, null,
					candidateUsers, params));
		}catch (RuntimeException e) {
			log.error(e);
			throw e;
		} 

	}
	
	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name="dict_itemService")
	public void setDictitemService(IDict_itemService dictitemService) {
		this.dictitemService = dictitemService;
	}
	
	@Resource(name="user_roleService")
	public void setUserRoleService(IUser_roleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	@Resource(name="CommonUtil")
	public void setUtil(CommonUtil util) {
		this.util = util;
	}
	@Resource(name="roleService")
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	/* (non-Javadoc)
	 * @see com.aisino2.techsupport.service.ApplyService#checkStNoIsExist(java.lang.String)
	 */
	public boolean checkStNoIsExist(String stNo) {
		SupportTicket st=new SupportTicket();
		st.setStNo(stNo);
		List<SupportTicket> lst=stService.getListSupportTicket(st);
		if(lst.size()>0)
			return true;
		else
			return false;
	}


}
