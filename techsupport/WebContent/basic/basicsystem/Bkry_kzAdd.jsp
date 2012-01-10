<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_tbsj").attr("readonly","true");
		$("#a_tbsj").datepicker();
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
		if (!checkControlValue("a_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("a_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_bkryid","Integer",-9999999999,9999999999,null,0,"布控人员ID"))
			return false;
		if (!checkControlValue("a_bkrykzid","Integer",-9999999999,9999999999,null,0,"布控人员快照ID"))
			return false;
		if (!checkControlValue("a_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_cym","String",1,100,null,0,"曾用名"))
			return false;
		if (!checkControlValue("a_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("a_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("a_jgdm","String",1,6,null,0,"籍贯代码"))
			return false;
		if (!checkControlValue("a_jg","String",1,100,null,0,"籍贯"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("a_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("a_kybm","String",1,6,null,0,"口音编码"))
			return false;
		if (!checkControlValue("a_ky","String",1,100,null,0,"口音"))
			return false;
		if (!checkControlValue("a_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("a_tzbm","String",1,10,null,0,"体征编码"))
			return false;
		if (!checkControlValue("a_tz","String",1,100,null,0,"体征"))
			return false;
		if (!checkControlValue("a_ttbm","String",1,20,null,0,"体态编码"))
			return false;
		if (!checkControlValue("a_tt","String",1,100,null,0,"体态"))
			return false;
		if (!checkControlValue("a_yz","String",1,200,null,0,"衣着"))
			return false;
		if (!checkControlValue("a_zz","String",1,300,null,0,"住址"))
			return false;
		if (!checkControlValue("a_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("a_fwdwbm","String",1,60,null,0,"发文单位编码"))
			return false;
		if (!checkControlValue("a_ajlbbm","String",1,20,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("a_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("a_tbsj","Date",null,null,null,0,"通报时间"))
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
		if (!checkControlValue("a_lxfs","String",1,60,null,0,"联系方式"))
			return false;
		if (!checkControlValue("a_sftyfb","String",1,2,null,0,"是否同意发布"))
			return false;
		if (!checkControlValue("a_spdw","String",1,100,null,0,"审批单位"))
			return false;
		if (!checkControlValue("a_spr","String",1,100,null,0,"审批人"))
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
		if (!checkControlValue("a_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("a_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("a_fsbs","String",1,2,null,0,"发送标识"))
			return false;
		if (!checkControlValue("a_bkdxzp","byte[]",,,,0,"布控对象照片"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">报警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjgzid" value="0"></td>
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">布控人员ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkryid" value="0"></td>
		<td class="distd">布控人员快照ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkrykzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">通报编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbbh" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">曾用名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cym" value=""></td>
		<td class="distd">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gmsfhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xmpy" value=""></td>
		<td class="distd">籍贯代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_jgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">籍贯</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_jg" value=""></td>
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_csrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xbdm" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_mzdm" value=""></td>
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_minzu" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">口音编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_kybm" value=""></td>
		<td class="distd">口音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ky" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_shengao" value="0"></td>
		<td class="distd">体征编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tzbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">体征</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tz" value=""></td>
		<td class="distd">体态编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ttbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">体态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tt" value=""></td>
		<td class="distd">衣着</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">住址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zz" value=""></td>
		<td class="distd">发文单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_fwdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发文单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_fwdwbm" value=""></td>
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ajlbbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ajlb" value=""></td>
		<td class="distd">通报时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_jyaq" value=""></td>
		<td class="distd">处理结果</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cljg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkr" value=""></td>
		<td class="distd">布控操作员</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkczy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控操作时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkczsj" value=""></td>
		<td class="distd">布控到期时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkdqsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控范围编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkfwbm" value=""></td>
		<td class="distd">布控范围</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkfw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">布控审批意见</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkspyj" value=""></td>
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_lxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_lxfs" value=""></td>
		<td class="distd">是否同意发布</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_sftyfb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_spdw" value=""></td>
		<td class="distd">审批人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_spr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_sprq" value=""></td>
		<td class="distd">请求撤控标识</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_qqckbs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控标识</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckbs" value=""></td>
		<td class="distd">撤控原因</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cksj" value=""></td>
		<td class="distd">撤控人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控操作员</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckczy" value=""></td>
		<td class="distd">撤控操作时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckczsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控部门编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckbmbm" value=""></td>
		<td class="distd">撤控部门名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckbmmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckspdw" value=""></td>
		<td class="distd">撤控审批人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckspr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤控审批意见</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ckspyj" value=""></td>
		<td class="distd">撤控审批日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cksprq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzqhbm" value=""></td>
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发送标识</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_fsbs" value=""></td>
		<td class="distd">布控对象照片</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bkdxzp" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>