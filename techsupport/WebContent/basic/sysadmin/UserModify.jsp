<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var yhjslbflag='ptry';//普通人员
	var usertype = new Array();
	$(document).ready(function() {
		bc_bottonMoveRight(); //按钮右对齐
		$("#q_userid").attr("value",dataid);
		$("#sfyx").selectBox({code:"dm_bez"});
		$("#yhjslb").selectBox({code:"dm_yhjslb"});
		$("#bq_jzlbdm_mod").selectBox({code:"dm_jzlb"});
		if(jzlbdm!=''){
			$("#bq_jzlbdm_mod").setValue(jzlbdm);
			$("#m_jzlbmc").attr("value",jzlbmc);
			$("#m_jzlbdm").attr("value",jzlbdm);
		}
		if(isSjyh=='1'){ //非省级用户锁定
			$("#bq_jzlbdm_mod").setAttr("readonly","true"); //锁定
			yincangJz(); //隐藏警种字段 20100329 杨提出
		}
	    setDetail();	
	}); 
	
	function sfyxOnchange(){ //是否有效
		var m_isvalid = $("#sfyx").attr("value");
		$("#m_isvalid").attr("value",m_isvalid);
	}
	function updatediv (json) { 
		$("#m_userid").attr("value",setNull(json.LUser[0].userid));
		$("#m_departid").attr("value",setNull(json.LUser[0].departid));
		$("#m_useraccount").attr("value",setNull(json.LUser[0].useraccount));
		$("#m_username").attr("value",setNull(json.LUser[0].username));
		$("#m_idnum").attr("value",setNull(json.LUser[0].idnum));
		$("#m_username").attr("value",setNull(json.LUser[0].username));
		$("#m_mobilephone").attr("value",setNull(json.LUser[0].mobilephone));
		//默认赋值
		$("#bq_jzlbdm_mod").setValue(setNull(json.LUser[0].jzlbdm));
		$("#m_jzlbdm").attr("value",setNull(json.LUser[0].jzlbdm));
		$("#m_jzlbmc").attr("value",setNull(json.LUser[0].jzlbmc));
		$("#sfyx").setValue(setNull(json.LUser[0].isvalid));
		
		if(setNull(json.LUser[0].usertype)!=''){
			if(json.LUser[0].usertype=='9999'){
			   $("#yhjslb").setValue(1);
			    yhjslbOnchange();
			}else {
				usertype = json.LUser[0].usertype.split(",");
			    jzyhlbInit();
			}
			$("#yhjslb").setAttr("readonly",true);
			sfyxOnchange();
		}
	}
	function jzyhlbInit(){
		var jzlbdm = $("#bq_jzlbdm_mod").attr("value");
		var params={jzlbdm:jzlbdm};
		var usls = 'sysadmin/findUserType_user.action';
		jQuery.post(usls,params,userTypeBack,"json");
	}
	function userTypeBack(json){ //用户类别
		if(yhjslbflag=='ptry'){
			$("#yhlbtd").css("display","block");
			$("#yhlb").html(setNull(json.strResult));
			
			for(var index=0,max=usertype.length;index<max;index++){
				$("#yhlb_"+usertype[index]).attr("checked",true);
			}
		}
	}
	function modifyVerify(){
		var isCanPlay = false;
		if(yhjslbflag=='ptry'){
				$("#yhlb").find("input[type='checkbox']").each(function(){
					if($(this).attr("checked")==true){
						isCanPlay = true;
					}
				});
				if(!isCanPlay){
					jAlert("请选择用户类别","提示");
					return false;
				}
		}
		if (!checkControlValue("m_useraccount","String",1,20,null,1,"登录账号"))
			return false;
		if (!checkControlValue("m_username","String",1,20,null,1,"用户姓名"))
			return false;
		if (!checkControlValue("m_mobilephone","String",1,400,null,0,"电话"))
			return false;
		if (!checkControlValue("m_userorder","Integer",-999999999,999999999,null,1,"排列顺序"))
			return false;
			
	 	if(yhjslbflag=='ptry'){
			$("#m_usertype").attr("value","");
			$("#yhlb").find("input[type='checkbox']").each(function(){
				if($(this).attr("checked")==true){
					var thisid = $(this).attr("id").replace('yhlb_','');
					$("#m_usertype").attr("value",$("#m_usertype").attr("value")+thisid+",");
				}
			});
		}
		var idnum = $("#m_idnum").attr("value");
		if(idnum!=''&&!isIdCardNo(idnum)){
			$("#m_idnum").focus();
			return false;
		}
		return true;
	}
	
	function yhjslbOnchange(){ //用户角色类别
		var a_yhjslb = $("#yhjslb").attr("value");
		if(a_yhjslb==1){
			$("#m_usertype").attr("value",'9999M');
			yhjslbflag='glry';//管理人员
			$("#yhlbtd").css("display","none");
		}else{
			$("#yhlbtd").css("display","block");
			yhjslbflag='ptry';//普通人员
			jzyhlbInit();
		}
	}
	function jzlbOnchange(){
		$("#yhlbAll").attr("checked",false);
		var jzlbdm = $("#bq_jzlbdm_mod").attr("value");
		var jzlbmc = $("#bq_jzlbdm_mod").attr("title");
		$("#m_jzlbdm").attr("value",jzlbdm);
		$("#m_jzlbmc").attr("value",jzlbmc);
		jzyhlbInit();
	}
	function yhlbAllOnchange(){ //全选或全取消用户类别
		var temp = $("#yhlbAll").attr("checked");
		$("#yhlb").find("input[type='checkbox']").each(function(){
			$(this).attr("checked",temp)
		});
	}
	function yincangJz(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tiele_mod").hide();
		$("#jz_content_mod").hide();
	}
</script>
<input type="hidden" id="q_userid">
<input type="hidden" id="m_userid">
<input type="hidden" id="m_departid">

<input type="hidden" id="m_isvalid"/>
<input type="hidden" id="m_usertype"/>
<input type="hidden" id="m_jzlbmc"/>
<input type="hidden" id="m_jzlbdm"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">用户修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#user_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr>
		<td class="distd" width="18%">用户姓名</td>
		<td class="detailtd" width="32%"><input type="text" class="inputstyle"  id="m_username" value=""/></td>
		<td class="distd" width="18%">登录账号</td>
		<td class="detailtd" width="32%"><input type="text" readonly class="readonly" id="m_useraccount"/></td>
	</tr>
  	<tr>
	  <td class="distd">公民身份号码</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_idnum" value="" /></td>
	  <td class="distd">电话</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_mobilephone"
	  		onkeyup="value=value.replace(/[^\d ,^\- ^(,)]/g,'')" title="用 , 隔开多个电话号码"/></td>
  	</tr>
	<tr>
	  <td class="distd">排列顺序</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_userorder" value="0" /></td>
	  <td class="distd">是否有效</td>
	  <td class="detailtd"><select id="sfyx" name="" onchange="sfyxOnchange();"></select></td>
  	</tr>
  	<tr align="center">
        <td class="distd">用户角色类别</td>
	    <td class="detailtd"><select id="yhjslb" onchange="yhjslbOnchange();"></select></td>
	    <td class="distd" id="jz_tiele_mod">警种</td>
	    <td class="detailtd" id="jz_content_mod"><select id="bq_jzlbdm_mod" onchange="jzlbOnchange();"><option></option></select></td>
	</tr>
	<tr id="yhlbtd" style="display:none" align="center">
	  <td class="distd">用户类别<input type='checkbox' id='yhlbAll' onclick="yhlbAllOnchange();"/></td>
	  <td  class="detailtd" colspan="3">
	  <div class="scrollbarface" style="border:1px #c5d9e8 solid;overflow-y:auto;overflow-x:hidden;height:200;width:420;">
		  <span id="yhlb"></span>
	  </div></td>
  	</tr>
	<tr height="25" align="center">
		<td colspan="4">
		<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td>
	</tr>
</table>
