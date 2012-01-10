<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.Globalpar"%>
<%@ page import="java.util.List"%>
<%@ page import="com.aisino2.cache.CacheManager" %>
<%
        String kffsfxycs = null ;//从缓存中得到 "卡发放是否需要选择场所"(全局参数)
        boolean displayQY = false;
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode("kffsfxycs");
		List list = CacheManager.getCacheGlobalpar(globalpar);
		if(list!=null&&list.size()>0){
			kffsfxycs = ((Globalpar)list.get(0)).getGlobalparvalue();
		}
		if(kffsfxycs!=null && "1".equals(kffsfxycs)){
		    displayQY = true;
		}
%>
<script type="text/javascript">
var flag = <%=displayQY%>;
var cardInfoVal = new Array();
var cardInfoArr = new Array();
	cardInfoArr[0]='xingming'; 
	cardInfoArr[1]='cyrybh';
	cardInfoArr[2]='zjhm';
	cardInfoArr[3]='xb';   
	cardInfoArr[4]='minzu';  
	cardInfoArr[5]='zxbz'; //注销标识
	          
	cardInfoArr[6]='csrq'; //出生日期
	cardInfoArr[7]='hjsx'; //户籍省县
	cardInfoArr[8]='hjdxz'; //户籍详细地址
	cardInfoArr[9]='rjrq'; //有效起始日期
	cardInfoArr[10]='zatlq'; //有效截至日期
	cardInfoArr[11]='ywx';
	cardInfoArr[12]='ywm';
	cardInfoArr[13]='gj';
	cardInfoArr[14]='wgrjyxkz'; //外国人就业许可证
	
	$(document).ready(function() {
	    if (flag){
	        $("#qy").show();
	    }else{
	        $("#qy").hide();
	    }
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+-1);
		loadIckknxx();
	}).keydown(function(){
		if(event.keyCode == 13)
			updateAll();
	});; 
	
	function loadIckknxx(){
		$("#div_ickknxx").empty();
		$("#div_ickknxx").load("public/skOne.jsp");
		$("#div_ickknxx").show("slow");
	}
	
	function reloadInput(){
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+-1);
		$("#input_cyryxx").find("input[type='text']").val("");
		$("#m_khSet").val("0");
	}
	
function updatediv (json) { 
	if(json.result=="success"){
		if(json.LIcksl.length>0){
			$("#w_ryid").val(setNull(json.LIcksl[0].ryid))
			$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+$("#w_ryid").val());
		
			$("#s_xingming").val(setNull(json.LIcksl[0].xm));
			changeRedFont(0,setNull(json.LIcksl[0].xm));
			$("#s_cyrybh").val(setNull(json.LIcksl[0].cyrybh));
			changeRedFont(1,setNull(json.LIcksl[0].cyrybh));
			$("#s_zjhm").val(setNull(json.LIcksl[0].zjhm));
			changeRedFont(2,setNull(json.LIcksl[0].zjhm));
			$("#s_xb").val(setNull(json.LIcksl[0].xb));
			changeRedFont(3,setNull(json.LIcksl[0].xb));
			$("#s_minzu").val(setNull(json.LIcksl[0].minzu));
			changeRedFont(4,setNull(json.LIcksl[0].minzu));
			$("#s_csrq").val(changeRqiNyr(setNull(json.LIcksl[0].csrq)));
			changeRedFont(6,changeRqiNyr(setNull(json.LIcksl[0].csrq)));
			$("#s_hjsx").val(setNull(json.LIcksl[0].hjdxzqh));
			changeRedFont(7,setNull(json.LIcksl[0].hjdxzqh));
			$("#s_hjdxz").val(setNull(json.LIcksl[0].hjdxz));
			changeRedFont(8,setNull(json.LIcksl[0].hjdxz));
			
			$("#s_rjrq").val(changeRqiNyr(setNull(json.LIcksl[0].yxsksrq).substring(0,10)));
			changeRedFont(9,changeRqiNyr(setNull(json.LIcksl[0].yxsksrq).substring(0,10)));
			$("#s_zatlq").val(changeRqiNyr(setNull(json.LIcksl[0].yxqhzrq).substring(0,10)));
			changeRedFont(10,changeRqiNyr(setNull(json.LIcksl[0].yxqhzrq).substring(0,10)));
			
			$("#s_ywx").val(setNull(json.LIcksl[0].ywx));
			changeRedFont(11,setNull(json.LIcksl[0].ywx));
			$("#s_ywm").val(setNull(json.LIcksl[0].ywm));
			changeRedFont(12,setNull(json.LIcksl[0].ywm));
			$("#s_gj").val(setNull(json.LIcksl[0].gj));
			changeRedFont(13,setNull(json.LIcksl[0].gj));
			$("#s_wgrjyxkz").val(setNull(json.LIcksl[0].wgrjyxkz));
			changeRedFont(14,setNull(json.LIcksl[0].wgrjyxkz));
			
			$("#s_qymc").val(setNull(json.LIcksl[0].qymc));
			$("#s_qybm").val(setNull(json.LIcksl[0].qybm));
			$("#s_cjdmc").val(setNull(json.LIcksl[0].cjdmc));
			$("#s_cjdbm").val(setNull(json.LIcksl[0].cjdbm));
			$("#s_jlzt").val(setNull(json.LIcksl[0].cyryzt));
			$("#s_cjr").val(setNull(json.LIcksl[0].cjr));
			$("#s_hjdxz").val(setNull(json.LIcksl[0].hjdxz));
			$("#s_kh").val(setNull(json.LIcksl[0].kh));
			
			$("#m_khSet").val(setNull(json.LIcksl[0].kh));
			$("#m_cyrybhSet").val(setNull(json.LIcksl[0].cyrybh));
			if(setNull(json.LIcksl[0].hylbdm)=='J'||setNull(json.LIcksl[0].hylbdm)=='K'){
			$("#dtd_qymc").val("场所名称");
			$("#dtd_qybh").val("场所编号");
			}
		}else{
			$("#m_khSet").val("");
			$("#m_cyrybhSet").val("");
			jAlert('没有该人员的信息','提示信息');
		}
	}else{
		$("#m_khSet").val("");
		$("#m_cyrybhSet").val("");
		jAlert(json.result,"提示信息");
	}
}	

function changeRedFont(index,val){ //不同时 红色字体
	$("#s_"+cardInfoArr[index]).css("color","");
	if(cardInfoVal[index]!=val){ 
		$("#s_"+cardInfoArr[index]).css("color","red");
	}
}
	
//刷卡调此方法
	function setXmlAddData(xml){
		//获取卡内信息开始
		for(var index=0,max=cardInfoArr.length;index<max;index++){
			var temp0 = '<'+cardInfoArr[index]+'>';
			var temp1 = '</'+cardInfoArr[index]+'>';
			var h0 = temp0.length;
			var h1 = xml.indexOf(temp0);
			var h2 = xml.indexOf(temp1);
			cardInfoVal[index] = xml.substr((h1+h0),(h2-h1-h0));
		}
		///取得ick芯片号和cyrybh
	    var ick_ickh=document.getElementById('ctlICCard').cardno;
	    var ick_cyrybh=cardInfoVal[1];
		//获取卡内信息结束
		//$("#h_kh").attr("value",cardInfoVal[1]); //将卡号放到隐藏域里 待查询数据库用
		$("#q_cyrybh").attr("value",ick_cyrybh); //将从业人员编号放到隐藏域里 待查询数据库用
		//$("#q_kh").attr("value",cardInfoVal[1]); //将卡号放到隐藏域里 待查询数据库用
		///根据情况传递值，若kh为null或者cyrybh长度小于19，用ickh更新kh和cyrybh
		if (ick_cyrybh.length<19) {
		$("#x_ickh").attr("value",ick_ickh);
		$("#x_zkztbs").attr("value","24");
		setParams("x_");
		jQuery.post('icksystem/queryKhcyrybm_icksl.action',params,ickhback,"json");
		} else {
		isCanSubmit = 1;
		xmlObj = xml;
		shuaka();
		}
	}	
	function ickhback(json){
		if(json.result=='success'){
		//用数据库中的数据替代卡中的信息
		$("#q_cyrybh").attr("value",setNull(json.LIcksl[0].cyrybh)); //将从业人员编号放到隐藏域里 待查询数据库用
		} else {
		jAlert(json.result,'提示信息');
		}
		isCanSubmit = 1;
		xmlObj = xml;
		shuaka();
	}
	function shuaka(){
		setParams("q_");
		jQuery.post('icksystem/queryFf_icksl.action',params,updatediv,"json");
	}
	
	function ffIckBack(json){
		if(json.result=="success"){
			jAlert("发放成功","提示信息");
			//loadIckknxx();
			reloadInput();
		}else{
			jAlert(json.result,"错误信息");
		}
	}
	
	function updateAll(){
		var kh = $("#m_khSet").val();
		var cyrybh = $("#m_cyrybhSet").val();
		if(kh=="0"){
			jAlert('请先刷卡','提示信息');
		}
		else if(kh==""||cyrybh==""){
			jAlert('该卡不能发放','提示信息');
		}else{
			setParams("m_");
			jQuery.post('icksystem/modifyff_icksl.action',params,ffIckBack,"json");
		}
	}
	
function closeAll(){
	//setPageList($("#pageNo").attr("value"));
	$("#ctlICCard").remove();
	$("#device").remove();
	$("#ickff_detail").hideAndRemove("show");
}

function changeRqiNyr(obj){ //改变日期格式为年月日
		obj = setNull(obj);
		if(obj!=''){
			obj = obj.replace("-","年");
			obj = obj.replace("-","月");
			obj = obj + '日';
		}
		return obj;
	}
	
// 企业筛选框
$("#qymc").click(function(){
    //dataid="";
    dataid=$('#p_hylbdm').val();
 	getTy_item_ymgn("qymc","q_qybm","","","","ickff");//页面功能 ickff:IC卡发放
  });
</script>
<input type="hidden" id="x_ickh" value="">
<input type="hidden" id="x_zkztbs" value="">
<input type="hidden" id="q_ickslid">
<input type="hidden" id="q_cyrybh">
<input type="hidden" id="w_ryid">
<input type="hidden" id="q_kh">
<input type="hidden" id="m_cyrybhSet" />
<input type="hidden" id="m_khSet" value="0" /><div align="right">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">IC卡发放</td>
      <td><a href="#" id="closeDiv" onclick='closeAll();'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
<div class="scrollbarface" style="height:500;overflow-y:auto;">
<table id="qy" width="98%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr>
      <td class="queryfont" colspan="2">选择企业</td>
    </tr>
    <tr>
      <td class="red" width="10%">企业名称</td><td class="detailtd2"><input type="text" id="qymc" readonly class="inputstyle" style="width:180" /><input type="hidden" id="q_qybm" /></td>
    </tr>
    <tr>
      <td colspan="2" height="6"></td>
    </tr>
</table>
  <table width="98%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC卡卡内信息</td>
    </tr>
    <tr>
      <td class="tdbg"><div id="div_ickknxx"></div></td>
    </tr>
  </table>
<table width="98%" border="0" cellspacing="0" cellpadding="0">
<tr>
      <td height="6"><table align="right" width="100%" border="0" cellspacing="0" cellpadding="2">
              <tr height="25" align="right">
                <td width="95%"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="发放" onclick='updateAll();'>发放</a></td>
               <td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭"  onclick='closeAll();'>关闭</a></td>
              </tr>
          </table></td>
    </tr>
  </table>
<table width="98%" cellpadding="0" cellspacing="0"  class="tableborder" id="input_cyryxx">
<tr>
      <td class="queryfont">人员、IC申请原信息</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%"  cellpadding="3" cellspacing="0" class="detail" id="detail" >
        <tr height="20">
          <td width="10%" class="distd1" id="dtd_qymc">企业名称</td>
          <td width="26%"  class="detailtd2"><input type="text"  id="s_qymc" readonly class="readonly" /></td>
          <td width="14%" class="distd1" id="dtd_qybh">企业编号</td>
          <td width="23%" class="detailtd2"><input type="text"   id="s_qybm" readonly class="readonly" /></td>
          <td colspan="2" rowspan="7" align="center" valign="top" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="125" height="160" src="" /></td></tr>
      </table></td>
        </tr>
        <tr height="20">
          <td width="10%" class="distd1">姓名</td>
          <td width="26%" class="detailtd2"><input type="text" id="s_xingming" readonly class="readonly" /></td>
          <td width="14%" class="distd1">IC卡卡号</td>
          <td width="23%" class="detailtd2"><input type="text" id="s_kh" readonly class="readonly" /></td>
        </tr>
        <tr height="20">
          <td width="10%" class="distd1">人员编号</td>
          <td width="26%"  class="detailtd2"><input type="text" id="s_cyrybh" readonly class="readonly" /></td>
          <td class="distd1">公民身份号码</td>
          <td class="detailtd2"><input type="text" id="s_zjhm" readonly class="readonly" /></td>
        </tr>
        <tr height="20">
          <td class="distd1">性别</td>
          <td class="detailtd2"><input type="text"  id="s_xb" readonly class="readonly" /></td>
          <td class="distd1">民族</td>
          <td class="detailtd2"><input type="text" id="s_minzu" readonly class="readonly" /></td>
        </tr>
        <tr height="20">
          <td class="distd1">出生日期</td>
          <td colspan="3" class="detailtd2"><input type="text" id="s_csrq" readonly class="readonly" /></td>
        </tr>
        <tr height="20">
          <td class="distd1">户籍省县</td>
          <td colspan="3" class="detailtd2"><input type="text" id="s_hjsx" readonly class="readonly" /></td>
        </tr>
        <tr height="20">
          <td class="distd1">户籍地详址</td>
          <td colspan="3" class="detailtd2"><input type="text" id="s_hjdxz" readonly class="readonly" style="width:88%" /></td>
        </tr>
        <tr height="20">
          <td class="distd1">英文名</td>
          <td class="detailtd2"><input type="text" id="s_ywm" readonly class="readonly" /></td>
          <td class="distd1">英文姓</td>
          <td class="detailtd2"><input type="text" id="s_ywx" readonly class="readonly" /></td>
          <td width="10%" class="distd1">国籍</td>
          <td width="17%" class="detailtd2"><input type="text" id="s_gj" readonly class="readonly" /></td>
        </tr>
        <tr height="20">         
          <td class="distd1">就业许可证号</td>
          <td class="detailtd2"><input type="text" id="s_wgrjyxkz" readonly class="readonly" /></td>
          <td class="distd1">有效起始日期</td>
          <td class="detailtd2"><input type="text" id="s_rjrq" readonly class="readonly" /></td>
          <td class="distd1">有效结束日期</td>
          <td class="detailtd2"><input type="text" id="s_zatlq" readonly class="readonly" /></td>
        </tr>
        <tr height="20">
          <td height="22" class="distd1">采集人</td>
          <td class="detailtd2"><input type="text" id="s_cjr" readonly class="readonly" /></td>
          <td class="distd1">记录状态</td>
          <td class="detailtd2"><input type="text" id="s_jlzt" readonly class="readonly" /></td>
          <td class="distd1">采集点编码</td>
          <td class="detailtd2"><input type="text" id="s_cjdbm" readonly class="readonly" /></td>
         </tr>
        <tr height="20">
          <td class="distd1">采集点名称</td>
          <td colspan="5" class="detailtd2"><input type="text"  id="s_cjdmc" readonly class="readonly" /></td>
        </tr>
  </table>
</td>
              </tr>
</table>
