<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4); 
	    updatedivModify_bwryxx($("#bwryxxIngridTable").find("tbody").find("tr:nth("+$("#caozuo_trIndex").val()+")"));
		$("#bwry_sgrq").attr("readonly","true").datepicker();
	}); 
	function updatedivModify_bwryxx(json) { 
		$("#bwry_xm").attr("value",setNull(json.find("td:nth(0)").html()));
		$("#bwry_gmsfhm").attr("value",setNull(json.find("td:nth(1)").html()));
		$("#bwry_sfzhm_fd").attr("value",setNull(json.find("td:nth(1)").html()));
		$("#bwry_hjdxzqh").attr("value",setNull(json.find("td:nth(2)").html()));
		$("#bwry_hjdxzqhdm").attr("value",setNull(json.find("td:nth(5)").html()));
		$("#bwry_hjdxz").attr("value",setNull(json.find("td:nth(3)").html()));
		$("#bwry_sgrq").attr("value",setNull(json.find("td:nth(4)").html()));
		$("#bwry_lrr").attr("value",setNull(json.find("td:nth(6)").html()));
		$("#bwry_lrsj").attr("value",setNull(json.find("td:nth(7)").html()));
		var bwryBz = setNull(json.find("td:nth(8)").html());
		bwryBz = bwryBz.replace(/(&nbsp;)/g,'');
		$("#bwry_bz").attr("value",bwryBz);
		if(compare_now_lrsj(json.find("td:nth(7)").html())){
			$("#bwry_gmsfhm").attr("disabled","true");
			$("#bwry_xm").attr("disabled","true");
		}
	}	
	
	function modifyVerify_bwryxx(){
		if (!checkControlValue("bwry_xm","String",1,100,null,1,"姓 名"))
			return false;
		if (!checkControlValue("bwry_gmsfhm","String",1,20,null,1,"身份证号"))
			return false;
		if(!bwry_valCyryZjhmFront($("#bwry_gmsfhm").val(),$("#bwry_sfzhm_fd").val()))
			return false;
		if (!checkControlValue("bwry_hjdxzqh","String",1,200,null,1,"户籍地省市县"))
			return false;
		if (!checkControlValue("bwry_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("bwry_sgrq","Date",null,null,null,1,"上岗日期"))
			return false;
		if (!checkControlValue("bwry_lrr","String",1,100,null,0,"填报人"))
			return false;
		return true;
	}

	$("#bwry_hjdxzqh").click(function(){
		getDict_item("bwry_hjdxzqh","bwry_hjdxzqhdm","dm_xzqh");
	});
	
	$("#bwry_gmsfhm").blur(function(){
		if(!checkIdCardNo("bwry_gmsfhm"))
			jAlert("身份证号不正确！","验证信息");

		getHjsxDD($(this).val(),"dm_xzqh","bwry_hjdxzqhdm","bwry_hjdxzqh");
	});

	function setUpdate_bwryxx(){
		if(modifyVerify_bwryxx()){
			var caoZuoTr = $("#bwryxxIngridTable").find("tbody").find("tr:nth("+$("#caozuo_trIndex").val()+")");
			caoZuoTr.find("td:nth(0)").html($("#bwry_xm").val());
			caoZuoTr.find("td:nth(1)").html($("#bwry_gmsfhm").val());
			caoZuoTr.find("td:nth(2)").html($("#bwry_hjdxzqh").val());
			caoZuoTr.find("td:nth(5)").html($("#bwry_hjdxzqhdm").val());
			caoZuoTr.find("td:nth(3)").html($("#bwry_hjdxz").val());
			caoZuoTr.find("td:nth(4)").html($("#bwry_sgrq").val());
			caoZuoTr.find("td:nth(6)").html($("#bwry_lrr").val());
			caoZuoTr.find("td:nth(7)").html($("#bwry_lrsj").val());
			caoZuoTr.find("td:nth(8)").html($("#bwry_bz").val());
			$("#bwryxx_detail").hideAndRemove("show");
		}
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
<input type="hidden" id="bwry_sfzhm_fd"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保卫人员信息修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#bwryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="red" width="12%">姓名</td>
		<td class="pagetd1" width="21%"><input type="text" id="bwry_xm" class="inputstyle" /></td>
		<td class="red" width="11%">身份证号</td>
		<td class="pagetd1" width="22%"><input type="text" id="bwry_gmsfhm" class="inputstyle" /></td>
		<td class="red" width="13%">户籍地省市县</td>
		<td class="pagetd1" width="21%">
		<input type="text" id="bwry_hjdxzqh" class="inputstyle" readonly />
		<input type="hidden" id="bwry_hjdxzqhdm" />
		</td>
	</tr>
	<tr height="20">
		<td class="red">户籍地详址</td>
		<td class="pagetd1" colspan="3"><input type="text" id="bwry_hjdxz" class="inputstyle3" style="width:98.7%" /></td>
		<td class="red">上岗日期</td>
		<td class="pagetd1"><input type="text" id="bwry_sgrq" class="inputstyle" /></td>
	</tr>
	<tr height="20" style="display:none">
		<td class="pagedistd1">填报人</td>
		<td class="pagetd1"><input type="text" id="bwry_lrr" class="readonly" /></td>
		<td class="pagedistd1">填报时间</td>
		<td class="pagetd1" colspan="3"><input type="text" id="bwry_lrsj" class="readonly" /></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">备注</td>
		<td class="pagetd1" colspan="5"><textarea id="bwry_bz" style="width:98.7%"></textarea></td>
	</tr>
<tr height="25" align="center">
<td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate_bwryxx();'>保存</a></td></tr>
</table>
