<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<head>
<script type="text/javascript">
    var bary_tables = "";
	var bary_dataid = "";
	var bary_rowselect = 0;
    var bary_pageUrl="publicsystem/querylist_baryxx.action";
	var bary_divnid="BaryxxListData";
	var bary_tableid="BaryxxTable";
	var bary_addUrl="publicsystem/insert_baryxx.action";
	var bary_addHtml="basic/publicsystem/BaryxxAdd.jsp";
	var bary_addWidth="700";
	var bary_delUrl="publicsystem/delete_baryxx.action";
	var bary_delid="d_qyid";
	var bary_modHtml="basic/publicsystem/BaryxxModify.jsp";
	var bary_lizhiHtml="basic/publicsystem/BaryxxLz.jsp"
	var bary_modUrl="publicsystem/modify_baryxx.action";
	var bary_modWidth="700";
	var bary_detailHtml="basic/publicsystem/BaryxxDetail.jsp";
	var bary_detailid="baryxx_detail";
	var bary_detailUrl="publicsystem/query_baryxx.action";
	var bary_detailWidth="700";
$(document).ready(function() {
	$("#p_baryRequetType").attr("value",qyjbxx_requestType);
		bary_loadPage(bary_divnid);
		dataid="sPmtid"; //公用变量 目的取得pmtID
		if(qyjbxx_requestType!='add'){ //非添加都请求
			createXML("p_"); //主要获取场所ID和请求动作
			bary_setPageList(1);
		}
		if(qyjbxx_requestType=='detail'){ //详细信息不给添加按钮 ‘操作’隐藏
			document.getElementById('bary_add').style.display='none';
		}
	daggleDiv(bary_detailid);
	
}); 

    function bary_loadPage(divpageid){
		bary_tables=$("#"+divpageid).html();
		$("#"+bary_detailid).hide();
		bary_setPageList(1,'#');
	}
	function bary_setList(pageno,url){
		$("#"+bary_divnid).html(bary_tables);
		if (url==null || url=="undefined"){
			url=bary_pageUrl;
		}
		return url;
	}
	
    function bary_setPageList(pageno,url){
        var tableHeight = 80;
		url=bary_setList(pageno,url);
		var hideCol=[6,7,8,9,10,11,12,13,14,15,16,,17,18,19];
		var colWidth=["15%","15%","15%","15%","15%","15%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","10%"];

		if(qyjbxx_requestType=='detail'){
			tableHeight = 60;
		    hideCol=[6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];
		    colWidth=["17%","17%","17%","15%","17%","17%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%"];
		}
		var bary_mygrid1 = $("#"+bary_tableid).ingrid({
										tableid:"baryxxIngridTable",
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										url: url,	
										height: tableHeight,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										isPlayResultNull: false,
										changeHref:function(table){
											
						                    table.find("tr").each(function(index){
												//var lzrq = $(this).find("td").eq(19).html(); //离职时间	判断 显示（修改 离职） or 空
												var zt = $(this).find("td").eq(13).html();
							                   // if(lzrq!=null&&lzrq!="&nbsp;&nbsp;"){
							                   if(zt==2){
							                    	$(this).append("<td>&nbsp;</td>");
							                    } else {
							                        var baryid = $(this).attr("id");
								                    if(baryid==1){// 新增记录
									                    $(this).append("<td><a class='fontbutton' href='#' onclick='bary_setModifyQuery("+baryid+")'>修改</a>&nbsp;&nbsp;<a class='fontbutton' href='#' onclick='bary_setDelete("+index+")'>删除</a></td>");
									                }else{// db中已存在记录
									                    $(this).append("<td><a class='fontbutton' href='#' onclick='bary_setModifyQuery("+baryid+")'>修改</a>&nbsp;&nbsp;<a class='fontbutton' href='#' onclick='bary_setLizhi("+baryid+")'>离职</a></td>");
									                }
							                    }
						                    });
					                    },
										onRowSelect: function(tr, selected){
											var str = selected ? 'SELECTED' : 'UNSELECTED';
											if (sFlag=="true"){
												if ($(tr).attr('_selected')=="true"){
													bary_setQuery($(tr).attr('rowindex')-1);
												}
											}else{
												sFlag="true";
											}					
											bary_rowselect=$(tr).attr('rowindex')-1;
										},
										hideColIndex:hideCol,
										colWidths: colWidth
									});				
	}	
	function bary_setAddPage(){// 添加初期化
		closeAllDiv();
		setWidthSome(bary_detailid,bary_addWidth);
		setUrl(bary_detailid,bary_addHtml);
		//bindDocument(bary_detailid);
	}
	function bary_setAdd(){ //添加保存
		if (bary_addVerify()){
			var child=new Array(bary_divnid);
			dataid="baryid";
			setParams("a_",child);
			bary_setPageList(1,bary_addUrl);
			$("#"+bary_detailid).hideAndRemove("show");
		}else{
			return bary_addVerify();
		}	
	}
	function bary_setQuery(id){ //查看
		closeAllDiv();
		bary_dataid=id;
		setWidthSome(bary_detailid,bary_detailWidth);
		setUrl(bary_detailid,bary_detailHtml);
		//bindDocument(bary_detailid);
	}
	function bary_setDetail(){// 详细初期化
		var child=new Array(bary_divnid);
		setParams("q_",child);
		jQuery.post(bary_detailUrl,params,bary_updatediv,"json");
	}
	function bary_setDelete(){ //删除
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
				$("#d_baryid").attr("value",''+bary_rowselect);
				$("#d_qyid").attr("value",'0');
				var child=new Array(bary_divnid);
				setParams("d_",child);
				bary_setPageList(1,bary_delUrl);
			}else{
			   return false;
			}
		});
	}
	function bary_setModifyQuery(id){ //修改初期化
	    sFlag="false";
	    closeAllDiv();
	    bary_dataid=id;
	    setWidthSome(bary_detailid,bary_modWidth);
		setUrl(bary_detailid,bary_modHtml);
	}
	function bary_setLizhi(id){//保安的离职
		sFlag="false";
	    closeAllDiv();
	    bary_dataid=id;
	    setWidthSome(bary_detailid,bary_modWidth);
		setUrl(bary_detailid,bary_lizhiHtml);
	}
	function bary_modify(){ //修改保存
		if (bary_modifyVerify()){
		    $("#b_baryid").attr("value",''+bary_rowselect);
			var child=new Array(bary_divnid);
			dataid="baryid";
			setParams("b_",child);
			bary_setPageList(1,bary_modUrl);
			$("#"+bary_detailid).hideAndRemove("show");
		}else{
			return false;
		}	
	}
	function bary_modifyLizhi(){ //离职 修改保存
		if($("#b_zt").val()==2){
			if (bary_modifyVerify()){
			    $("#b_baryid").attr("value",''+bary_rowselect);
				var child=new Array(bary_divnid);
				dataid="baryid";
				setParams("b_",child);
				bary_setPageList(1,bary_modUrl);
				$("#"+bary_detailid).hideAndRemove("show");
			}else{
				return false;
			}
		}else{
			$("#baryxx_detail").hideAndRemove("show");
		}	
	}
	
	//用于判断页面新加项，身份号码是否存在
	function bary_valCyryZjhmFront(zjhm,zjhmfd){
		var flag = true;
		$("#baryxxIngridTable").find("tbody").find("tr").each(function(){
			if($(this).find("td").eq(1).html()==zjhm){
				if(zjhm!=zjhmfd){
					jAlert('此保安身份号码已存在!','验证信息',null,null);
					flag = false;
				}
			}
		})
		$("#bwryxxIngridTable").find("tbody").find("tr").each(function(){
			if($(this).find("td").eq(1).html()==zjhm){
				jAlert('此保卫身份号码已存在!','验证信息',null,null);
				flag = false;
			}
		})
		return flag;
	}
</script>
</head>
<body>
	
<input type="hidden" id="d_baryid" value="">
<input type="hidden" id="p_baryRequetType" value="">
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;保安人员信息</td>
    <td align="right" id="bary_add">
    <table width="75" border="0" align="right" cellpadding="0" cellspacing="0">
		<tr>
			<td width="60"><a href="#" class="addbutton"  onclick='bary_setAddPage();'>添加</a></td>
			<td>&nbsp;</td>
		</tr>
	</table>
    </td>
  </tr>
</table>
<div id="baryxx_detail"  class="page-layout" src="#"
		style="top:180px; left:100px; width:500px;">
</div>

<div id="BaryxxListData" style="width:100%;">
	<table id="BaryxxTable" width="100%">
	  <thead>
	    <tr>      
	     	<th name="l_xm">保安人员姓名</th>
	     	<th name="l_gmsfhm">保安人员身份证号</th>
	     	<th name="l_hjdxzqh">户籍地省市县</th>
	     	<th name="l_sgrq">上岗日期</th>
	     	<th name="l_balx">保安类型</th>
	     	<th name="l_fzjg">发证机构</th>
		    <th name="l_xb">性别</th>
		    <th name="l_xbdm">性别代码</th>
		    <th name="l_csrq">出生日期</th>
		    <th name="l_hjdxzqhdm">户籍地省市县代码</th>
		    <th name="l_hjdxz">户籍地详址</th>
		    <th name="l_balxbm">保安类型代码</th>
		    <th name="l_bz">备注</th>
		    <th name="l_zt">状态</th>
		    <th name="l_lrr">填报人</th>
		    <th name="l_lrsj">填报时间</th>
		    <th name="l_lzyy">离职原因</th>
		    <th name="l_hylb">行业类别</th>
	    	<th name="l_qymc">企业名称</th> 
	    	<th name="l_lzrq">离职日期</th>
	    	<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>
</html>