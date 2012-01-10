<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(4); 
		$("#q_baryid").attr("value",bary_rowselect);// 记录行号
		$("#b_oldbaryid").attr("value",bary_dataid);// 实际db中保安人员信息id
		bary_setDetail();
		$("#b_zt").selectBox({code:"dm_ryzt"});
		$("#b_lzrq").datepicker();
		$("#b_lzrq").attr("disabled",true);
		$("#b_lzyy").attr("disabled",true);
	}); 
	function bary_updatediv (json) { 
		$("#b_xm").attr("value",setNull(json.LBaryxx[0].xm));
		$("#b_gmsfhm").attr("value",setNull(json.LBaryxx[0].gmsfhm));
		$("#b_hjdxzqhdm").attr("value",setNull(json.LBaryxx[0].hjdxzqhdm));
		$("#b_hjdxzqh").attr("value",setNull(json.LBaryxx[0].hjdxzqh));
		$("#b_hjdxz").attr("value",setNull(json.LBaryxx[0].hjdxz));
		$("#b_sgrq").attr("value",setNull(json.LBaryxx[0].sgrq));
		$("#b_zt").attr("value",setNull(json.LBaryxx[0].zt));
		$("#b_lzrq").attr("value",setNull(json.LBaryxx[0].lzrq));
		$("#b_balx").attr("value",setNull(json.LBaryxx[0].balx));
		$("#b_balxbm").attr("value",setNull(json.LBaryxx[0].balxbm));
		$("#b_fzjg").attr("value",setNull(json.LBaryxx[0].fzjg));
		$("#b_lrr").attr("value",setNull(json.LBaryxx[0].lrr));
		$("#b_lrsj").attr("value",setNull(json.LBaryxx[0].lrsj));
		$("#b_lzyy").attr("value",setNull(json.LBaryxx[0].lzyy));
		$("#b_hylb").attr("value",setNull(json.LBaryxx[0].hylb));
		$("#b_qymc").attr("value",setNull(json.LBaryxx[0].qymc));
		$("#b_bz").attr("value",setNull(json.LBaryxx[0].bz));
	}	
	function bary_modifyVerify(){
		if (!checkControlValue("b_lzrq","String",1,60,null,1,"离职时间"))
			return false;
		if (!checkControlValue("b_lzyy","String",1,200,null,0,"离职原因"))
			return false;
		return true;
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
<input type="hidden" id="b_oldbaryid">
<input type="hidden" id="b_baryid">
<input type="hidden" id="q_baryid">
<input type="hidden" id="b_balxbm">
<input type="hidden" id="b_hjdxzqhdm">
<input type="hidden" id="b_bz">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保安人员离职</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#baryxx_detail").hideAndRemove("show");' class="close"></a></td>
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
		<td class="pagetd1" width="21%"><input type="text" id="b_xm"   class="readonly"/></td>
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
		<td class="pagedistd1">保安类型</td>
		<td class="pagetd1"><input type="text" id="b_balx"  class="readonly"/></td>
		<td class="pagedistd1">发证机构</td>
		<td class="pagetd1"><input type="text" id="b_fzjg"  class="readonly"/></td>
		<td class="pagedistd1">填报人</td>
		<td class="pagetd1"><input type="text" id="b_lrr"  class="readonly"/></td>
	</tr>
	<tr height="20">
		
		<td class="pagedistd1">填报时间</td>
		<td class="pagetd1"><input type="text" id="b_lrsj"  class="readonly"/></td>
		<td class="pagedistd1">人员状态</td>
		<td class="pagetd1"><select id="b_zt" class="inputstyle" /></select></td>
		<td class="red">离职时间</td>
		<td class="pagetd1"><input type="text" id="b_lzrq" class="inputstyle" readonly/></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">离职原因</td>
		<td class="pagetd1" colspan="5"><textarea name="textarea" id="b_lzyy" cols="83" rows="2" style="width:98.7%"></textarea></td>
	</tr>
<tr height="25" align="center">
<td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='bary_modifyLizhi();'>保存</a></td></tr>
</table>

