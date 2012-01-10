<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
	String userbm = "";
	User user= (User)session.getAttribute(Constants.userKey);
	if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
		userbm = user.getSsdwbm();
	}
%>
<html>
<head>
<script type="text/javascript">
	var skjl_tables="";
	var skjl_pageUrl="icksystem/querylistCsrzSkjl_qyryskjl.action";
	var skjl_divnid="tabledata";
	var skjl_tableid="table1";
	var skjl_detailHtml="basic/publicsystem/QyryskjlDetail.jsp";
	var skjl_detailid="csryskjl_detail";
	var skjl_detailUrl="icksystem/query_qyryskjl.action";
	var skjl_detailWidth="300";
	var qybm="<%=userbm %>";
	$(document).ready(function(){
		skjl_loadPage("tabledata");
		$("#p_sksjf").datepicker().attr("readonly","true");
		$("#p_sksjt").datepicker().attr("readonly","true");
		$("#p_qybm").attr("value",qybm);
		$("#p_hylbdm").selectBoxhylb();//行业类别
		if($("#p_hylbdm").val()!="J"){
			$('body').find('div [@id=qy]').each(function(){
				$(this).show();
			});
			$('body').find('div [@id=cs]').each(function(){
				$(this).hide();
			});
		}
	});
	
	function skjl_setPageList(pageno,url){	
		url=skjl_setList(pageno,url);
		var mygrid1 = $("#"+skjl_tableid).ingrid({ 
							url: url,
							ingridPageParams:sXML,
							height: pageHeight-206,
							pageNumber: pageno,
							onRowSelect: function(tr, selected){  },
							colWidths: ["17%","17%","18%","18%","16%","16%"]
					});				
	}
	function skjl_loadPage(divpageid){
		skjl_tables=$("#"+divpageid).html();
		$("#"+skjl_detailid).hide(); 	
		skjl_setPageList(1,'#');
	}
	function skjl_setList(pageno,url){	
		$("#"+skjl_divnid).html(skjl_tables);
		setParams("p_");
		if (url==null || url=="undefined"){
			url=skjl_pageUrl;
		}
		return url;
	}
	function meclose(){
		$("#ylcsjbxx_detail").hideAndRemove("show");
		$("#ylcsjbxx_detail").empty();
	}
</script>
</head>
<body>
<input type="hidden" id="d_skxxtjmxid">
<input type="hidden" id="p_qybm">

<div style="display:none"><select id="p_hylbdm"></select></div>

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">刷卡记录</td>
  </tr>
  <tr>
    <td>
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
    		<tr>
			    <td class="pagedistd">从业人员编号</td>
			    <td class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh"></td>
    			<td class="pagedistd">刷卡时间</td>
			    <td class="pagetd">
			    <input type="text" class="inputstyle" id="p_sksjf" style="width:80px;"> 至  
			    <input type="text" class="inputstyle" id="p_sksjt" style="width:80px;"></td>
    		 	<td colspan="2" align="right">
   		  	  			<table width="100" border="0"  cellpadding="2" cellspacing="0">
                    		<tr>
                      			<td ><a href="#" class="searchbutton" id="querys" onClick="skjl_setPageList(1);">查询</a></td>
                    		</tr>
                		</table>
   		  	  	</td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>

<div id="csryskjl_detail"  class="page-layout" src="#" style="top:180px; left:160px; width:500px;"></div>

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_xmzc">注册人员</th>
	     	<th name="l_xmfzc">非注册人员</th>
	     	<th name="l_scyrybh">从业人员编号</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_sksj">刷卡时间</th>
	     	<th name="l_scsj">入库时间</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>