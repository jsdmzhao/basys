package com.aisino2.techsupport.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.ICeApprovalService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

/**
 * 技术支持单 总工审核服务实现
 *
 */
@Component("CeApprovalServiceImpl")
public class CeApprovalServiceImpl extends BaseService implements
		ICeApprovalService {
	private SupportTicketService stService;
	private TrackingService trackingService;
	
//	流程服务
	private WorkflowUtil workflow;
	
	private static Logger log=Logger.getLogger(CeApprovalServiceImpl.class);
	
	public void insertCeApproval(String taskId, SupportTicket st,Tracking tracking) {
//		如果不通过，设置状态为公司审批未通过
		if(tracking.getApprovalCode().equals(Constants.ST_APPR_TYPE_APPR_NOPASS))
			st.setStStatus(Constants.ST_STATUS_COMPANY_APPRAVAL_NOPASS);
		else
			st.setStStatus(Constants.ST_STATUS_WAIT_DEPARTMENT_APPRAVAL);
//		保存支持单信息
		stService.updateSupportTicket(st);
//		保存审核意见信息
		trackingService.insertTracking(tracking);
		//设置最后更新时间
		st.setLastUpdateDate(new Date());
//		流程控制
//		当提交的技术支持单，在本环节重新对单位做出了指派的时候，那么主要更新指派信息
		Map<String, Object> candidate_users=new HashMap<String, Object>();
		List<Department> deptlist= st.getSupportDeptList();
		candidate_users.putAll(workflow.setDeptAssigneeVariable(deptlist));
		Map<String, Object> parammap=new HashMap<String, Object>();
		parammap.put("ceApprovalCode", tracking.getApprovalCode());
		//debug
		
//		流程提交
		workflow.workflowNext(workflow.setVariable(taskId,null,candidate_users ,parammap));
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
