package com.aisino2.techsupport.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Word;
import com.aisino2.techsupport.service.IWord;
import com.aisino2.techsupport.service.SupportTicketService;
import com.lowagie.text.DocumentException;

@Component
@Scope("prototype")
public class WordAction extends BaseAction {

	private IWord wordService;
	private SupportTicketService supportTicketService;
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
			Properties properties=new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("word.properties");
			properties.load(in);
			String status=word.getStatus();
			String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
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
			word.setlSupportTicket(lSt);
			word.setPath(new String(properties.getProperty("filePath").getBytes("ISO8859-1"),"UTF-8")+fileName+".doc");
			wordService.CreateWord(word);
		} catch (DocumentException e) {
			this.result=e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			this.result=e.getMessage();
			e.printStackTrace();
		} catch (ParseException e) {
			this.result=e.getMessage();
			e.printStackTrace();
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
