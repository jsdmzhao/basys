package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyryshDao;
import com.aisino2.publicsystem.domain.Qyrysh;


public class QyryshDaoImpl extends BaseDao implements IQyryshDao {
	/** @param 企业人员审核(t_qyrysh) 增加 */
	public Qyrysh insertQyrysh(Qyrysh qyrysh){
		// TODO: implement
		qyrysh.setRyshid(getNextID("Ryshid"));
		return (Qyrysh)insert("insertQyrysh", qyrysh);
	}

	/** @param 企业人员审核(t_qyrysh) 删除 */
	public int deleteQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return delete("deleteQyrysh", qyrysh);
	}

	/** @param 企业人员审核(t_qyrysh) 修改 */
	public int updateQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return update("updateQyrysh", qyrysh);
	}

	/** @param 企业人员审核(t_qyrysh) 查询单条 */
	public Qyrysh getQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return (Qyrysh)queryForObject("getQyrysh", qyrysh);
	}

	/** @param 企业人员审核(t_qyrysh) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Ryshid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryshList", map, pageNo,pageSize);
	}

	/** @param 企业人员审核(t_qyrysh) 多条查询 */
	public List getListQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return queryForList("getQyryshListNoPage", qyrysh);
	}

	public Qyrysh getSjshid(Qyrysh qyrysh) {
		// TODO Auto-generated method stub
		return (Qyrysh)queryForObject("getSjshid_Qyrysh", qyrysh);
	}

	public int updateQyryshByqybg(Qyrysh qyrysh) {
		// TODO Auto-generated method stub
		return update("updateQyryshByqybg", qyrysh);
	}
}
