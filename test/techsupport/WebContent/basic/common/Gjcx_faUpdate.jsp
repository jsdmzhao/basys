<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	//$("#a_ickslid").attr("value",dataid);
	$("#a_gjcxfamc").focus();
}); 

function fanganAddValidate(){
	if (!checkControlValue("a_gjcxfamc","String",1,200,null,1,"方案名称"))
		return false;
	return true;
}

function getFangan(){
	if(fanganAddValidate()){	
		setAdd_fangan();
		hideFanganAdd();
	}
}

function setAdd_fangan(){
	dataid = "sjbjgid";
	var pptjList = new Array("Pptj_tableData","Pxgz_tableData");
	setParams("a_",pptjList);
	jQuery.post("basicsystem/insert_gjcxfa.action",params,update_gjcxfaback,"json"); 
}

function update_gjcxfaback(json){

}

function hideFanganAdd(){
	$("#gjcx_detail").hide("show");
}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
 <tr>
      <td align="left" class="title1" colspan="2">高级查询方案维护</td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" id="detail" > 
	<tr height="20">
		<td width="9%" class="distd" ></td>
	  <td width="91%" class="detailtd"><input type="text" class="inputstyle" id="a_gjcxfamc" /></td>
  </tr>
	<tr height="15"><td align="center" colspan="2">
		<table>
			<tr>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='getFangan();'>保存</a></td>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='hideFanganAdd();'>关闭</a></td>
			</tr>
		</table>
	</td>
</tr>
</table>