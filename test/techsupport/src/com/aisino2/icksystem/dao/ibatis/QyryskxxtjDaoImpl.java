package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IQyryskxxtjDao;
import com.aisino2.icksystem.domain.Qyryskxxtj;

public class QyryskxxtjDaoImpl extends BaseDao implements IQyryskxxtjDao {
	/** @param 刷卡信息统计明细(t_qyryskxxtj) 增加 */
	public Qyryskxxtj insertQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		qyryskxxtj.setQyryskxxtjmxid(getNextID("Qyryskxxtjid"));
		return (Qyryskxxtj)insert("insertQyryskxxtj", qyryskxxtj);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 删除 */
	public int deleteQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return delete("deleteQyryskxxtj", qyryskxxtj);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 修改 */
	public int updateQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return update("updateQyryskxxtj", qyryskxxtj);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 查询单条 */
	public Qyryskxxtj getQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return (Qyryskxxtj)queryForObject("getQyryskxxtj", qyryskxxtj);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyryskxxtjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryskxxtjList", map, pageNo,pageSize);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 多条查询 */
	public List getListQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return queryForList("getQyryskxxtjListNoPage", qyryskxxtj);
	}

	public Page getStatistics(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.sksj desc";
		}
		dealSjdForMap(map);
		map.put("pageSort", sCol);
		return queryForPage("getStatistics", map, pageNo,pageSize);
	}
	
	/** @param 刷卡信息统计明细(t_qyryskxxtj) 分页查询  公安端 从业轨迹查询*/
	public Page getCygjForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("1"))
				sCol = " a.ssqybm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.ssqygxdwdm "+ desc;
			else
				sCol = " a.rzrq desc ";
		}else{
			sCol=" a.rzrq desc ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCygjList", map, pageNo,pageSize);
	}
	private void dealSjdForMap(Map map) {
		String qssj = (String)map.get("qssj");
		if(qssj != null && !qssj.equalsIgnoreCase(""))
			qssj += " 06:00:00";
		String jzsj = (String)map.get("jzsj");
		if(jzsj != null && !jzsj.equalsIgnoreCase(""))
			jzsj += " 06:00:00";
		map.put("qssj", qssj);
		map.put("jzsj", jzsj);
	}
	/** @param 从业人员信息(t_qyryskxxtj) 分页查询  公安端 频繁变换场所统计查询*/
	public Page getPfbhcsForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		String sCol=" cyrybh desc";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " xm "+ desc;
			else if(sort.equals("2"))
				sCol = " zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " bhNum "+ desc;
			else
				sCol = " cyrybh desc ";
		}else{
			sCol=" cyrybh desc ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getPfbhcsList", map, pageNo,pageSize);
	}

}
