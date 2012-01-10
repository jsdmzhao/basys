<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjgzid").attr("value",dataid);
		$("#m_bjgzid").attr("value",dataid);
		setDetail();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_tbsj").attr("readonly","true");
		$("#m_tbsj").datepicker();
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
		$("#m_bjgzid").attr("value",setNull(json.LBkry_kz[0].bjgzid));
		$("#m_bjxxid").attr("value",setNull(json.LBkry_kz[0].bjxxid));
		$("#m_bkryid").attr("value",setNull(json.LBkry_kz[0].bkryid));
		$("#m_bkrykzid").attr("value",setNull(json.LBkry_kz[0].bkrykzid));
		$("#m_tbbh").attr("value",setNull(json.LBkry_kz[0].tbbh));
		$("#m_xm").attr("value",setNull(json.LBkry_kz[0].xm));
		$("#m_cym").attr("value",setNull(json.LBkry_kz[0].cym));
		$("#m_gmsfhm").attr("value",setNull(json.LBkry_kz[0].gmsfhm));
		$("#m_xmpy").attr("value",setNull(json.LBkry_kz[0].xmpy));
		$("#m_jgdm").attr("value",setNull(json.LBkry_kz[0].jgdm));
		$("#m_jg").attr("value",setNull(json.LBkry_kz[0].jg));
		$("#m_csrq").attr("value",setNull(json.LBkry_kz[0].csrq));
		$("#m_xbdm").attr("value",setNull(json.LBkry_kz[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LBkry_kz[0].xb));
		$("#m_mzdm").attr("value",setNull(json.LBkry_kz[0].mzdm));
		$("#m_minzu").attr("value",setNull(json.LBkry_kz[0].minzu));
		$("#m_kybm").attr("value",setNull(json.LBkry_kz[0].kybm));
		$("#m_ky").attr("value",setNull(json.LBkry_kz[0].ky));
		$("#m_shengao").attr("value",setNull(json.LBkry_kz[0].shengao));
		$("#m_tzbm").attr("value",setNull(json.LBkry_kz[0].tzbm));
		$("#m_tz").attr("value",setNull(json.LBkry_kz[0].tz));
		$("#m_ttbm").attr("value",setNull(json.LBkry_kz[0].ttbm));
		$("#m_tt").attr("value",setNull(json.LBkry_kz[0].tt));
		$("#m_yz").attr("value",setNull(json.LBkry_kz[0].yz));
		$("#m_zz").attr("value",setNull(json.LBkry_kz[0].zz));
		$("#m_fwdw").attr("value",setNull(json.LBkry_kz[0].fwdw));
		$("#m_fwdwbm").attr("value",setNull(json.LBkry_kz[0].fwdwbm));
		$("#m_ajlbbm").attr("value",setNull(json.LBkry_kz[0].ajlbbm));
		$("#m_ajlb").attr("value",setNull(json.LBkry_kz[0].ajlb));
		$("#m_tbsj").attr("value",setNull(json.LBkry_kz[0].tbsj));
		$("#m_jyaq").attr("value",setNull(json.LBkry_kz[0].jyaq));
		$("#m_cljg").attr("value",setNull(json.LBkry_kz[0].cljg));
		$("#m_bkr").attr("value",setNull(json.LBkry_kz[0].bkr));
		$("#m_bkczy").attr("value",setNull(json.LBkry_kz[0].bkczy));
		$("#m_bkczsj").attr("value",setNull(json.LBkry_kz[0].bkczsj));
		$("#m_bkdqsj").attr("value",setNull(json.LBkry_kz[0].bkdqsj));
		$("#m_bkfwbm").attr("value",setNull(json.LBkry_kz[0].bkfwbm));
		$("#m_bkfw").attr("value",setNull(json.LBkry_kz[0].bkfw));
		$("#m_bkspyj").attr("value",setNull(json.LBkry_kz[0].bkspyj));
		$("#m_lxr").attr("value",setNull(json.LBkry_kz[0].lxr));
		$("#m_lxfs").attr("value",setNull(json.LBkry_kz[0].lxfs));
		$("#m_sftyfb").attr("value",setNull(json.LBkry_kz[0].sftyfb));
		$("#m_spdw").attr("value",setNull(json.LBkry_kz[0].spdw));
		$("#m_spr").attr("value",setNull(json.LBkry_kz[0].spr));
		$("#m_sprq").attr("value",setNull(json.LBkry_kz[0].sprq));
		$("#m_qqckbs").attr("value",setNull(json.LBkry_kz[0].qqckbs));
		$("#m_ckbs").attr("value",setNull(json.LBkry_kz[0].ckbs));
		$("#m_ckyy").attr("value",setNull(json.LBkry_kz[0].ckyy));
		$("#m_cksj").attr("value",setNull(json.LBkry_kz[0].cksj));
		$("#m_ckr").attr("value",setNull(json.LBkry_kz[0].ckr));
		$("#m_ckczy").attr("value",setNull(json.LBkry_kz[0].ckczy));
		$("#m_ckczsj").attr("value",setNull(json.LBkry_kz[0].ckczsj));
		$("#m_ckbmbm").attr("value",setNull(json.LBkry_kz[0].ckbmbm));
		$("#m_ckbmmc").attr("value",setNull(json.LBkry_kz[0].ckbmmc));
		$("#m_ckspdw").attr("value",setNull(json.LBkry_kz[0].ckspdw));
		$("#m_ckspr").attr("value",setNull(json.LBkry_kz[0].ckspr));
		$("#m_ckspyj").attr("value",setNull(json.LBkry_kz[0].ckspyj));
		$("#m_cksprq").attr("value",setNull(json.LBkry_kz[0].cksprq));
		$("#m_xzqhbm").attr("value",setNull(json.LBkry_kz[0].xzqhbm));
		$("#m_xzqh").attr("value",setNull(json.LBkry_kz[0].xzqh));
		$("#m_fsbs").attr("value",setNull(json.LBkry_kz[0].fsbs));
		$("#m_bkdxzp").attr("value",setNull(json.LBkry_kz[0].bkdxzp));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("m_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_bkryid","Integer",-9999999999,9999999999,null,0,"布控人员ID"))
			return false;
		if (!checkControlValue("m_bkrykzid","Integer",-9999999999,9999999999,null,0,"布控人员快照ID"))
			return false;
		if (!checkControlValue("m_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_cym","String",1,100,null,0,"曾用名"))
			return false;
		if (!checkControlValue("m_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("m_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("m_jgdm","String",1,6,null,0,"籍贯代码"))
			return false;
		if (!checkControlValue("m_jg","String",1,100,null,0,"籍贯"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("m_kybm","String",1,6,null,0,"口音编码"))
			return false;
		if (!checkControlValue("m_ky","String",1,100,null,0,"口音"))
			return false;
		if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("m_tzbm","String",1,10,null,0,"体征编码"))
			return false;
		if (!checkControlValue("m_tz","String",1,100,null,0,"体征"))
			return false;
		if (!checkControlValue("m_ttbm","String",1,20,null,0,"体态编码"))
			return false;
		if (!checkControlValue("m_tt","String",1,100,null,0,"体态"))
			return false;
		if (!checkControlValue("m_yz","String",1,200,null,0,"衣着"))
			return false;
		if (!checkControlValue("m_zz","String",1,300,null,0,"住址"))
			return false;
		if (!checkControlValue("m_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("m_fwdwbm","String",1,60,null,0,"发文单位编码"))
			return false;
		if (!checkControlValue("m_ajlbbm","String",1,20,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("m_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("m_tbsj","Date",null,null,null,0,"通报时间"))
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
		if (!checkControlValue("m_lxfs","String",1,60,null,0,"联系方式"))
			return false;
		if (!checkControlValue("m_sftyfb","String",1,2,null,0,"是否同意发布"))
			return false;
		if (!checkControlValue("m_spdw","String",1,100,null,0,"审批单位"))
			return false;
		if (!checkControlValue("m_spr","String",1,100,null,0,"审批人"))
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
		if (!checkControlValue("m_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("m_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("m_fsbs","String",1,2,null,0,"发送标识"))
			return false;
		if (!checkControlValue("m_bkdxzp","byte[]",,,,0,"布控对象照片"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjgzid">
<input type="hidden" id="m_bjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">报警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjgzid" value="0"></td>
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">布控人员ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkryid" value="0"></td>
		<td class="distd">布控人员快照ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkrykzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">通报编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbbh" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">曾用名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cym" value=""></td>
		<td class="distd">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gmsfhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xmpy" value=""></td>
		<td class="distd">籍贯代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">籍贯</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jg" value=""></td>
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_csrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xbdm" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_mzdm" value=""></td>
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_minzu" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">口音编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_kybm" value=""></td>
		<td class="distd">口音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ky" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_shengao" value="0"></td>
		<td class="distd">体征编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tzbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">体征</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tz" value=""></td>
		<td class="distd">体态编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ttbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">体态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tt" value=""></td>
		<td class="distd">衣着</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">住址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zz" value=""></td>
		<td class="distd">发文单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fwdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发文单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fwdwbm" value=""></td>
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ajlbbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ajlb" value=""></td>
		<td class="distd">通报时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jyaq" value=""></td>
		<td class="distd">处理结果</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cljg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkr" value=""></td>
		<td class="distd">布控操作员</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkczy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控操作时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkczsj" value=""></td>
		<td class="distd">布控到期时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkdqsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控范围编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkfwbm" value=""></td>
		<td class="distd">布控范围</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkfw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控审批意见</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkspyj" value=""></td>
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_lxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_lxfs" value=""></td>
		<td class="distd">是否同意发布</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_sftyfb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_spdw" value=""></td>
		<td class="distd">审批人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_spr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_sprq" value=""></td>
		<td class="distd">请求撤控标识</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_qqckbs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控标识</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckbs" value=""></td>
		<td class="distd">撤控原因</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cksj" value=""></td>
		<td class="distd">撤控人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控操作员</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckczy" value=""></td>
		<td class="distd">撤控操作时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckczsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控部门编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckbmbm" value=""></td>
		<td class="distd">撤控部门名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckbmmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckspdw" value=""></td>
		<td class="distd">撤控审批人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckspr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批意见</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ckspyj" value=""></td>
		<td class="distd">撤控审批日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cksprq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzqhbm" value=""></td>
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发送标识</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fsbs" value=""></td>
		<td class="distd">布控对象照片</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bkdxzp" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
