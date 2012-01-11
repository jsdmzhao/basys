package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyrygzrzDao;
import com.aisino2.publicsystem.domain.Qyrygzrz;

public class QyrygzrzDaoImpl extends BaseDao implements IQyrygzrzDao {
	/** @param 企业人员工作日志(t_qyrygzrz) 增加 */
	public Qyrygzrz insertQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		qyrygzrz.setQyid(getNextID("Qyid"));
		return (Qyrygzrz)insert("insertQyrygzrz", qyrygzrz);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 删除 */
	public int deleteQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return delete("deleteQyrygzrz", qyrygzrz);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 修改 */
	public int updateQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return update("updateQyrygzrz", qyrygzrz);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 查询单条 */
	public Qyrygzrz getQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return (Qyrygzrz)queryForObject("getQyrygzrz", qyrygzrz);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 分页查询  企业端查询*/
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " b.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.gzkssj "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gzjssj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwxx "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("7"))
				sCol = " c.jydz "+ desc;
			else
				sCol = " a.gzrq "+ desc;
		}else{
			sCol=" a.gzrq ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyrygzrzList", map, pageNo,pageSize);
	}
	
	/** @param 企业人员工作日志(t_qyrygzrz) 分页查询  公安端查询*/
	public Page getListForPageGad(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.gzkssj "+ desc;
			else if(sort.equals("3"))
				sCol = " a.gzjssj "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gwxx "+ desc;
			else if(sort.equals("5"))
				sCol = " c.jydz "+ desc;
			else if(sort.equals("6"))
				sCol = " c.qybm "+ desc;
			else if(sort.equals("7"))
				sCol = " c.qymc "+ desc;
			else if(sort.equals("8"))
				sCol = " c.gxdwmc "+ desc;
			else
				sCol = " a.gzrq  "+ desc;
		}else{
			sCol=" a.gzrq  desc ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyrygzrzList", map, pageNo,pageSize);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 多条查询 */
	public List getListQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return queryForList("getQyrygzrzListNoPage", qyrygzrz);
	}
}
