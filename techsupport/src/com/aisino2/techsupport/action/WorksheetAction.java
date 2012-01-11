package com.aisino2.techsupport.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.common.PageUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.domain.Worksheet;
import com.aisino2.techsupport.service.WorksheetService;

/**
 * 
 * 支持单 代办工作单 视图
 * 
 */
@SuppressWarnings("serial")
@Component("WorksheetAction")
@Scope("prototype")
public class WorksheetAction extends PageAction {
	private WorksheetService worksheetService;

	private String slCode;
	private String rgCode;
	private String activity;
	private String tabledata;
	private String result;
	private String taskId;

	private Worksheet worksheet;

	private List lWorksheet = new ArrayList();
	
	private int totalrows = 0;
	
	/**
	 * 待办工作单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querylist() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();

		Worksheet worksheet = new Worksheet();
		worksheet = (Worksheet) this.setClass(worksheet, null);

		if(worksheet.getActivityName()==null || worksheet.getActivityName().trim().length() == 0)
			worksheet.setActivityName(null);
		if(worksheet.getApplicantName()==null || worksheet.getApplicantName().trim().length() == 0)
			worksheet.setApplicantName(null);
		if(worksheet.getStStatusCode()==null || worksheet.getStStatusCode().trim().length() == 0)
			worksheet.setStStatusCode(null);
		if(worksheet.getRegionCode()==null || worksheet.getRegionCode().trim().length() == 0)
			worksheet.setRegionCode(null);
		
		User curuser = (User) session.getAttribute(Constants.userKey);
		
		Page taskPage = worksheetService.getWorksheetTaskForPage(pagesize,
				pagerow, null, worksheet.getActivityName(),
				String.valueOf(curuser.getUserid()),
				worksheet.getSupportLeaderId()==null?null:String.valueOf(worksheet.getSupportLeaderId()), worksheet.getRegionCode(),worksheet.getStNo());

		totalpage = taskPage.getTotalPages();
		totalrows = taskPage.getTotalRows();
		lWorksheet = taskPage.getData();
		setTabledata(lWorksheet);
		this.result = "success";
		return SUCCESS;
	}

	/**
	 * 重新指派
	 * 
	 * @return
	 * @throws Exception
	 */
	public String reAssigner() throws Exception {
		return SUCCESS;
	}

	/**
	 * 获取单一工作单
	 * 
	 * @return
	 * @throws Exception
	 */
	public String worksheet() throws Exception {
		worksheet = worksheetService.getWorksheetTask(taskId);
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("taskId");
		lPro.add("stNo");
		lPro.add("regionName");
		lPro.add("applicantName");
		lPro.add("supportLeaderName");
		lPro.add("supportDeptName");
		lPro.add("stStatusName");
		lPro.add("activityName");

		List lCol = new ArrayList();

		if (PageUtil.checkFunction("ts_process")) {
			List lModify = new ArrayList();
			lModify.add("setProcess");
			lModify.add("处理");
			lCol.add(lModify);
		}
		if (PageUtil.checkFunction("ts_sms")) {
			List lDel = new ArrayList();
			lDel.add("sendSMS");
			lDel.add("短信");
			lCol.add(lDel);
		}

		Worksheet worksheet = new Worksheet();
		this.setData(worksheet, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	@Resource(name="WorksheetServiceImpl")
	public void setWorksheetService(WorksheetService worksheetService) {
		this.worksheetService = worksheetService;
	}

	public String getSlCode() {
		return slCode;
	}

	public void setSlCode(String slCode) {
		this.slCode = slCode;
	}

	public String getRgCode() {
		return rgCode;
	}

	public void setRgCode(String rgCode) {
		this.rgCode = rgCode;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
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

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Worksheet getWorksheet() {
		return worksheet;
	}

	public void setWorksheet(Worksheet worksheet) {
		this.worksheet = worksheet;
	}

	public List getlWorksheet() {
		return lWorksheet;
	}

	public void setlWorksheet(List lWorksheet) {
		this.lWorksheet = lWorksheet;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

}
