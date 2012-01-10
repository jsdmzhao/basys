<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
    var cyrylsxx_dataid="";
	var cyrylsxx_tables = "";
    var cyrylsxx_pageUrl="publicsystem/querylistGadLS_qyryxx.action";
	var cyrylsxx_divnid="CyrylsxxData";
	var cyrylsxx_tableid="CyrylsxxTable";
    var cyrylsxx_detailHtml="basic/publicsystem/QyrylsxxDetail-gn-gzth.jsp";
	var cyrylsxx_detailid="cyrylsxx_detail";
	var cyrylsxx_detailWidth="800";
$(document).ready(function() {
    $("#q_ryid").attr("value",dataid);

	cyrylsxx_loadPage(cyrylsxx_divnid);
	
	$("#q_bcsj").attr("readonly","true");
	$("#q_bcsj").datepicker();
	$("#q_bcsjt").attr("readonly","true");
	$("#q_bcsjt").datepicker();
	 
	daggleDiv(cyrylsxx_detailid);
}); 

function cyrylsxx_setXqInfo(id){
		cyrylsxx_dataid=id;
		setWidth(cyrylsxx_detailid,cyrylsxx_detailWidth);
		setUrl(cyrylsxx_detailid,cyrylsxx_detailHtml);
		bindDocument(cyrylsxx_detailid);
}

function cyrylsxx_loadPage(divpageid){
		cyrylsxx_tables=$("#"+divpageid).html();
		$("#"+cyrylsxx_detailid).hide(); 	
		cyrylsxx_setPageList(1,'#');
	}
	
	function cyrylsxx_setList(pageno,url){	
		$("#"+cyrylsxx_divnid).html(cyrylsxx_tables);	
		createXML("q_");
		if (url==null || url=="undefined"){
			url=cyrylsxx_pageUrl;
		}
		return url;
	}
	
function cyrylsxx_setPageList(pageno,url){	
		url=cyrylsxx_setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+cyrylsxx_tableid).ingrid({ 
										ingridPageParams:sXML,
										url: url,	
										ingridPageWidth: 950,
										height: pageHeight-260,
										pageNumber: pageno,
										onRowSelect: function(tr, selected){
										},
										colWidths: ["10%","14%","14%","6%","14%","12%","10%","12%","8%"]										
									});				
}	
	
</script>

<body>
<input type="hidden" id="q_ryid" value="">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr><td align="left" class="title1">国内从业人员变更历史</td>
	<td align="right"><a href="#" id="closeDiv" onclick='$("#cyryxx_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>	

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
	<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
		<tr>
			<td valign="top" class="tdbg">
				<table width="100%" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="10%" class="pagedistd">
							变更日期
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle"  id="q_bcsj" value="">
						</td>
						<td width="10%" class="pagedistd">
							至
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle"  id="q_bcsjt" value="">
						</td>
						<td class="pagetd">
							<table width="60" border="0" align="right" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="28px">
										<a href="#" class="searchbutton" id="querys"
											onClick="cyrylsxx_setPageList(1);">查询</a>
									</td>
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
	<div id="cyrylsxx_detail" class="page-layout" src="#"
		style="top: 20px; left: 160px; width: 500px;">
	</div>

	<div id="CyrylsxxData" style="width: 100%;">
		<table id="CyrylsxxTable" width="100%">
			<thead>
				<tr>
					<th name="l_xm">
						姓名
					</th>
					<th name="l_zjhm">
						公民身份证号码
					</th>
					<th name="l_cyrybh">
						从业人员编号
					</th>
					<th name="l_xb">
						性别
					</th>
					<th name="l_qymc">
						企业名称
					</th>
					<th name="l_gwmc">
						岗位类别
					</th>
					<th name="l_bcsj">
						变更日期
					</th>
					<th name="l_cyryzt">
						从业人员状态
					</th>
					<th name="">
						操作
					</th>
				</tr>
			</thead>

		</table>
	</div>
</body>