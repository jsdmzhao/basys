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
		addtotempList("azsxtsl_",setNull(json.LQyjbxx[0].azsxtsl));
		
		var sgscxfjjs = setNull(json.LQyjbxx[0].sgscxfjjs);
		if(sgscxfjjs=='1'){
			sgscxfjjs = "是";
		}
		if(sgscxfjjs=='0'){
			sgscxfjjs = "否";
		}
		addtotempList("sgscxfjjs_",sgscxfjjs);
		addtotempList("jhltlxmc_",setNull(json.LQyjbxx[0].jhltlxmc));
		
		//营业执照、经营许可证
		addtotempList("yyzzZjbh_",setNull(json.LQyjbxx[1].yyzzZjbh));
		addtotempList("yyzzFzjg_",setNull(json.LQyjbxx[1].yyzzFzjg));
		addtotempList("yyzzQsrq_",setNull(json.LQyjbxx[1].yyzzQsrq));
		addtotempList("yyzzJzrq_",setNull(json.LQyjbxx[1].yyzzJzrq));
		addtotempList("djrq_",setNull(json.LQyjbxx[0].djrq));
		
		addtotempList("jyxkZjbh_",setNull(json.LQyjbxx[1].jyxkZjbh));
		addtotempList("jyxkFzjg_",setNull(json.LQyjbxx[1].jyxkFzjg));
		addtotempList("jyxkQsrq_",setNull(json.LQyjbxx[1].jyxkQsrq));
		addtotempList("jyxkJzrq_",setNull(json.LQyjbxx[1].jyxkJzrq));
		addtotempList("jyxkFzjgdm_",setNull(json.LQyjbxx[1].swdjFzjgdm));
		
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
		addtotempList("bafzrgmsfhm_",setNull(json.LQyjbxx[0].bafzrgmsfhm));
		addtotempList("bafzrdh_",setNull(json.LQyjbxx[0].bafzrdh));
		addtotempList("nsrq_",setNull(json.LQyjbxx[0].nsrq));
		addtotempList("bz_",setNull(json.LQyjbxx[0].bz));

		addtotempList("lrr_",setNull(json.LQyjbxx[0].lrr));
		addtotempList("lrsj_",setNull(json.LQyjbxx[0].lrsj));
		bgqk_setDetail();
	}
	
	function bgqk_updatediv(json){ //当前历史记录
		selHylb = setNull(json.LQyjbxx[0].hylbdm);
		$("#f_jjlxbm").attr("value",setNull(json.LQyjbxx[0].jjlxbm));
		hyInit(json);
		
	}
	function loadSomeHyBack(json){
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
		changeAndWriteRedFont("azsxtsl_",setNull(json.LQyjbxx[0].azsxtsl));
		
		
		$("#bgyy_").append(setNull(json.LQyjbxx[0].bgyy));
		
		var sgscxfjjs = setNull(json.LQyjbxx[0].sgscxfjjs);
		if(sgscxfjjs=='1'){
			sgscxfjjs = "是";
		}
		if(sgscxfjjs=='0'){
			sgscxfjjs = "否";
		}
		changeAndWriteRedFont("sgscxfjjs_",sgscxfjjs);
		changeAndWriteRedFont("jhltlxmc_",setNull(json.LQyjbxx[0].jhltlxmc));
		
		//营业执照、经营许可证
		changeAndWriteRedFont("yyzzZjbh_",setNull(json.LQyjbxx[1].yyzzZjbh));
		changeAndWriteRedFont("yyzzFzjg_",setNull(json.LQyjbxx[1].yyzzFzjg));
		changeAndWriteRedFont("yyzzQsrq_",setNull(json.LQyjbxx[1].yyzzQsrq));
		changeAndWriteRedFont("yyzzJzrq_",setNull(json.LQyjbxx[1].yyzzJzrq));
		changeAndWriteRedFont("djrq_",setNull(json.LQyjbxx[0].djrq));
		
		changeAndWriteRedFont("jyxkZjbh_",setNull(json.LQyjbxx[1].jyxkZjbh));
		changeAndWriteRedFont("jyxkFzjg_",setNull(json.LQyjbxx[1].jyxkFzjg));
		changeAndWriteRedFont("jyxkQsrq_",setNull(json.LQyjbxx[1].jyxkQsrq));
		changeAndWriteRedFont("jyxkJzrq_",setNull(json.LQyjbxx[1].jyxkJzrq));
		changeAndWriteRedFont("jyxkFzjgdm_",setNull(json.LQyjbxx[1].jyxkFzjgdm));
		
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
		changeAndWriteRedFont("bafzrgmsfhm_",setNull(json.LQyjbxx[0].bafzrgmsfhm));
		changeAndWriteRedFont("bafzrdh_",setNull(json.LQyjbxx[0].bafzrdh));
		changeAndWriteRedFont("nsrq_",setNull(json.LQyjbxx[0].nsrq));
		changeAndWriteRedFont("bz_",setNull(json.LQyjbxx[0].bz));
		
		changeAndWriteRedFont("lrr_",setNull(json.LQyjbxx[0].lrr));
		changeAndWriteRedFont("lrsj_",setNull(json.LQyjbxx[0].lrsj));
	}
	function hyInit(json){ //行业初始化
		if(selHylb=='J'){
			ylyInit(json);
		} else if(selHylb=='C') { //机修
			jxyInit(json);
		} else if(selHylb=='E01') { //二手车
			ershoucInit(json);
		} else if(selHylb=='E02') { //二手机
			ershoushoujiInit(json);
		} else if(selHylb=='E04') { //废旧金属
			fjjsInit(json);
		} else if(selHylb=='F01') { //出租车
			czcInit(json);
		} else if(selHylb=='F02') { //汽车租赁
			qczlInit(json);
		} else if(selHylb=='B') { //印章行业
			yzyInit(json);
		} else if(selHylb=='E03') { //典当
			ddyInit(json);
		} else if(selHylb=='C01') { //机动车拆解
			jdccjyInit(json);
		} else if(selHylb=='E07') { //机动车拆解
			wtjmyInit(json);
		}
	}
	function ylyInit(json){ //娱乐业初始
	}
	function jxyInit(json){ //机修业初始
		changeLableTitle('gxdw_title','治安管辖机构');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-jxy-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function ershoucInit(json){ //二手车
		changeLableTitle('gxdw_title','治安管辖机构');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-esc-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function ershoushoujiInit(json){ //二手机
		changeLableTitle('gxdw_title','治安管辖机构');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-esj-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function fjjsInit(json){ //废旧金属
		changeLableTitle('gxdw_title','管辖单位');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-fjjs-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function czcInit(json){ //出租车
		changeLableTitle('gxdw_title','治安管辖机构');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-czc-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function qczlInit(json){ //汽车租赁
		changeLableTitle('gxdw_title','治安管辖机构');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-qczl-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function yzyInit(json){ //印章行业
		changeLableTitle('gxdw_title','管辖单位');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-yz-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function ddyInit(json){ //典当
		changeLableTitle('gxdw_title','管辖单位');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-ddy-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function jdccjyInit(json){ //机动车拆解
		changeLableTitle('gxdw_title','管辖单位');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-jdccj-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
		});
	}
	function wtjmyInit(json){ //委托寄卖业
		changeLableTitle('gxdw_title','管辖单位');
		$("#someHyMes").load("basic/publicsystem/QyjbxxDetail-ls-wtjm-gzth.jsp", {}, function(){
			loadSomeHyBack(json);
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
	function changeLableTitle(smallId,content){ //设置lable内容 
		$("label[id^='"+smallId+"']").each(function(){
			$(this).html(content);
		});
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
      <td align="right" class="title1"><a href="#" onClick="$('#qyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
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
		      	<td width="13%" class="distd1" id="hylb_title">行业类别</td>
		        <td width="14%" class="detailtd2"><span width="373px"  id="hylb_"></span></td>
		        <td width="22%" class="distd1" id="gxdwmc_title"><label id="gxdw_title"></label></td>
		        <td width="51%" class="detailtd2"><span width="373px" id="gxdwmc_"></span></td>
			</tr>
			<tr id="hqZhuFuType">
		        <td class="distd1" id="qyzflmc_title">企业分类（主）</td>
		        <td width="373px" class="detailtd2"><span id="qyzflmc_"></span></td>
		        <td class="distd1" id="qyfflmc_title" style="display:none">企业分类（副）</td>
		        <td width="520px" class="detailtd2" id="qyfflmc_content" style="display:none"><span id="qyfflmc_"></span></td>
			</tr>
		</table>
		<label id="someHyMes"></label> <!-- 企业信息 -->
 <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			      <tr id="bgqyxx">
			        <td class="distd1" width="13%">变更原因</td>
			        <td colspan="5" width="870px" class="detailtd2"><span id="bgyy_"></span></td>
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