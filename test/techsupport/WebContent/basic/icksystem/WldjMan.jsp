<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
String stCJDFlag = "";// 省厅采集点标志
if((departCode.indexOf("CJD")!=-1) && (departCode.length()==5)){// 省厅采集点
    stCJDFlag = "1";
}else{
    stCJDFlag = "0";
}
%>
<html>
<head>
<script type="text/javascript">
 
	var dataid;
	var chakanFlag = 0;
	var stCJDFlag = '<%=stCJDFlag%>';
	var colWidths0 = ["13%","9%","11%","11%","9%","10%","9%","11%","0%","13%"];
	var colWidths1 = ["16%","11%","12%","12%","11%","11%","11%","12%","0%","0%"];
	var tableWidth;
	var hideCol0 = [8];
	var hideCol1 = [8,9];
	var hideCol;
	
	if(stCJDFlag=='0'){
	    tableWidth = colWidths0;
	    hideCol = hideCol0;
	}else{
	    tableWidth = colWidths1;
	    hideCol = hideCol1;
	}
	$(document).ready(function() {
		pageUrl="icksystem/querylist_wldj.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="icksystem/insert_wldj.action";
		addHtml="basic/icksystem/WldjAdd.jsp";
		addWidth="500";
		delUrl="icksystem/delete_wldj.action";
		delid="d_wlid";
		modHtml="basic/icksystem/WldjModify.jsp";
		modUrl="icksystem/modify_wldj.action";
		modWidth="500";
		detailHtml="basic/icksystem/WldjDetail.jsp";
		detailid="wldj_detail";
		detailUrl="icksystem/query_wldj.action";
		detailWidth="600";
		wldj_loadPage("tabledata");
		$("#wldj_print").hide();
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
		// 行业类别	
		$("#p_hylbdm").selectBoxinhylb({code:"dm_hylb"});
		
		daggleDiv("wldj_detail");
		daggleDiv("wldj_print");
	}); 
	
	function wldj_loadPage(divpageid){
        tables=$("#"+divpageid).html();
	    $("#"+detailid).hide(); 	
	    if(dataid=="tzxxFlag"){
	        dataid="";
	        setPageList(1);
	    }else{
	        setPageList(1,'#');
	    }
	}
	
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			var mygrid1 = $("#"+tableid).ingrid({
											url: url,	
											ingridPageParams:sXML,
											height: pageHeight-275,
											pageNumber: pageno,
											changeHref : function(table){
											    var trObj;
											    table.find("tr").each(function() {
										            trObj = $(this);
										            if ((trObj.find("td:nth(8)").text()).length >= 10) {
											            trObj.find("td:last").find("a[title='接收']").remove();
											            trObj.find("td:last").find("a[title='反馈']").remove();
										            }
										        });
											},
											hideColIndex: hideCol,
											colWidths: tableWidth
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
		//if($("#p_cyzjdm").attr("value")=='111'){ //验证身份证
		//	var temp = $("#p_zjhm").attr("value");
		//	if(temp!=''){
		//		if(!isIdCardNo(temp))
		//		return false;
		//	}
		//}
		return true;
	}
	var wldj_timeFlag = true;
	function getObject(obj){ //操作
		sFlag="false";
		if(wldj_timeFlag){
			wldj_timeFlag = false;
			//alert($(obj).attr("id")+"="+$(obj).text());
			var content = $(obj).text();
			var thisId = $(obj).attr("id").split("_")[1];
			if(content=='查看'){
				wldj_setCk(thisId);
			}
			if(content=='接收'){
				wldj_setJs(thisId);
			}
			if(content=='反馈'){
				wldj_setFk(thisId);
			}
			if(content=='打印'){
				wldj_print(thisId);
			}
			setTimeout(function(){wldj_timeFlag = true;},800);
		}
	}
	function wldj_setCk(id){ //查看
		sFlag="false";
		chakanFlag = 1;
		dataid = id;
		setWidth('wldj_detail',900);
		setUrl('wldj_detail','basic/icksystem/WldjMan-fk.jsp');
		bindDocument(detailid);
	}
	function wldj_setJs(id){ //接收
		sFlag="false";
		dataid = id;
		
		setWidth('wldj_detail',900);
		setUrl('wldj_detail','basic/icksystem/wljs.jsp');
	}
	function isCanJieShouBack(json){ //未用
		//$("#d_wlid").attr("value",id);
		//setParams("d_");
		//jQuery.post('ylfwzagl/isCanJieShou_wldj.action',params,isCanJieShouBack,"json"); //判断是否可以进行接收
		if (json.result!="success"){
			$("#wldj_detail").hide("show");
			jAlert(json.result,'提示信息');
		} else { //可以进行反馈
		}
	}
	function wldj_setFk(id){ //反馈
		sFlag="false";
		chakanFlag = 0;
		dataid = id;
		
		setWidth('wldj_detail',900);
		setUrl('wldj_detail','basic/icksystem/WldjMan-fk.jsp');
		bindDocument(detailid);
	}
	function isCanFankuiBack(json){ //未用
		//$("#d_wlid").attr("value",id);
		//setParams("d_");
		//jQuery.post('ylfwzagl/isCanFankui_wldj.action',params,isCanFankuiBack,"json"); //判断是否可以进行反馈
		if (json.result!="success"){
			$("#wldj_detail").hide("show");
			jAlert(json.result,'提示信息');
		} else { //可以反馈
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
	function wldj_print(id){
		sFlag="false";
		dataid = $("#"+id).find("td").eq(0).text();
		//jAlert('物流批次传给下一个页面'+dataid);
		setWidth('wldj_print',900);
		setUrl('wldj_print','basic/icksystem/WldjShowPrint.jsp');
		bindDocument('wldj_print');
	}
	function gaojichaxun_wldj(){
		gaojichaxun("51",detailid);
	}
	
	

</script>

</head>
<body>
<input type="hidden" id="d_wlid" value="">
<input type="hidden" id="p_cyzjdm" value="">
<input type="hidden" id="p_ztdm" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">物流接收管理</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				    <td width="10%" class="pagedistd">行业类别</td>
		            <td width="23%" class="pagetd"><select  id="p_hylbdm" ></select></td>
					<td width="10%" class="pagedistd">物流批次</td>
				  	<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_wlpc" value=""></td>
					<td width="10%" class="pagedistd">接收人</td>
			      	<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jsr" value=""></td>
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
			  	    <td width="10%" class="pagedistd">状态</td>
				  	<td width="23%" class="pagetd"><select id="bq_ztdm" onChange="ztdmOnchange();">
				  	<option></option></select></td>
				  	<td width="10%" class="pagedistd">接收时间</td>
				  	<td width="23%" class="pagetd"><input type="text" class="inputstyle1"  id="p_jssj" value="">至
			  	    <input type="text" class="inputstyle1"  id="p_jssjt" value=""></td>
				</tr>
				<tr>
				<td colspan="6" class="pagetd"><table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                        <td ><a href="#" class="submitlongbutton" onclick='gaojichaxun_wldj();'>高级查询</a></td>
                      </tr>
                    </table></td>
				</tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="wldj_detail" class="page-layout" src="#" style="top:10px;">
</div>
<div id="wldj_print" class="page-layout" src="#" style="top:10px;">
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
	     	<th name="l_ztdm">状态</th>
	     	<th name="l_jsr">接收人</th>
	     	<th name="l_jssj">接收时间</th>
	     	<th name="l_fksj">反馈时间</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>