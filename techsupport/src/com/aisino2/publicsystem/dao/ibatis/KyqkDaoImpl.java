package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IKyqkDao;
import com.aisino2.publicsystem.domain.Kyqk;

public class KyqkDaoImpl extends BaseDao implements IKyqkDao {
	/** @param 可疑情况(t_kyqk) 增加 */
	public Kyqk insertKyqk(Kyqk kyqk){
		// TODO: implement
		kyqk.setKyqkid(getNextID("kyqkid"));
		return (Kyqk)insert("insertKyqk", kyqk);
	}

	/** @param 可疑情况(t_kyqk) 删除 */
	public int deleteKyqk(Kyqk kyqk){
		// TODO: implement
		return delete("deleteKyqk", kyqk);
	}

	/** @param 可疑情况(t_kyqk) 修改 */
	public int updateKyqk(Kyqk kyqk){
		// TODO: implement
		return update("updateKyqk", kyqk);
	}

	/** @param 可疑情况(t_kyqk) 查询单条 */
	public Kyqk getKyqk(Kyqk kyqk){
		// TODO: implement
		return (Kyqk)queryForObject("getKyqk", kyqk);
	}

	/** @param 可疑情况(t_kyqk) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.kyqkdjxh "+ desc;
			else if (sort.equals("1"))
				sCol = " a.kyqklx "+ desc;
			else if (sort.equals("2"))
				sCol = " a.tbrxm "+ desc;
			else if (sort.equals("3"))
				sCol = " a.tbsj "+ desc;
			else 
				sCol="a.kyqkid desc";
		}else{
			sCol="a.kyqkid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getKyqkList", map, pageNo,pageSize);
	}
	/** @param 可疑情况(t_kyqk) 公安端分页查询 */
	public Page getListForPageGAD(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " t.qymc "+ desc;
			else if(sort.equals("1"))
				sCol = " a.kyqkdjxh "+ desc;
			else if (sort.equals("2"))
				sCol = " a.kyqklx "+ desc;
			else if (sort.equals("3"))
				sCol = " a.tbrxm "+ desc;
			else if (sort.equals("4"))
				sCol = " a.tbsj "+ desc;
			else 
				sCol="a.kyqkid desc";
		}else{
			sCol="a.kyqkid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getKyqkList", map, pageNo,pageSize);
	}

	/** @param 可疑情况(t_kyqk) 多条查询 */
	public List getListKyqk(Kyqk kyqk){
		// TODO: implement
		return queryForList("getKyqkListNoPage", kyqk);
	}
	/** @param 待处理可疑情况(t_kyqk) 总数查询 */
	public int getKyqkCount(Map map){
		return ((Integer)queryForObject("getDCLKyqkListCount",map)).intValue();
	}
}
