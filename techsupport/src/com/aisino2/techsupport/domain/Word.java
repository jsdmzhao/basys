package com.aisino2.techsupport.domain;

import java.util.List;

import com.aisino2.sysadmin.domain.User;

public class Word {
	//文档的名称
	private String name;
	//状态
	private String status;
	//创建文档的路径
	private String path;
	//要创建多少列表格
	private int tableCellSize;
	//文档主题
	private String theme;
	//表格标题
	private String title;
	//第一行第一列的内容
	private String fRow_firstColumn;
	//第一行第二列的内容
	private String fRow_secondColumn;
	//第二行第一列
	private String sRow_firstColumn;
	//第二行第二列
	private String sRow_secondColumn;
	//第二行第三列
	private String sRow_thirdColumn;
	//第二行第四列
	private String sRow_fourthColumn;
	//第二行第五列 
	private String sRow_fifthColumn;
	//第二行第六咧
	private String sRow_sixthColumn;
	//第二行第七咧
	private String sRow_seventhColumn;
	
	private List<SupportTicket> lSupportTicket;
	
	private List<User> userList;
	//邮箱用户名
	private String mail_username;
	//邮箱密码
	private String mail_password;
	//邮箱
	private String mail;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMail_username() {
		return mail_username;
	}
	public void setMail_username(String mail_username) {
		this.mail_username = mail_username;
	}
	public String getMail_password() {
		return mail_password;
	}
	public void setMail_password(String mail_password) {
		this.mail_password = mail_password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public int getTableCellSize() {
		return tableCellSize;
	}
	public void setTableCellSize(int tableCellSize) {
		this.tableCellSize = tableCellSize;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getfRow_firstColumn() {
		return fRow_firstColumn;
	}
	public void setfRow_firstColumn(String fRow_firstColumn) {
		this.fRow_firstColumn = fRow_firstColumn;
	}
	public String getfRow_secondColumn() {
		return fRow_secondColumn;
	}
	public void setfRow_secondColumn(String fRow_secondColumn) {
		this.fRow_secondColumn = fRow_secondColumn;
	}
	public String getsRow_firstColumn() {
		return sRow_firstColumn;
	}
	public void setsRow_firstColumn(String sRow_firstColumn) {
		this.sRow_firstColumn = sRow_firstColumn;
	}
	public String getsRow_secondColumn() {
		return sRow_secondColumn;
	}
	public void setsRow_secondColumn(String sRow_secondColumn) {
		this.sRow_secondColumn = sRow_secondColumn;
	}
	public String getsRow_thirdColumn() {
		return sRow_thirdColumn;
	}
	public void setsRow_thirdColumn(String sRow_thirdColumn) {
		this.sRow_thirdColumn = sRow_thirdColumn;
	}
	public String getsRow_fourthColumn() {
		return sRow_fourthColumn;
	}
	public void setsRow_fourthColumn(String sRow_fourthColumn) {
		this.sRow_fourthColumn = sRow_fourthColumn;
	}
	public String getsRow_fifthColumn() {
		return sRow_fifthColumn;
	}
	public void setsRow_fifthColumn(String sRow_fifthColumn) {
		this.sRow_fifthColumn = sRow_fifthColumn;
	}
	public String getsRow_sixthColumn() {
		return sRow_sixthColumn;
	}
	public void setsRow_sixthColumn(String sRow_sixthColumn) {
		this.sRow_sixthColumn = sRow_sixthColumn;
	}
	
	public String getsRow_seventhColumn() {
		return sRow_seventhColumn;
	}
	public void setsRow_seventhColumn(String sRow_seventhColumn) {
		this.sRow_seventhColumn = sRow_seventhColumn;
	}
	public List<SupportTicket> getlSupportTicket() {
		return lSupportTicket;
	}
	public void setlSupportTicket(List<SupportTicket> lSupportTicket) {
		this.lSupportTicket = lSupportTicket;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
