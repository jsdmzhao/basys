<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	//登录用户所在部门父节点id
	int parentdeptid = -1;
	String gxdwbm = "";
	User user = new User();
	//获得登录用户session
	user = (User)session.getAttribute(Constants.userKey);
	if(user == null){
		response.sendRedirect("login.jsp");
	}
	else{
		parentdeptid = user.getDepartment().getParentdepartid().intValue();
		int level = 0;
		level = user.getDepartment().getDepartlevel();
		if(level > 2){
			gxdwbm=user.getDepartment().getDepartcode();
		}
	}	
%>

<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" />
<script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>

<script type="text/javascript">
	var selectDepartTreeWidth;
	var xctbParentdeptid;
	var xctbTreeDepartid;
	var xctbSelecttables;
	var gxdwTree;
	
	
	$(document).ready(function(){
		selectDepartTreeWidth = $("#selectDepartTree").width();
		$("#selectDepartTree").css({width:pageWidth - 838});
		$("#selectDepartTree").css({height:pageHeight - 142});
		itemSelect = 0;
		xctbParentdeptid = '<%=parentdeptid%>';
		//构建管辖单位列表
		gxdwTree = new dhtmlXTreeObject("selectDepartTree", "100%", "100%", xctbParentdeptid);
  		gxdwTree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
		//绑定单击事件
		gxdwTree.setOnClickHandler(selectDepartTreeOnClick);
		//载入管辖单位列表数据
  		gxdwTree.setXMLAutoLoading("sysadminDefault/deptTree_tree.action?");
  		gxdwTree.loadXML("sysadminDefault/deptTree_tree.action");
		$("#p_hylbbm").val(hylbbm);
		$("#d_hylbbm").val(hylbbm);
		$("#p_gxdwbm").attr("value","<%=gxdwbm%>");
		//载入行业类别列表数据
		loadXctbSelectPage("qydwData");
	});
	
	//重写别列表初始化函数
	function loadXctbSelectPage(divpageid){
		xctbSelecttables=$("#"+divpageid).html();	
		setXctbSelectPageList(1,'#');
	}

    //重写列表数据查询函数
    function setXctbSelectPageList(pageno, url){
        url = setXctbSelectList(pageno, url);
        // create the grid
        // returns a jQ object with a 'g' property - that's ingrid
        var mygrid1 = $("#qydwTable").ingrid({
            url: url,
            noSortColIndex: [0, 1, 2],
            tableid: "qydwTable",
			alignCenterColIndex: [0, 1],
            pageNumber: pageno,
            ingridPageParams: sXML,
			onRowSelect: null,
			height: pageHeight - 160,
			sorting: false,
			paging: false,
			ingridPageWidth: 518,
			changeHref:function(table){
				$(table).find("tr").each(function(){
					//var id = $(this).attr("id");
					//var qymc = $(this).find("td:last").html();
					// id='" + id + "' value='" + qymc + "'
					$(this).find("td:first").before("<td><input type='checkbox'/></td>");
				});
			},
            colWidths: ["10%", "20%", "70%"]
        });
    }
	
	//重写url设置函数
	function setXctbSelectList(pageno,url){
		$("#qydwData").html(xctbSelecttables);
		createXML("p_");
		if (url == null || url == "undefined"){
			url = "basicsystem/queryQydwList_xctb.action";
		}
		return url;
	}
	
	//管辖单位列表单击事件
    function selectDepartTreeOnClick(itemId){
		//选中的情况
		var userdatavalue = gxdwTree.getUserData(itemId,itemId);
  		if(userdatavalue == null || userdatavalue==undefined)
  			userdatavalue = "";
  		var userdatavalueArr = userdatavalue.split(",");
		var level = 0;
		level = userdatavalueArr[2];
		if(level > 2){
			$("#p_gxdwbm").val(userdatavalueArr[0]);
		} else {
			$("#p_gxdwbm").val("");
		}
		setXctbSelectPageList(1);
    }
	
	//选择行业类别事件
	$("#s_hylbmc").click(function(){
		//变量hylbbm在XctbAdd.sjp已声名
		setClearHylb();
		$("#s_hylbmc").val("");
		$("#s_hylbbm").val("");
		getHylbTree("s_hylbmc", "s_hylbbm", hylbbm);
    });
	
	//清除session
	function setClearHylb(){
		jQuery.post("basicsystem/clearHylb_xctb.action",null,null,"json");	
    }
	
    /*生成行业类别字典树形结构
     *mcId-行业类别名称控件,dmId-行业类别代码控件,flag-大行业标志
     **/
	var hylbmcId="";
	var hylbbmId="";
	var hylbdictCode="";
    function getHylbTree(mcId, dmId, flag){
        hylbmcId = mcId;
        hylbbmId = dmId;
        hylbdictCode = flag;
        if ($("#divs_" + mcId).length > 0) {
            return;
        }
        shuaiXuanKuangComm(mcId, dmId);
        detailidDict = "divs_" + mcId;//DIV层的ID
        addHtmlDict = "basic/common/hylbTree.jsp";//DIV层内嵌的jsp页面
        addWidthDict = "400"; //DIV层的宽度
        setDictPage();
    }
	
	//关闭接收单位选择页面
    function closeXctbSelectDiv(){
        $("#xctb_select").hideAndRemove("show");
    }
	
	//复选框全选函数
	function xctbSelectAll(obj){
		var checkState = $(obj).attr("checked");
		$("#qydwTable").find("input:checkbox").attr("checked",checkState);
	}
	
	//添加选中的企业单位
	var qydwmcs = "";
	function addQydw(){
		var qydwbms = "";
		var num = 0;
		qydwmcs = "";
		$("#qydwTable").find("input:checked").each(function(){
			var bm = $(this).attr("id");
			if(bm != "xctbCheckAll"){
				//获取企业编码
				bm = $(this).parent().parent().attr("id");
				//获取企业名称
				var mc = $(this).parent().next().next().text();
				if(qydwbms == ""){
					qydwbms = "'" + bm + "'";
					qydwmcs = mc;
					
				}else{
					qydwbms = qydwbms + ",'" + bm + "'";
					//仅回显15家单位的名称
					if (num < 15) {
						qydwmcs = qydwmcs + ";" + mc;
					}
				}
				num++;
			}
		});
		if(qydwbms == ""){
			jAlert("请选中企业后再确定",'提示信息');
			return false;
		}
		$("#d_qybms").attr("value", qydwbms);
		setParams("d_");
		jQuery.post("basicsystem/addQydw_xctb.action", params, addQydwBack, "json");
		closeXctbSelectDiv();
	}
	
	function addQydwBack(){
		if($("#" + gmcId).attr("id")!= null && $("#" + gmcId).attr("id")!= undefined ){
 			$("#" + gmcId).attr("value", qydwmcs);
 		}
		$("#divs_" + gmcId).remove();		
    }
</script>

<input type="hidden" id="s_hylbbm">
<input type="hidden" id="p_hylbbm">
<input type="hidden" id="p_gxdwbm" value="">
<input type="hidden" id="d_qybms">
<input type="hidden" id="d_hylbbm">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td align="left" class="title1">接收单位选择</td>
      	<td align="right" class="title1"><a href="#" id="closeSelectDiv" onclick='closeXctbSelectDiv();'class="close"></a></td>
	</tr>	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableborder">
	<tr>
		<!--管辖单位列表-->
        <td valign="top" width="25%">
            <div class="treediv">
                <table width="100%" align="center" cellpadding="1" cellspacing="3" class="titleTable">
                    <tr>
	                	<td style="font-weight:bold" >管辖单位列表</td>
	            	</tr>
					<tr>
                        <td class="tdContent">
                            <table width="100%" border='0' align="center" cellpadding="1" cellspacing="1" class="listTable">
                                <tr>
                                    <td valign="top">
                                        <div id="selectDepartTree" class="titleTablenei"></div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </td>
		<td  width="1%"><img name="" src="" width="2" height="1" alt=""></td>
		<!--单位选择页面-->
        <td valign="top" width="75%" style="text-align:left;">
            <div class="textdiv" valign="top" align="left">
                <table width="100%" cellpadding="4" cellspacing="0" class="tableborder">
                	<!--行业类别列表-->
                	<tr>
        				<td width="4%" class="detailtd">行业类别</td>
						<td width="10%" class="detailtd">
							<input type="text" class="inputstyle1" id="s_hylbmc" value="" style="width:200" readonly />
						</td>
                        <td width="4%">
                            <a href="#" class="searchbutton" id="searchQydw" title="查询" onClick="setXctbSelectPageList(1);">查询</a>
                        </td>
                        <td width="10%">
                            <a href="#" class="addbutton" id="addQydw" title="确定" onClick="addQydw();">确定</a>
                        </td>
      				</tr>					
                </table>
            </div>
			<!--单位选择列表-->
			<div id="qydwData" style="width:100%;">
			    <table id="qydwTable" width="100%">
			        <thead>
			            <tr>
			                <th name="">
			                    <input type='checkbox' id='xctbCheckAll' onclick='xctbSelectAll(this)'/>
								全选
			                </th>
			                <th name="l_qybm">
			                                                       企业编码
			                </th>
			                <th name="l_qymc">
			                  	 企业名称
			                </th>
			            </tr>
			        </thead>
			    </table>
			</div>
        </td>
	</tr>
</table>

