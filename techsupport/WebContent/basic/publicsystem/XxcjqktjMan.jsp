<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="java.util.Date,java.text.SimpleDateFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";


Date date = new Date();
SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
String strDate = sdfs.format(date);
%>
<jsp:include page="../../public/publicGADTJ.jsp" flush="true"></jsp:include>
<html>
<head>
<script language="javascript" type="text/javascript" src="<%=basePath%>javascript/jquery/plugs/jquery.TableConfig.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath%>javascript/jquery/plugs/jquery.MappingTable.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath%>javascript/excel.js" charset="utf-8"></script>
<script type="text/javascript">
var optionItemConfig;
var tableConfigs;

var dataStore = new Ext.data.JsonStore({	
	id: 'dataStore',
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>publicsystem/xxcjqkTJ_qyfltj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LQyfltj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'qczlqy', type: 'int'}, 
			 {name: 'qczlry', type: 'int'},
			 {name: 'escqy', type: 'int'},
             {name: 'escry', type: 'int'},
             {name: 'esjqy', type: 'int'}, 
             {name: 'esjry', type: 'int'}, 
             {name: 'jxqy', type: 'int'}, 
             {name: 'jxry', type: 'int'}, 
             {name: 'czcqy', type: 'int'}, 
             {name: 'czcry', type: 'int'}]}
);
		
dataStore.on('load', function(store, records, options ) {
});

$(document).ready(function() {
    // 初期化关联管辖单位控件
    ksd_csxxtjInit();
    // 初期化日期控件
    initTJDate();
    $("#t_qsrq").attr("readonly","true").datepicker();
	$("#t_jzrq").attr("readonly","true").datepicker();
	$("#t_qsrq").attr("value",tomorrowDate);
	$("#t_jzrq").attr("value",currentDate);
	//设定表格高度
	$("#tabledata").height(pageHeight-187); 
	$("#zbdw").html(departName);
}); 
function xxcjqktjSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    xxcjqktjSetParams();
	    // 清空上次结果
	    if(dataStore.getCount()>0){
	        $("#datatable").find('tr').each(function(i){
	            removeOneRow($(this));
	        });
	    }
	    $("#l_dsjgmc").remove();
	    $("#l_fxjgmc").remove();
	    $("#l_gxdwmc").remove();
	    $("#l_gatmc").remove();
	    $("#dsjgmc").remove();
	    $("#fxjmc").remove();
	    $("#gxdwmc").remove();
	    $("#gatmc").remove();
	    
	    if($("#t_dsjgbz").attr("value")=="1"){
	        $("#l_qczl").before("<td width='47' id='l_dsjgmc' rowspan='2' class='grid-header-bg1'>市局</td>");
	        $("#qczlqy").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	        $("#l_department").attr("colspan",11);
	        $("#l_date").attr("colspan",11);
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_qczl").before("<td width='100' id='l_fxjgmc' rowspan='2' class='grid-header-bg1'>分县局公安机关</td>");
	       $("#qczlqy").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	       $("#l_department").attr("colspan",12);
	       $("#l_date").attr("colspan",12);
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_qczl").before("<td width='55' id='l_gxdwmc' rowspan='2' class='grid-header-bg1'>派出所</td>");
	        $("#qczlqy").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	        $("#l_department").attr("colspan",13);
	        $("#l_date").attr("colspan",13);
	    }
	    if($("#t_dsjgbz").attr("value")=="0"){
	        $("#l_qczl").before("<td width='47' id='l_gatmc' rowspan='2' class='grid-header-bg1'>省厅</td>");
	        $("#qczlqy").before("<td class='grid-header-hbbg' valign='top' id='gatmc' property='gatmc' groupid='gatmc'>"+departName+"</td>");
	        $("#l_department").attr("colspan",11);
	        $("#l_date").attr("colspan",11);
	    }
        // 取得表的配置信息
	    tableConfigs = $.parseConfig($("#datatable"));    
	    // 取得远程数据到JsonStore
	    dataStore.load({
	        callback :function(r,options,success){   
                if(success){
                    // 绑定数据到table 
                    loadDataToTable();
                }else{
                    alert("加载数据失败，无对应数据或者系统出现异常！"); 
                }
            }   
	    });
    }
}
function loadDataToTable(){
    $("#datatable").loadData(dataStore, tableConfigs, {
	    mode: 'row',
	    entityclass: 'temp'
	});
}
function removeOneRow(obj) {
    $("#datatable").removeRow(obj, tableConfigs, {
	    entityclass: 'temp'
	});
}
 // 校验
function manVerify(){
    if (!checkControlValue("t_qsrq","Date",null,null,null,1,"起始日期"))
	    return false;
	if (!checkControlValue("t_jzrq","Date",null,null,null,1,"截止日期"))
		return false;
    var t_qssj = $("#t_qsrq").attr("value");
	var t_jzsj = $("#t_jzrq").attr("value");
	if(t_qssj!=''&&t_jzsj!=''&&formatDate(t_qssj)-formatDate(t_jzsj)>0){
		jAlert("请正确选择起始和截至日期!","提示信息");
		return false;
	}
	return true;
}
	// 转换成日期格式
function formatDate(strDate){ 
	var riqi = strDate.split("-");
	return new Date(riqi[0],(riqi[1]-1),riqi[2]);
}
</script>
</head>
<body>
<input type="hidden" id="k_deptCode">
<input type="hidden" id="t_dsjgbz" value="">
<input type="hidden" id="t_dsjgdm">
<input type="hidden" id="t_fxjbz" value="">
<input type="hidden" id="t_fxjdm">
<input type="hidden" id="t_gxdwbz" value="">
<input type="hidden" id="t_gxdwdm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">信息采集情况统计</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr id="gajgAll">
			<td width="10%" class="pagedistd">
			<input dataKey="dsjgdm" type="checkbox" id="ch_dsjgdm" onClick="ksd_gajgSelect(this);"/>市级公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_dsjgdm" onChange="ksd_dsjgdmOnchange();"><option>全部</option></select>
			</td>
			<td width="10%" class="pagedistd">
			<input dataKey="fxjdm" type="checkbox" id="ch_fxjdm" onClick="ksd_gajgSelect(this);">分县局公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_fxjdm" onChange="ksd_fxjdmOnchange();"><option>全部</option></select></td>
			<td width="10%" class="pagedistd">
			<input dataKey="gxdwdm" type="checkbox" id="ch_gxdwdm" onClick="ksd_gajgSelect(this);">科所队</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_gxdwdm" onChange="ksd_gxdwdmOnchange();"><option>全部</option></select></td>
		</tr>
		<tr id="cszflAll">
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qsrq"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzrq"></td>
			<td width="23%" class="pagetd" colspan="2">
				<table border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" onClick="loadData();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="expExcel('datatable',13,4);" id="csxxExcel">导出</a></td>
				</tr>
				</table>
			</td>
		</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="tabledata" class="scrollbarface"    style="overflow-y:scroll;height:500; border:1px #d8dbec solid;border-right:0px;">
	<table width="1002"  cellpadding="3" style="border-collapse:collapse;" cellspacing="0"  id="datatable" >
	  <thead>
        <tr>
         <td align="left" colspan="13" class="grid-header-bg1"  id='l_department'>制表单位：<span id="zbdw"></span></td>
        </tr>
        <tr>
          <td align="left" colspan="13" class="grid-header-bg1"  id='l_date'>制表时间：<%=strDate %></td>
        </tr>
         <tr>
         <td width="47"  id='l_dsjgmc' rowspan="2" class="grid-header-bg1">市局</td>
         <td width="100" id='l_fxjgmc' rowspan="2" class="grid-header-bg1">分县局公安机关</td>
         <td width="55"  id='l_gxdwmc' rowspan="2" class="grid-header-bg1">派出所</td>
         <td id='l_qczl'  colspan="2" class="grid-header-bg1">汽车租赁业</td>
         <td id='l_esc'  colspan="2" class="grid-header-bg1">二手车交易业</td>
         <td id='l_esj'  colspan="2" class="grid-header-bg1">二手手机交易业</td>
         <td id='l_jx'  colspan="2" class="grid-header-bg1">机动车修理业</td>
          <td id='l_czc'  colspan="2" class="grid-header-bg1">出租车管理</td>
        </tr>
	    <tr>
	    <td width="55"  class="grid-header-bg1" id='l_qczlqy'>企业</td>
        <td width="80"   class="grid-header-bg1" id='l_qczlry'>从业人员</td>
		<td width="49"  class="grid-header-bg1" id='l_escqy'>企业</td>
		<td width="90"   class="grid-header-bg1" id='l_escry'>从业人员</td>
		<td width="59"  class="grid-header-bg1" id='l_esjqy'>企业</td>
		<td width="94"  class="grid-header-bg1" id='l_esjry'>从业人员</td>
		<td width="46"  class="grid-header-bg1" id='l_jxqy'>企业</td>
		<td width="88"  class="grid-header-bg1" id='l_jxry'>从业人员</td>
		<td width="64"  class="grid-header-bg1" id='l_czcqy'>企业</td>
		<td width="95"  class="grid-header-bg1"  id='l_czcry'>从业人员</td>
	    </tr>
	  </thead>
	  <tr entityclass="temp" edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc" property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc" property="fxjmc" groupid="fxj" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw" mergeblank="true"></td>
        <td class="grid-header-hbbg" id="qczlqy" property="qczlqy"></td>
        <td class="grid-header-hbbg" id="qczlry" property="qczlry"></td>
        <td class="grid-header-hbbg" id="escqy" property="escqy"></td>
        <td class="grid-header-hbbg" id="escry" property="escry"></td>
        <td class="grid-header-hbbg" id="esjqy" property="esjqy"></td>
        <td class="grid-header-hbbg" id="esjry" property="esjry"></td>
        <td class="grid-header-hbbg" id="jxqy" property="jxqy"></td>
        <td class="grid-header-hbbg" id="jxry" property="jxry"></td>
        <td class="grid-header-hbbg" id="czcqy" property="czcqy"></td>
        <td class="grid-header-hbbg" id="czcry" property="czcry"></td>
      </tr>
	</table>
</div>
</body>
</html>