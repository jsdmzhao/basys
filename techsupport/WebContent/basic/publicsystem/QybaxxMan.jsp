<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var csbaxx_detailidTopOffset=0;
	var csbaxx_detailidLeftOffset=0;
	var csbaxx_tables="";
	var csbaxx_dataid="";
	var csbaxx_pageUrl="publicsystem/querylist_qybaxx.action";
	var csbaxx_divnid="CsbaxxData";
	var csbaxx_tableid="CsbaxxTable";
	var csbaxx_addUrl="publicsystem/insert_qybaxx.action";
	var csbaxx_addHtml="sCbaxxAdd.jsp";
	var csbaxx_addWidth="500";
	var csbaxx_delUrl="publicsystem/delete_qybaxx.action";
	var csbaxx_delid="d_qybaxxid";
	var csbaxx_modHtml="CsbaxxModify.jsp";
	var csbaxx_modUrl="publicsystem/modify_qybaxx.action";
	var csbaxx_modWidth="500";
	var csbaxx_detailHtml="CsbaxxDetail.jsp";
	var csbaxx_detailid="csbaxx_detail";
	var csbaxx_detailUrl="publicsystem/query_qybaxx.action";
	var csbaxx_detailWidth="300";
	
	var csbaxx_tjclHtml="basic/publicsystem/BaxxtjclMan-gn.jsp"; //提交材料信息
	var csbaxx_gncsbaAddHtml="basic/publicsystem/QybaxxAdd.jsp";
	var csbaxx_gncsbaAddWidth="900";
	var csbaxx_gncsbaModifyHtml="basic/publicsystem/QybaxxModify.jsp";
	var csbaxx_gncsbaModifyWidth="900";
	var csbaxx_gncsbaDetailHtml="basic/publicsystem/QybaxxDetail.jsp";
	var csbaxx_gncsbaDetailWidth="900";
	var csbaxx_gncsbaBbUrl="publicsystem/beianBubei_qybaxx.action"; //补备-URL
	var csbaxx_gncsbaBbHtml="basic/publicsystem/Baxxbb-gn.jsp"; //补备-HTML
	var csbaxx_gncsbaBbWidth="900";
	$(document).ready(function() {
		if(dangQianHylbdm=="J"){
			$("#td_qybaxxglTitle").text("场所备案信息管理");
		}
	
		$("#p_qyid").attr("value",ylcsjbxx_dataid);
		csbaxx_loadPage(csbaxx_divnid);
		
		$("#p_barq").attr("readonly","true");
		$("#p_barq").datepicker();
		$("#p_barqzhi").attr("readonly","true");
		$("#p_barqzhi").datepicker();
		csbaxx_setPageList(1);
	});
	
	function csbaxx_setPageList(pageno,url){
		if (csbaxx_manVerify()){
			rows = 10;
			url=csbaxx_setList(pageno,url);
			var mygrid1 = $("#"+csbaxx_tableid).ingrid({
											url: url,
											ingridPageParams:sXML,
											ingridPageWidth: 840,
											height: 250,
											barTopPosition:$("#ylcsjbxx_detail").position().top+95,
											onRowSelect: function(tr, selected){
												var str = selected?'SELECTED':'UNSELECTED';
												if(sFlag=="true"){
													if ($(tr).attr('_selected')=="true"){
														csbaxx_setQuery($(tr).attr("id")); 	
													}
												}else{
													sFlag="true";
												}					
											},
											pageNumber: pageno,
											colWidths: ["20%","20%","40%","20%"]
										});
		}
	}
	function csbaxx_loadPage(divpageid){
		csbaxx_tables=$("#"+divpageid).html();
		$("#"+csbaxx_detailid).hide();
		csbaxx_setPageList(1,'#');
	}
	function csbaxx_setList(pageno,url){
		$("#"+csbaxx_divnid).html(csbaxx_tables);	
		setParams("p_");
		if (url==null || url=="undefined"){
			url=csbaxx_pageUrl;
		}
		return url;
	}
	function getObject(obj){ //操作
		sFlag="false";
		var content = $(obj).text();
		var thisId = $(obj).attr("id").split("_")[1];
		if(content=='修改'){
			csbaxx_setModifyQuery(thisId);
		}
		if(content=='删除'){
			csbaxx_setDelete(thisId);
		}
		if(content=='补备'){
			setBubei(thisId);
		}
	}
	function ylcsjbxx_setDetail(){ //场所详细信息
		setParams("q_");
		jQuery.post(ylcsjbxx_detailUrl,params,ylcsjbxx_updatediv,"json");
	}
	function csbaxx_setDetail(){ //备案信息详细信息
		setParams("q_");
		jQuery.post(csbaxx_detailUrl,params,csbaxx_updatediv,"json");
	}
	function csbaxx_setAddPage(){ //展开添加页面
		sFlag="false";
		csbaxx_setWidth(csbaxx_detailid,csbaxx_gncsbaAddWidth);
		setUrl(csbaxx_detailid,csbaxx_gncsbaAddHtml);
		topAndLeft();
		//bindDocument(csbaxx_detailid);
	}
	function csbaxx_setQuery(id){ //展开详细页面
		csbaxx_dataid=id;
		csbaxx_setWidth(csbaxx_detailid,csbaxx_gncsbaDetailWidth);
		setUrl(csbaxx_detailid,csbaxx_gncsbaDetailHtml);
		topAndLeft();
		//bindDocument(csbaxx_detailid);
	}
	function csbaxx_setModifyQuery(id){ //展开修改页面
		sFlag="false";
		csbaxx_dataid=id;
		csbaxx_setWidth(csbaxx_detailid,csbaxx_gncsbaModifyWidth);
		setUrl(csbaxx_detailid,csbaxx_gncsbaModifyHtml);
		topAndLeft();
		//bindDocument(csbaxx_detailid);
	}
	function csbaxx_setDelete(id){ //删除
		sFlag="false";
		$("#"+csbaxx_delid).attr("value",id);
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
				setParams("d_");
		        jQuery.post(csbaxx_delUrl,params,csbaxx_deleteback,"json");
			}else{
			   return false;
			}
		});
	}
	function csbaxx_deleteback(json){
		if  (json.result=="success"){
			jAlert('删除成功','提示信息');
			csbaxx_setPageList(1);
		}else{
			jAlert(json.result,'错误信息');
		}
	}
	function setBubei(id){ //展开补备信息
		sFlag="false";
		csbaxx_dataid=id;
		csbaxx_setWidth(csbaxx_detailid,csbaxx_gncsbaBbWidth);
		setUrl(csbaxx_detailid,csbaxx_gncsbaBbHtml);
		topAndLeft();
		//bindDocument(csbaxx_detailid);
	}
	function csbaxx_setWidth(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		$("#"+divid).css("left","-30px");
		$("#"+divid).css("top","0px");
	}
	function csbaxx_setAdd(){ //添加备案信息
		setParams("a_");
		jQuery.post(csbaxx_addUrl,params,csbaxx_addBack,"json");
	}
	function csbaxx_addBack(json){ //添加回调函数
		if  (json.result=="success"){
			jAlert('添加成功','提示信息');
			csbaxx_setPageList(1);
			$("#"+csbaxx_detailid).hide("slow");
		}else{
			jAlert(json.result,'错误信息');
			$("#"+csbaxx_detailid).hide("slow");
		}
	}
	function csbaxx_setQueryBaxx(){ //修改备案信息
		setParams("m_");
		jQuery.post(csbaxx_modUrl,params,csbaxx_queryBack,"json");
	}
	function csbaxx_queryBack(json){ //修改回调函数
		if  (json.result=="success"){
			jAlert('修改成功','提示信息');
			csbaxx_setPageList(1);
			$("#"+csbaxx_detailid).hide("slow");
		}else{
			jAlert(json.result,'错误信息');
			$("#"+csbaxx_detailid).hide("slow");
		}
	}
	function csbaxx_setBubei(){ //补备备案信息
		setParams("b_");
		jQuery.post(csbaxx_gncsbaBbUrl,params,csbaxx_bubeiBack,"json");
	}
	function csbaxx_bubeiBack(json){ //补备回调函数
		if  (json.result=="success"){
			jAlert('补备成功','提示信息');
			csbaxx_setPageList(1);
			$("#"+csbaxx_detailid).hide("slow");
		}else{
			jAlert(json.result,'错误信息');
			$("#"+csbaxx_detailid).hide("slow");
		}
	}
	function csbaxx_manVerify(){
		var p_barqf = $("#p_barq").attr("value");
		var p_barqt = $("#p_barqzhi").attr("value");
		if(formatDate(p_barqf)-formatDate(p_barqt)>0){
			jAlert("请正确选择备案开始和结束日期!","提示信息");
			return false;
		}
		return true;
	}
	function topAndLeft(){
		var csbaxx_detailidOffset = $("#"+csbaxx_detailid).offset();
		csbaxx_detailidTopOffset=csbaxx_detailidOffset.top;
		csbaxx_detailidLeftOffset=csbaxx_detailidOffset.left;
	}
	function formatDate(strDate){ //转换成日期格式
		var rqAndTime = strDate.split(" ");
		var riqi = rqAndTime[0].split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
</script>
<body>
<input type="hidden" id="d_qybaxxid" value="">
<input type="hidden" id="p_qyid" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      	<td align="left" class="title1" id="td_qybaxxglTitle">企业备案信息管理</td>
      	<td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
    <tr>
    	<td height="6"></td>
	</tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">备案日期</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_barq" value=""></td>
				  <td width="10%" class="pagedistd">至</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_barqzhi" value=""></td>
				  <td class="pagedistd"><table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="50%" ><a href="#" class="searchbutton" id="querys" onClick="csbaxx_setPageList(1);">查询</a></td>
                      <td width="50%" ><a href="#" class="addbutton"  onclick='csbaxx_setAddPage()'>添加</a></td>
                    </tr>
                  </table></td>
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

<div id="csbaxx_detail"  class="page-layout" src="#"
		style="top:180px;">
</div>	

<div id="CsbaxxData" style="width:100%;">
	<table id="CsbaxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_csbabm">备案编码</th>
	     	<th name="l_barq">备案日期</th>
	     	<th name="l_babmmc">备案机构名称</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>