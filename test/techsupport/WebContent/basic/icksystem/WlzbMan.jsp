<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var dataid;
	var chakanFlag = 0;
	var wldj_detailidLeftOffset = 0;
	var wldj_detailidTopOffset = 0;
	$(document).ready(function() {
		pageUrl="icksystem/querylistWlzb_wldj.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="icksystem/insert_wldj.action";
		addHtml="basic/icksystem/WldjAdd.jsp";
		addWidth="900";
		delUrl="icksystem/delete_wldj.action";
		delid="d_wlid";
		modHtml="basic/icksystem/WldjModify.jsp";
		modUrl="icksystem/modifyWlzb_wldj.action";
		modWidth="500";
		detailHtml="basic/icksystem/WldjDetail.jsp";
		detailid="wldj_detail";
		detailUrl="icksystem/query_wldj.action";
		detailWidth="600";
		delUrl="icksystem/wlzbDell_wldj.action";
		sendUrl="icksystem/wlzbSend_wldj.action";
		loadPage("tabledata");
		$("#p_zbsj").attr("readonly","true");
		$("#p_zbsj").datepicker();
		$("#p_fksj").attr("readonly","true");
		$("#p_fksj").datepicker();
		$("#p_fssj").attr("readonly","true");
		$("#p_fssj").datepicker();
		$("#p_jssj").attr("readonly","true");
		$("#p_jssj").datepicker();
		$("#p_jssjt").attr("readonly","true");
		$("#p_jssjt").datepicker();
			
		$("#bq_zjlx").selectBox({code:"dm_rycyzj"});
		$("#bq_ztdm").selectBox({code:"dm_wlzt"});
	   
		daggleDiv("wldj_detail");
	}); 
	
	function setPageList(pageno,url){
		if (manVerify()){
			url=setList(pageno,url);
			var mygrid1 = $("#"+tableid).ingrid({
											url: url,
											ingridPageParams:sXML,
											height: pageHeight-274,
											pageNumber: pageno,
											colWidths: ["12%","7%","11%","11%","9%","10%","9%","7%","11%","13%"]
										});				
			}
	}
	function manVerify(){
		if (!checkControlValue("p_wlpc","String",1,30,null,0,"物流批次"))
			return false;
		if (!checkControlValue("p_jsr","String",1,30,null,0,"接收人"))
			return false;
		if (!checkControlValue("p_kh","String",1,100,null,0,"IC卡卡号"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		var p_jssj = $("#p_jssj").attr("value");
		var p_jssjt = $("#p_jssjt").attr("value");
		p_jssj=p_jssj.replace(/(-)/g,''); //去掉字符 - 
		p_jssjt=p_jssjt.replace(/(-)/g,''); //去掉字符 - 
		if(p_jssj!=''&&p_jssjt!=''&&p_jssj>p_jssjt){
			jAlert("请正确选择接收时间!","提示信息");
			return false;
		}
		return true;
	}
	var wlzb_timeFlag = true;
	function getObject(obj){ //操作
		sFlag="false";
		if(wlzb_timeFlag){
			wlzb_timeFlag = false;
			var content = $(obj).text();
			var thisId = $(obj).attr("id").split("_")[1];
			if(content=='查看'){
				wldj_setCk(thisId);
			}
			if(content=='修改'){
				set_wlzbUpdate(thisId);
			}
			if(content=='删除'){
				set_wlzbDel(thisId);
			}
			if(content=='发送'){
				set_wlzbSend(thisId);
			}
			setTimeout(function(){wlzb_timeFlag = true;},800);
		}
	}
	function wldj_setCk(id){ //查看
		sFlag="false";
		chakanFlag = 1;
		dataid = id;
		setWidth(detailid,addWidth);
		setUrl(detailid,'basic/icksystem/WlzbDetail.jsp');
		
		var wldj_fkOffset = $("#wldj_detail").offset();
		wldj_detailidLeftOffset=wldj_fkOffset.left;
		bindDocument(detailid);
	}
	function set_wlzbAdd(){ //展开添加页面
		sFlag="false";
		setWidth(detailid,addWidth);
		setUrl(detailid,'basic/icksystem/WlzbAdd.jsp');
		
		var wldj_fkOffset = $("#wldj_detail").offset();
		wldj_detailidLeftOffset=wldj_fkOffset.left;
		wldj_detailidTopOffset=wldj_fkOffset.top;
		bindDocument(detailid);
	}
	function setWlzbAdd(){ //添加
		if(wlzb_addVerify()){
			//lockedPage(); //锁屏幕
			setParams("a_");
			jQuery.ajax({
				type: 'POST',
				url: addUrl,
				data: params,
				async: false,
				dataType: 'json',
				success: function(result){						
					var rows  = eval(result);
					wlzbAddback(rows);
				}
			});
		}
	}
	function wlzbAddback(json){
		//activePage(); //解锁屏幕
		if(json.result=="success"){
			jAlert('物流包新增成功!','提示信息');
			setPageList(1);
			$("#ctlICCard").remove();
			$("#wldj_detail").hideAndRemove("show");
			$("#wldj_detail").empty();
		}else{
			jAlert(json.result,'错误信息');
		}
	}
	function set_wlzbUpdate(id){ //展开修改页面
		sFlag="false";
		dataid = id;
		setWidth(detailid,addWidth);
		setUrl(detailid,'basic/icksystem/WlzbModify.jsp');
		
		var wldj_fkOffset = $("#wldj_detail").offset();
		wldj_detailidLeftOffset=wldj_fkOffset.left;
		wldj_detailidTopOffset=wldj_fkOffset.top;
		bindDocument(detailid);
	}
	function setWlzbUpdate(){ //修改
		if(wlzb_modifyVerify()){
			setParams("m_");
			jQuery.ajax({
				type: 'POST',
				url: modUrl,
				data: params,
				async: false,
				dataType: 'json',
				success: function(result){						
					var rows  = eval(result);
					wlzbUpdateback(rows);
				}
			});
		}
	}
	function wlzbUpdateback(json){
		if(json.result=="success"){
			jAlert('物流包修改成功!','提示信息');
			setPageList(1);
			$("#ctlICCard").remove();
			$("#wldj_detail").hideAndRemove("show");
			$("#wldj_detail").empty();
		}else{
			jAlert(json.result,'错误信息');
		}
	}
	function set_wlzbDel(id){ //删除
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
				$("#d_wlid").attr("value",id);
				setParams("d_");
				jQuery.post(delUrl,params,wlzbDelBack,"json");
			}else{
			   return false;
			}
		});
	}
	function wlzbDelBack(json){ //删除 - 回调
		if(json.result=="success"){
			jAlert('删除物流包成功!','提示信息');
			setPageList(1);
		}else{
			jAlert(json.result,'错误');
		}
	}
	function set_wlzbSend(id){ //发送
/*		jConfirm('确定发送吗？', '发送提示', function(r) {
	    	if(r==true){
				$("#s_wlid").attr("value",id);
				setParams("s_");
				jQuery.post(sendUrl,params,wlzbSendBack,"json");
			}else{
			   return false;
			}
		});
*/
        sFlag="false";
		chakanFlag = 1;
		dataid = id;
		setWidth(detailid,addWidth);
		setUrl(detailid,'basic/icksystem/WlzbDetail-fs.jsp');
		
		var wldj_fkOffset = $("#wldj_detail").offset();
		wldj_detailidLeftOffset=wldj_fkOffset.left;
		bindDocument(detailid);
	}
	function wlzbSendBack(json){ //发送 - 回调
		if(json.result=="success"){
			jAlert('发送物流包成功!','提示信息');
			setPageList(1);
		}else{
			jAlert(json.result,'错误');
		}
	}
	function zjlxOnchange(){ //证件类型
		var bq_zjlx = $("#bq_zjlx").attr("value");
		$("#p_cyzjdm").attr("value",bq_zjlx);
	}
	function ztdmOnchange(){ //状态
		var bq_ztdm = $("#bq_ztdm").attr("value");
		$("#p_ztdm").attr("value",bq_ztdm);
	}
	function wlzb_setNull(sValue){
		if (sValue==null){
			sValue="&nbsp;";
		}else{
			sValue=''+sValue;
			sValue=sValue.split("T")[0];
		}
		if(sValue==''){
			sValue="&nbsp;";
		}
		return sValue;
	}
	function lockedPage(){ //锁屏幕
		activePage();
		var test = jQuery('<div id="jquery-overlay"></div>');
		//$('#allDiv').before('<div id="jquery-overlay"></div>');
		$('#jquery-overlay').css({
			zIndex:			1000000000,
			backgroundColor:	'#000',
			opacity:			0.6,
			width:				pageWidth,
			height:				pageHeight
		}).fadeIn();	
		window.document.body.appendChild(test);
	}
	function activePage(){ //解锁屏幕
		$('#jquery-overlay').remove();
    }
// 行业类别	
$("#p_hylbdm").selectBoxinhylb();
</script>

</head>
<body>
<input type="hidden" id="d_wlid" value="">
<input type="hidden" id="s_wlid" value="">
<input type="hidden" id="p_cyzjdm" value="">
<input type="hidden" id="p_ztdm" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">物流组包</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">物流批次</td>
				  	<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_wlpc" value=""></td>
					<td width="10%" class="pagedistd">接收人</td>
			      	<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jsr" value=""></td>
			      	<td width="10%" class="pagedistd">状态</td>
				  	<td width="23%" class="pagetd"><select id="bq_ztdm" onChange="ztdmOnchange();">
				  	<option></option></select></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">IC卡卡号</td>
				  	<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_kh" value=""></td>
					<td width="10%" class="pagedistd">证件类型</td>
			      	<td width="23%" class="pagetd">
			      	<select name="select4" id="bq_zjlx" onChange="zjlxOnchange();">
			      	<option></option></select></td>
			      	<td width="10%" class="pagedistd">证件号码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zjhm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">姓名</td>
				  	<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xm" value=""></td>
					<td width="10%" class="pagedistd">接收时间</td>
				  	<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jssj" value=""></td>
			  	      <td width="10%" class="pagedistd">至</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jssjt" value=""></td>
				</tr>
				<tr>
				<td width="10%" class="pagedistd">
								行业类别
							</td>
							<td width="23%" class="pagetd">
								<select  id="p_hylbdm" >
								</select>
							</td>
				<td colspan="4">
				      <table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                        <td ><a href="#" class="addbutton" onclick='set_wlzbAdd();'>添加</a></td>
                      </tr>
                      </table>
                    </td>
				</tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="wldj_detail" class="page-layout" src="#" style="top:0px;">
</div>	

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_wlpc">物流批次</th>
	     	<th name="l_djr">登记人</th>
	     	<th name="l_zbsj">组包时间</th>
	     	<th name="l_fssj">发送时间</th>
	     	<th name="l_bnksl">包内卡数量</th>
	     	<th name="l_mbsldmc">采集点</th>
	     	<th name="l_ztdm">状态</th>
	     	<th name="l_jsr">接收人</th>
	     	<th name="l_jssj">接收时间</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>

</body>
</html>