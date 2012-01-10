<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
		$("#m_bjxxid2").attr("value",dataid);
		setDetail();
		$("#m_bjsj").attr("readonly","true");
		$("#m_bjsj").datepicker();
		$("#m_pjsj").attr("readonly","true");
		$("#m_pjsj").datepicker();
		$("#m_chjsj").attr("readonly","true");
		$("#m_chjsj").datepicker();
		$("#m_fkrq").attr("readonly","true");
		$("#m_fkrq").datepicker();
		$("#m_zhsj").attr("readonly","true");
		$("#m_zhsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bjxxid2").attr("value",setNull(json.LWpbjxxb[0].bjxxid2));
		$("#m_ssqymc").attr("value",setNull(json.LWpbjxxb[0].ssqymc));
		$("#m_ssqydz").attr("value",setNull(json.LWpbjxxb[0].ssqydz));
		$("#m_gxdwbm").attr("value",setNull(json.LWpbjxxb[0].gxdwbm));
		$("#m_gxdwmc").attr("value",setNull(json.LWpbjxxb[0].gxdwmc));
		$("#m_bjlxdm").attr("value",setNull(json.LWpbjxxb[0].bjlxdm));
		$("#m_bjlx").attr("value",setNull(json.LWpbjxxb[0].bjlx));
		$("#m_bjsj").attr("value",setNull(json.LWpbjxxb[0].bjsj));
		$("#m_bdbm").attr("value",setNull(json.LWpbjxxb[0].bdbm));
		$("#m_ywbm").attr("value",setNull(json.LWpbjxxb[0].ywbm));
		$("#m_hylbdm").attr("value",setNull(json.LWpbjxxb[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LWpbjxxb[0].hylb));
		$("#m_jyaq").attr("value",setNull(json.LWpbjxxb[0].jyaq));
		$("#m_ladwbm").attr("value",setNull(json.LWpbjxxb[0].ladwbm));
		$("#m_ladwmc").attr("value",setNull(json.LWpbjxxb[0].ladwmc));
		$("#m_gxbbh").attr("value",setNull(json.LWpbjxxb[0].gxbbh));
		$("#m_ywlbdm").attr("value",setNull(json.LWpbjxxb[0].ywlbdm));
		$("#m_ywlb").attr("value",setNull(json.LWpbjxxb[0].ywlb));
		$("#m_pjbmbm").attr("value",setNull(json.LWpbjxxb[0].pjbmbm));
		$("#m_pjbmmc").attr("value",setNull(json.LWpbjxxb[0].pjbmmc));
		$("#m_pjr").attr("value",setNull(json.LWpbjxxb[0].pjr));
		$("#m_pjsj").attr("value",setNull(json.LWpbjxxb[0].pjsj));
		$("#m_jqztdm").attr("value",setNull(json.LWpbjxxb[0].jqztdm));
		$("#m_jqzt").attr("value",setNull(json.LWpbjxxb[0].jqzt));
		$("#m_cjbmbm").attr("value",setNull(json.LWpbjxxb[0].cjbmbm));
		$("#m_cjbm").attr("value",setNull(json.LWpbjxxb[0].cjbm));
		$("#m_chjsj").attr("value",setNull(json.LWpbjxxb[0].chjsj));
		$("#m_cjfzr").attr("value",setNull(json.LWpbjxxb[0].cjfzr));
		$("#m_lxdh").attr("value",setNull(json.LWpbjxxb[0].lxdh));
		$("#m_cjfklbdm").attr("value",setNull(json.LWpbjxxb[0].cjfklbdm));
		$("#m_cjfklb").attr("value",setNull(json.LWpbjxxb[0].cjfklb));
		$("#m_cjfkbz").attr("value",setNull(json.LWpbjxxb[0].cjfkbz));
		$("#m_fkdwbm").attr("value",setNull(json.LWpbjxxb[0].fkdwbm));
		$("#m_fkdw").attr("value",setNull(json.LWpbjxxb[0].fkdw));
		$("#m_fkrq").attr("value",setNull(json.LWpbjxxb[0].fkrq));
		$("#m_cjjg").attr("value",setNull(json.LWpbjxxb[0].cjjg));
		$("#m_cjjgdm").attr("value",setNull(json.LWpbjxxb[0].cjjgdm));
		$("#m_chjjg").attr("value",setNull(json.LWpbjxxb[0].chjjg));
		$("#m_zhsj").attr("value",setNull(json.LWpbjxxb[0].zhsj));
		$("#m_wxyydm").attr("value",setNull(json.LWpbjxxb[0].wxyydm));
		$("#m_wxyy").attr("value",setNull(json.LWpbjxxb[0].wxyy));
		$("#m_sfyxbjdm").attr("value",setNull(json.LWpbjxxb[0].sfyxbjdm));
		$("#m_sfyxbj").attr("value",setNull(json.LWpbjxxb[0].sfyxbj));
		$("#m_fkr").attr("value",setNull(json.LWpbjxxb[0].fkr));
		$("#m_ywbzj").attr("value",setNull(json.LWpbjxxb[0].ywbzj));
		$("#m_bdbzj").attr("value",setNull(json.LWpbjxxb[0].bdbzj));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_ssqymc","String",1,100,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("m_ssqydz","String",1,200,null,0,"所属企业地址"))
			return false;
		if (!checkControlValue("m_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_bjlxdm","String",1,4,null,0,"报警类型代码"))
			return false;
		if (!checkControlValue("m_bjlx","String",1,60,null,0,"报警类型"))
			return false;
		if (!checkControlValue("m_bjsj","Date",null,null,null,0,"报警时间"))
			return false;
		if (!checkControlValue("m_bdbm","String",1,100,null,0,"比对表名"))
			return false;
		if (!checkControlValue("m_ywbm","String",1,100,null,0,"业务表名"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,100,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("m_ladwbm","String",1,20,null,0,"立案单位编码"))
			return false;
		if (!checkControlValue("m_ladwmc","String",1,100,null,0,"立案单位名称"))
			return false;
		if (!checkControlValue("m_gxbbh","Integer",-999999,999999,null,0,"更新版本号"))
			return false;
		if (!checkControlValue("m_ywlbdm","String",1,2,null,0,"业务类别代码"))
			return false;
		if (!checkControlValue("m_ywlb","String",1,30,null,0,"业务类别"))
			return false;
		if (!checkControlValue("m_pjbmbm","String",1,20,null,0,"派警部门编码"))
			return false;
		if (!checkControlValue("m_pjbmmc","String",1,100,null,0,"派警部门名称"))
			return false;
		if (!checkControlValue("m_pjr","String",1,100,null,0,"派警人"))
			return false;
		if (!checkControlValue("m_pjsj","Date",null,null,null,0,"派警时间"))
			return false;
		if (!checkControlValue("m_jqztdm","String",1,2,null,0,"警情状态代码"))
			return false;
		if (!checkControlValue("m_jqzt","String",1,2,null,0,"警情状态"))
			return false;
		if (!checkControlValue("m_cjbmbm","String",1,20,null,0,"出警部门编码"))
			return false;
		if (!checkControlValue("m_cjbm","String",1,100,null,0,"出警部门"))
			return false;
		if (!checkControlValue("m_chjsj","Date",null,null,null,0,"出警时间"))
			return false;
		if (!checkControlValue("m_cjfzr","String",1,100,null,0,"出警负责人"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_cjfklbdm","String",1,2,null,0,"处警反馈类别代码"))
			return false;
		if (!checkControlValue("m_cjfklb","String",1,60,null,0,"处警反馈类别"))
			return false;
		if (!checkControlValue("m_cjfkbz","String",1,2000,null,0,"处警反馈备注"))
			return false;
		if (!checkControlValue("m_fkdwbm","String",1,20,null,0,"反馈单位编码"))
			return false;
		if (!checkControlValue("m_fkdw","String",1,100,null,0,"反馈单位"))
			return false;
		if (!checkControlValue("m_fkrq","Date",null,null,null,0,"反馈日期"))
			return false;
		if (!checkControlValue("m_cjjg","String",1,2000,null,0,"处警经过"))
			return false;
		if (!checkControlValue("m_cjjgdm","String",1,2,null,0,"处警结果代码"))
			return false;
		if (!checkControlValue("m_chjjg","String",1,60,null,0,"处警结果"))
			return false;
		if (!checkControlValue("m_zhsj","Date",null,null,null,0,"抓获时间"))
			return false;
		if (!checkControlValue("m_wxyydm","String",1,2,null,0,"无效原因代码"))
			return false;
		if (!checkControlValue("m_wxyy","String",1,60,null,0,"无效原因"))
			return false;
		if (!checkControlValue("m_sfyxbjdm","String",1,2,null,0,"是否有效报警代码"))
			return false;
		if (!checkControlValue("m_sfyxbj","String",1,30,null,0,"是否有效报警"))
			return false;
		if (!checkControlValue("m_fkr","String",1,60,null,0,"反馈人"))
			return false;
		if (!checkControlValue("m_ywbzj","String",1,30,null,0,"业务表主键"))
			return false;
		if (!checkControlValue("m_bdbzj","String",1,30,null,0,"比对表主键"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjxxid2">
<input type="hidden" id="m_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td align="left" class="title1">布控物品修改</td>
    <td align="right"  class="title1"><a href="#" id="closeDiv"
				onclick='$(&quot;#bkwpkbxx_detail&quot;).hideAndRemove(&quot;show&quot;);' class="close"></a></td>
  </tr>
</table>
<div style="overflow-y:auto;height:500" class="scrollbarface">
  <table width="98%" id="modify">
    <tr>
      <td valign="top">
        <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">   
    <tr><td  height="8" class="queryfont">接处警基本情况</td></tr>
  <tr><td  class="tdbg"><table width="100%" cellpadding="4" cellspacing="0" class="detail"  id="detail2">
    <tr>
      <td width="13%" class="distd">是否确认报警</td>
      <td width="20%" class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_show_sfqrbj"/></td>
     <td width="13%" class="distd">值班员</td>
      <td width="20%" class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_sfyxbj"/></td>
      <td width="13%" class="distd">是否出警</td>
      <td width="20%" class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_show_sfcj"/></td>
          </tr>
    <tr>
      <td class="distd">出警时间</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_chjsj"/></td>
       <td class="distd">处警部门代码</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_cjbm"/></td>
     <td class="distd">处警部门</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_cjbm"/></td>
          </tr>
        <tr>
      <td class="distd">是否撤销</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_fkdw"/></td>
     <td class="distd">撤销时间</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_fkdw"/></td>
      <td class="distd">反馈单位</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_fkdw"/></td>
                </tr>
        <tr>
     <td class="distd">反馈日期</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_fkdw"/></td>
	  <td width="13%" class="distd">是否有效报警</td>
      <td width="20%" class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_sfyxbj"/></td>
      <td class="distd">是否抓获</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_chjjg"/></td>
    </tr>
    <tr>
      <td class="distd">处警反馈情况</td>
      <td colspan="5" class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_cjfkbz"/></td>
    </tr>
        <tr>
      <td class="distd">是否漏网</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_fkdw"/></td>
      <td class="distd">登记单位</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_fkdw"/></td>
      <td class="distd">登记人员</td>
      <td class="detailtd"><input type="text" class="inputstyle" id="bjxxDetail_fkr"/></td>
      </tr>
      <tr>
      <td class="distd">登记时间</td>
      <td class="detailtd"  colspan="5"><input type="text" class="inputstyle" id="bjxxDetail_fkrq"/></td>
    </tr>
  </table></td></tr>
</table></td>
    </tr>
    
                          <tr height="25" align="center">
              <td colspan="3"  align="center"><a href="#" id="printbutton" hidefocus="true" class="submitbutton"
				      title="打印" onclick='printpage(&quot;printDiv&quot;);'>打印 </a><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='$(&quot;#bkwpkbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'>关闭</a></td>
              </tr>
  </table>
</div>
<%@include file="../../public/includeImgerToBase64.jsp" %>
