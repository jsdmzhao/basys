package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IQyryskjlDao;
import com.aisino2.icksystem.domain.Qyryskjl;

public class QyryskjlDaoImpl extends BaseDao implements IQyryskjlDao {
	/** @param 企业人员刷卡记录(t_qyryskjl) 增加 */
	public Qyryskjl insertQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		qyryskjl.setSkid(getNextID("Skid"));
		insert("insertQyryskjl", qyryskjl);
		return qyryskjl;
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 删除 */
	public int deleteQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return delete("deleteQyryskjl", qyryskjl);
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 修改 */
	public int updateQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return update("updateQyryskjl", qyryskjl);
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 查询单条 */
	public Qyryskjl getQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return (Qyryskjl)queryForObject("getQyryskjl", qyryskjl);
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 企业端人员工作日志*/
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.kh "+ desc;
			else if(sort.equals("1"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " b.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " b.zhiwu "+ desc;
			else if(sort.equals("4"))
				sCol = " a.sksj "+ desc;
			else
				sCol = " a.skid desc";
		}else{
			sCol="a.skid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryskjlList", map, pageNo,pageSize);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 公安端企业刷卡记录查询*/
	public Page getQyryskjlGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " xmzc "+ desc;
			else if(sort.equals("1"))
				sCol = " xmfzc "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " b.lxdh "+ desc;
			else if(sort.equals("4"))
				sCol = " a.sksj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.scsj "+ desc;
			else
				sCol = " a.skid desc";
		}else{
			sCol="a.skid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryskjlGadList", map, pageNo,pageSize);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 公安端从业人员工作日志*/
	public Page getCyrygzrzForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.kh "+ desc;
			else if(sort.equals("1"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.sksj "+ desc;
			else if(sort.equals("3"))
				sCol = " c.qymc "+ desc;
			else if(sort.equals("4"))
				sCol = " c.gxdwbm "+ desc;
			else
				sCol = " a.skid desc";
		}else{
			sCol="a.skid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyrygzrzList", map, pageNo,pageSize);
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 多条查询 */
	public List getListQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return queryForList("getQyryskjlListNoPage", qyryskjl);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 频繁刷卡*/
	public Page getPfskForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.skcs "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getPfskList", map, pageNo,pageSize);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 频繁刷卡轨迹*/
	public Page getPfskGjForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.sksj "+ desc;
			else if(sort.equals("1"))
				sCol = " a.scsj "+ desc;
			else if(sort.equals("2"))
				sCol = " a.qymc "+ desc;
			else if(sort.equals("3"))
				sCol = " a.gxdwmc "+ desc;
			else
				sCol = " a.sksj desc ";
		}else{
			sCol=" a.sksj desc ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getPfskGjList", map, pageNo,pageSize);
	}
}
