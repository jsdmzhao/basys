package com.aisino2.techsupport.service.impl;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.domain.Word;
import com.aisino2.techsupport.service.IWord;
import com.aisino2.techsupport.service.TrackingService;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;

@Component
public class WordImpl implements IWord {

	private TrackingService TrackingServiceImpl;
	
	private IUserService userService;
	
	private IDepartmentService departmentService;
	
	private Document document;
	
	public void CreateWord(Word word) throws DocumentException,
			IOException, ParseException {
		//创建文档并且设置纸张大小
		document = new Document(PageSize.A4);
		// 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
		RtfWriter2.getInstance(document, new FileOutputStream(word.getPath()));
		document.open();
		// 设置中文字体
		BaseFont macintosh = BaseFont.createFont(
				"C:\\WINDOWS\\Fonts\\STFANGSO.TTF", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		// 标题字体风格
		Font ThemeFont = new Font(macintosh, 18, Font.BOLD);
		// 设置标题字体的颜色
		ThemeFont.setColor(Color.RED);
		// 正文字体风格
		Font bodyFont = new Font(macintosh, 14, Font.NORMAL);
		// 设置正文字体的颜色
		bodyFont.setColor(56, 94, 15);
		// 创建主题的Phrases对象
		Paragraph theme = new Paragraph(word.getTheme());
		// 将设置好的字体添加到主题的短句上
		theme.setAlignment(Element.ALIGN_CENTER);
		// 将Phrases添加到document文档中
		document.add(theme);
		// 创建Table表格
		Table table = new Table(word.getTableCellSize());// 创建该表格的列数
		int width[] =new int[word.getTableCellSize()];// 每列的单元格的宽度
		for(int i=0;i<word.getTableCellSize();i++){
			width[i]=25;
		}
		table.setWidths(width);// 设置每列所占比例
		table.setWidth(90); // 占页面宽度 90%，相当于html中width属性
		table.setAlignment(Element.ALIGN_CENTER);// 设置该表格中的元素水平方向居中显示
		table.setAlignment(Element.ALIGN_MIDDLE);// 设置该表格中的元素垂直方向纵向居中显示
		table.setAutoFillEmptyCells(true); // 自动填满
		table.setBorderWidth(1); // 边框宽度
		table.setBorderColor(new Color(160, 32, 240)); // 边框颜色
		table.setPadding(2);// 单元格内部的空白距离，相当于html中的cellpadding属性
		table.setSpacing(3);// 单元格之间的间距，相当于html中的cellspacing
		table.setBorder(2);// 边框的宽度
		// 设置表头
		/*Cell haderCell = new Cell(word.getTitle());// 创建单元格
		haderCell.setBackgroundColor(Color.pink);// 设置此单元格的背景色
		haderCell.setHeader(true);// 设置为表头
		haderCell.setColspan(6);// 合并列的列数
		haderCell.setHorizontalAlignment(haderCell.ALIGN_CENTER);// 水平显示的位置
		table.addCell(haderCell);// 将单元格添加到表格中
		table.endHeaders();// 结束表头的设置*/
		/*Font fontChinese = new Font(macintosh, 15, Font.NORMAL, Color.blue);// 设置字体风格
		Cell cell = new Cell(new Phrase("这是一个3行1列合并的表格", fontChinese));// 创建单元格
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		cell.setBorderColor(new Color(255, 215, 0));
		cell.setRowspan(3);// 设置合并的行数
		table.addCell(cell);*/
		//Font fontChinese=new Font(macintosh,15,Font.NORMAL,Color.black);
		if(word.getStatus().equals(Constants.ST_STATUS_GOING)){//进行状态
			//设置第一行第一列
			Cell fRow_firstColumn=new Cell(word.getfRow_firstColumn());//创建但单元格
			table.addCell(fRow_firstColumn);
			//设置第一行第二列
			Cell fRorw_secondColumn=new Cell(word.getfRow_secondColumn());//创建单元格
			fRorw_secondColumn.setColspan(6);
			table.addCell(fRorw_secondColumn);
			//设置第二行第一列
			Cell sRow_firstColumn=new Cell(word.getsRow_firstColumn());
			table.addCell(sRow_firstColumn);
			//设置第二行第二列
			Cell sRow_secondColumn=new Cell(word.getsRow_secondColumn());
			table.addCell(sRow_secondColumn);
			//设置第二行第三列
			Cell sRow_thirdColumn=new Cell(word.getsRow_thirdColumn());
			table.addCell(sRow_thirdColumn);
			//设置第二行第四列
			Cell sRow_fourthColumn=new Cell(word.getsRow_fourthColumn());
			table.addCell(sRow_fourthColumn);
			//设置第二列第五列
			Cell sRow_fifthColumn=new Cell(word.getsRow_fifthColumn());
			table.addCell(sRow_fifthColumn);
			//设置第二行第六列
			Cell sRow_sixthColumn=new Cell(word.getsRow_sixthColumn());
			table.addCell(sRow_sixthColumn);
			//设置第二行第七列
			Cell sRow_seventhColumn=new Cell(word.getsRow_seventhColumn());
			table.addCell(sRow_seventhColumn);
			// 如果技术支持单负责人跨区域有多个，将一张支持单拆分为多N张
			List<SupportTicket> lst=word.getlSupportTicket();
			List<SupportTicket> newLst=new ArrayList<SupportTicket>();
			List<User> newUser=new ArrayList<User>();
			List<User> userList=new ArrayList<User>();
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			for(int i=0;i<lst.size();i++){
				userList=lst.get(i).getLstSupportLeaders();
				for(int j=0;j<userList.size();j++){
					SupportTicket st=new SupportTicket();
					User user=new User();
					user=userList.get(j);
					newUser.add(user);
					st=lst.get(i);
					st.setLstSupportLeaders(newUser);
					newLst.add(st);
				}
			}
			for(int i=0;i<newLst.size();i++){
				Tracking tracking=new Tracking();
				tracking.setStId(newLst.get(i).getId());
				User user=newLst.get(i).getLstSupportLeaders().get(0);
				//tracking.setProcessorId(user.getUserid());
				List<Tracking> trackList=new ArrayList<Tracking>();
				tracking.setStId(newLst.get(i).getId());
				
				trackList.addAll(TrackingServiceImpl.getTrackingList(tracking));
				
				//技术支持单编号
				table.addCell(new Cell(newLst.get(i).getStNo()));
				//技术支持单内容
				table.addCell(new Cell(newLst.get(i).getSupportContent()));
				//支持单负责人
				table.addCell(new Cell(user.getUsername()));
				//负责人所在部门
				Department department=new Department();
				department.setDepartid(user.getDepartid());
				department=departmentService.getDepartment(department);
				table.addCell(new Cell(department.getDepartname()));
				//上次填报时间
				table.addCell(new Cell(format.format(trackList.get(0).getTrackingDate())));
				//上次填报内容
				table.addCell(new Cell(trackList.get(0).getNewProcess()));
				//逾期时间
				Date editTime=format.parse(format.format(trackList.get(0).getTrackingDate()));
				Date now=format.parse(format.format(new Date()));
				long diff=now.getTime()-editTime.getTime();
				long days=diff/(1000 * 60 * 60 * 24);
				table.addCell(new Cell(String.valueOf(days)));
			}
		}else if(word.getStatus().equals(Constants.ST_STATUS_WAIT_FEEDBACK)){//待反馈状态
			//设置第一行第一列
			Cell fRow_firstColumn=new Cell(word.getfRow_firstColumn());//创建但单元格
			table.addCell(fRow_firstColumn);
			//设置第一行第二列
			Cell fRorw_secondColumn=new Cell(word.getfRow_secondColumn());//创建单元格
			fRorw_secondColumn.setColspan(5);
			table.addCell(fRorw_secondColumn);
			//设置第二行第一列
			Cell sRow_firstColumn=new Cell(word.getsRow_firstColumn());
			table.addCell(sRow_firstColumn);
			//设置第二行第二列
			Cell sRow_secondColumn=new Cell(word.getsRow_secondColumn());
			table.addCell(sRow_secondColumn);
			//设置第二行第三列
			Cell sRow_thirdColumn=new Cell(word.getsRow_thirdColumn());
			table.addCell(sRow_thirdColumn);
			//设置第二行第四列
			Cell sRow_fourthColumn=new Cell(word.getsRow_fourthColumn());
			table.addCell(sRow_fourthColumn);
			//设置第二列第五列
			Cell sRow_fifthColumn=new Cell(word.getsRow_fifthColumn());
			table.addCell(sRow_fifthColumn);
			//设置第二行第六列
			Cell sRow_sixthColumn=new Cell(word.getsRow_sixthColumn());
			table.addCell(sRow_sixthColumn);
			// 如果技术支持单负责人跨区域有多个，将一张支持单拆分为多N张
			List<SupportTicket> lst=word.getlSupportTicket();
			List<SupportTicket> newLst=new ArrayList<SupportTicket>();
			List<User> newUser=new ArrayList<User>();
			List<User> userList=new ArrayList<User>();
			DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
			for(int i=0;i<lst.size();i++){
				userList=lst.get(i).getLstSupportLeaders();
				for(int j=0;j<userList.size();j++){
					SupportTicket st=new SupportTicket();
					User user=new User();
					user=userList.get(j);
					newUser.add(user);
					st=lst.get(i);
					st.setLstSupportLeaders(newUser);
					newLst.add(st);
				}
			}
			for(int i=0;i<newLst.size();i++){
				User getUser=new User();
				Tracking tracking=new Tracking();
				tracking.setStId(newLst.get(i).getId());
				//技术支持单编号
				table.addCell(new Cell(newLst.get(i).getStNo()));
				//技术支持单内容
				table.addCell(new Cell(newLst.get(i).getSupportContent()));
				//支持单填报人
				getUser.setUserid(newLst.get(i).getApplicant().getUserid());
				getUser=userService.getUser(getUser);
				table.addCell(new Cell(getUser.getUsername()));
				//支持单负责人
				User user=newLst.get(i).getLstSupportLeaders().get(0);
				table.addCell(new Cell(user.getUsername()));
				//提请反馈时间
//				tracking.setProcessorId(user.getUserid());
//				tracking.setSuperbWhere(" (t.type=0 or t.type=10 or t.type=30) ");//设置查询追踪单子的状态，0-30之间都是处于待反馈状态
				tracking.setStId(newLst.get(i).getId());
				//tracking.setType("40");
				List<Tracking> trackingList=TrackingServiceImpl.getTrackingList(tracking);
				table.addCell(new Cell(format.format(trackingList.get(0).getTrackingDate())));
				//逾期时间
				Date editTime=format.parse(format.format(trackingList.get(0).getTrackingDate()));
				Date now=format.parse(format.format(new Date()));
				long diff=now.getTime()-editTime.getTime();
				long days=diff/(1000 * 60 * 60 * 24);
				table.addCell(new Cell(String.valueOf(days)));
			}
		}else if(word.getStatus().equals("wait_company_appraval")){//审批状态
			
		}
		document.add(table);
	}
	
	
	//关闭文档
	public void close() {
		if(document!=null){
			document.close();
		}
	}



	public TrackingService getTrackingServiceImpl() {
		return TrackingServiceImpl;
	}

	@Resource(name="TrackingServiceImpl")
	public void setTrackingServiceImpl(TrackingService trackingServiceImpl) {
		TrackingServiceImpl = trackingServiceImpl;
	}

	public IUserService getUserService() {
		return userService;
	}

	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public IDepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource(name="departmentService")
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	

}
