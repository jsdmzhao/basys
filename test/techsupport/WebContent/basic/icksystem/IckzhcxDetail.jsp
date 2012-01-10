<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	bc_bottonMoveRight(1,'打印');
		$("#q_ickslid").attr("value",dataid);
		setDetail();
	}); 
	
	function updatediv (json) { 
	//人员基本信息
		$("#ickzhcx_xm").append(setNull(json.qyryxx.xm));
		$("#ickzhcx_zjhm").append(setNull(json.qyryxx.zjhm));
		$("#ickzhcx_xb").append(setNull(json.qyryxx.xb));
		$("#ickzhcx_cyrybh").append(setNull(json.qyryxx.cyrybh));
		$("#ickzhcx_qymc").append(setNull(json.qyryxx.qymc));
		
	//IC卡受理信息	
		$("#kh").append(setNull(json.icksl.kh));
		$("#ickh").append(setNull(json.icksl.ickh));
		$("#slr").append(setNull(json.icksl.slr));
		$("#slsj").append(setNull(json.icksl.slsj));
		$("#yxsksrq").append(setNull(json.icksl.yxsksrq));
		$("#yxqhzrq").append(setNull(json.icksl.yxqhzrq));
		$("#zkztbs").append(setNull(json.icksl.zkztmc));
		$("#cjdbm").append(setNull(json.icksl.cjdbm));
		$("#cjdmc").append(setNull(json.icksl.cjdmc));
		
	//IC制卡信息
		$("#yssj").append(setNull(json.icksl.yssj));
		$("#ysr").append(setNull(json.icksl.ysr));
		$("#dxrsj").append(setNull(json.icksl.dxrsj));
		$("#dxrr").append(setNull(json.icksl.dxrr));
		if(json.wldj!=null){
			$("#wlpc").append(setNull(json.wldj.wlpc));
		}
		if(json.zzzxsc!=null){
			$("#zzhkbz").append(setNull(json.zzzxsc.sjscbz));
			var zzfssj = json.zzzxsc.fssj;
			$("#fssj").append(setNull(zzfssj));
			if(zzfssj!=null)
				$("#fssj").append("已发送");
			$("#sjscbz").append(setNull(json.zzzxsc.sjscbz));
			$("#zzzxscid").append(setNull(json.zzzxsc.zzzxscid));
			$("#zzcwyy").append(setNull(json.zzzxsc.zzcwyy));
		}
		
	//IC制卡信息2
		$("#yssj2").append(setNull(json.icksl.yssj));
		$("#ysr2").append(setNull(json.icksl.ysr));
		$("#dxrsj2").append(setNull(json.icksl.dxrsj));
		$("#dxrr2").append(setNull(json.icksl.dxrr));
		$("#cdxryy").append(setNull(json.icksl.cdxryy));
		$("#cysyy").append(setNull(json.icksl.cysyy));
		if(json.ickzb!=null){
			$("#pch").append(setNull(json.ickzb.pch));
			$("#zbsj").append(setNull(json.ickzb.zbsj));
		}
		if(json.wldj!=null){
			$("#wlpc2").append(setNull(json.wldj.wlpc));
			$("#zbsjwl").append(setNull(json.wldj.zbsj));
		}
		
	//IC卡发放及其他信息
		$("#ffr").append(setNull(json.icksl.ffr));
		$("#ffsj").append(setNull(json.icksl.ffsj));
		$("#ickzxr").append(setNull(json.icksl.ickzxr));
		$("#ickzxsj").append(setNull(json.icksl.ickzxsj));
		$("#ickzxyy").append(setNull(json.icksl.ickzxyy));
		$("#njr").append(setNull(json.icksl.njr));
		$("#njsj").append(setNull(json.icksl.njsj));
		$("#bhkyy").append(setNull(json.icksl.bhkyy));
		$("#yksfsh").append(setNull(json.icksl.yksfsh));
	
	}	
	
var win;
function addAndPrint(){
	window.open("basic/icksystem/ickslQueryPrint.jsp",dataid,"width=800,height=600");
	//win=window.showModelessDialog("business/Ylfwzagl/ickslQueryPrint.jsp",window,"dialogWidth=800px;dialogHeight=600px;status=0;scroll=no"); 
		
}
</script>
<input type="hidden" id="q_ickslid">
<span id="ickzhcxcloseFlag"></span>
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">IC卡综合查询</td>
      <td><a href="#" id="closeDiv" onclick='$("#ickzhcxcloseFlag").parent().hideAndRemove("show");'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
  <div style="overflow-y:auto;overflow-x:hidden;height:500" class="scrollbarface">
  <table width="98%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">人员基本信息</td>
    </tr>
    <tr>
      <td valign="top" class="tdbg"><table width="100%"  cellpadding="2" cellspacing="0" class="detail" id="detail2">
          <tr>
            <td width="18%" class="distd1">姓名</td>
            <td width="30%" class="detailtd2"><span id="ickzhcx_xm"></span></td>
            <td width="20%" class="distd1">证件号码</td>
            <td width="32%" class="detailtd2"><span id="ickzhcx_zjhm" ></span></td>
          </tr>
          <tr>
            <td width="18%" class="distd1">性别</td>
            <td width="30%" class="detailtd2"><span id="ickzhcx_xb"></span></td>
            <td width="20%" class="distd1">人员编号</td>
            <td width="32%"  class="detailtd2"><span id="ickzhcx_cyrybh"></span></td>
          </tr>

          <tr>
            <td class="distd1">服务单位</td>
            <td colspan="3" class="detailtd2"><span id="ickzhcx_qymc"></span></td>
          </tr>

      </table></td>
    </tr>
  </table>	<table width="95%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table> 
  <table width="98%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC卡受理信息</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%" border="0" cellspacing="0" class="detail" cellpadding="2">
          <tr>
            <td width="18%" class="distd1">IC卡受理号</td>
            <td width="30%" class="detailtd2"><span  id="kh"></span></td>
            <td width="20%" class="distd1">IC卡ID</td>
            <td width="32%" class="detailtd2"><span  id="ickh"></span></td>
          </tr>
          <tr>
            <td width="18%" class="distd1">受理人</td>
            <td width="30%" class="detailtd2"><span  id="slr"></span></td>
            <td width="20%" class="distd1">受理时间</td>
            <td width="32%" class="detailtd2"><span  id="slsj"></span></td>
          </tr>
                    <tr>
            <td width="18%" class="distd1">有效期开始日期</td>
            <td width="30%" class="detailtd2"><span  id="yxsksrq"></span></td>
            <td width="20%" class="distd1">有效截止日期</td>
            <td width="32%" class="detailtd2"><span  id="yxqhzrq"></span></td>
          </tr>
                    <tr>
            <td width="18%" class="distd1">制卡状态</td>
            <td colspan="3" class="detailtd2"><span  id="zkztbs"></span></td>
          </tr>
                    <tr>
            <td width="18%" class="distd1">采集点编号</td>
            <td width="30%" class="detailtd2"><span  id="cjdbm"></span></td>
            <td width="20%" class="distd1">采集点名称</td>
            <td width="32%" class="detailtd2"><span  id="cjdmc"></span></td>
          </tr>
      </table></td>
    </tr>
  </table>	<table width="95%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>  
  <table width="98%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC制卡信息</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%" border="0" cellspacing="0" class="detail" cellpadding="2">
        <tr>
          <td width="18%" class="distd1">印刷时间</td>
          <td width="30%" class="detailtd2"><span id="yssj"></span>
           </td>
          <td width="20%" class="distd1">印刷人</td>
          <td width="32%" class="detailtd2"><span id="ysr"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">电写入时间</td>
          <td width="30%" class="detailtd2"><span  id="dxrsj"></span></td>
          <td width="20%" class="distd1">写卡人</td>
          <td width="32%" class="detailtd2"><span id="dxrr"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">物流批次号</td>
          <td width="30%" class="detailtd2"><span  id="wlpc"></span></td>
          <td width="20%" class="distd1">制证上传标志</td>
          <td width="32%" class="detailtd2"><span  id="sjscbz"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">制证回馈标志</td>
          <td width="30%"  class="detailtd2"><span  id="zzhkbz"></span></td>
          <td width="20%"  class="distd1">制证上传时间</td>
          <td width="32%"  class="detailtd2"><span  id="fssj"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">制证回馈时间</td>
          <td width="30%" class="detailtd2"><span  id="hksj"></span></td>
          <td width="20%" class="distd1">制证中心主键</td>
          <td width="32%" class="detailtd2"><span  id="zzzxscid"></span></td>
        </tr>
                <tr>
          <td width="18%" class="distd1">错误原因</td>
          <td colspan="3" class="detailtd2"><span  id="zzcwyy"></span></td>
          </tr>
      </table></td>
    </tr>
  </table>	<table width="95%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
  <table width="98%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC卡制卡信息</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
        <tr>
          <td width="18%" class="distd1">组包批次号</td>
          <td width="30%" class="detailtd2"><span  id="pch"></span></td>
          <td width="20%" class="distd1">组包时间</td>
          <td width="32%"class="detailtd2"><span  id="zbsj"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">印刷时间</td>
          <td width="30%"class="detailtd2"><span  id="yssj2"></span></td>
          <td width="20%" class="distd1">印刷人</td>
          <td width="32%"class="detailtd2"><span  id="ysr2"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">电写入时间</td>
          <td width="30%"class="detailtd2"><span  id="dxrsj2"></span></td>
          <td width="20%" class="distd1">写卡人</td>
          <td width="32%"class="detailtd2"><span id="dxrr2"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">重电写入原因</td>
           <td width="30%" class="detailtd2"><span  id="cdxryy"></span></td>
           <td width="20%"class="distd1">重印刷原因</td>
            <td width="32%" class="detailtd2"><span  id="cysyy"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">物流批次号</td>
          <td width="30%"class="detailtd2"><span  id="wlpc2"></span></td>
          <td width="20%" class="distd1">物流组包时间</td>
          <td width="32%"class="detailtd2"><span  id="zbsjwl"></span></td>
       </tr>
      </table></td>
    </tr>
   </table>
   <table width="95%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="3"></td>
    </tr>
  </table>
  <table width="98%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC卡发放及其他信息</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%" border="0" cellspacing="0" class="detail" cellpadding="2">
        <tr>
          <td width="18%" class="distd1">发放人</td>
          <td width="30%"class="detailtd2"><span  id="ffr"></span></td>
          <td width="20%" class="distd1">发放时间</td>
          <td width="32%"class="detailtd2"><span  id="ffsj"></span></td>
        </tr>
        <tr>
          <td width="18%" class="distd1">注销人</td>
           <td width="30%" class="detailtd2"> <span  id="ickzxr"></span></td>
           <td width="20%" class="distd1">注销时间</td>
           <td width="32%" class="detailtd2"> <span  id="ickzxsj"></span></td>         
        </tr>
        <tr>
          <td width="18%" class="distd1">注销原因</td>
          <td colspan="3"class="detailtd2"><span  id="ickzxyy"></span></td>
          </tr>
                <tr>
          <td width="18%" class="distd1">年检人</td>
          <td width="30%"class="detailtd2"><span  id="njr"></span></td>
          <td width="20%" class="distd1">年检时间</td>
          <td width="32%"class="detailtd2"><span  id="njsj"></span></td>
        </tr>
                <tr>
          <td width="18%" class="distd1">补换卡原因</td>
          <td width="30%"class="detailtd2"><span  id="bhkyy"></span></td>
          <td width="20%" class="distd1">原卡是否收回</td>
          <td width="32%"class="detailtd2"><span  id="yksfsh"></span></td>
        </tr>
      </table></td>
    </tr>
  </table>
	<table  width="98%" border="0" cellpadding="0" cellspacing="0">
	<tr height="15" align="center">
	<td>
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="打印" onclick='addAndPrint();'>打印</a>
	</td>
	<!--  <td>
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='$("#ickzh_detail").hideAndRemove("show");'>关闭</a>
	</td>-->
	</tr>
	</table>
	</div>
