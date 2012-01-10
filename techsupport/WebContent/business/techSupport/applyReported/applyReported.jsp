<%@page import="java.util.UUID"%>
<%@ page language="java" pageEncoding="utf8"%>
<%@include file="/public/common.jsp"%>
<%@include file="../common/base.jsp" %>

<%-- <script type="text/javascript" src="<%=tsBase%>/common/javascript/uploadify/jquery.uploadify.v2.1.4.min.js"></script>  --%>
<%-- <script type="text/javascript" src="<%=tsBase%>/common/javascript/uploadify/swfobject.js"></script> --%>
<script type="text/javascript" src="<%=tsBase %>/common/javascript/common.js"></script>
<script type="text/javascript" src="<%=tsBase %>/applyReported/applyReported.js"></script>

<link href="<%=tsBase %>/common/css/basets.css" type="text/css" rel="stylesheet"></link>
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
<input id="uploadId"  type="hidden" name="uploadId" value="<%=UUID.randomUUID()%>">
<div id="applyReportedCt" class="bnbody">
	<div id="title" class="queryfont">
		技术支持单录入
	</div>
	<div id="contentCt" class="tdbg scrollbarface">
		<!-- content start -->
		<%@include file="../common/template/support_ticket_template.jsp" %>
		
		<div class="row">
<!-- 			<div class="column pagedistd" > -->
<!-- 				<label class="label">技术负责人:</label> -->
<!-- 				<input type="text" class="item inputstyle" id="supportLeaderName"> -->
<!-- 				<input type="hidden" class=" item" name="st.supportLeader.userid" id="supportLeaderCode"> -->
<!-- 				<div class="clear-column"></div> -->
<!-- 			</div> -->
			<div class="column pagedistd" >
				<label class="label">技术支持部门:</label>
				<div id="assigneeDeptPanel"></div>
<!-- 				<input type="text" class="item inputstyle" id="supportDeptName"> -->
<!-- 				<input type="hidden" class=" item" name="st.supportDept.departcode" id="supportDeptCode"> -->
					<label><input type="checkbox" class="item" name="st.supportDeptList[0].departcode" value="cpfab">产品方案部</label>
					<label><input type="checkbox" class="item" name="st.supportDeptList[1].departcode" value="jskfb">技术开发部</label>
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>
		<%-- 附件上传 --%>
<!-- 		<div class="row"> -->
<!-- 			<div class="pagedistd" style="width: 600px;"> -->
<!-- 				<label class="label">附件:</label> -->
<!-- 				<div class="item"> -->
<!-- 					<input type="file" name="uploadFileX" id="uploadFile"> -->
<!-- 					<input type="button" id="uploadButton" value="添加"> -->
<!-- 					<div id="fileUploadPanel"> -->
<!-- 						<table id="fileUploadTable"> -->
<!-- 							<thead> -->
<!-- 								<th>文件名</th> -->
<!-- 								<th>文件大小</th> -->
<!-- 								<th>文件类型</th> -->
<!-- 								<th>备注</th> -->
<!-- 								<th>操作</th> -->
<!-- 							</thead> -->
							
<!-- 						</table> -->
<!-- 					</div> -->
					
<!-- 				</div> -->
<!-- 				<div class="clear-column"></div> -->
<!-- 			</div> -->
			
<!-- 			<div class="clear-row"></div> -->
<!-- 		</div> -->
		<!-- content end -->
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
</div>
