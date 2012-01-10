<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var skjl_tables="";
	var skjl_pageUrl="icksystem/querylistCsrzSkjl_qyryskjl.action";
	var skjl_divnid="tabledata";
	var skjl_tableid="table1";
	var skjl_detailHtml="basic/publicsystem/QyryskjlDetail.jsp";
	var skjl_detailid="csryskjl_detail";
	var skjl_detailUrl="icksystem/query_qyryskjl.action";
	var skjl_detailWidth="300";
	
	$(document).ready(function(){
		$("#p_qyid").attr("value",qyjbxx_dataid);
		
		if($("#p_hylbdm").val()!="J"){
			$('body').find('div [@id=qy]').each(function(){
				$(this).show();
			});
			$('body').find('div [@id=cs]').each(function(){
				$(this).hide();
			});
		}
		
		
		skjl_loadPage("tabledata");
		skjl_setPageList(1);
	});
	
	function skjl_setPageList(pageno,url){	
		url=skjl_setList(pageno,url);
		var mygrid1 = $("#"+skjl_tableid).ingrid({ 
							url: url,
							ingridPageParams:sXML,
							ingridPageWidth: 990,
							height: 250,
							pageNumber: pageno,
							onRowSelect: function(tr, selected){  },
							hideColIndex: [3],
							colWidths: ["20%","20%","20%","0%","20%","20%"]
					});				
	}
	function skjl_loadPage(divpageid){
		skjl_tables=$("#"+divpageid).html();
		$("#"+skjl_detailid).hide(); 	
		skjl_setPageList(1,'#');
	}
	function skjl_setList(pageno,url){	
		$("#"+skjl_divnid).html(skjl_tables);
		setParams("p_");
		if (url==null || url=="undefined"){
			url=skjl_pageUrl;
		}
		return url;
	}
	function meclose(){
		$("#ylcsjbxx_detail").hideAndRemove("show");
		$("#ylcsjbxx_detail").empty();
	}
</script>
</head>
<body>
<input type="hidden" id="p_qyid">
<input type="hidden" id="d_skxxtjmxid">
<div id="qyxxClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" id="isHaveClose">
    <tr>
      <td align="left" class="title1"><div id="cs" >场所刷卡记录</div><div id="qy" style="display:none">企业刷卡记录</div></td>
      <td align="right" class="title1"><a href="#" onclick="$('#qyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
    <tr>
      <td>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
      </td>
    </tr>
</table>

<div id="csryskjl_detail"  class="page-layout" src="#"
		style="top:180px; left:160px; width:500px;">
</div>

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_xmzc">注册人员</th>
	     	<th name="l_xmfzc">非注册人员</th>
	     	<th name="l_scyrybh">从业人员编号</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_sksj">刷卡时间</th>
	     	<th name="l_scsj">入库时间</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>