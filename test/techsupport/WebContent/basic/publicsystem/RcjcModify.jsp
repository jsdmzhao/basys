<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	//获取内外网值nwwbz
	String nwwbz=(String)session.getAttribute("nwwbz");
	//是否控制日常检查方式
	String sfkzrcjcfs = QjblUtil.queryQjblVal("sfkzrcjcfs");
%>
<script type="text/javascript">
	var sfkzrcjcfs = "<%=sfkzrcjcfs%>";
	var nwwbz_jcfs = "<%=nwwbz%>";
	$(document).ready(function() {
	
	 bc_bottonMoveRight(3); 
	
		$("#q_rcjcid").attr("value",dataid);
		$("#m_rcjcid").attr("value",dataid);	
		//$("#m_jcfs").selectBox({code:"dm_jcfs"});
		if(chuli){ 
			$("#m_jcfs").selectBox({code:"dm_jcfs"});
		}else{
			if(nwwbz_jcfs=='1'){
				if(sfkzrcjcfs=='0'){
					$("#m_jcfs").selectBox({code:"dm_jcfs"});
				}else{
					$("#m_jcfs").selectBox({code:"dm_jcfs_qydadd"});
				}
			}else{
				if(sfkzrcjcfs=='0'){
					$("#m_jcfs").selectBox({code:"dm_jcfs"});
				}else{
					$("#m_jcfs").selectBox({code:"dm_jcfs_gadadd"});
				}
			}
		}
		
		getRidio();
		//判断是 处理链接 还是 修改连接
		if(chuli){ 
			$("#modify").find(":text,textarea").attr("readonly",true).removeClass("inputstyle").addClass("readonly");
			$("#m_cljg").attr("readonly",false).removeClass("readonly");
			$("#m_jcfs").setAttr("readonly",true);	
		}else{
			$("#m_jcrzw").click(function(){
    			getrylbTree("m_jcrzw","m_zwdm","dm_zw(rcjc)");
    		}); 
			$("#m_cljg").attr("readonly",true).removeClass("inputstyle").addClass("readonly");
		}
		
		setDetail();
	}); 
	function updatediv (json) { 
		var cljg = setNull(json.LRcjc[0].cljg);
		$("#m_qybm").attr("value",setNull(json.LRcjc[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LRcjc[0].qymc));
		$("#m_rcjcid").attr("value",setNull(json.LRcjc[0].rcjcid));
		$("#m_csfzr").attr("value",setNull(json.LRcjc[0].csfzr));
		$("#m_csfzrbh").attr("value",setNull(json.LRcjc[0].csfzrbh));
		$("#m_jcfs").setValue(setNull(json.LRcjc[0].jcfs));
		$("#m_rcjcbh").attr("value",setNull(json.LRcjc[0].rcjcbh));
		$("#m_jcrxm").attr("value",setNull(json.LRcjc[0].jcrxm));
		$("#m_jcrq").attr("value",setNull(json.LRcjc[0].jcrq));
		$("#m_jcrybh").attr("value",setNull(json.LRcjc[0].jcrybh));
		$("#m_zwdm").attr("value",setNull(json.LRcjc[0].zwdm));
		$("#m_jcrzw").attr("value",setNull(json.LRcjc[0].jcrzw));
		$("#m_lsdw").attr("value",setNull(json.LRcjc[0].lsdw));
		$("#m_fxwt").attr("value",setNull(json.LRcjc[0].fxwt));
		$("#m_cljg").attr("value",cljg);
		$("#m_bz").attr("value",setNull(json.LRcjc[0].bz));
		$("#m_hylbdm").attr("value",setNull(json.LRcjc[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LRcjc[0].hylb));
		$("#m_csfzr").attr("value",setNull(json.LRcjc[0].csfzr));
		$("#m_jcsx").attr("value",setNull(json.LRcjc[0].jcsx));
		$("#m_sfzdjcjg").attr("value",setNull(json.LRcjc[0].sfzdjcjg));
		var sfzdjcjg=setNull(json.LRcjc[0].sfzdjcjg);
		if(sfzdjcjg=="是"){
			$('input[@name="sfzdjcjg"]')[0].checked=true;
		}
		if(sfzdjcjg=="否"){
			$('input[@name="sfzdjcjg"]')[1].checked=true;
		}
		setHyxx_modify();
	}	
	//设定行业信息表示
    function setHyxx_modify(){
        var hylb=$("#m_hylbdm").attr("value");
		if(hylb=='J'||hylb=='K'){
			$('#mtd_qymc').text('场所名称');
			$('#mtd_qybm').text('场所备案编号');
			$('#mtd_csfzr').text('场所负责人');
			$('#mtd_csfzrbh').text('场所负责人编号');
		}
    }
	function modifyVerify(){
		if (!checkControlValue("m_hylb","String",1,100,null,0,"行业类别"))
			return false;
		
		if (!checkControlValue("m_jcfs","Select",1,20,null,1,"检查方式"))
			return false;
		
		if (!checkControlValue("m_sfzdjcjg","String",1,100,null,0,"是否知道检查结果"))
			return false;
	
		if (!checkControlValue("m_fxwt","String",1,300,null,1,"发现问题"))
			return false;
		
		if (!checkControlValue("m_cljg","String",1,2000,null,0,"处理结果"))
			return false;
		
		if (!checkControlValue("m_jcrzw","String",1,100,null,0,"检查人职务"))
			return false;
	
		if (!checkControlValue("m_jcrybh","String",1,20,null,0,"警号"))
			return false;
	
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		
		return true;
	}
	
	function setUpdateRcjc(){
		if (modifyVerify()){
			setParams("m_");
			jQuery.post(modUrl,params,updateRcjcback,"json"); 
			return true;
		}else{
			return false;
		}		
	}


	function updateRcjcback(json){
		if  (json.result=="success"){
			if(chuli)
				jAlert("处理成功！",'保存信息');
			else
				jAlert("修改成功！",'保存信息');
			
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow"); 
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
	
	function getRidio(){
		var a=0;
		$('input[@name="sfzdjcjg"]').click(function(){
			a=$(this).val();
			$("#m_sfzdjcjg").val(a);
		});	
	}
</script>
<input type="hidden" id="m_sfzdjcjg" />
<input type="hidden" id="m_hylbdm" />
<input type="hidden" id="q_rcjcid" >
<input type="hidden" id="m_rcjcid" >
<input type="hidden" id="m_zwdm" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">日常检查修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#rcjc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		  <td width="38%" class="red">行业类别</td>
		<td width="20%" class="detailtd"><input type="text" class="readonly" id="m_hylb" readonly /></td>
		
	</tr>
	<tr height="20">
		<td class="distd" id="mtd_qymc">企业名称</td>
		<td class="detailtd" ><input type="text" class="readonly" id="m_qymc" readonly /></td>
		<td width="15%" class="distd" id="mtd_qybm">企业编码</td>
	  	<td width="27%" class="detailtd"><input type="text" class="readonly" id="m_qybm" readonly /><input type="hidden" id="m_csid" readonly /></td>
	</tr>
	<tr height="20">
		<td class="distd" id="mtd_csfzr">企业负责人</td>
		<td class="detailtd"><input type="text" class="readonly" id="m_csfzr" readonly /></td>
		<td class="distd" id="mtd_csfzrbh">企业负责人编号</td>
		<td class="detailtd"><input type="text" class="readonly" id="m_csfzrbh" readonly /></td>
	</tr>
	<tr height="20">
		<td class="distd">日常检查登记序号</td>
		<td class="detailtd" colspan="3"><input type="text" class="readonly" readonly id="m_rcjcbh" style="width:415" /></td>
	</tr>
	<tr height="20">
		<td class="red">检查方式</td>
		<td class="detailtd"><select id="m_jcfs"><option></option></select></td>
		<td class="distd">检查日期</td>
		<td class="detailtd"><input type="text" class="readonly" readonly id="m_jcrq" /></td>
	</tr>
	<tr height="20">
		<td class="distd">检查人员姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_jcrxm" /></td>
		<td class="distd">检查人警号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jcrybh" /></td>
	</tr>
	<tr height="20">
		<td class="distd">检查人职务</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jcrzw" readonly /></td>
		<td class="distd">检查机构</td>
		<td class="detailtd" ><input type="text" class="readonly" readonly id="m_lsdw" /></td>
		
	</tr>
		
	<tr height="20">
		<td class="distd">检查事项</td>
		<td class="detailtd"><input type="text"  class="inputstyle" id="m_jcsx" /></td>
		<td class="distd">是否知道检查结果</td>
		<td class="detailtd"><input type="radio" name="sfzdjcjg"  value="是"/>是   <input type="radio" name="sfzdjcjg" value="否"/>否</td>
	</tr>
	<tr height="20">
		<td class="red">发现问题</td>
		<td class="detailtd" colspan="3"><label>
		  <textarea id="m_fxwt" style="width:432;height:80"></textarea>
		</label></td>
  	</tr>
    	<tr height="20">
		<td class="distd">处理结果</td>
		<td class="detailtd"  colspan="3"><textarea id="m_cljg" style="width:432;height:80" readonly class="readonly"></textarea></td>
	</tr>
    	<tr height="20">
    	<td class="distd">备注</td>
		<td class="detailtd"  colspan="3"><textarea id="m_bz" style="width:432;height:80"></textarea></td>
	</tr>
	<tr height="20">
	  <td colspan="5" class="detailtd"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          	<tr height="25" align="center">
				<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdateRcjc();'>保存</a></td>
			</tr>
</table>
</td>
			</tr>
</table>
