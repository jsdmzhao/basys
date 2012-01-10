<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
	Date da=new Date();
	long lo=da.getTime();
	String userName = "";
	String userbm = "";
	User user= (User)session.getAttribute(Constants.userKey);
	if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
		userName = user.getSsdwmc();
		userbm = user.getSsdwbm();
	}
 %>
<script type="text/javascript">
	var qymc="<%=userName %>";
	var qybm="<%=userbm %>";
	$(document).ready(function() {
		if(tj_tcryxx!=null && tj_tcryxx=="true")
			$("#q_cyrybh").attr("value",dataid);
		else
			$("#q_ryid").attr("value",dataid);
		setDetail();
		if(qybm!=""){ //企业端 
			$("#sscs").hide();
		}
	}); 
function updatediv (json) { 
	if(json.LWgcyryxx[0]!=null){
		$("#cyrybh").append(setNull(json.LWgcyryxx[0].cyrybh));
		$("#xm").append(setNull(json.LWgcyryxx[0].xm));
		$("#xb").append(setNull(json.LWgcyryxx[0].xb));
		//$("#csrq").append(setNull(json.LWgcyryxx[0].csrq));
		if(json.LWgcyryxx[0].csrq!=null)
			$("#csrq").append(setNull(json.LWgcyryxx[0].csrq.substr(0,10)));
		$("#zzzhm").append(setNull(json.LWgcyryxx[0].zzzhm));
		$("#zzdz").append(setNull(json.LWgcyryxx[0].zzdz));
		$("#shouji").append(setNull(json.LWgcyryxx[0].shouji));
		$("#qtlxdh").append(setNull(json.LWgcyryxx[0].jjlxrdh));
		$("#zhiwu").append(setNull(json.LWgcyryxx[0].zhiwu));
		//$("#rzrq").append(setNull(json.LWgcyryxx[0].rzrq));
		if(json.LWgcyryxx[0].rzrq!=null)
			$("#rzrq").append(setNull(json.LWgcyryxx[0].rzrq.substr(0,10)));
		$("#zxr").append(setNull(json.LWgcyryxx[0].zxr));
		if(json.LWgcyryxx[0].zxsj!=null){
			$("#zxsj").append(setNull(json.LWgcyryxx[0].zxsj.substr(0,10)));
			$("#zxsj2").append(setNull(json.LWgcyryxx[0].zxsj.substr(0,10)));
			}
		
		if(json.LWgcyryxx[0].lrsj!=null)
			$("#cjsj").append(setNull(json.LWgcyryxx[0].lrsj.substr(0,10)));
		$("#cjr").append(setNull(json.LWgcyryxx[0].cjr));
		$("#zxyy").append(setNull(json.LWgcyryxx[0].zxyy));
		$("#zt").append(setNull(json.LWgcyryxx[0].zt));
		$("#zxbz").append(setNull(json.LWgcyryxx[0].zxbz));
		$("#ywx").append(setNull(json.LWgcyryxx[0].ywx));
		$("#ywm").append(setNull(json.LWgcyryxx[0].ywm));
		$("#gj").append(setNull(json.LWgcyryxx[0].gj));
		
		$("#wgrjyxkz").append(setNull(json.LWgcyryxx[0].wgrjyxkz));
		$("#qzzldm").append(setNull(json.LWgcyryxx[0].qzzldm)); 
		$("#qzhm").append(setNull(json.LWgcyryxx[0].qzhm));
		$("#cyzj").append(setNull(json.LWgcyryxx[0].cyzj));
		$("#zjhm").append(setNull(json.LWgcyryxx[0].zjhm));
		$("#cjdbm").append(setNull(json.LWgcyryxx[0].cjdbm));
		$("#cjdmc").append(setNull(json.LWgcyryxx[0].cjdmc));
		//$("#cylb").append(setNull(json.LWgcyryxx[0].cylb));
		//$("#qyid").append(setNull(json.LWgcyryxx[0].qyid));
		$("#cyryzt").append(setNull(json.LWgcyryxx[0].cyryzt));
		$("#shengao").append(setNull(json.LWgcyryxx[0].shengao));
		$("#tizh").append(setNull(json.LWgcyryxx[0].tizh));
		$("#bz").append(setNull(json.LWgcyryxx[0].bz));
		$("#gwmc").append(setNull(json.LWgcyryxx[0].gwmc));
		$("#qymc").append(setNull(json.LWgcyryxx[0].qymc));
		$("#jjlxrdh").append(setNull(json.LWgcyryxx[0].jjlxrdh));
		$("#jjlxr").append(setNull(json.LWgcyryxx[0].jjlxr));
		
		//$("#cylbdm").append(setNull(json.LWgcyryxx[0].wgmc));
  		$("#hyzk").append(setNull(json.LWgcyryxx[0].hyzk));		
		
		$("#zpwtgyy").append(setNull(json.LWgcyryxx[0].zpwtgyy));
		$("#gwzrms").append(setNull(json.LWgcyryxx[0].gwzrms));
		$("#zxr2").append(setNull(json.LWgcyryxx[0].czr));
		$("#xx").append(setNull(json.LWgcyryxx[0].xx));
		
		
		if(setNull(json.LWgcyryxx[0].scbz)==1){
			$('#zhuxiao').hide();
			$('#shanchu').show();
		}
		var zkzt = setNull(json.LWgcyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
		
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LWgcyryxx[0].ryid+'&aa=<%=lo %>');
		dataid=setNull(json.LWgcyryxx[0].ryid);
		$("#cylb").append(setNull(json.LWgcyryxx[0].cylb));
		$("#gwbh").append(setNull(json.LWgcyryxx[0].gwbh));
		$("#gwmc").append(setNull(json.LWgcyryxx[0].gwmc));
		$("#djrq").append(setNull(json.LWgcyryxx[0].lrsj).substring(0,10));
	}
}	
</script>
<input type="hidden" id="q_ryid">
<input type="hidden" id="q_cyrybh">
<div align="right">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr>
		<td width="13%" class="distd1">从业人员编号</td>
	  <td width="21%"  class="detailtd2"><span id="cyrybh"></span></td>
      <td width="12%" class="distd1">英文姓</td>
		<td width="21%" class="detailtd2"><span id="ywx"></span></td>
      <td colspan="2" rowspan="14" align="center" valign="top" class="detailtd2" width="28%">
      	<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="130" height="180" /></td></tr>
      </table></td>
  </tr>
	<tr>
	    <td class="distd1">英文名</td>
	    <td class="detailtd2"><span id="ywm"></span></td>
	    <td class="distd1">中文姓名</td>
      <td class="detailtd2"><span id="xm"></span></td>
    </tr>
    	<tr>
	  <td class="distd1">性别</td>
	  <td class="detailtd2"><span id="xb"></span></td>
      <td class="distd1">出生日期</td>
      <td class="detailtd2"><span id="csrq"></span></td>
  </tr>
  	<tr>
		<td class="distd1">国家和地区</td>
		<td class="detailtd2"><span id="gj"></span></td>
	    <td class="distd1">婚姻状况</td>
	    <td class="detailtd2"><span id="hyzk"></span></td>
    </tr>
    	<tr>
		<td class="distd1">外国人就业许可证编号</td>
		<td class="detailtd2"><span id="wgrjyxkz"></span></td>
	    <td class="distd1">入职日期</td>
	    <td class="detailtd2"><span id="rzrq"></span></td>
    </tr>
	<tr>
	  <td class="distd1">证件类型</td>
      <td class="detailtd2"><span id="cyzj"></span></td>
      <td class="distd1">证件号码</td>
      <td class="detailtd2"><span id="zjhm"></span></td>
  </tr>
	<tr>
	  <td class="distd1">签证类型</td>
      <td class="detailtd2"><span id="qzzldm"></span></td>
      <td class="distd1">签证号码</td>
      <td class="detailtd2"><span id="qzhm"></span></td>
  </tr>
  	<tr>
		<td class="distd1">从业人员类别</td>
		<td class="detailtd2"><span id="cylb"></span></td>
		<td class="distd1">联系电话</td>
		<td class="detailtd2"><span id="shouji"></span></td>
    </tr>
	<tr>
		<td class="distd1">血型</td>
		<td class="detailtd2"><span id="xx"></span></td>
	    <td class="distd1">紧急联系人</td>
	    <td class="detailtd2"><span id="jjlxr"></span></td>
	</tr>
	<tr>
		<td class="distd1">身高（厘米）</td>
		<td class="detailtd2"><span id="shengao"></span></td>
	    <td class="distd1">紧急联系人电话</td>
	    <td class="detailtd2"><span id="jjlxrdh"></span></td>
	</tr>
	<tr>
	    <td class="distd1">体重（公斤）</td>
	    <td class="detailtd2"><span id="tizh"></span></td>
		<td class="distd1">暂住证号码</td>
		<td class="detailtd2"><span id="zzzhm"></span></td>
    </tr>
	<tr>
		<td class="distd1">暂住地址</td>
		<td class="detailtd2" colspan="3"><span id="zzdz"></span></td>
    </tr>
    <tr id="sscs">
		<td class="distd1">场所名称</td>
		<td colspan="3" class="detailtd2"><span id="qymc"></span></td>
    </tr>
    <tr>
		<td class="distd1">岗位编号</td>
		<td class="detailtd2"><span id="gwbh"></span></td>
	    <td class="distd1">岗位名称</td>
	    <td class="detailtd2"><span id="gwmc"></span></td>
    </tr>
    <tr>
		<td class="distd1">岗位责任描述</td>
	    <td class="detailtd2" width="560"><span id="gwzrms"></span></td>
	    <td class="distd1">从业人员状态</td>
		<td class="detailtd2"><span id="cyryzt"></span></td>
		<td class="distd1" width="10%">登记日期</td>
		<td class="detailtd2"><span id="djrq"></span></td>
    </tr>
	<tr id="zhuxiao">
	    <td class="distd1">注销日期</td>
	    <td class="detailtd2"><span id="zxsj"></span></td>
		<td class="distd1">注销原因</td>
		<td class="detailtd2"><span id="zxyy"></span></td>
         <td class="distd1" width="10%">人员注销标志</td>
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
	<tr>
		<td class="distd1">备注</td>
	  <td colspan="5" class="detailtd2" width="560"><span id="bz"></span></td>
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
<div id="qyrytjxx"  >
</div>	