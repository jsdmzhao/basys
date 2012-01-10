<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var exportState = 0;
$(document).ready(function() {
	pageUrl="sysadmin/querylist_operatelog.action";
	divnid="OperatelogData";
	tableid="OperatelogTable";
	detailHtml="basic/sysadmin/OperatelogDetail.jsp";
	detailid="operatelog_detail";
	detailUrl="sysadmin/query_operatelog.action";
	detailWidth="800";
	
	searchLongUrl="sysadmin/queryForExport_operatelog.action";  //超长参数后台Action对应url
	excelUrl="sysadmin/getExcelCreate_operatelog.action";
	//导出功能
	tabletitle = "";
	geteExcelHead("OperatelogData");
	
	loadPage(divnid);
	
	$("#p_operatedatef").attr("readonly","true");
	$("#p_operatedatef").datepicker();
	$("#p_operatedatet").attr("readonly","true");
	$("#p_operatedatet").datepicker();
		
	//$("#sel_operatesystem").selectBox({state:"2"}); 
		createXML("s_");
		$("#p_operatemodule").selectBox({url:"sysadmin/querySelMenu_menu.action"});
	
	$("#sel_operatesystem").selectBox({url:"sysadmin/querySelSystem_system.action"});
	//$("#p_operatemodule").selectBox({url:"sysadmin/querySelMenu_system.action"});
	
	daggleDiv("operatelog_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-230,
										pageNumber: pageno,
										changeHref:function(table){
											if(table.find("tr").length>0){
												exportState = 1;
											}else{
												exportState = 0;
											}
										},
										colWidths: ["25%","25%","25%","25%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_useraccount","String",1,30,null,0,"操作用户"))
			return false;
		
		var startDate = $("#p_operatedatef").val();
		var endDate = $("#p_operatedatet").val();
		if(!checkTwoDateEarlier(startDate,endDate)){
			jAlert("操作时间必须小于操作时间至","验证信息",null,"p_operatedatef");
			return false;
		}
			
		return true;
	}
	
	function getMenuDropList(){
		$("#p_operatesystem").val($("#sel_operatesystem").attr("title"));
		$("#s_systemcode").val($("#sel_operatesystem").val());
		createXML("s_");
		$("#p_operatemodule").selectBox({url:"sysadmin/querySelMenu_menu.action"});
	}
	
	//导出Excel
	function setExportExcel(){	
	  	if(exportState){
	  		setSearchLong(); //传全部参数将查询结果放入json，对应后台Action方法中将结果集放入session，用于处理超长参数的数据导出
	  	}else{
	  		jAlert("请先查询数据","提示信息");
	  	}		
	}
	
	
	//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
	function searchLongBack(json){  
			//报表标题
			var bbmc="操作日志";
			//报表请求
			//setExcel("gnlkexcel",bbmc);	
			setExcelLong("czrzexcel",bbmc);	
	}
	
</script>

<body>
	
	<input type="hidden" id="d_operatelogid" value="">	
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询条件</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">系统</td>
				  <td width="23%" class="pagetd">
				  <select id="sel_operatesystem" onchange="getMenuDropList();"><option></option></select>
				  <input type="hidden" id="p_operatesystem" />
				  </td>
					<td width="10%" class="pagedistd">模块</td>
				  <td width="23%" class="pagetd">
				  <input type="hidden" id="s_systemcode" />
				  <select id="p_operatemodule"><option></option></select>
				  </td>
					<td width="10%" class="pagedistd">操作用户</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_useraccount" /></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">操作时间</td>
			      <td class="pagetd"><input type="text" class="inputstyle" id="p_operatedatef" /></td>
					<td width="10%" class="pagedistd">至</td>
			      <td class="pagetd"><input type="text" class="inputstyle" id="p_operatedatet" /></td>
					<td width="10%" class="pagedistd"></td>
			      <td width="23%" class="pagetd"><table width="120" border="0" cellpadding="0" cellspacing="0" align="right">
                    <tr>
                      <td width="50%"><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                      <td width="50%">
                      <a href="#" class="exceldcbutton" title="导出查询结果" onClick="setExportExcel()" id="czrzexcel">导出</a>
                      </td>
                    </tr>
                    </table></td>
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
<div id="operatelog_detail"  class="page-layout" src="#"
		style="top:20px; left:160px;">
</div>	

<div id="OperatelogData" style="width:100%;">
	<table id="OperatelogTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_operatemodule" datatype="string" sumflag="0">模块</th>
	     	<th name="l_useraccount" datatype="string" sumflag="0">操作用户</th>
	     	<th name="l_operatedate" datatype="date" sumflag="0">操作时间</th>
	     	<th name="l_operatetype" datatype="string" sumflag="0">操作类型</th>
	    </tr>
	  </thead>  
	</table>	
</div>
</body>