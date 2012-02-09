package com.aisino2.techsupport.domain;

import java.util.List;

import javax.mail.Store;

public class Mail {
	// IMAP协议
	final static public String PROTOCOL_IMAP = "imap";
	// SMTP发送协议
	final static public String PROTOCOL_SMTP = "smtp";
	// POP3邮件收取协议
	final static public String PROTOCOL_POP = "pop3";
	// 邮件协议
	private String protocol;
	// 收件箱
	final static public String BOX_IN="INBOX";
	// SSL加密协议
	final static public String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	// 服务器主机
	private String host;
	//收件人
	private List<Recipient> recipients;
	
	//用户-发件人
	private String user;
	//密码
	private String password;
	// 需要安全连接
	private Boolean ssl;
	// 发送前验证用户 smtp验证
	private Boolean sendAuth;
	//错误信息
	private String error;
	// 是否显示调试信息
	private boolean debug;
	// smtp 主机默认为host
	private String smtphost;
	//邮件地址-发件人地址
	private String email;
	//邮件主题
	private String subject;
	//附件
	private String attach;
	//邮件内容
	private String content;
	
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getSsl() {
		return ssl;
	}
	public void setSsl(Boolean ssl) {
		this.ssl = ssl;
	}
	public Boolean getSendAuth() {
		return sendAuth;
	}
	public void setSendAuth(Boolean sendAuth) {
		this.sendAuth = sendAuth;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	public String getSmtphost() {
		return smtphost;
	}
	public void setSmtphost(String smtphost) {
		this.smtphost = smtphost;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Recipient> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<Recipient> recipients) {
		this.recipients = recipients;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
