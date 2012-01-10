<%@ page language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.Date"%>
<% Date da=new Date(); long lo=da.getTime(); %>
<script type="text/javascript">
var hylbdm;
	$(document).ready(function() {
	bc_bottonMoveRight(23); 
	 $("#qyryxxTr5").hide();
	 $("#qyryxxTr8").hide();
	 $("#qyryxxTr13").hide();
	 $("#qyryxxTr16").hide();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_rzrq").attr("readonly","true");
		$("#m_rzrq").datepicker();
		$("#m_lzrq").attr("readonly","true");
		$("#m_lzrq").datepicker();
		$("#m_zxsj").attr("readonly","true");
		$("#m_zxsj").datepicker();
		$("#m_hcsj").attr("readonly","true");
		$("#m_hcsj").datepicker();
		$("#m_bcsj").attr("readonly","true");
		$("#m_bcsj").datepicker();
		
		$("#s_ryid").attr("value",dataid);
		$("#q_ryid").attr("value",dataid);
		$("#m_ryid").attr("value",dataid);
		
  		$("#m_whcddm").selectBox({code:"dm_xl"});
  		//$("#m_hyzkdm").selectBox({code:"dm_hyzk"});
  		//$("#m_xxdm").selectBox({code:"dm_xx"});
  		$("#m_xbdm").selectBox({code:"dm_xb"});
		//setDetail();
		
	}).keydown(function(){
		if(event.keyCode == 13) event.keyCode = 9;
	});
	
	$("#m_cylb").click(function(){
	        getrylbTree("m_cylb","m_cylbdm","dm_cylb(jxy)");
	});
	
	$("#m_gz").click(function(){
	        getrylbTree("m_gz","m_gzdm","dm_gz(jxy)");
	    });
	
	$("#m_minzu").click(function(){
		getDict_item("m_minzu","m_mzdm","dm_mz");
	});
	$("#m_hjdxzqh").click(function(){
		getDict_item("m_hjdxzqh","m_hjdxzqhdm","dm_xzqh");
	});
	//$("#m_gwbh").change(function(){
	//	$("#m_gwmc").val($("#m_gwbh").attr('title'));
	//});
	//$("#m_hyzkdm").change(function(){
  	//	$("#m_hyzk").val($("#m_hyzkdm").attr('title'));
	//});
	//$("#m_xxdm").change(function(){
	//	$("#m_xx").val($("#m_xxdm").attr('title'));
	//});
	$("#m_whcddm").change(function(){
		$("#m_whcd").val($("#m_whcddm").attr('title'));
	});
	$("#m_xbdm").change(function(){
		$("#m_xb").val($("#m_xbdm").attr("title"));
	});
	
	function initPage(){
	    if(hylbdm=='C'){//机修业
		    //setRemoveObj("gwlb_");
		    //setRemoveObj("blank_");
		    //setBackRemoveObj("rylb_");
		    //setBackRemoveObj("gz_");
		    $("#qyryxxTr14").show();
		}else{
		    //setRemoveObj("rylb_");
		    //setRemoveObj("gz_");
		    //setBackRemoveObj("gwlb_");
		    //setBackRemoveObj("blank_");
		    $("#qyryxxTr14").hide();
		}
	}
	
	function updatediv (json) {
		hylbdm = setNull(json.LQyryxx[0].hylbdm);
	 	
		$("#m_whcddm").setValue(setNull(json.LQyryxx[0].whcddm));
		$("#m_xxdm").setValue(setNull(json.LQyryxx[0].xxdm));
		//$("#m_gwbh").setValue(setNull(json.LQyryxx[0].gwbh));
		$("#m_hyzkdm").setValue(setNull(json.LQyryxx[0].hyzkdm));
		$("#m_xbdm").setValue(setNull(json.LQyryxx[0].xbdm));
		$("#hylb").val(setNull(json.LQyryxx[0].hylb));
		$("#qymc").val(setNull(json.LQyryxx[0].qymc));
		
		$("#m_qybm").val(setNull(json.LQyryxx[0].qybm));
		//$("#m_hyzk").val(setNull(json.LQyryxx[0].m_hyzk));
		$("#m_whcd").val(setNull(json.LQyryxx[0].whcd));
		$("#m_cyrybh").val(setNull(json.LQyryxx[0].cyrybh));
		$("#m_xm").val(setNull(json.LQyryxx[0].xm));
		//$("#m_xx").val(setNull(json.LQyryxx[0].xx));
		//$("#m_bm").val(setNull(json.LQyryxx[0].bm));
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
		$("#m_jjlxr").val(setNull(json.LQyryxx[0].jjlxr));
		$("#m_zhiwu").val(setNull(json.LQyryxx[0].zhiwu));
		if(json.LQyryxx[0].rzrq!=null)
			$("#m_rzrq").val(setNull(json.LQyryxx[0].rzrq.substr(0,10)));
		if(json.LQyryxx[0].lzrq!=null)
			$("#m_lzrq").val(setNull(json.LQyryxx[0].lzrq.substr(0,10)));
		$("#m_zxr").val(setNull(json.LQyryxx[0].zxr));
		if(json.LQyryxx[0].zxsj!=null)
			$("#m_zxsj").val(setNull(json.LQyryxx[0].zxsj.substr(0,10)));
		if(json.LQyryxx[0].cjsj!=null)
			$("#m_cjsj").val(setNull(json.LQyryxx[0].cjsj.substr(0,10)));
		$("#m_cjr").val(setNull(json.LQyryxx[0].cjr));
		$("#m_hcdw").val(setNull(json.LQyryxx[0].hcdw));
		$("#m_zxyy").val(setNull(json.LQyryxx[0].zxyy));
		$("#m_cyryzt").val(setNull(json.LQyryxx[0].cyryzt));
		$("#m_zjzt").val(setNull(json.LQyryxx[0].zjzt));
		$("#m_scbz").val(setNull(json.LQyryxx[0].scbz));
		$("#m_qyid").val(setNull(json.LQyryxx[0].qyid));
		$("#m_xb").val(setNull(json.LQyryxx[0].xb));
		$("#m_cyrylbmc").val(setNull(json.LQyryxx[0].cyrylbmc));
		$("#m_csmc").val(setNull(json.LQyryxx[0].csmc));
		//$("#m_shengao").val(setNull(json.LQyryxx[0].shengao));
		//$("#m_tizh").val(setNull(json.LQyryxx[0].tizh));
		$("#m_bz").val(setNull(json.LQyryxx[0].bz));
		$("#m_cyrylbdm").val(setNull(json.LQyryxx[0].cyrylbdm));
		
		$("#m_fileload").val(setNull(json.LQyryxx[0].fileload));
		//$("#m_gwmc").val(setNull(json.LQyryxx[0].gwmc));
		//$("#m_cylbdm").val(setNull(json.LQyryxx[0].cylbdm));
		//$("#m_cylb").val(setNull(json.LQyryxx[0].cylb));
		$("#m_gz").val(setNull(json.LQyryxx[0].gz));
		$("#m_gzdm").val(setNull(json.LQyryxx[0].gzdm));
		//$("#m_gwzrms").val(setNull(json.LQyryxx[0].gwzrms));
		initPage();
		$("#img_picControlscr").attr('src','publicsystem/queryTp_qyryxx.action?ryId='+json.LQyryxx[0].ryid+'&aa=<%=lo %>');
		
		$("#zpwtgyy").append(setNull(json.LQyryxx[0].zpwtgyy));
		
		var zkzt = setNull(json.LQyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
	}
	
	function modifyVerify(){
		if (!checkControlValue("m_minzu","String",1,60,null,1,"企业名称"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("m_xm","姓名"))
			return false;
		if (!checkControlValue("m_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("m_whcddm","Select",1,2,null,1,"文化程度"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,30,null,1,"身份证号码"))
			return false;
		//if (!checkControlValue("m_bm","String",1,30,null,0,"别名"))
		//	return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,1,"出生日期"))
			return false;
		
		var tenYearAgo = new Date();
		tenYearAgo.setYear(tenYearAgo.getYear() - 10);
		var tenYearAgoStr = tenYearAgo.getFullYear()+"-"+(tenYearAgo.getMonth()+1)+"-"+tenYearAgo.getDate();
		if(!checkTwoDateEarlier($("#m_csrq").val(),tenYearAgoStr)){
			jAlert("出生日期必须小于"+tenYearAgoStr+"！",'验证信息',null,"m_csrq");
			return false;
		}
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,1,"户籍省县"))
			return false;
		if (!checkControlValue("m_zzzhm","String",1,20,null,0,"暂住证号"))
			return false;
		if (!checkControlValue("m_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		//if (!checkControlValue("m_hyzkdm","Select",1,4,null,0,"婚姻状况"))
		//	return false;
		if (!checkControlValue("m_zzdz","String",1,200,null,1,"现住址"))
			return false;
		if (!checkControlValue("m_shouji","String",1,20,null,1,"手机"))
			return false;
		if (!checkControlValue("m_zhiwu","String",1,20,null,1,"职务"))
			return false;
		if(hylbdm=='C'){
		     if (!checkControlValue("m_gz","String",1,60,null,1,"工种"))
			     return false;
		}
		if (!checkControlValue("m_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		if (!checkControlValue("m_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
		if (!checkControlValue("m_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("m_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		//if (!checkControlValue("m_xxdm","Select",1,200,null,1,"血型"))
		//	return false;
		//if(hylbdm=='C'){
		//    if (!checkControlValue("m_cylb","String",1,50,null,1,"人员类别"))
		//	return false;
		//}else{
		//    if (!checkControlValue("m_gwbh","Select",1,50,null,1,"岗位类别"))
		//	return false;
		//}
		//if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
		//	return false;
		//if (!checkControlValue("m_tizh","Float",-999.99,999.99,2,0,"体重"))
		//	return false;
		//if (!checkControlValue("m_gwzrms","String",1,2000,null,0,"岗位责任描述"))
		//	return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		var returnCardNo = checkIdCardNo("m_zjhm");
		if(returnCardNo){
			$("#m_zjzt").val(0);
		}else{
			$("#m_zjzt").val(1);
		}
		
		//if($("#m_shengao").val()==""){ $("#m_shengao").val("0"); }
		//if($("#m_tizh").val()==""){ $("#m_tizh").val("0"); }
		var rzrq = $("#m_rzrq").attr("value");
	    var lzrq = $("#m_lzrq").attr("value");
	    if(rzrq!=''&&lzrq!=''&&formatDate(rzrq)-formatDate(lzrq)>0){
		    jAlert("请正确选择入职和离职日期!","提示信息");
		    return false;
	    }
		return true;
	}   

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
				$("#m_xb").val($("#m_xbdm").attr("title"));
			}
		}else{
			jAlert("身份证号码不正确","验证信息");
		}
		getHjsxDD($(this).val(),"dm_xzqh","m_hjdxzqhdm","m_hjdxzqh")
	});

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
	
	function setTrAppendTd(trid,smallId){
		$("td[id^='"+smallId+"']").each(function(){
			$(this).appendTo($("#"+trid));
		});
	}
	function setRemoveObj(removeid){
		$("td[id^='"+removeid+"']").each(function(){
			$(this).hide();
		});
	}
	function setBackRemoveObj(removeid){
		$("td[id^='"+removeid+"']").each(function(){
			$(this).show();
		});
	}
	// 转换成日期格式
    function formatDate(strDate){ 
	    var riqi = strDate.split("-");
	    return new Date(riqi[0],(riqi[1]-1),riqi[2]);
    }
</script>
<div id="clearDiv"/>
<input type="hidden" id="s_ryid">
<input type="hidden" id="q_ryid">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_qyid">
<input type="hidden" id="m_zjzt"/>
<input type="hidden" id="m_fileload"/>
<input type="hidden" id="m_xb"/>
<!-- <input type="hidden" id="m_qybm"/> -->
<input type="hidden" id="m_hyzk"/>
<input type="hidden" id="m_mzdm"/>
<input type="hidden" id="m_hjdxzqhdm"/>
<input type="hidden" id="m_xx">
<input type="hidden" id="m_whcd"/>
<input type="hidden" id="m_gzdm" />
<!-- 
<input type="hidden" id="m_gwmc"/>
<input type="hidden" id="m_cylbdm"/>
 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
      <td align="left" class="title1">从业人员修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#cyryxx_detail").hideAndRemove("show");'class="close"></a></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>

<table width="100%" cellpadding="2" cellspacing="0" id="add">
	<tr id="qyryxxTr1" height="20">
		<td id="hylbdm_title" class="red">行业类别</td>
		<td id="hylbdm_data" class="detailtd"><input type="text" id="hylb" readonly class="readonly"/></td>
		<td id="qymc_title" class="red">企业名称</td>
		<td id="qymc_data" class="detailtd"><input type="text" id="qymc" readonly class="readonly"/></td>
	</tr>
	<tr id="qyryxxTr2" height="20">
		<td id="qybm_title" width="12%" class="red">企业代码</td>
	    <td id="qybm_data" width="22%" class="detailtd"><input type="text" readonly="readonly" id="m_qybm" class="readonly"> </td>
	    <td id="xm_title" width="15%" class="red">姓名</td>
		<td id="xm_data" width="22%" class="detailtd"><input type="text" class="inputstyle" id="m_xm"/></td>
		<td width="27%" rowspan="12" align="center" valign="top">
			<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
	        <tr><td><jsp:include page="qyryPicture.jsp?zh=true&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include>
	        </td></tr>
	      	</table></td>
	</tr>
	<tr id="qyryxxTr3" height="20">
		<td id="xb_title" class="red">性别</td>
		<td id="xb_data" class="detailtd"><select id="m_xbdm"><option></option></select></td>
		<td id="whcd_title" class="red">文化程度</td>
		<td id="whcd_data" class="detailtd"><select id="m_whcddm"><option></option></select></td>
    </tr>
	<tr id="qyryxxTr4" height="20">
		<td id="mz_title" class="red">民族</td>
		<td id="mz_data" class="detailtd"><input type="text" id="m_minzu" class="inputstyle" readonly/></td>
		<td id="cyrybh_title" class="distd">人员编号</td>
		<td id="cyrybh_data" class="detailtd"><input type="text" class="inputstyle" id="m_cyrybh" readonly/></td>
	</tr>
	<tr id="qyryxxTr5" height="20">
		<td id="hyzk_title" class="distd">婚姻状况</td>
		<td id="hyzk_data" class="detailtd"><select name="select5" id="m_hyzkdm"><option></option></select></td>
    </tr>
	<tr id="qyryxxTr6" height="20">
	    <td id="zjhm_title" class="red">公民身份号码</td>
		<td id="zjhm_data" class="detailtd"><input type="text" class="inputstyle" id="m_zjhm"/></td>
		<td id="csrq_title" class="red">出生日期</td>
		<td id="csrq_data" class="detailtd"><input type="text" class="inputstyle" id="m_csrq"/></td>
    </tr>
    <tr id="qyryxxTr7" height="20">
        <td id="hjdxzqh_title" class="red">户籍省县</td>
		<td id="hjdxzqh_data" class="detailtd"><input type="text" class="inputstyle" id="m_hjdxzqh" readonly/></td>
		<td id="zzzhm_title" class="distd">暂住证号</td>
		<td id="zzzhm_data" class="detailtd"><input type="text" class="inputstyle" id="m_zzzhm"/></td>
    </tr>
    <tr id="qyryxxTr12" height="20">
	    <td id="hjdxz_title" class="red">户籍地详址</td>
		<td id="hjdxz_data" colspan="3"  class="detailtd"><input type="text" style="width:450" class="inputstyle3" id="m_hjdxz"   /></td>
	   <!--  <td id="rylb_title" class="red">人员类别</td>
		<td id="rylb_data" class="detailtd"><input type="text" id="m_cylb" class="inputstyle" readonly /></td>
	    <td id="gwlb_title" class="red">岗位类别</td>
		<td id="gwlb_data" class="detailtd"><select type="text" id="m_gwbh"><option></option></select></td>
		 -->
    </tr>
    <tr id="qyryxxTr8" height="20">
        <td id="xx_title" class="red">血型</td>
		<td id="xx_data" class="detailtd"><select id="m_xxdm"><option></option></select></td> 
		<td id="bm_title" class="distd">别名</td>
		<td id="bm_data" class="detailtd"><input type="text" class="inputstyle" id="m_bm"/></td>
    </tr>
    <tr id="qyryxxTr15" height="20">
		<td id="zzdz_title" class="red">现住址</td>
		<td id="zzdz_data" colspan="3" class="detailtd"><input type="text" style="width:450" class="inputstyle3" id="m_zzdz"/></td>
	</tr>
	<tr id="qyryxxTr10" height="20">
		<td id="sj_title" class="red">手机</td>
		<td id="sj_data" class="detailtd"><input type="text" class="inputstyle" id="m_shouji"/></td>
		<td id="zw_title" class="red">职务</td>
		<td id="zw_data" class="detailtd"><input type="text" class="inputstyle" id="m_zhiwu"/></td>
    </tr>
    <tr id="qyryxxTr14" height="20">
		<td id="gz_title" class="red">工种</td>
		<td id="gz_data" class="detailtd"><input type="text" class="inputstyle" id="m_gz" readonly/></td>
		<td id="blank_title" class="distd">&nbsp;</td>
		<td id="blank_data" class="detailtd">&nbsp;</td>
	</tr>
	<tr id="qyryxxTr11" height="20">
	    <td id="jjlxr_title" class="distd">紧急联系人</td>
		<td id="jjlxr_data" class="detailtd"><input type="text" class="inputstyle" id="m_jjlxr"/></td>
		<td id="jjlxrdh_title" class="distd">紧急联系电话</td>
		<td id="jjlxrdh_data" class="detailtd"><input type="text" class="inputstyle" id="m_jjlxrdh"/></td>
	</tr>
	<tr id="qyryxxTr9" height="20">
		<td id="rzrq_title" class="red">入职日期</td>
		<td id="rzrq_data" class="detailtd"><input type="text" id="m_rzrq" class="inputstyle"/></td>
		<td id="lzrq_title" class="distd">离职日期</td>
		<td id="lzrq_data" class="detailtd"><input type="text" id="m_lzrq" class="inputstyle"/></td>
	</tr>
	<tr id="qyryxxTr13" height="20">
		<td id="sg_title" class="distd">身高（厘米）</td>
		<td id="sg_data" class="detailtd"><input type="text" class="inputstyle" id="m_shengao"/></td>
		<td id="tz_title" class="distd">体重(公斤)</td>
		<td id="tz_data" class="detailtd"><input type="text" class="inputstyle" id="m_tizh"/></td>
	</tr>
	<tr id="qyryxxTr16" height="20">
		<td colspan="5" class="distd">
		<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
            <td id="gwzrms_title" width="12%" class="distd" valign="top">岗位责任描述 </td>
            <td id="gwzrms_data" width="88%" class="detailtd"><textarea name="textarea2" id="m_gwzrms" cols="78" rows="3"></textarea></td>
			</tr>
        </table></td>
	</tr>
	<tr id="qyryxxTr17" height="20">
		<td colspan="5" class="distd">
		<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
            <td id="bz_title" width="12%" class="distd" valign="top">备注 </td>
            <td id="bz_data" width="88%" class="detailtd"><textarea name="textarea2" id="m_bz" cols="78" rows="3"></textarea></td>
			</tr>
        </table></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="5">
		<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate_cyry();'>保存</a>
	</td></tr>
</table>
