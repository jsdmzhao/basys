package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IXctb_fjDao;
import com.aisino2.basicsystem.domain.Xctb_fj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;



public class Xctb_fjDaoImpl extends BaseDao implements IXctb_fjDao {
	/** @param 协查通报_附件(t_xctb_fj) 增加 */
	public Xctb_fj insertXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		xctb_fj.setFjid(getNextID("Xctbfjid"));
		return (Xctb_fj)insert("insertXctb_fj", xctb_fj);
	}

	/** @param 协查通报_附件(t_xctb_fj) 删除 */
	public int deleteXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return delete("deleteXctb_fj", xctb_fj);
	}

	/** @param 协查通报_附件(t_xctb_fj) 修改 */
	public int updateXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return update("updateXctb_fj", xctb_fj);
	}

	/** @param 协查通报_附件(t_xctb_fj) 查询单条 */
	public Xctb_fj getXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return (Xctb_fj)queryForObject("getXctb_fj", xctb_fj);
	}

	/** @param 协查通报_附件(t_xctb_fj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.fjmc "+ desc;
			else if (sort.equals("1"))
				sCol = " a.fjlx "+ desc;
			else 
				sCol="a.fjid desc";
		}else{
			sCol="a.fjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getXctb_fjList", map, pageNo,pageSize);
	}

	/** @param 协查通报_附件(t_xctb_fj) 多条查询 */
	public List getListXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return queryForList("getXctb_fjListNoPage", xctb_fj);
	}
}
