<%@ page language="java" pageEncoding="UTF-8" %>
<script type="text/javascript">
	$(document).ready(function() {
	 bc_bottonMoveRight(23); 
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
		
  		$("#a_whcddm").selectBox({code:"dm_xl"});
  		$("#a_xbdm").selectBox({code:"dm_xb"});
		// 行业类别	
	    $("#a_hylbdm").selectBoxhylb({code:"ggmk"});
	    $("#a_hylbdm").setValue("N");
	    
		$("#a_hjlbdm").selectBox({code:"dm_hjlb"});  //户籍类别
		$("#a_zzmmdm").selectBox({code:"dm_zzmm"}); //政治面貌
	 	$("#a_cylbdm").selectBox({code:"dm_cyry_nbdw"}); //从业人员类别
	//	gy_getselectBox("a_cylbdm");//从业人员类别
	});
	
	$("#a_gz").click(function(){
	        getrylbTree("a_gz","a_gzdm","dm_gz(jxy)");
	    });
	
	$('#a_hylbdm').change(function(){
	    publicHylbdm = $('#a_hylbdm').val();
	    if(publicHylbdm == 'E03'){// 典当业
	        selectHylbPage("basic/publicsystem/QyryxxAdd-gad-dd.jsp");
	    }else if(publicHylbdm == 'B'){// 印章业
	        selectHylbPage("basic/publicsystem/QyryxxAdd-gad-yz.jsp");
         }else if(publicHylbdm == 'N'){ //内保单位
         	selectHylbPage("basic/publicsystem/QyryxxAdd-gad-nb.jsp");
	    }else{
	        selectHylbPage("basic/publicsystem/QyryxxAdd-gad.jsp");
	    }
	});
	$("#a_qymc").click(function(){ //服务场所筛选框
	 	dataid=$('#a_hylbdm').val();
		getTy_item("a_qymc","a_qybm");
	});
	$("#a_minzu").click(function(){
		getDict_item("a_minzu","a_mzdm","dm_mz");
	});
	$("#a_hjdxzqh").click(function(){
		getDict_item("a_hjdxzqh","a_hjdxzqhdm","dm_xzqh");
	});
	$("#a_gwbh").change(function(){
		$("#a_gwmc").val($("#a_gwbh").attr('title'));
	});
	$("#a_whcddm").change(function(){
		$("#a_whcd").val($("#a_whcddm").attr('title'));
	});
	$("#a_xbdm").change(function(){
		$("#a_xb").val($("#a_xbdm").attr("title"));
	});
	// 户籍类别改变
	$("#a_hjlbdm").change(function(){
		$("#a_hjlbmc").val($("#a_hjlbdm").attr("title"));
	});
	// 政治面貌改变
	$("#a_zzmmdm").change(function(){
		$("#a_zzmmmc").val($("#a_zzmmdm").attr("title"));
	});
	
	$("#a_cylbdm").change(function(){
		$("#a_cylb").val($("#a_cylbdm").attr("title"));
	});
	
	function addVerify(){
		if (!checkControlValue("a_hylbdm","Select",1,4,null,1,"行业类别"))
			return false;
		if (!checkControlValue("a_qymc","String",1,60,null,1,"企业名称"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("a_xm","姓名"))
			return false;
		if (!checkControlValue("a_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("a_whcddm","Select",1,2,null,1,"文化程度"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,30,null,1,"身份证号码"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,1,"出生日期"))
			return false;
		if(!checkControlValue("a_cylbdm","String",1,2,null,1,"从业人员类别"))
			return false;
		
		var tenYearAgo = new Date();
		tenYearAgo.setYear(tenYearAgo.getYear() - 10);
		var tenYearAgoStr = tenYearAgo.getFullYear()+"-"+(tenYearAgo.getMonth()+1)+"-"+tenYearAgo.getDate();
		if(!checkTwoDateEarlier($("#a_csrq").val(),tenYearAgoStr)){
			jAlert("出生日期必须小于"+tenYearAgoStr+"！",'验证信息',null,"a_csrq");
			return false;
		}
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,1,"户籍省县"))
			return false;
		if (!checkControlValue("a_zzzhm","String",1,20,null,0,"暂住证号"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("a_zzdz","String",1,200,null,1,"现住址"))
			return false;
		if (!checkControlValue("a_shouji","String",1,20,null,1,"手机"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,1,"职务"))
			return false;
		if (!checkControlValue("a_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		if (!checkControlValue("a_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
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
		var rzrq = $("#a_rzrq").attr("value");
	    var lzrq = $("#a_lzrq").attr("value");
	    if(rzrq!=''&&lzrq!=''&&formatDate(rzrq)-formatDate(lzrq)>0){
		    jAlert("请正确选择入职和离职日期!","提示信息");
		    return false;
	    }
		return true;
	}   

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
				$("#a_xb").val($("#a_xbdm").attr("title"));
			}
		}else{
			jAlert("身份证号码不正确","验证信息");
		}
		getHjsxDD($(this).val(),"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
	});

	function setAdd_cyry(){
		if (addVerify()){
			setParams("a_");
			jQuery.post(addUrl,params,addback,"json");
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

	function deleteDate(y){
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
<input type="hidden" id="a_zjzt"/>
<input type="hidden" id="a_cylb" />
<input type="hidden" id="a_fileload"/>
<input type="hidden" id="a_xb"/>
<input type="hidden" id="a_hyzk"/>
<input type="hidden" id="a_mzdm"/>
<input type="hidden" id="a_hjdxzqhdm"/>
<input type="hidden" id="a_xx">
<input type="hidden" id="a_whcd"/>
<input type="hidden" id="a_gwmc" />
<input type="hidden" id="a_gzdm" />
<input type="hidden" id="a_gwbh" value="9999"/>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
      <td align="left" class="title1">从业人员新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#cyryxx_detail").hideAndRemove("show");'class="close"></a></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>

<table width="100%" cellpadding="2" cellspacing="0" id="add">
	<tr id="qyryxxTr1" height="20">
		<td id="hylbdm_title" class="red">行业类别</td>
		<td id="hylbdm_data" class="detailtd"><select type="select" id="a_hylbdm"></select></td>
		<td id="qymc_title" class="red">企业名称</td>
		<td id="qymc_data" class="detailtd"><input type="text" class="inputstyle" id="a_qymc" readonly/></td>
	</tr>
	<tr id="qyryxxTr2" height="20">
		<td id="qybm_title" width="12%" class="red">企业代码</td>
	    <td id="qybm_data" width="22%" class="detailtd"><input type="text" readonly="readonly" id="a_qybm" class="readonly"> </td>
	    <td id="xm_title" width="15%" class="red">姓名</td>
		<td id="xm_data" width="22%" class="detailtd"><input type="text" class="inputstyle" id="a_xm"/></td>
		<td width="27%" rowspan="12" align="center" valign="top">
			<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
	        <tr><td><jsp:include page="qyryPicture.jsp?zh=true&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include>
	        </td></tr>
	      	</table></td>
	</tr>
	<tr id="qyryxxTr3" height="20">
	    <td id="xb_title" class="red">性别</td>
		<td id="xb_data" class="detailtd"><select id="a_xbdm"><option></option></select></td>
		<td id="whcd_title" class="red">文化程度</td>
		<td id="whcd_data" class="detailtd"><select id="a_whcddm"><option></option></select></td>
    </tr>
	<tr id="qyryxxTr4" height="20">
		<td id="mz_title" class="red">民族</td>
		<td id="mz_data" class="detailtd"><input type="text" id="a_minzu" class="inputstyle" readonly/></td>
		<td id="cyrybh_title" class="distd">人员编号</td>
		<td id="cyrybh_data" class="detailtd"><input type="text" class="readonly" id="a_cyrybh" readonly/></td>
	</tr>
	<tr id="qyryxxTr6" height="20">
	    <td id="zjhm_title" class="red">公民身份号码</td>
		<td id="zjhm_data" class="detailtd"><input type="text" class="inputstyle" id="a_zjhm"/></td>
		<td id="csrq_title" class="red">出生日期</td>
		<td id="csrq_data" class="detailtd"><input type="text" class="inputstyle" id="a_csrq"/></td>
    </tr>
    <tr id="qyryxxTr10" height="20">
	    <td id="hjdxzqh_title" class="red">户籍省县</td>
		<td id="hjdxzqh_data" class="detailtd"><input type="text" class="inputstyle" id="a_hjdxzqh" readonly/></td>
		<td id="zzzhm_title" class="distd">暂住证号</td>
		<td id="zzzhm_data"  class="detailtd"><input type="text" class="inputstyle" id="a_zzzhm"/></td>
    </tr>
	<tr id="qyryxxTr20" height="20">
		<td id="hjlbmc" class="distd">户籍类别</td>
		<td id="hjlbdm" class="detailtd">
			<input type="hidden" id="a_hjlbmc" />
			<select id="a_hjlbdm"><option></option></select>
		</td>
		<td id="zzmmmc" class="distd">政治面貌</td>
		<td id="zzmmdm" class="detailtd">
			<input type="hidden" id="a_zzmmmc" />
			<select id="a_zzmmdm"><option></option></select>
		</td>
	</tr>
    <tr id="qyryxxTr7" height="20">
        <td id="hjdxz_title" class="red">户籍地详址</td>
		<td id="hjdxz_data" colspan="3"  class="detailtd"><input type="text" style="width:450" class="inputstyle3" id="a_hjdxz"   /></td>
    </tr>
    <tr id="qyryxxTr15" height="20">
		<td id="zzdz_title" class="red">现住址</td>
		<td id="zzdz_data" colspan="3" class="detailtd"><input type="text" style="width:450" class="inputstyle3" id="a_zzdz"/></td>
	</tr>
	<tr id="qyryxxTr12" height="20">
		<td id="sj_title" class="red">手机</td>
		<td id="sj_data" class="detailtd"><input type="text" class="inputstyle" id="a_shouji"/></td>
		<td id="zw_title" class="red">职务</td>
		<td id="zw_data" class="detailtd"><input type="text" class="inputstyle" id="a_zhiwu"/></td>
    </tr>
	<tr id="qyryxxTr11" height="20">
	    <td id="jjlxr_title" class="distd">紧急联系人</td>
		<td id="jjlxr_data" class="detailtd"><input type="text" class="inputstyle" id="a_jjlxr"/></td>
		<td id="jjlxrdh_title" class="distd">紧急联系电话</td>
		<td id="jjlxrdh_data" class="detailtd"><input type="text" class="inputstyle" id="a_jjlxrdh"/></td>
	</tr>
	<tr id="qyryxxTr9" height="20">
	    <td id="rzrq_title" class="red">入职日期</td>
		<td id="rzrq_data" class="detailtd"><input type="text" id="a_rzrq" class="inputstyle"/></td>
		<td id="lzrq_title" class="distd">离职日期</td>
		<td id="lzrq_data" class="detailtd"><input type="text" id="a_lzrq" class="inputstyle"/></td>
	</tr>
	<tr id="qyryxxTr20" height="20">
		<td id="cylbmc" class="red">从业人员类别</td>
		<td id="cylbdm1" class="detailtd">
			<select id="a_cylbdm"><option></option></select>
		</td>
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
	<tr height="25" align="center">
		<td colspan="5">
		<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd_cyry();'>保存</a>
	</td></tr>
</table>
