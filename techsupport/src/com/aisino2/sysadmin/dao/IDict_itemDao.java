package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
public interface IDict_itemDao {
	/** @param 字典项(t_dict_item) 增加 */
	Dict_item insertDict_item(Dict_item dict_item);
	
	/** @param 字典项(t_dict_item) 增加 */
	Dict_item insertCacheDict_item(Dict_item dict_item);

	/** @param 字典项(t_dict_item) 删除 */
	int deleteDict_item(Dict_item dict_item);
	
	/** @param 字典项(t_dict_item) 删除 */
	int deleteCacheDict_item(Dict_item dict_item);

	/** @param 字典项(t_dict_item) 修改 */
	int updateDict_item(Dict_item dict_item);
	
	/** @param 字典项(t_dict_item) 修改 */
	int updateCacheDict_item(Dict_item dict_item);

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
	
	Dict_item getDictionaryItemByDictCodeAndFactValue(Dict_item dict_item);
	  
	Dict_item getParentDictionaryItemBySuperItemID(Dict_item dict_item);
	
	
	
	  
	  List getParentDictionaryItemListByDictCode(Dict_item dict_item);
	  
	  List getChildDictionaryItemListByItemID(Dict_item dict_item);
	  String getDictItemNameByDcFv(Dict_item dict_item);
	  String getDictItemCode(Dict_item dict_item);
	  //通过dictid取的字典项信息

	  List getDictionaryItemListByDictID(Dict_item dict_item);
	  /*
	   * 树型字典项或联动字典项取得相同的字典代码及真实值
	   */
	  List getDictItemNameListByDcFv(Dict_item dict_item);
	  
	  /*
	   * 查看树型或联动的同一级别下是否已存在此字典项
	   */
	  Dict_item getDictionaryItemByDcAndFvAndSuperII(Dict_item dict_item);
	  
	  /** 获得下一个排序号 */
	  Dict_item getNextNodeorder(Dict_item dict_item);
}
