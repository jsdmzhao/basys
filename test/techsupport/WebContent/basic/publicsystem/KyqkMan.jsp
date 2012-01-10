<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="publicsystem/querylist_kyqk.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="publicsystem/insert_kyqk.action";
	addHtml="basic/publicsystem/KyqkAdd.jsp";
	addWidth="600";
	delUrl="publicsystem/delete_kyqk.action";
	delid="d_kyqkid";
	modHtml="basic/publicsystem/KyqkModify.jsp";
	modUrl="publicsystem/modify_kyqk.action";
	modWidth="600";
	detailHtml="basic/publicsystem/KyqkDetail-gad.jsp";
	detailid="kyqk_detail";
	detailUrl="publicsystem/query_kyqk.action";
	detailWidth="700";
	
	loadPage("tabledata");
		$("#p_tbsj").attr("readonly","true");
		$("#p_tbsj").datepicker();
		$("#p_tbsjzhi").attr("readonly","true");
		$("#p_tbsjzhi").datepicker();
	$("#p_kyqklxbm").selectBox({code:"dm_kyqklx"});
	daggleDiv("kyqk_detail");
}); 

function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		rows = Math.ceil((pageHeight-225-25-23)/20);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-225,
										pageNumber: pageno,
										ingridPageParams: sXML,
										colWidths: ["20%","20%","20%","20%","20%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_tbrxm","String",1,100,null,0,"填报人姓名"))
			return false;	
		if (!checkControlValue("p_kyqklxbm","String",1,100,null,0,"可疑情况类型"))
			return false;
		return true;
	}
	
	////可疑情况查询
	function querykyqk(){
	  if (!checkControlValue("p_tbrxm","String",1,100,null,0,"填报人姓名"))
			return false;	
	  if (!checkControlValue("p_kyqklxbm","String",1,100,null,0,"可疑情况类型"))
			return false;
	  if (!checkDateEarlier("p_tbsj","开始时间","p_tbsjzhi","结束时间","DATE"))
		return false;
	
	  setPageList(1);
	}
	function getObject(obj){
    	sFlag="false";
    	//alert($(obj).attr("id")+"="+$(obj).text());
    	if($(obj).text()=="修改"){
    		setModifyQuery($(obj).attr("id").split("_")[1]);
    	}
    	if($(obj).text()=="删除"){
    		setDelete($(obj).attr("id").split("_")[1]);
    	}
    }
</script>

<body>
	
	<input type="hidden" id="d_csid" value="">
	<input type="hidden" id="d_kyqkid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">可疑情况管理</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="7%" class="pagedistd">填报时间</td>
				  <td width="41%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbsj" value="">
			      <span class="pagedistd">至
			      <input type="text" class="inputstyle"  id="p_tbsjzhi" value="">
			      </span></td>
					<td width="5%" class="pagedistd">填报人</td>
			      <td colspan="2" class="pagetd"><input type="text" class="inputstyle"  id="p_tbrxm" value=""></td>
                   <td width="12%" class="pagedistd">可疑情况类型</td>
				  <td width="13%" class="pagetd"><select type="select" id="p_kyqklxbm" value="">
				                                    <option value=""></option>
				                                 </select></td>
		  </tr>
				<tr>
					<td colspan="6" class="pagedistd">&nbsp;</td>
		          <td width="13%"><table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="52%"><a href="#"  class="searchbutton" id="querys" onClick="querykyqk();">查询</a></td>
                      <td  width="48%"><a href="#" class="addbutton" onclick='setAddPage()'>添加</a> </td>
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
<div id="kyqk_detail"  class="page-layout" src="#"
		style="top:180px; left:160px; width:500px;">
</div>	

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	
	     	<th name="l_kyqkdjxh">登记序号</th>
	     	<th name="l_kyqklx">可疑情况类型</th>
	     	<th name="l_tbrxm">填报人姓名</th>
	     	<th name="l_tbsj">填报时间</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
