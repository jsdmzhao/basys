<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>
<%
	String userbm = "";
	User user= (User)session.getAttribute(Constants.userKey);
	if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
		userbm = user.getSsdwbm();
	}
%>
<%			
		String version_prjWebControl_skone = "";
		String device_urlHnOrJs_skone = "";
		Globalpar glo_skone = new Globalpar();
		Globalpar temp_skone = null;
		List globList_skone = null;
		
		glo_skone.setGlobalparcode("prjweb-bbh"); //prj 版本号
		globList_skone = CacheManager.getCacheGlobalpar(glo_skone);
		if(globList_skone!=null&&globList_skone.size()>0){
			temp_skone = (Globalpar)globList_skone.get(0);
			version_prjWebControl_skone = temp_skone.getGlobalparvalue();	
		}
		
		glo_skone.setGlobalparcode("kjvalidater-bbh"); //验证文件
		globList_skone = CacheManager.getCacheGlobalpar(glo_skone);
		if(globList_skone!=null&&globList_skone.size()>0){
			temp_skone = (Globalpar)globList_skone.get(0);
			device_urlHnOrJs_skone = temp_skone.getGlobalparvalue();	
		}
%>
	
	
<html>
<head>
<script type="text/javascript">



	var skjl_tables="";
	var skjl_pageUrl="icksystem/querylistSkjllsxx_qyryskjl.action";
	var skjl_divnid="tabledata";
	var skjl_tableid="table1";
	
	var qybm="<%=userbm %>";
	$(document).ready(function(){
		
	});
	
	
	function skjlslxxx(cyrybh){
	    $("#p_cyrybh").attr("value",cyrybh);
	    $("#p_qybm").attr("value",qybm);
		 skjl_loadPage("tabledata");
	}
	
	function skjl_setPageList(pageno,url){	
		url=skjl_setList(pageno,url);
		var mygrid1 = $("#"+skjl_tableid).ingrid({ 
							url: url,
							ingridPageParams:sXML,
							height: pageHeight-206,
							pageNumber: pageno,
							onRowSelect: null,
							sorting: false,
							colWidths: ["25%","25%","25%","25%"]
					});				
	}
	function skjl_loadPage(divpageid){
		ctreatTable();
		skjl_tables=$("#"+divpageid).html();
		//$("#"+skjl_detailid).hide(); 	
		skjl_setPageList(1);
	}
	function ctreatTable(){
	       $("#tabledata").empty();
	        var result = "<table id='table1' width='100%'><thead><tr>";
		
		    result += "<th name='l_cyrybh' datatype='Integer' sumflag='0'>从业人员编号</th>";
	     	result += "<th name='l_xm' datatype='Integer' sumflag='0'>姓名</th>";
	     	result += "<th name='l_zjhm' datatype='Integer' sumflag='0'>证件号码</th>";
	     	result += "<th name='l_sksj' datatype='Integer' sumflag='0'>刷卡时间</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#tabledata").html(result);
	}
	
	
			
	
	function skjl_setList(pageno,url){	
		$("#"+skjl_divnid).html(skjl_tables);
		setParams("p_");
		if (url==null || url=="undefined"){
			url=skjl_pageUrl;
		}
		return url;
	}

</script>
</head>
<body>
<div style ="display :none ">
		<OBJECT ID="ctlICCard" CLASSID="CLSID:BF802FFD-DDC6-45CD-BC87-50C21696497E" CODEBASE="active/prjWebControl.CAB#version=<%=version_prjWebControl_skone %>"> </OBJECT>
		<OBJECT ID="device" CLASSID="CLSID:030B433D-7746-41FB-8CA1-3DAD1249D865" CODEBASE="<%=device_urlHnOrJs_skone %>"></OBJECT>
	</div>
<input type="hidden" id="p_qybm">
<input type="hidden" id="p_cyrybh">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">刷卡历史记录</td>
  </tr>
</table>

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_sksj">刷卡时间</th>
	    </tr>
	  </thead>
	</table>	
</div>

</body>
<script language="javascript" type="text/javascript">
	OpenRead1();
function OpenRead1(){


	document.getElementById('ctlICCard').ConnJava=content_connJava;
	document.getElementById('ctlICCard').ICCardDevice=content_deviceType;
	document.getElementById('ctlICCard').OpenRead();
}
var cardInfoArray= new Array();
var kncyrybh="";
 function ReadICCardFinish(strValue)
      { 
   
        if(strValue.indexOf("$")>=0){
            
                     cardInfoArray = strValue.split('$');
					     kncyrybh = cardInfoArray[1];	
					      
					      if(kncyrybh!=''){
					         skjlslxxx(kncyrybh);
					     }else{
					       // alert("卡内信息从业人员编号为空");
					     }     			    
             }
       }  
          
      
</script>
</html>