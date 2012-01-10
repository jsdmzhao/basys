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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/dictDropDown.js"></script>
<script type="text/javascript">
var fileData,fileId;
var hylbdm;
	$(document).ready(function() {
	  
	  bc_bottonMoveRight(28); 
	  $("#qyryxxTr5").hide();
	  $("#qyryxxTr13").hide();
	  $("#qyryxxTr15").hide();
		$("#wtgyy_detail").hide();
			$("#q_ryid").attr("value",dataid);
			$("#m_ryid").attr("value",dataid);
  		fileId = "m_fileload";
		setDetail();	
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	}); 
		function updatediv (json) { 
	    hylbdm = setNull(json.LQyryxx[0].hylbdm);
		$("#m_qyid").val(setNull(json.LQyryxx[0].qyid));
		$("#whcd").append(setNull(json.LQyryxx[0].whcd));
		$("#cyrybh").append(setNull(json.LQyryxx[0].cyrybh));
		//$("#xx").append(setNull(json.LQyryxx[0].xx));
		//$("#hylb").append(setNull(json.LQyryxx[0].hylb));
		$("#qymc").append(setNull(json.LQyryxx[0].qymc));
		$("#qybm").append(setNull(json.LQyryxx[0].qybm));
		//$("#gemc").append(setNull(json.LQyryxx[0].gwmc));
		$("#xm").append(setNull(json.LQyryxx[0].xm));
		//$("#bm").append(setNull(json.LQyryxx[0].bm));
		$("#minzu").append(setNull(json.LQyryxx[0].minzu));
		$("#xb").append(setNull(json.LQyryxx[0].xb));
		$("#csrq").append(setNull(json.LQyryxx[0].csrq));
		//$("#hyzk").append(setNull(json.LQyryxx[0].hyzk));
		$("#hjdxzqh").append(setNull(json.LQyryxx[0].hjdxzqh));
		$("#hjdxz").append(setNull(json.LQyryxx[0].hjdxz));
		$("#zjhm").append(setNull(json.LQyryxx[0].zjhm));
		$("#zzzhm").append(setNull(json.LQyryxx[0].zzzhm));
		$("#zzdz").append(setNull(json.LQyryxx[0].zzdz));
		$("#shouji").append(setNull(json.LQyryxx[0].shouji));
		$("#jjlxr").append(setNull(json.LQyryxx[0].jjlxr));
		$("#jjlxrdh").append(setNull(json.LQyryxx[0].jjlxrdh));
		$("#zhiwu").append(setNull(json.LQyryxx[0].zhiwu));
		$("#rzrq").append(setNull(json.LQyryxx[0].rzrq));
		$("#lzrq").append(setNull(json.LQyryxx[0].lzrq));
		$("#zxr").append(setNull(json.LQyryxx[0].zxr));
		if(json.LQyryxx[0].zxsj!=null){
			$("#zxsj").append(setNull(json.LQyryxx[0].zxsj.substr(0,10)));
			$("#zxsj2").append(setNull(json.LQyryxx[0].zxsj.substr(0,10)));
			}
		if(json.LQyryxx[0].cjsj!=null)
			$("#cjsj").append(setNull(json.LQyryxx[0].cjsj.substr(0,10)));
		$("#cjr").append(setNull(json.LQyryxx[0].cjr));
		$("#hcdw").append(setNull(json.LQyryxx[0].hcdw));
		$("#zxyy").append(setNull(json.LQyryxx[0].zxyy));
		$("#cyryzt").append(setNull(json.LQyryxx[0].cyryzt));
		$("#zxbz").append(setNull(json.LQyryxx[0].zxbz));
		$("#csmc").append(setNull(json.LQyryxx[0].csmc));
		//$("#shengao").append(setNull(json.LQyryxx[0].shengao));
		//$("#tizh").append(setNull(json.LQyryxx[0].tizh));
		$("#bz").append(setNull(json.LQyryxx[0].bz));
		//$("#gwzrms").append(setNull(json.LQyryxx[0].gwzrms));
		$("#zpwtgyy").append(setNull(json.LQyryxx[0].zpwtgyy));
		$("#zxr2").append(setNull(json.LQyryxx[0].zxr));
		if(setNull(json.LQyryxx[0].scbz)==1){
			$('#zhuxiao').empty();
			$('#shanchu').show();
		}
		var zkzt = setNull(json.LQyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
			
		//$("#cylb").append(setNull(json.LQyryxx[0].cylb));
		$("#gz").append(setNull(json.LQyryxx[0].gz));
		initPage();
		$("#img_picControlscr").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LQyryxx[0].ryid+'&aa=<%=lo %>');
		dataid=setNull(json.LQyryxx[0].ryid);
		$('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
	}	
	
function modifyVerify(){
	/*
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
			*/
		//if(hylbdm=='C'){
		//    if (!checkControlValue("m_cylb","String",1,50,null,1,"人员类别"))
		//	    return false;
		//}else{
		//    if (!checkControlValue("m_gwmc","String",1,50,null,1,"岗位类别"))
		//	    return false;
	    //}
		//if (!checkControlValue("m_gwzrms","String",1,2000,null,0,"岗位责任描述"))
		//	return false;
		/*
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
		*/
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
			     $('#m_xbdm').setValue(x.ocrCSex);
			     $('#m_xb').val($('#m_xbdm').attr('title'));
			     getHjsxDD(x.ocrIdentityId,"dm_xzqh","m_hjdxzqhdm","m_hjdxzqh")
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
</script>
<input type="hidden" id="s_ryid">
<input type="hidden" id="q_zt" value="m">
<input type="hidden" id="q_ryid">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_qyid">
<!--  
<input type="hidden" id="m_cyryzt">
<input type="hidden" id="m_zjzt">

<input type="hidden" id="m_hylb">
<input type="hidden" id="m_hylbdm">

<input type="hidden" id="m_gzdm" />
-->
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
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr id="qyryxxTr1">
		<td id="qymc_title"  class="distd1">企业名称</td>
		<td id="qymc_data" class="detailtd2"><span id="qymc" ></span></td>
	    <td id="qybm_title" class="distd1">企业代码</td>
	    <td id="qybm_data" class="detailtd2"><span id="qybm" ></span></td>
	     <td width="27%" rowspan="10" align="center" valign="top" colspan="2">
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
	<tr id="qyryxxTr2">
      <td id="xm_title" width="12%" class="distd1">姓名</td>
      <td id="xm_data" width="22%" class="detailtd2"><span id="xm"></span></td>
      <td id="xb_title" width="15%" class="distd1">性别</td>
	  <td id="xb_data" width="22%" class="detailtd2"><span id="xb"></span></td>
  </tr>
	<tr id="qyryxxTr3">
	    <td id="whcd_title" class="distd1">文化程度</td>
	    <td id="whcd_data" class="detailtd2"><span id="whcd"/></td>
	    <td id="mz_title" class="distd1">民族</td>
		<td id="mz_data" class="detailtd2"><span id="minzu"></span></td>
    </tr>
	<tr id="qyryxxTr4">
	    <td id="cyrybh_title" class="distd1">人员编号</td>
	    <td id="cyrybh_data" class="detailtd2"><span id="cyrybh"></span></td>
	    <td id="zjhm_title" class="distd1">公民身份号码</td>
		<td id="zjhm_data" class="detailtd2"><span id="zjhm" ></span></td>
  </tr>
	<tr id="qyryxxTr5">
        <td id="hyzk_title" class="distd1">婚姻状况</td>
	    <td id="hyzk_data" class="detailtd2"><span id="hyzk"></span></td>
    </tr>
	<tr id="qyryxxTr6">
	    <td id="csrq_title" class="distd1">出生日期</td>
        <td id="csrq_data" class="detailtd2"><span id="csrq"></span></td>
	    <td id="hjdxzqh_title" class="distd1">户籍省县</td>
		<td id="hjdxzqh_data" class="detailtd2"><span id="hjdxzqh"></span></td>
    </tr>
    <tr id="qyryxxTr7">
        <td id="zzzhm_title" class="distd1">暂住证号</td>
		<td id="zzzhm_data" colspan="3" class="detailtd2"><span id="zzzhm"></span></td>
    </tr>
	<tr id="qyryxxTr8">
	    <td id="hjdxz_title"  class="distd1">户籍地详址</td>
		<td id="hjdxz_data"  colspan="3" class="detailtd2"><span id="hjdxz"></span></td>
	    <!-- <td id="xx_title" class="distd1">血型</td>
		<td id="xx_data" class="detailtd2"><span id="xx"></span></td>
		<td id="bm_title" class="distd1">别名</td>
	    <td id="bm_data" class="detailtd2"><span id="bm" ></span></td>
	     -->
    </tr>
	<tr id="qyryxxTr9">
	    <td id="zzdz_title" class="distd1">现住址</td>
		<td id="zzdz_data" colspan="3"  class="detailtd2"><span id="zzdz"></span></td>
    </tr>
	<tr id="qyryxxTr10">
	    <!-- <td id="rylb_title" class="distd1">人员类别</td>
	    <td id="rylb_data" class="detailtd2"><span id="cylb"></span></td>
	    <td id="gwlb_title" class="distd1">岗位类别</td>
		<td id="gwlb_data" class="detailtd2"><span id="gemc"></span></td>
		 -->
		<td id="sj_title" class="distd1">手机</td>
	    <td id="sj_data" class="detailtd2"><span id="shouji"></span></td>
	    <td id="zw_title" class="distd1">职务</td>
		<td id="zw_data" class="detailtd2"><span id="zhiwu"></span></td>
    </tr>
    <tr id="qyryxxTr11">
		<td id="gz_title" class="distd1">工种</td>
		<td id="gz_data" class="detailtd2"><span id="gz"></span></td>
		<td id="blank_title1" class="distd1">&nbsp;&nbsp;</td>
		<td id="blank_data1" class="detailtd2">&nbsp;&nbsp;</td>
    </tr>
	<tr id="qyryxxTr12">
	    <td id="jjlxr_title" class="distd1">紧急联系人</td>
		<td id="jjlxr_data" class="detailtd2"><span id="jjlxr"></span></td>
		<td id="jjlxrdh_title" class="distd1">紧急联系电话</td>
		<td id="jjlxrdh_data" class="detailtd2"><span id="jjlxrdh"></span></td>
    </tr>
    <tr id="qyryxxTr13">
        <td id="sg_title" class="distd1">身高（厘米）</td>
	    <td id="sg_data" class="detailtd2"><span id="shengao"></span></td>
	    <td id="tz_title" class="distd1">体重（公斤）</td>
	    <td id="tz_data" class="detailtd2"><span id="tizh"></span></td>
    </tr>
	<tr id="qyryxxTr14">
		<td id="rzrq_title" class="distd1">入职日期</td>
	    <td id="rzrq_data" class="detailtd2"><span id="rzrq"></span></td>
	    <td id="lzrq_title" class="distd1">离职日期</td>
		<td id="lzrq_data" class="detailtd2"><span id="lzrq"></span></td>
    </tr>
	<tr id="zhuxiao">
	    <td class="distd1">注销时间</td>
	    <td class="detailtd2"><span id="zxsj"></span></td>
		<td class="distd1">注销原因</td>
		<td class="detailtd2"><span id="zxyy"></span></td>
		<td   class="distd1">人员注销标志</td>
	   	<td   class="detailtd2"><span id="zxbz"></span></td>
       
      </tr>
	<tr id="shanchu" style="display: none;">
	    <td class="distd1">删除时间</td>
	    <td class="detailtd2"><span id="zxsj2"></span></td>
		<td class="distd1">删除人</td>
		<td class="detailtd2"><span id="zxr2"></span></td>
         <td class="distd1"></td>
	    <td class="detailtd2"></td>
      </tr>
	<tr id="qyryxxTr15">
		<td id="gwzrms_title" class="distd1">岗位责任描述</td>
	  <td id="gwzrms_data" colspan="5" class="detailtd2"><span id="gwzrms"></span></td>
    </tr>
	<tr id="qyryxxTr16">
		<td id="bz_title" class="distd1">备注</td>
	  <td id="bz_data" colspan="5" class="detailtd2"><span id="bz"></span></td>
    </tr>
	<tr id="tr_zpwtgyy" style="display:none">
		<td class="distd1">照片未通过原因</td>
	  <td colspan="5" class="detailtd2"><span id="zpwtgyy"></span></td>
    </tr>
    <!-- 
	<tr>
		<td colspan="5" class="detailtd2"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='$("#q_ryid").parent().hideAndRemove();'>关闭</a></td>
	</tr>
        </table></td>
    </tr> -->
    	<tr>
		<td  height="3" colspan="6"></td>
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