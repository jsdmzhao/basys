<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
    var wgcyrylsxx_dataid="";
	var wgcyrylsxx_tables = "";
    var wgcyrylsxx_pageUrl="publicsystem/querylistGadLs_publicwgcyryxx.action";
	var wgcyrylsxx_divnid="WgcyrylsxxData";
	var wgcyrylsxx_tableid="WgcyrylsxxTable";
    var wgcyrylsxx_detailHtml="basic/publicsystem/WgcyrylsxxDetail-jw-gzth.jsp";
	var wgcyrylsxx_detailid="wgcyrylsxx_detail";
	var wgcyrylsxx_detailWidth="800";
$(document).ready(function() {
    $("#q_ryid").attr("value",dataid);

	wgcyrylsxx_loadPage(wgcyrylsxx_divnid);
	
	$("#q_bcsj").attr("readonly","true");
	$("#q_bcsj").datepicker();
	$("#q_bcsjt").attr("readonly","true");
	$("#q_bcsjt").datepicker();
	 
	daggleDiv(wgcyrylsxx_detailid);
}); 

function wgcyrylsxx_setXqInfo(id){
		wgcyrylsxx_dataid=id;
		setWidth(wgcyrylsxx_detailid,wgcyrylsxx_detailWidth);
		setUrl(wgcyrylsxx_detailid,wgcyrylsxx_detailHtml);
		bindDocument(wgcyrylsxx_detailid);
}

function wgcyrylsxx_loadPage(divpageid){
		wgcyrylsxx_tables=$("#"+divpageid).html();
		$("#"+wgcyrylsxx_detailid).hide(); 	
		wgcyrylsxx_setPageList(1,'#');
	}
	
	function wgcyrylsxx_setList(pageno,url){	
		$("#"+wgcyrylsxx_divnid).html(wgcyrylsxx_tables);	
		createXML("q_");
		if (url==null || url=="undefined"){
			url=wgcyrylsxx_pageUrl;
		}
		return url;
	}
	
function wgcyrylsxx_setPageList(pageno,url){	
		url=wgcyrylsxx_setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+wgcyrylsxx_tableid).ingrid({ 
										ingridPageParams:sXML,
										url: url,	
										ingridPageWidth: 950,
										height: pageHeight-260,
										pageNumber: pageno,
										onRowSelect: function(tr, selected){
										},
										colWidths: ["10%","10%","16%","6%","8%","20%","10%","12%","8%"]										
									});				
}	
	
</script>

<body>
<input type="hidden" id="q_ryid" value="">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr><td align="left" class="title1">境外从业人员变更历史</td>
	<td align="right"><a href="#" id="closeDiv" onclick='$("#wgcyryxx_detail").hideAndRemove("show");'class="close"></a></td>
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
											onClick="wgcyrylsxx_setPageList(1);">查询</a>
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
	<div id="wgcyrylsxx_detail" class="page-layout" src="#"
		style="top: 20px; left: 160px; width: 500px;">
	</div>

	<div id="WgcyrylsxxData" style="width: 100%;">
		<table id="WgcyrylsxxTable" width="100%">
			<thead>
				<tr>
					<th name="l_xm">
						英文名/姓
					</th>
					<th name="l_zjhm">
						护照号码
					</th>
					<th name="l_cyrybh">
						从业人员编号
					</th>
					<th name="l_xb">
						性别
					</th>
					<th name="l_gj">
						国籍
					</th>
					<th name="l_qymc">
						企业名称
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