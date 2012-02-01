<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String cp = request.getContextPath();
	String tsBase = cp + "/business/techSupport";
	String tsJSBase = tsBase+"/common/javascript";
%>
<%@include file="../../../public/user-info.jsp" %>
<input type="hidden" id="contextPath" value="<%=cp %>" />
<script type="text/javascript" charset="UTF-8">
	function getContextPath(){
		return $('#contextPath').val();
	}
	
	var BUSNEISS_PATH=getContextPath()+"/techsupport";
	
	var gxdwmc="<%=gxdwmc%>";
	var gxdwbm="<%=gxdwbm%>";
	//进行中
	var ST_STATUS_GOING="<%=com.aisino2.techsupport.common.Constants.ST_STATUS_GOING%>";
	//例外终止
	var ST_STATUS_STOP="<%=com.aisino2.techsupport.common.Constants.ST_STATUS_STOP%>";
	//已完成
	var ST_STATUS_COMPLETE="<%=com.aisino2.techsupport.common.Constants.ST_STATUS_COMPLETE%>";
	//待反馈
	var ST_STATUS_WAIT_FEEDBACK="<%=com.aisino2.techsupport.common.Constants.ST_STATUS_WAIT_FEEDBACK%>";
	//已反馈
	var ST_STATUS_FEEDBACKED="<%=com.aisino2.techsupport.common.Constants.ST_STATUS_FEEDBACKED%>";
	
	//支持单状态字典代码
	var ST_STATUS_DICT_CODE="<%=com.aisino2.techsupport.common.Constants.ST_STATUS_DICT_CODE%>";
	
	//区域字典代码
	var ST_REGION_DICT_CODE="<%=com.aisino2.techsupport.common.Constants.ST_REGION_DICT_CODE%>";
	
	//区总区域映射字典代码
	var ST_RGM_RG_MAP_DICT_CODE="<%=com.aisino2.techsupport.common.Constants.ST_RGM_RG_MAP_DICT_CODE%>";
	
	
	//普通进展批复
	var TRACKING_TYPE_TRACKING="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_TRACKING%>";
	//总共批复
	var TRACKING_TYPE_CEREPLY="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_CEREPLY%>";
	//产品方案批复
	var TRACKING_TYPE_PGMREPLY="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_PGMREPLY%>";
	//技术主管批复
	var TRACKING_TYPE_HDEVREPLY="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_HDEVREPLY%>";
	
	//反馈意见
	var TRACKING_TYPE_FEEDBACK="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_FEEDBACK%>";
	//归档意见或者注释
	var TRACKING_TYPE_ARCHIVE="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_ARCHIVE%>";
	//航天金盾公司 代码
	var HTJD_DEPT_CODE="<%=com.aisino2.techsupport.common.Constants.HTJD_DEPT_CODE%>";
	

		//技术支持单 审批类型字典
	var ST_APPR_TYPE_DICT_CODE="<%=com.aisino2.techsupport.common.Constants.ST_APPR_TYPE_DICT_CODE%>";
		//未审核
	var ST_APPR_TYPE_UNAPPR="<%=com.aisino2.techsupport.common.Constants.ST_APPR_TYPE_UNAPPR%>";
		//通过
	var ST_APPR_TYPE_APPR_PASSED="<%=com.aisino2.techsupport.common.Constants.ST_APPR_TYPE_APPR_PASSED%>";
		//未通过
	var ST_APPR_TYPE_APPR_NOPASS="<%=com.aisino2.techsupport.common.Constants.ST_APPR_TYPE_APPR_NOPASS%>";
	
//	技术支持单角色信息
//	填报人
	var ST_ROLE_NAME_APPLICANT="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_APPLICANT%>";
//	总工
	var ST_ROLE_NAME_CE="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_CE%>";
//	部门经理
	var ST_ROLE_NAME_DEPTMANAGE="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_DEPTMANAGE%>";
//	重庆区总
	var ST_ROLE_NAME_RGM_CQ="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_RGM_CQ%>";
//	四川区总
	var st_ROLE_NAME_RGM_SC="<%=com.aisino2.techsupport.common.Constants.st_ROLE_NAME_RGM_SC%>";
//	技术负责人
	var ST_ROLE_NAME_STLEADER="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_STLEADER%>";
//	质量管理员
	var ST_ROLE_NAME_QC="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_QC%>";

	var ST_ROLE_NAME_FEEDBACKER="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_FEEDBACKER%>";
	var ST_ROLE_NAME_SUPERVISION="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_SUPERVISION%>";
	var ST_ROLE_NAME_TRACKING_PROMPT="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_TRACKING_PROMPT%>";
	var ST_ROLE_NAME_APPROVAL_PROMPT="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_APPROVAL_PROMPT%>";
	var ST_ROLE_NAME_FEEDBACK_PROMPT="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_FEEDBACK_PROMPT%>";
	var ST_ROLE_NAME_DM="<%=com.aisino2.techsupport.common.Constants.ST_ROLE_NAME_DM%>";
</script>