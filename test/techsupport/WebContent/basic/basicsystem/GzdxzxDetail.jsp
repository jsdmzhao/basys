<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_gzdxid").attr("value",dataid);
			setDetail();
	}); 
	function updatediv (json) { 
		$("#xm").append(setNull(json.LGzdx[0].xm));
		$("#bm").append(setNull(json.LGzdx[0].bm));
		$("#minzu").append(setNull(json.LGzdx[0].minzu));
		$("#xb").append(setNull(json.LGzdx[0].xb));
		$("#csrq").append(setNull(json.LGzdx[0].csrq));
		$("#hjdxzqh").append(setNull(json.LGzdx[0].hjdxzqh));
		$("#hjdxz").append(setNull(json.LGzdx[0].hjdxz));
		$("#zjhm").append(setNull(json.LGzdx[0].zjhm))
		$("#whcd").append(setNull(json.LGzdx[0].whcd));
		$("#shengao").append(setNull(json.LGzdx[0].shengao));
		$("#xzdq").append(setNull(json.LGzdx[0].xzdq));
		$("#xzdqxz").append(setNull(json.LGzdx[0].xzdqxz));
		$("#zc").append(setNull(json.LGzdx[0].zc));
		$("#tbdw").append(setNull(json.LGzdx[0].tbdw));
		$("#tbdabm").append(setNull(json.LGzdx[0].tbdabm));
		$("#tbr").append(setNull(json.LGzdx[0].tbr));
		$("#tbrq").append(setNull(json.LGzdx[0].tbrq));
		$("#zxbz").append(setNull(json.LGzdx[0].zxbz));
		$("#bz").append(setNull(json.LGzdx[0].bz));
		$("#lxdh").append(setNull(json.LGzdx[0].lxdh));
		
		$("#m_gzdxid").attr("value",setNull(json.LGzdx[0].gzdxid));
		$("#m_xm").attr("value",setNull(json.LGzdx[0].xm));
	}	
	function modifyVerify(){
		return true;	
	}
	//撤控单写，回调函数的提示不同
	function setZxUpdate(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(modUrl,params,updateZxback,"json"); 
		return true;
	}else{
		return false;
	}		
}
function updateZxback(json){
	if  (json.result=="success"){
		jAlert('注销成功','保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}
</script>
<input type="hidden" id="q_gzdxid">
<input type="hidden" id="m_gzdxid">
<input type="hidden" id="m_zxbz" value="1">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			关注对象注销
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#gzdx_detail").hideAndRemove(&quot;show&quot;);'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="2" cellspacing="0" class="detail" id="detail" >
<tr>
		<td width="20%" class="distd1">
			姓名
		</td>
		<td width="30%" class="detailtd2">
			<span id="xm"></span>
			<input type="hidden" id="m_xm">
		</td>
		<td width="20%" class="distd1">
			身份证号码
		</td>
		<td width="30%" class="detailtd2">
			<span id="zjhm"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			性别
		</td>
		<td class="detailtd2">
			<span id="xb"></span>
		</td>
		<td class="distd1">
			出生日期
		</td>
		<td class="detailtd2">
			<span id="csrq"></span>
		</td>
		
	</tr>
	<tr>
		<td class="distd1">
			民族
		</td>
		<td class="detailtd2">
			<span id="minzu"></span>
		</td>
		<td class="distd1">
			户籍地行政区划
		</td>
		<td class="detailtd2">
			<span id="hjdxzqh"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			别名
		</td>
		<td class="detailtd2">
			<span id="bm"></span>
		</td>
		<td class="distd1">
			文化程度
		</td>
		<td class="detailtd2">
			<span id="whcd"></span>
		</td>
	</tr>
		<td class="distd1">
			户籍地详址
		</td>
		<td colspan="3" class="detailtd2">
			<span style="width:398" id="hjdxz"></span>
		</td>
		
	</tr>
	<tr>
		<td class="distd1">
			现住地区
		</td>
		<td class="detailtd2">
			<span id="xzdq"></span>
		</td>
		<td class="distd1">
			专长
		</td>
		<td class="detailtd2">
			<span id="zc"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			现住地区详址
		</td>
		<td colspan="3" class="detailtd2">
			<span style="width:398" id="xzdqxz"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			身高
		</td>
		<td class="detailtd2">
			<span id="shengao"></span>
		</td>
		<td class="distd1">
			填报人
		</td>
		<td class="detailtd2">
			<span id="tbr"></span>
		</td>
	</tr><tr>
		<td class="distd1">
			联系电话
		</td>
		<td class="detailtd2" colspan="3"><span id="lxdh"></span>	
		</td></tr>
	<tr>
	<tr>
		<td class="distd1">
			填报日期		</td>
		<td class="detailtd2">
			<span id="tbrq"></span>		</td>
		<td class="distd1">
			填报单位编码		</td>
		<td class="detailtd2">
			<span id="tbdabm"></span>		</td>
	</tr>
		<tr>
			<td class="distd">
				填报单位
			</td>
			<td colspan="3" class="detailtd2">
				<span id="tbdw" style="width:410"></span>
			</td>
		</tr>
	<tr>
		<td class="distd1">
			关注原因
		</td>
		<td colspan="3" class="detailtd2">
			<span id="bz"></span>
		</td>
	</tr>
	<tr align="center">
		<td colspan="4" height="8"></td>
	</tr>

	<tr align="center">
		<td colspan="4" align="center">
			<a href="#" id="addbutton" style="width:50px" hidefocus="true"
				class="submitbutton" title="注销" onclick='setZxUpdate()'>注销</a>
		</td>
	</tr>
</table>
