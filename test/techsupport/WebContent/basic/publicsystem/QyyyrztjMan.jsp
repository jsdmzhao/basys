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
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>publicsystem/querylist_qyyyrztj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LQyyyrztj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'qyzs', type: 'int'}, 
			 {name: 'sccss', type: 'int'},
			 {name: 'wsccss', type: 'int'},
             {name: 'cyrys', type: 'int'},
             {name: 'sbrs', type: 'int'}, 
             {name: 'xzrys', type: 'int'},
             {name: 'lzrys', type: 'int'},  
             {name: 'mxlj', type: 'String'}]}
);
		
dataStore.on('load', function(store, records, options ) {
});

$(document).ready(function() {
		daggleDiv("qyyyrztj_detail");
		ksd_csxxtjInit();
		initTJDate();
		$("#t_qsrq").attr("readonly","true").datepicker();
		$("#t_jzrq").attr("readonly","true").datepicker();
		$("#t_qsrq").attr("value",tomorrowDate);
		$("#t_jzrq").attr("value",currentDate);
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
	    //传递查询参数用于明细
	    $("#x_hylbdm").attr("value", $("#t_hylbdm").attr("value"));
		$("#x_qsrq").attr("value", $("#t_qsrq").attr("value"));
		$("#x_jzrq").attr("value", $("#t_jzrq").attr("value"));
		$("#x_dsjgbz").attr("value", $("#t_dsjgbz").attr("value"));
		$("#x_fxjbz").attr("value", $("#t_fxjbz").attr("value"));
		$("#x_gxdwbz").attr("value", $("#t_gxdwbz").attr("value"));
	    
	    if($("#t_dsjgbz").attr("value")=="1"){
	        $("#l_qyzs").before("<td width='111' id='l_dsjgmc' class='grid-header-bg1'>市局</td>");
	        $("#qyzs").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_qyzs").before("<td width='116' id='l_fxjgmc' class='grid-header-bg1'>分县局公安机关</td>");
	       $("#qyzs").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_qyzs").before("<td width='117' id='l_gxdwmc'  class='grid-header-bg1'>派出所</td>");
	        $("#qyzs").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	    }
	    if($("#t_dsjgbz").attr("value")=="0"){
	        $("#l_qyzs").before("<td width='111' id='l_gatmc' class='grid-header-bg1'>省厅</td>");
	        $("#qyzs").before("<td class='grid-header-hbbg' valign='top' id='gatmc' property='gatmc' groupid='gatmc'>"+departName+"</td>");
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

function setXxQuery(id){
	     detailid="qyyyrztj_detail";
	     dataid=id;
	     setWidth(detailid,"800");
	     $('#'+detailid).css('left','45').css('top','40');
		 var url="basic/publicsystem/Qyyyrztjxx.jsp";
		 setUrl(detailid,url);
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

<input type="hidden" id="x_dsjgbz" value="0">
<input type="hidden" id="x_dsjgdm">
<input type="hidden" id="x_fxjbz" value="0">
<input type="hidden" id="x_fxjdm">
<input type="hidden" id="x_gxdwbz" value="0">
<input type="hidden" id="x_gxdwdm">
<input type="hidden" id="x_hylbdm">
<input type="hidden" id="x_qsrq">
<input type="hidden" id="x_jzrq">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">企业营业日志统计</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr id="gajgAll">
			<td width="10%" class="pagedistd">
			<input dataKey="dsjgdm" type="checkbox" id="ch_dsjgdm" onClick="ksd_gajgSelect(this);"/>地市公安机关</td>
			<td width="23%" class="pagetd">
			<select id="bq_dsjgdm" onChange="ksd_dsjgdmOnchange();"><option>全部</option></select>
			</td>
			<td width="10%" class="pagedistd">
			<input dataKey="fxjdm" type="checkbox" id="ch_fxjdm" onClick="ksd_gajgSelect(this);">分县局公安机关</td>
			<td width="23%" class="pagetd">
			<select id="bq_fxjdm" onChange="ksd_fxjdmOnchange();"><option>全部</option></select></td>
			<td width="10%" class="pagedistd">
			<input dataKey="gxdwdm" type="checkbox" id="ch_gxdwdm" onClick="ksd_gajgSelect(this);">科所队</td>
			<td width="23%" class="pagetd">
			<select id="bq_gxdwdm" onChange="ksd_gxdwdmOnchange();"><option>全部</option></select></td>
		</tr>
		<tr>
			<td class="pagedistd">起始日期</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qsrq"></td>
			<td class="pagedistd">截止日期</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzrq"></td>
			<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
		</tr>
		<tr>
			<td class="pagetd" colspan="6">
			<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
			<tr>
			<td><a href="#" class="searchbutton" id="querys2" onClick="loadData();">查询</a></td>
			<td><a href="#" class="submitlongbutton" onClick="expExcel('datatable',10,1);" id="csxxExcel">导出Excel</a></td>
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
<div id="tabledata" class="scrollbarface" style="overflow-y:scroll;height:500; border:1px #d8dbec solid;border-right:0px;position:relative;">
<table width="1002"  cellpadding="3" style="border-collapse:collapse;" cellspacing="0"  id="datatable" >
   	  <thead>
   	  <tr class="grid-header-tr">
        <td width="111" class="grid-header-bg1"  id="l_dsjgmc"  >市局</td>
        <td width="116" class="grid-header-bg1" id="l_fxjgmc"   >分县局公安机关</td>
        <td width="117" class="grid-header-bg1" id="l_gxdwmc"   >派出所</td>
        <td width="74" class="grid-header-bg1" id="l_qyzs">企业总数</td>
        <td width="74" class="grid-header-bg1" id="l_sccss">上传场所数</td>
        <td width="74" class="grid-header-bg1" id="l_wsccss">未上传场所数</td>
        <td width="74" class="grid-header-bg1" id="l_cyrys">从业人员数</td>
        <td width="74" class="grid-header-bg1" id="l_sbrs">上班人数</td>
        <td width="74" class="grid-header-bg1" id="l_xzrys">新增人员数</td>
        <td width="74" class="grid-header-bg1" id="l_lzrys">离职人员数</td>
        <td width="74" class="grid-header-bg1" id="l_mxlj">操作</td>
      </tr>
      </thead>
      <tr entityclass="temp"  edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc" property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc" property="fxjmc" groupid="fxj" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw" mergeblank="true"></td>
        <td class="grid-header-hbbg" id="qyzs"  property="qyzs"></td>
        <td class="grid-header-hbbg" id="sccss"  property="sccss"></td>
        <td class="grid-header-hbbg" id="wsccss"  property="wsccss"></td>
        <td class="grid-header-hbbg" id="cyrys"  property="cyrys"></td>
        <td class="grid-header-hbbg" id="sbrs"  property="sbrs"></td>
        <td class="grid-header-hbbg" id="xzrys"  property="xzrys"></td>
        <td class="grid-header-hbbg" id="lzrys"  property="lzrys"></td>
        <td class="grid-header-hbbg" id="mxlj"  property="mxlj"></td>
      </tr>
	</table>	
</div>
<div id="qyyyrztj_detail" class="page-layout" src="#" style="top:20px; left:160px; width:800px; display:none;"></div>
</body>
</html>