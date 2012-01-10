<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	
function qyjbxxXiangxi_updatediv (json) { 
	$("#qyzflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyzflmc));
	$("#qyfflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyfflmc));
	$("#zajbmc").append(setNull(jsonResultMes.LQyjbxx[0].zajbmc));
	$("#yyztmc").append(setNull(jsonResultMes.LQyjbxx[0].yyztmc));
	$("#hylb").append(setNull(jsonResultMes.LQyjbxx[0].hylb));
	$("#qybm").append(setNull(jsonResultMes.LQyjbxx[0].qybm));
	$("#qymc").append(setNull(jsonResultMes.LQyjbxx[0].qymc));
	$("#gxdwmc").append(setNull(jsonResultMes.LQyjbxx[0].gxdwmc));
	$("#qyzzjgdm").append(setNull(jsonResultMes.LQyjbxx[0].qyzzjgdm));
	$("#lxdh").append(setNull(jsonResultMes.LQyjbxx[0].lxdh));
	$("#yzbm").append(setNull(jsonResultMes.LQyjbxx[0].yzbm));
	$("#chzh").append(setNull(jsonResultMes.LQyjbxx[0].chzh));
	$("#jwdzb").append(setNull(jsonResultMes.LQyjbxx[0].jwdzb));
	$("#jjlxmc").append(setNull(jsonResultMes.LQyjbxx[0].jjlxmc));
	$("#jyfwzy").append(setNull(jsonResultMes.LQyjbxx[0].jyfwzy));
	$("#jyfwjy").append(setNull(jsonResultMes.LQyjbxx[0].jyfwjy));
	$("#zczj").append(setNull(jsonResultMes.LQyjbxx[0].zczj));
	$("#jymj").append(setNull(jsonResultMes.LQyjbxx[0].jymj));
	$("#frdb").append(setNull(jsonResultMes.LQyjbxx[0].frdb));
	$("#frdbzjlb").append(setNull(jsonResultMes.LQyjbxx[0].frdbzjlb));
	$("#frdbzjhm").append(setNull(jsonResultMes.LQyjbxx[0].frdbzjhm));
	$("#frdblxfs").append(setNull(jsonResultMes.LQyjbxx[0].frdblxfs));
	$("#kyrq").append(setNull(jsonResultMes.LQyjbxx[0].kyrq));
	$("#yysj").append(setNull(jsonResultMes.LQyjbxx[0].yysj));
	$("#babh").append(setNull(jsonResultMes.LQyjbxx[0].babh));
	$("#barq").append(setNull(jsonResultMes.LQyjbxx[0].barq));
	$("#jydz").append(setNull(jsonResultMes.LQyjbxx[0].jydz));
	$("#dwfzrzjhm").append(setNull(jsonResultMes.LQyjbxx[0].dwfzrzjhm));
	$("#dwfzr").append(setNull(jsonResultMes.LQyjbxx[0].dwfzr));
	$("#dwfzrlxfs").append(setNull(jsonResultMes.LQyjbxx[0].dwfzrlxfs));
	$("#xfshdw").append(setNull(jsonResultMes.LQyjbxx[0].xfshdw));
	$("#xfhgzh").append(setNull(jsonResultMes.LQyjbxx[0].xfhgzh));
	$("#gdxx").append(setNull(jsonResultMes.LQyjbxx[0].gdxx));
	$("#zdskb").append(setNull(jsonResultMes.LQyjbxx[0].zdskb));
	$("#jqbm").append(setNull(jsonResultMes.LQyjbxx[0].jqbm));
	$("#tyrq").append(setNull(jsonResultMes.LQyjbxx[0].tyrq));
	$("#zjzt").append(setNull(jsonResultMes.LQyjbxx[0].zjztmc));
	$("#bwbmdh").append(setNull(jsonResultMes.LQyjbxx[0].bwbmdh));
	$("#thbajgdm").append(setNull(jsonResultMes.LQyjbxx[0].thbajgdm));
	$("#thbajg").append(setNull(jsonResultMes.LQyjbxx[0].thbajg));
	var sfazsxtStr = "";
	if(setNull(jsonResultMes.LQyjbxx[0].sfazsxt)=='1'){ sfazsxtStr="是"; } else { sfazsxtStr="否"; } 
	$("#sfazsxt").append(sfazsxtStr);
	$("#jyxkFzjgdm").append(setNull(jsonResultMes.LQyjbxx[1].jyxkFzjgdm));
	
	//营业执照、经营许可证
	$("#yyzzZjbh").append(setNull(jsonResultMes.LQyjbxx[1].yyzzZjbh));
	$("#yyzzFzjg").append(setNull(jsonResultMes.LQyjbxx[1].yyzzFzjg));
	$("#yyzzQsrq").append(setNull(jsonResultMes.LQyjbxx[1].yyzzQsrq));
	$("#yyzzJzrq").append(setNull(jsonResultMes.LQyjbxx[1].yyzzJzrq));
	
	$("#jyxkZjbh").append(setNull(jsonResultMes.LQyjbxx[1].jyxkZjbh));
	$("#jyxkFzjg").append(setNull(jsonResultMes.LQyjbxx[1].jyxkFzjg));
	$("#jyxkQsrq").append(setNull(jsonResultMes.LQyjbxx[1].jyxkQsrq));
	$("#jyxkJzrq").append(setNull(jsonResultMes.LQyjbxx[1].jyxkJzrq));
	
	$("#thxkZjbh").append(setNull(jsonResultMes.LQyjbxx[1].thxkZjbh));
	$("#thxkFzjg").append(setNull(jsonResultMes.LQyjbxx[1].thxkFzjg));
	$("#thxkQsrq").append(setNull(jsonResultMes.LQyjbxx[1].thxkQsrq));
	$("#thxkJzrq").append(setNull(jsonResultMes.LQyjbxx[1].thxkJzrq));
	
	$("#swdjZjbh").append(setNull(jsonResultMes.LQyjbxx[1].swdjZjbh));
	$("#swdjFzjg").append(setNull(jsonResultMes.LQyjbxx[1].swdjFzjg));
	$("#swdjQsrq").append(setNull(jsonResultMes.LQyjbxx[1].swdjQsrq));
	$("#swdjJzrq").append(setNull(jsonResultMes.LQyjbxx[1].swdjJzrq));
	
	//人员信息
	$("#zrs").append(setNull(jsonResultMes.LQyjbxx[0].zrs));
	$("#hdrs").append(setNull(jsonResultMes.LQyjbxx[0].hdrs));
	$("#bafzrxm").append(setNull(jsonResultMes.LQyjbxx[0].bafzrxm));
	$("#barysl").append(setNull(jsonResultMes.LQyjbxx[0].barysl));
	$("#bwrysl").append(setNull(jsonResultMes.LQyjbxx[0].bwrysl));
	$("#sxtsl").append(setNull(jsonResultMes.LQyjbxx[0].sxtsl));
	$("#jfsbsl").append(setNull(jsonResultMes.LQyjbxx[0].jfsbsl));
	$("#jgpxrs").append(setNull(jsonResultMes.LQyjbxx[0].jgpxrs));
	$("#bagsyj").append(setNull(jsonResultMes.LQyjbxx[0].bagsyj));
	$("#nsrq").append(setNull(jsonResultMes.LQyjbxx[0].nsrq)); 
	$("#bafzrgmsfhm").append(setNull(jsonResultMes.LQyjbxx[0].bafzrgmsfhm));
	$("#bafzrdh").append(setNull(jsonResultMes.LQyjbxx[0].bafzrdh)); 
	$("#lrr").append(setNull(jsonResultMes.LQyjbxx[0].lrr));
	$("#lrsj").append(setNull(jsonResultMes.LQyjbxx[0].lrsj));
	$("#bz").append(setNull(jsonResultMes.LQyjbxx[0].bz));
}	

</script>
<input type="hidden" id="zabdm"/>
<input type="hidden" id="jjlxbm"/>

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td class="queryfont">企业基本信息</td></tr>
		<tr>
		<td valign="top" class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			<tr height="25">    
				<td class="distd1">企业名称</td>
		        <td class="detailtd2" colspan="3"><span id="qymc"></span></td>
		        <td class="distd1">企业代码</td>
				<td class="detailtd2"><span id="qybm"></span></td>
		    </tr>	
		    <tr height="25">    
		        <td class="distd1">企业地址</td>
		        <td class="detailtd2" colspan="3"><span id="jydz"></span></td>
				<td class="distd1">组织机构代码</td>
		        <td class="detailtd2"><span id="qyzzjgdm"></span></td>
		    </tr>
			<tr height="25">
		        <td class="distd1">经营范围</td>
		        <td class="detailtd2" colspan="3"><span id="jyfwzy"></span></td>
		        <td class="distd1">联系电话</td>
		        <td class="detailtd2"><span id="lxdh"></span></td>
			</tr>
			<tr height="25">
		        <td class="distd1" width="12%">传真</td>
				<td class="detailtd2" width="14%"><span id="chzh"></span></td>
		        <td class="distd1" width="20%">邮政编码</td>
		        <td class="detailtd2" width="20%"><span id="yzbm" ></span></td>
		        <td class="distd1" width="11%">开业日期</td>
		        <td class="detailtd2" width="15%"><span id="kyrq"></span></td>
             </tr>
			<tr height="25">
				<td class="distd1" >经济类型</td>
		        <td class="detailtd2" ><span id="jjlxmc"></span></td>
		        <td class="distd1">占地面积（平米）</td>
		        <td class="detailtd2"><span id="jymj"></span></td>
		        <td class="distd1">注册资本（万元）</td>
		        <td class="detailtd2"><span id="zczj"></span></td>
             </tr>
			<tr height="25">
				<td class="distd1">法定代表人</td>
		        <td class="detailtd2"><span id="frdb"></span></td>
		        <td class="distd1">法人证件类型</td>
		        <td class="detailtd2"><span id="frdbzjlb"></span></td>
		        <td class="distd1">法人证件号码</td>
		        <td class="detailtd2"><span id="frdbzjhm"></span></td>
             </tr>
			<tr height="25">
		        <td class="distd1">法人联系方式</td>
		        <td class="detailtd2"><span id="frdblxfs"></span></td>
				<td class="distd1">特行许可证号</td>
		        <td class="detailtd2"><span id="babh"></span></td>
		        <td class="distd1">特行许可证发证机关</td>
				<td class="detailtd2"><span id="thbajg"></span></td>
			</tr>
			<tr height="25">
				<td class="distd1">营业执照编号</td>
		        <td class="detailtd2"><span id="yyzzZjbh"></span></td>
		        <td class="distd1">营业执照发证机关</td>
		        <td class="detailtd2"><span id="yyzzFzjg"></span></td>
				<td class="distd1">税务登记证编号</td>
		        <td class="detailtd2"><span id="swdjZjbh"></span></td>
             </tr>
			<tr height="25">
		        <td class="distd1">税务登记证发证机关</td>
		        <td class="detailtd2"><span id="swdjFzjg"></span></td>
				<td class="distd1">经营许可证编号</td>
		        <td class="detailtd2"><span id="jyxkZjbh"></span></td>
		        <td class="distd1">经营许可证发证机关</td>
		        <td id="jyxk_fzjgConte" class="detailtd2"><span id="jyxkFzjg"></span></td>
            </tr>
			<tr height="25">
				<td class="distd1">单位负责人</td>
		        <td class="detailtd2"><span id="dwfzr"></span></td>
		        <td class="distd1">单位负责人身份证号</td>
		        <td class="detailtd2"><span id="dwfzrzjhm"></span></td>
		        <td class="distd1">单位负责人联系方式</td>
		        <td class="detailtd2"><span id="dwfzrlxfs"></span></td>
            </tr>
			<tr height="25">
				<td class="distd1">治安负责人</td>
				<td class="detailtd2"><span id="bafzrxm"></span></td>
				<td class="distd1">治安负责人身份证号</td>
				<td class="detailtd2"><span id="bafzrgmsfhm"></span></td>
				<td class="distd1">治安负责人联系方式</td>
				<td class="detailtd2"><span id="bafzrdh"></span></td>
			</tr>
			<tr height="25">
				<td class="distd1">年审日期</td>
				<td class="detailtd2"><span id="nsrq"></span></td>
				<td class="distd1">登记人</td>
				<td class="detailtd2"><span id="lrr"></span></td>
				<td class="distd1">登记时间</td>
				<td class="detailtd2"><span id="lrsj"></span></td>
			<tr height="25">
				<td class="distd1">保安人员数量</td>
				<td class="detailtd2"><span id="barysl"></span></td>
				<td class="distd1">保卫人员数量</td>
				<td class="detailtd2"><span id="bwrysl"></span></td>
				<td class="distd1">摄像头数量</td>
				<td class="detailtd2"><span id="sxtsl"></span></td>
			</tr>
			<tr height="25">
				<td class="distd1">技防设备数量</td>
				<td class="detailtd2"><span id="jfsbsl"></span></td>
				<td class="distd1">&nbsp;</td>
				<td class="detailtd2">&nbsp;</td>
				<td class="distd1">&nbsp;</td>
				<td class="detailtd2">&nbsp;</td>
			</tr>
			<tr height="25">
				<td id="bz_title" class="distd1" valign="top">备注</td>
				<td id="bz_conte" colspan="5" class="detailtd2"><span id="bz"></span></td>
			</tr>
			</table>
		</td>
		</tr>
	</table>	