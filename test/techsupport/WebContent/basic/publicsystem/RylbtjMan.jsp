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
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>publicsystem/querylist_rylbtj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LRylbtj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'qymc', type: 'String'},
			 {name: 'hjT', type: 'int'}, 
			 {name: 'glryT', type: 'int'},
			 {name: 'fwryT', type: 'int'},
             {name: 'baryT', type: 'int'},
             {name: 'aqjcryT', type: 'int'}, 
             {name: 'qtT', type: 'int'}, 
             {name: 'hj', type: 'int'}, 
             {name: 'glry', type: 'int'}, 
             {name: 'fwry', type: 'int'}, 
             {name: 'bary', type: 'int'}, 
             {name: 'aqjcry', type: 'int'},
             {name: 'qt', type: 'int'}]}
);
		
dataStore.on('load', function(store, records, options ) {
});

	$(document).ready(function() {
		csxxtjInit();
		initTJDate();
		$("#t_qsrq").attr("readonly","true").datepicker();
	    $("#t_jzrq").attr("readonly","true").datepicker();
	    $("#t_qsrq").attr("value",tomorrowDate);
	    $("#t_jzrq").attr("value",currentDate);
		$("#p_csmc").click(function(){
			//if(changsuoCanPlay&&$("#ch_csbm").attr("checked")){
			if($("#ch_csbm").attr("checked")){
				dataid=$("#t_hylbdm").val();
	            //getTy_item("p_csmc","t_csbm","","",$("#t_gxdwdm").attr("value"));
	            var gxdw='';
	            if($("#t_gxdwdm").attr("value")!=''){
	                gxdw=$("#t_gxdwdm").attr("value");
	            }else if($("#t_fxjdm").attr("value")!=''){
	                gxdw=$("#t_fxjdm").attr("value");
	            }else if($("#t_dsjgdm").attr("value")!=''){
	                gxdw=$("#t_dsjgdm").attr("value");
	            }
	           
	            getTy_item_super("p_csmc","t_csbm","","",gxdw,"","");
			}
		});
		$("#t_hylbdm").selectBoxhylb({code:"J"});// 行业类别选择框
		//设定表格高度
	    $("#tabledata").height(pageHeight-214); 
	});

function rylbtjSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    rylbtjSetParams();
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
	        $("#hj").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='157' id='l_fxjgmc' rowspan='2' class='grid-header-bg1'>分县局公安机关</td>");
	       $("#hj").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='87' id='l_gxdwmc' rowspan='2' class='grid-header-bg1'>派出所</td>");
	        $("#hj").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	    }
	    if($("#t_csbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='90' id='l_qymc' rowspan='2' class='grid-header-bg1'>场所</td>");
	        $("#hj").before("<td class='grid-header-hbbg' valign='top' id='qymc' property='qymc' groupid='qy'  mergeblank='true'></td>");
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
    <td class="queryfont"">人员信息统计查询</td>
  </tr>
  <tr id="gajgAll">
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="10%" class="pagedistd">
			<input dataKey="dsjgdm" type="checkbox" id="ch_dsjgdm" onClick="gajgSelect(this);"/>市级公安机关</td>
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
		</tr>
		<tr>
			<td class="pagedistd">
			<input dataKey="csbm" type="checkbox" id="ch_csbm" onClick="gajgSelect(this);">场所</td>
			<td class="pagetd"><input type="text" id="p_csmc" class="inputstyle" readonly="readonly"></td>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qsrq"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzrq"></td>
		</tr>
		  <tr>
      <td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
      <td width="23%" class="pagetd" colspan="4">
				<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" id="querys2" onClick="loadData();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="expExcel('datatable',16,2);" id="csxxExcel">导出</a></td>
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
        <tr>
         <td width="81"  id='l_dsjgmc' rowspan="2" class="grid-header-bg1"  >市局</td>
         <td width="157" id='l_fxjgmc' rowspan="2" class="grid-header-bg1"   >分县局公安机关</td>
         <td width="87" id='l_gxdwmc' rowspan="2" class="grid-header-bg1"   >派出所</td>
         <td width="90" id="l_qymc" rowspan="2" class="grid-header-bg1" >场所</td>
         <td width="230" id="l_zqnxz" colspan="6"   class="grid-header-bg1" >周期内新增</td>
         <td width="230" id="l_zjzrq" colspan="6"  class="grid-header-bg1" >至截止日期</td>
        </tr>
	    <tr>
	        <td   id="l_hj" class="grid-header-bg1" >人员总数</td>
	     	<td id="l_glry" class="grid-header-bg1" >管理人员</td>
	     	<td  id="l_fwry" class="grid-header-bg1" >服务人员</td>
	     	<td id="l_bary" class="grid-header-bg1" >保安人员</td>
	     	<td  id="l_aqjcry" class="grid-header-bg1" >安检人员</td>
	     	<td   id="l_qt" class="grid-header-bg1" >其他人员</td>
	     	<td  id="l_hjT" class="grid-header-bg1" >人员总数</td>
	     	<td  id="l_glryT" class="grid-header-bg1" >管理人员</td>
	     	<td id="l_fwryT" class="grid-header-bg1" >服务人员</td>
	     	<td id="l_baryT" class="grid-header-bg1" >保安人员</td>
	     	<td  id="l_aqjcryT" class="grid-header-bg1" >安检人员</td>
	     	<td id="l_qtT" class="grid-header-bg1" >其他人员</td>
	    </tr>
	  <tr entityclass="temp"  edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc" property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc" property="fxjmc" groupid="fxj" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="qymc" property="qymc" groupid="qy" mergeblank="true"></td>
        <td class="grid-header-hbbg" id="hj"  property="hj"></td>
        <td class="grid-header-hbbg" id="glry"  property="glry"></td>
        <td class="grid-header-hbbg" id="fwry"  property="fwry"></td>
        <td class="grid-header-hbbg" id="bary"  property="bary"></td>
        <td class="grid-header-hbbg" id="aqjcry"  property="aqjcry"></td>
        <td class="grid-header-hbbg" id="qt"  property="qt"></td>
        <td class="grid-header-hbbg" id="hjT" property="hjT"></td>
        <td class="grid-header-hbbg" id="glryT" property="glryT"></td>
        <td class="grid-header-hbbg" id="fwryT"  property="fwryT"></td>
        <td class="grid-header-hbbg" id="baryT"  property="baryT"></td>
        <td class="grid-header-hbbg" id="aqjcryT"  property="aqjcryT"></td>
        <td class="grid-header-hbbg" id="qtT"  property="qtT"></td>
      </tr>
	</table>
</div>
</body>
</html>