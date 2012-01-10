<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<HTML>
<style type="text/css">
	.zhehangtd {border:1px dotted  #d7d7d7;text-align:right;}
</style>
<script type="text/javascript">
	var selHylb = "";
	var detailBalanceUrl="publicsystem/queryLsBalance_qyjbxx.action";
	var detailLsUrl="publicsystem/queryLs_qyjbxx.action";
	$(document).ready(function(){
		selHylb = "";
		$("#p_qylsid").attr("value",dataid);
		bgqkbalance_setDetail();
	});
	function bgqkbalance_setDetail(){ //对比信息 并存放起来 待对比
		setParams("p_");
		jQuery.post(detailBalanceUrl,params,bgqkbalance_updatediv,"json");
	}
	function bgqk_setDetail(){ //当前历史信息
		setParams("p_");
		jQuery.post(detailLsUrl,params,bgqk_updatediv,"json");
	}
	
	function bgqkbalance_updatediv(json){ //对比信息 存放起来 待对比
		addtotempList("qyzflmc_",setNull(json.LQyjbxx[0].qyzflmc));
		addtotempList("qyfflmc_",setNull(json.LQyjbxx[0].qyfflmc));
		addtotempList("zajbmc_",setNull(json.LQyjbxx[0].zajbmc));
		addtotempList("yyztmc_",setNull(json.LQyjbxx[0].yyztmc));
		addtotempList("hylb_",setNull(json.LQyjbxx[0].hylb));
		addtotempList("qybm_",setNull(json.LQyjbxx[0].qybm));
		addtotempList("qymc_",setNull(json.LQyjbxx[0].qymc));
		addtotempList("gxdwmc_",setNull(json.LQyjbxx[0].gxdwmc));
		addtotempList("qyzzjgdm_",setNull(json.LQyjbxx[0].qyzzjgdm));
		addtotempList("lxdh_",setNull(json.LQyjbxx[0].lxdh));
		addtotempList("yzbm_",setNull(json.LQyjbxx[0].yzbm));
		addtotempList("chzh_",setNull(json.LQyjbxx[0].chzh));
		addtotempList("jwdzb_",setNull(json.LQyjbxx[0].jwdzb));
		addtotempList("jjlxmc_",setNull(json.LQyjbxx[0].jjlxmc));
		addtotempList("jyfwzy_",setNull(json.LQyjbxx[0].jyfwzy));
		addtotempList("jyfwjy_",setNull(json.LQyjbxx[0].jyfwjy));
		addtotempList("zczj_",setNull(json.LQyjbxx[0].zczj));
		addtotempList("jymj_",setNull(json.LQyjbxx[0].jymj));
		addtotempList("frdb_",setNull(json.LQyjbxx[0].frdb));
		addtotempList("frdbzjlb_",setNull(json.LQyjbxx[0].frdbzjlb));
		addtotempList("frdbzjhm_",setNull(json.LQyjbxx[0].frdbzjhm));
		addtotempList("frdblxfs_",setNull(json.LQyjbxx[0].frdblxfs));
		addtotempList("kyrq_",setNull(json.LQyjbxx[0].kyrq));
		addtotempList("yysj_",setNull(json.LQyjbxx[0].yysj));
		addtotempList("babh_",setNull(json.LQyjbxx[0].babh));
		addtotempList("barq_",setNull(json.LQyjbxx[0].barq));
		addtotempList("jydz_",setNull(json.LQyjbxx[0].jydz));
		addtotempList("dwfzrzjhm_",setNull(json.LQyjbxx[0].dwfzrzjhm));
		addtotempList("dwfzr_",setNull(json.LQyjbxx[0].dwfzr));
		addtotempList("dwfzrlxfs_",setNull(json.LQyjbxx[0].dwfzrlxfs));
		addtotempList("xfshdw_",setNull(json.LQyjbxx[0].xfshdw));
		addtotempList("xfhgzh_",setNull(json.LQyjbxx[0].xfhgzh));
		addtotempList("gdxx_",setNull(json.LQyjbxx[0].gdxx));
		addtotempList("zdskb_",setNull(json.LQyjbxx[0].zdskb));
		addtotempList("jqbm_",setNull(json.LQyjbxx[0].jqbm));
		addtotempList("tyrq_",setNull(json.LQyjbxx[0].tyrq));
		
		addtotempList("bwbmdh_",setNull(json.LQyjbxx[0].bwbmdh));
		addtotempList("thbajg_",setNull(json.LQyjbxx[0].thbajg));
		var sfazsxtStr = "";
		if(setNull(json.LQyjbxx[0].sfazsxt)=='1'){ sfazsxtStr="是"; } else { sfazsxtStr="否"; } 
		addtotempList("sfazsxt_",setNull(sfazsxtStr));
		addtotempList("azsxtsl_",setNull(json.LQyjbxx[0].thbajg));
		addtotempList("jyxkFzjgdm_",setNull(json.LQyjbxx[0].thbajg));
		
		//营业执照、经营许可证
		addtotempList("yyzzZjbh_",setNull(json.LQyjbxx[1].yyzzZjbh));
		addtotempList("yyzzFzjg_",setNull(json.LQyjbxx[1].yyzzFzjg));
		addtotempList("yyzzQsrq_",setNull(json.LQyjbxx[1].yyzzQsrq));
		addtotempList("yyzzJzrq_",setNull(json.LQyjbxx[1].yyzzJzrq));
		
		addtotempList("jyxkZjbh_",setNull(json.LQyjbxx[1].jyxkZjbh));
		addtotempList("jyxkFzjg_",setNull(json.LQyjbxx[1].jyxkFzjg));
		addtotempList("jyxkQsrq_",setNull(json.LQyjbxx[1].jyxkQsrq));
		addtotempList("jyxkJzrq_",setNull(json.LQyjbxx[1].jyxkJzrq));
		
		addtotempList("thxkZjbh_",setNull(json.LQyjbxx[1].thxkZjbh));
		addtotempList("thxkFzjg_",setNull(json.LQyjbxx[1].thxkFzjg));
		addtotempList("thxkQsrq_",setNull(json.LQyjbxx[1].thxkQsrq));
		addtotempList("thxkJzrq_",setNull(json.LQyjbxx[1].thxkJzrq));
		
		addtotempList("swdjZjbh_",setNull(json.LQyjbxx[1].swdjZjbh));
		addtotempList("swdjFzjg_",setNull(json.LQyjbxx[1].swdjFzjg));
		addtotempList("swdjQsrq_",setNull(json.LQyjbxx[1].swdjQsrq));
		addtotempList("swdjJzrq_",setNull(json.LQyjbxx[1].swdjJzrq));
		
		//人员信息
		addtotempList("zrs_",setNull(json.LQyjbxx[0].zrs));
		addtotempList("hdrs_",setNull(json.LQyjbxx[0].hdrs));
		addtotempList("bafzrxm_",setNull(json.LQyjbxx[0].bafzrxm));
		addtotempList("bars_",setNull(json.LQyjbxx[0].bars));
		addtotempList("jgpxrs_",setNull(json.LQyjbxx[0].jgpxrs));
		addtotempList("cksl_",setNull(json.LQyjbxx[0].cksl));
		addtotempList("bxbjsl_",setNull(json.LQyjbxx[0].bxbjsl));
		addtotempList("bagsyj_",setNull(json.LQyjbxx[0].bagsyj));
		addtotempList("bz_",setNull(json.LQyjbxx[0].bz));
		bgqk_setDetail();
	}
	
	function bgqk_updatediv(json){ //当前历史记录
		selHylb = setNull(json.LQyjbxx[0].hylbdm);
		hyInit();
		$("#f_jjlxbm").attr("value",setNull(json.LQyjbxx[0].jjlxbm));
		if(selHylb=="J"&&setNull(json.LQyjbxx[0].yyztdm)=="12"){ //娱乐业专属
			showOrHideYlQitaxxbq('tyrq_','block');
		}
		changeAndWriteRedFont("qyzflmc_",setNull(json.LQyjbxx[0].qyzflmc));
		changeAndWriteRedFont("qyfflmc_",setNull(json.LQyjbxx[0].qyfflmc));
		changeAndWriteRedFont("zajbmc_",setNull(json.LQyjbxx[0].zajbmc));
		changeAndWriteRedFont("yyztmc_",setNull(json.LQyjbxx[0].yyztmc));
		
		changeAndWriteRedFont("hylb_",setNull(json.LQyjbxx[0].hylb));
		changeAndWriteRedFont("qybm_",setNull(json.LQyjbxx[0].qybm));
		changeAndWriteRedFont("qymc_",setNull(json.LQyjbxx[0].qymc));
		changeAndWriteRedFont("gxdwmc_",setNull(json.LQyjbxx[0].gxdwmc));
		changeAndWriteRedFont("qyzzjgdm_",setNull(json.LQyjbxx[0].qyzzjgdm));
		changeAndWriteRedFont("lxdh_",setNull(json.LQyjbxx[0].lxdh));
		changeAndWriteRedFont("yzbm_",setNull(json.LQyjbxx[0].yzbm));
		changeAndWriteRedFont("chzh_",setNull(json.LQyjbxx[0].chzh));
		changeAndWriteRedFont("jwdzb_",setNull(json.LQyjbxx[0].jwdzb));
		changeAndWriteRedFont("jjlxmc_",setNull(json.LQyjbxx[0].jjlxmc));
		changeAndWriteRedFont("jyfwzy_",setNull(json.LQyjbxx[0].jyfwzy));
		changeAndWriteRedFont("jyfwjy_",setNull(json.LQyjbxx[0].jyfwjy));
		changeAndWriteRedFont("zczj_",setNull(json.LQyjbxx[0].zczj));
		changeAndWriteRedFont("jymj_",setNull(json.LQyjbxx[0].jymj));
		changeAndWriteRedFont("frdb_",setNull(json.LQyjbxx[0].frdb));
		changeAndWriteRedFont("frdbzjlb_",setNull(json.LQyjbxx[0].frdbzjlb));
		changeAndWriteRedFont("frdbzjhm_",setNull(json.LQyjbxx[0].frdbzjhm));
		changeAndWriteRedFont("frdblxfs_",setNull(json.LQyjbxx[0].frdblxfs));
		changeAndWriteRedFont("kyrq_",setNull(json.LQyjbxx[0].kyrq));
		changeAndWriteRedFont("yysj_",setNull(json.LQyjbxx[0].yysj));
		changeAndWriteRedFont("babh_",setNull(json.LQyjbxx[0].babh));
		changeAndWriteRedFont("barq_",setNull(json.LQyjbxx[0].barq));
		changeAndWriteRedFont("jydz_",setNull(json.LQyjbxx[0].jydz));
		changeAndWriteRedFont("dwfzrzjhm_",setNull(json.LQyjbxx[0].dwfzrzjhm));
		changeAndWriteRedFont("dwfzr_",setNull(json.LQyjbxx[0].dwfzr));
		changeAndWriteRedFont("dwfzrlxfs_",setNull(json.LQyjbxx[0].dwfzrlxfs));
		changeAndWriteRedFont("xfshdw_",setNull(json.LQyjbxx[0].xfshdw));
		changeAndWriteRedFont("xfhgzh_",setNull(json.LQyjbxx[0].xfhgzh));
		changeAndWriteRedFont("gdxx_",setNull(json.LQyjbxx[0].gdxx));
		changeAndWriteRedFont("zdskb_",setNull(json.LQyjbxx[0].zdskb));
		changeAndWriteRedFont("jqbm_",setNull(json.LQyjbxx[0].jqbm));
		changeAndWriteRedFont("tyrq_",setNull(json.LQyjbxx[0].tyrq));
		changeAndWriteRedFont("bwbmdh_",setNull(json.LQyjbxx[0].bwbmdh));
		changeAndWriteRedFont("thbajg_",setNull(json.LQyjbxx[0].thbajg));
		var sfazsxtStr = "";
		if(setNull(json.LQyjbxx[0].sfazsxt)=='1'){ sfazsxtStr="是"; } else { sfazsxtStr="否"; } 
		changeAndWriteRedFont("sfazsxt_",setNull(sfazsxtStr));
		changeAndWriteRedFont("azsxtsl_",setNull(json.LQyjbxx[0].thbajg));
		changeAndWriteRedFont("jyxkFzjgdm_",setNull(json.LQyjbxx[0].thbajg));
		
		
		$("#bgyy_").append(setNull(json.LQyjbxx[0].bgyy));
		
		//营业执照、经营许可证
		changeAndWriteRedFont("yyzzZjbh_",setNull(json.LQyjbxx[1].yyzzZjbh));
		changeAndWriteRedFont("yyzzFzjg_",setNull(json.LQyjbxx[1].yyzzFzjg));
		changeAndWriteRedFont("yyzzQsrq_",setNull(json.LQyjbxx[1].yyzzQsrq));
		changeAndWriteRedFont("yyzzJzrq_",setNull(json.LQyjbxx[1].yyzzJzrq));
		
		changeAndWriteRedFont("jyxkZjbh_",setNull(json.LQyjbxx[1].jyxkZjbh));
		changeAndWriteRedFont("jyxkFzjg_",setNull(json.LQyjbxx[1].jyxkFzjg));
		changeAndWriteRedFont("jyxkQsrq_",setNull(json.LQyjbxx[1].jyxkQsrq));
		changeAndWriteRedFont("jyxkJzrq_",setNull(json.LQyjbxx[1].jyxkJzrq));
		
		changeAndWriteRedFont("thxkZjbh_",setNull(json.LQyjbxx[1].thxkZjbh));
		changeAndWriteRedFont("thxkFzjg_",setNull(json.LQyjbxx[1].thxkFzjg));
		changeAndWriteRedFont("thxkQsrq_",setNull(json.LQyjbxx[1].thxkQsrq));
		changeAndWriteRedFont("thxkJzrq_",setNull(json.LQyjbxx[1].thxkJzrq));
		
		changeAndWriteRedFont("swdjZjbh_",setNull(json.LQyjbxx[1].swdjZjbh));
		changeAndWriteRedFont("swdjFzjg_",setNull(json.LQyjbxx[1].swdjFzjg));
		changeAndWriteRedFont("swdjQsrq_",setNull(json.LQyjbxx[1].swdjQsrq));
		changeAndWriteRedFont("swdjJzrq_",setNull(json.LQyjbxx[1].swdjJzrq));
		
		//人员信息
		changeAndWriteRedFont("zrs_",setNull(json.LQyjbxx[0].zrs));
		changeAndWriteRedFont("hdrs_",setNull(json.LQyjbxx[0].hdrs));
		changeAndWriteRedFont("bafzrxm_",setNull(json.LQyjbxx[0].bafzrxm));
		changeAndWriteRedFont("bars_",setNull(json.LQyjbxx[0].bars));
		changeAndWriteRedFont("jgpxrs_",setNull(json.LQyjbxx[0].jgpxrs));
		changeAndWriteRedFont("cksl_",setNull(json.LQyjbxx[0].cksl));
		changeAndWriteRedFont("bxbjsl_",setNull(json.LQyjbxx[0].bxbjsl));
		changeAndWriteRedFont("bagsyj_",setNull(json.LQyjbxx[0].bagsyj));
		changeAndWriteRedFont("bz_",setNull(json.LQyjbxx[0].bz));
	}
	function hyInit(){ //行业初始化
		showOrHideYlQitaxxbqTr('thxx_','none'); //特行信息
		showOrHideYlQitaxxbqTr('xfxx_','none'); //消防信息
		showOrHideYlQitaxxbqLabel('bafzr_','none'); //保安负责人
		showOrHideYlQitaxxbqLabel('bars_','none'); //保安人数
		showOrHideYlQitaxxbq('jgpxrs_','none'); //经岗位培训人数
		showOrHideYlQitaxxbq('bagsyj_','none'); //保安公司已经
		if(selHylb=='J'){
			ylyInit();
		} else if(selHylb=='C') {
			jxyInit();
		} else if(selHylb=='E01') { //二手车
			ershoucInit();
		} else if(selHylb=='E02') { //二手机
			ershoushoujiInit();
		} else if(selHylb=='E04') { //废旧金属
			fjjsInit();
		} else if(selHylb=='F01') { //出租车
			czcInit();
		} else if(selHylb=='F02') { //汽车租赁
			qczlInit();
		}
		$("#bq_hylb").setAttr("readonly","true"); //除了添加都需锁定行业类别
	}
	function ylyInit(){ //娱乐业初始
		changeLableTitle('qybianOrDaima_','编码');
		changeLableTitle('zczj_','注册资金（万）');
		changeLableTitle('jyfw_','经营范围（主营）');
		changeLableTitle('jymj_','经营面积（㎡）');
		changeLableTitle('jydz_','经营地址');
		changeLableTitle('babh_','备案编号');
		changeLableTitle('jyxkzbh_','经营许可证编号');
		changeLableTitle('jyxkzfzjg_','经营许可证发证机关');
		changeLableTitle('gxdw_title','管辖单位');
		changeLableTitle('fzrgmsfhm_title','负责人公民身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		showOrHideYlQitaxxbq('small_yl_qt','block');
		showOrHideYlQitaxxbq('yly_csffl_','block');
		showOrHideYlQitaxxbq('zdskb_','block');
		showOrHideYlQitaxxbq('cksl_','block');
		showOrHideYlQitaxxbq('bxbjsl_','block');
		//$("#qyjbxxXiangxi").height(440);
		$("#hdrs_title").html("核定消费者数量");
		$("#bz_title").html("娱乐项目内容");
	}
	function jxyInit(){ //机修业初始
		changeLableTitle('qybianOrDaima_','代码');
		changeLableTitle('zczj_','注册资本（万元）');
		changeLableTitle('jyfw_','经营范围');
		changeLableTitle('jymj_','占地面积（㎡）');
		changeLableTitle('jydz_','企业地址');
		changeLableTitle('babh_','特行备案编号');
		changeLableTitle('jyxkzbh_','经营许可证号');
		changeLableTitle('jyxkzfzjg_','经营许可证<br>发证机构名称');
		changeLableTitle('gxdw_title','治安管理机构');
		changeLableTitle('fzrgmsfhm_title','负责人公民身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		showOrHideYlQitaxxbqTr('qyjbxxTr13','none');
		//$("#qyjbxxXiangxi").height(340);
		jxyChange();
	}
	function ershoucInit(){ //二手车
		changeLableTitle('qybianOrDaima_','代码');
		changeLableTitle('zczj_','注册资本（万元）');
		changeLableTitle('jyfw_','经营范围');
		changeLableTitle('jymj_','占地面积（㎡）');
		changeLableTitle('jydz_','企业地址');
		changeLableTitle('babh_','特行备案编号');
		changeLableTitle('jyxkzbh_','行业许可证号');
		changeLableTitle('jyxkzfzjg_','行业许可证<br>发证机构名称');
		changeLableTitle('gxdw_title','治安管辖机构');
		changeLableTitle('fzrgmsfhm_title','单位负责人身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		showOrHideYlQitaxxbqTr('qyjbxxTr13','none');
		//$("#qyjbxxXiangxi").height(340);
		esjAndEscChange();
		$("#hdrs_title").html("核定人数");
		$("#bz_title").html("备注");
	}
	function ershoushoujiInit(){ //二手机
		changeLableTitle('qybianOrDaima_','代码');
		changeLableTitle('zczj_','注册资本（万元）');
		changeLableTitle('jyfw_','经营范围');
		changeLableTitle('jymj_','占地面积（㎡）');
		changeLableTitle('jydz_','企业地址');
		changeLableTitle('babh_','特行备案编号');
		changeLableTitle('jyxkzbh_','行业许可证号');
		changeLableTitle('jyxkzfzjg_','行业许可证<br>发证机构名称');
		changeLableTitle('gxdw_title','治安管辖机构');
		changeLableTitle('fzrgmsfhm_title','负责人公民身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		showOrHideYlQitaxxbqTr('qyjbxxTr13','none');
		//$("#qyjbxxXiangxi").height(340);
		esjAndEscChange();
		$("#hdrs_title").html("核定人数");
		$("#bz_title").html("备注");
	}
	function fjjsInit(){ //废旧金属
		changeLableTitle('qybianOrDaima_','编码');
		changeLableTitle('zczj_','注册资金（万）');
		changeLableTitle('jyfw_','经营范围（主营）');
		changeLableTitle('jymj_','经营面积（㎡）');
		changeLableTitle('jydz_','经营地址');
		changeLableTitle('babh_','备案编号');
		changeLableTitle('jyxkzbh_','经营许可证编号');
		changeLableTitle('jyxkzfzjg_','经营许可证发证机关');
		changeLableTitle('gxdw_title','管辖单位');
		changeLableTitle('fzrgmsfhm_title','负责人公民身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		showOrHideYlQitaxxbqTr('thxx_','block'); //特行信息
		showOrHideYlQitaxxbqTr('xfxx_','block'); //消防信息
		showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		showOrHideYlQitaxxbqLabel('bars_','block'); //保安人数
		showOrHideYlQitaxxbq('jgpxrs_','block'); //经岗位培训人数
		showOrHideYlQitaxxbq('bagsyj_','block'); //保安公司已经
		//$("#qyjbxxXiangxi").height(490);
		$("#hdrs_title").html("核定人数");
		$("#bz_title").html("备注");
	}
	function czcInit(){ //出租车
		changeLableTitle('qybianOrDaima_','代码');
		changeLableTitle('zczj_','注册资本（万元）');
		changeLableTitle('jyfw_','经营范围');
		changeLableTitle('jymj_','占地面积（㎡）');
		changeLableTitle('jydz_','企业地址');
		changeLableTitle('babh_','特行备案编号');
		changeLableTitle('jyxkzbh_','经营许可证号');
		changeLableTitle('jyxkzfzjg_','经营许可证<br>发证机构名称');
		changeLableTitle('gxdw_title','治安管辖机构');
		changeLableTitle('fzrgmsfhm_title','负责人公民身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证<br>发证机构名称');
		showOrHideYlQitaxxbqTr('qyjbxxTr13','none');
		//$("#qyjbxxXiangxi").height(340);
		qcczAndQczlChange();
		$("#hdrs_title").html("核定人数");
		$("#bz_title").html("备注");
	}
	function qczlInit(){ //汽车租赁
		changeLableTitle('qybianOrDaima_','代码');
		changeLableTitle('zczj_','注册资本（万元）');
		changeLableTitle('jyfw_','经营范围');
		changeLableTitle('jymj_','占地面积（㎡）');
		changeLableTitle('jydz_','企业地址');
		changeLableTitle('babh_','特行备案编号');
		changeLableTitle('jyxkzbh_','经营许可证号');
		changeLableTitle('jyxkzfzjg_','经营许可证<br>发证机构名称');
		changeLableTitle('gxdw_title','治安管辖机构');
		changeLableTitle('fzrgmsfhm_title','负责人公民身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		showOrHideYlQitaxxbqTr('qyjbxxTr13','none');
		//$("#qyjbxxXiangxi").height(340);
		qcczAndQczlChange();
		$("#hdrs_title").html("核定人数");
		$("#bz_title").html("备注");
	}
	
	function showOrHideYlQitaxxbq(smallId,state){ //显示隐藏 TD
		$("td[id^='"+smallId+"']").each(function(){
			$(this)[0].style.display=''+state;
		});
	}
	function showOrHideYlQitaxxbqTr(smallId,state){ //显示隐藏 TR
		$("tr[id^='"+smallId+"']").each(function(){
			$(this)[0].style.display=''+state;
		});
	}
	function showOrHideYlQitaxxbqLabel(smallId,state){ //显示隐藏 LABEL
		$("label[id^='"+smallId+"']").each(function(){
			$(this)[0].style.display=''+state;
		});
	}
	function changeLableTitle(smallId,content){ //设置lable内容 
		$("label[id^='"+smallId+"']").each(function(){
			$(this).html(content);
		});
	}
	function setTrAppendTd(trid,smallId){ //移动td到制定的tr后面
		$("td[id^='"+smallId+"']").each(function(){
			$(this).appendTo($("#"+trid));
		});
	}
	function setRemoveObj(removeid){ //加制定的TD隐藏
		$("td[id^='"+removeid+"']").each(function(){
			$(this).hide();
		});
	}
	function addtotempList(key,value){
		var objOption = "<option value='"+key+"'>"+value+"</option>";
		$("#bdqylsxx").append($(objOption));
	}
	function getValueByKey(key){
		var result = "";
		$("#bdqylsxx option").each(function(){
			if($(this).attr("value")==key){
				result =  $(this).text();
				return false;
			}
		});
		return result;
	}
	function changeAndWriteRedFont(key,value){ //不同时 红色字体
		$("#"+key).append(value); //赋值
		var values = getValueByKey(key); //获取对比值
		if(values!=value){
			$("td[id^='"+key+"']").each(function(){
				$(this).addClass("red");
			});
			$("span[id^='"+key+"']").each(function(){
				$(this).addClass("red");
			});
			if(key=="tyrq_"){
				showOrHideYlQitaxxbq('tyrq_','block');
			}
		}
	}
	function jxyChange(){ //机修业变化
		setRemoveObj('jyfwjy_');
		setRemoveObj('yyztmc_');
		setRemoveObj('yysj_');
		setRemoveObj('barq_');
		setRemoveObj('zajbmc_');
		setRemoveObj('yyzzQsrq_');
		setRemoveObj('yyzzJzrq_');
		setRemoveObj('swdjQsrq_');
		setRemoveObj('swdjJzrq_');
		setRemoveObj('gdxx_');
		setRemoveObj('ryjqt_');
		setRemoveObj('zrs_');
		setRemoveObj('hdrs_');
		setRemoveObj('frdblxfs_');
		setRemoveObj('jyxkQsrq_');
		setRemoveObj('jyxkJzrq_');
		setTrAppendTd('qyjbxxTr3','jydz_');
		setTrAppendTd('qyjbxxTr8','swdjZjbh_');
		setTrAppendTd('qyjbxxTr8','swdjFzjg_');
		setTrAppendTd('qyjbxxTr14','bz_');
		setTrAppendTd('qyjbxxTr6','thbajg_');
		setTrAppendTd('qyjbxxTr5','bafzrxm_');
		setTrAppendTd('qyjbxxTr6','jyxkZjbh_');
		setTrAppendTd('qyjbxxTr7','jyxkFzjg_');
		showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		setTrAppendTd('qyjbxxTr4','bwbmdh_');
	}
	function esjAndEscChange(){ //二手机和二手机的变化
		qcczAndQczlChange();
		setTrAppendTd('qyjbxxTr4','sfazsxt_');
		setTrAppendTd('qyjbxxTr4','azsxtsl_');
	}
	function qcczAndQczlChange(){ //汽车出租和企业租赁变化
		setRemoveObj('jyxkQsrq_');
		setRemoveObj('jyxkJzrq_');
		setRemoveObj('jyfwjy_');
		setRemoveObj('yyztmc_');
		setRemoveObj('yysj_');
		setRemoveObj('barq_');
		setRemoveObj('zajbmc_');
		setRemoveObj('yyzzQsrq_');
		setRemoveObj('yyzzJzrq_');
		setRemoveObj('swdjQsrq_');
		setRemoveObj('swdjJzrq_');
		setRemoveObj('gdxx_');
		setRemoveObj('ryjqt_');
		setRemoveObj('zrs_');
		setRemoveObj('hdrs_');
		setTrAppendTd('qyjbxxTr3','jydz_');
		setTrAppendTd('qyjbxxTr8','swdjZjbh_');
		setTrAppendTd('qyjbxxTr8','swdjFzjg_');
		setTrAppendTd('qyjbxxTr14','bz_');
		setTrAppendTd('qyjbxxTr6','thbajg_');
		setTrAppendTd('qyjbxxTr7','bafzrxm_');
		showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		if(selHylb=="F01"||selHylb=="F02"){ //汽车出租、租赁
			setTrAppendTd('qyjbxxTr10','jyxkzfzjgdm_');
			setTrAppendTd('qyjbxxTr10','jymj_');
			setTrAppendTd('qyjbxxTr6','bwbmdh_');
		} else {
			setTrAppendTd('qyjbxxTr4','bwbmdh_');
		}
	}
</script>
<BODY>
<!-- 页面的页签及加载状态 新加业-->
<select id="yqAndZt" style="DISPLAY:none">
<option value='qyxx'>0</option>
<option value='yl_qt'>0</option>
<option value='yl_qtxx'>0</option>
</select>
<input type="hidden" id="p_qylsid">
<select id="bdqylsxx" style="DISPLAY:none"></select>

<input type="hidden" id="f_jjlxbm">
<div id="qyxxClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">企业信息详细</td>
      <td align="right" class="title1"><a href="#" onclick="$('#qyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
<!-- 企业信息开始 -->
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0" height="520" id="qyxx" style="DISPLAY: block">
<tr>
<td valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		<tr>
	    <td width="100%" valign="top" >
	    	<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
	      	<tr>
        		<td width="25" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
            		</table>
            	</td>
       			<td width="78" valign="bottom">
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav11">
            		<tr><td><a href="#" class="navfont" hidefocus="true">企业信息</a></td></tr>
            		</table>
            	</td>
        		<td width="1048" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
        			</table>
        		</td>
      		</tr>
    		</table>
    	</td>
  		</tr>
	</table>

	<table width="100%"  cellspacing="0" cellpadding="0" class="line" >
	<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			<tr>
		      	<td width="11%" class="distd1" id="hylb_title">行业类别</td>
		        <td width="14%" width="373px" class="detailtd2"><span id="hylb_"></span></td>
		        <td width="11%" class="distd1" id="gxdwmc_title"><label id="gxdw_title"></label></td>
		        <td width="373px" class="detailtd2"><span id="gxdwmc_"></span></td>
			</tr>
			<tr id="hqZhuFuType">
		        <td class="distd1" id="qyzflmc_title">企业分类（主）</td>
		        <td width="373px" class="detailtd2"><span id="qyzflmc_"></span></td>
		        <td class="distd1" id="qyfflmc_title" style="display:none">企业分类（副）</td>
		        <td width="520px" class="detailtd2" id="qyfflmc_content" style="display:none"><span id="qyfflmc_"></span></td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="queryfont">&nbsp;企业基本信息</td>
		  </tr>
		  <tr>
		    <td valign="top"  class="tdbg">
		    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
		      <tr id="qyjbxxTr1">
		        <td class="distd1" id="qybm_title"><label id="qyorcs_title"></label><label id="qybianOrDaima_title"></label></td>
		        <td width="132px" class="detailtd2"><span id="qybm_"></span></td>
		        <td class="distd1" id="qymc_title"><label id="qyorcs_title"></label>名称</td>
		        <td width="383px" class="detailtd2" colspan="3"><span id="qymc_"></span></td>
		        <td class="distd1" id="qyzzjgdm_title">组织机构编码</td>
		        <td width="132px" class="detailtd2"><span id="qyzzjgdm_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr2">
		        <td width="11%" class="distd1" id="lxdh_title">联系电话</td>
		        <td width="132px" class="detailtd2"><span id="lxdh_"></span></td>
		        <td width="11%"class="distd1" id="yzbm_title">邮政编码</td>
		        <td width="132px" class="detailtd2"><span id="yzbm_"></span></td>
		        <td width="11%" class="distd1" id="chzh_title">传真</td>
		        <td width="132px" class="detailtd2"><span id="chzh_"></span></td>
		        <td width="11%" class="distd1" id="jjlxmc_title">经济类型</td>
		        <td width="132px" class="detailtd2"><span id="jjlxmc_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr3">
		      	<td class="distd1" id="zczj_title"><label id="zczj_title"></label></td>
		        <td width="132px" class="detailtd2"><span id="zczj_"></span></td>
		        <td class="distd1" id="jyfwzy_title"><label id="jyfw_title"></label></td>
		        <td width="132px" class="detailtd2"><span id="jyfwzy_"></span></td>
		        <td class="distd1" id="jyfwjy_title">经营范围（兼营）</td>
		        <td width="383px" class="detailtd2" id="jyfwjy_conte" colspan="3"><span id="jyfwjy_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr4">
		        <td class="distd1" id="jymj_title"><label id="jymj_title"></label></td>
		        <td width="132px" id="jymj_conte" class="detailtd2"><span id="jymj_"></span></td>
		        <td class="distd1" id="yyztmc_title">营业状态</td>
		        <td width="132px" class="detailtd2" id="yyztmc_conte"><span id="yyztmc_"></span></td>
		        <td class="distd1" id="jydz_title"><label id="jydz_title"></label></td>
		        <td width="373px" class="detailtd2" colspan="3" id="jydz_conte"><span id="jydz_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr5">
		        <td class="distd1" id="frdb_title">法定代表人</td>
		        <td width="132px" class="detailtd2"><span id="frdb_"></span></td>
		        <td class="distd1" id="frdbzjlb_title">法人证件类型</td>
		        <td width="132px" class="detailtd2"><span id="frdbzjlb_"></span></td>
		        <td class="distd1" id="frdbzjhm_title">法人证件号码</td>
		        <td width="132px" class="detailtd2"><span id="frdbzjhm_"></span></td>
		        <td class="distd1" id="frdblxfs_title">法人联系方式</td>
		        <td width="132px" class="detailtd2" id="frdblxfs_conte"><span id="frdblxfs_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr6">
		        <td class="distd1" id="kyrq_title">开业日期</td>
		        <td width="132px" class="detailtd2"><span id="kyrq_"></span></td>
		        <td class="distd1" id="yysj_title">营业时间</td>
		        <td width="132px" class="detailtd2" id="yysj_conte"><span id="yysj_"></span></td>
		        <td class="distd1" id="babh_title"><label id="babh_title"></label></td>
		        <td width="132px" class="detailtd2"><span id="babh_"></span></td>
		        <td class="distd1" id="barq_title">备案日期</td>
		        <td width="132px" class="detailtd2" id="barq_conte"><span id="barq_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr7">
		        <td class="distd1" id="dwfzr_title">单位负责人</td>
		        <td width="132px" class="detailtd2"><span id="dwfzr_"></span></td>
		        <td class="distd1" id="dwfzrzjhm_title"><label id="fzrgmsfhm_title"></label></td>
		        <td width="132px" class="detailtd2"><span id="dwfzrzjhm_"></span></td>
		        <td class="distd1" id="dwfzrlxfs_title">负责人联系方式</td>
		        <td width="132px" class="detailtd2"><span id="dwfzrlxfs_"></span></td>
		        <td class="pagedistd1" id="zajbmc_title">治安等级</td>
		        <td width="132px" class="detailtd2" id="zajbmc_conte"><span id="zajbmc_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr8">
		        <td class="distd1" id="yyzzZjbh_title">营业执照编号</td>
		        <td width="132px" class="detailtd2"><span id="yyzzZjbh_"></span></td>
		        <td class="distd1" id="yyzzFzjg_title">营业执照发证机关</td>
		        <td width="132px" class="detailtd2"><span id="yyzzFzjg_"></span></td>
		        <td class="distd1" id="yyzzQsrq_title">营业执照起始日期</td>
		        <td width="132px" class="detailtd2" id="yyzzQsrq_conte"><span id="yyzzQsrq_"></span></td>
		        <td class="distd1" id="yyzzJzrq_title">营业执照截止日期</td>
		        <td width="132px" class="detailtd2" id="yyzzJzrq_conte"><span id="yyzzJzrq_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr9">
		        <td class="distd1" id="swdjZjbh_title">税务登记证编号</td>
		        <td width="132px" class="detailtd2" id="swdjZjbh_conte"><span id="swdjZjbh_"></span></td>
		        <td class="zhehangtd" id="swdjFzjg_title"><label id="swdjfzjg_title"></label></td>
		        <td width="132px" class="detailtd2" id="swdjFzjg_conte"><span id="swdjFzjg_"></span></td>
		        <td class="distd1" id="swdjQsrq_title">税务登记证起始日期</td>
		        <td width="132px" class="detailtd2" id="swdjQsrq_conte"><span id="swdjQsrq_"></span></td>
		        <td class="distd1" id="swdjJzrq_title">税务登记证截止日期</td>
		        <td width="132px" class="detailtd2" id="swdjJzrq_conte"><span id="swdjJzrq_"></span></td>
		      </tr>
		      <tr id="qyjbxxTr10">
		        <td class="distd1" id="jyxkZjbh_title"><label id="jyxkzbh_title"></label></td>
		        <td width="132px" class="detailtd2" id="jyxkZjbh_conte"><span id="jyxkZjbh_"></span></td>
		        <td class="zhehangtd" id="jyxkFzjg_title"><label id="jyxkzfzjg_title"></label></td>
		        <td width="132px" class="detailtd2" id="jyxkFzjg_conte"><span id="jyxkFzjg_"></span></td>
		        <td class="distd1" id="jyxkQsrq_title">经营许可证起始日期</td>
		        <td width="132px" class="detailtd2" id="jyxkQsrq_conte"><span id="jyxkQsrq_"></span></td>
		        <td class="distd1" id="jyxkJzrq_title">经营许可证截止日期</td>
		        <td width="132px" class="detailtd2" id="jyxkJzrq_conte"><span id="jyxkJzrq_"></span></td>
		      </tr>
			  <tr id="thxx_">
		        <td class="distd1" id="thxkZjbh_title">特行许可证编号</td>
		        <td width="132px" class="detailtd2"><span id="thxkZjbh_"></span></td>
		        <td class="distd1" id="thxkFzjg_title">特行许可证发证机关</td>
		        <td width="132px" class="detailtd2"><span id="thxkFzjg_"></span></td>
		        <td class="distd1" id="thxkQsrq_title">特行许可证起始日期</td>
		        <td width="132px" class="detailtd2"><span id="thxkQsrq_"></span></td>
		        <td class="distd1" id="thxkJzrq_title">特行许可证截止日期</td>
		        <td width="132px" class="detailtd2"><span id="thxkJzrq_"></span></td>
		      </tr>
		      <tr id="xfxx_">
		        <td class="distd1" id="xfhgzh_title">消防合格证号</td>
		        <td width="132px" class="detailtd2"><span id="xfhgzh_"></span></td>
		        <td class="distd1" id="xfshdw_title">消防审核单位</td>
		        <td width="132px" class="detailtd2"><span id="xfshdw_"></span></td>
		        <td class="distd1" id="jwdzb_title">经纬度坐标</td>
		        <td width="132px" class="detailtd2"><span id="jwdzb_"></span></td>
		        <td class="distd1" id="jqbm_title">机器编码</td>
		        <td width="132px" class="detailtd2"><span id="jqbm_"></span></td>
		      </tr>
			  <tr id="qyjbxxTr13">
				<td id="gdxx_title" class="distd1">股东信息</td>
				<td id="gdxx_conte" colspan="3" width="373px" class="detailtd2"><span id="gdxx_"></span></td>
				<td class="distd1"><label id="zdskb_title" style="display:none;">最低刷卡比</label></td>
		        <td width="132px" class="detailtd2"><label id="zdskb_content" style="display:none;"><span id="zdskb_"></span></label>&nbsp;</td>
		        <td class="distd1"><label id="tyrq_title" style="display:none;">停业日期</label></td>
		        <td width="132px" class="detailtd2"><label id="tyrq_content" style="display:none;"><span id="tyrq_"></span></label></td>
			  </tr>
			  <tr id="qyjbxxTr14"></tr>
			  <tr id="qyjbxxTrLinshi1" style="display:none">
			      <td id="thbajg_title" class="distd1">特行备案机构</td>
			      <td id="thbajg_conte" class="detailtd2" width="132px"><span id="thbajg_"></span></td>
			      <td id="jyxkzfzjgdm_title" class="zhehangtd">经营许可证发证机构代码</td>
			      <td id="jyxkzfzjgdm_conte" class="detailtd2" width="132px"><span id="jyxkFzjgdm_"></span></td>
		      </tr>
		      <tr id="qyjbxxTrLinshi2" style="display:none">
			      <td id="bwbmdh_title" class="distd1">保卫部门电话</td>
			      <td id="bwbmdh_conte" class="detailtd2" width="132px"><span id="bwbmdh_"></span></td>
			      <td id="sfazsxt_title" class="distd1">是否安装摄像头</td>
			      <td id="sfazsxt_conte" class="detailtd2" width="132px"><span id="sfazsxt_"></span></td>
			      <td id="azsxtsl_title" class="distd1">摄像头数量</td>
			      <td id="azsxtsl_conte" class="detailtd2" width="132px"><span id="azsxtsl_"></span></td>
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
			        <td width="11%" class="distd1" id="zrs_title">总人数</td>
			        <td width="132px" width="132px" class="detailtd2" id="zrs_conte"><span id="zrs_"></span></td>
			        <td width="11%" class="distd1" id="hdrs_title">核定人数</td>
			        <td width="132px" width="132px" class="detailtd2" id="hdrs_conte"><span id="hdrs_"></span></td>
			        <td width="11%" class="distd1" id="bafzrxm_title"><label id="bafzr_title">保安负责人</label></td>
			        <td width="132px" width="132px" class="detailtd2" id="bafzrxm_conte"><label id="bafzr_content"><span id="bafzrxm_"></span></label></td>
			        <td width="11%" class="distd1"><label id="bars_title">保安人数</label></td>
			        <td width="132px" width="132px" class="detailtd2"><label id="bars_content"><span id="bars_"></span></label></td>
			      </tr>
			      <tr id="ryxxTr2">
			        <td class="distd1" id="jgpxrs_title">经岗位培训人数</td>
			        <td width="132px" class="detailtd2" id="jgpxrs_content"><span id="jgpxrs_"></span></td>
			        <td class="distd1" id="bagsyj_title">保安公司意见</td>
			        <td width="132px" class="detailtd2" id="bagsyj_content"><span id="bagsyj_"></span></td>
			        <td class="distd1" id="cksl_title" style="display:none;">出口数量</td>
			        <td width="137px" class="detailtd2" id="cksl_content" style="display:none;"><span id="cksl_"></span></td>
			        <td class="distd1"><label id="bxbjsl_title" style="display:none;">包厢包间数量</label></td>
			        <td width="132px" class="detailtd2" id="bxbjsl_content" style="display:none;"><span id="bxbjsl_"></span></td>
			      </tr>
			      <tr id="ryxxTr3">
			        <td class="distd1" id="bz_title">备注</td>
			        <td colspan="7" width="870px" class="detailtd2" id="bz_conte"><span id="bz_"></span></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
		<table width="100%" cellspacing="0" cellpadding="0" class="line" >
			<tr><td height="1"></td></tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			      <tr id="bgqyxx">
			        <td class="distd1">变更原因</td>
			        <td colspan="7" width="870px" class="detailtd2"><span id="bgyy_"></span></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
	</td>
	</tr>
	</table>
</td>
</tr>
</table>
<!-- 企业信息结束 -->
</BODY>
</HTML>