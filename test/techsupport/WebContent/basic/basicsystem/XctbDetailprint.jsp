
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<% 
   String tbid = request.getParameter("tbid");
%>
<script type="text/javascript" src="../../javascript/jquery.js"></script>
<script type="text/javascript" src="../../javascript/jquery.ingrid-0.9.2.js"></script>
<script type="text/javascript" src="../../javascript/htmlConfig.js"></script>
<script type="text/javascript">
$(document).ready(function() {
        
        var dataid = "<%=tbid%>";
       
		//////////////
		
	    $("#q_tbid").attr("value",dataid);
		////返回单条详细信息
		setParams("q_");
	    jQuery.post("<%=request.getContextPath() %>/basicsystem/queryforPrint_xctb.action",params,updatediv,"json");
		//setDetail();
		 
		////打印初始化话
	}); 
	function Print() {
	  //var WB = document.getElementById("");
	  WB.ExecWB(8,1); // 设置
	  WB.ExecWB(7,1); // 预览
	  //WB.ExecWB(6,1); // 打印
    }
	function updatediv(json){
	    //$("#jsdwmc").append(setNull(json.LXctb[0].jsdwmc));
		$("#bt").append(setNull(json.LXctb[0].bt));
		$("#fbsj").append(setNull(json.LXctb[0].fbsj));
		$("#fbr").append(setNull(json.LXctb[0].fbr));
		$("#fbdw").append(setNull(json.LXctb[0].fbdw));
		$("#jzrq").append(setNull(json.LXctb[0].jzrq));
		//$("#fbnr").append(setNull(json.LXctb[0].fbnr));
		//$("#fbnr").append(setNull(json.LXctb[0].fbnr));
		$("#fbnr").attr("value",setNull(json.LXctb[0].fbnr));
		$("#fjname").append(setNull(json.LXctb[0].fjname));
		Print();
		window.close();
	}
	
</script>
<OBJECT classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 height=0 id=WB width=0></OBJECT>
<input type="hidden" id="q_tbid">

<P>
<table width="90%" id="detail" style="margin-left:30px; margin-top:40px;margin-right:30px;">
	
	<!-- 
	<tr>
	  <td width="13%" class="distd">接收单位</td>
      <td width="87%" class="detailtd"  colspan="5">
      <span id="jsdwmc"></span>
      </td>	
  </tr>   -->
  <tr align="center"><td colspan="6" height="20"></td></tr>
  <tr>
	    <td width="13%" class="distd">发布人</td>
        <td width="22%" class="detailtd" ><span id="fbr"></span></td>
      	<td width="13%" class="distd">发布时间</td>
		<td width="21%" class="detailtd"><span id="fbsj"></span></td>
		<td width="11%" class="distd">发布单位</td>
		<td width="20%" class="detailtd"><span id="fbdw"></span></td>
  </tr>
  <tr>
	    <td width="13%" class="distd">截至时间</td>
        <td width="22%" class="detailtd" ><span id="jzrq"></span></td>
      	<td width="9%" class="distd"></td>
		<td width="25%" class="detailtd"></td>
		<td width="11%" class="distd"></td>
		<td width="20%" class="detailtd"></td>
  </tr>
	<tr>
		<td class="distd">标题</td>
		<td class="detailtd" colspan="5"><span id="bt"></span></td>
	</tr>
	<tr align="center"><td colspan="6" height="20"></td></tr>
 	<tr>
		<td class="distd">通知内容</td>
		<td class="detailtd" colspan="5">
		<!--  <span id="fbnr"></span>-->
		<textarea id="fbnr"  style='border: 0px; width:100%;overflow:hidden' onpropertychange='this.style.posHeight=this.scrollHeight' onfocus='textarea.style.posHeight=this.scrollHeight'>
        </textarea>
		</td>
	</tr>
	<tr align="center"><td colspan="6" height="20"></td></tr>
    <tr>
	  <td width="13%" class="distd">附件名称</td>
      <td width="87%" class="detailtd"  colspan="5">
      <span id="fjname"></span>
      </td>	
    </tr>
</table>
</p>
<script type="text/javascript">


//window.print();

</script>