<%@page import="com.aisino2.techsupport.common.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../../public/common.jsp"%>
<%@include file="../common/base.jsp"%>

<script type="text/javascript"
	src="<%=tsBase%>/common/javascript/common.js"></script>
<script type="text/javascript"
	src="<%=tsBase%>/deptApproval/deptApproval.js"></script>

<link href="<%=tsBase%>/common/css/basets.css" type="text/css"
	rel="stylesheet"></link>
<style>
<!--
#contentCt {
	overflow-x: hidden;
	overflow-y: auto;
	padding-left: 50px;
	padding-right: 50px;
}

.item {
	margin-left: 8px;
}

.select {
	height: 19px !important;
	border: solid 1px #7f9db9 !important;
}

.date {
	width: 100px !important;
}
-->
</style>
<input type="hidden" id="p_taskId">
<input type="hidden" id="sv_st_id">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">部门审批</td>
		<td align="right"><a href="#" id="closeDiv"
			onclick='$("#detailCt").hideAndRemove("show");' class="close"></a>
		</td>
	</tr>
</table>
<div id="deptApprovalCt" style="padding: 5 5 5 5;">

	<div id="contentCt" class="tdbg scrollbarface">
		<div id="detailFieldPanel">
			<fieldset>
				<legend>支持单信息</legend>
				<%@ include
					file="../common/template/support_ticket_detail_template.jsp"%>
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
					<div id="trackingTableDiv" style="margin-left: auto;margin-right: auto;text-align: center;">
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
			<div class="row">
				<div class="column " style="width: 49%;">
					<fieldset>
						<legend>公司审批信息</legend>
						<div id="ceApproval">
							<div class="column ">
								<label class="label red">审批日期:</label> <input type="text"
									class=" item ro inputstyle" name="st.trackList[0].trackingDate"
									id="ceApprovalDate">
								<div class="clear-column"></div>

								<div class="row">
									<div class="column ">
										<label class="label red">审批结果:</label>
										<div id="ceApprovalRadioPanel">
											<span class="item"></span>
										</div>
										<div class="clear-column"></div>

									</div>
								</div>

								<div class="row">
									<div class="column ">
										<label class="label red">审批人:</label>
										<div>
											<input type="text" class=" item ro inputstyle"
												name="st.trackList[0].processor.username" id="ceName"
												style="width: 80px !important;">
										</div>
										<div class="clear-column"></div>
									</div>
								</div>
							</div>

							<div class="column " style="width: 600px;">
								<label class="label">审批意见:</label>
								<textarea class="ro item inputstyle"
									style="width: 320px !important; height: 66px;"
									name="st.trackList[0].newProcess" id="ceReply"></textarea>
								<div class="clear-column"></div>
							</div>
							<div class="clear-row"></div>
					</fieldset>
				</div>

				<div class="column " style="width: 49%;float: right;">
					<fieldset>
						<legend>部门审批信息</legend>
						<div class="deptApproval">

							<input type="hidden" name="st.trackList[0].stId" value=""
								id="tracklist_stId"> <input type="hidden" name="st.id"
								id="stId">
							<div class="row">
								<div class="column ">
									<label class="label red label-100">审批日期:</label> <input type="text"
										class=" item ro inputstyle"
										name="st.trackList[0].trackingDate" id="deptApprovalDate"
										value="<%=dateNow%>"> <input type="hidden"
										name="st.trackList[0].processor.userid"
										value="<%=user.getUserid()%>"> <input type="hidden"
										name="st.trackList[0].processor.departid"
										value="<%=user.getDepartid()%>">
									<div class="clear-column"></div>

									<div class="row">
										<div class="column ">
											<label class="label red label-100">审批结果:</label>
											<div id="deptRadioPanel"></div>
											<div class="clear-column"></div>
										</div>
									</div>

									<div class="row">
										<div class="column ">
											<label class="label red label-100">审批人:</label>
											<div>
												<input type="text" class=" item ro"
													name="st.trackList[0].processor.username" id="deptName"
													value="<%=username%>" style="width: 80px !important;">
											</div>
											<div class="clear-column"></div>
										</div>
									</div>
								</div>
								<div class="clear-row"></div>
							</div>

							<div class="column " >
								<label class="label red label-100">审批意见:</label>
								<textarea class=" item inputstyle"
									style="width: 320px !important; height: 60px;"
									name="st.trackList[0].newProcess" id="deptReply"></textarea>
								<div class="clear-column"></div>
							</div>

						</div>
					</fieldset>
					<div class="clear-column"></div>

				</div>

				<div class="clear-row"></div>
			</div>
		</div>

		<div class="row deptApproval">
			<div id="psgAppr">
				<div class="row">
					<div class="column ">
						<label class="label red">计划完成时间:</label> <input type="text"
							class=" item datero inputstyle" name="st.psgScheDate"
							id="psgScheDate">
						<div class="clear-column"></div>
					</div>
					<div class="column label-100">
						<label class="label" style="width: 60px;">阶段:</label> <input
							type="checkbox" class=" item" id="psgstage">
						<div class="clear-column"></div>
					</div>
					<div class="column column-block2">
						<div class="psgstage">
							<label class="label" style="width: 60px;">需求:</label> <input
								type="text" class=" item date datero  inputstyle"
								name="st.psgDsScheDate" id="psgDsScheDate">
						</div>

						<div class="clear-column"></div>
					</div>
					<div class="column column-block2">
						<div class="psgstage">
							<label class="label" style="width: 60px;">实施:</label> <input
								type="text" class=" item date datero inputstyle"
								name="st.psgIsScheDate" id="psgIsScheDate">
						</div>

						<div class="clear-column"></div>
					</div>
					<div class="clear-row"></div>
				</div>
			</div>
			<div id="devAppr" >
				<div class="row">
					<div class="column ">
						<label class="label red">计划完成时间:</label> <input type="text"
							class=" item datero inputstyle" name="st.devScheDate"
							id="devScheDate">
						<div class="clear-column"></div>
					</div>
					<div class="column label-100">
						<label class="label" style="width: 60px;">阶段:</label> <input
							type="checkbox" class=" item " id="devstage">
						<div class="clear-column"></div>
					</div>
					<%-- 折行 --%>
					<div>
						<div class="column column-block2">
							<div class="devstage">
								<label class="label" style="width: 60px;">设计:</label> <input
									type="text" class=" item date datero inputstyle"
									name="st.devDsScheDate" id="devDsScheDate">
							</div>
							<div class="clear-column"></div>
						</div>
						<div class="column column-block2">
							<div class="devstage">
								<label class="label" style="width: 60px;">开发:</label> <input
									type="text" class=" item date datero inputstyle"
									name="st.devDdScheDate" id="devDdScheDate">
							</div>

							<div class="clear-column"></div>
						</div>
						<%-- ++ 新需求为技术开发部添加测试阶段 --%>
						<div class="column column-block2">
							<div class="devstage">
								<label class="label" style="width: 60px;">测试:</label> <input
									type="text" class=" item date datero inputstyle"
									name="st.devDtScheDate" id="devDtScheDate">
							</div>

							<div class="clear-column"></div>
						</div>
						<%-- -- 新需求为技术开发部添加测试阶段 (结束) --%>
					</div>

					<div class="clear-row"></div>

				</div>
			</div>
			<div class="row">
				<div class="column ">
					<label class="label red">支持单负责人:</label> <input type="text"
						class="item ro inputstyle" id="supportLeaderName"> <input
						type="hidden" class=" item" name="st.lstSupportLeaders[0].userid"
						id="supportLeaderCode">
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
		</div>
	</div>
	<div id="footerCt">
		<div class="row">
			<div class="column" style="width: 70%;">
				<div class="clear-column"></div>
			</div>
			<div class="column" style="width: 10%;">
				<a href="#" class="addbutton" id="savebtn">保存</a>
				<div class="clear-column"></div>
			</div>
			<div class="column" style="width: 10%;">
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>
	</div>
</div>
