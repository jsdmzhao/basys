<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	cf_pageUrl="publicsystem/querylistForRy_ryjcxx.action";
	cf_divnid="rycfxxData";
	cf_tableid="rycfxxTable";
	
	cf_modHtml="basic/publicsystem/RyjcxxModify.jsp";
	cf_modUrl="publicsystem/modify_ryjcxx.action";
	cf_modWidth="550";
	cf_detailHtml="basic/publicsystem/RyjcxxDetailjc.jsp";
	cf_detailid="rycfxx_detail";
	cf_detailWidth="600";
	cf_detailUrl="publicsystem/queryForby_ryjcxx.action";
	
	cf_delUrl="publicsystem/delete_ryjcxx.action";
	
	cf_delid="f_rycfid";
	//detailHtml="business/Ylfwzagl/rycfxxDetail.jsp";
	//detailid="rycfxx_detail";
	//detailUrl="ylfwzagl/query_rycfxx.action";
	//detailWidth="500";
	
	
	
	$("#p_ryjcrqf").attr("readonly","true");
	$("#p_ryjcrqf").datepicker();
	$("#p_ryjcrqt").attr("readonly","true");
	$("#p_ryjcrqt").datepicker();
	
	$("#p_cflbbm").selectBox({code:"dm_jclb"});
	daggleDiv("rycfxx_detail");
	cf_loadPage(cf_divnid);
}); 
function cf_loadPage(divpageid){
	cf_tables=$("#"+divpageid).html();
	$("#rycfxx_detail").hide(); 	
	//查轨迹信息 根据证件号码去查询下
		$("#p_ryid").attr("value",dataid);	
		cf_setPageList(1);//默认去查询下
}	

function cf_setList(pageno,url){
	$("#rycfxxData").html(cf_tables);	
	createXML("p_");
	if (url==null || url=="undefined"){
		url=cf_pageUrl;
	}
	return url;
}	

function cf_setPageList(pageno,url){	
	if (manVerify()){
		url=cf_setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+cf_tableid).ingrid({ 
										url: url,
										ingridPageWidth:800,	
										ingridPageParams:sXML,
										onRowSelect: function(tr, selected){
											var str = selected ? 'SELECTED' : 'UNSELECTED';
											if(sFlag=="true"){
												if ($(tr).attr('_selected')=="true"){
													setQuery_rycf($(tr).attr("id")); 	
												}
											}else{
												sFlag="true";
											}
											rowselect=$(tr).attr('rowindex');
										},
										height: pageHeight - 250,
										pageNumber: pageno,
										colWidths: ["16%","16%","16%","16%","16%","20%"]									
									});				
		}
}	

function manVerify(){
	return true;
}
	
	//选择场所
$("#p_qymc").click(function(){
	getYlcs_item("p_qymc","p_qyid","");
});

function setDetail_rycf(){
	setParams("q_");
	jQuery.post(cf_detailUrl,params,updatediv,"json");
}

function setQuery_rycf(id){
	$("#"+cf_detailid).empty();
	dataid=id;
	$("#"+cf_detailid).css("width",cf_detailWidth);
	$("#"+cf_detailid).css("left",100);
	setUrl(cf_detailid,cf_detailHtml);
}

function setUpdate_rycf(id){
	sFlag="false";
	dataid = id;
	$("#"+cf_detailid).css("width",cf_modWidth);
	$("#"+cf_detailid).css("left",100);
	setUrl(cf_detailid,cf_modHtml);
}

function setDelete_rycf(id){
	sFlag="false";
	jConfirm('确定删除吗？', '删除提示', function(r) {
    	if(r==true){
			$("#"+cf_delid).attr("value",id);
			setParams("f_");
	        jQuery.post(cf_delUrl,params,deleteback_rycf,"json");
		}else{
		   return false;
		}
	});
}

function deleteback_rycf(json){
	if  (json.result=="success"){
		jAlert(delMessage,'提示信息');
		var pageno=$("#pageNo").attr("value");
		if ($("#startno").html()==$("#endno").html()){
			if ($("#pageNo").attr("value")>1){
				pageno=""+(parseInt(pageno)-1);
			}
		}
		cf_setPageList(pageno);
	}else{
		jAlert(json.result,'错误信息');
	}	
}
</script>
<html>
	<body>

		<input type="hidden" id="f_rycfid" value="">
		<input type="hidden" id="p_ryid">
		<input type="hidden" id="p_qyid">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" class="title1">
					人员奖惩查询
				</td>
				<td align="right" class="title1">
					<a href="#" id="closeDiv"
						onclick='$("#cyryxx_detail").hideAndRemove(&quot;show&quot;);relsetDetailUrl();'
						class="close"></a>
				</td>
			</tr>
		</table>
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="3"></td>
			</tr>
		</table>
		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td colspan="2" class="queryfont">
					人员奖惩查询
				</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="99%" border="0" cellspacing="0" cellpadding="2">
						<tr>

							<td class="distd" width="10%">
								奖惩类别
								</td>
							<td class="detailtd" width="23%">
								<select type="select" id="p_cflbbm">
									<option></option>
								</select>
							</td>
							<td width="10%" class="pagedistd">
								奖惩日期
							</td>
							<td width="56%" class="pagetd">
								<input type="text" class="inputstyle" id="p_ryjcrqf" value="">
								至
								<input type="text" class="inputstyle" id="p_ryjcrqt" value="">
							</td>
							<td width="8%" class="pagetd">
								<table width="60" border="0" align="right" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="28px">
											<a href="#" class="searchbutton" id="querys"
												onClick="cf_setPageList(1);">查询</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="3"></td>
			</tr>
		</table>
		<div id="rycfxx_detail" class="page-layout" src="#"
			style="top:180px; left:0px; width:500px;">
		</div>

		<div id="rycfxxData" style="width:100%;">
			<table id="rycfxxTable" width="100%">
				<thead>
					<tr>
						<th name="l_cflb">
							奖惩类别
						</th>
						<th name="l_pzjg">
							批准机构
						</th>
						<th name="l_pzrxm">
							批准人姓名
						</th>
						<th name="l_zxrxm">
							执行人姓名
						</th>
						<th name="l_ryjcrq">
							奖惩日期
						</th>
						<th name="">
							操作
						</th>
					</tr>
				</thead>
			</table>
		</div>
	</body>
</html>
