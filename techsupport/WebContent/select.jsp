<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page   import="java.util.*,java.net.*"   %>   

<html>
<% 
   //String sslport1 = request.getContextPath();
   //String sslport = request.getRequestURI();
   // String sslport = InetAddress.getLocalHost().getHostAddress();
  
   
   String path = request.getContextPath(); 
   //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
   String basePath = "https://"+request.getServerName()+":9443"+path+"/login-ca.jsp"; 
   //out.println(basePath);
%>
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script  src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="javascript/jquery.alerts.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
  $(document).ready(function (){
  
    $('#yonghu').click(function (){
       window.location="login-ca.jsp";
    });
    
    $('#cazhengshu').click(function (){
      
      //window.location="https://localhost:9443/scpt1/login.jsp";
      window.location="<%=basePath%>";
    });
    
    
  });
  
</script>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<p>
  <!-- ImageReady Slices (登录.psd) -->
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="477" height="329" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
<tr>
		<td colspan="3">
			<img src="images/select/select_01.gif" width="477" height="114" alt=""></td>
	</tr>
	<tr>
		<td rowspan="4">
			<img src="images/select/select_02.gif" width="175" height="215" alt=""></td>
		<td>
			<a href="#"><img src="images/select/select_03.gif" alt="用户名登陆" width="153" height="32" border="0" id="yonghu" ></a></td>
<td rowspan="4">
			<img src="images/select/select_04.gif" width="149" height="215" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/select/select_05.gif" width="153" height="11" alt=""></td>
	</tr>
	<tr>
		<td>
			<a href="#"><img src="images/select/select_06.gif" alt="CA证书登陆" width="153" height="32" border="0" id="cazhengshu" ></a></td>
  </tr>
	<tr>
		<td>
			<img src="images/select/select_07.gif" width="153" height="140" alt=""></td>
	</tr>
</table>
<!-- End ImageReady Slices -->
</body>
</html>