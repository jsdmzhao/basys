package com.aisino2.techsupport.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.techsupport.domain.Worksheet;

public interface WorksheetService {
	/**
	 * 获取技术支持单代办工作单列表 分页方式(兼容ingrid)
	 * 
	 * @param pageNo
	 *            起始记录数
	 * @param pagesize
	 *            每页最大显示数目
	 * @param assignee
	 *            指派用户
	 * @param activity
	 *            环节名称
	 * @param candidateUser
	 *            指派候选人
	 * @param slNo
	 *            技术支持负责人ID
	 * @param region
	 *            地区编号
	 * @param stNo 支持单编码
	 * @return 技术支持单代办工作单列表
	 */
	Page getWorksheetTaskForPage(int pageNo, int pagesize, String assignee,
			String activity, String candidateUser, String slNo, String region,String stNo);

	/**
	 * 获取技术支持单代办工作单列表
	 * 
	 * @param assignee
	 *            指派用户
	 * @param activity
	 *            环节名称
	 * @param candidateUser
	 *            指派候选人
	 * @param slNo
	 *            技术支持负责人ID
	 * @param region
	 *            地区编号
	 * @return 技术支持单代办工作单列表
	 */
	List<Worksheet> getWorksheetTaskList(String assignee, String activity,
			String candidateUser, String slNo, String region);

	/**
	 * 获取单一技术支持工作单
	 * @param taskId 任务ID
	 * @return 工作单
	 */
	Worksheet getWorksheetTask(String taskId);
	
	List<Dict_item> get_region_with_userrole(Map map);
	Page get_region_with_userrole_for_page(Map map,int pageno,int pagesize,String dir, String sort);
	
}
