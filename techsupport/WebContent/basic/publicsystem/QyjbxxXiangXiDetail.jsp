<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../public/common.jsp" %>
<HTML>
<style type="text/css">
	.zhehangtd {border:1px dotted  #d7d7d7;text-align:right;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		qyjbxxXiangxi_updatediv();
	});
	function qyjbxxXiangxi_updatediv(){
		$("#qyzflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyzflmc));
		$("#qyfflmc").append(setNull(jsonResultMes.LQyjbxx[0].qyfflmc));
		$("#zajbmc").append(setNull(jsonResultMes.LQyjbxx[0].zajbmc));
		$("#yyztmc").append(setNull(jsonResultMes.LQyjbxx[0].yyztmc));
		
		$("#hylb").append(setNull(jsonResultMes.LQyjbxx[0].hylb));
		$("#lrsj").append(setNull(jsonResultMes.LQyjbxx[0].lrsj).substr(0,10));
		$("#qybm").append(setNull(jsonResultMes.LQyjbxx[0].qybm));
		$("#qymc").append(setNull(jsonResultMes.LQyjbxx[0].qymc));
		$("#qyjc").append(setNull(jsonResultMes.LQyjbxx[0].qyjc));
		$("#gxdwmc").append(setNull(jsonResultMes.LQyjbxx[0].gxdwmc)+'['+setNull(jsonResultMes.LQyjbxx[0].gxdwbm)+']');
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
		$("#djrq").append(setNull(jsonResultMes.LQyjbxx[0].djrq));
		$("#bwbmdh").append(setNull(jsonResultMes.LQyjbxx[0].bwbmdh));
		$("#thbajgdm").append(setNull(jsonResultMes.LQyjbxx[0].thbajgdm));
		$("#thbajg").append(setNull(jsonResultMes.LQyjbxx[0].thbajg));
		var sfazsxtStr = "";
		if(setNull(jsonResultMes.LQyjbxx[0].sfazsxt)=='1'){ sfazsxtStr="是"; } else { sfazsxtStr="否"; } 
		$("#sfazsxt").append(sfazsxtStr);
		$("#azsxtsl").append(setNull(jsonResultMes.LQyjbxx[0].azsxtsl));
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
		$("#bars").append(setNull(jsonResultMes.LQyjbxx[0].bars));
		$("#jgpxrs").append(setNull(jsonResultMes.LQyjbxx[0].jgpxrs));
		$("#bagsyj").append(setNull(jsonResultMes.LQyjbxx[0].bagsyj));
		$("#bz").append(setNull(jsonResultMes.LQyjbxx[0].bz));
		
		$("#cksl").append(setNull(jsonResultMes.LQyjbxx[0].cksl));
		$("#bxbjsl").append(setNull(jsonResultMes.LQyjbxx[0].bxbjsl));
	}
	
</script>
<BODY>
	<table width="100%"  cellspacing="0" cellpadding="0" class="line" >
	<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			<tr>
		      	<td width="12%" class="distd1">行业类别</td>
		        <td width="14%" class="detailtd2"><span id="hylb"></span></td>
		        <td width="11%" class="distd1">治安管理机构</td>
		        <td class="detailtd2"><span id="gxdwmc"></span></td>
			</tr>
			<tr id="hqZhuFuType">
		        <td class="distd1">场所分类（主）</td>
		        <td class="detailtd2"><span id="qyzflmc"></span></td>
		        <td class="distd1" id="yly_csffl_title" >场所分类（副）</td>
		        <td class="detailtd2" id="yly_csffl_content" ><span id="qyfflmc"></span></td>
			</tr>
		</table>
		<div id="context_jbxx">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="queryfont">&nbsp;场所基本信息</td>
		  </tr>
		  <tr>
		    <td valign="top"  class="tdbg">
		    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
		      <tr id="qyjbxxTr1">
		        <td class="distd1">场所备案编号</td>
		        <td class="detailtd2" width="118px"><span id="qybm"></span></td>
		        <td class="distd1">娱乐场所名称</td>
		        <td class="detailtd2" width="118px"><span id="qymc"></span></td>
		        <td class="distd1">娱乐场所简称</td>
		        <td class="detailtd2" width="118px"><span id="qyjc"></span></td>
		        <td class="distd1">组织机构代码</td>
		        <td class="detailtd2" width="118px"><span id="qyzzjgdm"></span></td>
		      </tr>
		      <tr id="qyjbxxTr2">
		        <td width="11%" class="distd1">联系电话</td>
		        <td class="detailtd2" width="118px"><span id="lxdh"></span></td>
		        <td id="yzbm_title" width="11%" class="distd1">邮政编码</td>
		        <td id="yzbm_conte" width="14%" class="detailtd2" width="118px"><span id="yzbm"></span></td>
		        <td width="11%" class="distd1">传真</td>
		        <td width="14%" class="detailtd2" width="118px"><span id="chzh"></span></td>
		        <td id="jjlx_title" width="11%" class="distd1">经济类型</td>
		        <td id="jjlx_conte" width="14%" class="detailtd2" width="118px"><span id="jjlxmc"></span></td>
		      </tr>
		      <tr id="qyjbxxTr3">
		      	<td class="distd1">注册资金(万元)</td>
		        <td class="detailtd2" width="118px"><span id="zczj"></span></td>
		        <td class="distd1">经营范围(主营)</td>
		        <td class="detailtd2" width="118px"><span id="jyfwzy"></span></td>
		        <td id="jyfwjy_title" class="distd1">经营范围(兼营)</td>
		        <td id="jyfwjy_conte" class="detailtd2" colspan="3" width="380px"><span id="jyfwjy"></span></td>
		      </tr>
		      <tr id="qyjbxxTr4">
		        <td id="jymj_title" class="distd1">经营面积(平米)</td>
		        <td id="jymj_conte" class="detailtd2" width="118px"><span id="jymj"></span></td>
		        <td id="yyzt_title" class="distd1">娱乐服务场所状态</td>
		        <td id="yyzt_conte" class="detailtd2" width="118px"><span id="yyztmc"></span></td>
		        <td id="jydz_title" class="distd1">经营地址</td>
		        <td id="jydz_conte" class="detailtd2" colspan="3" width="380px"><span id="jydz"></span></td>
		      </tr>
		      <tr id="qyjbxxTr5">
		        <td class="distd1">法定代表人姓名</td>
		        <td class="detailtd2" width="118px"><span id="frdb"></span></td>
		        <td class="distd1">法人证件类型</td>
		        <td class="detailtd2" width="118px"><span id="frdbzjlb"></span></td>
		        <td class="distd1">法人证件号码</td>
		        <td class="detailtd2" width="118px"><span id="frdbzjhm"></span></td>
		        <td id="frlxfs_title" class="distd1">法人联系方式</td>
		        <td id="frlxfs_conte" class="detailtd2" width="118px"><span id="frdblxfs"></span></td>
		      </tr>
		      <tr id="qyjbxxTr6">
		        <td class="distd1">开业日期</td>
		        <td class="detailtd2" width="118px"><span id="kyrq"></span></td>
		        <td id="yysj_title" class="distd1">营业时间</td>
		        <td id="yysj_conte" class="detailtd2" width="118px"><span id="yysj"></span></td>
		        <td class="distd1">单位负责人</td>
		        <td class="detailtd2" width="118px"><span id="dwfzr"></span></td>
		        <td class="distd1">单位负责人联系方式</td>
		        <td class="detailtd2" width="118px"><span id="dwfzrlxfs"></span></td>
                </tr>
		      <tr id="qyjbxxTr7">
		        <td class="distd1">单位负责人身份证号</td>
		        <td class="detailtd2" width="118px"><span id="dwfzrzjhm"></span></td>
		        <td id="zadj_title" class="distd1">娱乐服务场所治安级别</td>
		        <td id="zadj_conte" class="detailtd2" width="118px"><span id="zajbmc"></span></td>
		        <td class="distd1">营业执照编号</td>
		        <td class="detailtd2" valign="top" width="118px"><span id="yyzzZjbh"></span></td>
                <td class="distd1">营业执照发证机关</td>
		        <td class="detailtd2" valign="top" width="118px"><span id="yyzzFzjg"></span></td>
                </tr>
		      <tr id="qyjbxxTr8">
		        <td id="yyzzqsrq_title" class="distd1">营业执照起始日期</td>
		        <td id="yyzzqsrq_conte" class="detailtd2" width="118px"><span id="yyzzQsrq"></span></td>
		        <td id="yyzzjzrq_title" class="distd1">营业执照截止日期</td>
		        <td id="yyzzjzrq_conte" class="detailtd2" width="118px"><span id="yyzzJzrq"></span></td>
                <td class="distd1" id="djrq_title" valign="top">营业执照登记日期</td>
		        <td class="detailtd2" id="djrq_content" valign="top" width="118px"><span id="djrq"></span></td> 
		        <td id="jyxk_bh_" class="distd1">娱乐经营许可证号</td>
		        <td id="jyxk_bhConte" class="detailtd2" width="118px"><span id="jyxkZjbh"></span></td>
		      </tr>
		      <tr>
		      	<td id="jyxk_fzjg_" class="distd1">娱乐经营许可证<br>发证机关</td>
		        <td id="jyxk_fzjgConte" class="detailtd2" width="118px"><span id="jyxkFzjg"></span></td>
		        <td id="jyxk_qsrq" class="distd1">娱乐经营许可证<br>起始日期</td>
		        <td id="jyxk_qsrq_conte" class="detailtd2" width="118px"><span id="jyxkQsrq"></span></td>
		        <td id="jyxk_jzrq" class="distd1">娱乐经营许可证<br>截止日期</td>
		        <td id="jyxk_jzrq_conte" class="detailtd2" width="118px"><span id="jyxkJzrq"></span></td>
		        <td class="distd1">&nbsp;</td>
			    <td class="detailtd2" valign="top" width="118px">&nbsp;</td>
		      </tr>
			  <tr>
				<td class="distd1">股东信息</td>
				<td colspan="3" class="detailtd2" width="380px"><span id="gdxx"></span></td>
				<td class="distd1" valign="top">娱乐项目内容</td>
				<td colspan="3" class="detailtd2" width="380px"><span id="bz"></span></td>
			  </tr>
		    </table></td>
		  </tr>
		</table>	
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td id="ryjqt_title" class="queryfont">&nbsp;场地设备及人员情况</td>
		  </tr>
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			      <tr id="ryxxTr1">
			      	<td width="12%" class="distd1">消防合格证号</td>
		        	<td width="14%" class="detailtd2" width="132px"><span id="xfhgzh"></span></td>
		        	<td width="12%" class="distd1">消防审核单位</td>
		        	<td width="13%" class="detailtd2" width="132px"><span id="xfshdw"></span></td>
		        	<td width="11%" class="distd1">经纬度坐标</td>
		        	<td width="13%" class="detailtd2" width="132px"><span id="jwdzb"></span></td>
		        	<td width="12%" class="distd1">核定消费者数量(人)</td>
			        <td width="14%" class="detailtd2" width="132px"><span id="hdrs"></span></td>
				  </tr>
				  <tr>
			        <td class="distd1" id="cksl_title">安全出口数量(个)</td>
			        <td class="detailtd2" id="cksl_content" width="132px"><span id="cksl"></span></td>
			        <td class="distd1" id="bxbjsl_title">包厢包间数量(间)</td>
			        <td class="detailtd2" id="bxbjsl_content" width="132px"><span id="bxbjsl"></span></td>
			        <td class="distd1">总人数(人)</td>
			        <td class="detailtd2" width="132px"><span id="zrs"></span></td>
			        <td class="distd1">治安负责人</td>
			        <td class="detailtd2" width="132px"><span id="bafzrxm"></span></td>
				  </tr>	
			      <tr>
			        <td class="distd1">保安人数(人)</td>
			        <td class="detailtd2" valign="top" width="132px"><span id="bars"></span></td>
			        <td class="distd1">经岗位培训人数(人)</td>
			        <td class="detailtd2" valign="top" width="132px"><span id="jgpxrs"></span></td>
			        <td class="distd1">&nbsp;</td>
			        <td class="detailtd2" valign="top" width="132px">&nbsp;</td>
			        <td class="distd1">&nbsp;</td>
			        <td class="detailtd2" valign="top" width="132px">&nbsp;</td>
			      </tr>
			      <tr>
			        <td class="distd1">保安公司意见</td>
			        <td colspan="7" class="detailtd2"><span id="bagsyj" width="500px"></span></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
		</div>
		<table width="100%" cellspacing="0" cellpadding="0" class="line" >
			<tr><td height="1"></td></tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="bgqyxx" style="DISPLAY: none">
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			      <tr>
			        <td class="distd1">变更原因</td>
			        <td colspan="7" width="870px" class="detailtd2"><span id="bgyy"></span></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
	</tr>
	</table>
</BODY>
</HTML>