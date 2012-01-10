<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
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
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");
	String currDate = sdf.format(new Date());
%>
<script type="text/javascript">
	var currDate = "<%=currDate%>";
	$(document).ready(function() {
		bc_bottonMoveRight(8); //将保存按钮右移
		$("#a_fasj").attr("readonly","true");
		$("#a_fasj").datepicker(true);
		$("#a_larq").attr("readonly","true");
		$("#a_larq").datepicker();
		$("#a_parq").attr("readonly","true");
		$("#a_parq").datepicker();
		
		$("#a_ajlbdm").selectBox({code:"dm_ajlx"});
		$("#a_ajxzdm").selectBox({code:"dm_ajxz"});
		$("#a_ajlydm").selectBox({code:"dm_ajly"});
		$("#a_hylbdm").selectBoxhylb();//行业类别		
		$("#a_qyzrdm").selectBox({code:"dm_cszr"});
		$("#a_fasjjt").attr("value",currDate+"23:59:59");
		$("#a_dqsj").attr("value",currDate);
		
		if($("#a_hylbdm").attr("value") == "N"){ //内保行业使用
			$("#a_djsj").attr("class","readonly");
		}else{
			$("#a_djsj").attr("readonly","true");
			$("#a_djsj").datepicker();
		}
		//$("#a_qyryjsdm").selectBox({code:"dm_cyrylb"}); ////企业人员角色
		$("#a_qyryjsdm").selectBox({state:"dm_cyrylb"});
		hy_lbselectBox($("#a_hylbdm").attr("value"),"a_qyryjsdm");
		$("#a_djsj").val(currDate);
		setHyxx_add();
	}); 
	function addVerify(){
		$("#a_ajlb").val($("#a_ajlbdm").attr("title"));	
		$("#a_ajxz").val($("#a_ajxzdm").attr("title"));	
		$("#a_ajly").val($("#a_ajlydm").attr("title"));	
		$("#a_qyzr").val($("#a_qyzrdm").attr("title"));	
		$("#a_qyryjs").val($("#a_qyryjsdm").attr("title"));	
		$("#a_hylb").val($("#a_hylbdm").attr("title"));
		if (!checkControlValue("a_hylbdm","Select",1,4,null,1,"行业类别"))
			return false;
		if (!checkControlValue("a_qymc","String",1,200,null,1,"企业名称"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		//判断发案日期不能大于今天
		if (!checkControlValue("a_fasj","Datetime",null,null,null,1,"发案时间"))
			return false;
		if (!checkDateEarlier("a_fasj","发案时间","a_fasjjt","当天时间","DATETIME"))
			return false;
		//判断发案日期结束
		
		if (!checkControlValue("a_ajxzdm","Select",1,60,null,1,"案件性质"))
			return false;
		if (!checkControlValue("a_ajlbdm","Select",1,60,null,1,"案件类别"))
			return false;
		if (!checkControlValue("a_ajbh","String",1,60,null,0,"案件编号"))
			return false;
		if (!checkControlValue("a_ssdwmc","String",1,100,null,1,"治安管辖机构"))
			return false;
		if (!checkControlValue("a_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("a_djsj","Datetime",null,null,null,0,"登记时间"))
			return false;
		if (!checkControlValue("a_ladw","String",1,100,null,1,"立案单位"))
			return false;
		//判断立案日期，立案日期不能小于发案日期
		if (!checkControlValue("a_larq","Datetime",null,null,null,1,"立案日期"))
			return false;
		if (!checkDateEarlier("a_larq","立案日期","a_dqsj","当天时间","DATE"))
			return false;
		if (!checkDateEarlier("a_fasj","发案时间","a_larq","立案日期","DatetimeAndDate"))
			return false;	
		//这个判断要在破案日期填写了的情况下,去检验这个时间的先后,不为空，返回true
		if(checkIsNotEmpty($("#a_parq").attr("value"))){
			if (!checkDateEarlier("a_parq","破案日期","a_dqsj","当天时间","DATE"))
				return false;
			//判断破案日期，破案日期不能小于发案日期
			if (!checkDateEarlier("a_fasj","发案日期","a_parq","破案日期","DatetimeAndDate"))
				return false;
			//判断破案日期不能小于立案日期
			if (!checkDateEarlier("a_larq","立案日期","a_parq","破案日期","DATE"))
				return false;	
		}
		
			
			//给MAN页面的行业类别赋值
		$("#p_hylbdm").setValue($("#a_hylbdm").attr("value"));
		
		return true;
	}
	
		//服务场所筛选框
 $("#a_qymc").click(function(){
 //判断行业类型选择了没，如果没有选择，需要先选择
	 if($("#a_hylbdm").attr("value")==null || $("#a_hylbdm").attr("value").length ==0 ){
	 	jAlert('请先选择行业类型!','验证信息');
	 	return false;
	 }
	
  if($("#a_hylbdm").attr("value") == "J"){  //娱乐业
   		dataid=$('#a_hylbdm').val();
   		getTy_item("a_qymc","a_qybm","","kcyzx");
        //getTy_item("a_qymc","a_qybm"); 
		//getYlcs_item("a_qymc","a_qybm");
  }else if($("#a_hylbdm").attr("value") == "A"){ //旅馆业
		//getLg_item("a_qymc","a_qybm","1");
		getLg_item("a_qymc","a_qybm","","kcyzx");
  }else if($("#a_hylbdm").attr("value") == "E03"){ //典当业
        getDdqy_item("a_qymc","a_qybm","qybm");            
  }else if($("#a_hylbdm").attr("value") == "B"){ //印章业  cuicui
  
        getYzQy_item("a_qymc","","a_qybm");
  }else{
        ////公共平台企业表
        dataid=$('#a_hylbdm').val();
        //getTy_item("a_qymc","a_qybm"); 
        getTy_item("a_qymc","a_qybm","","kcyzx");
  }
  
  
});
//管辖单位所筛选框
	 $("#a_ssdwmc").click(function(){
		//getGxdwTree("a_ssdwmc","a_ssdwbm","1");
		getGxdwTree("a_ssdwmc",null,"a_ssdwbm",null,null,null,null,null);
	});
	 $("#a_ladw").click(function(){
		//getGxdwTree("a_ladw","a_ladwbm","1");
		getGxdwTree("a_ladw",null,"a_ladwbm",null,null,null,null,null);
	});
	
	
	///根据行业类别清空角色
	function qyjsChange(){
	  
	   if($("#a_hylbdm").attr("value")==null || $("#a_hylbdm").attr("value").length ==0 ){
	    $("#a_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	   }else{
	    $("#a_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	     hy_lbselectBox($("#a_hylbdm").attr("value"),"a_qyryjsdm");
	   }
	   $("#a_qymc").val("");
	   $("#a_qybm").val("");
	  
	  /**
	  if($("#a_hylbdm").attr("value")==null || $("#a_hylbdm").attr("value").length ==0 ){
	    $("#a_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	  }else if($("#a_hylbdm").attr("value") == "J"){
	     $("#a_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	     $("#a_qyryjsdm").selectBox({code:"dm_cyrylb"});
	  }else if($("#a_hylbdm").attr("value") == "A"){
	     $("#a_qyryjsdm").selectBox({clear:"1"});////清空下拉框 dm_lgyrylb
	     $("#a_qyryjsdm").selectBox({code:"dm_lgyrylb"});
	  }else if($("#a_hylbdm").attr("value") == "E"){
	     $("#a_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	     $("#a_qyryjsdm").selectBox({code:"dm_ddyrylb"});
	  }else if($("#a_hylbdm").attr("value") == "B"){ //印章业  cuicui
	     $("#a_qyryjsdm").selectBox({code:"dm_yzyrylb"});////清空下拉框
	  }
	  **/
	  if($("#a_hylbdm").attr("value") == "N"){ //内保单位		
		$("#a_djsj").attr("class","readonly");
	  }else{
		$("#a_djsj").attr("readonly","true");
		$("#a_djsj").datepicker();
	  }
	  setHyxx_add();
	}
	
	 $("#qyryjsdmTd").click(function(){
	 	if($("#a_hylbdm").val()==null || $("#a_hylbdm").val()=="")
	 		jAlert('请先选择行业类型!','验证信息');
	 });
	 //设定行业信息表示
    function setHyxx_add(){
        var hylb=$("#a_hylbdm").attr("value");
		if(hylb=='J'||hylb=='K'){
			$('#atd_qymc').text('场所名称');
			$('#atd_qybm').text('场所备案编号');
			$('#atd_qyzr').text('场所责任');
			$('#atd_qyryjs').text('场所/人员角色');
			$('#ajbh_title').show();
		    $('#ajbh_conte').show();
		}else{
		    $('#atd_qymc').text('企业名称');
		    $('#atd_qybm').text('企业编号');
		    $('#atd_qyzr').text('企业责任');
			$('#atd_qyryjs').text('企业/人员角色');
		    $('#ajbh_title').hide();
		    $('#ajbh_conte').hide();
		}
    }
</script>
<input type="hidden" id="a_ajlb" />
<input type="hidden" id="a_ajxz" />
<input type="hidden" id="a_ajly" />
<input type="hidden" id="a_qyzr" />
<input type="hidden" id="a_qyryjs" />
<input type="hidden" id="a_hylb" />
<input type="hidden" id="a_ssdwbm" />
<input type="hidden" id="a_ladwbm" />
<input type="hidden" id="a_djdwmc" value="<%=deptName %>"/>
<input type="hidden" id="a_djdwbm" value="<%=deptCode %>"/>
<input type="hidden" id="a_fasjjt" />
<input type="hidden" id="a_dqsj" />

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			场所发案情况添加
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#asjgl_detail").hideAndRemove(&quot;show&quot;);'class="close"> </a>
		</td>
	</tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td width="15%" class="red">
			行业类别		</td>
  <td width="34%" class="detailtd">
   
		<select type="select" id="a_hylbdm" onchange="qyjsChange();"></select>
	  </td>
<td width="17%" class="red" id="atd_qymc">
				企业名称		</td>
<td width="34%" class="detailtd">
  <input type="text" class="inputstyle" readonly="readonly"  id="a_qymc"
				value="">
		</td>
  </tr>
  
  <tr height="20">
	<td width="15%" class="red" id="atd_qybm">企业代码</td>
    <td width="34%" class="detailtd"><input type="text" id="a_qybm"  readonly="readonly" class="readonly" /></td>
    <td width="17%" class="distd" id="ajbh_title">案件编号</td>
    <td width="34%" class="detailtd" id="ajbh_conte"><input type="text" id="a_ajbh" class="inputstyle"/></td>
  </tr>
  
	<tr height="20">
		<td class="distd">
			案件来源
		</td>
		<td class="detailtd">
			<select type="select" id="a_ajlydm">
				<option></option>
			</select>
		</td>
		<td class="red">
			发案时间
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  id="a_fasj" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			案件性质
		</td>
		<td class="detailtd">
			<select type="select" id="a_ajxzdm">
				<option></option>
			</select>
		</td>
		<td class="red">
			案件类别
		</td>
		<td class="detailtd">
			<select type="select" id="a_ajlbdm">
				<option></option>
			</select>
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			治安管辖机构
		</td>
		<td class="detailtd">
			<input type="text"  readonly="readonly"  id="a_ssdwmc" class="inputstyle"
				value="">
		</td>
		<td class="distd">
			登记人
		</td>
		<td class="detailtd">
			<input type="text"  readonly="readonly" class="readonly" id="a_djr"
				value="<%=userName %>">
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			登记时间
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  readonly="readonly" id="a_djsj" value="">
		</td>
		<td class="red">
			立案单位
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  id="a_ladw" value="" readonly="readonly">
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			立案日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  id="a_larq" value="">
		</td>
		<td class="distd">
			破案日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  id="a_parq" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="distd" id="atd_qyzr">
			企业责任
		</td>
		<td class="detailtd">
			<select type="select" id="a_qyzrdm" value="">
				<option></option>
			</select>
		</td>
		<td class="distd" id="atd_qyryjs">
			企业/人员角色
		</td>
		<td class="detailtd" id="qyryjsdmTd">
			<select id="a_qyryjsdm">
				<option></option>
			</select>
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			情况描述
		</td>
		<td colspan="3" class="detailtd">
			<textarea name="textarea" id="a_qkms" style="width:425px" rows="5"></textarea>
		</td>
	<tr align="center">
		<td colspan="4">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setAdd();'>保存</a>
		</td>
	</tr>
</table>
