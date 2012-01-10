<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="sysadmin/querylist_loginlog.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="sysadmin/insert_loginlog.action";
	addHtml="basic/sysadmin/LoginlogAdd.jsp";
	addWidth="260";
	delUrl="sysadmin/delete_loginlog.action";
	delid="d_loginlogid";
	modHtml="basic/sysadmin/LoginlogModify.jsp";
	modUrl="sysadmin/modify_loginlog.action";
	modWidth="260";
	detailHtml="basic/sysadmin/LoginlogDetail.jsp";
	detailid="loginlog_detail";
	detailUrl="sysadmin/query_loginlog.action";
	detailWidth="300";
	loadPage("tabledata");
		$("#p_logintiimef").attr("readonly","true");
		$("#p_logintiimef").datepicker();
		$("#p_logintiimet").attr("readonly","true");
		$("#p_logintiimet").datepicker();
	setPageList(1);
	
	daggleDiv("loginlog_detail");
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
										height: pageHeight-234,
										pageNumber: pageno,
										colWidths: ["20%","20%","20%","20%","20%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_username","String",1,200,null,0,"用户名"))
			return false;
		if (!checkControlValue("p_useraccount","String",1,200,null,0,"用户帐号"))
			return false;
		if (!checkControlValue("p_loginip","String",1,20,null,0,"登录IP"))
			return false;
		if (!checkControlValue("p_logintiimef","Date",null,null,null,0,"登录时间"))
			return false;
		if (!checkControlValue("p_logintiimet","Date",null,null,null,0,"登录时间至"))
			return false;
		return true;
	}
</script>

</head>
<body>
	
	<input type="hidden" id="d_loginlogid" value="">	
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">登录日志管理</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">用户名</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_username" value=""></td>
					<td width="10%" class="pagedistd">用户账号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_useraccount" value=""></td>
					<td width="10%" class="pagedistd">登录IP</td>
			      <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_loginip" value=""></td>
		  </tr>
				<tr>
					<td width="10%" class="pagedistd">登录时间</td>
				  <td class="pagetd"><input type="text" class="inputstyle"  id="p_logintiimef" value=""> 
				  </td>
					<td width="10%" class="pagedistd">至 </td>
				  <td class="pagetd">  
			        <input type="text" class="inputstyle"  id="p_logintiimet" value=""></td>
			      <td colspan="2" class="pagetd"><table width="80" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="100%" align="center" height="28px" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
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
<div id="loginlog_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_useraccount">用户账号</th>
	     	<th name="l_username">用户名称</th>
	     	<th name="l_loginip">登录IP</th>
	     	<th name="l_loginmac">MAC地址</th>
	     	<th name="l_logintiime">登录时间</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>