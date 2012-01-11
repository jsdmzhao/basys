package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.sysadmin.dao.IDict_itemDao;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.service.IDict_itemService;

public class Dict_itemServiceImpl extends BaseService implements IDict_itemService {

	private IDict_itemDao dict_itemDao;
	
	/** @param 字典项(t_dict_item) 增加 内存*/
	public Dict_item insertDict_item(Dict_item dict_item){
		// TODO: implement
		Dict_item dictionaryItem1 = getParentDictionaryItemBySuperItemID(dict_item);
		if(dictionaryItem1 !=null){
		      if ("Y".equals(String.valueOf(dictionaryItem1.getLeaf_flag()))) {
		    	  dictionaryItem1.setLeaf_flag("N");
		    	  dict_itemDao.updateCacheDict_item(dictionaryItem1);
		      }			
		}
		
		if(dict_item.getDisplay_name()!=null)
		{
			if(!"".equals(dict_item.getDisplay_name()))
			{
				dict_item.setItem_allpin(PinYinUtil.getHanyuPingYin(dict_item.getDisplay_name()));
				dict_item.setItem_simplepin(PinYinUtil.getHanyuPingYinInitial(dict_item.getDisplay_name()));
			}
		}
		return (Dict_item)dict_itemDao.insertCacheDict_item(dict_item);
	}
	
	/** @param 字典项(t_dict_item) 删除 内存*/
	public boolean deleteDict_item(Dict_item dict_item){
		// TODO: implement
		return dict_itemDao.deleteCacheDict_item(dict_item)>0;
	}
	
	/** @param 字典项(t_dict_item) 修改 内存*/
	public boolean updateDict_item(Dict_item dict_item){
		// TODO: implement
		if(dict_item.getDisplay_name()!=null)
		{
			if(!"".equals(dict_item.getDisplay_name()))
			{
				dict_item.setItem_allpin(PinYinUtil.getHanyuPingYin(dict_item.getDisplay_name()));
				dict_item.setItem_simplepin(PinYinUtil.getHanyuPingYinInitial(dict_item.getDisplay_name()));
			}
		}
		return dict_itemDao.updateCacheDict_item(dict_item)>0;
	}

	/** @param 字典项(t_dict_item) 查询单条 */
	public Dict_item getDict_item(Dict_item dict_item){
		// TODO: implement
		return (Dict_item)dict_itemDao.getDict_item(dict_item);
	}

	/** @param 字典项(t_dict_item) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return dict_itemDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 字典项(t_dict_item) 分页查询 字典下拉列表*/
	public Page getDropdownListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return dict_itemDao.getDropdownListForPage(map, pageNo, pageSize, sort, desc);
	}

	/** @param 字典项(t_dict_item) 多条查询 */
	public List getListDict_item(Dict_item dict_item){
		// TODO: implement
		return dict_itemDao.getListDict_item(dict_item);
	}
	
	/** @param 字典项(t_dict_item) 多条查询 offline用*/
	public List getOfflineDict_item(Dict dict)
	{
		return dict_itemDao.getOfflineDict_item(dict);
	}

	public IDict_itemDao getDict_itemDao() {
		return dict_itemDao;
	}

	public void setDict_itemDao(IDict_itemDao dict_itemDao) {
		this.dict_itemDao = dict_itemDao;
	}

	public List getChildDict_itemListByItemIDAndDictCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getChildDict_itemListByItemIDAndDictCode(dict_item);
	}

	public Dict_item deleteDictionaryItemTreeItem(Dict_item dict_item) {
		// TODO Auto-generated method stub
		Dict_item parentDictionaryItem = getParentDictionaryItemBySuperItemID(dict_item);
		deleteTreeItem(dict_item);		
		
	    List lst = null;
	    if(parentDictionaryItem != null)
	    	lst =getChildDictionaryItemListByItemID(parentDictionaryItem);
		if(lst != null && lst.isEmpty()){
			parentDictionaryItem.setLeaf_flag("Y");
			updateDict_item(parentDictionaryItem);
		}
		return parentDictionaryItem;
	  }	

	private void deleteTreeItem(Dict_item dict_item){
		  if(dict_item!=null){
			if(dict_item.getLeaf_flag().equals("N")){
				List lst =  getChildDictionaryItemListByItemID(dict_item);
			    for (int i = 0; i < lst.size(); i++) {
			    	deleteTreeItem((Dict_item) lst.get(i));
			    }
			}
			deleteDict_item(dict_item);
		  }
	}
	
	/**
	    * 字典项的上移、下移、置顶、置底
	    * @param dict_item
	    * dict_item.way取值：上移,下移,置顶,置底
	    * @return
	    */
	public  boolean updateDict_itemEditEdOrder(Dict_item dict_itemOrigin)
	{
		boolean isSuccess = false;
		Dict_item dict_item = new Dict_item();
		Dict_item parentDict_item  = new Dict_item();
		Dict_item swapDict_item = new Dict_item();
		int swapSib_order = -1;
		int swapSib_orderTwo = -1;
		Integer item_id = 0;
		//获得dict_item的父节点
		dict_item.setItem_id(dict_itemOrigin.getItem_id());
		dict_item = dict_itemDao.getDict_item(dict_item);
		parentDict_item.setSuper_item_id(dict_item.getSuper_item_id());
		parentDict_item = dict_itemDao.getParentDictionaryItemBySuperItemID(parentDict_item);
		//获得dict_item的所有兄弟节点,包括自身
		if(parentDict_item == null)//若该菜单为顶级菜单，则其父菜单的Super_item_id为0
		{
			parentDict_item = new Dict_item();
			parentDict_item.setItem_id(0);
			parentDict_item.setDict_code(dict_item.getDict_code());
		}
		List siblingList = dict_itemDao.getChildDictionaryItemListByItemID(parentDict_item);
		
		//若无兄弟节点，则无需进行移动操作
		if(siblingList == null)
			return true;
		else if(siblingList.size()==0)
			return true;

		if(dict_itemOrigin !=null)
		{
			item_id = dict_item.getItem_id();
			swapSib_order = dict_item.getSib_order();
			if(item_id != null)
			{
				if(dict_itemOrigin.getWay()!=null)
				{
					for(int i = 0;i<siblingList.size();i++)
					{
						dict_item = (Dict_item)siblingList.get(i);
						if(item_id.equals(dict_item.getItem_id()))
						{
							if(dict_itemOrigin.getWay().equals("上移"))
							{
								if(i>0)//第一个子节点无需上移
								{
									//交换需上移节点与其上一个节点的排序号
									swapDict_item = (Dict_item)siblingList.get(i-1);
									dict_item.setSib_order(swapDict_item.getSib_order());
									swapDict_item.setSib_order(swapSib_order);
									dict_itemDao.updateDict_item(swapDict_item);
									dict_itemDao.updateDict_item(dict_item);
									
								}
								else
									break;
							}
							else if(dict_itemOrigin.getWay().equals("下移"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需下移
								{
									//交换需下移节点与其下一个节点的排序号
									swapDict_item = (Dict_item)siblingList.get(i+1);
									dict_item.setSib_order(swapDict_item.getSib_order());
									swapDict_item.setSib_order(swapSib_order);
									dict_itemDao.updateDict_item(swapDict_item);
									dict_itemDao.updateDict_item(dict_item);
									
								}
								else
									break;
							}
							else if(dict_itemOrigin.getWay().equals("置顶"))
							{
								if(i>0)//第一个子节点无需置顶
								{
									swapDict_item = (Dict_item)siblingList.get(0);
									dict_item.setSib_order(swapDict_item.getSib_order());
									dict_itemDao.updateDict_item(dict_item);
									for(int j = i;j>0;j--)
									{
										swapDict_item = (Dict_item)siblingList.get(j-1);
										swapSib_orderTwo = swapDict_item.getSib_order();
										swapDict_item.setSib_order(swapSib_order);
										dict_itemDao.updateDict_item(swapDict_item);
										swapSib_order = swapSib_orderTwo;
									}
									
								}
								else
									break;
							}
							else if(dict_itemOrigin.getWay().equals("置底"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需置底
								{
									swapDict_item = (Dict_item)siblingList.get(siblingList.size()-1);
									dict_item.setSib_order(swapDict_item.getSib_order());
									dict_itemDao.updateDict_item(dict_item);
									for(int j = i;j<siblingList.size()-1;j++)
									{
										swapDict_item = (Dict_item)siblingList.get(j+1);
										swapSib_orderTwo = swapDict_item.getSib_order();
										swapDict_item.setSib_order(swapSib_order);
										dict_itemDao.updateDict_item(swapDict_item);
										swapSib_order = swapSib_orderTwo;
									}
								}
								else
									break;
							}
						}
					}
				}
			}
		}
		return true;  
	}

	public List getChildDictionaryItemListByItemID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getChildDictionaryItemListByItemID(dict_item);
	}

	public List getDIList(Dict_item dict_item) {
		// TODO Auto-generated method stub

		return dict_itemDao.getParentDictionaryItemListByDictCode(dict_item);		
	}

	public String getDictItemCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getDictItemCode(dict_item);
	}

	public String getDictItemNameByDcFv(Dict_item dict_item) {
		// TODO Auto-generated method stub
		 return dict_itemDao.getDictItemNameByDcFv(dict_item);
	}

	public Dict_item getDictionaryItemByDcAndFvAndSuperII(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getDictionaryItemByDcAndFvAndSuperII(dict_item);
	}

	public Dict_item getDictionaryItemByDictCodeAndFactValue(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getDictionaryItemByDictCodeAndFactValue(dict_item);
	}

	public List getDictionaryItemListByDictID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getDictionaryItemListByDictID(dict_item);
	}

	public Dict_item getParentDictionaryItemBySuperItemID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getParentDictionaryItemBySuperItemID(dict_item);
	}

	public List getParentDictionaryItemListByDictCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return dict_itemDao.getParentDictionaryItemListByDictCode(dict_item);
	}
	
	/**
	   * 获得下一个排序号
	   * @param dict_item.super_item_id
	   * @return 
	*/
	public Integer getNextNodeorder(Dict_item dict_item)
	{
		Integer nextNodeorder = 0;
		Dict_item newDict_item = new Dict_item();
		newDict_item = dict_itemDao.getNextNodeorder(dict_item);
		if(newDict_item != null)
		{
			nextNodeorder = newDict_item.getSib_order();
		}
		return nextNodeorder;
	}
}
