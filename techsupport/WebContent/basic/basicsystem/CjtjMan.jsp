<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
var stats_detailidTopOffset;
var stats_detailidLeftOffset;

$(document).ready(function() {

    tabletitle = "";
	geteExcelHead("CjtjData");
	//ExcelURL
	excelUrl="basicsystem/getExcelCreate_cjtj.action";
    
	pageUrl="basicsystem/querylist_cjtj.action";
	divnid="CjtjData";
	tableid="CjtjTable";
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
	loadPage("CjtjData");
	$("#stats_detail").hide();
	$("#"+tableid).ingrid({ 
							url: "#",	
							height: pageHeight-225,
							pageNumber: 0,
							colWidths: ["20%","20%","20%","20%","20%"]									
						});
	

	// 添加日期	
	$("#p_bjsj1").datepicker(true);
	$("#p_bjsj2").datepicker(true);
	initTJDate();
	$("#p_bjsj1").attr("value",tomorrowDate+" 00:00:00");
	$("#p_bjsj2").attr("value",currentDate+" 23:59:59");
	
	// 添加公安机关树
	$("#s_gxdwmc").click(function(){getGxdwTree("s_gxdwmc","p_gxdwbm_full","p_gxdwbm","p_gxdwlevel",null,null,null,"p_isleaf");});
	
	// 添加只读属性
	$("#p_bjsj1").attr("readonly","true");
	$("#p_bjsj2").attr("readonly","true");
	$("#s_gxdwmc").attr("readonly","true");
	
	daggleDiv("stats_detail");
	$("#p_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框
	if($("#p_hylbdm").find("option").length<=2){
		$("#p_hylbdm").setValue($("#p_hylbdm").find("option:nth(1)").val());
		$("#p_hylbdm").setAttr("readonly",true);
	}
}); 

function query(){
	if (manVerify()) {
		findList("basicsystem/removeSession_cjtj.action");
	}
}
	
function setPageList(pageno,url){

	// 点击查询时就保存开始时间和结束时间
	$("#t_bjsj1").attr("value",$("#p_bjsj1").attr("value"));
	$("#t_bjsj2").attr("value",$("#p_bjsj2").attr("value"));
	// 点击查询时就保存公安机关的代码全长，为了统计中排除所选单位的记录
	$("#t_gxdwbm_full").attr("value",$("#p_gxdwbm_full").attr("value"));
	$("#t_state").val("cjtj");
	$("#t_gxdwlevel").val($("#p_gxdwlevel").val());
	$("#t_hylbdm").val($("#p_hylbdm").val());
	$("#t_isleaf").val($("#p_isleaf").val());
	
	if(url!='#')
	if (manVerify()){
		url=setList(pageno,url);
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
											var hfs = $(tr).find("td").eq(3).text(); // 获得当前行回复数
											$(tr).find("td").eq(3).html("<a href='#' class='hyperlink' onClick=hfs('"+gxdwbm+"');>"+hfs+"</a>"); // 嵌入html
											
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
										colWidths: ["20%","20%","20%","20%","20%"]									
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
	$("#t_sfpj").attr("value","1");
			
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

function hfs(gxdwbm){
	cleanCondition();
	$("#t_gxdwbm").attr("value",gxdwbm);
	$("#t_jqztdm").attr("value","2");
	
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
	$("#t_jqztdm").attr("value","");
}

function manVerify(){
	if (!checkControlValue("p_bjsj1","Datetime",null,null,null,1,"开始时间"))
		return false;
	if (!checkControlValue("p_bjsj2","Datetime",null,null,null,1,"结束时间"))
		return false;
	if (!checkDateEarlier("p_bjsj1","开始时间","p_bjsj2","结束时间","DATETIME"))
		return false;
	if (!checkControlValue("s_gxdwmc","String",1,60,null,1,"治安管辖机构"))
		return false;
	return true;
}

  //Excel输出
  function setExportExcel(){
	  if(daochuNum==1){
			if (manVerify()){
				//报表标题
				var bbmc="处警统计";
				//报表请求
				setExcel("cjtjQyexcel",bbmc);
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
<input type="hidden" id="t_jqztdm">
<input type="hidden" id="t_gxdwbm_full">
<input type="hidden" id="t_sfpj">
<input type="hidden" id="p_isleaf">
<input type="hidden" id="t_state">
<input type="hidden" id="t_gxdwlevel">
<input type="hidden" id="t_hylbdm">
<input type="hidden" id="t_isleaf">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">处警统计查询</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="8%" class="red">开始日期</td>
					<td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_bjsj1" value=""></td>
					<td width="8%" class="red">结束日期</td>
					<td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_bjsj2" value=""></td>
					<td width="10%" class="red">治安管辖机构</td>
					<td width="15%" class="pagetd">
						<input type="hidden" id="p_gxdwbm" value="">
						<input type="hidden" id="p_gxdwlevel" value="">
						<input type="hidden" id="p_gxdwbm_full" value="">
						<input type="text" class="inputstyle" id="s_gxdwmc" value="">
					</td>
					<td width="8%" class="pagedistd">行业类别</td>
					<td width="17%" class="pagetd">
						<select type="select" id="p_hylbdm">
							<option></option>
						</select>
					</td>
				</tr>
				<tr>
         		    <td align="right" colspan="8">
         		    <table width="150" border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="50%"><a href="#" class="submitbutton" onClick="query();">统计</a></td>
                        <td width="50%" ><a href="#" class="submitlongbutton" onClick="setExportExcel();" id="cjtjQyexcel">导出统计结果</a></td>
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

<div id="CjtjData" style="width:100%;">
	<table id="CjtjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_departname" datatype="string" sumflag="0">治安管辖机构</th>
	     	<th name="l_jjzs"  datatype="number" sumflag="1">接警总数</th>
	     	<th name="l_yxbjs"  datatype="number" sumflag="1">有效报警数</th>
	     	<th name="l_hfs"  datatype="number" sumflag="1">回复数</th>
	     	<th name="l_hfl" datatype="string" sumflag="0">回复率</th>
	   </tr>
	  </thead>
	</table>	
</div>
</body>