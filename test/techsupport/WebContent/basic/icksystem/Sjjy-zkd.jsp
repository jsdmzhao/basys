<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var xmlObj = null;
	var allRight = true;
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
		$("#ickknxx").empty();
		$("#ickknxx").load("public/skOne.jsp");
		$("#ickknxx").show("slow");
			
		$("#tpnrImg").attr("src","icksystem/queryCyryzpImage_wldj.action?cyrybh=no");
	}); 
	
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
		///取得ick芯片号，kh和cyrybh
	    var ick_ickh=document.getElementById('ctlICCard').cardno;
	    var ick_kh=cardInfoVal[15];
	    var ick_cyrybh=cardInfoVal[1];
	    //ick_kh=null;//调试代码，模拟旧卡信息
		//获取卡内信息结束
		$("#h_kh").attr("value",ick_kh); //将卡号放到隐藏域里 待查询数据库用
		$("#h_cyrybh").attr("value",ick_cyrybh); //将从业人员编号放到隐藏域里 待查询数据库用
		///根据情况传递值，若kh为null或者cyrybh长度小于19，用ickh更新kh和cyrybh
		if (ick_kh==null||ick_kh=="null"||ick_kh==""||ick_cyrybh.length<19) {
		$("#s_ickh").attr("value",ick_ickh);
		$("#s_zkztbs").attr("value","5");
		setParams("s_");
		jQuery.post('icksystem/queryKhcyrybm_icksl.action',params,ickhback,"json");
		} else {
		xmlObj = xml;
		shuaka();
		}
	}
	function ickhback(json){
		if(json.result=='success'){
		//用数据库中的数据替代卡中的信息
		$("#h_kh").attr("value",setNull(json.LIcksl[0].kh)); //将卡号放到隐藏域里 待查询数据库用
		$("#h_cyrybh").attr("value",setNull(json.LIcksl[0].cyrybh)); //将从业人员编号放到隐藏域里 待查询数据库用
		} else {
		jAlert(json.result,'提示信息');
		}
		xmlObj = xml;
		shuaka();
	}
	function shuaka(){
		allRight = true;
		setParams("h_");
		jQuery.post('icksystem/sjjyCyry_wldj.action',params,shukaback,"json");
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
				
				var cyrybh = $("#h_cyrybh").attr("value"); //照片
				$("#tpnrImg").attr("src","icksystem/queryCyryzpImage_wldj.action?cyrybh="+cyrybh);
				/*重庆娱乐业制卡流程变更，此处不需改变物流发送状态
				if(allRight){
					setParams("h_");
					jQuery.post('icksystem/sjjyBackYwxy_wldj.action',params,null,"json");
				}
				*/
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
			allRight = false;
		}
	}
</script>
<input type="hidden" class="inputstyle" id="h_kh" value="">
<input type="hidden" class="inputstyle" id="h_cyrybh" value="">
<input type="hidden" class="inputstyle" id="s_ickh" value="">
<input type="hidden" class="inputstyle" id="s_zkztbs" value="">
<div align="right">
  <table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC卡卡内信息</td>
    </tr>
    <tr>
      <td class="tdbg">
      <div id="ickknxx"></div>
      </td>
    </tr>
  </table>	
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="2"></td>
		</tr>
  </table>
  <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">人员、IC申请原信息</td>
    </tr>
    <tr>
      <td class="tdbg">
      <table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
        <tr>
          <td width="11%" class="distd1" id="pageName_xingming">姓名</td>
          <td width="30%" class="detailtd2"><span id="db_xingming"></span>&nbsp;</td>
          <td width="11%" class="distd1" id="pageName_ickkh">IC卡卡号</td>
          <td width="30%" class="detailtd2"><span id="db_ickkh"></span>&nbsp;</td>
          <td width="18%" rowspan="13" align="center" valign="top" class="detailtd2">
	          <table border="0" align="center" cellpadding="8" cellspacing="0">
	              <tr>
	                <td><img id="tpnrImg" width="118" height="149"/></td>
	              </tr>
	          </table>
          </td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_cyrybh">从业人员编号</td>
          <td class="detailtd2"><span id="db_cyrybh"></span>&nbsp;</td>
          <td class="distd1" id="pageName_zjhm">证件号码</td>
          <td class="detailtd2"><span id="db_zjhm"></span>&nbsp;</td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_xb">性别</td>
          <td class="detailtd2"><span id="db_xb"></span>&nbsp;</td>
          <td class="distd1" id="pageName_minzu">民族</td>
          <td class="detailtd2"><span id="db_minzu"></span>&nbsp;</td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_csrq">出生日期</td>
          <td colspan="3" class="detailtd2"><span id="db_csrq"></span>&nbsp;</td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_hjsx">户籍省县市</td>
          <td colspan="3" class="detailtd2"><span id="db_hjsx"></span>&nbsp;</td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_hjdxz">户籍详细地址</td>
          <td colspan="3" class="detailtd2"><span id="db_hjdxz"></span>&nbsp;</td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_ywm">英文名</td>
          <td class="detailtd2"><span id="db_ywm"></span>&nbsp;</td>
          <td class="distd1" id="pageName_ywx">英文姓</td>
          <td class="detailtd2"><span id="db_ywx"></span>&nbsp;</td>
        </tr>
        <tr>
          <td class="distd1">国籍</td>
          <td class="detailtd2" id="pageName_gj"><span id="db_gj"></span>&nbsp;</td>
          <td class="distd1" id="pageName_wgrjyxkz">就业许可证号</td>
          <td class="detailtd2"><span id="db_wgrjyxkz"></span>&nbsp;</td>
        </tr>
        <tr>
          <td class="distd1" id="pageName_rjrq">有效起始日期</td>
          <td class="detailtd2"><span id="db_rjrq"></span>&nbsp;</td>
          <td class="distd1" id="pageName_zatlq">有效截至日期</td>
          <td class="detailtd2"><span id="db_zatlq"></span>&nbsp;</td>
        </tr>
      </table>
	</td>
    </tr>
</table>
</div>
