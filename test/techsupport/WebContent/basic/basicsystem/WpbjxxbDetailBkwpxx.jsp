<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	    setParams("m_");
		jQuery.post("basicsystem/query_bkwpkbxxkz.action",params,bkwpkzdiv,"json"); // 提交到BkwpkbxxkzAction中,调用其中的query方法
		$("#wpImage").attr("src","<%=request.getContextPath()%>/basicsystem/queryZp_bkwpkbxxkz.action?bjxxid2="+$("#m_bjxxid2").attr("value"));
	}); 
		
	function bkwpkzdiv (json) {
		$("#bd_bkwpmc").append(setNull(json.LBkwpkbxxkz[0].bkwpmc));
		$("#bd_bkwplx").append(setNull(json.LBkwpkbxxkz[0].bkwplx));
		$("#bd_bkwplxdm").attr("value",setNull(json.LBkwpkbxxkz[0].bkwplxdm));
		$("#bd_bkwpms").append(setNull(json.LBkwpkbxxkz[0].bkwpms));
		
		$("#bd_tbbh").append(setNull(json.LBkwpkbxxkz[0].tbbh));
		$("#bd_ajlb").append(setNull(json.LBkwpkbxxkz[0].ajlb));
		$("#bd_fwdw").append(setNull(json.LBkwpkbxxkz[0].fwdw));
		$("#bd_tbsj2").append(setNull(json.LBkwpkbxxkz[0].tbsj2));
		$("#bd_jyaq").append(setNull(json.LBkwpkbxxkz[0].jyaq));
		$("#bd_cljg").append(setNull(json.LBkwpkbxxkz[0].cljg));
		$("#bd_bkr").append(setNull(json.LBkwpkbxxkz[0].bkr));
		$("#bd_bkczy").append(setNull(json.LBkwpkbxxkz[0].bkczy));
		$("#bd_bkfw").append(setNull(json.LBkwpkbxxkz[0].bkfw));
		$("#bd_bkczsj").append(setNull(json.LBkwpkbxxkz[0].bkczsj));
		$("#bd_lxr").append(setNull(json.LBkwpkbxxkz[0].lxr));
		$("#bd_lxfs").append(setNull(json.LBkwpkbxxkz[0].lxfs));
		$("#bd_bkdqsj").append(setNull(json.LBkwpkbxxkz[0].bkdqsj));
		if($("#bd_bkwplxdm").val() == "2"){// 车辆
		    $("#bd_cllx").append(setNull(json.LBkwpkbxxkz[0].bkclkz.cllx));
	        $("#bd_clpp").append(setNull(json.LBkwpkbxxkz[0].bkclkz.clpp));
		    $("#bd_clxh").append(setNull(json.LBkwpkbxxkz[0].bkclkz.clxh));
		    $("#bd_hphm").append(setNull(json.LBkwpkbxxkz[0].bkclkz.hphm));
		    $("#bd_syr").append(setNull(json.LBkwpkbxxkz[0].bkclkz.syr));
		    $("#bd_fdjh").append(setNull(json.LBkwpkbxxkz[0].bkclkz.fdjh));
		    $("#bd_cjh").append(setNull(json.LBkwpkbxxkz[0].bkclkz.cjh));
		    $("#bd_csys").append(setNull(json.LBkwpkbxxkz[0].bkclkz.csys));
		    $("#bd_ccdjrq").append(setNull(json.LBkwpkbxxkz[0].bkclkz.ccdjrq));
	        $("[id^='bd_clDetail_']").show();
	        $("[id^='bd_sjDetail_']").hide();
		} else if($("#bd_bkwplxdm").val() == "1"){// 手机
	        $("#bd_pp").append(setNull(json.LBkwpkbxxkz[0].bksjkz.pp));
		    $("#bd_xh").append(setNull(json.LBkwpkbxxkz[0].bksjkz.xh));
		    $("#bd_sjch").append(setNull(json.LBkwpkbxxkz[0].bksjkz.sjch));
		    $("#bd_ys").append(setNull(json.LBkwpkbxxkz[0].bksjkz.ys));
	        $("[id^='bd_clDetail_']").hide();
	        $("[id^='bd_sjDetail_']").show();
		} else{
	        $("[id^='bd_clDetail_']").hide();
	        $("[id^='bd_sjDetail_']").hide();
		}
	}
</script>
<input type="hidden" id="bd_bkwplxdm">
<table width="100%"  class="detail" id="detail">
    <tr>
    <td valign="top">
    <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">   
    <tr><td  height="8" class="queryfont">本地布控物品信息</td></tr>
  <tr><td  class="tdbg" valign="top">
    <table width="100%" class="detail" >
      <tr>
       <td width="8%" class="distd1">物品类型</td>
        <td  class="detailtd2"><span id="bd_bkwplx" /></span></td>
        <td width="11%" class="distd1">物品名称</td>
        <td width="25%" class="detailtd2"><span id="bd_bkwpmc" /></span></td>
        <td colspan="2" rowspan="11" class="detailtd2">
            <table width="35%" border="0" align="center" cellpadding="8" cellspacing="0" class="detail">
          <input type="hidden" id="m_fileload" />
          <tr>
          <td align="center">
              <img id="wpImage" width="118" height="149" />          </td>
          </tr>
        </table></td>
        </tr>
 <tr height="20" id="bd_clDetail_1">
    <td width="8%" class="distd1"><font color="blue">车辆品牌</font></td>
    <td width="20%" class="detailtd2"><span id="bd_clpp" /></span></td>
    <td width="11%" class="distd1"><font color="blue">车辆型号</font></td>
    <td width="25%" class="detailtd2"><span id="bd_clxh" /></span></td>
      </tr>
  <tr height="20" id="bd_clDetail_2">
    <td width="8%" class="distd1"><font color="blue">车辆号牌</font></td>
    <td width="20%" class="detailtd2"><span id="bd_hphm" /></span></td>
    <td width="11%" class="distd1"><font color="blue">机动车所有人</font></td>
    <td width="25%" class="detailtd2"><span id="bd_syr" /></span></td>
    </tr>
  <tr height="20" id="bd_clDetail_3">
    <td class="distd1"><font color="blue">车辆类型</font></td>
    <td class="detailtd2"><span id="bd_cllx" /></span></td>
    <td class="distd1"><font color="blue">发动机号</font></td>
    <td class="detailtd2"><span id="bd_fdjh" /></span></td>
      </tr>
  <tr height="20" id="bd_clDetail_4">
    <td class="distd1"><font color="blue">车架号</font></td>
    <td class="detailtd2"><span id="bd_cjh" /></span></td>
    <td class="distd1"><font color="blue">初次登记日期</font></td>
    <td class="detailtd2"><span id="bd_ccdjrq" /></span></td>
    </tr>
  <tr>
    <td class="distd1" id="bd_clDetail_5"><font color="blue">车辆颜色</font></td>
    <td class="detailtd2" colspan="3"><span id="bd_csys" /></span></td>
    </tr>
  <tr height="20" id="bd_sjDetail_1">
    <td width="8%" class="distd1"><font color="green">手机品牌</font></td>
    <td width="20%" class="detailtd2"><span id="bd_pp" /></span></td>
    <td width="11%" class="distd1"><font color="green">手机型号</font></td>
    <td width="25%" class="detailtd2"><span id="bd_xh" /></span></td>
      </tr>
      <tr height="20" id="bd_sjDetail_2">
    <td width="8%" class="distd1"><font color="green">手机串号</font></td>
    <td width="20%" class="detailtd2"><span id="bd_sjch" /></span></td>
    <td width="11%" class="distd1"><font color="green">手机颜色</font></td>
    <td width="25%" class="detailtd2"><span id="bd_ys" /></span></td>
    </tr>
  <tr height="20">
    <td width="8%" class="distd1">通报编号</td>
    <td width="20%" class="detailtd2"><span id="bd_tbbh" /></span></td>
    <td width="11%" class="distd1">案件类别</td>
    <td width="25%" class="detailtd2"><span id="bd_ajlb" /></span></td>
    </tr>  
    <tr height="20">
    <td width="8%" class="distd1">布控单位</td>
    <td width="20%" class="detailtd2"><span id="bd_fwdw" /></span></td>
    <td width="11%" class="distd1">通报时间</td>
    <td width="25%" class="detailtd2"><span id="bd_tbsj2" /></span></td>
    </tr>
      <tr>
        <td class="distd1">物品描述</td>
        <td colspan="3" class="detailtd2"><span id="bd_bkwpms" /></span></td>
        </tr>
  <tr height="20">
    <td width="8%" class="distd1">简要案情</td>
    <td colspan="5"  class="detailtd2"><span id="bd_jyaq" /></span></td>
  </tr>
  <tr height="20">
    <td  class="distd1">处理结果</td>
    <td colspan="5"  class="detailtd2" ><span id="bd_cljg" /></span></td>
  </tr>
  <tr height="20">
    <td width="6%" class="distd1">布控人</td>
    <td width="16%" class="detailtd2"><span id="bd_bkr" /></span></td>
    <td width="9%" class="distd1">布控操作员</td>
    <td width="16%" class="detailtd2"><span id="bd_bkczy" /></span></td>
    <td width="10%" class="distd1">布控范围</td>
    <td width="15%" class="detailtd2"><span id="bd_bkfw" /></span></td>
      </tr>
  <tr height="20">
    <td width="11%" class="distd1">布控操作时间</td>
    <td width="17%" class="detailtd2"><span id="bd_bkczsj" /></span></td>
    <td class="distd1">联系人</td>
    <td class="detailtd2"><span id="bd_lxr" /></span></td>
    <td class="distd1">联系方式</td>
    <td class="detailtd2"><span id="bd_lxfs" /></span></td>
      </tr>
  <tr height="20">
    <td class="distd1">布控终止时间</td>
    <td class="detailtd2"  colspan="5"><span id="bd_bkdqsj" /></span></td>
  </tr>
    </table>
    </td>
  </tr>
</table> 
    </td>
  </tr>
</table>