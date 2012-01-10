<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	$(document).ready(function() {
	});
	
	function qyjbxxXiangxi_updatediv(){
		$("#qyzflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyzflmc));
		$("#qyfflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyfflmc));
		$("#hylb").append(setNull(jsonResultMes.LQyjbxx[0].hylb));
		$("#qybm").append(setNull(jsonResultMes.LQyjbxx[0].qybm));
		$("#qymc").append(setNull(jsonResultMes.LQyjbxx[0].qymc));
		$("#gxdwmc").append(setNull(jsonResultMes.LQyjbxx[0].gxdwmc));
		$("#qyzzjgdm").append(setNull(jsonResultMes.LQyjbxx[0].qyzzjgdm));
		$("#lxdh").append(setNull(jsonResultMes.LQyjbxx[0].lxdh));
		$("#yzbm").append(setNull(jsonResultMes.LQyjbxx[0].yzbm));
		$("#chzh").append(setNull(jsonResultMes.LQyjbxx[0].chzh));
		$("#jjlxmc").append(setNull(jsonResultMes.LQyjbxx[0].jjlxmc));
		$("#jyfwzy").append(setNull(jsonResultMes.LQyjbxx[0].jyfwzy));
		$("#zczj").append(setNull(jsonResultMes.LQyjbxx[0].zczj));
		$("#jymj").append(setNull(jsonResultMes.LQyjbxx[0].jymj));
		$("#frdb").append(setNull(jsonResultMes.LQyjbxx[0].frdb));
		$("#frdbzj").append(setNull(jsonResultMes.LQyjbxx[0].frdbzjlb));
		$("#frdbzjhm").append(setNull(jsonResultMes.LQyjbxx[0].frdbzjhm));
		$("#frdblxfs").append(setNull(jsonResultMes.LQyjbxx[0].frdblxfs));
		$("#kyrq").append(setNull(jsonResultMes.LQyjbxx[0].kyrq));
		$("#barq").append(setNull(jsonResultMes.LQyjbxx[0].barq));
		$("#jydz").append(setNull(jsonResultMes.LQyjbxx[0].jydz));
		$("#dwfzrzjhm").append(setNull(jsonResultMes.LQyjbxx[0].dwfzrzjhm));
		$("#dwfzr").append(setNull(jsonResultMes.LQyjbxx[0].dwfzr));
		$("#dwfzrlxfs").append(setNull(jsonResultMes.LQyjbxx[0].dwfzrlxfs));
		$("#zjzt").append(setNull(jsonResultMes.LQyjbxx[0].zjztmc));
		$("#thbajgdm").append(setNull(jsonResultMes.LQyjbxx[0].thbajgdm));
		$("#thbajg").append(setNull(jsonResultMes.LQyjbxx[0].thbajg));
		var sfazsxtStr = "";
		if(setNull(jsonResultMes.LQyjbxx[0].sfazsxt)=='1'){ sfazsxtStr="是"; } else { sfazsxtStr="否"; } 
		
		//营业执照、经营许可证
		$("#yyzzZjbh").append(setNull(jsonResultMes.LQyjbxx[1].yyzzZjbh));
		$("#yyzzFzjg").append(setNull(jsonResultMes.LQyjbxx[1].yyzzFzjg));
		$("#jyxkZjbh").append(setNull(jsonResultMes.LQyjbxx[1].jyxkZjbh));
		$("#jyxkFzjg").append(setNull(jsonResultMes.LQyjbxx[1].jyxkFzjg));
		$("#thxkZjbh").append(setNull(jsonResultMes.LQyjbxx[1].thxkZjbh));
		$("#thxkFzjg").append(setNull(jsonResultMes.LQyjbxx[1].thxkFzjg));
		$("#swdjZjbh").append(setNull(jsonResultMes.LQyjbxx[1].swdjZjbh));
		$("#swdjFzjg").append(setNull(jsonResultMes.LQyjbxx[1].swdjFzjg));
		
		$("#bafzrxm").append(setNull(jsonResultMes.LQyjbxx[0].bafzrxm));
		$("#bafzrgmsfhm").append(setNull(jsonResultMes.LQyjbxx[0].bafzrgmsfhm));
		$("#bafzrdh").append(setNull(jsonResultMes.LQyjbxx[0].bafzrdh));
		$("#barysl").append(setNull(jsonResultMes.LQyjbxx[0].barysl));
		$("#bwrysl").append(setNull(jsonResultMes.LQyjbxx[0].bwrysl));
		$("#sxtsl").append(setNull(jsonResultMes.LQyjbxx[0].sxtsl));
		$("#jfsbsl").append(setNull(jsonResultMes.LQyjbxx[0].jfsbsl));
		$("#djr").append(setNull(jsonResultMes.LQyjbxx[0].lrr));
		$("#djsj").append(setNull(jsonResultMes.LQyjbxx[0].lrsj));
		$("#bz").append(setNull(jsonResultMes.LQyjbxx[0].bz));
	}
</script>
<BODY>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td class="queryfont">企业基本信息</td></tr>
		<tr>
		<td valign="top" class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			<tr height="25">
			    <td class="distd1">企业名称</td>
		        <td class="detailtd2" colspan="3" width="490px"><span id="qymc"></span></td>
		        <td class="distd1">企业代码</td>
				<td class="detailtd2" width="132px"><span id="qybm"></span></td>
			</tr>
			<tr height="25">
			    <td class="distd1">企业地址</td>
		        <td class="detailtd2" width="490px" colspan="3"><span id="jydz"></span></td>
			    <td class="distd1">组织机构代码</td>
		        <td class="detailtd2" width="132px"><span id="qyzzjgdm"></span></td>
			</tr>
			<tr height="25">
			    <td class="distd1">经营范围</td>
		        <td class="detailtd2" width="490px" colspan="3"><span id="jyfwzy"></span></td>
		        <td class="distd1" >联系电话</td>
		        <td class="detailtd2" width="132px"><span id="lxdh"></span></td>
			</tr>
			<tr height="25">
			    <td class="distd1" width="12%">传真</td>
				<td class="detailtd2" width="14%" ><span width="132px" id="chzh"></span></td>
			    <td class="distd1" width="20%">邮政编码</td>
		        <td class="detailtd2" width="20%"><span width="132px" id="yzbm"></span></td>
		        <td class="distd1" width="11%" >开业日期</td>
		        <td class="detailtd2" width="15%" ><span width="132px" id="kyrq"></span></td>
             </tr>
			<tr height="25">
				<td class="distd1" >经济类型</td>
		        <td class="detailtd2" width="132px"><span id="jjlxmc"></span></td>
			    <td class="distd1">占地面积（平米）</td>
		        <td class="detailtd2" width="132px"><span id="jymj"></span></td>
			    <td class="distd1">注册资金（万元）</td>
		        <td class="detailtd2" width="132px"><span id="zczj"></span></td>
           	</tr>
			<tr height="25">
		        <td class="distd1">法定代表人</td>
		        <td class="detailtd2" width="132px"><span id="frdb"></span></td>
		        <td class="distd1">法人证件类型</td>
		        <td class="detailtd2" width="132px"><span id="frdbzj"></span></td>
				<td class="distd1">法人证件号码</td>
		        <td class="detailtd2" width="132px"><span id="frdbzjhm"></span></td>
            </tr>
			<tr height="25">
		        <td class="distd1">法人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="frdblxfs"></span></td>
		        <td class="distd1">特行备案管理机构</td>
		        <td class="detailtd2" width="132px"><span id="thbajg"></span></td>
		        <td class="distd1">营业执照编号</td>
		        <td class="detailtd2" width="132px"><span id="yyzzZjbh"></span></td>
			</tr>
			<tr height="25">
		        <td class="distd1">营业执照发证机关</td>
		        <td class="detailtd2" width="132px"><span id="yyzzFzjg"></span></td>
		        <td class="distd1">税务登记证编号</td>
		        <td class="detailtd2" width="132px"><span id="swdjZjbh"></span></td>
		        <td class="distd1">税务登记证发证机关</td>
		        <td class="detailtd2" width="132px"><span id="swdjFzjg"></span></td>
			</tr>
			<tr height="25">
		        <td class="distd1">经营许可证编号</td>
		        <td class="detailtd2" width="132px"><span id="jyxkZjbh"></span></td>
		        <td class="distd1">经营许可证发证机关</td>
		        <td class="detailtd2" width="132px"><span id="jyxkFzjg"></span></td>
				<td class="distd1">单位负责人</td>
		        <td class="detailtd2" width="132px"><span id="dwfzr"></span></td>
			</tr>
			<tr height="25">
		        <td class="distd1">单位负责人身份证号</td>
		        <td class="detailtd2" width="132px"><span id="dwfzrzjhm"></span></td>
		        <td class="distd1">单位负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="dwfzrlxfs"></span></td>
		        <td class="distd1">治安负责人</td>
		        <td class="detailtd2" width="132px"><span id="bafzrxm"></span></td>
			</tr>
			<tr height="25">
		        <td class="distd1">治安负责人身份证号</td>
		        <td class="detailtd2" width="132px"><span id="bafzrgmsfhm"></span></td>
		        <td class="distd1">治安负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="bafzrdh"></span></td>
		        <td class="distd1">保安人员数量</td>
		        <td class="detailtd2" width="132px"><span id="barysl"></span></td>
			</tr>
			<tr height="25">
		        <td class="distd1">保卫人员数量</td>
		        <td class="detailtd2" width="132px"><span id="bwrysl"></span></td>
		        <td class="distd1">摄像头数量</td>
		        <td class="detailtd2" width="132px"><span id="sxtsl"></span></td>
		        <td class="distd1">技防设备数量</td>
		        <td class="detailtd2" width="132px"><span id="jfsbsl"></span></td>
            </tr>
			<tr height="25">
		        <td class="distd1">登记人</td>
		        <td class="detailtd2" width="132px"><span id="djr"></span></td>
		        <td class="distd1">登记时间</td>
		        <td class="detailtd2" width="132px" colspan="3"><span id="djsj"></span></td>
		    </tr>
		    <tr>
		        <td class="distd1">备注</td>
			    <td colspan="5" class="detailtd2" width="582px"><span id="bz"></span></td>
		    </tr>
			</table>
		</td>
		</tr>
	</table>	
</BODY>
</HTML>