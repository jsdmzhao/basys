<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
Date da=new Date();
		long lo=da.getTime();
 %>
<script type="text/javascript">
var hylbdm;
	$(document).ready(function() {
	     $("#qyryxxTr5").hide();
	     $("#qyryxxTr13").hide();
	     $("#qyryxxTr15").hide();
	     var all_ryidValue = $("#all_ryid").val();
	    if(all_ryidValue==null || all_ryidValue==""){
			if(tj_tcryxx!=null && tj_tcryxx=="true")
				$("#q_cyrybh").attr("value",dataid);
			else
				$("#q_ryid").attr("value",dataid);
	    }
		Qyryxx_setDetail();
	}); 
	function updatediv (json) { 
	    hylbdm = setNull(json.LQyryxx[0].hylbdm);
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
		if(json.LQyryxx[0].cjsj!=null)
			$("#cjsj").append(setNull(json.LQyryxx[0].cjsj.substr(0,10)));
		$("#cjr").append(setNull(json.LQyryxx[0].cjr));
		$("#hcdw").append(setNull(json.LQyryxx[0].hcdw));
		$("#cyryzt").append(setNull(json.LQyryxx[0].cyryzt));
		$("#zxbz").append(setNull(json.LQyryxx[0].zxbz));
		if(setNull(json.LQyryxx[0].zxbz)=='已注销'){
			if(setNull(json.LQyryxx[0].zxsj)!=null){
				$("#zxsj").append(setNull(json.LQyryxx[0].zxsj.substr(0,10)));
				$("#zxsj2").append(setNull(json.LQyryxx[0].zxsj.substr(0,10)));
			}
			$("#zxyy").append(setNull(json.LQyryxx[0].zxyy));
		}
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
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LQyryxx[0].ryid+'&aa=<%=lo %>');
		dataid=setNull(json.LQyryxx[0].ryid);
		$('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
	}	
	
	function initPage(){
	
	    if(hylbdm=='C'){//机修业
		    setBackRemoveObj("gz_");
		    setBackRemoveObj("blank_");
		}else{
		    $("#qyryxxTr11").hide();
		}
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
	
	function closeDetailDiv(){
		var parentObj = $("#q_ryid").parent();
		if(parentObj.attr("id")=="cyryxx_detail_div"){
			parentObj.parent().hideAndRemove("show");
		}else{
			parentObj.hideAndRemove("show");
		}
	}
</script>
<input type="hidden" id="q_ryid">
<input type="hidden" id="q_cyrybh">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员详情</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeDetailDiv();'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr id="qyryxxTr1">
		<td id="qymc_title"  class="distd1">企业名称</td>
		<td id="qymc_data" class="detailtd2"><span id="qymc" ></span></td>
	    <td id="qybm_title" class="distd1">企业代码</td>
	    <td id="qybm_data" class="detailtd2"><span id="qybm" ></span></td>
	     <td colspan="2" rowspan="12" align="center" valign="top" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      </table></td>
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
<div id="qyrytjxx">
</div>	