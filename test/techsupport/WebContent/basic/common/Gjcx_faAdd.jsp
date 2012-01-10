<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	//$("#a_ickslid").attr("value",dataid);
	$("#a_gjcxfamc").focus();
	var h_gjcxfaid = $("#h_gjcxfaid").val();
	if(h_gjcxfaid!=null && h_gjcxfaid!="" && h_gjcxfaid!=-1){
		$("#gjcxfatj_td").text("高级查询方案修改");
		$("#a_gjcxfamc").val(gjcxfaName);
		$("#a_gjcxfamc").get(0).select();
	}
}); 

function fanganAddValidate(){
	if (!checkControlValue("a_gjcxfamc","String",1,200,null,1,"方案名称"))
		return false;
	return true;
}

function getFangan(){
	if(fanganAddValidate()){	
		setAdd_fangan();
		hideFanganAdd();
	}
}

function setAdd_fangan(){
	var gjcxfaInserUrl;
	if($("#biaoqian_4").css("display")!="block"){
		if(validateSqlYuJu()){
			dataid = "sjbjgid";
			var pptjList = new Array("Pptj_tableData","Pxgz_tableData");
			$("#a_gjcxlx").val("动态");
			
			removeInput();
			
			setParams("a_",pptjList);
			jQuery.post("basicsystem/insert_gjcxfa.action",params,update_gjcxfaback,"json"); 
		}else{
			return;
		}
	}else{
		$("#a_gjcxlx").val("SQL");
		setParams("a_");
		jQuery.post("basicsystem/insertSql_gjcxfa.action",params,update_gjcxfaback,"json"); 
	}
}

function update_gjcxfaback(json){
	if(json.result=="success"){
		jAlert("操作成功","提示信息");
		createXML("b_");
		$("#fangan_list").selectBox({url:"basicsystem/listNoPage_gjcxfa.action"});
		getFanganZbxx("","")
	}else{
		jAlert(json.result,"错误信息");
	}
}

function hideFanganAdd(){
	$("#gjcx_detail").hide("show");
}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
 <tr>
      <td align="left" class="title1" colspan="2" id="gjcxfatj_td">高级查询方案添加</td>
    </tr>
</table>
<table width="100%"  cellpadding="2" cellspacing="0"  id="detail" > 
<tr>
	  <td width="28%" height="5"></td>
  </tr>
<tr>
		<td width="28%" class="distd">方案名称</td>
    <td width="72%" class="detailtd"><input type="text" class="inputstyle" id="a_gjcxfamc" /></td>
  </tr>
	<tr height="15"><td align="center" colspan="2">
		<table border="0" cellpadding="2" cellspacing="0">
<tr>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='getFangan();'>保存</a></td>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='hideFanganAdd();'>关闭</a></td>
			</tr>
		</table>
	</td>
</tr>
</table>