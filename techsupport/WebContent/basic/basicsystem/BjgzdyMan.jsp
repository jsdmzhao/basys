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
	$(document).ready(function() {
		$("#Bjgz").empty();
		$("#Bjgz").load("basic/basicsystem/BjgzMan.jsp");
		$("#Bjgz").show("slow");	
	$(document).ready(function() {
		$("#Bjbdtj").empty();
		$("#Bjbdtj").load("basic/basicsystem/BjbdtjMan.jsp");
		$("#Bjbdtj").show("slow");
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
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">公安机关</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bjgzid" value="0"></td>
					<td width="10%" class="pagedistd">间隔时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ywbm" value=""> 
					  分钟</td>
					<td width="10%" class="pagedistd">&nbsp;</td>
					<td width="23%"><table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="100%" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
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
		<div style="width:100%" id=Bjgz></div>
		<div style="width:100%" id=Bjdbtj></div>
</body>
</html>