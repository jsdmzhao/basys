package com.aisino2.techsupport.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage;

import com.aisino2.techsupport.domain.Mail;
import com.aisino2.techsupport.service.MailService;
import javax.mail.internet.MimeBodyPart;

import org.springframework.stereotype.Component;
@Component
public class MailServiceImpl implements MailService {

	private Store store;
	private Session session;

	/**发送邮件
	 * @param subject 主题
	 * @param to 收件人（支持多个收件人，若需多个收件人，使用","隔开）
	 * @param cc 抄送 (支持多个抄送,若需多个抄送，使用“,”隔开)
	 * @param pgp 是否使用公密钥加密
	 * @param signature 是否使用数字签名
	 * @param text 正文 
	 * @param attach 附件
	 * @param html 是否为HTML邮件
	 * @return 是否发送成功
	 * @throws AddressException 
	 */
	public Boolean send(Mail mail, String subject, String to, String cc,
			Boolean pgp, Boolean signature, String text, String attach,
			Boolean html) throws Exception {
		// TODO Auto-generated method stub
		Boolean isSend = false;
		if(isConnected()){
			Multipart mp = new MimeMultipart();
			// 创建消息
			Message message = new MimeMessage(session);
			// 设置收件人地址
			if(to!=null&&!"".equals(to)){
				InternetAddress[] toAddress = InternetAddress.parse(to, false);
				message.setRecipients(Message.RecipientType.TO, toAddress);
			}
			// 设置抄送人地址
			if (cc != null&&!cc.equals("")) {
				InternetAddress[] ccAddress = InternetAddress.parse(cc,
						false);
				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}
			// 设置主题
			if(subject == null || "".equals(subject) ){
				message.setSubject("没有主题");
			}else{
				message.setSubject(subject);
			}
			// 设置发件人
			message.setFrom(new InternetAddress(
					mail.getEmail().indexOf("@") > 0 ? mail.getEmail() : mail
							.getEmail() + "@" + mail.getHost()));
			// 邮件类型
			if (html) {
				MimeBodyPart mBody = new MimeBodyPart();
				mBody.setContent(
						"<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>"
								+ text, "text/html;charset=utf-8");
				mp.addBodyPart(mBody);

			} else {
				message.setText(text);
			}
			// 设置附件
			if (attach != null) {
				String[] temp = attach.split(",");
				for (String filepath : temp) {
					MimeBodyPart mBody = new MimeBodyPart();
					DataSource dataSource = new FileDataSource(filepath);
					mBody.setDataHandler(new DataHandler(dataSource));
					mBody.setFileName(filepath);
					mp.addBodyPart(mBody);
				}
			}
			// 使用pgp加密 //###
			if (pgp) {
				usePGP();
			}
			// 使用签名 //###
			if (signature) {
				useSignature();
			}

			if (mp.getCount() != 0)
				message.setContent(mp);
			message.setSentDate(new Date());
			// 发送
			Transport.send(message);
			isSend=true;
		}else{
			throw new RuntimeException("连接邮件服务器失败");
		}
		return isSend;
	}
	
	
	/**
	 * 发送邮件（短版）,默认不使用 PGP加密和数字签名
	 * @param subject 主题
	 * @param to 收件人（支持多个收件人，若需多个收件人，使用","隔开）
	 * @param cc 抄送 (支持多个抄送,若需多个抄送，使用“,”隔开)
	 * @param text 正文
	 * @param html 是否为HTML邮件
	 * @return 是否发送成功
	 * @throws Exception 
	 */
	public boolean send(Mail mail,String subject, String to, String cc, String text,
			boolean html) throws Exception {
		return send(mail,subject, to, cc, false, false, text, null, html);
	}

	/**
	 * 连接邮件服务器
	 * @throws Exception 
	 * 
	 * @throws Exception
	 */
	public Boolean connect(final Mail mail, Boolean sendAuth, Boolean debug,
			Boolean ssl) throws Exception {
		Boolean isSuccess = false;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", mail.getSmtphost());// 发送主机
		props.put("mail.mime.charset", "utf-8"); // 字符编码
		if (sendAuth)
			props.put("mail.smtp.auth", "true"); // 发件前需要验证
		if (debug)
			props.put("mail.debug", "true"); // 显示调试信息
		if (ssl) {
			props.put("mail.smtp.starttls.enable", "true"); // 发件需要安全连接
			props.setProperty("mail.imap.socketFactory.class", Mail.SSL_FACTORY); // IMAP
			// provider
			props.setProperty("mail.pop3.socketFactory.class", Mail.SSL_FACTORY); // POP3
			// provider
			props.setProperty("mail.imap.socketFactory.fallback", "false"); // IMAP
			// provider
			props.setProperty("mail.pop3.socketFactory.fallback", "false"); // POP3
			// provider
			// IMAP provider
			props.setProperty("mail.imap.port", "993");
			props.setProperty("mail.imap.socketFactory.port", "993");
			// POP3 provider
			props.setProperty("mail.pop3.port", "995");
			props.setProperty("mail.pop3.socketFactory.port", "995");
		}
		// 会话验证, 采用密码验证类型，以后会加入自动获得验证类型，选择正确的验证
		session = Session.getInstance(props, new Authenticator() {
			//private String user = mail.getUser();
			private String user = mail.getEmail();
			private String password = mail.getPassword();

			// 密码验证方式
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		session.setDebug(debug);
		URLName url = new URLName(mail.getProtocol(), mail.getHost(), -1,
				Mail.BOX_IN, mail.getEmail(), mail.getPassword());
		store = session.getStore(url);
		store.connect();
		isSuccess = true;
		return isSuccess;
	}

	/**
	 * 判断是否连接
	 * 
	 * @return
	 */
	public boolean isConnected() {
		return store != null && store.isConnected();
	}

	/**
	 * 关闭连接
	 */
	public void close() {
		if (isConnected()) {
			try {
				store.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *  通过解析 邮件消息模板，得到消息内容 
	 * @param msgTemp 邮件消息模板 @msgTemp 为一个包含@N的字符串(N 为数字,从0开始)
	 * @param objs 消息参数 @objs 为对象数组
	 * @return 以解析好的邮件内容
	 */
	public static String parseMsgCont(String msgTemp, Object[] objs){
		//msgTemp为一个包含@N (N为数字)
		String str = msgTemp;
		if(objs == null){
			System.err.println("模板参数为空");
			return null;
		}
		
		for(int i=0;i<objs.length;i++){
			str = str.replaceAll("@"+i, (String) objs[i]);
		}
		return str;
	}

	public void usePGP() {

	}

	public void useSignature() {

	}

}
