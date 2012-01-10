<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<script type="text/javascript">
var exportState = 0;
var gzrztjry_detailid="gzrztjry_detail";
var gzrztjry_pageUrl="icksystem/queryListForPagePeop_gzrztj.action";
var gzrztjry_divnid="GzrztjryData";
var gzrztjry_tableid="GzrztjryTable";
var gzrztjry_tables="";

$(document).ready(function() {
	initTJDate();
	$("#p_ksyysj").attr("readonly","true").attr("value",tomorrowDate).datepicker();
	$("#p_jsyysj").attr("readonly","true").attr("value",currentDate).datepicker();
	//导出功能
	//tabletitle = "";
	//geteExcelHead("GzrztjryData");
	//ExcelURL
	 //excelUrl="icksystem/excelCreate_gzrztj.action";
	
	gzrztjry_loadPage("GzrztjryData");
	// 行业类别	
    $("#p_hylbdm").selectBoxhylb();
	daggleDiv("gzrztjry_detail");
}); 
function gzrztjry_loadPage(divpageid){
	gzrztjry_tables=$("#"+divpageid).html();
	$("#"+gzrztjry_detailid).hide(); 	
	gzrztjry_setPageList(1,'#');
}
function gzrztjry_setList(pageno,url){	
	$("#"+gzrztjry_divnid).html(gzrztjry_tables);	
	createXML("p_");
	if (url==null || url=="undefined"){
		url=gzrztjry_pageUrl;
	}
	return url;
}
function gzrztjry_setPageList(pageno,url){	
	if (gzrztjry_manVerify()){
		url=gzrztjry_setList(pageno,url);
		var mygrid3 = $("#"+gzrztjry_tableid).ingrid({ 
		                                    //sorting: false,
		                                    url: url,
											ingridPageParams:sXML,
											height: pageHeight-254,
											pageNumber: pageno,
											onRowSelect:null,
											colWidths: ["20%","15%","15%","25%","25%"]								
									});				
		}
}	

  function gzrztjry_manVerify(){
		if(!checkTwoDateEarlier($("#p_ksyysj").val(),$("#p_jsyysj").val())){
			jAlert("登记日期必须小于登记日期至！","验证信息",null,"p_ksyysj");
			return false;
		}
		return true;

	}

function xmpyselcte(){
  var ss = document.getElementById('p_xmpy').value;
  if(ss=='yes'){
     document.getElementById('p_xmpy').value ="no";
  }else{
    document.getElementById('p_xmpy').value ="yes";
   }
}

</script>

<body>
<input type="hidden" id="p_xmpy" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">工作日志按人员统计</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				      <td width="10%" class="pagedistd">行业类别</td>
			 	    <td width="23%" class="pagetd"><select  id="p_hylbdm" ></select></td>
				    <td width="10%" class="pagedistd">姓名</td>
				    <td width="23%" class="pagetd"><input type="text" id="p_xm" class="inputstyle" value=""><input  type="checkbox" id="p_xmpycheck" onclick="xmpyselcte();" />同音</td>
		        	<td width="10%" class="pagedistd">从业人员编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrybh" class="inputstyle" value=""></td>
				  
				</tr>
				<tr>
					 <td width="10%" class="pagedistd">外国人就业许可证号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_wgrjyxkz" class="inputstyle" value=""></td>
				    <td width="10%" class="pagedistd">英文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywm" class="inputstyle" value=""></td>
				    <td width="10%" class="pagedistd">证件号码</td>
					 <td width="23%" class="pagetd"><input type="text" id="p_zjhm" class="inputstyle" value=""></td>
				
    		</tr>
    		
			<tr>
	            <td width="8%" class="pagedistd">查询日期</td>
	            <td width="25%" class="pagetd"><input type="text" class="inputstyle"  id="p_ksyysj" value="" readonly="readonly" style="width:150px;"></td>
	            <td width="8%" align="right">至</td>
	            <td width="24%" class="pagetd"><input type="text" class="inputstyle"  id="p_jsyysj" value="" readonly="readonly" style="width:150px;"></td>
	            <td colspan="2" align="right">
		            <table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td ><a href="#" class="searchbutton" id="querys" onClick="gzrztjry_setPageList(1);">查询</a></td>
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
<div id="gzrztjry_detail" class="page-layout" src="#" style="top:180px; left:160px;">
</div>	
<div id="GzrztjryData" style="width:100%;">
	<table id="GzrztjryTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_sksj">刷卡时间</th>
	    	<th name="l_qymc">出入场所</th>
	        <th name="l_gxdwmc">所属管辖单位</th>
	      
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>