<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<% 
   String pch = request.getParameter("pch");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<xml id=bb></xml> 
<script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/jquery.js"></script>
<script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"/>/javascript/htmlConfig.js" charset="utf-8"></script>	
<script type="text/javascript">
var yuLanPageno = 1;
var yuLanRows = 16;
var shifoudayin;
$(document).ready(function() {
	var pch = "<%=request.getParameter("pch") %>";
	var kssxh = "<%=request.getParameter("kssxh") %>";
	var bcyssl = "<%=request.getParameter("bcyssl") %>";
	var ysym = "<%=request.getParameter("ysym") %>";
	shifoudayin = "<%=request.getParameter("isdy") %>";
	yuLanPageno = "<%=request.getParameter("yuLanPageSize") %>";
	if(kssxh=="null")kssxh="";
	if(bcyssl=="null")bcyssl="";
	if(ysym=="null")ysym="";
	$("#f_pch").val(pch);
	$("#f_kssxh").val(kssxh);
	$("#f_bcyssl").val(bcyssl);
	$("#f_bcysym").val(ysym);
	setIckMydytpzs();
}); 

//全局参数，每页打印图片张数
function setIckMydytpzs(){
	var globalparParams = '<Params><Param name="globalparcode">zdpbh</Param></Params>';
	jQuery.post("<%=request.getContextPath()%>/sysadmin/query_globalpar.action",{dataxml:globalparParams},
	function(json){
		yuLanRows = json.LGlobalpar[0].globalparvalue;
		setIckZbYuLan();
	},"json");
}

//IC卡组包预览查询
function setIckZbYuLan(){
	setParams("f_");
	var yuLanData = jQuery.extend(params,{pagesize:yuLanPageno,pagerow:yuLanRows});
	jQuery.post("<%=request.getContextPath()%>/icksystem/querylistYl_ickzb.action",yuLanData,zbYuLanBack,"json");//Action 未写完(service调用方法未完成)
}

//组包预览回调方法
function zbYuLanBack(json){

	if(json.result=="success"){
	//LIckzb列表里面存放IC卡受理Bean
		var ickList = json.LIckzb;
		var ickListLength = ickList.length;
		var ryidSet = "";
		var ickslidSet = "";
		for(i=0;i<yuLanRows;i++){
			if(i<ickListLength){
				$("#img"+i).attr("src","<%=request.getContextPath()%>/icksystem/queryTp_ickzb.action?ryId="+ickList[i].ickslid);
				$("#p"+i).css("display","block");
				$("#img"+i).css("display","block");
				$("#apDiv"+(i+1)).css("display","block");
				
				//根据从业类别判断背景图
				$("#tbCard"+i).attr("background","<%=request.getContextPath()%>/images/background/background"+ickList[i].cylbdm+".bmp");
				$("#tbCard"+i).height("5.7cm");
				$("#tbCard"+i).width("8.8cm");
				
				$("#cyrybh"+i).append(ickList[i].kh);
				$("#youxiaoqi"+i).append(setNull(ickList[i].yxqhzrq));
				$("#apDivfont3").text((yuLanPageno-1)*2+1);
				$("#apDivfont4").text(yuLanPageno*2);
				ryidSet += ickList[i].ryid+"_,,";
				ickslidSet += ickList[i].ickslid+"_,,";
			}else{
				$("#p"+i).css("display","none");
				$("#img"+i).css("display","none");
				$("#apDiv"+(i+1)).css("display","none");
			}
		}
        $('#y_ryidSet', window.parent.document).val(ryidSet);
        $('#y_ickslidSet', window.parent.document).val(ickslidSet);
		//parent.document.getElementById("y_ryidSet").value = ryidSet;
		//parent.document.getElementById("y_ickslidSet").value = ickslidSet;

	}
}

</script>	 
</head>
	<input type="hidden" id="f_pch" />
	<input type="hidden" id="f_kssxh" />
	<input type="hidden" id="f_bcyssl" />
	<input type="hidden" id="f_bcysym" />
<body style="margin-top: 16px; margin-left: 35px; margin-right: 0px; margin-bottom: 4px;" background="<%=request.getContextPath()%>/images/background/printground.jpg">
<table border="0" cellpadding="0" cellspacing="0" >
        <tr>
            <td style="width: 1px">
            <table border="0" cellpadding="0" cellspacing="0" style="background-color: Transparent; width:19.6cm;">
            <tr><td >
            
           <table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
    <tr>
        <td style="vertical-align: middle;">     
            <table id="tbCard0" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
                <tr>
                  <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                      <tr>
                                <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                          </tr>
                                <tr valign="top">
                          <td >&nbsp;</td>
                          <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                          <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img  id="img0" datasrc="#xmlPagedso" datafld="Img0" alt="照片" height="109px" width="83px" border="0" /></span></td>
                        </tr>
                            <tr>
                                <td colspan="3" style="text-align: right; height:1.2cm">
                              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="86%" align="right"> <span id="cyrybh0" datasrc="#xmlPagedso" datafld="Cyrybh0" style="font-family: 幼圆; font-weight:bold; font-size: 13px; color:#FFFFFF"></span></td>
    <td width="4%" align="right"></td>
    <td width="10%"></td>
  </tr>
  <tr>
    <td colspan="2" align="right"><span style="font-family: 幼圆; font-weight:bold; font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi0" datasrc="#xmlPagedso" datafld="Yxq0" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
    <td width="10%"></td>
  </tr>
  <tr><td height="2"></td></tr>
</table>
</td>
                           </tr>
                      </table>                    </td>
                </tr>
            </table>        </td>
    </tr>
</table>
</td>
              <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
                <tr>
                  <td style="vertical-align: middle;"><table id="tbCard1" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
                    <tr>
                      <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                          <tr>
                            <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                          </tr>
                          <tr valign="top">
                            <td >&nbsp;</td>
                            <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                            <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img id="img1" datasrc="#xmlPagedso" datafld="Img1" alt="照片" height="109px" width="83px" border="0" /></span></td>
                          </tr>
                          <tr>
                            <td colspan="3" style="text-align: right; height:1.2cm">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="86%" align="right"><span id="cyrybh1" datasrc="#xmlPagedso" datafld="Cyrybh1" style="font-family: 幼圆; font-weight:bold;font-size: 13px; color:#FFFFFF"></span></td>
    <td width="4%" align="right"></td>
    <td width="10%" ></td>
  </tr>
  <tr>
    <td  colspan="2"  align="right"><span style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi1" datasrc="#xmlPagedso" datafld="Yxq1" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
    <td width="10%"> </td>
  </tr>
    <tr><td height="2"></td></tr>
</table>


                            </td>
                          </tr>
                      </table></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>        
             </table>
             
             
          </td>
            </tr>
    </table>
<table border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td style="width: 1px"><table border="0" cellpadding="0" cellspacing="0" style="background-color: Transparent; width:19.6cm;">
      <tr>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard2" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img  id="img2" datasrc="#xmlPagedso" datafld="Img2" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh2" datasrc="#xmlPagedso" datafld="Cyrybh2" style="font-family: 幼圆; font-weight:bold; font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td colspan="2" align="right"><span style="font-family: 幼圆; font-weight:bold; font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi2" datasrc="#xmlPagedso" datafld="Yxq2" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard3" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img id="img3" datasrc="#xmlPagedso" datafld="Img3" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh3" datasrc="#xmlPagedso" datafld="Cyrybh3" style="font-family: 幼圆; font-weight:bold;font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%" ></td>
                      </tr>
                      <tr>
                        <td  colspan="2"  align="right"><span style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi3" datasrc="#xmlPagedso" datafld="Yxq3" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td style="width: 1px"><table border="0" cellpadding="0" cellspacing="0" style="background-color: Transparent; width:19.6cm;">
      <tr>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard4" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img  id="img4" datasrc="#xmlPagedso" datafld="Img4" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh4" datasrc="#xmlPagedso" datafld="Cyrybh4" style="font-family: 幼圆; font-weight:bold; font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td colspan="2" align="right"><span style="font-family: 幼圆; font-weight:bold; font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi4" datasrc="#xmlPagedso" datafld="Yxq4" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard5" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img id="img5" datasrc="#xmlPagedso" datafld="Img5" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh5" datasrc="#xmlPagedso" datafld="Cyrybh5" style="font-family: 幼圆; font-weight:bold;font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%" ></td>
                      </tr>
                      <tr>
                        <td  colspan="2"  align="right"><span style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi5" datasrc="#xmlPagedso" datafld="Yxq5" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td style="width: 1px"><table border="0" cellpadding="0" cellspacing="0" style="background-color: Transparent; width:19.6cm;">
      <tr>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard6" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img  id="img6" datasrc="#xmlPagedso" datafld="Img6" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh6" datasrc="#xmlPagedso" datafld="Cyrybh6" style="font-family: 幼圆; font-weight:bold; font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td colspan="2" align="right"><span style="font-family: 幼圆; font-weight:bold; font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi6" datasrc="#xmlPagedso" datafld="Yxq6" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard7" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img id="img7" datasrc="#xmlPagedso" datafld="Img7" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh7" datasrc="#xmlPagedso" datafld="Cyrybh7" style="font-family: 幼圆; font-weight:bold;font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%" ></td>
                      </tr>
                      <tr>
                        <td  colspan="2"  align="right"><span style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi7" datasrc="#xmlPagedso" datafld="Yxq7" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td style="width: 1px"><table border="0" cellpadding="0" cellspacing="0" style="background-color: Transparent; width:19.6cm;">
      <tr>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard8" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img  id="img8" datasrc="#xmlPagedso" datafld="Img8" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh8" datasrc="#xmlPagedso" datafld="Cyrybh8" style="font-family: 幼圆; font-weight:bold; font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td colspan="2" align="right"><span style="font-family: 幼圆; font-weight:bold; font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi8" datasrc="#xmlPagedso" datafld="Yxq8" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td ><table border="0" cellpadding="0" cellspacing="0" style="width: 9.8cm; height: 5.7cm; text-align: center; background-color:Transparent;">
          <tr>
            <td style="vertical-align: middle;"><table id="tbCard9" border="0" cellpadding="0" cellspacing="0" style="width: 8.8cm; height: 5.7cm;">
              <tr>
                <td  align="center"><table border="0" cellpadding="0" cellspacing="0" style="width: 8.6cm; height: 5.4cm;">
                  <tr>
                    <td colspan="3" style="height: 1.4cm;">&nbsp;</td>
                  </tr>
                  <tr valign="top">
                    <td >&nbsp;</td>
                    <td style="width: 3.4cm;height:2.5cm;">&nbsp;</td>
                    <td align="center" style="width: 4.4cm;"><span style="width: 2.6cm;"><img id="img9" datasrc="#xmlPagedso" datafld="Img9" alt="照片" height="109px" width="83px" border="0" /></span></td>
                  </tr>
                  <tr>
                    <td colspan="3" style="text-align: right; height:1.2cm"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="86%" align="right"><span id="cyrybh9" datasrc="#xmlPagedso" datafld="Cyrybh9" style="font-family: 幼圆; font-weight:bold;font-size: 13px; color:#FFFFFF"></span></td>
                        <td width="4%" align="right"></td>
                        <td width="10%" ></td>
                      </tr>
                      <tr>
                        <td  colspan="2"  align="right"><span style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF">有效期至</span><span id="youxiaoqi9" datasrc="#xmlPagedso" datafld="Yxq9" style="font-family: 幼圆; font-weight:bold;font-size: 12px;color:#FFFFFF"></span></td>
                        <td width="10%"></td>
                      </tr>
                      <tr>
                        <td height="2"></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
<object id="xmlPagedso" CLASSID="clsid:550dda30-0541-11d2-9ca9-0060b0ec3d39" width="0" height="0"></object>
<object ID='WebBrowser' WIDTH=0 HEIGHT=0 CLASSID='CLSID:8856F961-340A-11D0-A96B-00C04FD705A2'></object>
