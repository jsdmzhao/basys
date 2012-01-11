package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGatztb_fjDao;
import com.aisino2.basicsystem.domain.Gatztb_fj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class Gatztb_fjDaoImpl extends BaseDao implements IGatztb_fjDao {
	/** @param 公安通知通报_附件(t_gatztb_fj) 增加 */
	public Gatztb_fj insertGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		gatztb_fj.setGafjid(getNextID("Gafjid"));
		return (Gatztb_fj)insert("insertGatztb_fj", gatztb_fj);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 删除 */
	public int deleteGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return delete("deleteGatztb_fj", gatztb_fj);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 修改 */
	public int updateGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return update("updateGatztb_fj", gatztb_fj);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 查询单条 */
	public Gatztb_fj getGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return (Gatztb_fj)queryForObject("getGatztb_fj", gatztb_fj);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Gatbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGatztb_fjList", map, pageNo,pageSize);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 多条查询 */
	public List getListGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return queryForList("getGatztb_fjListNoPage", gatztb_fj);
	}
}
