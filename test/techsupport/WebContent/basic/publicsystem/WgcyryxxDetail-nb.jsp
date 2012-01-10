<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
Date da=new Date();
		long lo=da.getTime();
%>
<script type="text/javascript">
	//var ddwgcyryDetailUrl = "ddhyzagl/query_ddwgcyryxx.action";
	$(document).ready(function() {
		if(tj_tcryxx!=null && tj_tcryxx=="true")
			$("#q_cyrybh").attr("value",dataid);
		else
			$("#q_ryid").attr("value",dataid);
		//ddwgcyrySetDetail();
	});
	function ddwgcyrySetDetail(){
		setParams("q_");
		jQuery.post(ddwgcyryDetailUrl,params,updatediv,"json");
	}
	function updatediv (json) {
		if(json.LWgcyryxx[0]!=null){
			$("#ddqymc").append(setNull(json.LWgcyryxx[0].qymc));
			$("#cyrybh").append(setNull(json.LWgcyryxx[0].cyrybh));
			$("#xm").append(setNull(json.LWgcyryxx[0].xm));
			$("#xb").append(setNull(json.LWgcyryxx[0].xb));
			if(json.LWgcyryxx[0].csrq!=null)
				$("#csrq").append(setNull(json.LWgcyryxx[0].csrq.substr(0,10)));
			$("#zzzhm").append(setNull(json.LWgcyryxx[0].zzzhm));
			$("#zzdz").append(setNull(json.LWgcyryxx[0].zzdz));
			$("#shouji").append(setNull(json.LWgcyryxx[0].shouji));
			$("#jjlxrdh").append(setNull(json.LWgcyryxx[0].jjlxrdh));
			$("#zhiwu").append(setNull(json.LWgcyryxx[0].zhiwu));
			if(json.LWgcyryxx[0].rzrq!=null)
				$("#rzrq").append(setNull(json.LWgcyryxx[0].rzrq.substr(0,10)));
			if(json.LWgcyryxx[0].lrsj!=null)
				$("#lrsj").append(setNull(json.LWgcyryxx[0].lrsj.substr(0,10)));
			$("#ywx").append(setNull(json.LWgcyryxx[0].ywx));
			$("#ywm").append(setNull(json.LWgcyryxx[0].ywm));
			$("#gj").append(setNull(json.LWgcyryxx[0].gj));
			$("#wgrjyxkz").append(setNull(json.LWgcyryxx[0].wgrjyxkz));
			$("#qzzldm").append(setNull(json.LWgcyryxx[0].qzzldm));
			$("#qzhm").append(setNull(json.LWgcyryxx[0].qzhm));
			$("#cyzj").append(setNull(json.LWgcyryxx[0].cyzj));
			$("#zjhm").append(setNull(json.LWgcyryxx[0].zjhm));
			$("#csid").append(setNull(json.LWgcyryxx[0].csid));
			$("#csmc").append(setNull(json.LWgcyryxx[0].csmc));
			$("#rylb").append(setNull(json.LWgcyryxx[0].cylb));
			$("#zt").append(setNull(json.LWgcyryxx[0].zt));
			var shengao = setNull(json.LWgcyryxx[0].shengao);
			var tizh = setNull(json.LWgcyryxx[0].tizh);
			if("0"!=shengao){
				$("#shengao").append(shengao);
			}
			if("0"!=tizh){
				$("#tizh").append(tizh);
			}
			
			$("#bz").append(setNull(json.LWgcyryxx[0].bz));
			$("#lrr").append(setNull(json.LWgcyryxx[0].lrr));
			
	  		$("#hyzk").append(setNull(json.LWgcyryxx[0].hyzk));		
			
			var zxbz = setNull(json.LWgcyryxx[0].zxbz);
			if(zxbz=='1'){
				$("#zxr").append(setNull(json.LWgcyryxx[0].zxr));
				$("#zxsj").append(setNull(json.LWgcyryxx[0].zxsj));
				$("#zxyy").append(setNull(json.LWgcyryxx[0].zxyy));
				$("#zxflag1")[0].style.display='block';
				$("#zxflag2")[0].style.display='block';
			}
			
			$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LWgcyryxx[0].ryid+'&aa=<%=lo %>');
		    dataid=setNull(json.LWgcyryxx[0].ryid);
		    $('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
		}
	}
	
	function closeDetailDiv(){
		var parentObj = $("#q_ryid").parent();
		if(parentObj.attr("id")=="wgcyryxx_detail_div"){
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
      <td align="left" class="title1">外国从业人员详情</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeDetailDiv();' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr>
		<td class="distd1">企业名称</td>
		<td colspan="3" class="detailtd2" width="500px"><span id="ddqymc"></span></td>
		<td colspan="2" rowspan="17" align="center" valign="top" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      </table></td>
    </tr>
	<tr>
		<td width="14%" class="distd1">人员编号</td>
		<td width="170" class="detailtd2"><span id="cyrybh"></span></td>
		<td class="distd1">中文姓名</td>
		<td width="170" class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr>
		<td class="distd1">英文姓</td>
		<td class="detailtd2" width="170"><span id="ywx"></span></td>
	    <td class="distd1">英文名</td>
	    <td class="detailtd2" width="170"><span id="ywm"></span></td>
    </tr>
    	<tr>
		<td class="distd1">性别</td>
		<td class="detailtd2" width="170"><span id="xb"></span></td>
		<td class="distd1">出生日期</td>
		<td class="detailtd2" width="170"><span id="csrq"></span></td>
	</tr>
  	<tr>
		<td class="distd1">国籍</td>
		<td class="detailtd2" width="170"><span id="gj"></span></td>
	    <td class="distd1">婚姻状况</td>
	    <td class="detailtd2" width="170"><span id="hyzk"></span></td>
    </tr>
	<tr>
	    <td class="distd1">入职日期</td>
	    <td class="detailtd2" width="170"><span id="rzrq"></span></td>
		<td class="distd1">职务</td>
		<td class="detailtd2" width="170"><span id="zhiwu"></span></td>
    </tr>
    <tr>
		<td class="distd1">就业许可证号</td>
		<td colspan="3" class="detailtd2" width="490"><span id="wgrjyxkz"></span></td>
	</tr>
    <tr>
	  <td class="distd1">护照类型</td>
      <td class="detailtd2" width="170"><span id="cyzj"></span></td>
      <td class="distd1">护照号</td>
      <td class="detailtd2" width="170"><span id="zjhm"></span></td>
	</tr>
	<tr>
	  <td class="distd1">签证类型</td>
      <td class="detailtd2" width="170"><span id="qzzldm"></span></td>
      <td class="distd1">签证号码</td>
      <td class="detailtd2" width="170"><span id="qzhm"></span></td>
	</tr>
	<tr>
		<td class="distd1">联系电话</td>
		<td class="detailtd2" width="170"><span id="shouji"></span></td>
	    <td class="distd1">紧急联系电话</td>
	    <td class="detailtd2" width="170"><span id="jjlxrdh"></span></td>
	</tr>
	<tr>
		<td class="distd1">身高(厘米)</td>
		<td class="detailtd2" width="170"><span id="shengao"></span></td>
	    <td class="distd1">体重(公斤)</td>
	    <td class="detailtd2" width="170"><span id="tizh"></span></td>
	</tr>
    <tr>
		<td class="distd1">暂住证号码</td>
		<td class="detailtd2" width="170"><span id="zzzhm"></span></td>
	    <td class="distd1">记录状态</td>
	    <td class="detailtd2" width="170"><span id="zt"></span></td>
    </tr>
    <tr>
		<td class="distd1">录入人</td>
	    <td class="detailtd2" width="170"><span id="lrr"></span></td>
	    <td class="distd1">录入时间</td>
	    <td class="detailtd2" width="170"><span id="lrsj"></span></td>
    </tr>
	<tr>
		<td class="distd1">暂住地址</td>
		<td class="detailtd2" width="170"><span id="zzdz"></span></td>
		<td class="distd1">从业人员类别</td>
		<td class="detailtd2" ><span id="rylb"></span></td>
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
		<td colspan="3" class="detailtd2" width="490"><span id="bz"></span></td>
    </tr>
</table>
<div id="qyrytjxx"  >
</div>	