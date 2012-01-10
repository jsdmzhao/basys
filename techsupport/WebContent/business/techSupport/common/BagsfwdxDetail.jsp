<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bagsfwdxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bagsfwdxid").append(setNull(json.LBagsfwdx[0].bagsfwdxid));
		$("#bafwgsbm").append(setNull(json.LBagsfwdx[0].bafwgsbm));
		$("#bagsfwdxmc").append(setNull(json.LBagsfwdx[0].bagsfwdxmc));
		$("#fwdxlxdm").append(setNull(json.LBagsfwdx[0].fwdxlxdm));
		$("#bafwlxdm").append(setNull(json.LBagsfwdx[0].bafwlxdm));
		$("#ssxdm").append(setNull(json.LBagsfwdx[0].ssxdm));
		$("#ssxmc").append(setNull(json.LBagsfwdx[0].ssxmc));
		$("#gxdwbm").append(setNull(json.LBagsfwdx[0].gxdwbm));
		$("#gxdwmc").append(setNull(json.LBagsfwdx[0].gxdwmc));
		$("#xxdz").append(setNull(json.LBagsfwdx[0].xxdz));
		$("#lxr").append(setNull(json.LBagsfwdx[0].lxr));
		$("#lxdh").append(setNull(json.LBagsfwdx[0].lxdh));
		$("#htkssj").append(setNull(json.LBagsfwdx[0].htkssj));
		$("#htzzsj").append(setNull(json.LBagsfwdx[0].htzzsj));
		$("#sfzabwzddw").append(setNull(json.LBagsfwdx[0].sfzabwzddw));
		$("#sfylcs").append(setNull(json.LBagsfwdx[0].sfylcs));
		$("#djr").append(setNull(json.LBagsfwdx[0].djr));
		$("#djsj").append(setNull(json.LBagsfwdx[0].djsj));
		$("#lastedittime").append(setNull(json.LBagsfwdx[0].lastedittime));
	}	
</script>
<input type="hidden" id="q_bagsfwdxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#bagsfwdx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">保安公司服务对象ID</td>
		<td class="detailtd2"><span id="bagsfwdxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安服务公司编码</td>
		<td class="detailtd2"><span id="bafwgsbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安公司服务对象名称</td>
		<td class="detailtd2"><span id="bagsfwdxmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">服务对象类型代码</td>
		<td class="detailtd2"><span id="fwdxlxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安服务类型代码</td>
		<td class="detailtd2"><span id="bafwlxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">省市县代码</td>
		<td class="detailtd2"><span id="ssxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">省市县名称</td>
		<td class="detailtd2"><span id="ssxmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位编码</td>
		<td class="detailtd2"><span id="gxdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位名称</td>
		<td class="detailtd2"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">详细地址</td>
		<td class="detailtd2"><span id="xxdz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系人</td>
		<td class="detailtd2"><span id="lxr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系电话</td>
		<td class="detailtd2"><span id="lxdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">合同开始时间</td>
		<td class="detailtd2"><span id="htkssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">合同终止时间</td>
		<td class="detailtd2"><span id="htzzsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">是否治安保卫重点单位</td>
		<td class="detailtd2"><span id="sfzabwzddw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">是否娱乐场所</td>
		<td class="detailtd2"><span id="sfylcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登记人</td>
		<td class="detailtd2"><span id="djr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登记时间</td>
		<td class="detailtd2"><span id="djsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">最后修改时间</td>
		<td class="detailtd2"><span id="lastedittime"></span></td>
	</tr>
</table>