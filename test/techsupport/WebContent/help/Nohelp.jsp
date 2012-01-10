<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.domain.User" %>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<html>
<head>
<script type="text/javascript">
   function closeAndRemovehelp(){
		$("#man_help").children().remove();
		$("#man_help").hideAndRemove("show");
	}
</script>

</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">帮助信息</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeAndRemovehelp();' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="20"></td>
		</tr>
	</table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center">暂无帮助信息</td>
		</tr>
	</table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="20"></td>
		</tr>
	</table>


</body>
</html>