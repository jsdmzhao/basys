package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyzlxxfjDao;
import com.aisino2.publicsystem.domain.Qyzlxxfj;


public class QyzlxxfjDaoImpl extends BaseDao implements IQyzlxxfjDao {
	/** @param 企业质量信息附件(t_qyzlxxfj) 增加 */
	public Qyzlxxfj insertQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		qyzlxxfj.setQyzlxxfjid(getNextID("Qyzlxxfjid"));
		return (Qyzlxxfj)insert("insertQyzlxxfj", qyzlxxfj);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 删除 */
	public int deleteQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return delete("deleteQyzlxxfj", qyzlxxfj);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 修改 */
	public int updateQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return update("updateQyzlxxfj", qyzlxxfj);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 查询单条 */
	public Qyzlxxfj getQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return (Qyzlxxfj)queryForObject("getQyzlxxfj", qyzlxxfj);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyzlxxfjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyzlxxfjList", map, pageNo,pageSize);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 多条查询 */
	public List getListQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return queryForList("getQyzlxxfjListNoPage", qyzlxxfj);
	}
}
