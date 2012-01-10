<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head></head>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(8,'打印');
		$("#s_wlpc").attr("value",dataid);
		
		setParams("s_");
		jQuery.post('icksystem/printMessage_wldj.action',params,printMessageBack,"json");
		var ctlp = document.getElementById("ctlPrint");
		ctlp.SetUrl = "<%=basePath %>basic/icksystem/WldjPrint.jsp?WLPC="+dataid;
	});
	function printMessageBack(json){ //物流打印信息
		var content = "";
		var pageSize = 14; //一个打印页 多少 条记录
		var tableNum = 0;
		var endRows = 0;
		for(var csIndex=0,csmax=json.LWldj.length;csIndex<csmax;csIndex++){
			tableNum = Math.ceil(json.LWldj[csIndex].length/pageSize);
			for(var tableIndex=0;tableIndex<tableNum;tableIndex++){ //一个场所有多个table
				endRows = (tableIndex==(tableNum-1))?(json.LWldj[csIndex].length):((tableIndex+1)*pageSize);
				content += "<table border='1' bordercolordark='#FFFFFF' bordercolorlight='#cccccc' width='98%' cellpadding='0' cellspacing='0'>";
				content += "<caption style='height:25px;text-align:center; font:11pt;'>"+json.LWldj[csIndex][0].qymc+"</caption>";
				content += "<tr>";
				content += "<th bgcolor='#f0f0f0' height='25' width='5%'>序号</th>";
				content += "<th bgcolor='#f0f0f0' width='24%'>从业人员编号</th>";
				content += "<th bgcolor='#f0f0f0' width='10%'>姓名</th>";
				content += "<th bgcolor='#f0f0f0'width='19%'>证件号码</th>";
				content += "<th bgcolor='#f0f0f0' width='13%'>受理时间</th>";
				content += "<th bgcolor='#f0f0f0' width='9%'>签名</th>";
				content += "</tr>";
				for(var ickIndex=tableIndex*pageSize;ickIndex<endRows;ickIndex++){
					content += "<tr>";
					content += "<td height='20'>"+(ickIndex+1)+"</th>";
					content += "<td>"+setPrintNull(json.LWldj[csIndex][ickIndex].cyrybh)+"</td>";
					content += "<td>"+setPrintNull(json.LWldj[csIndex][ickIndex].xm)+"</td>";
					content += "<td>"+"<span style='display:none'>'</span>"+setPrintNull(json.LWldj[csIndex][ickIndex].zjhm)+"</td>";
					content += "<td>"+setPrintNull(json.LWldj[csIndex][ickIndex].slsj)+"</td>";
					content += "<td>&nbsp;</td>";
					content += "</tr>";
				}
				content += "<caption valign='bottom' style='height:25px;text-align:center; font:10pt;'>本企业，第"+(tableIndex+1)+"页/共"+tableNum+"页</caption>";
				content += "</table>";
				content += "<br>";
			}
		}
		$("#printContent").append(content);
	}
	function wldjPrint() { //打印
		//window.location.href="<%=basePath %>business/Ylfwzagl/WldjPrint.jsp?WLPC="+dataid;
		
		var ctlp = document.getElementById("ctlPrint");
		ctlp.SetUrl = "<%=basePath %>basic/icksystem/WldjPrint.jsp?WLPC="+dataid;
        var err=ctlp.PrintWeb();
        switch(err){
			case 0:
				jAlert("打印成功!","提示信息");
				return true;
			case 1:
				jAlert("打印失败,请检查打印机配置!","提示信息");
				return false;
			case 2:
				jAlert("发生意外错误","提示信息");
				return false;
 			default:
				return false;
		}
	}
	function setPrintNull(sValue){
		if (sValue==null){
			sValue="";
		}else{
			var patrn = /^(\d{4})\-(\d{2})\-(\d{2})T(\d{2}):(\d{2}):(\d{2})$/;
			if (patrn.test(sValue)){
				sValue = sValue.replace('T',' ');
			}
		}
		if(sValue==''){
			sValue="&nbsp;";
		}
		return sValue;
	}
	//导出Excel，只是用于采集端物流包打印
	function expExcel(objid) {
	    window.clipboardData.setData("Text",document.all(objid).outerHTML);   
	    try{   
	        var ExApp = new ActiveXObject("Excel.Application"); 
	    }catch(e){   
		    alert(e);
	        alert("您的电脑没有安装Microsoft Excel软件！");   
	        return false;  
	    }    
	    var ExWBk = ExApp.workbooks.add();   
	    var ExWSh = ExWBk.worksheets(1);   
	    var ExWCe = ExWBk.ActiveSheet; 
	    ExApp.DisplayAlerts = false;  
	    ExApp.visible = true;  
	    ExApp.UserControl = true; 
	
	    ExWSh.Paste; 
	    ExWCe.Columns.AutoFit;
    	//ExWCe.Columns(4).NumberFormatLocal="##################";
    	//ExWCe.Columns(4).NumberFormatLocal="0";
	}
</script>
<body>
<input type="hidden" id="s_wlpc"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">物流信息打印</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#wldj_print").hideAndRemove("show");'class="close"></a></td>
    </tr>
    
    <tr><td height="3"></td></tr>
</table>
<div id="printContent" style="height:500px; overflow:auto;"></div><br>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr height="25" align="center">
                <td width="100%">
<a href="#" class="submitbutton" onclick='wldjPrint();'>打印</a>
<a href="#" class="exceldcbutton" onClick="expExcel('printContent');">导出</a>
</td>
              </tr>
          </table>
</body>
<%@include file="../../public/includePrintKJ.jsp" %>
</html>