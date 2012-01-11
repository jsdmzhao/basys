package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IRylbtjDao;
import com.aisino2.publicsystem.domain.Rylbtj;

public class RylbtjDaoImpl extends BaseDao implements IRylbtjDao {
	/** @param 人员类别统计(t_rylbtj) 增加 */
	public Rylbtj insertRylbtj(Rylbtj rylbtj){
		// TODO: implement
		rylbtj.setRybtjid(getNextID("Rybtjid"));
		return (Rylbtj)insert("insertRylbtj", rylbtj);
	}

	/** @param 人员类别统计(t_rylbtj) 删除 */
	public int deleteRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return delete("deleteRylbtj", rylbtj);
	}

	/** @param 人员类别统计(t_rylbtj) 修改 */
	public int updateRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return update("updateRylbtj", rylbtj);
	}

	/** @param 人员类别统计(t_rylbtj) 查询单条 */
	public Rylbtj getRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return (Rylbtj)queryForObject("getRylbtj", rylbtj);
	}

	/** @param 人员类别统计(t_rylbtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "dsjgdm,fxjdm,gxdwdm,qybm ";
/*		if (sort != null) {
		   if (sort.equals("1"))
				sCol = "glryT ";
			else if (sort.equals("2"))
				sCol = "fwryT ";
			else if (sort.equals("3"))
				sCol = "baryT ";
			else if (sort.equals("4"))
				sCol = "aqjcryT ";
			else if (sort.equals("5"))
				sCol = "qtT ";
			else if (sort.equals("6"))
				sCol = "hjT ";
			else if (sort.equals("7"))
				sCol = "glry ";
			else if (sort.equals("8"))
				sCol = "fwry ";
			else if (sort.equals("9"))
				sCol = "bary ";
			else if (sort.equals("10"))
				sCol = "aqjcry ";
			else if (sort.equals("11"))
				sCol = "qt ";
			else if (sort.equals("12"))
				sCol = "hj ";
		}
		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";*/

		map.put("pageSort", sCol);
		return queryForPage("getRylbtjList", map, pageNo,pageSize);
	}

	/** @param 人员类别统计(t_rylbtj) 多条查询 */
	public List getListRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return queryForList("getRylbtjListNoPage", rylbtj);
	}
	
	/** @param 人员类别统计(t_rylbtj) 信息采集 */
	public Page getListForPageRY(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "dsjgdm,fxjdm,gxdwdm";
		map.put("pageSort", sCol);
		return queryForPage("getRyhylbtjList", map, pageNo,pageSize);
	}
}
