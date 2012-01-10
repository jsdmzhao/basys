<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@include file="../../public/common.jsp" %>
<%
User user = (User)session.getAttribute(Constants.userKey);
String csbm_qyd = "";
if(user!=null){
	csbm_qyd = user.getSsdwbm();
}
%>
<HTML>
<script type="text/javascript">
	var selHylb = "";
	var jsonResultMes = "";
	var qyjbxx_detailUrl = "publicsystem/query_qyjbxx.action";
	$(document).ready(function(){
		selHylb = "";
		$("#q_qybm").attr("value",'<%=csbm_qyd %>');
		qyjbxx_setDetail();
	});
	function qyjbxx_setDetail(){
		setParams("q_");
		jQuery.post(qyjbxx_detailUrl,params,qyjbxx_updatediv,"json");
	}
	function qyjbxx_updatediv(json){
		jsonResultMes = json;
		selHylb = setNull(json.LQyjbxx[0].hylbdm);
		$("#f_jjlxbm").attr("value",setNull(json.LQyjbxx[0].jjlxbm));
		$("#s_qyid").attr("value",json.LQyjbxx[0].qyid);
		$("#p_qyid").attr("value",json.LQyjbxx[0].qyid);
		if(selHylb=="J"&&setNull(json.LQyjbxx[0].yyztdm)=="12"){ //娱乐业专属
			showOrHideYlQitaxxbq('tyrq_','block');
		}
		
		$("#qyjbxxXiangxi").load("basic/publicsystem/QyjbxxXiangXiDetail.jsp", {}, function(){
			hyInit();
			if(selHylb=="J"){ //娱乐业专属
				$("#cksl").append(setNull(json.LQyjbxx[0].cksl));
				$("#bxbjsl").append(setNull(json.LQyjbxx[0].bxbjsl));
			}
			//默认赋值
			showOrHideByCsflAndJjlx(); //显示、隐藏标签
		});
	}
	function showOrHideByCsflAndJjlx(){ //用 企业分类-经济类型 判断显示与隐藏
		if(selHylb=="J"){ //娱乐业专属
			var theSecPageTag = 0;
			var jjlx = $("#f_jjlxbm").attr("value");
			//经济类型
			if(jjlx.substr(0,1)=='2'||jjlx.substr(0,1)=='3'){
				theSecPageTag = 1;
				$("#div_Wgtzrxx").show("slow");
			} else {
				$("#div_Wgtzrxx").hide("");
			}
			//整体第三个页签
			if(theSecPageTag==1){ //其他信息
				showOrHideYlQitaxxbq('small_yl_xxqt','block');
			} else {
				showOrHideYlQitaxxbq('small_yl_xxqt','none');
			}
		}
	}
	function hyInit(){ //行业初始化
		$("#qyjbxxXiangxi").height(490);
		showOrHideYlQitaxxbqTr('thxx_','none'); //特行信息
		showOrHideYlQitaxxbqTr('xfxx_','none'); //消防信息
		if(selHylb=="E01"||selHylb=="E02"||selHylb=="F01"||selHylb=="F02"){ //二手机、车 汽车出租、租赁
			showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		}
		showOrHideYlQitaxxbqLabel('bars_','none'); //保安人数
		showOrHideYlQitaxxbq('jgpxrs_','none'); //经岗位培训人数
		showOrHideYlQitaxxbq('bagsyj_','none'); //保安公司已经
		if(selHylb=='J'){ //娱乐业初始
			changeLableTitle('qyorcs_','场所');
		} else {
			changeLableTitle('qyorcs_','企业');
		}
		if(selHylb=='J'){
			ylyInit();
		} else if(selHylb=='C') { //机修业
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
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		//$("#qyjbxxXiangxi").height(340);
		jxylChange();
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
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		//$("#qyjbxxXiangxi").height(340);
		esjAndEscChange();
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
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		//$("#qyjbxxXiangxi").height(340);
		esjAndEscChange();
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
		showOrHideYlQitaxxbqTr('thxx_','block'); //特行信息
		showOrHideYlQitaxxbqTr('xfxx_','block'); //消防信息
		showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		showOrHideYlQitaxxbqLabel('bars_','block'); //保安人数
		showOrHideYlQitaxxbq('jgpxrs_','block'); //经岗位培训人数
		showOrHideYlQitaxxbq('bagsyj_','block'); //保安公司已经
		changeLableTitle('gxdw_title','管辖单位');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		//$("#qyjbxxXiangxi").height(490);
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
		changeLableTitle('swdjfzjg_title','税务登记证<br>发证机构名称');
		//$("#qyjbxxXiangxi").height(340);
		qcczAndQczlChange();
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
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		//$("#qyjbxxXiangxi").height(340);
		qcczAndQczlChange();
	}
	
	//function showOrHideYlQitaxxbq(smallId,state){ //显示隐藏 ‘其他信息’ 小标签  
	//	$("[id^='"+smallId+"']").each(function(){
	//		$(this)[0].style.display=''+state;
	//	});
	//}
	function showOrHideYlQitaxxbqTr(smallId,state){ //显示隐藏 TR
		$("tr[id^='"+smallId+"']").each(function(){
			$(this)[0].style.display=''+state;
		});
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
	function setTrAppendTd(trid,smallId){ //移动td到制定的tr后面
		$("td[id^='"+smallId+"']").each(function(){
			$(this).appendTo($("#"+trid));
		});
	}
	function show_biaoqian(yqid){ //点击页签时的动作
		$("#yqAndZt option").each(function(){
			var thisid =  $(this).attr("value");
			$("#"+thisid)[0].style.display='none';
			if(thisid==yqid){
				$("#"+thisid)[0].style.display='block';
			}
		});
		onloadbq(yqid);
	}
	function esjAndEscChange(){ //二手机和二手机的变化
		qcczAndQczlChange();
		setTrAppendTd('qyjbxxTr4','sfazsxt_');
		setTrAppendTd('qyjbxxTr4','azsxtsl_');
	}
	function qcczAndQczlChange(){ //汽车出租和企业租赁变化
		setRemoveObj('jyxk_qsrq');
		setRemoveObj('jyxk_jzrq');
		setRemoveObj('jyfwjy_');
		setRemoveObj('yyzt_');
		setRemoveObj('yysj_');
		setRemoveObj('barq_');
		setRemoveObj('zadj_');
		setRemoveObj('yyzzqsrq_');
		setRemoveObj('yyzzjzrq_');
		setRemoveObj('swdjqsrq_');
		setRemoveObj('swdjjzrq_');
		setRemoveObj('gdxx_');
		setRemoveObj('ryjqt_');
		setRemoveObj('zrs_');
		setRemoveObj('hdrs_');
		setTrAppendTd('qyjbxxTr3','jydz_');
		setTrAppendTd('qyjbxxTr8','swdjzbh_');
		setTrAppendTd('qyjbxxTr8','swdjfzjg_');
		setTrAppendTd('qyjbxxTr14','bz_');
		setTrAppendTd('qyjbxxTr6','thbajg_');
		setTrAppendTd('qyjbxxTr7','bafzr_');
		showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		if(selHylb=="F01"||selHylb=="F02"){ //汽车出租、租赁
			setTrAppendTd('qyjbxxTr10','jyxkzfzjgdm_');
			setTrAppendTd('qyjbxxTr10','jymj_');
			setTrAppendTd('qyjbxxTr6','bwbmdh_');
		} else {
			setTrAppendTd('qyjbxxTr4','bwbmdh_');
		}
	}
	function jxylChange(){ //机修业变化
		setRemoveObj('jyfwjy_');
		setRemoveObj('yyzt_');
		setRemoveObj('yysj_');
		setRemoveObj('barq_');
		setRemoveObj('zadj_');
		setRemoveObj('yyzzqsrq_');
		setRemoveObj('yyzzjzrq_');
		setRemoveObj('swdjqsrq_');
		setRemoveObj('swdjjzrq_');
		setRemoveObj('gdxx_');
		setRemoveObj('ryjqt_');
		setRemoveObj('zrs_');
		setRemoveObj('hdrs_');
		setRemoveObj('frlxfs_');
		setRemoveObj('jyxk_qsrq');
		setRemoveObj('jyxk_jzrq');
		setTrAppendTd('qyjbxxTr3','jydz_');
		setTrAppendTd('qyjbxxTr8','swdjzbh_');
		setTrAppendTd('qyjbxxTr8','swdjfzjg_');
		setTrAppendTd('qyjbxxTr14','bz_');
		setTrAppendTd('qyjbxxTr6','thbajg_');
		setTrAppendTd('qyjbxxTr5','bafzr_');
		setTrAppendTd('qyjbxxTr6','jyxk_bh');
		setTrAppendTd('qyjbxxTr7','jyxk_fzjg');
		showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		setTrAppendTd('qyjbxxTr4','bwbmdh_');
	}
	function onloadbq(yqid){
		var yqstate = getYqValueByKey(yqid);
		setYqValueByKey(yqid,'1');
		if(yqid=='yl_qt'&&yqstate==0){
			$("#div_baoan").empty();
			$("#div_baoan").load("basic/publicsystem/BafwhtMan.jsp");
			$("#div_baoan").show("slow");
			$("#div_pmt").empty();
			$("#div_pmt").load("basic/publicsystem/PmtMan.jsp");
			$("#div_pmt").show("slow"); 
			$("#div_Bldsjksb").empty();
			$("#div_Bldsjksb").load("basic/publicsystem/BldsjksbMan.jsp");
			$("#div_Bldsjksb").show("slow"); 
			$("#div_Aqjcsb").empty();
			$("#div_Aqjcsb").load("basic/publicsystem/AqjcsbMan.jsp");
			$("#div_Aqjcsb").show("slow");
			$("#m_activePageTwo").attr("value","1");
		}
		if(yqid=='yl_qtxx'&&yqstate==0){
			$("#div_Wgtzrxx").empty();
			$("#div_Wgtzrxx").load("basic/publicsystem/WgtzrxxMan.jsp");
			$("#m_activePageThree").attr("value","1");
		}
	}
	function getYqValueByKey(key){ //获取页签加载状态 0未加载 1已加载
		var result = "";
		$("#yqAndZt option").each(function(){
			if($(this).attr("value")==key){
				result =  $(this).text();
				return false;
			}
		});
		return result;
	}
	function setYqValueByKey(key,value){ //设置页签加载状态 0未加载 1已加载
		$("#yqAndZt option").each(function(){
			if($(this).attr("value")==key){
				$(this).html(value);;
			}
		});
	}
	function changeLableTitle(smallId,content){ //显示隐藏 ‘其他信息’ 小标签  
		$("label[id^='"+smallId+"']").each(function(){
			$(this).html(content);
		});
	}
	function setRemoveObj(removeid){ //加制定的TD隐藏
		$("td[id^='"+removeid+"']").each(function(){
			$(this).hide();
		});
	}
	function closeAllDiv(){ //关闭所有添加的页签
		$("#bafwht_detail").hide("slow");
		$("#pmt_detail").hide("slow");
		$("#bldsjksb_detail").hide("slow");
		$("#aqjcsb_detail").hide("slow"); 
		
		$("#wgtzrxx_detail").hide("slow");
		$("#yxyycs_detail").hide("slow");
	}
</script>
<BODY>
<!-- 页面的页签及加载状态 新加业-->
<select id="yqAndZt" style="DISPLAY:none">
<option value='qyxx'>0</option>
<option value='yl_qt'>0</option>
<option value='yl_qtxx'>0</option>
</select>

<input type="hidden" id="q_qyid">
<input type="hidden" id="q_qybm">
<input type="hidden" id="s_qyid">
<input type="hidden" id="p_qyid">
<input type="hidden" id="f_jjlxbm">
<div id="qyxxClose"></div>
<!-- 企业信息开始 -->
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0" id="qyxx" style="DISPLAY: block">
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
            		<tr><td><a href="#" onmousedown="show_biaoqian('qyxx')" class="navfont" hidefocus="true"><label id="qyorcs_title"></label>信息</a></td></tr>
            		</table>
            	</td>
        		<td width="78" id="small_yl_qt1" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1">
            		<tr><td align="center"><a href="#" onmousedown="show_biaoqian('yl_qt')" class="navfont" hidefocus="true">其他</a></td></tr>
        			</table>
        		</td>
        		<td width="78" id="small_yl_xxqt1" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1">
            		<tr><td align="center" ><a href="#" onmousedown="show_biaoqian('yl_qtxx')" class="navfont" hidefocus="true">其他信息</a></td></tr>
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
	<div id="qyjbxxXiangxi" class="scrollbarface" style="overflow-y:auto;overflow-x:hidden;height:490;width:100%;"></div>
</td>
</tr>
</table>
<!-- 企业信息结束 -->

<!-- 娱乐 其他开始 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="yl_qt"   style="DISPLAY:none">
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
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav1">
            		<tr><td><a  href="#" onmousedown="show_biaoqian('qyxx')" class="navfont" hidefocus="true"><label id="qyorcs_title"></label>信息</a></td></tr>
            		</table>
            	</td>
        		<td width="78" id="small_yl_qt2" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav11" >
            		<tr><td align="center"><a href="#" onmousedown="show_biaoqian('yl_qt')" class="navfont" hidefocus="true" >其他</a></td></tr>
        			</table>
        		</td>
        		<td width="78" id="small_yl_xxqt2" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1" >
            		<tr><td align="center" ><a href="#" onmousedown="show_biaoqian('yl_qtxx')" class="navfont" hidefocus="true" >其他信息</a></td></tr>
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
	<table width="100%" cellspacing="0" cellpadding="0" class="line" >
	<tr><td height="3"></td></tr>
	</table>
	<table width="100%"  cellspacing="0" cellpadding="0" class="line" >
		<tr><td valign="top" align="left">
			<div style="width:100%" id=div_baoan></div>
			<div style="width:100%" id=div_pmt></div>
			<div style="width:100%" id=div_Bldsjksb></div>
			<div style="width:100%" id=div_Aqjcsb></div>
		</td></tr>
	</table>
</td>
</tr>
</table>
<!-- 娱乐 其他结束 -->
<!-- 娱乐 其他信息开始 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="yl_qtxx" style="DISPLAY:none">
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
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav1">
            		<tr><td><a  href="#" onmousedown="show_biaoqian('qyxx')" class="navfont" hidefocus="true"><label id="qyorcs_title"></label>信息</a></td></tr>
            		</table>
            	</td>
        		<td width="78" id="small_yl_qt3" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1" >
            		<tr><td align="center"><a href="#" onmousedown="show_biaoqian('yl_qt')" class="navfont" hidefocus="true" >其他</a></td></tr>
        			</table>
        		</td>
        		<td width="78" id="small_yl_xxqt3" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav11" >
            		<tr><td align="center" ><a href="#" onmousedown="show_biaoqian('yl_qtxx')" class="navfont" hidefocus="true" >其他信息</a></td></tr>
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
		<tr><td></td></tr>
		<tr>
    	<td valign="top" align="left">
			<div style="width:100%" id=div_Wgtzrxx></div>
		</td>
		</tr>
	</table>
</td>
</tr>
</table>
</BODY>
</HTML>