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
		//$("#m_xxdm").selectBox({code:"dm_xx"});
  		//$("#m_xxdm").change(function(){
  		//	$("#m_xx").val($("#m_xxdm").attr('title'));
  		//});
  		//$("#m_hyzkdm").selectBox({code:"dm_hyzk"});
  		
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
	if(json.LWgcyryxx[0]!=null){
	    hylbdm = setNull(json.LWgcyryxx[0].hylbdm);
	    $("#m_ryid").val(setNull(json.LWgcyryxx[0].ryid));
	    $("#m_qyid").val(setNull(json.LWgcyryxx[0].qyid));
	    $("#qymc").append(setNull(json.LWgcyryxx[0].qymc));
		$("#qybm").append(setNull(json.LWgcyryxx[0].qybm));
		$("#cyrybh").append(setNull(json.LWgcyryxx[0].cyrybh));
		$("#xm").append(setNull(json.LWgcyryxx[0].xm));
		$("#xb").append(setNull(json.LWgcyryxx[0].xb));
		//$("#csrq").append(setNull(json.LWgcyryxx[0].csrq));
		if(json.LWgcyryxx[0].csrq!=null)
			$("#csrq").append(setNull(json.LWgcyryxx[0].csrq.substr(0,10)));
		$("#gj").append(setNull(json.LWgcyryxx[0].gj));
		$("#whcd").append(setNull(json.LWgcyryxx[0].whcd));
		$("#cyzj").append(setNull(json.LWgcyryxx[0].cyzj));
		$("#zjhm").append(setNull(json.LWgcyryxx[0].zjhm));
		$("#qzzldm").append(setNull(json.LWgcyryxx[0].qzzldm)); 
		$("#qzhm").append(setNull(json.LWgcyryxx[0].qzhm));
		$("#wgrjyxkz").append(setNull(json.LWgcyryxx[0].wgrjyxkz));
		if(json.LWgcyryxx[0].zatlq!=null)
			$("#zatlq").append(setNull(json.LWgcyryxx[0].zatlq.substr(0,10)));
		if(json.LWgcyryxx[0].rzrq!=null)
			$("#rzrq").append(setNull(json.LWgcyryxx[0].rzrq.substr(0,10)));
		if(json.LWgcyryxx[0].lzrq!=null)
			$("#lzrq").append(setNull(json.LWgcyryxx[0].lzrq.substr(0,10)));
		//$("#gwmc").append(setNull(json.LWgcyryxx[0].gwmc));
		$("#shouji").append(setNull(json.LWgcyryxx[0].shouji));
		$("#jjlxr").append(setNull(json.LWgcyryxx[0].jjlxr));
		$("#jjlxrdh").append(setNull(json.LWgcyryxx[0].jjlxrdh));
		//$("#cylb").append(setNull(json.LWgcyryxx[0].cylb));
		$("#gz").append(setNull(json.LWgcyryxx[0].gz));
		$("#zhiwu").append(setNull(json.LWgcyryxx[0].zhiwu));
		//$("#zzzhm").append(setNull(json.LWgcyryxx[0].zzzhm));
		$("#zzdz").append(setNull(json.LWgcyryxx[0].zzdz));
		
		
		
		//$("#rzrq").append(setNull(json.LWgcyryxx[0].rzrq));
		
		$("#zxr").append(setNull(json.LWgcyryxx[0].zxr));
		if(json.LWgcyryxx[0].zxsj!=null){
			$("#zxsj").append(setNull(json.LWgcyryxx[0].zxsj.substr(0,10)));
			$("#zxsj2").append(setNull(json.LWgcyryxx[0].zxsj.substr(0,10)));
			}
		
		if(json.LWgcyryxx[0].cjsj!=null)
			$("#cjsj").append(setNull(json.LWgcyryxx[0].cjsj.substr(0,10)));
		$("#cjr").append(setNull(json.LWgcyryxx[0].cjr));
		$("#zxyy").append(setNull(json.LWgcyryxx[0].zxyy));
		$("#zt").append(setNull(json.LWgcyryxx[0].zt));
		$("#zxbz").append(setNull(json.LWgcyryxx[0].zxbz));
		$("#ywx").append(setNull(json.LWgcyryxx[0].ywx));
		$("#ywm").append(setNull(json.LWgcyryxx[0].ywm));
		//$("#cjdbm").append(setNull(json.LWgcyryxx[0].cjdbm));
		//$("#cjdmc").append(setNull(json.LWgcyryxx[0].cjdmc));
		//$("#qyid").append(setNull(json.LWgcyryxx[0].qyid));
		$("#cyryzt").append(setNull(json.LWgcyryxx[0].cyryzt));
		$("#shengao").append(setNull(json.LWgcyryxx[0].shengao));
		$("#tizh").append(setNull(json.LWgcyryxx[0].tizh));
		$("#bz").append(setNull(json.LWgcyryxx[0].bz));
		//$("#cylbdm").append(setNull(json.LWgcyryxx[0].wgmc));
  		$("#hyzk").append(setNull(json.LWgcyryxx[0].hyzk));		
		$("#zpwtgyy").append(setNull(json.LWgcyryxx[0].zpwtgyy));
		$("#gwzrms").append(setNull(json.LWgcyryxx[0].gwzrms));
		$("#zxr2").append(setNull(json.LWgcyryxx[0].czr));
		//$("#xx").append(setNull(json.LWgcyryxx[0].xx));
		
		if(setNull(json.LWgcyryxx[0].scbz)==1){
			$('#zhuxiao').empty();
			$('#shanchu').show();
		}
		var zkzt = setNull(json.LWgcyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
		initPage();
		$("#img_picControlscr").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LWgcyryxx[0].ryid+'&aa=<%=lo %>');
		dataid=setNull(json.LWgcyryxx[0].ryid);
		$('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
	}
}	
	
	function modifyVerify(){
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
</script>
<input type="hidden" id="s_ryid">
<input type="hidden" id="q_ryid">
<input type="hidden" id="q_zt" value="m">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_qyid">
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
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
<tr id="qyryxxTr1">
		<td id="qymc_title"  class="distd1">企业名称</td>
		<td id="qymc_data" class="detailtd2"><span id="qymc" ></span></td>
	    <td id="qybm_title" class="distd1">企业代码</td>
	    <td id="qybm_data" class="detailtd2"><span id="qybm" ></span></td>
	    <td width="27%" rowspan="12" colspan="2" align="center" valign="top">
			<table width="35%" border="0" align="center" cellpadding="8"
				cellspacing="0">
				<input type="hidden" id="m_fileload" />
				<tr>
					<td>
						<jsp:include page="qyryPicture.jsp?zh=false&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include>
					</td>
				</tr>
			</table>
		</td>
    </tr>
	<tr id="qyryxxTr2">
      <td id="xm_title" width="12%" class="distd1">中文姓名</td>
      <td id="xm_data" width="22%" class="detailtd2"><span id="xm"></span></td>
      <td id="xb_title" width="15%" class="distd1">性别</td>
	  <td id="xb_data" width="22%" class="detailtd2"><span id="xb"></span></td>
  </tr>
	<tr id="qyryxxTr3">
		<td id="ywx_title" class="distd1">英文姓</td>
		<td id="ywx_data" class="detailtd2"><span id="ywx"></span></td>
	    <td id="ywm_title" class="distd1">英文名</td>
	    <td id="ywm_data" class="detailtd2"><span id="ywm"></span></td>
    </tr>
    <tr id="qyryxxTr4">
      <td id="csrq_title" class="distd1">出生日期</td>
        <td id="csrq_data" class="detailtd2"><span id="csrq"></span></td>
        <td id="cyrybh_title" class="distd1">人员编号</td>
	  <td id="cyrybh_data" class="detailtd2"><span id="cyrybh"></span></td>
  </tr>
  <tr id="qyryxxTr6">
	  <td id="cyzj_data" class="distd1">证件类型</td>
      <td id="cyzj_data" class="detailtd2"><span id="cyzj"></span></td>
      <td id="zjhm_title" class="distd1">证件号码</td>
      <td id="zjhm_data" class="detailtd2"><span id="zjhm"></span></td>
  </tr>
	<tr id="qyryxxTr7">
	  <td id="qzzldm_title" class="distd1">签证类型</td>
      <td id="qzzldm_data" class="detailtd2"><span id="qzzldm"></span></td>
      <td id="qzhm_title" class="distd1">签证号码</td>
      <td id="qzhm_data" class="detailtd2"><span id="qzhm"></span></td>
  </tr>
  	<tr id="qyryxxTr5">
		<td id="zatlq_title" class="distd1">在华停留期至</td>
	    <td id="zatlq_data" class="detailtd2"><span id="zatlq"></span></td>
		 <td id="whcd_title" class="distd1">文化程度</td>
	    <td id="whcd_data" class="detailtd2"><span id="whcd"/></td>
    </tr>
  <tr id="qyryxxTr8">
      <td id="hyzk_title" class="distd1">婚姻状况</td>
	    <td id="hyzk_data" class="detailtd2"><span id="hyzk"></span></td>
	    <td id="xx_title" class="distd1">血型</td>
		<td id="xx_data" class="detailtd2"><span id="xx"></span></td>
  </tr>
    <tr id="qyryxxTr9">
        <td id="gj_title" class="distd1">国籍</td>
		<td id="gj_data" class="detailtd2"><span id="gj"></span></td>
		<td id="wgrjyxkz_title" class="distd1">就业许可证号</td>
		<td id="wgrjyxkz_data" class="detailtd2"><span id="wgrjyxkz"></span></td>
    </tr>
    <tr id="qyryxxTr16">
		<td id="zzdz_title" class="distd1">现住址</td>
		<td id="zzdz_data" colspan="3"  class="detailtd2"><span id="zzdz"></span></td>
	</tr>
	<tr id="qyryxxTr11">
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
	<tr id="qyryxxTr14">
	    <td id="gz_title" class="distd1">工种</td>
		<td id="gz_data" colspan="3" class="detailtd2"><span id="gz"></span></td>
	</tr>
	<tr id="qyryxxTr12">
		<td id="jjlxrdh_title" class="distd1">紧急联系电话</td>
		<td id="jjlxrdh_data" class="detailtd2"><span id="jjlxrdh"></span></td>
		<td id="jjlxr_title" class="distd1">紧急联系人</td>
		<td id="jjlxr_data" class="detailtd2"><span id="jjlxr"></span></td>
    </tr>
	<tr id="qyryxxTr10">
		<td id="rzrq_title" class="distd1">入职日期</td>
	    <td id="rzrq_data" class="detailtd2"><span id="rzrq"></span></td>
	    <td id="lzrq_title" class="distd1">离职日期</td>
		<td id="lzrq_data" class="detailtd2"><span id="lzrq"></span></td>
    </tr>
    
	
	<tr id="qyryxxTr13">
        <td id="sg_title" class="distd1">身高（厘米）</td>
	    <td id="sg_data" class="detailtd2"><span id="shengao"></span></td>
	    <td id="tz_title" class="distd1">体重（公斤）</td>
	    <td id="tz_data" class="detailtd2"><span id="tizh"></span></td>
    </tr>
	
    <tr id="qyryxxTr15">
		<td id="zzzhm_title" width="10%" class="distd1">暂住证号</td>
		<td id="zzzhm_data"  width="24%" class="detailtd2"><span id="zzzhm"></span></td>
    </tr>
	<tr id="qyryxxTr17">
	    <td id="cjsj_title" class="distd1">采集时间</td>
	    <td id="cjsj_data" class="detailtd2"><span id="cjsj"></span></td>
	    <td class="distd1">记录状态</td>
	    <td class="detailtd2"><span id="cyryzt"></span></td>
		<td class="distd1">注销人</td>
		<td class="detailtd2"><span id="zxr"></span></td>
	</tr>
	<tr id="zhuxiao">
	    <td class="distd1">注销时间</td>
	    <td class="detailtd2"><span id="zxsj"></span></td>
		<td class="distd1">注销原因</td>
		<td class="detailtd2"><span id="zxyy"></span></td>
         <td class="distd1">人员注销标志</td>
	    <td class="detailtd2"><span id="zxbz"></span></td>
      </tr>
	<tr id="shanchu" style="display: none;">
	    <td class="distd1">删除时间</td>
	    <td class="detailtd2"><span id="zxsj2"></span></td>
		<td class="distd1">删除人</td>
		<td class="detailtd2"><span id="zxr2"></span></td>
         <td class="distd1"></td>
	    <td class="detailtd2"></td>
      </tr>
	<tr id="qyryxxTr18">
		<td id="gwzrms_title" class="distd1">岗位责任描述</td>
	  <td id="gwzrms_data" colspan="5" class="detailtd2"><span id="gwzrms"></span></td>
    </tr>
	<tr id="qyryxxTr19">
		<td id="bz_title" class="distd1">备注</td>
	  <td id="bz_data" colspan="5" class="detailtd2"><span id="bz"></span></td>
    </tr>
	<tr id="tr_zpwtgyy" style="display:none">
		<td class="distd1">照片未通过原因</td>
	  <td colspan="5" class="detailtd2" width="560"><span id="zpwtgyy"></span></td>
    </tr>
	<!--
	<tr>
		<td colspan="5" class="detailtd2"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='$("#q_ryid").parent().hideAndRemove();'>关闭</a></td>
	</tr>
        </table></td>
    </tr>-->
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="but">
  <tr  align="center">
    <td> <a  id="wtgyy" href="#" style="display:none"  hidefocus="true" class="submitbutton" title="审核记录" onclick='shhistroy();'>审核记录</a>
    <a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='updateAll();'>保存</a></td>
    
  </tr>
</table>
<div id="wtgyy_detail" class="page-layout" src="#" style="z-index:2000; top:50px; left:40px;">