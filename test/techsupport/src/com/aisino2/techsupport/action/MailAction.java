package com.aisino2.techsupport.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.common.ItemChange;
import com.aisino2.core.web.BaseAction;
import com.aisino2.core.web.PageAction;
import com.aisino2.techsupport.domain.Mail;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.SupportTicketService;

@Component
@Scope("prototype")
public class MailAction extends BaseAction {

	private List<SupportTicket> lSt;
	private String result;
	private SupportTicketService stService;
	private String EmailAddress;
	private Mail mail;
	private List<Mail> mLst;
	public String sendMail(){
		return "success";
	}
	
	public String setEmailDetail(){
		try{
			if(lSt==null){
				throw new RuntimeException("没有选择技术支持单,不能发送邮件");
			}
			for(SupportTicket st:lSt){
				lSt.remove(st);
				st = stService.getSupportTicket(st);
				lSt.add(st);
			}
		}catch(Exception e){
			
		}
		return "success";
	}
	
	public String findEmailAdreesByName(){
		if(mLst==null){
			throw new RuntimeException("没有选择技术支持单,不能发送邮件");
		}
		for(Mail mail:mLst){
			mail.setEmail(ItemChange.codeChange("", mail.getUser()));
		}
		return "success";
	}

	public List<SupportTicket> getlSt() {
		return lSt;
	}

	public void setlSt(List<SupportTicket> lSt) {
		this.lSt = lSt;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public SupportTicketService getStService() {
		return stService;
	}
	@Resource(name = "SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public List<Mail> getmLst() {
		return mLst;
	}

	public void setmLst(List<Mail> mLst) {
		this.mLst = mLst;
	}
	
	
	
}
