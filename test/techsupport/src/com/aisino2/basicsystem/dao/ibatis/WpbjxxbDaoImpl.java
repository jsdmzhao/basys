package com.aisino2.basicsystem.dao.ibatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWpbjxxbDao;
import com.aisino2.basicsystem.domain.BaojingTemp;
import com.aisino2.basicsystem.domain.WpbaojingTemp;
import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class WpbjxxbDaoImpl extends BaseDao implements IWpbjxxbDao {
	/** @param 物品报警信息表(t_wpbjxxb) 增加 */
	public Wpbjxxb insertWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		wpbjxxb.setBjxxid2(getNextID("Bjxxid2"));
		wpbjxxb.setBjsj(new Date());
		wpbjxxb.setJqztdm("0");
		wpbjxxb.setJqzt("新报警");
		return (Wpbjxxb)insert("insertWpbjxxb", wpbjxxb);
	}

	/** @param 物品报警信息表(t_wpbjxxb) 删除 */
	public int deleteWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return delete("deleteWpbjxxb", wpbjxxb);
	}

	/** @param 物品报警信息表(t_wpbjxxb) 修改 */
	public int updateWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return update("updateWpbjxxb", wpbjxxb);
	}

	/** @param 物品报警信息表(t_wpbjxxb) 查询单条 */
	public Wpbjxxb getWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return (Wpbjxxb)queryForObject("getWpbjxxb", wpbjxxb);
	}

	/** @param 物品报警信息表(t_wpbjxxb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getWpbjxxbList", map, pageNo, pageSize);
		}
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.wpmc "+ desc;
			else if(sort.equals("1"))
				sCol = " a.ssqymc "+ desc;
			else if(sort.equals("2"))
				sCol = " a.gxdwbm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.bjsj "+ desc;
			else if(sort.equals("4"))
				sCol = " a.bjlxdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.jqztdm "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cjjgdm "+ desc;
			else
				sCol = " a.Bjxxid2 desc ";
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
	
		return queryForPage("getWpbjxxbList", map, pageNo,pageSize);
	}

	/** @param 物品报警信息表(t_wpbjxxb) 多条查询 */
	public List getListWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return queryForList("getWpbjxxbListNoPage", wpbjxxb);
	}
	
	public List getWpBaojingTempList(Wpbjgz wpbjgz, Integer recordNum){
		BaojingTemp bjTemp=new BaojingTemp();
		WpbaojingTemp wpbaojingTemp = new WpbaojingTemp();
		Integer wpbjgzid = wpbjgz.getWpbjgzid();
		String ywb=wpbjgz.getYwbm();
	    String ywbzjzd=wpbjgz.getYwbzdm();
	    String sql="select '"+ywb+"' ywb,'"+ywb+"."+ywbzjzd+"' ywbzjzd,"+ywb+"."+ywbzjzd+" ywbzj  from "
	                +ywb+", t_ddwpxx where "
	                +ywb+".DDWPID = t_ddwpxx.DDWPID and t_ddwpxx.biduiflag = '0' and rownum<="+recordNum.intValue();
	    //System.out.println(sql);
	    wpbaojingTemp.setTempSql(sql);  
	    return queryForList("getWpbaojingTempList",wpbaojingTemp);
		
	}
	
	/**
	 * 照比对规则SQL执行查询，返回报警信息
	 * @param sql
	 * @return
	 */
	public List getWpBaoJingXX(String sql){
		Wpbjxxb wpbjxxb = new Wpbjxxb();
		wpbjxxb.setBdtjSql(sql);
		return  queryForList("getWpbjxxByBdtjSql",wpbjxxb);
	}
}
