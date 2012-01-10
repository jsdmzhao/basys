<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
Date da=new Date();
		long lo=da.getTime();
 %>
<script type="text/javascript">
	$(document).ready(function() {
		$('#qyryxx').load("basic/publicsystem/CyryxxDetail-wg.jsp", {}, function(){
			$('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
		});
	}); 
</script>
<div id="qyxxClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">境外从业人员详情</td>
      <td align="right" class="title1"><a href="#" onclick="$('#qyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
<div id="qyryxx"></div>	
<div id="qyrytjxx"></div>	