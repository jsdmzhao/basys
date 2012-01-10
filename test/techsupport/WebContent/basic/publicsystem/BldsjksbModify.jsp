<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(40); 
	    $("#bq_yorn").selectBox({code:"dm_bez"});
		yornOnchange();
		$("#q_bldsjksbid").attr("value",bldsjksb_dataid);
		bldsjksb_setDetail();
	}); 
	function yornOnchange(){ //是否录像
		var yorn = $("#bq_yorn").attr("title");
		$("#m_sflx").attr("value",yorn);
	}
	function bldsjksb_updatediv (json) { 
	    $("#m_sbjcjgmc").attr("value",setNull(json.LBldsjksb[0].sbjcjgmc));
		$("#m_wlcslxbm").attr("value",setNull(json.LBldsjksb[0].wlcslxbm));
		$("#m_wlcslxmc").attr("value",setNull(json.LBldsjksb[0].wlcslxmc));
		$("#m_azsxtsl").attr("value",setNull(json.LBldsjksb[0].azsxtsl));
		$("#m_sbxh").attr("value",setNull(json.LBldsjksb[0].sbxh));
		$("#m_sccsmc").attr("value",setNull(json.LBldsjksb[0].sccsmc));
		$("#m_ggxh").attr("value",setNull(json.LBldsjksb[0].ggxh));
		$("#m_azsl").attr("value",setNull(json.LBldsjksb[0].azsl));
		$("#m_sbmc").attr("value",setNull(json.LBldsjksb[0].sbmc));
		$("#bq_yorn").setValue(setNull(json.LBldsjksb[0].sflx));
		$("#m_ipdz").attr("value",setNull(json.LBldsjksb[0].ipdz));
		$("#m_anwz").attr("value",setNull(json.LBldsjksb[0].anwz));
	}	
	function bldsjksb_modifyVerify(){
		if (!checkControlValue("m_sbmc","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("m_sccsmc","String",1,200,null,1,"设备生产厂商名称"))
			return false;
		if (!checkControlValue("m_ggxh","String",1,100,null,1,"规格型号"))
			return false;
		if (!checkControlValue("m_sbjcjgmc","String",1,200,null,0,"设备检测机构名称"))
			return false;
		if (!checkControlValue("m_anwz","String",1,2000,null,1,"安装位置"))
			return false;
		if (!checkControlValue("m_wlcslxmc","String",1,100,null,0,"网络传输类型"))
			return false;
		if (!checkControlValue("m_azsxtsl","Integer",0,1000,null,1,"安装摄像头数量"))
			return false;
		if (!checkControlValue("bq_yorn","Select",1,2,null,1,"是否录像"))
			return false;
		if (!checkControlValue("m_ipdz","String",1,20,null,0,"IP地址"))
			return false;
		var strIP = setNull($("#m_ipdz").attr("value"));
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
		return true;
	}
</script>
<input type="hidden" id="q_bldsjksbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">视频监控设备修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#bldsjksb_detail").hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr><td height="10"></td></tr>
	<tr>
		<td class="red" width="20%">设备名称</td>
		<td class="detailtd" width="33%"><input type="text" class="inputstyle" id="m_sbmc"/></td>
		<td class="red" width="17%">设备生产厂商名称</td>
		<td class="detailtd" width="30%"><input type="text" class="inputstyle" id="m_sccsmc"/></td>
	</tr>
	<tr>
		<td class="red">规格型号</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_ggxh"/></td>
		<td class="distd">设备检测机构名称</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_sbjcjgmc"></td>
	</tr>
	<tr>
		<td class="red">安装位置</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_anwz"/></td>
		<td class="distd">网络传输类型</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_wlcslxmc"></td>
	</tr>
	<tr>
		<td class="red">安装摄像头数量</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_azsxtsl" onkeyup="value=value.replace(/[^\d]/g,'')"
      							onblur="value=value.replace(/[^\d]/g,'')"/></td>
	    <td class="red">是否录像</td>
		<td class="detailtd"><select id="bq_yorn" onchange="yornOnchange();"></select></td>
	</tr>
	<tr>
		<td class="distd">IP地址</td>
	    <td class="detailtd"><input type="text" class="inputstyle" id="m_ipdz"/></td>
	</tr>
	<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='bldsjksb_modify();'>保存</a></td></tr>
  	<tr><td height="10"></td></tr>
</table>
