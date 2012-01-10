<table width="100%">
        <tr>
          <td width="6%" class="red">物品名称</td>
          <td width="68%" class="detailtd"><input type="text" class="inputstyle"  id="m_bkwpmc" value="" /></td>
          <td width="26%" colspan="2" rowspan="4"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
            <input type="hidden" id="m_fileload" />
            <tr>
              <td valign="top"><img id ="pmtPho" width="150px" height="200px" src="images/pic.gif"/> <a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="选图片" onclick='openfile();'>选图片</a> </td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td class="red">物品类型</td>
          <td class="detailtd"><select name="m_bkwplxdm"  id="m_bkwplxdm" onchange="setWPLXForDetail('m_bkwplxdm');" type="select" value="">
            <option></option>
          </select></td>
        </tr>
        <tr>
          <td colspan="2" class="detailtd">物品描述</td>
        </tr>
        <tr>
          <td colspan="2" valign="top"  class="detailtd"><textarea name="textarea" id="m_bkwpms" style="width:670px;" value="" type="_moz" /></textarea>
                </textarea></td>
        </tr>
      </table>
          <table width="100%" id="clDetail">
            <tr height="20">
              <td class="distd"><font color="blue">车辆品牌</font></td>
              <td class="detailtd"><select name="m_clppdm" id="m_clppdm" type="select" value="">
                  <option></option>
                </select>
              </td>
              <td class="distd"><font color="blue">车辆型号</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"   id="m_clxh" value="" /></td>
              <td class="distd"><font color="blue">车辆号牌</font></td>
              <td class="detailtd"><input type="text"  class="inputstyle"  id="m_hphm" value="" /></td>
              <td class="distd"><font color="blue">机动车所有人</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_syr" value="" /></td>
            </tr>
            <tr height="20">
              <td class="distd"><font color="blue">车辆类型</font></td>
              <td class="detailtd"><select name="m_cllxdm" id="m_cllxdm" type="select" value="">
                  <option></option>
              </select></td>
              <td class="distd"><font color="blue">发动机号</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_fdjh" value="" /></td>
              <td class="distd"><font color="blue">车架号</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_cjh" value="" /></td>
              <td class="distd"><font color="blue">初次登记日期</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_ccdjrq" value="" /></td>
            </tr>
            <tr height="20">
              <td class="distd"><font color="blue">车辆颜色</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_csys" value="" /></td>
              <td class="distd" clospan="6">&nbsp;</td>
            </tr>
          </table>
        <table width="100%" id="sjDetail">
            <tr height="20">
              <td class="distd"><font color="green">手机品牌</font></td>
              <td class="detailtd"><select name="m_ppdm" id="m_ppdm" type="select" value="">
                  <option></option>
              </select></td>
              <td class="distd"><font color="green">手机型号</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_xh" value="" /></td>
              <td class="distd"><font color="green">手机串号</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_sjch" value="" /></td>
              <td class="distd"><font color="green">手机颜色</font></td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_ys" value="" /></td>
            </tr>
          </table>
        <table width="100%">
            <tr height="20">
              <td class="distd">通报编号</td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_tbbh" value="" /></td>
              <td class="red">案件类别</td>
              <td class="detailtd"><select name="m_ajlbbm" id="m_ajlbbm" type="select" value="">
                  <option></option>
                </select>
              </td>
              <td class="red">发文单位</td>
              <td class="detailtd"><input type="text" class="inputstyle"  id="m_fwdw" value="" /></td>
              <td class="red">通报时间</td>
              <td class="detailtd"><input type="text" class="inputstyle" id="m_tbsj2" value="" /></td>
            </tr>
          </table>
        <table width="100%">
            <tr height="20">
              <td class="detailtd"><font color="red">简要案情</font></td>
            </tr>
            <tr height="20">
              <td  class="detailtd"><textarea name="textarea2" id="m_jyaq" style="width:880px;" value="" type="_moz" /></textarea>
                  </textarea></td>
            </tr>
            <tr height="20">
              <td class="detailtd">处理结果</td>
            </tr>
            <tr height="20">
              <td  class="detailtd"><textarea name="textarea3" id="m_cljg" style="width:880px;" value="" type="_moz" /></textarea>
                  </textarea></td>
            </tr>
          </table>
        <table width="100%">
            <tr height="20">
              <td width="10%" class="red">布控人</td>
              <td width="25%" class="detailtd"><input type="text" class="inputstyle" id="m_bkr" value="" /></td>
              <td width="11%" class="red">布控操作员</td>
              <td width="21%" class="detailtd"><input type="text" class="inputstyle" id="m_bkczy" value="" /></td>
              <td width="12%" class="red">布控范围</td>
              <td width="21%" class="detailtd"><select name="m_bkfwbm" id="m_bkfwbm" type="select" value="">
                  <option></option>
                </select>
              </td>
            </tr>
            <tr height="20">
              <td width="10%" class="distd">布控操作时间</td>
              <td width="25%" class="detailtd"><input type="text" class="inputstyle" id="m_bkczsj" value="" /></td>
              <td class="red">联系人</td>
              <td class="detailtd"><input type="text" class="inputstyle" id="m_lxr" value="" /></td>
              <td class="red">联系方式</td>
              <td class="detailtd"><input type="text" class="inputstyle" id="m_lxfs" value="" /></td>
            </tr>
            <tr height="20">
              <td class="distd">布控终止时间</td>
              <td class="detailtd"  colspan="3"><input class="inputstyle" type="text" id="m_bkdqsj" value="" /></td>
            </tr>
        </table>