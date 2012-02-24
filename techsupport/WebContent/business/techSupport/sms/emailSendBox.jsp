<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../../public/common.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		//初始化收件人和发送人的默认地址
		var user=$('span[class=yhxx]').text().substring(0,3);
		$("#fPeople").val(user);
		var parameters={};
		parameters['mail.user']=user;
		$.post(BUSNEISS_PATH+'/findEmailAdreesByName_mail.action',parameters,function(json){
			$("#email").val(json.mail.email);
		},'json');
		//发送邮件
		$("#send").click(function(){
			var params={};
			params['mail.user']=user;
			params['mail.password']=$("#password").val();
			params['mail.status']=$('#p_stStatus').val();
			for(var i=0;i<stNoList.length;i++){
				params['lSt['+i+'].id']=stNoList[i];
			}
			/* $.post(BUSNEISS_PATH+'/send_mail.action',params,function(json){
				alert(json.result);
				$("#email_detail").hideAndRemove("show");
			},'json');  */
		});
	});
</script>
<style>
.textArea {
	width: 580px;
	height: 40px;
	blueidea:expression(this.readOnly=false);
}
</style>
<html>
<div id='st_NO_DIV'></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">发送email设置</td>
		<td align="right"><a href="#" id="closeDiv"
			onclick='$("#email_detail").hideAndRemove("show");' class="close"></a>
		</td>
	</tr>
</table>
	<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
		<tr height="20">
			<td class="pagedistd">发件人</td>
			<td class="pagetd"><input id="fPeople" class="readonly"></input></td>
		</tr>
		<tr>
			<td class="pagedistd">发件人邮箱地址</td>
			<td class="pagetd"><input id="email" class="readonly"></input></td>
			<td class="pagedistd">发件人邮箱密码</td>
			<td class="pagetd"><input type="password" id="password"></input></td>
		</tr>
	</table>
	<div>
		<center >
			<span>
				<input type="button" id="send" class="searchbutton" value="发送" onclick="">
			</span>
		</center>
	</div>
</html>