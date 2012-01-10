<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.common.DateToString"%>
<%@ page import="java.util.Date"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	//获取内外网值nwwbz
	String nwwbz=(String)session.getAttribute("nwwbz");
	String currDate = DateToString.getDateTimeEn(new Date());
	//判断如果不是内网，读取企业信息
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
	//是否控制日常检查方式
	String sfkzrcjcfs = QjblUtil.queryQjblVal("sfkzrcjcfs");
%>
 
<script type="text/javascript">
	var currDate = "<%=currDate%>";
	var sfkzrcjcfs = "<%=sfkzrcjcfs%>";
	var nwwbz_jcfs = "<%=nwwbz%>";
	$(document).ready(function() {
	  bc_bottonMoveRight(19,"添加"); 
	  	$("#a_nwwbz").val("<%=nwwbz%>");

		$("#a_hylbdm").selectBoxhylb();//行业类别	
		
		getRidio();
		setGaUserData();
		//isBindClickEvent();
		//GetALine('a_qybm','a_qymc');
		var nwwbz=0;
		setHyxx_add();
		if(nwwbz_jcfs=='1'){
			if(sfkzrcjcfs=='0'){
				$("#a_jcfs").selectBox({code:"dm_jcfs"});
			}else{
				$("#a_jcfs").selectBox({code:"dm_jcfs_qydadd"});
			}
		}else{
			if(sfkzrcjcfs=='0'){
				$("#a_jcfs").selectBox({code:"dm_jcfs"});
			}else{
				$("#a_jcfs").selectBox({code:"dm_jcfs_gadadd"});
			}
		}
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
		if (!checkControlValue("a_hylbdm","Select",1,100,null,1,"行业类别"))
			return false;
		if (!checkControlValue("a_qymc","String",1,100,null,1,"企业名称"))
			return false;
		if (!checkControlValue("a_jcfs","Select",1,20,null,1,"检查方式"))
			return false;
		if (!checkControlValue("a_fxwt","String",1,300,null,1,"发现问题"))
			return false;
		if (!checkControlValue("a_cljg","String",1,2000,null,0,"处理结果"))
			return false;
		if (!checkControlValue("a_jcrzw","String",1,100,null,0,"检查人职务"))
			return false;
		if (!checkControlValue("a_jcrybh","String",1,20,null,0,"警号"))
			return false;
		return true;
	}
	
	function setGaUserData(){
		$("#a_jcrxm").val(userName);
		$("#a_jcrq").val(currDate);
		$("#a_lsdw").val(departname);
		$("#a_jcjgdm").val(departcode);
		$("#a_jcjgmc").val(departname);
		$("#a_hylbdm").change(function(){
			$("#a_hylb").val($(this).attr("title"));
			$("#a_qymc").val('');
			$("#a_qybm").val('');
			$("#a_csfzr").val('');
			$("#a_csfzrbh").val('');
		});
	}
/*	
	该段代码用于填写选择企业名称
	function isBindClickEvent(){
		if(!isGadLogin){	
			$("#a_qybm").val(rcjcQybm);
			$("#a_qymc").val(rcjcQymc);
		}else{
			$("#a_qymc").removeClass("readonly").addClass("inputstyle");
						
	 		$("#a_qymc").click(function(){
		 	//判断行业类型选择了没，如果没有选择，需要先选择
			if (!checkControlValue("a_hylbdm","Select",1,100,null,1,"行业类别")){
			 		return false;
			}else{    ///娱乐业
			 	dataid=$('#a_hylbdm').val();
			  	getTy_item("a_qymc","a_qybm","1");
			}
		});
	}
	}
*/	
	function getRidio(){
		var a=0;
		$('input[@name="sfzdjcjg"]').click(function(){
			a=$(this).val();
			$("#a_sfzdjcjg").val(a);
		});	
	}
	//设定行业信息表示
    function setHyxx_add(){
        var hylb=$("#a_hylbdm").attr("value");
		if(hylb=='J'||hylb=='K'){
			$('#atd_qymc').text('场所名称');
			$('#atd_qybm').text('场所备案编号');
			$('#atd_csfzr').text('场所负责人');
			$('#atd_csfzrbh').text('场所负责人编号');
			nwwbz="<%=nwwbz %>";
		}else{
		    $('#atd_qymc').text('企业名称');
		    $('#atd_qybm').text('企业编号');
		    $('#atd_csfzr').text('企业负责人');
			$('#atd_csfzrbh').text('企业负责人编号');
			nwwbz=0;
		}
		if(nwwbz=='1'){
			$("#a_qymc").removeClass("inputstyle").addClass("readonly");
			$('#a_qybm').val('<%=qybm %>');
			$('#a_qymc').val('<%=qymc %>');
			$("#q_qybm").val('<%=qybm %>');
			setParams("q_");
			if($("#q_qybm").val()!='')
			jQuery.post("<%=request.getContextPath()%>/publicsystem/queryOne_qyjbxx.action",params,updateQyhylb,"json");
		}else if(nwwbz=='0'){
			$("#a_qymc").removeClass("readonly").addClass("inputstyle");
			
	 		$("#a_qymc").click(function(){
	 			
			 	//判断行业类型选择了没，如果没有选择，需要先选择
				if (!checkControlValue("a_hylbdm","Select",1,100,null,1,"行业类别")){
				 		return false;
				}else{    ///娱乐业
				 	dataid=$('#a_hylbdm').val();
				  	getTy_item("a_qymc","a_qybm","","kcyzx");
				}
				$("#a_csfzr").val('');
				$("#a_csfzrbh").val('');
			});
		}
    }

	$('#a_csfzr').click(function(){
		var qybm=$('#a_qybm').val()
		if(qybm!=""){
			getQyry_item("a_csfzr","a_csfzrbh",qybm);
		}else{
			var hylb=$("#a_hylbdm").attr("value");
			if(hylb=='J'){
				jAlert("请先选择场所",'提示信息');
			}else{
				jAlert("请先选择企业",'提示信息');
			}
		}	
	});
   
    $("#a_jcrzw").click(function(){
    	getrylbTree("a_jcrzw","a_zwdm","dm_zw(rcjc)");
    }); 
    function updateQyhylb(json){
    	$("#a_hylbdm").setValue(setNull(json.LQyjbxx[0].hylbdm));
    	$("#a_hylbdm").setAttr("readonly",true);//外网下拉框不可用	2011-1-20ygl
    }
</script>
<input type="hidden" id="a_sfzdjcjg" value="否"/>
<input type="hidden" id="a_jcjgdm" />
<input type="hidden" id="a_jcjgmc" />
<input type="hidden" id="a_zwdm" />
<input type="hidden" id="a_nwwbz"/><!-- 内外网标志 -->
<input type="hidden" id="q_qybm"/>
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">日常检查新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#rcjc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>
</div>
<table width="100%" id="add">
	<tr height="20">
			<td class="red" width="15%" >行业类别</td>
			<td class="detailtd" width="85%" colspan="3"><input type="hidden" id="a_hylb" /><select id="a_hylbdm" onchange="setHyxx_add();"></select></td>
	</tr>
	<tr height="20">
		<td width="15%" class="red" id="atd_qymc">企业名称</td>
		<td width="30%" class="detailtd"  ><input type="text" class="readonly" id="a_qymc"  readonly /></td>
		<td width="21%"  class="distd" width="17%" id="atd_qybm">企业编号</td>
		<td width="34%"  class="detailtd"  width="25%"><input type="text" class="readonly" id="a_qybm" readonly /></td>
	</tr>
	<tr height="20">
		<td class="distd" id="atd_csfzr">企业负责人</td>
		<td class="detailtd" ><input type="text" class="inputstyle" id="a_csfzr" readonly="readonly"/></td>
		<td class="distd" id="atd_csfzrbh">企业负责人编号</td>
		<td class="detailtd" ><input type="text" class="readonly" id="a_csfzrbh" readonly="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="red">检查方式</td>
		<td class="detailtd"><select id="a_jcfs"><option></option></select></td>
		<td class="distd">检查日期</td>
		<td class="detailtd"><input type="text" class="readonly" id="a_jcrq" readonly /></td>
	</tr>
	<tr height="20">
		<td class="distd">检查人员姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_jcrxm" /></td>
		<td class="distd">检查人警号</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_jcrybh" /></td>
	</tr>
	<tr height="20">
		<td class="distd">检查人职务</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_jcrzw" readonly /></td>
		<td class="distd">检查机构</td>
		<td class="detailtd" ><input type="text"  class="readonly" readonly id="a_lsdw" /></td>
	</tr>
	<tr height="20">
		<td class="distd">检查事项</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_jcsx" /></td>
		<td class="distd">是否知道检查结果</td>
		<td class="detailtd"><input type="radio" name="sfzdjcjg" value="是" />是   <input type="radio" name="sfzdjcjg" value="否" checked="true"/>否</td>
	</tr>
	<tr height="20">
		<td class="red" valign="top">发现问题</td>
		<td class="detailtd" colspan="3"><textarea id="a_fxwt" style="width:429" rows="5"></textarea></td>
	</tr>
	<tr height="20">
		<td class="distd" valign="top">处理结果</td>
		<td class="detailtd" colspan="3"><textarea id="a_cljg" style="width:429" rows="5"></textarea></td>
	</tr>
	<tr height="20">
		<td class="distd" valign="top">备注</td>
		<td class="detailtd" colspan="3"><textarea id="a_bz" style="width:429" rows="5"></textarea></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" class="addbutton"  onclick='setAdd();' >添加</a></td></tr>
</table>
