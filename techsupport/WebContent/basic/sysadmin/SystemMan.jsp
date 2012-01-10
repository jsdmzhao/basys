<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var moveSelectId;
	$(document).ready(function() {
		pageUrl="sysadmin/querylist_system.action";
		divnid="tabledata3";
		tableid="table1";
		addUrl="sysadmin/insert_system.action";
		addHtml="basic/sysadmin/SystemAdd.jsp";
		addWidth="500";
		delUrl="sysadmin/delete_system.action";
		modHtml="basic/sysadmin/SystemModify.jsp";
		modUrl="sysadmin/modify_system.action";
		modWidth="500";
		detailHtml="basic/sysadmin/SystemDetail.jsp";
		detailid="system_detail";
		detailUrl="sysadmin/query_system.action";
		detailWidth="500";
		delid="d_systemcode";
		loadPage("tabledata3");
		getSystem();
		setPageList(1);
		
		daggleDiv("system_detail");
	}); 
	function getSystem(){
		setParams("p_");
		var sUrl="sysadmin/showSystem_system.action";
		jQuery.post(sUrl,params,systemInfo,"json");
	}
	function systemInfo(json){
		if(json.nowSystem!=null){
			$("#n_systemcode").attr("value",setNull(json.nowSystem.systemcode));
			$("#n_systemname").attr("value",setNull(json.nowSystem.systemname));
			$("#n_systemdefine").attr("value",setNull(json.nowSystem.systemdefine));
			$("#n_picturepath").attr("value",setNull(json.nowSystem.picturepath));
			
			$("#n_parentsystemcode").attr("value",setNull(json.nowSystem.parentsystemcode));
			$("#n_nodeorder").attr("value",setNull(json.nowSystem.nodeorder));
			$("#n_isleaf").attr("value",setNull(json.nowSystem.isleaf));
			$("#n_fullcode").attr("value",setNull(json.nowSystem.fullcode));
			$("#nparentsystemname").attr("value",setNull(json.nowSystem.parentsystemname));
		} else {
			$('input[@id^="n_"]').attr("value","").end();
			$("#nparentsystemname").attr("value","");
		}
	}
	function setPageList(pageno,url){
		if (manVerify()){
			url=setList(pageno,url);
			setParams("p_");
			var mygrid1 = $("#"+tableid).ingrid({
											ingridPageParams:sXML,
											ingridPageWidth: pageWidth-205,
											url: url,
											height: pageHeight-306,
											pageNumber: pageno,
											sorting: false,
											onRowSelect: function(tr, selected){
												moveSelectId = $(tr).attr("id");
											},
											colWidths: ["25%","30%","30%","15%"]									
										});
			}
	}
	function manVerify(){
		if (!checkControlValue("n_systemname","String",1,50,null,0,"系统名称"))
			return false;
		if (!checkControlValue("n_parentsystemcode","String",1,20,null,0,"上级系统"))
			return false;
		if (!checkControlValue("n_systemcode","String",1,20,null,0,"系统代码"))
			return false;
		if (!checkControlValue("n_fullcode","String",1,50,null,0,"系统全路径代码"))
			return false;
		if (!checkControlValue("n_nodeorder","Integer",-999999999,999999999,null,0,"排列顺序"))
			return false;
		if (!checkControlValue("n_systemdefine","String",1,200,null,0,"系统连接"))
			return false;
		return true;
	}
	function setSysDetail(id){
		setQuery(id,detailHtml,detailWidth);
		bindDocument(detailid); //自动关闭
	}
	function setQuerys(){ //添加子系统
		var code = $("#n_systemcode").attr("value");
		if(code==null||code==''){
			code='0'; //父ID为''
		}
		dataid=code;
		setWidth(detailid,addWidth);
		setUrl(detailid,addHtml);
		bindDocument(detailid); //自动关闭
	}
	function updateNowObject(){ //修改
		if (manVerify()){ //验证
			var code = $("#n_systemcode").attr("value");
			if(code==null||code==''){
				jAlert('请选择系统!','提示信息');
				return;
			}
			setParams("n_");
	    	jQuery.post(modUrl,params,updateNowObjectBack,"json");
		}
	}
	function updateNowObjectBack(json){
		if(json.result=="success"){
			jAlert('修改成功!','保存信息');
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow");
			saveOnClickedit($("#n_parentsystemcode").attr("value"),$("#n_systemcode").attr("value")); //刷新树
		}else{
			getSystem();
			jAlert(json.result,'错误');
		}		
	}
	function deleteNowObject(){
		var code = $("#n_systemcode").attr("value");
		if(code==null||code==''){
			jAlert('请选择系统!','提示信息');
			return;
		}
		sFlag="false";
		jConfirm('确定删除吗?', '删除提示', function(r){
	    	if(r==true){
				setParams("n_");
		        jQuery.post(delUrl,params,deleteObjectBack,"json");
			}else{
			   return false;
			}
		});
	}
	function deleteObjectBack(json){
		if  (json.result=="success"){
			jAlert('删除成功！','提示信息');
			getSystem();
			setPageList($("#pageNo").attr("value"));
			saveOnClickdel($("#n_parentsystemcode").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误');
		}
	}
	function moveSort(moveWay){ //移动
		var row=$().find('tr[@id]');
		if(row.length>0){
			if(moveSelectId==null||moveSelectId==''){
				jAlert('请选择子系统!','提示信息');
				return;
			}
			var moveParentid=$("#n_systemcode").attr("value");
			var params={moveParentid:moveParentid,moveSelectId:moveSelectId,moveWay:moveWay};
			var sUrl="sysadmin/moveSort_system.action";
			jQuery.post(sUrl,params,moveSortBack,"json");
		}
	}
	function moveSortBack(json){
		if(json.result=="success"){
			moveSelectId = '';
			setPageList($("#pageNo").attr("value"));
			saveOnClick($("#n_systemcode").attr("value")); //刷新树
		}
	}
	function deleteback(json){
		if  (json.result=="success"){
			jAlert(delMessage,'提示信息');
			var pageno=$("#pageNo").attr("value");
			if ($("#startno").html()==$("#endno").html()){
				if ($("#pageNo").attr("value")>1){
					pageno=""+(parseInt(pageno)-1);
				}
			}
			setPageList(pageno);
			saveOnClickdel($("#p_systemcode").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误信息');
		}	
	}
	function saveOnClickedit(parentCode,code){
	    tree.refreshItem(parentCode);
	    //alert("更新成功");
	    tree.selectItem(code,true);
	}
</script>
<body>
	<input type="hidden" id="p_systemcode" value="<%=(String)request.getAttribute("systemcode") %>">
	<input type="hidden" id="d_systemcode" value="">
<div class="textdiv">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
<tr>
        <td class="queryfont" >系统管理</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <input type="hidden" id="n_parentsystemcode">
              <input type="hidden" id="n_isleaf">
              <td width="14%" class="pagedistd">系统名称</td>
              <td width="24%" class="pagetd"><input type="text" class="inputstyle"  id="n_systemname" value=""></td>
              <td width="8%" class="pagedistd">上级系统</td>
              <td width="21%" class="pagetd"><input type="text"  readonly   class="readonly" id="nparentsystemname" value=""></td>
              <td width="10%" class="pagedistd">系统代码</td>
              <td width="23%" class="pagetd"><input type="text"  id="n_systemcode" value="" readonly   class="readonly" ></td>
            </tr>
            <tr>
              <td class="pagedistd">系统全路径代码</td>
              <td class="pagetd" colspan="3"><input type="text" readonly   class="readonly" id="n_fullcode" value="" style="width:410;"></td>
              <td class="pagedistd">系统定义</td>
              <td class="pagetd"><input type="text" class="inputstyle"  id="n_systemdefine" value=""></td>
            </tr>
            <tr>
              <td class="pagedistd">图片路径</td>
              <td class="pagetd" colspan="3"><input type="text" class="inputstyle"  id="n_picturepath" value="" style="width:410;"/></td>
              <td class="pagedistd">排列顺序</td>
              <td class="pagetd"><input type="text" class="inputstyle"  id="n_nodeorder" value="0"></td>
            </tr>
            <tr>
              <td colspan="6"><table width="210" border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td ><a href="#" onclick='setQuerys()' class="submitlongbutton">添加下级系统</a></td>
                  <td width="3">&nbsp;</td>
                  <td ><a href="#" onclick='updateNowObject();' class="submitbutton">修改</a></td>
                  <td width="3">&nbsp;</td>
                  <td ><a href="#" onClick="deleteNowObject();" class="submitbutton">删除</a></td>
                </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
    </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="360" border="0" align="left" cellpadding="0" cellspacing="0">
     <tr><td height="3"></td></tr>
        <tr>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('置顶');">置顶</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('上移');">上移</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('下移');">下移</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('置底');">置底</a></td>
                      <td width="28%">&nbsp;</td>
                    </tr>
                     <tr><td height="3"></td></tr>
                </table></td>
  </tr>
</table>
<div id="system_detail"  class="page-layout" src="#"
		style="top:260px; left:160px;"></div>
<div id="tabledata3" style="width:100%; height:18px">
	<table id="table1" width="100%" cellpadding="0" cellspacing="0" border="0">
  <thead>
			<tr>
			<th name="l_systemcode">系统代码</th>
			<th name="l_systemname">系统名称</th>
			<th name="l_parentsystemcode">上级系统</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>
</div>

</body>
</html>