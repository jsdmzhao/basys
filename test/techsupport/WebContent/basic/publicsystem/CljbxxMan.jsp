<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	
	pageUrl="publicsystem/querylist_cljbxx.action";
	divnid="CljbxxData";
	tableid="CljbxxTable";
	addUrl="publicsystem/insert_cljbxx.action";
	addHtml="business/publicsystem/CljbxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_cljbxx.action";
	delid="d_cljbxxid";
	modHtml="business/publicsystem/CljbxxModify.jsp";
	modUrl="publicsystem/modify_cljbxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/CljbxxDetail_gad.jsp";
	detailid="cljbxx_detail";
	detailUrl="publicsystem/query_cljbxx.action";
	$("#p_cszsbm").selectBox({code:"csys_dm"});
	$("#p_hylbdm").selectBoxhylb();//行业类别	
	detailWidth="800";
	loadPage(divnid);
	daggleDiv(detailid);
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-323,
										pageNumber: pageno,
										ingridPageParams: sXML,
										onRowSelect: function(tr, selected){
											setQuery($(tr).attr("id")); 	
										},
										colWidths: ["12%","10%","12%","12%","12%","12%","10%","10%","12%"]	
									});				
		}
}	
function setQuery(id){
		dataid=id;
		setWidth(detailid,detailWidth);
		setUrl(detailid,detailHtml);
		bindDocument(detailid);
	}
	function manVerify(){
		return true;
	}
	//////////////////////////////////////
	$('#p_clcdbm').selectBox({code:"dm_clpp(tree)",width:"40px",query:"0"});
	$('#p_clcd').val($('#p_clcdbm').attr('title'));
	//Load_clcd($('#p_clcdbm'));
	$('#p_clcsbm').selectBox({code:"",width:"95px"});
	$('#p_clppbm').selectBox({code:""});
	//$('#p_clxhbm').selectBox({code:""});
	function Load_clcd(obj){//加载厂商
		var itemId = $(obj).find("option[value='"+$(obj).val()+"']").attr("item");
		$("#p_clcsbm").selectBox({code:"dm_clpp(tree)",width:"95px",query:itemId});
		$("#p_clcs").val($("#p_clcsbm").attr('title'));
		$("#p_clcd").val($("#p_clcdbm").attr('title'));
		$('#p_clppbm').selectBox({code:""});
		$('#p_clpp').val('');
		//$('#p_clxhbm').selectBox({code:""});
		//$('#p_clxh').val('');
	}
	function Load_clcs(obj){//加载品牌
		var itemId = $(obj).find("option[value='"+$(obj).val()+"']").attr("item");
		$("#p_clppbm").selectBox({code:"dm_clpp(tree)",query:itemId});
		$('#p_clcs').val($("#p_clcsbm").attr('title'));
		//$('#p_clxhbm').selectBox({code:""});
		//$('#p_clxh').val('');
		$('#p_clpp').val('');
	}
	function Load_clpp(obj){//加载类型
		var itemId = $(obj).find("option[value='"+$(obj).val()+"']").attr("item");
		//$("#p_clxhbm").selectBox({code:"dm_clpp(tree)",query:itemId});
		$('#p_clpp').val($("#p_clppbm").attr('title'));
		//$('#p_clxh').val('');
	}
	function Load_clxh(){
		//$('#p_clxh').val($("#p_clxhbm").attr('title'));
	}
/////////////////////////////////////
//高级查询
function gaojichaxun_gnlk(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("182",detailid);//贵州用的id是181
}
$("#p_gxdwmc").click(function(){// 管辖单位
		getGxdw("p_gxdwmc","p_gxdwdm");
});
//车辆类型 
$("#p_cllx").click(function(){
if($('#p_hylbdm').val()=='F01'){
	getDict_item("p_cllx","p_cllxbm","dm_cllx(czc)");
}else{
	getDict_item("p_cllx","p_cllxbm","dm_cllx");
	}
});
</script>

<body>
	
	<input type="hidden" id="d_cljbxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><select type="select" id="p_hylbdm"></select></td>
					<td width="10%" class="pagedistd">登记编号</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_cldjxh" value=""></td>
					<td width="10%" class="pagedistd">车牌号</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_cph" value=""></td>
					
				</tr>
				<tr>
						<td width="10%" class="pagedistd">
							厂商
						</td>
						<td width="23%" class="pagetd">
							<table>
								<tr>
									<td><select id="p_clcdbm" onchange="Load_clcd(this);"><option></option></select></td>
									<td><select id="p_clcsbm" onchange="Load_clcs(this);"><option></option></select></td>
								</tr>
							</table>
						</td>
						
						<td width="10%" class="pagedistd">
							品牌
						</td>
						<td width="23%" class="pagetd">
							<select id="p_clppbm" onchange="Load_clpp(this);"><option></option></select>
						</td>
						<td width="10%" class="pagedistd">
							型号
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_clxh" >
						</td>
					</tr>
				<tr>
					<td width="10%" class="pagedistd">
								治安管理机构
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_gxdwmc" value="">
								<input type="hidden" id="p_gxdwdm">
							</td>
					<td width="10%" class="pagedistd">车辆类型</td>
					<td width="23%" class="pagetd">
					<input type="text" class="inputstyle"  id="p_cllx" value="" readonly="readonly">
					<input type="hidden" class="inputstyle"  id="p_cllxbm" value="">
					</td>
					<td width="10%" class="pagedistd">发动机号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_fdjh" value="" > </td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车架号/车辆识别代号</td>
					<td width="23%" class="pagetd">
					<input type="text" class="inputstyle" id="p_cjh" >
					</td>
					<td width="10%" class="pagedistd">车身颜色</td>
					<td width="23%" class="pagetd">
					<select   id="p_cszsbm" ><option></option></select>
					</td>
					
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车主姓名</td>
					<td width="23%" class="pagetd">
					<input type="text" class="inputstyle"  id="p_czm" value="" >
					</td>
					<td width="10%" class="pagedistd">车主身份证号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_czzjhm" value="" > </td>
				   <td colspan="2">
					  
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="submitlongbutton" onclick='gaojichaxun_gnlk();'>高级查询</a></td>
    		    	</tr>
    		  	</table>
    		  </td>
				</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="cljbxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="CljbxxData" style="width:100%;">
	<table id="CljbxxTable" width="100%">
	  <thead>
	     	<th name="l_cldjxh">登记编号</th>
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_cllx">车辆类型</th>
	     	<th name="l_clpp">车辆品牌</th>
	     	<th name="l_cph">车牌号</th>
	     	<th name="l_czcyzj">车主证件类型</th>
	     	<th name="l_czzjhm">证件号码</th>
	     	<th name="l_lrsj">录入时间</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>