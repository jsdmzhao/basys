<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
String stCJDFlag = "";// 省厅采集点标志
if((departCode.indexOf("CJD")!=-1) && (departCode.length()==5)){// 省厅采集点
    stCJDFlag = "1";
}else{
    stCJDFlag = "0";
}
%>
<html>
<head>
<script type="text/javascript">
	var chakanFlag = 0;
	var yjswlb_pageUrl="icksystem/queryYjswlblist_wldj.action";
	var yjswlb_divnid="yjswlb_tabledata";
	var yjswlb_tableid="yjswlb_table";
	var yjswlb_detailHtml="basic/icksystem/WldjDetail.jsp";
	var yjswlb_detailid="wldj_detail";
	var yjswlb_detailUrl="icksystem/query_wldj.action";
	var yjswlb_detailWidth="600";
	var yjswlb_tables="";
	var stCJDFlag = '<%=stCJDFlag%>';
	var colWidths0 = ["13%","9%","11%","11%","9%","10%","9%","11%","0%","13%"];
	var colWidths1 = ["16%","11%","12%","12%","11%","11%","11%","12%","0%","0%"];
	var tableWidth;
	var hideCol0 = [8];
	var hideCol1 = [8,9];
	var hideCol;
	if(stCJDFlag=='0'){
	    tableWidth = colWidths0;
	    hideCol = hideCol0;
	}else{
	    tableWidth = colWidths1;
	    hideCol = hideCol1;
	}
	
	$(document).ready(function() {
	    if(typeof(cjdtjrq)!='undefined'){
            $("#p_jssj").val(cjdtjrq);
        }
		
		addUrl="icksystem/insert_wldj.action";
		addHtml="basic/icksystem/WldjAdd.jsp";
		addWidth="500";
		delUrl="icksystem/delete_wldj.action";
		delid="d_wlid";
		modHtml="basic/icksystem/WldjModify.jsp";
		modUrl="icksystem/modify_wldj.action";
		modWidth="500";
		detailUrl="icksystem/query_wldj.action";
		yjswlb_loadPage("yjswlb_tabledata");
		$("#wldj_print").hide();
			
		daggleDiv("wldj_detail");
		daggleDiv("wldj_print");
	}); 
	
	function yjswlb_loadPage(divpageid){
        yjswlb_tables=$("#"+divpageid).html();
	    $("#"+yjswlb_detailid).hide(); 	
	    yjswlb_setPageList(1);
	}
	function yjswlb_setList(pageno,url){	
		$("#"+yjswlb_divnid).html(yjswlb_tables);	
		createXML("p_");
		if (url==null || url=="undefined"){
			url=yjswlb_pageUrl;
		}
		return url;
	}
	function yjswlb_setPageList(pageno,url){	
			url=yjswlb_setList(pageno,url);
			var mygrid1 = $("#"+yjswlb_tableid).ingrid({
											url: url,	
											ingridPageWidth: pageWidth-120,
											ingridPageParams:sXML,
											height: pageHeight-275,
											pageNumber: pageno,
											hideColIndex: hideCol,
											colWidths: tableWidth
										});				
	}	
	var wldj_timeFlag = true;
	function getObject(obj){ //操作
		sFlag="false";
		if(wldj_timeFlag){
			wldj_timeFlag = false;
			var content = $(obj).text();
			var thisId = $(obj).attr("id").split("_")[1];
			if(content=='查看'){
				wldj_setCk(thisId);
			}
			if(content=='接收'){
				wldj_setJs(thisId);
			}
			if(content=='反馈'){
				wldj_setFk(thisId);
			}
			if(content=='打印'){
				wldj_print(thisId);
			}
			setTimeout(function(){wldj_timeFlag = true;},800);
		}
	}
	function setQuery(id,url){
	    $("#"+detailid).empty();
	    dataid=id;
	    setWidth(yjswlb_detailid,yjswlb_detailWidth);
	    setUrl(yjswlb_detailid,'basic/icksystem/WldjDetail.jsp');
	    bindDocument(yjswlb_detailid);
    }
	function wldj_setCk(id){ //查看
		sFlag="false";
		chakanFlag = 1;
		dataid = id;
		$("#"+yjswlb_detailid).css("width","900px");
	    $("#"+yjswlb_detailid).css("left","0px");
		setUrl('wldj_detail','basic/icksystem/WldjMan-fk.jsp');
		bindDocument(yjswlb_detailid);
	}
	function wldj_setJs(id){ //接收
		sFlag="false";
		dataid = id;
		$("#"+yjswlb_detailid).css("width","900px");
	    $("#"+yjswlb_detailid).css("left","0px");
		setUrl('wldj_detail','basic/icksystem/wljs.jsp');
	}
	function isCanJieShouBack(json){ //未用
		if (json.result!="success"){
			$("#wldj_detail").hide("show");
			jAlert(json.result,'提示信息');
		} else { //可以进行反馈
		}
	}
	function wldj_setFk(id){ //反馈
		sFlag="false";
		chakanFlag = 0;
		dataid = id;
		$("#"+yjswlb_detailid).css("width","900px");
	    $("#"+yjswlb_detailid).css("left","0px");
		setUrl('wldj_detail','basic/icksystem/WldjMan-fk.jsp');
		bindDocument(yjswlb_detailid);
	}
	function isCanFankuiBack(json){ //未用
		if (json.result!="success"){
			$("#wldj_detail").hide("show");
			jAlert(json.result,'提示信息');
		} else { //可以反馈
		}
	}
	function zjlxOnchange(){ //证件类型
		var bq_zjlx = $("#bq_zjlx").attr("value");
		$("#p_cyzjdm").attr("value",bq_zjlx);
	}
	function ztdmOnchange(){ //状态
		var bq_ztdm = $("#bq_ztdm").attr("value");
		$("#p_ztdm").attr("value",bq_ztdm);
	}
	function wldj_print(id){
		sFlag="false";
		dataid = $("#"+id).find("td").eq(0).text();
		//jAlert('物流批次传给下一个页面'+dataid);
		$("#wldj_print").css("width","900px");
	    $("#wldj_print").css("left","0px");
		setUrl('wldj_print','basic/icksystem/WldjShowPrint.jsp');
		bindDocument('wldj_print');
	}
	
</script>

</head>
<body>
<input type="hidden" id="d_wlid" value="">
<input type="hidden" id="p_cyzjdm" value="">
<input type="hidden" id="p_ztdm" value="">
<input type="hidden" id="p_jssj">
<div id="yjswlbClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">已接收物流包信息</td>
      <td align="right" class="title1"><a href="#" onclick="$('#yjswlbClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
<div id="wldj_detail" class="page-layout" src="#" style="top:-10px;">
</div>
<div id="wldj_print" class="page-layout" src="#" style="top:-30px;">
</div>	

<div id="yjswlb_tabledata" style="width:100%;">
	<table id="yjswlb_table" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_wlpc">物流批次</th>
	     	<th name="l_djr">登记人</th>
	     	<th name="l_zbsj">组包时间</th>
	     	<th name="l_fssj">发送时间</th>
	     	<th name="l_bnksl">包内卡数量</th>
	     	<th name="l_ztdm">状态</th>
	     	<th name="l_jsr">接收人</th>
	     	<th name="l_jssj">接收时间</th>
	     	<th name="l_fksj">反馈时间</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>