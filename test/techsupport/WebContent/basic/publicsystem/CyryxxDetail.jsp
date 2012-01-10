<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
	String userName = "";
	String userbm = "";
	User user= (User)session.getAttribute(Constants.userKey);
	if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
		userName = user.getSsdwmc();
		userbm = user.getSsdwbm();
	}
	Date da=new Date(); long lo=da.getTime();
 %>
<script type="text/javascript">
	var qymc="<%=userName %>";
	var qybm="<%=userbm %>";
	$(document).ready(function() {
		var queryCyryxxByCyrybh = setNull($("#queryCyryxxByCyrybh").attr("value"));
		if(tj_tcryxx!=null && tj_tcryxx=="true"){
			$("#q_cyrybh").attr("value",dataid);
		} else if (queryCyryxxByCyrybh!=''){
			$("#q_cyrybh").attr("value",queryCyryxxByCyrybh);
		} else {
			$("#q_ryid").attr("value",dataid);
		}
		setDetail();
		if(qybm!=""){ //企业端 
			$("#sscs").hide();
		}
	}); 
	function updatediv (json) { 
		dataid = setNull(json.LQyryxx[0].ryid);
		$("#cyrybh").append(setNull(json.LQyryxx[0].cyrybh));
		$("#cyzj").append(setNull(json.LQyryxx[0].cyzj));
		$("#xx").append(setNull(json.LQyryxx[0].xx));
		$("#qymc").append(setNull(json.LQyryxx[0].qymc));
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
		$("#jjlxr").append(setNull(json.LQyryxx[0].jjlxr));
		$("#jjlxrdh").append(setNull(json.LQyryxx[0].jjlxrdh));
		$("#rzrq").append(setNull(json.LQyryxx[0].rzrq));
		$("#zxr").append(setNull(json.LQyryxx[0].zxr));
		if(json.LQyryxx[0].cjsj!=null)
			$("#cjsj").append(setNull(json.LQyryxx[0].cjsj.substr(0,10)));
		$("#cjr").append(setNull(json.LQyryxx[0].cjr));
		$("#hcdw").append(setNull(json.LQyryxx[0].hcdw));
		$("#cyryzt").append(setNull(json.LQyryxx[0].cyryzt));
		$("#zxbz").append(setNull(json.LQyryxx[0].zxbz));
		if(setNull(json.LQyryxx[0].zxbz)=='已注销'){
			if(json.LQyryxx[0].zxsj!=null){
				$("#zxsj").append(setNull(json.LQyryxx[0].zxsj.substr(0,10)));
				$("#zxsj2").append(setNull(json.LQyryxx[0].zxsj.substr(0,10)));
			}
			$("#zxyy").append(setNull(json.LQyryxx[0].zxyy));
		}
		$("#csmc").append(setNull(json.LQyryxx[0].csmc));
		$("#shengao").append(setNull(json.LQyryxx[0].shengao));
		$("#tizh").append(setNull(json.LQyryxx[0].tizh));
		$("#bz").append(setNull(json.LQyryxx[0].bz));
		$("#gwzrms").append(setNull(json.LQyryxx[0].gwzrms));
		$("#zpwtgyy").append(setNull(json.LQyryxx[0].zpwtgyy));
		$("#zxr2").append(setNull(json.LQyryxx[0].zxr));
		if(setNull(json.LQyryxx[0].scbz)==1){
			$('#zhuxiao').empty();
			$('#shanchu').show();
		}
		var zkzt = setNull(json.LQyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
			
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+json.LQyryxx[0].ryid+'&aa=<%=lo %>');
		dataid=setNull(json.LQyryxx[0].ryid);
		
		$("#cylb").append(setNull(json.LQyryxx[0].cylb));
		$("#gwbh").append(setNull(json.LQyryxx[0].gwbh));
		$("#gwmc").append(setNull(json.LQyryxx[0].gwmc));
		$("#djrq").append(setNull(json.LQyryxx[0].lrsj).substring(0,10));
	}	
</script>
<input type="hidden" id="q_ryid">
<input type="hidden" id="q_cyrybh">
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr>
		<td class="distd1">从业人员编号</td>
		<td class="detailtd2" colspan="3"><span id="cyrybh"></span></td>
		<td colspan="2" rowspan="13" align="center" valign="top" class="detailtd2" width="28%">
		<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="130" height="180" /></td></tr>
		</table></td>
  </tr>
	<tr>
		<td class="distd1" width="12%" >姓名</td>
		<td class="detailtd2" width="23%"><span id="xm"></span></td>
	    <td class="distd1" width="13%">别名</td>
	    <td class="detailtd2" width="23%"><span id="bm" ></span></td>
    </tr>
	<tr>
	    <td class="distd1">常用证件</td>
	    <td class="detailtd2"><span id="cyzj" ></span></td>
		<td class="distd1">证件号码</td>
		<td class="detailtd2"><span id="zjhm" ></span></td>
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
		<td class="distd1">户口所在地</td>
		<td class="detailtd2"><span id="hjdxzqh"></span></td>
	    <td class="distd1">入职日期</td>
	    <td class="detailtd2"><span id="rzrq"></span></td>
    </tr>
	<tr>
		<td class="distd1">户口所在地详址</td>
		<td colspan="3" class="detailtd2"><span id="hjdxz"></span></td>
    </tr>
    <tr>
		<td class="distd1">从业人员类别</td>
		<td class="detailtd2"><span id="cylb"></span></td>
		<td class="distd1">血型</td>
		<td class="detailtd2"><span id="xx"></span></td>
    </tr>
	<tr>
	    <td class="distd1">联系电话</td>
	    <td class="detailtd2"><span id="shouji"></span></td>
		<td class="distd1">紧急联系人</td>
		<td class="detailtd2"><span id="jjlxr"></span></td>
    </tr>
    <tr>
		<td class="distd1">紧急联系人电话</td>
		<td class="detailtd2"><span id="jjlxrdh"></span></td>
	    <td class="distd1">身高（厘米）</td>
	    <td class="detailtd2"><span id="shengao"></span></td>
    </tr>
	<tr>
		<td class="distd1">暂住证号码</td>
		<td class="detailtd2"><span id="zzzhm"></span></td>
	    <td class="distd1">体重（公斤）</td>
	    <td class="detailtd2"><span id="tizh"></span></td>
    </tr>
	<tr>
		<td class="distd1">暂住地址</td>
		<td colspan="3" class="detailtd2"><span id="zzdz"></span></td>
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
		<td class="detailtd2"><span id="gwzrms"></span></td>
		<td class="distd1">从业人员状态</td>
		<td class="detailtd2"><span id="cyryzt"></span></td>
		<td class="distd1">登记日期</td>
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
	  <td colspan="5" class="detailtd2"><span id="bz"></span></td>
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
