package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IBldsjksbDao;
import com.aisino2.publicsystem.domain.Bldsjksb;

public class BldsjksbDaoImpl extends BaseDao implements IBldsjksbDao {
	/** @param 闭路电视监控设备(t_bldsjksb) 增加 */
	public Bldsjksb insertBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		//bldsjksb.setQyid(getNextID("Qyid"));
		bldsjksb.setBldsjksbid(getNextID("Bldsjksbid"));
		insert("insertBldsjksb", bldsjksb);
		return bldsjksb;
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 删除 */
	public int deleteBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return delete("deleteBldsjksb", bldsjksb);
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 修改 */
	public int updateBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return update("updateBldsjksb", bldsjksb);
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 查询单条 */
	public Bldsjksb getBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return (Bldsjksb)queryForObject("getBldsjksb", bldsjksb);
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBldsjksbList", map, pageNo,pageSize);
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 多条查询 */
	public List getListBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return queryForList("getBldsjksbListNoPage", bldsjksb);
	}
	
	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 公安端闭路电视监控设备查询*/
	public Page getBldsjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
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
				if(sort.equals("0"))
					sCol = " a.sbxh "+ desc;
				else if(sort.equals("1"))
					sCol = " a.sbmc "+ desc;
				else if(sort.equals("2"))
					sCol = " a.ggxh "+ desc;
				else if(sort.equals("3"))
					sCol = " a.azsl "+ desc;
				else if(sort.equals("4"))
					sCol = " b.qybm "+ desc;
				else if(sort.equals("5"))
					sCol = " b.qymc "+ desc;
				else if(sort.equals("6"))
					sCol = " b.qyzflmc "+ desc;
				else
					sCol = " b.qybm ";
			}else{
				sCol=" b.qybm ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getBldsjksbGadList", map, pageNo,pageSize);
	}
	
	
	/** 公共 视频监控设备 公安端 分页查询 */
	public Page getSpjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc) {
		String sCol=" b.lrsj desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.hylb "+ desc;
			else if(sort.equals("1"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("2"))
				sCol = " a.sbmc "+ desc;
			else if(sort.equals("3"))
				sCol = " a.sccsmc "+ desc;
			else if(sort.equals("4"))
				sCol = " a.ggxh "+ desc;
			else if(sort.equals("5"))
				sCol = " a.azsl "+ desc;
			else if(sort.equals("6"))
				sCol = " a.sflx "+ desc;
			else if(sort.equals("7"))
				sCol = " a.ipdz "+ desc;
		}
		map.put("pageSort", sCol);
		return queryForPage("getSpjksbGadList", map, pageNo,pageSize);
	}
	
	/** @param 闭路电视监控设备查询数量 */
	public Integer getSpjksbCount(Bldsjksb bldsjksb){
		// TODO: implement
		return (Integer)queryForObject("getSpjksbCount", bldsjksb);
	}
}
