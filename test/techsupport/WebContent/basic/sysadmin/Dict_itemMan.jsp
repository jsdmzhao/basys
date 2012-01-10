<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script type="text/javascript">
var oldWidth = $("#dictionaryItem_tree").width()-2;
var dict_itemWidth = pageWidth-206;
var item_id = "<c:out value='${item_id }' />";
if(item_id!="" && item_id!="")
	dict_itemWidth = dict_itemWidth-206;
var moveDataId = -1;
$(document).ready(function() {
	pageUrl="sysadmin/querylist_dict_item.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="sysadmin/insert_dict_item.action";
	addHtml="basic/sysadmin/Dict_itemAdd.jsp";
	addWidth="260";
	delUrl="sysadmin/delete_dict_item.action";
	delid="d_item_id";
	modHtml="basic/sysadmin/Dict_itemModify.jsp";
	modUrl="sysadmin/modify_dict_item.action";
	modWidth="260";
	detailHtml="basic/sysadmin/Dict_itemDetail.jsp";
	detailid="dict_item_detail";
	detailUrl="sysadmin/query_dict_item.action";
	detailWidth="300";
	loadPage("tabledata");
	setPageList(1);
	
	 daggleDiv("dict_item_detail");
}); 

function chgIndex(index){
	alert(index);
}
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										url: url,	
										height: pageHeight-231,
										pageNumber: pageno,
										ingridPageWidth: dict_itemWidth,
										onColFocus: function(tr){
											moveDataId = $(tr).attr("id");
										},
										onRowSelect: null,
										colWidths: ["30%","10%","20%","20%","20%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_display_name","String",1,100,null,0,"显示名称"))
			return false;
		return true;
	}
	
function chgIndex(changeWay){
	if(moveDataId!=-1){
		$("#c_way").val(changeWay);
		$("#c_item_id").val(moveDataId);
		moveDataId = -1;
		setMovePlace();
	}
}

function setMovePlace(){
		setParams("c_");
		jQuery.post("sysadmin/moveDictItem_dict_item.action",params,movePlaceback,"json"); 	
}
function movePlaceback(json){
	if  (json.result=="success"){
		jAlert("移动成功",'保存信息');
		setPageList($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}
function setQueryDict_item(id){
	setQuery(id,detailHtml,detailWidth);
}

function setDeleteDict_item(id){
	sFlag="false";
	jConfirm('确定删除吗？', '删除提示', function(r) {
    	if(r==true){
			$("#"+delid).attr("value",id);
			setParams("d_");
	        jQuery.post(delUrl,params,deleteDict_itemback,"json");
		}else{
		   return false;
		}
	});
}

function deleteDict_itemback(json){
	if  (json.result=="success"){
		jAlert(delMessage,'提示信息');
		var pageno=$("#pageNo").attr("value");
		if ($("#startno").html()==$("#endno").html()){
			if ($("#pageNo").attr("value")>1){
				pageno=""+(parseInt(pageno)-1);
			}
		}
		setPageList(pageno);
		if($("#dictionaryItem_tree").attr("id")!=null){
			$("#dictionaryItem_tree").width(oldWidth);
			saveSuccess($("#p_super_item_id").attr("value"),0); //刷新树
		}
	}else{
		jAlert(json.result,'错误信息');
	}	
}	

</script>


<body>
	<input type="hidden" id="d_item_id" value="">
	<input type="hidden" id="c_item_id">
	<input type="hidden" id="c_way">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
      <tr>
        <td class="queryfont">查询选项</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <td width="10%" class="pagedistd">显示值</td>
              <td width="23%" class="pagetd">
				<input type="hidden" id="s_super_item_id" value="<c:if test="${item_id!=null }"><c:out value="${item_id }" /></c:if>"/>
				<input type="hidden" id="p_super_item_id" value="<c:if test="${item_id!=null }"><c:out value="${item_id }" /></c:if>"/>
              	<input type="hidden" id="p_dict_code" value="<c:if test="${dict_code!=null }"><c:out value="${dict_code }" /></c:if>">
              	<input type="hidden" id="p_fact_value" value="<c:if test="${fact_value!=null }"><c:out value="${fact_value }" /></c:if>">
              	<input type="text" class="inputstyle"  id="p_display_name" value="">
              </td>
              <td >
               <table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="55%" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                  <td width="45%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a> </td>
                </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
    </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr><td height="3"></td></tr>
  <tr>
    <td><table width="360" border="0" align="left" cellpadding="0" cellspacing="0">
        <tr>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="chgIndex('置顶');">置顶</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="chgIndex('上移');">上移</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="chgIndex('下移');">下移</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="chgIndex('置底');">置底</a></td>
                      <td width="28%">&nbsp;</td>
                    </tr>
                     <tr><td height="3"></td></tr>
                </table></td>
  </tr>
</table>
      <div id="dict_item_detail"  class="page-layout" src="#"
		style="top:50px; left:160px;"> </div>
      <div id="tabledata" style="width:100%;">
        <table id="table1" width="100%">
          <thead>
            <tr>
              <th name="l_display_name">显示值</th>
              <th name="l_fact_value">实际值</th>
              <th name="l_append_value">附加值</th>
              <th name="l_item_simplepin">简拼</th>
              <th name="">操作</th>
	    </tr>
	  </thead>
        </table>
    </div>
</body>
</html>