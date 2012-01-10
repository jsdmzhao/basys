<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="java.util.Date"%>
<%
	Date da = new Date();
	long lo = da.getTime();
%>
<script type="text/javascript">
	var fileData,fileId;
	$(document).ready(function() {
	    bc_bottonMoveRight(20);
		$("#wtgyy_detail").hide();
		$("#s_ryid").attr("value",dataid);
		$("#q_ryid").attr("value",dataid);
		$("#m_ryid").attr("value",dataid);
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_rzrq").attr("readonly","true");
		$("#m_rzrq").datepicker();
		$("#m_qymc").attr("readonly","true");
			
  		$("#m_hyzkdm").selectBox({code:"dm_hyzk"});
  		$("#m_xbdm").selectBox({code:"dm_xb"});
  		$("#m_qzzldm").selectBox({code:"dm_qzzl(lgy)"});
  		$("#m_cyzjdm").selectBox({code:"dm_hz"});
  		$("#m_cylbdm").selectBox({code:"dm_cyry_nbdw"}); //从业人员类别
  	//	gy_getselectBox("m_cylbdm");//从业人员类别
  		fileId="m_fileload";
		//setDetail();
	}); 
	function updatediv (json) {
	    $("#hylb").val(setNull(json.LWgcyryxx[0].hylb));
		$("#m_qyid").val(setNull(json.LWgcyryxx[0].qyid));
		$("#qymc").val(setNull(json.LWgcyryxx[0].qymc));
		$("#m_cyrybh").val(setNull(json.LWgcyryxx[0].cyrybh));
		$("#m_xm").val(setNull(json.LWgcyryxx[0].xm));
		$("#m_xb").val(setNull(json.LWgcyryxx[0].xb));
		if(json.LWgcyryxx[0].csrq!=null)
			$("#m_csrq").val(setNull(json.LWgcyryxx[0].csrq.substr(0,10)));
		$("#m_zzzhm").val(setNull(json.LWgcyryxx[0].zzzhm));
		$("#m_zzdz").val(setNull(json.LWgcyryxx[0].zzdz));
		$("#m_shouji").val(setNull(json.LWgcyryxx[0].shouji));
		$("#m_jjlxrdh").val(setNull(json.LWgcyryxx[0].jjlxrdh));
		$("#m_zhiwu").val(setNull(json.LWgcyryxx[0].zhiwu));
		if(json.LWgcyryxx[0].rzrq!=null)
			$("#m_rzrq").val(setNull(json.LWgcyryxx[0].rzrq.substr(0,10)));
		$("#m_zxr").val(setNull(json.LWgcyryxx[0].zxr));
		$("#m_cjr").val(setNull(json.LWgcyryxx[0].cjr));
		$("#m_hcdw").val(setNull(json.LWgcyryxx[0].hcdw));
		$("#m_zxyy").val(setNull(json.LWgcyryxx[0].zxyy));
		$("#m_scbz").val(setNull(json.LWgcyryxx[0].scbz));
		$("#m_ywx").val(setNull(json.LWgcyryxx[0].ywx));
		$("#m_ywm").val(setNull(json.LWgcyryxx[0].ywm));
		$("#m_gj").val(setNull(json.LWgcyryxx[0].gj));
		$("#m_gjdm").val(setNull(json.LWgcyryxx[0].gjdm));
		$("#m_wgrjyxkz").val(setNull(json.LWgcyryxx[0].wgrjyxkz));
		$("#m_qzhm").val(setNull(json.LWgcyryxx[0].qzhm));
		$("#m_qzzldm").val(setNull(json.LWgcyryxx[0].qzzldm));
		$("#m_zjhm").val(setNull(json.LWgcyryxx[0].zjhm));
		$("#m_cjdbm").val(setNull(json.LWgcyryxx[0].cjdbm));
		
 		$("#m_cylbdm").setValue(setNull(json.LWgcyryxx[0].cylbdm)); //从业人员类别代码
		$("#m_cylb").setValue(setNull(json.LWgcyryxx[0].cylb)); //从业人员类别
		
		$("#m_cjdmc").val(setNull(json.LWgcyryxx[0].cjdmc));
		$("#m_csid").val(setNull(json.LWgcyryxx[0].csid));
		//$("#m_cyryzt").val(setNull(json.LWgcyryxx[0].shenhe_cyryzt));
		var shengao = setNull(json.LWgcyryxx[0].shengao);
		var tizh = setNull(json.LWgcyryxx[0].tizh);
		if("0"!=shengao){
			$("#m_shengao").val(shengao);
		}
		if("0"!=tizh){
			$("#m_tizh").val(tizh);
		}
		
		$("#m_bz").val(setNull(json.LWgcyryxx[0].bz));
		
  		$("#m_hyzkdm").setValue(setNull(json.LWgcyryxx[0].hyzkdm));
  		$("#m_hyzk").val(setNull(json.LWgcyryxx[0].hyzk));
  		$("#m_xbdm").setValue(setNull(json.LWgcyryxx[0].xbdm));
  		$("#m_qzzldm").setText(setNull(json.LWgcyryxx[0].qzzldm));
  		$("#m_cyzjdm").setText(setNull(json.LWgcyryxx[0].cyzj));
  		$("#m_bz").val(setNull(json.LWgcyryxx[0].bz));
  		
  		$("#m_fileload").val(setNull(json.LWgcyryxx[0].fileload));
		$("#zpwtgyy").append(setNull(json.LWgcyryxx[0].zpwtgyy));
		
		var zt = setNull(json.LWgcyryxx[0].shenhe_cyryzt);
		if(zt=='11'){ //显示 未通过原因 按钮
			$("#but").attr("width",124);
			document.getElementById('wtgyy').style.display='block';
		}
		$("#img_picControlscr").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LWgcyryxx[0].ryid+'&aa=<%=lo %>');
	}	
	
	function modifyVerify(){
		if (!checkControlValue("m_ywx","String",1,100,null,1,"英文姓"))
			return false;
		if (!checkControlValue("m_ywm","String",1,100,null,1,"英文名"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,1,"出生日期"))
			return false;	

		var tenYearAgo = new Date();
		tenYearAgo.setYear(tenYearAgo.getYear() - 10);
		var tenYearAgoStr = tenYearAgo.getFullYear()+"-"+(tenYearAgo.getMonth()+1)+"-"+tenYearAgo.getDate();
		if(!checkTwoDateEarlier($("#m_csrq").val(),tenYearAgoStr)){
			jAlert("出生日期必须小于"+tenYearAgoStr+"！",'验证信息',null,"m_csrq");
			return false;
		}
		
		if (!checkControlValue("m_gj","String",1,100,null,1,"国籍"))
			return false;
		if (!checkControlValue("m_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("m_wgrjyxkz","String",1,30,null,1,"就业许可证号"))
			return false;
		if (!checkControlValue("m_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("m_cyzjdm","Select",1,4,null,1,"证件类型"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,1,"证件号码"))
			return false;
		//exitCyryZjhm();
		//if(!canCommit)
		//	return false;
		if (!checkControlValue("m_qzzldm","String",1,4,null,1,"签证种类代码"))
			return false;
		if (!checkControlValue("m_qzhm","String",1,20,null,1,"签证号码"))
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
			
		$("#m_xb").val($("#m_xbdm").attr("title"));
		$("#m_cyzj").val($("#m_cyzjdm").attr("title"));
		
		if($("#m_shengao").val()=="")
			$("#m_shengao").val("0");
		if($("#m_tizh").val()=="")
			$("#m_tizh").val("0");
		return true;
	}
	
	$("#m_gj").click(function(){
		getDict_item("m_gj","m_gjdm","dm_gj(lgy)");
	});
	
	function setUpdate_wgcyry(){
		if (modifyVerify()){
			setParams("m_");
			jQuery.ajax({
				type: 'POST',
				url: modUrl,
				data: params,
				async: false,
				dataType: 'json',
				success: updatewgcyryback
			});
		}else{
			return modifyVerify();
		}
	}
	function updatewgcyryback(json){
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
				jAlert('此证件号码已存在!','验证信息',null,'m_zjhm');
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
		formDiv.find("input").val("");
		formDiv.find("input[type='checkbox']").attr("checked",false);
		formDiv.find("textarea").val("");
		formDiv.find("select").setValue("");
		ctlPicture1.InitPicture();
	}
	
	$("#m_cylbdm").change(function(){
		$("#m_cylb").val($("#m_cylbdm").attr("title"));
	});
	
	function deleteDate(y){
		$('#m_ywx').val("");
		$('#m_zjhm').val("");
 	}
	function updatePicture(y){
		$('#m_fileload').val(x.GetImage());
		$('#m_ywx').val(x.ocrCName);
		$('#m_zjhm').val(x.ocrIdentityId);
		$('#m_xbdm').setValue(x.ocrCSex);
		$('#m_xb').val($('#m_xbdm').attr('title'));
	}
	
	function setPictureBack(x){
 	    $('#m_fileload').val(x.GetImage());
 	}
</script>
<input type="hidden" id="s_ryid">
<input type="hidden" id="q_ryid">
<input type="hidden" id="q_zt" value="m">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_qyid">
<input type="hidden" id="m_fileload" />
<input type="hidden" id="m_hyzk">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="left" class="title1">
			从业人员（境外）修改
		</td>
		<td align="right">
			<a href="#" id="closeDiv"
				onclick='$("#wgcyryxx_detail").hideAndRemove("show");' class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<table width="100%" id="modify">
<tr id="qyryxxTr1" height="20">
		<td class="red">行业类别</td>
		<td class="detailtd"><input type="text" id="hylb" readonly class="readonly"/></td>
		<td class="red">企业名称</td>
		<td class="detailtd"><input type="text" id="qymc" readonly class="readonly"/></td>
	</tr>
	<tr>
		<td width="14%" class="distd">
			人员编号
		</td>
		<td width="24%" class="detailtd">
			<input type="text" class="readonly" id="m_cyrybh" readonly />
		</td>
		<td width="19%" class="distd">
			中文姓名
		</td>
		<td width="21%" class="detailtd">
			<input type="text" class="readonly" id="m_xm" readonly />
		</td>
		<td width="22%" rowspan="14" align="center" valign="top">
			<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
			<tr><td>
			<jsp:include page="qyryPicture.jsp?zh=false&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include>
			</td></tr>
			</table>
	    </td>
	</tr>
	<tr>
		<td class="red">
			英文姓
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_ywx" />
		</td>
		<td class="red">
			英文名
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_ywm" />
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			性别
		</td>
		<td class="detailtd">
			<input type="hidden" id="m_xb" />
			<select id="m_xbdm"></select>
		</td>
		<td class="red">
			出生日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_csrq" />
		</td>
	</tr>
	<tr height="20">
		<td class="red">从业人员类别</td>
		<td  class="detailtd">
			<select id="m_cylbdm"></select>
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			国籍
		</td>
		<td class="detailtd">
			<input type="text" id="m_gj" class="inputstyle" readonly />
			<input type="hidden" id="m_gjdm" />
		</td>
		<td class="distd">
			婚姻状况
		</td>
		<td class="detailtd">
			<select id="m_hyzkdm"></select>
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			就业许可证号
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_wgrjyxkz" />
		</td>
		<td class="red">
			入职日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_rzrq" />
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			证件类型
		</td>
		<td class="detailtd">
			<select id="m_cyzjdm">
				<option></option>
			</select>
			<input type="hidden" id="m_cyzj" />
		</td>
		<td class="red">
			证件号码
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_zjhm" />
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			签证类型
		</td>
		<td class="detailtd">
			<select id="m_qzzldm">
				<option></option>
			</select>
		</td>
		<td class="red">
			签证号码
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_qzhm" />
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			联系电话
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_shouji" />
		</td>
		<td class="distd">
			紧急联系电话
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_jjlxrdh" />
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			身高（厘米）
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_shengao" />
		</td>
		<td class="distd">
			体重(公斤)
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_tizh" />
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			暂住证编号
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_zzzhm" />
		</td>
		<td class="distd">
			职务
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_zhiwu" />
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			暂住地址
		</td>
		<td colspan="4" class="detailtd">
			<input class="inputstyle3" type="text" style="width: 493" id="m_zzdz" />
		</td>
	</tr>
	<tr height="20">
		<td class="distd" valign="top">
			备注
		</td>
		<td colspan="4" class="detailtd">
			<textarea id="m_bz" cols="76" rows="3"></textarea>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="but">
	<tr align="center">
		<td  colspan="5">
			<a id="wtgyy" style="display: none" href="#" hidefocus="true" class="submitlongbutton" title="审核记录"
				onclick='shhistroy();'>审核记录</a>
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setUpdate_wgcyry();'>保存</a>
		</td>
	</tr>
</table>
<div id="wtgyy_detail" class="page-layout" src="#"
	style="z-index: 2000; top: 50px; left: 40px;">