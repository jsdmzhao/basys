<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<script type="text/javascript">
  var exportState = 0;
   var gzrztjqy_detailid="gzrztjqy_detail";
	var gzrztjqy_pageUrl="icksystem/queryListForPageUnit_gzrztj.action";
	var gzrztjqy_divnid="GzrztjqyData";
	var gzrztjqy_tableid="GzrztjqyTable";
	var gzrztjqy_tables="";
	
$(document).ready(function() {
	initTJDate();
	$("#p_ksyysj").attr("readonly","true").attr("value",tomorrowDate).datepicker();
	$("#p_jsyysj").attr("readonly","true").attr("value",currentDate).datepicker();
	
	
		//导出功能
	tabletitle = "";
	geteExcelHead("GzrztjqyData");
	//ExcelURL
	 //excelUrl="icksystem/excelCreate_gzrztj.action";
	
	gzrztjqy_loadPage("GzrztjqyData");
	daggleDiv("gzrztjqy_detail");
}); 

function gzrztjqy_loadPage(divpageid){
	gzrztjqy_tables=$("#"+divpageid).html();
	$("#"+gzrztjqy_detailid).hide(); 	
	gzrztjqy_setPageList(1,'#');
}
function gzrztjqy_setList(pageno,url){	
	$("#"+gzrztjqy_divnid).html(gzrztjqy_tables);	
	createXML("p_");
	if (url==null || url=="undefined"){
		url=gzrztjqy_pageUrl;
	}
	return url;
}
	
	
function gzrztjqy_setPageList(pageno,url){	
	if (gzrztjqy_manVerify()){
		url=gzrztjqy_setList(pageno,url);
		var mygrid2 = $("#"+gzrztjqy_tableid).ingrid({ 
		                                    sorting: true,
		                                    url: url,
											ingridPageParams:sXML,
											height: pageHeight-205,
											pageNumber: pageno,
											onRowSelect:null,
											colWidths: ["20%","20%","20%","20%","20%"]								
									});				
		}
}	

  function gzrztjqy_manVerify(){
		if(!checkTwoDateEarlier($("#p_ksyysj").val(),$("#p_jsyysj").val())){
			jAlert("登记日期必须小于登记日期至！","验证信息",null,"p_ksyysj");
			return false;
		}
		return true;

	}

	// 行业类别	
$("#hylbdm").selectBoxhylb();
// 企业筛选框
$("#p_qymc").click(function(){
    dataid=$('#hylbdm').val();
 	//getTy_itemTj("p_qymc","p_qybm",null,null,null,"shyes");
 	getTy_item_super("p_qymc","p_qybm","","","","1","1");
  });

</script>

<body>
<input type="hidden" id="p_qybm" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
 <tr>
    <td class="queryfont">工作日志按部门统计</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
	
			<tr>
	          <td width="10%" class="pagedistd">行业类别</td>
			 	<td width="20%" class="pagetd"><select  id="hylbdm" ></select></td>
			   <td width="8%" class="pagedistd">场所名称</td>
	            <td width="35%"  class="pagetd"><input type="text" class="inputstyle"  id="p_qymc" value="" readonly="readonly" style="width:140px;"></td>
	            <td width="8%" class="pagedistd">查询日期</td>
	            <td width="25%" class="pagetd"><input type="text" class="inputstyle"  id="p_ksyysj" value="" readonly="readonly" style="width:140px;"></td>
	            <td width="8%" align="left">至</td>
	            <td width="24%" class="pagetd"><input type="text" class="inputstyle"  id="p_jsyysj" value="" readonly="readonly" style="width:140px;"></td>
	            <td align="right">
		            <table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td ><a href="#" class="searchbutton" id="querys" onClick="gzrztjqy_setPageList(1);">查询</a></td>
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
<div id="gzrztjqy_detail" class="page-layout" src="#" style="top:180px; left:160px;">
</div>	
<div id="GzrztjqyData" style="width:100%;">
	<table id="GzrztjqyTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bqycyryxm">本场所在职从业人员</th>
	     	<th name="l_bqycyrybh">本场所从业人员编号</th>
	     	<th name="l_crqycyryxm">出入场所人员姓名</th>
	    	<th name="l_crqycyrybh">出入场所从业人员编号</th>
	        <th name="l_sksj">刷卡时间</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>