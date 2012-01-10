<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.common.DepartmentUtil"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
String departName = user.getDepartment().getDepartname();
while(departCode.length()<12){
		departCode += "0";
}
String departTemp = departCode.substring(0,8);
String sdfjksdFlage = ""; //省地分局科所队 标志
String isZxs = "0";
if(DepartmentUtil.departIsZxs(departTemp)){ //直辖市
	isZxs = "1";
}
if(departTemp.contains("000000")){ //省厅
	sdfjksdFlage = "1";
	if("1".equals(isZxs)){ //直辖市既然是市则转到地市
		sdfjksdFlage = "2";
	}
	
}else if(departTemp.contains("0000")) { //地市
	sdfjksdFlage = "2";
}else if(departTemp.contains("00")) { //分局
	sdfjksdFlage = "3";
}else{ //科所队
	sdfjksdFlage = "4";
}
%>
<script type="text/javascript">
var js_sdfjksdFlage = '<%=sdfjksdFlage %>';
var js_departCode = '<%=departCode %>';
var departName = '<%=departName%>';
var isZxs = '<%=isZxs %>';
</script>
