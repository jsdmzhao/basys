package com.aisino2.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlCreater {
	public static void main(String[] args) throws Exception {
		XmlCreater xc = new XmlCreater();
		Document doc = xc.creatDocument();
		String result = xc.getXmlStringByXmlObj(doc);
		xc.createXmlFile("F:/QYRZ/abc.xml",result);
		System.out.println("���"+result);
	}

	public Document test() throws Exception {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("root");
		
		Element first1 = root.addElement("message");
		Element first_11 = first1.addElement("name");
		first_11.addText("中国汉字");
		
		Element second = root.addElement("second");
		second.addText("就是好使");
		return doc;
	}
	
	/**
	 * 创建 空 Document
	 */
	public static Document creatDocument(){
		Document doc = DocumentHelper.createDocument();
		return doc;
	}
	/**
	 * 创建根节点
	 */
	public static Element createElement(Document doc,String rootName){
		Element temp = doc.addElement(rootName);
		return temp;
	}
	
	/**
	 * 创建普通节点
	 */
	public static Element createElement(Element fathEle,String eleName){
		Element temp = fathEle.addElement(eleName);
		return temp;
	}
	
	/**
	 * 创建叶子节点
	 */
	public static Element createElement(Element fathEle,String eleName,String text){
		Element temp = createElement(fathEle, eleName);
		if(text==null){
			text = "";
		}
		temp.addText(text);
		return temp;
	}
	
	/**
	 * ���XML生产XML字符串描述
	 */
	public static String getXmlStringByXmlObj(Object doc) throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(baos, format);
		writer.write(doc);
		String result = new String(baos.toByteArray(),"utf-8");
		return result;
	}
	/**
	 * ���XML 根据DOC 生产XML文件
	 */
	public static void createXmlFile(String filePath,Document doc) throws Exception{
		Writer out = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out, format);
		writer.write(doc);
		out.close();
	}
	/**
	 * ��� 根据XML描述 生产XML文件
	 */
	public static void createXmlFile(String filePath,String content) throws Exception{
		Document doc = DocumentHelper.parseText(content);
		createXmlFile(filePath, doc);
	}
	/**
	 * 根据DOC 生产byte数组
	 */
	public static byte[] createByteArrByDoc(Document doc) throws Exception {
		byte[] result = null;
		OutputFormat format = OutputFormat.createPrettyPrint(); //分层 格式
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(doc);
        result = out.toByteArray();
        out.close();
        return result;
	}
	
	/**
	 * A方法追加文件：使用RandomAccessFile
	 * @param fileName 文件名
	 * @param content 追加的内容
	 * @throws Exception 
	 */
	public static void appendMethodA(String fileName, String content, String oldChar, String newChar) throws Exception{
		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			//将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(changeContentChar(content, oldChar, newChar));
			randomFile.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * B方法追加文件：使用FileWriter
	 * @param fileName
	 * @param content
	 */
	public static void appendMethodB(String fileName, String content){
		try {
			//打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void CreatLog(String wjjName,String fileName){
		isNotFindFileCreate(wjjName);
		try {
			File fileXml = new File(fileName);
			fileXml.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void isNotFindFileCreate(String fileName){
		File file = new File(fileName);
		if(!file.exists()){
			try {
				file.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String changeContentChar(String content, String oldChar, String newChar) throws Exception {
		return new String(content.getBytes(oldChar), newChar);
	}
}
