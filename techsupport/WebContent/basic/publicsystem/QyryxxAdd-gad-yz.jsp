<%@page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
var fileId;
var hylbdm = $("#hylbdm").val();
	$(document).ready(function() {
		bc_bottonMoveRight(20); 
		$("#a_csrq").attr("readonly","true").datepicker();
		$("#a_rzrq").attr("readonly","true").datepicker();
		$("#a_lzrq").attr("readonly","true").datepicker();
	
 		$("#a_xbdm").selectBox({code:"dm_xb"});
 		 $("#a_hylbdm").selectBoxhylb({code:"ggmk"});
 		 $("#a_hylbdm").setValue("B");
		fileId="a_fileload";
		
	})
	
	$("#a_qymc").click(function(){ //服务场所筛选框
	 	dataid=$('#a_hylbdm').val();
		getTy_item("a_qymc","a_qybm");
	});
	
	function addVerify(){	
		if (!checkControlValue("a_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("a_xm","姓名")	)
			return false;
		if (!checkControlValue("a_zjhm","String",1,30,null,1,"证件号码"))
			return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,1,"行政区划"))
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
		if (!checkControlValue("a_hjdxz","String",1,200,null,1,"详细地址"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("a_whcd","String",1,30,null,1,"文化程度"))
			return false;
		if (!checkControlValue("a_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("a_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("a_shouji","String",1,20,null,1,"联系电话"))
			return false;
		if (!checkControlValue("a_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
	    if (!checkControlValue("a_gz","String",1,60,null,1,"人员类别"))
		    return false;
		if (!checkControlValue("a_zzzhm","String",1,20,null,0,"暂住证号码 "))
			return false;
		if (!checkControlValue("a_zzdz","String",1,200,null,0,"暂住地址"))
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
		
		return true;
	}   

	//人员类别
	$("#a_gz").click(function(){
		getrylbTree("a_gz","a_gzdm","dm_yzyrylb");
	});

	//文化程度
	$("#a_whcd").click(function(){
		getDict_item("a_whcd","a_whcddm","dm_xl");
	});

	//民族
	$("#a_minzu").click(function(){
		getDict_item("a_minzu","a_mzdm","dm_mz");
	});

	//行政区划
	$("#a_hjdxzqh").click(function(){
		getDict_item("a_hjdxzqh","a_hjdxzqhdm","dm_xzqh");
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
		getHjsxDD($(this).val(),"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
	});
	
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
			$("#"+detailid).hideAndRemove("slow"); 
			setPageList($("#pageNo").attr("value"));
		}else{
			jAlert(json.result,'错误信息');
		}		
	}

	function  deleteDate(y){
		
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

 	$('#a_hylbdm').change(function(){
 		publicHylbdm = $('#a_hylbdm').val();
	    if(publicHylbdm=='E03'){// 典当业
	    	selectHylbPage("basic/publicsystem/QyryxxAdd-gad-dd.jsp");
	    }else if(publicHylbdm=='B'){// 印章业
	        selectHylbPage("basic/publicsystem/QyryxxAdd-gad-yz.jsp");
		}else if($('#a_hylbdm').val()=='N'){//内保单位
        	selectHylbPage("basic/publicsystem/QyryxxAdd-gad-nb.jsp");
	    }else{
	    	 selectHylbPage("basic/publicsystem/QyryxxAdd-gad.jsp");
	    }
	});
</script>
<div id="clearDiv" />
<!--	<input type="hidden" id="hylbdm" />-->
	<input type="hidden" id="a_zjzt" />
	<input type="hidden" id="a_cylbdm" />
	<input type="hidden" id="a_gzdm" />
	<input type="hidden" id="a_gwbh" value="9999" />
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
		<tr>
			<td id="cyrybh_title" class="distd">
				行业类别
			</td>
			<td id="cyrybh_data" class="detailtd">
				<select type="select" id="a_hylbdm"></select>
			</td>
			<td id="cyrybh_title" class="distd">
				从业人员编号
			</td>
			<td id="cyrybh_data" class="detailtd">
				<input type="text" class="readonly" id="a_cyrybh" readonly />
			</td>
			<td rowspan="8" align="center" valign="top" colspan="2">
				<table width="35%" border="0" align="center" cellpadding="8"
					cellspacing="0">
					<input type="hidden" id="a_fileload" />
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
			<tr>
			<td id="qymc_title" class="red">
				制作单位
			</td>
			<td id="qymc_data" class="detailtd" colspan="3">
				<input type="text" readonly="readonly" class="inputstyle3" id="a_qymc" style="width:95%" />
				
			</td>
		<tr>
			<td id="cyrybh_title" class="distd">
				单位编码
			</td>
			<td id="cyrybh_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_qybm" readonly />
			</td>
			<td id="xm_title" class="red">
				姓名
			</td>
			<td id="xm_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_xm" />
			</td>
		</tr>
		<tr id="qyryxxTr2" height="20">
			<td id="zjhm_title" class="red">
				证件号码
			</td>
			<td id="zjhm_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_zjhm" />
			</td>
			<td id="hjdxzqh_title" class="red">
				行政区划
			</td>
			<td id="hjdxzqh_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_hjdxzqh" readonly />
				<input type="hidden" id="a_hjdxzqhdm" />
			</td>
		</tr>
		<tr id="qyryxxTr3" height="20">
			<td id="xb_title" class="red">
				性别
			</td>
			<td id="xb_data" class="detailtd">
				<input type="hidden" id="a_xb" />
				<select id="a_xbdm">
					<option></option>
				</select>
			</td>
			<td id="csrq_title" class="red">
				出生日期
			</td>
			<td id="csrq_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_csrq" />
			</td>
		</tr>
		<tr id="qyryxxTr8" height="20">
			<td id="hjdxz_title" class="red">
				详细地址
			</td>
			<td id="hjdxz_data" colspan="3" class="detailtd">
				<input type="text" class="inputstyle3" id="a_hjdxz" style="width:95%" />
			</td>
		</tr>
		<tr id="qyryxxTr6" height="20">
			<td id="mz_title" class="red">
				民族
			</td>
			<td id="mz_data" class="detailtd">
				<input type="text" id="a_minzu" class="inputstyle" readonly />
				<input type="hidden" id="a_mzdm" />
			</td>
			<td id="whcd_title" class="red">
				文化程度
			</td>
			<td id="whcd_data" class="detailtd">
				<input type="text" id="a_whcd" class="inputstyle" readonly />
				<input type="hidden" id="a_whcddm" />
			</td>
		</tr>
		<tr id="qyryxxTr14" height="20">
			<td id="rzrq_title" class="red" width="11%">
				入职日期
			</td>
			<td id="rzrq_data" class="detailtd" width="22%">
				<input type="text" id="a_rzrq" class="inputstyle" />
			</td>
			<td id="lzrq_title" class="distd" width="11%">
				离职日期
			</td>
			<td id="lzrq_data" class="detailtd" width="22%">
				<input type="text" id="a_lzrq" class="inputstyle" />
			</td>
		</tr>
		<tr>
			<td id="zw_title" class="distd">
				职务
			</td>
			<td id="zw_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_zhiwu" />
			</td>
			<td id="sj_title" class="red">
				联系电话
			</td>
			<td id="sj_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_shouji" />
			</td>
		</tr>
		<tr id="qyryxxTr4" height="20">
			<td id="jjlxrdh_title" class="distd">
				紧急联系电话
			</td>
			<td id="jjlxrdh_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_jjlxrdh" />
			</td>
			<td id="gz_title" class="red">
				人员类别
			</td>
			<td id="gz_data" class="detailtd">
				<input type="text" class="inputstyle" id="a_gz" readonly />
			</td>
			<td id="zzzhm_title" class="distd" width="11%">
				暂住证号码
			</td>
			<td id="zzzhm_data" class="detailtd" width="22%">
				<input type="text" class="inputstyle" id="a_zzzhm" />
			</td>
		</tr>
		<tr id="qyryxxTr9" height="20">
			<td id="zzdz_title" class="distd">
				暂住地址
			</td>
			<td id="zzdz_data" colspan="5" class="detailtd">
				<input type="text" class="inputstyle3" id="a_zzdz" style="width:683" />
			</td>
		</tr>
		<tr id="qyryxxTr16" height="20">
			<td id="bz_title" class="distd" valign="top">
				备注
			</td>
			<td id="bz_data" class="detailtd" colspan="5">
				<textarea name="textarea2" id="a_bz" style="width:683" rows="3"></textarea>
			</td>
		</tr>
		<tr height="25" align="center">
			<td colspan="6">
				<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
					title="保存" onclick='setAdd_cyry();'>保存</a>
			</td>
		</tr>
	</table>