<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#a_tbsj2").attr("readonly","true");
		$("#a_tbsj2").datepicker();
		$("#a_bkczsj").attr("readonly","true");
		$("#a_bkczsj").datepicker();
		$("#a_bkdqsj").attr("readonly","true");
		$("#a_bkdqsj").datepicker();
		$("#a_sprq").attr("readonly","true");
		$("#a_sprq").datepicker();
		$("#a_cksj").attr("readonly","true");
		$("#a_cksj").datepicker();
		$("#a_ckczsj").attr("readonly","true");
		$("#a_ckczsj").datepicker();
		$("#a_cksprq").attr("readonly","true");
		$("#a_cksprq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,100,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_bkwplxdm","String",1,2,null,0,"布控物品类型代码"))
			return false;
		if (!checkControlValue("a_bkwplx","String",1,20,null,0,"布控物品类型"))
			return false;
		if (!checkControlValue("a_bkwpmc","String",1,30,null,0,"布控物品名称"))
			return false;
		if (!checkControlValue("a_bkwpms","String",1,2000,null,0,"布控物品描述"))
			return false;
		if (!checkControlValue("a_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("a_fwdwbm","String",1,60,null,0,"发文单位编码"))
			return false;
		if (!checkControlValue("a_ajlbbm","String",1,30,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("a_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("a_tbbh","String",1,30,null,0,"通报编号"))
			return false;
		if (!checkControlValue("a_tbsj2","Date",null,null,null,0,"通报时间"))
			return false;
		if (!checkControlValue("a_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("a_cljg","String",1,2000,null,0,"处理结果"))
			return false;
		if (!checkControlValue("a_bkr","String",1,100,null,0,"布控人"))
			return false;
		if (!checkControlValue("a_bkczy","String",1,100,null,0,"布控操作员"))
			return false;
		if (!checkControlValue("a_bkczsj","Date",null,null,null,0,"布控操作时间"))
			return false;
		if (!checkControlValue("a_bkdqsj","Date",null,null,null,0,"布控到期时间"))
			return false;
		if (!checkControlValue("a_bkfwbm","String",1,2,null,0,"布控范围编码"))
			return false;
		if (!checkControlValue("a_bkfw","String",1,300,null,0,"布控范围"))
			return false;
		if (!checkControlValue("a_bkspyj","String",1,2000,null,0,"布控审批意见"))
			return false;
		if (!checkControlValue("a_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("a_lxfs","String",1,300,null,0,"联系方式"))
			return false;
		if (!checkControlValue("a_sftyfb","String",1,2,null,0,"是否同意发布"))
			return false;
		if (!checkControlValue("a_spdw","String",1,100,null,0,"审批单位"))
			return false;
		if (!checkControlValue("a_spr2","String",1,100,null,0,"审批人"))
			return false;
		if (!checkControlValue("a_sprq","Date",null,null,null,0,"审批日期"))
			return false;
		if (!checkControlValue("a_qqckbs","String",1,2,null,0,"请求撤控标识"))
			return false;
		if (!checkControlValue("a_ckbs","String",1,2,null,0,"撤控标识"))
			return false;
		if (!checkControlValue("a_ckyy","String",1,2000,null,0,"撤控原因"))
			return false;
		if (!checkControlValue("a_cksj","Date",null,null,null,0,"撤控时间"))
			return false;
		if (!checkControlValue("a_ckr","String",1,100,null,0,"撤控人"))
			return false;
		if (!checkControlValue("a_ckczy","String",1,100,null,0,"撤控操作员"))
			return false;
		if (!checkControlValue("a_ckczsj","Date",null,null,null,0,"撤控操作时间"))
			return false;
		if (!checkControlValue("a_ckbmbm","String",1,60,null,0,"撤控部门编码"))
			return false;
		if (!checkControlValue("a_ckbmmc","String",1,100,null,0,"撤控部门名称"))
			return false;
		if (!checkControlValue("a_ckspdw","String",1,100,null,0,"撤控审批单位"))
			return false;
		if (!checkControlValue("a_ckspr","String",1,100,null,0,"撤控审批人"))
			return false;
		if (!checkControlValue("a_ckspyj","String",1,2000,null,0,"撤控审批意见"))
			return false;
		if (!checkControlValue("a_cksprq","Date",null,null,null,0,"撤控审批日期"))
			return false;
		if (!checkControlValue("a_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("a_fsbs","String",1,2,null,0,"发送标识"))
			return false;
		if (!checkControlValue("a_bkdxzp","byte[]",,,,0,"布控对象照片"))
			return false;
		if (!checkControlValue("a_wpjp","String",1,200,null,0,"物品简拼"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Bkwpkbxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="a_bjxxid2" value="0"></td>
		<td class="distd">布控物品基本信息快照ID</td>
		<td class="detailtd"><input type="text" id="a_bkwpjbxxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控物品类型代码</td>
		<td class="detailtd"><input type="text" id="a_bkwplxdm" value=""></td>
		<td class="distd">布控物品类型</td>
		<td class="detailtd"><input type="text" id="a_bkwplx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控物品名称</td>
		<td class="detailtd"><input type="text" id="a_bkwpmc" value=""></td>
		<td class="distd">布控物品描述</td>
		<td class="detailtd"><input type="text" id="a_bkwpms" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发文单位</td>
		<td class="detailtd"><input type="text" id="a_fwdw" value=""></td>
		<td class="distd">发文单位编码</td>
		<td class="detailtd"><input type="text" id="a_fwdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" id="a_ajlbbm" value=""></td>
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" id="a_ajlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">通报编号</td>
		<td class="detailtd"><input type="text" id="a_tbbh" value=""></td>
		<td class="distd">通报时间</td>
		<td class="detailtd"><input type="text" id="a_tbsj2" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" id="a_jyaq" value=""></td>
		<td class="distd">处理结果</td>
		<td class="detailtd"><input type="text" id="a_cljg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控人</td>
		<td class="detailtd"><input type="text" id="a_bkr" value=""></td>
		<td class="distd">布控操作员</td>
		<td class="detailtd"><input type="text" id="a_bkczy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控操作时间</td>
		<td class="detailtd"><input type="text" id="a_bkczsj" value=""></td>
		<td class="distd">布控到期时间</td>
		<td class="detailtd"><input type="text" id="a_bkdqsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控范围编码</td>
		<td class="detailtd"><input type="text" id="a_bkfwbm" value=""></td>
		<td class="distd">布控范围</td>
		<td class="detailtd"><input type="text" id="a_bkfw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控审批意见</td>
		<td class="detailtd"><input type="text" id="a_bkspyj" value=""></td>
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" id="a_lxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" id="a_lxfs" value=""></td>
		<td class="distd">是否同意发布</td>
		<td class="detailtd"><input type="text" id="a_sftyfb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批单位</td>
		<td class="detailtd"><input type="text" id="a_spdw" value=""></td>
		<td class="distd">审批人</td>
		<td class="detailtd"><input type="text" id="a_spr2" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批日期</td>
		<td class="detailtd"><input type="text" id="a_sprq" value=""></td>
		<td class="distd">请求撤控标识</td>
		<td class="detailtd"><input type="text" id="a_qqckbs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控标识</td>
		<td class="detailtd"><input type="text" id="a_ckbs" value=""></td>
		<td class="distd">撤控原因</td>
		<td class="detailtd"><input type="text" id="a_ckyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控时间</td>
		<td class="detailtd"><input type="text" id="a_cksj" value=""></td>
		<td class="distd">撤控人</td>
		<td class="detailtd"><input type="text" id="a_ckr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控操作员</td>
		<td class="detailtd"><input type="text" id="a_ckczy" value=""></td>
		<td class="distd">撤控操作时间</td>
		<td class="detailtd"><input type="text" id="a_ckczsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控部门编码</td>
		<td class="detailtd"><input type="text" id="a_ckbmbm" value=""></td>
		<td class="distd">撤控部门名称</td>
		<td class="detailtd"><input type="text" id="a_ckbmmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批单位</td>
		<td class="detailtd"><input type="text" id="a_ckspdw" value=""></td>
		<td class="distd">撤控审批人</td>
		<td class="detailtd"><input type="text" id="a_ckspr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批意见</td>
		<td class="detailtd"><input type="text" id="a_ckspyj" value=""></td>
		<td class="distd">撤控审批日期</td>
		<td class="detailtd"><input type="text" id="a_cksprq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" id="a_xzqh" value=""></td>
		<td class="distd">发送标识</td>
		<td class="detailtd"><input type="text" id="a_fsbs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控对象照片</td>
		<td class="detailtd"><input type="text" id="a_bkdxzp" value=""></td>
		<td class="distd">物品简拼</td>
		<td class="detailtd"><input type="text" id="a_wpjp" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>