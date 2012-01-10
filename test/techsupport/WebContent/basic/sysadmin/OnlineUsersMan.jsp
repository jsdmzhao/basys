<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">

$(document).ready(function() {
	pageUrl="sysadmin/querylist_onlineUsers.action";
	divnid="OnlineUsersData";
	tableid="OnlineUsersTable";

	loadPage(divnid);
	setPageList(1);
	
}); 
	
function setPageList(pageno,url){	
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
                                        noSortColIndex:[0,1,2,3,4],
										url: url,	
										height: pageHeight - 150,
										pageNumber: pageno,
										ingridPageParams:sXML,
										onRowSelect:null,
										colWidths: ["13%","25%","30%","14%","18%"]									
									});				

}	
</script>
<html>
	<body>
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="3"></td>
			</tr>
		</table>
		
		<div id="OnlineUsersData" style="width:100%;">
			<table id="OnlineUsersTable" width="100%">
				<thead>
					<tr>
						<th name="l_userid">
							用户ID
						</th>
						<th name="l_username">
							用户名
						</th>
						<th name="l_departmentname">
							所属单位
						</th>
						<th name="l_loginip">
							登录IP
						</th>
						<th name="l_logintime">
							登录时间
						</th>
						
					</tr>
				</thead>
			</table>
		</div>
	</body>
</html>
