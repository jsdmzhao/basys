<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<script type="text/javascript">
	$(document).ready(function() {
		pageUrl="sysadmin/querylist_function.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="sysadmin/insert_function.action";
		addHtml="basic/sysadmin/FunctionAdd.jsp";
		addWidth="500";
		delUrl="sysadmin/delete_function.action";
		modHtml="basic/sysadmin/FunctionModify.jsp";
		modUrl="sysadmin/modify_function.action";
		modWidth="500";
		detailHtml="basic/sysadmin/FunctionDetail.jsp";
		detailid="function_detail";
		detailUrl="sysadmin/query_function.action";
		detailWidth="400";
		delid="d_funccode";
		loadPage("tabledata");
		setPageList(1);
		
		daggleDiv("function_detail");
	}); 
		
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			setParams("p_");
			var mygrid1 = $("#"+tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: pageWidth-205,
											url: url,	
											height: pageHeight-205,
											pageNumber: pageno,
											colWidths: ["25%","30%","30%","15%"]
										});				
			}
	}	
	function manVerify(){
		if (!checkControlValue("p_funcname","String",1,100,null,0,"功能名称"))
			return false;
		if (!checkControlValue("p_funccode","String",1,50,null,0,"功能代码"))
			return false;
		return true;
	}
	function setQuerys(){ //添加新功能

		var systemcode = $("#p_systemcode").attr("value");
		if(systemcode==null||systemcode=='null'||systemcode==''){
			jAlert('请选择系统!','提示信息');
			return;
		}
		dataid=systemcode;
		setWidth(detailid,addWidth);
		setUrl(detailid,addHtml);
		bindDocument(detailid); //自动关闭
	}
</script>
<body>
	<input type="hidden" id="d_funccode" value="">
	<input type="hidden" id="p_systemcode" value="<%=(String)request.getAttribute("systemcode") %>">
<div class="textdiv">
	<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
      <tr>
        <td class="queryfont">功能管理</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          <tr>
            <td width="8%" class="pagedistd">功能名称</td>
            <td width="25%" class="pagetd"><input type="text" class="inputstyle"  id="p_funcname" value=""></td>
            <td width="8%" class="pagedistd">功能代码</td>
            <td width="24%" class="pagetd"><input type="text" class="inputstyle"  id="p_funccode" value=""></td>
            <td width="15%">&nbsp;</td>
            <td width="20%">
            <table width="120" border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="55%" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                  <td width="45%" ><a href="#" class="addbutton"  onclick='setQuerys()'>添加</a></td>
                </tr>
              </table>
            </td>
          </tr>
        </table></td>
      </tr>
    </table>	
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
	<div id="function_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;"> </div>
	<div id="tabledata" style="width:100%;">
        <table id="table1" width="100%">
          <thead>
            <tr>
              <th name="l_funccode">功能代码</th>
              <th name="l_funcname">功能名称</th>
              <th name="l_functype">功能类别</th>
              <th name="">操作</th>
	    </tr>
	  </thead>
        </table>
    </div>
</div>
</body>
</html>