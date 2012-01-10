<%@ page language="java" pageEncoding="UTF-8"
	import="java.util.Date,com.aisino2.sysadmin.domain.User,com.aisino2.sysadmin.Constants"%>
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
		hylbdm = userCount.substring(0, 1);
	}

	Date da = new Date();
	long lo = da.getTime();
%>
<script type="text/javascript">
var fileId;
var hylbdm = $("#hylbdm").val();
	$(document).ready(function() {
		bc_bottonMoveRight(22); 
		$("#m_csrq").attr("readonly","true").datepicker();
		$("#m_rzrq").attr("readonly","true").datepicker();
		$("#m_lzrq").attr("readonly","true").datepicker();

		$("#s_ryid").attr("value",dataid);
		$("#q_ryid").attr("value",dataid);
		$("#m_ryid").attr("value",dataid);
		$("#ryid").attr("value",dataid);
		
 		$("#m_xbdm").selectBox({code:"dm_xb"});
  		fileId = "m_fileload";
		setDetail();	
		
	})
	
	function updatediv (json) { 
	    hylbdm = setNull(json.LQyryxx[0].hylbdm);
		$("#m_whcddm").val(setNull(json.LQyryxx[0].whcddm));
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
		//initPage();
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
		if (!checkControlValue("m_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("m_xm","姓名")	)
			return false;
		if (!checkControlValue("m_zjhm","String",1,30,null,1,"证件号码"))
			return false;
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,1,"行政区划"))
			return false;
		if (!checkControlValue("m_xbdm","Select",1,2,null,1,"性别"))
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
		if (!checkControlValue("m_hjdxz","String",1,200,null,1,"详细地址"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,1,"民族"))
			return false;
		if (!checkControlValue("m_whcd","String",1,30,null,1,"文化程度"))
			return false;
		if (!checkControlValue("m_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("m_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		if (!checkControlValue("m_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("m_shouji","String",1,20,null,1,"联系电话"))
			return false;
		if (!checkControlValue("m_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
	    if (!checkControlValue("m_gz","String",1,60,null,1,"人员类别"))
		    return false;
		if (!checkControlValue("m_zzzhm","String",1,20,null,0,"暂住证号码 "))
			return false;
		if (!checkControlValue("m_zzdz","String",1,200,null,0,"暂住地址"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		
		var returnCardNo = checkIdCardNo("m_zjhm");
		if(returnCardNo){
			$("#m_zjzt").val(0);
		}else{
			$("#m_zjzt").val(1);
		}
			
		$("#m_xb").val($("#m_xbdm").attr("title"));
		
		return true;
	}   

	//人员类别
	$("#m_gz").click(function(){
		getrylbTree("m_gz","m_gzdm","dm_yzyrylb");
	});

	//文化程度
	$("#m_whcd").click(function(){
		getDict_item("m_whcd","m_whcddm","dm_xl");
	});

	//民族
	$("#m_minzu").click(function(){
		getDict_item("m_minzu","m_mzdm","dm_mz");
	});

	//行政区划
	$("#m_hjdxzqh").click(function(){
		getDict_item("m_hjdxzqh","m_hjdxzqhdm","dm_xzqh");
	});

	$("#m_zjhm").blur(function(){
		var returnCardNo = checkIdCardNo("m_zjhm");
		if(returnCardNo){
			//$("#m_zjhm").val(returnCardNo);
			var zjhm_csrq = getBirthday($(this).val());
			var zjhm_xb = getXb($(this).val());
			if(zjhm_csrq!=null && zjhm_csrq!=""){
				$("#m_csrq").val(zjhm_csrq);
			}
			if(zjhm_xb!=null && zjhm_xb!=""){
				$("#m_xbdm").setValue(zjhm_xb);
				//$("#m_xbdm").setAttr("readonly",false);
			}
		}else{
			jAlert("身份证号码不正确","验证信息");
			if($("#m_xbdm").attr("readonly")){
				//$("#m_xbdm").setAttr("readonly",false);
				}
		}
		getHjsxDD($(this).val(),"dm_xzqh","m_hjdxzqhdm","m_hjdxzqh")
	});
	
	function setAdd_cyry(){
		if (addVerify()){
			setParams("m_");
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

 	function updateAll(){
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
 		}else{
 			jAlert(json.result,'错误信息');
 		}		
 	}
 	 	
</script>
<div id="clearDiv" />
<input type="hidden" id="q_ryid">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_cyryzt">
<input type="hidden" id="m_zjzt">
<input type="hidden" id="m_qyid">
<input type="hidden" id="m_hylb">
<input type="hidden" id="m_hylbdm">
<input type="hidden" id="q_zt" value="m">
<input type="hidden" id="m_gzdm" />
<input type="hidden" id="m_fileload" />
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
				从业人员编号
			</td>
			<td id="cyrybh_data" class="detailtd">
				<input type="text" class="readonly" id="m_cyrybh" readonly />
			</td>
			<td id="xm_title" class="red">
				姓名
			</td>
			<td id="xm_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_xm" />
			</td>
			<td rowspan="8" align="center" valign="top" colspan="2">
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
		<tr id="qyryxxTr2" height="20">
			<td id="zjhm_title" class="red">
				证件号码
			</td>
			<td id="zjhm_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_zjhm" />
			</td>
			<td id="hjdxzqh_title" class="red">
				行政区划
			</td>
			<td id="hjdxzqh_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_hjdxzqh" readonly />
				<input type="hidden" id="m_hjdxzqhdm" />
			</td>
		</tr>
		<tr id="qyryxxTr3" height="20">
			<td id="xb_title" class="red">
				性别
			</td>
			<td id="xb_data" class="detailtd">
				<input type="hidden" id="m_xb" />
				<select id="m_xbdm">
					<option></option>
				</select>
			</td>
			<td id="csrq_title" class="red">
				出生日期
			</td>
			<td id="csrq_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_csrq" />
			</td>
		</tr>
		<tr id="qyryxxTr8" height="20">
			<td id="hjdxz_title" class="red">
				详细地址
			</td>
			<td id="hjdxz_data" colspan="3" class="detailtd">
				<input type="text" class="inputstyle3" id="m_hjdxz" style="width:95%" />
			</td>
		</tr>
		<tr id="qyryxxTr6" height="20">
			<td id="mz_title" class="red">
				民族
			</td>
			<td id="mz_data" class="detailtd">
				<input type="text" id="m_minzu" class="inputstyle" readonly />
				<input type="hidden" id="m_mzdm" />
			</td>
			<td id="whcd_title" class="red">
				文化程度
			</td>
			<td id="whcd_data" class="detailtd">
				<input type="text" id="m_whcd" class="inputstyle" readonly />
				<input type="hidden" id="m_whcddm" />
			</td>
		</tr>
		<tr id="qyryxxTr14" height="20">
			<td id="rzrq_title" class="red" width="11%">
				入职日期
			</td>
			<td id="rzrq_data" class="detailtd" width="22%">
				<input type="text" id="m_rzrq" class="inputstyle" />
			</td>
			<td id="lzrq_title" class="distd" width="11%">
				离职日期
			</td>
			<td id="lzrq_data" class="detailtd" width="22%">
				<input type="text" id="m_lzrq" class="inputstyle" />
			</td>
		</tr>
		<tr>
			<td id="zw_title" class="distd">
				职务
			</td>
			<td id="zw_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_zhiwu" />
			</td>
			<td id="sj_title" class="red">
				联系电话
			</td>
			<td id="sj_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_shouji" />
			</td>
		</tr>
		<tr id="qyryxxTr4" height="20">
			<td id="jjlxrdh_title" class="distd">
				紧急联系电话
			</td>
			<td id="jjlxrdh_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_jjlxrdh" />
			</td>
			<td id="gz_title" class="red">
				人员类别
			</td>
			<td id="gz_data" class="detailtd">
				<input type="text" class="inputstyle" id="m_gz" readonly />
			</td>
		</tr>
		<tr id="qyryxxTr11" height="20">
			<td id="qymc_title" class="distd">
				制作单位
			</td>
			<td id="qymc_data" class="detailtd" colspan="3">
				<input type="text" readonly="readonly" class="readonly"  style="width:95%"
					value="<%=name%>" />
			</td>
			<td id="zzzhm_title" class="distd" width="11%">
				暂住证号码
			</td>
			<td id="zzzhm_data" class="detailtd" width="22%">
				<input type="text" class="inputstyle" id="m_zzzhm" />
			</td>
		</tr>
		<tr id="qyryxxTr9" height="20">
			<td id="zzdz_title" class="distd">
				暂住地址
			</td>
			<td id="zzdz_data" colspan="5" class="detailtd">
				<input type="text" class="inputstyle3" id="m_zzdz" style="width:683" />
			</td>
		</tr>
		<tr id="qyryxxTr16" height="20">
			<td id="bz_title" class="distd" valign="top">
				备注
			</td>
			<td id="bz_data" class="detailtd" colspan="5">
				<textarea name="textarea2" id="m_bz" style="width:683" rows="3"></textarea>
			</td>
		</tr>
		<tr height="25" align="center">
			<td colspan="6">
				<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
					title="保存" onclick='updateAll();'>保存</a>
			</td>
		</tr>
	</table>