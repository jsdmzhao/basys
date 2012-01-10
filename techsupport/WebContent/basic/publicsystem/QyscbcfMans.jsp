<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
String departTemp = departCode.substring(0,8);
String sdfjksdFlage = ""; //省地分局科所队 标志
if(departTemp.contains("000000")){ //省厅
	sdfjksdFlage = "1";
}else if(departTemp.contains("0000")) { //地市
	sdfjksdFlage = "2";
}else if(departTemp.contains("00")) { //分局
	sdfjksdFlage = "3";
}else{ //科所队

	sdfjksdFlage = "4";
}
%>
<html>
<head>
<script type="text/javascript">
    var thePlayColWidths1 = ["7%","7%","7%","7%","7%","7%","7%","7%","7%","7%","7%","7%","7%","9%"];
    var thePlayColWidths2 = ["7.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%","6.6%"];
    var thePlayColWidths = thePlayColWidths1;
	var js_sdfjksdFlage = '<%=sdfjksdFlage %>';
	var js_departCode = '<%=departCode %>';
	var noSortCol = [0];
$(document).ready(function() {
	pageUrl="publicsystem/querylist_qyfltj.action";
	divnid="tabledata";
	tableid="table1";
	loadPage("tabledata");
	
	ksd_csxxtjInit();
	$("#t_qsrq").attr("readonly","true").datepicker();
	$("#t_jzrq").attr("readonly","true").datepicker();
	//ExcelURL
	excelUrl="publicsystem/querylistExcel_qyfltj.action";
	searchLongUrl="publicsystem/querylistExcelTemp_qyfltj.action";
}); 
    // 建立数据列表
    function createDataTable(){
        $("#gajgAll").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
				if($(this).attr("dataKey")=='dsjgdm'){
					ganjCol = "<th name='l_dsjgmc' datatype='String' sumflag='0'>地市公安机关</th>";
					thePlayColWidths = thePlayColWidths2;
				}
				if($(this).attr("dataKey")=='fxjdm'){
					ganjCol = "<th name='l_fxjmc' datatype='String' sumflag='0'>分县局公安机关</th>";
					thePlayColWidths = thePlayColWidths2;
				}
				if($(this).attr("dataKey")=='gxdwdm'){
					ganjCol = "<th name='l_gxdwmc' datatype='String' sumflag='0'>科所队</th>";
					thePlayColWidths = thePlayColWidths2;
				}
			}
		});
		var result = "<table id='table1' width='100%'><thead><tr>";
		result += ganjCol;
		result += "<th name='l_hjT' datatype='Integer' sumflag='0'>场所总数（至截止日期）</th>";
		result += "<th name='l_gwylT' datatype='Integer' sumflag='0'>歌舞娱乐（至截止日期）</th>";
		result += "<th name='l_yysdzyxtT' datatype='Integer' sumflag='0'>游艺场所（至截止日期）</th>";
		result += "<th name='l_qtylcsT' datatype='Integer' sumflag='0'>其他娱乐场所（至截止日期）</th>";
		result += "<th name='l_snxyamT' datatype='Integer' sumflag='0'>桑拿、洗浴、按摩（至截止日期）</th>";
		result += "<th name='l_mrmfzyT' datatype='Integer' sumflag='0'>美容美发、足浴（至截止日期）</th>";
		result += "<th name='l_qtfwcsT' datatype='Integer' sumflag='0'>其他服务场所（至截止日期）</th>";
		result += "<th name='l_hj' datatype='Integer' sumflag='0'>周期内新增企业数</th>";
		result += "<th name='l_gwyl' datatype='Integer' sumflag='0'>歌舞娱乐(周期内新增)</th>";
		result += "<th name='l_yysdzyxt' datatype='Integer' sumflag='0'>游艺场所(周期内新增)</th>";
		result += "<th name='l_qtylcs' datatype='Integer' sumflag='0'>其他娱乐场所(周期内新增)</th>";
		result += "<th name='l_snxyam' datatype='Integer' sumflag='0'>桑拿、洗浴、按摩(周期内新增)</th>";
		result += "<th name='l_mrmfzy' datatype='Integer' sumflag='0'>美容美发、足浴(周期内新增)</th>";
		result += "<th name='l_qtfwcs' datatype='Integer' sumflag='0'>其他服务场所(周期内新增)</th>";
		result += "</tr></thead><tbody></tbody></table>";
		$("#tabledata").html(result);
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
	// 查询
	function startTjcx(){ 
	    if(manVerify()){
		    createDataTable();
		    loadPage("tabledata");
		    setPageList(1);
		}
	}
	// 设定数据列表
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); 
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-236,
				pageNumber: pageno,
				colWidths: thePlayColWidths,
				onRowSelect: function(tr, selected){},
				noSortColIndex: noSortCol
		});
	}
	// 导出Excel
	function setExportExcel(){ 
	    if(manVerify()){
		    createDataTable();
		    geteExcelHead("tabledata");
		    setSearchLong();
		    loadPage("tabledata");
		    setPageList(1);
		}
	}
	/*
	不分页传参数将结果集返回，用于长参数导出前的查询
	*/
	function setSearchLong(){
		setParams("t_");
		jQuery.post(searchLongUrl,params,searchLongBack,"json");
	}
	//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数

	function searchLongBack(json){  
		//报表标题
		var bbmc="场所信息统计(按分类)";
		//报表请求
		setExcelLong("csxxExcel",bbmc);	
	}
	/*setExcel 生成EXCEL,不传参数，防止超长

	 * excelid 链接id
	 * bbmc：报表标题

	 */
	function setExcelLong(excelid,bbmc){
		var surl=excelUrl+"?tabletitle="+ganjCol+"&bbmc="+bbmc;
		surl=encodeURI(surl);
		location.href = surl;
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

<input type="hidden" id="t_dsjgbz" value="0">
<input type="hidden" id="t_dsjgdm">
<input type="hidden" id="t_fxjbz" value="0">
<input type="hidden" id="t_fxjdm">
<input type="hidden" id="t_gxdwbz" value="0">
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
			<input dataKey="dsjgdm" type="checkbox" id="ch_dsjgdm" onClick="ksd_gajgSelect(this);"/>地市公安机关</td>
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
			<td class="pagedistd">&nbsp;</td>
			<td width="23%" class="pagetd">
				<table width="186px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" onClick="startTjcx();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="setExportExcel()" id="csxxExcel">导出</a></td>
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
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
        <th name='l_hjT' datatype='Integer' sumflag='0'>场所总数(至截止日期)</th>
        <th name='l_gwylT' datatype='Integer' sumflag='0'>歌舞娱乐（至截止日期）</th>
		<th name='l_yysdzyxtT' datatype='Integer' sumflag='0'>游艺场所（至截止日期）</th>
		<th name='l_qtylcsT' datatype='Integer' sumflag='0'>其他娱乐场所（至截止日期）</th>
		<th name='l_snxyamT' datatype='Integer' sumflag='0'>桑拿、洗浴、按摩（至截止日期）</th>
		<th name='l_mrmfzyT' datatype='Integer' sumflag='0'>美容美发、足浴（至截止日期）</th>
		<th name='l_qtfwcsT' datatype='Integer' sumflag='0'>其他服务场所（至截止日期）</th>
		<th name='l_hj' datatype='Integer' sumflag='0'>周期内新增企业数</th>
		<th name='l_gwyl' datatype='Integer' sumflag='0'>歌舞娱乐(周期内新增)</th>
		<th name='l_yysdzyxt' datatype='Integer' sumflag='0'>游艺场所(周期内新增)</th>
		<th name='l_qtylcs' datatype='Integer' sumflag='0'>其他娱乐场所(周期内新增)</th>
		<th name='l_snxyam' datatype='Integer' sumflag='0'>桑拿、洗浴、按摩(周期内新增)</th>
		<th name='l_mrmfzy' datatype='Integer' sumflag='0'>美容美发、足浴(周期内新增)</th>
		<th name='l_qtfwcs' datatype='Integer' sumflag='0'>其他服务场所(周期内新增)</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>