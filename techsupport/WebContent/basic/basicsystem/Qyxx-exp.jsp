<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String qysjlyyScpt = QjblUtil.queryQjblVal("qysjlyyScpt"); //企业数据来源于社采平台
%>
<html>
<head>
<script type="text/javascript">
	var expfilename = "";
	var expfinish = false;
	var qyxxio_dataid="";
	var qyxxio_tables = "";
	var qyxxio_pageUrl="basicsystem/querylistExp_expimp.action";
	var qyxxio_divnid="tabledata";
	var qyxxio_tableid="table1";
	var qysjlyyScpt = '<%=qysjlyyScpt %>';
	var tijiaoKg = 0;
	$(document).ready(function() {
		qyxxio_loadPage("tabledata");
		$("#manbq_hylb").selectBox({code:"dm_hylb"});
		$("#manbq_dcbs").selectBox({code:"dm_dcbs"});
		$("#p_gxdwmc").click(function(){ //管辖单位
			getGxdwTree("p_gxdwmc","p_gxdwbm");
		});
		$("#p_cxtjDcsj").attr("readonly","true").datepicker();
		manhylbOnchange();
		mandcbsOnchange();
	});
	function manhylbOnchange(){ //行业类别
		var key = $("#manbq_hylb").attr("value");
		$("#p_hylbdm").attr("value",key);
	}
	function mandcbsOnchange(){ //导出标识
		var key = $("#manbq_dcbs").attr("value");
		$("#p_cxtjDcbs").attr("value",key);
		if(key=='1'){ //已导出
			$("#dcsj_title")[0].style.display='block';
			$("#p_cxtjDcsj")[0].style.display='block';
		} else {
			$("#dcsj_title")[0].style.display='none';
			$("#p_cxtjDcsj")[0].style.display='none';
		}
		if(key=='2'||qysjlyyScpt=='0'){ //已导入 ||qysjlyyScpt=='0'
			$("#alldc").hide(); $("#bufendc").hide();
			$("#buttable").attr("width","62");
		} else {
			$("#alldc").show(); $("#bufendc").show();
			$("#buttable").attr("width","186");
		}
	}
	function qyxxio_setPageList(pageno,url){
		delAlltempList();
			url=qyxxio_setList(pageno,url);
			var mygrid1 = $("#"+qyxxio_tableid).ingrid({ 
											url: url,
											ingridPageParams:sXML,
											height: pageHeight-230,
											pageNumber: pageno,
											onRowSelect: null,
											sorting: false,
											ingridComplete:function(){
												tijiaosel();
											},
											colWidths: ["3%","10%","27%","8%","10%","22%","20%"]
										});
	}
	function tijiaosel(){
		tijiaoKg==0;
		var gridTijiaoArr = $("#grid").find("input[id^='tijiao_']");
		gridTijiaoArr.each(function(){
			var thisid = $(this).attr("id").replace("tijiao_","");
			if(ishavetempList(thisid)){
				$(this).attr("checked","checked")
			}
		});
		if(gridTijiaoArr.length>0){
			$("#checkAll").attr("checked",isSelAll()); //判断是否全选
		}
		if(expfinish){ //点击保存生产XML
			playexpxml();
			expfinish = false;
		}
	}
	function qyxxio_loadPage(divpageid){
		qyxxio_tables=$("#"+divpageid).html();
		qyxxio_setPageList(1,'#');
	}
	function qyxxio_setList(pageno,url){
		$("#"+qyxxio_divnid).html(qyxxio_tables);	
		createXML("p_");
		if (url==null || url=="undefined"){
			url=qyxxio_pageUrl;
		}
		return url;
	}
	function qyxxio_setPageList_cx(){
		if(tijiaoKg==0){
			if (!checkControlValue("manbq_hylb","Select",1,30,null,1,"行业类别"))
				return false;
			if (!checkControlValue("manbq_dcbs","Select",1,30,null,1,"导出标识"))
				return false;
			qyxxio_setPageList(1);
		}
	}
	//checkbox用到开始
	function cstjCheck(obj){
		sFlag = "false";
		var thisid = $(obj).attr("id").replace("tijiao_","");
		var checks = $(obj).attr("checked");
		if(checks){
			addtotempList(thisid);
		} else {
			deltotempList(thisid);
		}
		$("#checkAll").attr("checked",isSelAll()); //判断是否全选
	}
	
	function isSelAll(){
		var resultCheck = true;
		$("#grid").find("input[id^='tijiao_']").each(function(){
			var checks = $(this).attr("checked");
			if(!checks){
				resultCheck = false;
				return;
			}
		});
		return resultCheck;
	}
	function quanxuan(obj){
		var checkState = $(obj).attr("checked");
		$("#grid").find("input[id^='tijiao_']").each(function(){
			var checks = $(this).attr("checked");
			if(checks!=checkState){
				$(this).attr("checked",checkState)
				var thisid = $(this).attr("id").replace("tijiao_","");
				if(checkState) addtotempList(thisid);
				else deltotempList(thisid);
			}
		});
	}
		
	function addtotempList(csid){
		var objOption = "<option value='"+csid+"'>"+csid+"</option>";
		$("#tempylcstj").append($(objOption));
	}
	function deltotempList(csid){
		var result = "";
		$("#tempylcstj option").each(function(){
			if($(this).attr("value")==csid){
				$(this).remove();
				return false;
			}
		});
		return result;
	}
	function ishavetempList(csid){
		var ishava = false;
		$("#tempylcstj option").each(function(){
			if($(this).attr("value")==csid){
				ishava = true;
				return false;
			}
		});
		return ishava;
	}
	function delAlltempList(){
		$("#tempylcstj option").each(function(){
			$(this).remove();
		});
	}
	//checkbox用到结束
	
	var bftjUrl = "basicsystem/bufenExp_expimp.action";
	function bufendc(){
		if("0"==qysjlyyScpt){ jAlert("当前状态不能导出企业信息，提示信息待定","提示"); return; }
		if(tijiaoKg==0){
			var result = "";
			$("#tempylcstj option").each(function(){
				result += $(this).attr("value")+",";
			});
			if(""==result){ jAlert("请选择企业","提示"); return; }
			jAlert("正在导出数据,请耐心等待","提示");
			tijiaoKg==1;
			$("#p_selQyid").attr("value",result);
			setParams("p_");
			jQuery.ajax({
				type: 'POST',
				url: bftjUrl,
				data: params,
				async: true,
				dataType: 'json',
				success: function(result){
					var rows  = eval(result);
					tijiaoback(rows);
				}
			});
		}
	}
	var alltjUrl = "basicsystem/quanbuExp_expimp.action";
	function allDaochu(){
		if("0"==qysjlyyScpt){ jAlert("当前状态不能导出企业信息","提示"); return; }
		if(tijiaoKg==0){
			jConfirm('导出过程中可能需要一些时间，请耐心等待', '提示', function(r) {
		    	if(r==true){
		    		jAlert("正在导出数据,请耐心等待","提示");
		    		tijiaoKg==1;
					setParams("p_");
					jQuery.ajax({
						type: 'POST',
						url: alltjUrl,
						data: params,
						async: true,
						dataType: 'json',
						success: function(result){						
							var rows  = eval(result);
							tijiaoback(rows);
						}
					});
				}else{
				   return false;
				}
			});
		}
	}
	function tijiaoback(json){
		tijiaoKg=0;
		if(json.result=="success"){
			isPlayChengGong = true;
			jAlert("导出成功，请选择保存文件。",'提示信息');
			qyxxio_setPageList_cx($("#pageNo").attr("value"));
			expfinish = true;
			expfilename = json.expFileName;
		}else{
			jAlert("请重试",'错误信息');
		}
	}
	function playexpxml(){
		var expxml = "basicsystem/resExpXml_expimp.action";
		document.forms[0].action=expxml;
		document.forms[0].submit();
	}
</script>

</head>
<body>
<input type="hidden" id="p_gxdwbm"/>
<input type="hidden" id="p_hylbdm"/>
<input type="hidden" id="p_cxtjDcbs"/>

<input type="hidden" id="p_selQyid" value="">
<select id="tempylcstj" style="DISPLAY:none"></select>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr><td class="queryfont">导出企业信息<br>
	<a></a>
	</td></tr>
	<tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="8%" class="pagedistd">行业类别</td>
			<td width="17%" class="pagetd"><select name="select" id="manbq_hylb" onChange="manhylbOnchange();"></select></td>
			<td width="8%" class="pagedistd">企业名称</td>
			<td width="17%" class="pagetd"><input type="text" class="inputstyle"  id="p_qymc"></td>
			<td width="8%" class="pagedistd">企业编号</td>
			<td width="17%" class="pagetd"><input type="text" class="inputstyle"  id="p_qybm"></td>
			<td width="8%" class="pagedistd">管辖单位</td>
			<td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdwmc" readonly></td>
		</tr>
		<tr>
			<td class="pagedistd">导出标识</td>
			<td class="pagetd"><select name="select" id="manbq_dcbs" onChange="mandcbsOnchange();"></select></td>
			<td class="pagedistd"><label id="dcsj_title" style="display:none">导出时间</label></td>
			<td class="pagetd"><input type="text" class="inputstyle" id="p_cxtjDcsj" style="display:none"></td>
			<td colspan="4">
				<table width="186" border="0" align="right" cellpadding="0" cellspacing="0" id="buttable">
				<tr>
					<td><a href="#" class="searchbutton" id="querys" onClick="qyxxio_setPageList_cx();">查询</a></td>
					<td><a href="#" class="submitlongbutton" id="alldc" onclick='allDaochu();'>全部导出</a></td>
					<td><a href="#" class="submitbutton" id="bufendc" onclick='bufendc();'>选择导出</a></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
    </td>
	</tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th>&nbsp;<input type='checkbox' id='checkAll' onclick='quanxuan(this)'/></th>
	     	<th>企业编码</th>
	     	<th>企业名称</th>
	     	<th>法人</th>
	     	<th>联系电话</th>
	     	<th>地址</th>
	     	<th>派出所名称</th>
	    </tr>
	  </thead>
	</table>
</div>
<form method="POST">
</form>
</body>
</html>