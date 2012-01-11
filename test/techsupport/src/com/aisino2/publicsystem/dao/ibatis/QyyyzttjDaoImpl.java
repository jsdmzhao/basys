package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyyyzttjDao;
import com.aisino2.publicsystem.domain.Qyyyzttj;

public class QyyyzttjDaoImpl extends BaseDao implements IQyyyzttjDao {
	/** @param 企业营业状态统计(t_qyyyzttj) 增加 */
	public Qyyyzttj insertQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		qyyyzttj.setQyyyzttjid(getNextID("Qyyyzttjid"));
		return (Qyyyzttj)insert("insertQyyyzttj", qyyyzttj);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 删除 */
	public int deleteQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return delete("deleteQyyyzttj", qyyyzttj);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 修改 */
	public int updateQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return update("updateQyyyzttj", qyyyzttj);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 查询单条 */
	public Qyyyzttj getQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return (Qyyyzttj)queryForObject("getQyyyzttj", qyyyzttj);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "dsjgdm,fxjdm,gxdwdm ";
		
		map.put("pageSort", sCol);
		return queryForPage("getQyyyzttjList", map, pageNo,pageSize);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 多条查询 */
	public List getListQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return queryForList("getQyyyzttjListNoPage", qyyyzttj);
	}
}
