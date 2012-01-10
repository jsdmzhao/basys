<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>
	<head>
		<title></title>
		<!-- 修改 -->
		<link rel="stylesheet" type="text/css"
			href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" />
		<script language="javascript">  
 
 function fnquery(roleid) 
 {
   rightMainTreeRole(roleid);
     
}
</script>
	</head>
	<body>	
		<table id="role_treeTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top">
					<div class="treediv">
						<!--表单样式开始 -->
						<table width="100%" border='0' align="center" cellpadding="1" cellspacing="3" class="titleTable">
							<tr>
								<td style="font-weight: bold">
									角色列表
								</td>
							</tr>
						</table>
						<table width="100%" height="94.3%" border='0' align="center" cellpadding="1" cellspacing="1" class="listTable">
							<tr>
								<td class="listTD" valign="top">
									<table width="100%" cellspacing="0" cellpadding="0" border='0'>
										<tr>

											<td align="left">
												<Div id="list1" class="titleTablenei">
													<%@ include file="roleList.jsp"%>
												</Div>
											</td>
										</tr>


									</table>

								</td>

							</tr>


						</table>
					</div>
				</td>
				<td width="4">
					<img name="" src="" width="4" height="1" alt="">
				</td>
				<td valign="top">
					<div class="textdiv" id="roleManager"
						onload='$("roleManager").show("slow");'>
					</div>

				</td>
			</tr>
		</table>
	</body>

	<script>
$("#list1").height(pageHeight-137);
//var listdict_code =0;
  function rightMainTreeRole(roleid){
	$("#roleManager").empty();
			$("#roleManager").load("sysadminDefault/queryRoleUser_user.action?roleid="+roleid);
			$("#roleManager").show("slow"); 
	}
	//rightMainDictItem();
</script>

</html>