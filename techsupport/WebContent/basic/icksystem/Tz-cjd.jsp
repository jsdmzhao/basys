<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
//String jdzkd = QjblUtil.queryQjblVal("jdzkd");//是否金盾制卡端 1否0是
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<script type="text/javascript">
	var pageDetailUrlId = "tzYlyCjd_detail";
	var cjd_tzxxtj="icksystem/cjdtzxxtj_icksl.action";
	$(document).ready(function() {
	    if(typeof(cjdtjrq)!='undefined'){
            cjdtjrq='';
        }
		$("#"+pageDetailUrlId).hide();
		$.post(
         	"<%=basePath%>sysadmin/queryUserMenu_menu.action", 
         	null,
         	function(json){
         	    if(json.result == '1'){
         	        $("#tr_wtjcs").show();
         	        $("#tr_wtjcyry").show();
         	    }else{
         	        $("#tr_wtjcs").hide();
         	        $("#tr_wtjcyry").hide();
         	    }
 			},
 			"json"); 
		<%//if("0".equals(jdzkd)) {%>
		//$("#title").html("系统运行情况");
		//$("#tzzkxx_detail").empty();
		//$("#tzzkxx_detail").load("basic/icksystem/TzZkYxqkMan.jsp");
		<%//}
		//if("1".equals(jdzkd)) {
		%>
		//$("#title").html("第三方制卡情况");
		//$("#tzzkxx_detail").empty();
		//$("#tzzkxx_detail").load("basic/icksystem/TzDsfxxMan.jsp");
		<%//}%>
		//未上传场所情况
		$("#wsccsqk_detail").empty();
		$("#wsccsqk_detail").load("business/Ylfwzagl/TzxxWscCsxxMan.jsp");
		//超时卡未办理情况
		$("#cskwblqk_detail").empty();
		$("#cskwblqk_detail").load("basic/icksystem/TzxxCskwblMan.jsp");
		$("#x_hylbdm").selectBoxinhylb({code:"J"});
		setParams("x_");
		//信息统计&待处理信息
		jQuery.post(cjd_tzxxtj,params,tzxxtj_updatediv,"json");
		//待受理IC卡信息
		jQuery.post("icksystem/querylistCount_icksl.action",params,dslick_updatediv,"json");
		
		daggleDiv(pageDetailUrlId);
	});
	function tzxxtj_updatediv (json) {
	    if(json.LIcksl[0]!=null){
	        $("#ycjcsxxzs").html(setNull(json.LIcksl[0].ycjcssl));
	        $("#ycjcyryxxzs").html(setNull(json.LIcksl[0].ycjrysl));
	        $("#yslick").html(setNull(json.LIcksl[0].yslick));
	        $("#yffick").html(setNull(json.LIcksl[0].yffsl));
	        $("#yjswlb").html(setNull(json.LIcksl[0].yjswlbsl));
	        $("#yzxick").html(setNull(json.LIcksl[0].yzxicksl));
	        $("#bhick").html(setNull(json.LIcksl[0].bhicksl));
	        $("#wtjcsxx").html(setNull(json.LIcksl[0].wtjcssl));
	        $("#wtjcyryxx").html(setNull(json.LIcksl[0].wtjrysl));
	        $("#dffickxx").html(setNull(json.LIcksl[0].dfficksl));
	        //需求变更，去除$("#dbhkickxx").html(setNull(json.LIcksl[0].dbhicksl));
	        $("#wlbbfjs").html(setNull(json.LIcksl[0].wlbbfjs));
	        $("#wlbjsbcg").html(setNull(json.LIcksl[0].wlbjsbcg));
	    }
	}
	function dslick_updatediv(json){
	    if(json.LIcksl[0]!=null){
	        $("#dslickxx").html(setNull(json.LIcksl[0]));
	    }
	}
	
	function xxtjDeatil(url){
	    setWidth(pageDetailUrlId,"900");
	    setUrl(pageDetailUrlId,url);
	    bindDocument(pageDetailUrlId);
	}
	function tzzhcxDeatil(url,zhcxflag){
	    dataid=zhcxflag;
	    setWidth(pageDetailUrlId,"900");
	    setUrl(pageDetailUrlId,url);
	    bindDocument(pageDetailUrlId);
	}
	function tzxxDeatil(url){
	    dataid = "tzxxFlag";
	    $(window.top.document.getElementById("iframes")).load(url);
	}
</script>
<body>
	<div style="display:none;">
		<select id="x_hylbdm"></select>
	</div>
	<div style="float: left; margin-top: 0px;">
		<fieldset style="width: 685">
			<legend style="font-size: 13px;">
				&nbsp;<span id="title">未上传场所情况</span>&nbsp;
			</legend>
			<div id="wsccsqk_detail"></div>
		</fieldset>
		<fieldset style="width: 685">
			<legend style="font-size: 13px;">
				&nbsp;<span id="title">超时卡未办理情况</span>&nbsp;
			</legend>
			<div id="cskwblqk_detail"></div>
		</fieldset>
	</div>
	<div style="float: left; margin-top: 0px; margin-left: 7px">
		<fieldset style="width: 300">
			<legend style="font-size: 13px;">
				&nbsp;信息统计&nbsp;
			</legend>
			<table width="100%" bordercolordark='#FFFFFF'
				bordercolorlight='#cccccc' border='1' cellpadding='0'
				cellspacing='0'>
				<tr height="22">
					<td width="40%" align="right" style="padding-right: 5px">
						已采集场所信息
					</td>
					<td width="60%" align="left" style="padding-left: 3px">
					<a style="cursor:hand;" onclick="xxtjDeatil('business/Ylfwzagl/TzYcjCsxxMan.jsp');" class="hyperlink">
						<span id="ycjcsxxzs">0</span>
					</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已采集从业人员信息
					</td>
					<td align="left" style="padding-left: 3px">
					<a style="cursor:hand;" onclick="xxtjDeatil('business/Ylfwzagl/TzYcjCyryxxMan.jsp');" class="hyperlink">
						<span id="ycjcyryxxzs">0</span>
					</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已受理IC卡
					</td>
					<td align="left" style="padding-left: 3px">
					<a style="cursor:hand;" onclick="xxtjDeatil('basic/icksystem/TzIckYslMan.jsp');" class="hyperlink">
						<span id="yslick">0</span>
					</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已发放IC卡
					</td>
					<td align="left" style="padding-left: 3px">
					<a style="cursor:hand;" onclick="tzzhcxDeatil('basic/icksystem/TzIckzhcxMan.jsp','yfficklist');" class="hyperlink">
						<span id="yffick">0</span>
					</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已接收物流包
					</td>
					<td align="left" style="padding-left: 3px">
					<a style="cursor:hand;" onclick="xxtjDeatil('basic/icksystem/TzYjswlbxxMan.jsp');" class="hyperlink">
						<span id="yjswlb">0</span>
					</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已注销IC卡
					</td>
					<td align="left" style="padding-left: 3px">
					<a style="cursor:hand;" onclick="tzzhcxDeatil('basic/icksystem/TzIckzhcxMan.jsp','yzxicklist');" class="hyperlink">
						<span id="yzxick">0</span>
					</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						补换IC卡
					</td>
					<td align="left" style="padding-left: 3px">
					<a style="cursor:hand;" onclick="tzzhcxDeatil('basic/icksystem/TzIckzhcxMan.jsp','bhicklist');" class="hyperlink">
						<span id="bhick">0</span>
					</a>
					</td>
				</tr>
			</table>
		</fieldset>
<table>
	<tr><td height="31"></td></tr>
</table>
		<fieldset style="width: 300">
			<legend style="font-size: 13px;">
				&nbsp;待处理信息&nbsp;
			</legend>
			<table width="100%" bordercolordark='#FFFFFF'
				bordercolorlight='#cccccc' border='1' cellpadding='0'
				cellspacing='0'>
				<tr height="22" id="tr_wtjcs">
					<td width="40%" align="right" style="padding-right: 5px">
						未提交场所信息
					</td>
					<td width="60%" align="left" style="padding-left: 3px">
						<a style="cursor:hand;" onclick="tzxxDeatil('business/Ylfwzagl/YlcsjbxxMan-tijiao.jsp');" class="hyperlink">
						<span id="wtjcsxx">0</span>
						</a>
					</td>
				</tr>
				<tr height="22" id="tr_wtjcyry">
					<td align="right" style="padding-right: 5px">
						未提交从业人员信息
					</td>
					<td align="left" style="padding-left: 3px">
					    <a style="cursor:hand;" onclick="tzxxDeatil('business/Ylfwzagl/CyryxxMan-tijiao-cjd.jsp');" class="hyperlink">
						<span id="wtjcyryxx">0</span>
						</a>
					</td>
				</tr>
				<tr height="22">
					<td width="40%" align="right" style="padding-right: 5px">
						待受理IC卡信息
					</td>
					<td width="60%" align="left" style="padding-left: 3px">
					    <a style="cursor:hand;" onclick="tzxxDeatil('basic/icksystem/IckslMan.jsp');" class="hyperlink">
						<span id="dslickxx">0</span>
						</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						待发放IC卡信息
					</td>
					<td align="left" style="padding-left: 3px">
					    <a style="cursor:hand;" onclick="tzxxDeatil('basic/icksystem/IckffMan.jsp');" class="hyperlink">
						<span id="dffickxx">0</span>
						</a>
					</td>
				</tr>
				<!-- 需求变更，去除 待补换卡IC卡信息
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						待补换卡IC卡信息
					</td>
					<td align="left" style="padding-left: 3px">
					    <a style="cursor:hand;" onclick="tzxxDeatil('basic/icksystem/IckbhkMan.jsp');" class="hyperlink">
						<span id="dbhkickxx">0</span>
						</a>
					</td>
				</tr>
				 -->
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						物流包部分接收
					</td>
					<td align="left" style="padding-left: 3px">
					    <a style="cursor:hand;" onclick="tzxxDeatil('basic/icksystem/WldjMan.jsp');" class="hyperlink">
						<span id="wlbbfjs">0</span>
						</a>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						物流包接收不成功
					</td>
					<td align="left" style="padding-left: 3px">
					    <a style="cursor:hand;" onclick="tzxxDeatil('basic/icksystem/WldjMan.jsp');" class="hyperlink">
						<span id="wlbjsbcg">0</span>
						</a>
					</td>
				</tr>
			</table>
		</fieldset>
	</div>

	<div id="tzYlyCjd_detail" class="page-layout" src="#"
		style="z-index: 2000; top: 60px; left: 0px;"></div>
</body>