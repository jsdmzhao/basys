<%@page import="com.aisino2.techsupport.common.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.User_role"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/base.jsp" %>

<html>
	<head>
	<meta http-equiv="pragma" content="no-cache" />
		<title>技术支持单查询统计</title>
		<script type="text/javascript" src="<%=tsBase %>/common/javascript/common.js"></script>

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
//督办容器
var supervision_div = "supervision_div";
//督办页面路径
var supervision_page = "business/techSupport/query/supervision.jsp";
//督办操作路径
var supervision_url = BUSNEISS_PATH + "/save_supervision.action";
//督办查询路径
var supervision_query_url = BUSNEISS_PATH +"/querylist_supervision.action";
//督办详情路径
var supervision_detail_url = BUSNEISS_PATH +"/query_supervision.action";

var supervision_width = 690;

// 延迟加载
function lazyLoad(){
	queryPanelHeight = $("#queryPanel").outerHeight(true);
	if(window.screen.height > 768 )
		ingridHeight=$('#iframes').height()-queryPanelHeight
		-$('#title').outerHeight(true)-80;
	else
		ingridHeight=document.body.clientHeight -$('#allDiv').outerHeight(true) -queryPanelHeight
		-$('#title').outerHeight(true)-80;
	loadPageSupportTicketQuery(divnid);
	
}
//初始化加载
	$(function(){
		setTimeout(lazyLoad,10);
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
// 		设置状态下拉条
		$('#p_stStatus').selectBox({code:ST_STATUS_DICT_CODE});
		//设置部门选择器
		
		$('#p_departid').selectBox({code:"dm_ts_depart_list"});
// 		时间选择器设置
		$('.date').each(function(){
			$(this).attr('readOnly',true);
			$(this).datepicker();
		});

		
		$('.ro').attr('readOnly',true);
		//导出按钮
		$('#export_btn').attr("disabled",true);
		
 		
		var roleURL="sysadmin/queryUsreRoleList_user.action"
		setParams('t_');
 		$.post(roleURL,params,function(data){
 			var rgm_mapping_dictitems=getDictitem({dictcode:ST_RGM_RG_MAP_DICT_CODE});
 			for(var i=0;i<data.userRoleList.length;i++){
//  				申请人角色 申请人选择框控制
 				if(ST_ROLE_NAME_APPLICANT == data.userRoleList[i].rolename){
 					//设置申请人
 					$('#applicantName').val('<%=username%>');
 					$('#p_applicantId').val('<%=user.getUserid()%>');

 					//支持单负责人选择器
 					$('#slName').unbind('click');
 					$("#slName").click(function(){
 						getUserofDept('slName','p_supportLeaderId',null,[ST_ROLE_NAME_STLEADER]);
	 	 			});
 					
 				}
//  	 			督办 角色控制
 				else if(ST_ROLE_NAME_SUPERVISION == data.userRoleList[i].rolename){
 					//$('#p_departid').val('<%=user.getDepartid()%>');
 					$('#applicantName').click(function(){
 	 					getUserofDept('applicantName','p_applicantId',null,[ST_ROLE_NAME_APPLICANT]);
 	 				});
 					//设置技术负责人
 					$('#slName').click(function(){
 						getUserofDept('slName','p_supportLeaderId',$('#p_departid').val(),ST_ROLE_NAME_STLEADER);
 					});
 					
 					//设置大区
 	 				$('#rgName').click(function(){
 	 					getDict_item('rgName','p_region',ST_REGION_DICT_CODE);
 	 				});
 					break;
 				}
 				//反馈人 控制
 				else if(ST_ROLE_NAME_FEEDBACKER == data.userRoleList[i].rolename){
					//设置大区智能选择器
					$('#rgName').unbind('click');
					$('#rgName').click(function(){
						getRegionWithRole('rgName','p_region');
					});
 	 			}
 	 			//支持单负责人 控制
 				else if(ST_ROLE_NAME_STLEADER == data.userRoleList[i].rolename){
 	 				//填报人
 	 				$('#applicantName').unbind('click');
 					$('#applicantName').click(function(){
 	 					getUserofDept('applicantName','p_applicantId',null,[ST_ROLE_NAME_APPLICANT]);
 	 				});
 	 				//设置支持单负责人为本人
					$('#slName').val("<%=username%>");
					$('#p_supportLeaderId').val("<%=user.getUserid()%>");
					
					//设置大区智能选择器
					$('#rgName').unbind('click');
					$('#rgName').click(function(){
						getDict_item('rgName','p_region',ST_REGION_DICT_CODE);
					});
 	 			}
 	 			//全部导出
 				else if (ST_ROLE_NAME_DM == data.userRoleList[i].rolename){
 	 				//设置导出按钮
 	 				$('#export_btn').attr('disabled',false);
 	 				$('#export_btn').click(function(){
 	 	 				window.open(BUSNEISS_PATH+'/export_excel_supportTicket.action');
						
 	 	 			});
 	 			}
 	 			//区总
 				else if (data.userRoleList[i].rolename.indexOf('区总') != -1){
					//填报人
					$('#applicantName').unbind('click');
 					$('#applicantName').click(function(){
 	 					getUserofDept('applicantName','p_applicantId',gxdwbm,[ST_ROLE_NAME_APPLICANT]);
 	 				});
					
 					//设置大区智能选择器
 					$('#rgName').unbind('click');
					$('#rgName').click(function(){
						getRegionWithRole('rgName','p_region');
					});

					//支持单负责人选择器
					$('#slName').unbind('click');
 					$("#slName").click(function(){
 						getUserofDept('slName','p_supportLeaderId',null,[ST_ROLE_NAME_STLEADER]);
	 	 			});
 	 			}

 				
 			}
 			
 		},'json');
		
		
		
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
	 			$('#p_type').val(null);
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
											noSortColIndex:[6],
											changeHref:function(table){
												$("tr",table).each(function(){
													__tr = $(this);
													$(this).find("a[title=督办]").each(function(){
														var text = __tr.find('td').eq(5).text();
														if(text == '已完成' || text == '已中止'){
															/*
															$(this).removeAttr('href').css('color','gray');
															$(this).unbind('click');
															this.onclick=null;
															*/
															$(this).remove();
														}
															
													});
												});
											},
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
	/**
		详情展示
		
	*/ 
	function setDetail(id){
		dataid=id;
		detailDialog(detailid,detailWidth,detailURL);
	}

	/**
		督办
	*/
	function set_supervision(id){
		dataid=id;
		detailDialog(supervision_div,supervision_width,supervision_page);
	}	
</script>
	</head>
	<body>
		<input type="hidden" id="p_tag" value="">
<input type="hidden" id="t_userid" value="<%=user.getUserid() %>">
<input type="hidden" id="p_processorId" value=""/>
<div id="tsworksheet" class="bnbody">
	<div id="title" class="queryfont">
		技术支持单查询
	</div>
	<div id="contentCt">
		<div id="queryPanel">
			<div class="row">
				<div class="column column-width-default">
					<label class="label">支持单状态:</label>
					<select class="item" name="st.stStatus" id="p_stStatus">
						<option></option>
					</select>
					<div class="clear-column"></div>
				</div>
				<div class="column column-width-default">
					<label class="label">填报时间:</label>
						<input type="text" class="item date  inputstyle" id="p_applyDateFrom"></select>
<!--						<input type="hidden" value="" id="p_type">-->
					<div class="clear-column"></div>
				</div>
				<div class="column column-width-default">
					<label class="label">到:</label>
						<input type="text" class="item date  inputstyle" id="p_applyDateTo"></select>
					<div class="clear-column"></div>
				</div>
				
				<div class="clear-row"></div>
			</div>
			<div class="row">
				<div class="column column-width-default">
						<label class="label">申请人:</label>
						<input type="text" class="item inputstyle ro" id="applicantName">
						<input type="hidden" id="p_applicantId">
					<div class="clear-column"></div>
				</div>
				
				<div class="column column-width-default">
						<label class="label">技术支持单负责人:</label>
						<input type="text" class="item inputstyle ro readOnly" id="slName">
						<input type="hidden" id="p_supportLeaderId" name="p_supportLeaderId">
					<div class="clear-column"></div>
				</div>
				
				<div class="column column-width-default">
					<label class="label">大区/区域:</label>
					<input type="text" class="item inputstyle ro" id="rgName">
					<input type="hidden" id="p_region" name="p_regionCode">
					<div class="clear-column"></div>
				</div>
				
				<div class="clear-row"></div>
			</div>
			
			<div class="row">
				<div class="column column-width-default">
					<label class="label">技术支持部门:</label>
					<select class="item" id="p_departid" >
						<option></option>
					</select>
					
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<div class="row">
				<div class="column" style="width: 75%;">
					<div class="clear-column"></div>
				</div>
				<div class="column" style="width:25%;">
					<div class="column">
						<a href="#" class="item searchbutton " id="queryBtn">查  询</a>
						<div class="clear-column"></div>
					</div>
					<div class="column">
						<a href="#" class="item submitbutton" id="export_btn" style="margin-left: 10px;">全部导出</a>
						<div class="clear-column"></div>
					</div>
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
			     	<th name="l_supportLeader">技术支持单负责人</th>
			     	<th name="l_supportDept">技术支持部门</th>
			     	<th name="l_supportStatus">状态</th>
			     	<th name="">操作</th>
			    </tr>
			  </thead>
			</table>
			
		</div>
	</div>
<div id="detailCt" style="position: absolute; z-index: 1000; top:0px; left:160px; display: none;" class="page-layout"></div>
<div id="supervision_div" style="position: absolute; z-index: 1000; top:0px; left:160px; display: none;" class="page-layout"></div>
	</body>
</html>
