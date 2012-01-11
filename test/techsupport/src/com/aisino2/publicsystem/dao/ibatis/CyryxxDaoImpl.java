package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.ICyryxxDao;
import com.aisino2.publicsystem.domain.Qyryxx;

public class CyryxxDaoImpl extends BaseDao implements ICyryxxDao {
	
	/** @param 从业人员信息(t_qyryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getCyryxxList", map, pageNo, pageSize);
		}
		// TODO: implement
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
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.mzdm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zt "+ desc;
			else if(sort.equals("9"))
				sCol = " c.zkztbs "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxxList", map, pageNo,pageSize);
	}
	
	public Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		// TODO: implement
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
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWtjCyryxxList", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  公安端人员查询*/
	public Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getCyryxxListGad", map, pageNo, pageSize);
		}
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
				sCol = " a.hjdxzqhdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zxbz "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxxListGad", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	public Page getListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getCyryxxListGad", map, pageNo, pageSize);
		}
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
				sCol = " a.hjdxzqhdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxxListGad", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  由场所ID或场所编码获得该场所下从业人员*/
	public Page getQyryxxListByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc)
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
				sCol = " a.cylbdm "+ desc;
			else
				sCol = " a.xm ";
		}else{
			sCol="a.xm";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxListGad", map, pageNo,pageSize);
	}
	/** @param 从业人员信息(t_qyryxx) 分页查询  公安端 删除查询*/
	public Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getCyryxxListGad", map, pageNo, pageSize);
		}
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
				sCol = " a.hjdxzqhdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zxr "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zxsj "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxxListGad", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  企业端人员查询*/
	public Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " d.kh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.mzdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else
				sCol = " a.rzrq ";
		}else{
			sCol="a.rzrq";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxxListQyd", map, pageNo,pageSize);
	}

	/** @param 从业人员信息(t_qyryxx) 分页查询  制卡端关联查询*/
	/*public Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc)
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
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.gj "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol=" a.cyrybh ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxZkdList", map, pageNo,pageSize);
	}*/
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  制卡端关联查询 场所所属人员*/
	/*public Page getListZkdByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc)
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
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.gj "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol=" a.cyrybh ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxZkdList", map, pageNo,pageSize);
	}*/
	
	/** @param 从业人员信息(t_qyryxx) 多条查询 获得未提交从业人员*/
	public List getWtjListQyryxx(Qyryxx qyryxx)
	{
		return queryForList("getWtjQyryxxListNoPage", qyryxx);
	}
	
	/** @param 从业人员信息(t_qyryxx) 多条查询 获得需进行公安人口库比对的人员(只比对国内人员)*/
	public List getDhdQyryxxList(Qyryxx qyryxx)
	{
		return queryForList("getDhdQyryxxList", qyryxx);
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
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.mzdm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zt "+ desc;
			else
				sCol = " a.rzrq ";
		}else{
			sCol="a.rzrq";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxx_lsxxListQyd", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息核查(t_cyryxxhc) 分页查询 */
	public Page getCyryxxhcListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getCyryxxhcList", map, pageNo, pageSize);
		}
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
				sCol = " a.cylb "+ desc;
			else if(sort.equals("4"))
				sCol = " a.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.hcwt "+ desc;
			else if(sort.equals("6"))
				sCol = " a.bdsj "+ desc;
			else if(sort.equals("7"))
				sCol = " a.hczt "+ desc;
			else
				sCol = " a.bdsj desc ";
		}else{
			sCol="a.bdsj desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxxhcList", map, pageNo,pageSize);
	}
	
	/**======================境外人员==============================*/
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询  采集点查询*/
	public Page getJwListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getJwcyryxxList", map, pageNo, pageSize);
		}
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
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gjdm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("8"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getJwcyryxxList", map, pageNo,pageSize);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 人员查询、注销查询*/
	public Page getJwListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getJwcyryxxListGad", map, pageNo, pageSize);
		}
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
				sCol = " a.gj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zxbz "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getJwcyryxxListGad", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集端台账 已采集人员查询询*/
	public Page getYcjCyryListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
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
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.mzdm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zt "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getYcjCyryxxList", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	public Page getJwListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getJwcyryxxListGad", map, pageNo, pageSize);
		}
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
				sCol = " a.gj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getJwcyryxxListGad", map, pageNo,pageSize);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 企业端人员查询*/
	public Page getJwListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " d.kh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gjdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else
				sCol = " a.rzrq ";
		}else{
			sCol="a.rzrq";
		}
		map.put("pageSort", sCol);
		return queryForPage("getJwcyryxxListQyd", map, pageNo,pageSize);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	public Page getJwScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getJwcyryxxListGad", map, pageNo, pageSize);
		}
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
				sCol = " a.gj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zxr "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zxsj "+ desc;
			else
				sCol = " a.cyrybh ";
		}else{
			sCol="a.cyrybh";
		}
		map.put("pageSort", sCol);
		return queryForPage("getJwcyryxxListGad", map, pageNo,pageSize);
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
				sCol = " d.kh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gjdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else
				sCol = " a.rzrq ";
		}else{
			sCol="a.rzrq";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCyryxx_lsxxListQyd", map, pageNo,pageSize);
	}

	/** @param 从业人员信息(t_qyryxx) 分页查询  根据江苏老版14位人员编号查询人员信息 20101109 mds*/
	public Page getQyryxxByOldcyrybh(Map map, int pageNo,int pageSize,String sort,String desc)
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
				sCol = " b.cyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gjdm "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("7"))
				sCol = " c.qymc "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zt "+ desc;
			else
				sCol = " b.cyrybh ";
		}else{
			sCol="b.cyrybh";
		}
		
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxByOldcyrybh", map, pageNo,pageSize);
	}
}
