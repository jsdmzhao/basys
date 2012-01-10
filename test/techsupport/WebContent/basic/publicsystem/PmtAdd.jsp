<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function(){
	    bc_bottonMoveRight(5); 
		$("#bq_pmtlx").selectBox({code:"dm_pmtlx"});
		pmtlxOnchange();
	}); 
	
	function openfile(){
		ImgerToBase1.OpenFile();
		ImgerToBase();
	}
	function ImgerToBase(){   
		//设置打开图片的大小
		ImgerToBase1.SetFileSize= 2000;
		//文件名称 eg: snow.jpeg
		//var fileName = ImgerToBase1.getFileName();
		//文件路径 包括文件名称
		var filePath = ImgerToBase1.getFile();
		//BASE64编码
		var base64code = ImgerToBase1.getBase64();
		var fileName = ImgerToBase1.getFileName();
		if(fileName==null||fileName==''||fileName=='null'){
			$("#pmtPho").attr("src","images/pic.gif");
		} else {
			$("#pmtPho").attr("src",filePath);
		}
		
		$("#a_pmtStringContent").attr("value",base64code);
	}
	
	function pmt_setAddTemp(){
		if(pmt_addVerify()){
			pmt_setAdd();
		}
	}
	
	function pmtlxOnchange(){ //平面图类型
		var pmtlxkey = $("#bq_pmtlx").attr("value");
		var pmtlxval = $("#bq_pmtlx").attr("title");
		$("#a_pmtlxdm").attr("value",pmtlxkey);
		$("#a_pmtlxmc").attr("value",pmtlxval);
	}
	function pmt_addVerify(){
		if (!checkControlValue("bq_pmtlx","Select",1,30,null,1,"平面图类型"))
			return false;
		var fileName = ImgerToBase1.getFileName();
		var pmtphosrc = $("#pmtPho").attr("src");
		if(fileName==null||fileName==''||fileName=='null'||(pmtphosrc.indexOf('images/pic.gif')!=-1)){
			jAlert('请选择图片','提示信息');
			return false;
		}
		return true;
	}
</script>
<input type="hidden" id="a_pmtStringContent" value="">
<input type="hidden" id="a_pmtlxmc" value=""/>
<input type="hidden" id="a_pmtlxdm" value=""/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">平面图信息添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#pmt_detail").hide("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr height="20">
	    <td class="red" width="25%">平面图类型</td>
		<td class="detailtd" width="50%"><select name="select" id="bq_pmtlx" onchange="pmtlxOnchange();">
		<option></option></select></td>
	    <td width="25%"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="选图片" onclick='openfile();'>选图片</a></td>
	</tr>
	<tr align="center">
	   <td colspan="3">
			<img id ="pmtPho" width="300px" height="250px" src="images/pic.gif"/>
       </td>
	</tr>
	<tr height="25" align="center">
	<td class="distd"><input type="checkbox" name="checkbox" id="pmt_checkbox"/>继续</td>
	<td></td>
	<td></td>
	</tr>
	<tr height="25" align="center">
	<td colspan="3"><a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='pmt_setAddTemp();'>保存</a></td>
	</tr>
</table>
<%@include file="../../public/includeImgerToBase64.jsp" %>
