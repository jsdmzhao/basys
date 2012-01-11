package com.aisino2.common;

import java.util.List;

import com.aisino2.cache.CacheManager;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;

public class QjblUtil {
	
	/** 根据全局变量代码 获取全局变量的值 */
	public static String queryQjblVal(String dm){
		String result = "";
		Globalpar glo_temp = new Globalpar();
		Globalpar temp = null;
		List globList_temp = null;
		glo_temp.setGlobalparcode(dm);
		globList_temp = CacheManager.getCacheGlobalpar(glo_temp);
		if(globList_temp!=null&&globList_temp.size()>0){
			temp = (Globalpar)globList_temp.get(0);
			result = temp.getGlobalparvalue();	
		}
		return result;
	}
	
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
		if(values==null)return "";
		String codeValue = "";
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(codename);
		dict_item.setFact_value(values);
		List list = CacheManager.getCacheDictitem(dict_item);
		if (list != null && list.size() > 0) {
			codeValue = ((Dict_item) list.get(0)).getDisplay_name();
		}
		return codeValue;
	}
}
