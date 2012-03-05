<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/base.jsp" %>

<script type="text/javascript" src="<%=tsBase %>/common/javascript/common.js"></script>
<script type="text/javascript" src="<%=tsBase %>/worksheet/worksheet.js"></script>

<link href="<%=tsBase %>/common/css/basets.css" type="text/css" rel="stylesheet"></link>

<style>
<!--
#title {
	margin-top: 4px;
	margin-bottom: 4px;
	line-height: 25px;
}


.item{
	margin-right: 10px;
}

#queryContent {
	padding-top: 2px;
	padding-bottom: 2px;
	padding-left: 2px;
	padding-right: 2px;
	
	margin-top: 2px;
	margin-bottom: 2px;
}

.row{
	margin-top: 2px;
	margin-bottom: 2px;
}

#contentCt {
	padding-left:2px;
 	padding-right:2px;
 	background-color: #edf1f7;
}

-->
</style>

<div id="tsworksheet" class="bnbody">
	<div id="title" class="queryfont">
		技术支持待办工作单
	</div>
	<div id="contentCt">
		<div id="queryPanel">
			<div class="row">
				<div class="column pagedistd">
					<label class="label pagedistd">技术支持单编号:</label>
					<input type="text" class="item inputstyle" name="p_stNo" id="p_stNo">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<div class="row">
				<div class="column pagedistd">
					<label class="label">技术支持单负责人:</label>
					<input type="text" class="item inputstyle ro" id="slName">
					<input type="hidden" id="p_supportLeaderId" name="p_supportLeaderId">
					<div class="clear-column"></div>
				</div>
				
				<div class="column pagedistd">
					<label class="label">大区/区域:</label>
					<input type="text" class="item inputstyle ro" id="rgName">
					<input type="hidden" id="p_regionCode" name="p_regionCode">
					<div class="clear-column"></div>
				</div>
				
				<div class="column">
					<label class="label">支持单环节:</label>
<!--					<input type="text" class="item inputstyle" name="p_activityName" id="p_activityName">-->
					<%-- ++添加流程筛选 --%>
					<select class="item" name="p_activityName" id="p_activityName">
						<option></option>
					</select>
					<%-- --添加流程筛选 --%>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column" style="width: 80%;">
					<div class="clear-column"></div>
				</div>
				<div class="column" style="width:10%;">
					<a href="#" class="item searchbutton" id="queryBtn">查  询</a>
					<div class="clear-column"></div>
				</div>
				<div class="column" style="width:10%;">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
		</div>
		<div id="queryContent">
			<table id="queryContentTable" width="100%" border="1">
			  <thead>
			    <tr>       
			     	<th name="l_stNo">支持单编号</th>
			     	<th name="l_region">大区/区域</th>
			     	<th name="l_applicant">申请人</th>
			     	<th name="l_supportLeader">技术支持人</th>
			     	<th name="l_supportDept">技术支持部门</th>
			     	<th name="l_stStatus">状态</th>
			     	<th name="l_taskName">环节</th>
			     	<th name="">操作</th>
			    </tr>
			  </thead>
			</table>
			
		</div>
	</div>
</div>
<div id="detailCt" style="position: absolute; z-index: 1000; top:0px; left:160px; display: none;" class="page-layout"></div>