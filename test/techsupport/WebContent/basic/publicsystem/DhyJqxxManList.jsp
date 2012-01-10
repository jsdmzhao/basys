<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../public/user-info.jsp" %>
<script type="text/javascript">
	var tzJqxxHeights = 150;
	var tzJqxxWidths = pageWidth-16;
	$(document).ready(function(){
		var tzJqxxHeight = setNull($("#tzJqxxHeight").attr("value"));
		if(tzJqxxHeight!=''){
			tzJqxxHeights = tzJqxxHeight;
		}
		var tzJqxxWidth = setNull($("#tzJqxxWidth").attr("value"));
		if(tzJqxxWidth!=''){
			tzJqxxWidths = tzJqxxWidth;
		}
		$("#bjxxb_detail").hide();
		pageUrl="basicsystem/querylistByDhyIndex_bjxxb.action";
		divnid="BjxxbData";
		tableid="BjxxbTable";
		delid="d_bjgzid";
		detailHtml="basic/basicsystem/BjxxbDetail.jsp";
		detailid="bjxxb_detail";
		detailUrl="basicsystem/query_bjxxb.action";
		detailWidth="800";
		//2011-1-19于光利（代孙旭）修改
		$("#p_usertype").val(user_type);
		$("#p_gxdwbm").val("<%=trimEvenDepartCode%>");
		$("#p_gxdwlevel").val("<%=departlevel%>");
		
		loadPage("BjxxbData");
		setPageList(1);
		daggleDiv("bjxxb_detail");
	});
  

	function setPageList(pageno,url){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({
			url: url,	
			height: tzJqxxHeights*1,
			pageNumber: pageno,
			ingridPageWidth : tzJqxxWidths*1,
			ingridPageParams: sXML,
			isPlayResultNull: false,
			sorting: false,
			onRowSelect: function(tr, selected){ },		
			colWidths: ["10%","26%","16%","20%","28%"]
		});
	}
	////报警详细信息
	function setdeailxx(id){
		var temp=$("#BjxxbData").find("tr[id='"+id+"']").find("input[name='lx"+id+"']").val();
        $("#current_recordBjlx").attr("value",temp.split('_')[0]); //保存本记录的报警类型
        dataid=id;
        $("#m_bjxxid").attr("value",dataid);
        setWidth("bjxxb_detail","800");
	    setUrl("bjxxb_detail","basic/basicsystem/BjxxDetail.jsp"); 
	    sFlag="false";
		bindDocument("bjxxb_detail");
	}
	
</script>
<html>
	<body>
	<input type="hidden" id="p_usertype" value="">
	<input type="hidden" id="p_gxdwbm" value="">
	<input type="hidden" id="p_gxdwlevel" value="">
	<input type="hidden" id="m_bjxxid" value="">
	<input type="hidden" id="current_recordBjlx" value="">
	<%-- 当前选择的记录的报警类型，用来给子div用 --%>
	<input type="hidden" id="current_bjxxid" value="">
	<%-- 当前选择的记录的报警信息ID，用来给子div用 --%>
	<input type="hidden" id="m_bjxxid" value="">
	<%-- 当前选择的记录的报警信息ID，用来给子div用 --%>
	<div id="BjxxbData" style="width: 100%;">
		<table id="BjxxbTable" width="100%">
		<thead>
			<tr>
			<th name="l_xm"> 姓名 </th>
			<th name="l_ssqymc"> 所属企业 </th>
			<th name="l_gxdwmc"> 管辖单位 </th>
			<th name="l_bjsj"> 报警时间 </th>
			<th name=""> 操作 </th>
			</tr>
		</thead>
		</table>
	</div>
	<div id="bjxxb_detail" src="#" class="page-layout" style="top: 40px; left: 160px;"></div>
</body>
</html>