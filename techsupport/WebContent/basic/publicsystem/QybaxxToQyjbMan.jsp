<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var csbaxx_detailidTopOffset=0;
	var csbaxx_detailidLeftOffset=0;
	var csbaxx_tables="";
	var csbaxx_dataid="";
	var csbaxx_pageUrl="publicsystem/querylist_qybaxx.action";
	var csbaxx_divnid="CsbaxxListData";
	var csbaxx_tableid="CsbaxxTable";
	var csbaxx_detailHtml="CsbaxxDetail.jsp";
	var csbaxx_detailid="csbaxx_detail";
	var csbaxx_detailUrl="publicsystem/query_qybaxx.action";
	var csbaxx_detailWidth="900";
	newTableWidth="";
	var csbaxx_tjclHtml="basic/publicsystem/BaxxtjclMan-gn.jsp"; //提交材料信息
	var csbaxx_gncsbaAddWidth="900";
	var csbaxx_gncsbaModifyWidth="900";
	var csbaxx_gncsbaDetailHtml="basic/publicsystem/QybaxxDetail.jsp";
	var csbaxx_gncsbaDetailWidth="900";
	var csbaxx_gncsbaBbWidth="900";
	var dangQianHylbdm = "";
	var ylcsjbxx_detailUrl="publicsystem/query_qyjbxx.action";
	var ylcsjbxx_dataid = qyjbxx_dataid;
	$(document).ready(function() {
		if(qyjbxx_dataid.indexOf("qybm_")!=-1){
			$("#j_qybm").attr("value",qyjbxx_dataid.split("_")[1]);
		} else {
			$("#j_qyid").attr("value",qyjbxx_dataid);
		}
		csbaxx_loadPage(csbaxx_divnid);
		dangQianHylbdm = $("#p_hylbdm").val();
		if(dangQianHylbdm=="J"){
			$("#td_qybaxxglTitle").text("场所备案信息管理");
		}
		if(qyjbxx_requestType!='add'){ //非添加都请求
			csbaxx_setPageList(1);
		}
		if(qyjbxx_requestType=='detail'){ //详细信息不给添加按钮 ‘操作’隐藏
			document.getElementById('csbaxx_add').style.display='none';
		}
		daggleDiv(csbaxx_detailid);
	});
	
	function csbaxx_setPageList(pageno,url){
			rows = 10;
			url=csbaxx_setList(pageno,url);
			var mygrid1 = $("#"+csbaxx_tableid).ingrid({
											url: url,
											ingridPageParams:sXML,
											ingridPageWidth: 998,
											height: 418,
											isPlayResultNull:false,
											onRowSelect: function(tr, selected){
												var str = selected?'SELECTED':'UNSELECTED';
												if(sFlag=="true"){
													if ($(tr).attr('_selected')=="true"){
														csbaxx_setQuery($(tr).attr("id")); 	
													}
												}else{
													sFlag="true";
												}					
											},
											sorting:false,
											pageNumber: pageno,
											hideColIndex:[3],
											colWidths: ["30%","20%","50%","0%"]
										});
	}
	function csbaxx_loadPage(divpageid){
		csbaxx_tables=$("#"+divpageid).html();
		$("#"+csbaxx_detailid).hide();
		csbaxx_setPageList(1,'#');
	}
	function csbaxx_setList(pageno,url){
		$("#"+csbaxx_divnid).html(csbaxx_tables);	
		setParams("j_");
		if (url==null || url=="undefined"){
			url=csbaxx_pageUrl;
		}
		return url;
	}
	
	function ylcsjbxx_setDetail(){ //场所详细信息
		setParams("j_");
		jQuery.post(ylcsjbxx_detailUrl,params,ylcsjbxx_updatediv,"json");
	}
	function csbaxx_setDetail(){ //备案信息详细信息
		setParams("h_");
		jQuery.post(csbaxx_detailUrl,params,csbaxx_updatediv,"json");
	}
	function csbaxx_setAddPage(){ //展开添加页面
		sFlag="false";
		csbaxx_setWidth(csbaxx_detailid,csbaxx_gncsbaAddWidth);
		setUrl(csbaxx_detailid,csbaxx_gncsbaAddHtml);
		topAndLeft();
		//bindDocument(csbaxx_detailid);
	}
	function csbaxx_setQuery(id){ //展开详细页面
		csbaxx_dataid=id;
		csbaxx_setWidth(csbaxx_detailid,csbaxx_gncsbaDetailWidth);
		setUrl(csbaxx_detailid,csbaxx_gncsbaDetailHtml);
		topAndLeft();
		//bindDocument(csbaxx_detailid);
	}

	function csbaxx_setWidth(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		$("#"+divid).css("left","50px");
		$("#"+divid).css("top","0px");
	}

	function topAndLeft(){
		var csbaxx_detailidOffset = $("#"+csbaxx_detailid).offset();
		csbaxx_detailidTopOffset=csbaxx_detailidOffset.top;
		csbaxx_detailidLeftOffset=csbaxx_detailidOffset.left;
	}
	function formatDate(strDate){ //转换成日期格式
		var rqAndTime = strDate.split(" ");
		var riqi = rqAndTime[0].split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
</script>
<body>
<input type="hidden" id="d_qybaxxid" value="">
<input type="hidden" id="j_qyid" />
<input type="hidden" id="j_qybm" />
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;备案信息</td>
    <td align="right" id="csbaxx_add">
    <table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
		<tr>
			<td ><a href="#" class="addbutton" onclick='csbaxx_setAddPage();'>添加</a></td>
		</tr>
	</table>
    </td>
  </tr>
</table>
<div id="csbaxx_detail"  class="page-layout" src="#"
		style="top:180px;">
</div>	

<div id="CsbaxxListData" style="width:100%;">
	<table id="CsbaxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_csbabm">备案编码</th>
	     	<th name="l_barq">备案日期</th>
	     	<th name="l_babmmc">备案机构名称</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>