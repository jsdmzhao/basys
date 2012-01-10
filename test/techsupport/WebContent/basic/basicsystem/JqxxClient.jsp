<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<script language="javascript" type="text/javascript"
	src="javascript/dictDropDown.js"> </script>
	<%
	User user = (User) session.getAttribute(Constants.userKey);
%>
<script type="text/javascript">
 $(document).ready(function(){

	pageUrl="basicsystem/querylistClient_bjxxb.action";
	divnid="BjxxbData";
	tableid="BjxxbTable";
	addUrl="basicsystem/insert_bjxxb.action";
	addHtml="basic/basicsystem/BjxxbAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bjxxb.action";
	delid="d_bjgzid";
	modHtml="basic/basicsystem/XbjModify.jsp";
	modUrl="basicsystem/modify_bjxxb.action";
	modWidth="800";
	detailHtml="basic/basicsystem/BjxxbDetail.jsp";
	detailid="bjxxb_detail";
	detailUrl="basicsystem/query_bjxxb.action";
	detailWidth="300";
	loadPage("BjxxbData");
	
	
	$("#p_sfyxbjdm").selectBox({code:"dm_bez"}); // 警情是否有效选择框

	$("#p_jqztdm").selectBox({code:"dm_jqzt"}); // 警情状态选择框

	
	setPageList(1);
	//reJqxx(reflashtime);  不定时刷新页面

	
	// 添加日期属性

	$("#p_bjsj1").datepicker(true);
	$("#p_bjsj2").datepicker(true);
	
	// 添加只读属性

	$("#p_bjsj1").attr("readonly","true");
	$("#p_bjsj2").attr("readonly","true");
	daggleDiv("bjxxb_detail");
 });
  
 /////按规定时间刷新页面

 function reJqxx(){
   setPageList(1); 
   testtime = setTimeout(function(){reJqxx();}, reflashtime);
 }

function setPageList(pageno,url){
	//if(url!='#')
	//if (manVerify()){
	    //rows = Math.ceil((pageHeight-200-25-23)/20);
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 456,
										pageNumber: pageno,
										ingridPageWidth: 1020,
										
										onRowSelect: null,
										onTdSelect: function(tr){
										},
										//ingridPageRows:rows,
			                            ingridPageParams: sXML,
										isPlayResultNull: false,
										changeHref:function(table){
										 ////如果存在新报警 开启报警音乐

										 /**
										 if($(table).find("tr").length>0){
										   playmusic();
										 }else{
										   closemusic();
										 }**/
										  
										},
										colWidths: ["10%","15%","15%","15%","15%","15%","15%"]									
									});	
					
		//}
		if($("#bjxxb_detail").css("display")=="block"){
		    return "Y";// 显示
		}else{
		    return "N";//  "none"(不显示)
		}
}

function setPageLista(){
        if($("#bjxxb_detail").css("display")=="block"){
		    return "Y";// 显示
		}else{
		    return "N";//  "none"(不显示)
		}
}
   ////报警详细信息
   function setdeailxx(id){
        $("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("input[name='lx"+id+"']").val()); //保存本记录的报警类型
        dataid=id;
        $("#m_bjxxid").attr("value",dataid);
        setWidth("bjxxb_detail","900");
	    //setUrl("lsxx_detail","business/Lgyzagl/Lsxxdb.jsp");            /////打开新界面

	    //detailUrl="basicsystem/query_bkry.action"; ///查询函数
	    setUrl("bjxxb_detail","basic/basicsystem/BjxxDetailClient.jsp"); 
	    sFlag="false";
   }
   
   ////派警
   function setPaiJing(id){
    
    $("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("input[name='lx"+id+"']").val()); //保存本记录的报警类型
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id
	
	sFlag="false";
	setWidth("bjxxb_detail","900");
	$("#bjxxb_detail").empty();
	$("#bjxxb_detail").load("basic/basicsystem/BjxxXbj.jsp");
	$("#bjxxb_detail").show("slow")
   }
   
   
   
   function getObject(obj){
	sFlag="false";
	//alert($(obj).attr("id")+"="+$(obj).text());
	if($(obj).text()=="派警"){
		xbj($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
	if($(obj).text()=="回复"){
		var id = $(obj).attr("id").substr(1,$(obj).attr("id").length-1);
		if($("#"+id).find("td").eq(2).text()=="<%=user.getDepartment().getDepartname()%>"){
			cjhf(id);
		}else{
			return false;
		}
	}
	if($(obj).text()=="修改回复"){
		cjhf($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
	if($(obj).text()=="无效报警"){
		wxbj($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
}
    ////新报警

    function xbj(id){
		$("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("input[name='lx"+id+"']").val()); //保存本记录的报警类型
		$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id
	
		sFlag="false";
		setWidth(detailid,modWidth);
	
		$("#bjxxb_detail").empty();
		$("#bjxxb_detail").load("basic/basicsystem/BjxxXbj.jsp");
		$("#bjxxb_detail").show("slow"); 
	
		//alert($("#current_recordBjlx").attr("value"));
		//alert($("#current_bjxxid").attr("value"));
		//alert($("#m_bjxxid").attr("value"));
   }
   
   ////无效报警
   function wxbj(id){
	$("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("input[name='lx"+id+"']").val()); //保存本记录的报警类型
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,"900");

	$("#bjxxb_detail").empty();
	$("#bjxxb_detail").load("basic/basicsystem/BjxxWxbjDetail.jsp");
	$("#bjxxb_detail").show("slow"); 
   }
   
   ///处警回复
   function cjhf(id){
	$("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("input[name='lx"+id+"']").val()); //保存本记录的报警类型
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#bjxxb_detail").empty();
	$("#bjxxb_detail").load("basic/basicsystem/BjxxCjhf.jsp");
	$("#bjxxb_detail").show("slow"); 
   }
</script>


<html>
	<body>
	<input type="hidden" id="current_recordBjlx" value="">
	<%-- 当前选择的记录的报警类型，用来给子div用 --%>
	<input type="hidden" id="current_bjxxid" value="">
	<%-- 当前选择的记录的报警信息ID，用来给子div用 --%>
	<input type="hidden" id="m_bjxxid" value="">
	<%-- 当前选择的记录的报警信息ID，用来给子div用 --%>
<table width="1020" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">警情信息</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
                        	<td width="8%" class="pagedistd">
								报警时间							</td>
							<td width="17%"  class="pagetd">
								<input type="text" class="inputstyle"  id="p_bjsj1" value="">							</td>
							<td width="8%" class="pagedistd">
								至							</td>
							<td width="16%"  class="pagetd">
								<input type="text" class="inputstyle"  id="p_bjsj2" value="">							</td>
							<td width="5%"  class="pagedistd">警情状态 </td>
							<td width="21%"  class="pagetd">
								<%-- <input type="hidden" id="p_jqzt" value=""> --%>
								<select type="select" id="p_jqztdm" value="">
									<option></option>
								</select></td>
							<td  class="pagedistd">
								警情是否有效							</td>
							<td  class="pagetd">
								<%-- <input type="hidden" id="p_sfyxbj" value=""> --%>
								<select type="select" id="p_sfyxbjdm">
									<option></option>
								</select></td>
						</tr>
						<tr>
							<td colspan="7" class="pagedistd">&nbsp;</td>
							<td  class="pagetd"><table width="60" border="0" align="right" cellpadding="2"
									cellspacing="0">
                              <tr>
                                <td width="25%" ><a href="#" class="searchbutton" id="querys"
												onClick="setPageList(1);">查询</a> </td>
                              </tr>
                            </table></td>
						</tr>
					</table>
			  </td>
			</tr>
	</table>
				<div id="bjxxb_detail" src="#" class="page-layout" style="top: 40px; left: 160px;"></div>

				<div id="BjxxbData" style="width: 100%;">
				  <table id="BjxxbTable" width="100%">
                    <thead>
                      <tr>
                        <th name="l_xm"> 姓名 </th>
                        <th name="l_ssqymc"> 所属企业 </th>
                        <th name="l_gxdwmc"> 治安管辖机构 </th>
                        <th name="l_bjsj"> 报警时间 </th>
                        <th name="l_sfyxbj"> 警情是否有效 </th>
                        <th name="l_bjsj">警情状态</th>
                        <th name=""> 操作 </th>
                      </tr>
                    </thead>
                  </table>
			    </div>
			    
			    </td>
		  </tr>
		</table>		
		<div id="BjxxbData" style="width: 100%;">
		  <!--  
		<input type="button"  value="stop" onclick="closemusic();"/>
		<input type="button"  value="play" onclick="playmusic();"/>
		-->
</div>
</body>
</html>