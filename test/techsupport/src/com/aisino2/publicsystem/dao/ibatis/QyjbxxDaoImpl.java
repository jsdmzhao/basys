package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.domain.Qyjbxx;

public class QyjbxxDaoImpl extends BaseDao implements IQyjbxxDao {
	/** @param 企业基本信息(t_qyjbxx) 增加 */
	public Qyjbxx insertQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		qyjbxx.setQyid(getNextID("Qyid"));
		insert("insertQyjbxx", qyjbxx);
		return qyjbxx;
	}

	/** @param 企业基本信息(t_qyjbxx) 删除 */
	public int deleteQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		return delete("deleteQyjbxx", qyjbxx);
	}

	/** @param 企业基本信息(t_qyjbxx) 修改 */
	public int updateQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		return update("updateQyjbxx", qyjbxx);
	}

	/** @param 企业基本信息(t_qyjbxx) 查询单条 */
	public Qyjbxx getQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		return (Qyjbxx)queryForObject("getQyjbxx", qyjbxx);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 采集点提交  */
	public Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		}else{
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("1"))
					sCol = " a.qybm "+ desc;
				else if(sort.equals("2"))
					sCol = " a.qymc "+ desc;
				else if(sort.equals("3"))
					sCol = " a.jjlxbm "+ desc;
				else if(sort.equals("4"))
					sCol = " a.zrs "+ desc;
				else if(sort.equals("5"))
					sCol = " a.lxdh "+ desc;
				else if(sort.equals("6"))
					sCol = " a.zt "+ desc;
				else
					sCol = " a.lrsj desc ";
			}else{
				sCol="a.lrsj desc ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getQyjbxxList", map, pageNo,pageSize);
	}

	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业管理页面*/
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		}else{
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.qybm "+ desc;
				else if(sort.equals("1"))
					sCol = " a.qymc "+ desc;
				else if(sort.equals("2"))
					sCol = " a.jjlxbm "+ desc;
				else if(sort.equals("3"))
					sCol = " a.zrs "+ desc;
				else if(sort.equals("4"))
					sCol = " a.lxdh "+ desc;
				else if(sort.equals("5"))
					sCol = " a.zt "+ desc;
				else if(sort.equals("6"))
					sCol = " a.zjztdm "+ desc;
				else
					sCol = " a.lrsj desc ";
			}else{
				sCol="a.lrsj desc ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getQyjbxxList", map, pageNo,pageSize);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业核查(即信息确认)*/
	public Page getListForPageHc(Map map, int pageNo,int pageSize,String sort,String desc){
		
		// TODO: implement
		String sCol="";
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		}else{
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.qybm "+ desc;
				else if(sort.equals("1"))
					sCol = " a.qymc "+ desc;
				else if(sort.equals("2"))
					sCol = " a.zrs "+ desc;
				else if(sort.equals("3"))
					sCol = " a.qyzflbm "+ desc;
				else if(sort.equals("4"))
					sCol = " a.zt "+ desc;
				else
					sCol = " a.lrsj desc  ";
			}else{
				sCol="a.lrsj desc ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getQyjbxxList", map, pageNo,pageSize);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  公安端企业查询*/
	public Page getListForPageQycx(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		}else{
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.qybm "+ desc;
				else if(sort.equals("1"))
					sCol = " a.qymc "+ desc;
				else if(sort.equals("2"))
					sCol = " a.zrs "+ desc;
				else if(sort.equals("3"))
					sCol = " a.qyzflbm "+ desc;
				else if(sort.equals("4"))
					sCol = " a.yyztdm "+ desc;
				else if(sort.equals("5"))
					sCol = " a.zjztmc "+ desc;
				else if(sort.equals("6"))
					sCol = " a.zabdm "+ desc;
				else
					sCol = " a.lrsj desc  ";
			}else{
				sCol="a.lrsj desc ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getQyjbxxList", map, pageNo,pageSize);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更、注销*/
	public Page getListForPageQybg(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		}else{
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.qybm "+ desc;
				else if(sort.equals("1"))
					sCol = " a.qymc "+ desc;
				else if(sort.equals("2"))
					sCol = " a.zrs "+ desc;
				else if(sort.equals("3"))
					sCol = " a.qyzflbm "+ desc;
				else if(sort.equals("4"))
					sCol = " a.gxdwmc "+ desc;
				else
					sCol = " a.lrsj desc  ";
			}else{
				sCol="a.lrsj desc ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getQyjbxxList", map, pageNo,pageSize);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更详情*/
	public Page getListForPageQybgxq(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		}else{
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.qybm "+ desc;
				else if(sort.equals("1"))
					sCol = " a.qymc "+ desc;
				else if(sort.equals("2"))
					sCol = " a.zrs "+ desc;
				else if(sort.equals("3"))
					sCol = " a.qyzflbm "+ desc;
				else if(sort.equals("4"))
					sCol = " a.bcsj "+ desc;
				else
					sCol = " a.bcsj desc  ";
			}else{
				sCol=" a.bcsj desc ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getQybgxqList", map, pageNo,pageSize);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 制卡端关联查询*/
	public Page getListForPageZkd(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.qybm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.qymc "+ desc;
			else if(sort.equals("2"))
				sCol = " a.frdb "+ desc;
			else if(sort.equals("3"))
				sCol = " a.zt "+ desc;
			else
				sCol = " a.lrsj desc   ";
		}else{
			sCol=" a.lrsj desc  ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyjbxxListZkd", map, pageNo,pageSize);
	}

	/** @param 企业基本信息(t_qyjbxx) 多条查询 */
	public List getListQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		return queryForList("getQyjbxxListNoPage", qyjbxx);
	}
	
	/**
	 * 判断企业是否已存在
	 * @param qyjbxx(qyid,zjbh)
	 */
	public Qyjbxx isQyjbxxExist(Qyjbxx qyjbxx)
	{
		return (Qyjbxx)queryForObject("isQyjbxxExist", qyjbxx);
	}
	
	/**  获取 基本的企业信息项目 */
	public Qyjbxx getQyjbxxXiangMu(Qyjbxx qyjbxx){
		return (Qyjbxx)queryForObject("getQyjbxxXiangMu", qyjbxx);
	}
	
	/** 根据企业主分类 公安端查询场所数量 娱乐业标准化 */
	public List getQyzflCountList(Map map){
		return queryForList("getQyzflCountList", map);
	}
	/** 待核查场所数 娱乐业标准化 */
	public int getDhccsCount(Map map){
		return ((Integer)queryForObject("getQyjbxxListCount", map)).intValue();
	}
}
