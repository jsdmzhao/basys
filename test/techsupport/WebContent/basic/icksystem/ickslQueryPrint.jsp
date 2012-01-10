<%@ page contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/htmlConfig.js" charset="utf-8"></script>	
<script type="text/javascript">
	$(document).ready(function() {
		//var ownHref = window.location.href;
		$("#q_ickslid").attr("value",window.name);
		//var print_ickslid = onwHref.substr
		//$("#q_ickslid").attr("value",dataid);
		detailUrl="<%=request.getContextPath() %>/icksystem/queryZh_icksl.action";
		setDetail();
	}); 
	
	function updatediv (json) { 
	//人员基本信息
		$("#xm").append(setNull(json.qyryxx.xm));
		$("#zjhm").append(setNull(json.qyryxx.zjhm));
		$("#cyrybh").append(setNull(json.qyryxx.cyrybh));
		$("#xm2").append(setNull(json.qyryxx.xm));
		$("#zjhm2").append(setNull(json.qyryxx.zjhm));
		$("#cyrybh2").append(setNull(json.qyryxx.cyrybh));
		
	//IC卡受理信息	
		$("#ickslid").append(setNull(json.icksl.ickslid));
		$("#ickslid2").append(setNull(json.icksl.ickslid));
		$("#slr").append(setNull(json.icksl.slr));
		$("#slsj").append(setNull(json.icksl.slsj));
		$("#slsj2").append(setNull(json.icksl.slsj));
	}	

</script>
<html>
<head>
<title>IC卡受理单</title>
	<style media="print">
    	.noprint {display:none}
    </style>
    <style media="all">
    </style>
	<style type="text/css">
		tr{height:30;}
	</style>
</head>
<body topMargin="10" leftMargin="10" rightMargin="10" bottomMargin="20">
<input type="hidden" id="q_ickslid" />
    <table border=1 align="center" cellspacing="0" cellpadding="0" width="85%">
		  <caption style="text-align:center">从业人员IC卡受理单<br></caption>
		  <caption style="text-align:left">受理单位（盖章）<br></caption>
		  <tr>
		    <td width="15%">受理号<br></td>
		    <td width="35%"><span id="ickslid"></span><br></td>
		    <td width="15%">姓名 <br></td>
		    <td width="35%"><span id="xm"></span> <br></td>
		  </tr>
		  <tr>
		    <td width="15%"> 证件号码<br></td>
		    <td colspan="3"><span id="zjhm"></span> <br></td>
		  </tr>
		  <tr>
		    <td width="15%">从业人员编号 <br></td>
		    <td colspan="3"><span id="cyrybh"></span>  <br></td>
		  </tr>
		  <tr>
		    <td width="15%"> 承办人<br></td>
		    <td width="35%"><span id="slr"></span><br></td>
		    <td width="15%"> 受理时间<br></td>
		    <td width="35%"><span id="slsj"></span> <br></td>
		  </tr>
		  <tr>
		    <td width="15%"> 发票领取情况<br></td>
		    <td width="35%">
		    	<input type="radio" name="fplqqkCheckbox" value="1"> 已领取&nbsp;
		    	<input type="radio" name="fplqqkCheckbox" value="0"> 未领取
		    <br></td>
		    <td width="15%">发卡人 <br></td>
		    <td width="35%"> <br></td>
		  </tr>
		  <tr>
		    <td width="15%">领卡人（签名） <br></td>
		    <td width="35%"><br></td>
		    <td width="15%"> 领卡时间<br></td>
		    <td width="35%"> <br></td>
		  </tr>
	</table>
	<table width="100%" border="0" style="text-align:center">
		<tr height="20">
		    <td>--------------------------------------------------------------------------------------------------------------------------------<br></td>
		</tr>
	</table>
    <table border=1 align="center" cellspacing="0" cellpadding="0" width="85%">
		  <caption style="text-align:center">从业人员IC卡领取凭证<br></caption>
		  <caption style="text-align:left">受理单位（盖章）<br></caption>
		  <tr>
		    <td width="15%">受理号</td>
		    <td width="35%">&nbsp;<span id="ickslid2"></span></td>
		    <td width="15%">姓名 </td>
		    <td width="35%">&nbsp;<span id="xm2"></span> </td>
		  </tr>
		  <tr>
		    <td width="15%"> 证件号码</td>
		    <td colspan="3">&nbsp;<span id="zjhm2"></span></td>
		  </tr>
		  <tr>
		    <td width="15%">编号 </td>
		    <td colspan="3">&nbsp;<span id="cyrybh2"></span></td>
		  </tr>
		  <tr>
		    <td width="15%"> 承办人</td>
		    <td width="35%">&nbsp;<span id="slr2"></span></td>
		    <td width="15%"> 受理电话</td>
		    <td width="35%">&nbsp;</td>
		  </tr>
		  <tr>
		    <td width="15%"> 受理时间</td>
		    <td colspan="3">&nbsp;<span id="slsj2"></span></td>
		  </tr>
	</table><br>
	<p>
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  注领取IC卡时，请携带此凭证及本人有效身份证件，未领取IC卡时，请在工作期间随身携带此凭证！
	</p>
    <table width="100%">
	  <tr>
	    <td style="text-align:right"><input type="button" class="noprint" value="打 印" onclick="checkPrint()"></td>
	  </tr>
	</table>
	<script type="text/javascript">
		function checkPrint()
		{
			window.print();
			window.close();
		}
	</script>
</body>
</html>
