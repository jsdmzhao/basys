<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
var stats_detailidTopOffset;
var stats_detailidLeftOffset;

$(document).ready(function() {

	pageUrl="basicsystem/querylist_ztxx.action";
	divnid="ZtxxData";
	tableid="ZtxxTable";
	addUrl="basicsystem/insert_bjxxb.action";
	addHtml="basic/basicsystem/BjxxbAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bjxxb.action";
	delid="d_bjgzid";
	modHtml="basic/basicsystem/BjxxbModify.jsp";
	modUrl="basicsystem/modify_bjxxb.action";
	modWidth="500";
	detailHtml="basic/basicsystem/BjxxbDetail.jsp";
	detailid="stats_detail";
	detailUrl="basicsystem/query_bjxxb.action";
	detailWidth="300";
	//Excel表头
	tabletitle=$("#ZtxxData").find("table:first").find("thead:first").html();
	//ExcelURL
	excelUrl="basicsystem/getExcelCreate_ztxx.action";
	tables=$("#ZtxxData").html();
	$("#stats_detail").hide();
	$("#"+tableid).ingrid({ 
							url: "#",	
							height: pageHeight-225,
							pageNumber: 0,
							colWidths: ["14%","8%","9%","8%","8%","12%","12%","13%","8%","8%"]									
						});
	

	// 添加日期	
	$("#p_bjsj1").datepicker(true);
	$("#p_bjsj2").datepicker(true);
	
	// 添加公安机关树
	$("#s_gxdwmc").click(function(){getGxdwTree("s_gxdwmc","p_gxdwbm_full","p_gxdwbm","p_gxdwlevel",null,null,null,"p_isleaf");});
	
	// 添加只读属性
	$("#p_bjsj1").attr("readonly","true");
	$("#p_bjsj2").attr("readonly","true");
	$("#s_gxdwmc").attr("readonly","true");
	initTJDate();
	$("#p_bjsj1").attr("value",tomorrowDate+" 00:00:00");
	$("#p_bjsj2").attr("value",currentDate+" 23:59:59");
	daggleDiv("stats_detail");
	$("#p_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框
	if($("#p_hylbdm").find("option").length<=2){
		$("#p_hylbdm").setValue($("#p_hylbdm").find("option:nth(1)").val());
		$("#p_hylbdm").setAttr("readonly",true);
	}	
}); 

function query(){
	if (manVerify()) {
		findList("basicsystem/removeSession_ztxx.action");
	}
}

function setPageList(pageno,url){
	// 点击查询时就保存开始时间和结束时间
	$("#t_bjsj1").attr("value",$("#p_bjsj1").attr("value"));
	$("#t_bjsj2").attr("value",$("#p_bjsj2").attr("value"));
	// 点击查询时就保存公安机关的代码全长，为了统计中排除所选单位的记录
	$("#t_gxdwbm_full").attr("value",$("#p_gxdwbm_full").attr("value"));
	$("#t_state").val("zttj");
	$("#t_gxdwlevel").val($("#p_gxdwlevel").val());
	$("#t_hylbdm").val($("#p_hylbdm").val());
	$("#t_isleaf").val($("#p_isleaf").val());
	
	if(url!='#')
	if (manVerify()){
		url=setList(pageno,url);
		//setParams("p_"); // 重新生成查询参数，把isQuery从1设为0
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: pageHeight-225,
										onRowSelect: null,
										pageNumber: pageno,
										ingridPageParams: sXML,
			                            sumFlag: true,
										onTdSelect: function(tr){
											var gxdwbm = $(tr).attr("id"); // 获得当前行公安机关编码
											
											var jjzs = $(tr).find("td").eq(1).text(); // 获得当前行接警总数
											$(tr).find("td").eq(1).html("<a href='#' class='hyperlink' onClick=jjzs('"+gxdwbm+"');>"+jjzs+"</a>"); // 嵌入html
											var yxbjs = $(tr).find("td").eq(2).text(); // 获得当前行有效报警总
											$(tr).find("td").eq(2).html("<a href='#' class='hyperlink' onClick=yxbjs('"+gxdwbm+"');>"+yxbjs+"</a>"); // 嵌入html
											var zts = $(tr).find("td").eq(3).text(); // 获得当前行抓逃数
											$(tr).find("td").eq(3).html("<a href='#' class='hyperlink' onClick=zts('"+gxdwbm+"');>"+zts+"</a>"); // 嵌入html
											var lws = $(tr).find("td").eq(4).text(); // 获得当前行漏网数
											$(tr).find("td").eq(4).html("<a href='#' class='hyperlink' onClick=lws('"+gxdwbm+"');>"+lws+"</a>"); // 嵌入html
											var zhqgztrs = $(tr).find("td").eq(5).text(); // 获得当前行抓获全国在逃人数
											$(tr).find("td").eq(5).html("<a href='#' class='hyperlink' onClick=zhqgztrs('"+gxdwbm+"');>"+zhqgztrs+"</a>"); // 嵌入html
											var zhbdbkrs = $(tr).find("td").eq(6).text(); // 获得当前行抓获本地布控人数
											$(tr).find("td").eq(6).html("<a href='#' class='hyperlink' onClick=zhbdbkrs('"+gxdwbm+"');>"+zhbdbkrs+"</a>"); // 嵌入html
											var bdbkydzhs = $(tr).find("td").eq(7).text(); // 获得当前行本地布控异地抓获数
											$(tr).find("td").eq(7).html("<a href='#' class='hyperlink' onClick=bdbkydzhs('"+gxdwbm+"');>"+bdbkydzhs+"</a>"); // 嵌入html
										},
										changeHref:function(table){//若表格无数据，则点击导出不起作用
											//alert($(table).find("tr").length);
												$("#gnlkexcel").unbind("click");
												if($(table).find("tr").length==0){
														daochuNum = 0;
													}else{
														daochuNum = 1;
													}	
										},
										colWidths: ["14%","8%","9%","8%","8%","12%","12%","13%","8%","8%"]				
									});				
		}
}

function adjustPosition(){
	var stats_detailidOffset = $("#stats_detail").offset();
	stats_detailidTopOffset=stats_detailidOffset.top;
	stats_detailidLeftOffset=stats_detailidOffset.left;
}

function jjzs(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	
	//alert($("#t_bjsj1").attr("value"));
	//alert($("#t_bjsj2").attr("value"));
	//alert($("#t_gxdwbm").attr("value"));
	
	sFlag="false";
	setWidth("stats_detail","900");
	
	$("#stats_detail").empty();
	$("#stats_detail").load("basic/basicsystem/BjxxbManStats.jsp");
	$("#stats_detail").show("slow");
	bindDocument("stats_detail");
	
	adjustPosition();
}

function yxbjs(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	$("#t_sfyxbjdm").attr("value","1");
	
	sFlag="false";
	setWidth("stats_detail","900");
	
	$("#stats_detail").empty();
	$("#stats_detail").load("basic/basicsystem/BjxxbManStats.jsp");
	$("#stats_detail").show("slow");
	bindDocument("stats_detail");
	
	adjustPosition(); 
}

function zts(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	$("#t_cjjgdm").attr("value","1");
	
	sFlag="false";
	setWidth("stats_detail","900");
	
	$("#stats_detail").empty();
	$("#stats_detail").load("basic/basicsystem/BjxxbManStats.jsp");
	$("#stats_detail").show("slow");
	bindDocument("stats_detail");
	
	adjustPosition(); 
}

function lws(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	$("#t_cjjgdm").attr("value","2");
	
	sFlag="false";
	setWidth("stats_detail","900");
	
	$("#stats_detail").empty();
	$("#stats_detail").load("basic/basicsystem/BjxxbManStats.jsp");
	$("#stats_detail").show("slow");
	bindDocument("stats_detail");
	
	adjustPosition(); 
}

function zhqgztrs(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	$("#t_cjjgdm").attr("value","1");
	$("#t_bjlxdm").attr("value","1");
	
	sFlag="false";
	setWidth("stats_detail","900");
	
	$("#stats_detail").empty();
	$("#stats_detail").load("basic/basicsystem/BjxxbManStats.jsp");
	$("#stats_detail").show("slow");
	bindDocument("stats_detail");
	
	adjustPosition(); 
}

function zhbdbkrs(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	$("#t_cjjgdm").attr("value","1");
	$("#t_bjlxdm").attr("value","2");
	
	sFlag="false";
	setWidth("stats_detail","900");
	
	$("#stats_detail").empty();
	$("#stats_detail").load("basic/basicsystem/BjxxbManStats.jsp");
	$("#stats_detail").show("slow");
	bindDocument("stats_detail");
	
	adjustPosition(); 
}

function bdbkydzhs(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	$("#t_cjjgdm").attr("value","1");
	$("#t_bjlxdm").attr("value","3");
	
	sFlag="false";
	setWidth("stats_detail","900");
	
	$("#stats_detail").empty();
	$("#stats_detail").load("basic/basicsystem/BjxxbManStats.jsp");
	$("#stats_detail").show("slow");
	bindDocument("stats_detail");
	
	adjustPosition(); 
}

function cleanCondition(){
	$("#t_sfyxbjdm").attr("value","");
	$("#t_cjjgdm").attr("value","");
	$("#t_bjlxdm").attr("value","");
}

function manVerify(){
	if (!checkControlValue("p_bjsj1","Datetime",null,null,null,1,"开始时间"))
		return false;
	if (!checkControlValue("p_bjsj2","Datetime",null,null,null,1,"结束时间"))
		return false;
	if (!checkControlValue("s_gxdwmc","String",1,60,null,1,"治安管辖机构"))
		return false;
	if (!checkDateEarlier("p_bjsj1","开始时间","p_bjsj2","结束时间","DATETIME"))
		return false;
	return true;
}
//Excel输出
function setExportExcel(){
	if(daochuNum==1){
		if (manVerify()){
			//报表标题
			var bbmc="抓获信息统计";
			//报表请求
			setExcel("jyxxexcel",bbmc);
  		}
  	}else{
  		jAlert('无查询结果不能导出！',"提示信息");
  	}
}
</script>

<body>

<input type="hidden" id="t_bjsj1">
<input type="hidden" id="t_bjsj2">
<input type="hidden" id="t_gxdwbm">
<input type="hidden" id="t_sfyxbjdm">
<input type="hidden" id="t_cjjgdm">
<input type="hidden" id="t_bjlxdm">
<input type="hidden" id="t_gxdwbm_full">
<input type="hidden" id="p_isleaf">
<input type="hidden" id="t_state">
<input type="hidden" id="t_gxdwlevel">
<input type="hidden" id="t_hylbdm">
<input type="hidden" id="t_isleaf">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">抓获信息统计</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="8%" class="red">开始日期</td>
					<td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_bjsj1" value=""></td>
					<td width="8%" class="red">结束日期</td>
					<td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_bjsj2" value=""></td>
					<td width="8%" class="red">治安管辖机构</td>
					<td width="17%" class="pagetd">
						<input type="hidden" id="p_gxdwbm" value="">
						<input type="hidden" id="p_gxdwlevel" value="">
						<input type="hidden" id="p_gxdwbm_full" value="">
						<input type="text" class="inputstyle" id="s_gxdwmc" value="">
					</td>
					<td width="8%" class="pagedistd">
								行业类别
							</td>
							<td width="17%" class="pagetd">
								<select type="select" id="p_hylbdm">
									<option></option>
								</select>
							</td>
				</tr>
				<tr>
         		    <td colspan="8">
         		    <table width="150" border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="50%"><a href="#" class="submitbutton" onClick="query();">统计</a></td>
                        <td width="50%" ><a href="#" class="submitlongbutton" onclick="setExportExcel();" id="jyxxexcel">导出统计结果</a></td>
                      </tr>
                    </table>
                   	</td>
				</tr>          
    	</table>
    </td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>

<div id="stats_detail"  class="page-layout" src="#"
		style="top: 80px; left: 160px; width: 500px;">
</div>
<!--Excel表头 
 	name domain的属性以l_开头；
 	datatyoe 数据类型 （字符 string,数字 number,日期 date）;
 	sumflag 0不合计，1合计-->
<div id="ZtxxData" style="width:100%;">
	<table id="ZtxxTable" width="100%">
	  <thead>
	    <tr>      
	     	<th name="l_departname" datatype="string" sumflag="0">治安管辖机构</th>
	     	<th name="l_bjzs" datatype="number" sumflag="1">报警总数</th>
	     	<th name="l_yxbjs" datatype="number" sumflag="1">有效报警数</th>
	     	<th name="l_zts" datatype="number" sumflag="1">抓逃数</th>
	     	<th name="l_lws" datatype="number" sumflag="1">漏网数</th>
	     	<th name="l_zhqgztrs" datatype="number" sumflag="1">抓获全国在逃人数</th>
	     	<th name="l_zhbdbkrs" datatype="number" sumflag="1">抓获本地布控人数</th>
	     	<th name="l_bdbkydzhs" datatype="number" sumflag="1">本地布控异地抓获数</th>
	     	<th name="l_ztl" datatype="string" sumflag="0">抓逃率</th>
	     	<th name="l_cjl" datatype="string" sumflag="0">出警率</th>
	  	</tr>      
	  </thead>
	</table>	
</div>
</body>