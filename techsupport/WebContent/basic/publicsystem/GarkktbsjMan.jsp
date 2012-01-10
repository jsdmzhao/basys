<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_garkktbsj.action";
	divnid="GarkktbsjData";
	tableid="GarkktbsjTable";
	addUrl="publicsystem/insert_garkktbsj.action";
	addHtml="business/publicsystem/GarkktbsjAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_garkktbsj.action";
	delid="d_garkktbsjid";
	modHtml="business/publicsystem/GarkktbsjModify.jsp";
	modUrl="publicsystem/modify_garkktbsj.action";
	modWidth="800";
	detailHtml="business/publicsystem/GarkktbsjDetail.jsp";
	detailid="garkktbsj_detail";
	detailUrl="publicsystem/query_garkktbsj.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["10%","10%","10%","10%","10%","10%","10%","10%","10%","10%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_garkktbsjid","Integer",-9999999999,9999999999,null,0,"公安人口库同步数据ID"))
			return false;
		if (!checkControlValue("p_gmsfzhm","String",1,20,null,0,"公民身份证号码"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_mz","String",1,30,null,0,"民族"))
			return false;
		if (!checkControlValue("p_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("p_hjsx","String",1,20,null,0,"户籍省县"))
			return false;
		if (!checkControlValue("p_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_zp","byte[]",,,,0,"照片"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_garkktbsjid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">公安人口库同步数据ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_garkktbsjid" value="0"></td>
					<td width="10%" class="pagedistd">公民身份证号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gmsfzhm" value=""></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xb" value=""></td>
					<td width="10%" class="pagedistd">民族</td>
					<td width="23%" class="pagetd"><input type="text" id="p_mz" value=""></td>
					<td width="10%" class="pagedistd">婚姻状况</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hyzk" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">户籍省县</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjsx" value=""></td>
					<td width="10%" class="pagedistd">户籍地详址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxz" value=""></td>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_csrq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">照片</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zp" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="garkktbsj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="GarkktbsjData" style="width:100%;">
	<table id="GarkktbsjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_gmsfzhm">公民身份证号码</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_mz">民族</th>
	     	<th name="l_hyzk">婚姻状况</th>
	     	<th name="l_hjsx">户籍省县</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_zp">照片</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>