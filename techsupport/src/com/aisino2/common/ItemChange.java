package com.aisino2.common;

import java.util.List;

import com.aisino2.cache.CacheManager;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;

public class ItemChange {
	/**
	 * 代码转换
	 * 
	 * @param codename
	 *            代码表的代码
	 * @param values
	 *            需要转的值
	 * @return 转换后的值
	 */
	public static String codeChange(String codename, String values) {
		String codeValue = "";
		if("".equals(values)||values==null){
			return codeValue;
		}
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(codename);
		dict_item.setFact_value(values);
		List list = CacheManager.getCacheDictitem(dict_item);
		if (list != null && list.size() > 0) {
			codeValue = ((Dict_item) list.get(0)).getDisplay_name();
		}
		return codeValue;
	}
	
	/**
	 * 获取全局参数
	 * 
	 */
	public static String getGlobalpar(String codename) {
		String codeValue = "";
		if("".equals(codename)||codename==null){
			return codeValue;
		}
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode(codename);
		List list = CacheManager.getCacheGlobalpar(globalpar);
		if (list != null && list.size() > 0) {
			codeValue = ((Globalpar) list.get(0)).getGlobalparvalue();
		}
		return codeValue;
	}
}
