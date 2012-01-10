<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="sysadmin/querylist_dict.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="sysadmin/insert_dict.action";
	addHtml="basic/sysadmin/DictAdd.jsp";
	addWidth="260";
	delUrl="sysadmin/delete_dict.action";
	delid="d_dict_code";
	modHtml="basic/sysadmin/DictModify.jsp";
	modUrl="sysadmin/modify_dict.action";
	modWidth="260";
	detailHtml="basic/sysadmin/DictDetail.jsp";
	detailid="dict_detail";
	detailUrl="sysadmin/query_dict.action";
	detailWidth="300";
	loadPage("tabledata");
	setPageList(1);
	$("#p_dict_type").selectBox({state:"1"});
	
	 daggleDiv("dict_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-228,
										pageNumber: pageno,
										colWidths: ["18%","18%","16%","16%","16%","16%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_dict_name","String",1,50,null,0,"字典名称"))
			return false;
		if (!checkControlValue("p_super_dict_code","String",1,30,null,0,"上级字典编码"))
			return false;
		if (!checkControlValue("p_dict_code","String",1,30,null,0,"字典代码"))
			return false;
		if (!checkControlValue("p_dict_type","String",1,2,null,0,"字典类型"))
			return false;
		if (!checkControlValue("p_dict_versionid","String",1,20,null,0,"版本号"))
			return false;
		
		return true;
	}
	
	function setDelete_dict(id){
		sFlag="false";
		jConfirm('确定删除且连带删除字典项吗？', '删除提示', function(r) {
	    	if(r==true){
				$("#"+delid).attr("value",id);
				setParams("d_");
		        jQuery.post(delUrl,params,deleteback,"json");
			}else{
			   return false;
			}
		});
	}
</script>

</head>
<body>
	
	<input type="hidden" id="d_dict_code" value="">	
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">字典名称</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_dict_name" /></td>
					<td width="10%" class="pagedistd">上级字典编码</td>
				    <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_super_dict_code" /></td>
				    <td width="10%" class="pagedistd">字典代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_dict_code" /></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">字典类型</td>
					<td width="23%" class="pagetd">
						<select id="p_dict_type">
							<option></option>
							<option value="01">简单</option>
							<option value="02">树状</option>
							<option value="03">联动</option>
						</select>
					</td>
					<td width="10%" class="pagedistd">版本号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_dict_versionid" /></td>
					<td colspan="2"><table border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td  width="55%"><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                      <td  width="45%"><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="dict_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	
<div id="tabledata" style="width:100%">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_dict_id">字典代码</th>
	     	<th name="l_dict_name">字典名称</th>
	     	<th name="l_super_dict_code">上级字典</th>
	     	<th name="l_dict_versionid">版本号</th>
	     	<th name="l_dict_type">字典类型</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>