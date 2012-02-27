<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../public/common.jsp" %>
<%@include file="../../public/user-info.jsp" %>  
<script type="text/javascript">
    $(document).ready(function (){
    	
        getLoginlogNum();
        //页面高度页面宽度
      //  loadOther(); //首页加载项
        /**  
        reloadHyIndex:加载各行业首页跳转按钮事件
        第一，二坐标是距离跳转按钮的top和left坐标值。
        第三，四参数是跳转的a标签id和图片id用于非多行业隐藏,如果id跟本页相同可以不写。
        */
        reloadHyIndex(10,5);
        helpContr();
        loadXtgl();
    });
    
    function loadOther(){
        if(systemcode=="gad"){
            //页面加载时，生成菜单
            setMenu();
            shouYeJiaZaiYeMian="";
        }else if(systemcode=="qyd"){
            setMenu();
            $("#loginInfoTD").empty();
            shouYeJiaZaiYeMian="";
        }
        jiaZaiShouYeYeMian();
    }
    
    function loadXtgl(){
            //页面加载时，生成菜单
        setMenu("zcd");
        shouYeJiaZaiYeMian="";
       
        jiaZaiShouYeYeMian();
    }
</script>

<body style="margin:0px;">
<table width="1020" border="0"  align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
      <div id="allDiv" align="center">
        <div id="antiFooter">
		  <div id="header">
            <div id="logo">
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="43" colspan="2" valign="top"><table width="96%" border="0" align="center" cellpadding="3" cellspacing="0">
          <tr>
            <td width="50%">
                <table>
                    <tr>
                        <td style="white-space:nowrap;">当前用户：<span class="yhxx"><%=username %>(<%=gxdwmc%>)</span></td>
                        <td id="loginInfoTD" style="white-space:nowrap;">今日共有<span class="yhxx" id="loginNum"></span>个，全部共有<span class="yhxx" id="loginSum"></span>个用户登录</td>
                    </tr>
                 </table>
            </td>
            <td width="50%" align="right">
                <!--    
                    tz_login_button 为跳转按钮ID 各行业如无特殊需求可以不改此id。
                    如果修改id值的话，reloadHyIndex方法，
                    请将此id当参数传入(reloadHyIndex方法在index.jsp页面中)
                 -->
                <img src="images/redo1_16x16.gif" width="16" height="18" id="tz_login_img"/>
                    <a class="headlink" href="#" id='tz_login_button'>跳转</a>    
                <img src="images/ioc_02.jpg" width="16" height="18" id='login_img'/>        
                    <a class="headlink" href="#" id='login' onclick='fnloginSy();'>首页</a>
                 <img src="images/lightbulb.gif" width="16" height="18" id='sytz_img'/>
                <a class="headlink" href="#" id='sytz_button' onClick="loadXtgl();">台帐</a>   
            <img src="images/ioc_04.jpg" width="17" height="18" id="pwd_img"/>                   
                    <a class="headlink" href="#" id='modifypassword' onclick='fnmodifypassword();'>修改密码</a>
                <img src="images/ioc_06.jpg" width="20" height="18" />              
                    <a class="headlink"   href="#"  id='help'>帮助</a>
                <img src="images/ioc_08.gif" width="19" height="18" />              
                    <a class="headlink" href="#" id='logout' onclick='fnlogout();'>退出</a>   
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="9%"></td>
        <td width="91%" valign="bottom" class="titlefont" ></td>
      </tr>
      <tr>
        <td></td>
        <td valign="top" class="smalltitlefont" >&nbsp;</td>
      </tr>
    </table>
            </div>
          </div>
        </div>
      </div>
      <div id="div_moveMenu" style="float:right;margin-top: -21" ></div>
<div id="div_menumain" style="margin-top: -28"><ul id='menumain' class='jd_menu jd_menu_jdsharp'></ul></div>
<div id=iframes onload='$("iframes").show("slow");' style="top:128px; width:1020px;height:602px; background-color:#cae4ff; background:url(images/jszc_bg.jpg) no-repeat center;   padding: 0px; "></div>
<div id="password_modify" class="page-layout" src="#" style="display: none; top: 110px; left: 350px; width: 300px;"></div>

    </td>
  </tr>
</table>
