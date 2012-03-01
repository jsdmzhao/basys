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
		if(send_or_export_flag == 1){
			$("#send").click(function(){
				$("input[type=button]").attr('disabled',true);
				var params={};
				
				for(var i=0;i<stNoList.length;i++){
					params['lSt['+i+'].id']=stNoList[i];
				}
				params['mail.user']=user;
				params['mail.password']=$("#password").val();
				params['mail.status']=$('#p_stStatus').val();
				$("#div_send").show(); //打开 AJAX 等待动画
	      		jQuery.ajax({
					type: 'POST',
					url: BUSNEISS_PATH+'/send_mail.action',
					data: params,
					async: true,
					dataType: 'json',
					success: function(data){
						if(data.result=='success'){
							jAlert('发送成功','提示信息');
						}else{
							jAlert('发送失败,请与管理员联系','提示信息');
						}
					},
					complete: function(){
						$("#div_send").hide(); //关闭 AJAX 等待动画
						$("input[type=button]").attr('disabled',false);
						$("#email_detail").hideAndRemove("show");
					}
				});
				
				//发送并导出
				
				/* $.post(BUSNEISS_PATH+'/send_mail.action',params,function(json){
					alert(json.result);
					$("#email_detail").hideAndRemove("show");
				},'json');  */
			});
		}
		//发送并导出
		else if(send_or_export_flag == 2){
			$('#send').click(function(){
				var params={};
				for(var i=0;i<stNoList.length;i++){
					params['lSt['+i+'].id']=stNoList[i];
				}
				params['word.status']=$("#p_stStatus").val();
				params['word.mail_username']=user;
				params['word.mail_password']=$("#password").val();
				params['word.mail']=$('#email').val();
				
				/* $.post(BUSNEISS_PATH+'/createWord_word.action',paramss,function(data){
					alert(data.result);
				},'json'); */
				$("#div_send").show(); //打开 AJAX 等待动画
	      		jQuery.ajax({
					type: 'POST',
					url: BUSNEISS_PATH+'/createWord_word.action',
					data: params,
					async: true,
					dataType: 'json',
					success: function(data){
						if(data.result=='success'){
							alert('导出并发送成功','提示信息');
						}else{
							alert('导出并发送失败,请与管理员联系','提示信息');
						}
					},
					complete: function(){
						$("#div_send").hide(); //关闭 AJAX 等待动画
						$("input[type=button]").attr('disabled',false);
						$("#email_detail").hideAndRemove("show");
					}
				});
			});
		}
		
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