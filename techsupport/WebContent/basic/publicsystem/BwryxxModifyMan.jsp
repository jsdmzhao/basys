<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	var bwry_rowselect = 0;
	var bwry_modWidth="700";
	var	bwry_lizhiHtml="basic/publicsystem/BwryxxLz.jsp"
	var bwry_divnid="BwryxxListData";
	var bwry_detailUrl="publicsystem/query_bwryxx.action";
$(document).ready(function() {
	daggleDiv("bwryxx_detail");
	$("#cx_qyid").val(qyjbxx_dataid);
	$("#baoCunTitle").val($("#BwryxxListData").html());
	setParams("cx_");
	setPageList_bwryxx(1,"publicsystem/querylistByQy_bwryxx.action");
}); 
	
function setPageList_bwryxx(pageno,url){	
	$("#BwryxxListData").html($("#baoCunTitle").val());
	if(url==null){
		url = "publicsystem/querylistBack_bwryxx.action";
	}
	var mygrid1 = $("#BwryxxListTable").ingrid({ 
					tableid:"bwryxxIngridTable",
					url: url,	
					height: 80,
					ingridPageWidth : 998,
                    ingridPageParams:sXML,
					pageNumber: pageno,
					changeHref:function(table){
						table.find("tr").each(function(index){
						var lzrq = $(this).find("td").eq(12).html(); //离职时间	判断 显示（修改 离职） or 空
						  if(lzrq!=null&&lzrq!="&nbsp;&nbsp;"){
								 $(this).append("<td>&nbsp;</td>");
							} else {
							     if($(this).attr("id")==0){
								    $(this).append("<td><a class='fontbutton' href='#' onclick='setModifyQuery_bwryxx("+index+")'>修改</a>&nbsp;&nbsp;<a class='fontbutton' href='#' onclick='setDelete_bwryxx("+index+")'>删除</a></td>");
								}else{
								  	$(this).append("<td><a class='fontbutton' href='#' onclick='setModifyQuery_bwryxx("+index+")'>修改</a>&nbsp;&nbsp;<a class='fontbutton' href='#' onclick='setLizhi_bwry("+index+")'>离职</a></td>");
								}
							}
						});
					},
					sorting:false,
					paging:false,
					onRowSelect:function(tr){
						if(sFlag=="true"){
							if ($(tr).attr('_selected')=="true"){
								setDetailQuery_bwryxx($(tr).attr('rowindex')-1);
							}
						}else{
							sFlag="true";
						}
					},
					isPlayResultNull:false,
					hideColIndex:[5,6,7,8,9,10,11,12,13],
					colWidths: ["16%","14%","20%","32%","10%","0%","0%","0%","0%","0%","0%","0%","0%","0%","8%"]								
				});				
}	

	function setAddPage_bwryxx(){
		setWidthSome("bwryxx_detail","700");
		setUrl("bwryxx_detail","basic/publicsystem/BwryxxAdd.jsp");
	}

	function setModifyQuery_bwryxx(trIndex){
		sFlag="false";
		$("#caozuo_trIndex").val(trIndex);
		setWidthSome("bwryxx_detail","700");
		setUrl("bwryxx_detail","basic/publicsystem/BwryxxModify.jsp");
	}

	function setDelete_bwryxx(trIndex){
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r){
			if(r){
				$("#czlx_sfsccz").val(1);
				$("#bwryxxIngridTable").find("tbody").find("tr:nth("+trIndex+")").remove();
				var child=new Array("BwryxxListData");
				setParams("czlx_",child);
				$("#czlx_sfsccz").val(0);
				setPageList_bwryxx(1);
			}
		});
	}
	
	function setDetailQuery_bwryxx(trIndex){
		setWidthSome("bwryxx_detail","700");
		$("#bwryxx_detail").empty().load("basic/publicsystem/BwryxxDetail.jsp",function(){
			updatediv_bwryxx($("#bwryxxIngridTable").find("tbody").find("tr:nth("+trIndex+")"));
		}).show("slow");
		upAllPage("bwryxx_detail");
	}
	
	function setLizhi_bwry(trIndex){//保卫人员的离职
		sFlag="false";
		$("#caozuo_trIndex").val(trIndex);
		setWidthSome("bwryxx_detail","700");
		setUrl("bwryxx_detail","basic/publicsystem/BwryxxLz.jsp");
	}
	
		//用于判断页面新加项，身份号码是否存在
	function bwry_valCyryZjhmFront(zjhm,zjhmfd){
		var flag = true;
		$("#baryxxIngridTable").find("tbody").find("tr").each(function(){
			if($(this).find("td").eq(1).html()==zjhm){
				jAlert('此保安身份号码已存在!','验证信息',null,null);
				flag = false;
			}
		})
		$("#bwryxxIngridTable").find("tbody").find("tr").each(function(){
			if($(this).find("td").eq(1).html()==zjhm){
				if(zjhm!=zjhmfd){
					jAlert('此保卫身份号码已存在!','验证信息',null,null);
					flag = false;
				}
			}
		})
		
		return flag;
	}
</script>
	<input type="hidden" id="cx_qyid" />
	<input type="hidden" id="baoCunTitle" />
	<input type="hidden" id="caozuo_trIndex" />
	<input type="hidden" id="czlx_sfsccz" value="0" />
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
    		<tr>
    		<td style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;保卫人员信息</td>
    		  <td>
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0" width="75">
    		    	<tr>
    		    	  <td width="60"><a href="#" class="addbutton" onclick='setAddPage_bwryxx()'>添加</a></td>
    		    		<td>&nbsp;</td>
    		    	</tr>
    		  	</table>
    		  </td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>
<div id="bwryxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;display:none">
</div>	

<div id="BwryxxListData" style="width:100%;">
	<table id="BwryxxListTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">保卫人员姓名</th>
	     	<th name="l_gmsfhm">保卫人员身份证号</th>
	     	<th name="l_hjdxzqh">户籍地省市县</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_sgrq">上岗日期</th>
	     	
	     	<th name="l_hjdxzqhdm">户籍地行政区划代码</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrsj">录入时间</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_zt">人员状态</th>
	     	<th name="l_lzrq">离职日期</th>
	     	<th name="l_lzyy">离职原因</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>