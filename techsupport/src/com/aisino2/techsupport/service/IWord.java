package com.aisino2.techsupport.service;

import java.io.IOException;
import java.text.ParseException;

import com.aisino2.techsupport.domain.Word;
import com.lowagie.text.DocumentException;

public interface IWord {

	/**
	 * 创建word文档
	 * 
	 * @param filePath创建文件的路径
	 */
	public void CreateWord(Word word) throws DocumentException,
			IOException, ParseException;
}
