<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
String stCJDFlag = "";// 省厅采集点标志
if((departCode.indexOf("CJD")!=-1) && (departCode.length()==5)){// 省厅采集点
    stCJDFlag = "1";
}else{
    stCJDFlag = "0";
}
%>
<script type="text/javascript">
var gnRyHtml,gwRyHtml,QyHtml;
var stCJDFlag = '<%=stCJDFlag%>';
	var colWidths0 = ["6%","18%","12%","5%","30%","11%","13%","5%"];
	var colWidths1 = ["12%","13%","14%","12%","19%","15%","15%","0%"];
	var tableWidth;
	var hideCol0 = [];
	var hideCol1 = [7];
	var hideCol;
	
	if(stCJDFlag=='0'){
	    tableWidth = colWidths0;
	    hideCol = hideCol0;
	}else{
	    tableWidth = colWidths1;
	    hideCol = hideCol1;
	}
$(document).ready(function() {
	//从业人员详细信息页面
	gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp";
	gwRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp";
	//场所详细信息页面
	QyHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	pageUrl="icksystem/zxIckList_icksl.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="icksystem/insert_icksl.action";
	addHtml="basic/icksystem/IckslAdd.jsp";
	addWidth="500";
	delUrl="icksystem/delete_icksl.action";
	delid="d_ryid";
	modHtml="basic/icksystem/IckslModify.jsp";
	modUrl="icksystem/modify_icksl.action";
	modWidth="800";
	detailHtml="basic/icksystem/IckffDetail.jsp";
	detailid="ickff_detail";
	detailUrl="icksystem/queryFf_icksl.action";
	detailWidth="800";
	zxUrl="icksystem/modifyzx_icksl.action";
	zxid="d_ickslid";
	loadPage("tabledata");
		$("#p_cjsjf").attr("readonly","true");
		$("#p_cjsjf").datepicker();
		$("#p_cjsjt").attr("readonly","true");
		$("#p_cjsjt").datepicker();
		
		// 行业类别	
		$("#p_hylbdm").selectBoxhylb();
		// 企业筛选框
		$("#p_qymc").click(function(){
		    dataid=$('#p_hylbdm').val();
		 	getTy_item("p_qymc","p_qybm");
		  });
	
		daggleDiv("ickff_detail");
		daggleDiv("ickzh_detail");
		daggleDiv("qyjbxx_detail");
		setHyxx();
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
		                                tableid: 'ickfftableid',
		                                isPlayResultNull: true,
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										onRowSelect: null,
										url: url,	
										colClasses: ['grid-col-style2','grid-col-style2','grid-col-style2'],
										colIndex: [1,2,4],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==1)
															setIckDetail(tr);
														else if(tdnum==2)
															setRyDetail(tr);
														else if(tdnum==4)
															setQyDetail(tr);
													}
											});
										},
										height: pageHeight-256,
										pageNumber: pageno,
										hideColIndex:hideCol,
										colWidths: tableWidth									
									});				
		}
		setHyxx();
}	
	function manVerify(){
		if (!checkControlValue("p_cyrybh","String",1,40,null,0,"人员编号"))
			return false;
		if (!checkControlValue("p_qymc","String",1,40,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_kh","String",1,20,null,0,"IC卡卡号"))
			return false;
			
		var cjsjf = $("#p_cjsjf").val();
		var cjsjt = $("#p_cjsjt").val();
		if(cjsjf!=null && cjsjf!="" && cjsjt!=null && cjsjt!=""){
			if(cjsjf>cjsjt){
				jAlert("受理时间必须大于受理时间至","验证信息",null,"p_cjsjf");
				return false;
			}
		}
		return true;
	}

//人员详细查询
function setRyDetail(obj){
	dataid=$(obj).find("input[name='ryid"+$(obj).attr("id")+"']").val();
	sFlag="false";
	setWidth(detailid,modWidth);
	var rylbInput = $(obj).find("input[name='rylb"+$(obj).attr("id")+"']");
	var rylbValue = rylbInput.val();
	$("#f_rylbbm").val(rylbValue);
	if(rylbValue == 0){
		detailUrl="publicsystem/query_qyryxx.action";
		setUrl(detailid,gnRyHtml);
	}else{
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		setUrl(detailid,gwRyHtml);
	}
	bindDocument(detailid);
}

	//IC卡注销	
	function setZxIck(id){
		sFlag="false";
		jConfirm('确定注销该卡吗？', '提示', function(r) {
	    	if(r==true){
				$("#"+zxid).attr("value",id);
				setParams("d_");
		        jQuery.post(zxUrl,params,zxback,"json");
			}else{
			   return false;
			}
		});
	}
	
	//IC卡注销回调函数
	function zxback(json){
		if  (json.result=="success"){
			jAlert("注销成功",'提示');
			var pageno=$("#pageNo").attr("value");
			setPageList(pageno);
		}else{
			jAlert(json.result,'错误');
		}	
	}
//场所详细查询
var qyjbxx_requestType;
var qyjbxx_dataid;
var qyjbxx_detailWidth="990";
function setQyDetail(obj){
	detailUrl="publicsystem/query_qyjbxx.action";
	qyjbxx_requestType="detail";
	qyjbxx_dataid=$(obj).find("input[name='qy"+$(obj).attr("id")+"']").val();
	setWidth("qyjbxx_detail",qyjbxx_detailWidth);
	setUrl("qyjbxx_detail",QyHtml);
	sFlag="false";
	bindDocument("qyjbxx_detail");
}
function qyjbxx_setDetail(){
	setParams("q_");
	jQuery.post("publicsystem/query_qyjbxx.action",params,qyjbxx_updatediv,"json");
}

//IC卡详细查询
function setIckDetail(obj){
	dataid=$(obj).attr("id");
	sFlag="false";
	detailUrl="icksystem/queryZh_icksl.action";
	setWidth("ickzh_detail",modWidth);
	setUrl("ickzh_detail","basic/icksystem/IckzhcxDetail.jsp");
	bindDocument("ickzh_detail");
}
function setHyxx(){
        var hylb=$("#p_hylbdm").val();
		if(hylb=='J'||hylb=='K'){
			$('#td_qymc').text('场所名称');
			$('#td_qybm').text('场所备案编号');
			$('#tabledata').find('thead').find('th[@name=l_qymc]').find('DIV').html('场所名称');
		}else{
		    $('#td_qymc').text('企业名称');
		    $('#td_qybm').text('企业编号');
			$('#tabledata').find('thead').find('th[@name=l_qymc]').find('DIV').html('企业名称');
		}
    }

</script>

<body>
	<input type="hidden" id="q_cyrybhSet" value="">
	<input type="hidden" id="q_khSet" value="">
	<input type="hidden" id="f_rylbbm" value="">
	<input type="hidden" id="p_qybm" value="">
	<input type="hidden" id="d_ickslid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">IC卡注销</td>
  </tr>
  <tr>
    <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
      <tr>
        <td width="10%" class="pagedistd">行业类别</td>
		<td width="23%" class="pagetd"><select  id="p_hylbdm" onchange="setHyxx();"></select></td>
        <td width="10%" class="pagedistd" id="td_qymc">企业名称</td>
        <td width="23%" class="pagetd"><input id="p_qymc" type="text" readonly class="inputstyle"></td>
        <td width="10%" class="pagedistd">姓名</td>
        <td width="23%" class="pagetd"><input id="p_xm" type="text" class="inputstyle"></td>
      </tr>
      <tr>
        <td width="10%" class="pagedistd">IC卡卡号</td>
        <td width="23%" class="pagetd"><input id="p_kh" type="text" class="inputstyle" /></td>
        <td width="10%" class="pagedistd">人员编号</td>
        <td width="23%" class="pagetd"><input id="p_cyrybh" type="text" class="inputstyle" /></td>
        <td width="10%" class="pagedistd">受理时间</td>
        <td width="23%" class="pagetd"><input type="text" class="inputstyle1" id="p_cjsjf" />至
        <input type="text" class="inputstyle1" id="p_cjsjt" />
        </td>
      </tr>
      <tr>
      <td colspan="6" align="right">
      <table width="100" border="0" align="right" cellpadding="2" cellspacing="0">
          <tr>
            <td width="55" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
          </tr>
        </table>
        </td>
      </tr>
    </table></td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="ickff_detail"  class="page-layout" src="#"
		style="top:20px; left:160px; width:500px;">
</div>	
<div id="qyjbxx_detail"  class="page-layout" src="#"
		style="display:none;top:20px; left:160px; width:500px;">
</div>	
<div id="ickzh_detail"  class="page-layout" src="#"
		style="display:none;top:20px; left:160px; width:500px;">
</div>	
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_ickslid">序号</th>
	     	<th name="l_kh">IC卡卡号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_yxqhzrq">有效截至日期</th>
	     	<th name="l_wlpc">物流批次号</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>