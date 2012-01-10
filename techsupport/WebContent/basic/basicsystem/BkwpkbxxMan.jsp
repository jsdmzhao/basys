<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
<%
String cmdID = (String)request.getParameter("cmdID");
%>
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bkwpkbxx.action";
	divnid="BkwpkbxxData";
	tableid="BkwpkbxxTable";
	addUrl="basicsystem/insert_bkwpkbxx.action";
	addHtml="basic/basicsystem/BkwpkbxxAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_bkwpkbxx.action";
	delid="d_bkwpjbxxid";
	modHtml="basic/basicsystem/BkwpkbxxModify.jsp";
	modUrl="basicsystem/modify_bkwpkbxx.action";
	modWidth="800";
	detailHtml="basic/basicsystem/BkwpkbxxDetail.jsp";
	detailid="bkwpkbxx_detail";
	detailUrl="basicsystem/query_bkwpkbxx.action";
	detailWidth="800";
	ckUrl="basicsystem/ckUpdate_bkwpkbxx.action";
	dataTableHeightBase = pageHeight-260;
	dataTableHeight = dataTableHeightBase;
	loadPage(divnid);
	
	$("#p_bkczsjks").attr("readonly","true");
	$("#p_bkczsjks").datepicker(true);
	$("#p_bkczsjjs").attr("readonly","true");
	$("#p_bkczsjjs").datepicker(true);
	$("#p_bkfwbm").selectBox({code:"dm_bkfw"});
	$("#p_bkwplxdm").selectBox({code:"dm_ddwpzl",query:"0"});
	$("#p_clppdm").selectBox({code:"dm_clpp"});
	$("#p_ppdm").selectBox({code:"dm_sjpp"});
	<%if (!"4".equals(cmdID)){%>
	$("#p_shjg").selectBox({code:"dm_bez"});
	<%}%>
	<%if (!"2".equals(cmdID)){%>
	$("#p_ckbs").selectBox({code:"dm_bez"});
	<%}%>
	$("#cl1").hide();
	$("#cl2").hide();
	$("#sj").hide();
	// 行业类别	
    $("#p_hylbdm").selectBoxhylb();
	daggleDiv("bkwpkbxx_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										ingridPageParams:sXML,
										height: dataTableHeight,
										pageNumber: pageno,
										<%// 查询（不带操作栏）
										if ("3".equals(cmdID)) {%>
										colWidths: ["25%","10%","25%","10%","15%","15%"]	
										<%}else{// 非查询（带操作栏）%>
										colWidths: ["20%","10%","20%","10%","15%","15%","10%"]
										<%}%>					
									});				
		}
}	
	function manVerify(){
        if (!checkControlValue("p_bkwpmc","String",1,30,null,0,"物品名称"))
			return false;
		if (!checkControlValue("p_bkwplxdm","String",1,20,null,0,"物品类型"))
			return false;
		if (!checkControlValue("p_bkfwbm","String",1,300,null,0,"布控范围"))
			return false;
		if($("#p_bkwplxdm").val()== "1"){
		    $("#p_pp").val($("#p_ppdm").attr("title"));
            if (!checkControlValue("p_sjch","String",1,30,null,0,"手机串号"))
			    return false;
		    if (!checkControlValue("p_pp","String",1,100,null,0,"手机品牌"))
			    return false;
		    if (!checkControlValue("p_xh","String",1,100,null,0,"手机型号"))
			    return false;
		}
		if($("#p_bkwplxdm").val()== "2"){
		    $("#p_clpp").val($("#p_clppdm").attr("title"));
		    if (!checkControlValue("p_clpp","String",1,64,null,0,"车辆品牌"))
			    return false;
		    if (!checkControlValue("p_clxh","String",1,64,null,0,"车辆型号"))
			    return false;
            if (!checkControlValue("p_hphm","String",1,32,null,0,"车辆号牌"))
			    return false;
		    if (!checkControlValue("p_fdjh","String",1,60,null,0,"发动机号"))
			    return false;
		    if (!checkControlValue("p_cjh","String",1,50,null,0,"车架号"))
			    return false;
		}
		if($("#p_checkbox").attr("checked")){
			$("#p_tyCheck").val("1");
		}else{
			$("#p_tyCheck").val("0");
		}
		return true;
	}
	// setWPLXForMan根据选择的物品类型设定页面表示项(管理页面用)
	function setWPLXForMan(){
	    if($("#p_bkwplxdm").val()== "2"){
	        $("#cl1").show();
	        $("#cl2").show();
	        $("#sj").hide();
	        var cl1Height = $("#cl1").height();
	        var cl2Height = $("#cl2").height();
	        dataTableHeight = dataTableHeightBase - cl1Height - cl2Height;
	    } else if($("#p_bkwplxdm").val()== "1"){
	        $("#cl1").hide();
	        $("#cl2").hide();
	        $("#sj").show();
	        var sjHeight = $("#sj").height();
	        dataTableHeight = dataTableHeightBase - sjHeight;
	    } else{
	        $("#cl1").hide();
	        $("#cl2").hide();
	        $("#sj").hide();
	        dataTableHeight = dataTableHeightBase;
	    }
	    setPageList(1,"#");
	}
	// setWPLXForDetail根据选择的物品类型设定页面表示项(详细页面用)
	function setWPLXForDetail(id){
	    if($("#"+id+"_bkwplxdm").val()== "2"){
	        $("#clDetail").show();
	        $("#sjDetail").hide();
	        $("#"+id+"_clppdm").selectBox({code:"dm_clpp"});
		    $("#"+id+"_cllxdm").selectBox({code:"dm_cllx"});
	    } else if($("#"+id+"_bkwplxdm").val()== "1"){
	        $("#clDetail").hide();
	        $("#sjDetail").show();
	        $("#"+id+"_ppdm").selectBox({code:"dm_sjpp"});
	    } else{
	        $("#clDetail").hide();
	        $("#sjDetail").hide();
	    }
	}
	// ckQuery 实现数据的详细信息查询(撤控处理用)
	function ckQuery(id) {
	    $("#"+detailid).empty();
	    dataid=id;
	    sFlag="false";
	    setWidth(detailid,detailWidth);
	    setUrl(detailid,detailHtml);
	    bindDocument(detailid);
	    $("#cmdType").attr("value","ck");
	}
	// shQuery 实现数据的详细信息查询(审核处理用)
	function shQuery(id) {
	    $("#"+detailid).empty();
	    dataid=id;
	    sFlag="false";
	    setWidth(detailid,detailWidth);
	    setUrl(detailid,detailHtml);
	    bindDocument(detailid);
	    $("#cmdType").attr("value","sh");
	}
	function gaojichaxun_bkwp(){
		gaojichaxun("154",detailid);
	}
</script>
<html>
<body>
    <input type="hidden" id="p_pp">
    <input type="hidden" id="p_clpp">
    <input type="hidden" id="p_tyCheck">
	<input type="hidden" id="p_cmdID" value="<%=cmdID%>">
	<input type="hidden" id="cmdType" value="">
	<input type="hidden" id="d_bkwpjbxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="10%" class="pagedistd">物品名称</td>
			<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkwpmc" value="">
			<label><input name="checkbox" type="checkbox" id="p_checkbox" style="width:20px">同音</label>			</td>
			<td width="10%" class="pagedistd">布控范围</td>
			<td class="pagetd">
			    <select type="select" id="p_bkfwbm" value="">
				    <option></option>
				</select>			</td>
			<td width="10%" class="pagedistd">布控操作时间</td>
			<td width="23%" class="pagetd">
			    <input type="text" class="inputstyle1"  id="p_bkczsjks"  value="">
				至
				<input type="text" class="inputstyle1"   id="p_bkczsjjs" value="">			</td>
		</tr>
		<tr>
			<td width="10%" class="pagedistd">物品类型</td>
			<td class="pagetd">
			   <select type="select" id="p_bkwplxdm" value="" onChange="setWPLXForMan();">
				   <option></option>
			   </select>			</td>
			<%// 布控审核
			if ("1".equals(cmdID)|| "3".equals(cmdID)) {%>
			<td width="10%" class="pagedistd">是否通过审核</td>
			<td class="pagetd">
			<select type="select" id="p_shjg" value="">
				   <option></option>
		      </select>			</td>
		    <td width="10%" class="pagedistd">是否已撤控</td>
			<td width="23%" class="pagetd">
			<select type="select" id="p_ckbs" value="">
				   <option></option>
		      </select>			</td>
		    <%}else if ("2".equals(cmdID)) {// 撤控管理%>
			<td width="10%" class="pagedistd">是否通过审核</td>
			<td class="pagetd">
			<select type="select" id="p_shjg" value="">
				   <option></option>
		      </select>			</td>
		    <td width="10%" class="pagedistd">行业类别</td>
			<td width="23%" class="pagetd"><select id="p_hylbdm" ></select></td>
			<%}else if ("4".equals(cmdID)) {// 审核管理%>
			<td width="10%" class="pagedistd">是否已撤控</td>
			<td width="23%" class="pagetd">
			<select type="select" id="p_ckbs" value="">
				   <option></option>
		      </select>			</td>
		    <td width="10%" class="pagedistd">行业类别</td>
			<td width="23%" class="pagetd"><select id="p_hylbdm" ></select></td>
			<%}%>
		</tr>
		<tr id="cl1">
		<td width="10%" class="pagedistd"><font color="blue">车辆品牌</font></td>
			<td class="pagetd">
			<select type="select" id="p_clppdm" value="">
				   <option></option>
			   </select>			</td>
			<td width="10%" class="pagedistd"><font color="blue">车辆型号</font></td>
			<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_clxh" value=""></td>
			<td width="10%" class="pagedistd"><font color="blue">车辆号牌</font></td>
			<td width="23%" class="pagetd"><input type="text"   class="inputstyle" id="p_hphm" value=""></td>
		</tr>
		<tr id="cl2">
			<td width="10%" class="pagedistd"><font color="blue">发动机号</font></td>
			<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_fdjh" value=""></td>
			<td width="10%" class="pagedistd"><font color="blue">车架号</font></td>
			<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_cjh" value=""></td>
			<td width="10%" class="pagedistd">&nbsp;</td>
			<td width="23%" class="pagetd">&nbsp;</td>
		</tr>
		<tr id="sj">
		    <td width="10%" class="pagedistd"><font color="green">手机品牌</font></td>
			<td class="pagetd">
			<select type="select" id="p_ppdm" value="">
				   <option></option>
			   </select>			</td>
			<td width="10%" class="pagedistd"><font color="green">手机型号</font></td>
			<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_xh" value=""></td>
			<td width="10%" class="pagedistd"><font color="green">手机串号</font></td>
			<td width="23%" class="pagetd"><input type="text"   class="inputstyle" id="p_sjch" value=""></td>
		</tr>
        <tr>
        <%if ("1".equals(cmdID) || "3".equals(cmdID)) {%>
		    <td width="10%" class="pagedistd">行业类别</td>
			<td width="23%" class="pagetd"><select id="p_hylbdm" ></select></td>
			 <%}else{%>
			 <td width="10%" class="pagedistd">&nbsp;</td>
			<td width="23%" class="pagetd">&nbsp;</td>
			 <%}%>
			 <td width="10%" class="pagedistd">&nbsp;</td>
			<td width="23%" class="pagetd">&nbsp;</td>
			<td colspan="2" class="pagedistd">
			<table  width="90" border="0" align="right"  cellpadding="2"  cellspacing="0">
              <tr>
                <td width="33%" class="querybutton"><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                <td width="33%" class="addbutton"><a href="#" class="submitlongbutton" onclick='gaojichaxun_bkwp();'>高级查询</a>
                <%if ("1".equals(cmdID)) {%>
                <td width="33%" class="addbutton"><a href="#" class="addbutton" onclick='setAddPage();'>添加</a></td>
                <%}%>
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
<div id="bkwpkbxx_detail" class="page-layout" src="#"
		style="top:5px; left:160px;">
</div>	

<div id="BkwpkbxxData" style="width:100%;">
	<table id="BkwpkbxxTable" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_bkwpmc">物品名称</th>
			<th name="l_bkwplx">物品类型</th>
	     	<th name="l_fwdw">布控单位</th>
			<th name="l_bkfw">布控范围</th>
			<th name="l_bkczsj">布控操作时间</th>
            <th name="l_bkdqsj">布控到期时间</th>
            <%// 查询（不带操作栏）
				if ("3".equals(cmdID)) {%>
			
			<%}else{// 非查询（带操作栏）%>
				<th name="">操作</th>
			<%}%>	
	    </tr>
	  </thead>
	  
	</table>	
</div>

</body>
</html>