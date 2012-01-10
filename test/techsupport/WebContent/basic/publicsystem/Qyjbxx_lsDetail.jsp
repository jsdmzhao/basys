<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyid").append(setNull(json.LQyjbxx_ls[0].qyid));
		$("#qylsid").append(setNull(json.LQyjbxx_ls[0].qylsid));
		$("#hylbdm").append(setNull(json.LQyjbxx_ls[0].hylbdm));
		$("#hylb").append(setNull(json.LQyjbxx_ls[0].hylb));
		$("#qybm").append(setNull(json.LQyjbxx_ls[0].qybm));
		$("#qymc").append(setNull(json.LQyjbxx_ls[0].qymc));
		$("#qyqp").append(setNull(json.LQyjbxx_ls[0].qyqp));
		$("#qyjp").append(setNull(json.LQyjbxx_ls[0].qyjp));
		$("#qyzflbm").append(setNull(json.LQyjbxx_ls[0].qyzflbm));
		$("#qyzflmc").append(setNull(json.LQyjbxx_ls[0].qyzflmc));
		$("#qyfflbm").append(setNull(json.LQyjbxx_ls[0].qyfflbm));
		$("#qyfflmc").append(setNull(json.LQyjbxx_ls[0].qyfflmc));
		$("#gxdwbm").append(setNull(json.LQyjbxx_ls[0].gxdwbm));
		$("#gxdwmc").append(setNull(json.LQyjbxx_ls[0].gxdwmc));
		$("#ssdxjgajgdm").append(setNull(json.LQyjbxx_ls[0].ssdxjgajgdm));
		$("#ssdxjgajgmc").append(setNull(json.LQyjbxx_ls[0].ssdxjgajgmc));
		$("#ssdpcsjgdm").append(setNull(json.LQyjbxx_ls[0].ssdpcsjgdm));
		$("#ssdpcsjgmc").append(setNull(json.LQyjbxx_ls[0].ssdpcsjgmc));
		$("#qyzzjgdm").append(setNull(json.LQyjbxx_ls[0].qyzzjgdm));
		$("#lxdh").append(setNull(json.LQyjbxx_ls[0].lxdh));
		$("#yzbm").append(setNull(json.LQyjbxx_ls[0].yzbm));
		$("#chzh").append(setNull(json.LQyjbxx_ls[0].chzh));
		$("#jwdzb").append(setNull(json.LQyjbxx_ls[0].jwdzb));
		$("#jjlxbm").append(setNull(json.LQyjbxx_ls[0].jjlxbm));
		$("#jjlxmc").append(setNull(json.LQyjbxx_ls[0].jjlxmc));
		$("#jyfwzy").append(setNull(json.LQyjbxx_ls[0].jyfwzy));
		$("#jyfwjy").append(setNull(json.LQyjbxx_ls[0].jyfwjy));
		$("#zczj").append(setNull(json.LQyjbxx_ls[0].zczj));
		$("#jymj").append(setNull(json.LQyjbxx_ls[0].jymj));
		$("#zabdm").append(setNull(json.LQyjbxx_ls[0].zabdm));
		$("#zajbmc").append(setNull(json.LQyjbxx_ls[0].zajbmc));
		$("#yyztdm").append(setNull(json.LQyjbxx_ls[0].yyztdm));
		$("#yyztmc").append(setNull(json.LQyjbxx_ls[0].yyztmc));
		$("#frdb").append(setNull(json.LQyjbxx_ls[0].frdb));
		$("#frdbzjlb").append(setNull(json.LQyjbxx_ls[0].frdbzjlb));
		$("#frdbzjhm").append(setNull(json.LQyjbxx_ls[0].frdbzjhm));
		$("#frdblxfs").append(setNull(json.LQyjbxx_ls[0].frdblxfs));
		$("#kyrq").append(setNull(json.LQyjbxx_ls[0].kyrq));
		$("#yysj").append(setNull(json.LQyjbxx_ls[0].yysj));
		$("#babh").append(setNull(json.LQyjbxx_ls[0].babh));
		$("#barq").append(setNull(json.LQyjbxx_ls[0].barq));
		$("#tyrq").append(setNull(json.LQyjbxx_ls[0].tyrq));
		$("#jyfs").append(setNull(json.LQyjbxx_ls[0].jyfs));
		$("#jydz").append(setNull(json.LQyjbxx_ls[0].jydz));
		$("#dwfzrzjlb").append(setNull(json.LQyjbxx_ls[0].dwfzrzjlb));
		$("#dwfzrzjhm").append(setNull(json.LQyjbxx_ls[0].dwfzrzjhm));
		$("#dwfzr").append(setNull(json.LQyjbxx_ls[0].dwfzr));
		$("#dwfzrlxfs").append(setNull(json.LQyjbxx_ls[0].dwfzrlxfs));
		$("#xfshdw").append(setNull(json.LQyjbxx_ls[0].xfshdw));
		$("#xfhgzh").append(setNull(json.LQyjbxx_ls[0].xfhgzh));
		$("#hcdw").append(setNull(json.LQyjbxx_ls[0].hcdw));
		$("#hcr").append(setNull(json.LQyjbxx_ls[0].hcr));
		$("#hcsj").append(setNull(json.LQyjbxx_ls[0].hcsj));
		$("#gdxx").append(setNull(json.LQyjbxx_ls[0].gdxx));
		$("#zrs").append(setNull(json.LQyjbxx_ls[0].zrs));
		$("#hdrs").append(setNull(json.LQyjbxx_ls[0].hdrs));
		$("#bagsmc").append(setNull(json.LQyjbxx_ls[0].bagsmc));
		$("#bafzrgmsfhm").append(setNull(json.LQyjbxx_ls[0].bafzrgmsfhm));
		$("#bafzrxm").append(setNull(json.LQyjbxx_ls[0].bafzrxm));
		$("#bafzrdh").append(setNull(json.LQyjbxx_ls[0].bafzrdh));
		$("#bars").append(setNull(json.LQyjbxx_ls[0].bars));
		$("#jgpxrs").append(setNull(json.LQyjbxx_ls[0].jgpxrs));
		$("#bagsyj").append(setNull(json.LQyjbxx_ls[0].bagsyj));
		$("#cksl").append(setNull(json.LQyjbxx_ls[0].cksl));
		$("#bxbjsl").append(setNull(json.LQyjbxx_ls[0].bxbjsl));
		$("#bz").append(setNull(json.LQyjbxx_ls[0].bz));
		$("#dcbs").append(setNull(json.LQyjbxx_ls[0].dcbs));
		$("#dcsj").append(setNull(json.LQyjbxx_ls[0].dcsj));
		$("#zt").append(setNull(json.LQyjbxx_ls[0].zt));
		$("#ztgbrq").append(setNull(json.LQyjbxx_ls[0].ztgbrq));
		$("#scbz").append(setNull(json.LQyjbxx_ls[0].scbz));
		$("#jqbm").append(setNull(json.LQyjbxx_ls[0].jqbm));
		$("#zxbz").append(setNull(json.LQyjbxx_ls[0].zxbz));
		$("#zxyy").append(setNull(json.LQyjbxx_ls[0].zxyy));
		$("#zdskb").append(setNull(json.LQyjbxx_ls[0].zdskb));
		$("#bcsj").append(setNull(json.LQyjbxx_ls[0].bcsj));
		$("#lrsj").append(setNull(json.LQyjbxx_ls[0].lrsj));
		$("#lrr").append(setNull(json.LQyjbxx_ls[0].lrr));
		$("#lrdwbm").append(setNull(json.LQyjbxx_ls[0].lrdwbm));
		$("#lrdwmc").append(setNull(json.LQyjbxx_ls[0].lrdwmc));
		$("#czlx").append(setNull(json.LQyjbxx_ls[0].czlx));
		$("#bgyy").append(setNull(json.LQyjbxx_ls[0].bgyy));
		$("#bglbdm").append(setNull(json.LQyjbxx_ls[0].bglbdm));
		$("#bglb").append(setNull(json.LQyjbxx_ls[0].bglb));
	}	
</script>
<input type="hidden" id="q_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyjbxx_ls_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业历史ID</td>
		<td class="detailtd2"><span id="qylsid"></span></td>
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
		<td class="distd1">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业名称</td>
		<td class="detailtd2"><span id="qymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业全拼</td>
		<td class="detailtd2"><span id="qyqp"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业简拼</td>
		<td class="detailtd2"><span id="qyjp"></span></td>
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
		<td class="distd1">所属地县级公安机关机构代码</td>
		<td class="detailtd2"><span id="ssdxjgajgdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属地县级公安机关名称</td>
		<td class="detailtd2"><span id="ssdxjgajgmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属地派出所机构代码</td>
		<td class="detailtd2"><span id="ssdpcsjgdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所属地派出所机构名称</td>
		<td class="detailtd2"><span id="ssdpcsjgmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业组织机构代码</td>
		<td class="detailtd2"><span id="qyzzjgdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系电话</td>
		<td class="detailtd2"><span id="lxdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">邮政编码</td>
		<td class="detailtd2"><span id="yzbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">传真</td>
		<td class="detailtd2"><span id="chzh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经纬度坐标</td>
		<td class="detailtd2"><span id="jwdzb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经济类型编码</td>
		<td class="detailtd2"><span id="jjlxbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经济类型名称</td>
		<td class="detailtd2"><span id="jjlxmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经营范围（主营）</td>
		<td class="detailtd2"><span id="jyfwzy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经营范围（兼营）</td>
		<td class="detailtd2"><span id="jyfwjy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">注册资金</td>
		<td class="detailtd2"><span id="zczj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经营面积</td>
		<td class="detailtd2"><span id="jymj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">治安级别代码</td>
		<td class="detailtd2"><span id="zabdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">治安级别名称</td>
		<td class="detailtd2"><span id="zajbmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">营业状态代码</td>
		<td class="detailtd2"><span id="yyztdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">营业状态名称</td>
		<td class="detailtd2"><span id="yyztmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">法人代表姓名</td>
		<td class="detailtd2"><span id="frdb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">法人代表证件类别</td>
		<td class="detailtd2"><span id="frdbzjlb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">法人代表证件号码</td>
		<td class="detailtd2"><span id="frdbzjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">法人代表联系方式</td>
		<td class="detailtd2"><span id="frdblxfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">开业日期</td>
		<td class="detailtd2"><span id="kyrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">营业时间</td>
		<td class="detailtd2"><span id="yysj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">备案编号</td>
		<td class="detailtd2"><span id="babh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">备案日期</td>
		<td class="detailtd2"><span id="barq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">停业日期</td>
		<td class="detailtd2"><span id="tyrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经营方式</td>
		<td class="detailtd2"><span id="jyfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经营地址</td>
		<td class="detailtd2"><span id="jydz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">单位负责人证件类别</td>
		<td class="detailtd2"><span id="dwfzrzjlb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">单位负责人证件号码</td>
		<td class="detailtd2"><span id="dwfzrzjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">单位负责人姓名</td>
		<td class="detailtd2"><span id="dwfzr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">单位负责人联系方式</td>
		<td class="detailtd2"><span id="dwfzrlxfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">消防审核单位</td>
		<td class="detailtd2"><span id="xfshdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">消防合格证号</td>
		<td class="detailtd2"><span id="xfhgzh"></span></td>
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
		<td class="distd1">股东信息</td>
		<td class="detailtd2"><span id="gdxx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">总人数</td>
		<td class="detailtd2"><span id="zrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">核定人数</td>
		<td class="detailtd2"><span id="hdrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安公司名称</td>
		<td class="detailtd2"><span id="bagsmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安负责人公民身份号码</td>
		<td class="detailtd2"><span id="bafzrgmsfhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安负责人姓名</td>
		<td class="detailtd2"><span id="bafzrxm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安负责人电话</td>
		<td class="detailtd2"><span id="bafzrdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安人数</td>
		<td class="detailtd2"><span id="bars"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">经岗位培训人数</td>
		<td class="detailtd2"><span id="jgpxrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保安公司意见</td>
		<td class="detailtd2"><span id="bagsyj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">出口数量</td>
		<td class="detailtd2"><span id="cksl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">包厢包间数量</td>
		<td class="detailtd2"><span id="bxbjsl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">备注</td>
		<td class="detailtd2"><span id="bz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">导出标识</td>
		<td class="detailtd2"><span id="dcbs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">导出时间</td>
		<td class="detailtd2"><span id="dcsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态</td>
		<td class="detailtd2"><span id="zt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态改变日期</td>
		<td class="detailtd2"><span id="ztgbrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">删除标志</td>
		<td class="detailtd2"><span id="scbz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">机器编码</td>
		<td class="detailtd2"><span id="jqbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">注销标志</td>
		<td class="detailtd2"><span id="zxbz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">注销原因</td>
		<td class="detailtd2"><span id="zxyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">最低刷卡比</td>
		<td class="detailtd2"><span id="zdskb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">保存时间</td>
		<td class="detailtd2"><span id="bcsj"></span></td>
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
		<td class="distd1">操作类型</td>
		<td class="detailtd2"><span id="czlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">变更原因</td>
		<td class="detailtd2"><span id="bgyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">变更类别代码</td>
		<td class="detailtd2"><span id="bglbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">变更类别</td>
		<td class="detailtd2"><span id="bglb"></span></td>
	</tr>
</table>