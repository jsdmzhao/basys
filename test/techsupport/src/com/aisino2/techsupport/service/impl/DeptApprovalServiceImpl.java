package com.aisino2.techsupport.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.task.Participation;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.mvel2.ast.WithNode.ParmValuePair;
import org.springframework.stereotype.Component;

import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.IDeptApprovalService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

/**
 * 部门审核环节服务，主要包括产品方案部和技术开发部
 *
 */
@Component("DeptApprovalServiceImpl")
public class DeptApprovalServiceImpl extends BaseService implements
		IDeptApprovalService {
	private SupportTicketService stService;
	private TrackingService trackingService;
	
	/**
	 * 流程控制服务
	 */
	private WorkflowUtil workflow;
	
	public void insertDeptApproval(String taskId, SupportTicket st,Tracking tracking) {
//		保存技术支持单信息
		stService.updateSupportTicket(st);
//		保存部门审核意见信息
		trackingService.insertTracking(tracking);
		
		if(tracking.getProcessor().getDepartid()==null)
			throw new RuntimeException("当前用户单位信息为空");
//		流程控制
//		当当前单位审批后，不允许再次看到本环节信息，故此，在这里对 指派候选人里面的当前用户单位ID做移除。
//		当全部指派单位审批后，提交流程到下一个环节
		String oldDeptApprovalUsersStr= (String) workflow.getTaskService().getVariable(taskId, "deptApprovalUsers");
		String[] oldDeptApprovalUsers= oldDeptApprovalUsersStr.split(",");
//		移除已经批复过的单位经理
		String newDeptApprrovalUsers="";
		for(String deptUserId : oldDeptApprovalUsers){
			if (!tracking.getProcessor().getUserid().toString().equals(deptUserId)){
				newDeptApprrovalUsers+=deptUserId+",";
			}
		}
		
		newDeptApprrovalUsers=newDeptApprrovalUsers.length()>0 ? newDeptApprrovalUsers.substring(0,newDeptApprrovalUsers.length()-1) : newDeptApprrovalUsers ;	
		Map<String, Object> candidateUsers=new HashMap<String, Object>();
		candidateUsers.put("deptApprovalUsers", newDeptApprrovalUsers);
		workflow.getTaskService().removeTaskParticipatingUser(taskId, tracking.getProcessor().getUserid().toString(), Participation.CANDIDATE);
		//指派追踪批复用户
//		@fixed 技术负责人变成多个指派
		String supportLeaderIds = "";
		for (User sl : st.getLstSupportLeaders())
			supportLeaderIds = "," + sl.getUserid();
		supportLeaderIds = supportLeaderIds.length() > 0 ? supportLeaderIds
				.substring(1) : supportLeaderIds;
		candidateUsers.put("trackingUsers", supportLeaderIds);
		
//		设置总的审批结果，及只要有一个部门审批未通过，那么就未通过，上报给总工，再定夺。
		Map<String, Object> paramsMap=new HashMap<String, Object>();
		paramsMap.put("deptApprovalCode", tracking.getApprovalCode());
		String deptApprovalCode=(String) workflow.getTaskService().getVariable(taskId, "params.deptApprovalCode");
		if(deptApprovalCode!= null && deptApprovalCode.equals(Constants.ST_APPR_TYPE_APPR_NOPASS))
			paramsMap.clear();
//		流程提交以后不能查看，另外确保所有 经理 都审核了
		if(candidateUsers.get("deptApprovalUsers").toString().equals(""))
			workflow.workflowNext(workflow.setVariable(taskId, null, candidateUsers, paramsMap));
		else{
			workflow.getTaskService().setVariables(taskId, workflow.setVariable(taskId, null, candidateUsers, paramsMap));
		}
	}

	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name="TrackingServiceImpl")
	public void setTrackingService(TrackingService trackingService) {
		this.trackingService = trackingService;
	}

	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	
}
