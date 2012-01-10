<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjgzid").append(setNull(json.LBjxxb[0].bjgzid));
		$("#bjxxid").append(setNull(json.LBjxxb[0].bjxxid));
		$("#ssqymc").append(setNull(json.LBjxxb[0].ssqymc));
		$("#ssqydz").append(setNull(json.LBjxxb[0].ssqydz));
		$("#gxdwbm").append(setNull(json.LBjxxb[0].gxdwbm));
		$("#gxdwmc").append(setNull(json.LBjxxb[0].gxdwmc));
		$("#bjlx").append(setNull(json.LBjxxb[0].bjlx));
		$("#bjsj").append(setNull(json.LBjxxb[0].bjsj));
		$("#bdbm").append(setNull(json.LBjxxb[0].bdbm));
		$("#ywbm").append(setNull(json.LBjxxb[0].ywbm));
		$("#hylb").append(setNull(json.LBjxxb[0].hylb));
		$("#xm").append(setNull(json.LBjxxb[0].xm));
		$("#gmsfhm").append(setNull(json.LBjxxb[0].gmsfhm));
		$("#jyaq").append(setNull(json.LBjxxb[0].jyaq));
		$("#ladwbm").append(setNull(json.LBjxxb[0].ladwbm));
		$("#ladwmc").append(setNull(json.LBjxxb[0].ladwmc));
		$("#gxbbh").append(setNull(json.LBjxxb[0].gxbbh));
		$("#ywlb").append(setNull(json.LBjxxb[0].ywlb));
		$("#pjbmdm").append(setNull(json.LBjxxb[0].pjbmdm));
		$("#pjbmmc").append(setNull(json.LBjxxb[0].pjbmmc));
		$("#pjr").append(setNull(json.LBjxxb[0].pjr));
		$("#pjsj").append(setNull(json.LBjxxb[0].pjsj));
		$("#jqzt").append(setNull(json.LBjxxb[0].jqzt));
		$("#cjbm").append(setNull(json.LBjxxb[0].cjbm));
		$("#cjbmdm").append(setNull(json.LBjxxb[0].cjbmdm));
		$("#chjsj").append(setNull(json.LBjxxb[0].chjsj));
		$("#cjfzr").append(setNull(json.LBjxxb[0].cjfzr));
		$("#lxdh").append(setNull(json.LBjxxb[0].lxdh));
		$("#cjfklb").append(setNull(json.LBjxxb[0].cjfklb));
		$("#cjfkbz").append(setNull(json.LBjxxb[0].cjfkbz));
		$("#fkdw").append(setNull(json.LBjxxb[0].fkdw));
		$("#fkdwbm").append(setNull(json.LBjxxb[0].fkdwbm));
		$("#fkrq").append(setNull(json.LBjxxb[0].fkrq));
		$("#cjjg").append(setNull(json.LBjxxb[0].cjjg));
		$("#chjjg").append(setNull(json.LBjxxb[0].chjjg));
		$("#zhsj").append(setNull(json.LBjxxb[0].zhsj));
		$("#wxyy").append(setNull(json.LBjxxb[0].wxyy));
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
		<td class="detailtd2">报警类型</td>
		<td class="detailtd1"><span id="bjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警时间</td>
		<td class="detailtd1"><span id="bjsj"></span></td>
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
		<td class="detailtd2">简要案情</td>
		<td class="detailtd1"><span id="jyaq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">立案单位编码</td>
		<td class="detailtd1"><span id="ladwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">立案单位名称</td>
		<td class="detailtd1"><span id="ladwmc"></span></td>
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
		<td class="detailtd2">派警部门代码</td>
		<td class="detailtd1"><span id="pjbmdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">派警部门名称</td>
		<td class="detailtd1"><span id="pjbmmc"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">派警人</td>
		<td class="detailtd1"><span id="pjr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">派警时间</td>
		<td class="detailtd1"><span id="pjsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">警情状态</td>
		<td class="detailtd1"><span id="jqzt"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">出警部门</td>
		<td class="detailtd1"><span id="cjbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">出警部门代码</td>
		<td class="detailtd1"><span id="cjbmdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">出警时间</td>
		<td class="detailtd1"><span id="chjsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">出警负责人</td>
		<td class="detailtd1"><span id="cjfzr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">联系电话</td>
		<td class="detailtd1"><span id="lxdh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">处警反馈类别</td>
		<td class="detailtd1"><span id="cjfklb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">处警反馈备注</td>
		<td class="detailtd1"><span id="cjfkbz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">反馈单位</td>
		<td class="detailtd1"><span id="fkdw"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">反馈单位编码</td>
		<td class="detailtd1"><span id="fkdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">反馈日期</td>
		<td class="detailtd1"><span id="fkrq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">处警经过</td>
		<td class="detailtd1"><span id="cjjg"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">处警结果</td>
		<td class="detailtd1"><span id="chjjg"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">抓获时间</td>
		<td class="detailtd1"><span id="zhsj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">无效原因</td>
		<td class="detailtd1"><span id="wxyy"></span></td>
	</tr>
</table>