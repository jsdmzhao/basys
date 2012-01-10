<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(56);
		$("#aqjcsbzl").selectBox({code:"dm_aqjcsbzl"});
		aqjcsbzlOnchange();
	}); 
	function aqjcsb_addVerify(){
		if (!checkControlValue("z_sbmc","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("z_ggxh","String",1,100,null,1,"规格型号"))
			return false;
		if (!checkControlValue("z_azsl","Integer",0,999999,null,0,"安装数量"))
			return false;
		return true;
	}
	function aqjcsbzlOnchange(){
		var aqjcsbzlkey = $("#aqjcsbzl").attr("value");
		var aqjcsbzlval = $("#aqjcsbzl").attr("title");
		$("#z_aqjcsbzlbm").attr("value",aqjcsbzlkey);
		$("#z_aqjcsbzlmc").attr("value",aqjcsbzlval);
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">安全检查设备信息添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#aqjcsb_detail").hide("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr><td height="10"></td></tr>
	<tr>
		<td class="red">设备名称</td>
		<td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="z_sbmc" value=""></td>
	</tr>
	<tr>
	  <td class="red">规格型号</td>
      <td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="z_ggxh" value=""></td>
	</tr>
	<tr>
		<td class="red" width="40%">安全检查设备种类</td>
		<td width="60%" colspan="2" class="detailtd">
		<select name="select" id="aqjcsbzl" onchange="aqjcsbzlOnchange();">
		</select></td>
		<input type="hidden" id="z_aqjcsbzlbm" value="">
		<input type="hidden" id="z_aqjcsbzlmc" value="">
	</tr>
	<tr>
		<td class="distd">安装数量</td>
 		<td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="z_azsl" onkeyup="value=value.replace(/[^\d]/g,'')"
      							onblur="value=value.replace(/[^\d]/g,'')"></td>
	</tr>
	<tr height="20">
	  <td></td>
	  <td  style="padding-bottom:2px; text-align:left"><input type="checkbox" name="checkbox" id="aqjcsb_checkbox" >继续</td>
       <td align="right"><a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='aqjcsb_setAdd();'>保存</a></td>
	</tr>
  <tr><td height="10"></td></tr>
</table>
