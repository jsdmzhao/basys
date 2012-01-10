<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		qyjbxxXiangxi_updatediv();
	});
		function qyjbxxXiangxi_updatediv(){
		$("#yyztmc").append(setNull(jsonResultMes.LQyjbxx[0].yyztmc));
		$("#zajbmc").append(setNull(jsonResultMes.LQyjbxx[0].zajbmc));
		$("#lrsj").append(setNull(jsonResultMes.LQyjbxx[0].lrsj).substr(0,10));
		$("#qybm").append(setNull(jsonResultMes.LQyjbxx[0].qybm));
		$("#qymc").append(setNull(jsonResultMes.LQyjbxx[0].qymc));
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
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="queryfont">&nbsp;基本信息</td>
		  </tr>
		  <tr>
		    <td valign="top"  class="tdbg">
		    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
		      <tr id="qyjbxxTr1">
		        <td class="distd1">场所备案编号</td>
		        <td class="detailtd2"><span id="qybm"></span></td>
		        <td class="distd1">场所名称</td>
		        <td class="detailtd2" colspan="3"><span id="qymc"></span></td>
		        <td class="distd1">企业组织机构代码</td>
		        <td class="detailtd2"><span id="qyzzjgdm"></span></td>
		      </tr>
		      <tr id="qyjbxxTr2">
		        <td width="13%" class="distd1">联系电话</td>
		        <td width="13%" class="detailtd2"><span id="lxdh"></span></td>
		        <td id="yzbm_title" width="11%"class="distd1">邮政编码</td>
		        <td id="yzbm_conte" width="13%" class="detailtd2"><span id="yzbm"></span></td>
		        <td width="11%" class="distd1">传真</td>
		        <td width="11%" class="detailtd2"><span id="chzh"></span></td>
		        <td id="jjlx_title" width="11%" class="distd1">经济类型</td>
		        <td id="jjlx_conte" width="17%" class="detailtd2"><span id="jjlxmc"></span></td>
		      </tr>
		      <tr id="qyjbxxTr3">
		      	<td class="distd1">注册资金（万）</td>
		        <td width="132px" class="detailtd2"><span id="zczj"></span></td>
		        <td class="distd1">经营范围（主营）</td>
		        <td width="132px" class="detailtd2"><span id="jyfwzy"></span></td>
		        <td id="jyfwjy_title" class="distd1">经营范围（兼营）</td>
		        <td id="jyfwjy_conte" width="383px" class="detailtd2" colspan="3"><span id="jyfwjy"></span></td>
		      </tr>
		      <tr id="qyjbxxTr4">
		        <td id="jymj_title" class="distd1">经营面积（㎡）</td>
		        <td id="jymj_conte" width="132px" class="detailtd2"><span id="jymj"></span></td>
		        <td id="yyzt_title" class="distd1">场所状态</td>
		        <td id="yyzt_conte" width="132px" class="detailtd2" ><span id='yyztmc'></span></td>
		        <td id="jydz_title" class="distd1">经营地址</td>
		        <td id="jydz_conte" width="383px" class="detailtd2" colspan="3" ><span id="jydz"></span></td>
		      </tr>
		      <tr id="qyjbxxTr5">
		        <td class="distd1">法定代表人姓名</td>
		        <td width="132px" class="detailtd2"><span id="frdb"></span></td>
		        <td class="distd1">法人证件类型</td>
		        <td width="132px" class="detailtd2"><span id="frdbzjlb"></span></td>
		        <td class="distd1">法人证件号码</td>
		        <td width="132px" class="detailtd2"><span id="frdbzjhm"></span></td>
		        <td id="frlxfs_title" class="distd1">法人联系方式</td>
		        <td id="frlxfs_conte" width="132px" class="detailtd2"><span id="frdblxfs"></span></td>
		      </tr>
		      <tr id="qyjbxxTr6">
		        <td class="distd1">开业日期</td>
		        <td width="132px" class="detailtd2"><span id="kyrq"></span></td>
		        <td id="yysj_title" class="distd1">营业时间</td>
		        <td id="yysj_conte" width="132px" class="detailtd2"><span id="yysj"></span></td>
		        <td id="barq_title" class="distd1">备案日期</td>
		        <td id="barq_conte" width="132px" class="detailtd2"><span id="barq"></span></td>
		        <td class="distd1" id="zjzt_title" >装机状态</td>
		        <td width="132px" class="detailtd2" id="zjzt_content" ><span id="zjzt"></span></td>
		      </tr>
		      <tr id="qyjbxxTr7">
		        <td class="distd1">单位负责人</td>
		        <td width="132px" class="detailtd2"><span id="dwfzr"></span></td>
		        <td class="distd1">负责人公民身份号码</td>
		        <td width="132px" class="detailtd2"><span id="dwfzrzjhm"></span></td>
		        <td class="distd1">负责人联系方式</td>
		        <td width="132px" class="detailtd2"><span id="dwfzrlxfs"></span></td>
		        <td id="zadj_title" class="pagedistd1">服务场所治安级别</td>
		        <td id="zadj_conte" width="132px" class="detailtd2"><span id="zajbmc"></span></td>
		      </tr>
		      <tr id="qyjbxxTr8">
		        <td class="distd1">营业执照号</td>
		        <td width="132px" class="detailtd2"><span id="yyzzZjbh"></span></td>
		        <td class="distd1">营业执照发证机构</td>
		        <td width="132px" class="detailtd2"><span id="yyzzFzjg"></span></td>
		        <td id="yyzzqsrq_title" class="distd1">营业执照起始日期</td>
		        <td id="yyzzqsrq_conte" width="132px" class="detailtd2"><span id="yyzzQsrq"></span></td>
		        <td id="yyzzjzrq_title" class="distd1">营业执照截止日期</td>
		        <td id="yyzzjzrq_conte" width="132px" class="detailtd2"><span id="yyzzJzrq"></span></td>
		      </tr>
		      <tr id="qyjbxxTr9" style='display:none;'>
		        <td id="swdjzbh_title" class="distd1">税务登记证编号</td>
		        <td id="swdjzbh_conte" width="132px" class="detailtd2"><span id="swdjZjbh"></span></td>
		        <td id="swdjfzjg_title" class="zhehangtd"><label id="swdjfzjg_title"></label></td>
		        <td id="swdjfzjg_conte" width="132px" class="detailtd2"><span id="swdjFzjg"></span></td>
		        <td id="swdjqsrq_title" class="distd1">税务登记证起始日期</td>
		        <td id="swdjqsrq_conte" width="132px" class="detailtd2"><span id="swdjQsrq"></span></td>
		        <td id="swdjjzrq_title" class="distd1">税务登记证截止日期</td>
		        <td id="swdjjzrq_conte" width="132px" class="detailtd2"><span id="swdjJzrq"></span></td>
		      </tr>
		      <tr id="qyjbxxTr10">
		        <td id="jyxk_bh_" class="distd1">经营许可证编号</td>
		        <td id="jyxk_bhConte" width="132px" class="detailtd2"><span id="jyxkZjbh"></span></td>
		        <td id="jyxk_fzjg_" class="zhehangtd">经营许可证发证机构</td>
		        <td id="jyxk_fzjgConte" width="132px" class="detailtd2"><span id="jyxkFzjg"></span></td>
		        <td id="jyxk_qsrq" class="distd1">经营许可证起始日期</td>
		        <td id="jyxk_qsrq_conte" width="132px" class="detailtd2"><span id="jyxkQsrq"></span></td>
		        <td id="jyxk_jzrq" class="distd1">经营许可证截止日期</td>
		        <td id="jyxk_jzrq_conte" width="132px" class="detailtd2"><span id="jyxkJzrq"></span></td>
		      </tr>
		      <tr id="thxx_" style='display:none;'>
		        <td id="thxk_bh" class="distd1">特行许可证编号</td>
		        <td width="132px" class="detailtd2"><span id="thxkZjbh"></span></td>
		        <td id="thxk_fzjg" class="distd1">特行许可证发证机关</td>
		        <td width="132px" class="detailtd2"><span id="thxkFzjg"></span></td>
		        <td id="thxk_qsrq" class="distd1">特行许可证起始日期</td>
		        <td width="132px" class="detailtd2"><span id="thxkQsrq"></span></td>
		        <td id="thxk_jzrq" class="distd1">特行许可证截止日期</td>
		        <td width="132px" class="detailtd2"><span id="thxkJzrq"></span></td>
		      </tr>
		      <tr id="xfxx_">
		        <td id="xf_hgzh" class="distd1">消防合格证号</td>
		        <td width="132px" class="detailtd2"><span id="xfhgzh"></span></td>
		        <td id="xf_dw" class="distd1">消防审核单位</td>
		        <td width="132px" class="detailtd2"><span id="xfshdw"></span></td>
		        <td class="distd1">经纬度坐标</td>
		        <td width="132px" class="detailtd2"><span id="jwdzb"></span></td>
		        <td class="distd1">机器编码</td>
		        <td width="132px" class="detailtd2"><span id="jqbm"></span></td>
		      </tr>
		      <tr id="qyjbxxTr13">
				<td class="distd1" id="zdskb_title"  >最低刷卡比</td>
		        <td width="132px" class="detailtd2" id="zdskb_content"  ><span id="zdskb"></span></td>
		        <td class="distd1" id="djrq_title">登记日期</td>
		        <td width="132px" class="detailtd2" id="djrq_content"><span id="djrq"></span></td>
		        <td colspan="4" class="distd1">&nbsp;</td>
			  </tr>
			  <tr id="qyjbxxTr13">
				<td id="gdxx_title" class="distd1">个人股东及投资单位</td>
				<td id="gdxx_conte" colspan="7" width="660px" class="detailtd2"><span id="gdxx"></span></td>
			  </tr>
			  <tr id="qyjbxxTr14"></tr>
			  <tr id="qyjbxxTrLinshi1" style="display:none">
			      <td id="thbajg_title" class="distd1">特行备案机构</td>
			      <td id="thbajg_conte" class="detailtd2" width="132px"><span id="thbajg"></span></td>
			      <td id="jyxkzfzjgdm_title" class="zhehangtd">经营许可证<br>发证机构代码</td>
			      <td id="jyxkzfzjgdm_conte" class="detailtd2" width="132px"><span id="jyxkFzjgdm"></span></td>
		      </tr>
		      <tr id="qyjbxxTrLinshi2" style="display:none">
			      <td id="bwbmdh_title" class="distd1">保卫部门电话</td>
			      <td id="bwbmdh_conte" class="detailtd2" width="132px"><span id="bwbmdh"></span></td>
			      <td id="sfazsxt_title" class="distd1">是否安装摄像头</td>
			      <td id="sfazsxt_conte" class="detailtd2" width="132px"><span id="sfazsxt"></span></td>
			      <td id="azsxtsl_title" class="distd1">摄像头数量</td>
			      <td id="azsxtsl_conte" class="detailtd2" width="132px"><span id="azsxtsl"></span></td>
		      </tr>
		    </table></td>
		  </tr>
		</table>	
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td id="ryjqt_title" class="queryfont">&nbsp;人员及其他信息</td>
		  </tr>
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			      <tr id="ryxxTr1">
			        <td id="zrs_title" width="10%" class="distd1">总人数</td>
			        <td id="zrs_conte" width="132px" width="132px" class="detailtd2"><span id="zrs"></span></td>
			        <td id="hdrs_title" width="11%" class="distd1" id="hdrs_title">核定人数</td>
			        <td id="hdrs_conte" width="132px" width="132px" class="detailtd2"><span id="hdrs"></span></td>
			        <td id="bafzr_title" width="11%" class="distd1"><label id="bafzr_title">治安负责人</label></td>
			        <td id="bafzr_content" width="132px" width="132px" class="detailtd2"><label id="bafzr_content"><span id="bafzrxm"></span></label></td>
			        <td width="11%" class="distd1"><label id="bars_title">保安人数</label></td>
			        <td width="132px" width="132px" class="detailtd2"><label id="bars_content"><span id="bars"></span></label></td>
			      </tr>
			      <tr id="ryxxTr2">
			        <td class="distd1" id="jgpxrs_title">经岗位培训人数</td>
			        <td width="132px" class="detailtd2" id="jgpxrs_content"><span id="jgpxrs"></span></td>
			        <td class="distd1" id="bagsyj_title">保安公司意见</td>
			        <td width="132px" class="detailtd2" id="bagsyj_content"><span id="bagsyj"></span></td>
			        <td class="distd1" id="cksl_title"  >安全出口数量</td>
			        <td width="132px" class="detailtd2" id="cksl_content"  ><span id="cksl"></span></td>
			        <td class="distd1" id="bxbjsl_title"  >包厢包间数量(间)</td>
			        <td width="132px" class="detailtd2" id="bxbjsl_content"  ><span id="bxbjsl"></span></td>
			      </tr>
			      <tr id="ryxxTr3">
			        <td id="bz_title" class="distd1">项目内容</td>
			        <td id="bz_conte" colspan="7" width="870px" class="detailtd2"><span id="bz"></span></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>