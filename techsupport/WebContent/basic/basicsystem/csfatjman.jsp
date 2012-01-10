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
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>basicsystem/querylist_asjtj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LAsjtj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'qymc', type: 'String'},
			 {name: 'fazsT', type: 'int'}, 
			 {name: 'zzajsT', type: 'int'},
			 {name: 'xsajsT', type: 'int'},
             {name: 'fazs', type: 'int'},
             {name: 'zzajs', type: 'int'}, 
             {name: 'xsajs', type: 'int'}]}
);
		
dataStore.on('load', function(store, records, options ) {
});

	$(document).ready(function() {
		csxxtjInit();
		initTJDate();
		$("#t_qssj").attr("readonly","true").datepicker();
		$("#t_jzsj").attr("readonly","true").datepicker();
		$("#t_qssj").attr("value",tomorrowDate);
	    $("#t_jzsj").attr("value",currentDate);
		$("#p_csmc").click(function(){
			//if(changsuoCanPlay&&$("#ch_csbm").attr("checked")){
			if($("#ch_csbm").attr("checked")){
			    dataid=$("#t_hylbdm").val();
			    var gxdw='';
	            if($("#t_gxdwdm").attr("value")!=''){
	                gxdw=$("#t_gxdwdm").attr("value");
	            }else if($("#t_fxjdm").attr("value")!=''){
	                gxdw=$("#t_fxjdm").attr("value");
	            }else if($("#t_dsjgdm").attr("value")!=''){
	                gxdw=$("#t_dsjgdm").attr("value");
	            }
			    getTy_item_super("p_csmc","t_csbm","","",gxdw,"","");
				//getQY_item("p_csmc","t_csbm","1",$("#t_gxdwdm").attr("value"));
			}
		});
		$("#t_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框
		//设定表格高度
	    $("#tabledata").height(pageHeight-212); 
	});

function csfatjSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    csfatjSetParams();
	    // 清空上次结果
	    if(dataStore.getCount()>0){
	        $("#datatable").find('tr').each(function(i){
	            removeOneRow($(this));
	        });
	    }
	    $("#l_dsjgmc").remove();
	    $("#l_fxjgmc").remove();
	    $("#l_gxdwmc").remove();
	    $("#l_qymc").remove();
	    $("#l_gatmc").remove();
	    $("#dsjgmc").remove();
	    $("#fxjmc").remove();
	    $("#gxdwmc").remove();
	    $("#qymc").remove();
	    $("#gatmc").remove();
	    
	    if($("#t_dsjgbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='81' id='l_dsjgmc' rowspan='2' class='grid-header-bg1'>市局</td>");
	        $("#fazs").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='107' id='l_fxjgmc' rowspan='2' class='grid-header-bg1'>分县局公安机关</td>");
	        $("#fazs").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='87' id='l_gxdwmc' rowspan='2' class='grid-header-bg1'>派出所</td>");
	        $("#fazs").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	    }
	    if($("#t_csbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td id='l_qymc' rowspan='2' class='grid-header-bg1'>场所</td>");
	        $("#fazs").before("<td class='grid-header-hbbg' valign='top' id='qymc' property='qymc' groupid='qy' mergeblank='true'></td>");
	    }
	    if($("#t_dsjgbz").attr("value")=="0"){
	        $("#l_zqnxz").before("<td width='81' id='l_gatmc' rowspan='2' class='grid-header-bg1'>省厅</td>");
	        $("#fazs").before("<td class='grid-header-hbbg' valign='top' id='gatmc' property='gatmc' groupid='gatmc'>"+departName+"</td>");
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
    if (!checkControlValue("t_qssj","Date",null,null,null,1,"起始日期"))
		return false;
	if (!checkControlValue("t_jzsj","Date",null,null,null,1,"截止日期"))
		return false;
	var p_qssj = $("#t_qssj").attr("value");
	var p_jzsj = $("#t_jzsj").attr("value");
	if(p_qssj!=''&&p_jzsj!=''&&formatDate(p_qssj)-formatDate(p_jzsj)>0){
		jAlert("请正确选择起始和截至日期!","提示信息");
		return false;
	}
	return true;
}
function formatDate(strDate){ //转换成日期格式
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
<input type="hidden" id="t_csbz" value="0">
<input type="hidden" id="t_csbm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">场所发案统计</td>
  </tr>
  <tr id="gajgAll">
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="10%" class="pagedistd">
			<input dataKey="dsjgdm" type="checkbox" id="ch_dsjgdm" onClick="gajgSelect(this);"/>地市公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_dsjgdm" onChange="dsjgdmOnchange();"><option>全部</option></select>
			</td>
			<td width="10%" class="pagedistd">
			<input dataKey="fxjdm" type="checkbox" id="ch_fxjdm" onClick="gajgSelect(this);">分县局公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_fxjdm" onChange="fxjdmOnchange();"><option>全部</option></select></td>
			<td width="10%" class="pagedistd">
			<input dataKey="gxdwdm" type="checkbox" id="ch_gxdwdm" onClick="gajgSelect(this);">科所队</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_gxdwdm" onChange="gxdwdmOnchange();"><option>全部</option></select></td>
			<td class="pagedistd">
			<input dataKey="csbm" type="checkbox" id="ch_csbm" onClick="gajgSelect(this);">场所</td>
			<td class="pagetd"><input type="text" id="p_csmc" class="inputstyle" readonly="readonly"></td>
		</tr>
		<tr>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qssj"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzsj"></td>
			<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
		</tr>
		<tr>
			<td width="23%" class="pagetd" colspan="8">
				<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" id="querys2" onClick="loadData();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="expExcel('datatable',10,2);" id="csxxExcel">导出</a></td>
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
<div id="tabledata" class="scrollbarface"  style="overflow-y:scroll;height:500; border:1px #d8dbec solid;border-right:0px;">
	<table width="1002"  cellpadding="3" style="border-collapse:collapse;" cellspacing="0"  id="datatable" >
       <tr>
         <td width="81" rowspan="2" class="grid-header-bg1"  id="l_dsjgmc">市局</td>
         <td width="107" rowspan="2" class="grid-header-bg1" id="l_fxjgmc">分县局公安机关</td>
         <td width="87" rowspan="2" class="grid-header-bg1" id="l_gxdwmc">派出所</td>
         <td  rowspan="2" class="grid-header-bg1" id="l_qymc">场所</td>
         <td width="364" colspan="3"   class="grid-header-bg1"  id='l_zqnxz'>周期内新增</td>
         <td width="363"  colspan="3"  class="grid-header-bg1"  id='l_zjzrq'>至截止日期</td>
      </tr>
	    <tr>
	        <td id="l_fazs" class="grid-header-bg1" >发案总数</td>
	     	<td id="l_zzajs" class="grid-header-bg1" >治安案件</td>
	     	<td id="l_xsajs" class="grid-header-bg1" >刑事案件</td>
	     	<td id="l_fazsT"  class="grid-header-bg1" >发案总数</td>
	     	<td id="l_zzajsT" class="grid-header-bg1" >治安案件</td>
	     	<td id="l_xsajsT" class="grid-header-bg1" >刑事案件</td>
	    </tr>
      <tr entityclass="temp"  edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc"  property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc"  property="fxjmc" groupid="fxj" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="qymc" property="qymc" groupid="qy" mergeblank="true"></td>
        <td class="grid-header-hbbg"  id="fazs" property="fazs"></td>
        <td class="grid-header-hbbg"  id="zzajs" property="zzajs"></td>
        <td class="grid-header-hbbg"  id="xsajs" property="xsajs"></td>
         <td class="grid-header-hbbg"  id="fazsT" property="fazsT"></td>
        <td class="grid-header-hbbg"  id="zzajsT" property="zzajsT"></td>
        <td class="grid-header-hbbg"  id="xsajsT" property="xsajsT"></td>
      </tr>
	</table>
</div>
</body>
</html>