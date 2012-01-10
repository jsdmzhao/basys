<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.common.DateUtil"%>
<%@include file="../../public/common.jsp" %>
<%
User user = new User();
String userName = null;
//获得登录用户session
user = (User) session.getAttribute(Constants.userKey);
if (user == null)
	response.sendRedirect("login.jsp");
else
	userName = user.getUsername(); 
String lrsj = DateUtil.getDateTime();
%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4); 
		$("#bq_yorn").selectBox({code:"dm_bez"});
		yornOnchange();
	});
	function yornOnchange(){ //是否录像
		var yorn = $("#bq_yorn").attr("title");
		$("#blds_sflx").attr("value",yorn);
	}
	function bldsjksb_addVerify(){
		if (!checkControlValue("blds_sbmc","String",1,100,null,1,"设备名称"))
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
		if (!checkControlValue("blds_azsxtsl","Integer",0,999999,null,1,"摄像头安装数量"))//安装摄像头数量
			return false;
		if (!checkControlValue("blds_ipdz","String",1,20,null,0,"IP地址"))
			return false;
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

		if (!checkControlValue("blds_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}

	function bldsjksb_setAdd(){
			if(bldsjksb_addVerify()){
				dataid = 'bldsjksbid';
				var child=new Array("BldsjksbListData");
				setParams("blds_",child);
				bldsjksb_setPageList(1);
				$("#bldsjksb_detail").hideAndRemove("show");
			}
	}
</script>
<input type="hidden" id="blds_wlcslxbm" value="1" />
<input type="hidden" id="blds_azsl" value="1" />
<input type="hidden" id="blds_zt" value="1" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">视频监控设备添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#bldsjksb_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr><td height="10"></td></tr>
	<tr>
      <td class="red">设备名称</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="blds_sbmc" /></td>
		<td class="red">设备生产厂商</td>
	  <td class="detailtd" colspan="3"><input type="text" class="inputstyle3" id="blds_sccsmc" style="width:98.7%" /></td>
	</tr>
	<tr>
		<td class="red">规格型号</td>
      <td class="detailtd"><input type="text" class="inputstyle"  id="blds_ggxh" /></td>
      <td class="distd">设备检测机构</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="blds_sbjcjgmc" /></td>
		<td class="distd">网络传输类型</td>
      <td class="detailtd">
      	<input type="text" class="inputstyle"  id="blds_wlcslxmc" />
      </td>
  </tr>
	<tr>
	<tr>
		<td class="red" width="10%">是否录像</td>
      <td class="detailtd" width="21%"><select id="bq_yorn" onchange="yornOnchange();"></select></td>
		<td class="red" width="15%">摄像头安装数量</td>
      <td class="detailtd" width="20%"><input type="text" class="inputstyle"  id="blds_azsxtsl" onkeyup="value=value.replace(/[^\d]/g,'')"
      							onblur="value=value.replace(/[^\d]/g,'')"/></td>
      <input type="hidden" id="blds_sflx" />
	    <td class="distd" width="13%">IP地址</td>
	    <td class="detailtd" width="20%"><input type="text" class="inputstyle"  id="blds_ipdz" /></td>
	<tr>
  </tr>
	<tr height="20" style="display:none">
		<td class="pagedistd1">填报人</td>
		<td class="pagetd1"><input type="text" id="blds_lrr" class="readonly" value="<%=userName %>" /></td>
		<td class="pagedistd1">填报时间</td>
		<td class="pagetd1" colspan="3"><input type="text" id="blds_lrsj" class="readonly" value="<%=lrsj %>" /></td>
	</tr>	
	<tr>
		<td class="pagedistd1" valign="top">备注</td>
      <td class="detailtd" colspan="5"><textarea id="blds_bz" style="width:98.7%"></textarea></td>
  </tr>
  <tr>
	  <td colspan="6">
	<a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='bldsjksb_setAdd();'>保存</a>
	</td>
  </tr>
	<tr><td height="10"></td></tr>
</table>
