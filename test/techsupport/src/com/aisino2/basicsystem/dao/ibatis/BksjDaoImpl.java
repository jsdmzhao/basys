package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBksjDao;
import com.aisino2.basicsystem.domain.Bksj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BksjDaoImpl extends BaseDao implements IBksjDao {
	/** @param 布控手机(t_bksj) 增加 */
	public Bksj insertBksj(Bksj bksj){
		// TODO: implement
		//bksj.setBkwpjbxxid(getNextID("Bkwpjbxxid"));Bksjid
		bksj.setBksjid(getNextID("Bksjid"));
		insert("insertBksj", bksj);
		return bksj;
	}

	/** @param 布控手机(t_bksj) 删除 */
	public int deleteBksj(Bksj bksj){
		// TODO: implement
		return delete("deleteBksj", bksj);
	}

	/** @param 布控手机(t_bksj) 修改 */
	public int updateBksj(Bksj bksj){
		// TODO: implement
		return update("updateBksj", bksj);
	}

	/** @param 布控手机(t_bksj) 查询单条 */
	public Bksj getBksj(Bksj bksj){
		// TODO: implement
		return (Bksj)queryForObject("getBksj", bksj);
	}

	/** @param 布控手机(t_bksj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bkwpjbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBksjList", map, pageNo,pageSize);
	}

	/** @param 布控手机(t_bksj) 多条查询 */
	public List getListBksj(Bksj bksj){
		// TODO: implement
		return queryForList("getBksjListNoPage", bksj);
	}
}
