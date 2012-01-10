<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		pageUrl="basicsystem/querylist_sjbdqxx.action";
		divnid="SjbdqxxData";
		tableid="SjbdqxxTable";
		addUrl="basicsystem/insert_sjbdqxx.action";
		addHtml="basic/basicsystem/SjbdqxxAdd.jsp";
		addWidth="600";
		delUrl="basicsystem/delete_sjbdqxx.action";
		delid="d_sjbdqxxid";
		modHtml="basic/basicsystem/SjbdqxxModify.jsp";
		modUrl="basicsystem/modify_sjbdqxx.action";
		modWidth="600";
		detailHtml="basic/basicsystem/SjbdqxxDetail.jsp";
		detailid="sjbdqxx_detail";
		detailUrl="basicsystem/query_sjbdqxx.action";
		detailWidth="600";
		loadPage(divnid);
		daggleDiv(detailid);
		
		$("#p_djrq").attr("readonly","true").datepicker();
		$("#p_djrqt").attr("readonly","true").datepicker();
	});
	
	$("#p_pp").attr("readonly","true").click(function(){ //品牌
		getDict_item("p_pp","","dm_sjpp");
	});
	$('#p_ajlb').attr("readonly","true").click(function(){ //案件类别
		//getDict_item("p_ajlb","p_ajlbbm","dm_ajlb(gb)");
		getDict_item("p_ajlb","p_ajlbbm","dm_ajlx");
	});
	$('#p_ladq').attr("readonly","true").click(function(){ //立案地区
		getDict_item("p_ladq","p_ladqbm","dm_xzqh");
	});
	
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			var mygrid1 = $("#"+tableid).ingrid({
				url: url,
				pageNumber: pageno,
				ingridPageParams:sXML,
				height: pageHeight-253,
				colWidths: ["20%","12%","14%","10%","13%","11%","12%","8%"]
			});
		}
	}	
	function manVerify(){
		if (!checkControlValue("p_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("p_ys","String",1,60,null,0,"颜色"))
			return false;
		if (!checkControlValue("p_sjch","String",1,30,null,0,"手机串号"))
			return false;
		if (!checkControlValue("p_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("p_lxr","String",1,100,null,0,"联系人"))
			return false;
		return true;
	}
	
	function gaojichaxun_sjbdq(){
		gaojichaxun("156",detailid);
	}
</script>
<head>
<body>
<input type="hidden" id="d_sjbdqxxid">

<input type="hidden" id="p_ajlbbm">
<input type="hidden" id="p_ladqbm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr>
    <td class="queryfont">手机被盗抢信息查询</td>
	</tr>
	<tr>
		<td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td width="6%" class="pagedistd">品牌</td>
				<td class="pagetd"><input type="text" id="p_pp" class="inputstyle3" style="width:130px"></td>
				<td width="6%" class="pagedistd">型号</td>
				<td class="pagetd"><input type="text" id="p_xh" class="inputstyle3" style="width:130px"></td>
				<td width="6%" class="pagedistd">颜色</td>
				<td class="pagetd"><input type="text" id="p_ys" class="inputstyle3" style="width:130px"></td>
				<td width="6%" class="pagedistd">手机串号</td>
				<td class="pagetd"><input type="text" id="p_sjch" class="inputstyle3" style="width:130px"></td>
				<td width="6%" class="pagedistd">登记人</td>
				<td class="pagetd"><input type="text" id="p_djr" class="inputstyle3" style="width:130px"></td>
			</tr>
			<tr>
				<td class="pagedistd">登记日期</td>
				<td class="pagetd"><input type="text" id="p_djrq" class="inputstyle3" style="width:130px"></td>
				<td class="pagedistd">至</td>
				<td class="pagetd"><input type="text" id="p_djrqt" class="inputstyle3" style="width:130px"></td>
				<td class="pagedistd">案件类别</td>
				<td class="pagetd"><input type="text" id="p_ajlb" class="inputstyle3" style="width:130px"></td>
				<td class="pagedistd">立案地区</td>
				<td class="pagetd"><input type="text" id="p_ladq" class="inputstyle3" style="width:130px"></td>
				<td class="pagedistd">联系人</td>
				<td class="pagetd"><input type="text" id="p_lxr" class="inputstyle3" style="width:130px"></td>
			</tr>
			<tr>
				<td colspan="10">
					<table width="186" border="0" align="right" cellpadding="0" cellspacing="0">
					<tr>
						<td><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
						<td><a href="#" class="submitlongbutton" onclick='gaojichaxun_sjbdq();'>高级查询</a></td>
						<td><a href="#" class="submitbutton" onclick='setAddPage();'>新增</a></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
    </td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="sjbdqxx_detail" class="page-layout" src="#" style="top:60px;"></div>

<div id="SjbdqxxData" style="width:100%;">
	<table id="SjbdqxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_sjch">手机串号</th>
	     	<th name="l_pp">品牌</th>
	     	<th name="l_xh">型号</th>
	     	<th name="l_ys">颜色</th>
	     	<th name="l_djrq">登记日期</th>
	     	<th name="l_lxr">联系人</th>
	     	<th name="l_ajlb">案件类别</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>