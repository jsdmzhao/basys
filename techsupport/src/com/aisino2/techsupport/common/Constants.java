package com.aisino2.techsupport.common;

import javax.annotation.Resource;

import org.codehaus.xfire.spring.SpringUtils;



public class Constants {
	//进行中
	public static String ST_STATUS_GOING="going";
	//例外终止
	public static String ST_STATUS_STOP="stop";
	//已完成
	public static String ST_STATUS_COMPLETE="gone";
	//待反馈
	public static String ST_STATUS_WAIT_FEEDBACK="wait_feedback";
	//已反馈
	public static String ST_STATUS_FEEDBACKED="feedbacked";
	
	//支持单状态字典代码
	public static String ST_STATUS_DICT_CODE="dm_ts_status";
	
	//区域字典代码
	public static String ST_REGION_DICT_CODE="dm_ts_regin";
	
	//区总区域映射字典代码
	public static String ST_RGM_RG_MAP_DICT_CODE="dm_ts_rm_map";
	
	
	//普通进展批复
	public static String TRACKING_TYPE_TRACKING = "0";
	//总共批复
	public static String TRACKING_TYPE_CEREPLY = "10";
	//产品方案批复
	public static String TRACKING_TYPE_PGMREPLY = "20";
	//技术主管批复
	public static String TRACKING_TYPE_HDEVREPLY = "30";
	
	//反馈意见
	public static String TRACKING_TYPE_FEEDBACK = "40";
	//归档意见或者注释
	public static String TRACKING_TYPE_ARCHIVE = "50";
	
	//流程名称
	public static final String workflowName = "技术支持单";
	
	//公司代码
	public static String HTJD_DEPT_CODE="htdj";
	
	//技术支持单 审批类型字典
	public static String ST_APPR_TYPE_DICT_CODE="dm_support_appr_type";
	//未审核
	public static String ST_APPR_TYPE_UNAPPR="0";
	//通过
	public static String ST_APPR_TYPE_APPR_PASSED="10";
	//未通过
	public static String ST_APPR_TYPE_APPR_NOPASS="20";
	
//	技术支持单短息发送角色对应状态 字典
	public static String ST_SMS_ROLE_STATUS_DICT_CODE="dm_ts_role_status";
	
//	技术支持单角色信息
//	填报人
	public static String ST_ROLE_NAME_APPLICANT="ts_填报人";
//	总工
	public static String ST_ROLE_NAME_CE="ts_总工";
//	部门经理
	public static String ST_ROLE_NAME_DEPTMANAGE="ts_部门经理";
//	重庆区总
	public static String ST_ROLE_NAME_RGM_CQ="ts_重庆区总";
//	四川区总
	public static String st_ROLE_NAME_RGM_SC="ts_四川区总";
//	技术负责人
	public static String ST_ROLE_NAME_STLEADER="ts_技术负责人";
//	质量管理员
	public static String ST_ROLE_NAME_QC="ts_技术质量员";
	
	
}
