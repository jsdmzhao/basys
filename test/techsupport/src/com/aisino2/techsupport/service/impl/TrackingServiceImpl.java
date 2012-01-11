package com.aisino2.techsupport.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.dao.TrackingDao;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

/**
 * 
 * 追踪批复服务
 */
@Component("TrackingServiceImpl")
public class TrackingServiceImpl extends BaseService implements TrackingService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TrackingServiceImpl.class);

	private TrackingDao trackDao;

	private SupportTicketService stService;
	
	private IUserService userService;
	
	/**
	 * 流程控制服务
	 */
	private WorkflowUtil workflow;
	
	public Tracking insertTracking(Tracking tracking) {
		Tracking track = null;
		if (logger.isDebugEnabled()) {
			logger.debug("insertTracking(Tracking) - start"); //$NON-NLS-1$
		}

		try {
			if(tracking.getType()==null || tracking.getType().trim().length() == 0)
				tracking.setType(Constants.TRACKING_TYPE_TRACKING);
			track = trackDao.insertTracking(tracking);
			
		} catch (RuntimeException e) {
			logger.error(e,e.fillInStackTrace());
			throw e;
		}
		

		if (logger.isDebugEnabled()) {
			logger.debug("insertTracking(Tracking) - end"); //$NON-NLS-1$
		}
		return track;
	}

	public int updateTracking(Tracking tracking) {
		int ret = 0;
		if (logger.isDebugEnabled()) {
			logger.debug("updateTracking(Tracking) - start"); //$NON-NLS-1$
		}
		
		try {
			ret = trackDao.updateTracking(tracking);
		} catch (RuntimeException e) {
			logger.error(e,e.fillInStackTrace());
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("updateTracking(Tracking) - end"); //$NON-NLS-1$
		}
		return ret;
	}

	public int deleteTracking(Tracking tracking) {
		int ret = 0;
		if (logger.isDebugEnabled()) {
			logger.debug("deleteTracking(Tracking) - start"); //$NON-NLS-1$
		}

		try {
			ret = trackDao.deleteTracking(tracking);
		} catch (RuntimeException e) {
			logger.error(e,e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("deleteTracking(Tracking) - end"); //$NON-NLS-1$
		}
		return ret;
	}

	public List<Tracking> getTrackingList(Tracking tracking) {
		return this.trackDao.getTrackingList(tracking);
	}

	public Page getTrackingListForPage(int pageno, int pagesize,
			Tracking tracking, String sort, String desc) {
		Page trackPage = null;

		if (logger.isDebugEnabled()) {
			logger.debug("getTrackingListForPage(int, int, Tracking, String, String) - start"); //$NON-NLS-1$
		}
		
		try {
			trackPage = trackDao.getTrackingListForPage(pageno, pagesize, tracking, sort, desc);
			if(trackPage.getData()!=null && trackPage.getData().size()>0)
				for(Tracking track : (List<Tracking>)trackPage.getData()){
					if(track.getProcessor()!=null){
						track.setProcessor(userService.getUser(track.getProcessor()));
						track.setProcessorId(track.getProcessor().getUserid());
						track.setProcessorName(track.getProcessor().getUsername());
					}
				}
		} catch (RuntimeException e) {
			logger.error(e,e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTrackingListForPage(int, int, Tracking, String, String) - end"); //$NON-NLS-1$
		}
		return trackPage;
	}

	public Tracking getTracking(Tracking tracking) {
		Tracking track = null;
		if (logger.isDebugEnabled()) {
			logger.debug("getTracking(Tracking) - start"); //$NON-NLS-1$
		}
		
		try {
			track = trackDao.getTracking(tracking);
		} catch (RuntimeException e) {
			logger.error(e,e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTracking(Tracking) - end"); //$NON-NLS-1$
		}
		return track;
	}

	@Resource(name="TrackingDaoImpl")
	public void setTrackDao(TrackingDao trackDao) {
		this.trackDao = trackDao;
	}

	public Tracking insertTrackingAndGo(Tracking tracking,String taskId,SupportTicket st) {
		Tracking track = null;
		if (logger.isDebugEnabled()) {
			logger.debug("insertTrackingAndGo(Tracking) - start"); //$NON-NLS-1$
		}

		try {
			if(taskId==null)
				throw new RuntimeException("taskID 为空;");
			if(tracking.getType()==null || tracking.getType().trim().length() == 0)
				tracking.setType(Constants.TRACKING_TYPE_TRACKING);
			track = trackDao.insertTracking(tracking);
			//设置提请反馈时间
			st.setApplyingFeedbackDate(new Date());
			//设置状态
			st.setStStatus(Constants.ST_STATUS_WAIT_FEEDBACK);
			
			stService.updateSupportTicket(st);
			//流程开始
			workflow.workflowNext(workflow.setVariable(taskId, null));
		} catch (RuntimeException e) {
			logger.error(e,e.fillInStackTrace());
			throw e ;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insertTrackingAndGo(Tracking) - end"); //$NON-NLS-1$
		}
		return track;
	}

	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

}
