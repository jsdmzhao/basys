package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IXctbDao;
import com.aisino2.basicsystem.domain.Xctb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class XctbDaoImpl extends BaseDao implements IXctbDao {
	
	Xctb_fjDaoImpl xctb_fjDao;
	XctbjsdwDaoImpl xctbjsdwDao;
	XctbhfDaoImpl xctbhfDao;
	
	public void setXctb_fjDao(Xctb_fjDaoImpl xctb_fjDao) {
		this.xctb_fjDao = xctb_fjDao;
	}

	public void setXctbhfDao(XctbhfDaoImpl xctbhfDao) {
		this.xctbhfDao = xctbhfDao;
	}

	/** @param 协查通报(t_xctb) 增加 */
	public Xctb insertXctb(Xctb xctb){
		// TODO: implement
		xctb.setTbid(getNextID("Tbid"));
		//return (Xctb)insert("insertXctb", xctb);
		Xctb resXctb=(Xctb)insert("insertXctb", xctb);
		
		return xctb;
	}

	/** @param 协查通报(t_xctb) 删除 */
	public int deleteXctb(Xctb xctb){
		// TODO: implement
		return delete("deleteXctb", xctb);
	}

	/** @param 协查通报(t_xctb) 修改 */
	public int updateXctb(Xctb xctb){
		// TODO: implement	
		return update("updateXctb", xctb);
	}

	/** @param 协查通报(t_xctb) 查询单条 */
	public Xctb getXctb(Xctb xctb){
		// TODO: implement
		return (Xctb)queryForObject("getXctb", xctb);
	}

	/** @param 协查通报(t_xctb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = "fbsj "+ desc;
			else if (sort.equals("1"))
				sCol = "fbdw "+ desc;
			else if (sort.equals("2"))
				sCol = "bt "+ desc;
			else if (sort.equals("3"))
				sCol = "fbr "+ desc;
			else 
				sCol="Tbid desc";
		}else{
			sCol="fbsj desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getXctbList", map, pageNo,pageSize);
	}

	/** @param 协查通报(t_xctb) 多条查询 */
	public List getListXctb(Xctb xctb){
		// TODO: implement
		return queryForList("getXctbListNoPage", xctb);
	}

	public List getXctbListForBt(Map map){
		return queryForList("getXctbListForBt", map);
	}

	public void setXctbjsdwDao(XctbjsdwDaoImpl xctbjsdwDao) {
		this.xctbjsdwDao = xctbjsdwDao;
	}
	
	/** @param 协查通报(t_xctb) 多条查询 查询未阅读的协查通报*/
	public List getXctbWydList(Xctb xctb)
	{
		return queryForList("getXctbWydList", xctb);
	}
	
	
	/** @param 协查通报场所(t_xctb) 分页查询 */
	public Page getcsListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.fbsj "+ desc;
			else if (sort.equals("1"))
				sCol = " a.fbdw "+ desc;
			else if (sort.equals("2"))
				sCol = " a.bt "+ desc;
			else if (sort.equals("3"))
				sCol = " a.fbr "+ desc;
			else 
				sCol="a.Tbid desc";
		}else{
			sCol="a.Tbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getXctbcsList", map, pageNo,pageSize);
	}
	
     /**
     * @param 协查通报企业单位
     *            (t_xctb) 分页查询
     */
    public Page getQydwListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
	String sCol = "";
	if (sort != null) {
	    sCol = "qybm desc";
	} else {
	    sCol = "qybm desc";
	}
	map.put("pageSort", sCol);
	return queryForPage("getXctbQydwList", map, pageNo, pageSize);
    }
    
    /** @param 协查通报企业单位(t_xctb) 列表查询 */
    public List getQydwList(Map map){
	return queryForList("getQydwList", map);
    }
}
