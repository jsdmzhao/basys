package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IXctbhfDao;
import com.aisino2.basicsystem.domain.Xctbhf;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class XctbhfDaoImpl extends BaseDao implements IXctbhfDao {
	/** @param 协查通报回复(t_xctbhf) 增加 */
	public Xctbhf insertXctbhf(Xctbhf xctbhf){
		// TODO: implement
		xctbhf.setHfid(getNextID("hfid"));
		return (Xctbhf)insert("insertXctbhf", xctbhf);
	}

	/** @param 协查通报回复(t_xctbhf) 删除 */
	public int deleteXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return delete("deleteXctbhf", xctbhf);
	}

	/** @param 协查通报回复(t_xctbhf) 修改 */
	public int updateXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return update("updateXctbhf", xctbhf);
	}

	/** @param 协查通报回复(t_xctbhf) 查询单条 */
	public Xctbhf getXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return (Xctbhf)queryForObject("getXctbhf", xctbhf);
	}

	/** @param 协查通报回复(t_xctbhf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = "c.jsdwmc "+ desc;
			else if (sort.equals("1"))
				sCol = "a.hfnr "+ desc;
			else if (sort.equals("2"))
				sCol = " a.hfsj "+ desc;
			else if (sort.equals("3"))
				sCol = " a.hfnr "+ desc;
			else 
				sCol="a.hfid desc";
		}else{
			sCol="a.hfid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getXctbhfList", map, pageNo,pageSize);
	}

	/** @param 协查通报回复(t_xctbhf) 多条查询 */
	public List getListXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return queryForList("getXctbhfListNoPage", xctbhf);
	}
	
	/** @param 协查通报回复(t_xctbhf) 分页查询 */
	public Page getcsListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = "a.hfnr "+ desc;
			else if (sort.equals("1"))
				sCol = "a.hfsj "+ desc;
			else if (sort.equals("2"))
				sCol = " a.hfnr "+ desc;
			else 
				sCol="a.hfid desc";
		}else{
			sCol="a.hfid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getXctbhfList", map, pageNo,pageSize);
	}
}
