<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjxxid2").append(setNull(json.LBkwpkbxxkz[0].bjxxid2));
		$("#bkwpjbxxkzid").append(setNull(json.LBkwpkbxxkz[0].bkwpjbxxkzid));
		$("#hylbdm").append(setNull(json.LBkwpkbxxkz[0].hylbdm));
		$("#hylb").append(setNull(json.LBkwpkbxxkz[0].hylb));
		$("#bkwplxdm").append(setNull(json.LBkwpkbxxkz[0].bkwplxdm));
		$("#bkwplx").append(setNull(json.LBkwpkbxxkz[0].bkwplx));
		$("#bkwpmc").append(setNull(json.LBkwpkbxxkz[0].bkwpmc));
		$("#bkwpms").append(setNull(json.LBkwpkbxxkz[0].bkwpms));
		$("#fwdw").append(setNull(json.LBkwpkbxxkz[0].fwdw));
		$("#fwdwbm").append(setNull(json.LBkwpkbxxkz[0].fwdwbm));
		$("#ajlbbm").append(setNull(json.LBkwpkbxxkz[0].ajlbbm));
		$("#ajlb").append(setNull(json.LBkwpkbxxkz[0].ajlb));
		$("#tbbh").append(setNull(json.LBkwpkbxxkz[0].tbbh));
		$("#tbsj2").append(setNull(json.LBkwpkbxxkz[0].tbsj2));
		$("#jyaq").append(setNull(json.LBkwpkbxxkz[0].jyaq));
		$("#cljg").append(setNull(json.LBkwpkbxxkz[0].cljg));
		$("#bkr").append(setNull(json.LBkwpkbxxkz[0].bkr));
		$("#bkczy").append(setNull(json.LBkwpkbxxkz[0].bkczy));
		$("#bkczsj").append(setNull(json.LBkwpkbxxkz[0].bkczsj));
		$("#bkdqsj").append(setNull(json.LBkwpkbxxkz[0].bkdqsj));
		$("#bkfwbm").append(setNull(json.LBkwpkbxxkz[0].bkfwbm));
		$("#bkfw").append(setNull(json.LBkwpkbxxkz[0].bkfw));
		$("#bkspyj").append(setNull(json.LBkwpkbxxkz[0].bkspyj));
		$("#lxr").append(setNull(json.LBkwpkbxxkz[0].lxr));
		$("#lxfs").append(setNull(json.LBkwpkbxxkz[0].lxfs));
		$("#sftyfb").append(setNull(json.LBkwpkbxxkz[0].sftyfb));
		$("#spdw").append(setNull(json.LBkwpkbxxkz[0].spdw));
		$("#spr2").append(setNull(json.LBkwpkbxxkz[0].spr2));
		$("#sprq").append(setNull(json.LBkwpkbxxkz[0].sprq));
		$("#qqckbs").append(setNull(json.LBkwpkbxxkz[0].qqckbs));
		$("#ckbs").append(setNull(json.LBkwpkbxxkz[0].ckbs));
		$("#ckyy").append(setNull(json.LBkwpkbxxkz[0].ckyy));
		$("#cksj").append(setNull(json.LBkwpkbxxkz[0].cksj));
		$("#ckr").append(setNull(json.LBkwpkbxxkz[0].ckr));
		$("#ckczy").append(setNull(json.LBkwpkbxxkz[0].ckczy));
		$("#ckczsj").append(setNull(json.LBkwpkbxxkz[0].ckczsj));
		$("#ckbmbm").append(setNull(json.LBkwpkbxxkz[0].ckbmbm));
		$("#ckbmmc").append(setNull(json.LBkwpkbxxkz[0].ckbmmc));
		$("#ckspdw").append(setNull(json.LBkwpkbxxkz[0].ckspdw));
		$("#ckspr").append(setNull(json.LBkwpkbxxkz[0].ckspr));
		$("#ckspyj").append(setNull(json.LBkwpkbxxkz[0].ckspyj));
		$("#cksprq").append(setNull(json.LBkwpkbxxkz[0].cksprq));
		$("#xzqh").append(setNull(json.LBkwpkbxxkz[0].xzqh));
		$("#fsbs").append(setNull(json.LBkwpkbxxkz[0].fsbs));
		$("#bkdxzp").append(setNull(json.LBkwpkbxxkz[0].bkdxzp));
		$("#wpjp").append(setNull(json.LBkwpkbxxkz[0].wpjp));
	}	
</script>
<input type="hidden" id="q_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bkwpkbxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd1">报警信息ID</td>
		<td class="detailtd2"><span id="bjxxid2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控物品基本信息快照ID</td>
		<td class="detailtd2"><span id="bkwpjbxxkzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别代码</td>
		<td class="detailtd2"><span id="hylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别</td>
		<td class="detailtd2"><span id="hylb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控物品类型代码</td>
		<td class="detailtd2"><span id="bkwplxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控物品类型</td>
		<td class="detailtd2"><span id="bkwplx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控物品名称</td>
		<td class="detailtd2"><span id="bkwpmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控物品描述</td>
		<td class="detailtd2"><span id="bkwpms"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发文单位</td>
		<td class="detailtd2"><span id="fwdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发文单位编码</td>
		<td class="detailtd2"><span id="fwdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">案件类别编码</td>
		<td class="detailtd2"><span id="ajlbbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">案件类别</td>
		<td class="detailtd2"><span id="ajlb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">通报编号</td>
		<td class="detailtd2"><span id="tbbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">通报时间</td>
		<td class="detailtd2"><span id="tbsj2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">简要案情</td>
		<td class="detailtd2"><span id="jyaq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">处理结果</td>
		<td class="detailtd2"><span id="cljg"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控人</td>
		<td class="detailtd2"><span id="bkr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控操作员</td>
		<td class="detailtd2"><span id="bkczy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控操作时间</td>
		<td class="detailtd2"><span id="bkczsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控到期时间</td>
		<td class="detailtd2"><span id="bkdqsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控范围编码</td>
		<td class="detailtd2"><span id="bkfwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控范围</td>
		<td class="detailtd2"><span id="bkfw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控审批意见</td>
		<td class="detailtd2"><span id="bkspyj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系人</td>
		<td class="detailtd2"><span id="lxr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系方式</td>
		<td class="detailtd2"><span id="lxfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">是否同意发布</td>
		<td class="detailtd2"><span id="sftyfb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审批单位</td>
		<td class="detailtd2"><span id="spdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审批人</td>
		<td class="detailtd2"><span id="spr2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审批日期</td>
		<td class="detailtd2"><span id="sprq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">请求撤控标识</td>
		<td class="detailtd2"><span id="qqckbs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控标识</td>
		<td class="detailtd2"><span id="ckbs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控原因</td>
		<td class="detailtd2"><span id="ckyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控时间</td>
		<td class="detailtd2"><span id="cksj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控人</td>
		<td class="detailtd2"><span id="ckr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控操作员</td>
		<td class="detailtd2"><span id="ckczy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控操作时间</td>
		<td class="detailtd2"><span id="ckczsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控部门编码</td>
		<td class="detailtd2"><span id="ckbmbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控部门名称</td>
		<td class="detailtd2"><span id="ckbmmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控审批单位</td>
		<td class="detailtd2"><span id="ckspdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控审批人</td>
		<td class="detailtd2"><span id="ckspr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控审批意见</td>
		<td class="detailtd2"><span id="ckspyj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤控审批日期</td>
		<td class="detailtd2"><span id="cksprq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行政区划</td>
		<td class="detailtd2"><span id="xzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发送标识</td>
		<td class="detailtd2"><span id="fsbs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">布控对象照片</td>
		<td class="detailtd2"><span id="bkdxzp"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">物品简拼</td>
		<td class="detailtd2"><span id="wpjp"></span></td>
	</tr>
</table>