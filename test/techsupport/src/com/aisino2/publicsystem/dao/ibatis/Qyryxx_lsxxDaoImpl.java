package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyryxx_lsxxDao;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;

public class Qyryxx_lsxxDaoImpl extends BaseDao implements IQyryxx_lsxxDao {
	/** @param 企业人员历史信息(t_qyryxx_lsxx) 增加 */
	public Qyryxx_lsxx insertQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		qyryxx_lsxx.setRylsid(getNextID("Ggrylsid"));
		insert("insertQyryxx_lsxx", qyryxx_lsxx);
		return qyryxx_lsxx;
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 删除 */
	public int deleteQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return delete("deleteQyryxx_lsxx", qyryxx_lsxx);
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 修改 */
	public int updateQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return update("updateQyryxx_lsxx", qyryxx_lsxx);
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 查询单条 */
	public Qyryxx_lsxx getQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return (Qyryxx_lsxx)queryForObject("getQyryxx_lsxx", qyryxx_lsxx);
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Rylsid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxx_lsxxList", map, pageNo,pageSize);
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 多条查询 */
	public List getListQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return queryForList("getQyryxx_lsxxListNoPage", qyryxx_lsxx);
	}

	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端国内人员历史查询 */
	public Page getCyryxx_lsxxListQydGnForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			
			 if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.mzdm "+ desc;
			else if(sort.equals("4"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("6"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("7"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.rzrq ";
		}else{
			sCol="a.rzrq";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxx_lsxxListQyd", map, pageNo,pageSize);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端境外人员历史查询 */
	public Page getCyryxx_lsxxListQydJwForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			
			 if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.gjdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("5"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.rzrq ";
		}else{
			sCol="a.rzrq";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxx_lsxxListQyd", map, pageNo,pageSize);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 公安端国内人员历史查询 */
	public Page getCyryxx_lsxxListGadGnForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			
			 if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("6"))
				sCol = " a.bcsj "+ desc;
			else if(sort.equals("7"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.bcsj ";
		}else{
			sCol="a.bcsj";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxx_lsxxListGad", map, pageNo,pageSize);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 公安端境外人员历史查询 */
	public Page getCyryxx_lsxxListGadJwForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			
			 if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gjdm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.bcsj "+ desc;
			else if(sort.equals("5"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.bcsj ";
		}else{
			sCol="a.bcsj";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxx_lsxxListGad", map, pageNo,pageSize);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 查询指定从业人员的操作类型为变更的最新一条历史记录 */
	public Qyryxx_lsxx getLatestBgQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx)
	{
		return (Qyryxx_lsxx)queryForObject("getLatestBgQyryxx_lsxx", qyryxx_lsxx);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 查询指定从业人员且操作类型为变更的某条历史记录的下一条记录(即rylsid较大的一条) */
	public Qyryxx_lsxx getNextBgQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx)
	{
		return (Qyryxx_lsxx)queryForObject("getNextBgQyryxx_lsxx", qyryxx_lsxx);
	}
}
