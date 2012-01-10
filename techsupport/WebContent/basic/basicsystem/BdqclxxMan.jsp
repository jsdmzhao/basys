<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bdqclxx.action";
	searchLongUrl="basicsystem/queryForExport_bdqclxx.action";
	divnid="BdqclxxData";
	tableid="BdqclxxTable";
	addUrl="basicsystem/insert_bdqclxx.action";
	addHtml="basic/basicsystem/BdqclxxAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_bdqclxx.action";
	delid="d_bdqclxxid";
	modHtml="basic/basicsystem/BdqclxxModify.jsp";
	modUrl="basicsystem/modify_bdqclxx.action";
	modWidth="800";
	detailHtml="basic/basicsystem/BdqclxxDetail.jsp";
	detailid="bdqclxx_detail";
	detailUrl="basicsystem/query_bdqclxx.action";
	detailWidth="800";
	
	// Excel表头
	tabletitle = "";
	geteExcelHead(divnid);
	
	// ExcelURL
	excelUrl="basicsystem/getExcelCreateRz_bdqclxx.action";
	
	loadPage(divnid);
	    $("#p_clppdm").selectBox({code:"dm_clpp"});
		$("#p_ccdjrq").attr("readonly","true");
		$("#p_ccdjrq").datepicker();
		$("#p_lasjF").attr("readonly","true");
		$("#p_lasjF").datepicker();
		$("#p_lasjT").attr("readonly","true");
		$("#p_lasjT").datepicker();
		
		daggleDiv(detailid);
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,
										ingridPageParams:sXML,
										height: pageHeight-280,
										changeHref:function(table){//若表格无数据，则点击导出不起作用
											$("#gnlkexcel").unbind("click");
											if($(table).find("tr").length==0){
													daochuNum = 0;
												}else{
													daochuNum = 1;
												}	
										},
										pageNumber: pageno,
										colWidths: ["10%","10%","10%","10%","15%","15%","15%","15%"]									
									});				
		}
}	
	function manVerify(){
	    $("#p_clpp").val($("#p_clppdm").attr("title"));
	    if (!checkControlValue("p_clxh","String",1,64,null,0,"车辆型号"))
			return false;
		if (!checkControlValue("p_hphm","String",1,32,null,0,"车辆号牌"))
			return false;
		if (!checkControlValue("p_fdjh","String",1,60,null,0,"发动机号"))
			return false;
		if (!checkControlValue("p_cjh","String",1,50,null,0,"车架号"))
			return false;
	    if (!checkControlValue("p_syr","String",1,512,null,0,"机动车所有人"))
			return false;
		if (!checkControlValue("p_ajbh","String",1,60,null,0,"立案编号"))
			return false;
		return true;
	}
	function gaojichaxun_bdqclxx(){
		gaojichaxun("146",detailid);
	}
	//导出Excel
function setExportExcel(){	
  	if(daochuNum==1){
		if (manVerify()){
  			setSearchLong(); //传全部参数将查询结果放入json，对应后台Action方法中将结果集放入session，用于处理超长参数的数据导出
  		}
  	}else{
  		alert('无查询结果不能导出！');
  	}		
}
//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
function searchLongBack(json){  
		//报表标题
		var bbmc="被盗抢车辆信息";
		//报表请求
		setExcelLong("bdqclxxExcel",bbmc);	
}
</script>
<html>
<body>
<!--  该域与详细页面中重复导致程序错误 ，请统一在用到该域的页面中添加该域 
<input type="hidden" id="q_bdqclxxid" value="">-->
<input type="hidden" id="p_clpp" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">车辆品牌</td>
				  <td width="23%" class="pagetd">
				  <select type="select" id="p_clppdm" value="">
				   <option></option>
			       </select>
                  </td>
					<td width="10%" class="pagedistd">车辆型号</td>
				  <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_clxh" value=""></td>
					<td width="10%" class="pagedistd">车辆号牌</td>
				  <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_hphm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发动机号</td>
			      <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_fdjh" value=""></td>
				    <td width="10%" class="pagedistd">车架号</td>
				  <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_cjh" value=""></td>
					<td width="10%" class="pagedistd">机动车所有人</td>
				  <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_syr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">初次登记时间</td>
				  <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_ccdjrq" value=""></td>
					<td width="10%" class="pagedistd">立案编号</td>
			      <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_ajbh" value=""></td>
				    <td width="10%" class="pagedistd">&nbsp;</td>
			      <td width="23%" class="pagetd">&nbsp;</td>
		        </tr>
		        <tr>
				    <td width="10%" class="pagedistd">报案时间</td>
			      <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_lasjF" value=""></td>
			      <td width="10%" class="pagedistd">至</td>
			      <td width="23%" class="pagetd"><input type="text"  class="inputstyle"id="p_lasjT" value=""></td>
			       <td width="10%" class="pagedistd">&nbsp;</td>
			      <td width="23%" class="pagetd">
                  <table  width="90" border="0" align="right"  cellpadding="2"  cellspacing="0">
                  <tr>
                    <td width="33%" class="querybutton"><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                    <td width="33%" class="addbutton"><a href="#" class="submitlongbutton" onclick='gaojichaxun_bdqclxx();'>高级查询</a>
                    <td width="33%" class="addbutton"><a href="#" class="exceldcbutton" id='bdqclxxExcel' onclick='setExportExcel();'>导出</a></td>
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
<div id="bdqclxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	
<div id="BdqclxxData" style="width:100%;">
	<table id="BdqclxxTable" width="100%">
	  <thead>
	    <tr>
	        <th name="l_syr" datatype="String" sumflag="0">机动车所有人</th>
	        <th name="l_hphm" datatype="String" sumflag="0">车牌号</th>
	        <th name="l_clpp" datatype="String" sumflag="0">车辆品牌</th>
	        <th name="l_clxh" datatype="String" sumflag="0">车辆型号</th>
	        <th name="l_fdjh" datatype="String" sumflag="0">发动机号</th>
	        <th name="l_cjh" datatype="String" sumflag="0">车架号</th>
	     	<th name="l_ccdjrq" datatype="String" sumflag="0">登记日期</th>
	     	<th name="l_ajbh" datatype="String" sumflag="0">案件编号</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>
</html>