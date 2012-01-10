<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<title></title>
<!-- 修改 -->
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css"/>
<script language="javascript">  
 
 function fnquery(d,t) {
   listdict_code =d;
     //rightMainTreeDictItem();
     //树形或联动字典
	 if(t=='02' || t=='11'){
	      listdict_code =d;
     rightMainTreeDictItem(listdict_code);
 }
 	//平板结构字典
	 if(t=='01'){
     listdict_code =d;
     rightMainDictItem(listdict_code);
 }
}
</script>
</head>
<body>	
<table id="d_treeTable" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
<div class="treediv">
<!--表单样式开始 -->
	<!--表单样式开始 -->
<table width="100%" border='0' align="center" cellpadding="1" cellspacing="3" class="titleTable" >
  <tr>
    <td style="font-weight:bold" >字典列表</td>
  </tr>
</table>
             <table width="100%"  border='0'  align="center" cellpadding="1" cellspacing="1" class="listTable">
  <tr>
    <td class="listTD" valign="top"><table width="100%" cellspacing="0" cellpadding="0"  border='0'>
  <tr >
              
	    <td   align="left" >
	    <input type="text" class="" class="inputstyle" id="v_query_simplepin" /><input type="button" value="查找" onclick="dictListQuery();" />
	     	<Div id="list1" class="titleTablenei">
	    		<%@ include file="dictList.jsp"%>
	    	</Div>	
	   </td>
	  </tr>			
</table> </td>               
            </tr>
            </table>
</div>
</td><td width="4"><img name="" src="" width="4" height="1" alt=""></td>
      <td valign="top">
<div class="textdiv" id="dictManager"	
	onload='$("dictManager").show("slow");'>
      </div>  
      </td>
        </tr>
</table>
</body>
<script>
$("#list1").height(pageHeight-162);
//var listdict_code =0;
  function rightMainDictItem(listdict_code){
	$("#dictManager").empty();
			$("#dictManager").load("sysadminDefault/manage_dict_item.action?dict_code="+listdict_code);
			$("#dictManager").show("slow"); 
			}
	//rightMainDictItem();
	  function rightMainTreeDictItem(listdict_code)
	  {
				//.css("top",$("#list1").css("top")).css("left",($("#list1").css("left")+$("#list1").width()))
			$("#dictManager").load("basic/sysadmin/tree/dictItemTree.jsp?dict_code="+listdict_code);
			$("#dictManager").show("slow"); 
	  }
</script>
</html>