package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQysctjDao;
import com.aisino2.publicsystem.domain.Qysctj;

public class QysctjDaoImpl extends BaseDao implements IQysctjDao {
	/** @param 企业上传统计表(t_qysctj) 增加 */
	public Qysctj insertQysctj(Qysctj qysctj){
		// TODO: implement
		qysctj.setQysctjid(getNextID("Qysctjid"));
		return (Qysctj)insert("insertQysctj", qysctj);
	}

	/** @param 企业上传统计表(t_qysctj) 删除 */
	public int deleteQysctj(Qysctj qysctj){
		// TODO: implement
		return delete("deleteQysctj", qysctj);
	}

	/** @param 企业上传统计表(t_qysctj) 修改 */
	public int updateQysctj(Qysctj qysctj){
		// TODO: implement
		return update("updateQysctj", qysctj);
	}

	/** @param 企业上传统计表(t_qysctj) 查询单条 */
	public Qysctj getQysctj(Qysctj qysctj){
		// TODO: implement
		return (Qysctj)queryForObject("getQysctj", qysctj);
	}

	/** @param 企业上传统计表(t_qysctj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qysctjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQysctjList", map, pageNo,pageSize);
	}

	/** @param 企业上传统计表(t_qysctj) 多条查询 */
	public List getListQysctj(Qysctj qysctj){
		// TODO: implement
		return queryForList("getQysctjListNoPage", qysctj);
	}

	public Page getSktjListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		if(sort == null)
			sort = " dsjgdm";
		if(desc == null)
			desc = " desc";
		
		map.put("pageSort", sort +" " + desc);
		return queryForPage("getSktjList", map, pageNo,pageSize);
	}
	
	public Page getSktjxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		if(sort == null)
			sort = " dsjgdm";
		if(desc == null)
			desc = " desc";
		
		map.put("pageSort", sort +" " + desc);
		return queryForPage("getSktjxxList", map, pageNo,pageSize);
	}

	public Page getZtxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return queryForPage("getZttjxxList", map, pageNo,pageSize);
	}
	//一次/多次刷卡人员信息
	public Page getYcskxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		return queryForPage("getYcskxxList", map, pageNo,pageSize);
	}
}
