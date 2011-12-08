package com.aisino2.sysadmin.dao;
import java.util.List;

import com.aisino2.sysadmin.domain.Dict;
public interface IDictDao {
	/** @param 字典(t_dict) 增加 */
	Dict insertDict(Dict dict);
	
	/** @param 字典(t_dict) 增加 */
	Dict insertCacheDict(Dict dict);

	/** @param 字典(t_dict) 删除 */
	int deleteDict(Dict dict);
	
	/** @param 字典(t_dict) 删除 */
	int deleteCacheDict(Dict dict);

	/** @param 字典(t_dict) 修改 */
	int updateDict(Dict dict);
	
	/** @param 字典(t_dict) 修改 */
	int updateCacheDict(Dict dict);

	/** @param 字典(t_dict) 查询单条 */
	Dict getDict(Dict dict);

	/** @param 字典(t_dict) 分页查询 */
	List getListForPage(Dict map, int pageNo,int pageSize,String sort,String desc);

	/** @param 字典(t_dict) 多条查询 */
	List<Dict> getListDict(Dict dict);
	
	  /**
	   * 根据上级字典编码DictCode取得下级字典
	   * @param dictionary
	   * @return
	   */
	List<Dict> getChildrenDictionary(Dict dict);
	List<Dict> getDictionaryAll(Dict dict);
	  
	  int deleteDictionaryItemByDictionary(Dict dict);
	  
}
