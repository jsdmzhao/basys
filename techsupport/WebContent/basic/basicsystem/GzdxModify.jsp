<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_gzdxid").attr("value",dataid);
		$("#m_gzdxid").attr("value",dataid);
		$("#y_gzdxid").attr("value",dataid);
		setDetail();
		$("#m_csrq").attr("readonly","true");
		//$("#m_xb").attr("readonly","true");现在是可改的了
		$("#m_xbdm").selectBox({code:"dm_xb"});
		$("#m_csrq").datepicker();//根据身份证号码出来了
		$("#m_tbrq").attr("readonly","true");
		$("#m_tbrq").datepicker();
		
		$("#m_minzu").click(function(){
			getDict_item("m_minzu","m_mzdm","dm_mz");
			});
		 $("#m_hjdxzqh").click(function(){
			getDict_item("m_hjdxzqh","m_hjdxzqhdm","dm_xzqh");
			});
		$("#m_xzdq").click(function(){
			getDict_item("m_xzdq","m_xzdqbm","dm_xzqh");
			});
			
			$("#m_whcd").click(function(){
			getDict_item("m_whcd","m_whcdbm","dm_whcd");
			});
			
			$("#m_zc").click(function(){
			getDict_item("m_zc","m_zcbm","dm_zc");
			});
		
		$("#m_zjhm").blur(function(){//当填写身份证号码失去焦点后，去判断身份证号码
		//如果身份证证号填写不为15或18位，则直接返回让他重新填写
		var zjhm = $("#m_zjhm").attr("value");
		  if(!isIdCardNo(zjhm))
		  {
		  $("#m_zjhm").val("");//清空
		  //$("#m_zjhm").focus();//得到焦点
		 // alert("请输入15位或18位的身份证号码");
		    return false;
		  }
		  
		//证件号码就用用户自己填写的，如15位的不在去转换为18位
		$("#m_zjhm").val(zjhm);
		$("#y_zjhm").val(zjhm);
		//根据证件号码去查看数据库此证件号是否已经存在，如果存在，则给出提示，并重新填写
		valadateCode(zjhm);
		if(!canCommit){
			$("#m_zjhm").val("");//清空,不在得到焦点
			return false;
		}
		
		//传入一个身份证号码，得到性别跟出生日期
		$("#m_xbdm").setValue(getXb(zjhm));
		$("#m_csrq").val(getBirthday(zjhm));
		});
			
	}); 
	function updatediv (json) { 
		$("#m_gzdxid").val(setNull(json.LGzdx[0].gzdxid));
		$("#m_xm").val(setNull(json.LGzdx[0].xm));
		$("#m_bm").val(setNull(json.LGzdx[0].bm));
		$("#m_minzu").val(setNull(json.LGzdx[0].minzu));
		$("#m_xb").val(setNull(json.LGzdx[0].xb));
		$("#m_csrq").val(setNull(json.LGzdx[0].csrq));
		$("#m_hjdxzqh").val(setNull(json.LGzdx[0].hjdxzqh));
		$("#m_hjdxz").val(setNull(json.LGzdx[0].hjdxz));
		$("#m_zjhm").val(setNull(json.LGzdx[0].zjhm));
		$("#m_whcd").val(setNull(json.LGzdx[0].whcd));
		$("#m_shengao").val(setNull(json.LGzdx[0].shengao));
		$("#m_xzdq").val(setNull(json.LGzdx[0].xzdq));
		$("#m_xzdqxz").val(setNull(json.LGzdx[0].xzdqxz));
		$("#m_zc").val(setNull(json.LGzdx[0].zc));
		$("#m_tbdw").val(setNull(json.LGzdx[0].tbdw));
		$("#m_tbdabm").val(setNull(json.LGzdx[0].tbdabm));
		$("#m_tbr").val(setNull(json.LGzdx[0].tbr));
		$("#m_tbrq").val(setNull(json.LGzdx[0].tbrq));
		$("#m_bz").val(setNull(json.LGzdx[0].bz));
		$("#m_xbdm").setValue(setNull(json.LGzdx[0].xbdm));
		$("#m_zcbm").val(setNull(json.LGzdx[0].zcbm));
		$("#m_whcdbm").val(setNull(json.LGzdx[0].whcdbm));
		$("#m_lxdh").val(setNull(json.LGzdx[0].lxdh));
			
		$("#m_mzdm").val(setNull(json.LGzdx[0].mzdm));	
		$("#m_hjdxzqhdm").val(setNull(json.LGzdx[0].hjdxzqhdm));	
		$("#m_xzdqbm").val(setNull(json.LGzdx[0].xzdqbm));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_gzdxid","Integer",-9999999999,9999999999,null,0,"序号"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,1,"姓名"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("m_xbdm","Select",1,2,null,1,"性别"))
			return false;
		
		if (!checkControlValue("m_csrq","Date",null,null,null,1,"出生日期"))
			return false;
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,0,"户籍地划"))
			return false;
		if (!checkControlValue("m_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,1,"证件号码"))
			return false;
		if (!checkControlValue("m_whcd","Select",1,60,null,0,"文化程度"))
			return false;
		if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("m_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("m_xzdqxz","String",1,2000,null,0,"现住地区详址"))
			return false;
		if (!checkControlValue("m_zc","Select",1,100,null,0,"专长"))
			return false;
		if (!checkControlValue("m_tbdw","String",1,100,null,0,"填报单位"))
			return false;
		if (!checkControlValue("m_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,100,null,1,"联系电话"))
			return false;
		if (!checkControlValue("m_tbrq","Date",null,null,null,0,"填报日期"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,1,"关注原因"))
			return false;
		$("#m_xb").val($("#m_xbdm").attr("title"));
		return true;
	}
	function setChildWhcd(){
		$("#m_whcd").val("");
	}
	function setChildZc(){
		$("#m_zc").val("");
	}
	function setChildXb(){
		$("#m_xb").val("");
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
<input type="hidden" id="q_gzdxid">
<input type="hidden" id="m_gzdxid">
<input type="hidden" id="m_xb">
<input type="hidden" id="y_zjhm">
<input type="hidden" id="y_gzdxid">
<input type="hidden" id="m_mzdm">
<input type="hidden" id="m_hjdxzqhdm">
<input type="hidden" id="m_xzdqbm">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			关注对象修改
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#gzdx_detail").hideAndRemove(&quot;show&quot;);' class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" id="modify">
		<tr>
			<td width="29%" class="red">
				姓名
			</td>
			<td width="27%" class="detailtd">
				<input type="text" class="inputstyle" id="m_xm" value="">
			</td>
			<td width="17%" class="red">
				身份证号码
			</td>
			<td width="27%" class="detailtd">
				<input type="text" class="inputstyle" id="m_zjhm" value="" />
			</td>
		</tr>
		<tr>
			<td class="red">
				性别
			</td>
			<td class="detailtd">
				<select type="select" id="m_xbdm" value="" onchange="setChildXb();">
					<option></option>
				</select>
			</td>
			<td class="red">
				出生日期
			</td>
			<td class="detailtd">
				<input type="text" class="inputstyle" id="m_csrq" value="" />
			</td>

		</tr>
		<tr>
			<td class="distd">
				民族
			</td>
			<td class="detailtd">
				<input type="text" class="inputstyle" id="m_minzu" readonly/>
			</td>
			<td class="distd">
				户籍地行政区划
			</td>
			<td class="detailtd">
				<input type="text" class="inputstyle" id="m_hjdxzqh" readonly />
			</td>
		</tr>
		<tr>
			<td class="distd">
				别名
			</td>
			<td class="detailtd">
				<input type="text" class="inputstyle" id="m_bm" value="" />
			</td>
			<td class="distd">
				文化程度
			</td>
			<td class="detailtd">
	<input type="text" id="m_whcd" class="inputstyle" readonly><input type="hidden" id="m_whcdbm" />
			</td>
		</tr>
		<tr>
			<td class="distd">
				现住地区
			</td>
			<td class="detailtd">
				<input type="text" class="inputstyle" id="m_xzdq" value="" />
			</td>
			<td class="distd">
				专长
			</td>
			<td class="detailtd">
			<input type="text" id="m_zc" class="inputstyle" readonly />
<input type="hidden" id="m_zcbm">
			</td>
		</tr>
		<tr>
			<td class="distd">
				户籍地详址
			</td>
			<td colspan="3" class="detailtd">
				<input type="text" class="inputstyle3" style="width:410"
					id="m_hjdxz" value="" />
			</td>
		</tr>
		<tr>
			<td class="distd">
				现住地区详址
			</td>
			<td colspan="3" class="detailtd">
				<input class="inputstyle3" style="width:410" type="text"
					id="m_xzdqxz" value="" />
			</td>
		</tr>
		<tr>
			<td class="distd">
				身高
			</td>
			<td class="detailtd">
				<input type="text" class="inputstyle" id="m_shengao" value="" />
			</td>
			<td class="distd">
				填报人
			</td>
			<td class="detailtd">
				<input type="text" readonly="readonly" class="readonly" id="m_tbr"
					value="" />
			</td>
		</tr>
	<tr>
		<td class="red">
			联系电话
		</td>
		<td class="detailtd" colspan="3">
			<input type="text" class="inputstyle3" style="width:230"  id="m_lxdh" />&emsp;(可写多个联系电话，以","分割)
		</td>
	</tr>
		<tr>
			<td class="distd">
				填报日期
			</td>
			<td class="detailtd">
				<input type="text" readonly="readonly" class="readonly" id="m_tbrq"
					value="" />
			</td>
			<td class="distd">
				填报单位编码
			</td>
			<td class="detailtd">
				<input type="text" readonly="readonly" class="readonly" id="m_tbdabm" />
			</td>
		</tr>
		<tr>
			<td class="distd">
				填报单位
			</td>
			<td colspan="3" class="detailtd">
				<input type="text" readonly="readonly" class="readonly" id="m_tbdw" style="width:410" />
			</td>
		</tr>
		<tr>
			<td class="red">
				关注原因
			</td>
			<td colspan="3" class="detailtd">
				<textarea name="textarea" id="m_bz" style="width:410" value="" /></textarea>
			</td>
		</tr>
		<tr align="center">
			<td colspan="4">
				<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
					title="保存" onclick='setUpdate();'>保存</a>
			</td>
		</tr>
	</table>