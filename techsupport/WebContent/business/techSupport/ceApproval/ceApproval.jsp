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

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">公司审批</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#detailCt").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<div id="ceApprovalCt" class="bnbody" style="padding: 5 5 5 5">
	<fieldset>
		<legend>支持单信息</legend>
		<%@ include file="../common/template/support_ticket_detail_template.jsp" %>
	</fieldset>
		
	<fieldset>
		<legend>总工审批信息</legend>
		<div id="ceApproval">
			<input type="hidden" name="ceApprovalSt.id">
			<input type="hidden" name="ceApprovalSt.trackList[0].stId" id="tracklist_stId">
			  <div class="row" >
	            <div class="column " >
	                <label class="label red">总工审批日期:</label>
	                <input type="text" class=" item ro inputstyle" name="ceApprovalSt.trackList[0].trackingDate" id="ceApprovalDate" value="<%=dateNow%>">
	                <div class="clear-column"></div>
	                
	                <div class="row" >
	                    <div class="column " >
	                        <label class="label red">总工审批:</label>
	                         <div id="ceApprovalRadioPanel" class="item">
	                         </div>
	                        <div class="clear-column"></div>
	                        
	                    </div>
	                </div>
	                
	                <div class="row" >
	                    <div class="column " >
	                        <label class="label red">总工名称:</label>
	                         <div>
	                            <input type="text" class=" item ro inputstyle" name="ceApprovalSt.trackList[0].processor.username" id="ceName" value="<%=username %>">
	                            <input type="hidden" name="ceApprovalSt.trackList[0].processor.userid" value="<%=user.getUserid()%>">
	                            <input type="hidden" name="ceApprovalSt.trackList[0].processor.departid" value="<%=user.getDepartid()%>">
	                         </div>
	                        <div class="clear-column"></div>
	                    </div>
	                </div>
	            </div>
	            
	            <div class="column " style="width: 600px;">
	                <label class="label red">总工意见:</label>
	                <textarea class=" item inputstyle" style="width:349px !important;height: 77px;" name="ceApprovalSt.trackList[0].newProcess" id="ceReply"></textarea>
	                <input type="hidden" name="ceApprovalSt.trackList[0].type" value="<%=com.aisino2.techsupport.common.Constants.TRACKING_TYPE_CEREPLY%>">
	                <div class="clear-column"></div>
	            </div>
	            <div class="clear-row"></div>
	        </div>
			
			
			<div class="row">
				<div class="column column-block" >
					<label class="label red">技术支持部门:</label>
					<div id="deptApprovalPanel">
						<label><input type="checkbox" class="item" name="ceApprovalSt.supportDeptList[0].departcode" value="cpfab">产品方案部</label>
						<label><input type="checkbox" class="item" name="ceApprovalSt.supportDeptList[1].departcode" value="jskfb">技术开发部</label>
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<!-- content end -->
		</div>
	</fieldset>	
		
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
