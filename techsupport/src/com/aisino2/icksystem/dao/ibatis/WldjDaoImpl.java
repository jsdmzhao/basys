package com.aisino2.icksystem.dao.ibatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.common.DateToString;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IWldjDao;
import com.aisino2.icksystem.domain.Wldj;

public class WldjDaoImpl extends BaseDao implements IWldjDao {
	/** @param 物流登记信息(t_wldj) 增加 */
	public Wldj insertWldj(Wldj wldj){
		// TODO: implement
		wldj.setWlid(getNextID("Wlid"));
		insert("insertWldj", wldj);
		return wldj;
	}

	/** @param 物流登记信息(t_wldj) 删除 */
	public int deleteWldj(Wldj wldj){
		// TODO: implement
		return delete("deleteWldj", wldj);
	}

	/** @param 物流登记信息(t_wldj) 修改 */
	public int updateWldj(Wldj wldj){
		// TODO: implement
		return update("updateWldj", wldj);
	}

	/** @param 物流登记信息(t_wldj) 查询单条 */
	public Wldj getWldj(Wldj wldj){
		// TODO: implement
		return (Wldj)queryForObject("getWldj", wldj);
	}

	/** @param 物流登记信息(t_wldj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		if(map.get("superbOrderBy")!=null&&!("".equals(map.get("superbOrderBy"))))
		{
			map.put("pageSort", map.get("superbOrderBy"));
		}
		else
		{
			String sCol = "";
			if(desc == null)
				desc = "";
			else if(!desc.equals("asc") && !desc.equals("desc"))
				desc = " asc ";
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.wlpc "+ desc;
				else if(sort.equals("1"))
					sCol = " a.djr "+ desc;
				else if(sort.equals("2"))
					sCol = " a.zbsj "+ desc;
				else if(sort.equals("3"))
					sCol = " a.fssj "+ desc;
				else if(sort.equals("4"))
					sCol = " a.bnksl "+ desc;
				else if(sort.equals("5"))
					sCol = " a.ztdm "+ desc;
				else if(sort.equals("6"))
					sCol = " a.jsr "+ desc;
				else if(sort.equals("7"))
					sCol = " a.jssj "+ desc;
				else
					sCol = " a.fssj desc ";
			}else{
				sCol="a.fssj desc";
			}
			map.put("pageSort", sCol);
		}
		return queryForPage("getWldjList", map, pageNo,pageSize);
	}
	
	/** @param 物流登记信息(t_wldj) 分页查询  制卡端*/
	public Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.wlpc "+ desc;
			else if(sort.equals("1"))
				sCol = " a.djr "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zbsj "+ desc;
			else if(sort.equals("3"))
				sCol = " a.fssj "+ desc;
			else if(sort.equals("4"))
				sCol = " a.bnksl "+ desc;
			else if(sort.equals("5"))
				sCol = " a.mbsldmc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.ztdm "+ desc;
			else if(sort.equals("7"))
				sCol = " a.jsr "+ desc;
			else if(sort.equals("8"))
				sCol = " a.jssj "+ desc;
			else
				sCol = " a.zbsj desc ";
		}else{
			sCol="a.zbsj desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWldjList", map, pageNo,pageSize);
	}
	
	/** @param 物流登记信息(t_wldj) 分页查询  制卡端台账*/
	public Page getListZkdTzForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol = "";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.wlpc "+ desc;
			else if(sort.equals("1"))
				sCol = " a.fssj "+ desc;
			else if(sort.equals("2"))
				sCol = " a.bnksl "+ desc;
			else if(sort.equals("3"))
				sCol = " a.mbsldmc "+ desc;
			else if(sort.equals("4"))
				sCol = " a.ztdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.jssj "+ desc;
			else
				sCol = " a.wlpc desc ";
		}else{
			sCol="a.wlpc desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWldjTzList", map, pageNo,pageSize);
	}

	/** @param 物流登记信息(t_wldj) 多条查询 */
	public List getListWldj(Wldj wldj){
		// TODO: implement
		return queryForList("getWldjListNoPage", wldj);
	}
	
	/**制证中心上传物流登记*/
	public Wldj insertWldjWs(Wldj wldj) {
		// TODO: implement
		wldj.setWlid(getNextID("Wlid"));
		String sPch=(String)DateToString.getDateTimeNoFormat20(new Date());
		wldj.setWlpc(sPch);
	    insert("insertWldj", wldj);
		return wldj;
	}
}
