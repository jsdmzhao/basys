package com.aisino2.techsupport.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.FeedbackService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.workflow.WorkflowUtil;
/**
 *  反馈确认服务
 *
 */
@Component("FeedbackServiceImpl")
public class FeedbackServiceImpl extends BaseService implements FeedbackService {

	private SupportTicketService stService;
	
	private TrackingService trackService;
	
	/**
	 * 流程控制服务
	 */
	private WorkflowUtil workflow;
	
	public void insertFeedbackAndGoback(String taskId, SupportTicket st,
			Tracking tracking) {
		try {
			if(taskId==null || taskId.equals(""))
				throw new RuntimeException("taskId 为空");
			if(st==null || st.getId()==null)
				throw new RuntimeException("支持单st ID为空");
			if(tracking==null)
				throw new RuntimeException("进展信息 tracking 为空");
			//保存支持单信息
			//设置状态为进行中
			st.setStStatus(Constants.ST_STATUS_GOING);
			//更新最后操作时间
			st.setLastUpdateDate(new Date());
			stService.updateSupportTicket(st);
			
			//保存进展信息
			tracking.setStId(st.getId());
			trackService.insertTracking(tracking);
			
			//流程回退(流程支线 不与反馈)
			Map candidateUsers = new HashMap();
			String supportLeaderIds = "";
			SupportTicket comm_st = stService.getSupportTicket(st);
			for (User sl : comm_st.getLstSupportLeaders())
				supportLeaderIds += "," + sl.getUserid();
			supportLeaderIds = supportLeaderIds.length() > 0 ? supportLeaderIds
					.substring(1) : supportLeaderIds;
			candidateUsers.put("trackingUsers", supportLeaderIds);
			workflow.workflowNext(workflow.setVariable(taskId, "no_feedback", candidateUsers));
		} catch (RuntimeException e) {
			log.error(e);
			throw e;
		}
		
	}

	public void insertFeedbackAndGo(String taskId, SupportTicket st,
			Tracking tracking) {
		try {
			if(taskId==null || taskId.equals(""))
				throw new RuntimeException("taskId 为空");
			if(st==null || st.getId()==null)
				throw new RuntimeException("支持单st ID为空");
			if(tracking==null)
				throw new RuntimeException("进展信息 tracking 为空");
			//保存支持单信息
			//设置状态为已反馈
			st.setStStatus(Constants.ST_STATUS_FEEDBACKED);
			//更新最后操作时间
			st.setLastUpdateDate(new Date());
			//设置反馈时间
			st.setFeedbackConfirmDate(new Date());
			
			stService.updateSupportTicket(st);
			
			//保存进展信息
			tracking.setStId(st.getId());
			trackService.insertTracking(tracking);
			
			//流程前进(流程支线 归档)
			workflow.workflowNext(workflow.setVariable(taskId, null));
		} catch (RuntimeException e) {
			log.error(e);
			throw e;
		}
	}
	
	@Resource(name="TrackingServiceImpl")
	public void setTrackService(TrackingService trackService) {
		this.trackService = trackService;
	}
	
	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}
	

}
