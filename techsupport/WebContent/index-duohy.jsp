<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.domain.User" %>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@include file="public/common.jsp"%>
<%
	String username="";
	String departmentname="";
	User user;
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if(user!=null){
		username = user.getUsername();
		departmentname = user.getDepartment().getDepartname();
	}
%>	
<script type="text/javascript">
var duoHangYeNeiRongHeight = (pageHeight-200)/3-30;
	$(document).ready(function (){
		jiaZaiDuoHyNeiRong();
		jiaZaiDuoHyList();
		daggleDiv("password_modify");
	});

	function jiaZaiDuoHyList(){
		//取全局参数,用于判断行业列表应该过滤的部分，默认过滤系统管理和日常管理
		var hycdpcggmk = "'xtgl_g','gad-glpt','gad-jfgl','tjfx_glpt'";
		var objGlobalpar = getGlobalparByCode("hycdpcggmk");
		if(objGlobalpar!=null){
			hycdpcggmk = objGlobalpar.value;
		}

		//依据menuList(由index.jsp设置)展示行业列表
		var duoHyListHtml = '<tr><td height="30"></td></tr>';
		var otherHtml = '';
		if(menuList != null){
			var menuLength = menuList.length;
			var oneMenu,oneMenuCode,otherMenuList;
			for(var index=0;index<menuLength;index++){
				oneMenu = menuList[index];
				oneMenuCode = oneMenu.menucode;
				if(hycdpcggmk.indexOf(("'"+oneMenuCode+"'"))==-1){
					duoHyListHtml += '<tr><td class="btsmall"><a href="#" class="btsmallfont" onclick="hyIndex(\''+oneMenuCode+'\')">'+oneMenu.menuname+'</a></td></tr>';
				}else{
					if(oneMenuCode == 'xtgl_g'){
						otherHtml += '<tr><td height="89"><img src="images/xtgl.jpg" alt="'+oneMenu.menuname+'" width="170" height="76" border="0" onclick="hyIndex(\''+oneMenuCode+'\')" style="cursor:pointer" /></td></tr>';
					}else if(oneMenuCode == 'gad-glpt'){
						otherHtml += '<tr><td><img src="images/rcgl.jpg" alt="'+oneMenu.menuname+'" width="172" height="80" border="0" onclick="hyIndex(\''+oneMenuCode+'\');" style="cursor:pointer" /></td></tr>';
					}else if(oneMenuCode == 'gad-jfgl'){
						otherHtml += '<tr><td><img src="images/jfgl.jpg" alt="'+oneMenu.menuname+'" width="172" height="80" border="0" onclick="hyIndex(\''+oneMenuCode+'\');" style="cursor:pointer" /></td></tr>';
					}else if(oneMenuCode == 'tjfx_glpt'){
						otherHtml += '<tr><td><img src="images/tjfx.jpg" alt="'+oneMenu.menuname+'" width="172" height="80" border="0" onclick="hyIndex(\''+oneMenuCode+'\');" style="cursor:pointer" /></td></tr>';
					}
				}
			}
			$("#duoHangYeListTable").html(duoHyListHtml);
	      	$("#gongGongListTable").html(otherHtml);
		}
	}

	function jiaZaiDuoHyNeiRong(){
		var yongHuXxDiv = $("#yongHuXxDiv");
		yongHuXxDiv.css({
			left:yongHuXxDiv.position().left+115
		});
		$("#loginlogNUm").css({
			left:(yongHuXxDiv.position().left+yongHuXxDiv.width()+3)
		});
		getLoginlogNum();
		$("#duoHangYeNrTd").load("index-duohynr.jsp");
	}
</script>
<table width="1020" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="118" background="images/logo_all.jpg" class="logofont" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
            <td height="29"></td>
          </tr>
      <tr>
        <td width="79%"><div id="yongHuXxDiv" style="width:600px; margin-left:103px; margin-top:43px;">当前用户:<%=username %>（<%=departmentname %>）今日共有<span  id="loginNum"></span>个，全部共有<span  id="loginSum"></span>个用户登录</div></td>
        <td width="21%" valign="top" style="padding-top:7px;">
        <table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" >
           <tr>
            <td align="right" colspan="4">
            <table width="163" border="0" cellspacing="0" cellpadding="0">
            <tr>
          <tr>
            <td ><a class="mpass" href="#" id='modifypassword'onclick='fnmodifypassword();'></a> </td>
            <td ><a class="mout" href="#" id='logout' onclick='fnlogout();'></a> </td>
            <td ><a class="mhelp"   href="#"  id='help' onclick='helpContr();'></a></td>
             <td width="20">&nbsp;</td>
          </tr>
            </table></td>
          </tr>
          <tr>
            <td height="5">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4" align="right"><table width="60" border="0" cellspacing="0" cellpadding="0">
                <tr>
<!--                  <td height="19"><a href="#" onclick="setCssPath('css');"-->
<!--													 class="bottonskin1"></a> </td>-->
<!--                  <td><a href="#" onclick="setCssPath('cssblue');"-->
<!--													 class="bottonskin2"></a> </td>-->
<!--                  <td><a href="#" onclick="setCssPath('cssred');"-->
<!--													 class="bottonskin3"></a> </td>-->
<!--                  <td width="20"></td>-->
                </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="1020" border="0" align="center" cellpadding="0" cellspacing="0" height="100%">
  <tr>
    <td width="230" valign="top">
    <table width="70%" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="images/hyzxt.jpg" width="221" height="27" /></td>
      </tr>
      <tr>
        <td bgcolor="#f5f5f5"   valign="top"  style="padding-left:20px;">
	        <div id="hylist_div"  style="height:120;overflow-y: auto;margin-top: -30 " class="scrollbarface">
		        <table id="duoHangYeListTable" height="100%" width="89%" border="0" align="center" cellpadding="0" cellspacing="0">
		        </table>
	        </div>
        </td>
      </tr>
      <tr>
        <td bgcolor="#f5f5f5">&nbsp;</td>
      </tr>
      <tr>
        <td bgcolor="#f5f5f5" valign="top" height="252" style="padding-left:15px;">
	        <table id="gongGongListTable" width="94%" border="0" align="center" cellpadding="0" cellspacing="0">
	        </table>
        </td>
      </tr>
    </table></td>
    <td width="790" valign="top" id="duoHangYeNrTd"></td>
  </tr>
</table>
<table border="0" align="center" cellpadding="0" cellspacing="0">
  <tr><td width="1020"  height="65" align="center" valign="top" background="images/copybg.jpg" style="background-repeat:no-repeat; padding-top:20px;" >copyright@2010 北京航天金盾科技有限公司版权所有</td> 
  </tr>
</table>
<div id="password_modify" class="page-layout" src="#" style="display: none; top: 110px; left: 450px; width: 300px;"></div>
