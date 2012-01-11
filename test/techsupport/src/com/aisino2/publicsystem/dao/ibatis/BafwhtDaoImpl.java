package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IBafwhtDao;
import com.aisino2.publicsystem.domain.Bafwht;

public class BafwhtDaoImpl extends BaseDao implements IBafwhtDao {
	/** @param 保安服务合同(t_bafwht) 增加 */
	public Bafwht insertBafwht(Bafwht bafwht){
		// TODO: implement
		bafwht.setBafwhtid(getNextID("Bafwhtid"));
		insert("insertBafwht", bafwht);
		return bafwht;
	}

	/** @param 保安服务合同(t_bafwht) 删除 */
	public int deleteBafwht(Bafwht bafwht){
		// TODO: implement
		return delete("deleteBafwht", bafwht);
	}

	/** @param 保安服务合同(t_bafwht) 修改 */
	public int updateBafwht(Bafwht bafwht){
		// TODO: implement
		return update("updateBafwht", bafwht);
	}

	/** @param 保安服务合同(t_bafwht) 查询单条 */
	public Bafwht getBafwht(Bafwht bafwht){
		// TODO: implement
		return (Bafwht)queryForObject("getBafwht", bafwht);
	}

	/** @param 保安服务合同(t_bafwht) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bafwhtid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBafwhtList", map, pageNo,pageSize);
	}

	/** @param 保安服务合同(t_bafwht) 多条查询 */
	public List getListBafwht(Bafwht bafwht){
		// TODO: implement
		return queryForList("getBafwhtListNoPage", bafwht);
	}
}
