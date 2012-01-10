<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	$(document).ready(function() {
	});
	
	function qyjbxxXiangxi_updatediv(){
		$("#qyzflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyzflmc));
		$("#qyfflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyfflmc));
		//$("#zajbmc").append(setNull(jsonResultMes.LQyjbxx[0].zajbmc));
		//$("#yyztmc").append(setNull(jsonResultMes.LQyjbxx[0].yyztmc));
		$("#hylb").append(setNull(jsonResultMes.LQyjbxx[0].hylb));
		$("#qybm").append(setNull(jsonResultMes.LQyjbxx[0].qybm));
		$("#qymc").append(setNull(jsonResultMes.LQyjbxx[0].qymc));
		$("#gxdwmc").append(setNull(jsonResultMes.LQyjbxx[0].gxdwmc));
		$("#qyzzjgdm").append(setNull(jsonResultMes.LQyjbxx[0].qyzzjgdm));
		$("#lxdh").append(setNull(jsonResultMes.LQyjbxx[0].lxdh));
		$("#yzbm").append(setNull(jsonResultMes.LQyjbxx[0].yzbm));
		$("#chzh").append(setNull(jsonResultMes.LQyjbxx[0].chzh));
		//$("#jwdzb").append(setNull(jsonResultMes.LQyjbxx[0].jwdzb));
		$("#jjlxmc").append(setNull(jsonResultMes.LQyjbxx[0].jjlxmc));
		$("#jyfwzy").append(setNull(jsonResultMes.LQyjbxx[0].jyfwzy));
		//$("#jyfwjy").append(setNull(jsonResultMes.LQyjbxx[0].jyfwjy));
		$("#zczj").append(setNull(jsonResultMes.LQyjbxx[0].zczj));
		$("#jymj").append(setNull(jsonResultMes.LQyjbxx[0].jymj));
		$("#frdb").append(setNull(jsonResultMes.LQyjbxx[0].frdb));
		$("#frdbzj").append(setNull(jsonResultMes.LQyjbxx[0].frdbzjlb));
		$("#frdbzjhm").append(setNull(jsonResultMes.LQyjbxx[0].frdbzjhm));
		$("#frdblxfs").append(setNull(jsonResultMes.LQyjbxx[0].frdblxfs));
		$("#kyrq").append(setNull(jsonResultMes.LQyjbxx[0].kyrq));
		//$("#yysj").append(setNull(jsonResultMes.LQyjbxx[0].yysj));
		$("#babh").append(setNull(jsonResultMes.LQyjbxx[0].babh));
		$("#barq").append(setNull(jsonResultMes.LQyjbxx[0].barq));
		$("#jydz").append(setNull(jsonResultMes.LQyjbxx[0].jydz));
		$("#dwfzrzjhm").append(setNull(jsonResultMes.LQyjbxx[0].dwfzrzjhm));
		$("#dwfzr").append(setNull(jsonResultMes.LQyjbxx[0].dwfzr));
		$("#dwfzrlxfs").append(setNull(jsonResultMes.LQyjbxx[0].dwfzrlxfs));
		//$("#xfshdw").append(setNull(jsonResultMes.LQyjbxx[0].xfshdw));
		//$("#xfhgzh").append(setNull(jsonResultMes.LQyjbxx[0].xfhgzh));
		//$("#gdxx").append(setNull(jsonResultMes.LQyjbxx[0].gdxx));
		//$("#zdskb").append(setNull(jsonResultMes.LQyjbxx[0].zdskb));
		//$("#jqbm").append(setNull(jsonResultMes.LQyjbxx[0].jqbm));
		//$("#tyrq").append(setNull(jsonResultMes.LQyjbxx[0].tyrq));
		$("#zjzt").append(setNull(jsonResultMes.LQyjbxx[0].zjztmc));
		//$("#bwbmdh").append(setNull(jsonResultMes.LQyjbxx[0].bwbmdh));
		$("#thbajgdm").append(setNull(jsonResultMes.LQyjbxx[0].thbajgdm));
		$("#thbajg").append(setNull(jsonResultMes.LQyjbxx[0].thbajg));
		var sfazsxtStr = "";
		if(setNull(jsonResultMes.LQyjbxx[0].sfazsxt)=='1'){ sfazsxtStr="是"; } else { sfazsxtStr="否"; } 
		//$("#sfazsxt").append(sfazsxtStr);
		//$("#azsxtsl").append(setNull(jsonResultMes.LQyjbxx[0].azsxtsl));
		//$("#jyxkFzjgdm").append(setNull(jsonResultMes.LQyjbxx[1].jyxkFzjgdm));
		
		//营业执照、经营许可证
		$("#yyzzZjbh").append(setNull(jsonResultMes.LQyjbxx[1].yyzzZjbh));
		$("#yyzzFzjg").append(setNull(jsonResultMes.LQyjbxx[1].yyzzFzjg));
		//$("#yyzzQsrq").append(setNull(jsonResultMes.LQyjbxx[1].yyzzQsrq));
		//$("#yyzzJzrq").append(setNull(jsonResultMes.LQyjbxx[1].yyzzJzrq));
		
		$("#jyxkZjbh").append(setNull(jsonResultMes.LQyjbxx[1].jyxkZjbh));
		$("#jyxkFzjg").append(setNull(jsonResultMes.LQyjbxx[1].jyxkFzjg));
		//$("#jyxkQsrq").append(setNull(jsonResultMes.LQyjbxx[1].jyxkQsrq));
		//$("#jyxkJzrq").append(setNull(jsonResultMes.LQyjbxx[1].jyxkJzrq));
		
		$("#thxkZjbh").append(setNull(jsonResultMes.LQyjbxx[1].thxkZjbh));
		$("#thxkFzjg").append(setNull(jsonResultMes.LQyjbxx[1].thxkFzjg));
		//$("#thxkQsrq").append(setNull(jsonResultMes.LQyjbxx[1].thxkQsrq));
		//$("#thxkJzrq").append(setNull(jsonResultMes.LQyjbxx[1].thxkJzrq));
		
		$("#swdjZjbh").append(setNull(jsonResultMes.LQyjbxx[1].swdjZjbh));
		$("#swdjFzjg").append(setNull(jsonResultMes.LQyjbxx[1].swdjFzjg));
		//$("#swdjQsrq").append(setNull(jsonResultMes.LQyjbxx[1].swdjQsrq));
		//$("#swdjJzrq").append(setNull(jsonResultMes.LQyjbxx[1].swdjJzrq));
		
		//人员信息
		//$("#zrs").append(setNull(jsonResultMes.LQyjbxx[0].zrs));
		//$("#hdrs").append(setNull(jsonResultMes.LQyjbxx[0].hdrs));
		$("#bafzrxm").append(setNull(jsonResultMes.LQyjbxx[0].bafzrxm));
		$("#bafzrgmsfhm").append(setNull(jsonResultMes.LQyjbxx[0].bafzrgmsfhm));
		$("#bafzrdh").append(setNull(jsonResultMes.LQyjbxx[0].bafzrdh));
		$("#barysl").append(setNull(jsonResultMes.LQyjbxx[0].barysl));
		$("#bwrysl").append(setNull(jsonResultMes.LQyjbxx[0].bwrysl));
		$("#sxtsl").append(setNull(jsonResultMes.LQyjbxx[0].sxtsl));
		$("#jfsbsl").append(setNull(jsonResultMes.LQyjbxx[0].jfsbsl));
		$("#djr").append(setNull(jsonResultMes.LQyjbxx[0].lrr));
		$("#djsj").append(setNull(jsonResultMes.LQyjbxx[0].lrsj));
		//$("#jgpxrs").append(setNull(jsonResultMes.LQyjbxx[0].jgpxrs));
		//$("#bagsyj").append(setNull(jsonResultMes.LQyjbxx[0].bagsyj));
		$("#nsrq").append(setNull(jsonResultMes.LQyjbxx[0].nsrq));
		$("#bz").append(setNull(jsonResultMes.LQyjbxx[0].bz));
		
		var sgscxfjjs = setNull(jsonResultMes.LQyjbxx[0].sgscxfjjs);
		if(sgscxfjjs=='1'){
			sgscxfjjs = "是";
		} 
		if(sgscxfjjs=='0'){
			sgscxfjjs = "否";
		}
		$("#sgscxfjjs").append(sgscxfjjs);
		$("#jhltlxmc").append(setNull(jsonResultMes.LQyjbxx[0].jhltlxmc));
	}
</script>
<BODY>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td class="queryfont">企业基本信息</td></tr>
		<tr>
		<td valign="top" class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			<tr>
			    <td class="distd1">经营者名称</td>
		        <td class="detailtd2" width="132px"><span id="qymc"></span></td>
			    <td class="distd1">经营地址</td>
		        <td class="detailtd2" width="132px"><span id="jydz"></span></td>
		        <td class="distd1">企业代码</td>
				<td class="detailtd2" width="132px"><span id="qybm"></span></td>
			</tr>
			<tr height="25">
				<td class="distd1">收购生产性废旧金属</td>
		        <td class="detailtd2"><span id="sgscxfjjs"></span></td>
			    <td class="distd1">旧货流通类型</td>
		        <td class="detailtd2"><span id="jhltlxmc"></span></td>
			    <td class="distd1">组织机构代码</td>
		        <td class="detailtd2" width="132px"><span id="qyzzjgdm"></span></td>
			</tr>
			<tr height="25">
			    <td class="distd1">经营范围</td>
		        <td class="detailtd2" width="490px" colspan="3"><span id="jyfwzy"></span></td>
		        <td class="distd1" >联系电话</td>
		        <td class="detailtd2" ><span id="lxdh" width="132px"></span></td>
			</tr>
			<tr height="25">
			    <td class="distd1" width="12%">传真</td>
				<td class="detailtd2" width="14%"><span id="chzh" width="132px"></span></td>
			    <td class="distd1" width="20%">邮政编码</td>
		        <td class="detailtd2" width="20%" ><span id="yzbm" width="132px"></span></td>
		        <td class="distd1" width="11%">开业日期</td>
		        <td class="detailtd2"  width="15%"><span id="kyrq" width="132px"></span></td>
              </tr>
			  <tr height="25">
				<td class="distd1">经济类型</td>
		        <td class="detailtd2" ><span id="jjlxmc" width="132px"></span></td>
			    <td class="distd1">经营面积（平米）</td>
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
			<!-- 
			<tr>
			    <td class="distd1">经营范围（兼营）</td>
		        <td class="detailtd2" width="380px" colspan="3"><span id="jyfwjy"></span></td>
		        <td class="distd1">营业状态</td>
		        <td class="detailtd2" width="132px"><span id="yyztmc"></span></td>
		        <td class="distd1">营业时间</td>
		        <td class="detailtd2" width="132px"><span id="yysj"></span></td>
				<td class="distd1">备案编号</td>
		        <td class="detailtd2" width="132px"><span id="babh"></span></td>
		        <td class="distd1">备案日期</td>
		        <td class="detailtd2" width="132px"><span id="barq"></span></td>
		        <td class="distd1">营业执照起始日期</td>
		        <td class="detailtd2" width="132px"><span id="yyzzQsrq"></span></td>
		        <td class="distd1">营业执照截止日期</td>
		        <td class="detailtd2" width="132px"><span id="yyzzJzrq"></span></td>
		        <td class="distd1">税务登记证起始日期</td>
		        <td class="detailtd2" width="132px"><span id="swdjQsrq"></span></td>
		        <td class="distd1">税务登记证截止日期</td>
		        <td class="detailtd2" width="132px"><span id="swdjJzrq"></span></td>
		        <td class="distd1">经营许可证起始日期</td>
		        <td class="detailtd2" width="132px"><span id="jyxkQsrq"></span></td>
		        <td class="distd1">经营许可证截止日期</td>
		        <td class="detailtd2" width="132px"><span id="jyxkJzrq"></span></td>
		        <td class="distd1">治安等级</td>
		        <td class="detailtd2" width="132px"><span id="zajbmc"></span></td>
			</tr>
			 <tr>
		        <td class="distd1">特行许可证编号</td>
		        <td class="detailtd2" width="132px"><span id="thxkZjbh"></span></td>
		        <td class="distd1">特行许可证发证机关</td>
		        <td class="detailtd2" width="132px"><span id="thxkFzjg"></span></td>
		        <td class="distd1">特行许可证起始日期</td>
		        <td class="detailtd2" width="132px"><span id="thxkQsrq"></span></td>
		        <td class="distd1">特行许可证截止日期</td>
		        <td class="detailtd2" width="132px"><span id="thxkJzrq"></span></td>
		    </tr>
		    <tr>
		        <td class="distd1">消防合格证号</td>
		        <td class="detailtd2" width="132px"><span id="xfhgzh"></span></td>
		        <td class="distd1">消防审核单位</td>
		        <td class="detailtd2" width="132px"><span id="xfshdw"></span></td>
		        <td class="distd1">经纬度坐标</td>
		        <td class="detailtd2" width="132px"><span id="jwdzb"></span></td>
		        <td class="distd1">机器编码</td>
		        <td class="detailtd2" width="132px"><span id="jqbm"></span></td>
		    </tr>
		    <tr>
				<td class="distd1">股东信息</td>
				<td colspan="7" class="detailtd2" width="582px"><span id="gdxx"></span></td>
			</tr>
			 -->
			<tr height="25">
		        <td class="distd1">法人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="frdblxfs"></span></td>
		        <td class="distd1">再生资源回收备案登记证号</td>
		        <td class="detailtd2" width="132px"><span id="babh"></span></td>
		        <td class="distd1">再生资源回收备案<br>登记发证公安机关</td>
		        <td class="detailtd2" width="132px"><span id="thbajg"></span></td>
              </tr>
			<tr height="25">
		        <td class="distd1">营业执照编号</td>
		        <td class="detailtd2" width="132px"><span id="yyzzZjbh"></span></td>
		        <td class="distd1">营业执照发证机关</td>
		        <td class="detailtd2" width="132px"><span id="yyzzFzjg"></span></td>
		        <td class="distd1">税务登记证编号</td>
		        <td class="detailtd2" width="132px"><span id="swdjZjbh"></span></td>
              </tr>
			<tr height="25">   
		        <td class="distd1">税务登记证发证机关</td>
		        <td class="detailtd2" width="132px"><span id="swdjFzjg"></span></td>
			    <td class="distd1">经营许可证编号</td>
		        <td class="detailtd2" width="132px"><span id="jyxkZjbh"></span></td>
		        <td class="distd1">经营许可证发证机关</td>
		        <td class="detailtd2" width="132px"><span id="jyxkFzjg"></span></td>
              </tr>
			<tr height="25">
				<td class="distd1">经营负责人</td>
		        <td class="detailtd2" width="132px"><span id="dwfzr"></span></td>
		        <td class="distd1">经营负责人身份证号</td>
		        <td class="detailtd2" width="132px"><span id="dwfzrzjhm"></span></td>
		        <td class="distd1">经营负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="dwfzrlxfs"></span></td>
              </tr>
			<tr height="25">
		        <td class="distd1">治安负责人</td>
		        <td class="detailtd2" width="132px"><span id="bafzrxm"></span></td>
		        <td class="distd1">治安负责人身份证号</td>
		        <td class="detailtd2" width="132px"><span id="bafzrgmsfhm"></span></td>
		        <td class="distd1">治安负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="bafzrdh"></span></td>
              </tr>
			<tr height="25">
		        <td class="distd1">年审日期</td>
		        <td class="detailtd2" width="132px"><span id="nsrq"></span></td>
		        <td class="distd1">保安人员数量</td>
		        <td class="detailtd2" width="132px"><span id="barysl"></span></td>
		        <td class="distd1">保卫人员数量</td>
		        <td class="detailtd2" width="132px"><span id="bwrysl"></span></td>
		    </tr>
		    <tr>
               <td class="distd1">摄像头数量</td>
		        <td class="detailtd2" width="132px"><span id="sxtsl"></span></td>
		        <td class="distd1">技防设备数量</td>
		        <td class="detailtd2" width="132px"><span id="jfsbsl"></span></td>
		        <td class="distd1">登记人</td>
		        <td class="detailtd2" width="132px"><span id="djr"></span></td>
		    </tr>
              <tr>
		        <td class="distd1">登记时间</td>
		        <td class="detailtd2"  colspan="5"><span id="djsj"></span></td>
		    </tr>
		    <tr>
		        <td class="distd1">备注</td>
			    <td colspan="5" class="detailtd2" width="582px"><span id="bz"></span></td>
		    </tr>
			</table>
		</td>
		</tr>
	</table>	
	<!-- 
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td class="queryfont">企业基本信息</td></tr>
		<tr>
		<td valign="top" class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
				<tr>
			        <td width="11%" class="distd1">总人数</td>
			        <td width="14%" class="detailtd2" width="132px"><span id="zrs"></span></td>
			        <td width="11%" class="distd1" id="hdrs_title">核定人数</td>
			        <td width="14%" class="detailtd2" width="132px"><span id="hdrs"></span></td>
			        <td width="11%" class="distd1">治安负责人</td>
			        <td width="14%" class="detailtd2" width="132px"><span id="bafzrxm"></span></td>
			        <td width="11%" class="distd1">保安人数</td>
			        <td width="14%" class="detailtd2" width="132px"><span id="bars"></span></td>
				</tr>
				<tr>
			        <td class="distd1">经岗位培训人数</td>
			        <td class="detailtd2" width="132px"><span id="jgpxrs"></span></td>
			        <td class="distd1">保安公司意见</td>
			        <td colspan="5" class="detailtd2" width="4802px"><span id="bagsyj"></span></td>
				</tr>
				<tr>
			        <td class="distd1">备注</td>
			        <td colspan="7" class="detailtd2" width="582px"><span id="bz"></span></td>
			      </tr>
			</table>
		</td></tr>
	</table>
	 -->
</BODY>
</HTML>