<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
String zdskb = QjblUtil.queryQjblVal("zdskb");// 最低刷卡比
String qysjlyyScpt = QjblUtil.queryQjblVal("qysjlyyScpt"); //企业数据来源于社采平台
%>
<script type="text/javascript">
    var zdskb = '<%=zdskb%>';
	var qyjbxx_requestType=""; //请求类型 添加、查看、修改
	var qyjbxx_dataid="";
	var qyjbxx_tables="";
	var qyjbxx_pageUrl="publicsystem/querylist_qyjbxx.action";
	var qyjbxx_divnid="QyjbxxData";
	var qyjbxx_tableid="QyjbxxTable";
	var qyjbxx_addUrl="publicsystem/insert_qyjbxx.action";
	var qyjbxx_addHtml="basic/publicsystem/QyjbxxAdd-gzth.jsp";
	var qyjbxx_addWidth="1000";
	var qyjbxx_delUrl="publicsystem/delete_qyjbxx.action";
	var qyjbxx_delid="d_qyid";
	var qyjbxx_modHtml="basic/publicsystem/QyjbxxModify-gzth.jsp";
	var qyjbxx_modUrl="publicsystem/modify_qyjbxx.action";
	var qyjbxx_modWidth="1000";
	var qyjbxx_detailHtml="basic/publicsystem/QyjbxxDetail-gzth.jsp";
	var qyjbxx_detailid="qyjbxx_detail";
	var qyjbxx_detailUrl="publicsystem/query_qyjbxx.action";
	var qyjbxx_detailWidth="1000";
	var qyjbxx_hylbdm="";
$(document).ready(function() {
	qyjbxx_loadPage(qyjbxx_divnid);
	$("#p_gxdwmc").click(function(){// 管辖单位
		getGxdw("p_gxdwmc","p_gxdwbm");
	});
	hylbLinkQyzfl("p_hylbdm","p_qyzflbm"); // 行业类别与企业主分类联动
	$("#p_zt").selectBox({code:"dm_csjlzt"});// 企业状态
	daggleDiv(qyjbxx_detailid);
	
	var qysjlyyScpt = '<%=qysjlyyScpt %>';
	if("0"==qysjlyyScpt){
		$("#tishiMes").html("新增企业请从客服系统导入");
		$("#addBut").hide();
	}
}); 
	
function qyjbxx_loadPage(divpageid){
		qyjbxx_tables=$("#"+divpageid).html();
		$("#"+qyjbxx_detailid).hide(); 	
		qyjbxx_setPageList(1,'#');
}
	
function qyjbxx_setPageList(pageno,url){
		if (qyjbxx_manVerify()){
			url=qyjbxx_setList(pageno,url);
			var mygrid1 = $("#"+qyjbxx_tableid).ingrid({ 
											url: url,
											ingridPageParams:sXML,
											height: pageHeight-253,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){
												var str = selected?'SELECTED':'UNSELECTED';
												if(sFlag=="true"){
													if ($(tr).attr('_selected')=="true"){
														qyjbxx_setQuery($(tr).attr("id")); 	
													}
												}else{
													sFlag="true";
												}					
											},
											colWidths: ["15%","26%","19%","10%","15%","10%","5%"]									
										});				
			}
	}
	
	function qyjbxx_setList(pageno,url){	
		$("#"+qyjbxx_divnid).html(qyjbxx_tables);	
		createXML("p_");
		if (url==null || url=="undefined"){
			url=qyjbxx_pageUrl;
		}
		return url;
	}
	
	function qyjbxx_setQuery(id){
		qyjbxx_requestType="detail";
		qyjbxx_dataid=id;
		setWidth(qyjbxx_detailid,qyjbxx_detailWidth);
		setUrl(qyjbxx_detailid,qyjbxx_detailHtml);
		bindDocument(qyjbxx_detailid);
	}
	
	function qyjbxx_setDetail(){
		setParams("q_");
		jQuery.post(qyjbxx_detailUrl,params,qyjbxx_updatediv,"json");
	}
	function qyjbxx_setAddPage(){
		qyjbxx_requestType="add";
		qyjbxx_dataid = zdskb;
		setWidth(qyjbxx_detailid,qyjbxx_addWidth);
		setUrl(qyjbxx_detailid,qyjbxx_addHtml);
	}
	function qyjbxx_setAdd(){ //添加
		if (qyjbxx_addVerify()){
			ajaxAddDivCeng();
			var child=new Array("BaryxxListData","BwryxxListData","BldsjksbListData","AqjcsbListData");
			setParams("a_",child);
			jQuery.ajax({
				type: 'POST',
				url: qyjbxx_addUrl,
				data: params,
				async: true,
				dataType: 'json',
				success: function(result){
					removeAllDivCeng();						
					var rows  = eval(result);
					qyjbxx_addback(rows);
				}
			});
		}	
	}
	function qyjbxx_addback(json){
		if  (json.result=="success"){
			jAlert('添加成功','提示信息');
			qyjbxx_setPageList($("#pageNo").attr("value"));
			$("#"+qyjbxx_detailid).hideAndRemove("slow");
		}else{
			jAlert(json.result,'错误信息');
		}
	}
	function qyjbxx_setModifyQuery(id){ //原修改
		sFlag="false";
		qyjbxx_requestType="modify";
		qyjbxx_dataid=id;
		setWidth(qyjbxx_detailid,qyjbxx_modWidth);
		setUrl(qyjbxx_detailid,qyjbxx_modHtml);
	}
	function getObject(obj){ //修改
		sFlag="false";
		if($(obj).text()=='修改'){
			qyjbxx_requestType="modify";
			qyjbxx_dataid=$(obj).attr("id").split("_")[1];
			setWidth(qyjbxx_detailid,qyjbxx_modWidth);
			setUrl(qyjbxx_detailid,qyjbxx_modHtml);
		}
	}
	function qyjbxx_setUpdate(){ //修改
		if (qyjbxx_modifyVerify()){
			ajaxAddDivCeng();
			dataid=['baryid','bwryid','bldsjksbid','anjcsbid'];
			var child=new Array("BaryxxListData","BwryxxListData","BldsjksbListData","AqjcsbListData");
			setParams("m_",child);
			jQuery.ajax({
				type: 'POST',
				url: qyjbxx_modUrl,
				data: params,
				async: true,
				dataType: 'json',
				success: function(result){			
					removeAllDivCeng();			
					var rows  = eval(result);
					qyjbxx_updateback(rows);
				}
			});
		}
	}
	function qyjbxx_updateback(json){
		if  (json.result=="success"){
			jAlert(modMessage,'保存信息');
			qyjbxx_setPageList($("#pageNo").attr("value"));
			$("#"+qyjbxx_detailid).hideAndRemove("slow"); 
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
	function qyjbxx_manVerify(){
		if (!checkControlValue("p_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_zjbh","String",1,60,null,0,"营业执照编号"))
			return false
		if (!checkControlValue("p_gxdwmc","String",1,60,null,0,"管辖单位"))
			return false; 
		return true;
	}
	function formatDate(strDate){ //转换成日期格式
		var rqAndTime = strDate.split(" ");
		var riqi = rqAndTime[0].split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	function dateDiff(datestart,dateend){ //日期相差的天数
		return parseInt(Math.abs(datestart - dateend) / 1000 / 60 / 60 /24);
	}
	function gaojichaxun_qy(){
		gaojichaxun("44,46",detailid,"qyjbxx_setPageList");
	}
</script>
<html>
<body>
	
<input type="hidden" id="d_qyid" value="">
<input type="hidden" id="p_gxdwbm" value=""/>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">企业管理</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				    <td width="10%" class="pagedistd">行业类别</td>
			  <td width="23%" class="pagetd"><select id="p_hylbdm"></select>
			  </td>
    		  <td width="10%" class="pagedistd">企业分类</td>
			      <td width="23%" class="pagetd">
			      <select name="select" id="p_qyzflbm">
			      <option></option></select></td>
			      <td width="10%" class="pagedistd">管辖单位</td>
			      <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdwmc" value="" readonly></td>
		  </tr>
				<tr>
				<td width="10%" class="pagedistd">企业名称</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qymc" value=""></td>
					<td width="10%" class="pagedistd">企业代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qybm" value=""></td>
					<td width="10%" class="pagedistd">营业执照编号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zjbh" value=""></td>
				</tr>
    		<tr>
    		  <td width="10%" class="pagedistd">状态</td>
				  <td width="23%" class="pagetd"><select name="select" id="p_zt">
				  <option></option></select></td>
    		  <td colspan="4">
   		  	  	<table border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="145"><font id="tishiMes" color="green"></font></td>
                      <td width="62"><a href="#" class="searchbutton" id="querys" onClick="qyjbxx_setPageList(1);">查询</a></td>
                      <td width="62" id="addBut"><a href="#" class="addbutton" onclick='qyjbxx_setAddPage();'>添加</a></td>
                    </tr>
                </table>
   		  	  </td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="qyjbxx_detail" class="page-layout" src="#" style="top:5px;"></div>	
<div id="QyjbxxData" style="width:100%;">
	<table id="QyjbxxTable" width="100%">
	  <thead>
	    <tr>    
	        <th name="l_qybm">企业代码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_jjlxmc">经济类型</th>
	     	<th name="l_zrs">总人数</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_zt">状态</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>