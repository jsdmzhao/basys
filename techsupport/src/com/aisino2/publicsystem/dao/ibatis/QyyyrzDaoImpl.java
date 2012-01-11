package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyyyrzDao;
import com.aisino2.publicsystem.domain.Qyyyrz;

public class QyyyrzDaoImpl extends BaseDao implements IQyyyrzDao {
	/** @param 企业营业日志(t_qyyyrz) 增加 */
	public Qyyyrz insertQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		qyyyrz.setYyrzid(getNextID("Yyrzid"));
		insert("insertQyyyrz", qyyyrz);
		return qyyyrz;
	}

	/** @param 企业营业日志(t_qyyyrz) 删除 */
	public int deleteQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return delete("deleteQyyyrz", qyyyrz);
	}

	/** @param 企业营业日志(t_qyyyrz) 修改 */
	public int updateQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return update("updateQyyyrz", qyyyrz);
	}

	/** @param 企业营业日志(t_qyyyrz) 查询单条 */
	public Qyyyrz getQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return (Qyyyrz)queryForObject("getQyyyrz", qyyyrz);
	}

	/** @param 企业营业日志(t_qyyyrz) 分页查询 企业端查询，公安端查询*/
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.riqi "+ desc;
			else if(sort.equals("1"))
				sCol = " a.ksyysj "+ desc;
			else if(sort.equals("2"))
				sCol = " a.jsyysj "+ desc;
			else if(sort.equals("3"))
				sCol = " a.csfe "+ desc;
			else if(sort.equals("4"))
				sCol = " a.sffsaj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.sfglbmjc "+ desc;
			else
				sCol = " a.yyrzid desc ";
		}else{
			sCol=" a.yyrzid desc ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyyyrzList", map, pageNo,pageSize);
	}
	
	/** 企业营业日志 公安端查询 标准化公安端*/
	public Page getListForPageYlyBzhGad(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.riqi "+ desc;
			else if(sort.equals("1"))
				sCol = " a.ksyysj "+ desc;
			else if(sort.equals("2"))
				sCol = " a.jsyysj "+ desc;
			else if(sort.equals("3"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("4"))
				sCol = " a.csfe "+ desc;
			else if(sort.equals("5"))
				sCol = " a.sffsaj "+ desc;
			else if(sort.equals("6"))
				sCol = " a.sfglbmjc "+ desc;
			else
				sCol = " a.yyrzid desc ";
		}else{
			sCol=" a.riqi desc ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyyyrzList", map, pageNo,pageSize);
	}
	

	/** @param 企业营业日志(t_qyyyrz) 多条查询 */
	public List getListQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return queryForList("getQyyyrzListNoPage", qyyyrz);
	}
	
	/** @param 企业营业日志(t_qyyyrz) 根据qybm查询负责人信息 */
	public Qyyyrz getQyyyrzFzry(Qyyyrz qyyyrz){
		// TODO: implement
		return (Qyyyrz)queryForObject("getQyyyrzFzry", qyyyrz);
	}
}
