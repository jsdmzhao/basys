<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_bjxxid2").attr("value",dataid);
		$("#m_bjxxid2").attr("value",dataid);
		setDetail();
		$("#m_tbsj2").attr("readonly","true");
		$("#m_tbsj2").datepicker();
		$("#m_bkczsj").attr("readonly","true");
		$("#m_bkczsj").datepicker();
		$("#m_bkdqsj").attr("readonly","true");
		$("#m_bkdqsj").datepicker();
		$("#m_sprq").attr("readonly","true");
		$("#m_sprq").datepicker();
		$("#m_cksj").attr("readonly","true");
		$("#m_cksj").datepicker();
		$("#m_ckczsj").attr("readonly","true");
		$("#m_ckczsj").datepicker();
		$("#m_cksprq").attr("readonly","true");
		$("#m_cksprq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bjxxid2").attr("value",setNull(json.LBkwpkbxxkz[0].bjxxid2));
		$("#m_bkwpjbxxkzid").attr("value",setNull(json.LBkwpkbxxkz[0].bkwpjbxxkzid));
		$("#m_hylbdm").attr("value",setNull(json.LBkwpkbxxkz[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LBkwpkbxxkz[0].hylb));
		$("#m_bkwplxdm").attr("value",setNull(json.LBkwpkbxxkz[0].bkwplxdm));
		$("#m_bkwplx").attr("value",setNull(json.LBkwpkbxxkz[0].bkwplx));
		$("#m_bkwpmc").attr("value",setNull(json.LBkwpkbxxkz[0].bkwpmc));
		$("#m_bkwpms").attr("value",setNull(json.LBkwpkbxxkz[0].bkwpms));
		$("#m_fwdw").attr("value",setNull(json.LBkwpkbxxkz[0].fwdw));
		$("#m_fwdwbm").attr("value",setNull(json.LBkwpkbxxkz[0].fwdwbm));
		$("#m_ajlbbm").attr("value",setNull(json.LBkwpkbxxkz[0].ajlbbm));
		$("#m_ajlb").attr("value",setNull(json.LBkwpkbxxkz[0].ajlb));
		$("#m_tbbh").attr("value",setNull(json.LBkwpkbxxkz[0].tbbh));
		$("#m_tbsj2").attr("value",setNull(json.LBkwpkbxxkz[0].tbsj2));
		$("#m_jyaq").attr("value",setNull(json.LBkwpkbxxkz[0].jyaq));
		$("#m_cljg").attr("value",setNull(json.LBkwpkbxxkz[0].cljg));
		$("#m_bkr").attr("value",setNull(json.LBkwpkbxxkz[0].bkr));
		$("#m_bkczy").attr("value",setNull(json.LBkwpkbxxkz[0].bkczy));
		$("#m_bkczsj").attr("value",setNull(json.LBkwpkbxxkz[0].bkczsj));
		$("#m_bkdqsj").attr("value",setNull(json.LBkwpkbxxkz[0].bkdqsj));
		$("#m_bkfwbm").attr("value",setNull(json.LBkwpkbxxkz[0].bkfwbm));
		$("#m_bkfw").attr("value",setNull(json.LBkwpkbxxkz[0].bkfw));
		$("#m_bkspyj").attr("value",setNull(json.LBkwpkbxxkz[0].bkspyj));
		$("#m_lxr").attr("value",setNull(json.LBkwpkbxxkz[0].lxr));
		$("#m_lxfs").attr("value",setNull(json.LBkwpkbxxkz[0].lxfs));
		$("#m_sftyfb").attr("value",setNull(json.LBkwpkbxxkz[0].sftyfb));
		$("#m_spdw").attr("value",setNull(json.LBkwpkbxxkz[0].spdw));
		$("#m_spr2").attr("value",setNull(json.LBkwpkbxxkz[0].spr2));
		$("#m_sprq").attr("value",setNull(json.LBkwpkbxxkz[0].sprq));
		$("#m_qqckbs").attr("value",setNull(json.LBkwpkbxxkz[0].qqckbs));
		$("#m_ckbs").attr("value",setNull(json.LBkwpkbxxkz[0].ckbs));
		$("#m_ckyy").attr("value",setNull(json.LBkwpkbxxkz[0].ckyy));
		$("#m_cksj").attr("value",setNull(json.LBkwpkbxxkz[0].cksj));
		$("#m_ckr").attr("value",setNull(json.LBkwpkbxxkz[0].ckr));
		$("#m_ckczy").attr("value",setNull(json.LBkwpkbxxkz[0].ckczy));
		$("#m_ckczsj").attr("value",setNull(json.LBkwpkbxxkz[0].ckczsj));
		$("#m_ckbmbm").attr("value",setNull(json.LBkwpkbxxkz[0].ckbmbm));
		$("#m_ckbmmc").attr("value",setNull(json.LBkwpkbxxkz[0].ckbmmc));
		$("#m_ckspdw").attr("value",setNull(json.LBkwpkbxxkz[0].ckspdw));
		$("#m_ckspr").attr("value",setNull(json.LBkwpkbxxkz[0].ckspr));
		$("#m_ckspyj").attr("value",setNull(json.LBkwpkbxxkz[0].ckspyj));
		$("#m_cksprq").attr("value",setNull(json.LBkwpkbxxkz[0].cksprq));
		$("#m_xzqh").attr("value",setNull(json.LBkwpkbxxkz[0].xzqh));
		$("#m_fsbs").attr("value",setNull(json.LBkwpkbxxkz[0].fsbs));
		$("#m_bkdxzp").attr("value",setNull(json.LBkwpkbxxkz[0].bkdxzp));
		$("#m_wpjp").attr("value",setNull(json.LBkwpkbxxkz[0].wpjp));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,100,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_bkwplxdm","String",1,2,null,0,"布控物品类型代码"))
			return false;
		if (!checkControlValue("m_bkwplx","String",1,20,null,0,"布控物品类型"))
			return false;
		if (!checkControlValue("m_bkwpmc","String",1,30,null,0,"布控物品名称"))
			return false;
		if (!checkControlValue("m_bkwpms","String",1,2000,null,0,"布控物品描述"))
			return false;
		if (!checkControlValue("m_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("m_fwdwbm","String",1,60,null,0,"发文单位编码"))
			return false;
		if (!checkControlValue("m_ajlbbm","String",1,30,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("m_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("m_tbbh","String",1,30,null,0,"通报编号"))
			return false;
		if (!checkControlValue("m_tbsj2","Date",null,null,null,0,"通报时间"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("m_cljg","String",1,2000,null,0,"处理结果"))
			return false;
		if (!checkControlValue("m_bkr","String",1,100,null,0,"布控人"))
			return false;
		if (!checkControlValue("m_bkczy","String",1,100,null,0,"布控操作员"))
			return false;
		if (!checkControlValue("m_bkczsj","Date",null,null,null,0,"布控操作时间"))
			return false;
		if (!checkControlValue("m_bkdqsj","Date",null,null,null,0,"布控到期时间"))
			return false;
		if (!checkControlValue("m_bkfwbm","String",1,2,null,0,"布控范围编码"))
			return false;
		if (!checkControlValue("m_bkfw","String",1,300,null,0,"布控范围"))
			return false;
		if (!checkControlValue("m_bkspyj","String",1,2000,null,0,"布控审批意见"))
			return false;
		if (!checkControlValue("m_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("m_lxfs","String",1,300,null,0,"联系方式"))
			return false;
		if (!checkControlValue("m_sftyfb","String",1,2,null,0,"是否同意发布"))
			return false;
		if (!checkControlValue("m_spdw","String",1,100,null,0,"审批单位"))
			return false;
		if (!checkControlValue("m_spr2","String",1,100,null,0,"审批人"))
			return false;
		if (!checkControlValue("m_sprq","Date",null,null,null,0,"审批日期"))
			return false;
		if (!checkControlValue("m_qqckbs","String",1,2,null,0,"请求撤控标识"))
			return false;
		if (!checkControlValue("m_ckbs","String",1,2,null,0,"撤控标识"))
			return false;
		if (!checkControlValue("m_ckyy","String",1,2000,null,0,"撤控原因"))
			return false;
		if (!checkControlValue("m_cksj","Date",null,null,null,0,"撤控时间"))
			return false;
		if (!checkControlValue("m_ckr","String",1,100,null,0,"撤控人"))
			return false;
		if (!checkControlValue("m_ckczy","String",1,100,null,0,"撤控操作员"))
			return false;
		if (!checkControlValue("m_ckczsj","Date",null,null,null,0,"撤控操作时间"))
			return false;
		if (!checkControlValue("m_ckbmbm","String",1,60,null,0,"撤控部门编码"))
			return false;
		if (!checkControlValue("m_ckbmmc","String",1,100,null,0,"撤控部门名称"))
			return false;
		if (!checkControlValue("m_ckspdw","String",1,100,null,0,"撤控审批单位"))
			return false;
		if (!checkControlValue("m_ckspr","String",1,100,null,0,"撤控审批人"))
			return false;
		if (!checkControlValue("m_ckspyj","String",1,2000,null,0,"撤控审批意见"))
			return false;
		if (!checkControlValue("m_cksprq","Date",null,null,null,0,"撤控审批日期"))
			return false;
		if (!checkControlValue("m_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("m_fsbs","String",1,2,null,0,"发送标识"))
			return false;
		if (!checkControlValue("m_bkdxzp","byte[]",,,,0,"布控对象照片"))
			return false;
		if (!checkControlValue("m_wpjp","String",1,200,null,0,"物品简拼"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjxxid2">
<input type="hidden" id="m_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bkwpkbxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="m_bjxxid2" value="0"></td>
		<td class="distd">布控物品基本信息快照ID</td>
		<td class="detailtd"><input type="text" id="m_bkwpjbxxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控物品类型代码</td>
		<td class="detailtd"><input type="text" id="m_bkwplxdm" value=""></td>
		<td class="distd">布控物品类型</td>
		<td class="detailtd"><input type="text" id="m_bkwplx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控物品名称</td>
		<td class="detailtd"><input type="text" id="m_bkwpmc" value=""></td>
		<td class="distd">布控物品描述</td>
		<td class="detailtd"><input type="text" id="m_bkwpms" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发文单位</td>
		<td class="detailtd"><input type="text" id="m_fwdw" value=""></td>
		<td class="distd">发文单位编码</td>
		<td class="detailtd"><input type="text" id="m_fwdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" id="m_ajlbbm" value=""></td>
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" id="m_ajlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">通报编号</td>
		<td class="detailtd"><input type="text" id="m_tbbh" value=""></td>
		<td class="distd">通报时间</td>
		<td class="detailtd"><input type="text" id="m_tbsj2" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" id="m_jyaq" value=""></td>
		<td class="distd">处理结果</td>
		<td class="detailtd"><input type="text" id="m_cljg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控人</td>
		<td class="detailtd"><input type="text" id="m_bkr" value=""></td>
		<td class="distd">布控操作员</td>
		<td class="detailtd"><input type="text" id="m_bkczy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控操作时间</td>
		<td class="detailtd"><input type="text" id="m_bkczsj" value=""></td>
		<td class="distd">布控到期时间</td>
		<td class="detailtd"><input type="text" id="m_bkdqsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控范围编码</td>
		<td class="detailtd"><input type="text" id="m_bkfwbm" value=""></td>
		<td class="distd">布控范围</td>
		<td class="detailtd"><input type="text" id="m_bkfw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控审批意见</td>
		<td class="detailtd"><input type="text" id="m_bkspyj" value=""></td>
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" id="m_lxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" id="m_lxfs" value=""></td>
		<td class="distd">是否同意发布</td>
		<td class="detailtd"><input type="text" id="m_sftyfb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批单位</td>
		<td class="detailtd"><input type="text" id="m_spdw" value=""></td>
		<td class="distd">审批人</td>
		<td class="detailtd"><input type="text" id="m_spr2" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批日期</td>
		<td class="detailtd"><input type="text" id="m_sprq" value=""></td>
		<td class="distd">请求撤控标识</td>
		<td class="detailtd"><input type="text" id="m_qqckbs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控标识</td>
		<td class="detailtd"><input type="text" id="m_ckbs" value=""></td>
		<td class="distd">撤控原因</td>
		<td class="detailtd"><input type="text" id="m_ckyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控时间</td>
		<td class="detailtd"><input type="text" id="m_cksj" value=""></td>
		<td class="distd">撤控人</td>
		<td class="detailtd"><input type="text" id="m_ckr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控操作员</td>
		<td class="detailtd"><input type="text" id="m_ckczy" value=""></td>
		<td class="distd">撤控操作时间</td>
		<td class="detailtd"><input type="text" id="m_ckczsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控部门编码</td>
		<td class="detailtd"><input type="text" id="m_ckbmbm" value=""></td>
		<td class="distd">撤控部门名称</td>
		<td class="detailtd"><input type="text" id="m_ckbmmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批单位</td>
		<td class="detailtd"><input type="text" id="m_ckspdw" value=""></td>
		<td class="distd">撤控审批人</td>
		<td class="detailtd"><input type="text" id="m_ckspr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批意见</td>
		<td class="detailtd"><input type="text" id="m_ckspyj" value=""></td>
		<td class="distd">撤控审批日期</td>
		<td class="detailtd"><input type="text" id="m_cksprq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" id="m_xzqh" value=""></td>
		<td class="distd">发送标识</td>
		<td class="detailtd"><input type="text" id="m_fsbs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控对象照片</td>
		<td class="detailtd"><input type="text" id="m_bkdxzp" value=""></td>
		<td class="distd">物品简拼</td>
		<td class="detailtd"><input type="text" id="m_wpjp" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
