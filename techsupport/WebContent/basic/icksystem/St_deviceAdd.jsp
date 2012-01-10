<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
        bc_bottonMoveRight(12); 
		$("#a_dw_sj").attr("readonly","true");
		$("#a_dw_sj").datepicker();
		$("#a_on_line").attr("readonly","true");
		$("#a_on_line").datepicker();
		$("#a_da_update").attr("readonly","true");
		$("#a_da_update").datepicker();
        $("#a_dev_up").selectBox({code:"dm_wxsbgxzt"});
        
	 
	
        //setParent();//设置所属服务  由于加了行业类别，所以这里不再先去数据库中取值了，因为hylbdm不缺定可能为多个，这样就不存在默认值问题了。

	}).keydown(function(){
		if(event.keyCode == 13)
			event.keyCode = 9;
	});
	function addVerify(){

		if (!checkControlValue("a_dev_name","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("a_dev_ip","String",1,20,null,1,"设备IP"))
			return false;
			if (!checkControlValue("a_mac","String",1,25,null,1,"终端MAC地址"))
			return false;
		if (!checkControlValue("a_dev_password","String",1,20,null,0,"设备连接密码"))
			return false;
		if (!checkControlValue("a_dev_log","String",1,500,null,0,"设备日志"))
			return false;
		if (!checkControlValue("a_dev_devrulezuc","Integer",-9999999999,9999999999,null,0,"常关规则"))
			return false;
		if (!checkControlValue("a_dev_devrulezuo","Integer",-9999999999,9999999999,null,0,"常开规则"))
			return false;
		if (!checkControlValue("a_gly_no","String",1,16,null,0,"管理员编号"))
			return false;

		if (!checkControlValue("a_dev_devrulezul","String",1,100,null,0,"联机，禁用时段设置"))
			return false;
		if (!checkControlValue("a_com","Integer",-999,999,null,0,"连接类型"))
			return false;
		if (!checkControlValue("a_port","Integer",-9999999999,9999999999,null,1,"端口号"))
			return false;
		if (!checkControlValue("a_btl","Integer",-9999999999,9999999999,null,0,"波特率"))
			return false;
		if (!checkControlValue("a_xs","String",1,50,null,0,"终端显示信息"))
			return false;
		if (!checkControlValue("a_gly_psw","String",1,16,null,0,"管理员密码"))
			return false;
				
		if (!checkControlValue("a_dw_sj","Date",null,null,null,0,"档案最近更新时间"))
			return false;
		if (!checkControlValue("a_qymc","String",1,100,null,1,"场所名称"))
			return false;
		if (!checkControlValue("parentName","String",1,100,null,1,"所属服务"))
			return false;
		
		if (!checkControlValue("a_tjkq","Integer",-999,999,null,0,"脱机数据实时存数据库标志"))
			return false;
		if (!checkControlValue("a_on_line","Date",null,null,null,0,"设备最后在线时间"))
			return false;
		if (!checkControlValue("a_run_state","Integer",-9,9,null,0,"设备当前状态"))
			return false;

		if (!checkControlValue("a_da_update","Date",null,null,null,0,"档案变更时间"))
			return false;
		if (!checkControlValue("a_notice_serial","Integer",-9999999999,9999999999,null,0,"协查通报编号"))
			return false;
		if (!checkControlValue("a_dev_cpu","String",1,50,null,0,"设备CPU型号"))
			return false;
		if (!checkControlValue("a_dev_os","String",1,50,null,0,"操作系统版本"))
			return false;
		
		if (!checkControlValue("a_flow_rate","Integer",-9999999999,9999999999,null,0,"本次流量（字节）"))
			return false;
	
	
		if (!checkControlValue("a_max_flow_no","Integer",-9999999999,9999999999,null,0,"本设备采集的最大流水号"))
			return false;
		if (!checkControlValue("a_dev_version","String",1,100,null,0,"本设备内核版本号"))
			return false;
		if (!checkControlValue("a_dev_up","Integer",-9,9,null,0,"设备更新状态"))
			return false;
		
		return true;
	}
	
	
	function addAll(){

	setAdd_cyry();
}
function setAdd_cyry(){

	if (addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addcyryback,"json");
	}else{
		return addVerify();
	}	
}	
//设置所属服务
function setParent(){
 jQuery.post("icksystem/setParentFrist_st_device.action",null,setParentback,"json");
}
function setParentback(json){
if(json.LSt_device.length>0){
	$("#parentName").attr("value",setNull(json.LSt_device[0].dev_name));
	$("#a_parent").attr("value",setNull(json.LSt_device[0].dev_serial));
	}
}

function addcyryback(json){

	if  (json.result=="success"){
		jAlert("添加成功",'提示信息');
		if(!$("#checkbox").attr("checked"))
			$("#"+detailid).hideAndRemove("slow"); 
		else
			clearPartFormElement();
		setPageList($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}



function clearPartFormElement(){
	$("#a_dev_name").val("");
	$("#a_dev_ip").val("");
	$("#a_mac").val("");
	$("#a_port").val("");
	$("#a_qymc").val("");
	$("#parentName").val("");
	
	$("#a_csbm").val("");
	$("#a_qyid").val("");
	$("#a_parent").val("");
	
}

	// 行业类别	
$("#a_hylbdm").selectBoxhylb();

 $("#a_qymc").click(function(){
 	 //dataid="J";//筛选娱乐行业的企业
 	   dataid=$('#a_hylbdm').val();

	getTy_item("a_qymc","a_csbm","a_qyid",null,null);
});

	$("#parentName").click(function(){
	        dataid=$('#a_hylbdm').val();
			getSsfwxh_item("parentName","a_parent");
		});
        
</script>

<input type="hidden" id="a_csbm" />
<input type="hidden" id="a_qyid" />
<input type="hidden" id="a_parent" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">无线终端设备新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#st_device_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>

<table width="100%" id="add">
	<tr height="20">
		<td class="red">设备名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_name" value=""></td>
		<td class="red">设备IP</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_ip" value=""></td>
		<td class="red">终端MAC</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="a_mac" value=""></td>
	</tr>
	<tr height="20">
    	<td class="red">端口号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_port"></td>
		 <td  class="red">行业类别</td>
		<td  class="detailtd"><select  id="a_hylbdm" ></select></td>
		<td class="red">场所名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_qymc" readonly></td>
		
	</tr>
	<tr height="20">
	    <td class="red">所属服务</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="parentName" readonly></td>
    	<td class="distd">管理员编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gly_no" value=""></td>
        <td class="distd">管理员密码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gly_psw" value=""></td>
	
	</tr>
	<tr height="20">
		<td class="distd">设备连接密码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_password" value=""></td>
    	<td class="distd">连接类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_com" value="4"></td>
    	<td class="distd">常关规则</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_devrulezuc" value="0"></td>
		
	</tr>
	<tr height="20">
	    <td class="distd">常开规则</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_devrulezuo" value="0"></td>
	    <td class="distd">联机禁用时段</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_devrulezul" value=""></td>
		<td class="distd">终端显示信息</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xs" value="bh,xm,duty"></td>
       
	</tr>
	<tr height="20">
	    <td class="distd">波特率</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_btl"></td>
		<td class="distd">本次流量（字节）</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_flow_rate" value="0"></td>
		<td class="distd">脱机保存标志</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="a_tjkq" value="0"></td>
		
	</tr>
	<tr height="20">
	   <td class="distd">最大流水号</td>
	    <td class="detailtd"><input type="text" class="inputstyle"  id="a_max_flow_no" value="0"></td>
		<td class="distd">协查通报编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_notice_serial" value="0"></td>
		<td class="distd">档案最近更新时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dw_sj" value=""></td>
	
	</tr>
	<tr height="20">
		<td class="distd">档案变更时间</td>
		<td class="detailtd"><input type="text"  class="inputstyle" id="a_da_update" value=""></td>
		<td class="distd">设备最后在线时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_on_line" value=""></td>
		<td class="distd">操作系统版本</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_os" value="mizilinux"></td>
       
	</tr>
	<tr height="20">
	    <td class="distd">设备CPU型号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_cpu" value=""></td>
		<td class="distd">本设备内核版本号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dev_version" value=""></td>
		<td class="distd">设备当前状态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_run_state" value="0"></td>
	
	</tr>
    	<tr height="20">
    		<td class="distd">设备更新状态</td>
		<td class="detailtd"><select name="select" id="a_dev_up">
		  </select>
		</td>
		<td class="distd">设备日志</td>
		<td class="detailtd" colspan="3"><input type="text" class="inputstyle" id="a_dev_log" value=""></td>
	</tr>
<tr height="25" align="left"><td  colspan="6"><input type="checkbox" name="checkbox" id="checkbox" />
  保存后继续新增</td>
</tr>
<tr height="25" align="center"><td colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='addAll();'>保存</a></td></tr>
</table>