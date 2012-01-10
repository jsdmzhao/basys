<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#p_qyid").attr("value",qyjbxx_dataid);
		pageUrl="publicsystem/querylistforga_qyyyrz.action";
		divnid="QyyyrzData";
		tableid="QyyyrzTable";
		addUrl="publicsystem/insert_qyyyrz.action";
		addHtml="basic/publicsystem/QyyyrzAdd.jsp";
		addWidth="720";
		delUrl="publicsystem/delete_qyyyrz.action";
		delid="d_yyrzid";
		modHtml="basic/publicsystem/QyyyrzModify.jsp";
		modUrl="publicsystem/modify_qyyyrz.action";
		modWidth="720";
		detailHtml="basic/publicsystem/QyyyrzDetail.jsp";
		detailid="qyyyrz_detail";
		detailUrl="publicsystem/query_qyyyrz.action";
		detailWidth="380";
		loadPage(divnid);
		daggleDiv(detailid);
		$("#p_riqi").attr("readonly","true").datepicker();
		$("#p_ksyysj").attr("readonly","true").datepicker();
		$("#p_jsyysj").attr("readonly","true").datepicker();
	
		$("#qyyyrz_detail").hide();
		setPageList(1);
	});
	
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			var hideCol=[6];
			var colWidth=["14%","20%","20%","12%","18%","16%","0%"];
			var mygrid1 = $("#"+tableid).ingrid({ 
											url: url,	
											height: pageHeight-209,
	                                       	ingridPageParams:sXML,
	                                       	ingridPageWidth: 760,
											pageNumber: pageno,
											onRowSelect:function(tr, selected){
												var str = selected ? 'SELECTED' : 'UNSELECTED';
												if (sFlag=="true"){
													if ($(tr).attr('_selected')=="true"){
														setQuery($(tr).attr('id'));
													}
												}else{
													sFlag="true";
												}					
											},
											hideColIndex:hideCol,
											colWidths: colWidth								
										});				
			}
	}	
	function manVerify(){
		return true;
	}
	
	function setQuery(id){
		dataid=id;
		setWidth(detailid,detailWidth);
		setUrl(detailid,detailHtml);
		bindDocument(detailid);
	}
</script>

<body>
	<input type="hidden" id="p_qyid">
	<input type="hidden" id="d_yyrzid">
	<input type="hidden" id="p_yyrzid">
	<div id="qyxxClose"></div>
    <table width="100%" cellpadding="0" cellspacing="0" >
      <tr>
        <td align="left" class="title1">营业日志</td>
        <td align="right"><a href="#" id="closeDiv" onclick="$('#qyxxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
      </tr>
	</table>
	<table width="100%" cellspacing="0" >
      <tr>
        <td class="tdbg" colspan="4">
        	<table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <td width="5%" class="pagedistd">营业日期</td>
              <td width="50%" class="pagetd"><input type="text" class="inputstyle"  id="p_ksyysj" value="">   至<input type="text" class="inputstyle"  id="p_jsyysj" value="">
                </td>
            	<td width="5%" class="pagedistd" >治安负责人</td>
				<td width="10%" class="pagetd"><input type="text" class="inputstyle"  id="p_zafzrxm" value=""></td>
              <td width="23%" class="pagetd"><table  border="0" align="right"  cellpadding="2"  cellspacing="0">
                  <tr>
                    <td align="right" width="50%" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                  </tr>
              </table>
             </td>
            </tr>
        </table>
        </td>
      </tr>
	  <tr>
        	<td colspan="2">
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr>
		              <td height="3"></td>
		            </tr>
		         </table>
           		 <div id="qyyyrz_detail" class="page-layout" src="#" style="top:180px; left:160px;"> </div>
		          <div id="QyyyrzData" style="width:100%">
		              <table id="QyyyrzTable" width="100%">
		                <thead>
		                  <tr>
		                    <th name="l_riqi">登记日期</th>
		                    <th name="l_ksyysj">营业开始时间</th>
		                    <th name="l_jsyysj">营业结束时间</th>
		                    <th name="l_csfe"><div id="cs" >场所负责人</div>
		                        <div id="qy" style="display:none">企业负责人</div></th>
		                    <th name="l_sffsaj">治安、刑事或事故</th>
		                    <th name="l_sfglbmjc">管理部门检查</th>
		                    <th name="">操作</th>
		                  </tr>
		                </thead>
		              </table>
		          </div>
         </td>
      </tr>
</table>
</body>