<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String context_path = request.getContextPath();
	String javascript_home = context_path + "/public/javascript";
%>

<script type="text/javascript">
	/** 上下文路径 */
	context_path = '<%=context_path%>';
	
</script>