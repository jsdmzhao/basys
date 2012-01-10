<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		pageUrl="publicsystem/queryCxlist_baryxx.action";
		divnid="BaryxxcxData";
		tableid="BaryxxcxTable";
		addUrl="publicsystem/insert_baryxx.action";
		addHtml="basic/publicsystem/BaryxxCxAdd.jsp";
		addWidth="600";
		delUrl="publicsystem/delete_baryxx.action";
		delid="d_baryxxcxid";
		modHtml="basic/pubilcsystem/BaryxxCxModify.jsp";
		modUrl="publicsystem/modify_baryxx.action";
		modWidth="600";
		detailHtml="basic/publicsystem/BaryxxCxDetail.jsp";
		detailid="baryxxcx_detail";
		detailUrl="publicsystem/queryBary_baryxx.action";
		detailWidth="600";
		loadPage(divnid);
		daggleDiv(detailid);
		$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
		//<!--$("#p_qymc").click(function(){ //服务场所筛选框
	 	//	dataid=$('#q_hylbdm').val();
		//	getTy_item("p_qymc","p_qybm");
		//});-->
		$("#p_qymc").click(function(){ //服务场所筛选框
	 		dataid=$('#p_hylbdm').val();
			getTy_item("p_qymc","p_qybm");
		});
		$('#p_hjdxzqh').attr("readonly","true").click(function(){ //户籍地省市县
			getDict_item("p_hjdxzqh","p_hjdxzqhdm","dm_xzqh");
		});
		$("#p_zt").selectBox({code:"dm_ryzt"});
	});
	
	function setPageList(pageno,url){	
			url=setList(pageno,url);
			var mygrid1 = $("#"+tableid).ingrid({
				url: url,
				pageNumber: pageno,
				ingridPageParams:sXML,
				height: pageHeight-276,
				colWidths: ["15%","10%","10%","15%","20%","20%","10%"]
			});
	}	
	function bary_setDetail(){
		setParams("p_");
		jQuery.post(detailUrl,params,updatediv,"json");
	}
</script>
<head>
<body>
<input type="hidden" id="p_baryxxid"/>
<input type="hidden" id="p_qyid">



<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr>
    <td class="queryfont">保安人员信息查询</td>
	</tr>
	<tr>
		<td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td width="10%" class="pagedistd">行业类别</td>
				<td class="pagetd"><select type="select" id="p_hylbdm" style="width:230px"><option></option></select></td>
				<td   class="pagedistd">企业名称</td>
				<td class="pagetd" colspan="3"><input type="text" id="p_qymc" class="inputstyle3" style="width:525px" readonly/></td>
			</tr>
			<tr>
				<td width="6%" class="pagedistd">姓名</td>
				<td class="pagetd"><input type="text" id="p_xm" class="inputstyle"></td>
				<td width="6%" class="pagedistd">身份证号</td>
				<td class="pagetd"><input type="text" id="p_gmsfhm" class="inputstyle"/></td>
				<td width="6%" class="pagedistd">户籍地省市县</td>
				<td class="pagetd"><input  type="text" id="p_hjdxzqh" class="inputstyle" /></td>
			</tr>
			<tr>
				<td class="pagedistd">户籍地详址</td>
				<td class="pagetd" colspan="3"><input type="text" id="p_hjdxz" class="inputstyle3" style="width:395px"></td>
				<td class="pagedistd">人员状态</td>
				<td class="pagetd"><select  type="select" id="p_zt" style="width:233px"><option></option></select></td>
			</tr>
			<tr>
				<td colspan="6">
					<table width="120" border="0" align="right" cellpadding="0" cellspacing="0">
					<tr>
						<td><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
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
<div id="baryxxcx_detail" class="page-layout" src="#" style="top:60px;"></div>

<div id="BaryxxcxData" style="width:100%;">
	<table id="BaryxxcxTable" width="100%">
	  <thead>
	    <tr>   
	    	<th name="l_hylb">行业类别</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_xm">姓名</th>
	    	<th name="l_gmsfhm">身份证号</th>
	     	<th name="l_hjdxzqh">户籍地省市县</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_zt">人员状态</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>