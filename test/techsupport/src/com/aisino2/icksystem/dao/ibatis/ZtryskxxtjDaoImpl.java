package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IZtryskxxtjDao;
import com.aisino2.icksystem.domain.Ztryskxxtj;

public class ZtryskxxtjDaoImpl extends BaseDao implements IZtryskxxtjDao {
	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 增加 */
	public Ztryskxxtj insertZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		ztryskxxtj.setZtryskxxtjmxid(getNextID("Ztryskxxtjmxid"));
		return (Ztryskxxtj)insert("insertZtryskxxtj", ztryskxxtj);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 删除 */
	public int deleteZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return delete("deleteZtryskxxtj", ztryskxxtj);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 修改 */
	public int updateZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return update("updateZtryskxxtj", ztryskxxtj);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 查询单条 */
	public Ztryskxxtj getZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return (Ztryskxxtj)queryForObject("getZtryskxxtj", ztryskxxtj);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Ztryskxxtjmxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZtryskxxtjList", map, pageNo,pageSize);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 多条查询 */
	public List getListZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return queryForList("getZtryskxxtjListNoPage", ztryskxxtj);
	}
}
