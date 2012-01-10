<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_yjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#yjgzid").append(setNull(json.LYjxxb[0].yjgzid));
		$("#yjxxid").append(setNull(json.LYjxxb[0].yjxxid));
		$("#ssqymc").append(setNull(json.LYjxxb[0].ssqymc));
		$("#ssqydz").append(setNull(json.LYjxxb[0].ssqydz));
		$("#gxdwbm").append(setNull(json.LYjxxb[0].gxdwbm));
		$("#gxdwmc").append(setNull(json.LYjxxb[0].gxdwmc));
		$("#yjlx").append(setNull(json.LYjxxb[0].yjlx));
		$("#yjsj").append(setNull(json.LYjxxb[0].yjsj));
		$("#bdbm").append(setNull(json.LYjxxb[0].bdbm));
		$("#ywbm").append(setNull(json.LYjxxb[0].ywbm));
		$("#hylb").append(setNull(json.LYjxxb[0].hylb));
		$("#xm").append(setNull(json.LYjxxb[0].xm));
		$("#gmsfhm").append(setNull(json.LYjxxb[0].gmsfhm));
		$("#gxbbh").append(setNull(json.LYjxxb[0].gxbbh));
		$("#ywlb").append(setNull(json.LYjxxb[0].ywlb));
		$("#lxdh").append(setNull(json.LYjxxb[0].lxdh));
		$("#qkms").append(setNull(json.LYjxxb[0].qkms));
	}	
</script>
<input type="hidden" id="q_yjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">预警规则ID</td>
		<td class="detailtd1"><span id="yjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警信息ID</td>
		<td class="detailtd1"><span id="yjxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">所属企业名称</td>
		<td class="detailtd1"><span id="ssqymc"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">所属企业地址</td>
		<td class="detailtd1"><span id="ssqydz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">管辖单位代码</td>
		<td class="detailtd1"><span id="gxdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">管辖单位名称</td>
		<td class="detailtd1"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警类型</td>
		<td class="detailtd1"><span id="yjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警时间</td>
		<td class="detailtd1"><span id="yjsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">比对表名</td>
		<td class="detailtd1"><span id="bdbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">业务表名</td>
		<td class="detailtd1"><span id="ywbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">行业类别</td>
		<td class="detailtd1"><span id="hylb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">姓名</td>
		<td class="detailtd1"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">公民身份号码</td>
		<td class="detailtd1"><span id="gmsfhm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">更新版本号</td>
		<td class="detailtd1"><span id="gxbbh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">业务类别</td>
		<td class="detailtd1"><span id="ywlb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">联系电话</td>
		<td class="detailtd1"><span id="lxdh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">情况描述</td>
		<td class="detailtd1"><span id="qkms"></span></td>
	</tr>
</table>