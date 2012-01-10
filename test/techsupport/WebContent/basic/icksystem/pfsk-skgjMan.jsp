<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var bafwht_tables = "";
	var bafwht_dataid = "";
	var bafwht_rowselect = 0;
	var bafwht_pageUrl="icksystem/querylistGj_qyryskjl.action";
	var bafwht_divnid="SkgjListData";
	var bafwht_tableid="lskgj";
	
	$(document).ready(function(){
		$("#t_cyrybh").attr("value",pfsk_dataid);
		bafwht_loadPage("SkgjListData");
		bafwht_setPageList(1);
	});
	
	function bafwht_setPageList(pageno,url){
		url=bafwht_setList(pageno,url);
		setParams("t_"); //传参
		var bafwht_mygrid1 = $("#"+bafwht_tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-209,
				ingridPageWidth:600,
				pageNumber: pageno,
				colWidths: ["20%","20%","30%","30%"],
				onRowSelect: function(tr, selected){},
				sorting: false
		});
	}
	function bafwht_loadPage(divpageid){
		bafwht_tables=$("#"+divpageid).html();
		bafwht_setPageList(1,'#');
	}
	function bafwht_setList(pageno,url){
		$("#"+bafwht_divnid).html(bafwht_tables);
		if (url==null || url=="undefined"){
			url=bafwht_pageUrl;
		}
		return url;
	}
</script>

</head>
<body>
<input type="hidden" id="t_cyrybh" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">刷卡轨迹</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#pfsk_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="SkgjListData" style="width:100%;">
	<table id="lskgj" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_bafwgsmc">刷卡时间</th>
	     	<th name="l_baryzgzsmc">保存时间</th>
	     	<th name="l_htbh">刷卡场所名称</th>
	     	<th name="l_barypxjsrq">所属管辖单位</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>