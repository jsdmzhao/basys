<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>request</title>
</head>
<body>
	<form action="submit.jsp" method="post" >
		<input type="hidden"  name="taskId"  value="${param.id }"/>
		天数<input type="text" name="day"/> 申请人<input type="text" name="owner"  value="${sessionScope['username'] }"> <input type="submit"  value="do it"/>
	</form>
</body>
</html>