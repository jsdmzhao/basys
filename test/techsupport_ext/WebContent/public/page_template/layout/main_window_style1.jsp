<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.tree.UIContainer"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@ taglib prefix="d" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><d:title default="航天金盾技术支持单"/> </title>
<%@ include file="../header.jsp" %>
<d:head></d:head>

<script type="text/javascript">
	
Ext.onReady(function(){
	 Ext.BLANK_IMAGE_URL = '<%=javascript_home%>/ext/resources/images/default/s.gif';  
	 Ext.QuickTips.init();     
	
	
	var accordion = new Ext.Panel({
						id:'accordion_part',
						layout:'accordion',
						region:'west',
						defaults:{ bodyStyle : 'padding:10px;'},
			 			layoutConfig: {
					    titleCollapse: false,
					    animate: true,
				  		activeOnTop: true,
						},
						items:[	<%
						   	  UIContainer system_accordion = (UIContainer)request.getSession().getAttribute(Constants.systemKey);
					 	  if(system_accordion!=null){
					 		  String accordion = system_accordion.CreateAccordion("left_side","right_part");
					 		  System.out.println(accordion);
					 		  out.println(accordion);
					 	  }
						 	 
						%>]
	});
	var header_panel = new Ext.Panel({id:'header_part',region:'north',html:'<h1>航天金盾技术支持单</h1>',style:'background-color:red;',height:33,padding:'2 2 2 2'});
	var footer_panel = new Ext.Panel({id:'footer_part',region:'south',html:'<p style="margin-left:auto;margin-right:auto;">Copyright 航天金盾有限公司</p>',height:33,padding:'2 2 2 2'});
	var cp=new Ext.Panel({id:'right_part',region:'center',padding:'2 2 2 2',html:'',autoScroll: true}); 
	var left_side = new Ext.Panel({id:'left_side',region:'west',defaults:{bodyStyle:'height:100%;'},items:[accordion],autoScroll: true,width:'20%'}) ;
	//var left_side = accordion;
	var view = new Ext.Viewport({renderTo:'body',layout:'border',items:[header_panel,footer_panel,cp,left_side]});
	view.doLayout();
	accordion.setHeight(left_side.getHeight()-left_side.el.getPadding('t')-left_side.el.getPadding('b'));
});

</script>
</head>
<body>
<!--	<div id="header" style="height:33px;background-color: red;-->
<!--	    padding: 5px 5px 5px 5px;">-->
<!--		<h1>航天金盾技术支持单</h1>    -->
<!--	</div>-->
<!--	<div id="left_side" style="width:24%;height:auto;float:left;-->
<!--	    padding: 2px 2px 2px 2px;">-->
<!--	</div>-->
<!--	<div id="right_part" style="float:left;padding : 2px 2px 2px 2px;">-->
<!--		<d:body></d:body>-->
<!--	</div>-->
<!--	<div style="clear:both;"></div>-->
<!--	<div id="footer" style="height:33px; background-color: gray;-->
<!--		 padding : 5px 5px 5px 5px;"></div>-->
</body>
</html>