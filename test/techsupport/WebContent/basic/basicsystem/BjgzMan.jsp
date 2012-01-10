<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bjgz.action";
	divnid="BjgzData";
	tableid="BjgzTable";
	addUrl="basicsystem/insert_bjgz.action";
	addHtml="basic/basicsystem/BjgzAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bjgz.action";
	delid="d_bjgzid";
	modHtml="basic/basicsystem/BjgzModify.jsp";
	modUrl="basicsystem/modify_bjgz.action";
	modWidth="500";
	detailHtml="basic/basicsystem/BjgzDetail.jsp";
	detailid="bjgz_detail";
	detailUrl="basicsystem/query_bjgz.action";
	detailWidth="300";
	loadPage(divnid);
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["8%","8%","8%","8%","8%","8%","8%","8%","8%","8%","8%","8%"]									
									});				
		}
}	
</script>

<body>
	
	<input type="hidden" id="d_bjgzid" value="">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td width="83%" class="queryfont">对比规则</td>
    <td width="17%"><table width="248" border="0" align="right" cellpadding="0" cellspacing="0">
      <tr>
        <td width="25%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
        <td width="25%" ><a href="#" class="submitbutton" onclick='setAddPage()'>删除</a></td>
        <td width="25%" ><a href="#" class="submitbutton" onclick='setAddPage()'>验证</a></td>
        <td width="25%" ><a href="#" class="submitbutton" onclick='setAddPage()'>撤销</a></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="6"></td>
	</tr>
</table>
<div id="bjgz_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BjgzData" style="width:100%;">
	<table id="BjgzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_ywbm">业务表名</th>
	     	<th name="l_bdbm">比对表名</th>
	     	<th name="l_bdlx">比对类型</th>
	     	<th name="l_sfyx">是否有效</th>
	     	<th name="l_fbcl">发布策略</th>
	     	<th name="l_fbfs">发布方式</th>
	     	<th name="l_txdwzd">特行单位字段</th>
	     	<th name="l_gxdwzd">管辖单位字段</th>
	     	<th name="l_bjjb">报警级别</th>
	     	<th name="l_bjfs">报警方式</th>
	     	<th name="l_bjlx">报警类型</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>
</html>