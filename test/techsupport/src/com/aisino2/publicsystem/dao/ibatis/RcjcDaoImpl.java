package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IRcjcDao;
import com.aisino2.publicsystem.domain.Rcjc;

public class RcjcDaoImpl extends BaseDao implements IRcjcDao {
	/** @param 日常检查(t_rcjc) 增加 */
	public Rcjc insertRcjc(Rcjc rcjc){
		// TODO: implement
		int id=getNextID("rcjcid");
		rcjc.setRcjcid(id);
		return (Rcjc)insert("insertRcjc", rcjc);
	}

	/** @param 日常检查(t_rcjc) 删除 */
	public int deleteRcjc(Rcjc rcjc){
		// TODO: implement
		return delete("deleteRcjc", rcjc);
	}

	/** @param 日常检查(t_rcjc) 修改 */
	public int updateRcjc(Rcjc rcjc){
		// TODO: implement
		return update("updateRcjc", rcjc);
	}

	/** @param 日常检查(t_rcjc) 查询单条 */
	public Rcjc getRcjc(Rcjc rcjc){
		// TODO: implement
		return (Rcjc)queryForObject("getRcjc", rcjc);
	}

	/** @param 日常检查(t_rcjc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		String query = (String)map.get("queryOrAdd");
		if("query".equals(query)){
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.jcrq "+ desc;
				else if(sort.equals("1"))
					sCol = " a.lsdw "+ desc;
				else if(sort.equals("2"))
					sCol = " a.jcrxm "+ desc;
				else if(sort.equals("3"))
					sCol = " a.jcrybh "+ desc;
				else if(sort.equals("4"))
					sCol = " a.jcrzw "+ desc;
				else if(sort.equals("5"))
					sCol = " t.qymc "+ desc;
				else
					sCol = " a.jcrq  "+ desc;
			}else{
				sCol="a.jcrq desc";
			}
		}else{
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.jcrq "+ desc;
				else if(sort.equals("1"))
					sCol = " t.qymc "+ desc;
				else if(sort.equals("2"))
					sCol = " a.jcrxm "+ desc;
				else if(sort.equals("3"))
					sCol = " a.lsdw "+ desc;
				else
					sCol = " a.jcrq  "+desc;
			}else{
				sCol="a.jcrq desc";
			}
		}
		map.put("pageSort", sCol);
		return queryForPage("getRcjcList", map, pageNo,pageSize);
	}

	/** @param 日常检查(t_rcjc) 多条查询 */
	public List getListRcjc(Rcjc rcjc){
		// TODO: implement
		return queryForList("getRcjcListNoPage", rcjc);
	}

	public Page getTjListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return queryForPage("getRcjcTjList", map, pageNo,pageSize);
	}

	public Page getTjxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return queryForPage("getRcjcTjxxList", map, pageNo,pageSize);
	}

	public Page getRcjcycyjListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.jcjgmc "+ desc;
			else if(sort.equals("1"))
				sCol = " a.mjjczbh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.jcrq "+ desc;
			else if(sort.equals("3"))
				sCol = " a.jcrybh "+ desc;
			else if(sort.equals("4"))
				sCol = " a.jcrxm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.jcrzw "+ desc;
		}else{
			sCol="a.jcrq desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getRcjcyjList", map, pageNo,pageSize);
	}
	
}
