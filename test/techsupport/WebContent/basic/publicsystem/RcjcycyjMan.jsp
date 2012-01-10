<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%@include file="../../public/common.jsp" %>
<%
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	String deptCode = user.getDepartment().getDepartcode();
 %>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="publicsystem/querylistRcjcycyj_publicrcjc.action";
	divnid="MjjczslData";
	tableid="MjjczslTable";
	addUrl="mjjczsystem/insert_mjjczsl.action";
	addHtml="basic/mjjczsystem/MjjczslAdd.jsp";
	addWidth="800";
	delUrl="mjjczsystem/delete_mjjczsl.action";
	delid="d_mjjczid";
	modHtml="basic/mjjczsystem/MjjczslModify.jsp";
	modUrl="mjjczsystem/modify_mjjczsl.action";
	modWidth="400";
	detailHtml="basic/publicsystem/RcjcDetail.jsp";
	detailid="rcjc_detail";
	detailUrl="publicsystem/query_publicrcjc.action";
	detailWidth="550";
	daggleDiv("rcjc_detail");
	rcjcycyj_loadPage(divnid);
		$("#p_hylbdm").selectBoxhylb({code:"dm_hylb"});
		$("#p_jcrqf").attr("readonly","true");
		$("#p_jcrqf").datepicker();	
		$("#p_jcrqt").attr("readonly","true");
		$("#p_jcrqt").datepicker();	
}); 
	
function rcjcycyj_setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: pageHeight-230,
                                       ingridPageParams:sXML,
										pageNumber: pageno,
										colWidths: ["25%","25%","20%","10%","10%","15%"]									
									});				
		}
}	
	function manVerify(){
		//if (!checkControlValue("p_gajgmc","String",1,60,null,0,"公安机关名称"))
		//	return false;
		return true;
	}
	function rcjcycyj_loadPage(divpageid){
		tables=$("#"+divpageid).html();
		$("#"+detailid).hide(); 	
		rcjcycyj_setPageList(1,'#');
	}
	$("#p_jcjgmc").click(function(){// 公安机关
		getGxdwTree("p_jcjgmc","p_jcjgdm");
	});
	//详情
function setQuery(id){
	dataid=id;
	rcjcFlag='rcjcycyj';
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}
</script>

<body>
	
<input type="hidden" id="d_rcjcid" >
<input type="hidden" id="p_jcjgdm" value="<%=deptCode %>" />
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">日常检查异常预警查询</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><select id="p_hylbdm" class="inputstyle" value=""></select></td>
					<td width="10%" class="pagedistd">检查机构名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jcjgmc" class="inputstyle" value="" readonly="true"></td>
					<td width="10%" class="pagedistd">检查时间</td>
						<td width="23%" class="pagetd"><input type="text" id="p_jcrqf" class="inputstyle1" value="">
						至
						<input type="text" id="p_jcrqt" class="inputstyle1" value=""></td>
				<tr>
					<td colspan="6">
	    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
	    		    	<tr align="right">
	    		    	  <td width="55%" ><a href="#" class="searchbutton" id="querys" onclick="rcjcycyj_setPageList(1);">查询</a></td>
	    		    	</tr>
	    		  	</table>
	    		  </td>
	    		  </tr>
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
<div id="rcjc_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="MjjczslData" style="width:100%;">
	<table id="MjjczslTable" width="100%">
	  <thead>
	    <tr>       
	    	<th name="l_jcjg">检查机构</th>
	     	<th name="l_mjjczbh">民警检查证编号</th>
	     	<th name="l_gajgmc">检查时间</th>
	     	<th name="l_jyh">警号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_slsj">职务</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>