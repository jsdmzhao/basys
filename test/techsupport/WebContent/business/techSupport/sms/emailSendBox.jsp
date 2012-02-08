<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../../public/common.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {//初始化收件人和发送人的默认地址
		var recipientsTR='';
		var user=$('span[class=yhxx]').text().substring(0,3);
		var trTemplate="<tr height='20' id='fk'>"
			+	"<td class='pagedistd'>收件人</td>"
			+	"<td class='pagetd'><input id='toPeople' class='inputstyle'></input></td>"
			+	"<td class='pagedistd'>收件人地址</td>"
			+	"<td class='pagetd'><input id='toAddress' class='readonly'></input></td>"
			+"</tr>";
		var inputTemplate="";
		for(var i=0;i<toNames.length;i++){
			recipientsTR+=trTemplate;
		}
		for(var i=0;i<stNumber.length;i++){
			inputTemplate+="<input id='st_NO' type='hidden'></input>";
			inputTemplate+="<input id='editTime' type='hidden'></input>";
		}
		$("#subject").before(recipientsTR);
		$("div[id=st_NO_DIV]").html(inputTemplate);
		var toPeoples=$("input[id=toPeople]");
		var stNumbers=$('input[id=st_NO]');
		var editTimes=$('input[id=editTime]');
		var paramters={};
		//添加收件人默认邮件地址
		$(toPeoples).each(function(i){
			$(this).val(toNames[i]);
			$(this).attr('class','readonly');
			paramters['mail.recipients['+i+'].rName']=toNames[i];
			$.post(BUSNEISS_PATH+'/findEmailAdreesByName_mail.action',paramters,function(json){
				var toAddress=$(toPeoples).parents('tr').eq(0).find('input[id=toAddress]');
				$(toAddress).val(json.mail.recipients[i].rAddress);
			},'json');
		});
		$(stNumbers).each(function(i){
			$(this).val(stNumber[i]);
		});
		$(editTimes).each(function(i){
			$(this).val(editTime[i]);
		});
		var param={};
		param['mail.user']=user;
		$.post(BUSNEISS_PATH+'/findEmailAdreesByName_mail.action',param,function(json){
			$("#email").val(json.mail.email);
		},'json');
		$("#fPeople").val(user);
		toNames=null;
		stNumber=null;
		editTime=null;
		recipientsTR="";
		$("#mail_subject").attr("value","进展信息填报提醒");
		$("#mail_subject").attr('class','readonly')
		//发送邮件
		$("#send").click(function(){
			var params={};
			var rAddress=$("input[id=toAddress]");
			var rName=$("input[id=toPeople]");
			var stNO=$('input[id=st_NO]');
			var editeTime=$('input[id=editTime]');
			if(rAddress.length>1){
				for(var i;i<recipients.length;i++){
					params['mail.recipients['+i+'].rAddress']=$(rAddress[i]).val();
					params['mail.recipients['+i+'].rNmae']=$(rName[i]).val();
					params['mail.recipients['+i+'].st_NO']=$(stNO[i]).val();
					params['mail.recipients['+i+'].lastEditTime']=$(editeTime[i]).val();
				}
			}else{
				params['mail.recipients['+0+'].rAddress']=$("#toAddress").val();
				params['mail.recipients['+0+'].rName']=$("#toPeople").val();
				params['mail.recipients['+0+'].st_NO']=$("#st_NO").val();
				params['mail.recipients['+0+'].lastEditTime']=$("#editTime").val();
			}
			params['mail.user']=$("#email").val();
			params['mail.password']=$("#password").val();
			params['mail.subject']=$("#mail_subject").val();
			$.post(BUSNEISS_PATH+'/sendEmail_mail.action',params,function(json){
				alert(json.result);
				$("#email_detail").hideAndRemove("show");
			},'json'); 
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
		<tr height="20" id='subject'>
			<td class="pagedistd">邮件主题</td>
			<td class="pagetd"><input id="mail_subject" class="inputstyle"></input></td>
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