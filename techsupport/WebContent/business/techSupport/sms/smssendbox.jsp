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
var ingridHeight=200;
var stNoList;
function lazyLoad(){
		queryPanelHeight = $("#queryPanel").outerHeight(true);
		ingridHeight=pageHeight-queryPanelHeight
			-$('#title').outerHeight(true)
			-$('#mainDIV > table').eq(0).height()-58;
		loadPageSupportTicketQuery(divnid);
	
}

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
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		if($('#'+tableid).length == 0){
			$('#'+divnid).html($(queryTable));
		}
		var mygrid1 = $("#"+tableid).ingrid({ 
//										tableid:tableid,
										url: url,	
										height:ingridHeight,
										ingridPageWidth:1000,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                      	ingridPageParams:sXML,
                                      	onRowSelect:null,
                                      	noSortColIndex:[0],
                                      	hideColIndex:[8],
										pageNumber: pageno,
										colWidths: ["4%","14%","6%","12%","12%","12%","18%","18%","10%"]				
									});				
		}
}

//初始化加载
	$(function(){
		//延迟加载
		$("#email_detail").hide();
		daggleDiv('email_detail');
		setTimeout(lazyLoad,5);
		var sendSmsURL=BUSNEISS_PATH + "/sendSms_smsHint.action";
		divnid="queryContent";//查询内容容器ID
		tableid="queryContentTable";//查询内容格式表格ID
		pageUrl=BUSNEISS_PATH+ "/querylist_supportTicket.action";
		queryTable=$("#"+tableid);

		 $("#div_send").css({
				position: 'absolute',
				zIndex: 99999999,
				padding: 0,
				margin: 0,
				top: (pageHeight/2+20) + 'px',
				left: (pageWidth/2-120) + 'px'
			});
		$("#div_send").hide();
// 		lazyLoad();
// 		SupportTicketQuery(1);

		
		//设置申请人
		$('#applicantName').click(function(){
			getUserofDept('applicantName','p_applicantId',HTJD_DEPT_CODE);
		});
		//设置大区
		$('#rgName').click(function(){
			getDict_item('rgName','p_regionCode',ST_REGION_DICT_CODE);
		});
		//设置技术负责人
		$('#slName').click(function(){
			getUserofDept('slName','p_supportLeaderId',HTJD_DEPT_CODE);
		});
		
		
		 
// 		全选
		$('#selectAll').click(function(){
			if($(this).attr('checked')){
				$('input:checkbox[name=lSt.]').attr('checked',true);
			}
			else {
				$('input:checkbox[name=lSt.]').attr('checked',false);
			}
		});
		
		
// 		页面权限控制 
		$.post(BUSNEISS_PATH+"/smsRoleStatus_smsHint.action",null,function(data){
			//查询状态值
			var stStatus=data.smsStatus;
			if(stStatus==null || stStatus.length==0){
				$('#tsworksheet').html('<center>该角色不具有短信提示的权限</center>');
				return;
			}
			
//	 		设置状态下拉条
			$('#p_stStatus').selectBox({code:ST_STATUS_DICT_CODE});
			var optExpr="";
			for(i=0;i<stStatus.length;i++){
				optExpr+=" && "+"opt.val() != '"+stStatus[i]+"'";
			}
			optExpr=optExpr.substring(4	);
			selectBoxOption($('#p_stStatus'),{expr:optExpr});
			$('#div_p_stStatus').find('ul li:visible').eq(0).click();
//	 		初始化查询动作
			$('#queryBtn').click(function(){
				SupportTicketQuery(1);
			});
// 			设置发送短信按钮
			$('#sendSmsBtn').click(function(){
				var paramss={};
				var fields=$('input:checked[name^=lSt]');
				for(i=0;i<fields.length;i++){
					paramss[fields.eq(i).attr('name')]=fields.eq(i).val();
				}
				$.post(sendSmsURL,paramss,function(data){
					
					if(data.returnNO==0){
						alert(data.returnMsg);
					}
					else 
						jAlert(data.returnMsg,"提示");
				},'json');
			});
			//发送邮件
			$("#sendEmail").click(function(){
				var checkboxs=$("input[type='checkbox']");
				var fields=$('input:checked[name^=lSt]');
				stNoList=new Array();
				$(checkboxs).each(function(i){
					if($(this).attr('checked')){
						for(i=0;i<fields.length;i++){
							stNoList.push(fields.eq(i).val());
						}
					}
				});
				if(stNoList.length==0){
					jAlert('请先选择发送邮件的对象','提示信息');
					return;
				}
				setWidth('email_detail','800');
				setUrl('email_detail','business/techSupport/sms/emailSendBox.jsp');
				bindDocument('email_detail');
			});
			//导出数据并发送邮件
			$("#sendWord").click(function(){
				var paramss={};
				var checkboxs=$("input[type='checkbox']");
				var fields=$('input:checked[name^=lSt]');
				var paramObject=new Array();
				$(checkboxs).each(function(i){
					if($(this).attr('checked')){
						for(var i=0;i<fields.length;i++){
							//paramss[fields.eq(i).attr('name')]=fields.eq(i).val();
							paramObject.push(fields.eq(i).val());
						}
					}
				});
				for(var i=0;i<paramObject.length;i++){
					paramss['lSt['+i+'].id']=paramObject[i];
				}
				paramss['word.status']=$("#p_stStatus").val();
				/* $.post(BUSNEISS_PATH+'/createWord_word.action',paramss,function(data){
					alert(data.result);
				},'json'); */
				$("#div_send").show(); //打开 AJAX 等待动画
          		jQuery.ajax({
					type: 'POST',
					url: BUSNEISS_PATH+'/createWord_word.action',
					data: paramss,
					async: true,
					dataType: 'json',
					success: function(data){
						alert(data.result);
					},
					complete: function(){
						$("#div_send").hide(); //关闭 AJAX 等待动画
					}
				});
			});
			
			$('#sendSmsBtn').attr('disabled',false);
			$('#sendEmail').attr('disabled',false);
			$("#sendWord").attr('disabled',false);
		},'json');
		
		
	});
</script>

<div id="tsworksheet" class="bnbody">
	<%-- 使用最后更新时间查询 --%>
	<input type="hidden" id="p_use_last_update_day" value="1">
	<input type="hidden" id="p_tag" value="dxts">
	<div id="title" class="queryfont">
		短信提示
	</div>
	<div id="contentCt">
		<div id="queryPanel">
			<div class="row">
				<div class="column pagedistd">
					<label class="label">支持单状态:</label>
					<div class="item">
						<select class="item inputstyle" name="st.stStatus" id="p_stStatus"></select>
					</div>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
			<div class="row">
				<div class="column pagedistd">
					<div>
						<label class="label">申请人:</label>
						<input type="text" class="item inputstyle" id="applicantName">
						<input type="hidden" id="p_applicantId" name="st.applicant.userid">
					</div>
					<div class="clear-column"></div>
				</div>
				
				<div class="column pagedistd">
					<div>
						<label class="label">技术负责人:</label>
						<input type="text" class="item inputstyle" id="slName">
						<input type="hidden" id="p_supportLeaderId" name="p_supportLeaderId">
					</div>
					<div class="clear-column"></div>
				</div>
				
				<div class="column pagedistd">
					<label class="label">大区/区域:</label>
					<input type="text" class="item inputstyle" id="rgName">
					<input type="hidden" id="p_regionCode" name="p_regionCode">
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
			    	<th name="l_checkbox"><input type="checkbox" id="selectAll"></th>
			     	<th name="l_stNo">支持单编号</th>
			     	<th name="l_region">大区/区域</th>
			     	<th name="l_applicant">申请人</th>
			     	<th name="l_supportLeader">技术支持单负责人</th>
			     	<th name="l_supportDept">技术支持部门</th>
			     	<th name="l_supportContent">支持单内容</th>
			     	<th name="l_trackingProcess">当前进展</th>
			    </tr>
			  </thead>
			</table>
			
		</div>
	</div>
	<div id="email_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>
	<div id="footerCt">
		<center >
			<span>
				<input type="button" id="sendSmsBtn" class="searchbutton" value="短信提示" disabled="disabled">
				<input type="button" id="sendEmail" class="searchbutton" value="发送邮件" disabled="disabled">
				<input type="button" id="sendWord" class="searchbutton" value="导出并发送" disabled="disabled">
			</span>
		</center>
	</div>
	<div id=div_send style="position:absolute; background:url(images/loadingbg.gif); width:243px; height:55px;font-size:13px; font-weight:bold; color:#666666;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td height="17px;"></td></tr>
		<tr><td width="15"></td>
		    <td><img src="images/loading.gif"/></td>
		    <td>发送中，请稍候......</td>
		</tr>
		</table>
	</div>
