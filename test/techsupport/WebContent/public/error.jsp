<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<%
    String message = String.valueOf(request.getAttribute("error"));
    if(message ==null||"null".equals(message))
    {
        message = String.valueOf(session.getAttribute("error"));
        session.removeAttribute("error");
    }
%>
<title>错误信息页面</title>
<script language=JavaScript>
<!--
function fnreturn(){
	history.back();
}
//-->
</script>
</head>
<body  leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form method = "post">
<table width="778" border="0" cellspacing="0" cellpadding="0" >
  <tr>
  <td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><div align="center"> <br>
              <table width="500" height="300" border="2" align="center"  bgcolor="#FFFFFF" cellpadding="0" bordercolorlight="#CCCCCC" bordercolordark="#999999">
                <tr>
                  <td valign="middle">
                    <div align="center">
                      <table width="400" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="150"><font color="#CC0000"><img src="<%=request.getContextPath()%>/images/error2.jpg" width="148" height="163" align="left"></font></td>
                          <td width="250"><p align="center"><font color="#CC0000">提示：操作失败或数据库连接失败！<br>点击返回重新操作！</font></p>
                            <div align="center"><img src="<%=request.getContextPath()%>/images/b-back.gif" width="37" height="18" onclick ="JavaScript:fnreturn()">
                            </div></td>
                        </tr>
                      </table>

                    </div></td>
                </tr>
              </table>
              <br>
            </div></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
