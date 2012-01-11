package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBjgzDao;
import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BjgzDaoImpl extends BaseDao implements IBjgzDao {
	/** @param 报警规则(t_bjgz) 增加 */
	public Bjgz insertBjgz(Bjgz bjgz){
		// TODO: implement
		bjgz.setBjgzid(getNextID("Bjgzid"));
		return (Bjgz)insert("insertBjgz", bjgz);
	}

	/** @param 报警规则(t_bjgz) 删除 */
	public int deleteBjgz(Bjgz bjgz){
		// TODO: implement
		return delete("deleteBjgz", bjgz);
	}

	/** @param 报警规则(t_bjgz) 修改 */
	public int updateBjgz(Bjgz bjgz){
		// TODO: implement
		return update("updateBjgz", bjgz);
	}

	/** @param 报警规则(t_bjgz) 查询单条 */
	public Bjgz getBjgz(Bjgz bjgz){
		// TODO: implement
		return (Bjgz)queryForObject("getBjgz", bjgz);
	}

	/** @param 报警规则(t_bjgz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBjgzList", map, pageNo,pageSize);
	}

	/** @param 报警规则(t_bjgz) 多条查询 */
	public List getListBjgz(Bjgz bjgz){
		// TODO: implement
		return queryForList("getBjgzListNoPage", bjgz);
	}
}
