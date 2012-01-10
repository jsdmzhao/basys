<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(25,'提交'); //将保存按钮右移
		$("#q_kyqkid").attr("value",dataid);
		$("#m_kyqkid").attr("value",dataid);
		setDetail();
		$("#m_djxh").attr("readonly","true");
		//$("#m_bgrbh").attr("readonly","true");
		$("#m_kyqklxbm").selectBox({code:"dm_kyqklx"});
		$("#m_tbrxm").click(function(){
		    dataid="";
		    getTyRY_item("m_tbrxm","m_tbrbh","","","");
	    });
	}); 
	
	/////回调函数
	function updatediv(json){ 
		
		$("#m_kyqkdjxh").attr("value",setNull(json.LKyqk[0].kyqkdjxh));
		$("#m_tbrbh").attr("value",setNull(json.LKyqk[0].tbrbh));
		$("#m_tbrxm").attr("value",setNull(json.LKyqk[0].tbrxm));
		//$("#m_bgsj").attr("value",setNull(json.LKyqk[0].bgsj));
		/////$("#m_kyqklx").attr("value",setNull(json.LKyqk[0].kyqklx));
		$("#m_ydxxms").attr("value",setNull(json.LKyqk[0].ydxxms));
		$("#m_kyqklxbm").setValue(setNull(json.LKyqk[0].kyqklxbm));
		
	}	
	function modifyVerify(){
	
	    
		//if (!checkControlValue("m_djxh","String",1,20,null,1,"登记序号"))
		//	return false;
		if (!checkControlValue("m_tbrbh","String",1,21,null,1,"填报人编号"))
			return false;
		if (!checkControlValue("m_tbrxm","String",1,100,null,1,"填报人姓名"))
			return false;
		
		//if (!checkControlValue("m_bgsj","Date",null,null,null,1,"报告时间"))
			//return false;
		
		if (!checkControlValue("m_kyqklxbm","Select",1,100,null,1,"可疑情况类型"))
			return false;
		if (!checkControlValue("m_ydxxms","String",1,2000,null,1,"疑点详细描述"))
			return false;
	   
		$("#m_kyqklx").attr("value",$("#m_kyqklxbm").attr("title"));
		///为隐藏域赋值
		
		return true;
	}
</script>
<input type="hidden" id="q_kyqkid">
<input type="hidden" id="m_kyqkid">
<input type="hidden" id="m_kyqklx" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">可疑情况修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#kyqk_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td width="17%" class="distd">可疑情况登记序号</td>
		<td width="30%" class="detailtd"><input type="text" class="readonly"  readonly="readonly"  id="m_kyqkdjxh" value="" /></td>
		<td width="15%" class="red">可疑情况类型</td>
		<td width="30%" class="detailtd"><select id="m_kyqklxbm"><option value=""></option></select></td>
		<td width="4%" class="distd"></td>
		<td width="4%" class="detailtd"></td>
	</tr>
	<tr height="20">
		<td class="red">填报人编号</td>
		<td class="detailtd"><input type="text" class="readonly"  id="m_tbrbh" value="" readonly/></td>
	  <td class="red">填报人姓名</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_tbrxm" value="" readonly/></td>
		<td class="distd">&nbsp;</td>
	    <td class="detailtd">&nbsp;</td>
	</tr>
	<tr height="20">
		<td class="red">疑点详细描述</td>
		<td colspan="5" class="detailtd">
		  <textarea name="textarea" id="m_ydxxms"  cols="55" rows="5"></textarea>
    </td>
	</tr>
	<tr height="25" align="center"><td colspan="6"><a href="#" id="addbutton"  class="submitbutton"  onclick='setUpdate();'>提交</a></td></tr>
</table>
