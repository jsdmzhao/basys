package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBjxxbDao;
import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BjxxbDaoImpl extends BaseDao implements IBjxxbDao {
	/**
	 * @param 报警信息表(t_bjxxb)
	 *            增加
	 */
	public Bjxxb insertBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		bjxxb.setBjxxid(getNextID("Bjxxid"));
		return (Bjxxb) insert("insertBjxxb", bjxxb);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            删除
	 */
	public int deleteBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return delete("deleteBjxxb", bjxxb);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            修改
	 */
	public int updateBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return update("updateBjxxb", bjxxb);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            查询单条
	 */
	public Bjxxb getBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return (Bjxxb) queryForObject("getBjxxb", bjxxb);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
		// TODO: implement
		String sCol = "a.bjsj ";
		if (sort != null) {
			int sortCol = Integer.valueOf(sort).intValue();

			switch (sortCol) {
			case 0:
				sCol = "a.XM ";
				break;
			case 1:
				sCol = "a.GMSFHM ";
				break;
			case 2:
				sCol = "a.SSQYMC ";
				break;
			case 3:
				sCol = "a.GXDWBM ";
				break;
			case 4:
				sCol = "a.BJSJ ";
				break;
			case 5:
				sCol = "a.BJLXDM ";
				break;
			case 6:
				sCol = "a.SFYXBJDM ";
				break;	
			case 7:
				sCol = "a.JQZTDM ";
				break;
			case 8:
				sCol = "a.CJJGDM ";
				break;
			default:
				break;
			}
		} else {
			sCol = "a.BJSJ ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		return queryForPage("getBjxxbList", map, pageNo, pageSize);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            多条查询
	 */
	public List getListBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return queryForList("getBjxxbListNoPage", bjxxb);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            查询快照表名称
	 */
	public Map getKzbmc(Bjxxb bjxxb) {
		return (Map) queryForObject("getKzbmc", bjxxb);
	}
	
	/** @param 报警信息表(t_bjxxb) 分页查询 主页面 */
	public Page getMainListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol = "a.bjsj ";
		if (sort != null) {
			int sortCol = Integer.valueOf(sort).intValue();

			switch (sortCol) {
			case 0:
				sCol = "a.XM ";
				break;
			case 1:
				sCol = "a.ssqymc ";
				break;
			case 2:
				sCol = "a.gxdwmc ";
				break;
			case 3:
				sCol = "a.BJSJ ";
				break;
			default:
				break;
			}
		} else {
			sCol = "a.BJSJ ";
		}
		
		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		return queryForPage("getBjxxbmainList", map, pageNo, pageSize);
		
	}

	public List getListExportBjxxb(Map map, String sort, String dir) {
		String sCol="a.bjsj desc";
        		
		map.put("pageSort", sCol);
		return queryForList("getListExportBjxxb", map);
	}
	
	/** @param 报警信息表(t_bjxxb) 分页查询 报警客户端得页面 */
	public Page getClientListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		
		String sCol = "a.jqztdm ";
		if (sort != null) {
			int sortCol = Integer.valueOf(sort).intValue();

			switch (sortCol) {
			case 0:
				sCol = "a.XM ";
				break;
			case 1:
				sCol = "a.ssqymc ";
				break;
			case 2:
				sCol = "a.gxdwmc ";
				break;
			case 3:
				sCol = "a.BJSJ ";
				break;
			case 4:
				sCol = "a.sfyxbj ";
				break;
			case 5:
				sCol = "a.jqztdm ";
				break;
			
			default:
				break;
			}
		} else {
			sCol = "a.jqztdm, a.bjsj ";
		}
		
		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";

		map.put("pageSort", sCol);
		
		return queryForPage("getBjxxbClientList", map, pageNo, pageSize);
		
	}
	/** @param 报警信息表(t_bjxxb)条数 */
	public int getBjxxbCount(Map map){
		
		return (Integer)queryForObject("getBjxxbCount", map);
	}
	
	/** ByTy 按照比对规则SQL执行查询，由于身份证重号现象，所以返回报警信息列表 */
	public List getBjxxByBdtjSql(Bjxxb bjxxb)
	{
		return queryForList("getBjxxByBdtjSql", bjxxb);
	}
}
