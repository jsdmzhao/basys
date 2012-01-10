<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,com.aisino2.sysadmin.domain.User,com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	 User user= (User)session.getAttribute(Constants.userKey);
	    String name="";
	    String userCount="";
	    if(user!=null){
	    	name=user.getSsdwmc();
	    	userCount=user.getSsdwbm();
	    }
 %>
<%
Date da=new Date();
		long lo=da.getTime();
 %>
<script type="text/javascript">
var fileData,fileId;
var hylbdm;
	$(document).ready(function() {
	
	  bc_bottonMoveRight(20); 
	    $("#qyryxxTr8").hide();
	    $("#qyryxxTr14").hide();
	    $("#qyryxxTr15").hide();
	    $("#qyryxxTr18").hide();
	
		$("#wtgyy_detail").hide();
		$("#s_ryid").attr("value",dataid);
		$("#q_ryid").attr("value",dataid);
		$("#m_ryid").attr("value",dataid);
		$("#m_zatlq").attr("readonly","true");
		$("#m_zatlq").datepicker();
		$("#m_rjrq").attr("readonly","true");
		$("#m_rjrq").datepicker();	
		$("#m_rzrq").attr("readonly","true");
		$("#m_rzrq").datepicker();
		$("#m_lzrq").attr("readonly","true");
		$("#m_lzrq").datepicker();
		//$("#m_xxdm").selectBox({code:"dm_xx"});
  		//$("#m_xxdm").change(function(){
  		//	$("#m_xx").val($("#m_xxdm").attr('title'));
  		//});
  		//$("#m_hyzkdm").selectBox({code:"dm_hyzk"});
  		
  		$("#m_xbdm").selectBox({code:"dm_xb"});
  		$("#m_qzzldm").selectBox({code:"dm_qzzl(lgy)"});
  		$("#m_cyzjdm").selectBox({code:"dm_hz"});
  		
  		$("#m_whcddm").selectBox({code:"dm_xl"});
  		$("#m_whcddm").change(function(){
  			$("#m_whcd").val($("#m_whcddm").attr('title'));	
  		});
  		//$("#m_hyzkdm").change(function(){
  		//	$("#m_hyzk").val($("#m_hyzkdm").attr('title'));	
  		//});
  	    //gy_getselectBox("m_gwbh");
		//$("#m_gwbh").change(function(){
		//	$("#m_gwmc").val($("#m_gwbh").attr('title'));
		//});
  		fileId="m_fileload";
		setDetail();
	}); 
	function updatediv (json) { 
	    hylbdm = setNull(json.LWgcyryxx[0].hylbdm);
		$("#m_whcddm").setValue(setNull(json.LWgcyryxx[0].whcddm));
		$("#m_whcd").val(setNull(json.LWgcyryxx[0].whcd));
		$("#m_cyrybh").val(setNull(json.LWgcyryxx[0].cyrybh));
		$("#m_xm").val(setNull(json.LWgcyryxx[0].xm));
		$("#m_xb").val(setNull(json.LWgcyryxx[0].xb));
		//$("#m_gwmc").val(setNull(json.LWgcyryxx[0].gwmc));
		//$("#m_gwbh").setValue(setNull(json.LWgcyryxx[0].gwbh));
		$("#m_jjlxrdh").val(setNull(json.LWgcyryxx[0].jjlxrdh));
		$("#m_jjlxr").val(setNull(json.LWgcyryxx[0].jjlxr));
		$("#m_hyzkdm").setValue(setNull(json.LWgcyryxx[0].hyzkdm));
		//$("#m_csrq").val(setNull(json.LWgcyryxx[0].csrq));
		if(json.LWgcyryxx[0].csrq!=null)
			$("#m_csrq").val(setNull(json.LWgcyryxx[0].csrq.substr(0,10)));
		$("#m_zzzhm").val(setNull(json.LWgcyryxx[0].zzzhm));
		$("#m_zzdz").val(setNull(json.LWgcyryxx[0].zzdz));
		$("#m_shouji").val(setNull(json.LWgcyryxx[0].shouji));
		$("#m_qtlxdh").val(setNull(json.LWgcyryxx[0].qtlxdh));
		$("#m_zhiwu").val(setNull(json.LWgcyryxx[0].zhiwu));
		//$("#m_rzrq").val(setNull(json.LWgcyryxx[0].rzrq));
		if(json.LWgcyryxx[0].rzrq!=null)
			$("#m_rzrq").val(setNull(json.LWgcyryxx[0].rzrq.substr(0,10)));
		if(json.LWgcyryxx[0].lzrq!=null)
			$("#m_lzrq").val(setNull(json.LWgcyryxx[0].lzrq.substr(0,10)));
		if(json.LWgcyryxx[0].zatlq!=null)
			$("#m_zatlq").val(setNull(json.LWgcyryxx[0].zatlq.substr(0,10)));
		$("#m_zxr").val(setNull(json.LWgcyryxx[0].zxr));
		//$("#m_zxsj").val(setNull(json.LWgcyryxx[0].zxsj));
		//$("#m_cjsj").val(setNull(json.LWgcyryxx[0].cjsj));
		$("#m_cjr").val(setNull(json.LWgcyryxx[0].cjr));
		$("#m_hcdw").val(setNull(json.LWgcyryxx[0].hcdw));
		$("#m_zxyy").val(setNull(json.LWgcyryxx[0].zxyy));
		//$("#m_zt").val(setNull(json.LWgcyryxx[0].zt));
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
		$("#m_cjdmc").val(setNull(json.LWgcyryxx[0].cjdmc));
		$("#m_cylb").val(setNull(json.LWgcyryxx[0].cylb));
		$("#m_qyid").val(setNull(json.LWgcyryxx[0].qyid));
		$("#m_csmc").val(setNull(json.LWgcyryxx[0].csmc));
		$("#m_cyryzt").val(setNull(json.LWgcyryxx[0].cyryzt));
		$("#m_shengao").val(setNull(json.LWgcyryxx[0].shengao));
		$("#m_tizh").val(setNull(json.LWgcyryxx[0].tizh));
		$("#m_bz").val(setNull(json.LWgcyryxx[0].bz));
		$("#m_gwzrms").val(setNull(json.LWgcyryxx[0].gwzrms));
		
		$("#m_hylb").val(setNull(json.LWgcyryxx[0].hylb));
		$("#m_hylbdm").val(setNull(json.LWgcyryxx[0].hylbdm));
		
		$("#m_cylbdm").val(setNull(json.LWgcyryxx[0].cylbdm));
  		$("#m_hyzk").val(setNull(json.LWgcyryxx[0].hyzk));
  		$("#m_xbdm").setValue(setNull(json.LWgcyryxx[0].xbdm));
  		$("#m_qzzldm").setValue(setNull(json.LWgcyryxx[0].qzzldm));
  		$("#m_cyzjdm").setValue(setNull(json.LWgcyryxx[0].cyzjdm));
  		$("#m_bz").val(setNull(json.LWgcyryxx[0].bz));
  		$("#m_xx").val(setNull(json.LWgcyryxx[0].xx));
  		$("#m_xxdm").setValue(setNull(json.LWgcyryxx[0].xxdm));
  		//$("#m_cylbdm").val(setNull(json.LWgcyryxx[0].cylbdm));
		//$("#m_cylb").val(setNull(json.LWgcyryxx[0].cylb));
		$("#m_gz").val(setNull(json.LWgcyryxx[0].gz));
		$("#m_gzdm").val(setNull(json.LWgcyryxx[0].gzdm));
		initPage();
  		//$("#m_fileload").val(setNull(json.LWgcyryxx[0].fileload));
		//fileData = setNull(json.LWgcyryxx[0].fileload);
		//setFile();
		$("#img_picControlscr").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LWgcyryxx[0].ryid+'&aa=<%=lo %>');
		$("#zpwtgyy").append(setNull(json.LWgcyryxx[0].zpwtgyy));
		
		var zkzt = setNull(json.LWgcyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
			
		var zt = setNull(json.LWgcyryxx[0].shenhe_cyryzt);
		if(zt=='11'){ //显示 未通过原因 按钮
		//	$("#but").attr("width",124);
			document.getElementById('wtgyy').style.display='block';
		}
	}	
	
	function modifyVerify(){
	    if (!checkControlValue("m_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
	    if (!checkControlValue("m_xm","String",1,100,null,0,"中文姓名"))
			return false;
		if (!checkControlValue("m_ywx","String",1,100,null,1,"英文姓"))
			return false;
		if (!checkControlValue("m_ywm","String",1,100,null,1,"英文名"))
			return false;
		if (!checkControlValue("m_gj","String",1,100,null,1,"国籍"))
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
		if (!checkControlValue("m_cyzjdm","Select",1,4,null,1,"证件类型"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,1,"证件号码"))
			return false;
		if (!checkControlValue("m_qzzldm","Select",1,4,null,1,"签证类型"))
			return false;
		if (!checkControlValue("m_qzhm","String",1,20,null,1,"签证号码"))
			return false;
		if (!checkControlValue("m_wgrjyxkz","String",1,30,null,1,"就业许可证号"))
			return false;
		if (!checkControlValue("m_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("m_shouji","String",1,20,null,1,"手机"))
			return false;
		if (!checkControlValue("m_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
		if (!checkControlValue("m_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		//if(hylbdm=='C'){
		//    if (!checkControlValue("m_cylb","String",1,50,null,1,"人员类别"))
		//	    return false;
		//}else{
		//    if (!checkControlValue("m_gwbh","Select",1,50,null,1,"岗位类别"))
		//	    return false;
		//}
		if (!checkControlValue("m_zhiwu","String",1,20,null,1,"职务"))
			return false;
		//if (!checkControlValue("m_hyzk","String",1,4,null,0,"婚姻状况"))
		//	return false;
		//if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
		//	return false;
		//if (!checkControlValue("m_tizh","Float",-999.99,999.99,2,0,"体重"))
		//	return false;
		//if (!checkControlValue("m_zzzhm","String",1,20,null,0,"暂住证编号"))
		//	return false;
		//if (!checkControlValue("m_xx","String",1,20,null,1,"血型"))
		//	return false;
		if(hylbdm=='C'){
		    if (!checkControlValue("m_gz","String",1,60,null,1,"工种"))
			    return false;
		}
		if (!checkControlValue("m_zzdz","String",1,200,null,1,"现住址"))
			return false;
		//if (!checkControlValue("m_gwzrms","String",1,2000,null,0,"岗位责任描述"))
		//	return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
			
		$("#m_xb").val($("#m_xbdm").attr("title"));
		$("#m_cyzj").val($("#m_cyzjdm").attr("title"));
		
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
	
	function initPage(){
	    if(hylbdm=='C'){//机修业
		    //setRemoveObj("gwlb_");
		    //setRemoveObj("blank_");
		    //setBackRemoveObj("rylb_");
		    //setBackRemoveObj("gz_");
		    $("#qyryxxTr16").show();
		}else{
		    //setRemoveObj("rylb_");
		    //setRemoveObj("gz_");
		    //setBackRemoveObj("gwlb_");
		    //setBackRemoveObj("blank_");
		    $("#qyryxxTr16").hide();
		}
	}
	
$("#m_cylb").click(function(){
	        getrylbTree("m_cylb","m_cylbdm","dm_cylb(jxy)");
	});
	
	$("#m_gz").click(function(){
	        getrylbTree("m_gz","m_gzdm","dm_gz(jxy)");
	    });
	    	
$("#m_gj").click(function(){
	getDict_item("m_gj","m_gjdm","dm_gj(lgy)");
});

function updateAll(){
	//getFile();
	setUpdate_wgcyry();
}	
	
function setUpdate_wgcyry(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(modUrl,params,updateback,"json"); 
	}else{
		return modifyVerify();
	}		
}
function updatewgcyryback(json){
	if  (json.result=="success"){
		jAlert(modMessage,'保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else if(json.result=="toicksl"){
		detailUrl="ylfwzagl/query_icksl.action";
		dataid=json.wgcyryxx.ryid;
		$("#"+detailid).hideAndRemove("slow"); 
		setWidth("icksl_detail",modWidth);
		setUrl("icksl_detail","business/Ylfwzagl/IckslgwDetail.jsp");
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
	 		 $('#m_ywx').val("");
		     $('#m_zjhm').val("");
 	}
 		function updatePicture(y){
		 		 $('#m_fileload').val(x.GetImage());
		 		 $('#m_ywx').val(x.ocrCName);
			     $('#m_zjhm').val(x.ocrIdentityId);
			     $('#m_xbdm').setValue(x.ocrCSex);
			     $('#m_xb').val($('#m_xbdm').attr('title'));
			    // getHjsxDD(x.ocrIdentityId,"dm_xzqh","m_hjdxzqhdm","m_hjdxzqh")
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
<input type="hidden" id="m_xb"/>
<input type="hidden" id="m_cyzj"/>
<input type="hidden" id="q_ryid">
<input type="hidden" id="q_zt" value="m">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_qyid">
<input type=hidden id="m_cyryzt">
<input type="hidden" id="m_hylb">
<input type="hidden" id="m_hylbdm">
<!-- <input type="hidden" id="m_cylbdm"/> -->
<input type="hidden" id="m_gzdm" />
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员（境外）修改</td>
      <td><a href="#" id="closeDiv" onclick='$("#wgcyryxx_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
<table width="100%" id="modify">
<tr id="qyryxxTr1" height="20">
	  <td id="qymc_title" class="red">企业名称</td>
      <td id="qymc_data" class="detailtd"><input type="text" readonly="readonly" class="readonly" value="<%=name %>"> </td>
      <td id="qybm_title" class="red">企业代码</td>
	  <td id="qybm_data" class="detailtd"><input type="text" readonly="readonly" class="readonly" value="<%=userCount %>"> </td>
	  <td width="27%" rowspan="14" align="center" valign="top" ><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
		<input type="hidden" id="m_fileload"/>
        <tr><td><jsp:include page="qyryPicture.jsp?zh=false&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include></td></tr>
      </table></td>
    </tr>
<tr id="qyryxxTr2" height="20">
		<td id="xm_title" width="12%" class="red">中文姓名</td>
	  <td id="xm_data" width="22%" class="detailtd"><input type="text" class="inputstyle" id="m_xm" /></td>
	  <td id="xb_title" width="15%"class="red">性别</td>
		<td id="xb_data" width="22%" class="detailtd"><select id="m_xbdm"><option></option></select></td>
	</tr>
	<tr id="qyryxxTr3" height="20">
	    <td id="ywm_title"  class="red">英文名</td>
		<td id="ywm_data" class="detailtd"><input type="text" class="inputstyle" id="m_ywm"/></td>
		<td id="ywx_title" class="red">英文姓</td>
		<td id="ywx_data" class="detailtd"><input type="text" class="inputstyle" id="m_ywx"/></td>
    </tr>
    <tr id="qyryxxTr4" height="20">
		<td id="csrq_title" class="red">出生日期</td>
		<td id="csrq_data" class="detailtd"><input type="text" class="inputstyle" id="m_csrq"/></td>
		<td id="cyrybh_title" class="distd">人员编号</td>
	  <td id="cyrybh_data" class="detailtd"><input type="text" class="readonly" id="m_cyrybh" readonly /></td>
	</tr>
  <tr id="qyryxxTr6" height="20">
		<td id="cyzjdm_title" class="red">证件类型</td>
		<td id="cyzjdm_data" class="detailtd"><select id="m_cyzjdm"><option></option></select></td>
		<td id="zjhm_title" class="red">证件号码</td>
		<td id="zjhm_data" class="detailtd"><input type="text" class="inputstyle" id="m_zjhm"/></td>
    </tr>
    <tr id="qyryxxTr7" height="20">
		<td id="qzzldm_title" class="red">签证（注）种类</td>
		<td id="qzzldm_data" class="detailtd"><select id="m_qzzldm"><option></option></select></td>
		<td id="qzhm_title" class="red">签证（注）号码</td>
		<td id="qzhm_data" class="detailtd"><input type="text" class="inputstyle" id="m_qzhm"/></td>
    </tr>
    <tr id="qyryxxTr5" height="20">
		<td id="zatlq_title" class="distd">在华停留期至</td>
		<td id="zatlq_data" class="detailtd"><input type="text" class="inputstyle" id="m_zatlq"/></td>
      <td id="whcd_title" class="distd">文化程度</td>
		<td id="whcd_data" class="detailtd"><select id="m_whcddm"><option></option></select></td>
  </tr>
    <tr id="qyryxxTr8" height="20">
        <td id="xx_title" class="red">血型</td>
		<td id="xx_data" class="detailtd"><select id="m_xxdm"><option></option></select></td> 
		<td id="hyzk_title" class="distd">婚姻状况</td>
		<td id="hyzk_data" class="detailtd"><select name="select5" id="m_hyzkdm"><option></option></select></td>
    </tr>
    <tr id="qyryxxTr9" height="20">
        <td id="gj_title" class="red">国籍</td>
		<td id="gj_data" class="detailtd"><input type="text" class="inputstyle" id="m_gj" readonly/></td>
		<td id="wgrjyxkz_title" class="red">就业许可证号</td>
		<td id="wgrjyxkz_data" class="detailtd"><input type="text" class="inputstyle" id="m_wgrjyxkz"/></td>
		
    </tr>
    <tr id="qyryxxTr17" height="20">
		<td id="zzdz_title" class="red">现住址</td>
		<td id="zzdz_data" colspan="3" class="detailtd"><input type="text" style="width:450px" class="inputstyle3" id="m_zzdz"/></td>
	</tr>
	<tr id="qyryxxTr11" height="20">
	    <!-- <td id="rylb_title" class="red">人员类别</td>
		<td id="rylb_data" class="detailtd"><input type="text" id="m_cylb" class="inputstyle" readonly /></td>
	    <td id="gwlb_title" class="red">岗位类别</td>
		<td id="gwlb_data" class="detailtd"><select type="text" id="m_gwbh"><option></option></select></td>
		 -->
		<td id="sj_title" class="red">手机</td>
		<td id="sj_data" class="detailtd"><input type="text" class="inputstyle" id="m_shouji"/></td>
		<td id="zw_title" class="red">职务</td>
		<td id="zw_data" class="detailtd"><input type="text" class="inputstyle" id="m_zhiwu"/></td>
    </tr>
    <tr id="qyryxxTr16" height="20">
		<td id="gz_title" class="red">工种</td>
		<td id="gz_data" class="detailtd"><input type="text" class="inputstyle" id="m_gz" readonly/></td>
		<td id="blank_title" class="distd">&nbsp;</td>
		<td id="blank_data" class="detailtd">&nbsp;</td>
	</tr>
	<tr id="qyryxxTr12" height="20">
	    <td id="jjlxr_title" class="distd">紧急联系人</td>
		<td id="jjlxr_data" class="detailtd"><input type="text" class="inputstyle" id="m_jjlxr"/></td>
		<td id="jjlxrdh_title" class="distd">紧急联系电话</td>
		<td id="jjlxrdh_data" class="detailtd"><input type="text" class="inputstyle" id="m_jjlxrdh"/></td>
	</tr>
    <tr id="qyryxxTr10" height="20">
	    <td id="rzrq_title" class="red">入职日期</td>
		<td id="rzrq_data" class="detailtd"><input type="text" id="m_rzrq" class="inputstyle"/></td>
		<td id="lzrq_title" class="distd">离职日期</td>
		<td id="lzrq_data" class="detailtd"><input type="text" id="m_lzrq" class="inputstyle"/></td>
	</tr>
	<tr id="qyryxxTr14" height="20">
	    <td id="sg_title" class="distd">身高（厘米）</td>
		<td id="sg_data" class="detailtd"><input type="text" class="inputstyle" id="m_shengao"/></td>
		<td id="tz_title" class="distd">体重(公斤)</td>
		<td id="tz_data" class="detailtd"><input type="text" class="inputstyle" id="m_tizh"/></td>
	</tr>
	<tr id="qyryxxTr15" height="20">
		<td id="zzzhm_title" class="distd">暂住证号</td>
		<td id="zzzhm_data"  class="detailtd"><input type="text" class="inputstyle" id="m_zzzhm"/></td>
	</tr>
	
	<tr id="qyryxxTr18" height="20">
		<td colspan="5" class="distd">
		<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
            <td id="gwzrms_title" width="12%" class="distd" valign="top">岗位责任描述 </td>
            <td id="gwzrms_data" width="88%" class="detailtd"><textarea name="textarea2" id="m_gwzrms" cols="78" rows="3"></textarea></td>
			</tr>
        </table></td>
	</tr>
	<tr id="qyryxxTr19" height="20">
		<td colspan="5" class="distd">
		<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
            <td id="bz_title" width="12%" class="distd" valign="top">备注 </td>
            <td id="bz_data" width="88%" class="detailtd"><textarea name="textarea2" id="m_bz" cols="78" rows="3"></textarea></td>
			</tr>
        </table></td>
	</tr>
	<tr height="20">
		<td colspan="5" class="distd"><table width="100%" border="0" cellspacing="0" cellpadding="2">
           <tr id="tr_zpwtgyy" style="display:none">
            <td width="12%" class="distd" valign="top">照片未通过原因 </td>
            <td width="88%" class="detailtd"><textarea id="zpwtgyy" cols="82" rows="3"></textarea></td>
          </tr>
        </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="but">
  <tr  align="center">
    <td> <a  id="wtgyy" href="#" style="display:none"  hidefocus="true" class="submitbutton" title="审核记录" onclick='shhistroy();'>审核记录</a>
    <a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='updateAll();'>保存</a></td>
    
  </tr>
</table>
<div id="wtgyy_detail" class="page-layout" src="#" style="z-index:2000; top:50px; left:40px;">