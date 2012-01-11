package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IDictDao;
import com.aisino2.sysadmin.domain.Dict;

public class DictDaoImpl extends BaseDao implements IDictDao {
	/** @param 字典(t_dict) 增加 */
	public Dict insertDict(Dict dict){
		return insertCacheDict(dict);
	}
	
	/** @param 字典(t_dict) 增加 */
	public Dict insertCacheDict(Dict dict){
		// TODO: implement
		  //为了离线新增
		dict.setDict_id(getNextID("Dict_id"));
		insert("insertDict", dict);
		return dict;
	}

	/** @param 字典(t_dict) 删除 */
	public int deleteDict(Dict dict){
		// TODO: implement
		return deleteCacheDict(dict);
	}
	
	/** @param 字典(t_dict) 删除 */
	public int deleteCacheDict(Dict dict){
		// TODO: implement
		return delete("deleteDict", dict);
	}

	/** @param 字典(t_dict) 修改 */
	public int updateDict(Dict dict){
		// TODO: implement
		return updateCacheDict(dict);
	}
	
	/** @param 字典(t_dict) 修改 */
	public int updateCacheDict(Dict dict){
		// TODO: implement
		return update("updateDict", dict);
	}

	/** @param 字典(t_dict) 查询单条 */
	public Dict getDict(Dict dict){
		// TODO: implement
	    Object obj = queryForObject("getDict", dict);
	    return (obj == null) ? null : (Dict) obj;
	}

	/** @param 字典(t_dict) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if("0".equals(sort))
				sCol = " a.dict_code "+ desc;
			else if("1".equals(sort))
				sCol = " a.dict_name "+ desc;
			else if("2".equals(sort))
				sCol = " a.super_dict_code "+ desc;
			else if("3".equals(sort))
				sCol = " a.dict_versionid "+ desc;
			else if("4".equals(sort))
				sCol = " a.dict_type "+ desc;
			else 
				sCol="a.Dict_code ";
		}else{
			sCol="a.Dict_code ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDictList", map, pageNo,pageSize);
	}

	/** @param 字典(t_dict) 多条查询 */
	public List getListDict(Dict dict){
		// TODO: implement
		return queryForList("getDictListNoPage", dict);
	}

	public int deleteDictionaryItemByDictionary(Dict dict) {
		// TODO Auto-generated method stub
		return   delete("deleteDictionaryItemByDictionary", dict);
	}

	public List getChildrenDictionary(Dict dict) {
		// TODO Auto-generated method stub
		return queryForList("getChildrenDictionary",dict);
	}

	public List getDictionaryAll(Dict dict) {
		// TODO Auto-generated method stub
		return queryForList("getDictionaryAll", dict);
	}
}
