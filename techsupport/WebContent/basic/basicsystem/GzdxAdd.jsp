<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	//登录用户
	int userid = 0;
	String userName ="";
	String userDeptCode = "";
	String userDeptName ="";
	
	User user = new User();
	//获得登录用户session
	user = (User)session.getAttribute(Constants.userKey);
	if(user == null)
		response.sendRedirect("login.jsp");
	else
		userid = user.getUserid().intValue();
		userName = user.getUsername();
		userDeptCode = user.getDepartment().getDepartcode();
		userDeptName = user.getDepartment().getDepartname();
 %>
<script type="text/javascript">
var canCommit=false;
	$(document).ready(function() {
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_tbrq").attr("readonly","true");
		$("#a_tbrq").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);
		$("#a_zxrq").attr("readonly","true");
		$("#a_zxrq").datepicker();
		//$("#a_xb").attr("readonly","true");现在是可改的了
		$("#a_xbdm").selectBox({code:"dm_xb"});
		 $("#a_hylbdm").selectBoxhylb();//行业类别	
		
		 $("#a_minzu").click(function(){
			getDict_item("a_minzu","a_mzdm","dm_mz");
			});
		 $("#a_hjdxzqh").click(function(){
			getDict_item4("a_hjdxzqh","a_hjdxzqhdm","dm_xzqh");
			});
		$("#a_xzdq").click(function(){
			getDict_item4("a_xzdq","a_xzdqbm","dm_xzqh");
			});
			
			$("#a_whcd").click(function(){
			getDict_item("a_whcd","a_whcdbm","dm_whcd");
			});
			
			$("#a_zc").click(function(){
			getDict_item("a_zc","a_zcbm","dm_zc");
			});
			
		$("#a_zjhm").blur(function(){//当填写身份证号码失去焦点后，去判断身份证号码
		//如果身份证证号填写不为15或18位，则直接返回让他重新填写
		var zjhm = $("#a_zjhm").attr("value");
		  if(!isIdCardNo(zjhm))
		  {
		  $("#a_zjhm").val("");//清空
		  //$("#a_zjhm").focus();//得到焦点
		 // alert("请输入15位或18位的身份证号码");
		    return false;
		  }
		  
		//证件号码就用用户自己填写的，如15位的不在去转换为18位
		$("#a_zjhm").val(zjhm);
		$("#y_zjhm").val(zjhm);
		//根据证件号码去查看数据库此证件号是否已经存在，如果存在，则给出提示，并重新填写
		valadateCode(zjhm);
		if(!canCommit){
			$("#a_zjhm").val("");//清空,不在得到焦点
			return false;
		}
		
		//传入一个身份证号码，得到性别跟出生日期
		$("#a_xbdm").setValue(getXb(zjhm));
		$("#a_csrq").val(getBirthday(zjhm));
		getHjsxDD($(this).val(),"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
		});
	}); 
	function addVerify(){
		if (!checkControlValue("a_gzdxid","Integer",-9999999999,9999999999,null,0,"序号"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,1,"姓名"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("a_xbdm","Select",1,2,null,1,"性别"))
			return false;
		if (!checkControlValue("a_hylbdm","Select",1,20,null,1,"行业类别"))
			return false;	
		if (!checkControlValue("a_csrq","Date",null,null,null,1,"出生日期"))
			return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,0,"户籍地划"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,1,"证件号码"))
			return false;
		if (!checkControlValue("a_whcd","Select",1,60,null,0,"文化程度"))
			return false;
		if (!checkControlValue("a_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("a_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("a_xzdqxz","String",1,2000,null,0,"现住地区祥址"))
			return false;
		if (!checkControlValue("a_zc","Select",1,100,null,0,"专长"))
			return false;
		if (!checkControlValue("a_tbdw","String",1,100,null,0,"填报单位"))
			return false;
		if (!checkControlValue("a_tbdabm","String",1,100,null,0,"填报单位编码"))
			return false;
		if (!checkControlValue("a_tbr","String",1,100,null,0,"填报人"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,100,null,1,"联系电话"))
			return false;
		if (!checkControlValue("a_tbrq","Date",null,null,null,0,"填报日期"))
			return false;
			if (!checkControlValue("a_bz","String",1,4000,null,1,"关注原因"))
			return false;
		$("#a_xb").val($("#a_xbdm").attr("title"));
		$("#a_hylb").val($("#a_hylbdm").attr("title"));
		return true;
	}
	//去空格函数
	function   String.prototype.Trim()   
  {  
  return   this.replace(/^\s*/g,"").replace(/\s*$/g,"");   
  }
  function valadateCode(zjhm){ //验证代码
		setParams("y_");
		var sUrl="basicsystem/validateZjhm_gzdx.action";
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
				jAlert('此身份证号码是全国在逃人员已经被关注!','验证信息');
				canCommit=false;
			}else if(json.strResult=="0"){
			    jAlert('此身份证号码已经被关注!','验证信息');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			canCommit=false;
		}
	}
</script>
<input type="hidden" id="q_gzdxid" />
<input type="hidden" id="a_gzdxid" value=1>
<input type="hidden" id="a_xb" />
<input type="hidden" id="a_hylb" />
<input type="hidden" id="y_zjhm" />
<input type="hidden" id="a_zxbz" value="0" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			关注对象添加
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#gzdx_detail").hideAndRemove(&quot;show&quot;);'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" id="add" border="0">
	<tr>
		<td width="24%" class="red">
			姓名		</td>
  <td width="26%" class="detailtd">
    <input type="text" class="inputstyle" id="a_xm" />
		</td>
  <td width="18%" class="red">
			身份证号码		</td>
  <td width="32%" class="detailtd">
    <input type="text" class="inputstyle" id="a_zjhm" />
		</td>
  </tr>
	<tr>
		<td class="red">
			性别
		</td>
		<td class="pagetd">
			<select id="a_xbdm">
				<option></option>
			</select>
		</td>
		<td class="red">
			出生日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_csrq" />
		</td>
	</tr>
	<tr>
		<td class="pagedistd">
			民族
		</td>
		<td class="pagetd">
			<input type="text" class="inputstyle" id="a_minzu" readonly />
			<input type="hidden" id="a_mzdm" />
		</td>
		<td class="distd">
			户籍地行政区划
		</td>
		<td class="pagetd">
			<input type="text" class="inputstyle" id="a_hjdxzqh" readonly />
			<input type="hidden" id="a_hjdxzqhdm" />
		</td>
	</tr>
	<tr>
		<td class="distd">
			别名
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_bm" />
		</td>
		<td class="distd">
			文化程度
		</td>
		<td class="detailtd">
	<input type="text" id="a_whcd" class="inputstyle" readonly><input type="hidden" id="a_whcdbm" />
		</td>
	</tr>
	<tr>
		<td class="distd">
			现住地区
		</td>
		<td class="pagetd">
			<input type="text" class="inputstyle"  id="a_xzdq" readonly />
			<input type="hidden" id="a_xzdqbm" />
		</td>
		<td class="distd">
			专长
		</td>
		<td class="detailtd">
			<input type="text" id="a_zc" class="inputstyle" readonly />
<input type="hidden" id="a_zcbm">
		</td>
	</tr>
	<tr>
		<td class="distd">
			户籍地详址
		</td>
		<td colspan="3" class="detailtd">
			<input type="text" class="inputstyle3"  style="width:410"  id="a_hjdxz" />
		</td>
	</tr>
	<tr>
		<td class="distd">
			现住地区详址
		</td>
		<td colspan="3" class="detailtd">
			<input type="text" class="inputstyle3"  style="width:410"  id="a_xzdqxz" />
		</td>
	</tr>
	<tr>
		<td class="distd">
			身高
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  id="a_shengao" />
		</td>
		<td class="distd">
			填报人
		</td>
		<td class="detailtd">
			<input type="text"  readonly="readonly" class="readonly" id="a_tbr"
				value="<%=userName %>" />
		</td>
	</tr>
	<tr>
		<td class="red">
			联系电话
		</td>
		<td class="detailtd" colspan="3">
			<input type="text" class="inputstyle"  id="a_lxdh" />&emsp;(可写多个联系电话，以","分割)
		</td>
	</tr>
	<tr>
		<td class="distd">
			填报日期
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="a_tbrq" />
		</td>
		<td class="distd">
			填报单位编码
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="a_tbdabm"
				value="<%=userDeptCode %>" />
		</td>
	</tr>
	<tr>
		<td class="distd">
			填报单位
		</td>
		<td colspan="3" class="detailtd">
			<input type="text" class="readonly" id="a_tbdw" style="width:410"
				value="<%=userDeptName %>" />
		</td>
	</tr>
	<tr>
		<td class="red">
			关注原因
		</td>
		<td colspan="3" class="detailtd">
			<textarea name="textarea" id="a_bz" style="width:410"></textarea>
		</td>
	</tr>
	<tr>
		<td class="red">
			行业类别
		</td>
		<td class="detailtd">
			<select id="a_hylbdm">
				
			</select>
		</td>
		<td class="red">&nbsp;
			
		</td>
		<td class="detailtd">&nbsp;
			
		</td>
	</tr>
	<tr align="center">
		<td colspan="4" height="8"></td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setAdd();'>保存</a>
		</td>
	</tr>
</table>
