<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(8); //将保存按钮右移
		$("#q_bkwpjbxxid").attr("value",dataid);
		$("#m_bkwpjbxxid").attr("value",dataid);
		setDetail();
		$("#m_ccdjrq").attr("readonly","true");
		$("#m_ccdjrq").datepicker();
		$("#m_tbsj2").attr("readonly","true");
		$("#m_tbsj2").datepicker(true);
		//$("#m_bkczsj").attr("readonly","true");
		//$("#m_bkczsj").datepicker();
		$("#m_bkdqsj").attr("readonly","true");
		$("#m_bkdqsj").datepicker(true);
		$("#m_bkwplxdm").selectBox({code:"dm_ddwpzl",query:"0"});
		$("#m_clppdm").selectBox({code:"dm_clpp"});
		$("#m_cllxdm").selectBox({code:"dm_cllx"});
		$("#m_ppdm").selectBox({code:"dm_sjpp"});
		$("#m_bkfwbm").selectBox({code:"dm_bkfw"});
		$("#m_ajlbbm").selectBox({code:"dm_ajlx"});
		// 行业类别	
        $("#m_hylbdm").selectBoxhylb();
		$("#pmtPho").attr("src","<%=request.getContextPath()%>/basicsystem/queryZp_bkwpkbxx.action?bkwpjbxxid="+dataid);
	});
	function updatediv (json) { 
		$("#m_bkwpjbxxid").attr("value",setNull(json.LBkwpkbxx[0].bkwpjbxxid));
		$("#m_bkwpmc").attr("value",setNull(json.LBkwpkbxx[0].bkwpmc));
		$("#m_bkwplxdm").setValue(setNull(json.LBkwpkbxx[0].bkwplxdm));
		$("#m_bkwpms").attr("value",setNull(json.LBkwpkbxx[0].bkwpms));
		if($("#m_bkwplxdm").val() == "2"){
		    $("#m_cllxdm").setValue(setNull(json.LBkwpkbxx[0].bkcl.cllxdm));
	        $("#m_clppdm").setText(setNull(json.LBkwpkbxx[0].bkcl.clpp));
		    $("#m_clxh").attr("value",setNull(json.LBkwpkbxx[0].bkcl.clxh));
		    $("#m_hphm").attr("value",setNull(json.LBkwpkbxx[0].bkcl.hphm));
		    $("#m_syr").attr("value",setNull(json.LBkwpkbxx[0].bkcl.syr));
		    $("#m_fdjh").attr("value",setNull(json.LBkwpkbxx[0].bkcl.fdjh));
		    $("#m_cjh").attr("value",setNull(json.LBkwpkbxx[0].bkcl.cjh));
		    $("#m_csys").attr("value",setNull(json.LBkwpkbxx[0].bkcl.csys));
		    $("#m_ccdjrq").attr("value",setNull(json.LBkwpkbxx[0].bkcl.ccdjrq));
		    $("#clDetail").show();
	        $("#sjDetail").hide();
		} else if($("#m_bkwplxdm").val() == "1"){
	        $("#m_ppdm").setText(setNull(json.LBkwpkbxx[0].bksj.pp));
		    $("#m_xh").attr("value",setNull(json.LBkwpkbxx[0].bksj.xh));
		    $("#m_sjch").attr("value",setNull(json.LBkwpkbxx[0].bksj.sjch));
		    $("#m_ys").attr("value",setNull(json.LBkwpkbxx[0].bksj.ys));
		    $("#clDetail").hide();
	        $("#sjDetail").show();
		} else{
		    $("#clDetail").hide();
	        $("#sjDetail").hide();
		}
		$("#m_tbbh").attr("value",setNull(json.LBkwpkbxx[0].tbbh));
		$("#m_ajlbbm").setValue(setNull(json.LBkwpkbxx[0].ajlbbm));
		$("#m_fwdw").attr("value",setNull(json.LBkwpkbxx[0].fwdw));
		$("#m_tbsj2").attr("value",setNull(json.LBkwpkbxx[0].tbsj2));
		$("#m_jyaq").attr("value",setNull(json.LBkwpkbxx[0].jyaq));
		$("#m_cljg").attr("value",setNull(json.LBkwpkbxx[0].cljg));
		$("#m_bkr").attr("value",setNull(json.LBkwpkbxx[0].bkr));
		$("#m_bkczy").attr("value",setNull(json.LBkwpkbxx[0].bkczy));
		$("#m_bkfwbm").setValue(setNull(json.LBkwpkbxx[0].bkfwbm));
		$("#m_bkczsj").attr("value",setNull(json.LBkwpkbxx[0].bkczsj));
		$("#m_lxr").attr("value",setNull(json.LBkwpkbxx[0].lxr));
		$("#m_lxfs").attr("value",setNull(json.LBkwpkbxx[0].lxfs));
		$("#m_bkdqsj").attr("value",setNull(json.LBkwpkbxx[0].bkdqsj));
		$("#m_hylbdm").setValue(setNull(json.LBkwpkbxx[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LBkwpkbxx[0].hylb));
		
	}	
	function modifyVerify(){
	    $("#m_bkwplx").val($("#m_bkwplxdm").attr("title"));
	    $("#m_bkfw").val($("#m_bkfwbm").attr("title"));
	    $("#m_ajlb").val($("#m_ajlbbm").attr("title"));
	    
		if (!checkControlValue("m_bkwplxdm","Select",1,20,null,1,"物品类型"))
			return false;
		if (!checkControlValue("m_bkwpmc","String",1,30,null,1,"物品名称"))
			return false;
		if (!checkControlValue("m_bkr","String",1,100,null,1,"布控人"))
			return false;
		if (!checkControlValue("m_bkczy","String",1,100,null,1,"布控操作员"))
			return false;
		if (!checkControlValue("m_bkfwbm","Select",1,300,null,1,"布控范围"))
			return false;
		if (!checkControlValue("m_hylbdm","Select",1,3,null,1,"行业类别"))
			return false;
		//if (!checkControlValue("m_bkczsj","Date",null,null,null,0,"布控操作时间"))
			//return false;
		if (!checkControlValue("m_lxr","String",1,100,null,1,"联系人"))
			return false;
		if (!checkControlValue("m_lxfs","String",1,300,null,1,"联系方式"))
			return false;
		if (!checkControlValue("m_bkdqsj","Datetime",null,null,null,0,"布控终止时间"))
			return false;
		if (!checkControlValue("m_tbbh","String",1,30,null,0,"通报编号"))
			return false;
		if (!checkControlValue("m_ajlbbm","Select",1,60,null,1,"案件类别"))
			return false;
		if (!checkControlValue("m_fwdw","String",1,100,null,1,"发文单位"))
			return false;
		if (!checkControlValue("m_tbsj2","Datetime",null,null,null,1,"通报时间"))
			return false;
		if (!checkControlValue("m_bkwpms","String",1,2000,null,0,"物品描述"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,1,"简要案情"))
			return false;
		if (!checkControlValue("m_cljg","String",1,2000,null,0,"处理结果"))
			return false;
		if($("#m_bkwplxdm").val()== "2"){
		    $("#m_cllx").val($("#m_cllxdm").attr("title"));
		    $("#m_clpp").val($("#m_clppdm").attr("title"));
		    if (!checkControlValue("m_clppdm","Select",1,64,null,1,"车辆品牌"))
			    return false;
		    if (!checkControlValue("m_clxh","String",1,64,null,1,"车辆型号"))
			    return false;
			if (!checkControlValue("m_hphm","String",1,32,null,1,"车辆号牌"))
			    return false;
		    if (!checkControlValue("m_syr","String",1,512,null,1,"机动车所有人"))
			    return false;
			if (!checkControlValue("m_cllxdm","Select",1,32,null,1,"车辆类型"))
			    return false;
			if (!checkControlValue("m_fdjh","String",1,60,null,1,"发动机号"))
			    return false;
		    if (!checkControlValue("m_cjh","String",1,50,null,1,"车架号"))
			    return false;
			if (!checkControlValue("m_ccdjrq","Date",null,null,null,0,"初次登记日期"))
			    return false;
		    if (!checkControlValue("m_csys","String",1,32,null,1,"车辆颜色"))
			    return false;
		}
		if($("#m_bkwplxdm").val()== "1"){
		    $("#m_pp").val($("#m_ppdm").attr("title"));
		    if (!checkControlValue("m_ppdm","Select",1,100,null,0,"手机品牌"))
			    return false;
		    if (!checkControlValue("m_xh","String",1,100,null,0,"手机型号"))
			    return false;
		    if (!checkControlValue("m_sjch","String",1,30,null,1,"手机串号"))
			    return false;
		    if (!checkControlValue("m_ys","String",1,60,null,0,"手机颜色"))
			    return false;
		}
		if($("#m_bkdqsj").val()!=null && $("#m_bkdqsj").val()!=""){
		    if($("#m_bkdqsj").val()<$("#m_bkczsj").val()){
		        jAlert("布控终止时间不能小于布控操作时间！",'提示信息');
		        return false;
		    }
		}
		$("#m_hylb").val($("#m_hylbdm").attr("title"));
		return true;
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
		
		$("#m_fileload").attr("value",base64code);
	}
</script>
<input type="hidden" id="m_pp">
<input type="hidden" id="m_clpp">
<input type="hidden" id="m_cllx">
<input type="hidden" id="m_bkwplx">
<input type="hidden" id="m_bkfw">
<input type="hidden" id="m_ajlb">
<input type="hidden" id="q_bkwpjbxxid">
<input type="hidden" id="m_bkwpjbxxid">
<input type="hidden" id="m_hylb">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">布控物品修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#bkwpkbxx_detail").hideAndRemove(&quot;show&quot;);' class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="1"></td>
  </tr>
</table>
<table width="98%" id="modify">
  <tr>
    <td valign="top">
    <table width="100%">
      <tr>
         <td width="74%" valign="top"><table width="100%" >
           <tr>
            <td width="15%" class="red">物品类型</td>
        <td width="31%" class="detailtd"><select  id="m_bkwplxdm" type="select" value="" onchange="setWPLXForDetail('m');">
          <option></option>
        </select></td>
        <td width="17%" class="red">物品名称</td>
        <td width="37%" class="detailtd">
          <input type="text" class="inputstyle"  id="m_bkwpmc" value="" /></td>
           </tr>
         </table>
         <table width="100%">
     	<tr height="20">
	    <td width="15%" class="red">布控人</td>
          <td width="31%" class="detailtd"><input type="text" class="inputstyle" id="m_bkr" value="" /></td>
          <td width="17%" class="red">布控操作员</td>
          <td width="37%" class="detailtd"><input type="text" readonly="readonly" class="readonly" id="m_bkczy" value="" /></td>
           </tr>
           <tr height="20">
          <td width="15%" class="red">布控范围</td>
<td width="31%" class="detailtd"><select id="m_bkfwbm" type="select" value="">
                  <option></option>
                </select>
          </td>
          <td width="17%" class="distd">布控操作时间</td>
          <td width="37%" class="detailtd"><input type="text" readonly="readonly" class="readonly" id="m_bkczsj" value="" /></td>
              </tr>
              <tr height="20">
                <td class="red">联系人</td>
                <td class="detailtd"><input type="text" class="inputstyle" id="m_lxr" value="" /></td>
                <td class="red">联系方式</td>
                <td class="detailtd"><input type="text" class="inputstyle" id="m_lxfs" value="" /></td>
          </tr>
              <tr height="20">
                <td class="distd">布控终止时间</td>
                <td class="detailtd"><input class="inputstyle" type="text" id="m_bkdqsj" value="" /></td>
                <td class="red">行业类别</td>
                <td class="detailtd"><select id="m_hylbdm" ></select></td>
	</tr>
    </table>
           <table width="100%">
             <tr height="20">
               <td width="15%" class="distd">通报编号</td>
               <td width="31%" class="detailtd"><input type="text" class="inputstyle"  id="m_tbbh" value="" /></td>
               <td width="17%" class="red">案件类别</td>
               <td width="37%" class="detailtd"><select name="m_ajlbbm" id="m_ajlbbm" type="select" value="">
                   <option></option>
                 </select>
               </td>
             </tr>
             <tr height="20">
               <td class="red">发文单位</td>
               <td class="detailtd"><input type="text" class="inputstyle"  id="m_fwdw" value="" /></td>
               <td class="red">通报时间</td>
               <td class="detailtd"><input type="text" class="inputstyle" id="m_tbsj2" value="" /></td>
             </tr>
           </table></td>
        <td width="26%" colspan="2" rowspan="3" valign="top">
            <table width="35%" border="0" align="center" cellpadding="5" cellspacing="0">
          <input type="hidden" id="m_fileload" />
          <tr>
            <td valign="top">
				<img id ="pmtPho" width="100px" height="120px" src="images/pic.gif"/>
				<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="选图片" onclick='openfile();'>选图片</a>			</td>
          </tr>
        </table></td>
        </tr>
    </table>
    <table width="100%" id="clDetail">
  <tr height="20">
    <td width="12%" class="distd"><font color="blue">车辆品牌</font></td>
    <td width="23%" class="detailtd"><select name="m_clppdm" id="m_clppdm" type="select" value="">
      <option></option>
    </select>
    </td>
    <td width="14%" class="distd"><font color="blue">车辆型号</font></td>
    <td width="23%" class="detailtd"><input type="text" class="inputstyle"   id="m_clxh" value="" /></td>
    <td width="11%" class="distd"><font color="blue">车辆号牌</font></td>
    <td width="17%" class="detailtd"><input type="text"  class="inputstyle"  id="m_hphm" value="" /></td>
  </tr>
  <tr height="20">
    <td class="distd"><font color="blue">机动车所有人</font></td>
    <td class="detailtd"><input type="text" class="inputstyle"  id="m_syr" value="" /></td>
    <td class="distd"><font color="blue">车辆类型</font></td>
    <td class="detailtd"><select name="m_cllxdm" id="m_cllxdm" type="select" value="">
      <option></option>
    </select></td>
    <td class="distd"><font color="blue">发动机号</font></td>
    <td class="detailtd"><input type="text" class="inputstyle"  id="m_fdjh" value="" /></td>
  </tr>
  <tr height="20">
    <td class="distd"><font color="blue">车架号</font></td>
    <td class="detailtd"><input type="text" class="inputstyle"  id="m_cjh" value="" /></td>
    <td class="distd"><font color="blue">初次登记日期</font></td>
    <td class="detailtd"><input type="text" class="inputstyle"  id="m_ccdjrq" value="" /></td>
    <td class="distd"><font color="blue">车辆颜色</font></td>
    <td class="detailtd" colspan="3"><input type="text" class="inputstyle"  id="m_csys" value="" /></td>
  </tr>
</table>
<table width="100%" id="sjDetail">
  <tr height="20">
    <td width="12%" class="distd"><font color="green">手机品牌</font></td>
    <td width="23%" class="detailtd"><select name="m_ppdm" id="m_ppdm" type="select" value="">
      <option></option>
    </select></td>
    <td width="14%" class="distd"><font color="green">手机型号</font></td>
    <td width="23%" class="detailtd"><input type="text" class="inputstyle"  id="m_xh" value="" /></td>
    <td width="11%" class="distd"><font color="green">手机串号</font></td>
    <td width="17%" class="detailtd"><input type="text" class="inputstyle"  id="m_sjch" value="" /></td>
  </tr>
  <tr height="20">
    <td class="distd"><font color="green">手机颜色</font></td>
    <td class="detailtd" colspan="5"><input type="text" class="inputstyle"  id="m_ys" value="" /></td>
  </tr>
</table>
    <table width="100%">
     <tr>
        <td colspan="4" class="detailtd">物品描述</td>
      </tr>
      <tr>
        <td colspan="4" valign="top"  class="detailtd">
          <textarea name="textarea" id="m_bkwpms" style="width:760px;" value="" type="_moz" /></textarea></td>
        </tr>
     	<tr height="20">
	    <td class="detailtd"><font color="red">简要案情</font></td>
		</tr>
     	<tr height="20">
     	  <td  class="detailtd"><textarea name="textarea2" id="m_jyaq" style="width:760px;" value="" type="_moz" /></textarea></td>
   	  </tr>
          	<tr height="20">
	    <td class="detailtd">处理结果</td>
		</tr>
     	<tr height="20">
     	  <td  class="detailtd"><textarea name="textarea3" id="m_cljg" style="width:760px;" value="" type="_moz" /></textarea></td>
   	  </tr>
    </table>
    
    </td>
  </tr>
</table>
<table width="98%">
<tr height="25" align="center">
    <td width="50%" colspan="4" align="right">
      <a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a>
    </td>
</tr>
</table>
<%@include file="../../public/includeImgerToBase64.jsp" %>