<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjgzid").append(setNull(json.LBkry_kz[0].bjgzid));
		$("#bjxxid").append(setNull(json.LBkry_kz[0].bjxxid));
		$("#bkryid").append(setNull(json.LBkry_kz[0].bkryid));
		$("#bkrykzid").append(setNull(json.LBkry_kz[0].bkrykzid));
		$("#tbbh").append(setNull(json.LBkry_kz[0].tbbh));
		$("#xm").append(setNull(json.LBkry_kz[0].xm));
		$("#cym").append(setNull(json.LBkry_kz[0].cym));
		$("#gmsfhm").append(setNull(json.LBkry_kz[0].gmsfhm));
		$("#xmpy").append(setNull(json.LBkry_kz[0].xmpy));
		$("#jgdm").append(setNull(json.LBkry_kz[0].jgdm));
		$("#jg").append(setNull(json.LBkry_kz[0].jg));
		$("#csrq").append(setNull(json.LBkry_kz[0].csrq));
		$("#xbdm").append(setNull(json.LBkry_kz[0].xbdm));
		$("#xb").append(setNull(json.LBkry_kz[0].xb));
		$("#mzdm").append(setNull(json.LBkry_kz[0].mzdm));
		$("#minzu").append(setNull(json.LBkry_kz[0].minzu));
		$("#kybm").append(setNull(json.LBkry_kz[0].kybm));
		$("#ky").append(setNull(json.LBkry_kz[0].ky));
		$("#shengao").append(setNull(json.LBkry_kz[0].shengao));
		$("#tzbm").append(setNull(json.LBkry_kz[0].tzbm));
		$("#tz").append(setNull(json.LBkry_kz[0].tz));
		$("#ttbm").append(setNull(json.LBkry_kz[0].ttbm));
		$("#tt").append(setNull(json.LBkry_kz[0].tt));
		$("#yz").append(setNull(json.LBkry_kz[0].yz));
		$("#zz").append(setNull(json.LBkry_kz[0].zz));
		$("#fwdw").append(setNull(json.LBkry_kz[0].fwdw));
		$("#fwdwbm").append(setNull(json.LBkry_kz[0].fwdwbm));
		$("#ajlbbm").append(setNull(json.LBkry_kz[0].ajlbbm));
		$("#ajlb").append(setNull(json.LBkry_kz[0].ajlb));
		$("#tbsj").append(setNull(json.LBkry_kz[0].tbsj));
		$("#jyaq").append(setNull(json.LBkry_kz[0].jyaq));
		$("#cljg").append(setNull(json.LBkry_kz[0].cljg));
		$("#bkr").append(setNull(json.LBkry_kz[0].bkr));
		$("#bkczy").append(setNull(json.LBkry_kz[0].bkczy));
		$("#bkczsj").append(setNull(json.LBkry_kz[0].bkczsj));
		$("#bkdqsj").append(setNull(json.LBkry_kz[0].bkdqsj));
		$("#bkfwbm").append(setNull(json.LBkry_kz[0].bkfwbm));
		$("#bkfw").append(setNull(json.LBkry_kz[0].bkfw));
		$("#bkspyj").append(setNull(json.LBkry_kz[0].bkspyj));
		$("#lxr").append(setNull(json.LBkry_kz[0].lxr));
		$("#lxfs").append(setNull(json.LBkry_kz[0].lxfs));
		$("#sftyfb").append(setNull(json.LBkry_kz[0].sftyfb));
		$("#spdw").append(setNull(json.LBkry_kz[0].spdw));
		$("#spr").append(setNull(json.LBkry_kz[0].spr));
		$("#sprq").append(setNull(json.LBkry_kz[0].sprq));
		$("#qqckbs").append(setNull(json.LBkry_kz[0].qqckbs));
		$("#ckbs").append(setNull(json.LBkry_kz[0].ckbs));
		$("#ckyy").append(setNull(json.LBkry_kz[0].ckyy));
		$("#cksj").append(setNull(json.LBkry_kz[0].cksj));
		$("#ckr").append(setNull(json.LBkry_kz[0].ckr));
		$("#ckczy").append(setNull(json.LBkry_kz[0].ckczy));
		$("#ckczsj").append(setNull(json.LBkry_kz[0].ckczsj));
		$("#ckbmbm").append(setNull(json.LBkry_kz[0].ckbmbm));
		$("#ckbmmc").append(setNull(json.LBkry_kz[0].ckbmmc));
		$("#ckspdw").append(setNull(json.LBkry_kz[0].ckspdw));
		$("#ckspr").append(setNull(json.LBkry_kz[0].ckspr));
		$("#ckspyj").append(setNull(json.LBkry_kz[0].ckspyj));
		$("#cksprq").append(setNull(json.LBkry_kz[0].cksprq));
		$("#xzqhbm").append(setNull(json.LBkry_kz[0].xzqhbm));
		$("#xzqh").append(setNull(json.LBkry_kz[0].xzqh));
		$("#fsbs").append(setNull(json.LBkry_kz[0].fsbs));
		$("#bkdxzp").append(setNull(json.LBkry_kz[0].bkdxzp));
	}	
</script>
<input type="hidden" id="q_bjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">报警规则ID</td>
		<td class="detailtd1"><span id="bjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警信息ID</td>
		<td class="detailtd1"><span id="bjxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控人员ID</td>
		<td class="detailtd1"><span id="bkryid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控人员快照ID</td>
		<td class="detailtd1"><span id="bkrykzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">通报编号</td>
		<td class="detailtd1"><span id="tbbh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">姓名</td>
		<td class="detailtd1"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">曾用名</td>
		<td class="detailtd1"><span id="cym"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">公民身份号码</td>
		<td class="detailtd1"><span id="gmsfhm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">姓名拼音</td>
		<td class="detailtd1"><span id="xmpy"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">籍贯代码</td>
		<td class="detailtd1"><span id="jgdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">籍贯</td>
		<td class="detailtd1"><span id="jg"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">出生日期</td>
		<td class="detailtd1"><span id="csrq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">性别代码</td>
		<td class="detailtd1"><span id="xbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">性别</td>
		<td class="detailtd1"><span id="xb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">民族代码</td>
		<td class="detailtd1"><span id="mzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">民族</td>
		<td class="detailtd1"><span id="minzu"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">口音编码</td>
		<td class="detailtd1"><span id="kybm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">口音</td>
		<td class="detailtd1"><span id="ky"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">身高</td>
		<td class="detailtd1"><span id="shengao"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">体征编码</td>
		<td class="detailtd1"><span id="tzbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">体征</td>
		<td class="detailtd1"><span id="tz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">体态编码</td>
		<td class="detailtd1"><span id="ttbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">体态</td>
		<td class="detailtd1"><span id="tt"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">衣着</td>
		<td class="detailtd1"><span id="yz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">住址</td>
		<td class="detailtd1"><span id="zz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">发文单位</td>
		<td class="detailtd1"><span id="fwdw"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">发文单位编码</td>
		<td class="detailtd1"><span id="fwdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">案件类别编码</td>
		<td class="detailtd1"><span id="ajlbbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">案件类别</td>
		<td class="detailtd1"><span id="ajlb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">通报时间</td>
		<td class="detailtd1"><span id="tbsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">简要案情</td>
		<td class="detailtd1"><span id="jyaq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">处理结果</td>
		<td class="detailtd1"><span id="cljg"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控人</td>
		<td class="detailtd1"><span id="bkr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控操作员</td>
		<td class="detailtd1"><span id="bkczy"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控操作时间</td>
		<td class="detailtd1"><span id="bkczsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控到期时间</td>
		<td class="detailtd1"><span id="bkdqsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控范围编码</td>
		<td class="detailtd1"><span id="bkfwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控范围</td>
		<td class="detailtd1"><span id="bkfw"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控审批意见</td>
		<td class="detailtd1"><span id="bkspyj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">联系人</td>
		<td class="detailtd1"><span id="lxr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">联系方式</td>
		<td class="detailtd1"><span id="lxfs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">是否同意发布</td>
		<td class="detailtd1"><span id="sftyfb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">审批单位</td>
		<td class="detailtd1"><span id="spdw"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">审批人</td>
		<td class="detailtd1"><span id="spr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">审批日期</td>
		<td class="detailtd1"><span id="sprq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">请求撤控标识</td>
		<td class="detailtd1"><span id="qqckbs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控标识</td>
		<td class="detailtd1"><span id="ckbs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控原因</td>
		<td class="detailtd1"><span id="ckyy"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控时间</td>
		<td class="detailtd1"><span id="cksj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控人</td>
		<td class="detailtd1"><span id="ckr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控操作员</td>
		<td class="detailtd1"><span id="ckczy"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控操作时间</td>
		<td class="detailtd1"><span id="ckczsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控部门编码</td>
		<td class="detailtd1"><span id="ckbmbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控部门名称</td>
		<td class="detailtd1"><span id="ckbmmc"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控审批单位</td>
		<td class="detailtd1"><span id="ckspdw"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控审批人</td>
		<td class="detailtd1"><span id="ckspr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控审批意见</td>
		<td class="detailtd1"><span id="ckspyj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">撤控审批日期</td>
		<td class="detailtd1"><span id="cksprq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">行政区划编码</td>
		<td class="detailtd1"><span id="xzqhbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">行政区划</td>
		<td class="detailtd1"><span id="xzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">发送标识</td>
		<td class="detailtd1"><span id="fsbs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">布控对象照片</td>
		<td class="detailtd1"><span id="bkdxzp"></span></td>
	</tr>
</table>