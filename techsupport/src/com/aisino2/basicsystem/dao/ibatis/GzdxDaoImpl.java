package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGzdxDao;
import com.aisino2.basicsystem.domain.Gzdx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class GzdxDaoImpl extends BaseDao implements IGzdxDao {
	/** @param 关注对象(t_gzdx) 增加 */
	public Gzdx insertGzdx(Gzdx gzdx){
		// TODO: implement
		gzdx.setGzdxid(getNextID("Gzdxid"));
		return (Gzdx)insert("insertGzdx", gzdx);
	}

	/** @param 关注对象(t_gzdx) 删除 */
	public int deleteGzdx(Gzdx gzdx){
		// TODO: implement
		return delete("deleteGzdx", gzdx);
	}

	/** @param 关注对象(t_gzdx) 修改 */
	public int updateGzdx(Gzdx gzdx){
		// TODO: implement
		return update("updateGzdx", gzdx);
	}

	/** @param 关注对象(t_gzdx) 查询单条 */
	public Gzdx getGzdx(Gzdx gzdx){
		// TODO: implement
		return (Gzdx)queryForObject("getGzdx", gzdx);
	}

	/** @param 关注对象(t_gzdx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="a.Gzdxid ";
		  if (sort!=null){
		   if (sort.equals("0"))
		    sCol="a.xm ";
		   else if (sort.equals("1"))
		    sCol="a.zjhm ";
		   else if (sort.equals("2"))
		    sCol="a.xb ";
		   else if (sort.equals("3"))
		    sCol="a.csrq ";
		   else if (sort.equals("4"))
		    sCol="a.minzu ";
		   else if (sort.equals("5"))
		    sCol="a.whcd ";
		   else if (sort.equals("6"))
		    sCol="a.hjdxzqh ";
		   else if (sort.equals("7"))
		    sCol="a.hjdxz ";
		  } 
		  if (desc!=null)
		   sCol+=desc;
		  else
		   sCol+=" desc";


		map.put("pageSort", sCol);
		return queryForPage("getGzdxList", map, pageNo,pageSize);
	}

	/** @param 关注对象(t_gzdx) 多条查询 */
	public List getListGzdx(Gzdx gzdx){
		// TODO: implement
		return queryForList("getGzdxListNoPage", gzdx);
	}

	public List validateZjhm(Gzdx gzdx) {
		// TODO Auto-generated method stub
		return queryForList("validateZjhm", gzdx);
	}

	public List getListExportGzdx(Map map, String sort, String desc) {
		String sCol="a.Gzdxid ";
		  if (sort!=null){
		   if (sort.equals("0"))
		    sCol="a.xm ";
		   else if (sort.equals("1"))
		    sCol="a.zjhm ";
		   else if (sort.equals("2"))
		    sCol="a.xb ";
		   else if (sort.equals("3"))
		    sCol="a.csrq ";
		   else if (sort.equals("4"))
		    sCol="a.minzu ";
		   else if (sort.equals("5"))
		    sCol="a.whcd ";
		   else if (sort.equals("6"))
		    sCol="a.hjdxzqh ";
		   else if (sort.equals("7"))
		    sCol="a.hjdxz ";
		  } 
		  if (desc!=null)
		   sCol+=desc;
		  else
		   sCol+=" desc";
		map.put("pageSort", sCol);
		return queryForList("getGzdxListExcel", map);
	}
}
