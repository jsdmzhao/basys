<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		//alert($("#m_bjxxid").attr("value"));
		setParams("m_");
		jQuery.post("<%=request.getContextPath()%>/basicsystem/query_qgztjx_kz.action",params,qgztkzdiv,"json"); // 提交到BjxxbAction中,调用其中的query方法
	}); 
	
	// 添加点击提示
	$("#tbbh").click(function(){
		alert("进入公安部全国在逃查询网站,请输入通报编号进行查询");
	});
	
	function qgztkzdiv (json) {             
		$("#bjsj_zt").append(setNull(json.LQgztjx_kz[0].bjsj));
		$("#bjlx_zt").append(setNull(json.LQgztjx_kz[0].bjlx));                
		$("#gmsfhm_zt").append(setNull(json.LQgztjx_kz[0].gmsfhm));
		$("#bm_zt").append(setNull(json.LQgztjx_kz[0].bm));
		$("#xm_zt").append(setNull(json.LQgztjx_kz[0].xm));
		$("#csrq_zt").append(setNull(json.LQgztjx_kz[0].csrq));
		$("#xb_zt").append(setNull(json.LQgztjx_kz[0].xb));
		$("#qtzjhm_zt").append(setNull(json.LQgztjx_kz[0].qtzjhm));
		$("#tbbh_zt").append(setNull(json.LQgztjx_kz[0].tbbh));
		$("#hjd_zt").append(setNull(json.LQgztjx_kz[0].hjd));
		$("#xzdq_zt").append(setNull(json.LQgztjx_kz[0].xzdq));
		$("#xzqh_zt").append(setNull(json.LQgztjx_kz[0].xzqh));
		$("#djrq_zt").append(setNull(json.LQgztjx_kz[0].djrq));
		$("#hjxxdz_zt").append(setNull(json.LQgztjx_kz[0].hjxxdz));
		$("#ladq_zt").append(setNull(json.LQgztjx_kz[0].ladq));
		$("#xzdxxdz_zt").append(setNull(json.LQgztjx_kz[0].xzdxxdz));
		//$("#badw").append(setNull(json.LQgztjx_kz[0].badw));
		$("#ajlb_zt").append(setNull(json.LQgztjx_kz[0].ajlb));
		$("#tbr_zt").append(setNull(json.LQgztjx_kz[0].tbr));
		$("#lxr_zt").append(setNull(json.LQgztjx_kz[0].lxr));
	}	
</script>

<table width="100%"  cellpadding="0" cellspacing="0"  border="0" class="tableborder">
  <tr>
  	<td class="queryfont" colspan="6">全国在逃简要信息</td>
  </tr>
  <tr>
    <td colspan="6" valign="top" class="tdbg">
    <table width="100%" cellpadding="4" cellspacing="0" class="detail" id="detail">
      <tr>
      	<td width="13%" class="distd1">报警时间</td>
        <td width="20%" class="detailtd2"><span id="bjsj_zt"/></span></td>
        <td width="13%" class="distd1">报警类型</td>
        <td width="20%" class="detailtd2"><span id="bjlx_zt"/></span></td>
        <td width="13%" class="distd1">姓名</td>
        <td width="20%" class="detailtd2"><span id="xm_zt"/></span></td>
	  </tr>
      <tr>
        <td width="13%" class="distd1">身份证号码</td>
        <td width="20%" class="detailtd2"><span id="gmsfhm_zt"/></span></td>
        <td width="13%" class="distd1">别名</td>
        <td width="20%" class="detailtd2"><span id="bm_zt"/></span></td>
        <td class="distd1">出生日期</td>
        <td class="detailtd2"><span id="csrq_zt"/></span></td>
      </tr>
      <tr>
        <td class="distd1">性别</td>
        <td class="detailtd2"><span id="xb_zt"/></span></td>
        <td class="distd1">其他证件</td>
        <td class="detailtd2"><span id="qtzjhm_zt"/></span></td>
        <td class="distd1">通报编号</td>
        <td class="detailtd2"><a href="http://ztry.xz.ga/" class="hyperlink" target="_blank"><span id="tbbh_zt"/></span></a></td>
      </tr>
      <tr>
        <td class="distd1">户籍地</td>
        <td class="detailtd2"><span id="hjd_zt" value="0" /></span></td>
        <td class="distd1">现住地区</td>
        <td class="detailtd2"><span id="xzdq_zt"/></span></td>
        <td class="distd1">行政区划</td>
        <td class="detailtd2"><span id="xzqh_zt"/></span></td>
      </tr>
      <tr>
        <td class="distd1">登记日期</td>
        <td class="detailtd2"><span id="djrq_zt"/></span></td>
	    <td class="distd1">户籍详细地址</td>
	    <td colspan="3" class="detailtd2" ><span readonly="readonly" class="readonly" id="hjxxdz_zt"/></span></td>
	  </tr>
	  <tr>
		<td class="distd1">填表人</td>
        <td class="detailtd2"><span id="tbr_zt"/></span></td>
	    <td class="distd1">立案地区</td>
	    <td class="detailtd2"><span id="ladq_zt"/></span></td>
	    <!--  <td class="distd1">办案单位</td>
	    <td class="detailtd2"><span id="badw"/></span></td>-->
	    <td class="distd1">案件类别</td>
	    <td class="detailtd2"><span id="ajlb_zt"/></span></td>
	  </tr>
	  <tr>
	  	<td class="distd1">现在地详细地址</td>
	    <td colspan="3" class="detailtd2" ><span readonly="readonly" class="readonly" id="xzdxxdz_zt"/></span></td>
	  	<td width="13%" class="distd1">联系人</td>
        <td width="20%" class="detailtd2"><span id="lxr_zt"/></span></td>
	  </tr>
    </table>
   	</td>
  </tr>
</table>