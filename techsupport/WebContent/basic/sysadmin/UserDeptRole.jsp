<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		setParams("o_");
		jQuery.post('sysadmin/queryDeptRoleList_user.action',params,getDepartRoleBack,"json");
	}); 
	function getDepartRoleBack(json){
		for(var i=0;i<json.deptRoleList.length;i++){
			if(!valIsHave('userRolelist',json.deptRoleList[i].roleid)){ //如果已选角色存在不显示
				var objOption = "<option value='"+json.deptRoleList[i].roleid+"' "
					+" id='"+json.deptRoleList[i].departid+"'>"+json.deptRoleList[i].rolename+"</option>";
				$("#departRolelist").append($(objOption));
			}
		}
		//取得登陆账号用户的具有的角色
		setParams("o_");
		jQuery.post('sysadmin/queryLoginUserRoleListOutDept_user.action',params,getLoginUserRoleListOutDeptBack,"json");
	}

	function getLoginUserRoleListOutDeptBack(json){
		for(var i=0;i<json.loginUserRoleOutDeptList.length;i++){
			if(!valIsHave('userRolelist',json.loginUserRoleOutDeptList[i].roleid)){ //如果已选角色存在不显示
				var objOption = "<option value='"+json.loginUserRoleOutDeptList[i].roleid+"' "
					+" id='"+json.loginUserRoleOutDeptList[i].departid+"'>"+json.loginUserRoleOutDeptList[i].rolename+"</option>";
				$("#departRolelist").append($(objOption));
			}
		}
	}
</script>
<body>
<div class="queryfont">角色列表</div>
<input type="hidden" id="o_departid" value="<%=(String)request.getAttribute("roledepartid") %>">
<input type="hidden" id="n_departid" value="<%=(String)request.getAttribute("roledepartid") %>">
<select id="departRolelist" style="width:590; height:185" multiple="multiple">
</select>
