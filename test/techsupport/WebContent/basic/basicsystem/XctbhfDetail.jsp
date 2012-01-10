<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {

        /////在div装载页面	
		$("#xctb-fj").empty();
		$("#xctb-fj").load("basic/basicsystem/Xctb_fjhfMan.jsp");
		$("#xctb-fj").show("slow");
		//////////////
		
	    $("#q_jsdwid").attr("value",jsdwid);
		////返回单条详细信息
		setDetail();  
		
		/////装载回复div
		xctb_hf_tables = "";////重写定义tables变量 tables 为公共变量需要重新定义 避免和主页面的变量的冲突
		xctb_hf_pageUrl="basicsystem/querylistga_xctbhf.action";
		xctb_hf_divnid="Xctb_hfData";
		xctb_hf_tableid="Xctb_hfTable";
		xctb_hf_loadPage(xctb_hf_divnid);
		xctb_hf_setPageList(1);
	}); 
	function updatediv(json){
	    $("#jsdwmc").attr("value",setNull(json.LXctb[0].jsdwmc));
		$("#bt").append(setNull(json.LXctb[0].bt));
		$("#fbsj").append(setNull(json.LXctb[0].fbsj));
		$("#fbr").append(setNull(json.LXctb[0].fbr));
		$("#fbdw").append(setNull(json.LXctb[0].fbdw));
		$("#jzrq").append(setNull(json.LXctb[0].jzrq));
		//$("#fbnr").append(setNull(json.LXctb[0].fbnr));
		$("#fbnr").attr("value",setNull(json.LXctb[0].fbnr));
	}
	function xctb_hf_setPageList(pageno,url){	
			url=xctb_hf_setList(pageno,url);
			var mygrid1 = $("#"+xctb_hf_tableid).ingrid({ 
				url: url,	
				height: 150,
				pageNumber: pageno,
				onRowSelect: null,	// function to call when row is clicked
			    ingridPageWidth: 682,
				ingridPageParams: sXML,
				isPlayResultNull: false,
				colWidths: ["15%","15%","20%","50%"]									
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

<input type="hidden" id="q_jsdwid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告详细信息</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#xctbfh_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<div style="height:16">&nbsp;</div>
<table width="100%" border="0" cellpadding="2" cellspacing="0" class="detail" id="detail">
<tr>
	  <td width="13%" class="distd1">接收单位</td>
      <td width="87%" class="detailtd2"  colspan="5">
      <textarea id="jsdwmc" name="tzcs" theme="simple" style="font-size:12px;WIDTH:585;BORDER: #A3B4CD 1px solid;height:50px;" readonly="true">
      </textarea>
      </td>	
  </tr>
  <tr>
	    <td width="13%" class="distd1">发布人</td>
        <td width="22%" class="detailtd2" ><span id="fbr"></span></td>
      	<td width="9%" class="distd1">发布时间</td>
		<td width="25%" class="detailtd2"><span id="fbsj"></span></td>
		<td width="11%" class="distd1">发布单位</td>
		<td width="20%" class="detailtd2"><span id="fbdw"></span></td>
  </tr>
  <tr>
	    <td width="13%" class="distd1">截至时间</td>
        <td width="22%" class="detailtd2" ><span id="jzrq"></span></td>
      	<td width="9%" class="distd1"></td>
		<td width="25%" class="detailtd2"></td>
		<td width="11%" class="distd1"></td>
		<td width="20%" class="detailtd2"></td>
  </tr>
	<tr>
		<td class="distd1">标题</td>
		<td class="detailtd2" colspan="5"><span id="bt"></span></td>
	</tr>
 	<tr>
		<td class="distd1">通知内容</td>
		<td class="detailtd2" colspan="5">
		<textarea id="fbnr" name="tzcs" theme="simple" style="font-size:12px;WIDTH:585;BORDER: #A3B4CD 1px solid;height:50px;" readonly="true">
        </textarea>
		</td>
	</tr>
    <tr>
     	  <td colspan="6" ><div id="xctb-fj"></div></td>
      </tr>
     <tr>
     	  <td colspan="6" >
     	  <div id="Xctb_hfData" style="width:100%;">
	<table id="Xctb_hfTable" width="100%">
	  <thead>
	    <tr>
	        <th name="l_jsdwmc">回复单位</th>       
	     	<th name="l_hfr">回复人</th>
	     	<th name="l_hfsj">回复时间</th>
	     	<th name="l_hfnr">回复内容</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
     	  </td>
      </tr>
    <!--  
    <tr align="center"><td colspan="6" height="8"></td></tr>
	 <tr align="center">
    <td colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="打印" onclick='setAdd();'>打印</a></td>
  </tr> -->
</table>
<div style="height:16">&nbsp;</div>
