package com.aisino2.techsupport.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

import com.aisino2.techsupport.domain.Mail;

public interface MailService {
	
	/**单独发送邮件
	 * @param subject 主题
	 * @param to 收件人（支持多个收件人，若需多个收件人，使用","隔开）
	 * @param cc 抄送 (支持多个抄送,若需多个抄送，使用“,”隔开)
	 * @param pgp 是否使用公密钥加密
	 * @param signature 是否使用数字签名
	 * @param text 正文 
	 * @param attach 附件
	 * @param html 是否为HTML邮件
	 * @return 是否发送成功
	 */
	public Boolean send(Mail mail,String subject,String to,String cc,Boolean pgp,Boolean signature,String text,String attach,Boolean html);
	
	
	/**
	 * 发送邮件（短版）,默认不使用 PGP加密和数字签名
	 * @param subject 主题
	 * @param to 收件人（支持多个收件人，若需多个收件人，使用","隔开）
	 * @param cc 抄送 (支持多个抄送,若需多个抄送，使用“,”隔开)
	 * @param text 正文
	 * @param html 是否为HTML邮件
	 * @return 是否发送成功
	 */
	public boolean send(Mail mail,String subject, String to, String cc, String text,boolean html);
	
	/**
	 * 连接邮件服务器
	 * @param mail
	 * @return 是否连接成功
	 */
	public Boolean connect(Mail mail,Boolean sendAuth,Boolean debug,Boolean ssl);
	
	/**
	 * 判断是否连接
	 * @return
	 */
	public boolean isConnected();
	
	/**
	 * 关闭连接
	 */
	public void close();

}
