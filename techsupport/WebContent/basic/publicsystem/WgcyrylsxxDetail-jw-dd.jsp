<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
Date da=new Date();
		long lo=da.getTime();
%>
<script type="text/javascript">
	$(document).ready(function() {
	    $("#q_rylsid").attr("value",wgcyrylsxx_dataid);
		
		//bgqkbalance_setDetail();
	});
	function bgqkbalance_setDetail(){ //对比信息 并存放起来 待对比
		setParams("q_");
		jQuery.post(detailBalanceUrl,params,bgqkbalance_updatediv,"json");
	}
	function bgqk_setDetail(){ //当前历史信息
		setParams("q_");
		jQuery.post(detailLsUrl,params,bgqk_updatediv,"json");
	}
	function bgqkbalance_updatediv(json){ //对比信息 存放起来 待对比
	    addtotempList("cyrybh",setNull(json.LQyryxx_lsxx[0].cyrybh));
	    addtotempList("qymc",setNull(json.LQyryxx_lsxx[0].qymc));
		addtotempList("xm",setNull(json.LQyryxx_lsxx[0].xm));
		addtotempList("xb",setNull(json.LQyryxx_lsxx[0].xb));
		//$("#csrq").append(setNull(json.LQyryxx_lsxx[0].csrq));
		if(json.LQyryxx_lsxx[0].csrq!=null)
			addtotempList("csrq",setNull(json.LQyryxx_lsxx[0].csrq.substr(0,10)));
		addtotempList("zzzhm",setNull(json.LQyryxx_lsxx[0].zzzhm));
		addtotempList("zzdz",setNull(json.LQyryxx_lsxx[0].zzdz));
		addtotempList("shouji",setNull(json.LQyryxx_lsxx[0].shouji));
		addtotempList("qtlxdh",setNull(json.LQyryxx_lsxx[0].qtlxdh));
		addtotempList("zhiwu",setNull(json.LQyryxx_lsxx[0].zhiwu));
		//$("#rzrq").append(setNull(json.LQyryxx_lsxx[0].rzrq));
		if(json.LQyryxx_lsxx[0].rzrq!=null)
			addtotempList("rzrq",setNull(json.LQyryxx_lsxx[0].rzrq.substr(0,10)));
		addtotempList("zxr",setNull(json.LQyryxx_lsxx[0].zxr));
		if(json.LQyryxx_lsxx[0].zxsj!=null)
			addtotempList("zxsj",setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
		if(json.LQyryxx_lsxx[0].cjsj!=null)
			addtotempList("cjsj",setNull(json.LQyryxx_lsxx[0].cjsj.substr(0,10)));
		addtotempList("cjr",setNull(json.LQyryxx_lsxx[0].cjr));
		addtotempList("hcdw",setNull(json.LQyryxx_lsxx[0].csmc));
		addtotempList("zxyy",setNull(json.LQyryxx_lsxx[0].zxyy));
		addtotempList("zt",setNull(json.LQyryxx_lsxx[0].zt));
		addtotempList("scbz",setNull(json.LQyryxx_lsxx[0].scbz));
		addtotempList("ywx",setNull(json.LQyryxx_lsxx[0].ywx));
		addtotempList("ywm",setNull(json.LQyryxx_lsxx[0].ywm));
		addtotempList("gj",setNull(json.LQyryxx_lsxx[0].gj));
		addtotempList("wgrjyxkz",setNull(json.LQyryxx_lsxx[0].wgrjyxkz));
		addtotempList("qzzldm",setNull(json.LQyryxx_lsxx[0].qzzldm));
		addtotempList("qzhm",setNull(json.LQyryxx_lsxx[0].qzhm));
		addtotempList("cyzj",setNull(json.LQyryxx_lsxx[0].cyzj));
		addtotempList("zjhm",setNull(json.LQyryxx_lsxx[0].zjhm));
		addtotempList("cjdbm",setNull(json.LQyryxx_lsxx[0].cjdbm));
		addtotempList("cjdmc",setNull(json.LQyryxx_lsxx[0].cjdmc));
		addtotempList("cylb",setNull(json.LQyryxx_lsxx[0].cylb));
		addtotempList("csid",setNull(json.LQyryxx_lsxx[0].csid));
		addtotempList("csmc",setNull(json.LQyryxx_lsxx[0].csmc));
		addtotempList("cyryzt",setNull(json.LQyryxx_lsxx[0].cyryzt));
		addtotempList("shengao",setNull(json.LQyryxx_lsxx[0].shengao));
		addtotempList("tizh",setNull(json.LQyryxx_lsxx[0].tizh));
		addtotempList("xx",setNull(json.LQyryxx_lsxx[0].xx));
		addtotempList("bz",setNull(json.LQyryxx_lsxx[0].bz));
		
		addtotempList("cylbdm",setNull(json.LQyryxx_lsxx[0].cylb));
  		addtotempList("hyzk",setNull(json.LQyryxx_lsxx[0].hyzk));
  		bgqk_setDetail();
	}
	
    function bgqk_updatediv (json) { 
		changeAndWriteRedFont("cyrybh",setNull(json.LQyryxx_lsxx[0].cyrybh));
		changeAndWriteRedFont("qymc",setNull(json.LQyryxx_lsxx[0].qymc));
		changeAndWriteRedFont("xm",setNull(json.LQyryxx_lsxx[0].xm));
		changeAndWriteRedFont("xb",setNull(json.LQyryxx_lsxx[0].xb));
		//$("#csrq").append(setNull(json.LQyryxx_lsxx[0].csrq));
		if(json.LQyryxx_lsxx[0].csrq!=null)
			changeAndWriteRedFont("csrq",setNull(json.LQyryxx_lsxx[0].csrq.substr(0,10)));
		changeAndWriteRedFont("zzzhm",setNull(json.LQyryxx_lsxx[0].zzzhm));
		changeAndWriteRedFont("zzdz",setNull(json.LQyryxx_lsxx[0].zzdz));
		changeAndWriteRedFont("shouji",setNull(json.LQyryxx_lsxx[0].shouji));
		changeAndWriteRedFont("qtlxdh",setNull(json.LQyryxx_lsxx[0].qtlxdh));
		changeAndWriteRedFont("zhiwu",setNull(json.LQyryxx_lsxx[0].zhiwu));
		//$("#rzrq").append(setNull(json.LQyryxx_lsxx[0].rzrq));
		if(json.LQyryxx_lsxx[0].rzrq!=null)
			changeAndWriteRedFont("rzrq",setNull(json.LQyryxx_lsxx[0].rzrq.substr(0,10)));
		changeAndWriteRedFont("zxr",setNull(json.LQyryxx_lsxx[0].zxr));
		if(json.LQyryxx_lsxx[0].zxsj!=null)
			changeAndWriteRedFont("zxsj",setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
		if(json.LQyryxx_lsxx[0].cjsj!=null)
			changeAndWriteRedFont("cjsj",setNull(json.LQyryxx_lsxx[0].cjsj.substr(0,10)));
		changeAndWriteRedFont("cjr",setNull(json.LQyryxx_lsxx[0].cjr));
		changeAndWriteRedFont("hcdw",setNull(json.LQyryxx_lsxx[0].csmc));
		changeAndWriteRedFont("zxyy",setNull(json.LQyryxx_lsxx[0].zxyy));
		changeAndWriteRedFont("zt",setNull(json.LQyryxx_lsxx[0].zt));
		changeAndWriteRedFont("scbz",setNull(json.LQyryxx_lsxx[0].scbz));
		changeAndWriteRedFont("ywx",setNull(json.LQyryxx_lsxx[0].ywx));
		changeAndWriteRedFont("ywm",setNull(json.LQyryxx_lsxx[0].ywm));
		changeAndWriteRedFont("gj",setNull(json.LQyryxx_lsxx[0].gj));
		changeAndWriteRedFont("wgrjyxkz",setNull(json.LQyryxx_lsxx[0].wgrjyxkz));
		changeAndWriteRedFont("qzzldm",setNull(json.LQyryxx_lsxx[0].qzzldm));
		changeAndWriteRedFont("qzhm",setNull(json.LQyryxx_lsxx[0].qzhm));
		changeAndWriteRedFont("cyzj",setNull(json.LQyryxx_lsxx[0].cyzj));
		changeAndWriteRedFont("zjhm",setNull(json.LQyryxx_lsxx[0].zjhm));
		changeAndWriteRedFont("cjdbm",setNull(json.LQyryxx_lsxx[0].cjdbm));
		changeAndWriteRedFont("cjdmc",setNull(json.LQyryxx_lsxx[0].cjdmc));
		changeAndWriteRedFont("cylb",setNull(json.LQyryxx_lsxx[0].cylb));
		changeAndWriteRedFont("csid",setNull(json.LQyryxx_lsxx[0].csid));
		changeAndWriteRedFont("csmc",setNull(json.LQyryxx_lsxx[0].csmc));
		changeAndWriteRedFont("cyryzt",setNull(json.LQyryxx_lsxx[0].cyryzt));
		changeAndWriteRedFont("shengao",setNull(json.LQyryxx_lsxx[0].shengao));
		changeAndWriteRedFont("tizh",setNull(json.LQyryxx_lsxx[0].tizh));
		changeAndWriteRedFont("xx",setNull(json.LQyryxx_lsxx[0].xx));
		changeAndWriteRedFont("bz",setNull(json.LQyryxx_lsxx[0].bz));
		
		changeAndWriteRedFont("cylbdm",setNull(json.LQyryxx_lsxx[0].cylb));
  		changeAndWriteRedFont("hyzk",setNull(json.LQyryxx_lsxx[0].hyzk));
		//$("#zpwtgyy").append(setNull(json.LCyryxx[0].zpwtgyy));
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+dataid);
		$('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
	}
	
	function addtotempList(key,value){
		var objOption = "<option value='"+key+"'>"+value+"</option>";
		$("#bdqylsxx").append($(objOption));
	}
	function getValueByKey(key){
		var result = "";
		$("#bdqylsxx option").each(function(){
			if($(this).attr("value")==key){
				result =  $(this).text();
				return false;
			}
		});
		return result;
	}
	function changeAndWriteRedFont(key,value){ //不同时 红色字体
		$("#"+key).append(value); //赋值
		var values = getValueByKey(key); //获取对比值
		if(values!=value){
			$("td[id^='"+key+"']").each(function(){
				$(this).addClass("red");
			});
			$("span[id^='"+key+"']").each(function(){
				$(this).addClass("red");
			});
			if(key=="tyrq_"){
				showOrHideYlQitaxxbq('tyrq_','block');
			}
		}
	}	
</script>
<input type="hidden" id="q_rylsid">
<select id="bdqylsxx" style="DISPLAY:none"></select>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">境外从业人员历史信息详情</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#wgcyrylsxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr>
		<td class="distd1">企业名称</td>
		<td colspan="3" class="detailtd2" width="500px"><span id="qymc"></span></td>
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
		<td colspan="3" class="detailtd2" width="490"><span id="zzdz"></span></td>
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