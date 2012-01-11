package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IAqjcsbDao;
import com.aisino2.publicsystem.domain.Aqjcsb;

public class AqjcsbDaoImpl extends BaseDao implements IAqjcsbDao {
	/** @param 安全检查设备(t_aqjcsb) 增加 */
	public Aqjcsb insertAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		//aqjcsb.setQyid(getNextID("Qyid"));
		aqjcsb.setAnjcsbid(getNextID("Anjcsbid"));
		insert("insertAqjcsb", aqjcsb);
		return aqjcsb;
	}

	/** @param 安全检查设备(t_aqjcsb) 删除 */
	public int deleteAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return delete("deleteAqjcsb", aqjcsb);
	}

	/** @param 安全检查设备(t_aqjcsb) 修改 */
	public int updateAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return update("updateAqjcsb", aqjcsb);
	}

	/** @param 安全检查设备(t_aqjcsb) 查询单条 */
	public Aqjcsb getAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return (Aqjcsb)queryForObject("getAqjcsb", aqjcsb);
	}

	/** @param 安全检查设备(t_aqjcsb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getAqjcsbList", map, pageNo,pageSize);
	}

	/** @param 安全检查设备(t_aqjcsb) 多条查询 */
	public List getListAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return queryForList("getAqjcsbListNoPage", aqjcsb);
	}
	
	/** @param 安全检查设备(t_aqjcsb) 分页查询  安全检查设备信息查询*/
	public Page getAqjcsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
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
					sCol = " a.aqjcsbzlmc "+ desc;
				else if(sort.equals("4"))
					sCol = " a.azsl "+ desc;
				else if(sort.equals("5"))
					sCol = " b.qybm "+ desc;
				else if(sort.equals("6"))
					sCol = " b.qymc "+ desc;
				else
					sCol = " b.qybm ";
			}else{
				sCol=" b.qybm ";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getAqjcsbGadList", map, pageNo,pageSize);
	}
	
	
	/** 公共 技防设备 公安端 分页查询 */
	public Page getjfsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol=" b.lrsj desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.hylb "+ desc;
			else if(sort.equals("1"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("2"))
				sCol = " a.sbmc "+ desc;
			else if(sort.equals("3"))
				sCol = " a.ggxh "+ desc;
			else if(sort.equals("4"))
				sCol = " a.aqjcsbzlmc "+ desc;
		}
		map.put("pageSort", sCol);
		return queryForPage("getJfsbGadList", map, pageNo,pageSize);
	}
	
	/** 技防设备查询数量 */
	public Integer getJfsbCount(Aqjcsb aqjcsb){
		return (Integer)queryForObject("getJfsbCount", aqjcsb);
	}
}
