package com.aisino2.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;








	/**
	* 取消DTD的验证
	* @author 
	*
	*/
	public class NullEntityResolver implements EntityResolver {
	  static String emptyDtd = "";
 	  static ByteArrayInputStream byteIs = new ByteArrayInputStream(emptyDtd.getBytes());

	/**
	* @see org.xml.sax.EntityResolver#resolveEntity(java.lang.String, java.lang.String)
	*/
	

	public InputSource resolveEntity(String publicId, String systemId)
			throws SAXException, IOException {
		// TODO Auto-generated method stub
		 return new InputSource(byteIs);
	}


	}


