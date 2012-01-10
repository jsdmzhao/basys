<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>

<%
//获取内外网值nwwbz
String nwwbz=(String)session.getAttribute("nwwbz");
String rcjc=(String)session.getAttribute("rcjc");

%>

<script type="text/javascript">

$(document).ready(function() {
	var nwwbz="<%=nwwbz %>";
	var rcjc="<%=rcjc %>";
	//通过内外网标志添加页面
	 if(nwwbz=='0'&&rcjc=='1'){
		//内网且不显示添加按钮，修改、删除、处理
		$("#rcjcman").load("basic/publicsystem/RcjcQuery.jsp");
	}else{
		//外网，允许添加
		$("#rcjcman").load("basic/publicsystem/RcjcManAdd.jsp");
	}
}); 

</script>

<body>
<div id="rcjcman"></div>
</body>
