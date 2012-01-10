<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4); 
	    updatedivModify_bwryxx($("#bwryxxIngridTable").find("tbody").find("tr:nth("+$("#caozuo_trIndex").val()+")"));
		$("#b_zt").selectBox({code:"dm_ryzt"});
		$("#b_lzrq").datepicker();
		$("#b_lzrq").attr("disabled",true);
		$("#b_lzyy").attr("disabled",true);
	}); 
	function updatedivModify_bwryxx(json) { 
		$("#b_xm").attr("value",setNull(json.find("td:nth(0)").html()));
		$("#b_gmsfhm").attr("value",setNull(json.find("td:nth(1)").html()));
		$("#b_hjdxzqh").attr("value",setNull(json.find("td:nth(2)").html()));
		$("#b_hjdxzqhdm").attr("value",setNull(json.find("td:nth(5)").html()));
		$("#b_hjdxz").attr("value",setNull(json.find("td:nth(3)").html()));
		$("#b_sgrq").attr("value",setNull(json.find("td:nth(4)").html()));
		$("#b_lrr").attr("value",setNull(json.find("td:nth(6)").html()));
		$("#b_lrsj").attr("value",setNull(json.find("td:nth(7)").html()));
		$("#b_hylb").attr("value",setNull(json.find("td:nth(9)").html()));
		$("#b_qymc").attr("value",setNull(json.find("td:nth(10)").html()));
		$("#b_zt").attr("value",setNull(json.find("td:nth(11)").html()));
		$("#b_lzrq").attr("value",setNull(json.find("td:nth(12)").html().replace(/(&nbsp;)/g,'')));
		$("#b_lzyy").attr("value",setNull(json.find("td:nth(13)").html().replace(/(&nbsp;)/g,'')));
		var bwryBz = setNull(json.find("td:nth(8)").html());
		bwryBz = bwryBz.replace(/(&nbsp;)/g,'');
		$("#bwry_bz").attr("value",bwryBz);
	}
	function bwry_modifyVerify(){
		if (!checkControlValue("b_lzrq","String",1,60,null,1,"离职时间"))
			return false;
		if (!checkControlValue("b_lzyy","String",1,200,null,0,"离职原因"))
			return false;
		return true;
	}
	
		function setUpdate_bwryxx(){
			if($("#b_zt").val()==2){
				if(bwry_modifyVerify()){
					var caoZuoTr = $("#bwryxxIngridTable").find("tbody").find("tr:nth("+$("#caozuo_trIndex").val()+")");
					caoZuoTr.find("td:nth(0)").html($("#b_xm").val());
					caoZuoTr.find("td:nth(1)").html($("#b_gmsfhm").val());
					caoZuoTr.find("td:nth(2)").html($("#b_hjdxzqh").val());
					caoZuoTr.find("td:nth(5)").html($("#b_hjdxzqhdm").val());
					caoZuoTr.find("td:nth(3)").html($("#b_hjdxz").val());
					caoZuoTr.find("td:nth(4)").html($("#b_sgrq").val());
					caoZuoTr.find("td:nth(6)").html($("#b_lrr").val());
					caoZuoTr.find("td:nth(7)").html($("#b_lrsj").val());
					caoZuoTr.find("td:nth(11)").html($("#b_zt").val());
					caoZuoTr.find("td:nth(12)").html($("#b_lzrq").val());
					caoZuoTr.find("td:nth(13)").html($("#b_lzyy").val());
					if($("#b_lzrq").val()&&$("#b_zt").val()==2){
						caoZuoTr.find("td:nth(14)").html("");
					}
					$("#bwryxx_detail").hideAndRemove("show");
				}
			}else{
				$("#bwryxx_detail").hideAndRemove("show");
			}
			
	}
	
	$("#b_zt").change(function(){
		if($("#b_zt").val()==2){
				$("#b_lzrq").attr("disabled",false);
				$("#b_lzrq").datepicker();
				$("#b_lzyy").attr("disabled",false);
			}else{
				$("#b_lzrq").val("");
				$("#b_lzrq").attr("disabled",true);
				$("#b_lzyy").val("");
				$("#b_lzyy").attr("disabled",true);
			}
	});

</script>
<input type="hidden" id="b_bwryid">
<input type="hidden" id="b_bwlx">
<input type="hidden" id="b_bwlxbm">
<input type="hidden" id="b_fzjg">
<input type="hidden" id="b_hjdxzqhdm">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保卫人员离职</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#bwryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td width="12%" class="pagedistd1">行业类别</td>
		<td class="pagetd1" width="21%"><input type="text" id="b_hylb"   class="readonly"/></td>
		<td class="pagedistd1">企业名称</td>
		<td class="pagetd1" colspan="3"><input type="text" id="b_qymc"  class="readonly" style="width:98.7%" /></td>
	</tr>
	<tr height="20">
		<td  width="12%" class="pagedistd1">姓名</td>
		<td class="pagetd1" width="21%"><input type="text" id="b_xm"  class="readonly" /></td>
		<td  width="11%" class="pagedistd1">身份证号</td>
		<td class="pagetd1" width="22%"><input type="text" id="b_gmsfhm"  class="readonly"></td>
		<td width="13%" class="pagedistd1">户籍地省市县</td>
		<td class="pagetd1" width="21%"><input type="text" id="b_hjdxzqh"  class="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">户籍地详址</td>
		<td class="pagetd1" colspan="3"><input type="text" id="b_hjdxz" class="readonly" style="width:98.7%" /></td>
		<td class="pagedistd1">上岗日期</td>
		<td class="pagetd1"><input type="text" id="b_sgrq"  class="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">填报人</td>
		<td class="pagetd1"><input type="text" id="b_lrr"  class="readonly"/></td>
		<td class="pagedistd1">填报时间</td>
		<td class="pagetd1"><input type="text" id="b_lrsj"  class="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">人员状态</td>
		<td class="pagetd1"><select id="b_zt" class="inputstyle"></select></td>
		<td class="red">离职时间</td>
		<td class="pagetd1"><input type="text" id="b_lzrq" class="inputstyle" readonly/></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">离职原因</td>
		<td class="pagetd1" colspan="5"><textarea name="textarea" id="b_lzyy" cols="83" rows="2" style="width:98.7%"></textarea></td>
	</tr>
<tr height="25" align="center">
<td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate_bwryxx();'>保存</a></td></tr>
</table>

