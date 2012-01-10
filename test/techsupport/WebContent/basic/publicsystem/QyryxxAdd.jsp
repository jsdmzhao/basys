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
		hylbdm = userCount.substring(0,1);
	}
%>
<script type="text/javascript">
var fileId;
var hylbdm = $("#hylbdm").val();
	$(document).ready(function() {

	 bc_bottonMoveRight(28); 
	 $("#qyryxxTr5").hide();
	 $("#qyryxxTr13").hide();
	 $("#qyryxxTr15").hide();
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
		//gy_getselectBox("a_gwbh");
		//$("#a_gwbh").change(function(){
		//	$("#a_gwmc").val($("#a_gwbh").attr('title'));
		//});
		//$("#p_hylbdm").selectBoxhylb();//行业类别	
  		//$("#a_cylbdm").selectBox({code:"dm_cyrylb"});
  		$("#a_whcddm").selectBox({code:"dm_xl"});
  		//$("#a_hyzkdm").selectBox({code:"dm_hyzk"});
  		//$("#a_xxdm").selectBox({code:"dm_xx"});
  		$("#a_xbdm").selectBox({code:"dm_xb"});
  		//$("#a_hyzkdm").change(function(){
  		//	$("#a_hyzk").val($("#a_hyzkdm").attr('title'));
  		//});
  		//$("#a_xxdm").change(function(){
  		//	$("#a_xx").val($("#a_xxdm").attr('title'));
  		//});
  		$("#a_whcddm").change(function(){
  			$("#a_whcd").val($("#a_whcddm").attr('title'));
  		});
		fileId="a_fileload";
		
		initPage();
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	}); 
		function addVerify(){	
		if (!checkControlValue("a_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("a_xm","姓名")	)
			return false;
		if (!checkControlValue("a_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("a_whcddm","Select",1,2,null,1,"文化程度"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,30,null,1,"身份证号码"))
			return false;
		//if (!checkControlValue("a_bm","String",1,30,null,0,"别名"))
		//	return false;
		
		if (!checkControlValue("a_csrq","Date",null,null,null,1,"出生日期"))
			return false;
			
		var tenYearAgo = new Date();
		tenYearAgo.setYear(tenYearAgo.getYear() - 10);
		var tenYearAgoStr = tenYearAgo.getFullYear()+"-"+(tenYearAgo.getMonth()+1)+"-"+tenYearAgo.getDate();
		if(!checkTwoDateEarlier($("#a_csrq").val(),tenYearAgoStr)){
			
			jAlert("出生日期必须小于"+tenYearAgoStr+"！",'验证信息',null,"a_csrq");
			return false;
		}
								
		
		//if (!checkControlValue("a_hyzk","Select",1,4,null,0,"婚姻状况"))
		//	return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,1,"户籍省县"))
			return false;
		if (!checkControlValue("a_zzzhm","String",1,20,null,0,"暂住证号"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("a_zzdz","String",1,200,null,1,"现住址"))
			return false;
		//if (!checkControlValue("a_xx","String",1,200,null,1,"血型"))
		//	return false;
		//if(hylbdm == 'C'){
		//    if (!checkControlValue("a_cylb","String",1,50,null,1,"人员类别"))
		//	    return false;
			
		//}else{
		//    if (!checkControlValue("a_gwmc","String",1,50,null,1,"岗位类别"))
		//	    return false;
		//}
		if (!checkControlValue("a_shouji","String",1,20,null,1,"手机"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,1,"职务"))
			return false;
		if(hylbdm == 'C'){
		    if (!checkControlValue("a_gz","String",1,60,null,1,"工种"))
			    return false;
		}
		if (!checkControlValue("a_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		if (!checkControlValue("a_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
		
		//if (!checkControlValue("a_shengao","Float",-999.99,999.99,2,0,"身高"))
		//	return false;
		//if (!checkControlValue("a_tizh","Float",-999.99,999.99,2,0,"体重"))
		//	return false;
		
		//if (!checkControlValue("a_gwzrms","String",1,2000,null,0,"岗位责任描述"))
		//	return false;
		if (!checkControlValue("a_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		
		if (!checkControlValue("a_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		
		var returnCardNo = checkIdCardNo("a_zjhm");
		if(returnCardNo){
			$("#a_zjzt").val(0);
		}else{
			$("#a_zjzt").val(1);
		}
			
		$("#a_xb").val($("#a_xbdm").attr("title"));
		
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
	    if(hylbdm == 'C'){//机修业
		    setBackRemoveObj("gz_");
		    setBackRemoveObj("blank_");
		}else{
		   $("#qyryxxTr11").hide();
		}
	}
	
	$("#a_cylb").click(function(){
	        getrylbTree("a_cylb","a_cylbdm","dm_cylb(jxy)");
	});
	
	$("#a_gz").click(function(){
	        getrylbTree("a_gz","a_gzdm","dm_gz(jxy)");
	    });

$("#a_minzu").click(function(){
	getDict_item("a_minzu","a_mzdm","dm_mz");
});
 
$("#a_hjdxzqh").click(function(){
	getDict_item("a_hjdxzqh","a_hjdxzqhdm","dm_xzqh");
});

 $("#a_csmc").click(function(){
	getYlcs_item("a_csmc","a_csid","kcyzx");
});

$("#a_zjhm").blur(function(){
	var returnCardNo = checkIdCardNo("a_zjhm");
	if(returnCardNo){
		//$("#a_zjhm").val(returnCardNo);
		var zjhm_csrq = getBirthday($(this).val());
		var zjhm_xb = getXb($(this).val());
		if(zjhm_csrq!=null && zjhm_csrq!=""){
			$("#a_csrq").val(zjhm_csrq);
		}
		if(zjhm_xb!=null && zjhm_xb!=""){
			$("#a_xbdm").setValue(zjhm_xb);
			//$("#a_xbdm").setAttr("readonly",false);
		}
	}else{
		jAlert("身份证号码不正确","验证信息");
		if($("#a_xbdm").attr("readonly")){
			//$("#a_xbdm").setAttr("readonly",false);
			}
	}
	//getHjsx($(this).val(),"a_hjdxzqhdm","a_hjdxzqh");
	getHjsxDD($(this).val(),"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
});
 
function addAll(){
	//getFile();
	setAdd_cyry();
}

function setAdd_cyry(){
	if (addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addback,"json");
	}else{
		return addVerify();
	}	
}	

function addcyryback(json){
	json.result = json.LQyryxx[0];
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
			dataid=json.cyryxx.ryid;
			sFlag="false";
			
			jAlert("添加成功，进入受理页面",'提示信息');
			
			$("#"+detailid).hideAndRemove("slow"); 
			setWidth("icksl_detail",modWidth);
			setUrl("icksl_detail","business/Ylfwzagl/IckslgnDetail.jsp");
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
	formDiv.find("input[id!='a_csmc'][id!='a_csid']").val("");
	formDiv.find("input[type='checkbox']").attr("checked",false);
	formDiv.find("textarea").val("");
	formDiv.find("select").setValue("");
	ctlPicture1.InitPicture();
}

$("#a_gwmc").click(function(){
	//getrylbTree("a_gwmc","a_gwbh","dm_cyrylb");
	//gy_getgwTree("a_gwmc","a_gwbh");
});
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
			$('#a_hjdxz').val(x.ocrAddR);
			$('#a_xbdm').setValue(x.ocrCSex);
			$('#a_xb').val($('#a_xbdm').attr('title'));
			var birthday=getBirthday($('#a_zjhm').val());
			if(birthday!=null&&birthday!=''){
				$("#a_csrq").val(birthday);
			}
			getHjsxDD(x.ocrIdentityId,"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
			getMinZu(x.ocrCNation,"dm_mz","a_mzdm","a_minzu")
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
<div id="clearDiv" />
    <input type="hidden" id="hylbdm" value="<%=hylbdm %>"/>
	<input type="hidden" id="a_zjzt" />
	<input type="hidden" id="a_cylbdm"/>
    <input type="hidden" id="a_gzdm" />
    <input type="hidden" id="a_gwbh" value="9999"/>
	<input type="hidden" id="a_fileload" />
	<div align="right">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" class="title1">
					从业人员新增
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
	<table width="100%" cellpadding="2" cellspacing="0" id="add">
		<tr id="qyryxxTr1" height="20">
			<td id="qymc_title" class="red">企业名称</td>
			<td id="qymc_data" class="detailtd">
				<input type="text" readonly="readonly" class="readonly"
					value="<%=name%>">
			</td>
			<td id="qybm_title" class="red">企业代码</td>
			<td id="qybm_data" class="detailtd">
				<input type="text" readonly="readonly" class="readonly"
					value="<%=userCount%>">
			</td>
		</tr>
		<tr id="qyryxxTr2" height="20">
			<td id="xm_title" width="12%" class="red">姓名</td>
			<td id="xm_data" width="22%" class="detailtd">
				<input type="text" class="inputstyle" id="a_xm" />
			</td>
			<td id="xb_title" width="15%" class="red">性别</td>
			<td id="xb_data" width="22%" class="detailtd">
				<input type="hidden" id="a_xb" />
				<select id="a_xbdm">
					<option></option>
				</select>
			</td>
			<td width="27%" rowspan="12" align="center" valign="top">
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
		<tr id="qyryxxTr3" height="20">
		    <td id="whcd_title" class="red">文化程度</td>
			<td id="whcd_data" class="detailtd">
				<select id="a_whcddm">
					<option></option>
				</select>
				<input type="hidden" id="a_whcd" />
			</td>
		    <td id="mz_title" class="red">民族</td>
			<td id="mz_data" class="detailtd">
				<input type="text" id="a_minzu" class="inputstyle" readonly />
				<input type="hidden" id="a_mzdm" />
			</td>
		</tr>
		<tr id="qyryxxTr4" height="20">
		    <td id="cyrybh_title" class="distd">人员编号</td>
			<td id="cyrybh_data" class="detailtd">
				<input type="text" class="readonly" id="a_cyrybh" readonly />
			</td>
		    <td id="zjhm_title" class="red">公民身份号码</td>
			<td id="zjhm_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_zjhm" />
			</td>
		</tr>
		<tr id="qyryxxTr5" height="20">
			
			<td id="hyzk_title" class="distd">婚姻状况</td>
			<td id="hyzk_data" class="detailtd">
				<select name="select5" id="a_hyzkdm">
					<option></option>
				</select>
				<input type="hidden" id="a_hyzk" />
			</td>
		</tr>
		<tr id="qyryxxTr6" height="20">
		     <td id="csrq_title" class="red">出生日期</td>
			<td id="csrq_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_csrq" />
			</td>
			<td id="hjdxzqh_title" class="red">户籍省县</td>
			<td id="hjdxzqh_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_hjdxzqh" readonly />
				<input type="hidden" id="a_hjdxzqhdm" />
			</td>
		</tr>
		<tr id="qyryxxTr7" height="20">
		    <td id="zzzhm_title" class="distd">暂住证号</td>
			<td id="zzzhm_data" colspan="3" class="detailtd">
				<input type="text" style="width: 450" class="inputstyle3" id="a_zzzhm" />
			</td>
		</tr>
		<tr id="qyryxxTr8" height="20">
		    <td id="hjdxz_title" class="red">户籍地详址</td>
			<td id="hjdxz_data" colspan="3" class="detailtd">
				<input type="text" style="width: 450" class="inputstyle3"
					id="a_hjdxz" />
			</td>
<!--			<td id="xx_title" class="red">血型</td>
			<td id="xx_data" class="detailtd">
				<select id="a_xxdm">
					<option></option>
				</select>
				<input type="hidden" id="a_xx" value="">
			</td>
			<td id="bm_title" class="distd">别名</td>
			<td id="bm_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_bm" />
			</td>
-->
		</tr>
		<tr id="qyryxxTr9" height="20">
		    <td id="zzdz_title" class="red">现住址</td>
			<td id="zzdz_data" colspan="3"  class="detailtd">
				<input type="text" class="inputstyle3" id="a_zzdz" style="width: 450;" />
			</td>
			
		</tr>
		<tr id="qyryxxTr10" height="20">
		   <!--  <td id="rylb_title" class="red">人员类别</td>
		<td id="rylb_data" class="detailtd"><input type="text" id="a_cylb" class="inputstyle" readonly /></td>
			<td id="gwlb_title" class="red">岗位类别</td>
			<td id="gwlb_data" class="detailtd">
				<input type="hidden" id="a_gwmc" class="inputstyle" readonly />
				<select type="text" id="a_gwbh">
					<option></option>
				</select>
		    </td> -->
			<td id="sj_title" class="red">手机</td>
			<td id="sj_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_shouji" />
			</td>	
			<td id="zw_title" class="red">职务</td>
			<td id="zw_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_zhiwu" />
			</td>
		</tr>
		<!--  
	<tr height="20">
	 <select id="a_cylbdm"><option></option></select>
		<td class="red">服务单位</td>
	  <td colspan="3" class="detailtd">
	  	<input type="text" id="a_csmc" class="inputstyle" style="width:470" readonly /><input type="hidden" id="a_csid" />
      </td>
  </tr>
  -->
		<tr id="qyryxxTr11" height="20">
			<td id="gz_title" class="red">工种</td>
		    <td id="gz_data" class="detailtd"><input type="text" class="inputstyle" id="a_gz" readonly/></td>
		    <td id="blank_title" class="distd">&nbsp;</td>
		    <td id="blank_data" class="detailtd">&nbsp;</td>
		</tr>
		<tr id="qyryxxTr12" height="20">
			<td id="jjlxr_title" class="distd">紧急联系人</td>
			<td id="jjlxr_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_jjlxr" />
			</td>
			<td id="jjlxrdh_title" class="distd">紧急联系电话</td>
			<td id="jjlxrdh_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_jjlxrdh" />
			</td>
		</tr>
		<tr id="qyryxxTr13" height="20">
			<td id="sg_title" class="distd">身高（厘米）</td>
			<td id="sg_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_shengao" />
			</td>
			<td id="tz_title" class="distd">体重(公斤)</td>
			<td id="tz_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_tizh" />
			</td>
		</tr>
		<tr id="qyryxxTr14" height="20">
			<td id="rzrq_title" class="red">入职日期</td>
			<td id="rzrq_data" class="detailtd">
				<input type="text" id="a_rzrq" class="inputstyle" />
			</td>
			<td id="lzrq_title" class="distd">离职日期</td>
			<td id="lzrq_data" class="detailtd">
				<input type="text" id="a_lzrq" class="inputstyle" />
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
							<textarea name="textarea2" id="a_gwzrms" cols="81" rows="3"></textarea>
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
							<textarea name="textarea2" id="a_bz" cols="81" rows="3"></textarea>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 
	<tr height="20">
	  <td class="distd">
	    <input type="checkbox" name="checkbox" id="checkbox" /></td>
      <td colspan="4" class="detailtd">保存后继续添加</td>
  </tr>
   -->
		<tr height="25" align="center">
			<td colspan="5">
				<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
					title="保存" onclick='addAll();'>保存</a>
			</td>
		</tr>
	</table>