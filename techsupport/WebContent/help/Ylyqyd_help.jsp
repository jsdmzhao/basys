<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String rjbbversion = "";
		String bqsyzname = "";
		Globalpar glo_skone = new Globalpar();
		Globalpar temp_skone = null;
		List globList_skone = null;
		
		glo_skone.setGlobalparcode("rjbb"); //软件版本 版本号

		globList_skone = CacheManager.getCacheGlobalpar(glo_skone);
		if(globList_skone!=null&&globList_skone.size()>0){
			temp_skone = (Globalpar)globList_skone.get(0);
			rjbbversion = temp_skone.getGlobalparvalue();	
		}
		
		glo_skone.setGlobalparcode("bqsyz"); //版权所有

		globList_skone = CacheManager.getCacheGlobalpar(glo_skone);
		if(globList_skone!=null&&globList_skone.size()>0){
			temp_skone = (Globalpar)globList_skone.get(0);
			bqsyzname = temp_skone.getGlobalparvalue();	
		}
%>


	
<script language="javascript" type="text/javascript">
	 function closeAndRemovehelp(){
	$("#man_help").children().remove();
	$("#man_help").hideAndRemove("show");
}
</script>

<body leftmargin="0" topmargin="0"  style="scroll:no;" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">帮助信息</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeAndRemovehelp();' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr height="30">
				<td >
					<b>版本：</b>
				</td>
				<td>
					<%=rjbbversion%>
				</td>
			</tr>
			<tr height="30">
				<td>
					<b>版权所有：</b>
				</td>
				<td>
				
					<%=bqsyzname%><br>
					北京航天金盾科技有限公司
				</td>
			</tr>
			<tr height="30">
				<td>
					<b>帮助文档：</b>
				</td>
				<td>
					<a href="<%=request.getContextPath() %>/help/场所端.doc" target="_blank">娱乐场所治安管理系统功能说明</a>
				</td>
			</tr>
</table>

</body>