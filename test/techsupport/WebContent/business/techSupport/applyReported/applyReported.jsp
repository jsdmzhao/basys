<%@page import="java.util.UUID"%>
<%@ page language="java" pageEncoding="utf8"%>
<%@include file="/public/common.jsp"%>
<%@include file="../common/base.jsp" %>

<script type="text/javascript" src="<%=tsBase%>/common/javascript/uploadify/jquery.uploadify.v2.1.4.js"></script> 
<script type="text/javascript" src="<%=tsBase%>/common/javascript/uploadify/swfobject.js"></script>
<script type="text/javascript" src="<%=tsBase %>/common/javascript/common.js"></script>
<script type="text/javascript" src="<%=tsBase %>/applyReported/applyReported.js"></script>
<link href="<%=tsBase %>/common/css/basets.css" type="text/css" rel="stylesheet"></link>
<link href="<%=tsBase%>/common/javascript/uploadify/uploadify.css"  rel="stylesheet" type="text/css"/>  
<style><!--
 #contentCt {
 	overflow-x:hidden;
 	overflow-y:auto;
 	padding-left:50px;
 	padding-right:50px;
 	background-color: #edf1f7;
 }
 
 .item{
 	margin-left: 5px;
 	float: left;
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
 
--></style>
<input id="att_batchNumber"  type="hidden" name="uploadId" value="<%=UUID.randomUUID()%>">
<div id="fileUploadPanel" style="position: absolute; display: none;width: 400px; ">

</div>
<div id="applyReportedCt" class="bnbody">
	<div id="title" class="queryfont">
		技术支持单录入
	</div>
	<div id="contentCt" class="tdbg scrollbarface">
		<!-- content start -->
		<%@include file="../common/template/support_ticket_template.jsp" %>
		<%-- 附件上传 --%>
		<div class="row">
			<div class=" column" >
				<label class="label">附件:</label>
				<div class="item">
					<input type="file" name="upload" id="uploadFile">
<!-- 					<input type="button" id="uploadCancelQueueButton" value="取消全部上传"> -->
				</div>
			</div>
			<div class="clear-row"></div>
		</div>
		<div class="row pagedistd">
			<div class="column" style="width: 800px;">
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
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>
		<!-- content end -->
	</div>
	<div id="footerCt">
		<div class="row">
			<div class="column" style="width: 100%;">
				<div class="item" style="margin-left: 680px;">
					<a href="#" class="addbutton" id="savebtn">保存</a>
				</div>
				<div class="item">
					<a href="#" id="uploadButton" class="submitbutton">上传附件</a>
				</div>
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>
	</div>
</div>
