<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%
	//登录用户ID，用于获得菜单
	int userid = 0;
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null)
		response.sendRedirect("login.jsp");
	else
		userid = user.getUserid().intValue();
	String deptCode = user.getDepartment().getDepartcode();
	String deptName = user.getDepartment().getDepartname();
	String userName = user.getUsername();

	String deptCodeStr = "";
	if (deptCode.length() == 12)
		deptCodeStr = deptCode.substring(0, 6);
	
	String deptLeve = user.getDepartment().getDepartlevel().toString(); ///得到当前用户的级别 2为省级用户
%>
<script type="text/javascript">
	var fileId;
	$(document).ready(function() {
	    bc_bottonMoveRight(); //将保存按钮右移
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_tbsj").attr("readonly","true");
		$("#a_tbsj").datepicker();
		$("#a_bkczsj").attr("readonly","true");
		$("#a_bkczsj").datepicker();
		$("#a_bkdqsj").attr("readonly","true");
		$("#a_bkdqsj").datepicker();
		$("#a_cksj").attr("readonly","true");
		$("#a_cksj").datepicker();
		$("#a_ckczsj").attr("readonly","true");
		$("#a_ckczsj").datepicker();
		$("#a_cksprq").attr("readonly","true");
		$("#a_cksprq").datepicker();
		
		$("#a_bkczsj").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);
		 $("#a_xbdm").selectBox({code:"dm_xb"});
		 
		 
		 $("#a_bkfwbm").selectBox({code:"dm_bkfw"});
		 if("2"=="<%=deptLeve%>"){
		   ////如果是登陆用户是省厅用户   只能选择省级布控
		   $("#a_bkfwbm").setValue("2");
		   $("#a_bkfwbm").setAttr("readonly","true");
		 }
		 
		 $("#a_kybm").selectBox({code:"dm_ky"});
		 $("#a_ttbm").selectBox({code:"dm_tx"});
		 $("#a_ajlbbm").selectBox({code:"dm_ajlx"});
		 
		  $("#a_tz").click(function(){
			getDict_item("a_tz","a_tzbm","dm_tmtz");
			});
		  $("#a_jg").click(function(){
			getDict_item("a_jg","a_jgdm","dm_xzqh");
			});
			$("#a_minzu").click(function(){
			getDict_item("a_minzu","a_mzdm","dm_mz");
			});
			
			
		$("#a_gmsfhm").blur(function(){//当填写身份证号码失去焦点后，去判断身份证号码
		//如果身份证证号填写不为15或18位，则直接返回让他重新填写
		var zjhm = $("#a_gmsfhm").attr("value").toUpperCase();
		  if(!isIdCardNo(zjhm))
		  {
		 	 $("#a_gmsfhm").val("");//清空
		  //$("#a_zjhm").focus();//得到焦点
		 // alert("请输入15位或18位的身份证号码");
		    return false;
		  }else{
		  	if(zjhm.length==15){		  	
					zjhm=change15to18(zjhm);
			}
		  }		  
		//证件号码就用用户自己填写的，如15位的不在去转换为18位
		$("#a_gmsfhm").val(zjhm.toUpperCase());
		$("#y_gmsfhm").val(zjhm.toUpperCase());
		//根据证件号码去查看数据库此证件号是否已经存在，如果存在，则给出提示，并重新填写
		valadateCode(zjhm.toUpperCase());
		if(!canCommit){
			$("#a_gmsfhm").val("");//清空,不在得到焦点
			return false;
		}
		
		//传入一个身份证号码，得到性别跟出生日期
		$("#a_xbdm").setValue(getXb(zjhm.toUpperCase()));
		$("#a_csrq").val(getBirthday(zjhm.toUpperCase()));
		});
		
		
		$("#a_hylbdm").selectBoxhylb();//行业类别
		
		
		fileId="a_fileload";
	}); 
	function addVerify(){
	//赋值放在检测的前面，这样才不会被阻止
	$("#a_xb").val($("#a_xbdm").attr("title"));
		$("#a_bkfw").val($("#a_bkfwbm").attr("title"));
		$("#a_ky").val($("#a_kybm").attr("title"));
		$("#a_tt").val($("#a_ttbm").attr("title"));
		$("#a_ajlb").val($("#a_ajlbbm").attr("title"));	
		
		//if (!checkDateEarlier("p_ruzhukssj","入住开始时间","p_ruzhujssj","入住结束时间","DATETIME"))
		  //return false;
		
		
		if (!checkControlValue("a_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,1,"姓名"))
			return false;
		if (!checkControlValue("a_gmsfhm","String",1,20,null,1,"公民身份号码"))
			return false;
		if (!checkControlValue("a_jg","String",1,100,null,0,"籍贯"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,1,"出生日期"))
			return false;
		if (!checkControlValue("a_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("a_ky","String",1,100,null,0,"口音"))
			return false;
		if (!checkControlValue("a_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("a_tz","String",1,100,null,0,"体征"))
			return false;
		if (!checkControlValue("a_tt","String",1,100,null,0,"体态"))
			return false;
		if (!checkControlValue("a_yz","String",1,200,null,0,"衣着"))
			return false;
		if (!checkControlValue("a_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("a_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("a_tbsj","Date",null,null,null,1,"通报时间"))
			return false;
		if (!checkControlValue("a_jyaq","String",1,2000,null,1,"简要案情"))
			return false;
		if (!checkControlValue("a_bkr","String",1,100,null,1,"布控人"))
			return false;
		if (!checkControlValue("a_bkczy","String",1,100,null,0,"布控操作员"))
			return false;
		if (!checkControlValue("a_bkczsj","Date",null,null,null,0,"布控操作时间"))
			return false;
		if (!checkControlValue("a_bkdqsj","Date",null,null,null,1,"布控终止时间"))
			return false;	
		if (!checkControlValue("a_lxr","String",1,100,null,1,"联系人"))
			return false;
		if (!checkControlValue("a_lxfs","String",1,60,null,1,"联系方式"))
			return false;
		if (!checkControlValue("a_hylbdm","Select",1,4,null,1,"行业类别"))
			return false;
			
		//if($("#a_bkdqsj").val()<gettoday()){
		if($("#a_bkdqsj").val()<$("#a_bkczsj").val()){
		  jAlert("布控终止时间不能小于布控操作时间！",'提示信息');
		  return false;
		}
			
		return true;
	}
	
	function valadateCode(zjhm){ //验证代码
		setParams("y_");
		var sUrl="basicsystem/validateZjhm_bkry.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				valadateCodeBack(rows);
			}
		});
	}
	function valadateCodeBack(json){
		if(json.result=="success"){
			if(json.strResult=="1"){
				jAlert('此身份证号码已存在!','验证信息');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			canCommit=false;
		}
	}
	
	
	function openfile(){
		ImgerToBase1.OpenFile();
		ImgerToBase();
	}
	function ImgerToBase(){   
		//设置打开图片的大小
		ImgerToBase1.SetFileSize= 2000;
		//文件名称 eg: snow.jpeg
		var fileName = ImgerToBase1.getFileName();
		
		//只能上传jpg格式的图片
		if(fileName!=null&&fileName!=''&&fileName!='null'){
		    var fileNameArray = fileName.split(".");
			if(fileNameArray[fileNameArray.length-1]!="jpg"){
				if(fileNameArray[fileNameArray.length-1]!="JPG"){
				   jAlert("只能上传jpg格式的图片！","系统提示");
				   return;
				}
			}
			//BASE64编码
			ajaxAddDivCeng();
			var base64code = ImgerToBase1.getBase64();
			removeAllDivCeng();
		}
		
		//文件路径 包括文件名称
		var filePath = ImgerToBase1.getFile();
		
		
		if(fileName==null||fileName==''||fileName=='null'){
			if($("#pmtPho").attr("src")==""){
				$("#pmtPho").attr("src","images/pic.gif");
			}
		} else {
			$("#pmtPho").attr("src",filePath);
		}
		
		$("#a_fileload").attr("value",base64code);
	}
	
	////为行业类别赋值
	function changehylb(){
	  
	  $("#a_hylb").val($("#a_hylbdm").attr("title"));
	  //alert($("#a_hylb").attr("value"));
	}
	
	 ////////得到今天的日期
    function gettoday(){
     var today = new Date();
     var month = "";
     var date = "";
     if((today.getMonth()+1)<10)
         month = "0"+(today.getMonth()+1);
     else
         month = today.getMonth()+1;
     
     if(today.getDate()<10)
         date = "0"+today.getDate();
     else
         date = today.getDate();
     mydate = today.getYear()+"-"+month+"-"+date;
     return mydate;
  }
	
</script>
<input type="hidden" id="a_bkryid" value=1>
<input type="hidden" id="a_xb">
<input type="hidden" id="a_bkfw">
<input type="hidden" id="a_ky">
<input type="hidden" id="a_tt">
<input type="hidden" id="a_ajlb">
<input type="hidden" id="y_gmsfhm">
<input type="hidden" id="a_ckbs" value="0">
<input type="hidden" id="a_bkrylxdm" value="1">
<input type="hidden" id="a_bkrylx" value="国内人员布控">
<input type="hidden" id="a_fwdwbm" value="<%=deptCode%>">
<input type="hidden" id="a_tbbh" value="<%=deptCodeStr%>">
<input type="hidden" id="a_deptLeve" value="<%=deptLeve%>">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			布控人员新增
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#bkry_detail").hideAndRemove(&quot;show&quot;);' class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0">
	<tr>
		<td width="12%" class="red">
			姓名
		</td>
		<td width="20%" class="detailtd">
			<input type="text" class="inputstyle" id="a_xm" value="" />
		</td>
		<td width="18%" class="red">
			公民身份号码
		</td>
		<td width="22%" class="detailtd">
			<input type="text" class="inputstyle" id="a_gmsfhm" value="" />
		</td>
		<td width="28%" rowspan="10" valign="top">
			<table width="100%" border="0" align="center" cellpadding="8"
				cellspacing="0">
				<input type="hidden" id="a_fileload" />
				<tr>
					<td valign="top">
						<img id ="pmtPho" width="150px" height="170px" src="images/pic.gif"/>
						<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="选图片" onclick='openfile();'>选图片</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td width="12%" class="red">
			出生日期
		</td>
		<td width="20%" class="detailtd">
			<input type="text" class="inputstyle" id="a_csrq" value="" />
		</td>
		<td width="18%" class="red">
			性别
		</td>
		<td width="22%" class="detailtd">
			<select type="select" id="a_xbdm" value="">
				<option></option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="distd">
			籍贯
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_jg" readonly />
			<input type="hidden" id="a_jgdm" />
		</td>
		<td width="12%" class="distd">
			口音
		</td>
		<td width="20%" class="detailtd">
			<select type="select" id="a_kybm" value="">
				<option></option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="distd">
			民族
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_minzu" readonly />
			<input type="hidden" id="a_mzdm" />
		</td>
		<td width="18%" class="distd">
			身高
		</td>
		<td width="22%" class="detailtd">
			<input type="text" class="inputstyle" id="a_shengao" />
		</td>
	</tr>
	<tr>
		<td class="distd">
			体征
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_tz" readonly />
			<input type="hidden" id="a_tzbm" />
		</td>
		<td class="distd">
			体态
		</td>
		<td class="detailtd">
			<select type="select" id="a_ttbm" value="">
				<option></option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="red">
			布控范围
		</td>
		<td class="detailtd">
			<select type="select" id="a_bkfwbm">
				
			</select>
		</td>
		<td class="distd">
			衣着
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_yz" value="" />
		</td>
	</tr>
	<tr>
		<td width="12%" height="23" class="distd">
			案件类别
		</td>
		<td width="20%" class="detailtd">
			<select type="select" id="a_ajlbbm" value="">
				<option></option>
			</select>
		</td>
		<td width="18%" class="red">
			通报时间
		</td>
		<td width="22%" class="detailtd">
			<input type="text" class="inputstyle" id="a_tbsj" value="" />
		</td>
	</tr>
	<tr>
		<td width="12%" class="red">
			布控终止时间
		</td>
		<td width="20%" class="detailtd">
			<input type="text" class="inputstyle" id="a_bkdqsj" value="" />
		</td>
		<td class="distd">
			布控操作员
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="a_bkczy"
				value="<%=userName%>" />
		</td>
	</tr>
	<tr>

		<td class="distd">
			布控操作时间
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="a_bkczsj" value="" />
		</td>
		<td class="red">
			布控人
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_bkr" value="" />
		</td>
	</tr>
	<tr>
		<td class="red">
			联系人
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_lxr" value="" />
		</td>
		<td class="red">
			联系方式
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_lxfs" value="" />
		</td>
	</tr>
	
	<!-- 添加行业类别 -->
	
	<tr>
		<td class="red">
			行业类别
		</td>
		<td class="detailtd">
			<select type="select" id="a_hylbdm" value="" onChange="changehylb();">
			   
			</select>
			<input type="hidden" id="a_hylb">
		</td>
		<td class="red">
			
		</td>
		<td class="detailtd">
		</td>
	</tr>
	
	
	
	<tr>
		<td height="33" class="red">
			简要案情
		</td>
		<td colspan="4" class="detailtd">
			<textarea name="textarea" id="a_jyaq" style="width:610px;" value=""
				type="_moz" />
			</textarea>
		</td>
	</tr>
	<tr>
		<td height="20" class="distd">
			发文单位
		</td>
		<td class="detailtd" colspan="4">
			<input type="text" style="width:610px;" class="readonly" id="a_fwdw"
				value="<%=deptName%>" />
		</td>
	</tr>

	<tr align="center">
		<td height="30" colspan="5">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setAdd();'>保存</a>
		</td>
	</tr>
</table>
<%@include file="../../public/includeImgerToBase64.jsp" %>