<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bkryid").attr("value",dataid);
			setDetail();
		$("#Qgztjyxx").empty();
		$("#Qgztjyxx").load("basic/basicsystem/Qgztjyxx.jsp");
		$("#Qgztjyxx").show("slow");
		$("#lgrzxx").empty();
		$("#lgrzxx").load("basic/basicsystem/lgrzxx.jsp");
		$("#lgrzxx").show("slow");
	}); 
	function updatediv (json) {                             
		$("#gmsfhm").append(setNull(json.LBkry[0].bkryid));
		$("#bm").append(setNull(json.LBkry[0].tbbh));
		$("#xm").append(setNull(json.LBkry[0].xm));
		$("#csrq").append(setNull(json.LBkry[0].jg));
		$("#xb").append(setNull(json.LBkry[0].xb));
		$("#qtzjhm").append(setNull(json.LBkry[0].minzu));
		$("#tbbh").append(setNull(json.LBkry[0].ky));
		$("#hjd").append(setNull(json.LBkry[0].shengao));
		$("#xzdq").append(setNull(json.LBkry[0].tz));
		$("#xzqh").append(setNull(json.LBkry[0].tt));
		$("#djrq").append(setNull(json.LBkry[0].yz));
		$("#hjxxdz").append(setNull(json.LBkry[0].fwdw));
		$("#ladq").append(setNull(json.LBkry[0].ajlb));
		$("#xzdxxdz").append(setNull(json.LBkry[0].tbsj));
		$("#badw").append(setNull(json.LBkry[0].jyaq));
		$("#tbr").append(setNull(json.LBkry[0].bkr));
		$("#lxr").append(setNull(json.LBkry[0].bkczsj));
	}	
</script>
<input type="hidden" id="q_bkryid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">报警信息查询本地全国在逃人员详细信息</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
    <table width="100%" border="0">
    <tr>
      <td width="28%" colspan="6" ><div style="width:100%" id=Qgztjyxx></div></td>
    </tr>
  
    <tr><td colspan="6" height="8" class="queryfont">接处警基本情况</td></tr>
  <tr align="center"><td colspan="6" height="8"><table width="100%" id="detail2">
    <tr>
      <td width="8%" class="detailtd2">是否确认报警</td>
      <td width="18%" class="detailtd1"><span id=" "/></span></td>
      <td width="11%" class="detailtd2">值班员</td>
      <td width="18%" class="detailtd1"><span id=" "/></span></td>
      <td width="7%" class="detailtd2">是否出警</td>
      <td width="17%" class="detailtd1"><span id=" "/></span></td>
    </tr>
    <tr>
      <td class="detailtd2">出警时间</td>
      <td class="detailtd1"><span id=" "/></span></td>
      <td class="detailtd2">处警部门代码</td>
      <td class="detailtd1"><span id=" "/></span></td>
      <td class="detailtd2">处警部门</td>
      <td class="detailtd1"><span id=" "/></span></td>
    </tr>
    
    <tr>
      <td class="detailtd2">是否撤销</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">撤销时间</td>
      <td class="detailtd1"><span id="" value="0" /></span></td>
      <td class="detailtd2">反馈单位</td>
      <td class="detailtd1"><span id=""/></span></td>
    </tr>
    <tr>
      <td class="detailtd2">反馈日期</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">是否有效报警</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">是否抓获</td>
      <td class="detailtd1"><span id=""/></span></td>
    </tr>
        <tr>
      <td class="detailtd2">反馈情况</td>
      <td colspan="3" class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">是否漏网</td>
      <td class="detailtd1"><span id=""></span></td>
    </tr>
        <tr>
      <td class="detailtd2">登记单位</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">登记人员</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">登记时间</td>
      <td class="detailtd1"><span id=""/></span></td>
    </tr>
  </table></td>></tr
  >    <tr>
      <td width="28%" colspan="6"><div style="width:100%" id=lgrzxx></div></td>
    </tr><tr align="center">
    <td colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="打印" onclick='setAdd();'>打印</a></td>
  </tr>
</table>
</td>
  </tr>
</table>