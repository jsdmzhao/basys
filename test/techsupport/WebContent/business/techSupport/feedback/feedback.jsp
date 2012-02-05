<%@page import="com.aisino2.techsupport.common.Constants"%>
<%@ page language="java" pageEncoding="utf8"%>
<%@include file="../../../public/common.jsp"%>
<%@include file="../common/base.jsp" %>

<script type="text/javascript" src="<%=tsBase %>/feedback/feedback.js"></script>
<link href="<%=tsBase %>/common/css/basets.css" type="text/css" rel="stylesheet"></link>

<style type="text/css">

.date {
	width: 100px !important;
}
</style>
<input type="hidden" id="p_taskId">
<input type="hidden" name="st.id">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">反馈确认</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#detailCt").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<div id="feedback">
	<div class="row">
		<div class="column">
			<label class="label">技术支持单编号:</label>
			<input type="text" class="item ro inputstyle" id="p_stNo" name="st.stNo">
			<div class="clear-column"></div>
		</div>
		<div class="column column-250">
			<label class="label label-80">技术支持部门:</label>
			<input type="text" class="item inputstyle ro" id="p_deptName" name="st.supportDeptList.departname">
			<div class="clear-column"></div>
		</div>
		<div class="clear-row"></div>
	</div>
	
	
	<div class="row">
		<div class="column">
			<label class="label">技术负责人:</label>
			<input type="text" class="item ro inputstyle" name="st.supportLeader.username" id="p_slName">
			<div class="clear-column"></div>
		</div>
		<div class="column column-250">
			<label class="label label-80">大区/区域:</label>
			<input type="text" class="item ro inputstyle" name="st.region" id="p_region">
			<div class="clear-column"></div>
		</div>
		<div class="column column-250">
			<label class="label label-80">申请人:</label>
			<input type="text" class="item inputstyle ro" name="st.applicant.username" id="p_applicant">
			<div class="clear-column"></div>
		</div>
		<div class="clear-row"></div>
	</div>
	
	<div class="row">
		<div class="column"  style="width: 800px;">
			<label class="label">技术支持单内容:</label>
			<textarea style="width:660px ! important;height: 79px;" class="ro item inputstyle" name="st.supportContent" id="p_supportContent"></textarea>
			<div class="clear-column"></div>
		</div>
		
		<div class="clear-row"></div>
	</div>
	
	<div class="row">
		<div style="margin-left: auto; margin-right: auto; width: 800px;">
			<div class=" column" style="width: 190px;">
			<label class="label label-80">产品方案部:</label>
			<div class="clear-column"></div>
			
			<div class="row">
				<div class="column">
					<label class="label label-80">计划完成时间:</label>
					<input type="text" class=" item ro label-100 inputstyle" name="st.psgScheDate" id="p_psgScheDate">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<label class="label label-80">阶段:</label>
					<input type="checkbox" class=" item" id="psgstage">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<div class="psgstage">
						<label class="label label-80" >需求:</label>
						<input type="text" class="psgstage item label-100 ro " name="st.psgDsScheDate" id="p_psgDsScheDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<div class="psgstage">
						<label class="label label-80" >实施:</label>
						<input type="text" class=" psgstage item label-100 ro" name="st.psgIsScheDate" id="p_psgIsScheDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
		</div>
		
		<div class="column column-block2" style="width: 190px;">
			<div>
				<label class="label label-80"></label>
			</div>
			<div class="clear-column"></div>
			
			
			<div class="row" >
				<div class="column" >
					<label class="label label-80">实际完成时间:</label>
					<input type="text" class=" item ro label-100 inputstyle" name="st.psgCompDate" id="p_psgCompDate">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<div class="row">
				<div class="column">
					<label class="label label-80">阶段:</label>
					<input type="checkbox" class=" item" id="psgcpstage">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<div class="psgcpstage">
						<label class="label label-80" >需求:</label>
						<input type="text" class=" item psgcpstage label-100 ro  inputstyle" name="st.psgDsCompDate" id="p_psgDsCompDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<div class="psgcpstage">
						<label class="label label-80" >实施:</label>
						<input type="text" class=" item psgcpstage label-100 ro inputstyle" name="st.psgIsCompDate" id="p_psgIsCompDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="clear-column"></div>
		</div>
		
		<div class="column" style="width: 190px;">
			<label class="label label-80">技术研发部:</label>
			<div class="clear-column"></div>
			
			<div class="row">
				<div class="column">
					<label class="label label-80">计划完成时间:</label>
					<input type="text" class=" item ro label-100 inputstyle" name="st.devScheDate" id="p_devScheDate">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<div class="row">
				<div class="column">
					<label class="label label-80">阶段:</label>
					<input type="checkbox" class=" item"  id="devstage">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<div class="devstage">
						<label class="label label-80" >设计:</label>
						<input type="text" class=" item devstage label-100 ro inputstyle" name="st.devDsScheDate" id="p_devDsScheDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
		
			<div class="row">
				<div class="column">
					<div class="devstage">
						<label class="label label-80" >开发:</label>
						<input type="text" class=" item devstage label-100 ro inputstyle" name="st.devDdScheDate" id="p_devDdScheDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<%-- ++ 新需求 技术开发部添加阶段测试 --%>
			<div class="row">
				<div class="column">
					<div class="devstage">
						<label class="label label-80" >测试:</label>
						<input type="text" class=" item devstage label-100 ro inputstyle" name="st.devDtScheDate" id="p_devDtScheDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<%-- -- 新需求 技术开发部添加阶段测试 -- --%>
		</div>
		
		<div class="column column-block2">
			<div>
				<label class="label label-80"></label>
			</div>
			<div class="clear-column"></div>
			
			
			<div class="row">
				<div class="column" >
					<label class="label label-80">实际完成时间:</label>
					<input type="text" class=" item ro label-100 inputstyle" name="st.devCompDate" id="p_devCompDate">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<label class="label label-80">阶段:</label>
					<input type="checkbox" class=" item" id="devcpstage">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column">
					<div class="devcpstage">
						<label class="label label-80" >设计:</label>
						<input type="text" class=" item devcpstage label-100 ro inputstyle" name="st.devDsCompDate" id="p_devDsCompDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
		
			<div class="row">
				<div class="column">
					<div class="devcpstage">
						<label class="label label-80" >开发:</label>
						<input type="text" class=" item devcpstage label-100 ro inputstyle" name="st.devDsCompDate" id="p_devDsCompDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<%-- ++ 新需求 技术开发部添加阶段测试 --%>
			<div class="row">
				<div class="column">
					<div class="devstage">
						<label class="label label-80" >测试:</label>
						<input type="text" class=" item devstage label-100 ro inputstyle" name="st.devDtCompDate" id="p_devDtCompDate">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<%-- -- 新需求 技术开发部添加阶段测试 -- --%>
			
		</div>
		</div> <!-- 时间行结束 -->
		
	</div>
	<div class="row" style="width: 90%; margin: 0 auto; ">
		<div class="column" style="width: 100%;">
			<div id="trackingTableDiv" style="width: 100%;">
				<table id="trackingTable" width="100%" border="1" cellpadding="0" cellspacing="0">
				  <thead>
				    <tr>       
				     	<th name="l_stNo">日期</th>
				     	<th name="l_region">进展</th>
				     	<th name="l_applicant">填写人员</th>
				    </tr>
				  </thead>
				</table>
			</div>
			<div class="clear-column"></div>
		</div>
		<div class="clear-row"></div>
	</div>
	
	
	<div class="row">
	
		
		<div class="column">
			<div class="row">
				<div class="column">
					<label class="label">提请反馈日期:</label>
					<input type="text" class="item ro label-100 inputstyle" id="p_applyingFeedbackDate" name="st.applyingFeedbackDate">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				
				<label class="label red">日期:</label>
				<input type="text" class="ro date item inputstyle" name="tracking.trackingDate" id="p_trackingDate" value="<%=dateNow%>">
			</div>
			
			<div class="clear-column"></div>
		</div>
	
		<div class="column" style="width: 530px;">
			<div>
				<label class="label label-80 red">反馈确认填写:</label>
				<input type="hidden" name="tracking.type" value="<%=Constants.TRACKING_TYPE_FEEDBACK%>">
				<textarea class="item inputstyle" style="width:400px ! important;height: 78px;" name="tracking.newProcess" id="p_newProcess"></textarea>
			</div>
			<div class="clear-column"></div>
		</div>
		
		<div class="clear-row"></div>
	</div>
	
	
	<div class="row">
		<div class="column" style="width: 70%">
			<div class="clear-column"></div>
		</div>
		<div class="column" style="width: 120px;">
			<a href="#" class="item submitbutton" id="saveBtn" >保存</a>
			<div class="clear-column"></div>
		</div>
		<div class="column" style="width: 120px;">
			<a href="#" class="item submitbutton" id="noFeedbackBtn">不予反馈</a>
			<div class="clear-column"></div>
		</div>
		<div class="clear-row"></div>
	</div>
</div>