<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	var selHylb; //当前行业类别
	$(document).ready(function() {
		bc_bottonMoveRight(); //按钮右对齐
		selHylb = "";
		$("#qyjbxxXiangxi").load("basic/publicsystem/QyjbxxXiangXiAdd.jsp", {}, function(){
			$("#a_barq").datepicker();
			frdbzjOnchange();
			zajbOnchange();
			hylbOnchange();
		});
	});
	
	function hylbOnchange(){
		if(selHylb=='E01'||selHylb=='E02'){ //上一次选择二手机或者二手车 将其变化置回来
			esjAndEscBackChange();
		}
		if(selHylb=='F01'||selHylb=='F02'){ //上一次选择 汽车出租或者汽车租赁 将其变化置回来
			qcczAndQczlBackChange();
		}
		if(selHylb=='J'){ //上一次选择 娱乐业 将其变化置回来
			ylyBackChange();
		}
		if(selHylb=='C'){ //上一次选择 机修业 将其变化置回来
			jxyBackChange();
		}
		$("#qyjbxxXiangxi").height(490);
		var key = $("#bq_hylb").attr("value");
		var val = $("#bq_hylb").attr("title");
		$("#a_hylbdm").attr("value",key);
		$("#a_hylb").attr("value",val);
		selHylb = key;
		
		//行业变化 需要清空的属性 开始
		showOrHideYlQitaxxbq('small_','none');
		showOrHideYlQitaxxbq('yly_csffl_','none');
		showOrHideYlQitaxxbq('zdskb_','none');
		showOrHideYlQitaxxbq('tyrq_','none');
		showOrHideYlQitaxxbq('cksl_','none');
		showOrHideYlQitaxxbq('bxbjsl_','none');
		showOrHideYlQitaxxbq('zjzt_','none');
		showOrHideYlQitaxxbq('djrq_','none');
		$("#bq_ylcsfl").selectBox({clear:"1",width:"115px"});
		$("#bq_yyzt").selectBox({clear:"1",width:"115px"});
		showOrHideYlQitaxxbqTr('thxx_','none'); //特行信息
		showOrHideYlQitaxxbqTr('xfxx_','none'); //消防信息
		showOrHideYlQitaxxbqLabel('bafzr_','none'); //保安负责人
		showOrHideYlQitaxxbqLabel('bars_','none'); //保安人数
		showOrHideYlQitaxxbq('jgpxrs_','none'); //经岗位培训人数
		showOrHideYlQitaxxbq('bagsyj_','none'); //保安公司已经
		changeLableTitle('fzrgmsfhm_title','负责人公民身份号码');
		changeLableTitle('swdjfzjg_title','税务登记证发证机关');
		changeLableTitle('ylfwcs_title','营业');
		//行业变化 需要清空的属性 结束
		
		if(selHylb=='J'){ //娱乐业初始
			changeLableTitle('qyorcs_','场所');
			setTdClassName('jyxk_','red');
			setTdClassName('thxk_','red');
			setTdClassName('xf_','red');
		} else {
			changeLableTitle('qyorcs_','企业');
			setTdClassName('jyxk_','pagedistd1');
			setTdClassName('thxk_','pagedistd1');
			setTdClassName('xf_','pagedistd1');
		}
		
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
		setTdClassName('jjlx_title','pagedistd1'); //pagedistd1	red
		setTdClassName('bafzr_title','pagedistd1'); //pagedistd1	red
		showOrHideYlQitaxxbq('small_yl_qt','block');
		showOrHideYlQitaxxbq('yly_csffl_','block');
		showOrHideYlQitaxxbq('zdskb_','block');
		showOrHideYlQitaxxbq('cksl_','block');
		showOrHideYlQitaxxbq('bxbjsl_','block');
		alert();
		ylyChange();
		$("#qyjbxxXiangxi").height(440);
		$("#bq_ylcsfl").selectBox({code:"dm_ylcsfl",width:"115px"});
		$("#bq_yyzt").selectBox({code:"dm_yyzt(bzhylcs)",width:"115px"});
		$("#bq_zajb").selectBox({code:"dm_zajb(bzhylcs)",width:"115px"});
		csflOnchange();
		yyztOnchange();
		$("#hdrs_title").html("核定消费者数量");
		$("#bz_title").html("娱乐项目内容");
	}
	function jxyInit(){ //机修
		changeLableTitle('qybianOrDaima_','代码');
		changeLableTitle('zczj_','注册资本（万元）');
		changeLableTitle('jyfw_','经营范围');
		changeLableTitle('jymj_','占地面积（㎡）');
		changeLableTitle('jydz_','企业地址');
		changeLableTitle('babh_','特行备案编号');
		changeLableTitle('jyxkzbh_','经营许可证号');
		changeLableTitle('jyxkzfzjg_','经营许可证<br>发证机构名称');
		changeLableTitle('gxdw_title','治安管理机构');
		setTdClassName('jyxk_bh_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxk_fzjg_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxkzfzjgdm_title','pagedistd1'); //pagedistd1	red
		setTdClassName('jjlx_title','red'); //pagedistd1	red
		setTdClassName('bafzr_title','red'); //pagedistd1	red
		jxylChange();
		$("#qyjbxxXiangxi").height(340);
		$("#bq_ylcsfl").selectBox({code:"dm_jxqyfl",width:"115px"});
		//$("#bq_yyzt").selectBox({code:"dm_yyzt(ylcs)",width:"115px"});
		//$("#bq_zajb").selectBox({code:"dm_cszajb",width:"115px"});
		csflOnchange();
		//yyztOnchange();
		$("#hdrs_title").html("核定人数");
		$("#bz_title").html("备注");
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
		setTdClassName('jyxk_bh_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxk_fzjg_','pagedistd1'); //pagedistd1	red
		setTdClassName('jjlx_title','red'); //pagedistd1	red
		setTdClassName('bafzr_title','red'); //pagedistd1	red
		$("#qyjbxxXiangxi").height(340);
		esjAndEscChange();
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(esc)",width:"115px"});
		//$("#bq_yyzt").selectBox({code:"dm_yyzt(ylcs)",width:"115px"});
		//$("#bq_zajb").selectBox({code:"dm_cszajb",width:"115px"});
		$("#a_sfazsxt").selectBox({code:"dm_bez",width:"115px"});
		csflOnchange();
		//yyztOnchange();
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
		setTdClassName('jyxk_bh_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxk_fzjg_','pagedistd1'); //pagedistd1	red
		setTdClassName('jjlx_title','red'); //pagedistd1	red
		setTdClassName('bafzr_title','red'); //pagedistd1	red
		$("#qyjbxxXiangxi").height(340);
		esjAndEscChange();
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(esj)",width:"115px"});
		//$("#bq_yyzt").selectBox({code:"dm_yyzt(ylcs)",width:"115px"});
		//$("#bq_zajb").selectBox({code:"dm_cszajb",width:"115px"});
		$("#a_sfazsxt").selectBox({code:"dm_bez",width:"115px"});
		csflOnchange();
		//yyztOnchange();
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
		setTdClassName('jjlx_title','pagedistd1'); //pagedistd1	red
		setTdClassName('bafzr_title','pagedistd1'); //pagedistd1	red
		$("#qyjbxxXiangxi").height(490);
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(fjjs)",width:"115px"});
		$("#bq_yyzt").selectBox({code:"dm_yyzt(ylcs)",width:"115px"});
		$("#bq_zajb").selectBox({code:"dm_cszajb",width:"115px"});
		csflOnchange();
		yyztOnchange();
		showOrHideYlQitaxxbqTr('thxx_','block'); //特行信息
		showOrHideYlQitaxxbqTr('xfxx_','block'); //消防信息
		showOrHideYlQitaxxbqLabel('bafzr_','block'); //保安负责人
		showOrHideYlQitaxxbqLabel('bars_','block'); //保安人数
		showOrHideYlQitaxxbq('jgpxrs_','block'); //经岗位培训人数
		showOrHideYlQitaxxbq('bagsyj_','block'); //保安公司已经
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
		changeLableTitle('swdjfzjg_title','税务登记证<br>发证机构名称');
		setTdClassName('jyxk_bh_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxk_fzjg_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxkzfzjgdm_title','pagedistd1'); //pagedistd1	red
		setTdClassName('jjlx_title','red'); //pagedistd1	red
		setTdClassName('bafzr_title','red'); //pagedistd1	red
		qcczAndQczlChange();
		$("#qyjbxxXiangxi").height(340);
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(czc)",width:"115px"});
		//$("#bq_yyzt").selectBox({code:"dm_yyzt(ylcs)",width:"115px"});
		//$("#bq_zajb").selectBox({code:"dm_cszajb",width:"115px"});
		csflOnchange();
		//yyztOnchange();
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
		setTdClassName('jyxk_bh_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxk_fzjg_','pagedistd1'); //pagedistd1	red
		setTdClassName('jyxkzfzjgdm_title','pagedistd1'); //pagedistd1	red
		setTdClassName('jjlx_title','red'); //pagedistd1	red
		setTdClassName('bafzr_title','red'); //pagedistd1	red
		qcczAndQczlChange();
		$("#qyjbxxXiangxi").height(340);
		$("#bq_ylcsfl").selectBox({code:"dm_qyzfl(qczl)",width:"115px"});
		//$("#bq_yyzt").selectBox({code:"dm_yyzt(ylcs)",width:"115px"});
		//$("#bq_zajb").selectBox({code:"dm_cszajb",width:"115px"});
		csflOnchange();
		//yyztOnchange();
		$("#hdrs_title").html("核定人数");
		$("#bz_title").html("备注");
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
		}
		if(yqid=='yl_qtxx'&&yqstate==0){
			$("#div_Wgtzrxx").empty();
			$("#div_Wgtzrxx").load("basic/publicsystem/WgtzrxxMan.jsp");
		}
	}
	
	function csfflInit(queryKey){
		if(selHylb=="J"){ //娱乐业专属
			$("#bq_csffl").selectCheckBox({code:"dm_ylcsfl",query:queryKey,
			valueId:"a_qyfflbm",textId:"a_qyfflmc",width:364});
		}
	}
	function csflOnchange(){ //企业分类
		//先清空企业副分类
		$("#a_qyfflbm").attr("value","");
		$("#a_qyfflmc").attr("value","");
		
		var csflkey = $("#bq_ylcsfl").attr("value");
		var csflval = $("#bq_ylcsfl").attr("title");
		$("#a_qyzflbm").attr("value",csflkey);
		$("#a_qyzflmc").attr("value",csflval);
		csfflInit(csflkey); //显示企业副分类
		showOrHideByCsflAndJjlx();
	}
	$("#a_qyfflbm").bind("propertychange",function(){ //企业副分类
		showOrHideByCsflAndJjlx();
	});
	$("#a_jjlxbm").bind("propertychange",function(){ //经济类型
		showOrHideByCsflAndJjlx();
	});
	function showOrHideByCsflAndJjlx(){ //用 企业分类-经济类型 判断显示与隐藏
		if(selHylb=="J"){ //娱乐业专属
			var theSecPageTag = 0;
			var jjlx = $("#a_jjlxbm").attr("value");
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
	function zajbOnchange(){ //治安等级
		var zajbkey = $("#bq_zajb").attr("value");
		var zajbval = $("#bq_zajb").attr("title");
		$("#a_zabdm").attr("value",zajbkey);
		$("#a_zajbmc").attr("value",zajbval);
	}
	function frdbzjOnchange(){ //法人证件类型
		var frdbzjlbkey = $("#bq_frdbzj").attr("value");
		var frdbzjlbval = $("#bq_frdbzj").attr("title");
		$("#a_frdbzjlb").attr("value",frdbzjlbval);
	}
	function yyztOnchange(){ // 营业状态
		var yyztkey = $("#bq_yyzt").attr("value");
		var yyztval = $("#bq_yyzt").attr("title");
		$("#a_yyztdm").attr("value",yyztkey);
		$("#a_yyztmc").attr("value",yyztval);
		if(selHylb=="J"&&yyztkey=="12"){ //娱乐业专属
			showOrHideYlQitaxxbq('tyrq_','block');
		} else {
			showOrHideYlQitaxxbq('tyrq_','none');
		}
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
	function setTdClassName(smallId,className){ //设置TD样式
		$("td[id^='"+smallId+"']").each(function(){
			$(this).removeClass('pagedistd1').removeClass('red').addClass(className);
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
	function setBackRemoveObj(removeid){ //加制定的TD显示
		$("td[id^='"+removeid+"']").each(function(){
			$(this).show();
		});
	}
	function ylyChange(){
		setRemoveObj('bafzr_');
		setRemoveObj('bars_');
		setTrAppendTd('ryxxTr1','cksl_');
		setTrAppendTd('ryxxTr1','bxbjsl_');
	}
	function ylyBackChange(){
		setBackRemoveObj('bafzr_');
		setBackRemoveObj('bars_');
		setTrAppendTd('ryxxTr2','cksl_');
		setTrAppendTd('ryxxTr2','bxbjsl_');
	}
	function esjAndEscChange(){ //二手机和二手机的变化
		qcczAndQczlChange();
		setTrAppendTd('qyjbxxTr4','sfazsxt_');
		setTrAppendTd('qyjbxxTr4','azsxtsl_');
	}
	function esjAndEscBackChange(){ //将二手机和二手机的变化置回来（二手机和二手车的变化一样）
		qcczAndQczlBackChange();
		setTrAppendTd('qyjbxxTrLinshi2','sfazsxt_');
		setTrAppendTd('qyjbxxTrLinshi2','azsxtsl_');
	}
	function qcczAndQczlChange(){ //汽车出租和企业租赁变化
		setTdClassName('babh_title','pagedistd1'); //pagedistd1	red
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
	function qcczAndQczlBackChange(){ //将汽车出租和企业租赁的变化置回来（二手机和二手车的变化一样）
		setTdClassName('babh_title','pagedistd1'); //pagedistd1	red
		setBackRemoveObj('jyxk_qsrq');
		setBackRemoveObj('jyxk_jzrq');
		setBackRemoveObj('jyfwjy_');
		setBackRemoveObj('yyzt_');
		setBackRemoveObj('yysj_');
		setBackRemoveObj('barq_');
		setBackRemoveObj('zadj_');
		setBackRemoveObj('yyzzqsrq_');
		setBackRemoveObj('yyzzjzrq_');
		setBackRemoveObj('swdjqsrq_');
		setBackRemoveObj('swdjjzrq_');
		setBackRemoveObj('gdxx_');
		setBackRemoveObj('ryjqt_');
		setBackRemoveObj('zrs_');
		setBackRemoveObj('hdrs_');
		if(selHylb=="F01"||selHylb=="F02"){ //汽车出租、租赁
			setTrAppendTd('qyjbxxTr4','jymj_');
			setTrAppendTd('qyjbxxTr4','yyzt_');
		}
		setTrAppendTd('qyjbxxTr4','jydz_');
		setTrAppendTd('qyjbxxTr9','swdjzbh_');
		setTrAppendTd('qyjbxxTr9','swdjfzjg_');
		setTrAppendTd('ryxxTr3','bz_');
		setTrAppendTd('qyjbxxTrLinshi1','thbajg_');
		setTrAppendTd('ryxxTr1','bafzr_');
		setTrAppendTd('qyjbxxTrLinshi1','jyxkzfzjgdm_');
		setTrAppendTd('qyjbxxTrLinshi2','bwbmdh_');
	}
	function jxylChange(){ //机修业变化
		setTdClassName('babh_title','pagedistd1'); //pagedistd1	red
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
	function jxyBackChange(){ //将机修业的变化置回来
		setTdClassName('babh_title','pagedistd1'); //pagedistd1	red
		setBackRemoveObj('jyfwjy_');
		setBackRemoveObj('yyzt_');
		setBackRemoveObj('yysj_');
		setBackRemoveObj('barq_');
		setBackRemoveObj('zadj_');
		setBackRemoveObj('yyzzqsrq_');
		setBackRemoveObj('yyzzjzrq_');
		setBackRemoveObj('swdjqsrq_');
		setBackRemoveObj('swdjjzrq_');
		setBackRemoveObj('gdxx_');
		setBackRemoveObj('ryjqt_');
		setBackRemoveObj('zrs_');
		setBackRemoveObj('hdrs_');
		setBackRemoveObj('frlxfs_');
		setBackRemoveObj('jyxk_qsrq');
		setBackRemoveObj('jyxk_jzrq');
		setTrAppendTd('qyjbxxTr4','jydz_');
		setTrAppendTd('qyjbxxTr9','swdjzbh_');
		setTrAppendTd('qyjbxxTr9','swdjfzjg_');
		setTrAppendTd('qyjbxxTr10','jyxk_bh');
		setTrAppendTd('qyjbxxTr10','jyxk_fzjg');
		setTrAppendTd('ryxxTr3','bz_');
		setTrAppendTd('qyjbxxTrLinshi1','thbajg_');
		setTrAppendTd('ryxxTr1','bafzr_');
		setTrAppendTd('qyjbxxTrLinshi2','bwbmdh_');
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

<div id="qyxxClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1"><label id="qyorcs_title"></label>信息新增</td>
      <td align="right" class="title1"><a href="#" onclick="$('#qyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="yl_qt"  height="520"  style="DISPLAY:none">
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="yl_qtxx" height="520" style="DISPLAY:none">
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
<!-- 娱乐 其他信息结束 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td>
    <a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='qyjbxx_setAdd();'>保存</a></td>
  </tr>
</table>
 </BODY>
</HTML>