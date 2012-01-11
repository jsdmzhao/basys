package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IKhxxDao;
import com.aisino2.publicsystem.domain.Khxx;

public class KhxxDaoImpl extends BaseDao implements IKhxxDao {
	/** @param 客户信息表(t_khxx) 增加 */
	public Khxx insertKhxx(Khxx khxx){
		// TODO: implement
		khxx.setKhxxid(getNextID("Ggkhxxid"));
		insert("insertKhxx", khxx);
		return khxx;
	}

	/** @param 客户信息表(t_khxx) 删除 */
	public int deleteKhxx(Khxx khxx){
		// TODO: implement
		return delete("deleteKhxx", khxx);
	}

	/** @param 客户信息表(t_khxx) 修改 */
	public int updateKhxx(Khxx khxx){
		// TODO: implement
		return update("updateKhxx", khxx);
	}

	/** @param 客户信息表(t_khxx) 查询单条 */
	public Khxx getKhxx(Khxx khxx){
		// TODO: implement
		return (Khxx)queryForObject("getKhxx", khxx);
	}
	
	/** @param 客户信息表(t_khxx) 查询单条 获得证件号码及国籍代码相同的客户信息中最新一条信息*/
	public Khxx getLatestKhxx(Khxx khxx)
	{
		return (Khxx)queryForObject("getLatestKhxx", khxx);
	}

	/** @param 客户信息表(t_khxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Khxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getKhxxList", map, pageNo,pageSize);
	}

	/** @param 客户信息表(t_khxx) 多条查询 */
	public List getListKhxx(Khxx khxx){
		// TODO: implement
		return queryForList("getKhxxListNoPage", khxx);
	}
	

	/** @param 客户信息表(t_khxx) 多条查询  判断客户是否存在*/
	public List isKhxxExist(Khxx khxx){
		// TODO: implement
		return queryForList("isKhxxExist", khxx);
	}
}
