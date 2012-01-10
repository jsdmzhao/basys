<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(45);
		$("#qzzl").selectBox({code:"dm_qzzl(ylybzh)"});

		$("#a_hzzlmc").click(function(){
			getDict_item("a_hzzlmc","a_hzzldm","dm_yxzj(wgtzr)");
		});
		qzzlOnchange();
	});
	function wgtzrxxGjOnclick(){
		getDict_item("a_gj","a_gjdm","dm_gj(lgy)");
	}
	
	function qzzlOnchange(){ //签证种类
		var qzzlkey = $("#qzzl").attr("value");
		var qzzlval = $("#qzzl").attr("title");
		$("#a_qzzldm").attr("value",qzzlkey);
		$("#a_qzzlmc").attr("value",qzzlval);
	}
	function wgtzrxx_addVerify(){
		if (!checkControlValue("a_tzzxm","String",1,100,null,1,"境外投资者名称"))
			return false;
		if (!checkControlValue("a_gj","String",1,100,null,1,"国家和地区"))
			return false;
		if (!checkControlValue("a_hzzlmc","String",1,100,null,1,"有效证件种类"))
			return false;	
		if (!checkControlValue("a_hzhm","String",1,20,null,1,"有效证件种类号码"))
			return false;
		if (!checkControlValue("a_qzhm","String",1,20,null,0,"签证签注号码"))
			return false;
		if (!htjdOnBlurNotOnlyZfVal('a_wgtzrLxdh','dh','1','‘联系电话’','0','1')){
			return false;
		}
		if (!checkControlValue("a_wgtzrLxdh","String",1,30,null,1,"联系电话"))
			return false;
		
		return true;
	}
	
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">境外投资者信息添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#wgtzrxx_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr><td height="10"></td></tr>
	<tr>
		<td class="red" width="43%">境外投资者名称</td>
		<td class="detailtd" width="57%"><input type="text" class="inputstyle"  id="a_tzzxm" 
			onkeyup="htjdOnkeyupVal('a_tzzxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_tzzxm','xingming','0','‘境外投资者名称’');"/></td>
	</tr>
	<tr>
		<td class="red">国家和地区</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_gj" readonly onclick="wgtzrxxGjOnclick();"></td>
        <input type="hidden" id="a_gjdm" value="">
	</tr>
	<tr>
		<td class="red">有效证件种类</td>
	    <td class="detailtd">
        <input type="hidden" id="a_hzzldm" />
        <input type="text" id="a_hzzlmc" class="inputstyle" readonly />
        </td>
	</tr>
	<tr>
		<td class="red">有效证件号码</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="a_hzhm"
	    	onkeyup="htjdOnkeyupVal('a_hzhm','hz');" onblur="htjdOnBlurNotOnlyZfVal('a_hzhm','hz','0','‘护照号码’');"/></td>
	</tr>
	<tr>
		<td class="distd">签证签注种类</td>
		<td class="detailtd">
	    <select name="select" id="qzzl" onchange="qzzlOnchange();"></select></td>
	    <input type="hidden" id="a_qzzldm" value="">
        <input type="hidden" id="a_qzzlmc" value="">
	</tr>
	<tr>
		<td class="distd">签证签注号码</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="a_qzhm"	
	    	onkeyup="htjdOnkeyupVal('a_qzhm','jyxk');" onblur="htjdOnBlurNotOnlyZfVal('a_qzhm','jyxk','0','‘签证号码’');"/></td>
	</tr>
	<tr>
		<td class="red">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_wgtzrLxdh" 
			onkeyup="htjdOnkeyupVal('a_wgtzrLxdh','dh');" onblur="htjdOnBlurNotOnlyZfVal('a_wgtzrLxdh','dh','0','‘联系电话’','0','1');"/></td>
	</tr>
	<tr height="20">
	  <td class="distd"><input type="checkbox" name="checkbox" id="wgtzrxx_checkbox" />继续</td>
	  <td align="right" style="padding-right: 25"><a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='wgtzrxx_setAdd();'>保存</a></td>
	</tr>
	<tr><td height="10"></td></tr>
</table>
