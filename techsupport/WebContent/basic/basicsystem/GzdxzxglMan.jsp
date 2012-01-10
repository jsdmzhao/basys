<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_gzdx.action";
	divnid="GzdxData";
	tableid="GzdxTable";
	addUrl="basicsystem/insert_gzdx.action";
	addHtml="basic/basicsystem/GzdxAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_gzdx.action";
	delid="d_gzdxid";
	modHtml="basic/basicsystem/GzdxzxDetail.jsp";
	modUrl="basicsystem/modify_gzdx.action";
	modWidth="500";
	detailHtml="basic/basicsystem/GzdxDetail.jsp";
	detailid="gzdx_detail";
	detailUrl="basicsystem/query_gzdx.action";
	detailWidth="500";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true").datepicker();
		$("#p_csrq2").attr("readonly","true").datepicker();
		$("#p_tbrq").attr("readonly","true").datepicker();
		$("#p_zxrq").attr("readonly","true").datepicker();
		$("#p_xb").selectBox({code:"dm_xb"});
		  $("#p_minzu").click(function(){
			getDict_item("p_minzu","p_mzdm","dm_mz");
			});
		 $("#p_hjdxzqh").click(function(){
			getDict_item("p_hjdxzqh","p_hjdxzqhdm","dm_xzqh");
			});
	$("#p_hylbdm").selectBoxhylb();//行业类别
	daggleDiv("gzdx_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										ingridPageParams:sXML,
										height: pageHeight - 280,
										pageNumber: pageno,
										hideColIndex : [8],
										changeHref : function(table) {
											var tdObj;
											table.find("tr").find("td:nth(8)").each(
													function() {
														tdObj = $(this);
														if (tdObj.text() != "1") {
															tdObj.parent().find("td:last")
																	.find("a").remove();
														}
													});
										},
										colWidths: ["8%","15%","5%","11%","6%","11%","15%","21%","0%","8%"]
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;

		var kssj = $("#p_csrq").val();
		var jssj = $("#p_csrq2").val();
		if(!compare_now(kssj)){
			jAlert("出生日期不能大于今天！","验证信息",null,"p_csrq");
			return false;
		}
		if(!compare_now(jssj)){
			jAlert("出生日期不能大于今天！","验证信息",null,"p_csrq2");
			return false;
		}
		if(!checkTwoDateEarlier(kssj,jssj)){
			jAlert("出生日期范围不正确！","验证信息",null,"p_csrq");
			return false;
		}
		
		if (!checkControlValue("p_hjdxzqh","String",1,200,null,0,"户籍地区"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
			if($("#p_checkbox").attr("checked")){
			$("#p_tyCheck").val("1");
		}else{
			$("#p_tyCheck").val("0");
		}
		return true;
	}
</script>
<input type="hidden" id="d_gzdxid" />
<!-- 由于3个菜单走的同一个action，为区别后面的操作列，加入一个参数 -->
<input type="hidden" id="p_flag" value="cancel">
<input type="hidden" id="p_tyCheck">
<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
	<tr>
		<td class="queryfont">
			关注对象注销
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
						<input type="text" class="inputstyle" id="p_xm" />
						<label>
							<input name="checkbox" type="checkbox" id="p_checkbox"
								style="width: 20px">
							同音
						</label>
					</td>
					<td width="10%" class="pagedistd">
						性别
					</td>
					<td width="23%" class="pagetd">
						<select id="p_xb">
							<option></option>
						</select>
					</td>
					<td width="10%" class="pagedistd">
						证件号码
					</td>
					<td width="23%" class="pagetd">
						<input type="text" class="inputstyle" id="p_zjhm" />
					</td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">
						出生日期
					</td>
					<td width="23%" class="pagetd">
						<input type="text" class="inputstyle1" id="p_csrq" />
						至
						<input type="text" class="inputstyle1" id="p_csrq2" />
					</td>
					<td width="10%" class="pagedistd">
						民族
					</td>
					<td width="23%" class="pagetd">
						<input type="text" class="inputstyle" id="p_minzu" readonly />
						<input type="hidden" id="p_mzdm" />
					</td>
					<td width="10%" class="pagedistd">
						户籍地区
					</td>
					<td width="23%" class="pagetd">
						<input type="text" class="inputstyle" id="p_hjdxzqh" readonly />
						<input type="hidden" id="p_hjdxzqhdm" />
					</td>
				</tr>
				<tr>
					<td class="pagedistd">
						行业类别
					</td>
					<td class="pagetd">
						<select id="p_hylbdm"></select>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<table width="20" border="0" align="right" cellpadding="2"
							cellspacing="0">
							<tr>
								<td width="29%">
									<a href="#" class="searchbutton" id="querys"
										onClick="setPageList(1);">查询</a>
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
<div id="gzdx_detail" class="page-layout" src="#"
	style="top: 180px; left: 160px;">
</div>

<div id="GzdxData" style="width: 100%;">
	<table id="GzdxTable" width="100%">
		<thead>
			<tr>
				<th name="l_xm">
					姓名
				</th>
				<th name="l_zjhm">
					证件号码
				</th>
				<th name="l_xb">
					性别
				</th>
				<th name="l_csrq">
					出生日期
				</th>
				<th name="l_minzu">
					民族
				</th>
				<th name="l_whcd">
					文化程度
				</th>
				<th name="l_hjdxzqh">
					户籍地行政区划
				</th>
				<th name="l_hjdxz">
					户籍地详址
				</th>
				<th name="">
				</th>
				<th name="">
					操作
				</th>
			</tr>
		</thead>
	</table>
</div>