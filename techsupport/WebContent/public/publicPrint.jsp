
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
<script type="text/javascript">
 $(document).ready(function() {

 })
</script>
<div align="center">
<% 
   out.println(con);
%>
</div>
