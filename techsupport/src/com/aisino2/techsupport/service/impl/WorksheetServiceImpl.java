package com.aisino2.techsupport.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.dao.WorksheetDao;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Worksheet;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.WorksheetService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

@Component("WorksheetServiceImpl")
public class WorksheetServiceImpl extends BaseService implements
		WorksheetService {
	private IDict_itemService dicItemService;
	private SupportTicketService stService;
	private WorksheetDao worksheet_dao;


	/**
	 * 流程服务
	 */
	private WorkflowUtil workflow;

	@Resource(name="WorksheetDaoImpl")
	public void setWorksheet_dao(WorksheetDao worksheet_dao) {
		this.worksheet_dao = worksheet_dao;
	}
	public List<Worksheet> getWorksheetTaskList(String assignee,
			String activity, String candidateUser, String slNo, String region) {
		TaskService taskService = workflow.getTaskService();

		List<Task> tasklist = taskService.createTaskQuery().assignee(assignee)
				.candidate(candidateUser).activityName(activity).list();
		List<Worksheet> worksheetList = new ArrayList<Worksheet>();

		if (tasklist != null && tasklist.size() > 0) {
			for (Task task : tasklist) {
				boolean result = true;
				Integer stId = (Integer) taskService.getVariable(task.getId(),
						"worksheetno");

				SupportTicket st = new SupportTicket();
				st.setId(stId);
				st = stService.getSupportTicket(st);

				try {
					if (slNo != null && result)
						for (User sl : st.getLstSupportLeaders()) {
							result = result
									&& slNo.equals(sl.getUserid().toString());
						}
					if (region != null && result)
						result = result && region.equals(st.getRegion());

					if (result) {
						Worksheet sheet = new Worksheet();

						sheet.setTask(task);
						sheet.setSt(st);

						sheet.setTaskId(sheet.getTask().getId());
						Dict_item tempDictI = new Dict_item();
						tempDictI.setDict_code(Constants.ST_WORKFLOW_NAME_DICT_CODE);
						tempDictI.setFact_value(sheet.getTask().getActivityName());
						sheet.setActivityName(tempDictI.getDisplay_name());

						sheet.setApplicantName(sheet.getSt().getApplicant() != null ? sheet
								.getSt().getApplicant().getUsername()
								: "");
						// 技术负责人
						String sSupportLeaderName = "";
						for (User sl : sheet.getSt().getLstSupportLeaders())
							sSupportLeaderName += "," + sl.getUsername();
						sSupportLeaderName = sSupportLeaderName.length() > 0 ? sSupportLeaderName
								.substring(1) : sSupportLeaderName;
						sheet.setSupportLeaderName(sSupportLeaderName);
						// 设置单位名称
						String supportDeptName = "";
						for (Department dept : sheet.getSt()
								.getSupportDeptList()) {
							supportDeptName += dept.getDepartname() + ",";
						}
						supportDeptName = supportDeptName.length() > 0 ? supportDeptName
								.substring(0, supportDeptName.length() - 1)
								: supportDeptName;

						sheet.setSupportDeptName(supportDeptName);
						sheet.setStNo(sheet.getSt().getStNo());

						tempDictI.setDict_code(Constants.ST_REGION_DICT_CODE);
						tempDictI.setFact_value(sheet.getSt().getRegion());
						sheet.setRegionName(dicItemService
								.getDictionaryItemByDictCodeAndFactValue(
										tempDictI).getDisplay_name());

						tempDictI.setDict_code(Constants.ST_STATUS_DICT_CODE);
						tempDictI.setFact_value(sheet.getSt().getStStatus());
						sheet.setStStatusName(dicItemService
								.getDictionaryItemByDictCodeAndFactValue(
										tempDictI).getDisplay_name());

						worksheetList.add(sheet);
					}
				} catch (Exception e) {
					log.error(e);
					log.debug(e.fillInStackTrace());
				}

			}

			tasklist.clear();
		}

		return worksheetList;
	}

	/*
	 * (non-Javadoc) 获取技术支持单待办工作列表 分页方式
	 * 
	 * @see
	 * com.aisino2.techsupport.service.WorksheetService#getWorksheetTaskForPage
	 * (int, int, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	public Page getWorksheetTaskForPage(int pageNo, int pagesize,
			String assignee, String activity, String candidateUser,
			String slNo, String region,String stNO) {
		TaskService taskService = workflow.getTaskService();

		List<Task> tasklist = taskService.createTaskQuery().assignee(assignee)
				.candidate(candidateUser).activityName(activity)
				.page((pageNo - 1) * pagesize, pagesize).orderDesc("id").list();
		List<Worksheet> worksheetList = new ArrayList<Worksheet>();

		for (Task task : tasklist) {
			boolean result = true;
			Integer stId = (Integer) taskService.getVariable(task.getId(),
					"worksheetno");

			SupportTicket st = new SupportTicket();
			st.setId(stId);

			st = stService.getSupportTicket(st);

			try {
//				过滤
				if (stNO != null && stNO.trim().length()>0 && result)
					result = result && st.getStNo().equals(stNO);
				if (slNo != null && result)
					for (User sl : st.getLstSupportLeaders()) {
						result = result
								&& slNo.equals(sl.getUserid().toString());
					}

				if (region != null && result)
					result = result && region.equals(st.getRegion());

				if (result) {
					Worksheet sheet = new Worksheet();

					sheet.setTask(task);
					sheet.setSt(st);

					sheet.setTaskId(sheet.getTask().getId());
					
					Dict_item tempDictI = new Dict_item();
					tempDictI.setDict_code(Constants.ST_WORKFLOW_NAME_DICT_CODE);
					tempDictI.setFact_value(sheet.getTask().getActivityName());
					sheet.setActivityName(tempDictI.getDisplay_name());
					sheet.setApplicantName(sheet.getSt().getApplicant() != null ? sheet
							.getSt().getApplicant().getUsername()
							: "");
					// 技术负责人
					String sSupportLeaderName = "";
					for (User sl : sheet.getSt().getLstSupportLeaders())
						sSupportLeaderName += "," + sl.getUsername();
					sSupportLeaderName = sSupportLeaderName.length() > 0 ? sSupportLeaderName
							.substring(1) : sSupportLeaderName;
					sheet.setSupportLeaderName(sSupportLeaderName);

					// 设置单位名称
					String supportDeptName = "";
					for (Department dept : sheet.getSt().getSupportDeptList()) {
						supportDeptName += dept.getDepartname() + ",";
					}
					supportDeptName = supportDeptName.length() > 0 ? supportDeptName
							.substring(0, supportDeptName.length() - 1)
							: supportDeptName;

					sheet.setSupportDeptName(supportDeptName);
					// sheet.setSupportDeptCode(sheet.getSt().getSupportDept()
					// .getDepartcode());
					sheet.setStNo(sheet.getSt().getStNo());

					tempDictI.setDict_code(Constants.ST_REGION_DICT_CODE);
					tempDictI.setFact_value(sheet.getSt().getRegion());
					sheet.setRegionName(dicItemService
							.getDictionaryItemByDictCodeAndFactValue(tempDictI)
							.getDisplay_name());
					sheet.setRegionCode(sheet.getSt().getRegion());

					tempDictI.setDict_code(Constants.ST_STATUS_DICT_CODE);
					tempDictI.setFact_value(sheet.getSt().getStStatus());
					sheet.setStStatusName(dicItemService
							.getDictionaryItemByDictCodeAndFactValue(tempDictI)
							.getDisplay_name());
					sheet.setStStatusCode(sheet.getSt().getStStatus());
					worksheetList.add(sheet);

					sheet.setTask(null);
				}
			} catch (Exception e) {
				log.error(e);
				log.debug(e.fillInStackTrace());
			}

		}

		tasklist.clear();

		Page pagein = new Page(pageNo, pagesize);
		pagein.setData(worksheetList);
		pagein.setTotalRows(worksheetList.size());

		return pagein;
	}

	public Worksheet getWorksheetTask(String taskId) {
		Worksheet worksheet = null;
		TaskService taskService = workflow.getTaskService();
		if (taskId == null || taskId.trim().length() == 0) {
			log.error("taskId 为空");
			throw new RuntimeException("taskId 为空");
		}
		Task task = taskService.getTask(taskId);
		// ((TaskImpl)task).getAllParticipants().size();
		if (task != null) {

			Integer stId = (Integer) taskService.getVariable(task.getId(),
					"worksheetno");

			SupportTicket st = new SupportTicket();
			st.setId(stId);
			// @fixed 申请人在环节查询的时候为空,任意制定一个APPLICANT的ID以满足SQL 关联查询的条件
			// User applicant=new User();
			// applicant.setUserid(1);
			// st.setApplicant(applicant);
			// @fixed 技术负责人在环节查询的时候为空,任意制定一个负责人的ID以满足SQL 关联查询的条件
			// User sl=new User();
			// sl.setUserid(1);
			// st.setSupportLeader(sl);

			try {
				st = stService.getSupportTicket(st);

				worksheet = new Worksheet();
				worksheet.setTask(task);
				Dict_item tempDictI = new Dict_item();
				tempDictI.setDict_code(Constants.ST_WORKFLOW_NAME_DICT_CODE);
				tempDictI.setFact_value(worksheet.getTask().getActivityName());
				worksheet.setActivityName(tempDictI.getDisplay_name());
				worksheet.setTaskId(task.getId());
				worksheet.setFormResourceName(task.getFormResourceName());

				worksheet.setSt(st);
				tempDictI.setDict_code(Constants.ST_REGION_DICT_CODE);
				tempDictI.setFact_value(worksheet.getSt().getRegion());
				worksheet.setRegionCode(st.getRegion());
				worksheet.setRegionName(dicItemService
						.getDictItemNameByDcFv(tempDictI));
				worksheet
						.setApplicantName(worksheet.getSt().getApplicant() != null ? worksheet
								.getSt().getApplicant().getUsername()
								: "");
				// 技术负责人
				String sSupportLeaderName = "";
				for (User sl : worksheet.getSt().getLstSupportLeaders())
					sSupportLeaderName += "," + sl.getUsername();
				sSupportLeaderName = sSupportLeaderName.length() > 0 ? sSupportLeaderName
						.substring(1) : sSupportLeaderName;
				worksheet.setSupportLeaderName(sSupportLeaderName);
				// 设置单位名称
				String supportDeptName = "";
				for (Department dept : worksheet.getSt().getSupportDeptList()) {
					supportDeptName += dept.getDepartname() + ",";
				}
				supportDeptName = supportDeptName.length() > 0 ? supportDeptName
						.substring(0, supportDeptName.length() - 1)
						: supportDeptName;

				worksheet.setSupportDeptName(supportDeptName);
				worksheet.setStNo(worksheet.getSt().getStNo());

				worksheet.setTask(null);
			} catch (Exception e) {
				log.error(e);
				log.debug(e.fillInStackTrace());
			}

		}
		return worksheet;
	}

	@Resource(name = "dict_itemService")
	public void setDicItemService(IDict_itemService dicItemService) {
		this.dicItemService = dicItemService;
	}

	@Resource(name = "SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name = "WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	public List<Dict_item> get_region_with_userrole(Map map) {
		List<Dict_item> result_list = this.worksheet_dao.get_region_with_userrole(map);
		if(!result_list.isEmpty()){
			return result_list;
		}
		else{
			result_list = this.worksheet_dao.get_region_with_deptcode(map);
			return result_list;
		}
			
	}

	public Page get_region_with_userrole_for_page(Map map,int pageno,int pagesize,String dir, String sort) {
		Page result = this.worksheet_dao.get_region_with_userrole_for_page(map, pageno, pagesize, dir, sort);
		if(result.getData().isEmpty())
			result = this.worksheet_dao.get_region_with_deptcode_for_page(map, pageno, pagesize, dir, sort);
		return result;
	}
}
