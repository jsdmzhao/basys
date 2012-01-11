package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Dict;

public interface IDictService {
	/** @param 字典(t_dict) 增加 */
	Dict insertDict(Dict dict);

	/** @param 字典(t_dict) 删除 */
	boolean deleteDict(Dict dict);

	/** @param 字典(t_dict) 修改 */
	boolean updateDict(Dict dict);

	/** @param 字典(t_dict) 查询单条 */
	Dict getDict(Dict dict);

	/** @param 字典(t_dict) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 字典(t_dict) 多条查询 */
	List getListDict(Dict dict);
	
	
	 /**
	   * 根据字典的dictCode等于“mzgjxzqh9”取得字典代码为'dm_mz','dm_gj(lgy)','dm_xzqh'”的字典，此方法用于离线控件
	   * @param dictionary
	   * @return
	   */
	  List getDictionaryAll(Dict dict);
	  /**
	   * 根据字典编码DictCode取得下级字典
	   * @param dictionary
	   * @return
	   */
	  List getChildrenDictionary(Dict dict);
	  
}
