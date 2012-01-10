<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv("bwryxx_detail");
	$("#cx_qyid").val(qyjbxx_dataid);
	$("#baoCunTitle").val($("#BwryxxListData").html());
	setParams("cx_");
	setPageList_bwryxx(1,"publicsystem/querylistByQy_bwryxx.action");
}); 
	
function setPageList_bwryxx(pageno,url){	
	$("#BwryxxListData").html($("#baoCunTitle").val());
	var mygrid1 = $("#BwryxxListTable").ingrid({ 
					tableid:"bwryxxIngridTable",
					url: url,	
					height: 60,
					ingridPageWidth : 998,
                    ingridPageParams:sXML,
					pageNumber: pageno,
					onRowSelect:function(tr){
						setDetailQuery_bwryxx($(tr).attr('rowindex')-1);
					},
					sorting:false,
					paging:false,
					isPlayResultNull:false,
					hideColIndex:[5,6,7,8,9,10,11,12,13],
					colWidths: ["17%","15%","22%","34%","12%","0%","0%","0%","0%","0%","0%","0%","0%","0%"]									
				});				
}	

function setDetailQuery_bwryxx(trIndex){
	setWidthSome("bwryxx_detail","700");
	$("#bwryxx_detail").empty().load("basic/publicsystem/BwryxxDetail.jsp",function(){
		updatediv_bwryxx($("#bwryxxIngridTable").find("tbody").find("tr:nth("+trIndex+")"));
	}).show("slow");
	upAllPage("bwryxx_detail");
}
</script>
	<input type="hidden" id="cx_qyid" />
	<input type="hidden" id="baoCunTitle" />
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
 	<tr>
    	<td style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;保卫人员信息</td>
   	</tr>
</table>
<div id="bwryxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;display:none">
</div>	

<div id="BwryxxListData" style="width:100%;">
	<table id="BwryxxListTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">保卫人员姓名</th>
	     	<th name="l_gmsfhm">保卫人员身份证号</th>
	     	<th name="l_hjdxzqh">户籍地省市县</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_sgrq">上岗日期</th>
	     	
	     	<th name="l_hjdxzqhdm">户籍地行政区划代码</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrsj">录入时间</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_zt">人员状态</th>
	     	<th name="l_lzrq">离职日期</th>
	     	<th name="l_lzyy">离职原因</th>
	    </tr>
	  </thead>
	</table>	
</div>