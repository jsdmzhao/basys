<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
		 bc_bottonMoveRight(8);
		 $("#xctb-fj").empty();
		 $("#xctb-fj").load("basic/basicsystem/Xctb_fjMan.jsp");
		 $("#xctb-fj").show("slow");
		 $("#q_tbid").attr("value",dataid);
		 $("#a_tbid").attr("value",dataid);
		 
		 
		 /////写入查看时间
	     /////////////start
	    	setParams("q_");
		    jQuery.ajax({
				type: 'POST',
				url: "basicsystem/modify_xctbjsdw.action",
				data: params,
				async: false,
				dataType: 'json',
				success: function(result){						
				}
			}); 
		  /////////////end 
		 
		 setDetail();
		 var xctbUrl = "basicsystem/initxctbhfAdd_xctbhf.action";
		 jQuery.post(xctbUrl,params,initxctbAdd,"json"); 
		
	}); 
	////setDetail的回调函数
	function updatediv(json){ 
	    $("#jsdwmc").attr("value",setNull(json.LXctb[0].jsdwmc));
		$("#bt").append(setNull(json.LXctb[0].bt));
		$("#fbsj").append(setNull(json.LXctb[0].fbsj));
		$("#fbr").append(setNull(json.LXctb[0].fbr));
		$("#fbdw").append(setNull(json.LXctb[0].fbdw));
		$("#jzrq").append(setNull(json.LXctb[0].jzrq));
		$("#fbnr").attr("value",setNull(json.LXctb[0].fbnr));
	}
	
	////回调函数
	function initxctbAdd(json){
	 document.getElementById("a_hfr").value = json.user.username;
	 document.getElementById("a_hfsj").value = json.hftime;
	}
	///////插入回复
	function setAddhf(){
	  if (addVerifyhf()){
			setParams("a_");
			jQuery.post("basicsystem/insert_xctbhf.action",params,addbackhf,"json");
	  }
	}
	function addbackhf(json){
		if  (json.result=="success"){
			jAlert("操作成功",'提示信息');
			//setPageList($("#pageNo").attr("value"));
		    set_replay(dataid);
		    $("#"+detailid).hideAndRemove("slow");
		}else{
			jAlert(json.result,'错误信息');
		}		
   }
   ////验证函数
   function addVerifyhf(){
		if (!checkControlValue("a_hfsj","Date",null,null,null,0,"回复时间"))
			return false;
		if (!checkControlValue("a_hfnr","String",1,2000,null,1,"回复内容"))
			return false;
		if (!checkControlValue("a_hfr","String",1,100,null,0,"回复人"))
			return false;
		
		return true;
	}		
		
</script>
<input type="hidden" id="q_tbid">
<input type="hidden" id="a_tbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告回复</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#xctb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25"></td>
  </tr>
</table>
<table width="100%" id="detail" cellpadding="4" cellspacing="0"  class="tableborder" >
	<tr>
	  <td width="13%" class="distd1">接收单位</td>
      <td width="87%" class="detailtd2"  colspan="5">
      <textarea id="jsdwmc" name="tzcs" theme="simple" style="font-size:12px;WIDTH:590;BORDER: #A3B4CD 1px solid;height:50px;" readonly="true">
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
		<textarea id="fbnr" name="tzcs" theme="simple" style="font-size:12px;WIDTH:590;BORDER: #A3B4CD 1px solid;height:50px;" readonly="true">
        </textarea>
		</td>
	</tr>
     	<tr>
		<td class="distd1">附件</td>
		<td colspan="5" class="detailtd2"></td>
	   </tr>
     	<tr>
     	  <td colspan="6" ><div id="xctb-fj"></div></td>
       </tr>
       <tr height="20">
		<td class="distd1" width="13%">回复人</td>
		<td class="detailtd2" width="22%" ><input type="text" class="readonly" id="a_hfr" value=""></td>
		<td class="distd1" width="9%">回复时间</td>
		<td class="detailtd2" colspan="3"><input type="text" class="readonly" id="a_hfsj" value="1111"></td>
		</tr>
		<tr height="20">
			<td class="red">回复内容</td>
			<td class="detailtd2" colspan="5">
		    <textarea id="a_hfnr" name="tzcs" style="text-indent:0px;font-size:12px;WIDTH:590;BORDER: #A3B4CD 1px solid;height:50px;"></textarea>		    </td>
     </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr align="center"><td colspan="6" height="10"></td></tr>
	 <tr align="center">
    <td colspan="6"><a href="#" id="addbutton" hidefocus="true"  class="submitbutton" title="保存" onclick='setAddhf();'>保存</a></td>
  </tr>
</table>
<div style="height:4">&nbsp;</div>
