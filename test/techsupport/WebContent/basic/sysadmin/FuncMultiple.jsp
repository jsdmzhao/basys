<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	$("#sys_rolelist").height(pageHeight*0.248);
		createXML("q_");
		$.ajax({
			  type: "POST",
			  url: "sysadmin/listRoleFunc_role_func.action",
			  data: {dataxml:sXML},
			  dataType:"json",
			  success: function(result){
			  	if(result.lfunction!=null)
					for(var i=0;i<result.lfunction.length;i++){
						var objOption = "<option value='"+result.lfunction[i].funccode+"' title='"+
							result.lfunction[i].functype+"'>"+result.lfunction[i].funcname+"</option>";
						$("#sys_rolelist").append($(objOption));
					}
					$("#sys_rolelist").find("option").each(function(){
						var lstcodebox = $("#roleFunctionTable").find("input[type='checkbox'][name='"+$("#q_systemcode").val()+"']");
						var lstcodeboxLength = lstcodebox.length;
						if(lstcodeboxLength>0){
							for(var i=0;i<lstcodeboxLength;i++){
								var checkboxtr = lstcodebox.eq(i).parent().parent().parent();
								var optionValue = checkboxtr.find("td").eq(0).text();
								if($(this).val()==optionValue){
									$(this).remove();
								}
							}
						}
					});
					
			  }
		});
	
	}); 
	
	function ddd(){
		//alert($("#q_systemcode").val());
	}
</script>
<body>
<div class="queryfont" onclick="ddd();">功能列表</div>
<input type="hidden" id="q_systemcode" value="<%=(String)request.getAttribute("systemcode") %>">
<select id="sys_rolelist" style="width:590" multiple="multiple">
</select>
