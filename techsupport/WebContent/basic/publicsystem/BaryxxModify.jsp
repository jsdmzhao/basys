<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4); 
	    $("#b_balxbm").selectBox({code:"dm_balx"});
		$("#b_sgrq").attr("readonly","true");
		$("#b_sgrq").datepicker();
		$("#q_baryid").attr("value",bary_rowselect);// 记录行号
		$("#b_oldbaryid").attr("value",bary_dataid);// 实际db中保安人员信息id
		bary_setDetail();
	}); 
	$("#b_gmsfhm").blur(function(){
	    var sfzh = $("#b_gmsfhm").val();
	    if(sfzh==''){
	        return true;
	    }
		var returnCardNo = checkIdCardNo("b_gmsfhm");
		if(!returnCardNo){
			jAlert("身份证号码不正确","验证信息");
		}
		getHjsxDD($(this).val(),"dm_xzqh","b_hjdxzqhdm","b_hjdxzqh");
	});
	$("#b_hjdxzqh").click(function(){
		getDict_item("b_hjdxzqh","b_hjdxzqhdm","dm_xzqh");
	});
	$("#b_balxbm").change(function(){
		$("#b_balx").val($("#b_balxbm").attr("title"));
	});
	function bary_updatediv (json) { 
		$("#b_xm").attr("value",setNull(json.LBaryxx[0].xm));
		$("#b_xbdm").attr("value",setNull(json.LBaryxx[0].xbdm));
		$("#b_xb").attr("value",setNull(json.LBaryxx[0].xb));
		$("#b_csrq").attr("value",setNull(json.LBaryxx[0].csrq));
		$("#b_gmsfhm").attr("value",setNull(json.LBaryxx[0].gmsfhm));
		$("#b_sfzhm_fd").attr("value",setNull(json.LBaryxx[0].gmsfhm));
		$("#b_hjdxzqhdm").attr("value",setNull(json.LBaryxx[0].hjdxzqhdm));
		$("#b_hjdxzqh").attr("value",setNull(json.LBaryxx[0].hjdxzqh));
		$("#b_hjdxz").attr("value",setNull(json.LBaryxx[0].hjdxz));
		$("#b_sgrq").attr("value",setNull(json.LBaryxx[0].sgrq));
		$("#b_balxbm").setValue(setNull(json.LBaryxx[0].balxbm));
		$("#b_balx").attr("value",setNull(json.LBaryxx[0].balx));
		$("#b_fzjg").attr("value",setNull(json.LBaryxx[0].fzjg));
		$("#b_bz").attr("value",setNull(json.LBaryxx[0].bz));
		$("#b_hylb").attr("value",setNull(json.LBaryxx[0].hylb));
		$("#b_qymc").attr("value",setNull(json.LBaryxx[0].qymc));
		$("#b_lrr").attr("value",setNull(json.LBaryxx[0].lrr));
		$("#b_lrsj").attr("value",setNull(json.LBaryxx[0].lrsj));
		$("#b_lzrq").attr("value",setNull(json.LBaryxx[0].lzrq));
		$("#b_lzyy").attr("value",setNull(json.LBaryxx[0].lzyy));
		if(compare_now_lrsj(json.LBaryxx[0].lrsj)){
			$("#b_gmsfhm").attr("disabled","true");
			$("#b_xm").attr("disabled","true");
		}
	}	
	function bary_modifyVerify(){
		if (!checkControlValue("b_xm","String",1,100,null,0,"姓名"))
			return false;
		if(!isChinese("b_xm","姓名"))
			return false;
		if (!checkControlValue("b_gmsfhm","String",1,20,null,1,"身份证号"))
			return false;
		if(!bary_valCyryZjhmFront($("#b_gmsfhm").val(),$("#b_sfzhm_fd").val()))
			return false;
		if (!checkControlValue("b_hjdxzqh","String",1,200,null,1,"户籍地省市县"))
			return false;
		if (!checkControlValue("b_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("b_sgrq","Date",null,null,null,1,"上岗日期"))
			return false;
		if (!checkControlValue("b_balx","String",1,10,null,1,"保安类型"))
			return false;
		if (!checkControlValue("b_fzjg","String",1,60,null,1,"发证机关"))
			return false;
		if (!checkControlValue("b_bz","String",1,2000,null,0,"备注"))
			return false;
		var returnCardNo = checkIdCardNo("b_gmsfhm");
		if(returnCardNo){
			$("#b_zt").val(0);
		}else{
			$("#b_zt").val(1);
		}
		return true;
	}

	//比较当前时间与创建时间相差3天
	function compare_now_lrsj(createTime){
		var today = new Date();
		today.setDate(today.getDate()-3);
		if(Date.parse(createTime.replace(/-/g, "/"))<Date.parse(today)){
			return true;
		}else{
			return false;
		}
	}
</script>
<input type="hidden" id="b_baryid">
<input type="hidden" id="b_oldbaryid">
<input type="hidden" id="q_baryid">
<input type="hidden" id="b_hjdxzqhdm">
<input type="hidden" id="b_balx">
<input type="hidden" id="b_zt">
<input type="hidden" id="b_hylb">
<input type="hidden" id="b_qymc">
<input type="hidden" id="b_lrr"/>
<input type="hidden" id="b_lrsj"/>
<input type="hidden" id="b_lzrq"/>
<input type="hidden" id="b_lzyy"/>
<input type="hidden" id="b_sfzhm_fd"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保安人员信息修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#baryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="red" width="12%">姓名</td>
		<td class="pagetd1" width="21%"><input type="text" id="b_xm" class="inputstyle" value=""></td>
		<td class="red" width="11%">身份证号</td>
		<td class="pagetd1" width="22%"><input type="text" id="b_gmsfhm" class="inputstyle" value=""></td>
		<td class="red" width="13%">户籍地省市县</td>
		<td class="pagetd1" width="21%"><input type="text" id="b_hjdxzqh" class="inputstyle" readonly></td>
	</tr>
	<tr height="20">
		<td class="red">户籍地详址</td>
		<td class="pagetd1" colspan="3"><input type="text" id="b_hjdxz" class="inputstyle3" style="width:98.7%" value=""></td>
		<td class="red">上岗日期</td>
		<td class="pagetd1"><input type="text" id="b_sgrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">保安类型</td>
		<td class="pagetd1"><select id="b_balxbm"><option></option></select></td>
		<td class="red">发证机构</td>
		<td class="pagetd1"><input type="text" id="b_fzjg" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">备注</td>
		<td class="pagetd1" colspan="5"><textarea name="textarea" id="b_bz" cols="83" rows="2" style="width:98.7%"></textarea></td>
	</tr>
<tr height="25" align="center">
<td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='bary_modify();'>保存</a></td></tr>
</table>
