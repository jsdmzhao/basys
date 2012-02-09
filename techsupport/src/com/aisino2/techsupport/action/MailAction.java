package com.aisino2.techsupport.action;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.techsupport.domain.CarbonCopy;
import com.aisino2.techsupport.domain.Mail;
import com.aisino2.techsupport.domain.Recipient;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.MailService;
import com.aisino2.techsupport.service.SupportTicketService;

@Component
@Scope("prototype")
public class MailAction extends BaseAction {

	private List<SupportTicket> lSt;
	private String result;
	private SupportTicketService stService;
	private MailService mailService;
	private IDict_itemService dict_itemService;
	private String EmailAddress;
	private Mail mail;
	private List<Mail> lMailList=new ArrayList<Mail>();
	private List<Recipient> lRecipient=new ArrayList<Recipient>();
	public String sendMail(){
		return "success";
	}
	
	//更具名字查找邮件地址
	public String findEmailAdreesByName(){
		if(mail==null){
			throw new RuntimeException("没有选择技术支持单,不能发送邮件");
		}
		Dict_item dict_item=new Dict_item();
		dict_item.setDict_code("dm_userAndEmail_tech");
		List<Dict_item> lstDictItem = dict_itemService.getListDict_item(dict_item);
		for(Dict_item di: lstDictItem){
			//收件人地址
			if(mail.getRecipients()!=null&&mail.getRecipients().size()>0){
				for(Recipient recipient:mail.getRecipients()){
					if(recipient!=null&&!"".equals(recipient.getrName()))
						if(di.getDisplay_name().equals(recipient.getrName()))
							recipient.setrAddress(di.getFact_value());
				}
			}
			//抄送人地址
			if(mail.getCarbonCopys()!=null&&mail.getCarbonCopys().size()>0){
				for(CarbonCopy carbonCopy:mail.getCarbonCopys()){
					if(carbonCopy!=null&&!"".equals(carbonCopy.getcName()))
						if(di.getDisplay_name().equals(carbonCopy.getcName())){
							carbonCopy.setcAddress(di.getFact_value());
						}
				}
			}
			//发件人地址
			if(mail.getUser()!=null&&!"".equals(mail.getUser()))
				if(di.getDisplay_name().equals(mail.getUser()))
					mail.setEmail(di.getFact_value());
		}
		this.result="success";
		return "success";
	}
	
	//根据名字获取邮件地址
	public String getAdressByName(String name){
		String address="";
		Dict_item dict_item=new Dict_item();
		dict_item.setDict_code("dm_userAndEmail_tech");
		List<Dict_item> lstDictItem = dict_itemService.getListDict_item(dict_item);
		for(Dict_item di: lstDictItem){
			if(name!=null&&!"".equals(name))
				address=di.getFact_value();
		}
		return address;
	}
	
	public String send(){
		String email="";
		InputStream in=this.getClass().getClassLoader().getResourceAsStream("mailContent.properties");
		Properties properties=new Properties();
		List<Recipient> recipients=new ArrayList<Recipient>();
		if (lSt == null || lSt.size() == 0)
			throw new RuntimeException("没有技术支持单被选中");

		for (SupportTicket st : lSt) {
			lSt.remove(st);
			st = stService.getSupportTicket(st);
			lSt.add(st);
		}
		if(mail==null){
			throw new RuntimeException("没有发件人不能发送邮件");
		}
		email=getAdressByName(mail.getUser());
		mail.setEmail(email);
		mail.setProtocol(Mail.PROTOCOL_POP);
		mail.setSmtphost("smtp.aisino.com");
		mail.setHost("pop3.aisino.com");
		for(SupportTicket st: lSt){
			Recipient recipient=new Recipient();
			recipient.setLastEditTime(st.getLastUpdateDate());
			recipient.setrAddress(getAdressByName(st.getSupportLeaderName()));
			recipient.setrName(st.getSupportLeaderName());
			recipient.setSt_NO(st.getStNo());
			recipients.add(recipient);
		}
		mail.setRecipients(recipients);
		try{
			properties.load(in);
			String content=new String(properties.getProperty("mailContent").getBytes("ISO8859-1"),"UTF-8");
			String subject=new String(properties.getProperty("mailSubject").getBytes("ISO8859-1"),"UTF-8");
			for(Recipient recipient:mail.getRecipients()){
				if(recipient.getLastEditTime()!=null&&!"".equals(recipient.getLastEditTime())){
					//DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date editTime=recipient.getLastEditTime();
					Date now=new Date();
					long diff=now.getTime()-editTime.getTime();
					long days=diff/(1000 * 60 * 60 * 24);
					Object template[]={recipient.getrName(),recipient.getSt_NO(),editTime,days};
					content=MessageFormat.format(content, template);
					mailService.send(mail, subject, recipient.getrAddress(), null, content, false);
				}
			}
			this.result="发送邮件成功";
		}catch(Exception e){
			this.result=e.getMessage();
		}
		return "success";
	}
	
	
	/**
	 * 发送Email
	 * @return
	 *//*
	public String sendEmail(){
		if(mail==null){
			throw new RuntimeException("没有收件人不能，发送电子邮件");
		}
		InputStream in=this.getClass().getClassLoader().getResourceAsStream("mailContent.properties");
		Properties properties=new Properties();
		mail.setProtocol(Mail.PROTOCOL_POP);
		mail.setSmtphost("smtp.aisino.com");
		mail.setHost("pop3.aisino.com");
		mailService.connect(mail, true, true, false);
		try{
			properties.load(in);
			String content=new String(properties.getProperty("mailContent").getBytes("ISO8859-1"),"UTF-8");
			String subject=new String(properties.getProperty("mailSubject").getBytes("ISO8859-1"),"UTF-8");
			for(Recipient recipient:mail.getRecipients()){
				if(recipient.getLastEditTime()!=null&&!"".equals(recipient.getLastEditTime())){
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date editTime=format.parse(recipient.getLastEditTime());
					Date now=new Date();
					long diff=now.getTime()-editTime.getTime();
					long days=diff/(1000 * 60 * 60 * 24);
				}
				Object template[]={recipient.getrName(),recipient.getSt_NO(),null,null};
				content=MessageFormat.format(content, template);
				mailService.send(mail, subject, recipient.getrAddress(), null, content, false);
			}
			this.result="发送邮件成功";
		}catch(Exception e){
			this.result=e.getMessage();
		}
		return "success";
	}*/

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

	
	

	public List<Mail> getlMailList() {
		return lMailList;
	}

	public void setlMailList(List<Mail> lMailList) {
		this.lMailList = lMailList;
	}
	

	public List<Recipient> getlRecipient() {
		return lRecipient;
	}

	public void setlRecipient(List<Recipient> lRecipient) {
		this.lRecipient = lRecipient;
	}

	@Resource(name = "dict_itemService")
	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
	@Resource(name="mailServiceImpl")
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
	
	
}
