<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(12); 
		$("#q_dev_serial").attr("value",dataid);
		$("#m_dev_serial").attr("value",dataid);
		setDetail();
		$("#m_dw_sj").attr("readonly","true");
		$("#m_dw_sj").datepicker();
		$("#m_on_line").attr("readonly","true");
		$("#m_on_line").datepicker();
		$("#m_da_update").attr("readonly","true");
		$("#m_da_update").datepicker();
        $("#m_dev_up").selectBox({code:"dm_wxsbgxzt"});
	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	});
	function updatediv (json) { 
		$("#m_dev_serial").attr("value",setNull(json.LSt_device[0].dev_serial));
		$("#m_dev_name").attr("value",setNull(json.LSt_device[0].dev_name));
		$("#m_dev_ip").attr("value",setNull(json.LSt_device[0].dev_ip));
		$("#m_dev_password").attr("value",setNull(json.LSt_device[0].dev_password));
		$("#m_dev_log").attr("value",setNull(json.LSt_device[0].dev_log));
		$("#m_dev_devrulezuc").attr("value",setNull(json.LSt_device[0].dev_devrulezuc));
		$("#m_dev_devrulezuo").attr("value",setNull(json.LSt_device[0].dev_devrulezuo));
		$("#m_gly_no").attr("value",setNull(json.LSt_device[0].gly_no));
		$("#m_dev_update").attr("value",setNull(json.LSt_device[0].dev_update));
		$("#m_dev_devrulezul").attr("value",setNull(json.LSt_device[0].dev_devrulezul));
		$("#m_com").attr("value",setNull(json.LSt_device[0].com));
		$("#m_port").attr("value",setNull(json.LSt_device[0].port));
		$("#m_btl").attr("value",setNull(json.LSt_device[0].btl));
		$("#m_xs").attr("value",setNull(json.LSt_device[0].xs));
		$("#m_gly_psw").attr("value",setNull(json.LSt_device[0].gly_psw));
		$("#m_dw_sj").attr("value",setNull(json.LSt_device[0].dw_sj));
		$("#m_parent").attr("value",setNull(json.LSt_device[0].parent));
		$("#m_mac").attr("value",setNull(json.LSt_device[0].mac));
		$("#m_tjkq").attr("value",setNull(json.LSt_device[0].tjkq));
		$("#m_on_line").attr("value",setNull(json.LSt_device[0].on_line));
		$("#m_run_state").attr("value",setNull(json.LSt_device[0].run_state));

		$("#m_da_update").attr("value",setNull(json.LSt_device[0].da_update));
		$("#m_notice_serial").attr("value",setNull(json.LSt_device[0].notice_serial));
		$("#m_dev_cpu").attr("value",setNull(json.LSt_device[0].dev_cpu));
		$("#m_dev_os").attr("value",setNull(json.LSt_device[0].dev_os));
		$("#m_flow_rate").attr("value",setNull(json.LSt_device[0].flow_rate));
		$("#m_csbm").attr("value",setNull(json.LSt_device[0].csbm));
		$("#m_savetime").attr("value",setNull(json.LSt_device[0].savetime));
		$("#m_max_flow_no").attr("value",setNull(json.LSt_device[0].max_flow_no));
		$("#m_dev_version").attr("value",setNull(json.LSt_device[0].dev_version));
		
		$("#m_dev_up").setValue(setNull(json.LSt_device[0].dev_up));
		
		$("#m_qyid").attr("value",setNull(json.LSt_device[0].qyid));
		$("#parentName").attr("value",setNull(json.LSt_device[0].parentName));
		$("#m_qymc").attr("value",setNull(json.LSt_device[0].qymc));
		
		$("#m_hylbdm").setValue(setNull(json.LSt_device[0].hylbdm));
			
			
	}	
	function modifyVerify(){
	
	
		if (!checkControlValue("m_dev_name","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("m_dev_ip","String",1,20,null,1,"设备IP"))
			return false;
		if (!checkControlValue("m_mac","String",1,25,null,1,"终端MAC地址"))
			return false;
		if (!checkControlValue("m_dev_password","String",1,20,null,0,"设备连接密码"))
			return false;
		if (!checkControlValue("m_dev_log","String",1,500,null,0,"设备日志"))
			return false;
		if (!checkControlValue("m_dev_devrulezuc","Integer",-9999999999,9999999999,null,0,"常关规则"))
			return false;
		if (!checkControlValue("m_dev_devrulezuo","Integer",-9999999999,9999999999,null,0,"常开规则"))
			return false;
		if (!checkControlValue("m_gly_no","String",1,16,null,0,"管理员编号"))
			return false;
		
		if (!checkControlValue("m_dev_devrulezul","String",1,100,null,0,"联机，禁用时段设置"))
			return false;
		if (!checkControlValue("m_com","Integer",-999,999,null,0,"连接类型"))
			return false;
		if (!checkControlValue("m_port","Integer",-9999999999,9999999999,null,1,"端口号"))
			return false;
		if (!checkControlValue("m_btl","Integer",-9999999999,9999999999,null,0,"波特率"))
			return false;
		if (!checkControlValue("m_xs","String",1,50,null,0,"终端显示信息"))
			return false;
		if (!checkControlValue("m_gly_psw","String",1,16,null,0,"管理员密码"))
			return false;
		if (!checkControlValue("m_dw_sj","Date",null,null,null,0,"档案最近更新时间"))
			return false;
			
		if (!checkControlValue("m_qymc","String",1,100,null,1,"场所名称"))
			return false;
			
		if (!checkControlValue("parentName","String",1,100,null,1,"所属服务"))
			return false;
	
		if (!checkControlValue("m_tjkq","Integer",-999,999,null,0,"脱机数据实时存数据库标志"))
			return false;
		if (!checkControlValue("m_on_line","Date",null,null,null,0,"设备最后在线时间"))
			return false;
		if (!checkControlValue("m_run_state","Integer",-9,9,null,0,"设备当前状态"))
			return false;

		if (!checkControlValue("m_da_update","Date",null,null,null,0,"档案变更时间"))
			return false;
		if (!checkControlValue("m_notice_serial","Integer",-9999999999,9999999999,null,0,"协查通报编号"))
			return false;
		if (!checkControlValue("m_dev_cpu","String",1,50,null,0,"设备CPU型号"))
			return false;
		if (!checkControlValue("m_dev_os","String",1,50,null,0,"操作系统版本"))
			return false;
		if (!checkControlValue("m_flow_rate","Integer",-9999999999,9999999999,null,0,"本次流量（字节）"))
			return false;
		
	
		if (!checkControlValue("m_max_flow_no","Integer",-9999999999,9999999999,null,0,"本设备采集的最大流水号"))
			return false;
		if (!checkControlValue("m_dev_version","String",1,100,null,0,"本设备内核版本号"))
			return false;
		if (!checkControlValue("m_dev_up","Integer",-9,9,null,0,"设备更新状态"))
			return false;
			
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"场所id"))
			return false;
			
		return true;
	}
	
	
		// 行业类别	
$("#m_hylbdm").selectBoxhylb();
	
	 $("#m_qymc").click(function(){
 //dataid="J";//筛选娱乐行业的企业
 	   dataid=$('#m_hylbdm').val();
	getTy_item("m_qymc","m_csbm","m_qyid",null,null);
	
});


 $("#parentName").click(function(){
   dataid=$('#m_hylbdm').val();
	getSsfwxh_item("parentName","m_parent");
});
</script>
<input type="hidden" id="q_dev_serial">
<input type="hidden" id="m_dev_serial">
<input type="hidden" id="m_csbm" />
<input type="hidden" id="m_qyid" />
<input type="hidden" id="m_parent" />
<input type="hidden" id="t_parents" value="d" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">无线终端设备修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#st_device_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>

<table width="100%" id="add">
	<tr height="20">
		<td class="red">设备名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_name" value=""></td>
		<td class="red">设备IP</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_ip" value=""></td>
		<td class="red">终端MAC</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="m_mac" value=""></td>
	</tr>
	<tr height="20">
    	<td class="red">端口号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_port"></td>
		 <td  class="red">行业类别</td>
		<td  class="detailtd"><select  id="m_hylbdm" ></select></td>
		<td class="red">场所名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_qymc" readonly></td>
		
	</tr>
	<tr height="20">
	  <td class="red">所属服务</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="parentName" readonly></td>
    	<td class="distd">管理员编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gly_no" value=""></td>
        <td class="distd">管理员密码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gly_psw" value=""></td>
		
	</tr>
	<tr height="20">
	    <td class="distd">设备连接密码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_password" value=""></td>
    	<td class="distd">连接类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_com" value="4"></td>
    	<td class="distd">常关规则</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_devrulezuc" value="0"></td>
		
	</tr>
	<tr height="20">
	    <td class="distd">常开规则</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_devrulezuo" value="0"></td>
	    <td class="distd">联机禁用时段</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_devrulezul" value=""></td>
		<td class="distd">终端显示信息</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xs" value="bh,xm,duty"></td>
        
	</tr>
	<tr height="20">
	    <td class="distd">波特率</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_btl"></td>
		<td class="distd">本次流量（字节）</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_flow_rate" value="0"></td>
		<td class="distd">脱机保存标志</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="m_tjkq" value="0"></td>
		
	</tr>
	<tr height="20">
    	<td class="distd">最大流水号</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="m_max_flow_no" value="0"></td>
		<td class="distd">协查通报编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_notice_serial" value="0"></td>
		<td class="distd">档案最近更新时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dw_sj" value=""></td>
	
	</tr>
	<tr height="20">
		<td class="distd">档案变更时间</td>
		<td class="detailtd"><input type="text"  class="inputstyle" id="m_da_update" value=""></td>
		<td class="distd">设备最后在线时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_on_line" value=""></td>
		<td class="distd">操作系统版本</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_os" value="mizilinux"></td>
      
	</tr>
	<tr height="20">
	    <td class="distd">设备CPU型号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_cpu" value=""></td>
		<td class="distd">本设备内核版本号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_version" value=""></td>
		<td class="distd">设备当前状态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_run_state" value="0"></td>
		
	</tr>
    	<tr height="20">
    	<td class="distd">设备更新状态</td>
		<td class="detailtd"><select name="select" id="m_dev_up">
		  </select>
		</td>
		<td class="distd">设备日志</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dev_log" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>