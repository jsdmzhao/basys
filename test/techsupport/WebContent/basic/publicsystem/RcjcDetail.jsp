<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<script type="text/javascript">
	
	$(document).ready(function() {
		$("#q_rcjcid").attr("value",dataid);
		setDetail();
	}); 

	function updatediv (json) { 
		$("#qybm").append(setNull(json.LRcjc[0].qybm));
		$("#qymc").append(setNull(json.LRcjc[0].qymc));
		$("#rcjcid").append(setNull(json.LRcjc[0].rcjcid));
		$("#hylb").append(setNull(json.LRcjc[0].hylb));
		$("#jcfs").append(setNull(json.LRcjc[0].jcfsDisName));
		$("#rcjcbh").append(setNull(json.LRcjc[0].rcjcbh));
		$("#jcrxm").append(setNull(json.LRcjc[0].jcrxm));
		$("#jcrq").append(setNull(json.LRcjc[0].jcrq));
		$("#jcrybh").append(setNull(json.LRcjc[0].jcrybh));
		var jcrzw = setNull(json.LRcjc[0].jcrzw);
		var jcrzwdm = setNull(json.LRcjc[0].zwdm);
		if(jcrzw!='' || jcrzwdm!=''){
			$("#jcrzw").append(jcrzw+"["+jcrzwdm+"]");
		}
		if(setNull(json.LRcjc[0].mjjczbh)==''){
			$('#mjjczbh_tr').hide();
		}else{
			$("#mjjczbh").append(setNull(json.LRcjc[0].mjjczbh));
		}
		$("#lsdw").append(setNull(json.LRcjc[0].lsdw));
		$("#fxwt").append(setNull(json.LRcjc[0].fxwt));
		$("#cljg").append(setNull(json.LRcjc[0].cljg));
		$("#bz").append(setNull(json.LRcjc[0].bz));
		$("#csfzr").append(setNull(json.LRcjc[0].csfzr));
		$("#csfzrbh").append(setNull(json.LRcjc[0].csfzrbh));
		$("#jcsx").append(setNull(json.LRcjc[0].jcsx));
		$("#sfzdjcjg").append(setNull(json.LRcjc[0].sfzdjcjg));
		//设定行业信息表示
		if(setNull(json.LRcjc[0].hylbdm)=='J'||setNull(json.LRcjc[0].hylbdm)=='K'){
			$('#dtd_qymc').text('场所名称');
			$('#dtd_qybm').text('场所备案编号');
			$('#dtd_csfzr').text('场所负责人');
			$('#dtd_csfzrbh').text('场所负责人编号');
		}
	}	
</script>
<input type="hidden" id="q_rcjcid">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">日常检查详细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#rcjc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table></div>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="16">
    	<td class="distd1">行业类别</td>
		<td class="detailtd2" colspan="3"><span id="hylb"></span></td>
	</tr>
	<tr height="16">
		<td class="distd1" id="dtd_qymc">企业名称</td>
		<td class="detailtd2" ><span id="qymc"></span></td>
		<td class="distd1" id="dtd_qybm">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	<tr height="16">
		<td class="distd1" id="dtd_csfzr">企业负责人</td>
		<td class="detailtd2" ><span id="csfzr"></span></td>
		<td class="distd1" id="dtd_csfzrbh">企业负责人编号</td>
		<td class="detailtd2" ><span id="csfzrbh"></span></td>
	</tr>
	<tr height="16">
		<td class="distd1">检查方式</td>
		<td class="detailtd2"><span id="jcfs"></span></td>
		<td class="distd1">日常检查登记序号</td>
		<td class="detailtd2"><span id="rcjcbh"></span></td>
	</tr>
	<tr id="mjjczbh_tr" height="16">
		<td  class="distd1">民警检查编号</td>
		<td  class="detailtd2" colspan="3"><span id="mjjczbh"></span></td>
	</tr>
	<tr height="16">
		<td class="distd1">检查人员姓名</td>
		<td class="detailtd2"><span id="jcrxm"></span></td>
		<td class="distd1">检查日期</td>
		<td class="detailtd2"><span id="jcrq"></span></td>
	</tr>
	<tr height="16">
		<td class="distd1">检查人警号</td>
		<td class="detailtd2"><span id="jcrybh"></span></td>
		<td class="distd1">检查人职务</td>
		<td class="detailtd2"><span id="jcrzw"></span></td>
	</tr>
	<tr height="16">
		<td class="distd1">检查机构</td>
		<td class="detailtd2" colspan="3"><span id="lsdw"></span></td>
	</tr>
	<tr height="16">
		<td class="distd1">检查事项</td>
		<td class="detailtd2" ><span id="jcsx"></span></td>
		<td class="distd1">是否知道检查结果</td>
		<td class="detailtd2"><span id="sfzdjcjg"></span></td>
	</tr>
	<tr height="16">
		<td class="distd1">发现问题</td>
		<td class="detailtd2" colspan="3" width="500"><label>
		  <span id="fxwt"></span>
		</label></td>
  </tr>
    	<tr height="16">
		<td class="distd1">处理结果</td>
		<td class="detailtd2"  colspan="3" width="500"><span id="cljg"></span></td>
	</tr>
    	<tr height="16">
    	<td class="distd1">备注</td>
		<td class="detailtd2"  colspan="3" width="500"><span id="bz"></span></td>
	</tr>
</table>