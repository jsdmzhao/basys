<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	var selHylb; //当前行业类别
	var yqstate = '0'; //页签点击状态
	$(document).ready(function() {
		bc_bottonMoveRight(); //按钮右对齐
		selHylb = "";
		$("#qyjbxxXiangxi").load("basic/publicsystem/QyjbxxXiangXiAdd-gzth.jsp", {}, function(){
			hylbOnchange();
		});
	});
	
	function hylbOnchange(){
		$("#QyJibenxiangmu").empty();
		var key = $("#bq_hylb").attr("value");
		var val = $("#bq_hylb").attr("title");
		$("#a_hylbdm").attr("value",key);
		$("#a_hylb").attr("value",val);
		selHylb = key;
		if(selHylb=='J'){ //娱乐业初始
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
		} else if(selHylb=='B') { //印章行业
			yzhyInit();
		} else if(selHylb=='E03') { //典当业
			ddyInit();
		} else if(selHylb=='E07') { //委托寄卖
			wtjmyInit();
		} else if(selHylb=='C01') { //机动车拆解
			jdccjyInit();
		}
	}
	function ylyInit(){ //娱乐业初始
	}
	function jxyInit(){ //机修
		changeLableTitle('gxdw_title','管辖单位');
		//$("#hqZhuFuType").css("display","block"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_jxqyfl",width:"118px"});
		$("#qyjbxxXiangxi").height(413);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-jxy-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
			jxyYqInit(); //页签初始化
		});
	}
	function ershoucInit(){ //二手车
		changeLableTitle('gxdw_title','管辖单位');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(esc)",width:"118px"}); //主分类
		$("#qyjbxxXiangxi").height(438);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-esc-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
			escYqInit(); //页签初始化
		});
	}
	function ershoushoujiInit(){ //二手机
		changeLableTitle('gxdw_title','治安管辖机构');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(esj)",width:"118px"}); //主分类
		$("#qyjbxxXiangxi").height(413);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-esj-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
		});
	}
	function fjjsInit(){ //废旧金属
		changeLableTitle('gxdw_title','管辖单位');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(fjjs)",width:"118px"});
		$("#qyjbxxXiangxi").height(435);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-fjjs-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			zajbOnchange();
			yyztOnchange();
			changeLableTitle('qyorcs_','企业');
			fjjsYqInit(); //页签初始化
		});
	}
	function czcInit(){ //出租车
		changeLableTitle('gxdw_title','治安管辖机构');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(czc)",width:"118px"}); //主分类
		$("#qyjbxxXiangxi").height(413);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-czc-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
		});
	}
	function qczlInit(){ //汽车租赁
		changeLableTitle('gxdw_title','治安管辖机构');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(qczl)",width:"118px"});
		$("#qyjbxxXiangxi").height(413);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-qczl-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
		});
	}
	
	function yzhyInit(){ //印章行业
		changeLableTitle('gxdw_title','管辖单位');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(yz)",width:"118px"});
		$("#qyjbxxXiangxi").height(485);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-yz-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
			yzyYqInit(); //页签初始化
		});
	}
	function ddyInit(){ //典当业
		changeLableTitle('gxdw_title','管辖单位');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(ddy)",width:"118px"});
		$("#qyjbxxXiangxi").height(440);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-ddy-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
			ddyYqInit(); //页签初始化
		});
	}
	function wtjmyInit(){ //委托寄卖业
		changeLableTitle('gxdw_title','管辖单位');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(wtjmy)",width:"118px"});
		$("#qyjbxxXiangxi").height(485);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-wtjm-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
			wtjmYqInit(); //页签初始化
		});
	}
	function jdccjyInit(){ //机动车拆解业
		changeLableTitle('gxdw_title','管辖单位');
		//$("#hqZhuFuType").css("display","none"); //当需要隐藏/显示企业主分类的时候 将此行回复注销
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(jdccj)",width:"118px"});
		$("#qyjbxxXiangxi").height(413);
		$("#QyJibenxiangmu").load("basic/publicsystem/QyjbxxJibenXiangMuAdd-jdccj-gzth.jsp", {}, function(){
			csflOnchange();
			frdbzjOnchange();
			changeLableTitle('qyorcs_','企业');
			jdccjYqInit(); //页签初始化
		});
	}
	
	//---不同行业页签初始化(根据需求,不同行业可能需要不同的页签)
	function jxyYqInit(){ //机修业
		showOrHideYlQitaxxbq('small_','none'); //先将除企业信息以外的页签关掉
		setYqValueAll('0'); //将除企业信息以外的页签加载状态全变成未被加载状态
		showOrHideYlQitaxxbq('small_abxx','block'); //用到安保信息页签则加载之,不需要则不用写本行和下两行
		$("#plant_abxx").load("basic/publicsystem/YqAbxx-jxy-gzth.jsp"); //安保信息页签需要有那些DIV 去加载不同的业务页面
	}
	
	//---不同行业页签初始化(根据需求,不同行业可能需要不同的页签)
	function yzyYqInit(){ //印章业
		showOrHideYlQitaxxbq('small_','none'); //先将除企业信息以外的页签关掉
		setYqValueAll('0'); //将除企业信息以外的页签加载状态全变成未被加载状态
		showOrHideYlQitaxxbq('small_abxx','block'); //用到安保信息页签则加载之,不需要则不用写本行和下两行
		$("#plant_abxx").load("basic/publicsystem/YqAbxx-yzy-gzth.jsp"); //安保信息页签需要有那些DIV 去加载不同的业务页面
	}
	function ddyYqInit(){ //典当业
		showOrHideYlQitaxxbq('small_','none'); //先将除企业信息以外的页签关掉
		setYqValueAll('0'); //将除企业信息以外的页签加载状态全变成未被加载状态
		showOrHideYlQitaxxbq('small_abxx','block'); //用到安保信息页签则加载之,不需要则不用写本行和下两行
		$("#plant_abxx").load("basic/publicsystem/YqAbxx-ddy-gzth.jsp"); //安保信息页签需要有那些DIV 去加载不同的业务页面
		//showOrHideYlQitaxxbq('small_xxqt','block'); //用到企业信息页签则加载之,不需要则不用写本行和下两行
		//$("#plant_qtxx").load("basic/publicsystem/YqQbxx-yly-th.jsp"); //其他信息页签需要有那些DIV 去加载不同的业务页面
	}
	function fjjsYqInit(){ //废旧金属业
		showOrHideYlQitaxxbq('small_','none'); //先将除企业信息以外的页签关掉
		setYqValueAll('0'); //将除企业信息以外的页签加载状态全变成未被加载状态
		showOrHideYlQitaxxbq('small_abxx','block'); //用到安保信息页签则加载之,不需要则不用写本行和下两行
		$("#plant_abxx").load("basic/publicsystem/YqAbxx-fjjs-gzth.jsp"); //安保信息页签需要有那些DIV 去加载不同的业务页面
	}
	function escYqInit(){ //二手车
		showOrHideYlQitaxxbq('small_','none'); //先将除企业信息以外的页签关掉
		setYqValueAll('0'); //将除企业信息以外的页签加载状态全变成未被加载状态
		showOrHideYlQitaxxbq('small_abxx','block'); //用到安保信息页签则加载之,不需要则不用写本行和下两行
		$("#plant_abxx").load("basic/publicsystem/YqAbxx-esc-gzth.jsp"); //安保信息页签需要有那些DIV 去加载不同的业务页面
	}
	
	//---不同行业页签初始化(根据需求,不同行业可能需要不同的页签)
	function wtjmYqInit(){ //委托寄卖业
		showOrHideYlQitaxxbq('small_','none'); //先将除企业信息以外的页签关掉
		setYqValueAll('0'); //将除企业信息以外的页签加载状态全变成未被加载状态
		showOrHideYlQitaxxbq('small_abxx','block'); //用到安保信息页签则加载之,不需要则不用写本行和下两行
		$("#plant_abxx").load("basic/publicsystem/YqAbxx-wtjm-gzth.jsp"); //安保信息页签需要有那些DIV 去加载不同的业务页面
	}

	function jdccjYqInit(){ //机动车拆解业
		showOrHideYlQitaxxbq('small_','none'); //先将除企业信息以外的页签关掉
		setYqValueAll('0'); //将除企业信息以外的页签加载状态全变成未被加载状态
		showOrHideYlQitaxxbq('small_abxx','block'); //用到安保信息页签则加载之,不需要则不用写本行和下两行
		$("#plant_abxx").load("basic/publicsystem/YqAbxx-jdccj-gzth.jsp"); //安保信息页签需要有那些DIV 去加载不同的业务页面
	}
	
	//---不同行业页签点击事件初始化(根据需求,不同行业每个页签加载的内容可能不同：在这里做)
	function jxyOnloadbq(yqid){ //机修业业
		if(yqid=='abxx'&&yqstate==0){ //保证加载一次
			$("#div_jxy_baoAnRY").empty().load("basic/publicsystem/BaryxxMan.jsp").show("slow"); //加载保安人员信息
			$("#div_jxy_baoWeiRY").empty().load("basic/publicsystem/BwryxxAddMan.jsp").show("slow"); //加载保卫人员信息
			$("#div_jxy_shiPinSB").empty().load("basic/publicsystem/BldsjksbAddMan-gzth.jsp").show("slow"); //加载视频监控设备
			$("#div_jxy_jiFangSB").empty().load("basic/publicsystem/AqjcsbMan-gzth.jsp").show("slow"); //加载技防设备信息
		}
	}
	
	//---不同行业页签点击事件初始化(根据需求,不同行业每个页签加载的内容可能不同：在这里做)
	function yzhyOnloadbq(yqid){ //印章业
		if(yqid=='abxx'&&yqstate==0){ //保证加载一次
			$("#div_yzy_baoAnRY").empty().load("basic/publicsystem/BaryxxMan.jsp").show("slow"); //加载保安人员信息
			$("#div_yzy_baoWeiRY").empty().load("basic/publicsystem/BwryxxAddMan.jsp").show("slow"); //加载保卫人员信息
			$("#div_yzy_shiPinSB").empty().load("basic/publicsystem/BldsjksbAddMan-gzth.jsp").show("slow"); //加载视频监控设备
			$("#div_yzy_jiFangSB").empty().load("basic/publicsystem/AqjcsbMan-gzth.jsp").show("slow"); //加载技防设备信息
		}
	}
	function ddyOnloadbq(yqid){ //典当业
		if(yqid=='abxx'&&yqstate==0){ //保证加载一次
			$("#div_ddy_baoAnRY").empty().load("basic/publicsystem/BaryxxMan.jsp").show("slow");//加载保安人员信息
			$("#div_ddy_baoWeiRY").empty().load("basic/publicsystem/BwryxxAddMan.jsp").show("slow");//加载保卫人员信息
			$("#div_ddy_shiPinSB").empty().load("basic/publicsystem/BldsjksbAddMan-gzth.jsp").show("slow");//加载视频监控设备
			$("#div_ddy_jiFangSB").empty().load("basic/publicsystem/AqjcsbMan-gzth.jsp").show("slow");//加载技防设备信息
		}
	}
	function fjjsOnloadbq(yqid){ //废旧金属
	    if(yqid=='abxx'&&yqstate==0){ //保证加载一次
			$("#div_fjjs_baoAnRY").empty().load("basic/publicsystem/BaryxxMan.jsp").show("slow");//加载保安人员信息
			$("#div_fjjs_baoWeiRY").empty().load("basic/publicsystem/BwryxxAddMan.jsp").show("slow"); //加载保卫人员信息
			$("#div_fjjs_shiPinSB").empty().load("basic/publicsystem/BldsjksbAddMan-gzth.jsp").show("slow"); //加载视频监控设备
			$("#div_fjjs_jiFangSB").empty().load("basic/publicsystem/AqjcsbMan-gzth.jsp").show("slow"); //加载技防设备信息
		}
	}
	function ershoucOnloadbq(yqid){ //二手车
	    if(yqid=='abxx'&&yqstate==0){ //保证加载一次
			$("#div_esc_baoAnRY").empty().load("basic/publicsystem/BaryxxMan.jsp").show("slow");//加载保安人员信息
			$("#div_esc_baoWeiRY").empty().load("basic/publicsystem/BwryxxAddMan.jsp").show("slow"); //加载保卫人员信息
			$("#div_esc_shiPinSB").empty().load("basic/publicsystem/BldsjksbAddMan-gzth.jsp").show("slow"); //加载视频监控设备
			$("#div_esc_jiFangSB").empty().load("basic/publicsystem/AqjcsbMan-gzth.jsp").show("slow"); //加载技防设备信息
		}
	}
	
	function wtjmOnloadbq(yqid){ //委托寄卖
	    if(yqid=='abxx'&&yqstate==0){ //保证加载一次
			$("#div_wtjm_baoAnRY").empty().load("basic/publicsystem/BaryxxMan.jsp").show("slow");//加载保安人员信息
			$("#div_wtjm_baoWeiRY").empty().load("basic/publicsystem/BwryxxAddMan.jsp").show("slow"); //加载保卫人员信息
			$("#div_wtjm_shiPinSB").empty().load("basic/publicsystem/BldsjksbAddMan-gzth.jsp").show("slow"); //加载视频监控设备
			$("#div_wtjm_jiFangSB").empty().load("basic/publicsystem/AqjcsbMan-gzth.jsp").show("slow"); //加载技防设备信息
		}
	}
	
	function jdccjOnloadbq(yqid){ //机动车拆解
	    if(yqid=='abxx'&&yqstate==0){ //保证加载一次
			$("#div_jdccj_baoAnRY").empty().load("basic/publicsystem/BaryxxMan.jsp").show("slow");//加载保安人员信息
			$("#div_jdccj_baoWeiRY").empty().load("basic/publicsystem/BwryxxAddMan.jsp").show("slow"); //加载保卫人员信息
			$("#div_jdccj_shiPinSB").empty().load("basic/publicsystem/BldsjksbAddMan-gzth.jsp").show("slow"); //加载视频监控设备
			$("#div_jdccj_jiFangSB").empty().load("basic/publicsystem/AqjcsbMan-gzth.jsp").show("slow"); //加载技防设备信息
		}
	}
	
	//---页签点击动作
	function show_biaoqian(yqid){ //点击页签时的动作
		$("#yqAndZt option").each(function(){
			var thisid =  $(this).attr("value");
			$("#"+thisid)[0].style.display='none';
			if(thisid==yqid){
				$("#"+thisid)[0].style.display='block';
			}
		});
		yqstate = getYqValueByKey(yqid);
		setYqValueByKey(yqid,'1');
		if(yqid=='abxx'&&yqstate==0){ //保证变更一次
			$("#a_activePageTwo").attr("value","1");
		}
		if(yqid=='qtxx'&&yqstate==0){ //保证变更一次
			$("#a_activePageTwo").attr("value","1");
		}
		if(selHylb=='J'){ //娱乐业初始
		} else if(selHylb=='C') {//机修
			jxyOnloadbq(yqid);
		} else if(selHylb=='E01') { //二手车
			ershoucOnloadbq(yqid);
		} else if(selHylb=='E02') { //二手机
			//ershoushoujiOnloadbq(yqid);
		} else if(selHylb=='E04') { //废旧金属
			fjjsOnloadbq(yqid);
		} else if(selHylb=='F01') { //出租车
			//czcOnloadbq(yqid);
		} else if(selHylb=='F02') { //汽车租赁
			//qczlOnloadbq(yqid);
		} else if(selHylb=='B') { //印章行业
			yzhyOnloadbq(yqid);
		} else if(selHylb=='E03') { //典当业
			ddyOnloadbq(yqid);
		} else if(selHylb=='E07') { //委托寄卖
			wtjmOnloadbq(yqid);
		} else if(selHylb=='C01') { //机动车拆解
			jdccjOnloadbq(yqid);
		}
	}
	
	//---------
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
				$(this).html(value);
			}
		});
	}
	function setYqValueAll(value){ //设置页签加载状态 0未加载 1已加载
		$("#yqAndZt option").each(function(){
			$(this).html(value);
		});
		$("input[id^='a_activePage']").each(function(){
			$(this).attr("value","0");
		});
	}
	function showOrHideYlQitaxxbq(smallId,state){ //显示隐藏 TD 
		$("td[id^='"+smallId+"']").each(function(){
			$(this)[0].style.display=''+state;
		});
	}
	function changeLableTitle(smallId,content){ //设置lable内容 
		$("label[id^='"+smallId+"']").each(function(){
			$(this).html(content);
		});
	}
	
	function closeAllDiv(){ //关闭所有添加的页签
		$("#bafwht_detail").hide("slow");
		$("#pmt_detail").hide("slow");
		$("#bldsjksb_detail").hide("slow");
		$("#aqjcsb_detail").hide("slow"); 
		$("#baryxx_detail").hide("slow"); 
		$("#bwryxx_detail").hide("slow"); 
		$("#wgtzrxx_detail").hide("slow");
		$("#yxyycs_detail").hide("slow");
	}
</script>
<BODY>
<div id="qyxxClose"></div>

<input type="hidden" id="a_activePageTwo" value="0">
<input type="hidden" id="a_activePageThree" value="0">
<!-- 页面的页签及加载状态 -->
<select id="yqAndZt" style="DISPLAY:none">
<option value='qyxx'>0</option>
<option value='abxx'>0</option>
<option value='qtxx'>0</option>
</select>

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1"><label id="qyorcs_title"></label>
      信息新增</td>
      <td align="right" class="title1"><a href="#" onClick="$('#qyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
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
            		<tr><td><a href="#" onMouseDown="show_biaoqian('qyxx')" class="navfont" hidefocus="true"><label id="qyorcs_title"></label>信息</a></td></tr>
            		</table>
            	</td>
        		<td width="78" id="small_abxx1" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1">
            		<tr><td align="center"><a href="#" onMouseDown="show_biaoqian('abxx')" class="navfont" hidefocus="true">安保信息</a></td></tr>
        			</table>
        		</td>
        		<td width="78" id="small_xxqt1" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1">
            		<tr><td align="center" ><a href="#" onMouseDown="show_biaoqian('qtxx')" class="navfont" hidefocus="true">其他信息</a></td></tr>
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

	<div id="qyjbxxXiangxi" class="scrollbarface" style="overflow-y:auto;overflow-x:hidden;height:650;width:100%;"></div>
</td>
</tr>
</table>
<!-- 企业信息结束 -->

<!-- 安保信息开始 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="abxx"  height="520"  style="DISPLAY:none">
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
            		<tr><td><a  href="#" onMouseDown="show_biaoqian('qyxx')" class="navfont" hidefocus="true"><label id="qyorcs_title"></label>信息</a></td></tr>
            		</table>
            	</td>
        		<td width="78" id="small_abxx2" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav11" >
            		<tr><td align="center"><a href="#" onMouseDown="show_biaoqian('abxx')" class="navfont" hidefocus="true" >安保信息</a></td></tr>
        			</table>
        		</td>
        		<td width="78" id="small_xxqt2" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1" >
            		<tr><td align="center" ><a href="#" onMouseDown="show_biaoqian('qtxx')" class="navfont" hidefocus="true" >其他信息</a></td></tr>
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
			<span id="plant_abxx"></span>
		</td></tr>
	</table>
</td>
</tr>
</table>
<!-- 安保信息结束 -->

<!-- 其他信息开始 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="qtxx" height="520" style="DISPLAY:none">
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
            		<tr><td><a  href="#" onMouseDown="show_biaoqian('qyxx')" class="navfont" hidefocus="true"><label id="qyorcs_title"></label>信息</a></td></tr>
            		</table>
            	</td>
        		<td width="78" id="small_abxx3" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1" >
            		<tr><td align="center"><a href="#" onMouseDown="show_biaoqian('abxx')" class="navfont" hidefocus="true" >安保信息</a></td></tr>
        			</table>
        		</td>
        		<td width="78" id="small_xxqt3" style="display:none">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav11" >
            		<tr><td align="center" ><a href="#" onMouseDown="show_biaoqian('qtxx')" class="navfont" hidefocus="true" >其他信息</a></td></tr>
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
			<span id="plant_qtxx"></span>
		</td>
		</tr>
	</table>
</td>
</tr>
</table>
<!-- 其他信息结束 -->

<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td>
    <a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='qyjbxx_setAdd();'>保存</a></td>
  </tr>
</table>
 </BODY>
</HTML>