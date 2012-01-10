<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css" />
        <link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" />
        <script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
        <script language="javascript" type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
    </head>
    <script type="text/javascript">
    	var hylbTreebm = ""; //全部场所名称
		var hylbTreemc = "";   ///  场所信息"1111||场所1||J||营业性娱乐场所";
		var hylbTree;
		$(document).ready(function(){
			$("#hylbTreeDropDown").css({height:300});
		    hylbTree = new dhtmlXTreeObject("hylbTreeDropDown", "100%", "100%", 0);
		    hylbTree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
		    //显示checkBoxes
		    hylbTree.enableCheckBoxes(1);
		    hylbTree.enableThreeStateCheckboxes(true);
			//绑定onCheck事件
		    hylbTree.setOnCheckHandler(hylbTreeOnCheck);     
		    var hylbdm = "";            
            if (hylbdictCode != null) {
                hylbdm = hylbdictCode;
            }
		    hylbTree.setXMLAutoLoading("basicsystem/hylbTree_xctb.action?hylbdm="+hylbdm);
		    hylbTree.loadXML("basicsystem/hylbTree_xctb.action?hylbdm="+hylbdm);
		});
		
        function hylbTreeOnCheck(itemId) {
			// 判断结点是否被选中的  1为选中 0未选中
            var flagcheck = hylbTree.isItemChecked(itemId); 
            var note = itemId.substring(0, 1); 
			//选中的情况
            if (flagcheck == 1) {
                if (note == 1) {
					//选择行业根节点的情况
                    selectAll(itemId);
                }else{
					//选择叶子行业的情况
					var userData = "<Params>";
               		userData += "<Param name='hylbbm'>" + itemId.substring(1) + "</Param>";
                	userData += "<Param name='hylbmc'>" + hylbTree.getItemText(itemId) + "</Param>";
               		userData += "</Params>";
                	selectHylbRequest({
                    	dataxml: userData,
                    	reXml: "1"
               		 }); 
				}
            } else if (flagcheck == 0) {
                //撤销的情况
                if (note == 1) {
					//撤销行业根节点的情况
                    outAll(itemId);
                } else {
                    var userData = "<Params>";
                    userData += "<Param name='hylbbm'>" + itemId.substring(1) + "</Param>";
                    userData += "</Params>";
                    selectHylbRequest({
                        dataxml: userData,
                        reXml: "0"
                    });
                }
            }
        }
	
		function selectHylbRequest(userData){
		  	jQuery.ajax({
				type: 'POST',
				url: "<c:out value="${pageContext.request.contextPath}"/>/basicsystem/setHylb_xctb.action",
				data: userData,
				async: true,
				dataType: 'json',
				success: function(json){
					 selectHylbResponse(json);					
				}
			});
  		}
		
		///选择结点的ajax方法
	    function selectAll(itemId){
		    if(itemId!=''){
			    var url ="<c:out value="${pageContext.request.contextPath}"/>/basicsystem/setHylbAll_xctb.action";
			    var params = {id:itemId, reXml:"1"};
			    jQuery.ajax({
			    type: 'POST',
			    url: url,
			    data: params,
			    async: true,
			    dataType: 'json',
			    success: function(json){
				    selectHylbResponse(json);
				    }
			    });
		    }
	    }
		
		///消去结点的ajax方法
	    function outAll(itemId){
		    if(itemId!=''){
			    var url ="<c:out value="${pageContext.request.contextPath}"/>/basicsystem/setHylbAll_xctb.action";
			    var params = {id:itemId, reXml:"0"};
			    jQuery.ajax({
			    type: 'POST',
			    url: url,
			    data: params,
			    async: true,
			    dataType: 'json',
			    success: function(json){
				    selectHylbResponse(json);
				    }
			    });
		    }
	    }
		
		//选择结点返回的方法
	    function selectHylbResponse(json){
	    	hylbTreemc = json.reXml;
	    }
		
	    //点击清除按钮，清除调用框及相应隐藏框的值
	    function addAllHylb(){
		    if($("#" + hylbmcId).attr("id")!=null&&$("#" + hylbmcId).attr("id")!=undefined ) {
		    	$("#" + hylbmcId).attr("value", hylbTreemc);
		    }
		    $("#divs_" + hylbmcId).remove();
	    }	
    </script>
    <body>
        <table width="100%" border="0" cellspacing="0" cellpadding="0" background="images/toolbar.gif">
            <tr>
            	<td height="6"></td>
            <tr>
                <td style="text-align:right">
                    <a href="#" id='b_clear' class="addbutton" onclick='addAllHylb();'>确定</a>
                </td>
            </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top">
                    <div class="treediv" style='width:400px'>
                        <!--表单样式开始 -->
                        <table width="100%" align="center" cellpadding="1" cellspacing="3" class="titleTable">
                            <tr>
                                <td class="tdContent">
                                    <table width="100%" border='0' align="center" cellpadding="1" cellspacing="1" class="listTable">
                                        <tr>
                                            <td valign="top">
                                                <div id="hylbTreeDropDown" style="width:100%;background-color:#eef6ff; border :0px solid Silver; overflow:auto;"></div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>
