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
		$("#q_rylsid").attr("value",dataid);
	}); 
		function updatediv (json) { 
		hylbdm = setNull(json.LQyryxx[0].hylbdm);
		$("#cyrybh").append(setNull(json.LQyryxx[0].cyrybh));
		//$("#xx").append(setNull(json.LQyryxx[0].xx));
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
		$("#qtlxdh").append(setNull(json.LQyryxx[0].jjlxrdh));
		$("#zhiwu").append(setNull(json.LQyryxx[0].zhiwu));
		$("#rzrq").append(setNull(json.LQyryxx[0].rzrq));
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
		$("#bz").append(setNull(json.LQyryxx[0].bz));
		$("#zpwtgyy").append(setNull(json.LQyryxx[0].zpwtgyy));
		$("#zxr2").append(setNull(json.LQyryxx[0].zxr));
		if(setNull(json.LQyryxx[0].scbz)==1){
			$('#zhuxiao').empty();
			$('#zhuxiaoyy').empty();
			$('#shanchu').show();
		}

		$("#whcd").append(setNull(json.LQyryxx[0].whcd));
		$("#lzrq").append(setNull(json.LQyryxx[0].lzrq));
		
		$("#gz").append(setNull(json.LQyryxx[0].gz));
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LQyryxx[0].ryid+'&aa=<%=lo %>');
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
<input type="hidden" id="q_rylsid">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员历史信息详情</td>
      <td><a href="#" id="closeDiv" onclick='$("#cyryxx_detail").hideAndRemove("show");'class="close"></a></td>
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
	    <td id="cyrybh_title" class="distd1">从业人员编号</td>
	    <td id="cyrybh_data" class="detailtd2"><span id="cyrybh"></span></td>
      <td id="xm_title" class="distd1">姓名</td>
      <td id="xm_data" class="detailtd2"><span id="xm"></span></td>
	    <td colspan="2" rowspan="9" align="center" valign="top" class="detailtd2"><table border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      </table></td>
    </tr>
    <tr>
	    <td id="qybm_title" class="distd1">企业代码</td>
	    <td id="qybm_data" class="detailtd2" colspan="3"><span id="qybm" ></span></td>
    </tr>
    <tr>
		<td id="qymc_title"  class="distd1">企业名称</td>
		<td id="qymc_data" class="detailtd2" colspan="3"><span id="qymc" ></span></td>
    </tr>
	<tr id="qyryxxTr4">
	    <td id="zjhm_title" class="distd1">证件号码</td>
		<td id="zjhm_data" class="detailtd2"><span id="zjhm" ></span></td>
	    <td id="hjdxzqh_title" class="distd1">行政区划</td>
		<td id="hjdxzqh_data" class="detailtd2"><span id="hjdxzqh"></span></td>
  </tr>
	<tr id="qyryxxTr2">
      <td id="xb_title" width="15%" class="distd1">性别</td>
	  <td id="xb_data" width="22%" class="detailtd2"><span id="xb"></span></td>
	    <td id="csrq_title" class="distd1">出生日期</td>
        <td id="csrq_data" class="detailtd2"><span id="csrq"></span></td>
  </tr>
	<tr id="qyryxxTr8">
	    <td id="hjdxz_title"  class="distd1">详细地址</td>
		<td id="hjdxz_data"  colspan="3" class="detailtd2"><span id="hjdxz"></span></td>
    </tr>
	<tr id="qyryxxTr3">
	    <td id="mz_title" class="distd1">民族</td>
		<td id="mz_data" class="detailtd2"><span id="minzu"></span></td>
		<td id="whcd_title" class="distd1">文化程度</td>
	    <td id="whcd_data" class="detailtd2"><span id="whcd"/></td>
    </tr>
	<tr id="qyryxxTr9">
		<td id="rzrq_title" class="distd1">入职日期</td>
	    <td id="rzrq_data" class="detailtd2"><span id="rzrq"></span></td>
	    <td id="lzrq_title" class="distd1">离职日期</td>
		<td id="lzrq_data" class="detailtd2"><span id="lzrq"></span></td>
    </tr>
    <tr id="qyryxxTr10">
	    <td id="zw_title" class="distd1">职务</td>
		<td id="zw_data" class="detailtd2"><span id="zhiwu"></span></td>
		<td id="sj_title" class="distd1">联系电话</td>
	    <td id="sj_data" class="detailtd2"><span id="shouji"></span></td>
    </tr>
    <tr id="qyryxxTr12">
		<td id="jjlxrdh_title" class="distd1" width="11%">紧急联系电话</td>
		<td id="jjlxrdh_data" class="detailtd2" width="22%"><span id="qtlxdh"></span></td>
		<td id="gz_title" class="distd1" width="11%">人员类别</td>
		<td id="gz_data" class="detailtd2" width="22%"><span id="gz"></span></td>
        <td id="zzzhm_title" class="distd1" width="11%">暂住证号</td>
		<td id="zzzhm_data" class="detailtd2" width="23%"><span id="zzzhm"></span></td>
    </tr>
    <tr id="qyryxxTr14">
		<td id="zzdz_title" class="distd1">暂住地址</td>
		<td id="zzdz_data" colspan="5" class="detailtd2" width="702"><span id="zzdz"></span></td>
    </tr>
	<tr id="zhuxiao">
	    <td class="distd1">注销时间</td>
	    <td class="detailtd2"><span id="zxsj"></span></td>
         <td class="distd1">人员注销标志</td>
	    <td class="detailtd2" colspan="3"><span id="zxbz"></span></td>
      </tr>
      <tr id="zhuxiaoyy">
		<td class="distd1">注销原因</td>
		<td class="detailtd2" colspan="5" width="702"><span id="zxyy"></span></td>
      </tr>
	<tr id="shanchu" style="display: none;">
	    <td class="distd1">删除时间</td>
	    <td class="detailtd2"><span id="zxsj2"></span></td>
		<td class="distd1">删除人</td>
		<td class="detailtd2"><span id="zxr2"></span></td>
         <td class="distd1"></td>
	    <td class="detailtd2"></td>
      </tr>
	<tr id="qyryxxTr16">
		<td id="bz_title" class="distd1">备注</td>
	  <td id="bz_data" colspan="5" class="detailtd2" width="702"><span id="bz"></span></td>
    </tr>
    	<tr>
		<td  height="3" colspan="6"></td>
	  </tr>
</table>