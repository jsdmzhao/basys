<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	
		pageUrl="publicsystem/querylist_qyjcxx.action";
		divnid="QyjcxxData";
		tableid="QyjcxxTable";
		addUrl="publicsystem/insert_qyjcxx.action";
		addHtml="basic/publicsystem/QyjcxxAdd-Bzh.jsp";
		addWidth="600";
		delUrl="publicsystem/delete_qyjcxx.action";
		delid="d_qycfid";
		modHtml="basic/publicsystem/QyjcxxModify-Bzh.jsp";
		modUrl="publicsystem/modify_qyjcxx.action";
		modWidth="600";
		detailHtml="basic/publicsystem/QyjcxxDetail-Bzh.jsp";
		detailid="qyjcxx_detail";
		detailUrl="publicsystem/query_qyjcxx.action";
		detailWidth="600";
		loadPage(divnid);
		$("#p_qyjcrq").attr("readonly","true");
		$("#p_qyjcrq").datepicker();
		$("#p_qyjcrqzhi").attr("readonly","true");
		$("#p_qyjcrqzhi").datepicker();
		$("#p_hylbdm").selectBoxhylb();//行业类别	
		
		daggleDiv(detailid);
		$("#p_jcmxlbdm").selectBox({code:"dm_qycflb(jxy)"});//明细 处罚
		$("#p_pzjg").click(function(){ //管辖单位
			getGxdw("p_pzjg","p_pzjgdm");
		});
	}); 
	
	function setPageList(pageno,url){	
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-253,
										pageNumber: pageno,
										ingridPageParams: sXML,
										hideColIndex:[2],
										colWidths: ["20%","20%","0%","15%","15%","10%","10%","10%"]									
									});
	}
	 //企业筛选框
	$("#p_qymc").click(function(){
		dataid=$('#p_hylbdm').val();
		getTy_item("p_qymc","","p_qyid");
	});
</script>

<body>
	
	<input type="hidden" id="d_qycfid">
		<input type="hidden" id="p_qyid">
		<input type="hidden" id="p_cflbbm" value="1">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">企业处罚查询</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="15%" class="pagedistd">行业类别</td>
					<td width="18%" class="pagetd"><select id="p_hylbdm"/></td>
					<td width="15%" class="pagedistd" id="td_qymc">场所名称</td>
					<td width="19%" class="pagetd"><input type="text" class="inputstyle" id="p_qymc" readonly="readonly"></td>
					<td width="15%" class="pagedistd">批准机构</td>
					<td width="18%" class="pagetd"><input type="hidden"class="inputstyle" id="p_pzjgdm">
					<input type="text"class="inputstyle" id="p_pzjg"></td>
				</tr>
				<tr>
				    <td class="pagedistd" id="jcmclb-1">行政处罚类别</td>
					<td class="pagetd"><select id="p_jcmxlbdm"><option></option></select></td>
					<td class="pagedistd" id="jcdjxh-1">处罚登记序号</td>
					<td class="pagetd"><input type="text"class="inputstyle" id="p_cfdjxh"></td>
    				<td class="pagedistd" id="xzjcpwh-1">行政处罚批准文号</td>
					<td class="pagetd"><input type="text"class="inputstyle" id="p_xzcfpzwh"></td>
				</tr>
    			<tr>
					<td class="pagedistd" id="qyjcrq-1">处罚日期</td>
					<td class="pagetd"><input type="text"class="inputstyle" id="p_qyjcrq">
					</td>
					<td class="pagedistd">至</td>
					<td class="pagetd"><input type="text"class="inputstyle" id="p_qyjcrqzhi"></td>
					<td colspan="2">
	    				<table  border="0" align="right"  cellpadding="1"  cellspacing="0">
	    		    	<tr>
	    		    	  <td width="62"><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
	    		    	  <td width="62"><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="qyjcxx_detail" class="page-layout" src="#"
		style="top:80px; left:160px;">
</div>	

<div id="QyjcxxData" style="width:100%;">
	<table id="QyjcxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qymc">场所名称</th>
	     	<th name="l_cfdjxh">处罚登记序号</th>
	     	<th name="l_cflb">奖惩类别</th>
	     	<th name="l_jcmxlb">行政处罚类别</th>
	     	<th name="l_pzjg">批准机构</th>
	     	<th name="l_qyjcrq">处罚日期</th>
	     	<th name="l_bjcr">被处罚人</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
