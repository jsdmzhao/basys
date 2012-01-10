<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	loadPageStats("BjxxbDataStats");
	
	daggleDiv("bjxxbStats_detail");
}); 

function detail(id){
	$("#current_recordBjlx").attr("value",$("#BjxxbDataStats").find("tr[id='"+id+"']").find("td").eq(5).text()); //保存本记录的报警类型
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth("bjxxbStats_detail","800");

	$("#bjxxbStats_detail").empty();
	$("#bjxxbStats_detail").load("basic/basicsystem/BjxxDetailStats.jsp");
	$("#bjxxbStats_detail").show("slow"); 
}

function loadPageStats(divpageid){
	tableStats=$("#"+divpageid).html();
	$("#bjxxbStats_detail").hide(); 	
	setPageListStats(1);
}

function setListStats(pageno,url){
	$("#BjxxbDataStats").html(tableStats);
	createXML("t_");
	if (url==null || url=="undefined"){
		url="basicsystem/querylistStats_bjxxb.action";
	}
	return url;
}

function setPageListStats(pageno,url){
	if (manVerifyStats()){
		url=setListStats(pageno,url);
		var mygrid2 = $("#BjxxbTableStats").ingrid({ 
										url: url,	
										height: 250,
										prefix:"t_",
										ingridPageWidth:900,
										ingridPageParams:sXML,
										barTopOffset:-(stats_detailidTopOffset+1),
										barLeftOffset:-(stats_detailidLeftOffset+1),
										onRowSelect: function(tr, selected){
											detail($(tr).attr("id")); 	
											rowselect=$(tr).attr('rowindex');
										},
										pageNumber: pageno,
										isDaoChu: true,	//是否导出标示，false为不导出，true为导出
										excelUrl:"basicsystem/getExcelCreateBjxxStats_bjxxb.action",
										biaoTouMc:"报警信息",	//导出表头名称
										colWidths: ["11%","14%","11%","11%","11%","11%","11%","11%","11%"]									
									});				
		}
}

function manVerifyStats(){
	return true;
}
</script>


<html>
<input type="hidden" id="current_recordBjlx" value="">
<input type="hidden" id="m_bjxxid">
	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td align="left" class="title1">
			报警信息查询
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv" onclick='$("#stats_detail").hideAndRemove("show");'class="close"></a>
		</td>
	</tr>
	<tr><td height="3"></td></tr>
</table>

		<div id="bjxxbStats_detail"  class="page-layout" src="#"
		style="top: -50px; left: 160px; width: 500px;">
		</div>

		<div id="BjxxbDataStats" style="width: 100%;">
			<table id="BjxxbTableStats" width="100%">
				<thead>
					<tr>
						<th name="l_xm" datatype="string" sumflag="0">
							姓名
						</th>
						<th name="l_gmsfhm" datatype="string" sumflag="0">
							公民身份号码
						</th>
						<th name="l_ssqymc" datatype="string" sumflag="0">
							所属企业名称
						</th>
						<th name="l_gxdwmc" datatype="string" sumflag="0">
							治安管辖机构
						</th>
						<th name="l_bjsj" datatype="string" sumflag="0">
							报警时间
						</th>
						<th name="l_bjlx" datatype="string" sumflag="0">
							报警类型
						</th>
						<th name="l_sfyxbj" datatype="string" sumflag="0">
							警情是否有效
						</th>
						<th name="l_jqzt" datatype="string" sumflag="0">
							警情状态
						</th>
						<th name="l_chjjg" datatype="string" sumflag="0">
							处警结果
						</th>
					</tr>
				</thead>
			</table>
		</div>
	</body>
</html>