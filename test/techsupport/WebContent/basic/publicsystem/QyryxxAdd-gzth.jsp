<%@ page language="java" pageEncoding="UTF-8"
	import="com.aisino2.sysadmin.domain.User,com.aisino2.sysadmin.Constants"%>
<%
	User user = (User) session.getAttribute(Constants.userKey);
	String yhlb = "";
	if (user != null) {
		yhlb = user.getUsertype();
		String []yhlbArry = yhlb.split(",");
		int arryLength = yhlbArry.length;
		String oneYhlb;
		for(int index=0;index<arryLength;index++){
			oneYhlb = yhlbArry[index];
			if(oneYhlb.equals("32") || oneYhlb.equals("33")){
				yhlb = "E03";
				break;
			}else if(oneYhlb.equals("52")){
				yhlb = "B";
				break;
			}
		}
	}
%>
<script type="text/javascript">
	$(document).ready(function() {
		var detail_div_loadHtml;
		var hylbdm = "<%=yhlb %>";
		if(hylbdm=="E03"){
			detail_div_loadHtml = "basic/publicsystem/QyryxxAdd-dd.jsp";
		}else if(hylbdm=="B"){
			detail_div_loadHtml = "basic/publicsystem/QyryxxAdd-yz.jsp";
		}else{
			detail_div_loadHtml = "basic/publicsystem/QyryxxAdd.jsp";
		}
		$("#cyryxx_detail_div").load(detail_div_loadHtml);
	});
</script>
<div id="cyryxx_detail_div"></div>
