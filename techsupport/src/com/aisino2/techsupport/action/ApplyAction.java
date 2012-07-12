package com.aisino2.techsupport.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.techsupport.common.CommonUtil;
import com.aisino2.techsupport.domain.Attachment;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.ApplyService;
import com.aisino2.techsupport.service.IAttachmentService;
import com.aisino2.techsupport.service.SupportTicketService;

/**
 * 
 * 申请填报视图
 */
@SuppressWarnings("serial")
@Component("ApplyAction")
@Scope("prototype")
public class ApplyAction extends BaseAction {
	private SupportTicket st;
	private ApplyService applyService;
	private SupportTicketService stService;
	private int returnNo;
	private String returnMsg;
	private IAttachmentService attachmentService;
	
	/**
	 * 参数用附件 
	 */
	private Attachment attachment;
	
	
	public String save() throws Exception{
		try{
			//如果有附件的话，就像支持单结构里面添加附件信息
			if(attachment != null && attachment.getBatchNumber() != null){
				List<Attachment> attachment_list = attachmentService.queryAttachment(attachment);
				st.setAttachment_list(attachment_list);
			}
			
			applyService.insertApplyAndGo(st);
			
			returnNo=0;
			returnMsg="录入申请成功";
		}catch (RuntimeException e) {
			returnNo=1;
			returnMsg="录入申请错误:"+e.getMessage();
		}
		
		
		return SUCCESS;
	}
	
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	/**
	 * 生成序号
	 * @return
	 * @throws Exception
	 */
	public String generateSN() throws Exception{
		int serialNumber=0;
		
		if(st.getStNo().length()>0){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("stNo", st.getStNo().split("-")[0]+"-"+st.getStNo().split("-")[1]);
			List<SupportTicket> lst=(List<SupportTicket>) stService.getListSupportTicketForPage(map, 1, 15, "0", "desc").getData();
			if(lst.size()>0){
				for(SupportTicket stt : lst){
					serialNumber = serialNumber > stt.getSerialNumber()? serialNumber : stt.getSerialNumber();
				}
			}
		}
		
		st.setSerialNumber(serialNumber+1);
		return SUCCESS;
	}
	public String checkStNoisValid() throws Exception{
		try{
			boolean isExist=applyService.checkStNoIsExist(st.getStNo());
			if(isExist){
				returnNo=1;
				returnMsg="此工作单编号已存在";
			}
			else{
				returnNo=0;
				returnMsg="此工作单编号可用";
			}
				
		}catch (Exception e) {
			log.debug(e);
			returnMsg="检查发生错误："+e.getMessage();
			returnNo=1;
		}
		
		return SUCCESS;
	}

	public SupportTicket getSt() {
		return st;
	}

	public void setSt(SupportTicket st) {
		this.st = st;
	}


	public int getReturnNo() {
		return returnNo;
	}

	public void setReturnNo(int returnNo) {
		this.returnNo = returnNo;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	@Resource(name="ApplyServiceImpl")
	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}
	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name="attachmentServiceImpl")
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

}
