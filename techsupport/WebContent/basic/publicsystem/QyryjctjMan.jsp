<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

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
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>publicsystem/querylist_qyryjctj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LQyryjctj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'jzrqJczs', type: 'int'}, 
			 {name: 'jzrqCfzs', type: 'int'},
			 {name: 'jzrqJlzs', type: 'int'},
             {name: 'zqnJczs', type: 'int'},
             {name: 'zqnCfzs', type: 'int'}, 
             {name: 'jg', type: 'int'}, 
             {name: 'fk', type: 'int'}, 
             {name: 'jl', type: 'int'}, 
             {name: 'jlbfk', type: 'int'}, 
             {name: 'zjxszr', type: 'int'}, 
             {name: 'xqcjhqzcj', type: 'int'}, 
             {name: 'qtfklx', type: 'int'},  
             {name: 'zqnJlzs', type: 'int'}, 
             {name: 'tbbycs', type: 'int'},  
             {name: 'wzjlcs', type: 'int'}, 
             {name: 'qtjlcs', type: 'int'}]}
);
		
dataStore.on('load', function(store, records, options ) {
});

$(document).ready(function() {
		ksd_csxxtjInit();
		initTJDate();
		$("#t_qsrq").attr("readonly","true").datepicker();
		$("#t_jzrq").attr("readonly","true").datepicker();
		$("#t_qsrq").attr("value",tomorrowDate);
	    $("#t_jzrq").attr("value",currentDate);
		// 行业类别选择框
	    $("#t_hylbdm").selectBoxhylb({code:"flgy"});
		//设定表格高度
	    $("#tabledata").height(pageHeight-212); 
});

function qyryjctjYMSSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    qyryjctjYMSSetParams();
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
	        $("#l_zqnxz").before("<td width='81' id='l_dsjgmc' rowspan='3' class='grid-header-bg1'>市局</td>");
	        $("#zqnJczs").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='107' id='l_fxjgmc' rowspan='3' class='grid-header-bg1'>分县局公安机关</td>");
	       $("#zqnJczs").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='87' id='l_gxdwmc' rowspan='3' class='grid-header-bg1'>派出所</td>");
	        $("#zqnJczs").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	    }
	    if($("#t_dsjgbz").attr("value")=="0"){
	        $("#l_zqnxz").before("<td width='81' id='l_gatmc' rowspan='3' class='grid-header-bg1'>省厅</td>");
	        $("#zqnJczs").before("<td class='grid-header-hbbg' valign='top' id='gatmc' property='gatmc' groupid='gatmc'>"+departName+"</td>");
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

<input type="hidden" id="t_dsjgbz" value="0">
<input type="hidden" id="t_dsjgdm">
<input type="hidden" id="t_fxjbz" value="0">
<input type="hidden" id="t_fxjdm">
<input type="hidden" id="t_gxdwbz" value="0">
<input type="hidden" id="t_gxdwdm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">人员奖惩统计</td>
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
		<tr>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qsrq"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzrq"></td>
			<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
		</tr>
		<tr>
			<td class="pagetd" colspan="6">
			<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
			<tr>
			<td><a href="#" class="searchbutton" id="querys2" onClick="loadData();">查询</a></td>
			<td><a href="#" class="exceldcbutton" onClick="expExcel('datatable',19,3);" id="csxxExcel">导出</a></td>
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
<div id="tabledata" class="scrollbarface" style="overflow-y:scroll;height:500; border:1px #d8dbec solid;border-right:0px;">
<table width="1002"  cellpadding="3" style="border-collapse:collapse;" cellspacing="0"  id="datatable" >
   <tr>
         <td width="81" rowspan="3" class="grid-header-bg1"  id="l_dsjgmc"  >市局</td>
         <td width="107" rowspan="3" class="grid-header-bg1" id="l_fxjgmc"   >分县局公安机关</td>
         <td width="87" rowspan="3" class="grid-header-bg1" id="l_gxdwmc"   >派出所</td>
        <td width="364" colspan="13"   class="grid-header-bg1" id="l_zqnxz">周期内新增</td>
        <td width="363"  colspan="3"  class="grid-header-bg1" id="l_zjzrq">至截止日期</td>
      </tr>
	    <tr>
		  <td rowspan="2"  class="grid-header-bg1" id="l_zqnJczs">奖惩总数</td>
		  <td colspan="8"  class="grid-header-bg1" id="l_zqnCf">处罚</td>
		  <td colspan="4"  class="grid-header-bg1" id="l_zqnJl">奖励</td>
		  <td rowspan="2"  class="grid-header-bg1" id="l_jzrqJczs">奖惩总数</td>
          <td rowspan="2"  class="grid-header-bg1" id="l_jzrqCfzs">处罚总数</td>
		  <td rowspan="2"  class="grid-header-bg1" id="l_jzrqJlzs">奖励总数</td>
	    </tr>
	    <tr>
            <td id="l_zqnCfzs" class="grid-header-bg1" >处罚总数</td>
            <td id="l_jg" class="grid-header-bg1" >警告</td>
	     	<td id="l_fk" class="grid-header-bg1" >罚款</td>
	     	<td id="l_jl" class="grid-header-bg1" >拘留</td>
	     	<td id="l_jlbfk" class="grid-header-bg1" >拘留并罚款</td>
	     	<td id="l_zjxszr" class="grid-header-bg1" >追究刑事责任</td>
	     	<td id="l_xqcjhqzcj" class="grid-header-bg1" >限期出境或驱逐出境</td>
	     	<td id="l_qtfklx" class="grid-header-bg1" >其他处罚</td>
	     	<td id="l_zqnJlzs" class="grid-header-bg1" >奖励总数</td>
	     	<td id="l_tbbycs" class="grid-header-bg1" >通报表扬</td>
	     	<td id="l_wzjlcs" class="grid-header-bg1" >物质奖励</td>
	     	<td id="l_qtjlcs" class="grid-header-bg1" >其他奖励</td>
	    </tr>
        <tr entityclass="temp"  edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc" property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc" property="fxjmc" groupid="fxj" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw" mergeblank="true"></td>
        <td class="grid-header-hbbg" id="zqnJczs"  property="zqnJczs"></td>
        <td class="grid-header-hbbg" id="zqnCfzs"  property="zqnCfzs"></td>
        <td class="grid-header-hbbg" id="jg"  property="jg"></td>
        <td class="grid-header-hbbg" id="fk"  property="fk"></td>
        <td class="grid-header-hbbg" id="jl"  property="jl"></td>
        <td class="grid-header-hbbg" id="jlbfk"  property="jlbfk"></td>
        <td class="grid-header-hbbg" id="zjxszr"  property="zjxszr"></td>
        <td class="grid-header-hbbg" id="xqcjhqzcj"  property="xqcjhqzcj"></td>
        <td class="grid-header-hbbg" id="qtfklx"  property="qtfklx"></td>
        <td class="grid-header-hbbg" id="zqnJlzs"  property="zqnJlzs"></td>
        <td class="grid-header-hbbg" id="tbbycs" property="tbbycs"></td>
        <td class="grid-header-hbbg" id="wzjlcs"  property="wzjlcs"></td>
        <td class="grid-header-hbbg" id="qtjlcs" property="qtjlcs"></td>
        <td class="grid-header-hbbg" id="jzrqJczs"  property="jzrqJczs"></td>
        <td class="grid-header-hbbg" id="jzrqCfzs" property="jzrqCfzs"></td>
        <td class="grid-header-hbbg" id="jzrqJlzs"  property="jzrqJlzs"></td>
      </tr>
	</table>	
</div>
</body>
</html>