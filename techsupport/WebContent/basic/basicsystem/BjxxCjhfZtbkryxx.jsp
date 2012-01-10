<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bkryid").attr("value",dataid);
			setDetail();
	}); 
	function updatediv (json) {                             
		$("#xm").append(setNull(json.LBkry[0].bkryid));
		$("#xb").append(setNull(json.LBkry[0].tbbh));
		$("#sfzh").append(setNull(json.LBkry[0].xm));
		$("#csrq").append(setNull(json.LBkry[0].jg));
		$("#ajlb").append(setNull(json.LBkry[0].xb));		
		}	
</script>
<input type="hidden" id="q_bkryid">
<table width="100%" border="0">
  <tr>
    <td width="100%" class="queryfont">在逃布控人员信息</td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" id="detail">
      <tr>
        <td width="7%" class="distd">姓名</td>
        <td width="17%" class="detailtd"><span type="text"id="xm"/></span></td>
        <td width="10%" class="distd">性别</td>
        <td width="18%" class="detailtd"><span type="text"id="xb"/></span></td>
      </tr>
      <tr>
        <td class="distd">身份证号码</td>
        <td class="detailtd"><span type="text"id="zjhm"/></span></td>
        <td class="distd">出生日期</td>
        <td class="detailtd"><select name="csrq"id="csrq" type="select"/>
        </select>
              </select></td>
      </tr>
      <tr>
        <td class="distd">在逃（布控）编号</td>
        <td class="detailtd"><span type="text"id=" "/></span></td>
        <td class="distd">上网时间</td>
        <td class="detailtd"><select name=" " id=" " type="select" value="0" />
        </select>
              </select></td>
      </tr>
      <tr>
        <td class="distd">案件类别</td>
        <td class="detailtd"><span type="text"id="ajlb"/></span></td>
        <td class="distd">&nbsp;</td>
        <td class="detailtd">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
