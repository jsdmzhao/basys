<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
//登录用户ID，用于获得菜单
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	String username=user.getUsername();
	
	//qybmAndMc="企业编码,|企业名称";
	String nwwbz=(String)session.getAttribute("nwwbz");
	String qymc="";
	String qybm="";
	if(!"0".equals(nwwbz)){
		String qybmAndMc=(String)session.getAttribute("csbmcsmc");
		//qybmAndMc="企业编码,|企业名称";
		if(qybmAndMc==null){
			qybmAndMc="";
		}
		String m[]=qybmAndMc.split(",\\|");
		if(m!=null&&m.length==2){
			qybm=m[0];
			qymc=m[1];
		}
	}
 %>
<script type="text/javascript">
	var nwwbz="<%=nwwbz %>";
	$(document).ready(function() {
	
	 bc_bottonMoveRight(39); 
	
	
	//GetALine("a_qybm","a_qymc");
	
		
		$("#a_hylbdm").selectBoxhylb();
		if(nwwbz=='1'){
			$('#a_qybm').val('<%=qybm %>');
			$('#a_qymc').val('<%=qymc %>');
		}else if(nwwbz=='0'){
			$("#a_qymc").removeClass("readonly").addClass("inputstyle");
			$("#atd_qymc").removeClass("distd").addClass("red");
			
	 		$("#a_qymc").click(function(){
			 	//判断行业类型选择了没，如果没有选择，需要先选择
				 	dataid=$('#a_hylbdm').val();
				  	getTy_item("a_qymc","a_qybm","1","kcyzx");
			});
		}
		setHyxx_add();
		daggleDiv(detailid);
		$("#a_lcsj").attr("readonly","true");
		$("#a_lcjgjbdm").selectBox({code:"dm_lcjgjb"});
		$("#a_lcjglxdm").selectBox({code:"dm_lcjglx"});
		$("#a_lcjgjb").val($("#a_lcjgjbdm").attr('title'));
		$("#a_lcjglx").val($("#a_lcjglxdm").attr('title'));
		$("#a_lcjgjbdm").change(function(){
			$("#a_lcjgjb").val($("#a_lcjgjbdm").attr('title'));
		});
		$("#a_lcjglxdm").change(function(){
			$("#a_lcjglx").val($("#a_lcjglxdm").attr('title'));
		});
		$("#a_lcsj").datepicker();
	}); 
	
	function GetALine(bmid,mcid){   
		var fso,f,s,ForReading;
		var qybm = "",qymc="";   
		ForReading   =   1,   s   =   "";   
		fso = new ActiveXObject("Scripting.FileSystemObject");   
		f = fso.OpenTextFile("c:\\Program Files\\AERO_INFO\\config.ini", ForReading, false);   
		while(!f.AtEndOfStream){   
		    s=f.ReadLine(); 
		    if(s.indexOf("CSBM")==0){
		       qybm = s;
		    }else if(s.indexOf("CS=")==0){
		       qymc = s;
		    } 
		} 
		f.Close();
		rcjcQybm = qybm.split("=")[1];
		rcjcQymc = qymc.split("=")[1];
		$("#"+bmid).val(rcjcQybm);
		$("#"+mcid).val(rcjcQymc);
	}
	function addVerify(){
		if (!checkControlValue("a_glbmlhjcdjxh","String",1,30,null,0,"管理部门联合检查登记序号"))
			return false;
		if (!checkControlValue("a_lcjgjb","String",1,30,null,1,"联查机构级别"))
			return false;
		if (!checkControlValue("a_lcjglx","String",1,30,null,1,"联查机构类型"))
			return false;
		if (!checkControlValue("a_lcjgmc","String",1,100,null,1,"联查机构名称"))
			return false;
		if (!checkControlValue("a_lcsj","Date",null,null,null,1,"联查时间"))
			return false;
		if (!checkControlValue("a_lcryxm","String",1,300,null,1,"联查人员姓名"))
			return false;
		if (!checkControlValue("a_lcsx","String",1,200,null,1,"联查事项"))
			return false;
		
		if(nwwbz==0){
			if (!checkControlValue("a_qymc","String",1,200,null,1,"企业名称"))
				return false;
		}
		if (!checkControlValue("a_fxwt","String",1,300,null,1,"发现问题"))
			return false;
		if (!checkControlValue("a_lcjg","String",1,200,null,1,"联查结果"))
			return false;
		return true;
	}
	function lhjc_setadd(){
		if (addVerify()){
			setParams("a_");
			jQuery.post(addUrl,params,addback,"json");
		}
	}	

	function setHyxx_add(){
        var hylb=$("#a_hylbdm").attr("value");
		if(hylb=='J'||hylb=='K'){
			$('#atd_qymc').text('场所名称');
		}else{
		    $('#atd_qymc').text('企业名称');
		}
		if(nwwbz=='0'){
			$("#a_qymc").val("");
		}
		
    }
</script>
<input type="hidden" id="a_qybm">
<!--  <input type="hidden" id="a_hylbdm" value='J'>-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#lhjc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	
	<tr height="20">
		<td width='15%' class="distd">管理部门联合检查登记序号</td>
		<td width='30%' class="detailtd"><input type="text" class="readonly" id="a_glbmlhjcdjxh" readonly="readonly" value=""></td>
		<td width='20%' class="distd">联查机构级别</td>
		<td width='35%' class="detailtd">
		<input type="hidden" class="inputstyle" id="a_lcjgjb" value="">
		<select id="a_lcjgjbdm"></select>
		</td>
	</tr>
	<tr height="20">
		<td class="distd">联查机构类型</td>
		<td class="detailtd">
		<input type="hidden" class="inputstyle" id="a_lcjglx" value="">
		<select id="a_lcjglxdm"></select>
		</td>
		<td class="red">联查机构名称</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_lcjgmc" value=""></td>
	</tr>
	<tr height="20">
		
		<td class="red">联查时间</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_lcsj" value=""></td>
		<td class="distd">联查人员姓名</td>
		<td class="detailtd"><input type="text" id="a_lcryxm" value="<%=username %>"></td>
	</tr>
	<tr height="20">
		
		<td class="red">联查事项</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_lcsx" value=""></td>
		<td class="distd" id="atd_qymc">企业名称</td>
		<td class="detailtd"><input type="text" class="readonly" id="a_qymc" value="" readonly="readonly"></td>
	</tr>
	<tr height="20">
		
		<td class="red">行业类别</td>
		<td class="detailtd"><select type="select" id="a_hylbdm"  onchange="setHyxx_add();"></td>
		
	</tr>
	
	<tr height="20">
		<td class="red" valign="top">发现问题</td>
		<td class="detailtd" colspan="3"><textarea id="a_fxwt" cols="51" rows="5"></textarea></td>
	</tr>
	<tr height="20">
		<td class="red" valign="top">联查结果</td>
		<td class="detailtd" colspan="3"><textarea id="a_lcjg" cols="51" rows="5"></textarea></td>
	</tr>
	
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='lhjc_setadd();'>保存</a></td></tr>
</table>