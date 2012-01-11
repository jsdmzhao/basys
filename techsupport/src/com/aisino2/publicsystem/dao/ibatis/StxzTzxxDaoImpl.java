package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IStxzTzxxDao;
import com.aisino2.publicsystem.domain.StxzTzxx;

public class StxzTzxxDaoImpl extends BaseDao implements IStxzTzxxDao {

	/** @param 省厅刑侦台帐信息 多条查询 */
	public List getListStxzTzxx(StxzTzxx stxzTzxx){
		return queryForList("getStxztzxxListNoPage", stxzTzxx);
	}

	
	/** @param 所有企业信息(企业总数、从业人员总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	public Page getListAllQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol = " a.qyid	 desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.qybm " + desc +"," + sCol;
			else if(sort.equals("1"))
				sCol = " a.qymc " + desc +"," + sCol;
			else if(sort.equals("2"))
				sCol = " a.gxdwmc " + desc +"," + sCol;
			else if(sort.equals("3"))
				sCol = " a.jjlxmc " + desc +"," + sCol;
			else if(sort.equals("4"))
				sCol = " a.zrs " + desc +"," + sCol;
			else if(sort.equals("5"))
				sCol = " a.lxdh " + desc +"," + sCol;
			else if(sort.equals("6"))
				sCol = " a.zt " + desc +"," + sCol;
		}
		map.put("pageSort", sCol);
		return queryForPage("getStxzTzxxQyzsList", map, pageNo,pageSize);
	}
	
	/** @param 未上传企业信息(未上传企业总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	public Page getListWscQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol = " a.qyid	 desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.qybm " + desc +"," + sCol;
			else if(sort.equals("1"))
				sCol = " a.qymc " + desc +"," + sCol;
			else if(sort.equals("2"))
				sCol = " a.gxdwmc " + desc +"," + sCol;
			else if(sort.equals("3"))
				sCol = " a.jjlxmc " + desc +"," + sCol;
			else if(sort.equals("4"))
				sCol = " a.zrs " + desc +"," + sCol;
			else if(sort.equals("5"))
				sCol = " a.lxdh " + desc +"," + sCol;
			else if(sort.equals("6"))
				sCol = " a.zt " + desc +"," + sCol;
		}
		map.put("pageSort", sCol);
		return queryForPage("getStxzTzxxWscQyzsList", map, pageNo,pageSize);
	}
	
	/** @param 上传企业信息(上传机修信息总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	public Page getListScQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol = " a.qyid	 desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.qybm " + desc +"," + sCol;
			else if(sort.equals("1"))
				sCol = " a.qymc " + desc +"," + sCol;
			else if(sort.equals("2"))
				sCol = " a.gxdwmc " + desc +"," + sCol;
			else if(sort.equals("3"))
				sCol = " a.jjlxmc " + desc +"," + sCol;
			else if(sort.equals("4"))
				sCol = " a.zrs " + desc +"," + sCol;
			else if(sort.equals("5"))
				sCol = " a.lxdh " + desc +"," + sCol;
			else if(sort.equals("6"))
				sCol = " a.zt " + desc +"," + sCol;
		}
		map.put("pageSort", sCol);
		return queryForPage("getStxzTzxxScQyzsList", map, pageNo,pageSize);
	}
}
