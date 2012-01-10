<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_tbid").attr("value",dataid);
		
		xctb_hf_tables = "";////重写定义tables变量 tables 为公共变量需要重新定义 避免和主页面的变量的冲突
		xctb_hf_pageUrl="basicsystem/querylist_xctbhf.action";
		xctb_hf_divnid="Xctb_hfData";
		xctb_hf_tableid="Xctb_hfTable";
		xctb_hf_addUrl="basicsystem/insert_xctb_fj.action";
		xctb_hf_addHtml="basic/basicsystem/Xctb_fjAdd.jsp";
		xctb_hf_addWidth="500";
		xctb_hf_delUrl="basicsystem/delete_xctb_fj.action";
		xctb_hf_delid="d_fjid";
		xctb_hf_modHtml="basic/basicsystem/Xctb_fjModify.jsp";
		xctb_hf_modUrl="basicsystem/modify_xctb_fj.action";
		xctb_hf_modWidth="500";
		xctb_hf_detailHtml="basic/basicsystem/Xctb_fjDetail.jsp";
		xctb_fj_detailid="xctb_hf_detail";
		xctb_hf_detailUrl="basicsystem/query_xctb_fj.action";
		xctb_hf_detailWidth="300";
		xctb_hf_loadPage(xctb_hf_divnid);
		xctb_hf_setPageList(1);
		
	}); 
	function xctb_hf_setPageList(pageno,url){	
			url=xctb_hf_setList(pageno,url);
			var mygrid1 = $("#"+xctb_hf_tableid).ingrid({ 
											url: url,
											barTopOffset:-(xctb_detailidTopOffset+1),
										    barLeftOffset:-(xctb_detailidLeftOffset+1),	
											height: 250,
											pageNumber: pageno,
											ingridPageParams: sXML,
										    ingridPageWidth: 680,
											onRowSelect: function(tr, selected){
										},	// function to call when row is clicked
											colWidths: ["30%","20%","50%"]									
										});				
	}	
	///重写setList方法
	function xctb_hf_setList(pageno,url){
	$("#"+xctb_hf_divnid).html(xctb_hf_tables);	
		setParams("q_"); ///传输查询条件
		if (url==null || url=="undefined"){
			url=xctb_hf_pageUrl;
		}
		return url;
	}
	
	///重写loadPage方法
	function xctb_hf_loadPage(xctb_hf_divnid){
	   xctb_hf_tables = $("#"+xctb_hf_divnid).html();
	   xctb_hf_setPageList(1,'#');
	}
	
	
</script>
<input type="hidden" id="q_tbid"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告-回复</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#xctb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<div id="Xctb_hfData" style="width:100%;">
	<table id="Xctb_hfTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_hfr">回复人</th>
	     	<th name="l_hfsj">回复时间</th>
	     	<th name="l_hfnr">回复内容</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
