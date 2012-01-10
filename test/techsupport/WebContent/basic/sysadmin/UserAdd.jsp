<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var canCommit=false;
	var yhjslbflag='ptry';//普通人员
	$(document).ready(function() {
		bc_bottonMoveRight(20); //按钮右对齐
		$("#a_departid").attr("value",dataid);
		$("#sfyx").selectBox({code:"dm_bez"});
		$("#yhjslb").selectBox({code:"dm_yhjslb"});
		$("#bq_jzlbdm_add").selectBox({code:"dm_jzlb"});
		if(jzlbdm!=''){
			$("#bq_jzlbdm_add").setValue(jzlbdm);
			$("#a_jzlbmc").attr("value",jzlbmc);
			$("#a_jzlbdm").attr("value",jzlbdm);
		}
		if(isSjyh=='1'){ //非省级用户锁定
			$("#bq_jzlbdm_add").setAttr("readonly","true"); //锁定
			yincangJz(); //隐藏警种字段 20100329 杨提出
		}
		sfyxOnchange();
		jzyhlbInit();
	});
	function jzyhlbInit(){
		var jzlbdm = $("#a_jzlbdm").attr("value");
		var params={jzlbdm:jzlbdm};
		var usls = 'sysadmin/findUserType_user.action';
		jQuery.post(usls,params,userTypeBack,"json");
	}
	function userTypeBack(json){ //用户类别
		$("#yhlb").html(setNull(json.strResult));
		var checkboxLst = $("#yhlb").find("input:checkbox");
		if(checkboxLst.length==1){
			checkboxLst.attr("checked",true);
			if(checkboxLst.attr("id")=="yhlb_13"){
				$("#yhjslb").setText("普通用户");
				$("#yhjslb").setAttr("readonly",true);
			}
		}
		queryNextOrder();
	}
	function queryNextOrder(){ //获取兄弟节点最大排序号
		setParams("a_");
		var nextOrderUrl="sysadmin/nextNodeorder_user.action";
		jQuery.ajax({
			type: 'POST',
			url: nextOrderUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				nextOrderInfo(rows);
			}
		});
	}
	function nextOrderInfo(json){ //获取兄弟节点最大排序号-回调函数
		$("#a_userorder").attr("value",json.strResult);
	}
	function sfyxOnchange(){ //是否有效
		var a_isvalid = $("#sfyx").attr("value");
		$("#a_isvalid").attr("value",a_isvalid);
	}
	function addVerify(){
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
		if (!checkControlValue("a_useraccount","String",1,20,null,1,"登录账号"))
			return false;
		if (!checkControlValue("a_username","String",1,20,null,1,"用户姓名"))
			return false;
		if (!checkControlValue("ra_password","String",1,100,null,1,"用户口令"))
			return false;
		if (!checkControlValue("re_password","String",1,100,null,1,"重复口令"))
			return false;
			
		var pwd = $("#ra_password").attr("value");
		var repwd = $("#re_password").attr("value");
		if(pwd!=repwd){
			jAlert("两次口令不一致","提示",null,"re_password");
			return false;
		}
		var a_idnum = $("#a_idnum").attr("value");
		if(a_idnum!=''){
			if(!isIdCardNo(a_idnum)){
				$("#a_idnum").focus();
				return false;
			}else{ //将转后的号码填好
				$("#a_idnum").attr("value",isIdCardNo(a_idnum));
			}
		}
		if (!checkControlValue("a_mobilephone","String",1,400,null,0,"电话"))
			return false;
		if (!checkControlValue("a_userorder","Integer",-999999999,999999999,null,1,"排列顺序"))
			return false;
		valadateCode();
		if(!canCommit)
			return false;
			
	  if(yhjslbflag=='ptry'){
			$("#a_usertype").attr("value","");
			$("#yhlb").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
					var thisid = $(this).attr("id").replace('yhlb_','');
					$("#a_usertype").attr("value",$("#a_usertype").attr("value")+thisid+",");
				}
			});
		}
		var idnum = $("#a_idnum").attr("value");
		if(idnum!=''&&!isIdCardNo(idnum)){
			$("#a_idnum").focus();
			return false;
		}
		$("#a_password").val(hex_md5($("#ra_password").val())); //MD5 加密
		return true;
	}
	function valadateCode(){ //验证代码
		setParams("a_");
		var sUrl="sysadmin/validateUser_user.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				valadateCodeBack(rows);
			}
		});
	}
	function valadateCodeBack(json){
		if(json.result=="success"){
			if(json.strResult=="1"){
				jAlert('此用户名已存在!','验证信息');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			canCommit=false;
		}
	}
	function addback(json){
		if (json.result=="success"){
			jAlert(addMessage,'提示信息');
			queryNextOrder();
			setPageList($("#pageNo").attr("value"));
			
			$("#a_username").attr("value",""); //姓名
			$("#a_useraccount").attr("value",""); //用户名
			$("#ra_password").attr("value",""); //用户口令
			$("#re_password").attr("value","");
			$("#a_idnum").attr("value","");
			$("#a_mobilephone").attr("value","");
			
			$("#yhlb").find("input[type='checkbox']").each(function(){
				$(this).attr("checked",false);
			});
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
	function passVal(){
		var pwd = $("#ra_password").attr("value");
		var repwd = $("#re_password").attr("value");
		if(repwd!=""&&pwd!=repwd){
			jAlert("两次口令不一致","提示");
		}
	}
	function repassVal(){
		var pwd = $("#ra_password").attr("value");
		var repwd = $("#re_password").attr("value");
		if(pwd!=repwd){
			jAlert("两次口令不一致","提示");
		}
	}
	
	function yhjslbOnchange(){ //用户角色类别
		var a_yhjslb = $("#yhjslb").attr("value");
		if(a_yhjslb==1){
			$("#a_usertype").attr("value",'9999M');
			yhjslbflag='glry';//管理人员
			$("#yhlbtd").css("display","none");
		}else{
			$("#yhlbtd").css("display","block");
			yhjslbflag='ptry';//普通人员
		}
	}
	function jzlbOnchange(){
		$("#yhlbAll").attr("checked",false);
		var jzlbdm = $("#bq_jzlbdm_add").attr("value");
		var jzlbmc = $("#bq_jzlbdm_add").attr("title");
		$("#a_jzlbdm").attr("value",jzlbdm);
		$("#a_jzlbmc").attr("value",jzlbmc);
		jzyhlbInit();
	}
	function yhlbAllOnchange(){ //全选或全取消用户类别
		var temp = $("#yhlbAll").attr("checked");
		$("#yhlb").find("input[type='checkbox']").each(function(){
			$(this).attr("checked",temp)
		});
	}
	function yincangJz(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tiele_add").hide();
		$("#jz_content_add").hide();
	}
</script>
<input type="hidden" id="a_departid">
<input type="hidden" id="a_isvalid"/>
<input type="hidden" id="a_usertype"/>
<input type="hidden" id="a_password"/>
<input type="hidden" id="a_jzlbdm"/>
<input type="hidden" id="a_jzlbmc"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">用户添加</td>
      <td class="title1" align="right">
      <a href="#" id="closeDiv" onclick='$("#user_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table><div align="center"> 
</div><table width="100%" id="add">
	<tr align="center">
		<td class="distd" width="17%">用户姓名</td>
		<td class="detailtd" width="33%"><input type="text" class="inputstyle" id="a_username" value="" /></td>
		<td class="distd" width="17%">登录账号</td>
		<td class="detailtd" width="33%"><input type="text" class="inputstyle" id="a_useraccount" value="" onblur="valadateCode();"/></td>
	</tr>
	<tr align="center">
	  <td class="distd">用户口令</td>
	  <td class="detailtd"><input class="inputstyle" type="password" id="ra_password" value="" onblur="passVal();"/></td>
	  <td class="distd">重复口令</td>
	  <td class="detailtd"><input class="inputstyle" type="password" id="re_password" value="" onblur="repassVal();"/></td>
	</tr>
	<tr align="center">
	  <td class="distd">公民身份号码</td>
	  <td class="detailtd"><input class="inputstyle" type="text" id="a_idnum" value=""/></td>
	  <td class="distd">电话</td>
	  <td class="detailtd"><input class="inputstyle" type="text" id="a_mobilephone" 
	  		onkeyup="value=value.replace(/[^\d ,^\- ^(,)]/g,'')" title="用 , 隔开多个电话号码"/></td>
	</tr>
	<tr align="center">
	  <td class="distd">排列顺序</td>
	  <td class="detailtd"><input type="text" class="inputstyle" id="a_userorder" value="0" /></td>
	  <td class="distd">是否有效</td>
	  <td class="detailtd"><select id="sfyx" onchange="sfyxOnchange();"></select></td>
	</tr>
	<tr align="center">
        <td class="distd">用户角色类别</td>
	    <td class="detailtd"><select id="yhjslb" onchange="yhjslbOnchange();"></select></td>
	    <td class="distd" id="jz_tiele_add">警种</td>
	    <td class="detailtd" id="jz_content_add"><select id="bq_jzlbdm_add" onchange="jzlbOnchange();"><option></option></select></td>
	</tr>
	<tr  id="yhlbtd" style="display:block" align="center">
	  <td  class="distd" >用户类别<input type='checkbox' id='yhlbAll' onclick="yhlbAllOnchange();"/></td>
	  <td  class="detailtd" colspan="3">
	  <div class="scrollbarface" style="border:1px #c5d9e8 solid;overflow-y:auto;overflow-x:hidden;height:200;width:420;">
		  <span id="yhlb"></span>
	  </div></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a></td>
	</tr>
</table>