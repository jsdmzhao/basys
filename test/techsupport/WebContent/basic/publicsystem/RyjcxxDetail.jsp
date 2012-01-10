<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		if(tj_tcryxx!=null && tj_tcryxx=="true")
			$("#q_cyrybh").attr("value",dataid);
		else
			$("#q_ryid").attr("value",dataid);
			
		setDetail();
	}); 
	function updatediv (json) { 
		$("#cyrybh").append(setNull(json.LCyryxx[0].cyrybh));
		$("#cylb").append(setNull(json.LCyryxx[0].cylb));
		$("#xm").append(setNull(json.LCyryxx[0].xm));
		$("#bm").append(setNull(json.LCyryxx[0].bm));
		$("#minzu").append(setNull(json.LCyryxx[0].minzu));
		$("#xb").append(setNull(json.LCyryxx[0].xb));
		$("#csrq").append(setNull(json.LCyryxx[0].csrq));
		$("#hyzk").append(setNull(json.LCyryxx[0].hyzk));
		$("#hjdxzqh").append(setNull(json.LCyryxx[0].hjdxzqh));
		$("#hjdxz").append(setNull(json.LCyryxx[0].hjdxz));
		$("#zjhm").append(setNull(json.LCyryxx[0].zjhm));
		$("#zzzhm").append(setNull(json.LCyryxx[0].zzzhm));
		$("#zzdz").append(setNull(json.LCyryxx[0].zzdz));
		$("#shouji").append(setNull(json.LCyryxx[0].shouji));
		$("#qtlxdh").append(setNull(json.LCyryxx[0].qtlxdh));
		$("#zhiwu").append(setNull(json.LCyryxx[0].zhiwu));
		$("#rzrq").append(setNull(json.LCyryxx[0].rzrq));
		$("#zxr").append(setNull(json.LCyryxx[0].zxr));
		if(json.LCyryxx[0].zxsj!=null)
			$("#zxsj").append(setNull(json.LCyryxx[0].zxsj.substr(0,10)));
		if(json.LCyryxx[0].cjsj!=null)
			$("#cjsj").append(setNull(json.LCyryxx[0].cjsj.substr(0,10)));
		$("#cjr").append(setNull(json.LCyryxx[0].cjr));
		$("#hcdw").append(setNull(json.LCyryxx[0].hcdw));
		$("#zxyy").append(setNull(json.LCyryxx[0].zxyy));
		$("#cyryzt").append(setNull(json.LCyryxx[0].cyryzt));
		$("#scbz").append(setNull(json.LCyryxx[0].zxbz));
		$("#csmc").append(setNull(json.LCyryxx[0].csmc));
		$("#shengao").append(setNull(json.LCyryxx[0].shengao));
		$("#tizh").append(setNull(json.LCyryxx[0].tizh));
		$("#bz").append(setNull(json.LCyryxx[0].bz));
		$("#zpwtgyy").append(setNull(json.LCyryxx[0].zpwtgyy));
		
		var zkzt = setNull(json.LCyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
			
		$("#ryImage").attr("src","publicsystem/queryTp_ryjcxx.action?ryId="+json.LCyryxx[0].ryid);
	}	
</script>
<input type="hidden" id="q_ryid">
<input type="hidden" id="q_cyrybh">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员详情</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#q_ryid").parent().hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
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
		<td class="distd1">人员类别</td>
		<td class="detailtd2"><span id="cylb"></span></td>
	    <td class="distd1">联系电话</td>
	    <td class="detailtd2"><span id="shouji"></span></td>
    </tr>
	<tr>
		<td class="distd1">服务单位</td>
		<td colspan="3" class="detailtd2"><span id="csmc"></span></td>
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
	<tr>
    	 <td class="distd1">采集时间</td>
	    <td class="detailtd2"><span id="cjsj"></span></td>
		<td class="distd1">采集人</td>
		<td class="detailtd2"><span id="cjr"></span></td>
	    <td class="distd1">记录状态</td>
	    <td class="detailtd2"><span id="cyryzt"></span></td>
	</tr>
	<tr>
		<td class="distd1">注销人</td>
		<td class="detailtd2"><span id="zxr"></span></td>
	    <td class="distd1">注销时间</td>
	    <td class="detailtd2"><span id="zxsj"></span></td>
	    <td class="distd1">人员注销标志</td>
	    <td class="detailtd2"><span id="scbz"></span></td>
	</tr>
	<tr>
		<td class="distd1">注销原因</td>
		<td colspan="5" class="detailtd2"><span id="zxyy"></span><span id="scbz"></span></td>
    </tr>
	<tr>
		<td class="distd1">备注</td>
	  <td colspan="5" class="detailtd2"><span id="bz"></span></td>
    </tr>
	<tr id="tr_zpwtgyy" style="display:none">
		<td class="distd1">照片未通过原因</td>
	  <td colspan="5" class="detailtd2"><span id="zpwtgyy"></span></td>
    </tr>
    <!-- 
	<tr>
		<td colspan="5" class="detailtd2"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='$("#q_ryid").parent().hideAndRemove();'>关闭</a></td>
	</tr>
        </table></td>
    </tr> -->
    	<tr>
		<td  height="3" colspan="6"></td>
	  </tr>
</table>
