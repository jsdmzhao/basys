<%@ page language="java" pageEncoding="UTF-8"
	import="java.util.*,com.aisino2.sysadmin.domain.User,com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	User user = (User) session.getAttribute(Constants.userKey);
	String name = "";
	String userCount = "";
	if (user != null) {
		name = user.getSsdwmc();
		userCount = user.getSsdwbm();
	}
%>
<%
	Date da = new Date();
	long lo = da.getTime();
%>
<script type="text/javascript">
var fileData,fileId;
var hylbdm;
	$(document).ready(function() {
	  
	  bc_bottonMoveRight(28); 
	  $("#qyryxxTr5").hide();
	  $("#qyryxxTr13").hide();
	  $("#qyryxxTr15").hide();
		$("#wtgyy_detail").hide();
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
		$("#ryid").attr("value",dataid);
		//gy_getselectBox("m_gwbh");
		//$("#m_xxdm").selectBox({code:"dm_xx"});
		$("#m_whcddm").selectBox({code:"dm_xl"});
		//$("#m_gwbh").change(function(){
		//	$("#m_gwmc").val($("#m_gwbh").attr('title'));
		//});
		$("#m_whcddm").change(function(){
			$("#m_whcd").val($("#m_whcddm").attr('title'));
		});
		//$("#m_xxdm").change(function(){
  		//	$("#m_xx").val($("#m_xxdm").attr('title'));
  		//});
		//$("#m_hyzk").selectBox({code:"dm_hyzk"});
		$("#m_xbdm").selectBox({code:"dm_xb"});
		//$("#m_xbdm2").selectBox({code:"dm_cyrylb"});//
  		fileId = "m_fileload";
		setDetail();	
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	}); 
	
	function updatediv (json) { 
	    hylbdm = setNull(json.LQyryxx[0].hylbdm);
		$("#m_whcddm").setValue(setNull(json.LQyryxx[0].whcddm));
		$("#m_whcd").val(setNull(json.LQyryxx[0].whcd));
		$("#m_cyrybh").val(setNull(json.LQyryxx[0].cyrybh));
		$("#m_xm").val(setNull(json.LQyryxx[0].xm));
		//$("#m_xx").val(setNull(json.LQyryxx[0].xx));
		//$("#m_xxdm").setValue(setNull(json.LQyryxx[0].xxdm));
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
		//$("#m_hyzk").setValue(setNull(json.LQyryxx[0].hyzk));
		$("#m_xbdm").setValue(setNull(json.LQyryxx[0].xbdm));
		$("#m_fileload").val(setNull(json.LQyryxx[0].fileload));
		//$("#m_gwmc").val(setNull(json.LQyryxx[0].gwmc));
		//$("#m_gwzrms").val(setNull(json.LQyryxx[0].gwzrms));
		$("#m_hylb").val(setNull(json.LQyryxx[0].hylb));
		$("#m_hylbdm").val(setNull(json.LQyryxx[0].hylbdm));
		//$("#m_gwbh").setValue(setNull(json.LQyryxx[0].gwbh));
		//$("#m_cylbdm").val(setNull(json.LQyryxx[0].cylbdm));
		//$("#m_cylb").val(setNull(json.LQyryxx[0].cylb));
		$("#m_gz").val(setNull(json.LQyryxx[0].gz));
		$("#m_gzdm").val(setNull(json.LQyryxx[0].gzdm));
		initPage();
		$("#img_picControlscr").attr('src','publicsystem/queryTp_qyryxx.action?ryId='+json.LQyryxx[0].ryid+'&aa=<%=lo%>');
		//fileData = setNull(json.LQyryxx[0].fileload);
		//setFile();
		
		
		$("#zpwtgyy").append(setNull(json.LQyryxx[0].zpwtgyy));
		
		var zkzt = setNull(json.LQyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
			
		var zt = setNull(json.LQyryxx[0].shenhe_cyryzt);
		if(zt=='11'){ //显示 未通过原因 按钮
		//	$("#but").attr("width",124);
			document.getElementById('wtgyy').style.display='block';
		}
	}	
function modifyVerify(){

		if($("#m_zjzt").val()==null||$("#m_zjzt").val()=="")
			$("#m_zjzt").val("0");
		if (!checkControlValue("m_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("m_xm","姓名")	)
			return false;
		if (!checkControlValue("m_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("m_whcddm","Select",1,2,null,1,"文化程度"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("m_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,30,null,1,"身份证号码"))
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
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,1,"户籍省县"))
			return false;
		//if (!checkControlValue("m_bm","String",1,30,null,0,"别名"))
		//	return false;
		if (!checkControlValue("m_zzzhm","String",1,20,null,0,"暂住证号"))
			return false;
	    if (!checkControlValue("m_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
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
		//if (!checkControlValue("m_hyzk","String",1,4,null,0,"婚姻状况"))
		//	return false;
		//if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
		//	return false;
		//if (!checkControlValue("m_tizh","Float",-999.99,999.99,2,0,"体重"))
		//	return false;
		//if (!checkControlValue("m_xx","String",1,200,null,1,"血型"))
		//	return false;
		if (!checkControlValue("m_rzrq","String",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("m_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		//if(hylbdm=='C'){
		//    if (!checkControlValue("m_cylb","String",1,50,null,1,"人员类别"))
		//	    return false;
		//}else{
		//    if (!checkControlValue("m_gwmc","String",1,50,null,1,"岗位类别"))
		//	    return false;
	    //}
		//if (!checkControlValue("m_gwzrms","String",1,2000,null,0,"岗位责任描述"))
		//	return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
				
		var returnCardNo = checkIdCardNo("m_zjhm");
		if (returnCardNo)
			$("#m_zjzt").val(0);
		else
			$("#m_zjzt").val(1);	
			
		$("#m_xb").val($("#m_xbdm").attr("title"));
		
		//if($("#m_shengao").val()=="")
		//	$("#m_shengao").val("0");
		//if($("#m_tizh").val()=="")
		//	$("#m_tizh").val("0");
		var rzrq = $("#m_rzrq").attr("value");
	    var lzrq = $("#m_lzrq").attr("value");
	    if(rzrq!=''&&lzrq!=''&&formatDate(rzrq)-formatDate(lzrq)>0){
		    jAlert("请正确选择入职和离职日期!","提示信息");
		    return false;
	    }
		return true;
	}
$("#m_cylb").click(function(){
	        getrylbTree("m_cylb","m_cylbdm","dm_cylb(jxy)");
	});
	
	$("#m_gz").click(function(){
	        getrylbTree("m_gz","m_gzdm","dm_gz(jxy)");
	    });
	    
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

 $("#m_csmc").click(function(){
	getYlcs_item("m_csmc","m_csid","kcyzx");
});

$("#m_zjhm").blur(function(){
	var returnCardNo = checkIdCardNo("m_zjhm");
	if(returnCardNo){
		$("#m_csrq").val(getBirthday($(this).val()));
		$("#m_xbdm").setValue(getXb($(this).val()));
	}else{
		jAlert("身份证号码不正确","验证信息");
	}
	//getHjsx($(this).val(),"m_hjdxzqhdm","m_hjdxzqh");
	getHjsxDD($(this).val(),"dm_xzqh","m_hjdxzqhdm","m_hjdxzqh")
});


function updateAll(){
	//getFile();
	setUpdate_cyry();
}	
	
function setUpdate_cyry(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(modUrl,params,updateback,"json"); 
	}else{
		return modifyVerify();
	}		
}
function updatecyryback(json){
	json.result = json.LQyryxx[0];
	if  (json.result=="success"){
		jAlert(modMessage,'保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else if(json.result=="toicksl"){
		detailUrl="ylfwzagl/query_icksl.action";
		dataid=json.cyryxx.ryid;
		sFlag="false";
		$("#"+detailid).hideAndRemove("slow"); 
		setWidth("icksl_detail",modWidth);
		setUrl("icksl_detail","business/Ylfwzagl/IckslgnDetail.jsp");
		setPageList($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}

$("#m_gwmc").click(function(){
	//getrylbTree("m_gwmc","m_gwbh","dm_cyrylb");
});


	function shhistroy(){ //公安局审核未通过 可以查看审核记录
		$("#wtgyy_detail").empty();
		$("#wtgyy_detail").load("business/Ylfwzagl/ShenHeHistory-cyry.jsp");
		$("#wtgyy_detail").show();
		$("#wtgyy_detail").css("width",520);
	}
		function  deleteDate(y){
	 		 $('#m_xm').val("");
		     $('#m_zjhm').val("");
 	}
 		function updatePicture(y){
		 		 $('#m_fileload').val(x.GetImage());
		 		 $('#m_xm').val(x.ocrCName);
			     $('#m_zjhm').val(x.ocrIdentityId);
			     $('#m_hjdxz').val(x.ocrAddR);
			     $('#m_xbdm').setValue(x.ocrCSex);
			     $('#m_xb').val($('#m_xbdm').attr('title'));
			     var birthday=getBirthday($('#m_zjhm').val());
					if(birthday!=null&&birthday!=''){
						$("#m_csrq").val(birthday);
					}
			     getHjsxDD(x.ocrIdentityId,"dm_xzqh","m_hjdxzqhdm","m_hjdxzqh");
			     getMinZu(x.ocrCNation,"dm_mz","m_mzdm","m_minzu")
 		}
 		
function initPage(){
	    if(hylbdm=='C'){//机修业
		    setBackRemoveObj("blank_");
		    setBackRemoveObj("gz_");
		}else{
		    $("#qyryxxTr11").hide();		    
		}
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
<input type="hidden" id="s_ryid">

<input type="hidden" id="q_ryid">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_cyryzt">
<input type="hidden" id="m_zjzt">
<input type="hidden" id="m_qyid">
<input type="hidden" id="m_hylb">
<input type="hidden" id="m_hylbdm">
<input type="hidden" id="q_zt" value="m">
<input type="hidden" id="m_gzdm" />
<!-- <input type="hidden" id="m_cylbdm"/> -->

<div align="right">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left" class="title1">
				从业人员修改
			</td>
			<td>
				<a href="#" id="closeDiv"
					onclick='$("#cyryxx_detail").hideAndRemove("show");' class="close"></a>
			</td>
		</tr>
		<tr>
			<td align="left"></td>
			<td></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
</div>
<table width="100%" id="modify">
	<tr id="qyryxxTr1" height="20">
		<td id="qymc_title" class="red">
			企业名称
		</td>
		<td id="qymc_data" class="detailtd">
			<input type="text" readonly="readonly" class="readonly"
				value="<%=name%>">
		</td>
		<td id="qybm_title" class="red">
			企业代码
		</td>
		<td id="qybm_data" width="22%" class="detailtd">
			<input type="text" readonly="readonly" class="readonly"
				value="<%=userCount%>">
		</td>
	</tr>
	<tr id="qyryxxTr2" height="20">
		<td id="xm_title" width="12%" class="red">
			姓名
		</td>
		<td id="xm_data" width="22%" class="detailtd">
			<input type="text" class="inputstyle" id="m_xm" value="" />
		</td>
		<td id="xb_title" width="15%" class="red">
			性别
		</td>
		<td id="xb_data" width="22%" class="detailtd">
			<input type="hidden" id="m_xb" />
			<select id="m_xbdm">
				<option></option>
			</select>
		</td>
		<td width="27%" rowspan="12" align="center" valign="top">
			<table width="35%" border="0" align="center" cellpadding="8"
				cellspacing="0">
				<input type="hidden" id="m_fileload" />
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
	<tr id="qyryxxTr3" height="20">
		<td id="whcd_title" class="red">
			文化程度
		</td>
		<td id="whcd_data" class="detailtd">
			<select id="m_whcddm">
				<option></option>
			</select>
			<input type="hidden" id="m_whcd" />
		</td>
		<td id="mz_title" class="red">
			民族
		</td>
		<td id="mz_data" class="detailtd">
			<input type="text" id="m_minzu" readonly class="inputstyle" />
			<input type="hidden" id="m_mzdm" />
		</td>
	</tr>
	<tr id="qyryxxTr4" height="20">
		<td id="cyrybh_title" class="distd">
			人员编号
		</td>
		<td id="cyrybh_data" class="detailtd">
			<input type="text" class="readonly" id="m_cyrybh" readonly />
		</td>
		<td id="zjhm_title" class="red">
			公民身份号码
		</td>
		<td id="zjhm_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_zjhm" />
		</td>
	</tr>
	<tr id="qyryxxTr5" height="20">
		<td id="hyzk_title" class="distd">
			婚姻状况
		</td>
		<td id="hyzk_data" class="detailtd">
			<select name="select5" id="m_hyzk">
				<option></option>
			</select>
		</td>
	</tr>
	<tr id="qyryxxTr6" height="20">
		<td id="csrq_title" class="red">
			出生日期
		</td>
		<td id="csrq_data" class="detailtd">
			<!--  <select name="select"  id="m_xbdm2" onchange="setChildm2();">
				  </select>-->
			<input type="text" class="inputstyle" id="m_csrq" value="" />
		</td>
		<td id="hjdxzqh_title" class="red">
			户籍省县
		</td>
		<td id="hjdxzqh_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_hjdxzqh" readonly />
			<input type="hidden" id="m_hjdxzqhdm" />
			<!--  select name="select4" id="m_hjdxzqh">
        </select-->
		</td>
	</tr>
	<tr id="qyryxxTr7" height="20">
		<td id="zzzhm_title" class="distd">
			暂住证号
		</td>
		<td id="zzzhm_data" colspan="3" class="detailtd">
			<input type="text" style="width: 450" class="inputstyle3"
				id="m_zzzhm" />
		</td>
	</tr>
	<tr id="qyryxxTr8" height="20">
		<td id="hjdxz_title" class="red">
			户籍地详址
		</td>
		<td id="hjdxz_data" colspan="3" class="detailtd">
			<input type="text" style="width: 450" class="inputstyle3"
				id="m_hjdxz" />
		</td>
		<!-- 	<td id="xx_title" class="red">血型</td>
	<td id="xx_data" class="detailtd">
	  <input type="hidden"   id="m_xx" />
	  <select id="m_xxdm"><option></option></select>
	  </td>
	<td id="bm_title" class="distd">别名</td>
	 <td id="bm_data" class="detailtd"><input type="text" class="inputstyle" id="m_bm" /></td>
	  -->
	</tr>

	<tr id="qyryxxTr9" height="20">
		<td id="zzdz_title" class="red">
			现住址
		</td>
		<td id="zzdz_data" class="detailtd" colspan="3">
			<input type="text" class="inputstyle3" id="m_zzdz"
				style="width: 450;" />
		</td>
	</tr>
	<tr id="qyryxxTr10" height="20">
		<!--  <td id="rylb_title" class="red">人员类别</td>
		<td id="rylb_data" class="detailtd"><input type="text" id="m_cylb" class="inputstyle" readonly /></td>
		<td id="gwlb_title" class="red">岗位类别</td>
	  <td id="gwlb_data" class="detailtd">
	  <input type="hidden" id="m_gwmc" class="inputstyle" readonly />
	  <select id="m_gwbh" />
	  -->
		<td id="sj_title" class="red">
			手机
		</td>
		<td id="sj_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_shouji" />
		</td>
		<td id="zw_title" class="red">
			职务
		</td>
		<td id="zw_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_zhiwu" />
		</td>
	</tr>
	<tr id="qyryxxTr11" height="20">
		<td id="gz_title" class="red">
			工种
		</td>
		<td id="gz_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_gz" readonly />
		</td>
		<td id="blank_title" class="distd">
			&nbsp;
		</td>
		<td id="blank_data" class="detailtd">
			&nbsp;
		</td>
	</tr>
	<tr id="qyryxxTr12" height="20">
		<td id="jjlxr_title" class="distd">
			紧急联系人
		</td>
		<td id="jjlxr_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_jjlxr" />
		</td>
		<td id="jjlxrdh_title" class="distd">
			紧急联系电话
		</td>
		<td id="jjlxrdh_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_jjlxrdh" />
		</td>
	</tr>
	<tr id="qyryxxTr13" height="20">
		<td id="sg_title" class="distd">
			身高（厘米）
		</td>
		<td id="sg_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_shengao" />
		</td>
		<td id="tz_title" class="distd">
			体重(公斤)
		</td>
		<td id="tz_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_tizh" />
		</td>
	</tr>
	<tr id="qyryxxTr14" height="20">
		<td id="rzrq_title" class="red">
			入职日期
		</td>
		<td id="rzrq_data" class="detailtd">
			<input type="text" class="inputstyle" id="m_rzrq" />
		</td>
		<td id="lzrq_title" class="distd">
			离职日期
		</td>
		<td id="lzrq_data" class="detailtd">
			<input type="text" id="m_lzrq" class="inputstyle" />
		</td>
	</tr>
	<tr id="qyryxxTr15" height="20">
		<td colspan="5" class="distd">
			<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td id="gwzrms_title" width="12%" class="distd" valign="top">
						岗位责任描述
					</td>
					<td id="gwzrms_data" width="88%" class="detailtd">
						<textarea id="m_gwzrms" cols="81" rows="3"></textarea>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr id="qyryxxTr16" height="20">
		<td colspan="5" class="distd">
			<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td id="bz_title" width="12%" class="distd" valign="top">
						备注
					</td>
					<td id="bz_data" width="88%" class="detailtd">
						<textarea id="m_bz" cols="81" rows="3"></textarea>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr id="tr_zpwtgyy" style="display: none">
		<td width="12%" class="distd" valign="top">
			照片未通过原因
		</td>
		<td width="88%" class="detailtd">
			<textarea id="zpwtgyy" cols="81" rows="3"></textarea>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="but">
	<tr align="center">
		<td>
			<a href="#" id="wtgyy" style="display: none" hidefocus="true"
				class="submitbutton" title="审核记录" onclick='shhistroy();'>审核记录</a>
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='updateAll();'>保存</a>
		</td>
	</tr>
</table>
<div id="wtgyy_detail" class="page-layout" src="#"
	style="z-index: 2000; top: 50px; left: 40px;">