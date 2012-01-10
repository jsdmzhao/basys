<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#ickknxx").empty();
		$("#ickknxx").load("public/skOne.jsp");
		$("#ickknxx").show("slow");
	});
	function addIckClose(){
	    document.getElementById('ctlICCard').CloseWrite();
		$("#ctlICCard").remove();
		$("#wldj_ick_detail").hideAndRemove("show");
		$("#wldj_ick_detail").empty();
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">从业人员信息</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='addIckClose();'class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="4"></td></tr>
</table>
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
		<tr>
        	<td class="queryfont">从业人员信息</td>
		</tr>
		<tr>
			<td class="tdbg">
				<div id="ickknxx"></div>
			</td>
		</tr>
</table>

