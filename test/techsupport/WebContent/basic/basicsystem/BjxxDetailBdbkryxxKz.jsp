<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
    
    var bkrylxdm = "";
    
	$(document).ready(function() {
		// setParams("current_"); // 把current开头的参数转为xml传到后台
		// jQuery.post("basicsystem/query_bjxxb.action",params,updatediv,"json"); // 提交到BjxxbAction中,调用其中的query方法
		setParams("m_");
		jQuery.post("basicsystem/query_bkry_kz.action",params,bdbkkzdiv,"json"); // 提交到BjxxbAction中,调用其中的query方法
		$("#bkryZp").attr("src","<%=request.getContextPath()%>/basicsystem/queryZp_bkry_kz.action?bjxxid="+$("#m_bjxxid").attr("value"));
	}); 
	function bdbkkzdiv (json) { 
	
	    bkrylxdm = setNull(json.LBkry_kz[0].bkrylxdm);
	    
	    
		$("#bjsj_bk").append(setNull(json.LBkry_kz[0].bjsj));
		$("#bjlx_bk").append(setNull(json.LBkry_kz[0].bjlx));
		$("#bkryid").append(setNull(json.LBkry_kz[0].bkryid));
		$("#tbbh_bk").append(setNull(json.LBkry_kz[0].tbbh));
		if(bkrylxdm=="0"){
		  $("#xm_bk").append(setNull(json.LBkry_kz[0].zwm));
		   $("#gmsfhm_bk").append(setNull(json.LBkry_kz[0].zjhm));
		   $("#zjhmtd").text("证件号码");
		   $("#ywx_bk").append(setNull(json.LBkry_kz[0].ywx));
		   $("#ywm_bk").append(setNull(json.LBkry_kz[0].ywm));
		   $("#gwtr").css("display","block");
		 
		   
		}else{
		  $("#xm_bk").append(setNull(json.LBkry_kz[0].xm));
		  $("#gmsfhm_bk").append(setNull(json.LBkry_kz[0].gmsfhm));
		  $("#zjhmtd").text("身份证号码");
		  
		  $("#gwtr").css("display","none"); /////隐藏中文姓名
		  
		}
		
		$("#jg_bk").append(setNull(json.LBkry_kz[0].jg));
		$("#xb_bk").append(setNull(json.LBkry_kz[0].xb));
		$("#minzu_bk").append(setNull(json.LBkry_kz[0].minzu));
		$("#ky_bk").append(setNull(json.LBkry_kz[0].ky));
		$("#shengao_bk").append(setNull(json.LBkry_kz[0].shengao));
		$("#tz_bk").append(setNull(json.LBkry_kz[0].tz));
		$("#tt_bk").append(setNull(json.LBkry_kz[0].tt));
		$("#yz_bk").append(setNull(json.LBkry_kz[0].yz));
		$("#fwdw_bk").append(setNull(json.LBkry_kz[0].fwdw));
		$("#ajlb_bk").append(setNull(json.LBkry_kz[0].ajlb));
		$("#tbsj_bk").append(setNull(json.LBkry_kz[0].tbsj));
		$("#jyaq_bk").append(setNull(json.LBkry_kz[0].jyaq));
		$("#bkr_bk").append(setNull(json.LBkry_kz[0].bkr));
		$("#bkczsj").append(setNull(json.LBkry_kz[0].bkczsj));
		$("#bkfw_bk").append(setNull(json.LBkry_kz[0].bkfw));
		$("#lxfs_bk").append(setNull(json.LBkry_kz[0].lxfs));
		
		$("#csrq_bk").append(setNull(json.LBkry_kz[0].csrq));
	}	
</script>
<input type="hidden" id="q_bkryid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableborder">
  <tr>
    <td colspan="6" class="queryfont">本地布控人员信息</td>
  </tr>
  <tr>
    <td colspan="6" valign="top" class="tdbg"><table width="100%" cellpadding="4" cellspacing="0" class="detail" >
      <tr>
      	<td width="10%" class="distd1">报警时间</td>
        <td width="22%" class="detailtd2"><span id="bjsj_bk"/></span></td>
        <td width="11%" class="distd1">报警类型</td>
        <td colspan="2" class="detailtd2"><span id="bjlx_bk"/></span></td>
        <td rowspan="8" class="detailtd2"><table width="34%" border="0" align="center" cellpadding="8" cellspacing="0">
          <tr>
            <td><img id="bkryZp" width="150" height="180" /> </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td class="distd1">姓名</td>
        <td class="detailtd2"><span id="xm_bk"/></span></td>
        <td class="distd1" id="zjhmtd">证件号码</td>
        <td colspan="2" class="detailtd2"><span id="gmsfhm_bk"/></span></td>
        </tr>
        
       <tr id="gwtr">
        <td class="distd1">英文姓</td>
        <td class="detailtd2"><span id="ywx_bk"/></span></td>
        <td class="distd1" id="zjhmtd">英文名</td>
        <td colspan="2" class="detailtd2"><span id="ywm_bk"/></span></td>
       </tr>
       
      <tr>
		<td class="distd1">籍贯</td>
        <td class="detailtd2"><span id="jg_bk"/></span></td>
        <td class="distd1">出生日期</td>
        <td colspan="2" class="detailtd2"><span id="csrq_bk"/></span></td>
	    </tr>
      <tr>
        <td class="distd1">性别</td>
        <td class="detailtd2"><span id="xb_bk"/></span></td>
        <td class="distd1">民族</td>
        <td colspan="2" class="detailtd2"><span id="minzu_bk"/></span></td>
        </tr>
      <tr>
        <td class="distd1">口音</td>
        <td class="detailtd2"><span id="ky_bk"/></span></td>
        <td class="distd1">身高</td>
        <td colspan="2" class="detailtd2"><span id="shengao_bk"/></span></td>
        </tr>
      <tr>
        <td class="distd1">体征</td>
        <td class="detailtd2"><span id="tz_bk"/></span></td>
        <td class="distd1">体态</td>
        <td colspan="2" class="detailtd2"><span id="tt_bk"/></span></td>
        </tr>
      <tr>
        <td class="distd1">衣着</td>
        <td class="detailtd2"><span id="yz_bk"/></span></td>
        <td class="distd1">通报编号</td>
        <td colspan="2" class="detailtd2"><span id="tbbh_bk"/></span></td>
        </tr>
      <tr>
        <td class="distd1">发文单位</td>
    	<td class="detailtd2" ><span id="fwdw_bk"/></span></td>
	    <td width="11%" class="distd1">通报时间</td>
	    <td colspan="2" class="detailtd2"><span id="tbsj_bk"/></span></td>
	    </tr>
      <tr>
        <td class="distd1">简要案情</td>
        <td colspan="3" class="detailtd2" ><span id="jyaq_bk"/></span></td>
        <td width="14%" class="distd1">案件类别</td>
        <td width="22%" class="detailtd2"><span id="ajlb_bk"/></span></td>
      </tr>
      <tr>
        <td class="distd1">布控人</td>
        <td class="detailtd2" ><span id="bkr_bk"/></span></td>
        <td width="11%" class="distd1">布控范围</td>
        <td width="21%" class="detailtd2"><span id="bkfw_bk"/></span></td>
        <td  class="distd1">联系方式</td>
        <td class="detailtd2"><span id="lxfs_bk"/></span></td>
      </tr>
    </table>
</table>
