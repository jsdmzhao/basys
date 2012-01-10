<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<HTML>
<script type="text/javascript">
	var selHylb; //当前行业类别
	var qyjzflag;//按企业统计加载标志
	$(document).ready(function() {
		bc_bottonMoveRight(); //按钮右对齐
		selHylb = "";
   $("#div_gzrztjry").load("basic/icksystem/Gzrztjbyry.jsp", {}, function(){
           qyjzflag=0;
		});	
	});
	function show_biaoqian(yqid){ //点击页签时的动作
			 if(yqid=='qy_tj'){
			     $("#ry_tj").css("display","none");
			     $("#qy_tj").css("display","block");
			    if(qyjzflag==0){
			     $("#div_gzrztjqy").load("basic/icksystem/Gzrztjbyqy.jsp");
			   }
			    qyjzflag=1;
			}else{
			    	$("#qy_tj").css("display","none");
			        $("#ry_tj").css("display","block");
			}
	}
	function ResumeError() { return true; } 
	window.onerror = ResumeError;
</script>
<BODY>
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0" height="520" id="tj" >
<tr>
<td valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		<tr>
	    <td width="100%" valign="top" >
	    	<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
	      	<tr>
        		<td width="25" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
            		</table>
            	</td>
       			<td width="78" valign="bottom">
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav11">
            		<tr><td><a href="#" onmousedown="show_biaoqian('ry_tj')" class="navfont" hidefocus="true">按人员</a></td></tr>
            		</table>
            	</td>
        		<td width="78" id="qy" >
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1">
            		<tr><td align="center"><a href="#" onmousedown="show_biaoqian('qy_tj')" class="navfont" hidefocus="true">按部门</a></td></tr>
        			</table>
        		</td>
        	
        		<td width="1126" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
        			</table>
        		</td>
      		</tr>
    		</table>
    	</td>
  		</tr>
	</table>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="ry_tj" style="DISPLAY: block">
		<tr>
	    <td width="100%" valign="top" >
	    	   <div id="div_gzrztjry" class="scrollbarface" style="overflow-y:auto;overflow-x:hidden;height:490;width:100%;"></div>
    	</td>
  		</tr>
	</table>
   <table width="100%"  border="0" cellpadding="0" cellspacing="0" id="qy_tj" style="DISPLAY: none">
		<tr>
	    <td width="100%" valign="top" >
	    	  <div id="div_gzrztjqy" class="scrollbarface" style="overflow-y:auto;overflow-x:hidden;height:490;width:100%;"></div>
    	</td>
  		</tr>
	</table>
</td>
</tr>
</table>
 </BODY>
</HTML>