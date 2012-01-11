package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyyyzttjDao;
import com.aisino2.publicsystem.domain.Qyyyzttj;
import com.aisino2.publicsystem.service.IQyyyzttjService;

public class QyyyzttjServiceImpl extends BaseService implements IQyyyzttjService {

	private IQyyyzttjDao qyyyzttjDao;

	/** @param 企业营业状态统计(t_qyyyzttj) 增加 */
	public Qyyyzttj insertQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return (Qyyyzttj)qyyyzttjDao.insertQyyyzttj(qyyyzttj);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 删除 */
	public boolean deleteQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return qyyyzttjDao.deleteQyyyzttj(qyyyzttj)>0;
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 修改 */
	public boolean updateQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return qyyyzttjDao.updateQyyyzttj(qyyyzttj)>0;
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 查询单条 */
	public Qyyyzttj getQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return (Qyyyzttj)qyyyzttjDao.getQyyyzttj(qyyyzttj);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
		return qyyyzttjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业营业状态统计(t_qyyyzttj) 多条查询 */
	public List getListQyyyzttj(Qyyyzttj qyyyzttj){
		// TODO: implement
		return qyyyzttjDao.getListQyyyzttj(qyyyzttj);
	}

	public IQyyyzttjDao getQyyyzttjDao() {
		return qyyyzttjDao;
	}

	public void setQyyyzttjDao(IQyyyzttjDao qyyyzttjDao) {
		this.qyyyzttjDao = qyyyzttjDao;
	}
	private void getConditions(Map map) {
		boolean dsjgbz = ((String)map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String)map.get("fxjbz")).equalsIgnoreCase("1"); 
		boolean gxdwbz = ((String)map.get("gxdwbz")).equalsIgnoreCase("1");
		String groupBy = "";
		String selectConditon = "";
		if(gxdwbz)
		{
		
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc,gxdwdm,gxdwmc";
			selectConditon = groupBy;
		}else if(fxjbz)
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc";
		}else if(dsjgbz)
		{
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
		}else
		{
			groupBy = "";
			selectConditon = "'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}
}
