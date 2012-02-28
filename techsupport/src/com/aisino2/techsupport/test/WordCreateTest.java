package com.aisino2.techsupport.test;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Word;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;

public class WordCreateTest {
	public static void main(String[] args) throws DocumentException, IOException{
		
		Document document = new Document(PageSize.A4);
		RtfWriter2.getInstance(document, new FileOutputStream("e:/test.doc"));
		//读取word文档配置信息
		Properties properties=new Properties();
		InputStream in = WordCreateTest.class.getClassLoader().getResourceAsStream("word.properties");
		properties.load(in);
		Word word=new Word();
		word.setfRow_firstColumn(new String(properties.getProperty("going_fRow_firstColumn")));
		word.setfRow_secondColumn(new SimpleDateFormat("yyyy年MM月dd日 ").format(new Date()));
		word.setsRow_firstColumn(new String(properties.getProperty("going_sRow_firstColumn")));
		word.setsRow_secondColumn(new String(properties.getProperty("going_sRow_secondColumn")));
		word.setsRow_thirdColumn(new String(properties.getProperty("going_sRow_thirdColumn")) );
		word.setsRow_fourthColumn(new String(properties.getProperty("going_sRow_fourthColumn")));
		word.setsRow_fifthColumn(new String(properties.getProperty("going_sRow_fifthColumn")));
		word.setsRow_sixthColumn(new String(properties.getProperty("going_sRow_sixthColumn")));
		word.setsRow_seventhColumn(new String(properties.getProperty("going_sRow_seventhColumn")));
		word.setTableCellSize(Integer.valueOf(new String(properties.getProperty("going_tableCloumnSize"))));
		word.setTheme(new String(properties.getProperty("going_theam")));
		document.open();
//		字体
		BaseFont macintosh = BaseFont.createFont(
				"C:\\WINDOWS\\Fonts\\STFANGSO.TTF", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		Font ThemeFont = new Font(macintosh, 18, Font.BOLD);
		// 设置标题字体的颜色
		ThemeFont.setColor(Color.RED);
		// 正文字体风格
		Font bodyFont = new Font(macintosh, 7, Font.NORMAL);
		// 设置正文字体的颜色
		bodyFont.setColor(Color.gray);
		// 创建主题的Phrases对象
		Paragraph theme = new Paragraph("反馈逾期人员列表",ThemeFont);
		// 将设置好的字体添加到主题的短句上
		theme.setAlignment(Element.ALIGN_CENTER);
		// 将Phrases添加到document文档中
		document.add(theme);
		// 创建Table表格
		Table table = new Table(word.getTableCellSize());// 创建该表格的列数
		int width[] =new int[word.getTableCellSize()];// 每列的单元格的宽度
		for(int i=0;i<word.getTableCellSize();i++){
			width[i]=30;
		}
		table.setWidths(width);// 设置每列所占比例
		table.setWidth(90); // 占页面宽度 90%，相当于html中width属性
		table.setAlignment(Element.ALIGN_CENTER);// 设置该表格中的元素水平方向居中显示
		table.setAlignment(Element.ALIGN_MIDDLE);// 设置该表格中的元素垂直方向纵向居中显示
		table.setAutoFillEmptyCells(true); // 自动填满
		table.setBorderWidth(3); // 边框宽度
		table.setBorderColor(new Color(160, 32, 240)); // 边框颜色
		table.setPadding(2);// 单元格内部的空白距离，相当于html中的cellpadding属性
		table.setSpacing(1);// 单元格之间的间距，相当于html中的cellspacing
		//设置第一行第一列
		Cell fRow_firstColumn=new Cell(new Paragraph(word.getfRow_firstColumn(), bodyFont));//创建但单元格
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
		
		document.add(table);
		document.close();
	}
}
