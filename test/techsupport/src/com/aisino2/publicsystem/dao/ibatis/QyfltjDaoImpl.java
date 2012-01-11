package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyfltjDao;
import com.aisino2.publicsystem.domain.Qyfltj;

public class QyfltjDaoImpl extends BaseDao implements IQyfltjDao {
	/** @param 企业分类统计(t_qyfltj) 增加 */
	public Qyfltj insertQyfltj(Qyfltj qyfltj){
		// TODO: implement
		qyfltj.setQyfltjid(getNextID("Qyfltjid"));
		return (Qyfltj)insert("insertQyfltj", qyfltj);
	}

	/** @param 企业分类统计(t_qyfltj) 删除 */
	public int deleteQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return delete("deleteQyfltj", qyfltj);
	}

	/** @param 企业分类统计(t_qyfltj) 修改 */
	public int updateQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return update("updateQyfltj", qyfltj);
	}

	/** @param 企业分类统计(t_qyfltj) 查询单条 */
	public Qyfltj getQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return (Qyfltj)queryForObject("getQyfltj", qyfltj);
	}

	/** @param 企业分类统计(t_qyfltj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "dsjgdm,fxjdm,gxdwdm ";
		/*if (sort != null) {
		   if (sort.equals("1"))
				sCol = "hjT ";
			else if (sort.equals("2"))
				sCol = "gwylT ";
			else if (sort.equals("3"))
				sCol = "yysdzyxtT ";
			else if (sort.equals("4"))
				sCol = "qtylcsT ";
			else if (sort.equals("5"))
				sCol = "snxyamT ";
			else if (sort.equals("6"))
				sCol = "mrmfzyT ";
			else if (sort.equals("7"))
				sCol = "qtfwcsT ";
			else if (sort.equals("8"))
				sCol = "hj ";
			else if (sort.equals("9"))
				sCol = "gwyl ";
			else if (sort.equals("10"))
				sCol = "yysdzyxt ";
			else if (sort.equals("11"))
				sCol = "qtylcs ";
			else if (sort.equals("12"))
				sCol = "snxyam ";
			else if (sort.equals("13"))
				sCol = "mrmfzy ";
			else if (sort.equals("14"))
				sCol = "qtfwcs ";
		}
		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";*/
		
		map.put("pageSort", sCol);
		return queryForPage("getQyfltjList", map, pageNo,pageSize);
	}

	/** @param 企业分类统计(t_qyfltj) 多条查询 */
	public List getListQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return queryForList("getQyfltjListNoPage", qyfltj);
	}
	
	/** @param 企业分类统计(t_qyfltj) 分页查询 */
	public Page getListForPageQY(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "dsjgdm,fxjdm,gxdwdm ";
		map.put("pageSort", sCol);
		return queryForPage("getQyflzstjList", map, pageNo,pageSize);
	}
}
