<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {	
		
		xctb_ck_tables = "";////重写定义tables变量 tables 为公共变量需要重新定义 避免和主页面的变量的冲突
		xctb_ck_pageUrl="basicsystem/querylist_xctbjsdw.action";
		xctb_ck_divnid="XctbjsdwData";
		xctb_ck_tableid="XctbjsdwTable"
		$("#q_tbid").attr("value",dataid);
		xctb_ck_loadPage(xctb_ck_divnid);
		xctb_ck_setPageList(1);
		
	}); 
	function xctb_ck_setPageList(pageno,url){
			url=xctb_ck_setList(pageno,url);
			var mygrid1 = $("#"+xctb_ck_tableid).ingrid({ 
				url: url,
				barTopOffset:-(xctb_detailidTopOffset+1),
			    barLeftOffset:-(xctb_detailidLeftOffset+1),	
				height: 250,
				pageNumber: pageno,
				onRowSelect: null,	// function to call when row is clicked
				changeHref:function(table){
					$(table).find("tr").find("td:last").remove();
				},
			    ingridPageParams: sXML,
			    ingridPageWidth: 680,
			    barTopPosition:$("#xctb_detail").position().top+44,
				colWidths: ["25%","25%","50%"]									
			});	
	}	
	///重写setList方法
	function xctb_ck_setList(pageno,url){
	$("#"+xctb_ck_divnid).html(xctb_ck_tables);	
		setParams("q_"); ///传输查询条件
		if (url==null || url=="undefined"){
			url=xctb_ck_pageUrl;
		}
		return url;
	}
	///重写loadPage方法
	function xctb_ck_loadPage(xctb_ck_divnid){
	   xctb_ck_tables = $("#"+xctb_ck_divnid).html();
	   xctb_ck_setPageList(1,'#');
	}
</script>
<input type="hidden" id="q_tbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告查看情况</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#xctb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
<table width="100%" id="detail" border="0" cellpadding="0" cellspacing="0" align="center">
   	<tr>
  <td ><div id="XctbjsdwData" style="width:100%; ">
	<table id="XctbjsdwTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bt">标题</th>
	     	<th name="l_sqsj">查看时间</th>
	     	<th name="l_jsdwmc">查看单位</th>
	    </tr>
	  </thead>
	</table>	
</div></td>
	</tr>
	<!-- 
    <tr align="center"><td height="8"></td></tr>
	 <tr align="center">
    <td colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton"  title="打印" onclick='setAdd();'>打印</a></td>
  </tr> -->
</table>
