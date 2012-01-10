<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,com.aisino2.sysadmin.domain.User,com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	 User user= (User)session.getAttribute(Constants.userKey);
	    String name="";
	    String userCount="";
	    String hylbdm = "";
	    if(user!=null){
	    	name=user.getSsdwmc();
	    	userCount=user.getSsdwbm();
	    	hylbdm = userCount.substring(0,1);
	    }
 %>
<script type="text/javascript">
var fileId;
var hylbdm = $("#hylbdm").val();
	$(document).ready(function() {
	    $("#qyryxxTr8").hide();
	    $("#qyryxxTr13").hide();
	    $("#qyryxxTr16").hide();
		 bc_bottonMoveRight(20); 
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_rzrq").attr("readonly","true");
		$("#a_rzrq").datepicker();
		$("#a_lzrq").attr("readonly","true");
		$("#a_lzrq").datepicker();
		$("#a_zxsj").attr("readonly","true");
		$("#a_zxsj").datepicker();
		$("#a_hcsj").attr("readonly","true");
		$("#a_hcsj").datepicker();
		$("#a_bcsj").attr("readonly","true");
		$("#a_bcsj").datepicker();
		$("#a_zatlq").attr("readonly","true");
		$("#a_zatlq").datepicker();
		
  		$("#a_whcddm").selectBox({code:"dm_xl"});
  		//$("#a_hyzkdm").selectBox({code:"dm_hyzk"});
  		$("#a_cyzjdm").selectBox({code:"dm_hz"});
  		$("#a_xbdm").selectBox({code:"dm_xb"});
  		$("#a_qzzldm").selectBox({code:"dm_qzzl(lgy)"});
  		//$("#a_xxdm").selectBox({code:"dm_xx"});
  		//$("#a_xxdm").change(function(){
  		//	$("#a_xx").val($("#a_xxdm").attr('title'));
  		//});
  		fileId="a_fileload";
  		//gy_getselectBox("a_gwbh");
		//$("#a_gwbh").change(function(){
		//	$("#a_gwmc").val($("#a_gwbh").attr('title'));
		//});
  		//$("#a_hyzkdm").change(function(){
  		//	$("#a_hyzk").val($("#a_hyzkdm").attr('title'));
  		//});
  		$("#a_whcddm").change(function(){
  			$("#a_whcd").val($("#a_whcddm").attr('title'));
  		});
  		initPage();
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	}); ; 
	function addVerify(){
	    if (!checkControlValue("a_cyrybh","String",1,20,null,0,"从业人员编号"))
			return false;
	    if (!checkControlValue("a_xm","String",1,100,null,0,"中文姓名"))
			return false;
		if (!checkControlValue("a_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("a_ywm","String",1,100,null,1,"英文名"))
			return false;
	    if (!checkControlValue("a_ywx","String",1,100,null,1,"英文姓"))
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
		if (!checkControlValue("a_cyzjdm","Select",1,4,null,1,"证件类型"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,1,"证件号码"))
			return false;
		if (!checkControlValue("a_qzzldm","Select",1,4,null,1,"签证（注）种类"))
			return false;
		if (!checkControlValue("a_qzhm","String",1,20,null,1,"签证（注）号码"))
			return false;
		if (!checkControlValue("a_gj","String",1,100,null,1,"国籍"))
			return false;
		if (!checkControlValue("a_wgrjyxkz","String",1,30,null,1,"就业许可证号"))
			return false;
		if (!checkControlValue("a_zzdz","String",1,200,null,1,"现住址"))
			return false;
		if (!checkControlValue("a_shouji","String",1,20,null,1,"手机"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,1,"职务"))
			return false;
		if(hylbdm=='C'){
		    if (!checkControlValue("a_gz","String",1,60,null,1,"工种"))
			    return false;
		}
		if (!checkControlValue("a_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		if (!checkControlValue("a_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
		if (!checkControlValue("a_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		//if(hylbdm=='C'){
		//    if (!checkControlValue("a_cylb","String",1,50,null,1,"人员类别"))
		//	    return false;
		//}else{
		//    if (!checkControlValue("a_gwbh","Select",1,50,null,1,"岗位类别"))
		//	return false;
		//}
		//if (!checkControlValue("a_hyzk","String",1,4,null,0,"婚姻状况"))
		//	return false;
		//if (!checkControlValue("a_shengao","Float",-999.99,999.99,2,0,"身高"))
		//	return false;
		//if (!checkControlValue("a_tizh","Float",-999.99,999.99,2,0,"体重"))
		//	return false;
		//if (!checkControlValue("a_xx","String",1,20,null,1,"血型"))
		//	return false;
		//if (!checkControlValue("a_zzzhm","String",1,20,null,0,"暂住证编号"))
		//	return false;
		//if (!checkControlValue("a_gwzrms","String",1,2000,null,0,"岗位责任描述"))
		//	return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
			
		$("#a_xb").val($("#a_xbdm").attr("title"));
		$("#a_cyzj").val($("#a_cyzjdm").attr("title"));
		
		//if($("#a_shengao").val()=="")
		//	$("#a_shengao").val("0");
		//if($("#a_tizh").val()=="")
		//	$("#a_tizh").val("0");
		var rzrq = $("#a_rzrq").attr("value");
	    var lzrq = $("#a_lzrq").attr("value");
	    if(rzrq!=''&&lzrq!=''&&formatDate(rzrq)-formatDate(lzrq)>0){
		    jAlert("请正确选择入职和离职日期!","提示信息");
		    return false;
	    }
		return true;
	}
	
	function initPage(){
	    if(hylbdm=='C'){//机修业
		    //setRemoveObj("gwlb_");
		    //setBackRemoveObj("rylb_");
		    //setRemoveObj("blank_");
		    //setBackRemoveObj("gz_");
		    $("#qyryxxTr14").show();
		}else{
		    //setRemoveObj("rylb_");
		    //setBackRemoveObj("gwlb_");
		    //setRemoveObj("gz_");
		    //setBackRemoveObj("blank_");
		    $("#qyryxxTr14").hide();
		}
	}
	
$("#a_cylb").click(function(){
	getrylbTree("a_cylb","a_cylbdm","dm_cylb(jxy)");
});
	
$("#a_gz").click(function(){
    getrylbTree("a_gz","a_gzdm","dm_gz(jxy)");
});	
$("#a_gj").click(function(){
	getDict_item("a_gj","a_gjdm","dm_gj(lgy)");
});

$("#a_csmc").click(function(){
	getYlcs_item("a_csmc","a_csid","kcyzx");
});


function addAll(){
	//getFile();
	setAdd_wgcyry();
}

function setAdd_wgcyry(){
	if (addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addwgcyryback,"json");
	}else{
		return addVerify();
	}	
}	

function addwgcyryback(json){
	if  (json.result=="success"){
		jAlert("添加成功",'提示信息');
		if(!$("#checkbox").attr("checked"))
			$("#"+detailid).hideAndRemove("slow"); 
		else
			clearAllFormElement();
			
		setPageList($("#pageNo").attr("value"));
	}else if(json.result=="toicksl"){
		if(!$("#checkbox").attr("checked")){
			detailUrl="ylfwzagl/query_icksl.action";
			dataid=json.wgcyryxx.ryid;
			sFlag="false";
			
			jAlert("添加成功，进入受理页面",'提示信息');
			
			$("#"+detailid).hideAndRemove("slow"); 
			setWidth("icksl_detail",modWidth);
			setUrl("icksl_detail","business/Ylfwzagl/IckslgwDetail.jsp");
			setPageList($("#pageNo").attr("value"));
		}else{
			jAlert("添加成功",'提示信息');
			clearAllFormElement();
			setPageList($("#pageNo").attr("value"));
		}
			
	}else{
		jAlert(json.result,'错误信息');
	}		
}	

function clearAllFormElement(){
	var formDiv = $("#clearDiv").parent();
	formDiv.find("input").val("");
	formDiv.find("input[type='checkbox']").attr("checked",false);
	formDiv.find("textarea").val("");
	formDiv.find("select").setValue("");
	ctlPicture1.InitPicture();
}

$("#a_gwmc").click(function(){
	//getrylbTree("a_gwmc","gwbh","dm_cyrylb");
	//gy_getgwTree("a_gwmc","a_gwbh");
});
	function  deleteDate(y){
	 		 $('#a_ywx').val("");
		     $('#a_zjhm').val("");
 	}
 		function updatePicture(y){
		 		 $('#a_fileload').val(x.GetImage());
		 		 $('#a_ywx').val(x.ocrCName);
			     $('#a_zjhm').val(x.ocrIdentityId);
			     $('#a_xbdm').setValue(x.ocrCSex);
			     $('#a_xb').val($('#a_xbdm').attr('title'));
			    // getHjsxDD(x.ocrIdentityId,"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
 		}
    
    function setPictureBack(x){
 	    $('#a_fileload').val(x.GetImage());
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
<!-- <input type="hidden" id="a_cylbdm"/> -->
<input type="hidden" id="a_gzdm" />
<input type="hidden" id="hylbdm" value="<%=hylbdm %>"/>
<input type="hidden" id="a_xb"/>
<input type="hidden" id="a_cyzj"/>
<input type="hidden" id="a_gwbh" value="9999"/>
<div id="clearDiv" />
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">

    <tr>
      <td align="left" class="title1">从业人员（境外）新增</td>
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
<table width="100%" cellpadding="2" cellspacing="0" id="add">
<tr id="qyryxxTr1" height="20">
	  <td id="qymc_title" class="red">企业名称</td>
      <td id="qymc_data" class="detailtd"><input type="text" readonly="readonly" class="readonly" value="<%=name %>"> </td>
      <td id="qybm_title" class="red">企业代码</td>
	  <td id="qybm_data" class="detailtd"><input type="text" readonly="readonly" class="readonly" value="<%=userCount %>"> </td>
	  <td width="27%" rowspan="14" align="center" valign="top" ><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
		<input type="hidden" id="a_fileload"/>
        <tr><td>
         <jsp:include page="qyryPicture.jsp?zh=false&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include>
        </td></tr>
      </table></td>
    </tr>
<tr id="qyryxxTr2" height="20">
		<td id="xm_title" width="12%" class="distd">中文姓名</td>
	  <td id="xm_data" width="22%" class="detailtd"><input type="text" class="inputstyle" id="a_xm" /></td>
	  <td id="xb_title" width="15%" class="red">性别</td>
		<td id="xb_data" width="22%" class="detailtd"><select id="a_xbdm"><option></option></select></td>
	</tr>
	<tr id="qyryxxTr3" height="20">
	    <td id="ywm_title"  class="red">英文名</td>
		<td id="ywm_data" class="detailtd"><input type="text" class="inputstyle" id="a_ywm"/></td>
		<td id="ywx_title" class="red">英文姓</td>
		<td id="ywx_data" class="detailtd"><input type="text" class="inputstyle" id="a_ywx"/></td>
    </tr>
    <tr id="qyryxxTr4" height="20">
		<td id="csrq_title" class="red">出生日期</td>
		<td id="csrq_data" class="detailtd"><input type="text" class="inputstyle" id="a_csrq"/></td>
		<td id="cyrybh_title" class="distd">人员编号</td>
	    <td id="cyrybh_data" class="detailtd"><input type="text" class="readonly" id="a_cyrybh" readonly /></td>
	</tr>
	
  <tr id="qyryxxTr6" height="20">
		<td id="cyzjdm_title" class="red">证件类型</td>
		<td id="cyzjdm_data" class="detailtd"><select id="a_cyzjdm"><option></option></select></td>
		<td id="zjhm_title" class="red">证件号码</td>
		<td id="zjhm_data" class="detailtd"><input type="text" class="inputstyle" id="a_zjhm"/></td>
    </tr>
	<tr id="qyryxxTr7" height="20">
		<td id="qzzldm_title" class="red">签证（注）种类</td>
		<td id="qzzldm_data" class="detailtd"><select id="a_qzzldm"><option></option></select></td>
		<td id="qzhm_title" class="red">签证（注）号码</td>
		<td id="qzhm_data" class="detailtd"><input type="text" class="inputstyle" id="a_qzhm"/></td>
    </tr>
    <tr id="qyryxxTr8" height="20">
        <td id="xx_title" class="red">血型</td>
		<td id="xx_data" class="detailtd"><select id="a_xxdm"><option></option></select></td> 
		<td id="hyzk_title" class="distd">婚姻状况</td>
		<td id="hyzk_data" class="detailtd"><select name="select5" id="a_hyzkdm"><option></option></select></td>
    </tr>
  	<tr id="qyryxxTr9" height="20">
		<td id="zatlq_title" class="distd">在华停留期至</td>
		<td id="zatlq_data" class="detailtd"><input type="text" class="inputstyle" id="a_zatlq"/></td>
		<td id="whcd_title" class="distd">文化程度</td>
		<td id="whcd_data" class="detailtd"><select id="a_whcddm"><option></option></select></td>
    </tr>
    <tr id="qyryxxTr5" height="20">
	  <td class="red">国籍</td>
      <td class="detailtd"><input type="text" id="a_gj" readonly class="inputstyle" /><input type="hidden" id="a_gjdm" /></td>
     <td id="wgrjyxkz_title" class="red">就业许可证号</td>
		<td id="wgrjyxkz_data" class="detailtd"><input type="text" class="inputstyle" id="a_wgrjyxkz"/></td>
  </tr>
  <tr id="qyryxxTr15" height="20">
		<td id="zzdz_title" class="red">现住址</td>
		<td id="zzdz_data" colspan="3" class="detailtd"><input type="text" style="width:450px" class="inputstyle3" id="a_zzdz"/></td>
	</tr>
	<tr id="qyryxxTr11" height="20">
	   <!--  <td id="rylb_title" class="red">人员类别</td>
		<td id="rylb_data" class="detailtd"><input type="text" id="a_cylb" class="inputstyle" readonly /></td>
	    <td id="gwlb_title" class="red">岗位类别</td>
		<td id="gwlb_data" class="detailtd"><select id="a_gwbh"><option></option></select></td>
		 -->
		<td id="sj_title" class="red">手机</td>
		<td id="sj_data" class="detailtd"><input type="text" class="inputstyle" id="a_shouji"/></td>
		 <td id="zw_title" class="red">职务</td>
		<td id="zw_data" class="detailtd"><input type="text" class="inputstyle" id="a_zhiwu" /></td>
    </tr>
    <tr id="qyryxxTr14" height="20">
		<td id="gz_title" class="red">工种</td>
		<td id="gz_data" class="detailtd"><input type="text" class="inputstyle" id="a_gz" readonly/></td>
		<td id="blank_title" class="distd">&nbsp;</td>
		<td id="blank_data" class="detailtd">&nbsp;</td>
	</tr>
	<tr id="qyryxxTr12" height="20">
        <td id="jjlxr_title" class="distd">紧急联系人</td>
		<td id="jjlxr_data" class="detailtd"><input type="text" class="inputstyle" id="a_jjlxr"/></td>
		<td id="jjlxrdh_title" class="distd">紧急联系电话</td>
		<td id="jjlxrdh_data" class="detailtd"><input type="text" class="inputstyle" id="a_jjlxrdh"/></td>
	</tr>
	<tr id="qyryxxTr10" height="20">
	    <td id="rzrq_title" class="red">入职日期</td>
		<td id="rzrq_data" class="detailtd"><input type="text" id="a_rzrq" class="inputstyle"/></td>
		<td id="lzrq_title" class="distd">离职日期</td>
		<td id="lzrq_data" class="detailtd"><input type="text" id="a_lzrq" class="inputstyle"/></td>
	</tr>
	
    
	<tr id="qyryxxTr13" height="20">
		<td id="sg_title" class="distd">身高（厘米）</td>
		<td id="sg_data" class="detailtd"><input type="text" class="inputstyle" id="a_shengao"/></td>
		<td id="tz_title" class="distd">体重(公斤)</td>
		<td id="tz_data" class="detailtd"><input type="text" class="inputstyle" id="a_tizh"/></td>
		<td id="zzzhm_title" class="distd">暂住证号</td>
		<td id="zzzhm_data"  class="detailtd"><input type="text" class="inputstyle" id="a_zzzhm"/></td>
	</tr>
  <tr id="qyryxxTr16" height="20">
		<td colspan="5" class="distd">
		<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
            <td id="gwzrms_title" width="12%" class="distd" valign="top">岗位责任描述 </td>
            <td id="gwzrms_data" width="88%" class="detailtd"><textarea name="textarea2" id="a_gwzrms" cols="78" rows="3"></textarea></td>
			</tr>
        </table></td>
	</tr>
	<tr id="qyryxxTr17" height="20">
		<td colspan="5" class="distd">
		<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
            <td id="bz_title" width="12%" class="distd" valign="top">备注 </td>
            <td id="bz_data" width="88%" class="detailtd"><textarea name="textarea2" id="a_bz" cols="78" rows="3"></textarea></td>
			</tr>
        </table></td>
	</tr>
  <!-- 
	<tr height="20">
	  <td align="right">
	    <input type="checkbox" name="checkbox" id="checkbox"/></td>
      <td colspan="4" align="left">保存后继续新的采集</td>
  </tr>
   -->
	<tr height="25" align="center"><td colspan="5"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='addAll();'>保存</a></td></tr>
</table>
