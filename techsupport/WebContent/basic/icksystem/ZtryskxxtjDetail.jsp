<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyryskxxtjmxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyryskxxtjmxid").append(setNull(json.LZtryskxxtj[0].qyryskxxtjmxid));
		$("#qybm").append(setNull(json.LZtryskxxtj[0].qybm));
		$("#qymc").append(setNull(json.LZtryskxxtj[0].qymc));
		$("#qyzflbm").append(setNull(json.LZtryskxxtj[0].qyzflbm));
		$("#qyzflmc").append(setNull(json.LZtryskxxtj[0].qyzflmc));
		$("#qyfflbm").append(setNull(json.LZtryskxxtj[0].qyfflbm));
		$("#qyfflmc").append(setNull(json.LZtryskxxtj[0].qyfflmc));
		$("#gxdwbm").append(setNull(json.LZtryskxxtj[0].gxdwbm));
		$("#gxdwmc").append(setNull(json.LZtryskxxtj[0].gxdwmc));
		$("#ssqyid").append(setNull(json.LZtryskxxtj[0].ssqyid));
		$("#ssqybm").append(setNull(json.LZtryskxxtj[0].ssqybm));
		$("#ssqymc").append(setNull(json.LZtryskxxtj[0].ssqymc));
		$("#ssqygxdwdm").append(setNull(json.LZtryskxxtj[0].ssqygxdwdm));
		$("#ssqygxdwmc").append(setNull(json.LZtryskxxtj[0].ssqygxdwmc));
		$("#ssqyzfldm").append(setNull(json.LZtryskxxtj[0].ssqyzfldm));
		$("#ssqyzflmc").append(setNull(json.LZtryskxxtj[0].ssqyzflmc));
		$("#hylbdm").append(setNull(json.LZtryskxxtj[0].hylbdm));
		$("#hylb").append(setNull(json.LZtryskxxtj[0].hylb));
		$("#sksj").append(setNull(json.LZtryskxxtj[0].sksj));
		$("#scsj").append(setNull(json.LZtryskxxtj[0].scsj));
		$("#ryid").append(setNull(json.LZtryskxxtj[0].ryid));
		$("#cyrybh").append(setNull(json.LZtryskxxtj[0].cyrybh));
		$("#cyrylbdm").append(setNull(json.LZtryskxxtj[0].cyrylbdm));
		$("#cyrylbmc").append(setNull(json.LZtryskxxtj[0].cyrylbmc));
		$("#xm").append(setNull(json.LZtryskxxtj[0].xm));
		$("#qm").append(setNull(json.LZtryskxxtj[0].qm));
		$("#bm").append(setNull(json.LZtryskxxtj[0].bm));
		$("#xmpy").append(setNull(json.LZtryskxxtj[0].xmpy));
		$("#gjdm").append(setNull(json.LZtryskxxtj[0].gjdm));
		$("#gj").append(setNull(json.LZtryskxxtj[0].gj));
		$("#mzdm").append(setNull(json.LZtryskxxtj[0].mzdm));
		$("#minzu").append(setNull(json.LZtryskxxtj[0].minzu));
		$("#xbdm").append(setNull(json.LZtryskxxtj[0].xbdm));
		$("#xb").append(setNull(json.LZtryskxxtj[0].xb));
		$("#csrq").append(setNull(json.LZtryskxxtj[0].csrq));
		$("#hyzkdm").append(setNull(json.LZtryskxxtj[0].hyzkdm));
		$("#hyzk").append(setNull(json.LZtryskxxtj[0].hyzk));
		$("#shengao").append(setNull(json.LZtryskxxtj[0].shengao));
		$("#tizh").append(setNull(json.LZtryskxxtj[0].tizh));
		$("#xxdm").append(setNull(json.LZtryskxxtj[0].xxdm));
		$("#xx").append(setNull(json.LZtryskxxtj[0].xx));
		$("#hjdxzqh").append(setNull(json.LZtryskxxtj[0].hjdxzqh));
		$("#hjdxzqhdm").append(setNull(json.LZtryskxxtj[0].hjdxzqhdm));
		$("#hjdxz").append(setNull(json.LZtryskxxtj[0].hjdxz));
		$("#cyzjdm").append(setNull(json.LZtryskxxtj[0].cyzjdm));
		$("#cyzj").append(setNull(json.LZtryskxxtj[0].cyzj));
		$("#zjhm").append(setNull(json.LZtryskxxtj[0].zjhm));
		$("#zzzhm").append(setNull(json.LZtryskxxtj[0].zzzhm));
		$("#zzdz").append(setNull(json.LZtryskxxtj[0].zzdz));
		$("#gwbh").append(setNull(json.LZtryskxxtj[0].gwbh));
		$("#gwmc").append(setNull(json.LZtryskxxtj[0].gwmc));
		$("#gwzrms").append(setNull(json.LZtryskxxtj[0].gwzrms));
		$("#shouji").append(setNull(json.LZtryskxxtj[0].shouji));
		$("#lxdh").append(setNull(json.LZtryskxxtj[0].lxdh));
		$("#jjlxr").append(setNull(json.LZtryskxxtj[0].jjlxr));
		$("#jjlxrdh").append(setNull(json.LZtryskxxtj[0].jjlxrdh));
		$("#gzdm").append(setNull(json.LZtryskxxtj[0].gzdm));
		$("#gz").append(setNull(json.LZtryskxxtj[0].gz));
		$("#zhiwu").append(setNull(json.LZtryskxxtj[0].zhiwu));
		$("#rzrq").append(setNull(json.LZtryskxxtj[0].rzrq));
		$("#lzrq").append(setNull(json.LZtryskxxtj[0].lzrq));
		$("#cyryztdm").append(setNull(json.LZtryskxxtj[0].cyryztdm));
		$("#cyryzt").append(setNull(json.LZtryskxxtj[0].cyryzt));
		$("#cxr").append(setNull(json.LZtryskxxtj[0].cxr));
		$("#zxbz").append(setNull(json.LZtryskxxtj[0].zxbz));
		$("#cxsj").append(setNull(json.LZtryskxxtj[0].cxsj));
		$("#lrsj").append(setNull(json.LZtryskxxtj[0].lrsj));
		$("#lrr").append(setNull(json.LZtryskxxtj[0].lrr));
		$("#lrdwbm").append(setNull(json.LZtryskxxtj[0].lrdwbm));
		$("#lrdwmc").append(setNull(json.LZtryskxxtj[0].lrdwmc));
		$("#hcdw").append(setNull(json.LZtryskxxtj[0].hcdw));
		$("#hcr").append(setNull(json.LZtryskxxtj[0].hcr));
		$("#hcsj").append(setNull(json.LZtryskxxtj[0].hcsj));
		$("#zxyy").append(setNull(json.LZtryskxxtj[0].zxyy));
		$("#zkzt").append(setNull(json.LZtryskxxtj[0].zkzt));
		$("#bcsj").append(setNull(json.LZtryskxxtj[0].bcsj));
		$("#dcbs").append(setNull(json.LZtryskxxtj[0].dcbs));
		$("#bz").append(setNull(json.LZtryskxxtj[0].bz));
		$("#scbz").append(setNull(json.LZtryskxxtj[0].scbz));
		$("#biduiflag").append(setNull(json.LZtryskxxtj[0].biduiflag));
		$("#zpwtgyy").append(setNull(json.LZtryskxxtj[0].zpwtgyy));
		$("#zt").append(setNull(json.LZtryskxxtj[0].zt));
		$("#ywx").append(setNull(json.LZtryskxxtj[0].ywx));
		$("#ywm").append(setNull(json.LZtryskxxtj[0].ywm));
		$("#wgrjyxkz").append(setNull(json.LZtryskxxtj[0].wgrjyxkz));
		$("#qzzldm").append(setNull(json.LZtryskxxtj[0].qzzldm));
		$("#qzhm").append(setNull(json.LZtryskxxtj[0].qzhm));
		$("#zatlq").append(setNull(json.LZtryskxxtj[0].zatlq));
		$("#qfjg").append(setNull(json.LZtryskxxtj[0].qfjg));
		$("#rjrq").append(setNull(json.LZtryskxxtj[0].rjrq));
		$("#rjka").append(setNull(json.LZtryskxxtj[0].rjka));
		$("#kh").append(setNull(json.LZtryskxxtj[0].kh));
		$("#ickh").append(setNull(json.LZtryskxxtj[0].ickh));
		$("#slyy").append(setNull(json.LZtryskxxtj[0].slyy));
		$("#slr").append(setNull(json.LZtryskxxtj[0].slr));
		$("#slsj").append(setNull(json.LZtryskxxtj[0].slsj));
		$("#yxsksrq").append(setNull(json.LZtryskxxtj[0].yxsksrq));
		$("#yxqhzrq").append(setNull(json.LZtryskxxtj[0].yxqhzrq));
		$("#ickcjsj").append(setNull(json.LZtryskxxtj[0].ickcjsj));
		$("#ickcjr").append(setNull(json.LZtryskxxtj[0].ickcjr));
		$("#ickcjdbm").append(setNull(json.LZtryskxxtj[0].ickcjdbm));
		$("#ickcjdmc").append(setNull(json.LZtryskxxtj[0].ickcjdmc));
		$("#jssj").append(setNull(json.LZtryskxxtj[0].jssj));
		$("#jsbmc").append(setNull(json.LZtryskxxtj[0].jsbmc));
		$("#ffr").append(setNull(json.LZtryskxxtj[0].ffr));
		$("#ffsj").append(setNull(json.LZtryskxxtj[0].ffsj));
		$("#lqr").append(setNull(json.LZtryskxxtj[0].lqr));
		$("#lqsj").append(setNull(json.LZtryskxxtj[0].lqsj));
		$("#lqrzjlx").append(setNull(json.LZtryskxxtj[0].lqrzjlx));
		$("#lqrzjhm").append(setNull(json.LZtryskxxtj[0].lqrzjhm));
		$("#ickzxr").append(setNull(json.LZtryskxxtj[0].ickzxr));
		$("#ickzxsj").append(setNull(json.LZtryskxxtj[0].ickzxsj));
		$("#ickzxyy").append(setNull(json.LZtryskxxtj[0].ickzxyy));
		$("#njr").append(setNull(json.LZtryskxxtj[0].njr));
		$("#njsj").append(setNull(json.LZtryskxxtj[0].njsj));
		$("#zkztbs").append(setNull(json.LZtryskxxtj[0].zkztbs));
		$("#sfqr").append(setNull(json.LZtryskxxtj[0].sfqr));
		$("#ysr").append(setNull(json.LZtryskxxtj[0].ysr));
		$("#yssj").append(setNull(json.LZtryskxxtj[0].yssj));
		$("#dxrr").append(setNull(json.LZtryskxxtj[0].dxrr));
		$("#dxrsj").append(setNull(json.LZtryskxxtj[0].dxrsj));
		$("#cyssj").append(setNull(json.LZtryskxxtj[0].cyssj));
		$("#cysyy").append(setNull(json.LZtryskxxtj[0].cysyy));
		$("#cdxrsj").append(setNull(json.LZtryskxxtj[0].cdxrsj));
		$("#cdxryy").append(setNull(json.LZtryskxxtj[0].cdxryy));
		$("#bhkyy").append(setNull(json.LZtryskxxtj[0].bhkyy));
		$("#yksfsh").append(setNull(json.LZtryskxxtj[0].yksfsh));
		$("#ztryskxxtjmxid").append(setNull(json.LZtryskxxtj[0].ztryskxxtjmxid));
		$("#skid3").append(setNull(json.LZtryskxxtj[0].skid3));
		$("#tjrq").append(setNull(json.LZtryskxxtj[0].tjrq));
	}	
</script>
<input type="hidden" id="q_qyryskxxtjmxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#ztryskxxtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业人员刷卡信息统计明细ID</td>
		<td class="detailtd2"><span id="qyryskxxtjmxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业名称</td>
		<td class="detailtd2"><span id="qymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业主分类编码</td>
		<td class="detailtd2"><span id="qyzflbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业主分类名称</td>
		<td class="detailtd2"><span id="qyzflmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业副分类编码</td>
		<td class="detailtd2"><span id="qyfflbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业副分类名称</td>
		<td class="detailtd2"><span id="qyfflmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位代码</td>
		<td class="detailtd2"><span id="gxdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位名称</td>
		<td class="detailtd2"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属企业ID</td>
		<td class="detailtd2"><span id="ssqyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属企业编码</td>
		<td class="detailtd2"><span id="ssqybm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属企业名称</td>
		<td class="detailtd2"><span id="ssqymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属企业管辖单位代码</td>
		<td class="detailtd2"><span id="ssqygxdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属企业管辖单位名称</td>
		<td class="detailtd2"><span id="ssqygxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属企业主分类代码</td>
		<td class="detailtd2"><span id="ssqyzfldm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属企业主分类名称</td>
		<td class="detailtd2"><span id="ssqyzflmc"></span></td>
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
		<td class="distd1">刷卡时间</td>
		<td class="detailtd2"><span id="sksj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">上传时间</td>
		<td class="detailtd2"><span id="scsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员ID</td>
		<td class="detailtd2"><span id="ryid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员编号</td>
		<td class="detailtd2"><span id="cyrybh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员类别代码</td>
		<td class="detailtd2"><span id="cyrylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员类别名称</td>
		<td class="detailtd2"><span id="cyrylbmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">全名</td>
		<td class="detailtd2"><span id="qm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">别名</td>
		<td class="detailtd2"><span id="bm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名拼音</td>
		<td class="detailtd2"><span id="xmpy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">国籍代码</td>
		<td class="detailtd2"><span id="gjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">国籍</td>
		<td class="detailtd2"><span id="gj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">民族代码</td>
		<td class="detailtd2"><span id="mzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">民族</td>
		<td class="detailtd2"><span id="minzu"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别代码</td>
		<td class="detailtd2"><span id="xbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别</td>
		<td class="detailtd2"><span id="xb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">出生日期</td>
		<td class="detailtd2"><span id="csrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">婚姻状况代码</td>
		<td class="detailtd2"><span id="hyzkdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">婚姻状况</td>
		<td class="detailtd2"><span id="hyzk"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">身高</td>
		<td class="detailtd2"><span id="shengao"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">体重</td>
		<td class="detailtd2"><span id="tizh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">血型代码</td>
		<td class="detailtd2"><span id="xxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">血型</td>
		<td class="detailtd2"><span id="xx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地行政区划</td>
		<td class="detailtd2"><span id="hjdxzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地行政区划代码</td>
		<td class="detailtd2"><span id="hjdxzqhdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地详址</td>
		<td class="detailtd2"><span id="hjdxz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件代码</td>
		<td class="detailtd2"><span id="cyzjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件</td>
		<td class="detailtd2"><span id="cyzj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">证件号码</td>
		<td class="detailtd2"><span id="zjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">暂住证号码</td>
		<td class="detailtd2"><span id="zzzhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">暂住地址</td>
		<td class="detailtd2"><span id="zzdz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">岗位编号</td>
		<td class="detailtd2"><span id="gwbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">岗位名称</td>
		<td class="detailtd2"><span id="gwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">岗位责任描述</td>
		<td class="detailtd2"><span id="gwzrms"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">手机</td>
		<td class="detailtd2"><span id="shouji"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系电话</td>
		<td class="detailtd2"><span id="lxdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">紧急联系人</td>
		<td class="detailtd2"><span id="jjlxr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">紧急联系人电话</td>
		<td class="detailtd2"><span id="jjlxrdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">工种代码</td>
		<td class="detailtd2"><span id="gzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">工种</td>
		<td class="detailtd2"><span id="gz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">职务</td>
		<td class="detailtd2"><span id="zhiwu"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">入职日期</td>
		<td class="detailtd2"><span id="rzrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">离职日期</td>
		<td class="detailtd2"><span id="lzrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员状态代码</td>
		<td class="detailtd2"><span id="cyryztdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员状态</td>
		<td class="detailtd2"><span id="cyryzt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤销人</td>
		<td class="detailtd2"><span id="cxr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">注销标志</td>
		<td class="detailtd2"><span id="zxbz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">撤销时间</td>
		<td class="detailtd2"><span id="cxsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入时间</td>
		<td class="detailtd2"><span id="lrsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入人</td>
		<td class="detailtd2"><span id="lrr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入单位编码</td>
		<td class="detailtd2"><span id="lrdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入单位名称</td>
		<td class="detailtd2"><span id="lrdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查单位</td>
		<td class="detailtd2"><span id="hcdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查人</td>
		<td class="detailtd2"><span id="hcr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核查时间</td>
		<td class="detailtd2"><span id="hcsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">注销原因</td>
		<td class="detailtd2"><span id="zxyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">制卡状态</td>
		<td class="detailtd2"><span id="zkzt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保存时间</td>
		<td class="detailtd2"><span id="bcsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">导出标识</td>
		<td class="detailtd2"><span id="dcbs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">备注</td>
		<td class="detailtd2"><span id="bz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">删除标志</td>
		<td class="detailtd2"><span id="scbz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对标志</td>
		<td class="detailtd2"><span id="biduiflag"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">照片未通过原因</td>
		<td class="detailtd2"><span id="zpwtgyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态</td>
		<td class="detailtd2"><span id="zt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文姓</td>
		<td class="detailtd2"><span id="ywx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文名</td>
		<td class="detailtd2"><span id="ywm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">外国人就业许可证号</td>
		<td class="detailtd2"><span id="wgrjyxkz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证种类代码</td>
		<td class="detailtd2"><span id="qzzldm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签证号码</td>
		<td class="detailtd2"><span id="qzhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">在华停留期至</td>
		<td class="detailtd2"><span id="zatlq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">签发机关</td>
		<td class="detailtd2"><span id="qfjg"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">入境日期</td>
		<td class="detailtd2"><span id="rjrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">入境口岸</td>
		<td class="detailtd2"><span id="rjka"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">卡号</td>
		<td class="detailtd2"><span id="kh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">卡ID号</td>
		<td class="detailtd2"><span id="ickh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">申领原因</td>
		<td class="detailtd2"><span id="slyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理人</td>
		<td class="detailtd2"><span id="slr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理时间</td>
		<td class="detailtd2"><span id="slsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">有效期开始日期</td>
		<td class="detailtd2"><span id="yxsksrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">有效期截至日期</td>
		<td class="detailtd2"><span id="yxqhzrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡采集时间</td>
		<td class="detailtd2"><span id="ickcjsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡采集人</td>
		<td class="detailtd2"><span id="ickcjr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡采集点编码</td>
		<td class="detailtd2"><span id="ickcjdbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡采集点名称</td>
		<td class="detailtd2"><span id="ickcjdmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">接收时间</td>
		<td class="detailtd2"><span id="jssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">接收包名称</td>
		<td class="detailtd2"><span id="jsbmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发放人</td>
		<td class="detailtd2"><span id="ffr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发放时间</td>
		<td class="detailtd2"><span id="ffsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">领取人</td>
		<td class="detailtd2"><span id="lqr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">领取时间</td>
		<td class="detailtd2"><span id="lqsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">领取人证件类型</td>
		<td class="detailtd2"><span id="lqrzjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">领取人证件号码</td>
		<td class="detailtd2"><span id="lqrzjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡注销人</td>
		<td class="detailtd2"><span id="ickzxr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡注销时间</td>
		<td class="detailtd2"><span id="ickzxsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡注销原因</td>
		<td class="detailtd2"><span id="ickzxyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">年检人</td>
		<td class="detailtd2"><span id="njr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">年检时间</td>
		<td class="detailtd2"><span id="njsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">制卡状态标识</td>
		<td class="detailtd2"><span id="zkztbs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">是否确认</td>
		<td class="detailtd2"><span id="sfqr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">印刷人</td>
		<td class="detailtd2"><span id="ysr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">印刷时间</td>
		<td class="detailtd2"><span id="yssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">电写入人</td>
		<td class="detailtd2"><span id="dxrr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">电写入时间</td>
		<td class="detailtd2"><span id="dxrsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">重印刷时间</td>
		<td class="detailtd2"><span id="cyssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">重印刷原因</td>
		<td class="detailtd2"><span id="cysyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">重电写入时间</td>
		<td class="detailtd2"><span id="cdxrsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">重电写入原因</td>
		<td class="detailtd2"><span id="cdxryy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">补换卡原因</td>
		<td class="detailtd2"><span id="bhkyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">原卡是否收回</td>
		<td class="detailtd2"><span id="yksfsh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">走台人员刷卡信息统计明细id</td>
		<td class="detailtd2"><span id="ztryskxxtjmxid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">刷卡ID</td>
		<td class="detailtd2"><span id="skid3"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">统计日期</td>
		<td class="detailtd2"><span id="tjrq"></span></td>
	</tr>
</table>