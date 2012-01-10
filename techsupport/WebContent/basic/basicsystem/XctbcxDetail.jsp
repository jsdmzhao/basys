<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
		bc_bottonMoveRight(5,'撤销');
        /////在div装载页面	
		$("#xctb-fj").empty();
		$("#xctb-fj").load("basic/basicsystem/Xctb_fjManCx.jsp");
		$("#xctb-fj").show("slow");
		//////////////
	    $("#q_tbid").attr("value",dataid);
	    $("#u_tbid").attr("value",dataid);
	    $("#u_gqbs").attr("value","1");
		////返回单条详细信息
		setDetail();  
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
	//////协查通报撤销
	function xctbcx(){
		jConfirm("确定撤销?","提示信息",function(r) {
			if(r==true){
				setParams("u_");
			    jQuery.post("basicsystem/cxxctb_xctb.action",params,addbackcx,"json");
			}else{
				return false;
			}
		});
	}
	function addbackcx(json){
		if  (json.result=="success"){
		jAlert("撤销成功",'提示信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
		}else{
			jAlert(json.result,'错误信息');
		} 
	}		
</script>
<input type="hidden" id="q_tbid">
<input type="hidden" id="u_tbid">
<input type="hidden" id="u_gqbs">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告撤销</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#xctb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25"></td>
  </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0"  class="tableborder"  id="detail">
	<tr>
	  <td width="13%" class="distd1">接收单位</td>
      <td width="87%" class="detailtd2" colspan="5">
      <textarea id="jsdwmc" name="tzcs" theme="simple" style="font-size:12px;WIDTH:587;BORDER: #A3B4CD 1px solid;height:50px;" readonly="true">
      </textarea>
      </td>	
  </tr>
  <tr>
	    <td width="13%" class="distd1">发布人</td>
        <td width="22%" class="detailtd2" ><span id="fbr"></span></td>
      	<td width="9%" class="distd1">发布时间</td>
		<td width="25%" class="detailtd2" ><span id="fbsj"></span></td>
		<td width="11%" class="distd1">发布单位</td>
		<td width="20%" class="detailtd2" ><span id="fbdw"></span></td>
  </tr>
  <tr>
	    <td width="13%" class="distd1">截至时间</td>
        <td width="22%" class="detailtd2" ><span id="jzrq"></span></td>
      	<td width="9%" class="distd1"></td>
		<td width="25%" class="detailtd2" ></td>
		<td width="11%" class="distd1"></td>
		<td width="20%" class="detailtd2" ></td>
  </tr>
	<tr>
		<td class="distd1">标题</td>
		<td class="detailtd2" colspan="5"><span id="bt"></span></td>
	</tr>
 	<tr>
		<td class="distd1">通知内容</td>
		<td class="detailtd2" colspan="5">
		<textarea id="fbnr" name="tzcs" theme="simple" style="font-size:12px;WIDTH:587;BORDER: #A3B4CD 1px solid;height:50px;" readonly="true">
        </textarea>
		</td>
	</tr>
    <tr>
     	  <td colspan="6" ><div id="xctb-fj"></div></td>
      </tr>
      <!--  
      	<tr>
      	<td width="9%" class="distd1">回复人</td>
		<td width="25%" class="detailtd2" ><span id=" "></span></td>
		<td width="11%" class="distd1">回复时间</td>
		<td width="20%" class="detailtd2" colspan="3"><span id=" "></span></td>
  </tr>
   	<tr>
		<td class="distd1">回复内容</td>
		<td class="detailtd2" colspan="5"><span id=" "></span></td>
	</tr>-->
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td colspan="6" height="5"></td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="撤销" onclick='xctbcx();'>撤销</a>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6" height="2"></td>
	</tr>
</table>
