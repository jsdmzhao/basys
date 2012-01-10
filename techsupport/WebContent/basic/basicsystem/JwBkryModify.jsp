<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
var fileData;
var fileId;
	$(document).ready(function() {
		$("#q_bkryid").attr("value",dataid);
		$("#m_bkryid").attr("value",dataid);
		setDetail();
		var dateRodom=new Date();
		$("#pmtPho").attr("src","<%=request.getContextPath()%>/basicsystem/queryZp_bkry.action?bkryid="+dataid+"&date="+dateRodom);
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_tbsj").attr("readonly","true");
		$("#m_tbsj").datepicker();
		$("#m_bkdqsj").attr("readonly","true");
		$("#m_bkdqsj").datepicker();
		$("#m_bkczsj").attr("readonly","true");
		//$("#m_bkczsj").datepicker();
		
		$("#m_xbdm").selectBox({code:"dm_xb"});
		
		 ////$("#m_bkfwbm").selectBox({code:"dm_bkfw"});
		 
		 $("#m_ttbm").selectBox({code:"dm_tx"});
		 $("#m_ajlbbm").selectBox({code:"dm_ajlx"});
		 $("#m_zjlxdm").selectBox({code:"dm_jwzjlx"});
		 
		  $("#m_tz").click(function(){
			getDict_item("m_tz","m_tzbm","dm_tmtz");
			});
		  $("#m_gj").click(function(){
			getDict_item("m_gj","m_gjdm","dm_gj(lgy)");
			});
		$("#m_zjhm").blur(function(){//当填写证件号码失去焦点后，去判断这个号码是否存在
		//先看看这个证件号码跟开始的时候进来的时候证件号码是否一致，如果是一致的，则不去检验了
			if($("#t_zjhm").attr("value")!= $("#m_zjhm").attr("value"))	{
			
			if($("#m_zjhm").val()!=""){
				var zjhm = $("#m_zjhm").attr("value");
				//根据证件号码去查看数据库此证件号是否已经存在，如果存在，则给出提示，并重新填写
				$("#y_zjhm").val(zjhm);
				valadateCode(zjhm);
				if(!canCommit){
					$("#m_zjhm").val("");//不清空,防止用户误点了这个文本框
					return false;
				}
				
			 }
				
			}
		});
	}); 
	function updatediv (json) { 
		$("#m_bkryid").attr("value",setNull(json.LBkry[0].bkryid));
		$("#m_tbbh").attr("value",setNull(json.LBkry[0].tbbh));
		$("#m_zwm").attr("value",setNull(json.LBkry[0].zwm));
		$("#m_ywm").attr("value",setNull(json.LBkry[0].ywm));
		$("#m_ywx").attr("value",setNull(json.LBkry[0].ywx));
		$("#m_zjhm").attr("value",setNull(json.LBkry[0].zjhm));
		$("#t_zjhm").attr("value",setNull(json.LBkry[0].zjhm));
		$("#m_gj").attr("value",setNull(json.LBkry[0].gj));
		$("#m_csrq").attr("value",setNull(json.LBkry[0].csrq));
		$("#m_xb").attr("value",setNull(json.LBkry[0].xb));
		$("#m_zjlx").attr("value",setNull(json.LBkry[0].zjlx));
		
		$("#m_xbdm").setValue(setNull(json.LBkry[0].xbdm));
		
		
		//$("#m_bkfwbm").setValue(setNull(json.LBkry[0].bkfwbm));
		
		$("#m_bkfwbm").attr("value",setNull(json.LBkry[0].bkfwbm));  /////update cuicui
		$("#m_bkfw").attr("value",setNull(json.LBkry[0].bkfw));      /////update cuicui
		
		$("#m_ttbm").setValue(setNull(json.LBkry[0].ttbm));
		$("#m_ajlbbm").setValue(setNull(json.LBkry[0].ajlbbm));
		$("#m_zjlxdm").setValue(setNull(json.LBkry[0].zjlxdm));
		
		$("#m_shengao").attr("value",setNull(json.LBkry[0].shengao));
		$("#m_tz").attr("value",setNull(json.LBkry[0].tz));
		$("#m_tzbm").attr("value",setNull(json.LBkry[0].tzbm));
		$("#m_tt").attr("value",setNull(json.LBkry[0].tt));
		$("#m_yz").attr("value",setNull(json.LBkry[0].yz));
		$("#m_fwdw").attr("value",setNull(json.LBkry[0].fwdw));
		$("#m_ajlb").attr("value",setNull(json.LBkry[0].ajlb));
		$("#m_tbsj").attr("value",setNull(json.LBkry[0].tbsj));
		$("#m_jyaq").attr("value",setNull(json.LBkry[0].jyaq));
		$("#m_bkr").attr("value",setNull(json.LBkry[0].bkr));
		$("#m_bkczy").attr("value",setNull(json.LBkry[0].bkczy));
		$("#m_bkdqsj").attr("value",setNull(json.LBkry[0].bkdqsj));
		
		//$("#m_bkfw").attr("value",setNull(json.LBkry[0].bkfw));
		
		$("#m_lxr").attr("value",setNull(json.LBkry[0].lxr));
		$("#m_lxfs").attr("value",setNull(json.LBkry[0].lxfs));
		$("#m_bkczsj").attr("value",setNull(json.LBkry[0].bkczsj));
		$("#m_fileload").attr("value",setNull(json.LBkry[0].fileload));
	}	
	function modifyVerify(){
	//赋值放在检测的前面，这样才不会被阻止
		$("#m_xb").val($("#m_xbdm").attr("title"));
		
		////$("#m_bkfw").val($("#m_bkfwbm").attr("title"));  update cuicui
		
		$("#m_tt").val($("#m_ttbm").attr("title"));
		$("#m_ajlb").val($("#m_ajlbbm").attr("title"));	
		$("#m_zjlx").val($("#m_zjlxdm").attr("title"));	
	
		if (!checkControlValue("m_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("m_zwm","String",1,100,null,1,"中文名"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,1,"证件号码"))
			return false;
		if (!checkControlValue("m_gj","String",1,100,null,1,"国籍"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,1,"出生日期"))
			return false;
		if (!checkControlValue("m_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("m_zjlxdm","Select",1,20,null,1,"证件类型"))
			return false;
		if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("m_tz","String",1,100,null,0,"体征"))
			return false;
		if (!checkControlValue("m_tt","String",1,100,null,0,"体态"))
			return false;
		if (!checkControlValue("m_yz","String",1,200,null,0,"衣着"))
			return false;
		if (!checkControlValue("m_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("m_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("m_tbsj","Date",null,null,null,1,"通报时间"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("m_bkr","String",1,100,null,0,"布控人"))
			return false;
		if (!checkControlValue("m_bkczy","String",1,100,null,0,"布控操作员"))
			return false;
		if (!checkControlValue("m_bkczsj","Date",null,null,null,0,"布控操作时间"))
			return false;
		if (!checkControlValue("m_bkdqsj","Date",null,null,null,1,"布控终止时间"))
			return false;
		/**
		if (!checkControlValue("m_bkfwbm","Select",1,300,null,1,"布控范围"))
			return false;  **/
		if (!checkControlValue("m_lxr","String",1,100,null,1,"联系人"))
			return false;
		if (!checkControlValue("m_lxfs","String",1,60,null,1,"联系方式"))
			return false;	
				
		$("#mod_dqsj").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);
		if (!checkDateEarlier("m_csrq", "出生日期", "mod_dqsj", "当前时间", "DATE")) 
	        return false;
	    //if (!checkDateEarlier("m_bkczsj", "布控操作时间", "mod_dqsj", "当前时间", "DATE")) 
	    //    return false;
	    if (!checkDateEarlier("m_tbsj", "通报时间", "mod_dqsj", "当前时间", "DATE")) 
	        return false;
	        
	    if($("#m_bkdqsj").val()<$("#m_bkczsj").val()){
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
		//文件路径 包括文件名称
		var filePath = ImgerToBase1.getFile();
		//BASE64编码
		ajaxAddDivCeng();
		var base64code = ImgerToBase1.getBase64();
		var fileName = ImgerToBase1.getFileName();
		removeAllDivCeng();
		//文件名称 eg: snow.jpeg
		//只能上传jpg格式的图片
		if(fileName!=null&&fileName!=''&&fileName!='null'){
		    var fileNameArray = fileName.split(".");
			if(fileNameArray[fileNameArray.length-1]!="jpg"){
			   if(fileNameArray[fileNameArray.length-1]!="JPG"){
				   jAlert("只能上传jpg格式的图片！","系统提示");
				   return;
				}
			}
		}
		if(fileName==null||fileName==''||fileName=='null'){
			$("#pmtPho").attr("src","images/pic.gif");
		} else {
			$("#pmtPho").attr("src",filePath);
		}
		$("#m_fileload").attr("value",base64code);
	}
</script>
<input type="hidden" id="q_bkryid">
<input type="hidden" id="m_bkryid">
<input type="hidden" id="m_xb">

<input type="hidden" id="m_ky">
<input type="hidden" id="m_tt">
<input type="hidden" id="m_ajlb">
<input type="hidden" id="m_zjlx">
<input type="hidden" id="y_zjhm">
<input type="hidden" id="t_zjhm">
<!-- 用来存刚进来的时候的身份证号码 -->
<input type="hidden" id="m_gjdm">
<input type="hidden" id="mod_dqsj">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			境外布控人员修改
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#bkry_detail").hideAndRemove(&quot;show&quot;);' class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0">
	<tr>
		<td colspan="6" valign="top">
			<table width="100%" border="0" cellpadding="2" cellspacing="0"
				id="modify">
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<table width="100%" border="0" cellpadding="2" cellspacing="0"
				id="modify2">
				<tr>
					<td width="13%" class="red">
						中文名
					</td>
					<td width="23%" class="detailtd">
						<input type="text" class="inputstyle" id="m_zwm" value="" />
					</td>
					<td width="15%" class="red">
						证件号码
					</td>
					<td width="26%" class="detailtd">
						<input type="text" class="inputstyle" id="m_zjhm" value="" />
					</td>
					<td rowspan="9" colspan="2">
						<table width="35%" border="0" align="center" cellpadding="8"
							cellspacing="0">
							<input type="hidden" id="m_fileload" />
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
					<td class="red">
						出生日期
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_csrq" value="" />
					</td>
					<td class="red">
						性别
					</td>
					<td class="detailtd">
						<select name="m_xbdm" id="m_xbdm" type="select" value="">
							<option></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="red">
						国籍
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_gj" value="" readonly/>
					</td>
					<td class="red">
						证件类型
					</td>
					<td class="detailtd">
						<select name="m_xbdm" id="m_zjlxdm" type="select" value="">
							<option></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="distd">
						英文名
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_ywm" value="" />
					</td>
					<td class="distd">
						英文姓
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_ywx" value="" />
					</td>
				</tr>
				<tr>
					<td class="distd">
						体征
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_tz" readonly />
						<input type="hidden" id="m_tzbm" />
					</td>
					<td class="distd">
						体态
					</td>
					<td class="detailtd">
						<select name="m_ttbm" id="m_ttbm" type="select" value="">
							<option></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="distd">
						衣着
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_yz" value="" />
					</td>
					<td class="distd">
						通报编号
					</td>
					<td class="detailtd">
						<input type="text" readonly="readonly" class="readonly"
							id="m_tbbh" value="" />
					</td>
				</tr>
				<tr>
					<td width="13%" class="distd">
						案件类别
					</td>
					<td width="23%" class="detailtd">
						<select name="m_ajlbbm" id="m_ajlbbm" type="select" value="">
							<option></option>
						</select>
					</td>
					<td width="15%" class="red">
						通报时间
					</td>
					<td width="26%" class="detailtd">
						<input type="text" class="inputstyle" id="m_tbsj" value="" />
					</td>
				</tr>
				<tr>
					<td width="13%" class="red">
						布控终止时间
					</td>
					<td width="23%" class="detailtd">
						<input type="text" class="inputstyle" id="m_bkdqsj" value="" />
					</td>
					<td class="red">
						布控人
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_bkr" value="" />
					</td>
				</tr>
				<tr>
					<td class="distd">
						布控操作员
					</td>
					<td class="detailtd">
						<input type="text" class="readonly" id="m_bkczy" value="" readonly/>
					</td>
					<td class="distd">
						布控操作时间
					</td>
					<td class="detailtd">
						<input type="text" class="readonly" id="m_bkczsj" value="" />
					</td>
				</tr>
				<tr>
					<td width="13%" class="red">
						联系人
					</td>
					<td width="23%" class="detailtd">
						<input type="text" class="inputstyle" id="m_lxr" value="" />
					</td>
					<td width="15%" class="red">
						联系方式
					</td>
					<td width="26%" class="detailtd">
						<input type="text" class="inputstyle" id="m_lxfs" value="" />
					</td>
					<td width="11%" class="red">
						布控范围
					</td>
					<td width="12%" class="detailtd">
						
						<input type="text" class="readonly" id="m_bkfw" value="" readonly/>
						<input type="hidden" id="m_bkfwbm">
					</td>
				</tr>
				<tr>
					<td class="distd">
						身高
					</td>
					<td class="detailtd">
						<input type="text" class="inputstyle" id="m_shengao" value="0" />
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="13%" class="distd">
						发文单位
					</td>
					<td width="87%" colspan="5" class="detailtd">
						<input type="text" readonly="readonly" style="width:630px;"
							class="readonly" id="m_fwdw" value="" />
					</td>
				</tr>
				<tr>
					<td class="red">
						简要案情
					</td>
					<td colspan="5" class="detailtd">
						<textarea name="textarea" id="m_jyaq" style="width:630px;"
							value="" />        
					
					
					
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6" height="8"></td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setUpdate();'>保存</a>
		</td>
	</tr>
</table>
<%@include file="../../public/includeImgerToBase64.jsp" %>