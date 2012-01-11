package com.aisino2.techsupport.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Track;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.domain.Worksheet;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.service.WorksheetService;

/**
 * 追踪批复视图 
 *
 */
@SuppressWarnings("serial")
@Component("TrackingAction")
@Scope("prototype")
public class TrackingAction extends PageAction implements ServletRequestAware {

	private HttpServletRequest request;
	
	private TrackingService trackService;
	private WorksheetService worksheetService;
	private SupportTicket st;
	private SupportTicket trSt;
	private Tracking track;
	private List<Tracking> trackList;
	private String tabledata;
	private String taskId;
	private List lTracking = new ArrayList();
	
	private String returnMsg;
	private int returnNo;
	
	private String result="success";
	
	private int totalrows = 0;
	
	public String init() throws Exception{
		try {
			Worksheet worksheet = worksheetService.getWorksheetTask(taskId);
			st = worksheet.getSt();
			
		} catch (RuntimeException e) {
			returnNo=1;
			result="failed";
			log.error(e);
			throw e;
		}
	
		
		return	SUCCESS;
	}
	
	public String querylistNoPage() throws Exception{
		try{
			Worksheet worksheet = new Worksheet();
			worksheet = (Worksheet) this.setClass(worksheet, null);
			worksheet = worksheetService.getWorksheetTask(worksheet.getTaskId());
			if(track==null)
				track = new Tracking();
			track.setStId(worksheet.getSt().getId());
			
			lTracking=trackService.getTrackingList(track);
		} catch (RuntimeException e) {
			returnNo=1;
			result="failed";
			log.error(e);
			throw e;
		}
		
		return SUCCESS;
	}
	public String querylistOnlyTracking() throws Exception{
		if(track==null){
			Tracking setTracking=new Tracking();
			track=(Tracking)this.setClass(setTracking, null);
		}
			
		Page trackPage = trackService.getTrackingListForPage(pagesize, pagerow, track, "0", null);
		
		totalpage = trackPage.getTotalPages();
		totalrows = trackPage.getTotalRows();
		lTracking = trackPage.getData();
		
		this.setTabledata(lTracking);
		return SUCCESS;
	}
	public String querylist() throws Exception{
		try {
			Worksheet worksheet = new Worksheet();
			worksheet = (Worksheet) this.setClass(worksheet, null);
			worksheet = worksheetService.getWorksheetTask(worksheet.getTaskId());
			if(track==null)
				track = new Tracking();
			track.setStId(worksheet.getSt().getId());
			Page trackPage = trackService.getTrackingListForPage(pagesize, pagerow, track, "0", null);

			
			totalpage = trackPage.getTotalPages();
			totalrows = trackPage.getTotalRows();
			lTracking = trackPage.getData();
			
			this.setTabledata(lTracking);
		} catch (RuntimeException e) {
			returnNo=1;
			result="failed";
			log.error(e);
			throw e;
		}
		return SUCCESS;
	}
	public String save() throws Exception{
		
		if(track==null)
			throw new RuntimeException("追踪信息为空，数据传输错误");
		User culUser = (User)request.getSession().getAttribute(Constants.userKey);
		track.setProcessor(culUser);//设置填写人员
		
		try {
			trackService.insertTracking(track);
			returnNo=0;
			returnMsg="追踪批复 保存成功";
		} catch (RuntimeException e) {
			returnNo=1;
			returnMsg="追踪批复 保存出错";
			log.error(returnMsg);
			log.error(e,e.fillInStackTrace());
		}
		return SUCCESS;
	}
	
	public String applyFeedback() throws Exception{
		if(track==null)
			throw new RuntimeException("追踪信息为空，数据传输错误");
		if(trSt==null)
			throw new RuntimeException("支持单信息为空");
		
		User culUser = (User)request.getSession().getAttribute(Constants.userKey);
		track.setProcessor(culUser);//设置填写人员
		
		try {
			trackService.insertTrackingAndGo(track, taskId, trSt);
			returnNo=0;
			returnMsg="追踪批复 提请反馈成功";
		} catch (RuntimeException e) {
			returnNo=1;
			returnMsg="追踪批复 提请反馈出错";
			log.error(returnMsg);
			log.error(e,e.fillInStackTrace());
		}
		return SUCCESS;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("id");
		lPro.add("trackingDate");
		lPro.add("newProcess");
		lPro.add("processorName");

		track = new Tracking();
		this.setData(track, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public SupportTicket getSt() {
		return st;
	}

	public void setSt(SupportTicket st) {
		this.st = st;
	}

	public Tracking getTrack() {
		return track;
	}

	public void setTrack(Tracking track) {
		this.track = track;
	}

	public List<Tracking> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Tracking> trackList) {
		this.trackList = trackList;
	}

	@Resource(name="TrackingServiceImpl")
	public void setTrackService(TrackingService trackService) {
		this.trackService = trackService;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public int getReturnNo() {
		return returnNo;
	}

	public void setReturnNo(int returnNo) {
		this.returnNo = returnNo;
	}
	
	@Resource(name="WorksheetServiceImpl")
	public void setWorksheetService(WorksheetService worksheetService) {
		this.worksheetService = worksheetService;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTabledata() {
		return tabledata;
	}
	public void setTabledata(String tabledata) {
		this.tabledata = tabledata;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public SupportTicket getTrSt() {
		return trSt;
	}
	public void setTrSt(SupportTicket trSt) {
		this.trSt = trSt;
	}
	public List getlTracking() {
		return lTracking;
	}
	public void setlTracking(List lTracking) {
		this.lTracking = lTracking;
	}

	public int getTotalrows() {
		// TODO Auto-generated method stub
		return this.totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

}
