<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

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
	
	<div style ="display :none ">
		<OBJECT ID="ctlICCard" CLASSID="CLSID:BF802FFD-DDC6-45CD-BC87-50C21696497E" CODEBASE="active/prjWebControl.CAB#version=<%=version_prjWebControl_skone %>"> </OBJECT>
		<OBJECT ID="device" CLASSID="CLSID:030B433D-7746-41FB-8CA1-3DAD1249D865" CODEBASE="<%=device_urlHnOrJs_skone %>"></OBJECT>
	</div>
<script language="javascript" type="text/javascript">
	
</script>

<table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
    <tr>
      <td width="11%" class="distd1" id="cardName_xingming">姓名</td>
      <td width="30%" class="detailtd2"><span id="xingming"></span>&nbsp;</td>
      <td width="11%" class="distd1" id="cardName_ickkh">IC卡卡号</td>
      <td width="30%" class="detailtd2"><span id="ickkh"></span>&nbsp;</td>
      <td width="18%" rowspan="13" class="detailtd2">&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_cyrybh">从业人员编号</td>
      <td class="detailtd2"><span id="cyrybh"></span>&nbsp;</td>
      <td class="distd1" id="cardName_zjhm">证件号码</td>
      <td class="detailtd2"><span id="zjhm"></span>&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_xb">性别</td>
      <td class="detailtd2"><span id="xb"></span>&nbsp;</td>
      <td class="distd1" id="cardName_minzu">民族</td>
	  <td class="detailtd2"><span id="minzu"></span>&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_csrq">出生日期</td>
      <td class="detailtd2"><span id="csrq"></span>&nbsp;</td>
      <td class="distd1" id="cardName_zxbz">是否注销</td>
	  <td class="detailtd2"><span id="zxbz"></span>&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_hjsx">户籍省县市</td>
      <td class="detailtd2" colspan="3"><span id="hjsx"></span>&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_hjdxz">户籍详细地址</td>
      <td class="detailtd2" colspan="3"><span id="hjdxz"></span>&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_ywm">英文名</td>
	  <td class="detailtd2"><span id="ywm"></span>&nbsp;</td>
      <td class="distd1" id="cardName_ywx">英文姓</td>
	  <td class="detailtd2"><span id="ywx"></span>&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_gj">国籍</td>
	  <td class="detailtd2"><span id="gj"></span>&nbsp;</td>
      <td class="distd1" id="cardName_wgrjyxkz">就业许可证号</td>
	  <td class="detailtd2"><span id="wgrjyxkz"></span>&nbsp;</td>
    </tr>
    <tr style="display:none">
      <td class="distd1" id="cardName_hjlb">户籍类别</td>
	  <td class="detailtd2"><span id="hjlbmc"></span>&nbsp;</td>
      <td class="distd1" id="cardName_cylb">从业人员类别</td>
	  <td class="detailtd2"><span id="cylb"></span>&nbsp;</td>
    </tr>
    <tr>
      <td class="distd1" id="cardName_rjrq">有效起始日期</td>
      <td class="detailtd2"><span id="rjrq"></span>&nbsp;</td>
      <td class="distd1" id="cardName_zatlq">有效截至日期</td>
      <td class="detailtd2"><span id="zatlq"></span>&nbsp;</td>
    </tr>
</table>
<script language="javascript" type="text/javascript">
	OpenRead();
	//infoWrite();
</script>
