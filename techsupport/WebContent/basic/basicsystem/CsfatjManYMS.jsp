<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
// 统计类型 M：月，S：季度
String tjType = (String)request.getParameter("tjtype");
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
	// 初期化关联管辖单位控件
	csxxtjInit();
	
	var currentDate = new Date();
	var strY="<option></option>";
	// 年度
	for(i=1980;i<(currentDate.getFullYear()+10);i++){
	    strY+="<option value="+i+">"+i+"</option>";
	}
	$(strY).appendTo("#tjYear");
	$("#tjYear").selectBox({state:"temp"});
	$("#tjYear").setValue(currentDate.getFullYear());
	<%
	if("M".equals(tjType)){
	%>
	var month;
	var strM="<option></option>";
	// 月份
	$("#titleTD").html('月度');
	$("#tjMonth").show();
	for(i=1;i<13;i++){ 
	    if(i<10)
            month = "0"+i;
        else
            month = i;
	    if(i == (currentDate.getMonth()+1)){
	        strM+="<option value="+month+" selected>"+month+"</option>";
	    }else{
	        strM+="<option value="+month+">"+month+"</option>";
	    }
	}
	$(strM).appendTo("#tjMonth");
	$("#tjMonth").selectBox({state:"temp"});
	<%
	}else if("S".equals(tjType)){
	%>
	var strS;
	// 季度
	$("#titleTD").html('季度');
	$("#tjSeason").show();
	for(i=1;i<5;i++){
	    strS+="<option value="+i+">第"+i+"季度</option>";
	}
	$(strS).appendTo("#tjSeason");
	$("#tjSeason").selectBox({state:"temp"});
	<%}%>
	
	// 加载场所控件
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
	// 行业类别选择框
	$("#t_hylbdm").selectBoxhylb({code:"dm_hylb"});
	//设定表格高度
	$("#tabledata").height(pageHeight-212); 
});

function csfatjYMSSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    csfatjYMSSetParams();
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
    if (!checkControlValue("tjYear","Select",null,null,null,1,"年度"))
	    return false;
	var tjYear = $("#tjYear").attr("value");
<%
if("M".equals(tjType)){
%>
        if (!checkControlValue("tjMonth","Select",null,null,null,1,"月度"))
	        return false;
		// 按月份统计
		var tjMonth = $("#tjMonth").attr("value");
		$("#t_qssj").val(tjYear+"-"+tjMonth+"-01");
		$("#t_jzsj").val(tjYear+"-"+tjMonth+"-31");
<%
}else if("S".equals(tjType)){
%>	
		// 按季度统计
		var tjSeason = $("#tjSeason").attr("value");
		if(tjSeason==1){
		    $("#t_qssj").val(tjYear+"-01-01");
		    $("#t_jzsj").val(tjYear+"-03-31");
		}else if(tjSeason==2){
		    $("#t_qssj").val(tjYear+"-04-01");
		    $("#t_jzsj").val(tjYear+"-06-31");
		}else if(tjSeason==3){
		    $("#t_qssj").val(tjYear+"-07-01");
		    $("#t_jzsj").val(tjYear+"-09-31");
		}else if(tjSeason==4){
		    $("#t_qssj").val(tjYear+"-10-01");
		    $("#t_jzsj").val(tjYear+"-12-31");
		}
<%}else{%>
    // 按年度统计
		$("#t_qssj").val(tjYear+"-01-01");
		$("#t_jzsj").val(tjYear+"-12-31");
<%}%>
		return true;
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
<input type="hidden" id="t_qssj">
<input type="hidden" id="t_jzsj">

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
			<input dataKey="csbm" type="checkbox" id="ch_csbm" onClick="gajgSelect(this);">服务场所</td>
			<td class="pagetd"><input type="text" id="p_csmc" class="inputstyle" readonly="readonly"></td>
		</tr>
		<tr>
		    <td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
			<td class="pagedistd">年度</td>
			<td class="pagetd">
              <select name="select" id="tjYear">
              </select></td>
			<td id="titleTD" class="pagedistd"></td>
			<td id="dataTD" class="pagetd">
              <SELECT name="select" id="tjMonth" style="display:none;"> 
              </SELECT>
              <SELECT name="select" id="tjSeason"  style="display:none;"> 
              </SELECT>
            </td>
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