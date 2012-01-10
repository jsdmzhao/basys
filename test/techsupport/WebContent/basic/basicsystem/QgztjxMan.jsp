<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
$(document).ready(function() {
	searchLongUrl="basicsystem/queryForExport_qgztjx.action";  //超长参数后台Action对应url
	pageUrl="basicsystem/querylist_qgztjx.action";
	divnid="QgztjxData";
	tableid="QgztjxTable";
	addUrl="basicsystem/insert_qgztjx.action";
	addHtml="basic/basicsystem/QgztjxAdd.jsp";
	addWidth="600";
	delUrl="basicsystem/delete_qgztjx.action";
	delid="d_qgztjxid";
	modHtml="basic/basicsystem/QgztjxModify.jsp";
	modUrl="basicsystem/modify_qgztjx.action";
	modWidth="600";
	detailHtml="basic/basicsystem/QgztjxDetail.jsp";
	detailid="qgztjx_detail";
	detailUrl="basicsystem/query_qgztjx.action";
	detailWidth="650";
	//*****导出Excel 
	tabletitle = "";	 
	geteExcelHead("QgztjxData");	
	excelUrl="basicsystem/getExcelCreate_qgztjx.action";
	
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		$("#p_djrq").attr("readonly","true");
		$("#p_djrq").datepicker();
		
	 $("#p_xb").selectBox({code:"dm_xb"});
	 $("#p_hjd").click(function(){
			getDict_item("p_hjd","p_hjdbm","dm_xzqh");
			});
	 
	daggleDiv("qgztjx_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										changeHref:function(table){//若表格无数据，则点击导出不起作用
										//alert($(table).find("tr").length);
											$("#gnlkexcel").unbind("click");
											if($(table).find("tr").length==0){
													daochuNum = 0;
												}else{
													daochuNum = 1;
												}	
										},
										ingridPageParams:sXML,
										height: pageHeight -260,
										pageNumber: pageno,
										colWidths: ["12.5%","12.5%","12.5%","12.5%","12.5%","12.5%","12.5%","12.5%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_tbbh","String",1,30,null,0,"通报编号"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_gmsfhm","String",1,20,null,0,"身份号码"))
			return false;
		if (!checkControlValue("p_hjd","String",1,300,null,0,"户籍地"))
			return false;
		if (!checkControlValue("p_djrq","Date",null,null,null,0,"登记日期"))
			return false;
		return true;
	}
	//导出Excel
function setExportExcel(){	
  	//alert(daochuNum);
  	if(daochuNum==1){
		if (manVerify()){
  			setSearchLong(); //传全部参数将查询结果放入json，对应后台Action方法中将结果集放入session，用于处理超长参数的数据导出
  		}
  	}else{
  		alert('无查询结果不能导出！');
  	}		
}


//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
function searchLongBack(json){  
		//报表标题
			var bbmc="全国在逃人员信息";
		//报表请求
			//setExcel("gnlkexcel",bbmc);	
			setExcelLong("qgztjxexcel",bbmc);	
}

//是否同音设置
$("#p_sfty").click(function(){

	if($(this).attr("checked"))
		$(this).val(1);
	else
		$(this).val(0);
});

</script>
<html>
	<body>

		<input type="hidden" id="d_qgztjxid" value="">
		<input type="hidden" id="p_hjdbm" value="">
		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">
					全国在逃人员查询
				</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td width="10%" class="pagedistd">
								姓名
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_xm" value="">
								<label>
									<input name="checkbox" type="checkbox" id="p_sfty">
									同音
								</label>
							</td>
							<td width="10%" class="pagedistd">
								身份证号
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_gmsfhm" value="">
							</td>
							<td width="10%" class="pagedistd">
								性别
							</td>
							<td width="23%" class="pagetd">
								<select id="p_xb">
									<option></option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="10%" class="pagedistd">
								户籍地
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_hjd" value="" readonly>
							</td>
							<td width="10%" class="pagedistd">
								登记日期
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_djrq" value="">
							</td>
							<td width="10%" class="pagedistd">
								通报编号
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_tbbh" value="">
							</td>
						</tr>
						<tr>
							<td colspan="6">
								<table width="180" border="0" align="right" cellpadding="2"
									cellspacing="0">
									<tr>
										<td width="25%">
											&nbsp;
											<!-- <a href="#" class="submitbutton" onclick=''>高级查询</a> -->
										</td>
										<td width="25%">
											<a href="#" class="searchbutton" id="querys"
												onClick="setPageList(1);">查询</a>
										</td>
										<td width="25%">
											<a href="#" class="exceldcbutton"
												onclick='setExportExcel();'>导出</a>
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
		<div id="qgztjx_detail" class="page-layout" src="#"
			style="top:180px; left:160px;">
		</div>

		<div id="QgztjxData" style="width:100%;">
			<table id="QgztjxTable" width="100%">
				<thead>
					<tr>
						<th name="l_xm" datatype="string" sumflag="0">
							姓名
						</th>
						<th name="l_gmsfhm" datatype="string" sumflag="0">
							公民身份号码
						</th>
						<th name="l_csrq" datatype="date" sumflag="0">
							出生日期
						</th>
						<th name="l_xb" datatype="string" sumflag="0">
							性别
						</th>
						<th name="l_hjd" datatype="string" sumflag="0">
							户籍地
						</th>
						<th name="l_hjxxdz" datatype="string" sumflag="0">
							户籍详细地址
						</th>
						<th name="l_djrq" datatype="date" sumflag="0">
							登记日期
						</th>
						<th name="l_tbbh" datatype="string" sumflag="0">
							通报编号
						</th>
					</tr>
				</thead>
			</table>
		</div>



	</body>
</html>
