<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
//var parentDiv = $("#q_tbid").parent();
$(document).ready(function() {
       bc_bottonMoveRight(5,'打印');
        /////在div装载页面	
		$("#xctb-fj").empty();
		$("#xctb-fj").load("basic/basicsystem/Xctb_fjMan.jsp");
		$("#xctb-fj").show("slow");
		//////////////
		
	    $("#q_tbid").attr("value",dataid);
		////返回单条详细信息
		setDetail(); 
		////打印初始化话
		//fnLoadprint(); 
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
	
	//////打印函数
	function printpage(myDiv){ 
	   var content = document.all.item(myDiv).innerHTML;
	    var title = "通知通告详细信息"; //标题信息
	    params={con:content,titlecon:title};
	    jQuery.post("basicsystem/printCon_publicPrint.action",params,printback,"json");
	    return false; 
	} 
	
	function printback(){
	    var url = window.location.href;
	   var len = url.lastIndexOf('/');
	   url = url.substring(0, len)+"/public/printHtml.jsp";
	   window.open(url);
	}
	/**
	function xctbprint(){
	    //var ctlp = document.getElementById("ctlPrint");
	    var url = window.location.href;
	    var len = url.lastIndexOf('/');
	    url = url.substring(0, len)+"/basic/basicsystem/XctbDetailprint.jsp?tbid="+dataid;
        window.open(url); 
	}
	**/
	/**
	function fnLoadprint(){	    	
        var ctlp = document.getElementById("ctlPrint");
	    var url = window.location.href;
	    var len = url.lastIndexOf('/');
        ctlp.SetUrl = url.substring(0, len)+"/basic/basicsystem/XctbDetailprint.jsp?tbid="+dataid;
   }**/	   
</script>
<input type="hidden" id="q_tbid">
<input type="hidden" id="m_tbid">
<div id="closeParentDiv" style="display:none"></div>
<table width="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td align="left" class="title1">
			通知通告详细信息
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#closeParentDiv").parent().hideAndRemove("show");'
				class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="25"></td>
	</tr>
</table>
<div id="printDiv" class="scrollbarface"  style="overflow-y:auto;overflow-x:hidden;">
<table width="100%" cellpadding="2" cellspacing="0" class="tableborder"
	id="detail">
	<tr>
		<td width="13%" class="distd1">
			接收单位
		</td>
		<td width="87%" class="detailtd2" colspan="5">
			<textarea id="jsdwmc" name="tzcs" theme="simple"
				style="font-size: 12px; WIDTH: 587; BORDER: #A3B4CD 1px solid; height: 50px;"
				readonly="true">
      </textarea>
		</td>
	</tr>
	<tr>
		<td width="13%" class="distd1">
			发布人
		</td>
		<td width="22%" class="detailtd2">
			<span id="fbr"></span>
		</td>
		<td width="9%" class="distd1">
			发布时间
		</td>
		<td width="25%" class="detailtd2">
			<span id="fbsj"></span>
		</td>
		<td width="11%" class="distd1">
			发布单位
		</td>
		<td width="20%" class="detailtd2">
			<span id="fbdw"></span>
		</td>
	</tr>
	<tr>
		<td width="13%" class="distd1">
			截至时间
		</td>
		<td width="87%" class="detailtd2" colspan="5">
			<span id="jzrq"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			标题
		</td>
		<td class="detailtd2" colspan="5">
			<span id="bt"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			通知内容
		</td>
		<td class="detailtd2" colspan="5">
			<textarea id="fbnr" name="tzcs" theme="simple"
				style="font-size: 12px; WIDTH: 587; BORDER: #A3B4CD 1px solid; height: 50px;"
				readonly="true">
        </textarea>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<div id="xctb-fj"></div>
		</td>
	</tr>
	<!--  
      	<tr>
      	<td width="9%" class="distd1">回复人</td>
		<td width="25%" class="detailtd2"><span id=" "></span></td>
		<td width="11%" class="distd1">回复时间</td>
		<td width="20%" class="detailtd2" colspan="3"><span id=" "></span></td>
  </tr>
   	<tr>
		<td class="distd1">回复内容</td>
		<td class="detailtd2" colspan="5"><span id=" "></span></td>
	</tr>-->
</table>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td colspan="6" height="5"></td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="打印" onclick='printpage("printDiv");'>打印</a>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6" height="2"></td>
	</tr>
</table>

