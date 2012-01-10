<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_dev_serial").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#dev_serial").append(setNull(json.LSt_device[0].dev_serial));
		$("#dev_name").append(setNull(json.LSt_device[0].dev_name));
		$("#dev_ip").append(setNull(json.LSt_device[0].dev_ip));
		$("#dev_password").append(setNull(json.LSt_device[0].dev_password));
		$("#dev_log").append(setNull(json.LSt_device[0].dev_log));
		$("#dev_devrulezuc").append(setNull(json.LSt_device[0].dev_devrulezuc));
		$("#dev_devrulezuo").append(setNull(json.LSt_device[0].dev_devrulezuo));
		$("#gly_no").append(setNull(json.LSt_device[0].gly_no));
		$("#dev_update").append(setNull(json.LSt_device[0].dev_update));
		$("#dev_devrulezul").append(setNull(json.LSt_device[0].dev_devrulezul));
		$("#com").append(setNull(json.LSt_device[0].com));
		$("#port").append(setNull(json.LSt_device[0].port));
		$("#btl").append(setNull(json.LSt_device[0].btl));
		$("#xs").append(setNull(json.LSt_device[0].xs));
		$("#gly_psw").append(setNull(json.LSt_device[0].gly_psw));
		$("#dw_sj").append(setNull(json.LSt_device[0].dw_sj));
		$("#parent").append(setNull(json.LSt_device[0].parentName));
		$("#mac").append(setNull(json.LSt_device[0].mac));
		$("#tjkq").append(setNull(json.LSt_device[0].tjkq));
		$("#on_line").append(setNull(json.LSt_device[0].on_line));
		$("#run_state").append(setNull(json.LSt_device[0].run_state));
	
		$("#da_update").append(setNull(json.LSt_device[0].da_update));
		$("#notice_serial").append(setNull(json.LSt_device[0].notice_serial));
		$("#dev_cpu").append(setNull(json.LSt_device[0].dev_cpu));
		$("#dev_os").append(setNull(json.LSt_device[0].dev_os));
		$("#flow_rate").append(setNull(json.LSt_device[0].flow_rate));
		$("#csbm").append(setNull(json.LSt_device[0].qymc));
		$("#savetime").append(setNull(json.LSt_device[0].savetime));
		$("#max_flow_no").append(setNull(json.LSt_device[0].max_flow_no));
		$("#dev_version").append(setNull(json.LSt_device[0].dev_version));
		$("#dev_up").append(setNull(json.LSt_device[0].dev_upName));
		$("#hylb").append(setNull(json.LSt_device[0].hylb));
	}	
</script>
<input type="hidden" id="q_dev_serial">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">无线终端设备明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#st_device_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
	<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td width="12%" class="distd1">设备名称</td>
	  <td width="21%" class="detailtd2"><span   id="dev_name"  ></span></td>
	  <td width="12%" class="distd1">设备IP</td>
	  <td width="24%" class="detailtd2"><span  id="dev_ip"  ></span></td>
	  <td width="10%" class="distd1">终端MAC</td>
      <td width="21%" class="detailtd2"><span  id="mac"  ></span></td>
	</tr>
	<tr height="20">
    	<td class="distd1">端口号</td>
		<td class="detailtd2"><span  id="port"></span></td>
		<td class="distd1">行业类别</td>
		<td class="detailtd2"><span  id="hylb"></span></td>
		<td class="distd1">场所名称</td>
		<td class="detailtd2"><span  id="csbm"></span></td>
		
	</tr>
	<tr height="20">
	   <td class="distd1">所属服务</td>
		<td class="detailtd2"><span  id="parent"></span></td>
    	<td class="distd1">管理员编号</td>
		<td class="detailtd2"><span  id="gly_no"  ></span></td>
        <td class="distd1">管理员密码</td>
		<td class="detailtd2"><span  id="gly_psw"  ></span></td>
		
	</tr>
	<tr height="20">
	    <td class="distd1">设备连接密码</td>
		<td class="detailtd2"><span  id="dev_password"  ></span></td>
    	<td class="distd1">连接类型</td>
		<td class="detailtd2"><span  id="com"></td>
    	<td class="distd1">常关规则</td>
		<td class="detailtd2"><span  id="dev_devrulezuc" ></span></td>
		
	</tr>
	<tr height="20">
	    <td class="distd1">常开规则</td>
		<td class="detailtd2"><span  id="dev_devrulezuo" ></span></td>
	    <td class="distd1">联机禁用时段</td>
	    <td class="detailtd2"><span  id="dev_devrulezul"  ></span></td>
		<td class="distd1">终端显示信息</td>
		<td class="detailtd2"><span  id="xs" value="bh,xm,duty"></span></td>
     
	</tr>
	<tr height="20">
	   <td class="distd1">波特率</td>
		<td class="detailtd2"><span  id="btl"></span></td>
		<td class="distd1">本次流量（字节）</td>
		<td class="detailtd2"><span  id="flow_rate" ></span></td>
		<td class="distd1">脱机保存标志</td>
	    <td class="detailtd2"><span  id="tjkq" ></span></td>
		
	</tr>
	<tr height="20">
	<td class="distd1">最大流水号</td>
	    <td class="detailtd2"><span  id="max_flow_no" ></span></td>
		<td class="distd1">协查通报编号</td>
		<td class="detailtd2"><span  id="notice_serial" ></span></td>
		<td class="distd1">档案最近更新时间</td>
		<td class="detailtd2"><span  id="dw_sj"  ></span></td>
		
	</tr>
	<tr height="20">
	<td class="distd1">档案变更时间</td>
		<td class="detailtd2"><span  id="da_update"  ></span></td>
		<td class="distd1">设备最后在线时间</td>
		<td class="detailtd2"><span  id="on_line"  ></span></td>
		<td class="distd1">操作系统版本</td>
		<td class="detailtd2"><span  id="dev_os" ></span></td>
       
	</tr>
	<tr height="20">
	 <td class="distd1">设备CPU型号</td>
		<td class="detailtd2"><span  id="dev_cpu"  ></span></td>
		<td class="distd1">本设备内核版本号</td>
		<td class="detailtd2"><span  id="dev_version"  ></span></td>
		<td class="distd1">设备当前状态</td>
		<td class="detailtd2"><span  id="run_state" ></span></td>
	
	</tr>
    	<tr height="20">
    		<td class="distd1">设备更新状态</td>
		<td class="detailtd2"><span id="dev_up"></span>
		</td>
		<td class="distd1">设备日志</td>
		<td class="detailtd2" ><span  id="dev_log"  ></span></td>
		<td class="distd1">保存时间</td>
		<td class="detailtd2" ><span  id="savetime"  ></span></td>
		
	</tr>
	 	<tr height="20">
	    <td class="distd1">设备更新时间</td>
		<td class="detailtd2" ><span  id="dev_update"  ></span></td>
	</tr>
</table>