package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;

public interface IDict_itemService {
	/** @param 字典项(t_dict_item) 增加 */
	Dict_item insertDict_item(Dict_item dict_item);

	/** @param 字典项(t_dict_item) 删除 */
	boolean deleteDict_item(Dict_item dict_item);

	/** @param 字典项(t_dict_item) 修改 */
	boolean updateDict_item(Dict_item dict_item);

	/** @param 字典项(t_dict_item) 查询单条 */
	Dict_item getDict_item(Dict_item dict_item);

	/** @param 字典项(t_dict_item) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 字典项(t_dict_item) 分页查询 字典下拉列表*/
	Page getDropdownListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 字典项(t_dict_item) 多条查询 */
	List getListDict_item(Dict_item dict_item);
	
	/** @param 字典项(t_dict_item) 多条查询 offline用*/
	List getOfflineDict_item(Dict dict);
	/**
	 * 根据ItemID和DictCode取得子字典项
	 * @param dict_item
	 * @return
	 */
	
	List getChildDict_itemListByItemIDAndDictCode(Dict_item dict_item);
	
	  /**
     * 删除树状
     * @param dictionaryItem
     * @return
     */  
	Dict_item deleteDictionaryItemTreeItem(Dict_item dict_item);
	
	 /**
	   * 根据dict_code和fact_value取得字典项
	   * @param dictionaryItem
	   * @return
	   */
	Dict_item getDictionaryItemByDictCodeAndFactValue(Dict_item dict_item);
	
	 /**
	   * 根据super_item_id取得其父类的字典项
	   * @param dictionaryItem
	   * @return
	   */
	Dict_item getParentDictionaryItemBySuperItemID(Dict_item dict_item);	
	
	  /**
	   * 根据dict_code取得字典项列表，方法名字可能有些误解
	   * @param dictionaryItem
	   * @return
	   */
	  List getParentDictionaryItemListByDictCode(Dict_item dict_item);	
	  
	  /**
	   * 根据dict_code和item_id取得子字典项，当item_id=9999时，item_id不作为查询条件使用
	   * @param dictionaryItem
	   * @return
	   */
	  List getChildDictionaryItemListByItemID(Dict_item dict_item);	
	  
	  /**
	   * 根据dict_code取得字典项list
	   * @param dict_code
	   * @return
	   */
	  List getDIList(Dict_item dict_item);	
		/**
		 * 根据dict_code和factValue取得字典项名字
		 * @param dictCode
		 * @param factValue
		 * @return
		 */
		String getDictItemNameByDcFv(Dict_item dict_item);	
		/**
		 * 根据dictCode和displayName取得字典项的fact_value值
		 * @param condition
		 * @return
		 */
		String getDictItemCode(Dict_item dict_item);	
		/**
		 * 根据dictID取得字典项
		 */
		  List getDictionaryItemListByDictID(Dict_item dict_item);	
		  /**
		   * 根据dict_code和fact_value和super_item_id取得字典项
		   * 查看树型或联动的同一级别下是否已存在此字典项
		   */
		  Dict_item getDictionaryItemByDcAndFvAndSuperII(Dict_item dict_item);	
		  
		  /**
		    * 字典项的上移、下移、置顶、置底
		    * @param dict_item
		    * dict_item.way取值：上移,下移,置顶,置底
		    * @return
		    */
		public  boolean updateDict_itemEditEdOrder(Dict_item dict_item);
		
		/**
		   * 获得下一个排序号
		   * @param dict_item.super_item_id
		   * @return 
		   */
		  Integer getNextNodeorder(Dict_item dict_item);
} 
