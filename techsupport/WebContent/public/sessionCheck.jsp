<%@ page import="com.aisino2.sysadmin.Constants"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<script language="JavaScript">
<%
String sUserName=((User)session.getAttribute(Constants.userKey)).getUsername();
if (sUserName==null){
%>
	alert("您太长时间没有使用或登录本系统！请重新登录");
	top.window.location="../login.jsp";
<%}%>
</script>