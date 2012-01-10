<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var tableRolePurview=$("#FuncListData").html();
	var state=0;
	$(document).ready(function() {
		$("#x_userid").attr("value",dataid);
		$("#n_userid").attr("value",dataid);
		
		setParams("x_");
		jQuery.post('sysadmin/queryUsreRoleList_user.action',params,getUserRoleBack,"json");
		
		$("#deptRole").empty();
		$("#deptRole").load("sysadminDefault/deptTreeUser_roleForm_tree.action?treeFalg=user_role");
	});
	function getUserRoleBack(json){
		for(var i=0;i<json.userRoleList.length;i++){
			var objOption = "<option value='"+json.userRoleList[i].roleid+"' "
				+"id='"+json.userRoleList[i].departid+"'>"+json.userRoleList[i].rolename+"</option>";
			$("#userRolelist").append($(objOption));
		}
	}
	
	function moveOptionUp(){
		$("#departRolelist option:selected").each(function(){
			moveUp(this);
			$(this).remove();
		});
	}
	function moveOptionUpAll(){
		$("#departRolelist option").each(function(){
			moveUp(this);
			$(this).remove();
		});
	}
	function moveUp(objOption){
		if(!valIsHave('userRolelist',$(objOption).attr("value"))){
			var objOption = "<option value='"+$(objOption).attr("value")+"'"
			+" id='"+$(objOption).attr("id")+"'>"+$(objOption).text()+"</option>";
			$("#userRolelist").append($(objOption));
		}
	}
	function moveOptionDown(){
		$("#userRolelist option:selected").each(function(){
			moveDown(this);
			$(this).remove();
		});
	}
	function moveOptionDownAll(){
		$("#userRolelist option").each(function(){
			moveDown(this);
			$(this).remove();
		});
	}
	function moveDown(objOption){
		if(!valIsHave('departRolelist',$(objOption).attr("value"))){
			if($("#o_departid").attr("value")==$(objOption).attr("id")){ //机构相同才可以下移
				var objOption = "<option value='"+$(objOption).attr("value")+"'"
				+" id='"+$(objOption).attr("id")+"'>"+$(objOption).text()+"</option>";
				$("#departRolelist").append($(objOption));
			}
		}
	}
	function valIsHave(idname,objOptionVal){
		var isHave = 0;
		$("#"+idname+" option").each(function(){
			if($(this).attr("value")==objOptionVal){
				isHave = 1;
				return;
			}
		});
		if(isHave==1) return true; //有
		return false;
	}
	function updateUserRole(){ //用户角色修改
		var roleidString = '';
		$("#userRolelist option").each(function(){
			roleidString = roleidString+$(this).attr("value")+'|'
		});
		$("#n_roleidString").attr("value",roleidString);
		setParams("n_");
		jQuery.post('sysadmin/updateUserRole_user.action',params,updateUserRoleBack,"json");
	}
	function updateUserRoleBack(json){
		if  (json.result=="success"){
			jAlert('保存成功','保存信息');
			$("#user_detail").hideAndRemove("show");
		}else{
			jAlert(json.result,'错误信息');
		}
	}
</script>
<input type="hidden" id="x_userid">
<input type="hidden" id="n_userid">
<input type="hidden" id="n_roleidString">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">角色管理</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#user_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
    <tr>
		<td height="3"></td>
	</tr>
</table>
<!--角色管理开始-->	
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
<td>
	<table width="100%" cellspacing="0" cellpadding="0" class="line" >
	<tr><td>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
			<tr><td class="queryfont" colspan="4">&nbsp;已选择角色</td></tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="tdbg">
			<tr>
				<td valign="top" class="tdbg" colspan="4">
				<select id="userRolelist" style="width:800; height:140" multiple="multiple">
				
				</select>
				</td>
			</tr>
			<tr><td>
				<table width="120" border="0" cellspacing="0" cellpadding="2">
  <tr>
<td width="29%" height="28px" ><a href="#" class="submitbutton" onclick="moveOptionUpAll();">全部上移</a></td>
				<td width="22%" ><a href="#" class="submitbutton" onclick="moveOptionUp();">上移</a></td>
				<td width="24%" ><a href="#" class="submitbutton" onclick="moveOptionDown();">下移</a></td>
				<td width="25%" ><a href="#" class="submitbutton" onclick="moveOptionDownAll();">全部下移</a></td>
  </tr>
</table>
	</td></tr>
	    </table>	
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><td class="queryfont">&nbsp;未选择角色</td></tr>
			<tr>
				<td valign="top" class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="1">
					<tr>
						<td valign="top" class="pagetd1">
							<div id="deptRole"></div>
						</td>
					</tr>
	 				</table>
 				</td>
			</tr>
		</table>
	</td></tr>
	</table>
</td>
</tr>
</table>
<!--角色管理结束-->
<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="tdbg">
	<tr><td height="3"></td></tr>
	<tr><td align="center">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='updateUserRole();'>保存</a>
	</td></tr>
</table>