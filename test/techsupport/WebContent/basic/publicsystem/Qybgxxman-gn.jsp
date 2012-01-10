<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() { //企业变更详细列表
		$("#p_qyid").attr("value",qyjbxx_dataid);
		pageUrl="publicsystem/queryQyBianGengXiangxiList_qyjbxx.action";
		divnid="tabledata";
		tableid="table1";
		detailHtml="basic/publicsystem/QyjbxxDetail-ls-gzth.jsp";
		detailid="bgqk_detail";
		detailWidth="1000";
		loadPage("tabledata");
		setPageList(1);
		
		$("#p_bcsj").attr("readonly","true");
		$("#p_bcsj").datepicker();
		$("#p_bcsjt").attr("readonly","true");
		$("#p_bcsjt").datepicker();
	}); 
	function setPageList(pageno,url){
		if (bgxx_manVerify()){
			url=setList(pageno,url);
			setParams("p_");
			var mygrid1 = $("#"+tableid).ingrid({
											url: url,
											ingridPageParams:sXML,
											ingridPageWidth: 998,
											height: 430,
											barTopPosition: 98,
											onRowSelect: function(tr, selected){
											},
											pageNumber: pageno,
											colWidths: ["14%","38%","10%","13%","18%","8%"]
										});
		}
	}
	function qybg_setXqInfo(id){
		dataid=id;
		bgqk_setWidth(detailid,detailWidth);
		setUrl(detailid,detailHtml);
		bindDocument(detailid);
	}
	function bgxx_manVerify(){
		var p_bcsj = $("#p_bcsj").attr("value");
		var p_bcsjt = $("#p_bcsjt").attr("value");
		p_bcsj=p_bcsj.replace(/(-)/g,''); //去掉字符 - 
		p_bcsjt=p_bcsjt.replace(/(-)/g,''); //去掉字符 - 
		if(p_bcsj != '' && p_bcsjt != ''){
		    if(p_bcsj>p_bcsjt){
			    jAlert("请正确选择变更日期!","提示信息");
			    return false;
		    }
		}
		return true;
	}
	function bgqk_setWidth(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		$("#"+divid).css("left","-2px");
	}
	function qybgxxClose(){
		$("#qyjbxx_detail").hideAndRemove("show");
		$("#qyjbxx_detail").empty();
	}
</script>
<body>
<input type="hidden" id="p_qyid" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">企业变更详情</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='qybgxxClose();' class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr>
	<td class="queryfont">查询数据项</td>
	</tr>
	<tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          <tr>
            <td width="8%" class="pagedistd">变更日期</td>
            <td width="25%" class="pagetd"><input type="text" class="inputstyle"  id="p_bcsj" value=""></td>
            <td width="8%" align="left">至</td>
            <td width="24%" class="pagetd"><input type="text" class="inputstyle"  id="p_bcsjt" value=""></td>
            <td width="15%">&nbsp;</td>
            <td width="20%">
	            <table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
	                    <tr>
	                      <td ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
	                    </tr>
				</table>
            </td>
          </tr>
        </table>
	</td>
</tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="bgqk_detail" class="page-layout" src="#" style="top:10px;"></div>
<div id="tabledata" style="width:100%;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td align="left" valign="top">
		<div id="tabledata" style="width:100%;">
			<table id="table1" width="100%">
			  <thead>
			    <tr>       
			     	<th name="l_qybm">企业编码</th>
			     	<th name="l_qymc">企业名称</th>
			     	<th name="l_zrs">总人数</th>
			     	<th name="l_qyzflmc">企业类别</th>
			     	<th name="l_bcsj">变更日期</th>
					<th name="">操作</th>
			    </tr>
			  </thead>
			</table>	
		</div>
	</td></tr>
</table>
</body>
</html>