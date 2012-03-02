<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="supportTicket">
          <div class="row">
            <div class="column pagedistd" >
                <label class="label red">技术支持单编号:</label>
                <input type="text" class=" item ro inputstyle" name="st.stNo" id="stNo">
                <div class="clear-column"></div>
            </div>
            <div class="clear-row"></div>
        </div>
        
        <div class="row">
            <div class="column pagedistd" >
                <label class="label red">申请人:</label>
                <input type="text" class=" item inputstyle" id="applicantName" name="st.applicant.username">
                <input type="hidden" class=" item inputstyle" id="applicantId" name="st.applicant.userid">
                <div class="clear-column"></div>
            </div>
            <div class="column pagedistd" >
                <label class="label red" style="width:100px;">大区/区域:</label>
                <input type="text" class=" item inputstyle genStNo ro" id="regionName">
                <input type="hidden" name="st.region" id="regionCode">
                <div class="clear-column"></div>
            </div>
            <div class="column pagedistd" >
                <label class="label red" style="width:60px;">序号:</label>
                <input class=" item inputstyle ro genStNo " name="st.serialNumber" id="serialNumber">
                <div class="clear-column"></div>
            </div>
            <div class="clear-row"></div>
        </div>
        
        <div class="row">
            <div class="column pagedistd"  style="line-height: 78px;">
                <label class="label red">技术支持单内容:</label>
                <textarea style="width:627px !important;height: 78px;" class=" item inputstyle genStNo" name="st.supportContent" id="supportContent"></textarea>
                <div class="clear-column"></div>
            </div>
            <div class="clear-row"></div>
        </div>
        </div>