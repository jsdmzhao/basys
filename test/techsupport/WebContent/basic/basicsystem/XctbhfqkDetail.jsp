<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
   var jsdwid = "";
    var xctb1_detailidTopOffset;
    var xctb1_detailidLeftOffset;
   $(document).ready(function() {
		$("#q_tbid").attr("value",dataid);
		hfck_tables = "";////重写定义tables变量 tables 为公共变量需要重新定义 避免和主页面的变量的冲突
		hfck_pageUrl="basicsystem/querylistHf_xctbjsdw.action";
		hfck_divnid="Hfck_Data";
		hfck_tableid="Hfck_Table";
		hfck_loadPage(hfck_divnid);
		hfck_setPageList(1);
		
		$("#xctbfh_detail").hide(); //隐藏div
		daggleDiv("xctbfh_detail");
	}); 
	
	///重写setPageList 方法
	function hfck_setPageList(pageno,url){	
			url=hfck_setList(pageno,url);
			var mygrid1 = $("#Hfck_Table").ingrid({ 
				url: url,
				barTopOffset:-(xctb_detailidTopOffset+1),
			    barLeftOffset:-(xctb_detailidLeftOffset+1),	
				height: 250,
				pageNumber: pageno,
				onRowSelect: null,	// function to call when row is clicked
			    ingridPageParams: sXML,
			    ingridPageWidth: 680,
			    barTopPosition:$("#xctb_detail").position().top+44,
			    noSortColIndex:[3],
			    colWidths: ["25%","20%","43%","12%"]									
			});				
	}
	///重写setList方法
	function hfck_setList(pageno,url){
		$("#"+hfck_divnid).html(hfck_tables);
		setParams("q_"); ///传输查询条件	
		if (url==null || url=="undefined"){
			url=hfck_pageUrl;
		}
		return url;
	}
	///重写loadPage方法
	function hfck_loadPage(hfck_divnid){
	   hfck_tables = $("#"+hfck_divnid).html();
	   hfck_setPageList(1,'#');
	  
	}
	function setWidth1(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		sLeft=ForDight((parseFloat(pageWidth)-parseFloat(sWidth))/2,2);
		$("#"+divid).css("left","50px");
	}
	
	function xctbhfDetail_xqck(id){
		jsdwid=id;
		setWidth1("xctbfh_detail",detailWidth);
		setUrl("xctbfh_detail","basic/basicsystem/XctbhfDetail.jsp");
	}
	
</script>
<input type="hidden" id="q_tbid">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告回复情况</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#xctb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
<div id="xctbfh_detail"  class="page-layout" src="#"
		style="top:-70px; left:20px;;overflowY:scroll;">
</div>
<div id="Hfck_Data" style="width:100%;">
	<table id="Hfck_Table" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bt">标题</th>
	     	<th name="l_sqsj">回复时间</th>
	     	<th name="l_jsdwmc">查看单位</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
<!--  
<table width="100%" id="detail">
    <tr align="center"><td height="8"></td></tr>
	<tr align="center">
    <td colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="打印" onclick='setAdd();'>打印</a></td>
	</tr>
</table>  -->
