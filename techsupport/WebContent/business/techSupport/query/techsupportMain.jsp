<%@page import="com.aisino2.techsupport.common.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.User_role"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/base.jsp" %>

<script type="text/javascript" src="<%=tsBase %>/common/javascript/common.js"></script>

<link href="<%=tsBase %>/common/css/basets.css" type="text/css" rel="stylesheet"></link>

<style>
<!--
#title {
	margin-top: 4px;
	margin-bottom: 4px;
	line-height: 25px;
}

.column{
	width: 300px;
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

<script type="text/javascript">
var ingridHeight=180;
var detailWindow;
// 延迟加载
function lazyLoad(){
	queryPanelHeight = $("#queryPanel").outerHeight(true);
	ingridHeight=pageHeight-queryPanelHeight
		-$('#title').outerHeight(true)
		-$('#mainDIV > table').eq(0).height()-25;
	loadPageSupportTicketQuery(divnid);
	
}
//初始化加载
	$(function(){
		setTimeout(lazyLoad,5);
		divnid="queryContent";//查询内容容器ID
		tableid="queryContentTable";//查询内容格式表格ID
		pageUrl=BUSNEISS_PATH+ "/querylist_supportTicket.action";
		detailid="detailCt";
		detailWidth=930;
		detailURL="business/techSupport/query/techsupportDetail.jsp";
		queryTable=$("#"+tableid);
		detailWindow=$('#'+detailid);
		lazyLoad();
		
		daggleDiv(detailid);
		
// 		时间选择器设置
		$('.date').each(function(){
			$(this).attr('readOnly',true);
			$(this).datepicker();
		});
		
		$('.ro').attr('readOnly',true);
		
		var roleURL="sysadmin/queryUsreRoleList_user.action"
		setParams('t_');
 		$.post(roleURL,params,function(data){
 			var rgm_mapping_dictitems=getDictitem({dictcode:ST_RGM_RG_MAP_DICT_CODE});
 			for(i=0;i<data.userRoleList.length;i++){
//  				申请人角色 申请人选择框控制
 				if(ST_ROLE_NAME_APPLICANT == data.userRoleList[i].rolename){
 					//设置申请人
 					$('#applicantName').val('<%=username%>');
 					$('#p_applicantId').val('<%=user.getUserid()%>');

 				/*
 					
 				*/
 					$("#slName").click(function(){
						userDropDownBoxWithRole('slName','p_supportLeaderId',[ST_ROLE_NAME_STLEADER])
	 	 			});
	 	 			$('#rgName').click(function(){
	 	 				getRegionWithRole('rgName','p_region');
		 	 		});
	 	 			$('#rgName').click();
 					
 				}
//  				质量监督员 角色 控制
 				else if(ST_ROLE_NAME_QC == data.userRoleList[i].rolename){
 	 				$('#applicantName').click(function(){
 	 					getUserofDept('applicantName','p_applicantId',gxdwbm);
 	 				});
 	 				
 	 				//设置大区
 	 				$('#rgName').click(function(){
 	 					getDict_item('rgName','p_region',ST_REGION_DICT_CODE);
 	 				});
 	 			}
//  	 			部门经理 角色控制
 				else if(ST_ROLE_NAME_DEPTMANAGE == data.userRoleList[i].rolename){
 					$('#p_departid').val('<%=user.getDepartid()%>');
 					//设置技术负责人
 					$('#slName').click(function(){
 						getUserofDept('slName','p_supportLeaderId',gxdwbm);
 					});
 					
 				}
 				else{
//  	 			区总角色控制
 	 				for(j=0;j<rgm_mapping_dictitems.length;j++){
 	 					if(data.userRoleList[i].rolename == rgm_mapping_dictitems[j].display_name){
 	 						//设置申请人
 	 						$('#applicantName').click(function(){
 	 	 	 					getUserofDept('applicantName','p_applicantId',gxdwbm);
 	 	 	 				});
 	 						//设置大区
 	 						var dictItem=getDictitem({dictcode:ST_REGION_DICT_CODE,value:rgm_mapping_dictitems[j].fact_value});
 	 						$('#rgName').val(dictItem[0].display_name);
 	 						$('#p_region').val(dictItem[0].fact_value);
 	 						break;
 	 					}
 	 				}
 	 			}

 				
 			}
 			
 		},'json');
		
		
		 
// 		设置状态下拉条
		$('#p_stStatus').selectBox({code:ST_STATUS_DICT_CODE});
		
// 		初始化查询动作
		$('#queryBtn').click(function(){
			SupportTicketQuery(1);
		});
		
	});
	
	/**
	  * 表单验证
	  * */
	 function validate(){
	 	return true;
	 }
	 
	 function loadPageSupportTicketQuery(divpageid){
		tables=$("#"+divpageid).html();
		$("#"+detailid).hide(); 	
		SupportTicketQuery(1,'#');
	}	

	 /**
	  * 查询函数
	  * */
	 function SupportTicketQuery(pageno,url){
	 	if (validate()){
	 		//总工查询时间控制
	 		if($('#p_trackingDateFrom').val() || $('#p_trackingDateTo').val()){
	 			$('#p_type').val(TRACKING_TYPE_CEREPLY);
	 		}
	 		else
	 			$('#p_type').val('');
			url=setList(pageno,url);
			// create the grid
			// returns a jQ object with a 'g' property - that's ingrid
			if($('#'+tableid).length == 0){
				$('#'+divnid).html($(queryTable));
			}
			var mygrid1 = $("#"+tableid).ingrid({ 
											url: url,	
											height:ingridHeight,
											ingridPageWidth:1000,
											isPlayResultNull: false,
											havaWaiDivGunDong: true,
	                                       	ingridPageParams:sXML,
	                                       	onRowSelect:null,
											pageNumber: pageno,
											colWidths: function(){
												var a_col_widths=[];
												var ths = $('#queryContentTable th');
												for(i=0;i<ths.length;i++){
													a_col_widths[i]=100/ths.length+'%';
												}
												
												return a_col_widths;
											}()				
										});				
			}
	}
	 
	function setDetail(id){
		dataid=id;
		detailDialog(detailid,detailWidth,detailURL);
	}
</script>

<input type="hidden" id="p_tag" value="">
<input type="hidden" id="t_userid" value="<%=user.getUserid() %>">
<input type="hidden" id="p_departid" value="">
<div id="tsworksheet" class="bnbody">
	<div id="title" class="queryfont">
		技术支持单查询
	</div>
	<div id="contentCt">
		<div id="queryPanel">
			<div class="row">
				<div class="column pagedistd">
					<label class="label">支持单状态:</label>
					<div class="item">
						<select class="item" name="st.stStatus" id="p_stStatus">
							<option></option>
						</select>
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="column pagedistd">
					<label class="label">进展时间:</label>
					<div class="item">
						<input type="text" class="date  inputstyle" id="p_trackingDateFrom"></select>
						<input type="hidden" value="" id="p_type">
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="column pagedistd">
					<label class="label">到</label>
					<div class="item">
						<input type="text" class="date  inputstyle" id="p_trackingDateTo"></select>
					</div>
					<div class="clear-column"></div>
				</div>
				
				<div class="clear-row"></div>
			</div>
			<div class="row">
				<div class="column pagedistd">
					<div>
						<label class="label">申请人:</label>
						<input type="text" class="item inputstyle ro" id="applicantName">
						<input type="hidden" id="p_applicantId" name="st.applicant.userid">
					</div>
					<div class="clear-column"></div>
				</div>
				
				<div class="column pagedistd">
					<div>
						<label class="label">技术负责人:</label>
						<input type="text" class="item inputstyle ro" id="slName">
						<input type="hidden" id="p_supportLeaderId" name="p_supportLeaderId">
					</div>
					<div class="clear-column"></div>
				</div>
				
				<div class="column pagedistd">
					<label class="label">大区/区域:</label>
					<input type="text" class="item inputstyle ro" id="rgName">
					<input type="hidden" id="p_region" name="p_regionCode">
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
			     	<th name="l_region">区域</th>
			     	<th name="l_applicant">申请人</th>
			     	<th name="l_supportLeader">技术负责人</th>
			     	<th name="l_supportDept">技术支持单位</th>
			     	<th name="l_supportStatus">状态</th>
			     	<th name="">操作</th>
			    </tr>
			  </thead>
			</table>
			
		</div>
	</div>
<div id="detailCt" style="position: absolute; z-index: 1000; top:0px; left:160px; display: none;" class="page-layout"></div>