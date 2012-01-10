<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
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
	
	
%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/javascript/dictDropDown.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_cfrq").attr("readonly","true");
		$("#a_cfrq").datepicker();
		$("#a_djsj").attr("readonly","true");
		//$("#a_djsj").datepicker();
		$("#a_hylbdm").selectBoxhylb();//行业类别	
		
		//$("#a_cfjgdm").selectBox({code:"dm_cljg"});
		$("#a_cfjgdm").selectBox({state:"dm_cljg"});
		
		$("#a_djsj").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);
		changehylb();
	}); 
	
	
	function addVerify(){
		if (!checkControlValue("a_qycfid","Integer",-9999999999,9999999999,null,0,"处罚ID"))
			return false;//自动生成的，不在检测
		if (!checkControlValue("a_hylbdm","Select",1,100,null,1,"行业类别"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_qymc","String",1,200,null,1,"企业名称"))
			return false;
		if (!checkControlValue("a_ssdwbm","String",1,20,null,0,"所属单位编码"))
			return false;
		if (!checkControlValue("a_ssdwmc","String",1,100,null,0,"所属单位名称"))
			return false;
		if (!checkControlValue("a_wgqkms","String",1,2000,null,1,"处罚原因"))
			return false;
		if (!checkControlValue("a_cfjgdm","Select",1,2000,null,1,"处罚结果"))
			return false;
		if (!checkControlValue("a_cfzxrxm","String",1,100,null,1,"处罚人"))
			return false;
		if (!checkControlValue("a_cfrq","Date",null,null,null,0,"处罚日期"))
			return false;
		//判断处罚日期不能大于今天
		if(!compare_now($("#a_cfrq").attr("value"),"DATE")){
			jAlert('处罚日期不能大于今天!','验证信息');
			//$("#a_cfrq").attr("value","");//清空
			return false;
		}
		if (!checkControlValue("a_djsj","Date",null,null,null,0,"登记时间"))
			return false;
		if (!checkControlValue("a_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		$("#a_cfjg").val($("#a_cfjgdm").attr("title"));	
		$("#a_hylb").val($("#a_hylbdm").attr("title"));	
		
		//给MAN页面的行业类别赋值
		$("#p_hylb").setValue($("#a_hylbdm").attr("value"));
		return true;
	}
	
	//服务场所筛选框
 $("#a_qymc").click(function(){
 //判断行业类型选择了没，如果没有选择，需要先选择
	 if($("#a_hylbdm").attr("value")==null || $("#a_hylbdm").attr("value").length ==0 ){
	 	jAlert('请先选择行业类型!','验证信息');
	 	return false;
	 }else if($("#a_hylbdm").attr("value") == "J")    ///娱乐业
	  getYlcs_item("a_qymc","a_qybm","1");
	else if($("#a_hylbdm").attr("value") == "A"){ //旅馆业
	  getLg_item("a_qymc","a_qybm","1");
	
	}else if($("#a_hylbdm").attr("value") == "C"){ //机修业
	  
	  //getLg_item("a_qymc","a_qybm","1");   ///需要机修的控件
	  getQY_item("a_qymc","a_qybm","1","<%=deptCode%>");
	  
	}else if($("#a_hylbdm").attr("value") == "B"){ //印章业
	   getYzQy_item("a_qymc","","a_qybm");
	   
	}else if($("#a_hylbdm").attr("value") == "E03"){ //典当业
        getDdqy_item("a_qymc","a_qybm","qybm");            
	}else if($("#a_hylbdm").attr("value") == "C01"){ //机动车拆解
		dataid=$('#a_hylbdm').val();
        getTy_item("a_qymc","a_qybm","","",$("#a_ssdwbm").attr("value"));         
	}
});
   
   ////检查行业类别
    function checkhylb(){
      if($("#a_hylbdm").attr("value")==null || $("#a_hylbdm").attr("value").length ==0 ){
 	  jAlert('请先选择行业类型!','验证信息');
 	  return false;
 	 } 
    }
    
    function changehylb(){
      if($("#a_hylbdm").attr("value")==null || $("#a_hylbdm").attr("value").length ==0 ){
        $("#a_cfjgdm").selectBox({clear:"1"});
      
      }else if($("#a_hylbdm").attr("value") == "B"){//印章业
       
       $("#a_cfjgdm").selectBox({code:"dm_qycflb(jxy)"});
      }else if($("#a_hylbdm").attr("value") == "C"){ //机修业 
      
        $("#a_cfjgdm").selectBox({code:"dm_qycflb(jxy)"});
      }else{
        $("#a_cfjgdm").selectBox({code:"dm_cljg"});
      }
    }
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			企业处罚添加
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#qycf_detail").hideAndRemove(&quot;show&quot;);' class="close"> </a>
		</td>
	</tr>
</table>
<input type="hidden" id="a_qybm">
<input type="hidden" id="a_cfjg">
<input type="hidden" id="a_hylb">
<input type="hidden" id="a_qycfid" value="1">
<input type="hidden" id="a_ssdwbm" value="<%=deptCode %>">
<input type="hidden" id="a_cflb" value="处罚">
<input type="hidden" id="a_cflbbm" value="1">
<table width="100%" cellpadding="2" cellspacing="0" bordercolor="0" id="add">

	<tr>
		<td width="18%" class="distd">
			处罚日期		</td>
  <td width="34%" class="detailtd">
	  <input type="text" class="inputstyle"  id="a_cfrq" value="">
	  </td>
<td width="14%" class="red">
			行业类别		</td>
  <td width="34%" class="detailtd">
<select type="select" id="a_hylbdm" onchange="changehylb();">
				
			</select>
	  </td>
  </tr>
  <tr>
		<td class="red">
			企业名称
		</td>
		<td colspan="3" class="detailtd">
			<input type="text"   readonly="readonly" class="readonly" id="a_qymc"
				style="width:415px;" value="">
		</td>
	</tr>
	<tr>
		<td class="red">
			处罚人
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  id="a_cfzxrxm" value="">
		</td>
		<td class="red">
			处罚结果
		</td>
		<td class="detailtd" onclick="checkhylb();">
			<select type="select" id="a_cfjgdm" value="" >
				<option></option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="distd">
			登记人
		</td>
		<td class="detailtd">
			<input type="text"  readonly="readonly" class="readonly" id="a_djr"
				value="<%=userName %>">
		</td>
		<td class="distd">
			登记时间
		</td>
		<td class="detailtd">
			<input type="text"   readonly="readonly" class="readonly" id="a_djsj"
				value="">
		</td>
	</tr>
	<tr>
		<td class="distd">
			所属单位名称
		</td>
		<td class="detailtd" colspan="3">
			<input type="text"  readonly="readonly" class="readonly" id="a_ssdwmc"
				value="<%=deptName %>">
		</td>
	</tr>
	<tr>
		<td class="red">
			处罚原因
		</td>
		<td colspan="3" class="detailtd">
			<textarea name="textarea" id="a_wgqkms" style="width:410px;"></textarea>
		</td>
	</tr>
	<tr>
		<td class="distd">
			备注
		</td>
		<td colspan="3" class="detailtd">
			<textarea name="textarea" id="a_bz" style="width:410px;"></textarea>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6" height="8"></td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setAdd();'>保存</a>
		</td>
	</tr>
</table>
