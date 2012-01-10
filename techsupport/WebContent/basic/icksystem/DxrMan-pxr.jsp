<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		if(dataid==null||dataid=='null'||dataid==''){
			jAlert("失败，请重试！","提示");
			dxrpxrColse();
		} else {
		    dxr_querysnAndWcUrl = "icksystem/querySnAndWc_ickzb.action"; //获取开始顺序号和写卡数量 url
		    dxr_queryCyryxxMesUrl = "icksystem/queryCyryxxMes_ickzb.action"; //获取从业信息 url
		    dxr_backWriteIckhUrl = "icksystem/backWriteIckh_ickzb.action"; //将ic卡号(芯片号)写到数据库
		    dxr_queryCyryxxMesByCyrybhUrl = "icksystem/queryCyryxxMesByCyrybh_ickzb.action"; //获取从业信息(自定义写入) url
			wldj_queryCyryzpImageUrl = "icksystem/queryCyryzpImage_wldj.action?cyrybh="; // 获取物流登记时从业人员照片
			$("#p_pch").attr("value",dataid);
			queryStartNumAndWriteCount();
		}
	});
	function dxrpxrColse(){
		$("#ickzb_detail").hideAndRemove("show");
		$("#ickzb_detail").empty();
	}
</script>
</head>
<body>
<input type="hidden" id="b_ickslid">
<input type="hidden" id="b_ryid">
<input type="hidden" id="b_ickh">

<input type="hidden" id="projectUrl" value="<%=basePath %>">
<input type="hidden" id="pxrflag" value="1">
<input id="pxr" type="radio" name="xrtype" value="pxr" checked style="display:none">
<table width="100%" cellpadding="0" cellspacing="0"class="tableborder">
	<tr>
	
		<td class="queryfont">电写入查询条件</td>
	</tr>
	<tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td class="pagedistd">批次号</td>
				<td class="pagetd"><input type="text" readonly class="readonly" value="" id="p_pch"></td>
				<td class="pagedistd">开始顺序号</td>
				<td class="pagetd"><input type="text" class="inputstyle" id="p_kssxh"></td>
				<td class="pagedistd">本次电写入数量</td>
				<td class="pagetd"><input type="text" class="inputstyle" id="p_bcdxrsl"> 
				张卡片</td>
				<td class="pagedistd">
					<table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
					<tr>
						<td><a href="#" id="start" class="submitbutton" onClick="startDxrIckBon();">开始</a></td>
                        <td><a href="#" id="tiaog" class="submitbutton"  onclick="tiaoGuoIckBon();">跳过</a></td>
					</tr>
                    </table>
				</td>
			</tr>
    	</table>
    </td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr>
    <td class="queryfont">从业人员信息</td>
	</tr>
	<tr>
    <td valign="top" class="tdbg">
    <table width="100%" border="0" cellspacing="0" cellpadding="4" class="detail">
    	<tr>
	      <td class="distd1">顺序号</td>
	      <td class="detailtd2" colspan="4"><span id="ic_orderNum"></span></td>
	    </tr>
	    <tr>
	      <td width="11%" class="distd1">姓名</td>
	      <td width="30%" class="detailtd2"><span id="ic_xingming"></span></td>
	      <td width="11%" class="distd1">卡号</td>
	      <td width="30%" class="detailtd2"><span id="ic_kh"></span></td>
	      <td width="18%" rowspan="13" class="detailtd2">
		  <table border="0" align="center" cellpadding="8" cellspacing="0">
              <tr>
                <td><img id="tpnrImg" width="118" height="149" src="images/pic.gif"/></td>
              </tr>
          </table>
	      </td>
	    </tr>
	    <tr>
	      <td class="distd1">从业人员编号</td>
	      <td class="detailtd2"><span id="ic_cyrybh"></span></td>
	      <td class="distd1">证件号码</td>
	      <td class="detailtd2"><span id="ic_zjhm"></span></td>
	    </tr>
	    <tr>
	      <td class="distd1">性别</td>
	      <td class="detailtd2"><span id="ic_xb"></span></td>
	      <td class="distd1">民族</td>
		  <td class="detailtd2"><span id="ic_minzu"></span></td>
	    </tr>
	    <tr>
	      <td class="distd1">出生日期</td>
	      <td class="detailtd2"><span id="ic_csrq"></span></td>
	      <td class="distd1">是否注销</td>
		  <td class="detailtd2"><span id="ic_zxbz"></span></td>
	    </tr>
	    <tr>
	      <td class="distd1">户籍省县市</td>
	      <td class="detailtd2" colspan="3"><span id="ic_hjsx"></span></td>
	    </tr>
	    <tr>
	      <td class="distd1">户籍详细地址</td>
	      <td class="detailtd2" colspan="3"><span id="ic_hjdxz"></span></td>
	    </tr>
	    <tr>
	      <td class="distd1">英文名</td>
		  <td class="detailtd2"><span id="ic_ywm"></span></td>
	      <td class="distd1">英文姓</td>
		  <td class="detailtd2"><span id="ic_ywx"></span></td>
	    </tr>
	    <tr>
	      <td class="distd1">国籍</td>
		  <td class="detailtd2"><span id="ic_gj"></span></td>
	      <td class="distd1">就业许可证号</td>
		  <td class="detailtd2"><span id="ic_wgrjyxkz"></span></td>
	    </tr>
	    <tr>
	      <td class="distd1">有效起始日期</td>
	      <td class="detailtd2"><span id="ic_rjrq"></span></td>
	      <td class="distd1">有效截至日期</td>
	      <td class="detailtd2"><br><span id="ic_zatlq"></span><br></td>
	    </tr>
    </table>
    </td>
	</tr>
</table>
</body>
<%@include file="../../public/includeKongJian.jsp" %>
</html>