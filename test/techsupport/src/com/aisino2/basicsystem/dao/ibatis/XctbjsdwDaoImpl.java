package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IXctbjsdwDao;
import com.aisino2.basicsystem.domain.Xctbjsdw;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class XctbjsdwDaoImpl extends BaseDao implements IXctbjsdwDao {
	/** @param 协查通报接收单位(t_xctbjsdw) 增加 */
	public Xctbjsdw insertXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		xctbjsdw.setJsdwid(getNextID("Jsdwid"));
		return (Xctbjsdw)insert("insertXctbjsdw", xctbjsdw);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 删除 */
	public int deleteXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return delete("deleteXctbjsdw", xctbjsdw);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 修改 */
	public int updateXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return update("updateXctbjsdw", xctbjsdw);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 查询单条 */
	public Xctbjsdw getXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return (Xctbjsdw)queryForObject("getXctbjsdw", xctbjsdw);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.bt "+ desc;
			else if (sort.equals("1"))
				sCol = " a.sqsj "+ desc;
			else if (sort.equals("2"))
				sCol = " a.jsdwmc "+ desc;
			else 
				sCol="a.Tbid desc";
		}else{
			sCol="a.sqsj ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getXctbjsdwList", map, pageNo,pageSize);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 多条查询 */
	public List getListXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return queryForList("getXctbjsdwListNoPage", xctbjsdw);
	}
	
	/** @param 协查通报接收单位(t_xctbjsdw) 分页查询 */
	public Page getListForPageHf(Map map, int pageNo,int pageSize,String sort,String desc){
		
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.bt "+ desc;
			else if (sort.equals("1"))
				sCol = " c.hfsj "+ desc;
			else if (sort.equals("2"))
				sCol = " a.jsdwmc "+ desc;
			else 
				sCol="a.Tbid desc";
		}else{
			sCol="c.hfsj desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getXctbjsdwHfList", map, pageNo,pageSize);
		
	}
}
