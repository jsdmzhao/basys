<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var qyjbxx_requestType=""; //添加、查看、修改
	var qyjbxx_dataid="";
	var glcxick_tables = "";
	var glcxick_pageUrl="icksystem/queryIckZkdList_icksl.action";
	var glcxick_divnid="glcxick_tabledata";
	var glcxick_tableid="glcxick_table1";
	var glcxick_detailid="glcxick_detail";
	
	$(document).ready(function(){
		$("#y_cyrybh").attr("value",glcxcyry_dataid.split("$$$")[0]);
		$("#show_xm").append(glcxcyry_dataid.split("$$$")[1]);
		$("#show_cyrybh").append(glcxcyry_dataid.split("$$$")[0]);
		glcxick_loadPage("glcxick_tabledata");
		glcxick_setPageList(1);
	}); 
	function glcxick_setPageList(pageno,url){
		if (glcxick_manVerify()){
			url=glcxick_setList(pageno,url);
			var mygrid1 = $("#"+glcxick_tableid).ingrid({ 
											url: url,
											ingridPageParams:sXML,
											height: 160,
											ingridPageWidth: 650,
											sorting: false,
											barTopPosition:100,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){ },
											colWidths: ["16%","26%","10%","20%","28%"]									
										});				
			}
	}	
	function glcxick_loadPage(divpageid){
		glcxick_tables=$("#"+divpageid).html();
		$("#"+glcxick_detailid).hide(); 	
		glcxick_setPageList(1,'#');
	}
	function glcxick_setList(pageno,url){	
		$("#"+glcxick_divnid).html(glcxick_tables);	
		setParams("y_");
		if (url==null || url=="undefined"){
			url=glcxick_pageUrl;
		}
		return url;
	}
	function glcxick_manVerify(){
		if (!checkControlValue("y_kh","String",1,20,null,0,"IC卡受理号"))
			return false;
		return true;
	}
	function cyryIckColse(){
		$("#glcxcyry_detail").hideAndRemove("show");
		$("#glcxcyry_detail").empty();
	}
</script>

</head>
<body>
<input type="hidden" id="y_cyrybh" value="">
<input type="hidden" id="y_zkdCyryIck" value="1">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">IC卡信息</td>
      <td align="right"><a href="#" id="closeDiv" onClick="cyryIckColse();" class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">IC卡信息查询条件</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
			<td width="4%" class="pagedistd">姓名</td>
			<td width="21%" class="pagetd"><span id="show_xm"></span></td>
			<td width="8%" class="pagedistd">从业人员编号</td>
			<td width="21%" class="pagetd"><span id="show_cyrybh"></span></td>
			<td width="7%" class="pagedistd">IC卡受理号</td>
			<td class="pagetd"><input type="text" class="inputstyle"  id="y_kh" value=""></td>
		  	<td width="6%">
				<table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
					<td><a href="#" class="searchbutton" id="querys" onClick="glcxick_setPageList(1);">查询</a></td>
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
<div id="glcxick_detail"  class="page-layout" src="#"
		style="top:0px;">
</div>	

<div id="glcxick_tabledata" style="width:100%;">
	<table id="glcxick_table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_kh">IC卡受理号</th>
	     	<th name="l_gj">国籍</th>
			<th name="l_xb">性别</th>
			<th name="l_yxqhzrq">有效截至日期</th>
	     	<th name="l_zkztbs">制卡状态</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>