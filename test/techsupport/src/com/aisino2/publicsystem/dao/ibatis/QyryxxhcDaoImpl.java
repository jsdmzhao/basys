package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyryxxhcDao;
import com.aisino2.publicsystem.domain.Qyryxxhc;

public class QyryxxhcDaoImpl extends BaseDao implements IQyryxxhcDao {
	/** @param 企业人员信息核查(t_qyryxxhc) 增加 */
	public Qyryxxhc insertQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		qyryxxhc.setHcid(getNextID("Gghcid"));
		insert("insertQyryxxhc", qyryxxhc);
		return qyryxxhc;
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 删除 */
	public int deleteQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return delete("deleteQyryxxhc", qyryxxhc);
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 修改 */
	public int updateQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return update("updateQyryxxhc", qyryxxhc);
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 查询单条 */
	public Qyryxxhc getQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return (Qyryxxhc)queryForObject("getQyryxxhc", qyryxxhc);
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getQyryxxhcList", map, pageNo, pageSize);
		}
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("4"))
				sCol = " a.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.hcwt "+ desc;
			else if(sort.equals("6"))
				sCol = " a.bdsj "+ desc;
			else if(sort.equals("7"))
				sCol = " a.hczt "+ desc;
			else
				sCol = " a.bdsj desc ";
		}else{
			sCol="a.bdsj desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxhcList", map, pageNo,pageSize);

	}

	/** @param 企业人员信息核查(t_qyryxxhc) 多条查询 */
	public List getListQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return queryForList("getQyryxxhcListNoPage", qyryxxhc);
	}
	
	/** @param 企业人员信息核查(t_qyryxxhc) 未核查总数查询 */
	public int getDhcryCount(Map map){
		return ((Integer)queryForObject("getQyryxxhcListCount",map)).intValue();
	}
}
