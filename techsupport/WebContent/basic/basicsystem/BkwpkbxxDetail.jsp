<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	String deptCode = "";
	String deptName = "";
	String userName = "";
	User user = new User();
	// 获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null){
		response.sendRedirect("login.jsp");
	}else{
	    deptCode = user.getDepartment().getDepartcode();
	    deptName = user.getDepartment().getDepartname();
	    userName = user.getUsername();
	}
%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(5); //将保存按钮右移
	    bc_bottonMoveRight(5,'打印'); //将保存按钮右移
	    $("#q_bkwpjbxxid").attr("value",dataid);
		$("#c_bkwpjbxxid").attr("value",dataid);
		$("#s_bkwpjbxxid").attr("value",dataid);
        strType = $("#cmdType").val();
        strTitle = "";
        if (strType == "ck"){
            strTitle = "布控物品撤控";
            $("#printbutton").hide();
            $("#ckbutton").show();
            $("#shbutton").hide();
        }else if(strType == "sh"){
            strTitle = "布控物品审核";
            $("#printbutton").hide();
            $("#ckbutton").hide();
            $("#shbutton").show();
        }else{
            strTitle = "布控物品详细信息";
            $("#printbutton").show();
            $("#ckbutton").hide();
            $("#shbutton").hide();
        }
        $("#cmdType").attr("value","");
        $("#title").html(strTitle);
		$("#q_bkwpjbxxid").attr("value",dataid);
		setDetail();
		$("#wpImage").attr("src","<%=request.getContextPath()%>/basicsystem/queryZp_bkwpkbxx.action?bkwpjbxxid="+dataid);
		$("#c_ckczsj").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);	
		$("#s_cksprq").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);	
	}); 
		
	function updatediv (json) {
		$("#bkwpjbxxid").append(setNull(json.LBkwpkbxx[0].bkwpjbxxid));
		$("#bkwpmc").append(setNull(json.LBkwpkbxx[0].bkwpmc));
		$("#bkwplx").append(setNull(json.LBkwpkbxx[0].bkwplx));
		$("#bkwplxdm").attr("value",setNull(json.LBkwpkbxx[0].bkwplxdm));
		$("#bkwpms").append(setNull(json.LBkwpkbxx[0].bkwpms));
		
		$("#tbbh").append(setNull(json.LBkwpkbxx[0].tbbh));
		$("#ajlb").append(setNull(json.LBkwpkbxx[0].ajlb));
		$("#fwdw").append(setNull(json.LBkwpkbxx[0].fwdw));
		$("#tbsj2").append(setNull(json.LBkwpkbxx[0].tbsj2));
		$("#jyaq").append(setNull(json.LBkwpkbxx[0].jyaq));
		$("#cljg").append(setNull(json.LBkwpkbxx[0].cljg));
		$("#bkr").append(setNull(json.LBkwpkbxx[0].bkr));
		$("#bkczy").append(setNull(json.LBkwpkbxx[0].bkczy));
		$("#bkfw").append(setNull(json.LBkwpkbxx[0].bkfw));
		$("#bkczsj").append(setNull(json.LBkwpkbxx[0].bkczsj));
		$("#lxr").append(setNull(json.LBkwpkbxx[0].lxr));
		$("#lxfs").append(setNull(json.LBkwpkbxx[0].lxfs));
		$("#bkdqsj").append(setNull(json.LBkwpkbxx[0].bkdqsj));
		$("#hylb").append(setNull(json.LBkwpkbxx[0].hylb));
		if($("#bkwplxdm").val() == "2"){
		    $("#cllx").append(setNull(json.LBkwpkbxx[0].bkcl.cllx));
	        $("#clpp").append(setNull(json.LBkwpkbxx[0].bkcl.clpp));
		    $("#clxh").append(setNull(json.LBkwpkbxx[0].bkcl.clxh));
		    $("#hphm").append(setNull(json.LBkwpkbxx[0].bkcl.hphm));
		    $("#syr").append(setNull(json.LBkwpkbxx[0].bkcl.syr));
		    $("#fdjh").append(setNull(json.LBkwpkbxx[0].bkcl.fdjh));
		    $("#cjh").append(setNull(json.LBkwpkbxx[0].bkcl.cjh));
		    $("#csys").append(setNull(json.LBkwpkbxx[0].bkcl.csys));
		    $("#ccdjrq").append(setNull(json.LBkwpkbxx[0].bkcl.ccdjrq));
		    $("[id^='clDetail_']").show();
	        $("[id^='sjDetail_']").hide();
		} else if($("#bkwplxdm").val() == "1"){
	        $("#pp").append(setNull(json.LBkwpkbxx[0].bksj.pp));
		    $("#xh").append(setNull(json.LBkwpkbxx[0].bksj.xh));
		    $("#sjch").append(setNull(json.LBkwpkbxx[0].bksj.sjch));
		    $("#ys").append(setNull(json.LBkwpkbxx[0].bksj.ys));
		    $("[id^='clDetail_']").hide();
	        $("[id^='sjDetail_']").show();
		} else{
		    $("[id^='clDetail_']").hide();
	        $("[id^='sjDetail_']").hide();
		}
	}
	
	function setCkUpdate(){
	    setParams("c_");
		jQuery.post(ckUrl,params,updateCKback,"json"); 
		return true;
	}
	function updateCKback(json){
	    if(json.result=="success"){
		    jAlert('撤控成功','保存信息');
		    setPageList($("#pageNo").attr("value"));
		    $("#"+detailid).hideAndRemove("slow"); 
	    }else{
		    jAlert(json.result,'错误信息');
	    }		
	}
	function setShUpdate(){
		    setParams("s_");
		    jQuery.post(ckUrl,params,updateSHback,"json"); 
		    return true;
	}
    function updateSHback(json){
	    if  (json.result=="success"){
		    jAlert('审核成功','保存信息');
		    setPageList($("#pageNo").attr("value"));
		    $("#"+detailid).hideAndRemove("slow"); 
	    }else{
		    jAlert(json.result,'错误信息');
	    }		
    }
function printpage(myDiv){ 
   var content = document.all.item(myDiv).innerHTML;
    var title = "布控物品详细信息"; //标题信息
    params={con:content,titlecon:title};
    jQuery.post("basicsystem/printCon_publicPrint.action",params,printback,"json");
    return false; 
} 

function printback(){
    var url = window.location.href;
   var len = url.lastIndexOf('/');
   url = url.substring(0, len)+"/public/printHtml.jsp";
   window.open(url);
}
</script>
<input type="hidden" id="bkwplxdm">
<input type="hidden" id="q_bkwpjbxxid">
<input type="hidden" id="c_bkwpjbxxid">
<input type="hidden" id="s_bkwpjbxxid">
<input type="hidden" id="s_shjg" value="1">
<input type="hidden" id="s_ckspr" value="<%=userName%>">
<input type="hidden" id="s_ckspdw" value="<%=deptName%>">
<input type="hidden" id="s_cksprq">
<input type="hidden" id="c_ckbs" value="1">
<input type="hidden" id="c_ckczsj">
<input type="hidden" id="c_ckczy" value="<%=userName%>">
<input type="hidden" id="c_ckbmbm" value="<%=deptCode%>">
<input type="hidden" id="c_ckbmmc" value="<%=deptName%>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1" id="title"></td>
      <td align="right"  class="title1"><a href="#" id="closeDiv" onclick='$("#bkwpkbxx_detail").hideAndRemove(&quot;show&quot;);' class="close"></a></td>
    </tr>
</table>
<div id="printDiv" class="scrollbarface"  style="overflow-y:auto;height:370">
  <table width="98%" cellpadding="3" cellspacing="0" class="detail" id="detail" >
    <tr>
      <td width="13%" class="distd1">物品类型</td>
      <td width="22%"  class="detailtd2"><span id="bkwplx" /></span></td>
      <td width="13%" class="distd1">物品名称</td>
      <td width="23%" class="detailtd2"><span id="bkwpmc" /></span></td>
      <td colspan="2" rowspan="10" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0" class="detail">
          <input type="hidden" id="m_fileload" />
          <tr>
            <td align="center"><img id="wpImage" width="110" height="150" /> </td>
          </tr>
      </table></td>
    </tr>
    <tr height="20" id="clDetail_1">
      <td width="13%" class="distd1"><font color="blue">车辆品牌</font></td>
      <td width="22%" class="detailtd2"><span id="clpp" /></span></td>
      <td width="13%" class="distd1"><font color="blue">车辆型号</font></td>
      <td width="23%" class="detailtd2"><span id="clxh" /></span></td>
    </tr>
    <tr height="20" id="clDetail_2">
      <td width="13%" class="distd1"><font color="blue">车辆号牌</font></td>
      <td width="22%" class="detailtd2"><span id="hphm" /></span></td>
      <td width="13%" class="distd1"><font color="blue">机动车所有人</font></td>
      <td width="23%" class="detailtd2"><span id="syr" /></span></td>
    </tr>
    <tr height="20" id="clDetail_3">
      <td class="distd1"><font color="blue">车辆类型</font></td>
      <td class="detailtd2"><span id="cllx" /></span></td>
      <td class="distd1"><font color="blue">发动机号</font></td>
      <td class="detailtd2"><span id="fdjh" /></span></td>
    </tr>
    <tr height="20" id="clDetail_4">
      <td class="distd1"><font color="blue">车架号</font></td>
      <td class="detailtd2"><span id="cjh" /></span></td>
      <td class="distd1"><font color="blue">初次登记日期</font></td>
      <td class="detailtd2"><span id="ccdjrq" /></span></td>
    </tr>
    <tr id="clDetail_5">
      <td class="distd1" ><font color="blue">车辆颜色</font></td>
      <td class="detailtd2" colspan="3"><span id="csys" /></span></td>
    </tr>
    <tr height="20" id="sjDetail_1">
      <td width="13%" class="distd1"><font color="green">手机品牌</font></td>
      <td width="22%" class="detailtd2"><span id="pp" /></span></td>
      <td width="13%" class="distd1"><font color="green">手机型号</font></td>
      <td width="23%" class="detailtd2"><span id="xh" /></span></td>
    </tr>
    <tr id="sjDetail_2">
      <td width="13%" class="distd1"><font color="green">手机串号</font></td>
      <td width="22%" class="detailtd2"><span id="sjch" /></span></td>
      <td width="13%" class="distd1"><font color="green">手机颜色</font></td>
      <td width="23%" class="detailtd2"><span id="ys" /></span></td>
    </tr>
    <tr height="20">
      <td width="13%" class="distd1">通报编号</td>
      <td width="22%" class="detailtd2"><span id="tbbh" /></span></td>
      <td width="13%" class="distd1">案件类别</td>
      <td width="23%" class="detailtd2"><span id="ajlb" /></span></td>
    </tr>
    <tr>
      <td width="13%" class="distd1">布控单位</td>
      <td width="22%" class="detailtd2"><span id="fwdw" /></span></td>
      <td width="13%" class="distd1">通报时间</td>
      <td width="23%" class="detailtd2"><span id="tbsj2" /></span></td>
    </tr>
    <tr>
      <td class="distd1">物品描述</td>
      <td colspan="5" class="detailtd2"><span id="bkwpms" /></span></td>
    </tr>
  <tr height="20">
    <td width="13%" class="distd1">简要案情</td>
    <td colspan="5"  class="detailtd2"><span id="jyaq" /></span></td>
  </tr>
  <tr height="20">
    <td  class="distd1">处理结果</td>
    <td  class="detailtd2" colspan="5"><span id="cljg" /></span></td>
  </tr>
  <tr height="20">
    <td width="13%" class="distd1">布控人</td>
    <td width="22%" class="detailtd2"><span id="bkr" /></span></td>
    <td width="13%" class="distd1">布控操作员</td>
    <td width="23%" class="detailtd2"><span id="bkczy" /></span></td>
    <td width="12%" class="distd1">布控范围</td>
    <td width="17%" class="detailtd2"><span id="bkfw" /></span></td>
    </tr>
  <tr height="20">
    <td width="13%" class="distd1">布控操作时间</td>
    <td width="22%" class="detailtd2"><span id="bkczsj" /></span></td>
    <td class="distd1">联系人</td>
    <td class="detailtd2"><span id="lxr" /></span></td>
    <td class="distd1">联系方式</td>
    <td class="detailtd2"><span id="lxfs" /></span></td>
      </tr>
  <tr height="20">
    <td class="distd1">布控终止时间</td>
    <td class="detailtd2"><span id="bkdqsj" /></span></td>
    <td class="distd1">行业类别</td>
    <td class="detailtd2"  colspan="3"><span id="hylb" /></span></td>
  </tr>
  </table>
</div>
<table width="100%" cellpadding="4" cellspacing="0" class="detail">
<tr height="25" align="center">
    <td width="50%" align="right">
    <a href="#" id="printbutton" hidefocus="true" class="submitbutton"
  title="打印" onclick='printpage("printDiv");'>打印</a>
	   <a href="#" id="ckbutton" hidefocus="true" class="submitbutton"
  title="保存" onclick='setCkUpdate();'>保存</a>
	   <a href="#" id="shbutton" hidefocus="true" class="submitbutton"
  title="保存" onclick='setShUpdate();'>保存</a>
    </td>
   <!--  <td  align="left">
    <a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='$("#bkwpkbxx_detail").hideAndRemove(&quot;show&quot;);'>关闭</a>
    </td>--> 
</tr>
</table>
