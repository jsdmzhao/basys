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
	proxy: new Ext.data.HttpProxy({url:'<%=basePath%>basicsystem/querylistBzh_qycftj.action'}),
	reader: new Ext.data.JsonReader(), 
	root: 'LQycftj',
	totalProperty: 'totalrows',
	successProperty: 'success',
	fields: [{name: 'dsjgmc', type: 'String'}, 
			 {name: 'fxjmc', type: 'String'},
			 {name: 'gxdwmc', type: 'String'},
			 {name: 'csmc', type: 'String'},
			 {name: 'jczsT', type: 'int'}, 
			 {name: 'cfzsT', type: 'int'},
			 {name: 'jlzsT', type: 'int'},
             {name: 'jczs', type: 'int'},
             {name: 'cfzs', type: 'int'}, 
             {name: 'jgcs', type: 'int'}, 
             {name: 'fmcs', type: 'int'}, 
             {name: 'tdcs', type: 'int'}, 
             {name: 'zjcs', type: 'int'}, 
             {name: 'qtfmcs', type: 'int'}, 
             {name: 'jlzs', type: 'int'}, 
             {name: 'tbbycs', type: 'int'},  
             {name: 'wzjlcs', type: 'int'}, 
             {name: 'qtjlcs', type: 'int'}]}
);
		
dataStore.on('load', function(store, records, options ) {
});

$(document).ready(function() {
	// 控件联动机能初期化
	csxxtjInit();
	initTJDate();
	$("#t_tjrq").attr("readonly","true").datepicker();
	$("#t_tjrqzhi").attr("readonly","true").datepicker();
	$("#t_tjrq").attr("value",tomorrowDate);
	$("#t_tjrqzhi").attr("value",currentDate);
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
	$("#t_hylbdm").selectBoxhylb({code:"flgy"});
	//设定表格高度
	$("#tabledata").height(pageHeight-215); 
}); 
function qycftjSetParams(){
    createXML('t_');
	params={dataxml:sXML,pagerow:10000,pagesize:1};
	dataStore.baseParams = dataStore.baseParams || {};
	Ext.apply(dataStore.baseParams, params);
}
function loadData() {
    if(manVerify()){
        // 设定查询参数
	    qycftjSetParams();
	    // 清空上次结果
	    if(dataStore.getCount()>0){
	        $("#datatable").find('tr').each(function(i){
	            removeOneRow($(this));
	        });
	    }
	    $("#l_dsjgmc").remove();
	    $("#l_fxjgmc").remove();
	    $("#l_gxdwmc").remove();
	    $("#l_csmc").remove();
	    $("#l_gatmc").remove();
	    $("#dsjgmc").remove();
	    $("#fxjmc").remove();
	    $("#gxdwmc").remove();
	    $("#csmc").remove();
	    $("#gatmc").remove();
	    
	    if($("#t_dsjgbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='81' id='l_dsjgmc' rowspan='3' class='grid-header-bg1'>市局</td>");
	        $("#jczs").before("<td class='grid-header-hbbg' valign='top' id='dsjgmc' property='dsjgmc' groupid='dsjg'></td>");
	    }
	    if($("#t_fxjbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='107' id='l_fxjgmc' rowspan='3' class='grid-header-bg1'>分县局公安机关</td>");
	       $("#jczs").before("<td class='grid-header-hbbg' valign='top' id='fxjmc' property='fxjmc' groupid='fxj' mergeblank='true'></td>");
	    }
	    if($("#t_gxdwbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td width='87' id='l_gxdwmc' rowspan='3' class='grid-header-bg1'>派出所</td>");
	        $("#jczs").before("<td class='grid-header-hbbg' valign='top' id='gxdwmc' property='gxdwmc' groupid='gxdw' mergeblank='true'></td>");
	    }
	    if($("#t_csbz").attr("value")=="1"){
	        $("#l_zqnxz").before("<td id='l_csmc' rowspan='3' class='grid-header-bg1'>场所</td>");
	        $("#jczs").before("<td class='grid-header-hbbg' valign='top' id='csmc' property='csmc' groupid='qy' mergeblank='true'></td>");
	    }
	    if($("#t_dsjgbz").attr("value")=="0"){
	        $("#l_zqnxz").before("<td width='81' id='l_gatmc' rowspan='3' class='grid-header-bg1'>省厅</td>");
	        $("#jczs").before("<td class='grid-header-hbbg' valign='top' id='gatmc' property='gatmc' groupid='gatmc'>"+departName+"</td>");
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
    if (!checkControlValue("t_tjrq","Date",null,null,null,1,"起始日期"))
		return false;
	if (!checkControlValue("t_tjrqzhi","Date",null,null,null,1,"截止日期"))
		return false;
			
    var t_qssj = $("#t_tjrq").attr("value");
	var t_jzsj = $("#t_tjrqzhi").attr("value");
	if(t_qssj!=''&&t_jzsj!=''&&formatDate(t_qssj)-formatDate(t_jzsj)>0){
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
    <td class="queryfont">企业奖惩统计</td>
  </tr>
  <tr  id="gajgAll">
    <td class="tdbg">
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
		</tr>
		<tr>
			<td class="pagedistd">
			<input dataKey="csbm" type="checkbox" id="ch_csbm" onClick="gajgSelect(this);">场所名称</td>
			<td class="pagetd"><input type="text" id="p_csmc" class="inputstyle" readonly="readonly"></td>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_tjrq"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_tjrqzhi"></td>
		</tr>
    	<tr>
    	    <td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
			<td width="23%" class="pagetd" colspan="4">
				<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" id="querys2" onClick="loadData();">统计</a></td>
				<td><a href="#" class="exceldcbutton" onClick="expExcel('datatable',18,3);" id="qycftjExcel">导出</a></td>
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
   <tr>
         <td width="81" rowspan="3" class="grid-header-bg1"  id="l_dsjgmc">市局</td>
         <td width="107" rowspan="3" class="grid-header-bg1" id="l_fxjgmc">分县局公安机关</td>
         <td width="87" rowspan="3" class="grid-header-bg1" id="l_gxdwmc">派出所</td>
         <td  rowspan="3" class="grid-header-bg1" id="l_csmc">场所</td>
        <td width="364" colspan="11"   class="grid-header-bg1" id='l_zqnxz'>周期内新增</td>
        <td width="363"  colspan="3"  class="grid-header-bg1"  id='l_zjzrq'>至截止日期</td>
      </tr>
	    <tr>
        
		<td rowspan="2"   class="grid-header-bg1" id='l_jczs'>处罚奖励总数</td>
		<td  colspan="6" class="grid-header-bg1"  id='l_cf'>处罚</td>
		<td  colspan="4"  class="grid-header-bg1"  id='l_jl'>奖励</td>
		  <td rowspan="2"  class="grid-header-bg1" id='l_jczsT'>处罚奖励总数</td>
        <td rowspan="2"   class="grid-header-bg1" id='l_cfzsT'>处罚总数</td>
		<td rowspan="2"  class="grid-header-bg1" id='l_jlzsT'>奖励总数</td>
	    </tr>
	    <tr>
          <td id='l_cfzs' class="grid-header-bg1" >处罚总数</td>
	     	<td id='l_jgcs' class="grid-header-bg1" >警告次数</td>
	     	<td id='l_fmcs' class="grid-header-bg1" >罚没次数</td>
	     	<td id='l_tdcs' class="grid-header-bg1" >停吊次数</td>
	     	<td id='l_zjcs' class="grid-header-bg1" >追究次数</td>
	     	<td id='l_qtfmcs' class="grid-header-bg1" >其他处罚次数</td>
	     	<td id='l_jlzs' class="grid-header-bg1" >场所奖励总数</td>
	     	<td id='l_tbbycs' class="grid-header-bg1" >通报表扬次数</td>
	     	<td id='l_wzjlcs' class="grid-header-bg1" >物质奖励次数</td>
	     	<td id='l_qtjlcs' class="grid-header-bg1" >其他奖励次数</td>
	    </tr>
        <tr entityclass="temp"  edittype="singletext">
	    <td class="grid-header-hbbg" valign="top" id="dsjgmc"  property="dsjgmc" groupid="dsjg"></td>
        <td class="grid-header-hbbg" valign="top" id="fxjmc"  property="fxjmc" groupid="fxj" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="gxdwmc" property="gxdwmc" groupid="gxdw" mergeblank="true"></td>
        <td class="grid-header-hbbg" valign="top" id="csmc" property="csmc" groupid="qy" mergeblank="true"></td> 
        <td class="grid-header-hbbg" id="jczs" property="jczs"></td>
        <td class="grid-header-hbbg" id="cfzs" property="cfzs"></td>
        <td class="grid-header-hbbg" id="jgcs" property="jgcs"></td>
        <td class="grid-header-hbbg" id="fmcs" property="fmcs"></td>
        <td class="grid-header-hbbg" id="tdcs" property="tdcs"></td>
        <td class="grid-header-hbbg" id="zjcs" property="zjcs"></td>
        <td class="grid-header-hbbg" id="qtfmcs" property="qtfmcs"></td>
        <td class="grid-header-hbbg" id="jlzs" property="jlzs"></td>
        <td class="grid-header-hbbg" id="tbbycs" property="tbbycs"></td>
        <td class="grid-header-hbbg" id="wzjlcs" property="wzjlcs"></td>
        <td class="grid-header-hbbg" id="qtjlcs" property="qtjlcs"></td>
         <td class="grid-header-hbbg" id="jczsT" property="jczsT"></td>
        <td class="grid-header-hbbg" id="cfzsT" property="cfzsT"></td>
        <td class="grid-header-hbbg" id="jlzsT" property="jlzsT"></td>
      </tr>
	</table>	
</div>
</body>
</html>