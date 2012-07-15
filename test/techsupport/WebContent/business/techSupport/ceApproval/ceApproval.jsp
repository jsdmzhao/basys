<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../../public/common.jsp" %>
<%@include file="../common/base.jsp" %>
<script type="text/javascript" src="<%=tsBase %>/common/javascript/common.js"></script>
<script type="text/javascript" src="<%=tsBase %>/ceApproval/ceApproval.js"></script>
<link href="<%=tsBase %>/common/css/basets.css" type="text/css" rel="stylesheet"></link>

<style>
 
 .item{
 	margin-left: 5px;
 }
 
 #title {
 	line-height: 25px;
 	
 }
 
 .select {
 	height:19px !important;
 	border:solid 1px #7f9db9 !important;
 }
 
 .date {
    width: 100px !important;
}
 
</style>

<input type="hidden" id="p_taskId" value="">
<input type="hidden" id="sv_st_id">
<input type="hidden" id="att_stId">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">公司审批</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#detailCt").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<div id="ceApprovalCt" style="padding: 5 5 5 5">
	<fieldset>
		<legend>支持单信息</legend>
		<%@ include file="../common/template/support_ticket_detail_template.jsp" %>
	</fieldset>
	<div class="row" style="width: 100%;">
	
			<div class="column" style="width: 49%;">
				<fieldset>
					<legend>督办进展</legend>
					<div id="supervision_list_div" style="margin-left: auto;margin-right: auto;text-align: center;">
						<table id="supervision_list_table" >
							<thead>
								<tr>
									<th>督办人</th>
									<th>督办进展</th>
									<th>督办时间</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="clear-column"></div>
				</fieldset>
			</div>
	
			<div class="column" style="width: 49%;float: right;">
				<fieldset>
					<legend>进展信息</legend>
					<div id="trackingTableDiv" >
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
				</fieldset>
			</div>
		</div>
	
		<div id="ceApproval">
			<input type="hidden" name="ceApprovalSt.id">
			<input type="hidden" name="ceApprovalSt.trackList[0].stId" id="tracklist_stId">
			  <div class="row" >
	            <div class="column " style="width: 49%;">
		            <fieldset>
					<legend>公司一级审批信息</legend>
	                <label class="label red">审批日期:</label>
	                <input type="text" class=" item ro inputstyle" name="ceApprovalSt.trackList[0].trackingDate" id="ceApprovalDate" value="<%=dateNow%>">
	                <div class="clear-column"></div>
	                
	                <div class="row" >
	                    <div class="column " >
	                        <label class="label red">审批结果:</label>
	                         <div id="ceApprovalRadioPanel" class="item">
	                         </div>
	                        <div class="clear-column"></div>
	                        
	                    </div>
	                </div>
	                
	                <div class="row" >
	                    <div class="column " >
	                        <label class="label label-80 red">审批人:</label>
	                         <div>
	                            <input type="text" class=" item ro inputstyle" 
	                            	name="ceApprovalSt.trackList[0].processor.username" 
	                            	id="ceName" 
	                            	value="<%=username %>" 
	                            	style="width:86px!important;">
	                            <input type="hidden" name="ceApprovalSt.trackList[0].processor.userid"
	                             	value="<%=user.getUserid()%>">
	                            <input type="hidden" name="ceApprovalSt.trackList[0].processor.departid"
	                           		value="<%=user.getDepartid()%>">
	                         </div>
	                        <div class="clear-column"></div>
	                    </div>
	                    <div class="clear-row"></div>
	                </div>
	                
	                <div class="row">
	                	<div class="column ">
			                <label class="label red">审批意见:</label>
			                <textarea class=" item inputstyle" style="width:310px !important;height: 77px;" name="ceApprovalSt.trackList[0].newProcess" id="ceReply"></textarea>
			                <input type="hidden" name="ceApprovalSt.trackList[0].type" value="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_CEREPLY%>">
			                <div class="clear-column"></div>
			            </div>
	                	<div class="clear-row"></div>
	                </div>
	                
          			<div class="row">
						<div class="column" >
							<label class="label red">技术支持部门:</label>
							<div id="deptApprovalPanel"  class="item">
								<label><input type="checkbox" name="ceApprovalSt.supportDeptList[0].departcode" value="cpfab">产品方案部</label>
								<label><input type="checkbox" name="ceApprovalSt.supportDeptList[1].departcode" value="jskfb">技术开发部</label>
							</div>
							<div class="clear-column"></div>
						</div>
						<div class="clear-row"></div>
					</div>
					</fieldset>
	            </div>
	            
	            <%--附件 --%>
	            <div class="column" style="width: 49%;float: right;">
	            	<fieldset>
	            		<legend>附件</legend>
	            		<label class="label">&nbsp;</label>
						<div class="item">
							<div id="attachment_list_div">
								<table id="attachment_list_table">
									<thead>
										<th>文件名</th>
										<th>文件大小</th>
										<th>备注</th>
										<th>操作</th>
									</thead>
									
								</table>
							</div>
						</div>
	            	</fieldset>
					
					<div class="clear-column"></div>
				</div>
	            <div class="clear-row"></div>
	        </div>

	<div class="clear-row"></div>
	</div>
		
	<div id="footerCt">
		<div class="row">
			<div class="column" style="width: 70%;">
				<div class="clear-column"></div>
			</div>
			<div class="column" style="width:10%;">
				<a href="#" class="addbutton" id="savebtn">保存</a>
				<div class="clear-column"></div>
			</div>
			<div class="column" style="width:10%;">
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>
	</div>
