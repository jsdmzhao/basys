package com.aisino2.common;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlReader {
	
	
	public static void main(String[] args) throws Exception{
		XmlReader xr = new XmlReader();
	}
	/**
	 * @param filePath
	 * @throws Exception
	 */
	public void testReadXml(String filePath) throws Exception {
		try {
			File file = new File(filePath);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			
			Element databody = root.element("DATABODY");
			Element data = databody.element("DATA");
			List list = data.elements();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 节点数量
	 * @param filePath
	 * @param xpath eg:count(root/message)
	 * @return
	 */
	public static int getNodeCount(String filePath, String xpath) {
		File file = new File(filePath);
		SAXReader reader = new SAXReader();
		int count = 0;
		try {
			Document doc = reader.read(file);
			Number number = doc.numberValueOf(xpath);
			count = number.intValue();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 节点数量
	 * @param Document
	 * @param xpath eg:count(root/message)
	 * @return
	 */
	public static int getNodeCount(Document doc, String xpath) {
		SAXReader reader = new SAXReader();
		Number number = doc.numberValueOf(xpath);
		return number.intValue();
	}
	
	/**
	 * 返回节点 list
	 * @param filePath
	 * @param xpath eg:root/message
	 * @throws DocumentException 
	 */
	public static List getNodeList(String filePath, String xpath) throws Exception {
		File file = new File(filePath);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		List list = doc.selectNodes(xpath);
		return list;
	}
	
	/**
	 * 返回节点 list
	 * @param Document
	 * @param xpath eg:root/message
	 */
	public static List getNodeList(Document doc, String xpath) {
		List list = doc.selectNodes(xpath);
		return list;
	}
	
	public static String getNodeText(Element element,String nodeName){
		String result = "";
		Element temp = element.element(nodeName);
		if(temp!=null){
			result = temp.getText();
		}
		return result;
	}
	/**
	 * 获取 ： <Param name="gsmc">公司名称</Param>这种形式的
	 * @param element
	 * @param paramName
	 * @return
	 */
	public static String getNodeParamText(Element element,String paramName){
		String result = "";
		List tempList = element.selectNodes("Param[@name='"+paramName+"']");
		if(tempList!=null&&!tempList.isEmpty()){
			Element temp =  (Element)tempList.get(0);
			if(temp!=null){
				result = temp.getText();
			}
		}
		return result;
	}
}
