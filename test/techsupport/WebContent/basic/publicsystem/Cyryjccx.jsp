<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	cf_pageUrl="publicsystem/querylistForRyjc_ryjcxx.action";
	cf_divnid="rycfxxData";
	cf_tableid="rycfxxTable";
	
	cf_modHtml="basic/publicsystem/RyjcxxModify.jsp";
	cf_modUrl="publicsystem/modify_ryjcxx.action";
	cf_modWidth="500";
	cf_detailHtml="basic/publicsystem/RyjcxxDetailjc.jsp";
	cf_detailid="rycfxx_detail";
	cf_detailWidth="500";
	cf_detailUrl="publicsystem/queryForby_ryjcxx.action";
	
	cf_delUrl="publicsystem/delete_ryjcxx.action";
	
	cf_delid="f_rycfid";
	//detailHtml="business/Ylfwzagl/rycfxxDetail.jsp";
	//detailid="rycfxx_detail";
	//detailUrl="ylfwzagl/query_rycfxx.action";
	//detailWidth="500";
	
	
	cf_loadPage(cf_divnid);
	$("#p_ryjcrqf").attr("readonly","true");
	$("#p_ryjcrqf").datepicker();
	$("#p_ryjcrqt").attr("readonly","true");
	$("#p_ryjcrqt").datepicker();
	// 行业类别	
	$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
	//与奖惩类别联动
	$("#p_cflbbm").selectBox({code:"dm_jclb"});
	$("#p_jcmxlbdm").selectBox({code:"1"});//明细 处罚
	$("#p_cflbbm").change(function(){
		if($("#p_cflbbm").val()==0){
			$("#p_jcmxlbdm").selectBox({code:"dm_ryjllb"});//明细 奖励
		}
		if($("#p_cflbbm").val()==1){
			$("#p_jcmxlbdm").selectBox({code:"dm_rycflb"});//明细 处罚
		}
		if($("#p_cflbbm").val()==''){
			$("#p_jcmxlbdm").selectBox({code:"1"});//明细 处罚
		}
	});
	$("#p_jcmxlbdm").change(function(){
		$("#p_jcmxlb").val($("#a_jcmxlbdm").attr('title'));
	});
	// 根据行业类别设定表示信息
	setHyxx();
	daggleDiv("rycfxx_detail");
}); 
function cf_loadPage(divpageid){
	cf_tables=$("#"+divpageid).html();
	$("#rycfxx_detail").hide(); 	
	//查轨迹信息 根据证件号码去查询下
	cf_setPageList(1,'#');
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
										height: pageHeight - 256,
										pageNumber: pageno,
										colWidths: ["12%","11%","11%","11%","11%","11%","11%","11%","11%"]									
									});		
		setHyxx();		
		}
}	

function manVerify(){
	return true;
}
	
	 //企业筛选框
 $("#p_qymc").click(function(){
 dataid=$('#p_hylbdm').val();
	getTy_item("p_qymc","p_qybm");
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
//设定行业信息表示
    function setHyxx(){
        var hylb=$("#p_hylbdm").val();
		if(hylb=='J'){
			$('#td_qymc').text('场所名称');
			$('#td_qybm').text('场所备案编号');
			$('#rycfxxData').find('thead').find('th[@name=l_qymc]').find('DIV').html('场所名称');
			$('#rycfxxData').find('thead').find('th[@name=l_qybm]').find('DIV').html('场所备案编号');
		}else{
		    $('#td_qymc').text('企业名称');
		    $('#td_qybm').text('企业编号');
			$('#rycfxxData').find('thead').find('th[@name=l_qymc]').find('DIV').html('企业名称');
			$('#rycfxxData').find('thead').find('th[@name=l_qybm]').find('DIV').html('企业编号');
		}
    }
</script>
<html>
	<body>

		<input type="hidden" id="f_rycfid" value="">
		<input type="hidden" id="p_ryid">
		<input type="hidden" id="p_qyid">
		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td colspan="2" class="queryfont">
					从业人员处罚/奖励查询
				</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="99%" border="0" cellspacing="0" cellpadding="2">
					    <tr>
					        <td width="10%" class="pagedistd">
								行业类别
							</td>
							<td width="27%" class="pagetd">
								<select name="hylb" id="p_hylbdm"  onchange="setHyxx();">
								</select>
							</td>
					        <td width="10%" class="pagedistd" id="td_qybm">
								场所备案编号
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_qybm">
							</td>
							<td width="10%" class="pagedistd" id="td_qymc">
								场所名称
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" readonly="readonly"
									id="p_qymc" value="">
							</td>
						</tr>
					    <tr>
							<td width="10%" class="pagedistd">
								姓名
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_xm" value="">
							</td>
							<td class="distd" width="10%">
								奖惩类别
								</td>
							<td class="detailtd" width="23%">
								<select type="select" id="p_cflbbm">
									<option></option>
								</select>
							</td>		
							<td class="distd" width="10%">
								奖惩明细
								</td>
							<td class="detailtd" width="23%">
								<select type="select" id="p_jcmxlbdm">
									<option></option>
								</select>
							</td>							
						</tr>
						<tr>
							<td width="10%" class="pagedistd">
								奖惩日期
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_ryjcrqf" value="">
							</td>
							<td width="10%" class="pagedistd">
								至
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_ryjcrqt" value="">
							</td>
							<td width="8%" colspan="2" class="pagetd">
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
					    <th name="l_qybm">
							场所备案编号
						</th>
						<th name="l_qymc">
							场所名称
						</th>
						<th name="l_xm">
							姓名
						</th>
						<th name="l_cflb">
							奖惩类别
						</th>
						<th name="l_jcmxlb">
							奖惩明细
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
					</tr>
				</thead>
			</table>
		</div>
	</body>
</html>
