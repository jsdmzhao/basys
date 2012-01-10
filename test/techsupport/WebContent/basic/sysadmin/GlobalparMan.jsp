<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="sysadmin/querylist_globalpar.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="sysadmin/insert_globalpar.action";
	addHtml="basic/sysadmin/GlobalparAdd.jsp";
	addWidth="260";
	delUrl="sysadmin/delete_globalpar.action";
	delid="d_globalparcode";
	modHtml="basic/sysadmin/GlobalparModify.jsp";
	modUrl="sysadmin/modify_globalpar.action";
	modWidth="260";
	detailHtml="basic/sysadmin/GlobalparDetail.jsp";
	detailid="globalpar_detail";
	detailUrl="sysadmin/query_globalpar.action";
	detailWidth="300";
	loadPage("tabledata");
	setPageList(1);
	
	daggleDiv("globalpar_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										url: url,	
										height: pageHeight-203,
										pageNumber: pageno,
										colWidths: ["25%","25%","25%","25%"],
										onRowSelect:null,
										onColFocus:function(tr){
											$(tr).find("td").click(function(){
												var numIn = $(tr).find("td").index(this);
												if(numIn>0&&numIn<$(tr).find("td").length-1){
													var hidId = $("#d_globalparcode").attr("id").substr(2);
													htmVal = $(this).text();
													if(htmVal!=null&&htmVal!=''){
														var txtId = $("#tabledata").find("tr").eq(0).find("th").eq(numIn).attr("name").substr(2);
														var inp = "<input class='inputstyle' type='text' id='m_"+txtId+"' value='"+$(this).text()+"' />";
														inp += "<input type='hidden' id='m_"+hidId+"' value='"+$(tr).attr("id")+"' />";
														$(this).html($(inp));
														$(this).find("input").get(0).select();
													}else{
														htmVal = $(this).find("input").eq(0).val();
													}
												
													$(this).find("input").eq(0).blur(function(){
														if(htmVal==$(this).val()){
															$(this).parent().html(htmVal);
															//setParams("m_");
															//jQuery.post(modUrl,params,updateback,"json"); 
														}else{
															setParams("m_");
															jQuery.post(modUrl,params,updateback,"json"); 
														}	
													});
												}
											});
										}																		
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_globalparcode","String",1,50,null,0,"参数编码"))
			return false;
		if (!checkControlValue("p_globalparname","String",1,50,null,0,"参数名称"))
			return false;
		return true;
	}
	
</script>

</head>
<body>
	
	<input type="hidden" id="d_globalparcode" value="">	
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
      <tr>
        <td class="queryfont">全局参数管理</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <td width="10%" class="pagedistd">参数编码</td>
              <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_globalparcode" value=""></td>
              <td width="10%" class="pagedistd">参数名称</td>
              <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_globalparname" value=""></td>
              <td ><table width="120" border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="55%" ><a href="#" class="searchbutton" id="querys2" onClick="setPageList(1);">查询</a></td>
                  <td width="45%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
                </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
  </tr>
</table>
      <div id="globalpar_detail"  class="page-layout" src="#" style="top:180px; left:160px;"> </div>
              <div id="tabledata" style="width:100%;">
                <table id="table1" width="100%">
                  <thead>
                    <tr>
                      <th name="l_globalparcode">参数编码</th>
                      <th name="l_globalparname">参数名称</th>
                      <th name="l_globalparvalue">参数值</th>
                      <th name="">操作</th>
	    </tr>
	  </thead>
                </table>
              </div>
</body>
</html>