<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4); 
	    $("#bq_yorn").selectBox({code:"dm_bez"});
	    $("#bq_sbzt").selectBox({code:"dm_sbzt"});
	    $("#bq_sbzt").setValue("2");
	    $("#blds_tysj").datepicker();
		bldsjksb_updatediv($("#bldsjksbTable").find("tbody").find("tr:nth("+$("#caozuo_trIndex_blds").val()+")"));
	}); 
	function yornOnchange(){ //是否录像
		var yorn = $("#bq_yorn").attr("title");
		$("#blds_sflx").attr("value",yorn);
	}
	
	
	function sbztchange(){ //设备是否停用
		var sbzt = $("#bq_sbzt").attr("value");
		$("#blds_sbzt").attr("value",sbzt);
	}
	function bldsjksb_updatediv (json) { 
		var sourceVal;
		$("#blds_sbmc").attr("value",setNull(json.find("td:nth(0)").html()));
		$("#blds_sccsmc").attr("value",setNull(json.find("td:nth(1)").html()));
		$("#blds_ggxh").attr("value",setNull(json.find("td:nth(2)").html()));
		
		sourceVal = setNull(json.find("td:nth(3)").html());
		sourceVal = sourceVal.replace(/(&nbsp;)/g,'');
	    $("#blds_sbjcjgmc").attr("value",sourceVal);
	    
		sourceVal = setNull(json.find("td:nth(4)").html());
		sourceVal = sourceVal.replace(/(&nbsp;)/g,'');
		$("#blds_wlcslxmc").attr("value",sourceVal);
		
		$("#blds_azsxtsl").attr("value",setNull(json.find("td:nth(5)").html()));
		$("#bq_yorn").setValue(setNull(json.find("td:nth(6)").html()));
		
		sourceVal = setNull(json.find("td:nth(7)").html());
		sourceVal = sourceVal.replace(/(&nbsp;)/g,'');
		$("#blds_ipdz").attr("value",sourceVal);
		
		$("#blds_lrr").attr("value",setNull(json.find("td:nth(8)").html()));
		$("#blds_lrsj").attr("value",setNull(json.find("td:nth(9)").html()));
		$("#blds_hylb").attr("value",setNull(json.find("td:nth(15)").html()));
		$("#blds_qymc").attr("value",setNull(json.find("td:nth(16)").html()));
		
		yornOnchange();
	}	
	function bldsjksb_modifyVerify(){
	/*	if (!checkControlValue("blds_sbmc","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("blds_sccsmc","String",1,200,null,1,"设备生产厂商"))
			return false;
		if (!checkControlValue("blds_ggxh","String",1,100,null,1,"规格型号"))
			return false;
		if (!checkControlValue("blds_sbjcjgmc","String",1,200,null,0,"设备检测机构"))
			return false;
		if (!checkControlValue("blds_wlcslxmc","String",1,100,null,0,"网络传输类型"))
			return false;
		if (!checkControlValue("bq_yorn","Select",1,2,null,1,"是否录像"))
			return false;
		if (!checkControlValue("blds_azsxtsl","Integer",0,999999,null,1,"安装数量"))//安装摄像头数量
			return false;
		if (!checkControlValue("blds_ipdz","String",1,20,null,0,"IP地址"))
			return false;
			*/
         if($("#bq_sbzt").attr("value")==2){
				if (!checkControlValue("blds_jibr","String",1,20,null,1,"经办人"))
					return false;
				if (!checkControlValue("blds_tysj","Date",1,20,null,1,"停用时间"))
					return false;
				if (!checkControlValue("blds_tyyy","String",1,200,null,1,"停用原因"))
					return false;
			}
			/*
		var strIP = setNull($("#blds_ipdz").attr("value"));
		if(strIP!=""){
			var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g //匹配IP地址的正则表达式
			if(re.test(strIP)){
				if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256){
					return true;
				}else{
					jAlert("请正确填写IP地址","提示");
					return false;
				}
			}else{
				jAlert("请正确填写IP地址","提示");
				return false;
			}
		}
		*/
		return true;
	}

	function bldsjksb_modify(){
		if(bldsjksb_modifyVerify()){
			var caoZuoTr = $("#bldsjksbTable").find("tbody").find("tr:nth("+$("#caozuo_trIndex_blds").val()+")");
			caoZuoTr.find("td:nth(0)").html($("#blds_sbmc").val());
			caoZuoTr.find("td:nth(1)").html($("#blds_sccsmc").val());
			caoZuoTr.find("td:nth(2)").html($("#blds_ggxh").val());
			caoZuoTr.find("td:nth(3)").html($("#blds_sbjcjgmc").val());
			caoZuoTr.find("td:nth(4)").html($("#blds_wlcslxmc").val());
			caoZuoTr.find("td:nth(5)").html($("#blds_azsxtsl").val());
			caoZuoTr.find("td:nth(6)").html($("#bq_yorn").attr("title"));
			caoZuoTr.find("td:nth(7)").html($("#blds_ipdz").val());
			caoZuoTr.find("td:nth(8)").html($("#blds_lrr").val());
			caoZuoTr.find("td:nth(9)").html($("#blds_lrsj").val());
			caoZuoTr.find("td:nth(11)").html($("#blds_jibr").val());
			caoZuoTr.find("td:nth(12)").html($("#blds_tysj").val());
			caoZuoTr.find("td:nth(13)").html($("#bq_sbzt").val());
			caoZuoTr.find("td:nth(14)").html($("#blds_tyyy").val());
			if($("#bq_sbzt").val()=="2"){
			caoZuoTr.find("td:nth(17)").html("");
			}
			$("#bldsjksb_detail").hideAndRemove("show");
			}
	}
	
		$("#bq_sbzt").change(function(){
		if($("#bq_sbzt").val()==2){
				$("#blds_tysj").attr("disabled",false);
				$("#blds_jibr").attr("readonly",false);
				$("#blds_tyyy").attr("readonly",false);
				$("#blds_tysj").attr("disabled",false);
			}else{
				$("#blds_tysj").attr("value","");
				$("#blds_jibr").attr("value","");
				$("#blds_tyyy").attr("value","");
				$("#blds_tysj").attr("disabled",true);
				$("#blds_jibr").attr("readonly",true);
				$("#blds_tyyy").attr("readonly",true);
			}
	} );
	
</script>
<input type="hidden" id="blds_wlcslxbm" />
<input type="hidden" id="blds_azsl" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">视频监控设备停用</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#bldsjksb_detail").hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" id="modify">
	
	<tr>
      <td class="pagedistd1">行业类别</td>
	  <td class="detailtd"><input type="text" class="readonly"   id="blds_hylb" /></td>
		<td class="pagedistd1">企业名称</td>
	  <td class="detailtd" colspan="3"><input type="text" class="readonly"  style="width:98.7%" id="blds_qymc" /></td>
	</tr>
	<tr>
      <td class="pagedistd1">设备名称</td>
	  <td class="detailtd"><input type="text" class="readonly"   id="blds_sbmc" /></td>
		<td class="pagedistd1">设备生产厂商</td>
	  <td class="detailtd" colspan="3"><input type="text" class="readonly"   id="blds_sccsmc" style="width:98.7%" /></td>
	</tr>
	<tr>
		<td class="pagedistd1" >规格型号</td>
      <td class="detailtd"><input type="text" class="readonly"   id="blds_ggxh" /></td>
      <td class="distd">设备检测机构名称</td>
		<td class="detailtd"><input type="text" class="readonly"   id="blds_sbjcjgmc" /></td>
		<td class="distd">网络传输类型</td>
      <td class="detailtd">
      	<input type="text" class="readonly"  id="blds_wlcslxmc" />
      </td>
  </tr>
	<tr>
		<td class="distd" width="10%">是否录像</td>
      <td class="detailtd" width="21%"><select id="bq_yorn"  class="readonly"></select></td>
		<td class="distd" width="15%">摄像头安装数量</td>
      <td class="detailtd" width="20%"><input type="text" class="readonly"   id="blds_azsxtsl" onkeyup="value=value.replace(/[^\d]/g,'')"
      							onblur="value=value.replace(/[^\d]/g,'')"/></td>
      <input type="hidden" id="blds_sflx" />
	    <td class="distd" width="13%">IP地址</td>
	    <td class="detailtd" width="20%"><input type="text" class="readonly"  id="blds_ipdz" /></td>
  </tr>
	<tr>
		<td class="distd">填报人</td>
		<td class="pagetd1"><input type="text" id="blds_lrr" class="readonly" /></td>
		<td class="distd">填报时间</td>
		<td class="pagetd1" colspan="3"><input type="text" id="blds_lrsj" class="readonly" /></td>
	</tr>	
	<tr>
			<td class="red">设备状态</td>
      <td class="detailtd" width="21%"><select id="bq_sbzt" onchange="sbztchange();"></select></td>
		<td class="red">经办人</td>
      <td class="detailtd" width="20%"><input type="text" class="inputstyle"  id="blds_jibr" /></td>
      <input type="hidden" id="blds_sbzt" />
	    <td class="red" width="13%">停用时间</td>
	    <td class="detailtd" width="20%"><input type="text" id="blds_tysj" class="readonly" /></td>
	</tr>
	<tr>
		<td class="red" valign="top">停用原因</td>
      <td class="detailtd" colspan="5"><textarea id="blds_tyyy" style="width:98.7%"></textarea></td>
  </tr>
<tr height="25" align="center"><td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='bldsjksb_modify();'>保存</a></td></tr>
  <tr><td height="10"></td></tr>
</table>
