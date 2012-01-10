<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var fileData,fileId;
	$(document).ready(function() {
	    bc_bottonMoveRight(30);
		$("#q_ickslid").attr("value",dataid);
		$("#q_cyrylbdm").attr("value",$("#f_rylbbm").val());
		$("#a_ickslid").attr("value",dataid);
		$("#a_rzrq").attr("readonly","true");
		$("#a_rzrq").datepicker();
		
		$("#a_hyzkdm").selectBox({code:"dm_hyzk"});
		//$("#a_cylbdm").selectBox({code:"dm_cyrylb"});
		$("#a_bhkyy").selectBox({code:"dm_bhkyy"});
		$("#a_cylb").click(function(){
          getrylbTree("a_cylb","a_cylbdm","dm_cyrylb");
      });
  		fileId = "a_fileload";
		setDetail();
	}); 
	
	function updatediv (json) { 
		$("#cyrybh").append(setNull(json.wgcyryxx.cyrybh));
		$("#a_cyrybh").val(setNull(json.qyryxx.cyrybh));
		$("#a_qyid").val(setNull(json.wgcyryxx.qyid));
		$("#a_cylb").val(setNull(json.wgcyryxx.cylb));
		$("#a_cylbdm").val(setNull(json.wgcyryxx.cylbdm));
		$("#xm").append(setNull(json.wgcyryxx.xm));
		$("#ywx").append(setNull(json.wgcyryxx.ywx));
		$("#qzhm").append(setNull(json.wgcyryxx.qzhm));
		$("#ywm").append(setNull(json.wgcyryxx.ywm));
		$("#wgrjyxkz").append(setNull(json.wgcyryxx.wgrjyxkz));
		$("#qzzldm").append(setNull(json.wgcyryxx.qzzldm));
		$("#gj").append(setNull(json.wgcyryxx.gj));
		$("#minzu").append(setNull(json.wgcyryxx.minzu));
		$("#xb").append(setNull(json.wgcyryxx.xb));
		$("#csrq").append(setNull(json.wgcyryxx.csrq));
		$("#hyzk").append(setNull(json.wgcyryxx.hyzk));
		$("#hjdxzqh").append(setNull(json.wgcyryxx.hjdxzqh));
		$("#hjdxz").append(setNull(json.wgcyryxx.hjdxz));
		$("#zjhm").append(setNull(json.wgcyryxx.zjhm));
		$("#a_zzzhm").val(setNull(json.wgcyryxx.zzzhm));
		$("#a_zzdz").val(setNull(json.wgcyryxx.zzdz));
		$("#a_shouji").val(setNull(json.wgcyryxx.shouji));
		$("#a_qtlxdh").val(setNull(json.wgcyryxx.jjlxrdh));
		$("#a_zhiwu").val(setNull(json.wgcyryxx.zhiwu));
		$("#a_rzrq").val(setNull(json.wgcyryxx.rzrq));
		$("#zxr").append(setNull(json.wgcyryxx.zxr));
		$("#zxsj").append(setNull(json.wgcyryxx.zxsj));
		$("#cjsj").append(setNull(json.wgcyryxx.cjsj));
		$("#cjr").append(setNull(json.wgcyryxx.cjr));
		$("#hcdw").append(setNull(json.wgcyryxx.hcdw));
		$("#zxyy").append(setNull(json.wgcyryxx.zxyy));
		$("#zt").append(setNull(json.wgcyryxx.zt));
		$("#a_bz").val(setNull(json.wgcyryxx.bz));
		$("#a_ryid").val(setNull(json.wgcyryxx.ryid));
		$("#a_qymc").val(setNull(json.wgcyryxx.qymc));
		$("#a_qybm").val(setNull(json.wgcyryxx.qybm));
		$("#a_tizh").val(setNull(json.wgcyryxx.tizh));
		$("#a_shengao").val(setNull(json.wgcyryxx.shengao));
		$("#a_zkztbs").val(setNull(json.icksl.zkztbs));
		$("#a_ickzxr").val(setNull(json.icksl.ickzxr));
		$("#a_hyzk").val(setNull(json.wgcyryxx.hyzk));
		$("#a_hyzkdm").setValue(setNull(json.wgcyryxx.hyzkdm));
		
		$("#cyryPho").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+$("#a_ryid").val());
		
		$("#yxqhzrq").append(setNull(json.LIcksl[0].yxqhzrq).substring(0,10));
		
		//fileData = setNull(json.wgcyryxx.fileload);
		//setFile();
		
	}	
	
	function addVerify(){
		if (!checkControlValue("a_rzrq","String",1,20,null,1,"入职日期"))
			return false;
		if (!checkControlValue("a_shouji","String",1,30,null,1,"联系电话"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,1,"服务单位"))
			return false;
		var selValue = $("#a_cylbdm").val();
		if (selValue==null || selValue==""){
			jAlert("人员类别不能为空值！",'验证信息');
			return false;
		}
		selValue = $("#a_bhkyy").val();	
		if (selValue==null || selValue==""){
			jAlert("补换卡原因不能为空值！",'验证信息');
			return false;
		}
		
		if($("#a_yksfsh").attr("checked")){
			$("#a_yksfsh").val(1);
		}else{
			$("#a_yksfsh").val(0);
		}
		
		//$("#a_cylb").val($("#a_cylbdm").attr("title"));
		
		if($("#a_shengao").val()=="")
			$("#a_shengao").val("0");
		if($("#a_tizh").val()=="")
			$("#a_tizh").val("0");
		return true;
	}
	
// 企业筛选框
$("#a_qymc").click(function(){
    dataid="";
 	getTy_item("a_qymc","a_qybm","a_qyid");
  });

	function addAll(){
		setAdd_ickbhk();
	}
	
	function setAdd_ickbhk(){
	if (addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addickbhkback,"json");
	}else{
		return addVerify();
	}	
}	

function addickbhkback(json){
	if  (json.result=="success"){
		jAlert("补换卡成功",'提示信息');
		$("#"+detailid).empty();
		$("#"+detailid).hideAndRemove("slow"); 
		detailUrl="icksystem/query_icksl.action";
		dataid=json.cyryxx.ryid;
		sFlag="false";
		setWidth("icksl_detail",modWidth);
		setUrl("icksl_detail","basic/icksystem/IckslgwDetail.jsp?slyy=0");
		setPageList($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}	
function openfile(){
	ImgerToBase1.SetFileSizeA(1600);
	ImgerToBase1.OpenFile();
	var fileName = ImgerToBase1.getFileName();
	if(fileName!='') ImgerToBase();
}

function ImgerToBase(){
	ImgerToBase1.SetFileSize= 1600;
	var filePath = ImgerToBase1.getFile();
	var base64code = ImgerToBase1.getBase64();
	var fileName = ImgerToBase1.getFileName();
	if(fileName==null||fileName==''||fileName=='null'){
	} else {
		$("#cyryPho").attr("src",filePath);
		$("#a_fileload").attr("value",base64code);
	}
}
</script>
<input type="hidden" id="q_ickslid">
<input type="hidden" id="q_cyrylbdm">
<input type="hidden" id="a_ickslid">
<input type="hidden" id="a_ryid">
<input type="hidden" id="a_zkztbs">
<input type="hidden" id="a_ickzxr">
<input type="hidden" id="a_qybm" />
<input type="hidden" id="a_qyid" />
<input type="hidden" id="a_hyzk" />
<input type="hidden" id="a_cyrybh" />
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">境外从业人员IC卡补换卡</td>
      <td><a href="#" id="closeDiv" onclick='$("#ickbhk_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
<table width="100%" cellpadding="2" cellspacing="0" id="add">
<tr height="20">
		<td width="12%" class="distd">人员编号</td>
	  <td width="22%" class="detailtd"><span id="cyrybh" /></span></td>
		<td width="18%" class="distd">中文姓名</td>
	  <td width="21%" class="detailtd"><span id="xm" ></span></td>
	  <td width="27%" rowspan="12" align="center" valign="top" >
          <table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id ="cyryPho" width="120px" height="160px" src="images/pic.gif"/></td></tr>
        <tr><td><input type="hidden" id="a_fileload"/>
        <a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="选图片" onclick='openfile();'>选图片</a>
        </td></tr>
      </table>
      </td>
	</tr>
	<tr height="20">
	  <td class="distd">英文姓</td>
      <td class="detailtd"><span id="ywx" ></span></td>
      <td  class="distd">英文名</td>
	  <td class="detailtd"><span id="ywm" ></span></td>
    </tr>
    	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd">
		  <span id="xb">
	      </span></td>
	  <td class="distd">出生日期</td>
      <td class="detailtd"><span id="csrq" ></span></td>
  </tr>
	<tr height="20">
	  <td class="distd">国籍</td>
      <td class="detailtd"><span id="gj">
      </span></td>
      <td class="distd">婚姻状况</td>
      <td class="detailtd"><select name="select5" id="a_hyzkdm"><option></option>
        </select></td>
  </tr>
  	<tr height="20">
		<td class="distd">就业许可证号</td>
	  <td class="detailtd"><span id="wgrjyxkz"></span></td>
		<td class="red">入职日期</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_rzrq" /></td>
    </tr>
	<tr height="20">
		<td class="distd">证件类型</td>
		<td class="detailtd">
		  <span id="qzzldm">
          </span></td>
	  <td class="distd">证件号码</td>
	  <td class="detailtd"><span id="qzhm" ></span></td>
    </tr>
	<tr height="20">
		<td class="red">人员类别</td>
	  <td class="detailtd"><input type="hidden" id="a_cylbdm"/>
	  <input type="text" id="a_cylb" class="inputstyle" readonly /></td>
		<td class="red">联系电话</td>
	  <td class="detailtd"><input type="text" class="inputstyle" id="a_shouji" /></td>
    </tr>
	<tr height="20">
		<td class="red">服务单位</td>
	  <td colspan="3" class="detailtd"> <input type="text" style="width:470" class="inputstyle" id="a_qymc" readonly />
      </td>
  </tr>
	<tr height="20">
		<td class="distd">紧急联系电话</td>
      <td class="detailtd"><input type="text" class="inputstyle"  id="a_qtlxdh" /></td>
      <td class="distd">身高（厘米）</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_shengao" /></td>
  </tr>
	<tr height="20">
		<td class="distd">职务</td>
      <td class="detailtd"><input type="text" class="inputstyle"  id="a_zhiwu" /></td>
      <td class="distd">体重(公斤)</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_tizh" /></td>
    </tr>
	<tr height="20">
		<td class="distd">暂住证编号</td>
      <td colspan="3" class="detailtd"><input type="text" class="inputstyle" id="a_zzzhm" /></td>
  </tr>
	<tr height="20">
		<td class="distd">暂住地址</td>
	  <td colspan="3" class="detailtd"><input type="text" style="width:470" class="inputstyle" id="a_zzdz" /></td>
  </tr>
	<tr height="20">
		<td colspan="5" class="distd"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          <tr>
            <td width="12%" class="distd" valign="top">备注 </td>
            <td width="88%" class="detailtd"><textarea name="textarea2" id="a_bz" cols="78" rows="3"></textarea></td>
          </tr>
        </table></td>
  </tr>
	<tr height="20">
	  <td class="distd">
	    原IC卡有效期</td>
      <td class="detailtd"><span id="yxqhzrq" ></span></td>
      <td class="red">补换卡原因</td>
      <td class="detailtd"><select name="select6" id="a_bhkyy" ><option></option>
      </select></td>
      <td class="detailtd"><label>
        <input type="checkbox" name="checkbox" id="a_yksfsh" value="1"  />
      原卡是否收回</label></td>
  </tr>
	<tr height="25" align="center"><td colspan="5"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='addAll();'>保存</a></td></tr>
</table>
<%@include file="../../public/includeImgerToBase64.jsp" %>