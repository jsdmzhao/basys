<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var gnRyHtml,gwRyHtml;
$(document).ready(function() {
	gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp";
	gwRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp";
	
	pageUrl="icksystem/querylistZkxx_icksl.action";
	divnid="tabledata";
	tableid="table1";
	modWidth="400";
	detailWidth="800";
	detailid="zkxxlb_detail";
	loadPage("tabledata");
		$("#p_slsjf").attr("readonly","true");
		$("#p_slsjf").datepicker();
		$("#p_slsjt").attr("readonly","true");
		$("#p_slsjt").datepicker();
		
  	$("#p_xbdm").selectBox({code:"dm_xb"});
 	$("#p_cylbdm").selectBox({code:"dm_cyrylb"});
	$("#p_cyzjdm").selectBox({code:"dm_rycyzj"});
	$("#p_zkztbs").selectBox({code:"dm_zkzt"});
	//$("#p_cjdbm").selectBox({url:"sysadmin/querySelDepart_department.action"});
	listOfCjd();
	daggleDiv("zkxxlb_detail");
	daggleDiv("cyryxx_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										ingridPageWidth: pageWidth,
										url: url,	
										sorting:true,
										noSortColIndex:[9],
										height: pageHeight-309,
										pageNumber: pageno,
										onRowSelect: null,
										colClasses: ['grid-col-style2','grid-col-style2','grid-col-style2','grid-col-style2'],
										colIndex: [0,1,2,3],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
													    if(tdnum==1 || tdnum==0)
															setIckDetail(tr);
														else
															setRyDetail(tr);
													}
											});
										},
										changeHref:function(table){
											table.find("tr").each(function(){
												var trId = $(this).attr("id");
												var ryid = $(this).find("input[name='ryid"+trId+"']").val();
	
												//删除设置
												var zkztbs = $(this).find("input[name='zkzt"+trId+"']").val();
												var updTd = $(this).find("td:last");
												if(zkztbs=="4"){
													var cyHref = "<a class='fontbutton' href='#' onClick='ickxxCy("+trId+","+ryid+");'>重印</a>";
													updTd.append(cyHref);
												}else if(zkztbs=="5" || zkztbs=="25"){
													var cyrybh = $(this).find("td").eq(3).text();
													var cyHref = "<a class='fontbutton' href='#' onClick='ickxxCy("+trId+","+ryid+");'>重印</a>&nbsp;&nbsp;&nbsp;";
													var cxHref = "<a class='fontbutton' href='#' onClick='ickxxCx("+trId+","+ryid+");'>重写</a>&nbsp;&nbsp;&nbsp;";
													var bxHref = "<a class='fontbutton' href='#' onClick='ickxxBx(\""+cyrybh+"\");'>补写</a>";
													updTd.append(cyHref).append(cxHref).append(bxHref);
												}
											});
										},
										colWidths: ["10%","15.5%","5%","18%","11.5%","4%","11%","6%","8%","9%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("p_xm","String",1,30,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_pch","String",1,30,null,0,"批次号"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,30,null,0,"证件号码"))
			return false;
		if (!checkControlValue("p_slsjf","Date",null,null,null,0,"受理起始时间"))
			return false;
		if (!checkControlValue("p_slsjt","Date",null,null,null,0,"受理结束时间"))
			return false;
		return true;
	}
	
$("#p_minzu").click(function(){	
	getDict_item("p_minzu","p_mzdm","dm_mz");
});
 
//是否同音设置
$("#p_sfty").click(function(){
	if($(this).attr("checked"))
		$(this).val(1);
	else
		$(this).val(0);
});

//人员详细查询
function setRyDetail(obj){
	sFlag="false";
	var trid = $(obj).attr("id");
	dataid=$(obj).find("input[name='ryid"+trid+"']").val();
	setWidth("cyryxx_detail",detailWidth);
	var rylbInput = $(obj).find("input[name='"+trid+"']");
	var rylbValue = rylbInput.val();
	$("#f_rylbbm").val(rylbValue);
	bindDocument("cyryxx_detail");
	if(rylbValue == 0){
		if($("#p_hylbdm").val() =="J"){
			detailUrl="publicsystem/query_qyryxx.action";
			setUrl("cyryxx_detail",gnRyHtml);
		}else{
			setUrl("cyryxx_detail","basic/publicsystem/QyryxxDetail-gzth.jsp");
		}
	}else{
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		setUrl("cyryxx_detail",gwRyHtml);
	}
}

//IC卡重印
function ickxxCy(slid,ryid){
	modUrl="icksystem/modifyCy_icksl.action";
	dataid=slid;
	delid=ryid;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/icksystem/IckcyDetail.jsp");
	bindDocument("zkxxlb_detail");
}

//IC卡重写
function ickxxCx(slid,ryid){
	modUrl="icksystem/modifyCx_icksl.action";
	dataid=slid;
	delid=ryid;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/icksystem/IckcxDetail.jsp");
	bindDocument("zkxxlb_detail");
}

//IC卡补写
function ickxxBx(cyrybh){
	dataid=cyrybh;
	sFlag="false";
	setWidth(detailid,"700");
	setUrl(detailid,"basic/icksystem/DxrMan-bx.jsp");
	bindDocument("zkxxlb_detail");

}

// 行业类别	
$("#p_hylbdm").selectBoxhylb();

//IC卡详细查询
function setIckDetail(obj){
	dataid=$(obj).attr("id");
	detailUrl="icksystem/queryZh_icksl.action";
	setWidth(detailid,810);
	setUrl(detailid,"basic/icksystem/IckzhcxDetail.jsp");
	bindDocument("zkxxlb_detail");
}
//查询采集点列表方法	
function listOfCjd(){
	createXML("s_");
	if(!window.XMLHttpRequest){ //IE6
		selectOptionsAdd({dataxml:sXML},"");
	}else{
		if(window.ActiveXObject){//IE7
      	 	$("#p_cjdbm").selectBox({url:"sysadmin/querySelDepart_department.action"});
		}
	}
}
function selectOptionsAdd(selData,selectCon){
	$.ajax({
		  type: "POST",
		  url: "sysadmin/querySelDepart_department.action",
		  async: true,
		  data: selData,
		  dataType:"json",
		  //timeout:1000,
		  success: function(result){
			 
			var itemLength = result.ldata.length;
			for(var i=0;i<itemLength;i++){
				$("#p_cjdbm").get(0).options.add(new Option(result.ldata[i].display_name,result.ldata[i].fact_value));	
			}
			$("#p_cjdbm").selectBox({state:"1"});
		}
	});
}
$('#dqcheck').click(function(){
	if($(this).attr('checked')==true){
		$('#p_dqzt').val('');
	}else{
		$('#p_dqzt').val('1');
	}
});
</script>
<body>
	<input type="hidden" id="p_dqzt" value='1'><!-- 当前状态 选中为空 -->
	<input type="hidden" id="s_isCjd" value="1" />
	<input type="hidden" id="d_cjdtjrbid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">制卡信息列表查询</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				    <td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><select  id="p_hylbdm" ></select></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="15%" class="pagetd"><input type="text" class="inputstyle" id="p_xm" /></td>
			        <td width="10%" class="pagetd"><input  type="checkbox" id="p_sfty" value="0" />是否同音</td>
					<td width="10%" class="pagedistd">从业人员编码</td>
					<td width="21%" class="pagetd"><input type="text" class="inputstyle"  id="p_cyrybh" /></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">性别</td>
					<td width="21%" class="pagetd">
				    <select name="select"  id="p_xbdm">
				  	<option></option>
		          </select></td>
					<td width="10%" class="pagedistd">民族</td>
					<td width="25%" colspan="2" class="pagetd"><input type="text" id="p_minzu" class="inputstyle" readonly /><input type="hidden" id="p_mzdm" /></td>
					<td width="10%" class="pagedistd">从业类别</td>
					<td width="23%" class="pagetd">
				  	<select id="p_cylbdm">
				  	<option></option>
				  	</select></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">受理起始时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle1"  id="p_slsjf" />至
					<input type="text" class="inputstyle1"  id="p_slsjt" /></td>
					<td    width="10%" class="pagedistd">受理状态</td>
					<td width="15%"  class="pagetd"><select id="p_zkztbs"><option></option></select></td>
			        <td width="10%" class="pagetd"><input type="checkbox" id='dqcheck'/>当前状态</td>
					<td width="10%" class="pagedistd">批次号</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_pch" /></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">证件类型</td>
					<td width="23%" class="pagetd">
       					<select id="p_cyzjdm"><option></option></select>
       				</td>
					<td width="10%" class="pagedistd">证件号码</td>
					<td width="0%" colspan="2"  class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" /></td>
				    <td width="10%" class="pagedistd">受理点</td>
				    <td width="23%" class="pagetd"><input type="hidden" class="inputstyle" id="p_cjdmc" readonly="readonly"/>
				    <select id="p_cjdbm">
				    <option></option>
				    </select>
				    </td>
				</tr>
				<tr>
					<td colspan="7">
						<table width="64" border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="53%" height="28px"><a href="#"  class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                      </tr>
                    </table>
					</td>
				</tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="zkxxlb_detail"  class="page-layout" src="#"
		style="top:20px; left:160px; width:500px;">
</div>	
<div id="cyryxx_detail"  class="page-layout" src="#"
		style="display:none;top:20px; left:160px; width:500px;">
</div>	
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_cjdtjrq">受理号</th>
	     	<th name="l_ssdsbm">批次号</th>
	     	<th name="l_ssdsmc">姓名</th>
	     	<th name="l_cjdbm">从业人员编号</th>
	     	<th name="l_cjdmc">证件号码</th>
	     	<th name="l_lrcss" nowrap>性别</th>
	     	<th name="l_lrcyrys">受理时间</th>
	     	<th name="l_yslicks">受理点</th>
	     	<th name="l_yjss">状态</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>