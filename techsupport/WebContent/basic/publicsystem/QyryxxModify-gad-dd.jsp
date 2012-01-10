<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="java.util.Date"%>
<% Date da=new Date(); long lo=da.getTime(); %>
<script type="text/javascript">
var fileId;
var hylbdm = $("#hylbdm").val();
	$(document).ready(function(){
	    bc_bottonMoveRight(20);
		$("#wtgyy_detail").hide();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_rzrq").attr("readonly","true");
		$("#m_rzrq").datepicker();
		$("#s_ryid").attr("value",dataid);
		$("#q_ryid").attr("value",dataid);
		$("#m_ryid").attr("value",dataid);
		$("#ryid").attr("value",dataid);
		
		$("#m_hyzkdm").selectBox({code:"dm_hyzk"});
		$("#m_xbdm").selectBox({code:"dm_xb"});
		fileId="m_fileload";
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	});
	
	function updatediv (json) { 
	    hylbdm = setNull(json.LQyryxx[0].hylbdm);
		$("#m_qyid").val(setNull(json.LQyryxx[0].qyid));
		$("#hylb").val(setNull(json.LQyryxx[0].hylb));
		$("#m_cyrybh").val(setNull(json.LQyryxx[0].cyrybh));
		$("#m_xm").val(setNull(json.LQyryxx[0].xm));
		$("#m_bm").val(setNull(json.LQyryxx[0].bm));
		$("#m_minzu").val(setNull(json.LQyryxx[0].minzu));
		$("#m_mzdm").val(setNull(json.LQyryxx[0].mzdm));
		if(json.LQyryxx[0].csrq!=null)
			$("#m_csrq").val(setNull(json.LQyryxx[0].csrq.substr(0,10)));
		$("#m_hjdxzqh").val(setNull(json.LQyryxx[0].hjdxzqh));
		$("#m_hjdxzqhdm").val(setNull(json.LQyryxx[0].hjdxzqhdm));
		$("#m_hjdxz").val(setNull(json.LQyryxx[0].hjdxz));
		$("#m_zjhm").val(setNull(json.LQyryxx[0].zjhm));
		$("#m_zzzhm").val(setNull(json.LQyryxx[0].zzzhm));
		$("#m_zzdz").val(setNull(json.LQyryxx[0].zzdz));
		$("#m_shouji").val(setNull(json.LQyryxx[0].shouji));
		$("#m_jjlxrdh").val(setNull(json.LQyryxx[0].jjlxrdh));
		$("#m_zhiwu").val(setNull(json.LQyryxx[0].zhiwu));
		if(json.LQyryxx[0].rzrq!=null)
			$("#m_rzrq").val(setNull(json.LQyryxx[0].rzrq.substr(0,10)));
		$("#m_xb").val(setNull(json.LQyryxx[0].xb));
		var shengao = setNull(json.LQyryxx[0].shengao);
		var tizh = setNull(json.LQyryxx[0].tizh);
		if("0"!=shengao){
			$("#m_shengao").val(shengao);
		}
		if("0"!=tizh){
			$("#m_tizh").val(tizh);
		}
		$("#m_bz").val(setNull(json.LQyryxx[0].bz));
		$("#m_hyzk").val(setNull(json.LQyryxx[0].hyzk));
		$("#m_hyzkdm").setValue(setNull(json.LQyryxx[0].hyzkdm));
		$("#m_xbdm").setValue(setNull(json.LQyryxx[0].xbdm));
		$("#m_fileload").val(setNull(json.LQyryxx[0].fileload));
		$("#qymc").val(setNull(json.LQyryxx[0].qymc));
		
		var zt = setNull(json.LQyryxx[0].shenhe_cyryzt);
		//$("#m_cyryzt").val(zt);
		if(zt=='5'){ //证件号码错误 不允许修改证件号码
			$("#m_zjhm").attr("readonly","readonly");
		}
		if(zt=='11'){ //显示 未通过原因 按钮
			$("#but").attr("width",124);
			document.getElementById('wtgyy').style.display='block';
		}
		$("#img_picControlscr").attr('src','publicsystem/queryTp_qyryxx.action?ryId='+json.LQyryxx[0].ryid+'&aa=<%=lo %>');
	}
	
	function modifyVerify(){
		if (!checkControlValue("m_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("m_xm","姓名"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,30,null,1,"身份证号码"))
			return false;
		if (!checkControlValue("m_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("m_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("m_csrq","String",null,null,null,1,"出生日期"))
			return false;
				
		var tenYearAgo = new Date();
		tenYearAgo.setYear(tenYearAgo.getYear() - 10);
		var tenYearAgoStr = tenYearAgo.getFullYear()+"-"+(tenYearAgo.getMonth()+1)+"-"+tenYearAgo.getDate();
		if(!checkTwoDateEarlier($("#m_csrq").val(),tenYearAgoStr)){
			jAlert("出生日期必须小于"+tenYearAgoStr+"！",'验证信息',null,"m_csrq");
			return false;
		}
		
		if (!checkControlValue("m_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("m_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,1,"户籍省县"))
			return false;
		if (!checkControlValue("m_rzrq","String",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("m_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("m_shouji","String",1,20,null,1,"联系电话"))
			return false;
		if (!checkControlValue("m_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
		if(!valFloatValue("m_shengao","请正确填写身高信息",300.00,0,2,0))
			return false;
		if(!valFloatValue("m_tizh","请正确填写体重信息",500.00,0,2,0))
			return false;
		if (!checkControlValue("m_zzzhm","String",1,20,null,0,"暂住证编号"))
			return false;
		if (!checkControlValue("m_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("m_zzdz","String",1,200,null,0,"暂住地址"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		
		var returnCardNo = checkIdCardNo("m_zjhm");
		if (returnCardNo)
			$("#m_zjhmError").val(0);
		else
			$("#m_zjhmError").val(1);	
			
		$("#m_xb").val($("#m_xbdm").attr("title"));
		
		if($("#m_shengao").val()=="")
			$("#m_shengao").val("0");
		if($("#m_tizh").val()=="")
			$("#m_tizh").val("0");
		return true;
	}

	$("#m_cyrylbdm").change(function(){
		$("#m_cyrylbmc").val($(this).attr("title"));
	});
	
	$("#m_xbdm").change(function(){
		$("#m_xb").val($(this).attr("title"));
	});
	
	$("#m_minzu").click(function(){
		getDict_item("m_minzu","m_mzdm","dm_mz");
	});
	
	$("#m_hjdxzqh").click(function(){
		getDict_item("m_hjdxzqh","m_hjdxzqhdm","dm_xzqh");
	});
	
	$("#m_hyzkdm").change(function(){
  		$("#m_hyzk").val($("#m_hyzkdm").attr('title'));
	});

	$("#m_zjhm").blur(function(){
		var returnCardNo = checkIdCardNo("m_zjhm");
		if(returnCardNo){
			var zjhm_csrq = getBirthday($(this).val());
			var zjhm_xb = getXb($(this).val());
			if(zjhm_csrq!=null && zjhm_csrq!=""){
				$("#m_csrq").val(zjhm_csrq);
			}
			if(zjhm_xb!=null && zjhm_xb!=""){
				$("#m_xbdm").setValue(zjhm_xb);
			}
		}else{
			jAlert("身份证号码不正确","验证信息");
		}
		getDdHjsx($(this).val(),"m_hjdxzqhdm","m_hjdxzqh");
	});
	
	function updateAll(){
		if (modifyVerify()){
			setParams("m_");
			jQuery.ajax({
				type: 'POST',
				url: modUrl,
				data: params,
				async: false,
				dataType: 'json',
				success: updatecyryback
			});
		}
	}
	
	function updatecyryback(json){
		if  (json.result=="success"){
			jAlert(modMessage,'保存信息');
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow"); 
		}else{
			jAlert(json.result,'错误信息');
		}
	}

	function shhistroy(){ //公安局审核未通过 可以查看审核记录
		$("#wtgyy_detail").empty();
		$("#wtgyy_detail").load("business/Ddhyzagl/ShenHeHistory-cyry.jsp");
		$("#wtgyy_detail").show();
		$("#wtgyy_detail").css("width",520);
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
		
		$("#m_fileload").attr("value",base64code);
	}
	
	function exitCyryZjhm(){
		var mzjhm = $("#m_zjhm").attr("value");
		var mryid = $("#m_ryid").attr("value");
		var sUrl="ddhyzagl/cyryExist_ddcyryxx.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: {vzjhm:mzjhm,vryid:mryid},
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
				jAlert('此公民身份号码已存在!','验证信息',null,'m_zjhm');
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
	function clearAllFormElement(){
		var formDiv = $("#clearDiv").parent();
		formDiv.find("input[id!='m_csmc'][id!='m_csid']").val("");
		formDiv.find("input[type='checkbox']").attr("checked",false);
		formDiv.find("textarea").val("");
		formDiv.find("select").setValue("");
		ctlPicture1.InitPicture();
	}

	function deleteDate(y){
		$('#m_xm').val("");
		$('#m_zjhm').val("");
 	}
	function updatePicture(y){
		$('#m_fileload').val(x.GetImage());
		$('#m_xm').val(x.ocrCName);
		$('#m_hjdxz').val(x.ocrAddR);
		$('#m_csrq').val(x.ocrBirth);
		$('#m_zjhm').val(x.ocrIdentityId);
		$('#m_xbdm').setValue(x.ocrCSex);
		$('#m_xb').val($('#m_xbdm').attr('title'));
		getHjsxDD(x.ocrIdentityId,"dm_xzqh","m_hjdxzqhdm","m_hjdxzqh")
	}
	
	function setPictureBack(x){
 	    $('#m_fileload').val(x.GetImage());
 	}
</script>
<input type="hidden" id="s_ryid">

<input type="hidden" id="q_ryid">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_qyid">
<input type="hidden" id="m_csid">
<input type="hidden" id="q_zt" value="m">
<input type="hidden" id="m_fileload"/>
<input type="hidden" id="m_zjhmError"/>
<input type="hidden" id="m_hyzk"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#cyryxx_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="2" cellspacing="0" id="add">
    <tr height="20">
		<td class="red">行业类别</td>
		<td class="detailtd"><input type="text" id="hylb" readonly class="readonly"/></td>
		<td class="red">企业名称</td>
		<td class="detailtd"><input type="text" id="qymc" readonly class="readonly"/></td>
	</tr>
	<tr height="20">
		<td width="14%" class="distd">人员编号</td>
		<td width="24%" class="detailtd"><input type="text" class="readonly" id="m_cyrybh" readonly /></td>
		<td width="19%" class="red">姓名</td>
		<td width="21%" class="detailtd"><input type="text" class="inputstyle" id="m_xm"/></td>
		<td width="22%" rowspan="12" align="center" valign="top">
			<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
	        <tr><td><jsp:include page="qyryPicture.jsp?zh=true&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include>
	        </td></tr>
	      	</table>
	    </td>
	</tr>
	<tr height="20">
		<td class="red">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_zjhm" /></td>
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_bm" /></td>
    </tr>
	<tr height="20">
		<td class="red">性别</td>
		<td class="detailtd">
		<input type="hidden" id="m_xb" />
		<select id="m_xbdm"><option></option></select></td>
		<td class="red">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_csrq" /></td>
	</tr>
	<tr height="20">
		<td class="red">民族</td>
		<td class="detailtd"><input type="text" id="m_minzu" class="inputstyle" readonly /><input type="hidden" id="m_mzdm" /></td>
		<td class="distd">婚姻状况</td>
		<td class="detailtd">
	    <select name="select5" id="m_hyzkdm"><option></option></select></td>
    </tr>
	<tr height="20">
		<td class="red">户籍省县</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_hjdxzqh" readonly /><input type="hidden" id="m_hjdxzqhdm" /></td>
		<td class="red">入职日期</td>
		<td class="detailtd"><input type="text" id="m_rzrq" class="inputstyle"/></td>
    </tr>
	<tr height="20">
		<td class="red">户籍地详址</td>
		<td colspan="3" class="detailtd"><input type="text" style="width:490" id="m_hjdxz" class="inputstyle3" /></td>
	</tr>
	<tr height="20">
		<td class="red">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_shouji" /></td>
		<td class="distd">紧急联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_jjlxrdh" /></td>
    </tr>
	<tr height="20">
		<td class="distd">身高（厘米）</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_shengao" /></td>
		<td class="distd">体重(公斤)</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_tizh" /></td>
	</tr>
	<tr height="20">
		<td class="distd">暂住证编号</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_zzzhm" /></td>
		<td class="distd">职务</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_zhiwu" /></td>
    </tr>
    <tr height="20">
		<td class="distd">暂住地址</td>
		<td colspan="3" class="detailtd"><input type="text" style="width:490" class="inputstyle3" id="m_zzdz"/></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td colspan="4" class="detailtd"><textarea name="textarea2" id="m_bz" cols="76" rows="3"></textarea></td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="but">
  <tr align="center">
    <td colspan="5">
    <a id="wtgyy" style="display:none" href="#" hidefocus="true" class="submitlongbutton" title="审核记录" onclick='shhistroy();'>审核记录</a>
    <a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='updateAll();'>保存</a>
    </td>
  </tr>
</table>
<div id="wtgyy_detail" class="page-layout" src="#" style="z-index:2000; top:50px; left:40px;">