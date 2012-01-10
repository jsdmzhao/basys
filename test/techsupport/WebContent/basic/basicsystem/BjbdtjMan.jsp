<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bjbdtj.action";
	divnid="BjbdtjData";
	tableid="BjbdtjTable";
	addUrl="basicsystem/insert_bjbdtj.action";
	addHtml="basic/basicsystem/BjbdtjAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bjbdtj.action";
	delid="d_bjgzid";
	modHtml="basic/basicsystem/BjbdtjModify.jsp";
	modUrl="basicsystem/modify_bjbdtj.action";
	modWidth="500";
	detailHtml="basic/basicsystem/BjbdtjDetail.jsp";
	detailid="bjbdtj_detail";
	detailUrl="basicsystem/query_bjbdtj.action";
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
										colWidths: ["10%","10%","10%","10%","10%","10%","10%","10%","10%","10%"]									
									});				
		}
}	
</script>

<body>
	
	<input type="hidden" id="d_bjgzid" value="">	
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td width="83%" class="queryfont">对比条件</td>
    <td width="17%"><table width="248" border="0" align="right" cellpadding="0" cellspacing="0">
      <tr>
        <td width="25%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
         <td width="25%" ><a href="#" class="submitbutton" onclick='setAddPage()'>删除</a></td>
         <td width="25%" ><a href="#" class="submitbutton" onclick='setAddPage()'>验证</a></td>
         <td width="25%" ><a href="#" class="submitbutton" onclick='setAddPage()'>撤销</a></td>                  
      </tr>
    </table></td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="bjbdtj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BjbdtjData" style="width:100%;">
	<table id="BjbdtjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bjbdtjid">报警比对条件ID</th>
	     	<th name="l_tjlx">条件类型</th>
	     	<th name="l_ywbzdm">业务表字段名</th>
	     	<th name="l_bdbzdm">比对表字段名</th>
	     	<th name="l_bdgx">比对关系</th>
	     	<th name="l_gxc">关系串</th>
	     	<th name="l_zxsx">执行顺序</th>
	     	<th name="l_ljgx">逻辑关系</th>
	     	<th name="l_jibie">级别</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>