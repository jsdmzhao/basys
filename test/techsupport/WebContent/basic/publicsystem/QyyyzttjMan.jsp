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
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>publicsystem/querylist_qyyyzttj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LQyyyzttj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'hjT', type: 'int'}, 
			 {name: 'yyT', type: 'int'},
			 {name: 'zztyT', type: 'int'},
             {name: 'lltyT', type: 'int'},
             {name: 'xyT', type: 'int'}, 
             {name: 'zxT', type: 'int'}, 
             {name: 'qtT', type: 'int'}]}
);
dataStore.on('load', function(store, records, options ) {
});
		
$(document).ready(function() {
	// 初期化关联管辖单位控件
    ksd_csxxtjInit();
    initTJDate();
	$("#t_tjrq").attr("readonly","true").datepicker();
	$("#t_tjrq").attr("value",currentDate);
	// 行业类别选择框
	$("#t_hylbdm").selectBoxhylb({code:"J"});
	//设定表格高度
	$("#tabledata").height(pageHeight-186); 
}); 

function qyyyzttjSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    qyyyzttjSetParams();
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
	        $("#l_hjT").before("<td id='l_dsjgmc' class='grid-header-bg1'>市局</td>");
	        $("#hjT").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_hjT").before("<td id='l_fxjgmc' class='grid-header-bg1'>分县局公安机关</td>");
	       $("#hjT").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_hjT").before("<td id='l_gxdwmc' class='grid-header-bg1'>派出所</td>");
	        $("#hjT").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	    }
	    if($("#t_dsjgbz").attr("value")=="0"){
	        $("#l_hjT").before("<td id='l_gatmc' class='grid-header-bg1'>省厅</td>");
	        $("#hjT").before("<td class='grid-header-hbbg' valign='top' id='gatmc' property='gatmc' groupid='gatmc'>"+departName+"</td>");
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
    if (!checkControlValue("t_tjrq","Date",null,null,null,1,"统计日期"))
		return false;
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
    <td class="queryfont">场所信息统计(按营业状态)</td>
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
			<td class="pagedistd">统计日期</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_tjrq"></td>
			<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
			<td class="pagedistd">&nbsp;</td>
			<td width="23%" class="pagetd">
				<table width="186px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" onClick="loadData();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="expExcel('datatable',10,1);" id="csxxExcel">导出</a></td>
				</tr>
				</table>
			</td>
		</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="tabledata" class="scrollbarface"    style="overflow-y:scroll;height:500; border:1px #d8dbec solid;border-right:0px;">
	<table width="1002"  cellpadding="3" style="border-collapse:collapse;" cellspacing="0"  id="datatable" >
	  <thead>
         <tr>
         <td class="grid-header-bg1" id='l_dsjgmc'>市局</td>
         <td class="grid-header-bg1" id='l_fxjgmc'>分县局公安机关</td>
         <td class="grid-header-bg1"  id='l_gxdwmc'>派出所</td>
	     <td class="grid-header-bg1" id='l_hjT'>企业总数</td>
         <td class="grid-header-bg1" id='l_yyT'>营业场所数</td>
		 <td class="grid-header-bg1" id='l_zztyT'>自主停业数</td>
		 <td class="grid-header-bg1" id='l_lltyT'>勒令停业数</td>
		 <td class="grid-header-bg1" id='l_xyT'>歇业场所数</td>
		 <td class="grid-header-bg1" id='l_zxT'>注销场所数</td>
		 <td class="grid-header-bg1" id='l_qtT'>其他状态场所数</td>
	    </tr>
	  </thead>
	  <tr entityclass="temp" edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc" property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc" property="fxjmc" groupid="fxj"  mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw"  mergeblank="true"></td>
        <td class="grid-header-hbbg" id="hjT" property="hjT"></td>
        <td class="grid-header-hbbg" id="yyT" property="yyT"></td>
        <td class="grid-header-hbbg" id="zztyT" property="zztyT"></td>
        <td class="grid-header-hbbg" id="lltyT" property="lltyT"></td>
        <td class="grid-header-hbbg" id="xyT" property="xyT"></td>
        <td class="grid-header-hbbg" id="zxT" property="zxT"></td>
        <td class="grid-header-hbbg" id="qtT" property="qtT"></td>
      </tr>
	</table>
</div>
</body>
</html>