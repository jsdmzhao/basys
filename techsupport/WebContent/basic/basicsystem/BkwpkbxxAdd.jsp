<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%
	String userName = "";
	User user = new User();
	// 获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null){
		response.sendRedirect("login.jsp");
	}else{
	userName = user.getUsername();
	}
%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(7); //将保存按钮右移
		$("#a_ccdjrq").attr("readonly","true");
		$("#a_ccdjrq").datepicker();
		$("#a_tbsj2").attr("readonly","true");
		$("#a_tbsj2").datepicker(true);
		//$("#a_bkczsj").attr("readonly","true");
		//$("#a_bkczsj").datepicker();
		$("#a_bkdqsj").attr("readonly","true");
		$("#a_bkdqsj").datepicker(true);
		$("#a_bkwplxdm").selectBox({code:"dm_ddwpzl",query:"0"});
		$("#a_clppdm").selectBox({code:"dm_clpp"});
		$("#a_cllxdm").selectBox({code:"dm_cllx"});
		$("#a_ppdm").selectBox({code:"dm_sjpp"});
		$("#a_bkfwbm").selectBox({code:"dm_bkfw"});
		$("#a_ajlbbm").selectBox({code:"dm_ajlx"});
		$("#clDetail").hide();
	    $("#sjDetail").hide();
	    // 行业类别	
        $("#a_hylbdm").selectBoxhylb();
	}); 
	function addVerify(){
	    $("#a_bkwplx").val($("#a_bkwplxdm").attr("title"));
	    $("#a_bkfw").val($("#a_bkfwbm").attr("title"));
	    $("#a_ajlb").val($("#a_ajlbbm").attr("title"));
	    
	    if (!checkControlValue("a_bkwplxdm","Select",1,20,null,1,"物品类型"))
			return false;
		if (!checkControlValue("a_bkwpmc","String",1,30,null,1,"物品名称"))
			return false;
		if (!checkControlValue("a_bkr","String",1,100,null,1,"布控人"))
			return false;
		if (!checkControlValue("a_bkczy","String",1,100,null,1,"布控操作员"))
			return false;
		if (!checkControlValue("a_bkfwbm","Select",1,300,null,1,"布控范围"))
			return false;
		if (!checkControlValue("a_bkdqsj","Datetime",null,null,null,0,"布控终止时间"))
			return false;
		if (!checkControlValue("a_lxr","String",1,100,null,1,"联系人"))
			return false;
		if (!checkControlValue("a_lxfs","String",1,300,null,1,"联系方式"))
			return false;
		if (!checkControlValue("a_tbbh","String",1,30,null,0,"通报编号"))
			return false;
		if (!checkControlValue("a_ajlbbm","Select",1,60,null,1,"案件类别"))
			return false;
		if (!checkControlValue("a_fwdw","String",1,100,null,1,"发文单位"))
			return false;
		if (!checkControlValue("a_tbsj2","Datetime",null,null,null,1,"通报时间"))
			return false;
		if (!checkControlValue("a_bkwpms","String",1,2000,null,0,"物品描述"))
			return false;
		if (!checkControlValue("a_jyaq","String",1,2000,null,1,"简要案情"))
			return false;
		if (!checkControlValue("a_cljg","String",1,2000,null,0,"处理结果"))
			return false;
		if($("#a_bkwplxdm").val()== "2"){
		    $("#a_cllx").val($("#a_cllxdm").attr("title"));
		    $("#a_clpp").val($("#a_clppdm").attr("title"));
		    
		    if (!checkControlValue("a_clppdm","Select",1,64,null,1,"车辆品牌"))
			    return false;
		    if (!checkControlValue("a_clxh","String",1,64,null,1,"车辆型号"))
			    return false;
			if (!checkControlValue("a_hphm","String",1,32,null,1,"车辆号牌"))
			    return false;
		    if (!checkControlValue("a_syr","String",1,512,null,1,"机动车所有人"))
			    return false;
			if (!checkControlValue("a_cllxdm","Select",1,32,null,1,"车辆类型"))
			    return false;
			if (!checkControlValue("a_fdjh","String",1,60,null,1,"发动机号"))
			    return false;
		    if (!checkControlValue("a_cjh","String",1,50,null,1,"车架号"))
			    return false;
			if (!checkControlValue("a_ccdjrq","Date",null,null,null,0,"初次登记日期"))
			    return false;
		    if (!checkControlValue("a_csys","String",1,32,null,1,"车辆颜色"))
			    return false;
		}
		if($("#a_bkwplxdm").val()== "1"){
		    $("#a_pp").val($("#a_ppdm").attr("title"));
		    if (!checkControlValue("a_ppdm","Select",1,100,null,0,"手机品牌"))
			    return false;
		    if (!checkControlValue("a_xh","String",1,100,null,0,"手机型号"))
			    return false;
		    if (!checkControlValue("a_sjch","String",1,30,null,1,"手机串号"))
			    return false;
		    if (!checkControlValue("a_ys","String",1,60,null,0,"手机颜色"))
			    return false;
		}
		//if (!checkControlValue("a_bkczsj","Date",null,null,null,0,"布控操作时间"))
			//return false;
		if($("#a_bkdqsj").val()!=null && $("#a_bkdqsj").val()!=""){
		    if(dateDiff(new Date(),formatDate($("#a_bkdqsj").val()))>0){
		        jAlert("布控终止时间不能小于布控操作时间！",'提示信息');
		        return false;
		    }
		}
		$("#a_hylb").val($("#a_hylbdm").attr("title"));
		return true;
	}
	 function formatDate(strDate){ //转换成日期格式
		var rqAndTime = strDate.split(" ");
		var riqi = rqAndTime[0].split("-");
		var times = rqAndTime[1].split(":");
		return new Date(riqi[0],(riqi[1]-1),riqi[2],times[0],times[1],times[2]);
	}
	function dateDiff(datestart,dateend){
		return parseInt((datestart - dateend) / 1000 / 60 / 60);
	}
	
	function openfile(){
		ImgerToBase1.OpenFile();
		ImgerToBase();
	}
	function ImgerToBase(){
		// 设置打开图片的大小
		ImgerToBase1.SetFileSize= 2000;
		//文件路径 包括文件名称
		var filePath = ImgerToBase1.getFile();
		// BASE64编码
		var base64code = ImgerToBase1.getBase64();
		var fileName = ImgerToBase1.getFileName();
		if(fileName==null||fileName==''||fileName=='null'){
			$("#pmtPho").attr("src","images/pic.gif");
		} else {
			$("#pmtPho").attr("src",filePath);
		}
		
		$("#a_fileload").attr("value",base64code);
	}
	function saveBkwpxx(){
	if (addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addCallBack,"json");
	}
}	

function addCallBack(json){
	if  (json.result=="success"){
		jAlert('添加成功！','提示信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}
</script>
<input type="hidden" id="a_pp">
<input type="hidden" id="a_clpp">
<input type="hidden" id="a_cllx">
<input type="hidden" id="a_bkwplx">
<input type="hidden" id="a_bkfw">
<input type="hidden" id="a_ajlb">
<input type="hidden" id="a_hylb">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
<tr>
      <td width="97%" align="left" class="title1">布控物品新增</td>
    <td width="3%" align="right"><a href="#" id="closeDiv"
				onclick='$("#bkwpkbxx_detail").hideAndRemove(&quot;show&quot;);' class="close"></a></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="1"></td>
  </tr>
</table>
<table width="98%" id="add">
  <tr>
    <td valign="top"><table width="100%">
      <tr>
        <td width="74%" valign="top"><table width="100%" >
          <tr>
            <td width="13%" class="red">物品类型</td>
        <td colspan="3" class="detailtd"><select name="a_bkwplxdm" id="a_bkwplxdm" onchange="setWPLXForDetail('a');" type="select" value="">
            <option></option>
        </select></td>
        <td width="19%" class="red">物品名称</td>
        <td width="38%" class="detailtd"><input type="text" class="inputstyle"  id="a_bkwpmc" value="" /></td>
          </tr>
        </table>
        <table width="100%">
  <tr height="20">
    <td width="13%" class="red">布控人</td>
    <td width="30%" class="detailtd"><input type="text" class="inputstyle" id="a_bkr" value="" /></td>
    <td width="19%" class="red">布控操作员</td>
    <td width="38%" class="detailtd"><input type="text" readonly="readonly" class="readonly" id="a_bkczy" value="<%=userName %>" /></td>
    </tr>
    <tr height="20">
    <td width="13%" class="red">布控范围</td>
    <td width="30%" class="detailtd"><select name="a_bkfwbm" id="a_bkfwbm" type="select" value="">
      <option></option>
    </select>
    </td>
    <!--<td width="10%" class="distd">布控操作时间</td>
          <td width="23%" class="detailtd"><input type="text" class="inputstyle" id="a_bkczsj" value="" /></td>-->
    <td width="19%" class="distd">布控终止时间</td>
    <td class="detailtd" width="38%" ><input class="inputstyle" type="text" id="a_bkdqsj" value="" /></td>
      </tr>
  <tr height="20">
    <td class="red">联系人</td>
    <td class="detailtd"><input type="text" class="inputstyle" id="a_lxr" value="" /></td>
    <td class="red">联系方式</td>
    <td class="detailtd"><input type="text" class="inputstyle" id="a_lxfs" value="" /></td>
  </tr>
</table>  
          <table width="100%">
              <tr height="20">
                <td width="13%" class="distd">通报编号</td>
                <td width="30%" class="detailtd"><input type="text" class="inputstyle"  id="a_tbbh" value="" /></td>
                <td width="19%" class="red">案件类别</td>
                <td width="38%" class="detailtd"><select name="a_ajlbbm" id="a_ajlbbm" type="select" value="">
                    <option></option>
                  </select>  </td>
              </tr>
              <tr height="20">
                <td width="13%" class="red">发文单位</td>
                <td width="30%" class="detailtd"><input type="text" class="inputstyle"  id="a_fwdw" value="" /></td>
                <td class="red">通报时间</td>
                <td class="detailtd" ><input type="text" class="inputstyle" id="a_tbsj2" value="" /></td>
              </tr>
              <tr height="20">
              <td class="red">行业类别</td>
                <td class="detailtd" colspan="3"><select id="a_hylbdm" ></select></td>
                </tr>
          </table></td>
        <td width="26%" valign="top" ><table width="35%" border="0" align="center" cellpadding="5" cellspacing="0">
            <input type="hidden" id="a_fileload" />
            <tr>
              <td valign="top"><img src="images/pic.gif" name="pmtPho" width="100" height="120" id ="pmtPho"/> <a href="#" id="addbutton2" hidefocus="true" class="submitbutton" title="选图片" onclick='openfile();'>选图片</a></td>
            </tr>
        </table></td>
      </tr>
      
    </table>
     <table width="100%" id="clDetail">
            <tr height="20">
              <td width="10%" class="distd"><font color="blue">车辆品牌</font></td>
    <td width="22%" class="detailtd"><select name="a_clppdm" id="a_clppdm" type="select" value="">
                  <option></option>
              </select></td>
              <td width="14%" class="distd"><font color="blue">车辆型号</font></td>
              <td width="22%" class="detailtd"><input type="text" class="inputstyle"   id="a_clxh" value="" /></td>
               <td width="8%" class="distd"><font color="blue">车辆号牌</font></td>
              <td width="24%" class="detailtd"><input type="text"  class="inputstyle"  id="a_hphm" value="" /></td>
        </tr>
            <tr height="20">
              <td class="distd"><font color="blue">机动车所有人</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="a_syr" value="" /></td>
              <td class="distd"><font color="blue">车辆类型</font></td>
              <td class="detailtd"><select name="a_cllxdm" id="a_cllxdm" type="select" value="">
                  <option></option>
              </select></td>
              <td class="distd"><font color="blue">发动机号</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="a_fdjh" value="" /></td>
            </tr>
            <tr height="20">
               <td class="distd"><font color="blue">车架号</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="a_cjh" value="" /></td>
              <td class="distd"><font color="blue">初次登记日期</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="a_ccdjrq" value="" /></td>
              <td class="distd"><font color="blue">车辆颜色</font></td>
              <td class="detailtd" colspan="3"><input type="text" class="inputstyle"  id="a_csys" value="" /></td>
              </tr>
      </table>
            <table width="100%" id="sjDetail">
              <tr height="20">
                <td width="10%" class="distd"><font color="green">手机品牌</font></td>
    <td width="22%" class="detailtd"><select name="a_ppdm" id="a_ppdm" type="select" value="">
                    <option></option>
                </select></td>
                <td width="14%" class="distd"><font color="green">手机型号</font></td>
                <td width="22%" class="detailtd"><input type="text" class="inputstyle"  id="a_xh" value="" /></td>
                <td width="8%" class="distd"><font color="green">手机串号</font></td>
                <td width="24%" class="detailtd"><input type="text" class="inputstyle"  id="a_sjch" value="" /></td>
              </tr>
              <tr height="20">
                <td class="distd"><font color="green">手机颜色</font></td>
                <td class="detailtd" colspan="5"><input type="text" class="inputstyle"  id="a_ys" value="" /></td>
              </tr>
            </table>
      <table width="100%">
        <tr>
        <td colspan="7" class="detailtd">物品描述 </td>
      </tr>
      <tr>
        <td colspan="7" valign="top"  class="detailtd"><textarea name="textarea" id="a_bkwpms" style="width:760px;" value="" type="_moz" /></td>
      </tr>
     	<tr height="20">
	       <td class="detailtd"><font color="red">简要案情</font></td>
		</tr>
     	<tr height="20">
     	  <td  class="detailtd"><textarea name="textarea2" id="a_jyaq" style="width:760px;" value="" type="_moz" /></textarea></td>
   	  </tr>
          	<tr height="20">
	    <td class="detailtd">处理结果</td>
		</tr>
     	<tr height="20">
     	  <td  class="detailtd"><textarea name="textarea3" id="a_cljg" style="width:760px;" value="" type="_moz" /></textarea></td>
   	  </tr>
    </table>
    <table width="100%">
    <tr height="25" align="center" >
           <td width="100%">
<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='saveBkwpxx();'>保存</a>
</td>     
</tr>
    </table>
    </td>
  </tr>
</table>
<%@include file="../../public/includeImgerToBase64.jsp" %>