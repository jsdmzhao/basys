package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyscbcfDao;
import com.aisino2.publicsystem.domain.Qyscbcf;

public class QyscbcfDaoImpl extends BaseDao implements IQyscbcfDao {
	/** @param 企业上传不充分(t_qyscbcf) 增加 */
	public Qyscbcf insertQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		qyscbcf.setQyscbcfid(getNextID("Qyscbcfid"));
		return (Qyscbcf)insert("insertQyscbcf", qyscbcf);
	}

	/** @param 企业上传不充分(t_qyscbcf) 删除 */
	public int deleteQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return delete("deleteQyscbcf", qyscbcf);
	}

	/** @param 企业上传不充分(t_qyscbcf) 修改 */
	public int updateQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return update("updateQyscbcf", qyscbcf);
	}

	/** @param 企业上传不充分(t_qyscbcf) 查询单条 */
	public Qyscbcf getQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return (Qyscbcf)queryForObject("getQyscbcf", qyscbcf);
	}

	/** @param 企业上传不充分(t_qyscbcf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if("0".equals(map.get("dsjgbz"))&&"0".equals(map.get("fxjbz"))&&"0".equals(map.get("gxdwbz")))
			{sort=String.valueOf(Integer.parseInt(sort)+1);}
			if(sort.equals("3"))
				sCol = " wdbts "+ desc;
			else if(sort.equals("4"))
				sCol = " yljts "+ desc;
			else if(sort.equals("5"))
				sCol = " nljts "+ desc;
			else
				sCol = " a.gxdwdm asc  ";
			
		}else{
			sCol="a.gxdwdm asc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyscbcfList", map, pageNo,pageSize);
	}

	/** @param 企业上传不充分(t_qyscbcf) 多条查询 */
	public List getListQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return queryForList("getQyscbcfListNoPage", qyscbcf);
	}

	public Page getXxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyscbcfid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyscbcfXxList", map, pageNo,pageSize);
	}
}
