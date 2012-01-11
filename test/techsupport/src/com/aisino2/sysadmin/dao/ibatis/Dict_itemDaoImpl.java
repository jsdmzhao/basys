package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IDict_itemDao;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;

public class Dict_itemDaoImpl extends BaseDao implements IDict_itemDao {
	/** @param 字典项(t_dict_item) 增加 */
	public Dict_item insertDict_item(Dict_item dict_item){
		return insertCacheDict_item(dict_item);
	}
	
	/** @param 字典项(t_dict_item) 增加 */
	public Dict_item insertCacheDict_item(Dict_item dict_item){
		// TODO: implement
		dict_item.setItem_id(getNextID("Item_id"));
		insert("insertDict_item", dict_item);
		return dict_item;
	}

	/** @param 字典项(t_dict_item) 删除 */
	public int deleteDict_item(Dict_item dict_item){
		// TODO: implement
		return deleteCacheDict_item(dict_item);
	}
	
	/** @param 字典项(t_dict_item) 删除 */
	public int deleteCacheDict_item(Dict_item dict_item){
		// TODO: implement
		return delete("deleteDict_item", dict_item);
	}

	/** @param 字典项(t_dict_item) 修改 */
	public int updateDict_item(Dict_item dict_item){
		// TODO: implement
		return updateCacheDict_item(dict_item);
	}
	
	/** @param 字典项(t_dict_item) 修改 */
	public int updateCacheDict_item(Dict_item dict_item){
		// TODO: implement
		return update("updateDict_item", dict_item);
	}

	/** @param 字典项(t_dict_item) 查询单条 */
	public Dict_item getDict_item(Dict_item dict_item){
		// TODO: implement
		return (Dict_item)queryForObject("getDict_item", dict_item);
	}

	/** @param 字典项(t_dict_item) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if("0".equals(sort))
				sCol = " a.display_name "+ desc;
			else if("1".equals(sort))
				sCol = " a.fact_value "+ desc;
			else if("2".equals(sort))
				sCol = " a.append_value "+ desc;
			else if("3".equals(sort))
				sCol = " a.item_simplepin "+ desc;
			else 
				sCol=" a.sib_order ";
		}else{
			sCol=" a.sib_order ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDict_itemList", map, pageNo,pageSize);
	}
	
	/** @param 字典项(t_dict_item) 分页查询 字典下拉列表*/
	public Page getDropdownListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if("0".equals(sort))
				sCol = " a.display_name "+ desc;
			else if("1".equals(sort))
				sCol = " a.fact_value "+ desc;
			else 
				sCol=" a.fact_value ";
		}else{
			sCol=" a.fact_value ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDict_itemList", map, pageNo,pageSize);
	}

	/** @param 字典项(t_dict_item) 多条查询 */
	public List getListDict_item(Dict_item dict_item){
		// TODO: implement
		return queryForList("getDict_itemListNoPage", dict_item);
	}
	
	/** @param 字典项(t_dict_item) 多条查询 offline用*/
	public List getOfflineDict_item(Dict dict)
	{
		return queryForList("getDict_itemListOffline", dict);
	}

	public List getChildDict_itemListByItemIDAndDictCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return queryForList("getChildDict_itemListByItemIDAndDictCode",dict_item);
	}

	public List getChildDictionaryItemListByItemID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return queryForList("getChildDictionaryItemListByItemID",dict_item);
	}

	public String getDictItemCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return (String) queryForObject("getDictItemCode", dict_item);
	}

	public String getDictItemNameByDcFv(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return (String) queryForObject("getDictItemNameByDcFv", dict_item);
	}

	public List getDictItemNameListByDcFv(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return queryForList("getDictItemNameListByDcFv",dict_item);
	}

	public Dict_item getDictionaryItemByDcAndFvAndSuperII(Dict_item dict_item) {
		// TODO Auto-generated method stub
		  Object obj = queryForObject("getDictionaryItemByDcAndFvAndSuperII", dict_item);
		    return (obj == null) ? null : (Dict_item) obj;
	}

	public Dict_item getDictionaryItemByDictCodeAndFactValue(Dict_item dict_item) {
		// TODO Auto-generated method stub
		 Object obj = queryForObject("getDictionaryItemByDictCodeAndFactValue", dict_item);
		    return (obj == null) ? null : (Dict_item) obj;
	}



	public List getDictionaryItemListByDictID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return queryForList("getDictionaryItemListByDictID",dict_item);
	}

	public Dict_item getParentDictionaryItemBySuperItemID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		 Object obj = queryForObject("getParentDictionaryItemBySuperItemID", dict_item);
		    return (obj == null) ? null : (Dict_item) obj;
	}

	public List getParentDictionaryItemListByDictCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return queryForList("getParentDictionaryItemListByDictCode",dict_item);
	}
	
	/** 获得下一个排序号 */
	public  Dict_item getNextNodeorder(Dict_item dict_item)
	{
		return (Dict_item) queryForObject("getNextSib_order", dict_item);
	}
}
