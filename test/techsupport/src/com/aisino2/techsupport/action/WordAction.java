package com.aisino2.techsupport.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.techsupport.domain.Mail;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Word;
import com.aisino2.techsupport.service.IWord;
import com.aisino2.techsupport.service.MailService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.lowagie.text.DocumentException;

@Component
@Scope("prototype")
public class WordAction extends BaseAction {

	private IWord wordService;
	private SupportTicketService supportTicketService;
	private MailService mailService;
	private Word word;
	private String result;
	private List<SupportTicket> lSt;

	
	public String createWord(){
		if(lSt==null){
			this.result="没有选择技术支持单不能导出并发送邮件";
			throw new RuntimeException("没有选择技术支持单不能导出并发送邮件");
		}
		for(SupportTicket st:lSt){
			lSt.remove(st);
			st=supportTicketService.getSupportTicket(st);
			lSt.add(st);
		}
		if(word==null){
			word=new Word();
		}
		try {
			//读取word文档配置信息
			Properties properties=new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("word.properties");
			properties.load(in);
			//读取邮件配置信息
			Properties mailConfig=new Properties();
			InputStream config = this.getClass().getClassLoader().getResourceAsStream("mailConfig.properties");
			mailConfig.load(config);
			String status=word.getStatus();
			String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String subject=null;//邮件主题
			String to=null;//收件人
			String cc=null;//抄送人
			String text=null;//内容
			if(status!=null&&status.equals("going")){//进展状态
				word.setfRow_firstColumn(new String(properties.getProperty("going_fRow_firstColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setfRow_secondColumn(new SimpleDateFormat("yyyy年MM月dd日 ").format(new Date()));
				word.setsRow_firstColumn(new String(properties.getProperty("going_sRow_firstColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_secondColumn(new String(properties.getProperty("going_sRow_secondColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_thirdColumn(new String(properties.getProperty("going_sRow_thirdColumn").getBytes("ISO8859-1"),"UTF-8") );
				word.setsRow_fourthColumn(new String(properties.getProperty("going_sRow_fourthColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_fifthColumn(new String(properties.getProperty("going_sRow_fifthColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_sixthColumn(new String(properties.getProperty("going_sRow_sixthColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_seventhColumn(new String(properties.getProperty("going_sRow_seventhColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setTableCellSize(Integer.valueOf(new String(properties.getProperty("going_tableCloumnSize").getBytes("ISO8859-1"),"UTF-8")));
				Object[] temp={new SimpleDateFormat("yyyy年MM月dd日").format(new Date())};
				subject=new String(properties.getProperty("going_maiSubject").getBytes("ISO8859-1"),"UTF-8");
				subject=MessageFormat.format(subject, temp);
				text=subject;
				to=new String(properties.getProperty("going_recipient").getBytes("ISO8859-1"),"UTF-8");
			}else if(status!=null&&status.equals("wait_feedback")){//反馈状态
				word.setfRow_firstColumn(new String(properties.getProperty("feedback_fRow_firstColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setfRow_secondColumn(new SimpleDateFormat("yyyy年MM月dd日 ").format(new Date()));
				word.setsRow_firstColumn(new String(properties.getProperty("feedback_sRow_firstColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_secondColumn(new String(properties.getProperty("feedback_sRow_secondColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_thirdColumn(new String(properties.getProperty("feedback_sRow_thirdColumn").getBytes("ISO8859-1"),"UTF-8") );
				word.setsRow_fourthColumn(new String(properties.getProperty("feedback_sRow_fourthColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_fifthColumn(new String(properties.getProperty("feedback_sRow_fifthColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setsRow_sixthColumn(new String(properties.getProperty("feedback_sRow_sixthColumn").getBytes("ISO8859-1"),"UTF-8"));
				word.setTableCellSize(Integer.valueOf(new String(properties.getProperty("feedback_tableCloumnSize").getBytes("ISO8859-1"),"UTF-8")));
			}else if(status!=null&&status.equals("wait_company_appraval")){//审批状态
				
			}
			String file=new String(properties.getProperty("filePath").getBytes("ISO8859-1"),"UTF-8")+fileName+".doc";
			word.setlSupportTicket(lSt);
			word.setPath(file);
			wordService.CreateWord(word);
			Mail mail=new Mail();
			mail.setEmail(new String(properties.getProperty("company_Address").getBytes("ISO8859-1"),"UTF-8"));
			mail.setPassword(new String(properties.getProperty("compnay_password").getBytes("ISO8859-1"),"UTF-8"));
			mail.setProtocol(mailConfig.getProperty("protocol"));
			mail.setSmtphost(mailConfig.getProperty("smtphost"));
			mail.setHost(mailConfig.getProperty("host"));
			mailService.connect(mail, true, true, false);
			if(to.indexOf(",")>0){
				String[] recipient=to.split(",");
				for(int i=0;i<recipient.length;i++){
					mailService.send(mail, subject, recipient[i], null, text, file, false);
				}
			}else{
				mailService.send(mail, subject, to, null, text,file, false);
			}
			
		} catch (DocumentException e) {
			this.result=e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			this.result=e.getMessage();
			e.printStackTrace();
		} catch (ParseException e) {
			this.result=e.getMessage();
			e.printStackTrace();
		} catch (Exception e) {
			this.result=e.getMessage();
			e.printStackTrace();
		}finally{
			wordService.close();
			mailService.close();
		}
		return "success";
	}




	@Resource(name="wordImpl")
	public void setWordService(IWord wordService) {
		this.wordService = wordService;
	}


	public Word getWord() {
		return word;
	}
	


	@Resource(name="SupportTicketServiceImpl")
	public void setSupportTicketService(SupportTicketService supportTicketService) {
		this.supportTicketService = supportTicketService;
	}
	

	@Resource(name="mailServiceImpl")
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}




	public void setWord(Word word) {
		this.word = word;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public List<SupportTicket> getlSt() {
		return lSt;
	}


	public void setlSt(List<SupportTicket> lSt) {
		this.lSt = lSt;
	}
	
	
	
	
	
	
	
	
	
}
