<%@ page language="java" pageEncoding="UTF-8"
	import="com.aisino2.sysadmin.domain.User,com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	User user = (User) session.getAttribute(Constants.userKey);
	String name = "";
	String userCount = "";
	String hylbdm = "";
	if (user != null) {
		name = user.getSsdwmc();
		userCount = user.getSsdwbm();
		hylbdm = userCount.substring(0,3);
	}
%>
<script type="text/javascript">
var fileId;
var hylbdm = $("#hylbdm").val();
	$(document).ready(function() {
	    bc_bottonMoveRight(20);
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_rzrq").attr("readonly","true");
		$("#a_rzrq").datepicker();
		$("#a_zxsj").attr("readonly","true");
		$("#a_zxsj").datepicker();
		$("#a_hcsj").attr("readonly","true");
		$("#a_hcsj").datepicker();
		$("#a_bcsj").attr("readonly","true");
		$("#a_bcsj").datepicker();
		
  		$("#a_hyzkdm").selectBox({code:"dm_hyzk"});
  		$("#a_xbdm").selectBox({code:"dm_xb"});
  		fileId="a_fileload";
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	}); 
	function addVerify(){	
		if (!checkControlValue("a_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("a_xm","姓名")	)
			return false;
		if (!checkControlValue("a_zjhm","String",1,30,null,1,"身份证号码"))
			return false;
		exitCyryZjhm();
		if(!canCommit)
			return false;
		if (!checkControlValue("a_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("a_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,1,"出生日期"))
			return false;
			
		var tenYearAgo = new Date();
		tenYearAgo.setYear(tenYearAgo.getYear() - 10);
		var tenYearAgoStr = tenYearAgo.getFullYear()+"-"+(tenYearAgo.getMonth()+1)+"-"+tenYearAgo.getDate();
		if(!checkTwoDateEarlier($("#a_csrq").val(),tenYearAgoStr)){
			jAlert("出生日期必须小于"+tenYearAgoStr+"！",'验证信息',null,"a_csrq");
			return false;
		}
								
		if (!checkControlValue("a_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("a_hyzk","Select",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,1,"户籍省县"))
			return false;
		if (!checkControlValue("a_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("a_shouji","String",1,20,null,1,"联系电话"))
			return false;
		if (!checkControlValue("a_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
		if(!valFloatValue("a_shengao","请正确填写身高信息",300.00,0,2,0))
			return false;
		if(!valFloatValue("a_tizh","请正确填写体重信息",500.00,0,2,0))
			return false;
		if (!checkControlValue("a_zzzhm","String",1,20,null,0,"暂住证编号"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("a_zzdz","String",1,200,null,0,"暂住地址"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		
		var returnCardNo = checkIdCardNo("a_zjhm");
		if(returnCardNo){
			$("#a_zjhmError").val(0);
		}else{
			$("#a_zjhmError").val(1);
		}
			
		$("#a_xb").val($("#a_xbdm").attr("title"));
		
		if($("#a_shengao").val()=="")
			$("#a_shengao").val("0");
		if($("#a_tizh").val()=="")
			$("#a_tizh").val("0");
		return true;
	}

	$("#a_minzu").click(function(){
		getDict_item("a_minzu","a_mzdm","dm_mz");
	});
	 
	$("#a_hjdxzqh").click(function(){
		getDict_item("a_hjdxzqh","a_hjdxzqhdm","dm_xzqh");
	});
	
	$("#a_zjhm").blur(function(){
		var returnCardNo = checkIdCardNo("a_zjhm");
		if(returnCardNo){
			var zjhm_csrq = getBirthday($(this).val());
			var zjhm_xb = getXb($(this).val());
			if(zjhm_csrq!=null && zjhm_csrq!=""){
				$("#a_csrq").val(zjhm_csrq);
			}
			if(zjhm_xb!=null && zjhm_xb!=""){
				$("#a_xbdm").setValue(zjhm_xb);
			}
		}else{
			jAlert("身份证号码不正确","验证信息");
		}
		getDdHjsx($(this).val(),"a_hjdxzqhdm","a_hjdxzqh");
	});
	
	$("#a_hyzkdm").change(function(){
  		$("#a_hyzk").val($("#a_hyzkdm").attr('title'));
	});
 
	function addAll(){
		if (addVerify()){
			setParams("a_");
			jQuery.ajax({
				type: 'POST',
				url: addUrl,
				data: params,
				async: false,
				dataType: 'json',
				success: addcyryback
			});
		}
	}

	function addcyryback(json){
		if(json.result=="success"){
			jAlert("添加成功",'提示信息');
			if(!$("#checkbox").attr("checked")){
				$("#"+detailid).hideAndRemove("slow"); 
			} else {
				clearAllFormElement();
			}
			setPageList($("#pageNo").attr("value"));
		}else{
			jAlert(json.result,'错误信息');
		}
	}
	
	function clearAllFormElement(){
		$("[id^=a_]").each(function(index, domEle) {
			$(domEle).attr("value","");
		});
		$("select[id^=a_]").setValue("");
		ctlPicture1.InitPicture();
	}
	
	function openfile(){
		ImgerToBase1.OpenFile();
		ImgerToBase();
	}
	function ImgerToBase(){
		//设置打开图片的大小
		ImgerToBase1.SetFileSize= 2000;
		//文件路径 包括文件名称
		var filePath = ImgerToBase1.getFile();
		//BASE64编码
		var base64code = ImgerToBase1.getBase64();
		var fileName = ImgerToBase1.getFileName();
		if(fileName==null||fileName==''||fileName=='null'){
			$("#pmtPho").attr("src","images/pic.gif");
		} else {
			$("#pmtPho").attr("src",filePath);
		}
		
		$("#a_fileload").attr("value",base64code);
	}
	
	function exitCyryZjhm(){
		var azjhm = $("#a_zjhm").attr("value");
		var sUrl="ddhyzagl/cyryExist_ddcyryxx.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: {vzjhm:azjhm},
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				valCyryZjhmBack(rows);
			}
		});
	}
	function valCyryZjhmBack(json){
		if(json.result=="success"){
			if(json.exitResult=="1"){
				jAlert('此公民身份号码已存在!','验证信息',null,'a_zjhm');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			jAlert(json.result,'提示信息');
			canCommit=false;
		}
	}
	var canCommit = true;
	
	function  deleteDate(y){
	 		 $('#a_xm').val("");
		     $('#a_zjhm').val("");
 	}
 	function updatePicture(y){
		 	$('#a_fileload').val(x.GetImage());
		 	$('#a_xm').val(x.ocrCName);
			$('#a_hjdxz').val(x.ocrAddR);
			$('#a_csrq').val(x.ocrBirth);
			$('#a_zjhm').val(x.ocrIdentityId);
			$('#a_xbdm').setValue(x.ocrCSex);
			$('#a_xb').val($('#a_xbdm').attr('title'));
			getHjsxDD(x.ocrIdentityId,"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
 	}
 	
 	function setPictureBack(x){
 	    $('#a_fileload').val(x.GetImage());
 	}
</script>
<input type="hidden" id="hylbdm" value="<%=hylbdm%>" />
<input type="hidden" id="a_fileload"/>
<input type="hidden" id="a_zjhmError"/>
<input type="hidden" id="a_mzdm"/>
<input type="hidden" id="a_hjdxzqhdm"/>
<input type="hidden" id="a_hyzk"/>
<input type="hidden" id="a_gwbh" value="9999"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#cyryxx_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="2" cellspacing="0" id="add" border="0">
	<tr height="20">
		<td width="14%" class="distd">人员编号</td>
		<td width="24%" class="detailtd"><input type="text" class="readonly" id="a_cyrybh" readonly /></td>
		<td width="19%" class="red">姓名</td>
		<td width="21%" class="detailtd"><input type="text" class="inputstyle" id="a_xm"/></td>
		<td rowspan="10" align="center" valign="top">
				<table width="35%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td>
							<jsp:include
								page="qyryPicture.jsp?zh=true&mo=2&pic=picControlscr&wi=87&hi=124"
								flush="true"></jsp:include>
						</td>
					</tr>
				</table>
		</td>
	</tr>
	<tr height="20">
		<td class="red">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_zjhm"/></td>
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_bm"/></td>
    </tr>
	<tr height="20">
		<td class="red">性别</td>
		<td class="detailtd">
		<input type="hidden" id="a_xb" />
		<select id="a_xbdm"><option></option></select></td>
		<td class="red">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_csrq"/></td>
	</tr>
	<tr height="20">
		<td class="red">民族</td>
		<td class="detailtd"><input type="text" id="a_minzu" class="inputstyle" readonly/></td>
		<td class="distd">婚姻状况</td>
		<td class="detailtd">
	    <select name="select5" id="a_hyzkdm"><option></option></select></td>
    </tr>
	<tr height="20">
		<td class="red">户籍省县</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_hjdxzqh" readonly/></td>
		<td class="red">入职日期</td>
		<td class="detailtd"><input type="text" id="a_rzrq" class="inputstyle"/></td>
    </tr>
	<tr height="20">
		<td class="red">户籍地详址</td>
		<td colspan="3" class="detailtd"><input type="text" style="width:495" id="a_hjdxz" class="inputstyle3"/></td>
	</tr>
	<tr height="20">
		<td class="red">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_shouji"/></td>
		<td class="distd">紧急联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_jjlxrdh"/></td>
    </tr>
	<tr height="20">
		<td class="distd">身高（厘米）</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_shengao"/></td>
		<td class="distd">体重(公斤)</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_tizh"/></td>
	</tr>
	<tr height="20">
		<td class="distd">暂住证编号</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_zzzhm"/></td>
		<td class="distd">职务</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_zhiwu"/></td>
    </tr>
	<tr height="20">
		<td class="distd">暂住地址</td>
		<td colspan="3" class="detailtd"><input type="text" style="width:495" class="inputstyle3" id="a_zzdz"/></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td colspan="4" class="detailtd"><textarea name="textarea2" id="a_bz" cols="76" rows="3"></textarea></td>
	</tr>
	<!-- 
	<tr height="20">
		<td class="distd"><input type="checkbox" name="checkbox" id="checkbox"/></td>
		<td colspan="4" class="detailtd">保存后继续新的采集</td>
	</tr>
	 -->
	<tr height="25" align="center"><td colspan="5">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='addAll();'>保存</a></td>
	</tr>
</table>