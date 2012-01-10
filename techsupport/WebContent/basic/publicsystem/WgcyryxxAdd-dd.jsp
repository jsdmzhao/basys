<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,com.aisino2.sysadmin.domain.User,com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	 User user= (User)session.getAttribute(Constants.userKey);
	    String name="";
	    String userCount="";
	    String hylbdm = "";
	    if(user!=null){
	    	name=user.getSsdwmc();
	    	userCount=user.getSsdwbm();
	    	hylbdm = userCount.substring(0,3);
	    }
 %>
<script type="text/javascript">
	var fileId;
	var hylbdm = $("#hylbdm").val();
	$(document).ready(function() {
	    bc_bottonMoveRight(20); 
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_rzrq").attr("readonly","true");
		$("#a_rzrq").datepicker();
		
  		$("#a_hyzkdm").selectBox({code:"dm_hyzk"});
  		$("#a_cyzjdm").selectBox({code:"dm_hz"});
  		$("#a_xbdm").selectBox({code:"dm_xb"});
  		$("#a_qzzldm").selectBox({code:"dm_qzzl(lgy)"});
  		fileId="a_fileload";
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	});
	function addVerify(){
	    if (!checkControlValue("a_ywx","String",1,100,null,1,"英文姓"))
			return false;
		if (!checkControlValue("a_ywm","String",1,100,null,1,"英文名"))
			return false;
		if (!checkControlValue("a_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,1,"出生日期"))
			return false;
			
		var tenYearAgo = new Date();
		tenYearAgo.setYear(tenYearAgo.getYear() - 10);
		var tenYearAgoStr = tenYearAgo.getFullYear()+"-"+(tenYearAgo.getMonth()+1)+"-"+tenYearAgo.getDate();
		if(!checkTwoDateEarlier($("#a_csrq").val(),tenYearAgoStr)){
			jAlert("出生日期必须小于"+tenYearAgoStr+"！",'验证信息',null,"a_csrq");
			return false;
		}
		
		if (!checkControlValue("a_gj","String",1,100,null,1,"国籍"))
			return false;
		if (!checkControlValue("a_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("a_wgrjyxkz","String",1,30,null,1,"就业许可证号"))
			return false;
		if (!checkControlValue("a_rzrq","Date",null,null,null,1,"入职日期"))
			return false;
		if (!checkControlValue("a_cyzjdm","Select",1,4,null,1,"证件类型"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,1,"证件号码"))
			return false;
		if (!checkControlValue("a_qzzldm","Select",1,4,null,1,"签证类型"))
			return false;
		if (!checkControlValue("a_qzhm","String",1,20,null,1,"签证号码"))
			return false;
		if (!checkControlValue("a_shouji","String",1,20,null,1,"联系电话"))
			return false;
		if (!checkControlValue("a_jjlxrdh","String",1,20,null,0,"紧急联系电话"))
			return false;
		if(!valFloatValue("a_shengao","请正确填写身高信息",300.00,0,2,0))
			return false;
		if(!valFloatValue("a_tizh","请正确填写体重信息",500.00,0,2,0))
			return false;
		if (!checkControlValue("a_zzzhm","String",1,20,null,0,"暂住证编号"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("a_zzdz","String",1,200,null,0,"暂住地址"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
			
		$("#a_xb").val($("#a_xbdm").attr("title"));
		$("#a_cyzj").val($("#a_cyzjdm").attr("title"));
		
		if($("#a_shengao").val()=="")
			$("#a_shengao").val("0");
		if($("#a_tizh").val()=="")
			$("#a_tizh").val("0");
		return true;
	}
	
	$("#a_gj").click(function(){
		getDict_item("a_gj","a_gjdm","dm_gj(lgy)");
	});
	
	$("#a_hyzkdm").change(function(){
  		$("#a_hyzk").val($("#a_hyzkdm").attr('title'));
	});
	
	function setAdd_wgcyry(){
		if (addVerify()){
			setParams("a_");
			jQuery.ajax({
				type: 'POST',
				url: addUrl,
				data: params,
				async: false,
				dataType: 'json',
				success: addwgcyryback
			});
		}
	}

	function addwgcyryback(json){
		if(json.result=="success"){
			jAlert("添加成功",'提示信息');
			if(!$("#checkbox").attr("checked"))
				$("#"+detailid).hideAndRemove("slow"); 
			else
				clearAllFormElement();
				
			setPageList($("#pageNo").attr("value"));
		}else{
			jAlert(json.result,'错误信息');
		}		
	}	

	function clearAllFormElement(){
		$("[id^=a_]").each(function(index, domEle) {
			$(domEle).attr("value","");
		});
		$("select[id^=a_]").setValue("");
		ctlPicture1.InitPicture();
	}
	
	function openfile(){
		ImgerToBase1.OpenFile();
		ImgerToBase();
	}
	function ImgerToBase(){
		//设置打开图片的大小
		ImgerToBase1.SetFileSize= 2000;
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
		$("#a_fileload").attr("value",base64code);
	}
	function  deleteDate(y){
	 	$('#a_ywx').val("");
		$('#a_zjhm').val("");
 	}
 	function updatePicture(y){
		$('#a_fileload').val(x.GetImage());
		$('#a_ywx').val(x.ocrCName);
		$('#a_zjhm').val(x.ocrIdentityId);
		$('#a_xbdm').setValue(x.ocrCSex);
	    $('#a_xb').val($('#a_xbdm').attr('title'));
 	}
    
    function setPictureBack(x){
 	    $('#a_fileload').val(x.GetImage());
 	}
</script>
<input type="hidden" id="hylbdm" value="<%=hylbdm %>"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">外国从业人员新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#wgcyryxx_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="2" cellspacing="0" id="add">
	<tr height="20">
		<td width="14%" class="distd">人员编号</td>
		<td width="24%" class="detailtd"><input type="text" class="readonly" id="a_cyrybh" readonly/></td>
		<td width="19%" class="distd">中文姓名</td>
		<td width="21%" class="detailtd"><input type="text" class="readonly" id="a_xm" readonly/></td>
		<td width="22%" rowspan="12" align="center" valign="top" ><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
		<input type="hidden" id="a_fileload"/>
        <tr><td>
         <jsp:include page="qyryPicture.jsp?zh=false&mo=2&pic=picControlscr&wi=87&hi=124" flush="true"></jsp:include>
        </td></tr>
      </table>
      </td>
	</tr>
	<tr height="20">
		<td class="red">英文姓</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ywx" /></td>
		<td  class="red">英文名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ywm" /></td>
    </tr>
	<tr height="20">
		<td class="red">性别</td>
		<td class="detailtd"><input type="hidden" id="a_xb"/><select id="a_xbdm"><option></option></select></td>
		<td class="red">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_csrq" /></td>
	</tr>
	<tr height="20">
		<td class="red">国籍</td>
		<td class="detailtd"><input type="text" id="a_gj" readonly class="inputstyle" /><input type="hidden" id="a_gjdm" /></td>
		<td class="distd">婚姻状况</td>
		<td class="detailtd"><select name="select5" id="a_hyzkdm"><option></option></select><input type="hidden" id="a_hyzk" /></td>
	</tr>
  	<tr height="20">
		<td class="red">就业许可证号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_wgrjyxkz" /></td>
		<td class="red">入职日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_rzrq" /></td>
    </tr>
	<tr height="20">
		<td class="red">证件类型</td>
		<td class="detailtd"><select id="a_cyzjdm"><option></option></select><input type="hidden" id="a_cyzj" /></td>
		<td class="red">证件号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zjhm" /></td>
    </tr>
	<tr height="20">
		<td class="red">签证类型</td>
		<td class="detailtd"><select name="select3" id="a_qzzldm"><option></option></select></td>
		<td class="red">签证号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_qzhm" /></td>
    </tr>
	<tr height="20">
		<td class="red">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_shouji" /></td>
		<td class="distd">紧急联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_jjlxrdh" /></td>
    </tr>
	<tr height="20">
		<td class="distd">身高（厘米）</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_shengao" /></td>
		<td class="distd">体重(公斤)</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_tizh" /></td>
	</tr>
	<tr height="20">
		<td class="distd">暂住证编号</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_zzzhm" /></td>
		<td class="distd">职务</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_zhiwu" /></td>
    </tr>
	<tr height="20">
		<td class="distd">暂住地址</td>
		<td colspan="4" class="detailtd"><input type="text" class="inputstyle3" style="width:493" id="a_zzdz" /></td>
	</tr>
	<tr height="20">
        <td class="distd">备注</td>
		<td colspan="4" class="detailtd"><textarea name="textarea2" id="a_bz" cols="76" rows="3"></textarea></td>
	</tr>
	<!-- 
	<tr height="20">
	  <td align="right">
	    <input type="checkbox" name="checkbox" id="checkbox"/></td>
      <td colspan="4" align="left">保存后继续新的采集</td>
	</tr>
	 -->
	<tr height="25" align="center"><td colspan="5"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd_wgcyry();'>保存</a></td></tr>
</table>