<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
Date da=new Date();
		long lo=da.getTime();
 %>
<script type="text/javascript">
	//var ddcyryDetailUrl = "ddhyzagl/query_ddcyryxx.action";
	$(document).ready(function() {
		if(tj_tcryxx!=null && tj_tcryxx=="true")
			$("#q_cyrybh").attr("value",dataid);
		else
			$("#q_ryid").attr("value",dataid);
		//ddcyrySetDetail();
	});
	function ddcyrySetDetail(){
		setParams("q_");
		jQuery.post(ddcyryDetailUrl,params,updatediv,"json");
	}
	function updatediv (json) {
		$("#ddqymc").append(setNull(json.LQyryxx[0].qymc));
		$("#cyrybh").append(setNull(json.LQyryxx[0].cyrybh));
		$("#xm").append(setNull(json.LQyryxx[0].xm));
		$("#bm").append(setNull(json.LQyryxx[0].bm));
		$("#minzu").append(setNull(json.LQyryxx[0].minzu));
		$("#xb").append(setNull(json.LQyryxx[0].xb));
		$("#csrq").append(setNull(json.LQyryxx[0].csrq));
		$("#hyzk").append(setNull(json.LQyryxx[0].hyzk));
		$("#hjdxzqh").append(setNull(json.LQyryxx[0].hjdxzqh));
		$("#hjdxz").append(setNull(json.LQyryxx[0].hjdxz));
		$("#zjhm").append(setNull(json.LQyryxx[0].zjhm));
		$("#zzzhm").append(setNull(json.LQyryxx[0].zzzhm));
		$("#zzdz").append(setNull(json.LQyryxx[0].zzdz));
		$("#shouji").append(setNull(json.LQyryxx[0].shouji));
		$("#jjlxrdh").append(setNull(json.LQyryxx[0].jjlxrdh));
		$("#zhiwu").append(setNull(json.LQyryxx[0].zhiwu));
		$("#rzrq").append(setNull(json.LQyryxx[0].rzrq));
		if(json.LQyryxx[0].lrsj!=null)
			$("#lrsj").append(setNull(json.LQyryxx[0].lrsj.substr(0,10)));
		$("#lrr").append(setNull(json.LQyryxx[0].lrr));
		$("#hcdw").append(setNull(json.LQyryxx[0].hcdw));
		$("#cyryzt").append(setNull(json.LQyryxx[0].cyryzt));
		var shengao = setNull(json.LQyryxx[0].shengao);
		var tizh = setNull(json.LQyryxx[0].tizh);
		if("0"!=shengao){
			$("#shengao").append(shengao);
		}
		if("0"!=tizh){
			$("#tizh").append(tizh);
		}
		$("#bz").append(setNull(json.LQyryxx[0].bz));
		var zxbz = setNull(json.LQyryxx[0].zxbz);
		if(zxbz=='已注销'){
			$("#zxr").append(setNull(json.LQyryxx[0].zxr));
			$("#zxsj").append(setNull(json.LQyryxx[0].zxsj));
			$("#zxyy").append(setNull(json.LQyryxx[0].zxyy));
			$("#zxflag1")[0].style.display='block';
			$("#zxflag2")[0].style.display='block';
		}
		
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LQyryxx[0].ryid+'&aa=<%=lo %>');
		dataid=setNull(json.LQyryxx[0].ryid);
		$('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
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
<table width="100%"  cellpadding="3" cellspacing="0" class="detail" id="detail" >
	<tr>
		<td class="distd1">典当企业</td>
		<td colspan="3" class="detailtd2" width="500px"><span id="ddqymc"></span></td>
		<td rowspan="16" align="center" valign="top" class="detailtd2">
      	<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td height="20"></td></tr>
		<tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      	</table></td>
    </tr>
	<tr>
	  <td width="14%" class="distd1">人员编号</td>
	  <td width="28%"  class="detailtd2"><span id="cyrybh"></span></td>
      <td width="14%" class="distd1">姓名</td>
      <td width="28%" class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr>
		<td class="distd1">公民身份号码</td>
		<td class="detailtd2"><span id="zjhm" ></span></td>
	    <td class="distd1">别名</td>
	    <td class="detailtd2"><span id="bm" ></span></td>
    </tr>
	<tr>
	  <td class="distd1">性别</td>
	  <td class="detailtd2"><span id="xb"></span></td>
      <td class="distd1">出生日期</td>
      <td class="detailtd2"><span id="csrq"></span></td>
	</tr>
	<tr>
		<td class="distd1">民族</td>
		<td class="detailtd2"><span id="minzu"></span></td>
	    <td class="distd1">婚姻状况</td>
	    <td class="detailtd2"><span id="hyzk"></span></td>
    </tr>
	<tr>
	    <td class="distd1">入职日期</td>
	    <td class="detailtd2"><span id="rzrq"></span></td>
		<td class="distd1">职务</td>
		<td class="detailtd2"><span id="zhiwu"></span></td>
    </tr>
    <tr>
		<td class="distd1">户籍省县</td>
		<td colspan="3" class="detailtd2" width="490px"><span id="hjdxzqh"></span></td>
    </tr>
	<tr>
		<td  class="distd1">户籍地详址</td>
		<td colspan="3" class="detailtd2" width="490px"><span id="hjdxz"></span></td>
    </tr>
	<tr>
	    <td class="distd1">联系电话</td>
	    <td class="detailtd2"><span id="shouji"></span></td>
		<td class="distd1">紧急联系电话</td>
		<td class="detailtd2"><span id="jjlxrdh"></span></td>
    </tr>
	<tr>
	    <td class="distd1">身高（厘米）</td>
	    <td class="detailtd2"><span id="shengao"></span></td>
	    <td class="distd1">体重（公斤）</td>
	    <td class="detailtd2"><span id="tizh"></span></td>
    </tr>
	<tr>
		<td class="distd1">暂住地址</td>
		<td colspan="3" class="detailtd2" width="490px"><span id="zzdz"></span></td>
    </tr>
   <tr>
		<td class="distd1">暂住证号码</td>
		<td class="detailtd2"><span id="zzzhm"></span></td>
	    <td class="distd1">记录状态</td>
	    <td class="detailtd2"><span id="cyryzt"></span></td>
    </tr>
	<tr>
		<td class="distd1">录入人</td>
		<td class="detailtd2"><span id="lrr"></span></td>
		<td class="distd1">录入时间</td>
	    <td class="detailtd2"><span id="lrsj"></span></td>
	</tr>
	<tr id="zxflag1" style="display:none">
		<td class="distd1">注销人</td>
		<td class="detailtd2"><span id="zxr"></span></td>
		<td class="distd1">注销时间</td>
	    <td class="detailtd2"><span id="zxsj"></span></td>
	</tr>
	<tr id="zxflag2" style="display:none">
		<td class="distd1">注销原因</td>
		<td class="detailtd2"><span id="zxyy"></span></td>
		<td class="distd1">注销状态</td>
	    <td class="detailtd2">已注销</td>
	</tr>
	<tr>
		<td class="distd1">备注</td>
		<td colspan="3" class="detailtd2" width="490px"><span id="bz"></span></td>
    </tr>
    	<tr>
		<td  height="3" colspan="6"></td>
	</tr>
</table>
<div id="qyrytjxx">
</div>	