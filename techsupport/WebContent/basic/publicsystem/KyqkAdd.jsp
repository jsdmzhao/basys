<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(); //将保存按钮右移
		$("#a_bgsj").attr("readonly","true");
		//$("#a_bgsj").datepicker();
		$("#a_djxh").attr("readonly","true");
		$("#a_kyqklxbm").selectBox({code:"dm_kyqklx"});
		//var kyqkUrl = "publicsystem/initinsert_kyqk.action";
		//jQuery.post(kyqkUrl,params,initkyqkAdd,"json"); 
		$("#a_tbrxm").click(function(){
		    dataid="";
		    getTyRY_item("a_tbrxm","a_tbrbh","","","");
	    });
		
	}); 
	function addVerify(){
		//if (!checkControlValue("a_djxh","String",1,20,null,1,"登记序号"))
			//return false;
		if (!checkControlValue("a_tbrbh","String",1,21,null,1,"填报人编号"))
			return false;
		if (!checkControlValue("a_tbrxm","String",1,100,null,1,"填报人姓名"))
			return false;
		if (!checkControlValue("a_kyqklxbm","Select",1,100,null,1,"可疑情况类型"))
			return false;
		if (!checkControlValue("a_ydxxms","String",1,2000,null,1,"疑点详细描述"))
			return false;		
		return true;
	}
	
	function initkyqkAdd(json){
	
	  document.getElementById("a_kyqkdjxh").value = json.djxh;
	}
	function setAddkyqk(){
	
	if (addVerify()){
	    $("#a_kyqklx").attr("value",$("#a_kyqklxbm").attr("title"));
		setParams("a_");
		jQuery.post(addUrl,params,addback,"json");
	}
}
</script>
<input type="hidden" id="a_kyqklx" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">可疑情况添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#kyqk_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td width="17%" class="distd">可疑情况登记序号</td>
		<td width="30%" class="detailtd"><input type="text" class="readonly" readonly="readonly"  id="a_kyqkdjxh" value="" /></td>
		<td width="18%" class="red">可疑情况类型</td>
		<td width="28%" class="detailtd"><select id="a_kyqklxbm"><option value=""></option></select></td>
	</tr>
	<tr height="20">
		<td class="red">填报人编号</td>
		<td class="detailtd"><input type="text" class="readonly"  id="a_tbrbh" value="" readonly/></td>
	  <td class="red">填报人姓名</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_tbrxm" value="" readonly/></td>
	</tr>
	<tr height="20">
		<td valign="top" class="red">疑点详细描述</td>
<td colspan="5" class="detailtd">
		  <textarea name="textarea" id="a_ydxxms"  cols="55" rows="5"></textarea>
    </td>
	</tr>
	<tr height="25" align="center"><td colspan="6"><a href="#" id="addbutton"  class="submitbutton"  onclick='setAddkyqk();'>保存</a></td></tr>
</table>
