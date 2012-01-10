<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
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
	cardInfoArr[11]='ywm';
	cardInfoArr[12]='ywx';
	cardInfoArr[13]='gj';
	cardInfoArr[14]='wgrjyxkz'; //外国人就业许可证
	cardInfoArr[15]='ickkh'; //IC卡卡号
	
	$(document).ready(function() {
		$("#h_wlid").attr("value",dataid);
		$("#m_wlid").attr("value",dataid);
		$("#q_wlid").attr("value",dataid);
		
		$("#ickknxx").empty();
		$("#ickknxx").load("public/skOne.jsp");
		$("#ickknxx").show("slow");
		
		setParams("q_");
		jQuery.post('icksystem/queryWldjIckCount_wldj.action',params,ickCountBack,"json");
			
		$("#tpnrImg").attr("src","icksystem/queryCyryzpImage_wldj.action?cyrybh=no");
	}); 
	
	function ickCountBack(json){
		if (json.result=="success"){
			$("#ji_gyjl").append(setNull(json.totalrows));
			$("#jl_qrjl").append('0');
		}else{
			jAlert(json.result,'错误信息');
		}
	}
	function shuaka(){
		setParams("h_");
		jQuery.ajax({
			type: 'POST',
			url: 'icksystem/CyrybhExistInIcksl_wldj.action',
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				shukaback(rows);
			}
		});
	}
	function shukaback(json){
		$(".red").removeClass("red");
		$('span[@id^="db_"]').html("").end();
		$("#tpnrImg").attr("src","");
		if (json.result=="success"){
			if(json.exitIckslList.length>0){
				$("#db_xingming").append(setNull(json.exitIckslList[0].xm));
				changeRedFont(0,setNull(json.exitIckslList[0].xm));
				$("#db_cyrybh").append(setNull(json.exitIckslList[0].cyrybh));
				changeRedFont(1,setNull(json.exitIckslList[0].cyrybh));
				$("#db_zjhm").append(setNull(json.exitIckslList[0].zjhm));
				//$("#db_zjhm").append(setNull(json.exitIckslList[0].zjhm));
				changeRedFont(2,setNull(json.exitIckslList[0].zjhm));
				$("#db_xb").append(setNull(json.exitIckslList[0].xb));
				changeRedFont(3,setNull(json.exitIckslList[0].xb));
				
				$("#db_minzu").append(setNull(json.exitIckslList[0].minzu));
				changeRedFont(4,setNull(json.exitIckslList[0].minzu));
				$("#db_csrq").append(changeRqiNyr(json.exitIckslList[0].csrq));
				changeRedFont(6,changeRqiNyr(json.exitIckslList[0].csrq));
				$("#db_hjsx").append(setNull(json.exitIckslList[0].hjdxzqh));
				changeRedFont(7,setNull(json.exitIckslList[0].hjdxzqh));
				$("#db_hjdxz").append(setNull(json.exitIckslList[0].hjdxz));
				changeRedFont(8,setNull(json.exitIckslList[0].hjdxz));
				
				$("#db_rjrq").append(changeRqiNyr(json.exitIckslList[0].yxsksrq));
				changeRedFont(9,changeRqiNyr(json.exitIckslList[0].yxsksrq));
				$("#db_zatlq").append(changeRqiNyr(json.exitIckslList[0].yxqhzrq));
				changeRedFont(10,changeRqiNyr(json.exitIckslList[0].yxqhzrq));
				$("#db_ywm").append(setNull(json.exitIckslList[0].ywm));
				changeRedFont(11,setNull(json.exitIckslList[0].ywm));
				$("#db_ywx").append(setNull(json.exitIckslList[0].ywx));
				changeRedFont(12,setNull(json.exitIckslList[0].ywx));
				$("#db_gj").append(setNull(json.exitIckslList[0].gj));
				changeRedFont(13,setNull(json.exitIckslList[0].gj));
				$("#db_wgrjyxkz").append(setNull(json.exitIckslList[0].wgrjyxkz));
				changeRedFont(14,setNull(json.exitIckslList[0].wgrjyxkz));
				$("#db_ickkh").append(setNull(json.exitIckslList[0].kh));
				changeRedFont(15,setNull(json.exitIckslList[0].kh));
				
				$("#db_csbm").append(setNull(json.exitIckslList[0].qybm));
				$("#db_csmc").append(setNull(json.exitIckslList[0].qymc));
				$("#db_cjr").append(setNull(json.exitIckslList[0].cjr));
				$("#db_zt").append(setNull(json.exitIckslList[0].cyryzt));
				$("#db_cjdbm").append(setNull(json.exitIckslList[0].cjdbm));
				$("#db_cjdmc").append(setNull(json.exitIckslList[0].cjdmc));
				
				var cyrybh = $("#h_cyrybh").attr("value"); //照片
				$("#tpnrImg").attr("src","icksystem/queryCyryzpImage_wldj.action?cyrybh="+cyrybh);
		
				var cyrybhSet = $("#m_cyrybhSet").attr("value");
				var bcqrsksl = $("#m_bcqrsksl").attr("value");
				if(cyrybhSet.indexOf(cardInfoVal[1])<0){
					cyrybhSet = cyrybhSet + ",'"+cardInfoVal[1]+"'";
					$("#m_cyrybhSet").attr("value",cyrybhSet);
					$("#m_bcqrsksl").attr("value",parseInt(bcqrsksl,10)+1);
					
					$("#jl_qrjl").html("");
					$("#jl_qrjl").append(parseInt(bcqrsksl,10)+1);
				} else {
					jAlert('此卡已经刷过','提示信息');
				}
			} else {
				jAlert('没查到数据','提示信息');
				$("#tpnrImg").attr("src","icksystem/queryCyryzpImage_wldj.action?cyrybh=no");
			}
		} else {
			jAlert('异常,请重试','提示信息');
			$("#tpnrImg").attr("src","icksystem/queryCyryzpImage_wldj.action?cyrybh=no");
		}
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
	function changeRedFont(index,val){ //不同时 红色字体
		$("#"+cardInfoArr[index]).removeClass("red");
		$("#db_"+cardInfoArr[index]).removeClass("red");
		$("#pageName_"+cardInfoArr[index]).removeClass("red");
		$("#cardName_"+cardInfoArr[index]).removeClass("red");
		if(cardInfoVal[index]!=val){ 
			$("#"+cardInfoArr[index]).addClass("red");
			$("#db_"+cardInfoArr[index]).addClass("red");
			$("#pageName_"+cardInfoArr[index]).addClass("red");
			$("#cardName_"+cardInfoArr[index]).addClass("red");
		}
	}
	function setJieShou(){
		if(isCanSubmit==0){
			jAlert('请刷卡','提示信息');
			return;
		}
		setParams("m_");
		jQuery.ajax({
			type: 'POST',
			url: 'icksystem/wldjJieShou_wldj.action',
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				jieShouback(rows);
			}
		});
	}
	function jieShouback(json){
		if (json.result=="success"){
			jAlert('操作成功','保存信息');
			$("#wldj_detail").hideAndRemove("show"); 
			setPageList(1);
		}else{
			jAlert(json.result,'错误信息');
		}
	}
	//刷卡掉此方法
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
		//获取卡内信息结束
		var ick_ickh=document.getElementById('ctlICCard').cardno;
	    var ick_kh=cardInfoVal[15];
	    var ick_cyrybh=cardInfoVal[1];
		$("#h_kh").attr("value",ick_kh); //将卡号放到隐藏域里 待查询数据库用
		$("#h_cyrybh").attr("value",ick_cyrybh); //将从业人员编号放到隐藏域里 待查询数据库用
		///根据情况传递值，若kh为null或者cyrybh长度小于等于19，用ickh更新kh和cyrybh
		if (ick_kh==null||ick_kh=="null"||ick_kh==""||ick_cyrybh.length<19) {
		$("#x_ickh").attr("value",ick_ickh);
		$("#x_zkztbs").attr("value","23");
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
		$("#h_kh").attr("value",setNull(json.LIcksl[0].kh)); //将卡号放到隐藏域里 待查询数据库用
		$("#h_cyrybh").attr("value",setNull(json.LIcksl[0].cyrybh)); //将从业人员编号放到隐藏域里 待查询数据库用
		cardInfoVal[15]=setNull(json.LIcksl[0].kh);
		cardInfoVal[1]=setNull(json.LIcksl[0].cyrybh);
		} else {
		jAlert(json.result,'提示信息');
		}
		isCanSubmit = 1;
		xmlObj = xml;
		shuaka();
	}
	var xmlObj
	var isCanSubmit = 0;
</script>
<input type="hidden" id="q_wlid" value="">

<input type="hidden" id="m_wlid" value="">
<input type="hidden" id="m_khSet" value="">
<input type="hidden" id="m_cyrybhSet" value="">
<input type="hidden" id="m_bcqrsksl" value="0">
<input type="hidden" id="x_ickh" value="">
<input type="hidden" id="x_zkztbs" value="">
<input type="hidden" id="h_kh" value="">
<input type="hidden" id="h_cyrybh" value="">
<input type="hidden" id="h_wlid" value="">

<div align="right">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">物流接收</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#wldj_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>

  <table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC卡卡内信息</td>
    </tr>
    <tr>
      <td class="tdbg">
      <div id="ickknxx"></div>
      </td>
    </tr>
  </table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
  <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">人员、IC申请原信息</td>
    </tr>
    <tr>
      <td class="tdbg">
      <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
        <tr>
          <td width="11%" class="distd1">企业名称</td>
          <td width="30%" class="detailtd2"><span id="db_csmc"></span></td>
          <td width="11%" class="distd1">企业编码</td>
          <td width="30%" class="detailtd2"><span id="db_csbm"></span></td>
          <td width="18%" rowspan="12" align="center" valign="top" class="detailtd2">
          <table border="0" align="center" cellpadding="8" cellspacing="0">
              <tr>
                <td><img id="tpnrImg" width="118" height="149"/></td>
              </tr>
          </table>
          </td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_xingming">姓名</td>
          <td class="detailtd2"><span id="db_xingming"></span></td>
          <td class="distd1" id="pageName_ickkh">IC卡号</td>
          <td class="detailtd2"><span id="db_ickkh"></span></td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_cyrybh">人员编号</td>
          <td class="detailtd2"><span id="db_cyrybh"></span></td>
          <td class="distd1" id="pageName_zjhm">公民身份号码</td>
          <td class="detailtd2"><span id="db_zjhm"></span></td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_xb">性别</td>
          <td class="detailtd2"><span id="db_xb"></span></td>
          <td class="distd1" id="pageName_minzu">民族</td>
          <td class="detailtd2"><span id="db_minzu"></span></td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_csrq">出生日期</td>
          <td colspan="3" class="detailtd2"><span id="db_csrq"></span></td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_hjsx">户籍省县</td>
          <td colspan="3" class="detailtd2"><span id="db_hjsx"></span></td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_hjdxz">户籍地详址</td>
          <td colspan="3" class="detailtd2"><span id="db_hjdxz"></span></td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_ywm">英文名</td>
          <td class="detailtd2"><span id="db_ywm"></span></td>
          <td class="distd1" id="pageName_ywx">英文姓</td>
          <td class="detailtd2"><span id="db_ywx"></span></td>
        </tr>
        <tr>
          <td class="distd1">国籍</td>
          <td class="detailtd2" id="pageName_gj"><span id="db_gj"></span></td>
          <td class="distd1" id="pageName_wgrjyxkz">就业许可证号</td>
          <td class="detailtd2"><span id="db_wgrjyxkz"></span></td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_rjrq">有效起始日期</td>
          <td class="detailtd2"><span id="db_rjrq"></span></td>
          <td class="distd1" id="pageName_zatlq">有效结束日期</td>
          <td class="detailtd2"><span id="db_zatlq"></span></td>
        </tr>
        <tr>
          <td class="distd1">采集人</td>
          <td class="detailtd2"><span id="db_cjr"></span></td>
          <td class="distd1">记录状态</td>
          <td class="detailtd2"><span id="db_zt"></span></td>
        </tr>
        <tr>
          <td class="distd1">采集点编码</td>
          <td class="detailtd2"><span id="db_cjdbm"></span></td>
          <td class="distd1">采集点名称</td>
          <td class="detailtd2"><span id="db_cjdmc"></span></td>
        </tr>
      </table>
    </td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="2">
	<tr height="25" align="center">
	  <td width="50%" align="left">
	  <font color="red">该物流包中共有&nbsp;<span id="ji_gyjl"></span>条记录，已确认&nbsp;<span id="jl_qrjl"></span>条记录</font>
	  </td>
	  <td width="50%" align="left">
	  <a href="#" hidefocus="true" class="submitbutton" title="接收" onclick='setJieShou();'>接收</a>
	  </td>
	</tr>
</table>
</div>
