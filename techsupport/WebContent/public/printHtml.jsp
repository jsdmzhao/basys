<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<% 
   String con = (String)session.getAttribute("printCon");
%>
<script type="text/javascript" src="../javascript/jquery.js"></script>
<script type="text/javascript" src="../javascript/jquery.ingrid-0.9.2.js"></script>
<script type="text/javascript" src="../javascript/htmlConfig.js"></script>
<link rel="stylesheet" href="../css/printshow.css" type="text/css" />

<OBJECT classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 height=0 id=WB width=0></OBJECT>
<div align="center">
<% 
   out.println(con);
%>

<script type="text/javascript">
function Print() {
  //var WB = document.getElementById("");
  WB.ExecWB(8,1); // 设置
  WB.ExecWB(7,1); // 预览
  //WB.ExecWB(6,1); // 打印
}
Print();
//window.print();
window.close();
</script>
</div>