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
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>publicsystem/querylist_qyfltj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LQyfltj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'gwyl', type: 'int'}, 
			 {name: 'gwylT', type: 'int'},
			 {name: 'hj', type: 'int'},
             {name: 'hjT', type: 'int'},
             {name: 'mrmfzy', type: 'int'}, 
             {name: 'mrmfzyT', type: 'int'}, 
             {name: 'qtfwcs', type: 'int'}, 
             {name: 'qtfwcsT', type: 'int'}, 
             {name: 'qtylcs', type: 'int'}, 
             {name: 'qtylcsT', type: 'int'}, 
             {name: 'snxyam', type: 'int'}, 
             {name: 'snxyamT', type: 'int'},  
             {name: 'yysdzyxt', type: 'int'}, 
             {name: 'yysdzyxtT', type: 'int'}]}
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
	///$("#t_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框
	//设定表格高度
	$("#tabledata").height(pageHeight-212); 
}); 
function qyfltjSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    qyfltjSetParams();
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
	        $("#l_zqnxz").before("<td width='81' id='l_dsjgmc' rowspan='2' class='grid-header-bg1'>市局</td>");
	        $("#hj").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='107' id='l_fxjgmc' rowspan='2' class='grid-header-bg1'>分县局公安机关</td>");
	       $("#hj").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='87' id='l_gxdwmc' rowspan='2' class='grid-header-bg1'>派出所</td>");
	        $("#hj").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	    }
	    if($("#t_dsjgbz").attr("value")=="0"){
	        $("#l_zqnxz").before("<td width='81' id='l_gatmc' rowspan='2' class='grid-header-bg1'>省厅</td>");
	        $("#hj").before("<td class='grid-header-hbbg' valign='top' id='gatmc' property='gatmc' groupid='gatmc'>"+departName+"</td>");
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
<input type="hidden" id="t_gwylbz">
<input type="hidden" id="t_jbbz">
<input type="hidden" id="t_glxxhdcsbz">
<input type="hidden" id="t_yysdzyxtbz">
<input type="hidden" id="t_snxybz">
<input type="hidden" id="t_ambz">
<input type="hidden" id="t_zsbz">
<input type="hidden" id="t_wsfwbz">
<input type="hidden" id="t_qtbz">
<input type="hidden" id="t_hylbdm" value="J">

<input type="hidden" id="t_dsjgbz" value="">
<input type="hidden" id="t_dsjgdm">
<input type="hidden" id="t_fxjbz" value="">
<input type="hidden" id="t_fxjdm">
<input type="hidden" id="t_gxdwbz" value="">
<input type="hidden" id="t_gxdwdm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">场所信息统计(按分类)</td>
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
			<!--
			<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
			-->
		</tr>
		<tr>
		  <td width="23%" class="pagetd" colspan="6">
				<table border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" onClick="loadData();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="expExcel('datatable',17,2);" id="csxxExcel">导出</a></td>
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
         <td width="81"  id='l_dsjgmc' rowspan="2" class="grid-header-bg1">市局</td>
         <td width="107" id='l_fxjgmc' rowspan="2" class="grid-header-bg1">分县局公安机关</td>
         <td width="87"  id='l_gxdwmc' rowspan="2" class="grid-header-bg1">派出所</td>
         <td width="364" id='l_zqnxz'  colspan="7" class="grid-header-bg1">周期内新增</td>
         <td width="363" id='l_zjzrq'  colspan="7" class="grid-header-bg1">至截止日期</td>
        </tr>
	    <tr>
		<td  class="grid-header-bg1" id='l_hj'>场所总数</td>
		<td  class="grid-header-bg1" id='l_gwyl'>歌舞娱乐</td>
		<td  class="grid-header-bg1"  id='l_yysdzyxt'>游艺场所</td>
		<td  class="grid-header-bg1" id='l_qtylcs'>其他娱乐场所</td>
		<td  class="grid-header-bg1" id='l_snxyam'>桑拿洗浴按摩</td>
		<td   class="grid-header-bg1" id='l_mrmfzy'>美容美发足浴</td>
		<td  class="grid-header-bg1" id='l_qtfwcs'>其他服务场所</td>
		<td  class="grid-header-bg1" id='l_hjT'>场所总数</td>
        <td   class="grid-header-bg1" id='l_gwylT'>歌舞娱乐</td>
		<td  class="grid-header-bg1" id='l_yysdzyxtT'>游艺场所</td>
		<td   class="grid-header-bg1" id='l_qtylcsT'>其他娱乐场所</td>
		<td  class="grid-header-bg1" id='l_snxyamT'>桑拿洗浴按摩</td>
		<td  class="grid-header-bg1" id='l_mrmfzyT'>美容美发足浴</td>
		<td  class="grid-header-bg1" id='l_qtfwcsT'>其他服务场所</td>
	    </tr>
	  </thead>
	  <tr entityclass="temp" edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc" property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc" property="fxjmc" groupid="fxj" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw" mergeblank="true"></td>
        <td class="grid-header-hbbg" id="hj" property="hj"></td>
        <td class="grid-header-hbbg" id="gwyl" property="gwyl"></td>
        <td class="grid-header-hbbg" id="yysdzyxt" property="yysdzyxt"></td>
        <td class="grid-header-hbbg" id="qtylcs" property="qtylcs"></td>
        <td class="grid-header-hbbg" id="snxyam" property="snxyam"></td>
        <td class="grid-header-hbbg" id="mrmfzy" property="mrmfzy"></td>
        <td class="grid-header-hbbg" id="qtfwcs" property="qtfwcs"></td>
         <td class="grid-header-hbbg" id="hjT" property="hjT"></td>
        <td class="grid-header-hbbg" id="gwylT" property="gwylT"></td>
        <td class="grid-header-hbbg" id="yysdzyxtT" property="yysdzyxtT"></td>
        <td class="grid-header-hbbg" id="qtylcsT" property="qtylcsT"></td>
        <td class="grid-header-hbbg" id="snxyamT" property="snxyamT"></td>
        <td class="grid-header-hbbg" id="mrmfzyT" property="mrmfzyT"></td>
        <td class="grid-header-hbbg" id="qtfwcsT" property="qtfwcsT"></td>
      </tr>
	</table>
</div>
</body>
</html>