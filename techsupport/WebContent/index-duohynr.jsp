<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="public/common.jsp"%>
<script type="text/javascript">
	$(document).ready( function() {
		$("#xiechatbdiv").height(duoHangYeNeiRongHeight);
		tztgList();
		$("#jqxx_DIV").empty();
		$("#jqxx_DIV").load("basic/publicsystem/DhyJqxxManList.jsp");

		//$("#yeWuXtYxQk").val($("#yeWuXtYxQkData").html());
		//yeWuXtYxQk_setPageList(1);
		daggleDiv("xctb_detail");
	});
	
function tztgList(){
	setParams("q_");
	jQuery.post("basicsystem/querylistFortitile_xctb.action",params,tztgList_updatediv,"json");
}
function tztgList_updatediv(json){
	var xctblist=json.LXctb;
	var str="";
	if(xctblist.length<1){
		for(var i=0;i<3;i++){
			str+='<tr><td bgcolor="#FFFFFF">&nbsp;</td></tr>';
		}
	}else{
		//str+="";
		for(var i=0;i<xctblist.length;i++){
			str+='<tr><td bgcolor="#FFFFFF"><img src="images/jt.jpg" width="7" height="9" />&nbsp;<a href="#" onclick="tztgDetail('+xctblist[i].tbid+');">'+xctblist[i].bt+'</a></td></tr>';
		}
		//str+=" ";
	}
	$("#tztgTable").append(str);
	//$("marquee").preend(str);
}

function tztgDetail(tbid){
	detailUrl="basicsystem/query_xctb.action";
	setQuery(tbid,"basic/basicsystem/XctbDetail.jsp");
}

	function jinqinxx_setPageList(pageno) {
		$("#JinQingXxData").html($("#jinqinxinxi").val());
		var mygrid1 = $("#JinQingXxTable").ingrid( {
			url :"#",
			height :duoHangYeNeiRongHeight,
			tableid :"JinQingXxTable",
			pageNumber :pageno,
			ingridPageWidth :790,
			ingridPageParams :sXML,
			sorting :false,
			isPlayResultNull :false,
			paging:false,
			colWidths : [ "20%", "20%", "20%", "20%", "20%" ]
		});
	}
	
	function yeWuXtYxQk_setPageList(pageno) {
		$("#yeWuXtYxQkData").html($("#yeWuXtYxQk").val());
		var mygrid1 = $("#yeWuXtYxQkTable").ingrid( {
			url :"#",
			height :duoHangYeNeiRongHeight,
			tableid :"yeWuXtYxQkTable",
			pageNumber :pageno,
			ingridPageWidth :790,
			ingridPageParams :sXML,
			sorting :false,
			isPlayResultNull :false,
			paging:false,
			colWidths : [ "20%", "16%", "16%", "16%", "16%", "16%" ]
		});
	}
	
</script>
<input type="hidden" id="jinqinxinxi" />
<input type="hidden" id="yeWuXtYxQk" />
<!-- 控制警情信息的高和宽 -->
<input type="hidden" id="tzJqxxWidth" value="740"/>
<input type="hidden" id="tzJqxxHeight" value="218"/>
<div id="xctb_detail"  style="top: 30px; left: 160px;; overflowY: scroll;">
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
        <td><img src="images/tztg.jpg" width="790" height="28" /></td>
  </tr>
      <tr>
        <td>
        <table width="100%" border="0" cellpadding="1" cellspacing="0" bgcolor="#b9cfe4">
          <tr>
            <td>
            	 <table width="100%" border="0" cellspacing="0" bgcolor="#ffffff" cellpadding="0">
			             <tr>
            <td>         
            	<div class="scrollbarface"  style="top: 30px; left: 160px;; overflowY: scroll;">
		            	<!-- 通知通报Table -->
			        <marquee direction=up border=1 scrollDelay=200 height="70" onmouseover=stop() onmouseout=start()>
                        <table id="tztgTable" width="100%" border="0" cellspacing="0" cellpadding="5">
			            </table>
                    </marquee>
	            </div>
                </td></tr>
                </table>
            </td>
          </tr>
        </table></td>
      </tr>
    </table>
<table width="10" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="5"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><img src="images/jqxx.jpg" width="790" height="28" /></td>
        </tr>
        <tr>
          <td>
               <table width="100%" border="0" cellpadding="1" cellspacing="0" bgcolor="#b9cfe4">
          <tr>
            <td>
            	 <table width="100%" border="0" cellspacing="0" bgcolor="#ffffff" cellpadding="3">
			             <tr>
            <td> 
				<!-- 警情信息DIV -->
          		<div id="jqxx_DIV"></div>
                </td></tr>
                </table>
            </td>
          </tr>
        </table>
          </td>
        </tr>
      </table>
<table width="10" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="5"></td>
        </tr>
      </table>
<!--      <table width="98%" border="0" cellspacing="0" cellpadding="3" style=" border:1px #c5d9e8 solid ">-->
<!--        <tr>-->
<!--          <td><img src="images/ywxtyxqk.jpg" width="748" height="28" /></td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td><table width="100%" border="0" cellpadding="1" cellspacing="0" bgcolor="#b9cfe4">-->
<!--              <tr>-->
<!--                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">-->
<!--                    <tr>-->
<!--                      <td bgcolor="#FFFFFF"><div id="yeWuXtYxQkData" style="width: 100%;">-->
<!--							<table id="yeWuXtYxQkTable" width="100%">-->
<!--								<thead>-->
<!--									<tr>-->
<!--										<th name="">-->
<!--											公安机关-->
<!--										</th>-->
<!--										<th name="">-->
<!--											场所总数-->
<!--										</th>-->
<!--										<th name="">-->
<!--											人员总数-->
<!--										</th>-->
<!--										<th name="">-->
<!--											营业日志未上传-->
<!--										</th>-->
<!--										<th name="">-->
<!--											未上传场所-->
<!--										</th>-->
<!--										<th name="">-->
<!--											上传不充分场所-->
<!--										</th>-->
<!--									</tr>-->
<!--								</thead>-->
<!--							</table>-->
<!--						</div></td>-->
<!--                    </tr>-->
<!--                </table></td>-->
<!--              </tr>-->
<!--          </table></td>-->
<!--        </tr>-->
<!--      </table>-->