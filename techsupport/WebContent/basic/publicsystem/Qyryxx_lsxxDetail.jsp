<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<%
Date da=new Date();
		long lo=da.getTime();
 %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_rylsid").attr("value",dataid);
		setParams("q_");
		jQuery.post("publicsystem/query_qyryxx_lsxx.action",params,updatediv,"json");
	}); 

	function updatediv (json) { 
	    $("#cyrybh").append(setNull(json.LQyryxx_lsxx[0].cyrybh));
		$("#qymc").append(setNull(json.LQyryxx_lsxx[0].qymc));
		$("#gemc").append(setNull(json.LQyryxx_lsxx[0].gwmc));
		$("#xm").append(setNull(json.LQyryxx_lsxx[0].xm));
		$("#bm").append(setNull(json.LQyryxx_lsxx[0].bm));
		$("#minzu").append(setNull(json.LQyryxx_lsxx[0].minzu));
		$("#xb").append(setNull(json.LQyryxx_lsxx[0].xb));
		$("#csrq").append(setNull(json.LQyryxx_lsxx[0].csrq));
		$("#hyzk").append(setNull(json.LQyryxx_lsxx[0].hyzk));
		$("#hjdxzqh").append(setNull(json.LQyryxx_lsxx[0].hjdxzqh));
		$("#hjdxz").append(setNull(json.LQyryxx_lsxx[0].hjdxz));
		$("#zjhm").append(setNull(json.LQyryxx_lsxx[0].zjhm));
		$("#zzzhm").append(setNull(json.LQyryxx_lsxx[0].zzzhm));
		$("#zzdz").append(setNull(json.LQyryxx_lsxx[0].zzdz));
		$("#shouji").append(setNull(json.LQyryxx_lsxx[0].shouji));
		$("#qtlxdh").append(setNull(json.LQyryxx_lsxx[0].jjlxrdh));
		$("#zhiwu").append(setNull(json.LQyryxx_lsxx[0].zhiwu));
		$("#rzrq").append(setNull(json.LQyryxx_lsxx[0].rzrq));
		$("#zxr").append(setNull(json.LQyryxx_lsxx[0].zxr));
		if(json.LQyryxx_lsxx[0].zxsj!=null){
			$("#zxsj").append(setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
			$("#zxsj2").append(setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
			}
		if(json.LQyryxx_lsxx[0].cjsj!=null)
			$("#cjsj").append(setNull(json.LQyryxx_lsxx[0].cjsj.substr(0,10)));
		$("#cjr").append(setNull(json.LQyryxx_lsxx[0].cjr));
		$("#hcdw").append(setNull(json.LQyryxx_lsxx[0].hcdw));
		$("#zxyy").append(setNull(json.LQyryxx_lsxx[0].zxyy));
		$("#cyryzt").append(setNull(json.LQyryxx_lsxx[0].cyryzt));
		$("#scbz").append(setNull(json.LQyryxx_lsxx[0].zxbz));
		$("#csmc").append(setNull(json.LQyryxx_lsxx[0].csmc));
		$("#shengao").append(setNull(json.LQyryxx_lsxx[0].shengao));
		$("#tizh").append(setNull(json.LQyryxx_lsxx[0].tizh));
		$("#bz").append(setNull(json.LQyryxx_lsxx[0].bz));
		$("#gwzrms").append(setNull(json.LQyryxx_lsxx[0].gwzrms));
		$("#zpwtgyy").append(setNull(json.LQyryxx_lsxx[0].zpwtgyy));
		$("#zxr2").append(setNull(json.LQyryxx_lsxx[0].zxr));
		if(setNull(json.LQyryxx_lsxx[0].scbz)==1){
			$('#zhuxiao').empty();
			$('#shanchu').show();
		}
		var zkzt = setNull(json.LQyryxx_lsxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
			
		$("#ryImage").attr("src",'<%=request.getContextPath()%>/'+"publicsystem/queryTp_qyryxx.action?ryId="+json.LQyryxx_lsxx[0].ryid+'&aa=<%=lo %>');
	}	
</script>
<input type="hidden" id="q_rylsid">
<table width="100%"  cellpadding="1" cellspacing="0" class="detail" id="detail" >
<tr>
			<td colspan="6"  class="queryfont">企业人员信息</td>
		</tr>
	<tr>
		<td width="12%" class="distd1">人员编号</td>
	  <td width="23%"  class="detailtd2"><span id="cyrybh"></span></td>
      <td width="13%" class="distd1">姓名</td>
      <td width="18%" class="detailtd2"><span id="xm"></span></td>
      <td colspan="2" rowspan="9" align="center" valign="top" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      </table></td>
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
		<td class="distd1">户籍省县</td>
		<td class="detailtd2"><span id="hjdxzqh"></span></td>
	    <td class="distd1">入职日期</td>
	    <td class="detailtd2"><span id="rzrq"></span></td>
    </tr>
	<tr>
		<td  class="distd1">户籍地详址</td>
		<td colspan="3" class="detailtd2"><span id="hjdxz"></span></td>
    </tr>
	<tr>
		<td class="distd1">岗位类别</td>
		<td class="detailtd2"><span id="gemc"></span></td>
	    <td class="distd1">联系电话</td>
	    <td class="detailtd2"><span id="shouji"></span></td>
    </tr>
	<tr>
		<td class="distd1">企业名称</td>
		<td colspan="3" class="detailtd2"><span id="qymc"></span></td>
    </tr>
	<tr>
		<td class="distd1">紧急联系电话</td>
		<td class="detailtd2"><span id="qtlxdh"></span></td>
	    <td class="distd1">身高（厘米）</td>
	    <td class="detailtd2"><span id="shengao"></span></td>
    </tr>
	<tr>
		<td class="distd1">职务</td>
		<td class="detailtd2"><span id="zhiwu"></span></td>
	    <td class="distd1">体重（公斤）</td>
	    <td class="detailtd2"><span id="tizh"></span></td>
		<td width="10%" class="distd1">暂住证号码</td>
		<td width="24%" class="detailtd2"><span id="zzzhm"></span></td>
    </tr>
	<tr>
		<td class="distd1">暂住地址</td>
		<td colspan="5" class="detailtd2"><span id="zzdz"></span></td>
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
	<tr>
		<td class="distd1">岗位责任描述</td>
	  <td colspan="5" class="detailtd2"><span id="gwzrms"></span></td>
    </tr>
	<tr>
		<td class="distd1">备注</td>
	  <td colspan="5" class="detailtd2"><span id="bz"></span></td>
    </tr>
	<tr id="tr_zpwtgyy" style="display:none">
		<td class="distd1">照片未通过原因</td>
	  <td colspan="5" class="detailtd2"><span id="zpwtgyy"></span></td>
    </tr>
    	<tr>
		<td  height="3" colspan="6"></td>
	  </tr>
</table>
