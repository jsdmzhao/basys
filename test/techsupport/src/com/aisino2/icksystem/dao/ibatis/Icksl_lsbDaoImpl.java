package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIcksl_lsbDao;
import com.aisino2.icksystem.domain.Icksl_lsb;

public class Icksl_lsbDaoImpl extends BaseDao implements IIcksl_lsbDao {
	/** @param IC卡受理临时表(t_icksl_lsb) 增加 */
	public Icksl_lsb insertIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		insert("insertIcksl_lsb", icksl_lsb);
		return icksl_lsb;
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 删除 */
	public int deleteIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return delete("deleteIcksl_lsb", icksl_lsb);
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 修改 */
	public int updateIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return update("updateIcksl_lsb", icksl_lsb);
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 查询单条 */
	public Icksl_lsb getIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return (Icksl_lsb)queryForObject("getIcksl_lsb", icksl_lsb);
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Ickhold desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIcksl_lsbList", map, pageNo,pageSize);
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 多条查询 */
	public List getListIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return queryForList("getIcksl_lsbListNoPage", icksl_lsb);
	}
}
