<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<%
Date da=new Date();
		long lo=da.getTime();
 %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_rylsid").attr("value",cyrylsxx_dataid);
	}); 
	
	function bgqk_setDetail(){ //当前历史信息
		setParams("q_");
		jQuery.post(detailLsUrl,params,bgqk_updatediv,"json");
	}

    function bgqkbalance_updatediv(json){ //对比信息 存放起来 待对比
        addtotempList("cyrybh",setNull(json.LQyryxx_lsxx[0].cyrybh));
		addtotempList("qymc",setNull(json.LQyryxx_lsxx[0].qymc));
		addtotempList("gemc",setNull(json.LQyryxx_lsxx[0].gwmc));
		addtotempList("xm",setNull(json.LQyryxx_lsxx[0].xm));
		addtotempList("bm",setNull(json.LQyryxx_lsxx[0].bm));
		addtotempList("minzu",setNull(json.LQyryxx_lsxx[0].minzu));
		addtotempList("xb",setNull(json.LQyryxx_lsxx[0].xb));
		addtotempList("csrq",setNull(json.LQyryxx_lsxx[0].csrq));
		addtotempList("hyzk",setNull(json.LQyryxx_lsxx[0].hyzk));
		addtotempList("hjdxzqh",setNull(json.LQyryxx_lsxx[0].hjdxzqh));
		addtotempList("hjdxz",setNull(json.LQyryxx_lsxx[0].hjdxz));
		addtotempList("zjhm",setNull(json.LQyryxx_lsxx[0].zjhm));
		addtotempList("zzzhm",setNull(json.LQyryxx_lsxx[0].zzzhm));
		addtotempList("zzdz",setNull(json.LQyryxx_lsxx[0].zzdz));
		addtotempList("shouji",setNull(json.LQyryxx_lsxx[0].shouji));
		addtotempList("qtlxdh",setNull(json.LQyryxx_lsxx[0].jjlxrdh));
		addtotempList("zhiwu",setNull(json.LQyryxx_lsxx[0].zhiwu));
		addtotempList("rzrq",setNull(json.LQyryxx_lsxx[0].rzrq));
		addtotempList("zxr",setNull(json.LQyryxx_lsxx[0].zxr));
		if(json.LQyryxx_lsxx[0].zxsj!=null){
			addtotempList("zxsj",setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
			addtotempList("zxsj2",setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
			}
		if(json.LQyryxx_lsxx[0].cjsj!=null)
			addtotempList("cjsj",setNull(json.LQyryxx_lsxx[0].cjsj.substr(0,10)));
		addtotempList("cjr",setNull(json.LQyryxx_lsxx[0].cjr));
		addtotempList("hcdw",setNull(json.LQyryxx_lsxx[0].hcdw));
		addtotempList("zxyy",setNull(json.LQyryxx_lsxx[0].zxyy));
		addtotempList("cyryzt",setNull(json.LQyryxx_lsxx[0].cyryzt));
		addtotempList("zxbz",setNull(json.LQyryxx_lsxx[0].zxbz));
		addtotempList("csmc",setNull(json.LQyryxx_lsxx[0].csmc));
		addtotempList("shengao",setNull(json.LQyryxx_lsxx[0].shengao));
		addtotempList("tizh",setNull(json.LQyryxx_lsxx[0].tizh));
		addtotempList("bz",setNull(json.LQyryxx_lsxx[0].bz));
		addtotempList("gwzrms",setNull(json.LQyryxx_lsxx[0].gwzrms));
		addtotempList("zpwtgyy",setNull(json.LQyryxx_lsxx[0].zpwtgyy));
		addtotempList("zxr2",setNull(json.LQyryxx_lsxx[0].zxr));
		bgqk_setDetail();
    }

	function bgqk_updatediv (json) { 
	    changeAndWriteRedFont("cyrybh",setNull(json.LQyryxx_lsxx[0].cyrybh));
		changeAndWriteRedFont("qymc",setNull(json.LQyryxx_lsxx[0].qymc));
		changeAndWriteRedFont("gemc",setNull(json.LQyryxx_lsxx[0].gwmc));
		changeAndWriteRedFont("xm",setNull(json.LQyryxx_lsxx[0].xm));
		changeAndWriteRedFont("bm",setNull(json.LQyryxx_lsxx[0].bm));
		changeAndWriteRedFont("minzu",setNull(json.LQyryxx_lsxx[0].minzu));
		changeAndWriteRedFont("xb",setNull(json.LQyryxx_lsxx[0].xb));
		changeAndWriteRedFont("csrq",setNull(json.LQyryxx_lsxx[0].csrq));
		changeAndWriteRedFont("hyzk",setNull(json.LQyryxx_lsxx[0].hyzk));
		changeAndWriteRedFont("hjdxzqh",setNull(json.LQyryxx_lsxx[0].hjdxzqh));
		changeAndWriteRedFont("hjdxz",setNull(json.LQyryxx_lsxx[0].hjdxz));
		changeAndWriteRedFont("zjhm",setNull(json.LQyryxx_lsxx[0].zjhm));
		changeAndWriteRedFont("zzzhm",setNull(json.LQyryxx_lsxx[0].zzzhm));
		changeAndWriteRedFont("zzdz",setNull(json.LQyryxx_lsxx[0].zzdz));
		changeAndWriteRedFont("shouji",setNull(json.LQyryxx_lsxx[0].shouji));
		changeAndWriteRedFont("qtlxdh",setNull(json.LQyryxx_lsxx[0].jjlxrdh));
		changeAndWriteRedFont("zhiwu",setNull(json.LQyryxx_lsxx[0].zhiwu));
		changeAndWriteRedFont("rzrq",setNull(json.LQyryxx_lsxx[0].rzrq));
		changeAndWriteRedFont("zxr",setNull(json.LQyryxx_lsxx[0].zxr));
		if(json.LQyryxx_lsxx[0].zxsj!=null){
			changeAndWriteRedFont("zxsj",setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
			changeAndWriteRedFont("zxsj2",setNull(json.LQyryxx_lsxx[0].zxsj.substr(0,10)));
			}
		if(json.LQyryxx_lsxx[0].cjsj!=null)
			changeAndWriteRedFont("cjsj",setNull(json.LQyryxx_lsxx[0].cjsj.substr(0,10)));
		changeAndWriteRedFont("cjr",setNull(json.LQyryxx_lsxx[0].cjr));
		changeAndWriteRedFont("hcdw",setNull(json.LQyryxx_lsxx[0].hcdw));
		changeAndWriteRedFont("zxyy",setNull(json.LQyryxx_lsxx[0].zxyy));
		changeAndWriteRedFont("cyryzt",setNull(json.LQyryxx_lsxx[0].cyryzt));
		changeAndWriteRedFont("zxbz",setNull(json.LQyryxx_lsxx[0].zxbz));
		changeAndWriteRedFont("csmc",setNull(json.LQyryxx_lsxx[0].csmc));
		changeAndWriteRedFont("shengao",setNull(json.LQyryxx_lsxx[0].shengao));
		changeAndWriteRedFont("tizh",setNull(json.LQyryxx_lsxx[0].tizh));
		changeAndWriteRedFont("bz",setNull(json.LQyryxx_lsxx[0].bz));
		changeAndWriteRedFont("gwzrms",setNull(json.LQyryxx_lsxx[0].gwzrms));
		changeAndWriteRedFont("zpwtgyy",setNull(json.LQyryxx_lsxx[0].zpwtgyy));
		changeAndWriteRedFont("zxr2",setNull(json.LQyryxx_lsxx[0].zxr));
		if(setNull(json.LQyryxx_lsxx[0].scbz)==1){
			$('#zhuxiao').empty();
			$('#shanchu').show();
		}
		var zkzt = setNull(json.LQyryxx_lsxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
			
		$("#ryImage").attr("src",'<%=request.getContextPath()%>/'+"publicsystem/queryTp_qyryxx.action?ryId="+json.LQyryxx_lsxx[0].ryid+'&aa=<%=lo %>');
		$('#qyrytjxx').load("basic/publicsystem/Cyry_tjxxManDetail.jsp");
	}	
</script>
<input type="hidden" id="q_rylsid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">国内从业人员变更历史详情</td>
      <td align="right" class="title1"><a href="#" onclick="$('#cyrylsxx_detail').hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="1" cellspacing="0" class="detail" id="detail" >
	<tr>
		<td width="12%" class="distd1">人员编号</td>
	  <td width="23%"  class="detailtd2"><span id="cyrybh"></span></td>
      <td width="13%" class="distd1">姓名</td>
      <td width="18%" class="detailtd2"><span id="xm"></span></td>
      <td colspan="2" rowspan="9" align="center" valign="top" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      </table></td>
  </tr>
	<tr>
		<td class="distd1">公民身份号码</td>
		<td class="detailtd2"><span id="zjhm" ></span></td>
	    <td class="distd1">别名</td>
	    <td class="detailtd2"><span id="bm" ></span></td>
    </tr>
	<tr>
	  <td class="distd1">性别</td>
	  <td class="detailtd2"><span id="xb"></span></td>
      <td class="distd1">出生日期</td>
      <td class="detailtd2"><span id="csrq"></span></td>
  </tr>
	<tr>
		<td class="distd1">民族</td>
		<td class="detailtd2"><span id="minzu"></span></td>
	    <td class="distd1">婚姻状况</td>
	    <td class="detailtd2"><span id="hyzk"></span></td>
    </tr>
	<tr>
		<td class="distd1">户籍省县</td>
		<td class="detailtd2"><span id="hjdxzqh"></span></td>
	    <td class="distd1">入职日期</td>
	    <td class="detailtd2"><span id="rzrq"></span></td>
    </tr>
	<tr>
		<td  class="distd1">户籍地详址</td>
		<td colspan="3" class="detailtd2"><span id="hjdxz"></span></td>
    </tr>
	<tr>
		<td class="distd1">岗位类别</td>
		<td class="detailtd2"><span id="gemc"></span></td>
	    <td class="distd1">联系电话</td>
	    <td class="detailtd2"><span id="shouji"></span></td>
    </tr>
	<tr>
		<td class="distd1">企业名称</td>
		<td colspan="3" class="detailtd2"><span id="qymc"></span></td>
    </tr>
	<tr>
		<td class="distd1">紧急联系电话</td>
		<td class="detailtd2"><span id="qtlxdh"></span></td>
	    <td class="distd1">身高（厘米）</td>
	    <td class="detailtd2"><span id="shengao"></span></td>
    </tr>
	<tr>
		<td class="distd1">职务</td>
		<td class="detailtd2"><span id="zhiwu"></span></td>
	    <td class="distd1">体重（公斤）</td>
	    <td class="detailtd2"><span id="tizh"></span></td>
		<td width="10%" class="distd1">暂住证号码</td>
		<td width="24%" class="detailtd2"><span id="zzzhm"></span></td>
    </tr>
	<tr>
		<td class="distd1">暂住地址</td>
		<td colspan="5" class="detailtd2"><span id="zzdz"></span></td>
    </tr>
	<tr id="zhuxiao">
	    <td class="distd1">注销时间</td>
	    <td class="detailtd2"><span id="zxsj"></span></td>
		<td class="distd1">注销原因</td>
		<td class="detailtd2"><span id="zxyy"></span></td>
         <td class="distd1">人员注销标志</td>
	    <td class="detailtd2"><span id="zxbz"></span></td>
      </tr>
	<tr id="shanchu" style="display: none;">
	    <td class="distd1">删除时间</td>
	    <td class="detailtd2"><span id="zxsj2"></span></td>
		<td class="distd1">删除人</td>
		<td class="detailtd2"><span id="zxr2"></span></td>
         <td class="distd1"></td>
	    <td class="detailtd2"></td>
      </tr>
	<tr>
		<td class="distd1">岗位责任描述</td>
	  <td colspan="5" class="detailtd2"><span id="gwzrms"></span></td>
    </tr>
	<tr>
		<td class="distd1">备注</td>
	  <td colspan="5" class="detailtd2"><span id="bz"></span></td>
    </tr>
	<tr id="tr_zpwtgyy" style="display:none">
		<td class="distd1">照片未通过原因</td>
	  <td colspan="5" class="detailtd2"><span id="zpwtgyy"></span></td>
    </tr>
    	<tr>
		<td  height="3" colspan="6"></td>
	  </tr>
</table>
<div id="qyrytjxx"  >
</div>	