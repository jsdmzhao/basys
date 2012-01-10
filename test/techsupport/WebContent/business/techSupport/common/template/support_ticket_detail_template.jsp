<%@ page language="java" pageEncoding="UTF-8"%>
		<!-- content start -->
		<div id="supportTicket">
          <div class="row">
            <div class="column " >
                <label class="label red">技术支持单编号:</label>
                <input type="text" class=" item ro inputstyle" name="st.stNo" id="stNo">
                <div class="clear-column"></div>
            </div>
            <div class="clear-row"></div>
        </div>
        
        <div class="row">
            <div class="column " >
                <label class="label red">申请人:</label>
                <input type="text" class="ro item inputstyle" id="applicant" name="st.applicant.username">
                <div class="clear-column"></div>
            </div>
            <div class="column " >
                <label class="label red" style="width:100px;">大区/区域:</label>
                <input type="text" name="st.region"  class="ro inputstyle" id="region">
                <div class="clear-column"></div>
            </div>
            <div class="column " >
                <label class="label red" style="width:60px;">序号:</label>
                <input class=" item inputstyle genStNo ro" name="st.serialNumber" id="serialNumber"></select>
                <div class="clear-column"></div>
            </div>
            <div class="clear-row"></div>
        </div>
        
        <div class="row">
            <div class="column "  style="line-height: 78px;width: 880px;">
                <label class="label red">技术支持单内容:</label>
                <textarea style="width:690px !important;height: 78px;" class="ro item inputstyle genStNo" name="st.supportContent" id="supportContent"></textarea>
                <div class="clear-column"></div>
            </div>
            <div class="clear-row"></div>
        </div>
        </div>