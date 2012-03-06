package com.aisino2.techsupport.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import com.aisino2.techsupport.domain.Word;
import com.lowagie.text.DocumentException;

public interface IWord {

	/**
	 * 创建word文档
	 * 
	 * @param filePath创建文件的路径
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public void CreateWord(Word word) throws DocumentException,
			IOException, ParseException, IllegalAccessException, InvocationTargetException;
	
	/**
	 * 关闭文档
	 */
	public void close();
}
